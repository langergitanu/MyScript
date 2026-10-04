package coil.util;

import android.graphics.Bitmap;
import coil.size.Dimension;
import coil.size.Scale;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: renamed from: coil.util.-SvgUtils, reason: invalid class name */
/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u000e\u0010\u000b\u001a\u00020\t*\u0004\u0018\u00010\tH\u0000\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\n¨\u0006\u0011"}, m1599d2 = {"indexOf", "", "Lokio/BufferedSource;", "bytes", "Lokio/ByteString;", "fromIndex", "toIndex", "isHardware", "", "Landroid/graphics/Bitmap$Config;", "(Landroid/graphics/Bitmap$Config;)Z", "toSoftware", "toPx", "", "Lcoil/size/Dimension;", "scale", "Lcoil/size/Scale;", "coil-svg_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SvgUtils {

    /* JADX INFO: renamed from: coil.util.-SvgUtils$WhenMappings */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 0, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Scale.values().length];
            try {
                iArr[Scale.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Scale.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long indexOf(BufferedSource bufferedSource, ByteString byteString, long j, long j2) throws IOException {
        if (byteString.size() <= 0) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        byte b = byteString.getByte(0);
        long size = j2 - ((long) byteString.size());
        long j3 = j;
        while (j3 < size) {
            BufferedSource bufferedSource2 = bufferedSource;
            long jIndexOf = bufferedSource2.indexOf(b, j3, size);
            if (jIndexOf == -1 || bufferedSource2.rangeEquals(jIndexOf, byteString)) {
                return jIndexOf;
            }
            j3 = jIndexOf + 1;
            bufferedSource = bufferedSource2;
        }
        return -1L;
    }

    public static final boolean isHardware(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }

    public static final Bitmap.Config toSoftware(Bitmap.Config config) {
        return (config == null || isHardware(config)) ? Bitmap.Config.ARGB_8888 : config;
    }

    public static final float toPx(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).px;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[scale.ordinal()];
        if (i == 1) {
            return Float.MIN_VALUE;
        }
        if (i == 2) {
            return Float.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
