package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.identity.IdentityProviderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthScheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "", "schemeId", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getSchemeId-DepwgT4", "()Ljava/lang/String;", "identityProvider", "Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "identityProviderConfig", "Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;", "signer", "Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "getSigner", "()Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "http-auth-api"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AuthScheme {
    /* JADX INFO: renamed from: getSchemeId-DepwgT4 */
    String mo12074getSchemeIdDepwgT4();

    HttpSigner getSigner();

    /* JADX INFO: compiled from: AuthScheme.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static IdentityProvider identityProvider(AuthScheme authScheme, IdentityProviderConfig identityProviderConfig) {
            Intrinsics.checkNotNullParameter(identityProviderConfig, "identityProviderConfig");
            return AuthScheme.super.identityProvider(identityProviderConfig);
        }
    }

    default IdentityProvider identityProvider(IdentityProviderConfig identityProviderConfig) {
        Intrinsics.checkNotNullParameter(identityProviderConfig, "identityProviderConfig");
        return identityProviderConfig.mo12051identityProviderForSchemekHcdgsI(mo12074getSchemeIdDepwgT4());
    }
}
