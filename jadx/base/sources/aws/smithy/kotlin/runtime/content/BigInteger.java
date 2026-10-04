package aws.smithy.kotlin.runtime.content;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BigIntegerJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 52\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u00015B\u0011\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0011\u0010\u000e\u001a\u00020\rH\u0096\u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0011\u001a\u00020\u0010H\u0096\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0014\u001a\u00020\u0013H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u00020\u0016H\u0096\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u00020\u0019H\u0096\u0080\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001d\u001a\u00020\u001cH\u0096\u0080\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010\"J\u0011\u0010#\u001a\u00020\u0016H\u0096\u0080\u0004¢\u0006\u0004\b#\u0010\u0018J\u001b\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$H\u0096\u0082\u0004¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b)\u0010*J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b+\u0010*J\u0019\u0010,\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0000H\u0096\u0082\u0004¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\n¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0004\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u00100\u001a\u0004\b1\u00102R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00103\u001a\u0004\b4\u0010 ¨\u00066"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/BigInteger;", "", "", "Ljava/math/BigInteger;", "delegate", "<init>", "(Ljava/math/BigInteger;)V", "", "value", "(Ljava/lang/String;)V", "", "bytes", "([B)V", "", "toByte", "()B", "", "toLong", "()J", "", "toShort", "()S", "", "toInt", "()I", "", "toFloat", "()F", "", "toDouble", "()D", "toString", "()Ljava/lang/String;", "radix", "(I)Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "plus", "(Laws/smithy/kotlin/runtime/content/BigInteger;)Laws/smithy/kotlin/runtime/content/BigInteger;", "minus", "compareTo", "(Laws/smithy/kotlin/runtime/content/BigInteger;)I", "toByteArray", "()[B", "Ljava/math/BigInteger;", "getDelegate$runtime_core", "()Ljava/math/BigInteger;", "Ljava/lang/String;", "getValue", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BigInteger extends Number implements Comparable<BigInteger> {
    private static final Companion Companion = new Companion(null);
    private final java.math.BigInteger delegate;
    private final String value;

    public BigInteger(java.math.BigInteger delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        String string = delegate.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.value = string;
    }

    @Override // java.lang.Number
    public final /* bridge */ byte byteValue() {
        return toByte();
    }

    @Override // java.lang.Number
    public final /* bridge */ double doubleValue() {
        return toDouble();
    }

    @Override // java.lang.Number
    public final /* bridge */ float floatValue() {
        return toFloat();
    }

    /* JADX INFO: renamed from: getDelegate$runtime_core, reason: from getter */
    public final java.math.BigInteger getDelegate() {
        return this.delegate;
    }

    @Override // java.lang.Number
    public final /* bridge */ int intValue() {
        return toInt();
    }

    @Override // java.lang.Number
    public final /* bridge */ long longValue() {
        return toLong();
    }

    @Override // java.lang.Number
    public final /* bridge */ short shortValue() {
        return toShort();
    }

    /* JADX INFO: compiled from: BigIntegerJVM.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/BigInteger$Companion;", "", "<init>", "()V", "Ljava/math/BigInteger;", "value", "Laws/smithy/kotlin/runtime/content/BigInteger;", TtmlNode.LEFT, TtmlNode.RIGHT, "coalesceOrCreate", "(Ljava/math/BigInteger;Laws/smithy/kotlin/runtime/content/BigInteger;Laws/smithy/kotlin/runtime/content/BigInteger;)Laws/smithy/kotlin/runtime/content/BigInteger;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BigInteger coalesceOrCreate(java.math.BigInteger value, BigInteger left, BigInteger right) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            return Intrinsics.areEqual(value, left.getDelegate()) ? left : Intrinsics.areEqual(value, right.getDelegate()) ? right : new BigInteger(value);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BigInteger(String value) {
        this(new java.math.BigInteger(value));
        Intrinsics.checkNotNullParameter(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BigInteger(byte[] bytes) {
        this(new java.math.BigInteger(bytes));
        Intrinsics.checkNotNullParameter(bytes, "bytes");
    }

    public byte toByte() {
        return this.delegate.byteValue();
    }

    public long toLong() {
        return this.delegate.longValue();
    }

    public short toShort() {
        return this.delegate.shortValue();
    }

    public int toInt() {
        return this.delegate.intValue();
    }

    public float toFloat() {
        return this.delegate.floatValue();
    }

    public double toDouble() {
        return this.delegate.doubleValue();
    }

    public String toString() {
        return toString(10);
    }

    public static /* synthetic */ String toString$default(BigInteger bigInteger, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 10;
        }
        return bigInteger.toString(i);
    }

    public final String toString(int radix) {
        String string = this.delegate.toString(radix);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.delegate.hashCode() + 17;
    }

    public boolean equals(Object other) {
        return (other instanceof BigInteger) && Intrinsics.areEqual(this.delegate, ((BigInteger) other).delegate);
    }

    public final BigInteger plus(BigInteger other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Companion companion = Companion;
        java.math.BigInteger bigIntegerAdd = this.delegate.add(other.delegate);
        Intrinsics.checkNotNullExpressionValue(bigIntegerAdd, "add(...)");
        return companion.coalesceOrCreate(bigIntegerAdd, this, other);
    }

    public final BigInteger minus(BigInteger other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Companion companion = Companion;
        java.math.BigInteger bigIntegerSubtract = this.delegate.subtract(other.delegate);
        Intrinsics.checkNotNullExpressionValue(bigIntegerSubtract, "subtract(...)");
        return companion.coalesceOrCreate(bigIntegerSubtract, this, other);
    }

    @Override // java.lang.Comparable
    public int compareTo(BigInteger other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.delegate.compareTo(other.delegate);
    }

    public final byte[] toByteArray() {
        byte[] byteArray = this.delegate.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
