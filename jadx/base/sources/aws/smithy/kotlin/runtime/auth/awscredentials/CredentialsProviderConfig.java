package aws.smithy.kotlin.runtime.auth.awscredentials;

import kotlin.Metadata;

/* JADX INFO: compiled from: CredentialsProviderConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProviderConfig;", "", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getCredentialsProvider", "()Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "credentialsProvider", "Builder", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CredentialsProviderConfig {

    /* JADX INFO: compiled from: CredentialsProviderConfig.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProviderConfig$Builder;", "", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "getCredentialsProvider", "()Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "setCredentialsProvider", "(Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;)V", "credentialsProvider", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Builder {
        CredentialsProvider getCredentialsProvider();

        void setCredentialsProvider(CredentialsProvider credentialsProvider);
    }

    CredentialsProvider getCredentialsProvider();
}
