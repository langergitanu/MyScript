package aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CreateTokenRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u001c\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\"\u001a\u00020\u00002\u0019\b\u0002\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%0$¢\u0006\u0002\b&H\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0019\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest$Builder;)V", "clientId", "", "getClientId", "()Ljava/lang/String;", "clientSecret", "getClientSecret", "code", "getCode", "codeVerifier", "getCodeVerifier", "deviceCode", "getDeviceCode", "grantType", "getGrantType", "redirectUri", "getRedirectUri", "refreshToken", "getRefreshToken", "scope", "", "getScope", "()Ljava/util/List;", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateTokenRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String clientId;
    private final String clientSecret;
    private final String code;
    private final String codeVerifier;
    private final String deviceCode;
    private final String grantType;
    private final String redirectUri;
    private final String refreshToken;
    private final List<String> scope;

    public /* synthetic */ CreateTokenRequest(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateTokenRequest(Builder builder) {
        this.clientId = builder.getClientId();
        this.clientSecret = builder.getClientSecret();
        this.code = builder.getCode();
        this.codeVerifier = builder.getCodeVerifier();
        this.deviceCode = builder.getDeviceCode();
        this.grantType = builder.getGrantType();
        this.redirectUri = builder.getRedirectUri();
        this.refreshToken = builder.getRefreshToken();
        this.scope = builder.getScope();
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCodeVerifier() {
        return this.codeVerifier;
    }

    public final String getDeviceCode() {
        return this.deviceCode;
    }

    public final String getGrantType() {
        return this.grantType;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final List<String> getScope() {
        return this.scope;
    }

    /* JADX INFO: compiled from: CreateTokenRequest.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateTokenRequest invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateTokenRequest(");
        sb.append("clientId=" + this.clientId + AbstractJsonLexerKt.COMMA);
        sb.append("clientSecret=*** Sensitive Data Redacted ***,");
        sb.append("code=" + this.code + AbstractJsonLexerKt.COMMA);
        sb.append("codeVerifier=*** Sensitive Data Redacted ***,");
        sb.append("deviceCode=" + this.deviceCode + AbstractJsonLexerKt.COMMA);
        sb.append("grantType=" + this.grantType + AbstractJsonLexerKt.COMMA);
        sb.append("redirectUri=" + this.redirectUri + AbstractJsonLexerKt.COMMA);
        sb.append("refreshToken=*** Sensitive Data Redacted ***,");
        sb.append("scope=" + this.scope);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.clientId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.clientSecret;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.code;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.codeVerifier;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.deviceCode;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.grantType;
        int iHashCode6 = (iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.redirectUri;
        int iHashCode7 = (iHashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.refreshToken;
        int iHashCode8 = (iHashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        List<String> list = this.scope;
        return iHashCode8 + (list != null ? list.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CreateTokenRequest createTokenRequest = (CreateTokenRequest) other;
        return Intrinsics.areEqual(this.clientId, createTokenRequest.clientId) && Intrinsics.areEqual(this.clientSecret, createTokenRequest.clientSecret) && Intrinsics.areEqual(this.code, createTokenRequest.code) && Intrinsics.areEqual(this.codeVerifier, createTokenRequest.codeVerifier) && Intrinsics.areEqual(this.deviceCode, createTokenRequest.deviceCode) && Intrinsics.areEqual(this.grantType, createTokenRequest.grantType) && Intrinsics.areEqual(this.redirectUri, createTokenRequest.redirectUri) && Intrinsics.areEqual(this.refreshToken, createTokenRequest.refreshToken) && Intrinsics.areEqual(this.scope, createTokenRequest.scope);
    }

    public static /* synthetic */ CreateTokenRequest copy$default(CreateTokenRequest createTokenRequest, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model.CreateTokenRequest.copy.1
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
        Builder builder = new Builder(createTokenRequest);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateTokenRequest copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateTokenRequest.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010(\u001a\u00020\u0005H\u0001J\r\u0010)\u001a\u00020\u0000H\u0000¢\u0006\u0002\b*R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\"\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006+"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenRequest;)V", "clientId", "", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "clientSecret", "getClientSecret", "setClientSecret", "code", "getCode", "setCode", "codeVerifier", "getCodeVerifier", "setCodeVerifier", "deviceCode", "getDeviceCode", "setDeviceCode", "grantType", "getGrantType", "setGrantType", "redirectUri", "getRedirectUri", "setRedirectUri", "refreshToken", "getRefreshToken", "setRefreshToken", "scope", "", "getScope", "()Ljava/util/List;", "setScope", "(Ljava/util/List;)V", "build", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String clientId;
        private String clientSecret;
        private String code;
        private String codeVerifier;
        private String deviceCode;
        private String grantType;
        private String redirectUri;
        private String refreshToken;
        private List<String> scope;

        public final Builder correctErrors$aws_config() {
            return this;
        }

        public final String getClientId() {
            return this.clientId;
        }

        public final void setClientId(String str) {
            this.clientId = str;
        }

        public final String getClientSecret() {
            return this.clientSecret;
        }

        public final void setClientSecret(String str) {
            this.clientSecret = str;
        }

        public final String getCode() {
            return this.code;
        }

        public final void setCode(String str) {
            this.code = str;
        }

        public final String getCodeVerifier() {
            return this.codeVerifier;
        }

        public final void setCodeVerifier(String str) {
            this.codeVerifier = str;
        }

        public final String getDeviceCode() {
            return this.deviceCode;
        }

        public final void setDeviceCode(String str) {
            this.deviceCode = str;
        }

        public final String getGrantType() {
            return this.grantType;
        }

        public final void setGrantType(String str) {
            this.grantType = str;
        }

        public final String getRedirectUri() {
            return this.redirectUri;
        }

        public final void setRedirectUri(String str) {
            this.redirectUri = str;
        }

        public final String getRefreshToken() {
            return this.refreshToken;
        }

        public final void setRefreshToken(String str) {
            this.refreshToken = str;
        }

        public final List<String> getScope() {
            return this.scope;
        }

        public final void setScope(List<String> list) {
            this.scope = list;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CreateTokenRequest x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.clientId = x.getClientId();
            this.clientSecret = x.getClientSecret();
            this.code = x.getCode();
            this.codeVerifier = x.getCodeVerifier();
            this.deviceCode = x.getDeviceCode();
            this.grantType = x.getGrantType();
            this.redirectUri = x.getRedirectUri();
            this.refreshToken = x.getRefreshToken();
            this.scope = x.getScope();
        }

        public final CreateTokenRequest build() {
            return new CreateTokenRequest(this, null);
        }
    }
}
