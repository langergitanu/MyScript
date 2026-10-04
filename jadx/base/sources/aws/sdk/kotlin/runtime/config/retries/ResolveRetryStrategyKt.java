package aws.sdk.kotlin.runtime.config.retries;

import aws.sdk.kotlin.runtime.ConfigurationException;
import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.sdk.kotlin.runtime.config.profile.AwsProfileKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.client.config.RetryMode;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.retries.AdaptiveRetryStrategy;
import aws.smithy.kotlin.runtime.retries.RetryStrategy;
import aws.smithy.kotlin.runtime.retries.StandardRetryStrategy;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.LazyAsyncValueKt;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResolveRetryStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"resolveRetryStrategy", "Laws/smithy/kotlin/runtime/retries/RetryStrategy;", "platformProvider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "profile", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResolveRetryStrategyKt {

    /* JADX INFO: compiled from: ResolveRetryStrategy.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RetryMode.values().length];
            try {
                iArr[RetryMode.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RetryMode.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RetryMode.ADAPTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.retries.ResolveRetryStrategyKt$resolveRetryStrategy$1 */
    /* JADX INFO: compiled from: ResolveRetryStrategy.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.retries.ResolveRetryStrategyKt", m1609f = "ResolveRetryStrategy.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {34, 37}, m1612m = "resolveRetryStrategy", m1613n = {"platformProvider", "profile", "platformProvider", "profile", "maxAttempts"}, m1614nl = {33, 36}, m1615s = {"L$0", "L$1", "L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C31261 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C31261(Continuation<? super C31261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolveRetryStrategyKt.resolveRetryStrategy(null, null, this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        if (r9 == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a1, code lost:
    
        if (r9 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveRetryStrategy(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super RetryStrategy> continuation) {
        C31261 c31261;
        Integer maxAttempts;
        final Integer num;
        RetryMode retryMode;
        int i;
        StandardRetryStrategy.Companion companion;
        if (continuation instanceof C31261) {
            c31261 = (C31261) continuation;
            if ((c31261.label & Integer.MIN_VALUE) != 0) {
                c31261.label -= Integer.MIN_VALUE;
            } else {
                c31261 = new C31261(continuation);
            }
        }
        Object obj = c31261.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c31261.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            maxAttempts = (Integer) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsMaxAttempts(), platformProvider);
            if (maxAttempts == null) {
                c31261.L$0 = platformProvider;
                c31261.L$1 = lazyAsyncValue;
                c31261.label = 1;
                obj = lazyAsyncValue.get(c31261);
            } else {
                LazyAsyncValue<ConfigSection> lazyAsyncValue2 = lazyAsyncValue;
                PlatformProvider platformProvider2 = platformProvider;
                num = maxAttempts;
                retryMode = (RetryMode) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsRetryMode(), platformProvider2);
                if (retryMode == null) {
                    c31261.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider2);
                    c31261.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue2);
                    c31261.L$2 = num;
                    c31261.label = 2;
                    obj = lazyAsyncValue2.get(c31261);
                }
                i = WhenMappings.$EnumSwitchMapping$0[retryMode.ordinal()];
                if (i == 1) {
                    companion = StandardRetryStrategy.INSTANCE;
                }
                return companion.invoke(new Function1() { // from class: aws.sdk.kotlin.runtime.config.retries.ResolveRetryStrategyKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return ResolveRetryStrategyKt.resolveRetryStrategy$lambda$0(num, (StandardRetryStrategy.Config.Builder) obj2);
                    }
                });
            }
            return coroutine_suspended;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            num = (Integer) c31261.L$2;
            ResultKt.throwOnFailure(obj);
            retryMode = AwsProfileKt.getRetryMode((ConfigSection) obj);
            if (retryMode == null) {
                retryMode = RetryMode.STANDARD;
            }
            i = WhenMappings.$EnumSwitchMapping$0[retryMode.ordinal()];
            if (i == 1 || i == 2) {
                companion = StandardRetryStrategy.INSTANCE;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                companion = AdaptiveRetryStrategy.INSTANCE;
            }
            return companion.invoke(new Function1() { // from class: aws.sdk.kotlin.runtime.config.retries.ResolveRetryStrategyKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ResolveRetryStrategyKt.resolveRetryStrategy$lambda$0(num, (StandardRetryStrategy.Config.Builder) obj2);
                }
            });
        }
        LazyAsyncValue<ConfigSection> lazyAsyncValue3 = (LazyAsyncValue) c31261.L$1;
        PlatformProvider platformProvider3 = (PlatformProvider) c31261.L$0;
        ResultKt.throwOnFailure(obj);
        lazyAsyncValue = lazyAsyncValue3;
        platformProvider = platformProvider3;
        maxAttempts = AwsProfileKt.getMaxAttempts((ConfigSection) obj);
        LazyAsyncValue<ConfigSection> lazyAsyncValue22 = lazyAsyncValue;
        PlatformProvider platformProvider22 = platformProvider;
        num = maxAttempts;
        retryMode = (RetryMode) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsRetryMode(), platformProvider22);
        if (retryMode == null) {
        }
        i = WhenMappings.$EnumSwitchMapping$0[retryMode.ordinal()];
        if (i == 1) {
        }
        return companion.invoke(new Function1() { // from class: aws.sdk.kotlin.runtime.config.retries.ResolveRetryStrategyKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ResolveRetryStrategyKt.resolveRetryStrategy$lambda$0(num, (StandardRetryStrategy.Config.Builder) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.retries.ResolveRetryStrategyKt$resolveRetryStrategy$2 */
    /* JADX INFO: compiled from: ResolveRetryStrategy.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.retries.ResolveRetryStrategyKt$resolveRetryStrategy$2", m1609f = "ResolveRetryStrategy.kt", m1610i = {}, m1611l = {31}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
    public static final class C31272 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
        final /* synthetic */ PlatformProvider $platformProvider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C31272(PlatformProvider platformProvider, Continuation<? super C31272> continuation) {
            super(1, continuation);
            this.$platformProvider = platformProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C31272(this.$platformProvider, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super ConfigSection> continuation) {
            return ((C31272) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(this.$platformProvider, null, null, this, 6, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return ((AwsSharedConfig) obj).getActiveProfile();
        }
    }

    public static /* synthetic */ Object resolveRetryStrategy$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        if ((i & 2) != 0) {
            lazyAsyncValue = LazyAsyncValueKt.asyncLazy(new C31272(platformProvider, null));
        }
        return resolveRetryStrategy(platformProvider, lazyAsyncValue, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resolveRetryStrategy$lambda$0(Integer num, StandardRetryStrategy.Config.Builder factory) {
        Intrinsics.checkNotNullParameter(factory, "$this$factory");
        if (num != null) {
            int iIntValue = num.intValue();
            if (iIntValue < 1) {
                throw new ConfigurationException("max attempts was " + iIntValue + ", but should be at least 1");
            }
            factory.setMaxAttempts(iIntValue);
        }
        return Unit.INSTANCE;
    }
}
