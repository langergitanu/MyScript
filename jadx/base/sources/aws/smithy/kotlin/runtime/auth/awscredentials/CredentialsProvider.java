package aws.smithy.kotlin.runtime.auth.awscredentials;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CredentialsProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "Laws/smithy/kotlin/runtime/collections/Attributes;", "attributes", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "resolve", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface CredentialsProvider extends IdentityProvider {
    @Override // aws.smithy.kotlin.runtime.identity.IdentityProvider
    Object resolve(Attributes attributes, Continuation<? super Credentials> continuation);
}
