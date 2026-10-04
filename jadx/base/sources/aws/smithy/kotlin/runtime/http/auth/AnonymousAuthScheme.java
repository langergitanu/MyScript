package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.identity.IdentityProviderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnonymousAuthScheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/AnonymousAuthScheme;", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "<init>", "()V", "schemeId", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getSchemeId-DepwgT4", "()Ljava/lang/String;", "Ljava/lang/String;", "signer", "Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "getSigner", "()Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "identityProvider", "Laws/smithy/kotlin/runtime/identity/IdentityProvider;", "identityProviderConfig", "Laws/smithy/kotlin/runtime/identity/IdentityProviderConfig;", "http-auth"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AnonymousAuthScheme implements AuthScheme {
    public static final AnonymousAuthScheme INSTANCE = new AnonymousAuthScheme();
    private static final String schemeId = AuthSchemeId.INSTANCE.m12123getAnonymousDepwgT4();
    private static final HttpSigner signer = AnonymousHttpSigner.INSTANCE;

    private AnonymousAuthScheme() {
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.AuthScheme
    /* JADX INFO: renamed from: getSchemeId-DepwgT4 */
    public String mo12074getSchemeIdDepwgT4() {
        return schemeId;
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.AuthScheme
    public HttpSigner getSigner() {
        return signer;
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.AuthScheme
    public IdentityProvider identityProvider(IdentityProviderConfig identityProviderConfig) {
        Intrinsics.checkNotNullParameter(identityProviderConfig, "identityProviderConfig");
        return AnonymousIdentityProvider.INSTANCE;
    }
}
