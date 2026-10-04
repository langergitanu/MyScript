package aws.smithy.kotlin.runtime.identity;

import aws.smithy.kotlin.runtime.InternalApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IdentityProviderConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0003"}, m1599d2 = {"asIdentityProviderConfig", "Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;", "Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "identity-api"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class IdentityProviderConfigKt {
    @InternalApi
    public static final IdentityProviderConfig asIdentityProviderConfig(final IdentityProvider identityProvider) {
        Intrinsics.checkNotNullParameter(identityProvider, "<this>");
        return new IdentityProviderConfig() { // from class: aws.smithy.kotlin.runtime.identity.IdentityProviderConfigKt.asIdentityProviderConfig.1
            @Override // aws.smithy.kotlin.runtime.identity.IdentityProviderConfig
            /* JADX INFO: renamed from: identityProviderForScheme-kHcdgsI */
            public final IdentityProvider mo12051identityProviderForSchemekHcdgsI(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return identityProvider;
            }
        };
    }
}
