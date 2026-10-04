package aws.smithy.kotlin.runtime.auth.awssigning;

import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import aws.smithy.kotlin.runtime.collections.PeriodicSweepCache;
import aws.smithy.kotlin.runtime.content.BigInteger;
import aws.smithy.kotlin.runtime.hashing.EcdsaJVMKt;
import aws.smithy.kotlin.runtime.hashing.HashFunction;
import aws.smithy.kotlin.runtime.hashing.HmacKt;
import aws.smithy.kotlin.runtime.hashing.Sha256;
import aws.smithy.kotlin.runtime.text.encoding.HexKt;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.util.ExpiringValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SigV4aSignatureCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001e\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m1599d2 = {"Laws/smithy/kotlin/runtime/auth/awssigning/SigV4aSignatureCalculator;", "Laws/smithy/kotlin/runtime/auth/awssigning/BaseSigV4SignatureCalculator;", "sha256Provider", "Lkotlin/Function0;", "Laws/smithy/kotlin/runtime/hashing/HashFunction;", "Laws/smithy/kotlin/runtime/hashing/HashSupplier;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getSha256Provider", "()Lkotlin/jvm/functions/Function0;", "privateKeyCache", "Laws/smithy/kotlin/runtime/collections/PeriodicSweepCache;", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;", "", "calculate", "", "signingKey", "stringToSign", "config", "Laws/smithy/kotlin/runtime/auth/awssigning/AwsSigningConfig;", "fixedInputString", "accessKeyId", "counter", "", "aws-signing-default"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SigV4aSignatureCalculator extends BaseSigV4SignatureCalculator {
    private final PeriodicSweepCache<Credentials, byte[]> privateKeyCache;
    private final Function0<HashFunction> sha256Provider;

    /* JADX WARN: Multi-variable type inference failed */
    public SigV4aSignatureCalculator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.SigV4aSignatureCalculator$1 */
    /* JADX INFO: compiled from: SigV4aSignatureCalculator.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C36531 extends FunctionReferenceImpl implements Function0<Sha256> {
        public static final C36531 INSTANCE = new C36531();

        C36531() {
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
    public SigV4aSignatureCalculator(Function0<? extends HashFunction> sha256Provider) {
        super(AwsSigningAlgorithm.SIGV4_ASYMMETRIC, sha256Provider);
        Intrinsics.checkNotNullParameter(sha256Provider, "sha256Provider");
        this.sha256Provider = sha256Provider;
        Duration.Companion companion = Duration.INSTANCE;
        this.privateKeyCache = new PeriodicSweepCache<>(DurationKt.toDuration(1, DurationUnit.HOURS), null, 2, null);
    }

    public /* synthetic */ SigV4aSignatureCalculator(C36531 c36531, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? C36531.INSTANCE : c36531);
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.BaseSigV4SignatureCalculator
    public Function0<HashFunction> getSha256Provider() {
        return this.sha256Provider;
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.SignatureCalculator
    public String calculate(byte[] signingKey, String stringToSign) {
        Intrinsics.checkNotNullParameter(signingKey, "signingKey");
        Intrinsics.checkNotNullParameter(stringToSign, "stringToSign");
        return HexKt.encodeToHex(EcdsaJVMKt.ecdsaSecp256r1(signingKey, StringsKt.encodeToByteArray(stringToSign)));
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.SigV4aSignatureCalculator$signingKey$1 */
    /* JADX INFO: compiled from: SigV4aSignatureCalculator.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.SigV4aSignatureCalculator$signingKey$1", m1609f = "SigV4aSignatureCalculator.kt", m1610i = {}, m1611l = {50}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {70}, m1615s = {}, m1616v = 2)
    static final class C36541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        final /* synthetic */ AwsSigningConfig $config;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36541(AwsSigningConfig awsSigningConfig, Continuation<? super C36541> continuation) {
            super(2, continuation);
            this.$config = awsSigningConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SigV4aSignatureCalculator.this.new C36541(this.$config, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((C36541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.auth.awssigning.SigV4aSignatureCalculator$signingKey$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: SigV4aSignatureCalculator.kt */
        @Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, m1599d2 = {"<anonymous>", "Laws/smithy/kotlin/runtime/util/ExpiringValue;", "", "it", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
        @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.auth.awssigning.SigV4aSignatureCalculator$signingKey$1$1", m1609f = "SigV4aSignatureCalculator.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Credentials, Continuation<? super ExpiringValue<byte[]>>, Object> {
            final /* synthetic */ AwsSigningConfig $config;
            int label;
            final /* synthetic */ SigV4aSignatureCalculator this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(AwsSigningConfig awsSigningConfig, SigV4aSignatureCalculator sigV4aSignatureCalculator, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$config = awsSigningConfig;
                this.this$0 = sigV4aSignatureCalculator;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$config, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Credentials credentials, Continuation<? super ExpiringValue<byte[]>> continuation) {
                return ((AnonymousClass1) create(credentials, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                BigInteger positiveBigInteger;
                byte[] byteArray;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                byte[] bArrEncodeToByteArray = StringsKt.encodeToByteArray("AWS4A" + this.$config.getCredentials().getSecretAccessKey());
                byte b = 1;
                do {
                    positiveBigInteger = SigV4aSignatureCalculatorKt.toPositiveBigInteger(HmacKt.hmac(bArrEncodeToByteArray, this.this$0.fixedInputString(this.$config.getCredentials().getAccessKeyId(), b), this.this$0.getSha256Provider()));
                    byteArray = positiveBigInteger.plus(new BigInteger("1")).toByteArray();
                    if (b == -2 && positiveBigInteger.compareTo(SigV4aSignatureCalculatorKt.getN_MINUS_TWO()) > 0) {
                        throw new IllegalStateException("Counter exceeded maximum length");
                    }
                    b = (byte) (b + 1);
                } while (positiveBigInteger.compareTo(SigV4aSignatureCalculatorKt.getN_MINUS_TWO()) > 0);
                return new ExpiringValue(byteArray, Instant.INSTANCE.getMAX_VALUE());
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object obj2 = SigV4aSignatureCalculator.this.privateKeyCache.get(this.$config.getCredentials(), new AnonymousClass1(this.$config, SigV4aSignatureCalculator.this, null), this);
            return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
        }
    }

    @Override // aws.smithy.kotlin.runtime.auth.awssigning.SignatureCalculator
    public byte[] signingKey(AwsSigningConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return (byte[]) BuildersKt__BuildersKt.runBlocking$default(null, new C36541(config, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] fixedInputString(String accessKeyId, byte counter) {
        return ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(new byte[]{0, 0, 0, 1}, StringsKt.encodeToByteArray(AwsSigningAlgorithm.SIGV4_ASYMMETRIC.getSigningName())), new byte[]{0}), StringsKt.encodeToByteArray(accessKeyId)), counter), new byte[]{0, 0, 1, 0});
    }
}
