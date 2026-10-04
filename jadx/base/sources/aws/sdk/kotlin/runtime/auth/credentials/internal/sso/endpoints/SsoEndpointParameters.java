package aws.sdk.kotlin.runtime.auth.credentials.internal.sso.endpoints;

import androidx.media3.extractor.text.ttml.TtmlNode;
import aws.sdk.kotlin.runtime.auth.credentials.internal.sso.endpoints.SsoEndpointParameters;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SsoEndpointParameters.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0007H\u0096\u0080\u0004J!\u0010\u0018\u001a\u00020\u00002\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\u0002\b\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters$Builder;)V", "endpoint", "", "getEndpoint", "()Ljava/lang/String;", TtmlNode.TAG_REGION, "getRegion", "useDualStack", "", "getUseDualStack", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "useFips", "getUseFips", "equals", "other", "hashCode", "", "toString", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SsoEndpointParameters {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String endpoint;
    private final String region;
    private final Boolean useDualStack;
    private final Boolean useFips;

    public /* synthetic */ SsoEndpointParameters(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private SsoEndpointParameters(Builder builder) {
        this.endpoint = builder.getEndpoint();
        this.region = builder.getRegion();
        Boolean useDualStack = builder.getUseDualStack();
        if (useDualStack == null) {
            throw new IllegalArgumentException("endpoint provider parameter #useDualStack is required".toString());
        }
        this.useDualStack = useDualStack;
        Boolean useFips = builder.getUseFips();
        if (useFips == null) {
            throw new IllegalArgumentException("endpoint provider parameter #useFips is required".toString());
        }
        this.useFips = useFips;
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final String getRegion() {
        return this.region;
    }

    public final Boolean getUseDualStack() {
        return this.useDualStack;
    }

    public final Boolean getUseFips() {
        return this.useFips;
    }

    /* JADX INFO: compiled from: SsoEndpointParameters.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SsoEndpointParameters invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SsoEndpointParameters)) {
            return false;
        }
        SsoEndpointParameters ssoEndpointParameters = (SsoEndpointParameters) other;
        return Intrinsics.areEqual(this.endpoint, ssoEndpointParameters.endpoint) && Intrinsics.areEqual(this.region, ssoEndpointParameters.region) && Intrinsics.areEqual(this.useDualStack, ssoEndpointParameters.useDualStack) && Intrinsics.areEqual(this.useFips, ssoEndpointParameters.useFips);
    }

    public int hashCode() {
        String str = this.endpoint;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.region;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool = this.useDualStack;
        int iHashCode3 = (iHashCode2 + (bool != null ? Boolean.hashCode(bool.booleanValue()) : 0)) * 31;
        Boolean bool2 = this.useFips;
        return iHashCode3 + (bool2 != null ? Boolean.hashCode(bool2.booleanValue()) : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SsoEndpointParameters(");
        sb.append("endpoint=" + this.endpoint + AbstractJsonLexerKt.COMMA);
        sb.append("region=" + this.region + AbstractJsonLexerKt.COMMA);
        sb.append("useDualStack=" + this.useDualStack + AbstractJsonLexerKt.COMMA);
        sb.append("useFips=" + this.useFips + ')');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SsoEndpointParameters copy$default(SsoEndpointParameters ssoEndpointParameters, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.sso.endpoints.SsoEndpointParameters$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return SsoEndpointParameters.copy$lambda$0((SsoEndpointParameters.Builder) obj2);
                }
            };
        }
        return ssoEndpointParameters.copy(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copy$lambda$0(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return Unit.INSTANCE;
    }

    public final SsoEndpointParameters copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder();
        builder.setEndpoint(this.endpoint);
        builder.setRegion(this.region);
        builder.setUseDualStack(this.useDualStack);
        builder.setUseFips(this.useFips);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: SsoEndpointParameters.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006\u0019"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters$Builder;", "", "<init>", "()V", "endpoint", "", "getEndpoint", "()Ljava/lang/String;", "setEndpoint", "(Ljava/lang/String;)V", TtmlNode.TAG_REGION, "getRegion", "setRegion", "useDualStack", "", "getUseDualStack", "()Ljava/lang/Boolean;", "setUseDualStack", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "useFips", "getUseFips", "setUseFips", "build", "Laws/sdk/kotlin/runtime/auth/credentials/internal/sso/endpoints/SsoEndpointParameters;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String endpoint;
        private String region;
        private Boolean useDualStack = false;
        private Boolean useFips = false;

        public final String getEndpoint() {
            return this.endpoint;
        }

        public final void setEndpoint(String str) {
            this.endpoint = str;
        }

        public final String getRegion() {
            return this.region;
        }

        public final void setRegion(String str) {
            this.region = str;
        }

        public final Boolean getUseDualStack() {
            return this.useDualStack;
        }

        public final void setUseDualStack(Boolean bool) {
            this.useDualStack = bool;
        }

        public final Boolean getUseFips() {
            return this.useFips;
        }

        public final void setUseFips(Boolean bool) {
            this.useFips = bool;
        }

        public final SsoEndpointParameters build() {
            return new SsoEndpointParameters(this, null);
        }
    }
}
