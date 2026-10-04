package aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model;

import aws.smithy.kotlin.runtime.SdkDsl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccessToken.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u000e\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J'\u0010\u0014\u001a\u00020\u00002\u0019\b\u0002\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0086\bø\u0001\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken;", "", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken$Builder;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken$Builder;)V", "accessKeyId", "", "getAccessKeyId", "()Ljava/lang/String;", "secretAccessKey", "getSecretAccessKey", "sessionToken", "getSessionToken", "toString", "hashCode", "", "equals", "", "other", "copy", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AccessToken {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String accessKeyId;
    private final String secretAccessKey;
    private final String sessionToken;

    public /* synthetic */ AccessToken(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private AccessToken(Builder builder) {
        String accessKeyId = builder.getAccessKeyId();
        if (accessKeyId == null) {
            throw new IllegalArgumentException("A non-null value must be provided for accessKeyId".toString());
        }
        this.accessKeyId = accessKeyId;
        String secretAccessKey = builder.getSecretAccessKey();
        if (secretAccessKey == null) {
            throw new IllegalArgumentException("A non-null value must be provided for secretAccessKey".toString());
        }
        this.secretAccessKey = secretAccessKey;
        String sessionToken = builder.getSessionToken();
        if (sessionToken == null) {
            throw new IllegalArgumentException("A non-null value must be provided for sessionToken".toString());
        }
        this.sessionToken = sessionToken;
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

    /* JADX INFO: compiled from: AccessToken.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AccessToken invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    public String toString() {
        return "AccessToken(*** Sensitive Data Redacted ***)";
    }

    public int hashCode() {
        return (((this.accessKeyId.hashCode() * 31) + this.secretAccessKey.hashCode()) * 31) + this.sessionToken.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        AccessToken accessToken = (AccessToken) other;
        return Intrinsics.areEqual(this.accessKeyId, accessToken.accessKeyId) && Intrinsics.areEqual(this.secretAccessKey, accessToken.secretAccessKey) && Intrinsics.areEqual(this.sessionToken, accessToken.sessionToken);
    }

    public static /* synthetic */ AccessToken copy$default(AccessToken accessToken, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            block = new Function1<Builder, Unit>() { // from class: aws.sdk.kotlin.runtime.auth.credentials.internal.signin.model.AccessToken.copy.1
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
        Builder builder = new Builder(accessToken);
        block.invoke(builder);
        return builder.build();
    }

    public final AccessToken copy(Function1<? super Builder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Builder builder = new Builder(this);
        block.invoke(builder);
        return builder.build();
    }

    /* JADX INFO: compiled from: AccessToken.kt */
    @SdkDsl
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0011¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0005H\u0001J\r\u0010\u0014\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0016"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken$Builder;", "", "<init>", "()V", "x", "Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken;", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/signin/model/AccessToken;)V", "accessKeyId", "", "getAccessKeyId", "()Ljava/lang/String;", "setAccessKeyId", "(Ljava/lang/String;)V", "secretAccessKey", "getSecretAccessKey", "setSecretAccessKey", "sessionToken", "getSessionToken", "setSessionToken", "build", "correctErrors", "correctErrors$aws_config", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String accessKeyId;
        private String secretAccessKey;
        private String sessionToken;

        public final String getAccessKeyId() {
            return this.accessKeyId;
        }

        public final void setAccessKeyId(String str) {
            this.accessKeyId = str;
        }

        public final String getSecretAccessKey() {
            return this.secretAccessKey;
        }

        public final void setSecretAccessKey(String str) {
            this.secretAccessKey = str;
        }

        public final String getSessionToken() {
            return this.sessionToken;
        }

        public final void setSessionToken(String str) {
            this.sessionToken = str;
        }

        public Builder() {
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(AccessToken x) {
            this();
            Intrinsics.checkNotNullParameter(x, "x");
            this.accessKeyId = x.getAccessKeyId();
            this.secretAccessKey = x.getSecretAccessKey();
            this.sessionToken = x.getSessionToken();
        }

        public final AccessToken build() {
            return new AccessToken(this, null);
        }

        public final Builder correctErrors$aws_config() {
            if (this.accessKeyId == null) {
                this.accessKeyId = "";
            }
            if (this.secretAccessKey == null) {
                this.secretAccessKey = "";
            }
            if (this.sessionToken == null) {
                this.sessionToken = "";
            }
            return this;
        }
    }
}
