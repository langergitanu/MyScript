package aws.smithy.kotlin.runtime.auth.awssigning;

import kotlin.Metadata;

/* JADX INFO: compiled from: SignatureCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/SignatureCalculator;", "", "calculate", "", "signingKey", "", "stringToSign", "chunkStringToSign", "chunkBody", "prevSignature", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "canonicalRequest", "chunkTrailerStringToSign", "trailingHeaders", "Companion", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface SignatureCalculator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String calculate(byte[] signingKey, String stringToSign);

    String chunkStringToSign(byte[] chunkBody, byte[] prevSignature, AwsSigningConfig config);

    String chunkTrailerStringToSign(byte[] trailingHeaders, byte[] prevSignature, AwsSigningConfig config);

    byte[] signingKey(AwsSigningConfig config);

    String stringToSign(String canonicalRequest, AwsSigningConfig config);

    /* JADX INFO: compiled from: SignatureCalculator.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/SignatureCalculator$Companion;", "", "<init>", "()V", "SigV4", "Laws/smithy/kotlin/runtime/auth/awssigning/SigV4SignatureCalculator;", "getSigV4", "()Laws/smithy/kotlin/runtime/auth/awssigning/SigV4SignatureCalculator;", "SigV4a", "Laws/smithy/kotlin/runtime/auth/awssigning/SigV4aSignatureCalculator;", "getSigV4a", "()Laws/smithy/kotlin/runtime/auth/awssigning/SigV4aSignatureCalculator;", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final SigV4SignatureCalculator SigV4 = new SigV4SignatureCalculator(null, 1, null);
        private static final SigV4aSignatureCalculator SigV4a = new SigV4aSignatureCalculator(null, 1, null);

        private Companion() {
        }

        public final SigV4SignatureCalculator getSigV4() {
            return SigV4;
        }

        public final SigV4aSignatureCalculator getSigV4a() {
            return SigV4a;
        }
    }
}
