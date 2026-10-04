package androidx.media3.extractor.mp4;

import android.util.Pair;
import androidx.collection.SieveCacheKt;
import androidx.core.view.ViewCompat;
import androidx.media3.common.C2181C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.DolbyVisionConfig;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4AlternateGroupData;
import androidx.media3.container.Mp4Box;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.container.OpusUtil;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.AvcConfig;
import androidx.media3.extractor.ExtractorUtil;
import androidx.media3.extractor.GaplessInfoHolder;
import androidx.media3.extractor.HevcConfig;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.VvcConfig;
import androidx.media3.extractor.mp4.FixedSampleSizeRechunker;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.work.WorkInfo;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import com.survicate.surveys.TextRecallingManager;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class BoxParser {
    private static final int EDIT_LIST_DURATION_TOLERANCE_TIMESCALE_UNITS = 2;
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final int SAMPLE_RATE_AMR_NB = 8000;
    private static final int SAMPLE_RATE_AMR_WB = 16000;
    private static final String TAG = "BoxParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subp = 1937072752;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp || i == TYPE_subp) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static int parseFullBoxFlags(int i) {
        return i & ViewCompat.MEASURED_SIZE_MASK;
    }

    public static int parseFullBoxVersion(int i) {
        return (i >> 24) & 255;
    }

    public static List<TrackSampleTable> parseTraks(Mp4Box.ContainerBox containerBox, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function, boolean z3) throws ParserException {
        Track trackApply;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerBox.containerChildren.size(); i++) {
            Mp4Box.ContainerBox containerBox2 = containerBox.containerChildren.get(i);
            if (containerBox2.type == 1953653099 && (trackApply = function.apply(parseTrak(containerBox2, (Mp4Box.LeafBox) Preconditions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_mvhd)), j, drmInitData, z, z2))) != null) {
                arrayList.add(parseStbl(trackApply, (Mp4Box.ContainerBox) Preconditions.checkNotNull(((Mp4Box.ContainerBox) Preconditions.checkNotNull(((Mp4Box.ContainerBox) Preconditions.checkNotNull(containerBox2.getContainerBoxOfType(Mp4Box.TYPE_mdia))).getContainerBoxOfType(Mp4Box.TYPE_minf))).getContainerBoxOfType(Mp4Box.TYPE_stbl)), gaplessInfoHolder, z3));
            }
        }
        return arrayList;
    }

    public static Metadata parseUdta(Mp4Box.LeafBox leafBox) {
        ParsableByteArray parsableByteArray = leafBox.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int i = parsableByteArray.readInt();
            int i2 = parsableByteArray.readInt();
            if (i2 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(parseUdtaMeta(parsableByteArray, position + i));
            } else if (i2 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata = metadata.copyWithAppendedEntriesFrom(SmtaAtomUtil.parseSmta(parsableByteArray, position + i));
            } else if (i2 == -1451722374) {
                metadata = metadata.copyWithAppendedEntriesFrom(parseXyz(parsableByteArray));
            }
            parsableByteArray.setPosition(position + i);
        }
        return metadata;
    }

    public static Mp4TimestampData parseMvhd(ParsableByteArray parsableByteArray) {
        long unsignedInt;
        long unsignedInt2;
        parsableByteArray.setPosition(8);
        if (parseFullBoxVersion(parsableByteArray.readInt()) == 0) {
            unsignedInt = parsableByteArray.readUnsignedInt();
            unsignedInt2 = parsableByteArray.readUnsignedInt();
        } else {
            unsignedInt = parsableByteArray.readLong();
            unsignedInt2 = parsableByteArray.readLong();
        }
        return new Mp4TimestampData(unsignedInt, unsignedInt2, parsableByteArray.readUnsignedInt());
    }

    public static Metadata parseMdtaFromMeta(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(Mp4Box.TYPE_hdlr);
        Mp4Box.LeafBox leafBoxOfType2 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_keys);
        Mp4Box.LeafBox leafBoxOfType3 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_ilst);
        if (leafBoxOfType == null || leafBoxOfType2 == null || leafBoxOfType3 == null || parseHdlr(leafBoxOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType2.data;
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i2] = parsableByteArray.readString(i3 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafBoxOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int i4 = parsableByteArray2.readInt();
            int i5 = parsableByteArray2.readInt() - 1;
            if (i5 >= 0 && i5 < i) {
                MdtaMetadataEntry mdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + i4, strArr[i5]);
                if (mdtaMetadataEntryFromIlst != null) {
                    arrayList.add(mdtaMetadataEntryFromIlst);
                }
            } else {
                Log.m132w(TAG, "Skipped metadata with unknown key index: " + i5);
            }
            parsableByteArray2.setPosition(position + i4);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void maybeSkipRemainingMetaBoxHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    public static Track parseTrak(Mp4Box.ContainerBox containerBox, Mp4Box.LeafBox leafBox, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long[] jArr;
        long[] jArr2;
        Format formatBuild;
        Metadata metadata;
        Mp4Box.ContainerBox containerBoxOfType;
        Pair<long[], long[]> edts;
        Mp4Box.ContainerBox containerBox2 = (Mp4Box.ContainerBox) Preconditions.checkNotNull(containerBox.getContainerBoxOfType(Mp4Box.TYPE_mdia));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Mp4Box.LeafBox) Preconditions.checkNotNull(containerBox2.getLeafBoxOfType(Mp4Box.TYPE_hdlr))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData tkhd = parseTkhd(((Mp4Box.LeafBox) Preconditions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_tkhd))).data);
        long jScaleLargeTimestamp = C2181C.TIME_UNSET;
        long j2 = j == C2181C.TIME_UNSET ? tkhd.duration : j;
        long j3 = parseMvhd(leafBox.data).timescale;
        if (j2 != C2181C.TIME_UNSET) {
            jScaleLargeTimestamp = Util.scaleLargeTimestamp(j2, 1000000L, j3);
        }
        long j4 = jScaleLargeTimestamp;
        Mp4Box.ContainerBox containerBox3 = (Mp4Box.ContainerBox) Preconditions.checkNotNull(((Mp4Box.ContainerBox) Preconditions.checkNotNull(containerBox2.getContainerBoxOfType(Mp4Box.TYPE_minf))).getContainerBoxOfType(Mp4Box.TYPE_stbl));
        MdhdData mdhd = parseMdhd(((Mp4Box.LeafBox) Preconditions.checkNotNull(containerBox2.getLeafBoxOfType(Mp4Box.TYPE_mdhd))).data);
        Mp4Box.LeafBox leafBoxOfType = containerBox3.getLeafBoxOfType(Mp4Box.TYPE_stsd);
        if (leafBoxOfType == null) {
            Log.m132w(TAG, "Ignoring track where sample table (stbl) box is missing a sample description (stsd).");
            return null;
        }
        StsdData stsd = parseStsd(leafBoxOfType.data, tkhd, mdhd.language, drmInitData, z2);
        if (z || (containerBoxOfType = containerBox.getContainerBoxOfType(Mp4Box.TYPE_edts)) == null || (edts = parseEdts(containerBoxOfType)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) edts.first;
            jArr2 = (long[]) edts.second;
            jArr = jArr3;
        }
        if (stsd.format == null) {
            return null;
        }
        if (tkhd.alternateGroup != 0) {
            Mp4AlternateGroupData mp4AlternateGroupData = new Mp4AlternateGroupData(tkhd.alternateGroup);
            Format.Builder builderBuildUpon = stsd.format.buildUpon();
            if (stsd.format.metadata != null) {
                metadata = stsd.format.metadata.copyWithAppendedEntries(mp4AlternateGroupData);
            } else {
                metadata = new Metadata(mp4AlternateGroupData);
            }
            formatBuild = builderBuildUpon.setMetadata(metadata).build();
        } else {
            formatBuild = stsd.format;
        }
        return new Track(tkhd.f362id, trackTypeForHdlr, mdhd.timescale, j3, j4, mdhd.mediaDurationUs, formatBuild, stsd.requiredSampleTransformation, stsd.trackEncryptionBoxes, stsd.nalUnitLengthFieldLength, jArr, jArr2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:137:0x02a1, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018c  */
    /* JADX WARN: Type inference failed for: r26v2 */
    /* JADX WARN: Type inference failed for: r26v3 */
    /* JADX WARN: Type inference failed for: r26v4 */
    /* JADX WARN: Type inference failed for: r26v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r26v8 */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r29v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TrackSampleTable parseStbl(Track track, Mp4Box.ContainerBox containerBox, GaplessInfoHolder gaplessInfoHolder, boolean z) throws ParserException {
        SampleSizeBox stz2SampleSizeBox;
        boolean z2;
        int unsignedIntToInt;
        int unsignedIntToInt2;
        int unsignedIntToInt3;
        int i;
        int i2;
        long[] jArr;
        int[] iArrCopyOf;
        ArrayList arrayList;
        int[] iArr;
        int i3;
        int length;
        long[] jArr2;
        long j;
        int i4;
        int[] iArr2;
        long j2;
        int i5;
        ArrayList arrayList2;
        long j3;
        long[] jArr3;
        int i6;
        int i7;
        int i8;
        int i9;
        long jScaleLargeTimestamp;
        Track trackCopyWithFormat = track;
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(Mp4Box.TYPE_stsz);
        if (leafBoxOfType != null) {
            stz2SampleSizeBox = new StszSampleSizeBox(leafBoxOfType, trackCopyWithFormat.format);
        } else {
            Mp4Box.LeafBox leafBoxOfType2 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_stz2);
            if (leafBoxOfType2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            stz2SampleSizeBox = new Stz2SampleSizeBox(leafBoxOfType2);
        }
        int sampleCount = stz2SampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(trackCopyWithFormat, new long[0], new int[0], 0, new long[0], new int[0], new int[0], false, 0L, 0);
        }
        if (trackCopyWithFormat.type == 2 && trackCopyWithFormat.mediaDurationUs > 0) {
            trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(trackCopyWithFormat.format.buildUpon().setFrameRate(sampleCount / (trackCopyWithFormat.mediaDurationUs / 1000000.0f)).build());
        }
        Mp4Box.LeafBox leafBoxOfType3 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_stco);
        if (leafBoxOfType3 == null) {
            leafBoxOfType3 = (Mp4Box.LeafBox) Preconditions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_co64));
            z2 = true;
        } else {
            z2 = false;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType3.data;
        ParsableByteArray parsableByteArray2 = ((Mp4Box.LeafBox) Preconditions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_stsc))).data;
        ParsableByteArray parsableByteArray3 = ((Mp4Box.LeafBox) Preconditions.checkNotNull(containerBox.getLeafBoxOfType(Mp4Box.TYPE_stts))).data;
        Mp4Box.LeafBox leafBoxOfType4 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_stss);
        ParsableByteArray parsableByteArray4 = leafBoxOfType4 != null ? leafBoxOfType4.data : null;
        Mp4Box.LeafBox leafBoxOfType5 = containerBox.getLeafBoxOfType(Mp4Box.TYPE_ctts);
        ParsableByteArray parsableByteArray5 = leafBoxOfType5 != null ? leafBoxOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z2);
        parsableByteArray3.setPosition(12);
        int unsignedIntToInt4 = parsableByteArray3.readUnsignedIntToInt() - 1;
        int unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt();
        int unsignedIntToInt6 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            unsignedIntToInt = parsableByteArray5.readUnsignedIntToInt();
        } else {
            unsignedIntToInt = 0;
        }
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            unsignedIntToInt2 = parsableByteArray4.readUnsignedIntToInt();
            if (unsignedIntToInt2 <= 0) {
                unsignedIntToInt3 = -1;
                i = 1;
                parsableByteArray4 = null;
                int fixedSampleSize = stz2SampleSizeBox.getFixedSampleSize();
                String str = trackCopyWithFormat.format.sampleMimeType;
                i2 = (fixedSampleSize == -1 && (MimeTypes.AUDIO_RAW.equals(str) || MimeTypes.AUDIO_MLAW.equals(str) || MimeTypes.AUDIO_ALAW.equals(str)) && unsignedIntToInt4 == 0 && unsignedIntToInt == 0 && unsignedIntToInt2 == 0) ? i : 0;
                ArrayList arrayList3 = new ArrayList();
                ?? r29 = parsableByteArray4 != null ? i : 0;
                if (i2 == 0) {
                    long[] jArr4 = new long[chunkIterator.length];
                    int[] iArr3 = new int[chunkIterator.length];
                    while (chunkIterator.moveNext()) {
                        jArr4[chunkIterator.index] = chunkIterator.offset;
                        iArr3[chunkIterator.index] = chunkIterator.numSamples;
                    }
                    FixedSampleSizeRechunker.Results resultsRechunk = FixedSampleSizeRechunker.rechunk(fixedSampleSize, jArr4, iArr3, unsignedIntToInt6);
                    long[] jArr5 = z ? new long[0] : resultsRechunk.offsets;
                    int[] iArr4 = z ? new int[0] : resultsRechunk.sizes;
                    jArr = z ? new long[0] : resultsRechunk.timestamps;
                    iArrCopyOf = z ? new int[0] : resultsRechunk.flags;
                    int i10 = resultsRechunk.maximumSize;
                    long j4 = resultsRechunk.duration;
                    j = resultsRechunk.totalSize;
                    length = resultsRechunk.offsets.length;
                    jArr2 = jArr5;
                    iArr2 = iArr4;
                    arrayList = arrayList3;
                    i4 = i10;
                    j2 = j4;
                } else {
                    long[] jArr6 = z ? new long[0] : new long[sampleCount];
                    ParsableByteArray parsableByteArray6 = parsableByteArray5;
                    int[] iArrCopyOf2 = z ? new int[0] : new int[sampleCount];
                    SampleSizeBox sampleSizeBox = stz2SampleSizeBox;
                    jArr = z ? new long[0] : new long[sampleCount];
                    int i11 = unsignedIntToInt2;
                    iArrCopyOf = z ? new int[0] : new int[sampleCount];
                    int i12 = unsignedIntToInt3;
                    int i13 = unsignedIntToInt;
                    int unsignedIntToInt7 = i12;
                    int i14 = unsignedIntToInt4;
                    ParsableByteArray parsableByteArray7 = parsableByteArray4;
                    long j5 = 0;
                    long j6 = 0;
                    int i15 = i11;
                    int i16 = 0;
                    int i17 = 0;
                    int i18 = 0;
                    int i19 = 0;
                    int unsignedIntToInt8 = 0;
                    long j7 = 0;
                    while (true) {
                        if (i17 >= sampleCount) {
                            arrayList = arrayList3;
                            break;
                        }
                        long j8 = j6;
                        ?? MoveNext = i;
                        while (i19 == 0) {
                            MoveNext = chunkIterator.moveNext();
                            if (MoveNext == 0) {
                                break;
                            }
                            ArrayList arrayList4 = arrayList3;
                            long j9 = chunkIterator.offset;
                            i19 = chunkIterator.numSamples;
                            j8 = j9;
                            arrayList3 = arrayList4;
                            unsignedIntToInt6 = unsignedIntToInt6;
                            sampleCount = sampleCount;
                            MoveNext = MoveNext;
                        }
                        int i20 = sampleCount;
                        arrayList = arrayList3;
                        int i21 = unsignedIntToInt6;
                        if (MoveNext == 0) {
                            Log.m132w(TAG, "Unexpected end of chunk data");
                            if (z) {
                                iArr = iArrCopyOf2;
                                sampleCount = i17;
                            } else {
                                long[] jArrCopyOf = Arrays.copyOf(jArr6, i17);
                                iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i17);
                                long[] jArrCopyOf2 = Arrays.copyOf(jArr, i17);
                                jArr6 = jArrCopyOf;
                                iArrCopyOf = Arrays.copyOf(iArrCopyOf, i17);
                                sampleCount = i17;
                                jArr = jArrCopyOf2;
                            }
                        } else {
                            if (parsableByteArray6 != null) {
                                while (unsignedIntToInt8 == 0 && i13 > 0) {
                                    unsignedIntToInt8 = parsableByteArray6.readUnsignedIntToInt();
                                    i18 = parsableByteArray6.readInt();
                                    i13--;
                                }
                                unsignedIntToInt8--;
                            }
                            int nextSampleSize = sampleSizeBox.readNextSampleSize();
                            long j10 = nextSampleSize;
                            j5 += j10;
                            if (nextSampleSize > i16) {
                                i16 = nextSampleSize;
                            }
                            if (z) {
                                i5 = i16;
                            } else {
                                jArr6[i17] = j8;
                                iArrCopyOf2[i17] = nextSampleSize;
                                i5 = i16;
                                jArr[i17] = j7 + ((long) i18);
                                iArrCopyOf[i17] = parsableByteArray7 == null ? i : 0;
                                if (i17 == unsignedIntToInt7) {
                                    iArrCopyOf[i17] = i;
                                    arrayList2 = arrayList;
                                    arrayList2.add(Integer.valueOf(i17));
                                }
                                if (parsableByteArray7 != null && i17 == unsignedIntToInt7 && i15 - 1 > 0) {
                                    unsignedIntToInt7 = ((ParsableByteArray) Preconditions.checkNotNull(parsableByteArray7)).readUnsignedIntToInt() - 1;
                                }
                                ArrayList arrayList5 = arrayList2;
                                ChunkIterator chunkIterator2 = chunkIterator;
                                int i22 = i21;
                                j7 += (long) i22;
                                unsignedIntToInt5--;
                                if (unsignedIntToInt5 != 0 && i14 > 0) {
                                    i14--;
                                    unsignedIntToInt5 = parsableByteArray3.readUnsignedIntToInt();
                                    i22 = parsableByteArray3.readInt();
                                }
                                long j11 = j8 + j10;
                                i19--;
                                i17++;
                                unsignedIntToInt6 = i22;
                                i16 = i5;
                                arrayList3 = arrayList5;
                                chunkIterator = chunkIterator2;
                                j6 = j11;
                                sampleCount = i20;
                            }
                            arrayList2 = arrayList;
                            if (parsableByteArray7 != null) {
                                unsignedIntToInt7 = ((ParsableByteArray) Preconditions.checkNotNull(parsableByteArray7)).readUnsignedIntToInt() - 1;
                            }
                            ArrayList arrayList52 = arrayList2;
                            ChunkIterator chunkIterator22 = chunkIterator;
                            int i222 = i21;
                            j7 += (long) i222;
                            unsignedIntToInt5--;
                            if (unsignedIntToInt5 != 0) {
                            }
                            long j112 = j8 + j10;
                            i19--;
                            i17++;
                            unsignedIntToInt6 = i222;
                            i16 = i5;
                            arrayList3 = arrayList52;
                            chunkIterator = chunkIterator22;
                            j6 = j112;
                            sampleCount = i20;
                        }
                    }
                    int i23 = i19;
                    long j12 = j7 + ((long) i18);
                    if (parsableByteArray6 != null) {
                        for (int i24 = i13; i24 > 0; i24--) {
                            if (parsableByteArray6.readUnsignedIntToInt() != 0) {
                                i3 = 0;
                                break;
                            }
                            parsableByteArray6.readInt();
                        }
                        i3 = i;
                        if (i15 == 0 || unsignedIntToInt5 != 0 || i23 != 0 || i14 != 0 || unsignedIntToInt8 != 0 || i3 == 0) {
                            Log.m132w(TAG, "Inconsistent stbl box for track " + trackCopyWithFormat.f363id + ": remainingSynchronizationSamples " + i15 + ", remainingSamplesAtTimestampDelta " + unsignedIntToInt5 + ", remainingSamplesInChunk " + i23 + ", remainingTimestampDeltaChanges " + i14 + ", remainingSamplesAtTimestampOffset " + unsignedIntToInt8 + (i3 != 0 ? ", ctts invalid" : ""));
                        }
                        length = sampleCount;
                        jArr2 = jArr6;
                        j = j5;
                        i4 = i16;
                        iArr2 = iArr;
                        j2 = j12;
                    } else {
                        i3 = i;
                        if (i15 == 0) {
                            Log.m132w(TAG, "Inconsistent stbl box for track " + trackCopyWithFormat.f363id + ": remainingSynchronizationSamples " + i15 + ", remainingSamplesAtTimestampDelta " + unsignedIntToInt5 + ", remainingSamplesInChunk " + i23 + ", remainingTimestampDeltaChanges " + i14 + ", remainingSamplesAtTimestampOffset " + unsignedIntToInt8 + (i3 != 0 ? ", ctts invalid" : ""));
                            length = sampleCount;
                            jArr2 = jArr6;
                            j = j5;
                            i4 = i16;
                            iArr2 = iArr;
                            j2 = j12;
                        }
                    }
                }
                long[] jArr7 = jArr;
                if (trackCopyWithFormat.mediaDurationUs > 0) {
                    long jScaleLargeValue = Util.scaleLargeValue(j * 8, 1000000L, trackCopyWithFormat.mediaDurationUs, RoundingMode.HALF_DOWN);
                    if (jScaleLargeValue > 0 && jScaleLargeValue < SieveCacheKt.NodeLinkMask) {
                        trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(trackCopyWithFormat.format.buildUpon().setAverageBitrate((int) jScaleLargeValue).build());
                    }
                }
                long jScaleLargeTimestamp2 = Util.scaleLargeTimestamp(j2, 1000000L, trackCopyWithFormat.timescale);
                int[] array = Ints.toArray(arrayList);
                if (trackCopyWithFormat.editListDurations != null) {
                    if (!z) {
                        Util.scaleLargeTimestampsInPlace(jArr7, 1000000L, trackCopyWithFormat.timescale);
                    }
                    return new TrackSampleTable(trackCopyWithFormat, jArr2, iArr2, i4, jArr7, iArrCopyOf, array, r29, jScaleLargeTimestamp2, length);
                }
                ArrayList arrayList6 = arrayList;
                int[] iArr5 = iArrCopyOf;
                if (z) {
                    long[] jArr8 = (long[]) Preconditions.checkNotNull(trackCopyWithFormat.editListMediaTimes);
                    if (trackCopyWithFormat.editListDurations.length == i && trackCopyWithFormat.editListDurations[0] == 0) {
                        jScaleLargeTimestamp = Util.scaleLargeTimestamp(j2 - jArr8[0], 1000000L, trackCopyWithFormat.timescale);
                    } else {
                        long j13 = 0;
                        for (int i25 = 0; i25 < trackCopyWithFormat.editListDurations.length; i25++) {
                            if (jArr8[i25] != -1) {
                                j13 += trackCopyWithFormat.editListDurations[i25];
                            }
                        }
                        jScaleLargeTimestamp = Util.scaleLargeTimestamp(j13, 1000000L, trackCopyWithFormat.movieTimescale);
                    }
                    return new TrackSampleTable(trackCopyWithFormat, jArr2, iArr2, i4, jArr7, iArr5, array, r29, jScaleLargeTimestamp, length);
                }
                if (trackCopyWithFormat.editListDurations.length == 1 && trackCopyWithFormat.type == 1 && jArr7.length >= 2) {
                    long j14 = ((long[]) Preconditions.checkNotNull(trackCopyWithFormat.editListMediaTimes))[0];
                    j3 = -1;
                    long jScaleLargeTimestamp3 = Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[0], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale) + j14;
                    if (canApplyEditWithGaplessInfo(jArr7, j2, j14, jScaleLargeTimestamp3)) {
                        long jMax = Math.max(0L, j2 - jScaleLargeTimestamp3);
                        long jScaleLargeTimestamp4 = Util.scaleLargeTimestamp(j14 - jArr7[0], trackCopyWithFormat.format.sampleRate, trackCopyWithFormat.timescale);
                        long jScaleLargeTimestamp5 = Util.scaleLargeTimestamp(jMax, trackCopyWithFormat.format.sampleRate, trackCopyWithFormat.timescale);
                        if ((jScaleLargeTimestamp4 != 0 || jScaleLargeTimestamp5 != 0) && jScaleLargeTimestamp4 <= SieveCacheKt.NodeLinkMask && jScaleLargeTimestamp5 <= SieveCacheKt.NodeLinkMask) {
                            gaplessInfoHolder.encoderDelay = (int) jScaleLargeTimestamp4;
                            gaplessInfoHolder.encoderPadding = (int) jScaleLargeTimestamp5;
                            Util.scaleLargeTimestampsInPlace(jArr7, 1000000L, trackCopyWithFormat.timescale);
                            return new TrackSampleTable(trackCopyWithFormat, jArr2, iArr2, i4, jArr7, iArr5, array, r29, Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[0], 1000000L, trackCopyWithFormat.movieTimescale), length);
                        }
                    }
                } else {
                    j3 = -1;
                }
                if (trackCopyWithFormat.editListDurations.length == 1 && trackCopyWithFormat.editListDurations[0] == 0) {
                    long j15 = ((long[]) Preconditions.checkNotNull(trackCopyWithFormat.editListMediaTimes))[0];
                    for (int i26 = 0; i26 < jArr7.length; i26++) {
                        jArr7[i26] = Util.scaleLargeTimestamp(jArr7[i26] - j15, 1000000L, trackCopyWithFormat.timescale);
                    }
                    return new TrackSampleTable(trackCopyWithFormat, jArr2, iArr2, i4, jArr7, iArr5, array, r29, Util.scaleLargeTimestamp(j2 - j15, 1000000L, trackCopyWithFormat.timescale), length);
                }
                long[] jArr9 = jArr7;
                long[] jArr10 = jArr2;
                int[] iArr6 = iArr2;
                int i27 = length;
                boolean z3 = trackCopyWithFormat.type == 1;
                int[] iArr7 = new int[trackCopyWithFormat.editListDurations.length];
                int[] iArr8 = new int[trackCopyWithFormat.editListDurations.length];
                long[] jArr11 = (long[]) Preconditions.checkNotNull(trackCopyWithFormat.editListMediaTimes);
                int i28 = 0;
                boolean z4 = false;
                int i29 = 0;
                int i30 = 0;
                while (i28 < trackCopyWithFormat.editListDurations.length) {
                    int[] iArr9 = iArr7;
                    int[] iArr10 = iArr8;
                    long j16 = jArr11[i28];
                    ArrayList arrayList7 = arrayList6;
                    if (j16 != j3) {
                        jArr3 = jArr11;
                        long jScaleLargeTimestamp6 = Util.scaleLargeTimestamp(trackCopyWithFormat.editListDurations[i28], trackCopyWithFormat.timescale, trackCopyWithFormat.movieTimescale) + j16;
                        i6 = i28;
                        iArr9[i6] = Util.binarySearchFloor(jArr9, j16, true, true);
                        int iBinarySearchCeil = Util.binarySearchCeil(jArr9, jScaleLargeTimestamp6, z3, false);
                        int i31 = iBinarySearchCeil - 1;
                        int i32 = iBinarySearchCeil;
                        int i33 = 0;
                        while (true) {
                            i7 = i31;
                            if (i32 >= jArr9.length) {
                                break;
                            }
                            if (jArr9[i32] < jScaleLargeTimestamp6) {
                                i31 = i32;
                            } else {
                                i33++;
                                if (i33 > trackCopyWithFormat.format.maxNumReorderSamples) {
                                    break;
                                }
                                i31 = i7;
                            }
                            i32++;
                        }
                        iArr10[i6] = i7 + 1;
                        int i34 = iArr9[i6];
                        while (true) {
                            i8 = iArr9[i6];
                            if (i8 <= 0) {
                                i9 = 1;
                                break;
                            }
                            i9 = 1;
                            if ((iArr5[i8] & 1) != 0) {
                                break;
                            }
                            iArr9[i6] = i8 - 1;
                        }
                        if (i8 == 0 && (iArr5[0] & i9) == 0) {
                            iArr9[i6] = i34;
                            while (true) {
                                int i35 = iArr9[i6];
                                if (i35 >= iArr10[i6] || (iArr5[i35] & i9) != 0) {
                                    break;
                                }
                                iArr9[i6] = i35 + 1;
                                i9 = 1;
                            }
                        }
                        int i36 = iArr10[i6];
                        int i37 = iArr9[i6];
                        i29 += i36 - i37;
                        boolean z5 = i30 != i37;
                        i30 = i36;
                        z4 = z5 | z4;
                    } else {
                        jArr3 = jArr11;
                        i6 = i28;
                    }
                    i28 = i6 + 1;
                    jArr11 = jArr3;
                    iArr7 = iArr9;
                    iArr8 = iArr10;
                    arrayList6 = arrayList7;
                }
                ArrayList arrayList8 = arrayList6;
                int[] iArr11 = iArr7;
                int[] iArr12 = iArr8;
                boolean z6 = false;
                boolean z7 = (i29 != i27) | z4;
                long[] jArr12 = z7 ? new long[i29] : jArr10;
                int[] iArr13 = z7 ? new int[i29] : iArr6;
                if (z7) {
                    i4 = 0;
                }
                int[] iArr14 = z7 ? new int[i29] : iArr5;
                ArrayList arrayList9 = z7 ? new ArrayList() : arrayList8;
                long[] jArr13 = new long[i29];
                int i38 = 0;
                int i39 = 0;
                int i40 = i4;
                long j17 = 0;
                while (i38 < trackCopyWithFormat.editListDurations.length) {
                    long j18 = trackCopyWithFormat.editListMediaTimes[i38];
                    int i41 = iArr11[i38];
                    boolean z8 = z7;
                    int i42 = iArr12[i38];
                    long[] jArr14 = jArr9;
                    if (z8) {
                        int i43 = i42 - i41;
                        System.arraycopy(jArr10, i41, jArr12, i39, i43);
                        System.arraycopy(iArr6, i41, iArr13, i39, i43);
                        System.arraycopy(iArr5, i41, iArr14, i39, i43);
                    }
                    while (i41 < i42) {
                        long[] jArr15 = jArr10;
                        int[] iArr15 = iArr6;
                        long jScaleLargeTimestamp7 = Util.scaleLargeTimestamp(j17, 1000000L, trackCopyWithFormat.movieTimescale);
                        long jScaleLargeTimestamp8 = Util.scaleLargeTimestamp(jArr14[i41] - j18, 1000000L, trackCopyWithFormat.timescale);
                        if (jScaleLargeTimestamp8 < 0) {
                            z6 = true;
                        }
                        jArr13[i39] = jScaleLargeTimestamp7 + jScaleLargeTimestamp8;
                        if (z8 && iArr13[i39] > i40) {
                            i40 = iArr15[i41];
                        }
                        if (z8 && r29 == 0 && (iArr14[i39] & 1) != 0) {
                            arrayList9.add(Integer.valueOf(i39));
                        }
                        i39++;
                        i41++;
                        jArr10 = jArr15;
                        iArr6 = iArr15;
                    }
                    j17 += trackCopyWithFormat.editListDurations[i38];
                    i38++;
                    z7 = z8;
                    jArr10 = jArr10;
                    jArr9 = jArr14;
                    iArr6 = iArr6;
                }
                long jScaleLargeTimestamp9 = Util.scaleLargeTimestamp(j17, 1000000L, trackCopyWithFormat.movieTimescale);
                if (z6) {
                    trackCopyWithFormat = trackCopyWithFormat.copyWithFormat(trackCopyWithFormat.format.buildUpon().setHasPrerollSamples(true).build());
                }
                return new TrackSampleTable(trackCopyWithFormat, jArr12, iArr13, i40, jArr13, iArr14, Ints.toArray(arrayList9), r29, jScaleLargeTimestamp9, jArr12.length);
            }
            unsignedIntToInt3 = parsableByteArray4.readUnsignedIntToInt() - 1;
        } else {
            unsignedIntToInt2 = 0;
            unsignedIntToInt3 = -1;
        }
        i = 1;
        int fixedSampleSize2 = stz2SampleSizeBox.getFixedSampleSize();
        String str2 = trackCopyWithFormat.format.sampleMimeType;
        if (fixedSampleSize2 == -1) {
        }
        ArrayList arrayList32 = new ArrayList();
        if (parsableByteArray4 != null) {
        }
        if (i2 == 0) {
        }
        long[] jArr72 = jArr;
        if (trackCopyWithFormat.mediaDurationUs > 0) {
        }
        long jScaleLargeTimestamp22 = Util.scaleLargeTimestamp(j2, 1000000L, trackCopyWithFormat.timescale);
        int[] array2 = Ints.toArray(arrayList);
        if (trackCopyWithFormat.editListDurations != null) {
        }
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaBoxHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int i2 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + i2);
            }
            parsableByteArray.setPosition(position + i2);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry ilstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (ilstElement != null) {
                arrayList.add(ilstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    private static Metadata parseXyz(ParsableByteArray parsableByteArray) {
        short s = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        String string = parsableByteArray.readString(s);
        int iMax = Math.max(string.lastIndexOf(43), string.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(string.substring(0, iMax)), Float.parseFloat(string.substring(iMax, string.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullBoxVersion == 0 ? 8 : 16);
        int i = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        int i2 = fullBoxVersion == 0 ? 4 : 8;
        int i3 = 0;
        while (true) {
            j = C2181C.TIME_UNSET;
            if (i3 < i2) {
                if (parsableByteArray.getData()[position + i3] != -1) {
                    long unsignedInt = fullBoxVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                    if (unsignedInt != 0) {
                        j = unsignedInt;
                    }
                } else {
                    i3++;
                }
            } else {
                parsableByteArray.skipBytes(i2);
                break;
            }
        }
        parsableByteArray.skipBytes(10);
        int i4 = 0;
        long j2 = j;
        int unsignedShort = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(4);
        int i5 = parsableByteArray.readInt();
        int i6 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int i7 = parsableByteArray.readInt();
        int i8 = parsableByteArray.readInt();
        if (i5 == 0 && i6 == 65536 && ((i7 == -65536 || i7 == 65536) && i8 == 0)) {
            i4 = 90;
        } else if (i5 == 0 && i6 == -65536 && ((i7 == 65536 || i7 == -65536) && i8 == 0)) {
            i4 = 270;
        } else if ((i5 == -65536 || i5 == 65536) && i6 == 0 && i7 == 0 && i8 == -65536) {
            i4 = SensibleDefaults.X_OFFSET;
        }
        parsableByteArray.skipBytes(16);
        short s = parsableByteArray.readShort();
        parsableByteArray.skipBytes(2);
        return new TkhdData(i, j2, unsignedShort, i4, s, parsableByteArray.readShort());
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static MdhdData parseMdhd(ParsableByteArray parsableByteArray) {
        long j;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(fullBoxVersion == 0 ? 8 : 16);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        int position = parsableByteArray.getPosition();
        int i = fullBoxVersion == 0 ? 4 : 8;
        int i2 = 0;
        while (true) {
            j = C2181C.TIME_UNSET;
            if (i2 < i) {
                if (parsableByteArray.getData()[position + i2] != -1) {
                    long unsignedInt2 = fullBoxVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
                    if (unsignedInt2 != 0) {
                        long jScaleLargeTimestamp = Util.scaleLargeTimestamp(unsignedInt2, 1000000L, unsignedInt);
                        unsignedInt = unsignedInt;
                        j = jScaleLargeTimestamp;
                    }
                } else {
                    i2++;
                }
            } else {
                parsableByteArray.skipBytes(i);
                break;
            }
        }
        return new MdhdData(unsignedInt, j, getLanguageFromCode(parsableByteArray.readUnsignedShort()));
    }

    private static String getLanguageFromCode(int i) {
        char[] cArr = {(char) (((i >> 10) & 31) + 96), (char) (((i >> 5) & 31) + 96), (char) ((i & 31) + 96)};
        for (int i2 = 0; i2 < 3; i2++) {
            char c = cArr[i2];
            if (c < 'a' || c > 'z') {
                return null;
            }
        }
        return new String(cArr);
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, TkhdData tkhdData, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        parsableByteArray.setPosition(12);
        int i = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(i);
        for (int i2 = 0; i2 < i; i2++) {
            int position = parsableByteArray.getPosition();
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            int i4 = parsableByteArray.readInt();
            if (i4 == 1635148593 || i4 == 1635148595 || i4 == 1701733238 || i4 == 1831958048 || i4 == 1836070006 || i4 == 1752589105 || i4 == 1751479857 || i4 == 1987470129 || i4 == 1987471665 || i4 == 1932670515 || i4 == 1211250227 || i4 == 1748121139 || i4 == 1987063864 || i4 == 1987063865 || i4 == 1635135537 || i4 == 1685479798 || i4 == 1685479729 || i4 == 1685481573 || i4 == 1685481521 || i4 == 1634760241 || i4 == 1684108849) {
                parseVideoSampleEntry(parsableByteArray, i4, position, i3, tkhdData.f362id, str, tkhdData.rotationDegrees, drmInitData, stsdData, i2);
            } else if (i4 == 1836069985 || i4 == 1701733217 || i4 == 1633889587 || i4 == 1700998451 || i4 == 1633889588 || i4 == 1835823201 || i4 == 1685353315 || i4 == 1685353317 || i4 == 1685353320 || i4 == 1685353324 || i4 == 1685353336 || i4 == 1935764850 || i4 == 1935767394 || i4 == 1819304813 || i4 == 1936684916 || i4 == 1953984371 || i4 == 778924082 || i4 == 778924083 || i4 == 1835557169 || i4 == 1835560241 || i4 == 1634492771 || i4 == 1634492791 || i4 == 1970037111 || i4 == 1332770163 || i4 == 1716281667 || i4 == 1767992678 || i4 == 1768973165 || i4 == 1718641517) {
                parseAudioSampleEntry(parsableByteArray, i4, position, i3, tkhdData.f362id, str, z, drmInitData, stsdData, i2);
            } else if (i4 == 1414810956 || i4 == 1954034535 || i4 == 2004251764 || i4 == 1937010800 || i4 == 1664495672 || i4 == 1836070003) {
                StsdData stsdData2 = stsdData;
                parseTextSampleEntry(parsableByteArray, i4, position, i3, tkhdData, str, stsdData2);
                stsdData = stsdData2;
            } else if (i4 == 1835365492) {
                parseMetaDataSampleEntry(parsableByteArray, i4, position, tkhdData.f362id, stsdData);
            } else if (i4 == 1667329389) {
                stsdData.format = new Format.Builder().setId(tkhdData.f362id).setSampleMimeType(MimeTypes.APPLICATION_CAMERA_MOTION).build();
            }
            parsableByteArray.setPosition(position + i3);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, TkhdData tkhdData, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableListM767of = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i4 = i3 - 16;
                byte[] bArr = new byte[i4];
                parsableByteArray.readBytes(bArr, 0, i4);
                immutableListM767of = ImmutableList.m767of(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else if (i == 1836070003) {
                int position = parsableByteArray.getPosition();
                parsableByteArray.skipBytes(4);
                if (parsableByteArray.readInt() == 1702061171) {
                    EsdsData esdsFromParent = parseEsdsFromParent(parsableByteArray, position);
                    if (esdsFromParent.initializationData == null || esdsFromParent.initializationData.length != 64) {
                        return;
                    }
                    immutableListM767of = ImmutableList.m767of(Util.getUtf8Bytes(formatVobsubIdx(esdsFromParent.initializationData, tkhdData.width, tkhdData.height)));
                    str2 = MimeTypes.APPLICATION_VOBSUB;
                } else {
                    str2 = null;
                }
            } else {
                throw new IllegalStateException();
            }
        }
        if (str2 != null) {
            stsdData.format = new Format.Builder().setId(tkhdData.f362id).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableListM767of).build();
        }
    }

    private static String formatVobsubIdx(byte[] bArr, int i, int i2) {
        Preconditions.checkState(bArr.length == 64);
        ArrayList arrayList = new ArrayList(16);
        for (int i3 = 0; i3 < bArr.length - 3; i3 += 4) {
            arrayList.add(String.format("%06x", Integer.valueOf(vobsubYuvToRgb(Ints.fromBytes(bArr[i3], bArr[i3 + 1], bArr[i3 + 2], bArr[i3 + 3])))));
        }
        return "size: " + i + "x" + i2 + "\npalette: " + Joiner.m734on(TextRecallingManager.ANSWER_SEPARATOR).join(arrayList) + "\n";
    }

    private static int vobsubYuvToRgb(int i) {
        int i2 = (i >> 16) & 255;
        int i3 = ((i >> 8) & 255) + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        int i4 = (i & 255) + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        return Util.constrainValue(i2 + ((i4 * 17790) / 10000), 0, 255) | (Util.constrainValue(((i3 * 14075) / 10000) + i2, 0, 255) << 16) | (Util.constrainValue((i2 - ((i4 * 3455) / 10000)) - ((i3 * 7169) / 10000), 0, 255) << 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:213:0x053a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        String str2;
        DrmInitData drmInitData2;
        int i7;
        List<byte[]> list;
        int i8;
        int i9;
        int i10;
        int i11;
        byte[] bArr;
        String str3;
        int i12;
        DolbyVisionConfig dolbyVisionConfig;
        String str4;
        String str5;
        int i13;
        String str6;
        int iIsoColorPrimariesToColorSpace;
        int i14;
        DrmInitData drmInitData3;
        int i15;
        List<byte[]> list2;
        String str7;
        int i16;
        int i17;
        int i18;
        int i19;
        NalUnitUtil.H265VpsData h265VpsData;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26 = i2;
        int i27 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray.setPosition(i26 + 16);
        parsableByteArray.skipBytes(16);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int iIntValue = i;
        if (iIntValue == 1701733238) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i26, i27);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str8 = MimeTypes.VIDEO_H263;
        if (iIntValue != 1831958048) {
            str2 = iIntValue == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        } else {
            str2 = MimeTypes.VIDEO_MPEG;
        }
        float paspFromParent = 1.0f;
        int i28 = 8;
        int i29 = 8;
        ByteBuffer byteBufferAllocateHdrStaticInfo = null;
        DolbyVisionConfig dolbyVisionConfig2 = null;
        List<byte[]> listM767of = null;
        String strBuildApvCodecString = null;
        byte[] projFromParent = null;
        int i30 = -1;
        int i31 = -1;
        int i32 = -1;
        int i33 = -1;
        int i34 = -1;
        int i35 = -1;
        int i36 = -1;
        int iIsoTransferCharacteristicsToColorTransfer = -1;
        BtrtData btrtFromParent = null;
        EsdsData esdsFromParent = null;
        NalUnitUtil.H265VpsData h265VpsData2 = null;
        boolean z = false;
        while (true) {
            if (position - i26 >= i27) {
                drmInitData2 = drmInitDataCopyWithSchemeType;
                i7 = i28;
                list = listM767of;
                i8 = i30;
                i9 = i35;
                i10 = i36;
                i11 = iIsoTransferCharacteristicsToColorTransfer;
                bArr = null;
                str3 = str2;
                i12 = i29;
                dolbyVisionConfig = dolbyVisionConfig2;
                break;
            }
            parsableByteArray.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            int i37 = parsableByteArray.readInt();
            if (i37 == 0 && parsableByteArray.getPosition() - i2 == i27) {
                drmInitData2 = drmInitDataCopyWithSchemeType;
                i7 = i28;
                dolbyVisionConfig = dolbyVisionConfig2;
                list = listM767of;
                i8 = i30;
                i9 = i35;
                i10 = i36;
                i11 = iIsoTransferCharacteristicsToColorTransfer;
                bArr = null;
                str3 = str2;
                i12 = i29;
                break;
            }
            ExtractorUtil.checkContainerInput(i37 > 0, "childAtomSize must be positive");
            int i38 = parsableByteArray.readInt();
            if (i38 == 1635148611) {
                ExtractorUtil.checkContainerInput(str2 == null, null);
                parsableByteArray.setPosition(position2 + 8);
                AvcConfig avcConfig = AvcConfig.parse(parsableByteArray);
                List<byte[]> list3 = avcConfig.initializationData;
                stsdData2.nalUnitLengthFieldLength = avcConfig.nalUnitLengthFieldLength;
                if (!z) {
                    paspFromParent = avcConfig.pixelWidthHeightRatio;
                }
                String str9 = avcConfig.codecs;
                int i39 = avcConfig.maxNumReorderFrames;
                int i40 = avcConfig.colorSpace;
                int i41 = avcConfig.colorRange;
                listM767of = list3;
                int i42 = avcConfig.colorTransfer;
                int i43 = avcConfig.bitdepthLuma;
                int i44 = avcConfig.bitdepthChroma;
                drmInitData3 = drmInitDataCopyWithSchemeType;
                i13 = position;
                i16 = iIntValue;
                str6 = str8;
                iIsoColorPrimariesToColorSpace = i40;
                i14 = i41;
                iIsoTransferCharacteristicsToColorTransfer = i42;
                str7 = MimeTypes.VIDEO_H264;
                i29 = i44;
                strBuildApvCodecString = str9;
                i31 = i39;
                h265VpsData = h265VpsData2;
                i15 = i43;
            } else {
                i13 = position;
                if (i38 == 1752589123) {
                    ExtractorUtil.checkContainerInput(str2 == null, null);
                    parsableByteArray.setPosition(position2 + 8);
                    HevcConfig hevcConfig = HevcConfig.parse(parsableByteArray);
                    List<byte[]> list4 = hevcConfig.initializationData;
                    stsdData2.nalUnitLengthFieldLength = hevcConfig.nalUnitLengthFieldLength;
                    if (!z) {
                        paspFromParent = hevcConfig.pixelWidthHeightRatio;
                    }
                    int i45 = hevcConfig.maxNumReorderPics;
                    int i46 = hevcConfig.maxSubLayers;
                    String str10 = hevcConfig.codecs;
                    listM767of = list4;
                    if (hevcConfig.stereoMode != -1) {
                        i30 = hevcConfig.stereoMode;
                    }
                    int i47 = hevcConfig.decodedWidth;
                    int i48 = hevcConfig.decodedHeight;
                    int i49 = hevcConfig.colorSpace;
                    int i50 = hevcConfig.colorRange;
                    int i51 = hevcConfig.colorTransfer;
                    int i52 = hevcConfig.bitdepthLuma;
                    int i53 = hevcConfig.bitdepthChroma;
                    h265VpsData = hevcConfig.vpsData;
                    drmInitData3 = drmInitDataCopyWithSchemeType;
                    str7 = MimeTypes.VIDEO_H265;
                    i16 = iIntValue;
                    str6 = str8;
                    iIsoColorPrimariesToColorSpace = i49;
                    i14 = i50;
                    iIsoTransferCharacteristicsToColorTransfer = i51;
                    i15 = i52;
                    i31 = i45;
                    i32 = i46;
                    i34 = i48;
                    i33 = i47;
                    i29 = i53;
                    strBuildApvCodecString = str10;
                } else {
                    str6 = str8;
                    if (i38 == 1818785347) {
                        ExtractorUtil.checkContainerInput(MimeTypes.VIDEO_H265.equals(str2), "lhvC must follow hvcC atom");
                        NalUnitUtil.H265VpsData h265VpsData3 = h265VpsData2;
                        ExtractorUtil.checkContainerInput(h265VpsData3 != null && h265VpsData3.layerInfos.size() >= 2, "must have at least two layers");
                        parsableByteArray.setPosition(position2 + 8);
                        HevcConfig layered = HevcConfig.parseLayered(parsableByteArray, (NalUnitUtil.H265VpsData) Preconditions.checkNotNull(h265VpsData3));
                        ExtractorUtil.checkContainerInput(stsdData2.nalUnitLengthFieldLength == layered.nalUnitLengthFieldLength, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                        if (layered.colorSpace != -1) {
                            i22 = i35;
                            ExtractorUtil.checkContainerInput(i22 == layered.colorSpace, "colorSpace must be the same for both views");
                        } else {
                            i22 = i35;
                        }
                        if (layered.colorRange != -1) {
                            i23 = i36;
                            ExtractorUtil.checkContainerInput(i23 == layered.colorRange, "colorRange must be the same for both views");
                        } else {
                            i23 = i36;
                        }
                        if (layered.colorTransfer != -1) {
                            int i54 = iIsoTransferCharacteristicsToColorTransfer;
                            i24 = i54;
                            ExtractorUtil.checkContainerInput(i54 == layered.colorTransfer, "colorTransfer must be the same for both views");
                        } else {
                            i24 = iIsoTransferCharacteristicsToColorTransfer;
                        }
                        ExtractorUtil.checkContainerInput(i28 == layered.bitdepthLuma, "bitdepthLuma must be the same for both views");
                        ExtractorUtil.checkContainerInput(i29 == layered.bitdepthChroma, "bitdepthChroma must be the same for both views");
                        List<byte[]> listBuild = listM767of;
                        if (listBuild != null) {
                            listBuild = ImmutableList.builder().addAll((Iterable) listBuild).addAll((Iterable) layered.initializationData).build();
                            i25 = i22;
                        } else {
                            i25 = i22;
                            ExtractorUtil.checkContainerInput(false, "initializationData must be already set from hvcC atom");
                        }
                        String str11 = layered.codecs;
                        drmInitData3 = drmInitDataCopyWithSchemeType;
                        i15 = i28;
                        str7 = MimeTypes.VIDEO_MV_HEVC;
                        i16 = iIntValue;
                        i14 = i23;
                        iIsoColorPrimariesToColorSpace = i25;
                        iIsoTransferCharacteristicsToColorTransfer = i24;
                        strBuildApvCodecString = str11;
                        h265VpsData = h265VpsData3;
                        listM767of = listBuild;
                    } else {
                        List<byte[]> listBuildVp9CodecPrivateInitializationData = listM767of;
                        iIsoColorPrimariesToColorSpace = i35;
                        i14 = i36;
                        int i55 = iIsoTransferCharacteristicsToColorTransfer;
                        NalUnitUtil.H265VpsData h265VpsData4 = h265VpsData2;
                        if (i38 == 1987470147) {
                            ExtractorUtil.checkContainerInput(str2 == null, null);
                            parsableByteArray.setPosition(position2 + 8);
                            VvcConfig vvcConfig = VvcConfig.parse(parsableByteArray);
                            List<byte[]> list5 = vvcConfig.initializationData;
                            stsdData2.nalUnitLengthFieldLength = vvcConfig.nalUnitLengthFieldLength;
                            String str12 = vvcConfig.codecs;
                            int i56 = vvcConfig.bitdepthLuma;
                            i29 = vvcConfig.bitdepthLuma;
                            h265VpsData = h265VpsData4;
                            drmInitData3 = drmInitDataCopyWithSchemeType;
                            listM767of = list5;
                            strBuildApvCodecString = str12;
                            i15 = i56;
                            i16 = iIntValue;
                            str7 = MimeTypes.VIDEO_H266;
                            iIsoTransferCharacteristicsToColorTransfer = i55;
                            i31 = 16;
                        } else if (i38 == 1986361461) {
                            VexuData videoExtendedUsageBox = parseVideoExtendedUsageBox(parsableByteArray, position2, i37);
                            if (videoExtendedUsageBox == null || videoExtendedUsageBox.eyesData == null) {
                                i21 = i30;
                                i30 = i21;
                                h265VpsData = h265VpsData4;
                                drmInitData3 = drmInitDataCopyWithSchemeType;
                                i15 = i28;
                                listM767of = listBuildVp9CodecPrivateInitializationData;
                                str7 = str2;
                                i16 = iIntValue;
                                iIsoTransferCharacteristicsToColorTransfer = i55;
                            } else if (h265VpsData4 == null || h265VpsData4.layerInfos.size() < 2) {
                                i21 = i30;
                                if (i21 == -1) {
                                    i30 = videoExtendedUsageBox.eyesData.striData.eyeViewsReversed ? 5 : 4;
                                } else {
                                    i30 = i21;
                                }
                                h265VpsData = h265VpsData4;
                                drmInitData3 = drmInitDataCopyWithSchemeType;
                                i15 = i28;
                                listM767of = listBuildVp9CodecPrivateInitializationData;
                                str7 = str2;
                                i16 = iIntValue;
                                iIsoTransferCharacteristicsToColorTransfer = i55;
                            } else {
                                ExtractorUtil.checkContainerInput(videoExtendedUsageBox.hasBothEyeViews(), "both eye views must be marked as available");
                                ExtractorUtil.checkContainerInput(!videoExtendedUsageBox.eyesData.striData.eyeViewsReversed, "for MV-HEVC, eye_views_reversed must be set to false");
                                i21 = i30;
                                i30 = i21;
                                h265VpsData = h265VpsData4;
                                drmInitData3 = drmInitDataCopyWithSchemeType;
                                i15 = i28;
                                listM767of = listBuildVp9CodecPrivateInitializationData;
                                str7 = str2;
                                i16 = iIntValue;
                                iIsoTransferCharacteristicsToColorTransfer = i55;
                            }
                        } else {
                            int i57 = i30;
                            if (i38 == 1685480259 || i38 == 1685485123 || i38 == 1685485379) {
                                drmInitData3 = drmInitDataCopyWithSchemeType;
                                i15 = i28;
                                list2 = listBuildVp9CodecPrivateInitializationData;
                                str7 = str2;
                                i16 = iIntValue;
                                i17 = i29;
                                i18 = iIsoColorPrimariesToColorSpace;
                                i19 = i55;
                                dolbyVisionConfig2 = DolbyVisionConfig.parse(parsableByteArray);
                            } else if (i38 == 1987076931) {
                                ExtractorUtil.checkContainerInput(str2 == null, null);
                                String str13 = iIntValue == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                                parsableByteArray.setPosition(position2 + 12);
                                byte unsignedByte = (byte) parsableByteArray.readUnsignedByte();
                                byte unsignedByte2 = (byte) parsableByteArray.readUnsignedByte();
                                int unsignedByte3 = parsableByteArray.readUnsignedByte();
                                i29 = unsignedByte3 >> 4;
                                i16 = iIntValue;
                                byte b = (byte) ((unsignedByte3 >> 1) & 7);
                                if (str13.equals(MimeTypes.VIDEO_VP9)) {
                                    listBuildVp9CodecPrivateInitializationData = CodecSpecificDataUtil.buildVp9CodecPrivateInitializationData(unsignedByte, unsignedByte2, (byte) i29, b);
                                }
                                boolean z2 = (unsignedByte3 & 1) != 0;
                                int unsignedByte4 = parsableByteArray.readUnsignedByte();
                                int unsignedByte5 = parsableByteArray.readUnsignedByte();
                                int iIsoColorPrimariesToColorSpace2 = ColorInfo.isoColorPrimariesToColorSpace(unsignedByte4);
                                int i58 = z2 ? 1 : 2;
                                iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedByte5);
                                drmInitData3 = drmInitDataCopyWithSchemeType;
                                i15 = i29;
                                i14 = i58;
                                iIsoColorPrimariesToColorSpace = iIsoColorPrimariesToColorSpace2;
                                str7 = str13;
                                listM767of = listBuildVp9CodecPrivateInitializationData;
                                h265VpsData = h265VpsData4;
                                i30 = i57;
                            } else {
                                i16 = iIntValue;
                                if (i38 == 1635135811) {
                                    int i59 = i37 - 8;
                                    byte[] bArr2 = new byte[i59];
                                    parsableByteArray.readBytes(bArr2, 0, i59);
                                    listM767of = ImmutableList.m767of(bArr2);
                                    parsableByteArray.setPosition(position2 + 8);
                                    ColorInfo av1c = parseAv1c(parsableByteArray);
                                    int i60 = av1c.lumaBitdepth;
                                    int i61 = av1c.chromaBitdepth;
                                    int i62 = av1c.colorSpace;
                                    int i63 = av1c.colorRange;
                                    iIsoTransferCharacteristicsToColorTransfer = av1c.colorTransfer;
                                    i15 = i60;
                                    drmInitData3 = drmInitDataCopyWithSchemeType;
                                    i29 = i61;
                                    iIsoColorPrimariesToColorSpace = i62;
                                    i14 = i63;
                                    str7 = MimeTypes.VIDEO_AV1;
                                    h265VpsData = h265VpsData4;
                                } else if (i38 == 1668050025) {
                                    if (byteBufferAllocateHdrStaticInfo == null) {
                                        byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                                    }
                                    ByteBuffer byteBuffer = byteBufferAllocateHdrStaticInfo;
                                    byteBuffer.position(21);
                                    byteBuffer.putShort(parsableByteArray.readShort());
                                    byteBuffer.putShort(parsableByteArray.readShort());
                                    byteBufferAllocateHdrStaticInfo = byteBuffer;
                                    drmInitData3 = drmInitDataCopyWithSchemeType;
                                    i15 = i28;
                                    listM767of = listBuildVp9CodecPrivateInitializationData;
                                    str7 = str2;
                                    h265VpsData = h265VpsData4;
                                    iIsoTransferCharacteristicsToColorTransfer = i55;
                                } else if (i38 == 1835295606) {
                                    if (byteBufferAllocateHdrStaticInfo == null) {
                                        byteBufferAllocateHdrStaticInfo = allocateHdrStaticInfo();
                                    }
                                    ByteBuffer byteBuffer2 = byteBufferAllocateHdrStaticInfo;
                                    short s = parsableByteArray.readShort();
                                    short s2 = parsableByteArray.readShort();
                                    short s3 = parsableByteArray.readShort();
                                    str7 = str2;
                                    short s4 = parsableByteArray.readShort();
                                    short s5 = parsableByteArray.readShort();
                                    int i64 = i29;
                                    short s6 = parsableByteArray.readShort();
                                    i15 = i28;
                                    short s7 = parsableByteArray.readShort();
                                    drmInitData3 = drmInitDataCopyWithSchemeType;
                                    short s8 = parsableByteArray.readShort();
                                    long unsignedInt = parsableByteArray.readUnsignedInt();
                                    long unsignedInt2 = parsableByteArray.readUnsignedInt();
                                    byteBuffer2.position(1);
                                    byteBuffer2.putShort(s5);
                                    byteBuffer2.putShort(s6);
                                    byteBuffer2.putShort(s);
                                    byteBuffer2.putShort(s2);
                                    byteBuffer2.putShort(s3);
                                    byteBuffer2.putShort(s4);
                                    byteBuffer2.putShort(s7);
                                    byteBuffer2.putShort(s8);
                                    byteBuffer2.putShort((short) (unsignedInt / 10000));
                                    byteBuffer2.putShort((short) (unsignedInt2 / 10000));
                                    byteBufferAllocateHdrStaticInfo = byteBuffer2;
                                    h265VpsData = h265VpsData4;
                                    i29 = i64;
                                    iIsoTransferCharacteristicsToColorTransfer = i55;
                                    listM767of = listBuildVp9CodecPrivateInitializationData;
                                } else {
                                    drmInitData3 = drmInitDataCopyWithSchemeType;
                                    i15 = i28;
                                    list2 = listBuildVp9CodecPrivateInitializationData;
                                    str7 = str2;
                                    i17 = i29;
                                    if (i38 == 1681012275) {
                                        ExtractorUtil.checkContainerInput(str7 == null, null);
                                        h265VpsData = h265VpsData4;
                                        i29 = i17;
                                        str7 = str6;
                                    } else if (i38 == 1702061171) {
                                        ExtractorUtil.checkContainerInput(str7 == null, null);
                                        esdsFromParent = parseEsdsFromParent(parsableByteArray, position2);
                                        String str14 = esdsFromParent.mimeType;
                                        byte[] bArr3 = esdsFromParent.initializationData;
                                        listM767of = bArr3 != null ? ImmutableList.m767of(bArr3) : list2;
                                        str7 = str14;
                                        h265VpsData = h265VpsData4;
                                        i29 = i17;
                                        iIsoTransferCharacteristicsToColorTransfer = i55;
                                        i30 = i57;
                                    } else {
                                        if (i38 == 1651798644) {
                                            btrtFromParent = parseBtrtFromParent(parsableByteArray, position2);
                                        } else {
                                            if (i38 == 1885434736) {
                                                paspFromParent = parsePaspFromParent(parsableByteArray, position2);
                                                h265VpsData = h265VpsData4;
                                                i29 = i17;
                                                iIsoTransferCharacteristicsToColorTransfer = i55;
                                                listM767of = list2;
                                                z = true;
                                            } else if (i38 == 1937126244) {
                                                projFromParent = parseProjFromParent(parsableByteArray, position2, i37);
                                            } else if (i38 == 1936995172) {
                                                int unsignedByte6 = parsableByteArray.readUnsignedByte();
                                                parsableByteArray.skipBytes(3);
                                                if (unsignedByte6 != 0) {
                                                    i20 = i57;
                                                    h265VpsData = h265VpsData4;
                                                    i29 = i17;
                                                    iIsoTransferCharacteristicsToColorTransfer = i55;
                                                    listM767of = list2;
                                                    i30 = i20;
                                                } else {
                                                    int unsignedByte7 = parsableByteArray.readUnsignedByte();
                                                    if (unsignedByte7 != 0) {
                                                        i20 = 1;
                                                        if (unsignedByte7 != 1) {
                                                            if (unsignedByte7 == 2) {
                                                                i20 = 2;
                                                            } else if (unsignedByte7 == 3) {
                                                                i20 = 3;
                                                            }
                                                        }
                                                    } else {
                                                        i20 = 0;
                                                    }
                                                    h265VpsData = h265VpsData4;
                                                    i29 = i17;
                                                    iIsoTransferCharacteristicsToColorTransfer = i55;
                                                    listM767of = list2;
                                                    i30 = i20;
                                                }
                                            } else {
                                                if (i38 == 1634760259) {
                                                    int i65 = i37 - 12;
                                                    byte[] bArr4 = new byte[i65];
                                                    parsableByteArray.setPosition(position2 + 12);
                                                    parsableByteArray.readBytes(bArr4, 0, i65);
                                                    strBuildApvCodecString = CodecSpecificDataUtil.buildApvCodecString(bArr4);
                                                    listM767of = ImmutableList.m767of(bArr4);
                                                    ColorInfo apvc = parseApvc(new ParsableByteArray(bArr4));
                                                    int i66 = apvc.lumaBitdepth;
                                                    int i67 = apvc.chromaBitdepth;
                                                    int i68 = apvc.colorSpace;
                                                    int i69 = apvc.colorRange;
                                                    iIsoTransferCharacteristicsToColorTransfer = apvc.colorTransfer;
                                                    i15 = i66;
                                                    i29 = i67;
                                                    iIsoColorPrimariesToColorSpace = i68;
                                                    i14 = i69;
                                                    str7 = MimeTypes.VIDEO_APV;
                                                    h265VpsData = h265VpsData4;
                                                } else {
                                                    i18 = iIsoColorPrimariesToColorSpace;
                                                    if (i38 == 1668246642) {
                                                        i19 = i55;
                                                        if (i18 == -1 && i19 == -1) {
                                                            int i70 = parsableByteArray.readInt();
                                                            if (i70 == TYPE_nclx || i70 == TYPE_nclc) {
                                                                int unsignedShort3 = parsableByteArray.readUnsignedShort();
                                                                int unsignedShort4 = parsableByteArray.readUnsignedShort();
                                                                parsableByteArray.skipBytes(2);
                                                                boolean z3 = i37 == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                                                                iIsoColorPrimariesToColorSpace = ColorInfo.isoColorPrimariesToColorSpace(unsignedShort3);
                                                                i14 = z3 ? 1 : 2;
                                                                h265VpsData = h265VpsData4;
                                                                i29 = i17;
                                                                listM767of = list2;
                                                                iIsoTransferCharacteristicsToColorTransfer = ColorInfo.isoTransferCharacteristicsToColorTransfer(unsignedShort4);
                                                            } else {
                                                                Log.m132w(TAG, "Unsupported color type: " + Mp4Box.getBoxTypeString(i70));
                                                            }
                                                        }
                                                    } else {
                                                        i19 = i55;
                                                    }
                                                }
                                            }
                                            i30 = i57;
                                        }
                                        h265VpsData = h265VpsData4;
                                        i29 = i17;
                                    }
                                    iIsoTransferCharacteristicsToColorTransfer = i55;
                                    listM767of = list2;
                                    i30 = i57;
                                }
                                i30 = i57;
                            }
                            iIsoColorPrimariesToColorSpace = i18;
                            i29 = i17;
                            listM767of = list2;
                            iIsoTransferCharacteristicsToColorTransfer = i19;
                            h265VpsData = h265VpsData4;
                            i30 = i57;
                        }
                        position = i13 + i37;
                        i27 = i3;
                        stsdData2 = stsdData;
                        str2 = str7;
                        iIntValue = i16;
                        i28 = i15;
                        str8 = str6;
                        i35 = iIsoColorPrimariesToColorSpace;
                        i36 = i14;
                        drmInitDataCopyWithSchemeType = drmInitData3;
                        h265VpsData2 = h265VpsData;
                        i26 = i2;
                    }
                }
            }
            position = i13 + i37;
            i27 = i3;
            stsdData2 = stsdData;
            str2 = str7;
            iIntValue = i16;
            i28 = i15;
            str8 = str6;
            i35 = iIsoColorPrimariesToColorSpace;
            i36 = i14;
            drmInitDataCopyWithSchemeType = drmInitData3;
            h265VpsData2 = h265VpsData;
            i26 = i2;
        }
        if (dolbyVisionConfig != null) {
            str4 = dolbyVisionConfig.codecs;
            str5 = MimeTypes.VIDEO_DOLBY_VISION;
        } else {
            str4 = strBuildApvCodecString;
            str5 = str3;
        }
        if (str5 == null) {
            return;
        }
        Format.Builder colorInfo = new Format.Builder().setId(i4).setSampleMimeType(str5).setCodecs(str4).setWidth(unsignedShort).setHeight(unsignedShort2).setDecodedWidth(i33).setDecodedHeight(i34).setPixelWidthHeightRatio(paspFromParent).setRotationDegrees(i5).setProjectionData(projFromParent).setStereoMode(i8).setInitializationData(list).setMaxNumReorderSamples(i31).setMaxSubLayers(i32).setDrmInitData(drmInitData2).setLanguage(str).setColorInfo(new ColorInfo.Builder().setColorSpace(i9).setColorRange(i10).setColorTransfer(i11).setHdrStaticInfo(byteBufferAllocateHdrStaticInfo != null ? byteBufferAllocateHdrStaticInfo.array() : bArr).setLumaBitdepth(i7).setChromaBitdepth(i12).build());
        if (btrtFromParent != null) {
            colorInfo.setAverageBitrate(Ints.saturatedCast(btrtFromParent.avgBitrate)).setPeakBitrate(Ints.saturatedCast(btrtFromParent.maxBitrate));
        } else if (esdsFromParent != null) {
            colorInfo.setAverageBitrate(Ints.saturatedCast(esdsFromParent.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsFromParent.peakBitrate));
        }
        stsdData.format = colorInfo.build();
    }

    private static ColorInfo parseAv1c(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int bits = parsableBitArray.readBits(3);
        parsableBitArray.skipBits(6);
        boolean bit = parsableBitArray.readBit();
        boolean bit2 = parsableBitArray.readBit();
        if (bits == 2 && bit) {
            builder.setLumaBitdepth(bit2 ? 12 : 10);
            builder.setChromaBitdepth(bit2 ? 12 : 10);
        } else if (bits <= 2) {
            builder.setLumaBitdepth(bit ? 10 : 8);
            builder.setChromaBitdepth(bit ? 10 : 8);
        }
        parsableBitArray.skipBits(13);
        parsableBitArray.skipBit();
        int bits2 = parsableBitArray.readBits(4);
        if (bits2 != 1) {
            Log.m130i(TAG, "Unsupported obu_type: " + bits2);
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.m130i(TAG, "Unsupported obu_extension_flag");
            return builder.build();
        }
        boolean bit3 = parsableBitArray.readBit();
        parsableBitArray.skipBit();
        if (bit3 && parsableBitArray.readBits(8) > 127) {
            Log.m130i(TAG, "Excessive obu_size");
            return builder.build();
        }
        int bits3 = parsableBitArray.readBits(3);
        parsableBitArray.skipBit();
        if (parsableBitArray.readBit()) {
            Log.m130i(TAG, "Unsupported reduced_still_picture_header");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.m130i(TAG, "Unsupported timing_info_present_flag");
            return builder.build();
        }
        if (parsableBitArray.readBit()) {
            Log.m130i(TAG, "Unsupported initial_display_delay_present_flag");
            return builder.build();
        }
        int bits4 = parsableBitArray.readBits(5);
        boolean z = false;
        for (int i = 0; i <= bits4; i++) {
            parsableBitArray.skipBits(12);
            if (parsableBitArray.readBits(5) > 7) {
                parsableBitArray.skipBit();
            }
        }
        int bits5 = parsableBitArray.readBits(4);
        int bits6 = parsableBitArray.readBits(4);
        parsableBitArray.skipBits(bits5 + 1);
        parsableBitArray.skipBits(bits6 + 1);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(7);
        }
        parsableBitArray.skipBits(7);
        boolean bit4 = parsableBitArray.readBit();
        if (bit4) {
            parsableBitArray.skipBits(2);
        }
        if ((parsableBitArray.readBit() ? 2 : parsableBitArray.readBits(1)) > 0 && !parsableBitArray.readBit()) {
            parsableBitArray.skipBits(1);
        }
        if (bit4) {
            parsableBitArray.skipBits(3);
        }
        parsableBitArray.skipBits(3);
        boolean bit5 = parsableBitArray.readBit();
        if (bits3 == 2 && bit5) {
            parsableBitArray.skipBit();
        }
        if (bits3 != 1 && parsableBitArray.readBit()) {
            z = true;
        }
        if (parsableBitArray.readBit()) {
            int bits7 = parsableBitArray.readBits(8);
            int bits8 = parsableBitArray.readBits(8);
            builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(bits7)).setColorRange(((z || bits7 != 1 || bits8 != 13 || parsableBitArray.readBits(8) != 0) ? parsableBitArray.readBits(1) : 1) != 1 ? 2 : 1).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(bits8));
        }
        return builder.build();
    }

    private static ColorInfo parseApvc(ParsableByteArray parsableByteArray) {
        ColorInfo.Builder builder = new ColorInfo.Builder();
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.getData());
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        parsableBitArray.skipBytes(1);
        int bits = parsableBitArray.readBits(8);
        for (int i = 0; i < bits; i++) {
            parsableBitArray.skipBytes(1);
            int bits2 = parsableBitArray.readBits(8);
            for (int i2 = 0; i2 < bits2; i2++) {
                parsableBitArray.skipBits(6);
                boolean bit = parsableBitArray.readBit();
                parsableBitArray.skipBit();
                parsableBitArray.skipBytes(11);
                parsableBitArray.skipBits(4);
                int bits3 = parsableBitArray.readBits(4) + 8;
                builder.setLumaBitdepth(bits3);
                builder.setChromaBitdepth(bits3);
                parsableBitArray.skipBytes(1);
                if (bit) {
                    int bits4 = parsableBitArray.readBits(8);
                    int bits5 = parsableBitArray.readBits(8);
                    parsableBitArray.skipBytes(1);
                    builder.setColorSpace(ColorInfo.isoColorPrimariesToColorSpace(bits4)).setColorRange(parsableBitArray.readBit() ? 1 : 2).setColorTransfer(ColorInfo.isoTransferCharacteristicsToColorTransfer(bits5));
                }
            }
        }
        return builder.build();
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 16);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String nullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (nullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(nullTerminatedString).build();
            }
        }
    }

    private static Pair<long[], long[]> parseEdts(Mp4Box.ContainerBox containerBox) {
        Mp4Box.LeafBox leafBoxOfType = containerBox.getLeafBoxOfType(Mp4Box.TYPE_elst);
        if (leafBoxOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafBoxOfType.data;
        parsableByteArray.setPosition(8);
        int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
        int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[unsignedIntToInt];
        long[] jArr2 = new long[unsignedIntToInt];
        for (int i = 0; i < unsignedIntToInt; i++) {
            jArr[i] = fullBoxVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = fullBoxVersion == 1 ? parsableByteArray.readLong() : parsableByteArray.readInt();
            if (parsableByteArray.readShort() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            parsableByteArray.skipBytes(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return parsableByteArray.readUnsignedIntToInt() / parsableByteArray.readUnsignedIntToInt();
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x039b A[PHI: r2 r8 r9 r11 r16 r23
      0x039b: PHI (r2v17 java.util.List<byte[]>) = 
      (r2v2 java.util.List<byte[]>)
      (r2v2 java.util.List<byte[]>)
      (r2v16 java.util.List<byte[]>)
      (r2v2 java.util.List<byte[]>)
      (r2v26 java.util.List<byte[]>)
     binds: [B:240:0x0458, B:242:0x0466, B:245:0x0470, B:232:0x0410, B:205:0x036b] A[DONT_GENERATE, DONT_INLINE]
      0x039b: PHI (r8v11 int) = (r8v8 int), (r8v8 int), (r8v8 int), (r8v8 int), (r8v15 int) binds: [B:240:0x0458, B:242:0x0466, B:245:0x0470, B:232:0x0410, B:205:0x036b] A[DONT_GENERATE, DONT_INLINE]
      0x039b: PHI (r9v8 int) = (r9v5 int), (r9v5 int), (r9v5 int), (r9v5 int), (r9v10 int) binds: [B:240:0x0458, B:242:0x0466, B:245:0x0470, B:232:0x0410, B:205:0x036b] A[DONT_GENERATE, DONT_INLINE]
      0x039b: PHI (r11v11 java.lang.String) = 
      (r11v9 java.lang.String)
      (r11v10 java.lang.String)
      (r11v10 java.lang.String)
      (r11v12 java.lang.String)
      (r11v9 java.lang.String)
     binds: [B:240:0x0458, B:242:0x0466, B:245:0x0470, B:232:0x0410, B:205:0x036b] A[DONT_GENERATE, DONT_INLINE]
      0x039b: PHI (r16v3 androidx.media3.extractor.mp4.BoxParser$EsdsData) = 
      (r16v1 androidx.media3.extractor.mp4.BoxParser$EsdsData)
      (r16v2 androidx.media3.extractor.mp4.BoxParser$EsdsData)
      (r16v2 androidx.media3.extractor.mp4.BoxParser$EsdsData)
      (r16v1 androidx.media3.extractor.mp4.BoxParser$EsdsData)
      (r16v1 androidx.media3.extractor.mp4.BoxParser$EsdsData)
     binds: [B:240:0x0458, B:242:0x0466, B:245:0x0470, B:232:0x0410, B:205:0x036b] A[DONT_GENERATE, DONT_INLINE]
      0x039b: PHI (r23v2 int) = (r23v1 int), (r23v1 int), (r23v1 int), (r23v3 int), (r23v4 int) binds: [B:240:0x0458, B:242:0x0466, B:245:0x0470, B:232:0x0410, B:205:0x036b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, boolean z, DrmInitData drmInitData, StsdData stsdData, int i5) throws ParserException {
        int unsignedShort;
        int unsignedShort2;
        int unsignedFixedPoint1616;
        int i6;
        int i7;
        int i8;
        String str2;
        int i9;
        String str3;
        String str4;
        String str5;
        String str6;
        int pcmEncoding;
        int i10;
        String str7;
        int iIntValue = i;
        int i11 = i3;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        parsableByteArray.setPosition(i2 + 16);
        if (z) {
            unsignedShort = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
        } else {
            parsableByteArray.skipBytes(8);
            unsignedShort = 0;
        }
        if (unsignedShort == 0 || unsignedShort == 1) {
            unsignedShort2 = parsableByteArray.readUnsignedShort();
            parsableByteArray.skipBytes(6);
            unsignedFixedPoint1616 = parsableByteArray.readUnsignedFixedPoint1616();
            parsableByteArray.setPosition(parsableByteArray.getPosition() - 4);
            i6 = parsableByteArray.readInt();
            i7 = 2;
            if (unsignedShort == 1) {
                parsableByteArray.skipBytes(16);
            }
            i8 = -1;
        } else {
            if (unsignedShort != 2) {
                return;
            }
            parsableByteArray.skipBytes(16);
            unsignedFixedPoint1616 = (int) Math.round(parsableByteArray.readDouble());
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            parsableByteArray.skipBytes(4);
            int unsignedIntToInt2 = parsableByteArray.readUnsignedIntToInt();
            int unsignedIntToInt3 = parsableByteArray.readUnsignedIntToInt();
            boolean z2 = (unsignedIntToInt3 & 1) != 0;
            boolean z3 = (unsignedIntToInt3 & 2) != 0;
            if (!z2) {
                i8 = unsignedIntToInt2 == 8 ? 3 : unsignedIntToInt2 == 16 ? z3 ? 268435456 : 2 : unsignedIntToInt2 == 24 ? z3 ? C2181C.ENCODING_PCM_24BIT_BIG_ENDIAN : 21 : unsignedIntToInt2 == 32 ? z3 ? C2181C.ENCODING_PCM_32BIT_BIG_ENDIAN : 22 : -1;
                parsableByteArray.skipBytes(8);
                unsignedShort2 = unsignedIntToInt;
                i7 = 2;
                i6 = 0;
            } else {
                if (!z3 && unsignedIntToInt2 == 32) {
                    i8 = 4;
                }
                parsableByteArray.skipBytes(8);
                unsignedShort2 = unsignedIntToInt;
                i7 = 2;
                i6 = 0;
            }
        }
        if (iIntValue == 1767992678) {
            unsignedFixedPoint1616 = -1;
            unsignedShort2 = -1;
        } else {
            if (iIntValue != 1935764850) {
                unsignedFixedPoint1616 = iIntValue == 1935767394 ? 16000 : 8000;
            }
            unsignedShort2 = 1;
        }
        int position = parsableByteArray.getPosition();
        if (iIntValue == 1701733217) {
            Pair<Integer, TrackEncryptionBox> sampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray, i2, i11);
            if (sampleEntryEncryptionData != null) {
                iIntValue = ((Integer) sampleEntryEncryptionData.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((TrackEncryptionBox) sampleEntryEncryptionData.second).schemeType);
                stsdData.trackEncryptionBoxes[i5] = (TrackEncryptionBox) sampleEntryEncryptionData.second;
            }
            parsableByteArray.setPosition(position);
        }
        String str8 = MimeTypes.AUDIO_MPEGH_MHM1;
        if (iIntValue == 1633889587) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (iIntValue == 1700998451) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (iIntValue == 1633889588) {
            str2 = MimeTypes.AUDIO_AC4;
        } else if (iIntValue == 1685353315) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (iIntValue == 1685353317) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (iIntValue == 1685353336) {
            str2 = MimeTypes.AUDIO_DTS_X;
        } else if (iIntValue == 1935764850) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else if (iIntValue == 1935767394) {
            str2 = MimeTypes.AUDIO_AMR_WB;
        } else {
            if (iIntValue != 1936684916) {
                if (iIntValue == 1953984371) {
                    str3 = MimeTypes.AUDIO_RAW;
                    i9 = 268435456;
                } else if (iIntValue == 1819304813) {
                    i9 = i8 == -1 ? i7 : i8;
                    str3 = MimeTypes.AUDIO_RAW;
                } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                    str2 = MimeTypes.AUDIO_MPEG;
                } else if (iIntValue == 1835557169) {
                    str2 = MimeTypes.AUDIO_MPEGH_MHA1;
                } else if (iIntValue == 1835560241) {
                    i9 = i8;
                    str3 = MimeTypes.AUDIO_MPEGH_MHM1;
                } else if (iIntValue == 1634492771) {
                    str2 = MimeTypes.AUDIO_ALAC;
                } else if (iIntValue == 1634492791) {
                    str2 = MimeTypes.AUDIO_ALAW;
                } else if (iIntValue == 1970037111) {
                    str2 = MimeTypes.AUDIO_MLAW;
                } else if (iIntValue == 1332770163) {
                    str2 = MimeTypes.AUDIO_OPUS;
                } else if (iIntValue == 1716281667) {
                    str2 = MimeTypes.AUDIO_FLAC;
                } else if (iIntValue == 1835823201) {
                    str2 = MimeTypes.AUDIO_TRUEHD;
                } else if (iIntValue == 1767992678) {
                    str2 = MimeTypes.AUDIO_IAMF;
                } else {
                    i9 = i8;
                    str3 = null;
                }
            }
            int pcmEncoding2 = i9;
            List<byte[]> vorbisCsdFromEsdsInitializationData = null;
            String str9 = null;
            EsdsData esdsFromParent = null;
            BtrtData btrtFromParent = null;
            while (position - i2 < i11) {
                parsableByteArray.setPosition(position);
                int i12 = parsableByteArray.readInt();
                String str10 = str9;
                ExtractorUtil.checkContainerInput(i12 > 0, "childAtomSize must be positive");
                int i13 = parsableByteArray.readInt();
                if (i13 == 1835557187) {
                    parsableByteArray.setPosition(position + 8);
                    parsableByteArray.skipBytes(1);
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    parsableByteArray.skipBytes(1);
                    if (Objects.equals(str3, str8)) {
                        str7 = String.format("mhm1.%02X", Integer.valueOf(unsignedByte));
                    } else {
                        str7 = String.format("mha1.%02X", Integer.valueOf(unsignedByte));
                    }
                    String str11 = str7;
                    int unsignedShort3 = parsableByteArray.readUnsignedShort();
                    str10 = str11;
                    byte[] bArr = new byte[unsignedShort3];
                    str4 = str8;
                    parsableByteArray.readBytes(bArr, 0, unsignedShort3);
                    if (vorbisCsdFromEsdsInitializationData == null) {
                        vorbisCsdFromEsdsInitializationData = ImmutableList.m767of(bArr);
                    } else {
                        vorbisCsdFromEsdsInitializationData = ImmutableList.m768of(bArr, vorbisCsdFromEsdsInitializationData.get(0));
                    }
                } else {
                    str4 = str8;
                    if (i13 == 1835557200) {
                        parsableByteArray.setPosition(position + 8);
                        int unsignedByte2 = parsableByteArray.readUnsignedByte();
                        if (unsignedByte2 > 0) {
                            byte[] bArr2 = new byte[unsignedByte2];
                            parsableByteArray.readBytes(bArr2, 0, unsignedByte2);
                            if (vorbisCsdFromEsdsInitializationData == null) {
                                vorbisCsdFromEsdsInitializationData = ImmutableList.m767of(bArr2);
                            } else {
                                vorbisCsdFromEsdsInitializationData = ImmutableList.m768of(vorbisCsdFromEsdsInitializationData.get(0), bArr2);
                            }
                        }
                    } else {
                        if (i13 == 1702061171 || (z && i13 == 2002876005)) {
                            int iFindBoxPosition = i13 == 1702061171 ? position : findBoxPosition(parsableByteArray, Mp4Box.TYPE_esds, position, i12);
                            if (iFindBoxPosition != -1) {
                                esdsFromParent = parseEsdsFromParent(parsableByteArray, iFindBoxPosition);
                                str3 = esdsFromParent.mimeType;
                                byte[] bArr3 = esdsFromParent.initializationData;
                                if (bArr3 == null) {
                                    str6 = str10;
                                } else if (MimeTypes.AUDIO_VORBIS.equals(str3)) {
                                    vorbisCsdFromEsdsInitializationData = VorbisUtil.parseVorbisCsdFromEsdsInitializationData(bArr3);
                                    str6 = str10;
                                } else {
                                    if (MimeTypes.AUDIO_AAC.equals(str3)) {
                                        AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArr3);
                                        unsignedFixedPoint1616 = audioSpecificConfig.sampleRateHz;
                                        unsignedShort2 = audioSpecificConfig.channelCount;
                                        str5 = audioSpecificConfig.codecs;
                                    } else {
                                        str5 = str10;
                                    }
                                    ImmutableList immutableListM767of = ImmutableList.m767of(bArr3);
                                    str6 = str5;
                                    vorbisCsdFromEsdsInitializationData = immutableListM767of;
                                }
                            }
                        } else if (i13 == 1651798644) {
                            btrtFromParent = parseBtrtFromParent(parsableByteArray, position);
                        } else {
                            if (i13 == 1684103987) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                            } else if (i13 == 1684366131) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                            } else if (i13 == 1684103988) {
                                parsableByteArray.setPosition(position + 8);
                                stsdData.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray, Integer.toString(i4), str, drmInitDataCopyWithSchemeType);
                            } else if (i13 == 1684892784) {
                                if (i6 <= 0) {
                                    throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + i6, null);
                                }
                                str6 = str10;
                                unsignedFixedPoint1616 = i6;
                                unsignedShort2 = i7;
                            } else if (i13 == 1684305011 || i13 == 1969517683) {
                                stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str3).setChannelCount(unsignedShort2).setSampleRate(unsignedFixedPoint1616).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str).build();
                                str6 = str10;
                            } else if (i13 == 1682927731) {
                                int i14 = i12 - 8;
                                byte[] bArr4 = opusMagic;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length + i14);
                                parsableByteArray.setPosition(position + 8);
                                parsableByteArray.readBytes(bArrCopyOf, bArr4.length, i14);
                                vorbisCsdFromEsdsInitializationData = OpusUtil.buildInitializationData(bArrCopyOf);
                            } else if (i13 == 1684425825) {
                                byte[] bArr5 = new byte[i12 - 8];
                                bArr5[0] = 102;
                                bArr5[1] = 76;
                                bArr5[i7] = 97;
                                bArr5[3] = 67;
                                parsableByteArray.setPosition(position + 12);
                                parsableByteArray.readBytes(bArr5, 4, i12 - 12);
                                vorbisCsdFromEsdsInitializationData = ImmutableList.m767of(bArr5);
                            } else {
                                if (i13 == 1634492771) {
                                    int i15 = i12 - 12;
                                    byte[] bArr6 = new byte[i15];
                                    parsableByteArray.setPosition(position + 12);
                                    parsableByteArray.readBytes(bArr6, 0, i15);
                                    int[] alacAudioSpecificConfig = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(bArr6);
                                    int i16 = alacAudioSpecificConfig[0];
                                    unsignedShort2 = alacAudioSpecificConfig[1];
                                    unsignedFixedPoint1616 = i16;
                                    pcmEncoding2 = Util.getPcmEncoding(alacAudioSpecificConfig[i7]);
                                    vorbisCsdFromEsdsInitializationData = ImmutableList.m767of(bArr6);
                                } else if (i13 == 1767990114) {
                                    parsableByteArray.setPosition(position + 9);
                                    int unsignedLeb128ToInt = parsableByteArray.readUnsignedLeb128ToInt();
                                    byte[] bArr7 = new byte[unsignedLeb128ToInt];
                                    parsableByteArray.readBytes(bArr7, 0, unsignedLeb128ToInt);
                                    String strBuildIamfCodecString = CodecSpecificDataUtil.buildIamfCodecString(bArr7);
                                    ImmutableList immutableListM767of2 = ImmutableList.m767of(bArr7);
                                    str6 = strBuildIamfCodecString;
                                    vorbisCsdFromEsdsInitializationData = immutableListM767of2;
                                } else if (i13 == 1885564227) {
                                    parsableByteArray.setPosition(position + 12);
                                    ByteOrder byteOrder = (parsableByteArray.readUnsignedByte() & 1) != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                                    if (iIntValue == 1768973165) {
                                        pcmEncoding = Util.getPcmEncoding(unsignedByte3, byteOrder);
                                        i10 = -1;
                                    } else {
                                        pcmEncoding = (iIntValue == 1718641517 && unsignedByte3 == 32 && byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) ? 4 : pcmEncoding2;
                                        i10 = -1;
                                    }
                                    pcmEncoding2 = pcmEncoding;
                                    if (pcmEncoding != i10) {
                                        str3 = MimeTypes.AUDIO_RAW;
                                    }
                                }
                                str6 = str10;
                            }
                            str6 = str10;
                        }
                        position += i12;
                        str8 = str4;
                        str9 = str6;
                        i11 = i3;
                    }
                }
                str6 = str10;
                position += i12;
                str8 = str4;
                str9 = str6;
                i11 = i3;
            }
            String str12 = str9;
            if (stsdData.format == null || str3 == null) {
            }
            Format.Builder language = new Format.Builder().setId(i4).setSampleMimeType(str3).setCodecs(str12).setChannelCount(unsignedShort2).setSampleRate(unsignedFixedPoint1616).setPcmEncoding(pcmEncoding2).setInitializationData(vorbisCsdFromEsdsInitializationData).setDrmInitData(drmInitDataCopyWithSchemeType).setLanguage(str);
            if (esdsFromParent != null) {
                language.setAverageBitrate(Ints.saturatedCast(esdsFromParent.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsFromParent.peakBitrate));
            } else if (btrtFromParent != null) {
                language.setAverageBitrate(Ints.saturatedCast(btrtFromParent.avgBitrate)).setPeakBitrate(Ints.saturatedCast(btrtFromParent.maxBitrate));
            }
            stsdData.format = language.build();
            return;
        }
        String str13 = str2;
        i9 = i8;
        str3 = str13;
        int pcmEncoding22 = i9;
        List<byte[]> vorbisCsdFromEsdsInitializationData2 = null;
        String str92 = null;
        EsdsData esdsFromParent2 = null;
        BtrtData btrtFromParent2 = null;
        while (position - i2 < i11) {
        }
        String str122 = str92;
        if (stsdData.format == null) {
        }
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i, int i2, int i3) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i2, null);
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int i4 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i4 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i) {
                return position;
            }
            position += i4;
        }
        return -1;
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 12);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        if ((unsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((unsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((unsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, null, -1L, -1L);
        }
        parsableByteArray.skipBytes(4);
        long unsignedInt = parsableByteArray.readUnsignedInt();
        long unsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int expandableClassSize = parseExpandableClassSize(parsableByteArray);
        long j = unsignedInt2;
        byte[] bArr = new byte[expandableClassSize];
        parsableByteArray.readBytes(bArr, 0, expandableClassSize);
        if (j <= 0) {
            j = -1;
        }
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, j, unsignedInt > 0 ? unsignedInt : -1L);
    }

    private static BtrtData parseBtrtFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        parsableByteArray.skipBytes(4);
        return new BtrtData(parsableByteArray.readUnsignedInt(), parsableByteArray.readUnsignedInt());
    }

    static VexuData parseVideoExtendedUsageBox(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int position = parsableByteArray.getPosition();
        EyesData stereoViewBox = null;
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1702454643) {
                stereoViewBox = parseStereoViewBox(parsableByteArray, position, i3);
            }
            position += i3;
        }
        if (stereoViewBox == null) {
            return null;
        }
        return new VexuData(stereoViewBox);
    }

    private static EyesData parseStereoViewBox(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1937011305) {
                parsableByteArray.skipBytes(4);
                int unsignedByte = parsableByteArray.readUnsignedByte();
                return new EyesData(new StriData((unsignedByte & 1) == 1, (unsignedByte & 2) == 2, (unsignedByte & 8) == 8));
            }
            position += i3;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Pair<Integer, TrackEncryptionBox> commonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int i3 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(i3 > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (commonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, i3)) != null) {
                return commonEncryptionSinfFromParent;
            }
            position += i3;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        int i3 = i + 8;
        int i4 = -1;
        int i5 = 0;
        String string = null;
        Integer numValueOf = null;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i6 = parsableByteArray.readInt();
            int i7 = parsableByteArray.readInt();
            if (i7 == 1718775137) {
                numValueOf = Integer.valueOf(parsableByteArray.readInt());
            } else if (i7 == 1935894637) {
                parsableByteArray.skipBytes(4);
                string = parsableByteArray.readString(4);
            } else if (i7 == 1935894633) {
                i4 = i3;
                i5 = i6;
            }
            i3 += i6;
        }
        if (!C2181C.CENC_TYPE_cenc.equals(string) && !C2181C.CENC_TYPE_cbc1.equals(string) && !C2181C.CENC_TYPE_cens.equals(string) && !C2181C.CENC_TYPE_cbcs.equals(string)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(numValueOf != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox schiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, string);
        ExtractorUtil.checkContainerInput(schiFromParent != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (TrackEncryptionBox) Util.castNonNull(schiFromParent));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int i6 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int fullBoxVersion = parseFullBoxVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (fullBoxVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int unsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = unsignedByte & 15;
                    i4 = (unsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int unsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && unsignedByte2 == 0) {
                    int unsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[unsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, unsignedByte3);
                }
                return new TrackEncryptionBox(z, str, unsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += i6;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int i4 = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, i4 + i3);
            }
            i3 += i4;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int unsignedByte = parsableByteArray.readUnsignedByte();
        int i = unsignedByte & 127;
        while ((unsignedByte & 128) == 128) {
            unsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (unsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[Util.constrainValue(4, 0, length)] && jArr[Util.constrainValue(jArr.length - 4, 0, length)] < j3 && j3 <= j + 2;
    }

    private BoxParser() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long unsignedInt;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                unsignedInt = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                unsignedInt = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = unsignedInt;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        private final int alternateGroup;
        private final long duration;
        private final int height;

        /* JADX INFO: renamed from: id */
        private final int f362id;
        private final int rotationDegrees;
        private final int width;

        public TkhdData(int i, long j, int i2, int i3, int i4, int i5) {
            this.f362id = i;
            this.duration = j;
            this.alternateGroup = i2;
            this.rotationDegrees = i3;
            this.width = i4;
            this.height = i5;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    private static final class EsdsData {
        private final long bitrate;
        private final byte[] initializationData;
        private final String mimeType;
        private final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j, long j2) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j;
            this.peakBitrate = j2;
        }
    }

    private static final class BtrtData {
        private final long avgBitrate;
        private final long maxBitrate;

        public BtrtData(long j, long j2) {
            this.avgBitrate = j;
            this.maxBitrate = j2;
        }
    }

    private static final class StriData {
        private final boolean eyeViewsReversed;
        private final boolean hasLeftEyeView;
        private final boolean hasRightEyeView;

        public StriData(boolean z, boolean z2, boolean z3) {
            this.hasLeftEyeView = z;
            this.hasRightEyeView = z2;
            this.eyeViewsReversed = z3;
        }
    }

    private static final class EyesData {
        private final StriData striData;

        public EyesData(StriData striData) {
            this.striData = striData;
        }
    }

    private static final class MdhdData {
        private final String language;
        private final long mediaDurationUs;
        private final long timescale;

        public MdhdData(long j, long j2, String str) {
            this.timescale = j;
            this.mediaDurationUs = j2;
            this.language = str;
        }
    }

    static final class VexuData {
        private final EyesData eyesData;

        public VexuData(EyesData eyesData) {
            this.eyesData = eyesData;
        }

        public boolean hasBothEyeViews() {
            EyesData eyesData = this.eyesData;
            return eyesData != null && eyesData.striData.hasLeftEyeView && this.eyesData.striData.hasRightEyeView;
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Mp4Box.LeafBox leafBox, Format format) {
            ParsableByteArray parsableByteArray = leafBox.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int unsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (unsignedIntToInt % pcmFrameSize != 0) {
                    Log.m132w(BoxParser.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + unsignedIntToInt);
                    unsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = unsignedIntToInt == 0 ? -1 : unsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getFixedSampleSize() {
            return -1;
        }

        public Stz2SampleSizeBox(Mp4Box.LeafBox leafBox) {
            ParsableByteArray parsableByteArray = leafBox.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override // androidx.media3.extractor.mp4.BoxParser.SampleSizeBox
        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 == 0) {
                int unsignedByte = this.data.readUnsignedByte();
                this.currentByte = unsignedByte;
                return (unsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
            }
            return this.currentByte & 15;
        }
    }
}
