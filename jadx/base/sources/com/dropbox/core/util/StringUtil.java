package com.dropbox.core.util;

import aws.sdk.kotlin.runtime.config.profile.Literals;
import com.google.common.base.Ascii;
import com.survicate.surveys.TextRecallingManager;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public class StringUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String Base64Digits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    public static final String UrlSafeBase64Digits = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    public static final Charset UTF8 = Charset.forName("UTF-8");
    private static final char[] HexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static char hexDigit(int i) {
        return HexDigits[i];
    }

    public static String utf8ToString(byte[] bArr) throws CharacterCodingException {
        return utf8ToString(bArr, 0, bArr.length);
    }

    public static String utf8ToString(byte[] bArr, int i, int i2) throws CharacterCodingException {
        return UTF8.newDecoder().decode(ByteBuffer.wrap(bArr, i, i2)).toString();
    }

    public static byte[] stringToUtf8(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw LangUtil.mkAssert("UTF-8 should always be supported", e);
        }
    }

    public static String javaQuotedLiteral(String str) {
        StringBuilder sb = new StringBuilder(str.length() * 2);
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 0) {
                sb.append("\\000");
            } else if (cCharAt == '\r') {
                sb.append("\\t");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt == '\t') {
                sb.append("\\r");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt >= ' ' && cCharAt <= '~') {
                sb.append(cCharAt);
            } else {
                sb.append("\\u");
                sb.append(hexDigit((cCharAt >> '\f') & 15));
                sb.append(hexDigit((cCharAt >> '\b') & 15));
                sb.append(hexDigit((cCharAt >> 4) & 15));
                sb.append(hexDigit(cCharAt & 15));
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    public static String javaQuotedLiterals(String[] strArr) {
        return javaQuotedLiterals(Arrays.asList(strArr));
    }

    public static String javaQuotedLiterals(Iterable<String> iterable) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        for (String str2 : iterable) {
            sb.append(str);
            sb.append(javaQuotedLiteral(str2));
            str = TextRecallingManager.ANSWER_SEPARATOR;
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: jq */
    public static String m531jq(String str) {
        return javaQuotedLiteral(str);
    }

    /* JADX INFO: renamed from: jq */
    public static String m532jq(String[] strArr) {
        return javaQuotedLiterals(strArr);
    }

    /* JADX INFO: renamed from: jq */
    public static String m530jq(Iterable<String> iterable) {
        return javaQuotedLiterals(iterable);
    }

    public static String binaryToHex(byte[] bArr) {
        return binaryToHex(bArr, 0, bArr.length);
    }

    public static String binaryToHex(byte[] bArr, int i, int i2) {
        int i3 = i + i2;
        char[] cArr = new char[i2 * 2];
        int i4 = 0;
        while (i < i3) {
            byte b = bArr[i];
            int i5 = i4 + 1;
            cArr[i4] = hexDigit((b >>> 4) & 15);
            i4 += 2;
            cArr[i5] = hexDigit(b & Ascii.f990SI);
            i++;
        }
        return new String(cArr);
    }

    public static boolean secureStringEquals(String str, String str2) {
        if (str.length() != str2.length()) {
            return false;
        }
        int iCharAt = 0;
        for (int i = 0; i < str.length(); i++) {
            iCharAt |= str.charAt(i) ^ str2.charAt(i);
        }
        return iCharAt == 0;
    }

    public static String base64Encode(byte[] bArr) {
        return base64EncodeGeneric(Base64Digits, bArr);
    }

    public static String urlSafeBase64Encode(byte[] bArr) {
        return base64EncodeGeneric(UrlSafeBase64Digits, bArr);
    }

    public static String base64EncodeGeneric(String str, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("'data' can't be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("'digits' can't be null");
        }
        if (str.length() != 64) {
            throw new IllegalArgumentException("'digits' must be 64 characters long: " + m531jq(str));
        }
        StringBuilder sb = new StringBuilder(((bArr.length + 2) / 3) * 4);
        int i = 0;
        while (i + 3 <= bArr.length) {
            byte b = bArr[i];
            int i2 = i + 2;
            byte b2 = bArr[i + 1];
            i += 3;
            byte b3 = bArr[i2];
            int i3 = (b & 255) >>> 2;
            int i4 = ((b & 3) << 4) | ((b2 & 255) >>> 4);
            int i5 = ((b2 & Ascii.f990SI) << 2) | ((b3 & 255) >>> 6);
            int i6 = b3 & Utf8.REPLACEMENT_BYTE;
            sb.append(str.charAt(i3));
            sb.append(str.charAt(i4));
            sb.append(str.charAt(i5));
            sb.append(str.charAt(i6));
        }
        int length = bArr.length - i;
        if (length != 0) {
            if (length == 1) {
                byte b4 = bArr[i];
                sb.append(str.charAt((b4 & 255) >>> 2));
                sb.append(str.charAt((b4 & 3) << 4));
                sb.append("==");
            } else if (length == 2) {
                int i7 = i + 1;
                byte b5 = bArr[i];
                byte b6 = bArr[i7];
                int i8 = (b5 & 255) >>> 2;
                int i9 = ((b5 & 3) << 4) | ((b6 & 255) >>> 4);
                int i10 = (b6 & Ascii.f990SI) << 2;
                sb.append(str.charAt(i8));
                sb.append(str.charAt(i9));
                sb.append(str.charAt(i10));
                sb.append(Literals.PROPERTY_SPLITTER);
            } else {
                throw new AssertionError("data.length: " + bArr.length + ", i: " + i);
            }
        }
        return sb.toString();
    }

    public static String join(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str2 : collection) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append(str2);
            i++;
        }
        return sb.toString();
    }
}
