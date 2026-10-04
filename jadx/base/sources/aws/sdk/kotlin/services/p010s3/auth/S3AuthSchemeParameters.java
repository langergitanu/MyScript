package aws.sdk.kotlin.services.p010s3.auth;

import aws.sdk.kotlin.services.p010s3.auth.S3AuthSchemeParameters;
import aws.sdk.kotlin.services.p010s3.endpoints.S3EndpointParameters;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: S3AuthSchemeParameters.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u0003J\n\u0010\u000f\u001a\u00020\u000bH\u0096\u0080\u0004J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0013\u001a\u00020\u0014H\u0096\u0080\u0004J!\u0010\u0015\u001a\u00020\u00002\u0019\b\u0002\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017¢\u0006\u0002\b\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters;", "", "builder", "Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters$Builder;", "<init>", "(Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters$Builder;)V", "endpointParameters", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;", "getEndpointParameters", "()Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;", "operationName", "", "getOperationName", "()Ljava/lang/String;", "toBuilder", "toString", "equals", "", "other", "hashCode", "", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class S3AuthSchemeParameters {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final S3EndpointParameters endpointParameters;
    private final String operationName;

    public /* synthetic */ S3AuthSchemeParameters(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private S3AuthSchemeParameters(Builder builder) {
        this.endpointParameters = builder.getEndpointParameters();
        String operationName = builder.getOperationName();
        if (operationName == null) {
            throw new IllegalArgumentException("operationName is a required auth scheme parameter".toString());
        }
        this.operationName = operationName;
    }

    public final S3EndpointParameters getEndpointParameters() {
        return this.endpointParameters;
    }

    /* JADX INFO: compiled from: S3AuthSchemeParameters.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters$Builder;", "", "Lkotlin/ExtensionFunctionType;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final S3AuthSchemeParameters invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public final String getOperationName() {
        return this.operationName;
    }

    public final Builder toBuilder() {
        Builder builder = new Builder();
        builder.setEndpointParameters(this.endpointParameters);
        builder.setOperationName(this.operationName);
        return builder;
    }

    /* JADX INFO: compiled from: S3AuthSchemeParameters.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters$Builder;", "", "<init>", "()V", "endpointParameters", "Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;", "getEndpointParameters", "()Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;", "setEndpointParameters", "(Laws/sdk/kotlin/services/s3/endpoints/S3EndpointParameters;)V", "operationName", "", "getOperationName", "()Ljava/lang/String;", "setOperationName", "(Ljava/lang/String;)V", "build", "Laws/sdk/kotlin/services/s3/auth/S3AuthSchemeParameters;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private S3EndpointParameters endpointParameters;
        private String operationName;

        public final S3EndpointParameters getEndpointParameters() {
            return this.endpointParameters;
        }

        public final void setEndpointParameters(S3EndpointParameters s3EndpointParameters) {
            this.endpointParameters = s3EndpointParameters;
        }

        public final String getOperationName() {
            return this.operationName;
        }

        public final void setOperationName(String str) {
            this.operationName = str;
        }

        public final S3AuthSchemeParameters build() {
            return new S3AuthSchemeParameters(this, null);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("S3AuthSchemeParameters(");
        sb.append("endpointParameters=" + this.endpointParameters + AbstractJsonLexerKt.COMMA);
        sb.append("operationName=" + this.operationName + ')');
        return sb.toString();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof S3AuthSchemeParameters)) {
            return false;
        }
        S3AuthSchemeParameters s3AuthSchemeParameters = (S3AuthSchemeParameters) other;
        return Intrinsics.areEqual(this.endpointParameters, s3AuthSchemeParameters.endpointParameters) && Intrinsics.areEqual(this.operationName, s3AuthSchemeParameters.operationName);
    }

    public int hashCode() {
        S3EndpointParameters s3EndpointParameters = this.endpointParameters;
        int iHashCode = (s3EndpointParameters != null ? s3EndpointParameters.hashCode() : 0) * 31;
        String str = this.operationName;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ S3AuthSchemeParameters copy$default(S3AuthSchemeParameters s3AuthSchemeParameters, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: aws.sdk.kotlin.services.s3.auth.S3AuthSchemeParameters$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return S3AuthSchemeParameters.copy$lambda$0((S3AuthSchemeParameters.Builder) obj2);
                }
            };
        }
        return s3AuthSchemeParameters.copy(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copy$lambda$0(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return Unit.INSTANCE;
    }

    public final S3AuthSchemeParameters copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder();
        builder.setEndpointParameters(this.endpointParameters);
        builder.setOperationName(this.operationName);
        block.invoke(builder);
        return builder.build();
    }
}
