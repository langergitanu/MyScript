package ch.randelshofer.fastdoubleparser;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
final class JsonDoubleBitsFromByteArray extends AbstractJsonFloatingPointBitsFromByteArray {
    @Override // ch.randelshofer.fastdoubleparser.AbstractJsonFloatingPointBitsFromByteArray
    long valueOfFloatLiteral(byte[] bArr, int i, int i2, boolean z, long j, int i3, boolean z2, int i4) {
        double dTryDecFloatToDoubleTruncated = FastDoubleMath.tryDecFloatToDoubleTruncated(z, j, i3, z2, i4);
        if (Double.isNaN(dTryDecFloatToDoubleTruncated)) {
            dTryDecFloatToDoubleTruncated = Double.parseDouble(new String(bArr, i, i2 - i, StandardCharsets.ISO_8859_1));
        }
        return Double.doubleToRawLongBits(dTryDecFloatToDoubleTruncated);
    }
}
