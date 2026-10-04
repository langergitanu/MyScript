package aws.sdk.kotlin.services.p010s3.express;

import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DefaultS3ExpressCredentialsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.express.DefaultS3ExpressCredentialsProvider$resolve$3$2", m1609f = "DefaultS3ExpressCredentialsProvider.kt", m1610i = {}, m1611l = {61}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {73}, m1615s = {}, m1616v = 2)
final class DefaultS3ExpressCredentialsProvider$resolve$3$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ S3Client $client;
    final /* synthetic */ S3ExpressCredentialsCacheValue $it;
    final /* synthetic */ S3ExpressCredentialsCacheKey $key;
    int label;
    final /* synthetic */ DefaultS3ExpressCredentialsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultS3ExpressCredentialsProvider$resolve$3$2(S3ExpressCredentialsCacheValue s3ExpressCredentialsCacheValue, DefaultS3ExpressCredentialsProvider defaultS3ExpressCredentialsProvider, S3Client s3Client, S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey, Continuation<? super DefaultS3ExpressCredentialsProvider$resolve$3$2> continuation) {
        super(2, continuation);
        this.$it = s3ExpressCredentialsCacheValue;
        this.this$0 = defaultS3ExpressCredentialsProvider;
        this.$client = s3Client;
        this.$key = s3ExpressCredentialsCacheKey;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultS3ExpressCredentialsProvider$resolve$3$2(this.$it, this.this$0, this.$client, this.$key, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultS3ExpressCredentialsProvider$resolve$3$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$it.getSfg().singleFlight(new C31411(this.this$0, this.$key, this.$client, this.$it, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception e) {
            final S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey = this.$key;
            this.this$0.getLogger$s3(this.$client).warn(e, new Function0() { // from class: aws.sdk.kotlin.services.s3.express.DefaultS3ExpressCredentialsProvider$resolve$3$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DefaultS3ExpressCredentialsProvider$resolve$3$2.invokeSuspend$lambda$0(s3ExpressCredentialsCacheKey);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.express.DefaultS3ExpressCredentialsProvider$resolve$3$2$1 */
    /* JADX INFO: compiled from: DefaultS3ExpressCredentialsProvider.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/services/s3/express/ExpiringValue;", "Laws/smithy/kotlin/runtime/auth/awscredentials/Credentials;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.express.DefaultS3ExpressCredentialsProvider$resolve$3$2$1", m1609f = "DefaultS3ExpressCredentialsProvider.kt", m1610i = {1}, m1611l = {65, 68}, m1612m = "invokeSuspend", m1613n = {"currentCreds"}, m1614nl = {67, 70}, m1615s = {"L$0"}, m1616v = 2)
    static final class C31411 extends SuspendLambda implements Function1<Continuation<? super ExpiringValue<Credentials>>, Object> {
        final /* synthetic */ S3Client $client;
        final /* synthetic */ S3ExpressCredentialsCacheValue $it;
        final /* synthetic */ S3ExpressCredentialsCacheKey $key;
        Object L$0;
        int label;
        final /* synthetic */ DefaultS3ExpressCredentialsProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31411(DefaultS3ExpressCredentialsProvider defaultS3ExpressCredentialsProvider, S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey, S3Client s3Client, S3ExpressCredentialsCacheValue s3ExpressCredentialsCacheValue, Continuation<? super C31411> continuation) {
            super(1, continuation);
            this.this$0 = defaultS3ExpressCredentialsProvider;
            this.$key = s3ExpressCredentialsCacheKey;
            this.$client = s3Client;
            this.$it = s3ExpressCredentialsCacheValue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C31411(this.this$0, this.$key, this.$client, this.$it, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ExpiringValue<Credentials>> continuation) {
            return ((C31411) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0064, code lost:
        
            if (r7 == r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ExpiringValue<Credentials> expiringCredentials;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.this$0.credentialsCache.get(this.$key, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return (ExpiringValue) obj;
            }
            ResultKt.throwOnFailure(obj);
            S3ExpressCredentialsCacheValue s3ExpressCredentialsCacheValue = (S3ExpressCredentialsCacheValue) obj;
            if (s3ExpressCredentialsCacheValue != null && (expiringCredentials = s3ExpressCredentialsCacheValue.getExpiringCredentials()) != null && S3ExpressCredentialsCacheKt.m12073isExpiringWithinHG0u8IE(expiringCredentials, this.this$0.refreshBuffer)) {
                this.L$0 = SpillingKt.nullOutSpilledVariable(s3ExpressCredentialsCacheValue);
                this.label = 2;
                obj = this.this$0.createSessionCredentials$s3(this.$key, this.$client, this);
            } else {
                return this.$it.getExpiringCredentials();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$0(S3ExpressCredentialsCacheKey s3ExpressCredentialsCacheKey) {
        return "Asynchronous refresh for " + s3ExpressCredentialsCacheKey.getBucket() + " failed.";
    }
}
