package ch.randelshofer.fastdoubleparser;

/* JADX INFO: loaded from: classes4.dex */
final class JavaFloatBitsFromCharArray extends AbstractJavaFloatingPointBitsFromCharArray {
    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long nan() {
        return Float.floatToRawIntBits(Float.NaN);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long negativeInfinity() {
        return Float.floatToRawIntBits(Float.NEGATIVE_INFINITY);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long positiveInfinity() {
        return Float.floatToRawIntBits(Float.POSITIVE_INFINITY);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long valueOfFloatLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        return Float.isNaN(FastFloatMath.decFloatLiteralToFloat(z, j, i3, z2, i4)) ? Float.floatToRawIntBits(Float.parseFloat(new String(cArr, i, i2 - i))) : Float.floatToRawIntBits(r4);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long valueOfHexLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        float fHexFloatLiteralToFloat = FastFloatMath.hexFloatLiteralToFloat(z, j, i3, z2, i4);
        if (Float.isNaN(fHexFloatLiteralToFloat)) {
            fHexFloatLiteralToFloat = Float.parseFloat(new String(cArr, i, i2 - i));
        }
        return Float.floatToRawIntBits(fHexFloatLiteralToFloat);
    }
}
