package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PublicAccessBlockConfiguration.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J\u0014\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0017\u001a\u00020\u00002\u0019\b\u0002\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0086\bø\u0001\u0000R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000e\u0010\tR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0010\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration;", "", "builder", "Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration$Builder;)V", "blockPublicAcls", "", "getBlockPublicAcls", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "blockPublicPolicy", "getBlockPublicPolicy", "ignorePublicAcls", "getIgnorePublicAcls", "restrictPublicBuckets", "getRestrictPublicBuckets", "toString", "", "hashCode", "", "equals", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PublicAccessBlockConfiguration {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean blockPublicAcls;
    private final Boolean blockPublicPolicy;
    private final Boolean ignorePublicAcls;
    private final Boolean restrictPublicBuckets;

    public /* synthetic */ PublicAccessBlockConfiguration(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PublicAccessBlockConfiguration(Builder builder) {
        this.blockPublicAcls = builder.getBlockPublicAcls();
        this.blockPublicPolicy = builder.getBlockPublicPolicy();
        this.ignorePublicAcls = builder.getIgnorePublicAcls();
        this.restrictPublicBuckets = builder.getRestrictPublicBuckets();
    }

    public final Boolean getBlockPublicAcls() {
        return this.blockPublicAcls;
    }

    public final Boolean getBlockPublicPolicy() {
        return this.blockPublicPolicy;
    }

    public final Boolean getIgnorePublicAcls() {
        return this.ignorePublicAcls;
    }

    public final Boolean getRestrictPublicBuckets() {
        return this.restrictPublicBuckets;
    }

    /* JADX INFO: compiled from: PublicAccessBlockConfiguration.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PublicAccessBlockConfiguration invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PublicAccessBlockConfiguration(");
        sb.append("blockPublicAcls=" + this.blockPublicAcls + AbstractJsonLexerKt.COMMA);
        sb.append("blockPublicPolicy=" + this.blockPublicPolicy + AbstractJsonLexerKt.COMMA);
        sb.append("ignorePublicAcls=" + this.ignorePublicAcls + AbstractJsonLexerKt.COMMA);
        sb.append("restrictPublicBuckets=" + this.restrictPublicBuckets);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Boolean bool = this.blockPublicAcls;
        int iHashCode = (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0) * 31;
        Boolean bool2 = this.blockPublicPolicy;
        int iHashCode2 = (iHashCode + (bool2 != null ? Boolean.hashCode(bool2.booleanValue()) : 0)) * 31;
        Boolean bool3 = this.ignorePublicAcls;
        int iHashCode3 = (iHashCode2 + (bool3 != null ? Boolean.hashCode(bool3.booleanValue()) : 0)) * 31;
        Boolean bool4 = this.restrictPublicBuckets;
        return iHashCode3 + (bool4 != null ? Boolean.hashCode(bool4.booleanValue()) : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        PublicAccessBlockConfiguration publicAccessBlockConfiguration = (PublicAccessBlockConfiguration) other;
        return Intrinsics.areEqual(this.blockPublicAcls, publicAccessBlockConfiguration.blockPublicAcls) && Intrinsics.areEqual(this.blockPublicPolicy, publicAccessBlockConfiguration.blockPublicPolicy) && Intrinsics.areEqual(this.ignorePublicAcls, publicAccessBlockConfiguration.ignorePublicAcls) && Intrinsics.areEqual(this.restrictPublicBuckets, publicAccessBlockConfiguration.restrictPublicBuckets);
    }

    public static /* synthetic */ PublicAccessBlockConfiguration copy$default(PublicAccessBlockConfiguration publicAccessBlockConfiguration, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.PublicAccessBlockConfiguration.copy.1
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
        Builder builder = new Builder(publicAccessBlockConfiguration);
        block.invoke(builder);
        return builder.build();
    }

    public final PublicAccessBlockConfiguration copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: PublicAccessBlockConfiguration.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0005H\u0001J\r\u0010\u0018\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\f¨\u0006\u001a"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration;", "(Laws/sdk/kotlin/services/s3/model/PublicAccessBlockConfiguration;)V", "blockPublicAcls", "", "getBlockPublicAcls", "()Ljava/lang/Boolean;", "setBlockPublicAcls", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "blockPublicPolicy", "getBlockPublicPolicy", "setBlockPublicPolicy", "ignorePublicAcls", "getIgnorePublicAcls", "setIgnorePublicAcls", "restrictPublicBuckets", "getRestrictPublicBuckets", "setRestrictPublicBuckets", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Boolean blockPublicAcls;
        private Boolean blockPublicPolicy;
        private Boolean ignorePublicAcls;
        private Boolean restrictPublicBuckets;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Boolean getBlockPublicAcls() {
            return this.blockPublicAcls;
        }

        public final void setBlockPublicAcls(Boolean bool) {
            this.blockPublicAcls = bool;
        }

        public final Boolean getBlockPublicPolicy() {
            return this.blockPublicPolicy;
        }

        public final void setBlockPublicPolicy(Boolean bool) {
            this.blockPublicPolicy = bool;
        }

        public final Boolean getIgnorePublicAcls() {
            return this.ignorePublicAcls;
        }

        public final void setIgnorePublicAcls(Boolean bool) {
            this.ignorePublicAcls = bool;
        }

        public final Boolean getRestrictPublicBuckets() {
            return this.restrictPublicBuckets;
        }

        public final void setRestrictPublicBuckets(Boolean bool) {
            this.restrictPublicBuckets = bool;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(PublicAccessBlockConfiguration x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.blockPublicAcls = x.getBlockPublicAcls();
            this.blockPublicPolicy = x.getBlockPublicPolicy();
            this.ignorePublicAcls = x.getIgnorePublicAcls();
            this.restrictPublicBuckets = x.getRestrictPublicBuckets();
        }

        public final PublicAccessBlockConfiguration build() {
            return new PublicAccessBlockConfiguration(this, null);
        }
    }
}
