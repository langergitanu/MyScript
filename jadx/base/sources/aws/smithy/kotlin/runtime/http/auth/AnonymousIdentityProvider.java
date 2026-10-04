package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.identity.Identity;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: AnonymousAuthScheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/AnonymousIdentityProvider;", "Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "<init>", "()V", "resolve", "Laws/smithy/kotlin/runtime/identity/Identity;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnonymousIdentityProvider implements IdentityProvider {
    public static final AnonymousIdentityProvider INSTANCE = new AnonymousIdentityProvider();

    private AnonymousIdentityProvider() {
    }

    @Override // aws.smithy.kotlin.runtime.identity.IdentityProvider
    public Object resolve(Attributes attributes, Continuation<? super Identity> continuation) {
        return AnonymousIdentity.INSTANCE;
    }
}
