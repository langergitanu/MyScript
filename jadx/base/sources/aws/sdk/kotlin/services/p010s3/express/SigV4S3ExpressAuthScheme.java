package aws.sdk.kotlin.services.p010s3.express;

import aws.smithy.kotlin.runtime.auth.AuthSchemeId;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigner;
import aws.smithy.kotlin.runtime.auth.awssigning.AwsSigningAlgorithm;
import aws.smithy.kotlin.runtime.http.auth.AuthScheme;
import aws.smithy.kotlin.runtime.http.auth.AwsHttpSigner;
import aws.smithy.kotlin.runtime.http.auth.HttpSigner;
import aws.smithy.kotlin.runtime.identity.IdentityProvider;
import aws.smithy.kotlin.runtime.identity.IdentityProviderConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SigV4S3ExpressAuthScheme.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nR\u0016\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/sdk/kotlin/services/s3/express/SigV4S3ExpressAuthScheme;", "Laws/smithy/kotlin/runtime/http/auth/AuthScheme;", "httpSigner", "Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "<init>", "(Laws/smithy/kotlin/runtime/http/auth/HttpSigner;)V", "awsSigner", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;", "serviceName", "", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigner;Ljava/lang/String;)V", "schemeId", "Laws/smithy/kotlin/runtime/auth/AuthSchemeId;", "getSchemeId-DepwgT4", "()Ljava/lang/String;", "Ljava/lang/String;", "signer", "getSigner", "()Laws/smithy/kotlin/runtime/http/auth/HttpSigner;", "s3"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigV4S3ExpressAuthScheme implements AuthScheme {
    private final String schemeId;
    private final HttpSigner signer;

    public SigV4S3ExpressAuthScheme(HttpSigner httpSigner) {
        Intrinsics.checkNotNullParameter(httpSigner, "httpSigner");
        this.schemeId = SigV4S3ExpressAuthSchemeKt.getAwsSigV4S3Express(AuthSchemeId.INSTANCE);
        this.signer = new S3ExpressHttpSigner(httpSigner);
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.AuthScheme
    public /* bridge */ IdentityProvider identityProvider(IdentityProviderConfig identityProviderConfig) {
        return super.identityProvider(identityProviderConfig);
    }

    public /* synthetic */ SigV4S3ExpressAuthScheme(AwsSigner awsSigner, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(awsSigner, (i & 2) != 0 ? null : str);
    }

    public SigV4S3ExpressAuthScheme(AwsSigner awsSigner, String str) {
        Intrinsics.checkNotNullParameter(awsSigner, "awsSigner");
        AwsHttpSigner.Config config = new AwsHttpSigner.Config();
        config.setSigner(awsSigner);
        config.setService(str);
        config.setAlgorithm(AwsSigningAlgorithm.SIGV4);
        this(new AwsHttpSigner(config));
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.AuthScheme
    /* JADX INFO: renamed from: getSchemeId-DepwgT4, reason: not valid java name and from getter */
    public String getSchemeId() {
        return this.schemeId;
    }

    @Override // aws.smithy.kotlin.runtime.http.auth.AuthScheme
    public HttpSigner getSigner() {
        return this.signer;
    }
}
