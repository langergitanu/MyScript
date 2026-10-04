package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.Mp4Box;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.SniffFailure;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class Sniffer {
    public static final int BRAND_HEIC = 1751476579;
    public static final int BRAND_QUICKTIME = 1903435808;
    private static final int[] COMPATIBLE_BRANDS = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Mp4Box.TYPE_avc1, Mp4Box.TYPE_hvc1, Mp4Box.TYPE_hev1, Mp4Box.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};
    private static final int SEARCH_LENGTH = 4096;

    public static SniffFailure sniffFragmented(ExtractorInput extractorInput) throws IOException {
        return sniffInternal(extractorInput, true, false);
    }

    public static SniffFailure sniffUnfragmented(ExtractorInput extractorInput, boolean z) throws IOException {
        return sniffInternal(extractorInput, false, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static SniffFailure sniffInternal(ExtractorInput extractorInput, boolean z, boolean z2) throws IOException {
        SniffFailure sniffFailure;
        int i;
        long j;
        int i2;
        int i3;
        int i4;
        long j2;
        int i5;
        int[] iArr;
        long length = extractorInput.getLength();
        long j3 = -1;
        int i6 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        long j4 = 4096;
        if (i6 != 0 && length <= 4096) {
            j4 = length;
        }
        int i7 = (int) j4;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i8 = 0;
        int i9 = 0;
        boolean z3 = false;
        while (i9 < i7) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), i8, 8, true)) {
                break;
            }
            long unsignedInt = parsableByteArray.readUnsignedInt();
            int i10 = parsableByteArray.readInt();
            if (unsignedInt == 1) {
                j = j3;
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                i3 = 16;
                parsableByteArray.setLimit(16);
                unsignedInt = parsableByteArray.readLong();
                i2 = i9;
            } else {
                j = j3;
                if (unsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j) {
                        i2 = i9;
                        unsignedInt = (length2 - extractorInput.getPeekPosition()) + ((long) 8);
                    } else {
                        i2 = i9;
                    }
                    i3 = 8;
                }
            }
            long j5 = unsignedInt;
            long j6 = i3;
            if (j5 < j6) {
                sniffFailure = null;
                if (i10 != 1718773093 || i3 != 8) {
                    return new AtomSizeTooSmallSniffFailure(i10, j5, i3);
                }
                j5 = j6;
            } else {
                sniffFailure = null;
            }
            int i11 = i2 + i3;
            if (i10 == 1836019574 || i10 == 1970628964) {
                i7 += (int) j5;
                i4 = i6;
                if (i6 != 0 && i7 > length) {
                    i7 = (int) length;
                }
                if (i10 == 1836019574) {
                    i9 = i11;
                    i6 = i4;
                    j3 = j;
                    i8 = 0;
                }
            } else {
                i4 = i6;
            }
            if (i10 != 1953653099 && i10 != 1835297121 && i10 != 1835626086) {
                if (i10 != 1836019558 && i10 != 1836475768) {
                    if (i10 == 1835295092) {
                        z3 = true;
                    }
                    if (i10 != 1937007212 || j5 <= 1000000) {
                        j2 = length;
                        if ((((long) i11) + j5) - j6 < i7) {
                            int i12 = (int) (j5 - j6);
                            i9 = i11 + i12;
                            if (i10 != 1718909296) {
                                i5 = 0;
                                if (i12 != 0) {
                                    extractorInput.advancePeekPosition(i12);
                                }
                            } else {
                                if (i12 < 8) {
                                    return new AtomSizeTooSmallSniffFailure(i10, i12, 8);
                                }
                                parsableByteArray.reset(i12);
                                i5 = 0;
                                extractorInput.peekFully(parsableByteArray.getData(), 0, i12);
                                int i13 = parsableByteArray.readInt();
                                if (isCompatibleBrand(i13, z2)) {
                                    z3 = true;
                                }
                                parsableByteArray.skipBytes(4);
                                int iBytesLeft = parsableByteArray.bytesLeft() / 4;
                                if (!z3 && iBytesLeft > 0) {
                                    iArr = new int[iBytesLeft];
                                    int i14 = 0;
                                    while (true) {
                                        if (i14 >= iBytesLeft) {
                                            break;
                                        }
                                        int i15 = parsableByteArray.readInt();
                                        iArr[i14] = i15;
                                        if (isCompatibleBrand(i15, z2)) {
                                            z3 = true;
                                            break;
                                        }
                                        i14++;
                                    }
                                } else {
                                    iArr = sniffFailure;
                                }
                                if (!z3) {
                                    return new UnsupportedBrandsSniffFailure(i13, iArr);
                                }
                            }
                        }
                    }
                    i = 0;
                    break;
                }
                i = 1;
                break;
            }
            j2 = length;
            i5 = 0;
            i9 = i11;
            i8 = i5;
            i6 = i4;
            j3 = j;
            length = j2;
        }
        sniffFailure = null;
        i = i8;
        if (!z3) {
            return NoDeclaredBrandSniffFailure.INSTANCE;
        }
        if (z == i) {
            return sniffFailure;
        }
        if (i != 0) {
            return IncorrectFragmentationSniffFailure.FILE_FRAGMENTED;
        }
        return IncorrectFragmentationSniffFailure.FILE_NOT_FRAGMENTED;
    }

    private static boolean isCompatibleBrand(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : COMPATIBLE_BRANDS) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private Sniffer() {
    }
}
