package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: SigV4aSignatureCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\u001a\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, m1599d2 = {"MAX_KDF_COUNTER_ITERATIONS", "", "N_MINUS_TWO", "Laws/smithy/kotlin/runtime/content/BigInteger;", "getN_MINUS_TWO", "()Laws/smithy/kotlin/runtime/content/BigInteger;", "toPositiveBigInteger", "", "aws-signing-default"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigV4aSignatureCalculatorKt {
    public static final byte MAX_KDF_COUNTER_ITERATIONS = -2;
    private static final BigInteger N_MINUS_TWO = toPositiveBigInteger(HexKt.decodeHexBytes("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC63254F"));

    public static final BigInteger getN_MINUS_TWO() {
        return N_MINUS_TWO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BigInteger toPositiveBigInteger(byte[] bArr) {
        return new BigInteger(ArraysKt.plus(new byte[]{0}, bArr));
    }
}
