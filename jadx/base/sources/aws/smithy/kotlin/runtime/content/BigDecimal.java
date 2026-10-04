package aws.smithy.kotlin.runtime.content;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BigDecimalJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u0000 42\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u00014B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0005\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0010J\u0011\u0010\u0013\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u00020\u0015H\u0096\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u00020\u0018H\u0096\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\fH\u0096\u0080\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u00020\u001dH\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u00020 H\u0096\u0080\u0004¢\u0006\u0004\b!\u0010\"J\u001b\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#H\u0096\u0082\u0004¢\u0006\u0004\b&\u0010'J\u0011\u0010(\u001a\u00020\fH\u0096\u0080\u0004¢\u0006\u0004\b(\u0010\u001cJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b)\u0010*J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b+\u0010*J\u0019\u0010,\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0000H\u0096\u0082\u0004¢\u0006\u0004\b,\u0010-R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010.R\u0011\u0010\u000b\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u0010\r\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b1\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b3\u0010\u0010¨\u00065"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/BigDecimal;", "", "", "Ljava/math/BigDecimal;", "delegate", "<init>", "(Ljava/math/BigDecimal;)V", "", "value", "(Ljava/lang/String;)V", "Laws/smithy/kotlin/runtime/content/BigInteger;", "mantissa", "", "exponent", "(Laws/smithy/kotlin/runtime/content/BigInteger;I)V", "toPlainString", "()Ljava/lang/String;", "toString", "", "toByte", "()B", "", "toDouble", "()D", "", "toFloat", "()F", "toInt", "()I", "", "toLong", "()J", "", "toShort", "()S", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "plus", "(Laws/smithy/kotlin/runtime/content/BigDecimal;)Laws/smithy/kotlin/runtime/content/BigDecimal;", "minus", "compareTo", "(Laws/smithy/kotlin/runtime/content/BigDecimal;)I", "Ljava/math/BigDecimal;", "getMantissa", "()Laws/smithy/kotlin/runtime/content/BigInteger;", "getExponent", "Ljava/lang/String;", "getValue", "Companion", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BigDecimal extends Number implements Comparable<BigDecimal> {
    private static final Companion Companion = new Companion(null);
    private final java.math.BigDecimal delegate;
    private final String value;

    public /* synthetic */ BigDecimal(java.math.BigDecimal bigDecimal, DefaultConstructorMarker defaultConstructorMarker) {
        this(bigDecimal);
    }

    private BigDecimal(java.math.BigDecimal bigDecimal) {
        this.delegate = bigDecimal;
        String string = bigDecimal.toString();
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

    /* JADX INFO: compiled from: BigDecimalJVM.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/content/BigDecimal$Companion;", "", "<init>", "()V", "Ljava/math/BigDecimal;", "value", "Laws/smithy/kotlin/runtime/content/BigDecimal;", TtmlNode.LEFT, TtmlNode.RIGHT, "coalesceOrCreate", "(Ljava/math/BigDecimal;Laws/smithy/kotlin/runtime/content/BigDecimal;Laws/smithy/kotlin/runtime/content/BigDecimal;)Laws/smithy/kotlin/runtime/content/BigDecimal;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BigDecimal coalesceOrCreate(java.math.BigDecimal value, BigDecimal left, BigDecimal right) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(left, "left");
            Intrinsics.checkNotNullParameter(right, "right");
            return Intrinsics.areEqual(value, left.delegate) ? left : Intrinsics.areEqual(value, right.delegate) ? right : new BigDecimal(value, (DefaultConstructorMarker) null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BigDecimal(String value) {
        this(new java.math.BigDecimal(value));
        Intrinsics.checkNotNullParameter(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BigDecimal(BigInteger mantissa, int i) {
        this(new java.math.BigDecimal(mantissa.getDelegate(), i));
        Intrinsics.checkNotNullParameter(mantissa, "mantissa");
    }

    public final String toPlainString() {
        String plainString = this.delegate.toPlainString();
        Intrinsics.checkNotNullExpressionValue(plainString, "toPlainString(...)");
        return plainString;
    }

    public String toString() {
        String string = this.delegate.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public byte toByte() {
        return this.delegate.byteValue();
    }

    public double toDouble() {
        return this.delegate.doubleValue();
    }

    public float toFloat() {
        return this.delegate.floatValue();
    }

    public int toInt() {
        return this.delegate.intValue();
    }

    public long toLong() {
        return this.delegate.longValue();
    }

    public short toShort() {
        return this.delegate.shortValue();
    }

    public boolean equals(Object other) {
        return (other instanceof BigDecimal) && Intrinsics.areEqual(this.delegate, ((BigDecimal) other).delegate);
    }

    public int hashCode() {
        return this.delegate.hashCode() + 31;
    }

    public final BigInteger getMantissa() {
        java.math.BigInteger bigIntegerUnscaledValue = this.delegate.unscaledValue();
        Intrinsics.checkNotNullExpressionValue(bigIntegerUnscaledValue, "unscaledValue(...)");
        return new BigInteger(bigIntegerUnscaledValue);
    }

    public final int getExponent() {
        return this.delegate.scale();
    }

    public final String getValue() {
        return this.value;
    }

    public final BigDecimal plus(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Companion companion = Companion;
        java.math.BigDecimal bigDecimalAdd = this.delegate.add(other.delegate);
        Intrinsics.checkNotNullExpressionValue(bigDecimalAdd, "add(...)");
        return companion.coalesceOrCreate(bigDecimalAdd, this, other);
    }

    public final BigDecimal minus(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Companion companion = Companion;
        java.math.BigDecimal bigDecimalSubtract = this.delegate.subtract(other.delegate);
        Intrinsics.checkNotNullExpressionValue(bigDecimalSubtract, "subtract(...)");
        return companion.coalesceOrCreate(bigDecimalSubtract, this, other);
    }

    @Override // java.lang.Comparable
    public int compareTo(BigDecimal other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.delegate.compareTo(other.delegate);
    }
}
