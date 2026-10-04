package ch.randelshofer.fastdoubleparser;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
final class JavaFloatBitsFromByteArray extends AbstractJavaFloatingPointBitsFromByteArray {
    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromByteArray
    long nan() {
        return Float.floatToRawIntBits(Float.NaN);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromByteArray
    long negativeInfinity() {
        return Float.floatToRawIntBits(Float.NEGATIVE_INFINITY);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromByteArray
    long positiveInfinity() {
        return Float.floatToRawIntBits(Float.POSITIVE_INFINITY);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromByteArray
    long valueOfFloatLiteral(byte[] bArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        float fDecFloatLiteralToFloat = FastFloatMath.decFloatLiteralToFloat(z, j, i3, z2, i4);
        if (Float.isNaN(fDecFloatLiteralToFloat)) {
            fDecFloatLiteralToFloat = Float.parseFloat(new String(bArr, i, i2 - i, StandardCharsets.ISO_8859_1));
        }
        return Float.floatToRawIntBits(fDecFloatLiteralToFloat);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromByteArray
    long valueOfHexLiteral(byte[] bArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        float fHexFloatLiteralToFloat = FastFloatMath.hexFloatLiteralToFloat(z, j, i3, z2, i4);
        if (Float.isNaN(fHexFloatLiteralToFloat)) {
            fHexFloatLiteralToFloat = Float.parseFloat(new String(bArr, i, i2 - i, StandardCharsets.ISO_8859_1));
        }
        return Float.floatToRawIntBits(fHexFloatLiteralToFloat);
    }
}
