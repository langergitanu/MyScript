package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.IntelligentTieringConfiguration;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetBucketIntelligentTieringConfigurationResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0011\u001a\u00020\u00002\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\b\u0015H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse$Builder;)V", "intelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;", "getIntelligentTieringConfiguration", "()Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetBucketIntelligentTieringConfigurationResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final IntelligentTieringConfiguration intelligentTieringConfiguration;

    public /* synthetic */ GetBucketIntelligentTieringConfigurationResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GetBucketIntelligentTieringConfigurationResponse(Builder builder) {
        this.intelligentTieringConfiguration = builder.getIntelligentTieringConfiguration();
    }

    public final IntelligentTieringConfiguration getIntelligentTieringConfiguration() {
        return this.intelligentTieringConfiguration;
    }

    /* JADX INFO: compiled from: GetBucketIntelligentTieringConfigurationResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GetBucketIntelligentTieringConfigurationResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketIntelligentTieringConfigurationResponse(");
        sb.append("intelligentTieringConfiguration=" + this.intelligentTieringConfiguration);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        IntelligentTieringConfiguration intelligentTieringConfiguration = this.intelligentTieringConfiguration;
        if (intelligentTieringConfiguration != null) {
            return intelligentTieringConfiguration.hashCode();
        }
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other != null && getClass() == other.getClass() && Intrinsics.areEqual(this.intelligentTieringConfiguration, ((GetBucketIntelligentTieringConfigurationResponse) other).intelligentTieringConfiguration);
    }

    public static /* synthetic */ GetBucketIntelligentTieringConfigurationResponse copy$default(GetBucketIntelligentTieringConfigurationResponse getBucketIntelligentTieringConfigurationResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.GetBucketIntelligentTieringConfigurationResponse.copy.1
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
        Builder builder = new Builder(getBucketIntelligentTieringConfigurationResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final GetBucketIntelligentTieringConfigurationResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: GetBucketIntelligentTieringConfigurationResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse;", "(Laws/sdk/kotlin/services/s3/model/GetBucketIntelligentTieringConfigurationResponse;)V", "intelligentTieringConfiguration", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;", "getIntelligentTieringConfiguration", "()Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;", "setIntelligentTieringConfiguration", "(Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/IntelligentTieringConfiguration$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private IntelligentTieringConfiguration intelligentTieringConfiguration;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final IntelligentTieringConfiguration getIntelligentTieringConfiguration() {
            return this.intelligentTieringConfiguration;
        }

        public final void setIntelligentTieringConfiguration(IntelligentTieringConfiguration intelligentTieringConfiguration) {
            this.intelligentTieringConfiguration = intelligentTieringConfiguration;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(GetBucketIntelligentTieringConfigurationResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.intelligentTieringConfiguration = x.getIntelligentTieringConfiguration();
        }

        public final GetBucketIntelligentTieringConfigurationResponse build() {
            return new GetBucketIntelligentTieringConfigurationResponse(this, null);
        }

        public final void intelligentTieringConfiguration(Function1<? super IntelligentTieringConfiguration.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.intelligentTieringConfiguration = GetBucketIntelligentTieringConfigurationResponseKt.f443x732f0e75.invoke(block);
        }
    }
}
