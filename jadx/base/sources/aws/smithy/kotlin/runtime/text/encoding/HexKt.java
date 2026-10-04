package aws.smithy.kotlin.runtime.text.encoding;

import androidx.media3.exoplayer.upstream.CmcdData;
import aws.smithy.kotlin.runtime.InternalApi;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: Hex.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0019\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0002*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0000*\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\b\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"", "bytes", "", "encodeHex", "([B)Ljava/lang/String;", "encodeToHex", CmcdData.STREAMING_FORMAT_SS, "decodeHex", "(Ljava/lang/String;)[B", "decodeHexBytes", "", "hexChars", "[C", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class HexKt {
    private static final char[] hexChars;

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        hexChars = charArray;
    }

    @InternalApi
    public static final String encodeHex(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            char[] cArr = hexChars;
            sb.append(cArr[(b & 255) >> 4]);
            sb.append(cArr[b & Ascii.f990SI]);
        }
        return sb.toString();
    }

    @InternalApi
    public static final String encodeToHex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return encodeHex(bArr);
    }

    @InternalApi
    public static final byte[] decodeHex(String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        int i = 1;
        byte[] bArr = new byte[(s.length() + 1) / 2];
        int i2 = 0;
        if (s.length() % 2 == 1) {
            bArr[0] = (byte) CharsKt.digitToInt(s.charAt(0), 16);
            i2 = 1;
        } else {
            i = 0;
        }
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(i, s.length()), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                int i3 = i2 + 1;
                bArr[i2] = (byte) ((CharsKt.digitToInt(s.charAt(first), 16) << 4) | CharsKt.digitToInt(s.charAt(first + 1), 16));
                if (first == last) {
                    break;
                }
                first += step;
                i2 = i3;
            }
        }
        return bArr;
    }

    @InternalApi
    public static final byte[] decodeHexBytes(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return decodeHex(str);
    }
}
