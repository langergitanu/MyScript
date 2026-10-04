package aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.auth;

import aws.sdk.kotlin.runtime.auth.credentials.internal.ssooidc.SsoOidcClient;
import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.http.auth.AnonymousIdentityProvider;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.identity.IdentityProviderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SsoOidcIdentityProviderConfigAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/auth/SsoOidcIdentityProviderConfigAdapter;", "Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;", "config", "Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/SsoOidcClient$Config;", "<init>", "(Laws/sdk/kotlin/runtime/auth/credentials/internal/ssooidc/SsoOidcClient$Config;)V", "identityProviderForScheme", "Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "schemeId", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "identityProviderForScheme-kHcdgsI", "(Ljava/lang/String;)Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "aws-config"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SsoOidcIdentityProviderConfigAdapter implements IdentityProviderConfig {
    private final SsoOidcClient.Config config;

    public SsoOidcIdentityProviderConfigAdapter(SsoOidcClient.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @Override // aws.smithy.kotlin.runtime.identity.IdentityProviderConfig
    /* JADX INFO: renamed from: identityProviderForScheme-kHcdgsI */
    public IdentityProvider mo12051identityProviderForSchemekHcdgsI(String schemeId) {
        Intrinsics.checkNotNullParameter(schemeId, "schemeId");
        if (Intrinsics.areEqual(schemeId, "aws.auth#sigv4")) {
            return this.config.getCredentialsProvider();
        }
        if (Intrinsics.areEqual(schemeId, "smithy.api#noAuth")) {
            return AnonymousIdentityProvider.INSTANCE;
        }
        throw new IllegalStateException(("auth scheme " + ((Object) AuthSchemeId.m12121toStringimpl(schemeId)) + " not configured for client").toString());
    }
}
