package ch.randelshofer.fastdoubleparser;

/* JADX INFO: loaded from: classes4.dex */
final class JsonDoubleBitsFromCharArray extends AbstractJsonFloatingPointBitsFromCharArray {
    @Override // ch.randelshofer.fastdoubleparser.AbstractJsonFloatingPointBitsFromCharArray
    long valueOfFloatLiteral(char[] cArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        double dTryDecFloatToDoubleTruncated = FastDoubleMath.tryDecFloatToDoubleTruncated(z, j, i3, z2, i4);
        if (Double.isNaN(dTryDecFloatToDoubleTruncated)) {
            dTryDecFloatToDoubleTruncated = Double.parseDouble(new String(cArr, i, i2 - i));
        }
        return Double.doubleToRawLongBits(dTryDecFloatToDoubleTruncated);
    }
}
