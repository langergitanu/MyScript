package aws.sdk.kotlin.services.p010s3.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: GetBucketLifecycleConfigurationResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\n\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0016\u001a\u00020\u00002\u0019\b\u0002\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\u0002\b\u001aH\u0086\bø\u0001\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse;", "", "builder", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse$Builder;)V", "rules", "", "Laws/sdk/kotlin/services/s3/model/LifecycleRule;", "getRules", "()Ljava/util/List;", "transitionDefaultMinimumObjectSize", "Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;", "getTransitionDefaultMinimumObjectSize", "()Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GetBucketLifecycleConfigurationResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<LifecycleRule> rules;
    private final TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize;

    public /* synthetic */ GetBucketLifecycleConfigurationResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private GetBucketLifecycleConfigurationResponse(Builder builder) {
        this.rules = builder.getRules();
        this.transitionDefaultMinimumObjectSize = builder.getTransitionDefaultMinimumObjectSize();
    }

    public final List<LifecycleRule> getRules() {
        return this.rules;
    }

    public final TransitionDefaultMinimumObjectSize getTransitionDefaultMinimumObjectSize() {
        return this.transitionDefaultMinimumObjectSize;
    }

    /* JADX INFO: compiled from: GetBucketLifecycleConfigurationResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GetBucketLifecycleConfigurationResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GetBucketLifecycleConfigurationResponse(");
        sb.append("rules=" + this.rules + AbstractJsonLexerKt.COMMA);
        sb.append("transitionDefaultMinimumObjectSize=" + this.transitionDefaultMinimumObjectSize);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        List<LifecycleRule> list = this.rules;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize = this.transitionDefaultMinimumObjectSize;
        return iHashCode + (transitionDefaultMinimumObjectSize != null ? transitionDefaultMinimumObjectSize.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        GetBucketLifecycleConfigurationResponse getBucketLifecycleConfigurationResponse = (GetBucketLifecycleConfigurationResponse) other;
        return Intrinsics.areEqual(this.rules, getBucketLifecycleConfigurationResponse.rules) && Intrinsics.areEqual(this.transitionDefaultMinimumObjectSize, getBucketLifecycleConfigurationResponse.transitionDefaultMinimumObjectSize);
    }

    public static /* synthetic */ GetBucketLifecycleConfigurationResponse copy$default(GetBucketLifecycleConfigurationResponse getBucketLifecycleConfigurationResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.GetBucketLifecycleConfigurationResponse.copy.1
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
        Builder builder = new Builder(getBucketLifecycleConfigurationResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final GetBucketLifecycleConfigurationResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: GetBucketLifecycleConfigurationResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0005H\u0001J\r\u0010\u0015\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0016R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse;", "(Laws/sdk/kotlin/services/s3/model/GetBucketLifecycleConfigurationResponse;)V", "rules", "", "Laws/sdk/kotlin/services/s3/model/LifecycleRule;", "getRules", "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "transitionDefaultMinimumObjectSize", "Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;", "getTransitionDefaultMinimumObjectSize", "()Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;", "setTransitionDefaultMinimumObjectSize", "(Laws/sdk/kotlin/services/s3/model/TransitionDefaultMinimumObjectSize;)V", "build", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private List<LifecycleRule> rules;
        private TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final List<LifecycleRule> getRules() {
            return this.rules;
        }

        public final void setRules(List<LifecycleRule> list) {
            this.rules = list;
        }

        public final TransitionDefaultMinimumObjectSize getTransitionDefaultMinimumObjectSize() {
            return this.transitionDefaultMinimumObjectSize;
        }

        public final void setTransitionDefaultMinimumObjectSize(TransitionDefaultMinimumObjectSize transitionDefaultMinimumObjectSize) {
            this.transitionDefaultMinimumObjectSize = transitionDefaultMinimumObjectSize;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(GetBucketLifecycleConfigurationResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.rules = x.getRules();
            this.transitionDefaultMinimumObjectSize = x.getTransitionDefaultMinimumObjectSize();
        }

        public final GetBucketLifecycleConfigurationResponse build() {
            return new GetBucketLifecycleConfigurationResponse(this, null);
        }
    }
}
