package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.auth.awssigning.HashSpecification;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.hashing.HashFunctionKt;
import aws.smithy.kotlin.runtime.hashing.Sha256;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BaseSigV4SignatureCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/BaseSigV4SignatureCalculator;", "Laws/smithy/kotlin/runtime/auth/awssigning/SignatureCalculator;", "algorithm", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "sha256Provider", "Lkotlin/Function0;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "Laws/smithy/kotlin/runtime/hashing/HashSupplier;", "<init>", "(Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;Lkotlin/jvm/functions/Function0;)V", "getAlgorithm", "()Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningAlgorithm;", "getSha256Provider", "()Lkotlin/jvm/functions/Function0;", "supportedAlgorithms", "", "stringToSign", "", "canonicalRequest", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "chunkStringToSign", "chunkBody", "", "prevSignature", "chunkTrailerStringToSign", "trailingHeaders", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public abstract class BaseSigV4SignatureCalculator implements SignatureCalculator {
    private final AwsSigningAlgorithm algorithm;
    private final Function0<HashFunction> sha256Provider;
    private final Set<AwsSigningAlgorithm> supportedAlgorithms;

    /* JADX INFO: compiled from: BaseSigV4SignatureCalculator.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AwsSignatureType.values().length];
            try {
                iArr[AwsSignatureType.HTTP_REQUEST_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseSigV4SignatureCalculator(AwsSigningAlgorithm algorithm, Function0<? extends HashFunction> sha256Provider) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(sha256Provider, "sha256Provider");
        this.algorithm = algorithm;
        this.sha256Provider = sha256Provider;
        Set<AwsSigningAlgorithm> of = SetsKt.setOf((Object[]) new AwsSigningAlgorithm[]{AwsSigningAlgorithm.SIGV4, AwsSigningAlgorithm.SIGV4_ASYMMETRIC});
        this.supportedAlgorithms = of;
        if (!of.contains(algorithm)) {
            throw new IllegalStateException(("This class should only be used for " + CollectionsKt.joinToString$default(of, null, null, null, 0, null, null, 63, null) + ", got " + algorithm).toString());
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.BaseSigV4SignatureCalculator$1 */
    /* JADX INFO: compiled from: BaseSigV4SignatureCalculator.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C36421 extends FunctionReferenceImpl implements Function0<Sha256> {
        public static final C36421 INSTANCE = new C36421();

        C36421() {
            super(0, Sha256.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Sha256 invoke() {
            return new Sha256();
        }
    }

    public final AwsSigningAlgorithm getAlgorithm() {
        return this.algorithm;
    }

    public /* synthetic */ BaseSigV4SignatureCalculator(AwsSigningAlgorithm awsSigningAlgorithm, C36421 c36421, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(awsSigningAlgorithm, (i & 2) != 0 ? C36421.INSTANCE : c36421);
    }

    public Function0<HashFunction> getSha256Provider() {
        return this.sha256Provider;
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.SignatureCalculator
    public String stringToSign(String canonicalRequest, AwsSigningConfig config) {
        Intrinsics.checkNotNullParameter(canonicalRequest, "canonicalRequest");
        Intrinsics.checkNotNullParameter(config, "config");
        StringBuilder sb = new StringBuilder();
        sb.append(this.algorithm.getSigningName()).append('\n');
        sb.append(config.getSigningDate().format(TimestampFormat.ISO_8601_CONDENSED)).append('\n');
        sb.append(RequestMutatorKt.getCredentialScope(config)).append('\n');
        sb.append(HexKt.encodeToHex(HashFunctionKt.hash(StringsKt.encodeToByteArray(canonicalRequest), getSha256Provider())));
        return sb.toString();
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.SignatureCalculator
    public String chunkStringToSign(byte[] chunkBody, byte[] prevSignature, AwsSigningConfig config) {
        String hash;
        Intrinsics.checkNotNullParameter(chunkBody, "chunkBody");
        Intrinsics.checkNotNullParameter(prevSignature, "prevSignature");
        Intrinsics.checkNotNullParameter(config, "config");
        StringBuilder sb = new StringBuilder();
        sb.append(this.algorithm.getSigningName() + "-PAYLOAD").append('\n');
        sb.append(config.getSigningDate().format(TimestampFormat.ISO_8601_CONDENSED)).append('\n');
        sb.append(RequestMutatorKt.getCredentialScope(config)).append('\n');
        sb.append(StringsKt.decodeToString(prevSignature)).append('\n');
        if (WhenMappings.$EnumSwitchMapping$0[config.getSignatureType().ordinal()] == 1) {
            hash = BaseSigV4SignatureCalculatorKt.eventStreamNonSignatureHeaders(config.getSigningDate());
        } else {
            hash = HashSpecification.EmptyBody.INSTANCE.getHash();
        }
        sb.append(hash).append('\n');
        sb.append(HexKt.encodeToHex(HashFunctionKt.hash(chunkBody, getSha256Provider())));
        return sb.toString();
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.SignatureCalculator
    public String chunkTrailerStringToSign(byte[] trailingHeaders, byte[] prevSignature, AwsSigningConfig config) {
        Intrinsics.checkNotNullParameter(trailingHeaders, "trailingHeaders");
        Intrinsics.checkNotNullParameter(prevSignature, "prevSignature");
        Intrinsics.checkNotNullParameter(config, "config");
        StringBuilder sb = new StringBuilder();
        sb.append(this.algorithm.getSigningName() + "-TRAILER").append('\n');
        sb.append(config.getSigningDate().format(TimestampFormat.ISO_8601_CONDENSED)).append('\n');
        sb.append(RequestMutatorKt.getCredentialScope(config)).append('\n');
        sb.append(StringsKt.decodeToString(prevSignature)).append('\n');
        sb.append(HexKt.encodeToHex(HashFunctionKt.hash(trailingHeaders, getSha256Provider())));
        return sb.toString();
    }
}
