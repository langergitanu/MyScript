package aws.sdk.kotlin.runtime.auth.credentials.internal;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.smithy.kotlin.runtime.auth.awscredentials.CloseableCredentialsProvider;
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ManagedCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, m1599d2 = {"manage", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CloseableCredentialsProvider;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ManagedCredentialsProviderKt {
    @InternalSdkApi
    public static final CredentialsProvider manage(CloseableCredentialsProvider closeableCredentialsProvider) {
        Intrinsics.checkNotNullParameter(closeableCredentialsProvider, "<this>");
        return closeableCredentialsProvider instanceof ManagedCredentialsProvider ? closeableCredentialsProvider : new ManagedCredentialsProvider(closeableCredentialsProvider);
    }
}
