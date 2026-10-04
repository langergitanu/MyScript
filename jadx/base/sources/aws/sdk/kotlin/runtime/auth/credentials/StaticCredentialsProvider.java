package aws.sdk.kotlin.runtime.auth.credentials;

import aws.sdk.kotlin.runtime.auth.credentials.internal.CredentialsExtKt;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderKt;
import aws.smithy.kotlin.runtime.collections.Attributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StaticCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/StaticCredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "credentials", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "<init>", "(Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;)V", "builder", "Laws/sdk/kotlin/runtime/auth/credentials/StaticCredentialsProvider$Builder;", "(Laws/sdk/kotlin/runtime/auth/credentials/StaticCredentialsProvider$Builder;)V", "getCredentials", "()Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "resolve", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toString", "", "Companion", "Builder", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class StaticCredentialsProvider implements CredentialsProvider {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Credentials credentials;

    public /* synthetic */ StaticCredentialsProvider(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public StaticCredentialsProvider(Credentials credentials) {
        Intrinsics.checkNotNullParameter(credentials, "credentials");
        this.credentials = credentials;
    }

    public final Credentials getCredentials() {
        return this.credentials;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private StaticCredentialsProvider(Builder builder) {
        String accessKeyId = builder.getAccessKeyId();
        Intrinsics.checkNotNull(accessKeyId);
        String secretAccessKey = builder.getSecretAccessKey();
        Intrinsics.checkNotNull(secretAccessKey);
        this(CredentialsExtKt.credentials$default(accessKeyId, secretAccessKey, builder.getSessionToken(), null, "Static", builder.getAccountId(), 8, null));
    }

    @Override // aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        return this.credentials;
    }

    /* JADX INFO: compiled from: StaticCredentialsProvider.kt */
    @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0002¨\u0006\u000b"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/StaticCredentialsProvider$Companion;", "", "<init>", "()V", "invoke", "Laws/sdk/kotlin/runtime/auth/credentials/StaticCredentialsProvider;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/runtime/auth/credentials/StaticCredentialsProvider$Builder;", "", "Lkotlin/ExtensionFunctionType;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StaticCredentialsProvider invoke(Function1<? super Builder, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder();
            block.invoke(builder);
            return builder.build();
        }
    }

    /* JADX INFO: compiled from: StaticCredentialsProvider.kt */
    @Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0015"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/StaticCredentialsProvider$Builder;", "", "<init>", "()V", "accessKeyId", "", "getAccessKeyId", "()Ljava/lang/String;", "setAccessKeyId", "(Ljava/lang/String;)V", "secretAccessKey", "getSecretAccessKey", "setSecretAccessKey", "sessionToken", "getSessionToken", "setSessionToken", "accountId", "getAccountId", "setAccountId", "build", "Laws/sdk/kotlin/runtime/auth/credentials/StaticCredentialsProvider;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Builder {
        private String accessKeyId;
        private String accountId;
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

        public final String getAccountId() {
            return this.accountId;
        }

        public final void setAccountId(String str) {
            this.accountId = str;
        }

        public final StaticCredentialsProvider build() {
            if (this.accessKeyId == null || this.secretAccessKey == null) {
                throw new IllegalArgumentException("StaticCredentialsProvider - accessKeyId and secretAccessKey must not be null");
            }
            return new StaticCredentialsProvider(this, null);
        }
    }

    public String toString() {
        return CredentialsProviderKt.getSimpleClassName(this);
    }
}
