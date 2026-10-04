package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: DefaultRetention.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0007H\u0096\u0080\u0004J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0017\u001a\u00020\u00002\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0010\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DefaultRetention;", "", "builder", "Laws/sdk/kotlin/services/s3/model/DefaultRetention$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/DefaultRetention$Builder;)V", "days", "", "getDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "mode", "Laws/sdk/kotlin/services/s3/model/ObjectLockRetentionMode;", "getMode", "()Laws/sdk/kotlin/services/s3/model/ObjectLockRetentionMode;", "years", "getYears", "toString", "", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultRetention {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer days;
    private final ObjectLockRetentionMode mode;
    private final Integer years;

    public /* synthetic */ DefaultRetention(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private DefaultRetention(Builder builder) {
        this.days = builder.getDays();
        this.mode = builder.getMode();
        this.years = builder.getYears();
    }

    public final Integer getDays() {
        return this.days;
    }

    public final ObjectLockRetentionMode getMode() {
        return this.mode;
    }

    public final Integer getYears() {
        return this.years;
    }

    /* JADX INFO: compiled from: DefaultRetention.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DefaultRetention$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/DefaultRetention;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/DefaultRetention$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DefaultRetention invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DefaultRetention(");
        sb.append("days=" + this.days + AbstractJsonLexerKt.COMMA);
        sb.append("mode=" + this.mode + AbstractJsonLexerKt.COMMA);
        sb.append("years=" + this.years);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Integer num = this.days;
        int iIntValue = (num != null ? num.intValue() : 0) * 31;
        ObjectLockRetentionMode objectLockRetentionMode = this.mode;
        int iHashCode = (iIntValue + (objectLockRetentionMode != null ? objectLockRetentionMode.hashCode() : 0)) * 31;
        Integer num2 = this.years;
        return iHashCode + (num2 != null ? num2.intValue() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultRetention defaultRetention = (DefaultRetention) other;
        return Intrinsics.areEqual(this.days, defaultRetention.days) && Intrinsics.areEqual(this.mode, defaultRetention.mode) && Intrinsics.areEqual(this.years, defaultRetention.years);
    }

    public static /* synthetic */ DefaultRetention copy$default(DefaultRetention defaultRetention, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.DefaultRetention.copy.1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "<this>");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(defaultRetention);
        block.invoke(builder);
        return builder.build();
    }

    public final DefaultRetention copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: DefaultRetention.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0005H\u0001J\r\u0010\u0018\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\f¨\u0006\u001a"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/DefaultRetention$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/DefaultRetention;", "(Laws/sdk/kotlin/services/s3/model/DefaultRetention;)V", "days", "", "getDays", "()Ljava/lang/Integer;", "setDays", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mode", "Laws/sdk/kotlin/services/s3/model/ObjectLockRetentionMode;", "getMode", "()Laws/sdk/kotlin/services/s3/model/ObjectLockRetentionMode;", "setMode", "(Laws/sdk/kotlin/services/s3/model/ObjectLockRetentionMode;)V", "years", "getYears", "setYears", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Integer days;
        private ObjectLockRetentionMode mode;
        private Integer years;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Integer getDays() {
            return this.days;
        }

        public final void setDays(Integer num) {
            this.days = num;
        }

        public final ObjectLockRetentionMode getMode() {
            return this.mode;
        }

        public final void setMode(ObjectLockRetentionMode objectLockRetentionMode) {
            this.mode = objectLockRetentionMode;
        }

        public final Integer getYears() {
            return this.years;
        }

        public final void setYears(Integer num) {
            this.years = num;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(DefaultRetention x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.days = x.getDays();
            this.mode = x.getMode();
            this.years = x.getYears();
        }

        public final DefaultRetention build() {
            return new DefaultRetention(this, null);
        }
    }
}
