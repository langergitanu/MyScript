package aws.smithy.kotlin.runtime.auth.awscredentials;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.identity.IdentityProviderChain;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CredentialsProviderChain.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0017\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u0006\u0010\tJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0096@¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u00020\u000eH\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProviderChain;", "Laws/smithy/kotlin/runtime/identity/IdentityProviderChain;", "Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "", "providers", "<init>", "([Laws/smithy/kotlin/runtime/auth/awscredentials/CredentialsProvider;)V", "", "(Ljava/util/List;)V", "Laws/smithy/kotlin/runtime/collections/Attributes;", "attributes", "resolve", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "aws-credentials"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CredentialsProviderChain extends IdentityProviderChain<CredentialsProvider, Credentials> implements CredentialsProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialsProviderChain(CredentialsProvider... providers) {
        super((IdentityProvider[]) Arrays.copyOf(providers, providers.length));
        Intrinsics.checkNotNullParameter(providers, "providers");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CredentialsProviderChain(List<? extends CredentialsProvider> providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        CredentialsProvider[] credentialsProviderArr = (CredentialsProvider[]) providers.toArray(new CredentialsProvider[0]);
        this((CredentialsProvider[]) Arrays.copyOf(credentialsProviderArr, credentialsProviderArr.length));
    }

    @Override // aws.smithy.kotlin.runtime.identity.IdentityProviderChain, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super Credentials> continuation) {
        return super.resolve(attributes, continuation);
    }

    @Override // aws.smithy.kotlin.runtime.identity.IdentityProviderChain
    public String toString() {
        return ArraysKt.joinToString$default(getProviders(), " -> ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
