package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.auth;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.auth.SigninAuthSchemeParameters;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SigninAuthSchemeParameters.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\n\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\u000bJ\n\u0010\f\u001a\u00020\u0007H\u0096\u0080\u0004J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J(\u0010\u0012\u001a\u00020\u00002\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0002\b\u0016H\u0000¢\u0006\u0002\b\u0017R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeParameters;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeParameters$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeParameters$Builder;)V", "operationName", "", "getOperationName", "()Ljava/lang/String;", "toBuilder", "toBuilder$aws_config", "toString", "equals", "", "other", "hashCode", "", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "copy$aws_config", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigninAuthSchemeParameters {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String operationName;

    public /* synthetic */ SigninAuthSchemeParameters(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private SigninAuthSchemeParameters(Builder builder) {
        String operationName = builder.getOperationName();
        if (operationName == null) {
            throw new IllegalArgumentException("operationName is a required auth scheme parameter".toString());
        }
        this.operationName = operationName;
    }

    /* JADX INFO: compiled from: SigninAuthSchemeParameters.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0080\nø\u0001\u0000¢\u0006\u0002\b\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeParameters$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeParameters;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeParameters$Builder;", "", "Lkotlin/ExtensionFunctionType;", "invoke$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SigninAuthSchemeParameters invoke$aws_config(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public final String getOperationName() {
        return this.operationName;
    }

    public final Builder toBuilder$aws_config() {
        Builder builder = new Builder();
        builder.setOperationName(this.operationName);
        return builder;
    }

    /* JADX INFO: compiled from: SigninAuthSchemeParameters.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeParameters$Builder;", "", "<init>", "()V", "operationName", "", "getOperationName", "()Ljava/lang/String;", "setOperationName", "(Ljava/lang/String;)V", "build", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/auth/SigninAuthSchemeParameters;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String operationName;

        public final String getOperationName() {
            return this.operationName;
        }

        public final void setOperationName(String str) {
            this.operationName = str;
        }

        public final SigninAuthSchemeParameters build() {
            return new SigninAuthSchemeParameters(this, null);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SigninAuthSchemeParameters(");
        sb.append("operationName=" + this.operationName + ')');
        return sb.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SigninAuthSchemeParameters) && Intrinsics.areEqual(this.operationName, ((SigninAuthSchemeParameters) other).operationName);
    }

    public int hashCode() {
        String str = this.operationName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SigninAuthSchemeParameters copy$aws_config$default(SigninAuthSchemeParameters signinAuthSchemeParameters, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.signin.auth.SigninAuthSchemeParameters$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SigninAuthSchemeParameters.copy$lambda$0((SigninAuthSchemeParameters.Builder) obj2);
                }
            };
        }
        return signinAuthSchemeParameters.copy$aws_config(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copy$lambda$0(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return Unit.INSTANCE;
    }

    public final SigninAuthSchemeParameters copy$aws_config(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder();
        builder.setOperationName(this.operationName);
        block.invoke(builder);
        return builder.build();
    }
}
