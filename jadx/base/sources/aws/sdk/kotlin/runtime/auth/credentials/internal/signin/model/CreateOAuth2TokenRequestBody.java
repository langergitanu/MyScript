package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CreateOAuth2TokenRequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0014\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001a\u001a\u00020\u00002\u0019\b\u0002\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\b\u001eH\u0086\bø\u0001\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody$Builder;)V", "clientId", "", "getClientId", "()Ljava/lang/String;", "code", "getCode", "codeVerifier", "getCodeVerifier", "grantType", "getGrantType", "redirectUri", "getRedirectUri", "refreshToken", "getRefreshToken", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateOAuth2TokenRequestBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String clientId;
    private final String code;
    private final String codeVerifier;
    private final String grantType;
    private final String redirectUri;
    private final String refreshToken;

    public /* synthetic */ CreateOAuth2TokenRequestBody(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateOAuth2TokenRequestBody(Builder builder) {
        String clientId = builder.getClientId();
        if (clientId == null) {
            throw new IllegalArgumentException("A non-null value must be provided for clientId".toString());
        }
        this.clientId = clientId;
        this.code = builder.getCode();
        this.codeVerifier = builder.getCodeVerifier();
        String grantType = builder.getGrantType();
        if (grantType == null) {
            throw new IllegalArgumentException("A non-null value must be provided for grantType".toString());
        }
        this.grantType = grantType;
        this.redirectUri = builder.getRedirectUri();
        this.refreshToken = builder.getRefreshToken();
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getCodeVerifier() {
        return this.codeVerifier;
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

    /* JADX INFO: compiled from: CreateOAuth2TokenRequestBody.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateOAuth2TokenRequestBody invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateOAuth2TokenRequestBody(");
        sb.append("clientId=" + this.clientId + AbstractJsonLexerKt.COMMA);
        sb.append("code=" + this.code + AbstractJsonLexerKt.COMMA);
        sb.append("codeVerifier=" + this.codeVerifier + AbstractJsonLexerKt.COMMA);
        sb.append("grantType=" + this.grantType + AbstractJsonLexerKt.COMMA);
        sb.append("redirectUri=" + this.redirectUri + AbstractJsonLexerKt.COMMA);
        sb.append("refreshToken=*** Sensitive Data Redacted ***)");
        return sb.toString();
    }

    public int hashCode() {
        int iHashCode = this.clientId.hashCode() * 31;
        String str = this.code;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.codeVerifier;
        int iHashCode3 = (((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.grantType.hashCode()) * 31;
        String str3 = this.redirectUri;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.refreshToken;
        return iHashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CreateOAuth2TokenRequestBody createOAuth2TokenRequestBody = (CreateOAuth2TokenRequestBody) other;
        return Intrinsics.areEqual(this.clientId, createOAuth2TokenRequestBody.clientId) && Intrinsics.areEqual(this.code, createOAuth2TokenRequestBody.code) && Intrinsics.areEqual(this.codeVerifier, createOAuth2TokenRequestBody.codeVerifier) && Intrinsics.areEqual(this.grantType, createOAuth2TokenRequestBody.grantType) && Intrinsics.areEqual(this.redirectUri, createOAuth2TokenRequestBody.redirectUri) && Intrinsics.areEqual(this.refreshToken, createOAuth2TokenRequestBody.refreshToken);
    }

    public static /* synthetic */ CreateOAuth2TokenRequestBody copy$default(CreateOAuth2TokenRequestBody createOAuth2TokenRequestBody, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenRequestBody.copy.1
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
        Builder builder = new Builder(createOAuth2TokenRequestBody);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateOAuth2TokenRequestBody copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateOAuth2TokenRequestBody.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0005H\u0001J\r\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenRequestBody;)V", "clientId", "", "getClientId", "()Ljava/lang/String;", "setClientId", "(Ljava/lang/String;)V", "code", "getCode", "setCode", "codeVerifier", "getCodeVerifier", "setCodeVerifier", "grantType", "getGrantType", "setGrantType", "redirectUri", "getRedirectUri", "setRedirectUri", "refreshToken", "getRefreshToken", "setRefreshToken", "build", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String clientId;
        private String code;
        private String codeVerifier;
        private String grantType;
        private String redirectUri;
        private String refreshToken;

        public final String getClientId() {
            return this.clientId;
        }

        public final void setClientId(String str) {
            this.clientId = str;
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

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CreateOAuth2TokenRequestBody x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.clientId = x.getClientId();
            this.code = x.getCode();
            this.codeVerifier = x.getCodeVerifier();
            this.grantType = x.getGrantType();
            this.redirectUri = x.getRedirectUri();
            this.refreshToken = x.getRefreshToken();
        }

        public final CreateOAuth2TokenRequestBody build() {
            return new CreateOAuth2TokenRequestBody(this, null);
        }

        public final Builder correctErrors$aws_config() {
            if (this.clientId == null) {
                this.clientId = "";
            }
            if (this.grantType == null) {
                this.grantType = "";
            }
            return this;
        }
    }
}
