package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.hashing.HmacKt;
import aws.smithy.kotlin.runtime.hashing.Sha256;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import aws.smithy.kotlin.runtime.time.TimestampFormat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SigV4SignatureCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u001e\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/SigV4SignatureCalculator;", "Laws/smithy/kotlin/runtime/auth/awssigning/BaseSigV4SignatureCalculator;", "sha256Provider", "Lkotlin/Function0;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "Laws/smithy/kotlin/runtime/hashing/HashSupplier;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getSha256Provider", "()Lkotlin/jvm/functions/Function0;", "calculate", "", "signingKey", "", "stringToSign", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigV4SignatureCalculator extends BaseSigV4SignatureCalculator {
    private final Function0<HashFunction> sha256Provider;

    /* JADX WARN: Multi-variable type inference failed */
    public SigV4SignatureCalculator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.SigV4SignatureCalculator$1 */
    /* JADX INFO: compiled from: SigV4SignatureCalculator.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C36521 extends FunctionReferenceImpl implements Function0<Sha256> {
        public static final C36521 INSTANCE = new C36521();

        C36521() {
            super(0, Sha256.class, "<init>", "<init>()V", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Sha256 invoke() {
            return new Sha256();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SigV4SignatureCalculator(Function0<? extends HashFunction> sha256Provider) {
        super(AwsSigningAlgorithm.SIGV4, sha256Provider);
        Intrinsics.checkNotNullParameter(sha256Provider, "sha256Provider");
        this.sha256Provider = sha256Provider;
    }

    public /* synthetic */ SigV4SignatureCalculator(C36521 c36521, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C36521.INSTANCE : c36521);
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.BaseSigV4SignatureCalculator
    public Function0<HashFunction> getSha256Provider() {
        return this.sha256Provider;
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.SignatureCalculator
    public String calculate(byte[] signingKey, String stringToSign) {
        Intrinsics.checkNotNullParameter(signingKey, "signingKey");
        Intrinsics.checkNotNullParameter(stringToSign, "stringToSign");
        return HexKt.encodeToHex(HmacKt.hmac(signingKey, StringsKt.encodeToByteArray(stringToSign), getSha256Provider()));
    }

    private static final byte[] signingKey$hmac(SigV4SignatureCalculator sigV4SignatureCalculator, byte[] bArr, String str) {
        return HmacKt.hmac(bArr, StringsKt.encodeToByteArray(str), sigV4SignatureCalculator.getSha256Provider());
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.SignatureCalculator
    public byte[] signingKey(AwsSigningConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return signingKey$hmac(this, signingKey$hmac(this, signingKey$hmac(this, signingKey$hmac(this, StringsKt.encodeToByteArray("AWS4" + config.getCredentials().getSecretAccessKey()), config.getSigningDate().format(TimestampFormat.ISO_8601_CONDENSED_DATE)), config.getRegion()), config.getService()), "aws4_request");
    }
}
