package ch.randelshofer.fastdoubleparser;

/* JADX INFO: loaded from: classes4.dex */
final class JavaDoubleBitsFromCharArray extends AbstractJavaFloatingPointBitsFromCharArray {
    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long nan() {
        return Double.doubleToRawLongBits(Double.NaN);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long negativeInfinity() {
        return Double.doubleToRawLongBits(Double.NEGATIVE_INFINITY);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long positiveInfinity() {
        return Double.doubleToRawLongBits(Double.POSITIVE_INFINITY);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long valueOfFloatLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        double dTryDecFloatToDoubleTruncated = FastDoubleMath.tryDecFloatToDoubleTruncated(z, j, i3, z2, i4);
        if (Double.isNaN(dTryDecFloatToDoubleTruncated)) {
            dTryDecFloatToDoubleTruncated = Double.parseDouble(new String(cArr, i, i2 - i));
        }
        return Double.doubleToRawLongBits(dTryDecFloatToDoubleTruncated);
    }

    @Override // ch.randelshofer.fastdoubleparser.AbstractJavaFloatingPointBitsFromCharArray
    long valueOfHexLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        double dTryHexFloatToDoubleTruncated = FastDoubleMath.tryHexFloatToDoubleTruncated(z, j, i3, z2, i4);
        if (Double.isNaN(dTryHexFloatToDoubleTruncated)) {
            dTryHexFloatToDoubleTruncated = Double.parseDouble(new String(cArr, i, i2 - i));
        }
        return Double.doubleToRawLongBits(dTryHexFloatToDoubleTruncated);
    }
}
