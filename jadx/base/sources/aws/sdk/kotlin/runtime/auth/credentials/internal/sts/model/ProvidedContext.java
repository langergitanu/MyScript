package aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ProvidedContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0012\u001a\u00020\u00002\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0019"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext$Builder;)V", "contextAssertion", "", "getContextAssertion", "()Ljava/lang/String;", "providerArn", "getProviderArn", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ProvidedContext {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String contextAssertion;
    private final String providerArn;

    public /* synthetic */ ProvidedContext(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ProvidedContext(Builder builder) {
        this.contextAssertion = builder.getContextAssertion();
        this.providerArn = builder.getProviderArn();
    }

    public final String getContextAssertion() {
        return this.contextAssertion;
    }

    public final String getProviderArn() {
        return this.providerArn;
    }

    /* JADX INFO: compiled from: ProvidedContext.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ProvidedContext invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ProvidedContext(");
        sb.append("contextAssertion=" + this.contextAssertion + AbstractJsonLexerKt.COMMA);
        sb.append("providerArn=" + this.providerArn);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.contextAssertion;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.providerArn;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        ProvidedContext providedContext = (ProvidedContext) other;
        return Intrinsics.areEqual(this.contextAssertion, providedContext.contextAssertion) && Intrinsics.areEqual(this.providerArn, providedContext.providerArn);
    }

    public static /* synthetic */ ProvidedContext copy$default(ProvidedContext providedContext, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sts.model.ProvidedContext.copy.1
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
        Builder builder = new Builder(providedContext);
        block.invoke(builder);
        return builder.build();
    }

    public final ProvidedContext copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: ProvidedContext.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0005H\u0001J\r\u0010\u0011\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0013"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sts/model/ProvidedContext;)V", "contextAssertion", "", "getContextAssertion", "()Ljava/lang/String;", "setContextAssertion", "(Ljava/lang/String;)V", "providerArn", "getProviderArn", "setProviderArn", "build", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String contextAssertion;
        private String providerArn;

        public final Builder correctErrors$aws_config() {
            return this;
        }

        public final String getContextAssertion() {
            return this.contextAssertion;
        }

        public final void setContextAssertion(String str) {
            this.contextAssertion = str;
        }

        public final String getProviderArn() {
            return this.providerArn;
        }

        public final void setProviderArn(String str) {
            this.providerArn = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(ProvidedContext x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.contextAssertion = x.getContextAssertion();
            this.providerArn = x.getProviderArn();
        }

        public final ProvidedContext build() {
            return new ProvidedContext(this, null);
        }
    }
}
