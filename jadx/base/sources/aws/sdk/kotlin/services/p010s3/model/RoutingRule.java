package aws.sdk.kotlin.services.p010s3.model;

import aws.sdk.kotlin.services.p010s3.model.Condition;
import aws.sdk.kotlin.services.p010s3.model.Redirect;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: RoutingRule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0015\u001a\u00020\u00002\u0019\b\u0002\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0002\b\u0019H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/RoutingRule;", "", "builder", "Laws/sdk/kotlin/services/s3/model/RoutingRule$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/model/RoutingRule$Builder;)V", "condition", "Laws/sdk/kotlin/services/s3/model/Condition;", "getCondition", "()Laws/sdk/kotlin/services/s3/model/Condition;", "redirect", "Laws/sdk/kotlin/services/s3/model/Redirect;", "getRedirect", "()Laws/sdk/kotlin/services/s3/model/Redirect;", "toString", "", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RoutingRule {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Condition condition;
    private final Redirect redirect;

    public /* synthetic */ RoutingRule(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private RoutingRule(Builder builder) {
        this.condition = builder.getCondition();
        this.redirect = builder.getRedirect();
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public final Redirect getRedirect() {
        return this.redirect;
    }

    /* JADX INFO: compiled from: RoutingRule.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/RoutingRule$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/model/RoutingRule;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/RoutingRule$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RoutingRule invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RoutingRule(");
        sb.append("condition=" + this.condition + AbstractJsonLexerKt.COMMA);
        sb.append("redirect=" + this.redirect);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        Condition condition = this.condition;
        int iHashCode = (condition != null ? condition.hashCode() : 0) * 31;
        Redirect redirect = this.redirect;
        return iHashCode + (redirect != null ? redirect.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        RoutingRule routingRule = (RoutingRule) other;
        return Intrinsics.areEqual(this.condition, routingRule.condition) && Intrinsics.areEqual(this.redirect, routingRule.redirect);
    }

    public static /* synthetic */ RoutingRule copy$default(RoutingRule routingRule, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.services.s3.model.RoutingRule.copy.1
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
        Builder builder = new Builder(routingRule);
        block.invoke(builder);
        return builder.build();
    }

    public final RoutingRule copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: RoutingRule.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0018J\u001f\u0010\r\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0018J\r\u0010\u001a\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/model/RoutingRule$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/services/s3/model/RoutingRule;", "(Laws/sdk/kotlin/services/s3/model/RoutingRule;)V", "condition", "Laws/sdk/kotlin/services/s3/model/Condition;", "getCondition", "()Laws/sdk/kotlin/services/s3/model/Condition;", "setCondition", "(Laws/sdk/kotlin/services/s3/model/Condition;)V", "redirect", "Laws/sdk/kotlin/services/s3/model/Redirect;", "getRedirect", "()Laws/sdk/kotlin/services/s3/model/Redirect;", "setRedirect", "(Laws/sdk/kotlin/services/s3/model/Redirect;)V", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/Condition$Builder;", "Lkotlin/ExtensionFunctionType;", "Laws/sdk/kotlin/services/s3/model/Redirect$Builder;", "correctErrors", "correctErrors$s3", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private Condition condition;
        private Redirect redirect;

        public final Builder correctErrors$s3() {
            return this;
        }

        public final Condition getCondition() {
            return this.condition;
        }

        public final void setCondition(Condition condition) {
            this.condition = condition;
        }

        public final Redirect getRedirect() {
            return this.redirect;
        }

        public final void setRedirect(Redirect redirect) {
            this.redirect = redirect;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(RoutingRule x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.condition = x.getCondition();
            this.redirect = x.getRedirect();
        }

        public final RoutingRule build() {
            return new RoutingRule(this, null);
        }

        public final void condition(Function1<? super Condition.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.condition = RoutingRuleKt.awsSdkKotlinServicesS3ModelConditionDslBuilderRef.invoke(block);
        }

        public final void redirect(Function1<? super Redirect.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.redirect = RoutingRuleKt.awsSdkKotlinServicesS3ModelRedirectDslBuilderRef.invoke(block);
        }
    }
}
