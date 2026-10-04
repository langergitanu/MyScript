package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.identity.IdentityProviderChain;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BearerTokenProviderChain.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0017\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u0006\u0010\tJ\u0016\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/BearerTokenProviderChain;", "Laws/smithy/kotlin/runtime/identity/IdentityProviderChain;", "Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;", "Laws/smithy/kotlin/runtime/http/auth/BearerToken;", "providers", "", "<init>", "([Laws/smithy/kotlin/runtime/http/auth/BearerTokenProvider;)V", "", "(Ljava/util/List;)V", "resolve", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BearerTokenProviderChain extends IdentityProviderChain<BearerTokenProvider, BearerToken> implements BearerTokenProvider {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BearerTokenProviderChain(BearerTokenProvider... providers) {
        super((IdentityProvider[]) Arrays.copyOf(providers, providers.length));
        Intrinsics.checkNotNullParameter(providers, "providers");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BearerTokenProviderChain(List<? extends BearerTokenProvider> providers) {
        Intrinsics.checkNotNullParameter(providers, "providers");
        BearerTokenProvider[] bearerTokenProviderArr = (BearerTokenProvider[]) providers.toArray(new BearerTokenProvider[0]);
        this((BearerTokenProvider[]) Arrays.copyOf(bearerTokenProviderArr, bearerTokenProviderArr.length));
    }

    @Override // aws.smithy.kotlin.runtime.identity.IdentityProviderChain, aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super BearerToken> continuation) {
        return super.resolve(attributes, continuation);
    }
}
