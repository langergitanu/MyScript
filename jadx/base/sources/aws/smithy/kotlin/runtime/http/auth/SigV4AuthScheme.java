package aws.smithy.kotlin.runtime.http.auth;

import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner;
import aws.smithy.kotlin.runtime.http.auth.AwsHttpSigner;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.identity.IdentityProviderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SigV4AuthScheme.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nR\u0016\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/http/auth/SigV4AuthScheme;", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "config", "Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner$Config;", "<init>", "(Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner$Config;)V", "awsSigner", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "serviceName", "", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Ljava/lang/String;)V", "schemeId", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getSchemeId-DepwgT4", "()Ljava/lang/String;", "Ljava/lang/String;", "signer", "Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner;", "getSigner", "()Laws/smithy/kotlin/runtime/http/auth/AwsHttpSigner;", "http-auth-aws"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigV4AuthScheme implements AuthScheme {
    private final String schemeId;
    private final AwsHttpSigner signer;

    public SigV4AuthScheme(AwsHttpSigner.Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.schemeId = AuthSchemeId.INSTANCE.m12124getAwsSigV4DepwgT4();
        this.signer = new AwsHttpSigner(config);
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.AuthScheme
    public /* bridge */ IdentityProvider identityProvider(IdentityProviderConfig identityProviderConfig) {
        return super.identityProvider(identityProviderConfig);
    }

    public /* synthetic */ SigV4AuthScheme(AwsSigner awsSigner, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(awsSigner, (i & 2) != 0 ? null : str);
    }

    public SigV4AuthScheme(AwsSigner awsSigner, String str) {
        Intrinsics.checkNotNullParameter(awsSigner, "awsSigner");
        AwsHttpSigner.Config config = new AwsHttpSigner.Config();
        config.setSigner(awsSigner);
        config.setService(str);
        this(config);
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.AuthScheme
    /* JADX INFO: renamed from: getSchemeId-DepwgT4, reason: from getter */
    public String getSchemeId() {
        return this.schemeId;
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.AuthScheme
    public AwsHttpSigner getSigner() {
        return this.signer;
    }
}
