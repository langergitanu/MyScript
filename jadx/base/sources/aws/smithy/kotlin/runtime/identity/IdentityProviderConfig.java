package aws.smithy.kotlin.runtime.identity;

import kotlin.Metadata;

/* JADX INFO: compiled from: IdentityProviderConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;", "", "identityProviderForScheme", "Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "schemeId", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "identityProviderForScheme-kHcdgsI", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "identity-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IdentityProviderConfig {
    /* JADX INFO: renamed from: identityProviderForScheme-kHcdgsI */
    IdentityProvider mo12051identityProviderForSchemekHcdgsI(String schemeId);
}
