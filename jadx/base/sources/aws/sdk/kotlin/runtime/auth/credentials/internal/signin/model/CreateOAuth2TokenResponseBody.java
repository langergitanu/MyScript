package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model;

import aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.AccessToken;
import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: CreateOAuth2TokenResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000  2\u00020\u0001:\u0002 !B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0016\u001a\u00020\u000fH\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u000bH\u0096\u0080\u0004J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u001b\u001a\u00020\u00002\u0019\b\u0002\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\u0002\b\u001fH\u0086\bø\u0001\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody$Builder;)V", "accessToken", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken;", "getAccessToken", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken;", "expiresIn", "", "getExpiresIn", "()I", "idToken", "", "getIdToken", "()Ljava/lang/String;", "refreshToken", "getRefreshToken", "tokenType", "getTokenType", "toString", "hashCode", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateOAuth2TokenResponseBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AccessToken accessToken;
    private final int expiresIn;
    private final String idToken;
    private final String refreshToken;
    private final String tokenType;

    public /* synthetic */ CreateOAuth2TokenResponseBody(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private CreateOAuth2TokenResponseBody(Builder builder) {
        this.accessToken = builder.getAccessToken();
        Integer expiresIn = builder.getExpiresIn();
        if (expiresIn == null) {
            throw new IllegalArgumentException("A non-null value must be provided for expiresIn".toString());
        }
        this.expiresIn = expiresIn.intValue();
        this.idToken = builder.getIdToken();
        String refreshToken = builder.getRefreshToken();
        if (refreshToken == null) {
            throw new IllegalArgumentException("A non-null value must be provided for refreshToken".toString());
        }
        this.refreshToken = refreshToken;
        String tokenType = builder.getTokenType();
        if (tokenType == null) {
            throw new IllegalArgumentException("A non-null value must be provided for tokenType".toString());
        }
        this.tokenType = tokenType;
    }

    public final AccessToken getAccessToken() {
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

    /* JADX INFO: compiled from: CreateOAuth2TokenResponseBody.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CreateOAuth2TokenResponseBody invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CreateOAuth2TokenResponseBody(accessToken=*** Sensitive Data Redacted ***,");
        sb.append("expiresIn=" + this.expiresIn + AbstractJsonLexerKt.COMMA);
        sb.append("idToken=" + this.idToken + AbstractJsonLexerKt.COMMA);
        sb.append("refreshToken=*** Sensitive Data Redacted ***,");
        sb.append("tokenType=" + this.tokenType);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        AccessToken accessToken = this.accessToken;
        int iHashCode = (((accessToken != null ? accessToken.hashCode() : 0) * 31) + this.expiresIn) * 31;
        String str = this.idToken;
        return ((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.refreshToken.hashCode()) * 31) + this.tokenType.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        CreateOAuth2TokenResponseBody createOAuth2TokenResponseBody = (CreateOAuth2TokenResponseBody) other;
        return Intrinsics.areEqual(this.accessToken, createOAuth2TokenResponseBody.accessToken) && this.expiresIn == createOAuth2TokenResponseBody.expiresIn && Intrinsics.areEqual(this.idToken, createOAuth2TokenResponseBody.idToken) && Intrinsics.areEqual(this.refreshToken, createOAuth2TokenResponseBody.refreshToken) && Intrinsics.areEqual(this.tokenType, createOAuth2TokenResponseBody.tokenType);
    }

    public static /* synthetic */ CreateOAuth2TokenResponseBody copy$default(CreateOAuth2TokenResponseBody createOAuth2TokenResponseBody, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.CreateOAuth2TokenResponseBody.copy.1
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
        Builder builder = new Builder(createOAuth2TokenResponseBody);
        block.invoke(builder);
        return builder.build();
    }

    public final CreateOAuth2TokenResponseBody copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: CreateOAuth2TokenResponseBody.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010 \u001a\u00020\u0005H\u0001J\u001f\u0010\u0007\u001a\u00020!2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020!0#¢\u0006\u0002\b%J\r\u0010&\u001a\u00020\u0000H\u0000¢\u0006\u0002\b'R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006("}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/CreateOAuth2TokenResponseBody;)V", "accessToken", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken;", "getAccessToken", "()Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken;", "setAccessToken", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken;)V", "expiresIn", "", "getExpiresIn", "()Ljava/lang/Integer;", "setExpiresIn", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "idToken", "", "getIdToken", "()Ljava/lang/String;", "setIdToken", "(Ljava/lang/String;)V", "refreshToken", "getRefreshToken", "setRefreshToken", "tokenType", "getTokenType", "setTokenType", "build", "", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken$Builder;", "Lkotlin/ExtensionFunctionType;", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private AccessToken accessToken;
        private Integer expiresIn;
        private String idToken;
        private String refreshToken;
        private String tokenType;

        public final AccessToken getAccessToken() {
            return this.accessToken;
        }

        public final void setAccessToken(AccessToken accessToken) {
            this.accessToken = accessToken;
        }

        public final Integer getExpiresIn() {
            return this.expiresIn;
        }

        public final void setExpiresIn(Integer num) {
            this.expiresIn = num;
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
        public Builder(CreateOAuth2TokenResponseBody x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.accessToken = x.getAccessToken();
            this.expiresIn = Integer.valueOf(x.getExpiresIn());
            this.idToken = x.getIdToken();
            this.refreshToken = x.getRefreshToken();
            this.tokenType = x.getTokenType();
        }

        public final CreateOAuth2TokenResponseBody build() {
            return new CreateOAuth2TokenResponseBody(this, null);
        }

        public final void accessToken(Function1<? super AccessToken.Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.accessToken = CreateOAuth2TokenResponseBodyKt.f415x847748d0.invoke(block);
        }

        public final Builder correctErrors$aws_config() {
            if (this.expiresIn == null) {
                this.expiresIn = 0;
            }
            if (this.refreshToken == null) {
                this.refreshToken = "";
            }
            if (this.tokenType == null) {
                this.tokenType = "";
            }
            return this;
        }
    }
}
