package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import com.survicate.surveys.TextRecallingManager;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.message.TokenParser;

/* JADX INFO: compiled from: RequestMutator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/DefaultRequestMutator;", "Laws/smithy/kotlin/runtime/auth/awssigning/RequestMutator;", "<init>", "()V", "appendAuth", "Laws/smithy/kotlin/runtime/http/request/HttpRequest;", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "canonical", "Laws/smithy/kotlin/runtime/auth/awssigning/CanonicalRequest;", "signatureHex", "", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DefaultRequestMutator implements RequestMutator {

    /* JADX INFO: compiled from: RequestMutator.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AwsSignatureType.values().length];
            try {
                iArr[AwsSignatureType.HTTP_REQUEST_VIA_HEADERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AwsSignatureType.HTTP_REQUEST_VIA_QUERY_PARAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.RequestMutator
    public HttpRequest appendAuth(AwsSigningConfig config, CanonicalRequest canonical, String signatureHex) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(canonical, "canonical");
        Intrinsics.checkNotNullParameter(signatureHex, "signatureHex");
        int i = WhenMappings.$EnumSwitchMapping$0[config.getSignatureType().ordinal()];
        if (i == 1) {
            canonical.getRequest().getHeaders().set("Authorization", config.getAlgorithm().getSigningName() + TokenParser.f2383SP + ("Credential=" + RequestMutatorKt.credentialValue(config)) + TextRecallingManager.ANSWER_SEPARATOR + ("SignedHeaders=" + canonical.getSignedHeaders()) + TextRecallingManager.ANSWER_SEPARATOR + ("Signature=" + signatureHex));
        } else if (i == 2) {
            canonical.getRequest().getUrl().getParameters().getDecodedParameters().put("X-Amz-Signature", signatureHex);
        } else {
            throw new NotImplementedError("An operation is not implemented: " + ("Support for " + config.getSignatureType() + " is not yet implemented"));
        }
        return canonical.getRequest().build();
    }
}
