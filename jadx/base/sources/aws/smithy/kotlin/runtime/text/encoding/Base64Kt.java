package aws.smithy.kotlin.runtime.text.encoding;

import androidx.media3.extractor.p007ts.PsExtractor;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.encoding.Base64;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Base64.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0005\n\u0002\b\f\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\b*\u00020\b¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\b*\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\t\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\t\u0010\r\u001a\u0011\u0010\u000e\u001a\u00020\b*\u00020\b¢\u0006\u0004\b\u000e\u0010\n\u001a\u0011\u0010\u000f\u001a\u00020\u0004*\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u000e\u001a\u00020\u0004*\u00020\u0004¢\u0006\u0004\b\u000e\u0010\r\u001a\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\u0016\u001a\u00020\u0000*\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u00020\u0000*\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u0014\u0010\u001c\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d\"\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, m1599d2 = {"", "srcLen", "base64EncodedLen", "(I)I", "", "encoded", "base64DecodedLen", "([B)I", "", "encodeBase64", "(Ljava/lang/String;)Ljava/lang/String;", "encodeBase64String", "([B)Ljava/lang/String;", "([B)[B", "decodeBase64", "decodeBase64Bytes", "(Ljava/lang/String;)[B", "", "toBase64", "(I)B", FirebaseAnalytics.Param.INDEX, "mask", "getOrZero", "([BILjava/lang/Integer;)I", "fromBase64", "(B)I", "BASE64_ENCODE_TABLE", "Ljava/lang/String;", "BASE64_PAD_SENTINEL", "I", "", "BASE64_PAD", "C", "", "BASE64_DECODE_TABLE", "[I", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Base64Kt {
    private static final int[] BASE64_DECODE_TABLE;
    private static final String BASE64_ENCODE_TABLE = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static final char BASE64_PAD = '=';
    private static final int BASE64_PAD_SENTINEL = 255;

    static {
        int[] iArr = new int[256];
        int i = 0;
        while (i < 256) {
            iArr[i] = i == 61 ? 255 : StringsKt.indexOf$default((CharSequence) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", (char) i, 0, false, 6, (Object) null);
            i++;
        }
        BASE64_DECODE_TABLE = iArr;
    }

    private static final int base64EncodedLen(int i) {
        return ((i + 2) / 3) * 4;
    }

    private static final int base64DecodedLen(byte[] bArr) {
        int i = 0;
        if (bArr.length == 0) {
            return 0;
        }
        int length = bArr.length;
        if ((length & 3) != 0) {
            throw new IllegalArgumentException("invalid base64 string of length " + length + "; not a multiple of 4");
        }
        if (length >= 2 && bArr[length - 1] == 61 && bArr[length - 2] == 61) {
            i = 2;
        } else if (bArr[length - 1] == 61) {
            i = 1;
        }
        return ((length * 3) / 4) - i;
    }

    public static final String encodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.decodeToString(encodeBase64(StringsKt.encodeToByteArray(str)));
    }

    public static final String encodeBase64String(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return StringsKt.decodeToString(encodeBase64(bArr));
    }

    public static final byte[] encodeBase64(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArr2 = new byte[base64EncodedLen(bArr.length)];
        int length = bArr.length % 3;
        int length2 = (bArr.length + 2) / 3;
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, bArr.length - 1, 3);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                int orZero = getOrZero(bArr, i + 2, 255) | (getOrZero(bArr, i, 255) << 16) | (getOrZero(bArr, i + 1, 255) << 8);
                bArr2[i2] = toBase64((orZero >> 18) & 63);
                bArr2[i2 + 1] = toBase64((orZero >> 12) & 63);
                int i3 = i2 + 3;
                bArr2[i2 + 2] = toBase64((orZero >> 6) & 63);
                i2 += 4;
                bArr2[i3] = toBase64(orZero & 63);
                if (i == progressionLastElement) {
                    break;
                }
                i += 3;
            }
        }
        if (length > 0) {
            int i4 = length2 * 4;
            bArr2[i4 - 1] = Base64.padSymbol;
            if (length == 1) {
                bArr2[i4 - 2] = Base64.padSymbol;
            }
        }
        return bArr2;
    }

    public static final String decodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.decodeToString(decodeBase64Bytes(str));
    }

    public static final byte[] decodeBase64Bytes(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return decodeBase64(StringsKt.encodeToByteArray(str));
    }

    public static final byte[] decodeBase64(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length % 4;
        int i = 0;
        if (length != 0) {
            int i2 = 4 - length;
            byte[] bArr2 = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr2[i3] = Base64.padSymbol;
            }
            bArr = ArraysKt.plus(bArr, bArr2);
        }
        byte[] bArr3 = new byte[base64DecodedLen(bArr)];
        int length2 = (bArr.length / 4) - 1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = 2;
            if (i >= length2) {
                break;
            }
            int i7 = i4 + 3;
            int iFromBase64 = (fromBase64(bArr[i4 + 1]) << 12) | (fromBase64(bArr[i4]) << 18) | (fromBase64(bArr[i4 + 2]) << 6);
            i4 += 4;
            int iFromBase642 = iFromBase64 | (fromBase64(bArr[i7]) & 255);
            while (-1 < i6) {
                bArr3[i5] = (byte) ((iFromBase642 >> (i6 * 8)) & 255);
                i6--;
                i5++;
            }
            i++;
        }
        if (length2 * 3 >= 0) {
            int iFromBase643 = fromBase64(bArr[i4]);
            int iFromBase644 = fromBase64(bArr[i4 + 1]);
            int iFromBase645 = fromBase64(bArr[i4 + 2]);
            int iFromBase646 = fromBase64(bArr[i4 + 3]);
            if (iFromBase643 == 255 || iFromBase644 == 255) {
                throw new IllegalArgumentException("decode base64: invalid padding");
            }
            int i8 = i5 + 1;
            bArr3[i5] = (byte) ((iFromBase643 << 2) | ((iFromBase644 >> 4) & 3));
            if (iFromBase645 != 255) {
                bArr3[i8] = (byte) (((iFromBase644 << 4) & PsExtractor.VIDEO_STREAM_MASK) | ((iFromBase645 >> 2) & 15));
                i8 = i5 + 2;
            }
            if (iFromBase646 != 255) {
                bArr3[i8] = (byte) (iFromBase646 | ((iFromBase645 & 3) << 6));
                return bArr3;
            }
        }
        return bArr3;
    }

    private static final byte toBase64(int i) {
        return (byte) "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(i);
    }

    private static final int getOrZero(byte[] bArr, int i, Integer num) {
        if (i >= bArr.length) {
            return 0;
        }
        int i2 = bArr[i];
        return num != null ? i2 & num.intValue() : i2;
    }

    static /* synthetic */ int getOrZero$default(byte[] bArr, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        return getOrZero(bArr, i, num);
    }

    private static final int fromBase64(byte b) {
        int i = BASE64_DECODE_TABLE[b];
        if (i != -1) {
            return i;
        }
        throw new IllegalArgumentException("decode base64: invalid input byte: " + ((int) b));
    }
}
