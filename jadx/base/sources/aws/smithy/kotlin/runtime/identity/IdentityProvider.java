package aws.smithy.kotlin.runtime.identity;

import aws.smithy.kotlin.runtime.collections.Attributes;
import aws.smithy.kotlin.runtime.collections.AttributesKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IdentityProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "", "resolve", "Laws/smithy/kotlin/runtime/identity/Identity;", "attributes", "Laws/smithy/kotlin/runtime/collections/Attributes;", "(Laws/smithy/kotlin/runtime/collections/Attributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "identity-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IdentityProvider {
    Object resolve(Attributes attributes, Continuation<? super Identity> continuation);

    /* JADX INFO: compiled from: IdentityProvider.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object resolve$default(IdentityProvider identityProvider, Attributes attributes, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve");
        }
        if ((i & 1) != 0) {
            attributes = AttributesKt.emptyAttributes();
        }
        return identityProvider.resolve(attributes, continuation);
    }
}
