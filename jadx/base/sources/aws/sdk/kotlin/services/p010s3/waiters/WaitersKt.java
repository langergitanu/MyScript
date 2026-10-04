package aws.sdk.kotlin.services.p010s3.waiters;

import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.sdk.kotlin.services.p010s3.model.HeadBucketRequest;
import aws.sdk.kotlin.services.p010s3.model.HeadBucketResponse;
import aws.sdk.kotlin.services.p010s3.model.HeadObjectRequest;
import aws.sdk.kotlin.services.p010s3.model.HeadObjectResponse;
import aws.smithy.kotlin.runtime.retries.Outcome;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.retries.delay.ExponentialBackoffWithJitter;
import aws.smithy.kotlin.runtime.retries.delay.InfiniteTokenBucket;
import aws.smithy.kotlin.runtime.retries.policy.Acceptor;
import aws.smithy.kotlin.runtime.retries.policy.AcceptorRetryPolicy;
import aws.smithy.kotlin.runtime.retries.policy.ErrorTypeAcceptor;
import aws.smithy.kotlin.runtime.retries.policy.RetryDirective;
import aws.smithy.kotlin.runtime.retries.policy.RetryErrorType;
import aws.smithy.kotlin.runtime.retries.policy.SuccessAcceptor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: Waiters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\b\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\b\u001a1\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00122\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\u0013\u001a1\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086@¢\u0006\u0002\u0010\u000e\u001a,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00122\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\u0013\u001a1\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00032\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086@¢\u0006\u0002\u0010\u000e¨\u0006\u0016"}, m1599d2 = {"waitUntilBucketExists", "Laws/smithy/kotlin/runtime/retries/Outcome;", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;", "Laws/sdk/kotlin/services/s3/S3Client;", "request", "Laws/sdk/kotlin/services/s3/model/HeadBucketRequest;", "retryStrategy", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/HeadBucketRequest;Laws/smithy/kotlin/runtime/retries/RetryStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "block", "Lkotlin/Function1;", "Laws/sdk/kotlin/services/s3/model/HeadBucketRequest$Builder;", "", "Lkotlin/ExtensionFunctionType;", "(Laws/sdk/kotlin/services/s3/S3Client;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitUntilBucketNotExists", "waitUntilObjectExists", "Laws/sdk/kotlin/services/s3/model/HeadObjectResponse;", "Laws/sdk/kotlin/services/s3/model/HeadObjectRequest;", "(Laws/sdk/kotlin/services/s3/S3Client;Laws/sdk/kotlin/services/s3/model/HeadObjectRequest;Laws/smithy/kotlin/runtime/retries/RetryStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/sdk/kotlin/services/s3/model/HeadObjectRequest$Builder;", "waitUntilObjectNotExists", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class WaitersKt {
    public static /* synthetic */ Object waitUntilBucketExists$default(S3Client s3Client, HeadBucketRequest headBucketRequest, RetryStrategy retryStrategy, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            retryStrategy = null;
        }
        return waitUntilBucketExists(s3Client, headBucketRequest, retryStrategy, continuation);
    }

    public static final Object waitUntilBucketExists(S3Client s3Client, HeadBucketRequest headBucketRequest, RetryStrategy retryStrategy, Continuation<? super Outcome<HeadBucketResponse>> continuation) {
        if (retryStrategy == null) {
            retryStrategy = StandardRetryStrategy.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.services.s3.waiters.WaitersKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WaitersKt.waitUntilBucketExists$lambda$0((StandardRetryStrategy.Config.Builder) obj);
                }
            });
        }
        return retryStrategy.retry(new AcceptorRetryPolicy(headBucketRequest, CollectionsKt.listOf((Object[]) new Acceptor[]{new SuccessAcceptor(RetryDirective.TerminateAndSucceed.INSTANCE, true), new ErrorTypeAcceptor(new RetryDirective.RetryError(RetryErrorType.ServerSide), "NotFound")})), new C36342(s3Client, headBucketRequest, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit waitUntilBucketExists$lambda$0(StandardRetryStrategy.Config.Builder StandardRetryStrategy) {
        Intrinsics.checkNotNullParameter(StandardRetryStrategy, "$this$StandardRetryStrategy");
        StandardRetryStrategy.setMaxAttempts(20);
        StandardRetryStrategy.setTokenBucket(InfiniteTokenBucket.INSTANCE);
        StandardRetryStrategy.delayProvider(new Function1() { // from class: aws.sdk.kotlin.services.s3.waiters.WaitersKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WaitersKt.waitUntilBucketExists$lambda$0$0((ExponentialBackoffWithJitter.Config.Builder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit waitUntilBucketExists$lambda$0$0(ExponentialBackoffWithJitter.Config.Builder delayProvider) {
        Intrinsics.checkNotNullParameter(delayProvider, "$this$delayProvider");
        Duration.Companion companion = Duration.INSTANCE;
        delayProvider.m12244setInitialDelayLRDsOJo(DurationKt.toDuration(5000, DurationUnit.MILLISECONDS));
        delayProvider.setScaleFactor(1.5d);
        delayProvider.setJitter(1.0d);
        Duration.Companion companion2 = Duration.INSTANCE;
        delayProvider.m12245setMaxBackoffLRDsOJo(DurationKt.toDuration(120000, DurationUnit.MILLISECONDS));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.waiters.WaitersKt$waitUntilBucketExists$2 */
    /* JADX INFO: compiled from: Waiters.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.waiters.WaitersKt$waitUntilBucketExists$2", m1609f = "Waiters.kt", m1610i = {}, m1611l = {41}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C36342 extends SuspendLambda implements Function1<Continuation<? super HeadBucketResponse>, Object> {
        final /* synthetic */ HeadBucketRequest $request;
        final /* synthetic */ S3Client $this_waitUntilBucketExists;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36342(S3Client s3Client, HeadBucketRequest headBucketRequest, Continuation<? super C36342> continuation) {
            super(1, continuation);
            this.$this_waitUntilBucketExists = s3Client;
            this.$request = headBucketRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C36342(this.$this_waitUntilBucketExists, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super HeadBucketResponse> continuation) {
            return ((C36342) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            Object objHeadBucket = this.$this_waitUntilBucketExists.headBucket(this.$request, this);
            return objHeadBucket == coroutine_suspended ? coroutine_suspended : objHeadBucket;
        }
    }

    public static final Object waitUntilBucketExists(S3Client s3Client, Function1<? super HeadBucketRequest.Builder, Unit> function1, Continuation<? super Outcome<HeadBucketResponse>> continuation) {
        HeadBucketRequest.Builder builder = new HeadBucketRequest.Builder();
        function1.invoke(builder);
        return waitUntilBucketExists$default(s3Client, builder.build(), null, continuation, 2, null);
    }

    public static /* synthetic */ Object waitUntilBucketNotExists$default(S3Client s3Client, HeadBucketRequest headBucketRequest, RetryStrategy retryStrategy, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            retryStrategy = null;
        }
        return waitUntilBucketNotExists(s3Client, headBucketRequest, retryStrategy, continuation);
    }

    public static final Object waitUntilBucketNotExists(S3Client s3Client, HeadBucketRequest headBucketRequest, RetryStrategy retryStrategy, Continuation<? super Outcome<HeadBucketResponse>> continuation) {
        if (retryStrategy == null) {
            retryStrategy = StandardRetryStrategy.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.services.s3.waiters.WaitersKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WaitersKt.waitUntilBucketNotExists$lambda$0((StandardRetryStrategy.Config.Builder) obj);
                }
            });
        }
        return retryStrategy.retry(new AcceptorRetryPolicy(headBucketRequest, CollectionsKt.listOf(new ErrorTypeAcceptor(RetryDirective.TerminateAndSucceed.INSTANCE, "NotFound"))), new C36352(s3Client, headBucketRequest, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit waitUntilBucketNotExists$lambda$0(StandardRetryStrategy.Config.Builder StandardRetryStrategy) {
        Intrinsics.checkNotNullParameter(StandardRetryStrategy, "$this$StandardRetryStrategy");
        StandardRetryStrategy.setMaxAttempts(20);
        StandardRetryStrategy.setTokenBucket(InfiniteTokenBucket.INSTANCE);
        StandardRetryStrategy.delayProvider(new Function1() { // from class: aws.sdk.kotlin.services.s3.waiters.WaitersKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WaitersKt.waitUntilBucketNotExists$lambda$0$0((ExponentialBackoffWithJitter.Config.Builder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit waitUntilBucketNotExists$lambda$0$0(ExponentialBackoffWithJitter.Config.Builder delayProvider) {
        Intrinsics.checkNotNullParameter(delayProvider, "$this$delayProvider");
        Duration.Companion companion = Duration.INSTANCE;
        delayProvider.m12244setInitialDelayLRDsOJo(DurationKt.toDuration(5000, DurationUnit.MILLISECONDS));
        delayProvider.setScaleFactor(1.5d);
        delayProvider.setJitter(1.0d);
        Duration.Companion companion2 = Duration.INSTANCE;
        delayProvider.m12245setMaxBackoffLRDsOJo(DurationKt.toDuration(120000, DurationUnit.MILLISECONDS));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.waiters.WaitersKt$waitUntilBucketNotExists$2 */
    /* JADX INFO: compiled from: Waiters.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/services/s3/model/HeadBucketResponse;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.waiters.WaitersKt$waitUntilBucketNotExists$2", m1609f = "Waiters.kt", m1610i = {}, m1611l = {64}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C36352 extends SuspendLambda implements Function1<Continuation<? super HeadBucketResponse>, Object> {
        final /* synthetic */ HeadBucketRequest $request;
        final /* synthetic */ S3Client $this_waitUntilBucketNotExists;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36352(S3Client s3Client, HeadBucketRequest headBucketRequest, Continuation<? super C36352> continuation) {
            super(1, continuation);
            this.$this_waitUntilBucketNotExists = s3Client;
            this.$request = headBucketRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C36352(this.$this_waitUntilBucketNotExists, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super HeadBucketResponse> continuation) {
            return ((C36352) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            Object objHeadBucket = this.$this_waitUntilBucketNotExists.headBucket(this.$request, this);
            return objHeadBucket == coroutine_suspended ? coroutine_suspended : objHeadBucket;
        }
    }

    public static final Object waitUntilBucketNotExists(S3Client s3Client, Function1<? super HeadBucketRequest.Builder, Unit> function1, Continuation<? super Outcome<HeadBucketResponse>> continuation) {
        HeadBucketRequest.Builder builder = new HeadBucketRequest.Builder();
        function1.invoke(builder);
        return waitUntilBucketNotExists$default(s3Client, builder.build(), null, continuation, 2, null);
    }

    public static /* synthetic */ Object waitUntilObjectExists$default(S3Client s3Client, HeadObjectRequest headObjectRequest, RetryStrategy retryStrategy, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            retryStrategy = null;
        }
        return waitUntilObjectExists(s3Client, headObjectRequest, retryStrategy, continuation);
    }

    public static final Object waitUntilObjectExists(S3Client s3Client, HeadObjectRequest headObjectRequest, RetryStrategy retryStrategy, Continuation<? super Outcome<HeadObjectResponse>> continuation) {
        if (retryStrategy == null) {
            retryStrategy = StandardRetryStrategy.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.services.s3.waiters.WaitersKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WaitersKt.waitUntilObjectExists$lambda$0((StandardRetryStrategy.Config.Builder) obj);
                }
            });
        }
        return retryStrategy.retry(new AcceptorRetryPolicy(headObjectRequest, CollectionsKt.listOf((Object[]) new Acceptor[]{new SuccessAcceptor(RetryDirective.TerminateAndSucceed.INSTANCE, true), new ErrorTypeAcceptor(new RetryDirective.RetryError(RetryErrorType.ServerSide), "NotFound")})), new C36362(s3Client, headObjectRequest, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit waitUntilObjectExists$lambda$0(StandardRetryStrategy.Config.Builder StandardRetryStrategy) {
        Intrinsics.checkNotNullParameter(StandardRetryStrategy, "$this$StandardRetryStrategy");
        StandardRetryStrategy.setMaxAttempts(20);
        StandardRetryStrategy.setTokenBucket(InfiniteTokenBucket.INSTANCE);
        StandardRetryStrategy.delayProvider(new Function1() { // from class: aws.sdk.kotlin.services.s3.waiters.WaitersKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WaitersKt.waitUntilObjectExists$lambda$0$0((ExponentialBackoffWithJitter.Config.Builder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit waitUntilObjectExists$lambda$0$0(ExponentialBackoffWithJitter.Config.Builder delayProvider) {
        Intrinsics.checkNotNullParameter(delayProvider, "$this$delayProvider");
        Duration.Companion companion = Duration.INSTANCE;
        delayProvider.m12244setInitialDelayLRDsOJo(DurationKt.toDuration(5000, DurationUnit.MILLISECONDS));
        delayProvider.setScaleFactor(1.5d);
        delayProvider.setJitter(1.0d);
        Duration.Companion companion2 = Duration.INSTANCE;
        delayProvider.m12245setMaxBackoffLRDsOJo(DurationKt.toDuration(120000, DurationUnit.MILLISECONDS));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.waiters.WaitersKt$waitUntilObjectExists$2 */
    /* JADX INFO: compiled from: Waiters.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/services/s3/model/HeadObjectResponse;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.waiters.WaitersKt$waitUntilObjectExists$2", m1609f = "Waiters.kt", m1610i = {}, m1611l = {88}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C36362 extends SuspendLambda implements Function1<Continuation<? super HeadObjectResponse>, Object> {
        final /* synthetic */ HeadObjectRequest $request;
        final /* synthetic */ S3Client $this_waitUntilObjectExists;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36362(S3Client s3Client, HeadObjectRequest headObjectRequest, Continuation<? super C36362> continuation) {
            super(1, continuation);
            this.$this_waitUntilObjectExists = s3Client;
            this.$request = headObjectRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C36362(this.$this_waitUntilObjectExists, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super HeadObjectResponse> continuation) {
            return ((C36362) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            Object objHeadObject = this.$this_waitUntilObjectExists.headObject(this.$request, this);
            return objHeadObject == coroutine_suspended ? coroutine_suspended : objHeadObject;
        }
    }

    public static final Object waitUntilObjectExists(S3Client s3Client, Function1<? super HeadObjectRequest.Builder, Unit> function1, Continuation<? super Outcome<HeadObjectResponse>> continuation) {
        HeadObjectRequest.Builder builder = new HeadObjectRequest.Builder();
        function1.invoke(builder);
        return waitUntilObjectExists$default(s3Client, builder.build(), null, continuation, 2, null);
    }

    public static /* synthetic */ Object waitUntilObjectNotExists$default(S3Client s3Client, HeadObjectRequest headObjectRequest, RetryStrategy retryStrategy, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            retryStrategy = null;
        }
        return waitUntilObjectNotExists(s3Client, headObjectRequest, retryStrategy, continuation);
    }

    public static final Object waitUntilObjectNotExists(S3Client s3Client, HeadObjectRequest headObjectRequest, RetryStrategy retryStrategy, Continuation<? super Outcome<HeadObjectResponse>> continuation) {
        if (retryStrategy == null) {
            retryStrategy = StandardRetryStrategy.INSTANCE.invoke(new Function1() { // from class: aws.sdk.kotlin.services.s3.waiters.WaitersKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WaitersKt.waitUntilObjectNotExists$lambda$0((StandardRetryStrategy.Config.Builder) obj);
                }
            });
        }
        return retryStrategy.retry(new AcceptorRetryPolicy(headObjectRequest, CollectionsKt.listOf(new ErrorTypeAcceptor(RetryDirective.TerminateAndSucceed.INSTANCE, "NotFound"))), new C36372(s3Client, headObjectRequest, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit waitUntilObjectNotExists$lambda$0(StandardRetryStrategy.Config.Builder StandardRetryStrategy) {
        Intrinsics.checkNotNullParameter(StandardRetryStrategy, "$this$StandardRetryStrategy");
        StandardRetryStrategy.setMaxAttempts(20);
        StandardRetryStrategy.setTokenBucket(InfiniteTokenBucket.INSTANCE);
        StandardRetryStrategy.delayProvider(new Function1() { // from class: aws.sdk.kotlin.services.s3.waiters.WaitersKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WaitersKt.waitUntilObjectNotExists$lambda$0$0((ExponentialBackoffWithJitter.Config.Builder) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit waitUntilObjectNotExists$lambda$0$0(ExponentialBackoffWithJitter.Config.Builder delayProvider) {
        Intrinsics.checkNotNullParameter(delayProvider, "$this$delayProvider");
        Duration.Companion companion = Duration.INSTANCE;
        delayProvider.m12244setInitialDelayLRDsOJo(DurationKt.toDuration(5000, DurationUnit.MILLISECONDS));
        delayProvider.setScaleFactor(1.5d);
        delayProvider.setJitter(1.0d);
        Duration.Companion companion2 = Duration.INSTANCE;
        delayProvider.m12245setMaxBackoffLRDsOJo(DurationKt.toDuration(120000, DurationUnit.MILLISECONDS));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.waiters.WaitersKt$waitUntilObjectNotExists$2 */
    /* JADX INFO: compiled from: Waiters.kt */
    @Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/services/s3/model/HeadObjectResponse;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.waiters.WaitersKt$waitUntilObjectNotExists$2", m1609f = "Waiters.kt", m1610i = {}, m1611l = {111}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    static final class C36372 extends SuspendLambda implements Function1<Continuation<? super HeadObjectResponse>, Object> {
        final /* synthetic */ HeadObjectRequest $request;
        final /* synthetic */ S3Client $this_waitUntilObjectNotExists;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36372(S3Client s3Client, HeadObjectRequest headObjectRequest, Continuation<? super C36372> continuation) {
            super(1, continuation);
            this.$this_waitUntilObjectNotExists = s3Client;
            this.$request = headObjectRequest;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C36372(this.$this_waitUntilObjectNotExists, this.$request, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super HeadObjectResponse> continuation) {
            return ((C36372) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
            Object objHeadObject = this.$this_waitUntilObjectNotExists.headObject(this.$request, this);
            return objHeadObject == coroutine_suspended ? coroutine_suspended : objHeadObject;
        }
    }

    public static final Object waitUntilObjectNotExists(S3Client s3Client, Function1<? super HeadObjectRequest.Builder, Unit> function1, Continuation<? super Outcome<HeadObjectResponse>> continuation) {
        HeadObjectRequest.Builder builder = new HeadObjectRequest.Builder();
        function1.invoke(builder);
        return waitUntilObjectNotExists$default(s3Client, builder.build(), null, continuation, 2, null);
    }
}
