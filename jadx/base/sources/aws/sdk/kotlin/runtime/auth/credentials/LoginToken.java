package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginTokenProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jq\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006-"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/LoginToken;", "", "accessKeyId", "", "secretAccessKey", "sessionToken", "accountId", "tokenType", "expiresAt", "Laws/smithy/kotlin/runtime/time/Instant;", "refreshToken", "idToken", "clientId", "dpopKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/time/Instant;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "getSecretAccessKey", "getSessionToken", "getAccountId", "getTokenType", "getExpiresAt", "()Laws/smithy/kotlin/runtime/time/Instant;", "getRefreshToken", "getIdToken", "getClientId", "getDpopKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class LoginToken {
    private final String accessKeyId;
    private final String accountId;
    private final String clientId;
    private final String dpopKey;
    private final Instant expiresAt;
    private final String idToken;
    private final String refreshToken;
    private final String secretAccessKey;
    private final String sessionToken;
    private final String tokenType;

    public static /* synthetic */ LoginToken copy$default(LoginToken loginToken, String str, String str2, String str3, String str4, String str5, Instant instant, String str6, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginToken.accessKeyId;
        }
        if ((i & 2) != 0) {
            str2 = loginToken.secretAccessKey;
        }
        if ((i & 4) != 0) {
            str3 = loginToken.sessionToken;
        }
        if ((i & 8) != 0) {
            str4 = loginToken.accountId;
        }
        if ((i & 16) != 0) {
            str5 = loginToken.tokenType;
        }
        if ((i & 32) != 0) {
            instant = loginToken.expiresAt;
        }
        if ((i & 64) != 0) {
            str6 = loginToken.refreshToken;
        }
        if ((i & 128) != 0) {
            str7 = loginToken.idToken;
        }
        if ((i & 256) != 0) {
            str8 = loginToken.clientId;
        }
        if ((i & 512) != 0) {
            str9 = loginToken.dpopKey;
        }
        String str10 = str8;
        String str11 = str9;
        String str12 = str6;
        String str13 = str7;
        String str14 = str5;
        Instant instant2 = instant;
        return loginToken.copy(str, str2, str3, str4, str14, instant2, str12, str13, str10, str11);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getDpopKey() {
        return this.dpopKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSessionToken() {
        return this.sessionToken;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAccountId() {
        return this.accountId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getTokenType() {
        return this.tokenType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Instant getExpiresAt() {
        return this.expiresAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getIdToken() {
        return this.idToken;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    public final LoginToken copy(String accessKeyId, String secretAccessKey, String sessionToken, String accountId, String tokenType, Instant expiresAt, String refreshToken, String idToken, String clientId, String dpopKey) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(dpopKey, "dpopKey");
        return new LoginToken(accessKeyId, secretAccessKey, sessionToken, accountId, tokenType, expiresAt, refreshToken, idToken, clientId, dpopKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginToken)) {
            return false;
        }
        LoginToken loginToken = (LoginToken) other;
        return Intrinsics.areEqual(this.accessKeyId, loginToken.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, loginToken.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, loginToken.sessionToken) && Intrinsics.areEqual(this.accountId, loginToken.accountId) && Intrinsics.areEqual(this.tokenType, loginToken.tokenType) && Intrinsics.areEqual(this.expiresAt, loginToken.expiresAt) && Intrinsics.areEqual(this.refreshToken, loginToken.refreshToken) && Intrinsics.areEqual(this.idToken, loginToken.idToken) && Intrinsics.areEqual(this.clientId, loginToken.clientId) && Intrinsics.areEqual(this.dpopKey, loginToken.dpopKey);
    }

    public int hashCode() {
        int iHashCode = ((((((this.accessKeyId.hashCode() * 31) + this.secretAccessKey.hashCode()) * 31) + this.sessionToken.hashCode()) * 31) + this.accountId.hashCode()) * 31;
        String str = this.tokenType;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.expiresAt.hashCode()) * 31) + this.refreshToken.hashCode()) * 31;
        String str2 = this.idToken;
        return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.clientId.hashCode()) * 31) + this.dpopKey.hashCode();
    }

    public String toString() {
        return "LoginToken(accessKeyId=" + this.accessKeyId + ", secretAccessKey=" + this.secretAccessKey + ", sessionToken=" + this.sessionToken + ", accountId=" + this.accountId + ", tokenType=" + this.tokenType + ", expiresAt=" + this.expiresAt + ", refreshToken=" + this.refreshToken + ", idToken=" + this.idToken + ", clientId=" + this.clientId + ", dpopKey=" + this.dpopKey + ')';
    }

    public LoginToken(String accessKeyId, String secretAccessKey, String sessionToken, String accountId, String str, Instant expiresAt, String refreshToken, String str2, String clientId, String dpopKey) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(dpopKey, "dpopKey");
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
        this.sessionToken = sessionToken;
        this.accountId = accountId;
        this.tokenType = str;
        this.expiresAt = expiresAt;
        this.refreshToken = refreshToken;
        this.idToken = str2;
        this.clientId = clientId;
        this.dpopKey = dpopKey;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LoginToken(String str, String str2, String str3, String str4, String str5, Instant instant, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str10;
        String str11;
        String str12;
        str5 = (i & 16) != 0 ? null : str5;
        if ((i & 128) != 0) {
            str10 = str9;
            str11 = str8;
            str12 = null;
        } else {
            str10 = str9;
            str11 = str8;
            str12 = str7;
        }
        this(str, str2, str3, str4, str5, instant, str6, str12, str11, str10);
    }

    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    public final String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public final Instant getExpiresAt() {
        return this.expiresAt;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final String getIdToken() {
        return this.idToken;
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getDpopKey() {
        return this.dpopKey;
    }
}
