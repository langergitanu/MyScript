package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: NoncurrentVersionTransition.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0007H\u0096\u0080\u0004J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0017\u001a\u00020\u00002\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition;", "", "builder", "Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition$Builder;)V", "newerNoncurrentVersions", "", "getNewerNoncurrentVersions", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "noncurrentDays", "getNoncurrentDays", "storageClass", "Laws/sdk/kotlin/services/s3/model/TransitionStorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/TransitionStorageClass;", "toString", "", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoncurrentVersionTransition {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer newerNoncurrentVersions;
    private final Integer noncurrentDays;
    private final TransitionStorageClass storageClass;

    public /* synthetic */ NoncurrentVersionTransition(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private NoncurrentVersionTransition(Builder builder) {
        this.newerNoncurrentVersions = builder.getNewerNoncurrentVersions();
        this.noncurrentDays = builder.getNoncurrentDays();
        this.storageClass = builder.getStorageClass();
    }

    public final Integer getNewerNoncurrentVersions() {
        return this.newerNoncurrentVersions;
    }

    public final Integer getNoncurrentDays() {
        return this.noncurrentDays;
    }

    public final TransitionStorageClass getStorageClass() {
        return this.storageClass;
    }

    /* JADX INFO: compiled from: NoncurrentVersionTransition.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NoncurrentVersionTransition invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NoncurrentVersionTransition(");
        sb.append("newerNoncurrentVersions=" + this.newerNoncurrentVersions + AbstractJsonLexerKt.COMMA);
        sb.append("noncurrentDays=" + this.noncurrentDays + AbstractJsonLexerKt.COMMA);
        sb.append("storageClass=" + this.storageClass);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Integer num = this.newerNoncurrentVersions;
        int iIntValue = (num != null ? num.intValue() : 0) * 31;
        Integer num2 = this.noncurrentDays;
        int iIntValue2 = (iIntValue + (num2 != null ? num2.intValue() : 0)) * 31;
        TransitionStorageClass transitionStorageClass = this.storageClass;
        return iIntValue2 + (transitionStorageClass != null ? transitionStorageClass.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        NoncurrentVersionTransition noncurrentVersionTransition = (NoncurrentVersionTransition) other;
        return Intrinsics.areEqual(this.newerNoncurrentVersions, noncurrentVersionTransition.newerNoncurrentVersions) && Intrinsics.areEqual(this.noncurrentDays, noncurrentVersionTransition.noncurrentDays) && Intrinsics.areEqual(this.storageClass, noncurrentVersionTransition.storageClass);
    }

    public static /* synthetic */ NoncurrentVersionTransition copy$default(NoncurrentVersionTransition noncurrentVersionTransition, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.NoncurrentVersionTransition.copy.1
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
        Builder builder = new Builder(noncurrentVersionTransition);
        block.invoke(builder);
        return builder.build();
    }

    public final NoncurrentVersionTransition copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: NoncurrentVersionTransition.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0005H\u0001J\r\u0010\u0018\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition;", "(Laws/sdk/kotlin/services/s3/model/NoncurrentVersionTransition;)V", "newerNoncurrentVersions", "", "getNewerNoncurrentVersions", "()Ljava/lang/Integer;", "setNewerNoncurrentVersions", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "noncurrentDays", "getNoncurrentDays", "setNoncurrentDays", "storageClass", "Laws/sdk/kotlin/services/s3/model/TransitionStorageClass;", "getStorageClass", "()Laws/sdk/kotlin/services/s3/model/TransitionStorageClass;", "setStorageClass", "(Laws/sdk/kotlin/services/s3/model/TransitionStorageClass;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Integer newerNoncurrentVersions;
        private Integer noncurrentDays;
        private TransitionStorageClass storageClass;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Integer getNewerNoncurrentVersions() {
            return this.newerNoncurrentVersions;
        }

        public final void setNewerNoncurrentVersions(Integer num) {
            this.newerNoncurrentVersions = num;
        }

        public final Integer getNoncurrentDays() {
            return this.noncurrentDays;
        }

        public final void setNoncurrentDays(Integer num) {
            this.noncurrentDays = num;
        }

        public final TransitionStorageClass getStorageClass() {
            return this.storageClass;
        }

        public final void setStorageClass(TransitionStorageClass transitionStorageClass) {
            this.storageClass = transitionStorageClass;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(NoncurrentVersionTransition x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.newerNoncurrentVersions = x.getNewerNoncurrentVersions();
            this.noncurrentDays = x.getNoncurrentDays();
            this.storageClass = x.getStorageClass();
        }

        public final NoncurrentVersionTransition build() {
            return new NoncurrentVersionTransition(this, null);
        }
    }
}
