package coil.decode;

import coil.util.SvgUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import okhttp3.internal.p041ws.RealWebSocket;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: DecodeUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"SVG_TAG", "Lokio/ByteString;", "LEFT_ANGLE_BRACKET", "isSvg", "", "Lcoil/decode/DecodeUtils;", FirebaseAnalytics.Param.SOURCE, "Lokio/BufferedSource;", "coil-svg_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SvgDecodeUtils {
    private static final ByteString SVG_TAG = ByteString.INSTANCE.encodeUtf8("<svg");
    private static final ByteString LEFT_ANGLE_BRACKET = ByteString.INSTANCE.encodeUtf8("<");

    public static final boolean isSvg(DecodeUtils decodeUtils, BufferedSource bufferedSource) {
        return bufferedSource.rangeEquals(0L, LEFT_ANGLE_BRACKET) && SvgUtils.indexOf(bufferedSource, SVG_TAG, 0L, RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) != -1;
    }
}
