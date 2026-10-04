package coil.decode;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: DecodeUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u000f\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0010\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0011\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u0012\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m1599d2 = {"GIF_HEADER_87A", "Lokio/ByteString;", "GIF_HEADER_89A", "WEBP_HEADER_RIFF", "WEBP_HEADER_WEBP", "WEBP_HEADER_VPX8", "HEIF_HEADER_FTYP", "HEIF_HEADER_MSF1", "HEIF_HEADER_HEVC", "HEIF_HEADER_HEVX", "isGif", "", "Lcoil/decode/DecodeUtils;", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSource;", "isWebP", "isAnimatedWebP", "isHeif", "isAnimatedHeif", "coil-gif_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class GifDecodeUtils {
    private static final ByteString GIF_HEADER_87A = ByteString.INSTANCE.encodeUtf8("GIF87a");
    private static final ByteString GIF_HEADER_89A = ByteString.INSTANCE.encodeUtf8("GIF89a");
    private static final ByteString WEBP_HEADER_RIFF = ByteString.INSTANCE.encodeUtf8("RIFF");
    private static final ByteString WEBP_HEADER_WEBP = ByteString.INSTANCE.encodeUtf8("WEBP");
    private static final ByteString WEBP_HEADER_VPX8 = ByteString.INSTANCE.encodeUtf8("VP8X");
    private static final ByteString HEIF_HEADER_FTYP = ByteString.INSTANCE.encodeUtf8("ftyp");
    private static final ByteString HEIF_HEADER_MSF1 = ByteString.INSTANCE.encodeUtf8("msf1");
    private static final ByteString HEIF_HEADER_HEVC = ByteString.INSTANCE.encodeUtf8("hevc");
    private static final ByteString HEIF_HEADER_HEVX = ByteString.INSTANCE.encodeUtf8("hevx");

    public static final boolean isGif(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(0L, GIF_HEADER_89A) || bufferedSource.rangeEquals(0L, GIF_HEADER_87A);
    }

    public static final boolean isWebP(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(0L, WEBP_HEADER_RIFF) && bufferedSource.rangeEquals(8L, WEBP_HEADER_WEBP);
    }

    public static final boolean isAnimatedWebP(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return isWebP(decodeUtils, bufferedSource) && bufferedSource.rangeEquals(12L, WEBP_HEADER_VPX8) && bufferedSource.request(17L) && ((byte) (bufferedSource.getBuffer().getByte(16L) & 2)) > 0;
    }

    public static final boolean isHeif(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(4L, HEIF_HEADER_FTYP);
    }

    public static final boolean isAnimatedHeif(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        if (isHeif(decodeUtils, bufferedSource)) {
            return bufferedSource.rangeEquals(8L, HEIF_HEADER_MSF1) || bufferedSource.rangeEquals(8L, HEIF_HEADER_HEVC) || bufferedSource.rangeEquals(8L, HEIF_HEADER_HEVX);
        }
        return false;
    }
}
