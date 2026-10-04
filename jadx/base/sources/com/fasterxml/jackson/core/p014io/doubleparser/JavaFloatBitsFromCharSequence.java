package com.fasterxml.jackson.core.p014io.doubleparser;

/* JADX INFO: loaded from: classes5.dex */
final class JavaFloatBitsFromCharSequence extends AbstractJavaFloatingPointBitsFromCharSequence {
    @Override // com.fasterxml.jackson.core.p014io.doubleparser.AbstractJavaFloatingPointBitsFromCharSequence
    long nan() {
        return Float.floatToRawIntBits(Float.NaN);
    }

    @Override // com.fasterxml.jackson.core.p014io.doubleparser.AbstractJavaFloatingPointBitsFromCharSequence
    long negativeInfinity() {
        return Float.floatToRawIntBits(Float.NEGATIVE_INFINITY);
    }

    @Override // com.fasterxml.jackson.core.p014io.doubleparser.AbstractJavaFloatingPointBitsFromCharSequence
    long positiveInfinity() {
        return Float.floatToRawIntBits(Float.POSITIVE_INFINITY);
    }

    @Override // com.fasterxml.jackson.core.p014io.doubleparser.AbstractJavaFloatingPointBitsFromCharSequence
    long valueOfFloatLiteral(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        float fDecFloatLiteralToFloat = FastFloatMath.decFloatLiteralToFloat(z, j, i3, z2, i4);
        if (Float.isNaN(fDecFloatLiteralToFloat)) {
            fDecFloatLiteralToFloat = Float.parseFloat(charSequence.subSequence(i, i2).toString());
        }
        return Float.floatToRawIntBits(fDecFloatLiteralToFloat);
    }

    @Override // com.fasterxml.jackson.core.p014io.doubleparser.AbstractJavaFloatingPointBitsFromCharSequence
    long valueOfHexLiteral(CharSequence charSequence, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        float fHexFloatLiteralToFloat = FastFloatMath.hexFloatLiteralToFloat(z, j, i3, z2, i4);
        if (Float.isNaN(fHexFloatLiteralToFloat)) {
            fHexFloatLiteralToFloat = Float.parseFloat(charSequence.subSequence(i, i2).toString());
        }
        return Float.floatToRawIntBits(fHexFloatLiteralToFloat);
    }
}
