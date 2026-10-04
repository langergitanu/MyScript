package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAuth2ErrorCode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000f2\u00020\u0001:\b\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "AuthcodeExpired", "InsufficientPermissions", "InvalidRequest", "ServerError", "TokenExpired", "UserCredentialsChanged", "SdkUnknown", "Companion", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$AuthcodeExpired;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$InsufficientPermissions;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$InvalidRequest;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$SdkUnknown;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$ServerError;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$TokenExpired;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$UserCredentialsChanged;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class OAuth2ErrorCode {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<OAuth2ErrorCode> values = CollectionsKt.listOf((Object[]) new OAuth2ErrorCode[]{AuthcodeExpired.INSTANCE, InsufficientPermissions.INSTANCE, InvalidRequest.INSTANCE, ServerError.INSTANCE, TokenExpired.INSTANCE, UserCredentialsChanged.INSTANCE});

    public /* synthetic */ OAuth2ErrorCode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getValue();

    private OAuth2ErrorCode() {
    }

    /* JADX INFO: compiled from: OAuth2ErrorCode.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$AuthcodeExpired;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class AuthcodeExpired extends OAuth2ErrorCode {
        public static final AuthcodeExpired INSTANCE = new AuthcodeExpired();
        private static final String value = "AUTHCODE_EXPIRED";

        private AuthcodeExpired() {
            super(null);
        }

        @Override // aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode
        public String getValue() {
            return value;
        }

        public String toString() {
            return "AuthcodeExpired";
        }
    }

    /* JADX INFO: compiled from: OAuth2ErrorCode.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$InsufficientPermissions;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class InsufficientPermissions extends OAuth2ErrorCode {
        public static final InsufficientPermissions INSTANCE = new InsufficientPermissions();
        private static final String value = "INSUFFICIENT_PERMISSIONS";

        private InsufficientPermissions() {
            super(null);
        }

        @Override // aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode
        public String getValue() {
            return value;
        }

        public String toString() {
            return "InsufficientPermissions";
        }
    }

    /* JADX INFO: compiled from: OAuth2ErrorCode.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$InvalidRequest;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class InvalidRequest extends OAuth2ErrorCode {
        public static final InvalidRequest INSTANCE = new InvalidRequest();
        private static final String value = "INVALID_REQUEST";

        private InvalidRequest() {
            super(null);
        }

        @Override // aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode
        public String getValue() {
            return value;
        }

        public String toString() {
            return "InvalidRequest";
        }
    }

    /* JADX INFO: compiled from: OAuth2ErrorCode.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$ServerError;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ServerError extends OAuth2ErrorCode {
        public static final ServerError INSTANCE = new ServerError();
        private static final String value = "server_error";

        private ServerError() {
            super(null);
        }

        @Override // aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode
        public String getValue() {
            return value;
        }

        public String toString() {
            return "ServerError";
        }
    }

    /* JADX INFO: compiled from: OAuth2ErrorCode.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$TokenExpired;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class TokenExpired extends OAuth2ErrorCode {
        public static final TokenExpired INSTANCE = new TokenExpired();
        private static final String value = "TOKEN_EXPIRED";

        private TokenExpired() {
            super(null);
        }

        @Override // aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode
        public String getValue() {
            return value;
        }

        public String toString() {
            return "TokenExpired";
        }
    }

    /* JADX INFO: compiled from: OAuth2ErrorCode.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\b\u001a\u00020\u0005H\u0096\u0080\u0004R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$UserCredentialsChanged;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "<init>", "()V", "value", "", "getValue", "()Ljava/lang/String;", "toString", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class UserCredentialsChanged extends OAuth2ErrorCode {
        public static final UserCredentialsChanged INSTANCE = new UserCredentialsChanged();
        private static final String value = "USER_CREDENTIALS_CHANGED";

        private UserCredentialsChanged() {
            super(null);
        }

        @Override // aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode
        public String getValue() {
            return value;
        }

        public String toString() {
            return "UserCredentialsChanged";
        }
    }

    /* JADX INFO: compiled from: OAuth2ErrorCode.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\u0003H\u0096\u0080\u0004J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0083\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$SdkUnknown;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "value", "", "<init>", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class SdkUnknown extends OAuth2ErrorCode {
        private final String value;

        public static /* synthetic */ SdkUnknown copy$default(SdkUnknown sdkUnknown, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sdkUnknown.value;
            }
            return sdkUnknown.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final SdkUnknown copy(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new SdkUnknown(value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof SdkUnknown) && Intrinsics.areEqual(this.value, ((SdkUnknown) other).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SdkUnknown(String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.OAuth2ErrorCode
        public String getValue() {
            return this.value;
        }

        public String toString() {
            return "SdkUnknown(" + getValue() + ')';
        }
    }

    /* JADX INFO: compiled from: OAuth2ErrorCode.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode$Companion;", "", "<init>", "()V", "fromValue", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/OAuth2ErrorCode;", "value", "", "values", "", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final OAuth2ErrorCode fromValue(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            switch (value.hashCode()) {
                case -2054838772:
                    if (value.equals("server_error")) {
                        return ServerError.INSTANCE;
                    }
                    break;
                case -2032477093:
                    if (value.equals("AUTHCODE_EXPIRED")) {
                        return AuthcodeExpired.INSTANCE;
                    }
                    break;
                case -1345867105:
                    if (value.equals("TOKEN_EXPIRED")) {
                        return TokenExpired.INSTANCE;
                    }
                    break;
                case -1125000185:
                    if (value.equals("INVALID_REQUEST")) {
                        return InvalidRequest.INSTANCE;
                    }
                    break;
                case 895372733:
                    if (value.equals("USER_CREDENTIALS_CHANGED")) {
                        return UserCredentialsChanged.INSTANCE;
                    }
                    break;
                case 1052361256:
                    if (value.equals("INSUFFICIENT_PERMISSIONS")) {
                        return InsufficientPermissions.INSTANCE;
                    }
                    break;
            }
            return new SdkUnknown(value);
        }

        public final List<OAuth2ErrorCode> values() {
            return OAuth2ErrorCode.values;
        }
    }
}
