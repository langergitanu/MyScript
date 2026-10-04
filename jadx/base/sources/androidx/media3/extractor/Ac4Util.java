package androidx.media3.extractor;

import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.container.OpusUtil;
import androidx.window.core.layout.WindowSizeClass;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class Ac4Util {
    public static final int AC40_SYNCWORD = 44096;
    public static final int AC41_SYNCWORD = 44097;
    private static final int CHANNEL_COUNT_2 = 2;
    private static final int CHANNEL_MODE_22_2 = 15;
    private static final int CHANNEL_MODE_3_0 = 2;
    private static final int CHANNEL_MODE_5_0 = 3;
    private static final int CHANNEL_MODE_5_1 = 4;
    private static final int CHANNEL_MODE_7_0_322 = 9;
    private static final int CHANNEL_MODE_7_0_34 = 5;
    private static final int CHANNEL_MODE_7_0_4 = 11;
    private static final int CHANNEL_MODE_7_0_52 = 7;
    private static final int CHANNEL_MODE_7_1_322 = 10;
    private static final int CHANNEL_MODE_7_1_34 = 6;
    private static final int CHANNEL_MODE_7_1_4 = 12;
    private static final int CHANNEL_MODE_7_1_52 = 8;
    private static final int CHANNEL_MODE_9_0_4 = 13;
    private static final int CHANNEL_MODE_9_1_4 = 14;
    private static final int CHANNEL_MODE_MONO = 0;
    private static final int CHANNEL_MODE_STEREO = 1;
    private static final int CHANNEL_MODE_UNKNOWN = -1;
    public static final int HEADER_SIZE_FOR_PARSER = 16;
    public static final int MAX_RATE_BYTES_PER_SECOND = 336000;
    private static final int[] SAMPLE_COUNT = {PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT, 2000, 1920, 1601, WindowSizeClass.WIDTH_DP_EXTRA_LARGE_LOWER_BOUND, 1001, 1000, 960, 800, 800, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, 400, 400, 2048};
    public static final int SAMPLE_HEADER_SIZE = 7;
    private static final String TAG = "Ac4Util";

    private static int getChannelCountFromChannelMode(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 6;
            case 5:
            case 7:
            case 9:
                return 7;
            case 6:
            case 8:
            case 10:
                return 8;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 24;
            default:
                return -1;
        }
    }

    public static final class SyncFrameInfo {
        public final int bitstreamVersion;
        public final int channelCount;
        public final int frameSize;
        public final int sampleCount;
        public final int sampleRate;

        private SyncFrameInfo(int i, int i2, int i3, int i4, int i5) {
            this.bitstreamVersion = i;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.frameSize = i4;
            this.sampleCount = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Format parseAc4AnnexEFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) throws ParserException {
        int i;
        int i2;
        int adjustedChannelCount;
        boolean bit;
        int i3;
        int bits;
        int bits2;
        int bits3;
        int i4;
        boolean z;
        boolean bit2;
        int i5;
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.reset(parsableByteArray);
        int iBitsLeft = parsableBitArray.bitsLeft();
        int bits4 = parsableBitArray.readBits(3);
        if (bits4 > 1) {
            throw ParserException.createForUnsupportedContainerFeature("Unsupported AC-4 DSI version: " + bits4);
        }
        int bits5 = parsableBitArray.readBits(7);
        int i6 = parsableBitArray.readBit() ? OpusUtil.SAMPLE_RATE : 44100;
        parsableBitArray.skipBits(4);
        int bits6 = parsableBitArray.readBits(9);
        if (bits5 > 1) {
            if (bits4 == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Invalid AC-4 DSI version: " + bits4);
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(16);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(128);
                }
            }
        }
        if (bits4 == 1) {
            if (!skipDsiBitrate(parsableBitArray)) {
                throw ParserException.createForUnsupportedContainerFeature("Invalid AC-4 DSI bitrate.");
            }
            parsableBitArray.byteAlign();
        }
        Ac4Presentation ac4Presentation = new Ac4Presentation();
        for (int i7 = 0; i7 < bits6; i7++) {
            if (bits4 == 0) {
                bit = parsableBitArray.readBit();
                i3 = 8;
                bits = parsableBitArray.readBits(5);
                bits2 = parsableBitArray.readBits(5);
                bits3 = 0;
                i4 = 0;
                z = false;
            } else {
                int bits7 = parsableBitArray.readBits(8);
                bits3 = parsableBitArray.readBits(8);
                i3 = 8;
                if (bits3 == 255) {
                    bits3 += parsableBitArray.readBits(16);
                }
                if (bits7 > 2) {
                    parsableBitArray.skipBits(bits3 * 8);
                } else {
                    int iBitsLeft2 = (iBitsLeft - parsableBitArray.bitsLeft()) / 8;
                    int bits8 = parsableBitArray.readBits(5);
                    bits2 = bits7;
                    bits = bits8;
                    z = bits8 == 31;
                    i4 = iBitsLeft2;
                    bit = false;
                }
            }
            ac4Presentation.version = bits2;
            if (bit || z || bits != 6) {
                ac4Presentation.level = parsableBitArray.readBits(3);
                if (parsableBitArray.readBit()) {
                    parsableBitArray.skipBits(5);
                }
                parsableBitArray.skipBits(2);
                int i8 = 1;
                if (bits4 == 1 && (bits2 == 1 || bits2 == 2)) {
                    parsableBitArray.skipBits(2);
                }
                parsableBitArray.skipBits(5);
                parsableBitArray.skipBits(10);
                if (bits4 == 1) {
                    if (bits2 > 0) {
                        ac4Presentation.isChannelCoded = parsableBitArray.readBit();
                    }
                    if (ac4Presentation.isChannelCoded) {
                        if (bits2 != 1) {
                            i5 = 2;
                            if (bits2 == 2) {
                                int bits9 = parsableBitArray.readBits(5);
                                if (bits9 >= 0 && bits9 <= 15) {
                                    ac4Presentation.channelMode = bits9;
                                }
                                if (bits9 < 11 || bits9 > 14) {
                                    i5 = 2;
                                } else {
                                    ac4Presentation.hasBackChannels = parsableBitArray.readBit();
                                    i5 = 2;
                                    ac4Presentation.topChannelPairs = parsableBitArray.readBits(2);
                                }
                            }
                            parsableBitArray.skipBits(24);
                            i8 = 1;
                        }
                        if (ac4Presentation.isChannelCoded) {
                            adjustedChannelCount = getAdjustedChannelCount(ac4Presentation.channelMode, ac4Presentation.hasBackChannels, ac4Presentation.topChannelPairs);
                        } else if (ac4Presentation.numOfUmxObjects > 0) {
                            int i9 = ac4Presentation.numOfUmxObjects + 1;
                            if (ac4Presentation.level == 4 && i9 == 17) {
                                i9 = 21;
                            }
                            adjustedChannelCount = i9;
                        } else {
                            int i10 = ac4Presentation.level;
                            if (i10 == 0) {
                                i2 = 2;
                            } else if (i10 != 1) {
                                i2 = 2;
                                if (i10 == 2) {
                                    adjustedChannelCount = i;
                                } else if (i10 == 3) {
                                    adjustedChannelCount = 10;
                                } else if (i10 != 4) {
                                    Log.m132w(TAG, "AC-4 level " + ac4Presentation.level + " has not been defined.");
                                } else {
                                    adjustedChannelCount = 12;
                                }
                            } else {
                                adjustedChannelCount = 6;
                            }
                            adjustedChannelCount = i2;
                        }
                        if (adjustedChannelCount <= 0) {
                            throw ParserException.createForUnsupportedContainerFeature("Cannot determine channel count of presentation.");
                        }
                        return new Format.Builder().setId(str).setSampleMimeType(MimeTypes.AUDIO_AC4).setChannelCount(adjustedChannelCount).setSampleRate(i6).setDrmInitData(drmInitData).setLanguage(str2).setCodecs(createCodecsString(bits5, ac4Presentation.version, ac4Presentation.level)).build();
                    }
                    i5 = 2;
                    if (bits2 == i8 || bits2 == i5) {
                        if (parsableBitArray.readBit() && parsableBitArray.readBit()) {
                            parsableBitArray.skipBits(i5);
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray.skipBit();
                            int i11 = i3;
                            int bits10 = parsableBitArray.readBits(i11);
                            int i12 = 0;
                            while (i12 < bits10) {
                                parsableBitArray.skipBits(i11);
                                i12++;
                                i11 = 8;
                            }
                        }
                    }
                }
                if (!bit && !z) {
                    parsableBitArray.skipBit();
                    if (bits == 0 || bits == 1 || bits == 2) {
                        if (bits2 == 0) {
                            for (int i13 = 0; i13 < 2; i13++) {
                                parseDsiSubstream(parsableBitArray, ac4Presentation);
                            }
                        } else {
                            for (int i14 = 0; i14 < 2; i14++) {
                                parseDsiSubstreamGroup(parsableBitArray, ac4Presentation);
                            }
                        }
                    } else if (bits == 3 || bits == 4) {
                        if (bits2 == 0) {
                            for (int i15 = 0; i15 < 3; i15++) {
                                parseDsiSubstream(parsableBitArray, ac4Presentation);
                            }
                        } else {
                            for (int i16 = 0; i16 < 3; i16++) {
                                parseDsiSubstreamGroup(parsableBitArray, ac4Presentation);
                            }
                        }
                    } else if (bits != 5) {
                        int bits11 = parsableBitArray.readBits(7);
                        for (int i17 = 0; i17 < bits11; i17++) {
                            parsableBitArray.skipBits(8);
                        }
                    } else if (bits2 == 0) {
                        parseDsiSubstream(parsableBitArray, ac4Presentation);
                    } else {
                        int bits12 = parsableBitArray.readBits(3);
                        for (int i18 = 0; i18 < bits12 + 2; i18++) {
                            parseDsiSubstreamGroup(parsableBitArray, ac4Presentation);
                        }
                    }
                } else if (bits2 == 0) {
                    parseDsiSubstream(parsableBitArray, ac4Presentation);
                } else {
                    parseDsiSubstreamGroup(parsableBitArray, ac4Presentation);
                }
                parsableBitArray.skipBit();
                bit2 = parsableBitArray.readBit();
            } else {
                bit2 = true;
            }
            if (bit2) {
                int bits13 = parsableBitArray.readBits(7);
                for (int i19 = 0; i19 < bits13; i19++) {
                    parsableBitArray.skipBits(15);
                }
            }
            if (bits2 > 0) {
                if (parsableBitArray.readBit() && !skipDsiBitrate(parsableBitArray)) {
                    throw ParserException.createForUnsupportedContainerFeature("Can't parse bitrate DSI.");
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray.byteAlign();
                    parsableBitArray.skipBytes(parsableBitArray.readBits(16));
                    int bits14 = parsableBitArray.readBits(5);
                    for (int i20 = 0; i20 < bits14; i20++) {
                        parsableBitArray.skipBits(3);
                        parsableBitArray.skipBits(8);
                    }
                }
            }
            i = 8;
            parsableBitArray.byteAlign();
            if (bits4 == 1) {
                int iBitsLeft3 = ((iBitsLeft - parsableBitArray.bitsLeft()) / 8) - i4;
                if (bits3 < iBitsLeft3) {
                    throw ParserException.createForUnsupportedContainerFeature("pres_bytes is smaller than presentation bytes read.");
                }
                parsableBitArray.skipBytes(bits3 - iBitsLeft3);
            }
            if (ac4Presentation.isChannelCoded && ac4Presentation.channelMode == -1) {
                throw ParserException.createForUnsupportedContainerFeature("Can't determine channel mode of presentation " + i7);
            }
            if (ac4Presentation.isChannelCoded) {
            }
            if (adjustedChannelCount <= 0) {
            }
        }
        i = 8;
        if (ac4Presentation.isChannelCoded) {
        }
        if (adjustedChannelCount <= 0) {
        }
    }

    private static void parseDsiSubstream(ParsableBitArray parsableBitArray, Ac4Presentation ac4Presentation) throws ParserException {
        int bits = parsableBitArray.readBits(5);
        parsableBitArray.skipBits(2);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(5);
        }
        if (bits >= 7 && bits <= 10) {
            parsableBitArray.skipBit();
        }
        if (parsableBitArray.readBit()) {
            int bits2 = parsableBitArray.readBits(3);
            if (ac4Presentation.channelMode == -1 && bits >= 0 && bits <= 15 && (bits2 == 0 || bits2 == 1)) {
                ac4Presentation.channelMode = bits;
            }
            if (parsableBitArray.readBit()) {
                skipDsiLanguage(parsableBitArray);
            }
        }
    }

    private static void parseDsiSubstreamGroup(ParsableBitArray parsableBitArray, Ac4Presentation ac4Presentation) throws ParserException {
        parsableBitArray.skipBits(2);
        boolean bit = parsableBitArray.readBit();
        int bits = parsableBitArray.readBits(8);
        for (int i = 0; i < bits; i++) {
            parsableBitArray.skipBits(2);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(5);
            }
            if (bit) {
                parsableBitArray.skipBits(24);
            } else {
                if (parsableBitArray.readBit()) {
                    if (!parsableBitArray.readBit()) {
                        parsableBitArray.skipBits(4);
                    }
                    ac4Presentation.numOfUmxObjects = parsableBitArray.readBits(6) + 1;
                }
                parsableBitArray.skipBits(4);
            }
        }
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(3);
            if (parsableBitArray.readBit()) {
                skipDsiLanguage(parsableBitArray);
            }
        }
    }

    private static void skipDsiLanguage(ParsableBitArray parsableBitArray) throws ParserException {
        int bits = parsableBitArray.readBits(6);
        if (bits < 2 || bits > 42) {
            throw ParserException.createForUnsupportedContainerFeature(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(bits)));
        }
        parsableBitArray.skipBits(bits * 8);
    }

    private static boolean skipDsiBitrate(ParsableBitArray parsableBitArray) {
        if (parsableBitArray.bitsLeft() < 66) {
            return false;
        }
        parsableBitArray.skipBits(66);
        return true;
    }

    private static int getAdjustedChannelCount(int i, boolean z, int i2) {
        int channelCountFromChannelMode = getChannelCountFromChannelMode(i);
        if (i != 11 && i != 12 && i != 13 && i != 14) {
            return channelCountFromChannelMode;
        }
        if (!z) {
            channelCountFromChannelMode -= 2;
        }
        return i2 != 0 ? i2 != 1 ? channelCountFromChannelMode : channelCountFromChannelMode - 2 : channelCountFromChannelMode - 4;
    }

    private static String createCodecsString(int i, int i2, int i3) {
        return Util.formatInvariant("ac-4.%02d.%02d.%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0081, code lost:
    
        if (r11 != 11) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0086, code lost:
    
        if (r11 != 11) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008b, code lost:
    
        if (r11 != 8) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static SyncFrameInfo parseAc4SyncframeInfo(ParsableBitArray parsableBitArray) {
        int i;
        int i2;
        int i3;
        int i4;
        int bits = parsableBitArray.readBits(16);
        int bits2 = parsableBitArray.readBits(16);
        if (bits2 == 65535) {
            bits2 = parsableBitArray.readBits(24);
            i = 7;
        } else {
            i = 4;
        }
        int i5 = bits2 + i;
        if (bits == 44097) {
            i5 += 2;
        }
        int i6 = i5;
        int bits3 = parsableBitArray.readBits(2);
        if (bits3 == 3) {
            bits3 += readVariableBits(parsableBitArray, 2);
        }
        int i7 = bits3;
        int bits4 = parsableBitArray.readBits(10);
        if (parsableBitArray.readBit() && parsableBitArray.readBits(3) > 0) {
            parsableBitArray.skipBits(2);
        }
        int i8 = 44100;
        if (parsableBitArray.readBit()) {
            i2 = 44100;
            i8 = 48000;
        } else {
            i2 = 44100;
        }
        int bits5 = parsableBitArray.readBits(4);
        if (i8 == i2 && bits5 == 13) {
            i3 = SAMPLE_COUNT[bits5];
        } else {
            if (i8 == 48000) {
                int[] iArr = SAMPLE_COUNT;
                if (bits5 < iArr.length) {
                    int i9 = iArr[bits5];
                    int i10 = bits4 % 5;
                    if (i10 == 1) {
                        if (bits5 != 3) {
                        }
                        i3 = i9 + 1;
                    } else if (i10 == 2) {
                        if (bits5 != 8) {
                        }
                        i3 = i9 + 1;
                    } else if (i10 != 3) {
                        if (i10 == 4) {
                            if (bits5 != 3) {
                                if (bits5 != 8) {
                                }
                            }
                            i3 = i9 + 1;
                        }
                        i4 = i9;
                    }
                } else {
                    i3 = 0;
                }
            }
            return new SyncFrameInfo(i7, 2, i8, i6, i4);
        }
        i4 = i3;
        return new SyncFrameInfo(i7, 2, i8, i6, i4);
    }

    public static int parseAc4SyncframeSize(byte[] bArr, int i) {
        int i2 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i3 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i3 == 65535) {
            i3 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i2 = 4;
        }
        if (i == 44097) {
            i2 += 2;
        }
        return i3 + i2;
    }

    public static int parseAc4SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return parseAc4SyncframeInfo(new ParsableBitArray(bArr)).sampleCount;
    }

    public static void getAc4SampleHeader(int i, ParsableByteArray parsableByteArray) {
        parsableByteArray.reset(7);
        byte[] data = parsableByteArray.getData();
        data[0] = -84;
        data[1] = SignedBytes.MAX_POWER_OF_TWO;
        data[2] = -1;
        data[3] = -1;
        data[4] = (byte) ((i >> 16) & 255);
        data[5] = (byte) ((i >> 8) & 255);
        data[6] = (byte) (i & 255);
    }

    private static int readVariableBits(ParsableBitArray parsableBitArray, int i) {
        int i2 = 0;
        while (true) {
            int bits = i2 + parsableBitArray.readBits(i);
            if (!parsableBitArray.readBit()) {
                return bits;
            }
            i2 = (bits + 1) << i;
        }
    }

    private static final class Ac4Presentation {
        public int channelMode;
        public boolean hasBackChannels;
        public boolean isChannelCoded;
        public int level;
        public int numOfUmxObjects;
        public int topChannelPairs;
        public int version;

        private Ac4Presentation() {
            this.isChannelCoded = true;
            this.channelMode = -1;
            this.numOfUmxObjects = -1;
            this.hasBackChannels = true;
            this.topChannelPairs = 2;
            this.version = 1;
            this.level = 0;
        }
    }

    private Ac4Util() {
    }
}
