package kotlin.experimental;

import kotlin.Metadata;

/* JADX INFO: compiled from: bitwiseOperations.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\n\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004\u001a\u0016\u0010\u0003\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004\u001a\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u008c\u0004\u001a\u0016\u0010\u0003\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u008c\u0004\u001a\u0016\u0010\u0004\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u008c\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H\u0087\u0088\u0004¨\u0006\u0007"}, m1599d2 = {"and", "", "other", "or", "xor", "inv", "", "kotlin-stdlib"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BitwiseOperationsKt {
    private static final byte and(byte b, byte b2) {
        return (byte) (b & b2);
    }

    private static final short and(short s, short s2) {
        return (short) (s & s2);
    }

    private static final byte inv(byte b) {
        return (byte) (~b);
    }

    private static final short inv(short s) {
        return (short) (~s);
    }

    /* JADX INFO: renamed from: or */
    private static final byte m1617or(byte b, byte b2) {
        return (byte) (b | b2);
    }

    /* JADX INFO: renamed from: or */
    private static final short m1618or(short s, short s2) {
        return (short) (s | s2);
    }

    private static final byte xor(byte b, byte b2) {
        return (byte) (b ^ b2);
    }

    private static final short xor(short s, short s2) {
        return (short) (s ^ s2);
    }
}
