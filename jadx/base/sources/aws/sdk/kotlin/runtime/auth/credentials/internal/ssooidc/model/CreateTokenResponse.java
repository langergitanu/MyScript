package aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CreateTokenResponse.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0014\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u0015\u001a\u00020\u000bH\u0096\u0080\u0004J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0019\u001a\u00020\u00002\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0002\b\u001dH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse$Builder;)V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "expiresIn", "", "getExpiresIn", "()I", "idToken", "getIdToken", "refreshToken", "getRefreshToken", "tokenType", "getTokenType", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateTokenResponse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String accessToken;
    private final int expiresIn;
    private final String idToken;
    private final String refreshToken;
    private final String tokenType;

    public /* synthetic */ CreateTokenResponse(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateTokenResponse(Builder builder) {
        this.accessToken = builder.getAccessToken();
        this.expiresIn = builder.getExpiresIn();
        this.idToken = builder.getIdToken();
        this.refreshToken = builder.getRefreshToken();
        this.tokenType = builder.getTokenType();
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final int getExpiresIn() {
        return this.expiresIn;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    /* JADX INFO: compiled from: CreateTokenResponse.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateTokenResponse invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateTokenResponse(accessToken=*** Sensitive Data Redacted ***,");
        sb.append("expiresIn=" + this.expiresIn + AbstractJsonLexerKt.COMMA);
        sb.append("idToken=*** Sensitive Data Redacted ***,refreshToken=*** Sensitive Data Redacted ***,");
        sb.append("tokenType=" + this.tokenType);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        String str = this.accessToken;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + this.expiresIn) * 31;
        String str2 = this.idToken;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.refreshToken;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.tokenType;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CreateTokenResponse createTokenResponse = (CreateTokenResponse) other;
        return Intrinsics.areEqual(this.accessToken, createTokenResponse.accessToken) && this.expiresIn == createTokenResponse.expiresIn && Intrinsics.areEqual(this.idToken, createTokenResponse.idToken) && Intrinsics.areEqual(this.refreshToken, createTokenResponse.refreshToken) && Intrinsics.areEqual(this.tokenType, createTokenResponse.tokenType);
    }

    public static /* synthetic */ CreateTokenResponse copy$default(CreateTokenResponse createTokenResponse, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.model.CreateTokenResponse.copy.1
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
        Builder builder = new Builder(createTokenResponse);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateTokenResponse copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateTokenResponse.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u0005H\u0001J\r\u0010\u001d\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/model/CreateTokenResponse;)V", "accessToken", "", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "expiresIn", "", "getExpiresIn", "()I", "setExpiresIn", "(I)V", "idToken", "getIdToken", "setIdToken", "refreshToken", "getRefreshToken", "setRefreshToken", "tokenType", "getTokenType", "setTokenType", "build", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String accessToken;
        private int expiresIn;
        private String idToken;
        private String refreshToken;
        private String tokenType;

        public final Builder correctErrors$aws_config() {
            return this;
        }

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final void setAccessToken(String str) {
            this.accessToken = str;
        }

        public final int getExpiresIn() {
            return this.expiresIn;
        }

        public final void setExpiresIn(int i) {
            this.expiresIn = i;
        }

        public final String getIdToken() {
            return this.idToken;
        }

        public final void setIdToken(String str) {
            this.idToken = str;
        }

        public final String getRefreshToken() {
            return this.refreshToken;
        }

        public final void setRefreshToken(String str) {
            this.refreshToken = str;
        }

        public final String getTokenType() {
            return this.tokenType;
        }

        public final void setTokenType(String str) {
            this.tokenType = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(CreateTokenResponse x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.accessToken = x.getAccessToken();
            this.expiresIn = x.getExpiresIn();
            this.idToken = x.getIdToken();
            this.refreshToken = x.getRefreshToken();
            this.tokenType = x.getTokenType();
        }

        public final CreateTokenResponse build() {
            return new CreateTokenResponse(this, null);
        }
    }
}
