package aws.sdk.kotlin.runtime.auth.credentials;

import aws.smithy.kotlin.runtime.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonCredentialsDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/JsonCredentialsResponse;", "", "<init>", "()V", "SessionCredentials", "Error", "Laws/sdk/kotlin/runtime/auth/credentials/JsonCredentialsResponse$Error;", "Laws/sdk/kotlin/runtime/auth/credentials/JsonCredentialsResponse$SessionCredentials;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class JsonCredentialsResponse {
    public /* synthetic */ JsonCredentialsResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private JsonCredentialsResponse() {
    }

    /* JADX INFO: compiled from: JsonCredentialsDeserializer.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/JsonCredentialsResponse$SessionCredentials;", "Laws/sdk/kotlin/runtime/auth/credentials/JsonCredentialsResponse;", "accessKeyId", "", "secretAccessKey", "sessionToken", "expiration", "Laws/smithy/kotlin/runtime/time/Instant;", "accountId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Laws/smithy/kotlin/runtime/time/Instant;Ljava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "getSecretAccessKey", "getSessionToken", "getExpiration", "()Laws/smithy/kotlin/runtime/time/Instant;", "getAccountId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SessionCredentials extends JsonCredentialsResponse {
        private final String accessKeyId;
        private final String accountId;
        private final Instant expiration;
        private final String secretAccessKey;
        private final String sessionToken;

        public static /* synthetic */ SessionCredentials copy$default(SessionCredentials sessionCredentials, String str, String str2, String str3, Instant instant, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionCredentials.accessKeyId;
            }
            if ((i & 2) != 0) {
                str2 = sessionCredentials.secretAccessKey;
            }
            if ((i & 4) != 0) {
                str3 = sessionCredentials.sessionToken;
            }
            if ((i & 8) != 0) {
                instant = sessionCredentials.expiration;
            }
            if ((i & 16) != 0) {
                str4 = sessionCredentials.accountId;
            }
            String str5 = str4;
            String str6 = str3;
            return sessionCredentials.copy(str, str2, str6, instant, str5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAccessKeyId() {
            return this.accessKeyId;
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
        public final Instant getExpiration() {
            return this.expiration;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAccountId() {
            return this.accountId;
        }

        public final SessionCredentials copy(String accessKeyId, String secretAccessKey, String sessionToken, Instant expiration, String accountId) {
            Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
            Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
            Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
            return new SessionCredentials(accessKeyId, secretAccessKey, sessionToken, expiration, accountId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionCredentials)) {
                return false;
            }
            SessionCredentials sessionCredentials = (SessionCredentials) other;
            return Intrinsics.areEqual(this.accessKeyId, sessionCredentials.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, sessionCredentials.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, sessionCredentials.sessionToken) && Intrinsics.areEqual(this.expiration, sessionCredentials.expiration) && Intrinsics.areEqual(this.accountId, sessionCredentials.accountId);
        }

        public int hashCode() {
            int iHashCode = ((((this.accessKeyId.hashCode() * 31) + this.secretAccessKey.hashCode()) * 31) + this.sessionToken.hashCode()) * 31;
            Instant instant = this.expiration;
            int iHashCode2 = (iHashCode + (instant == null ? 0 : instant.hashCode())) * 31;
            String str = this.accountId;
            return iHashCode2 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "SessionCredentials(accessKeyId=" + this.accessKeyId + ", secretAccessKey=" + this.secretAccessKey + ", sessionToken=" + this.sessionToken + ", expiration=" + this.expiration + ", accountId=" + this.accountId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SessionCredentials(String accessKeyId, String secretAccessKey, String sessionToken, Instant instant, String str) {
            super(null);
            Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
            Intrinsics.checkNotNullParameter(secretAccessKey, "secretAccessKey");
            Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
            this.accessKeyId = accessKeyId;
            this.secretAccessKey = secretAccessKey;
            this.sessionToken = sessionToken;
            this.expiration = instant;
            this.accountId = str;
        }

        public /* synthetic */ SessionCredentials(String str, String str2, String str3, Instant instant, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, instant, (i & 16) != 0 ? null : str4);
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

        public final Instant getExpiration() {
            return this.expiration;
        }

        public final String getAccountId() {
            return this.accountId;
        }
    }

    /* JADX INFO: compiled from: JsonCredentialsDeserializer.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0083\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/JsonCredentialsResponse$Error;", "Laws/sdk/kotlin/runtime/auth/credentials/JsonCredentialsResponse;", "code", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class Error extends JsonCredentialsResponse {
        private final String code;
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.code;
            }
            if ((i & 2) != 0) {
                str2 = error.message;
            }
            return error.copy(str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String code, String message) {
            return new Error(code, message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            Error error = (Error) other;
            return Intrinsics.areEqual(this.code, error.code) && Intrinsics.areEqual(this.message, error.message);
        }

        public int hashCode() {
            String str = this.code;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.message;
            return iHashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Error(code=" + this.code + ", message=" + this.message + ')';
        }

        public Error(String str, String str2) {
            super(null);
            this.code = str;
            this.message = str2;
        }

        public final String getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
