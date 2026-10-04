package ch.randelshofer.fastdoubleparser;

/* JADX INFO: loaded from: classes4.dex */
public class JsonDoubleParser {
    private static final JsonDoubleBitsFromByteArray BYTE_ARRAY_PARSER = new JsonDoubleBitsFromByteArray();
    private static final JsonDoubleBitsFromCharArray CHAR_ARRAY_PARSER = new JsonDoubleBitsFromCharArray();
    private static final JsonDoubleBitsFromCharSequence CHAR_SEQUENCE_PARSER = new JsonDoubleBitsFromCharSequence();

    private JsonDoubleParser() {
    }

    public static double parseDouble(CharSequence charSequence) throws NumberFormatException {
        return parseDouble(charSequence, 0, charSequence.length());
    }

    public static double parseDouble(CharSequence charSequence, int i, int i2) throws NumberFormatException {
        return Double.longBitsToDouble(CHAR_SEQUENCE_PARSER.parseNumber(charSequence, i, i2));
    }

    public static double parseDouble(byte[] bArr) throws NumberFormatException {
        return parseDouble(bArr, 0, bArr.length);
    }

    public static double parseDouble(byte[] bArr, int i, int i2) throws NumberFormatException {
        return Double.longBitsToDouble(BYTE_ARRAY_PARSER.parseNumber(bArr, i, i2));
    }

    public static double parseDouble(char[] cArr) throws NumberFormatException {
        return parseDouble(cArr, 0, cArr.length);
    }

    public static double parseDouble(char[] cArr, int i, int i2) throws NumberFormatException {
        return Double.longBitsToDouble(CHAR_ARRAY_PARSER.parseNumber(cArr, i, i2));
    }
}
