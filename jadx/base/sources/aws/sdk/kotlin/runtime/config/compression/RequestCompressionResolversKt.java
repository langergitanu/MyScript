package aws.sdk.kotlin.runtime.config.compression;

import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.profile.AwsProfileKt;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: RequestCompressionResolvers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b¨\u0006\u000b"}, m1599d2 = {"resolveDisableRequestCompression", "", DeviceDimensionProvider.KEY_PLATFORM, "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "profile", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveRequestMinCompressionSizeBytes", "", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RequestCompressionResolversKt {

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.compression.RequestCompressionResolversKt$resolveDisableRequestCompression$1 */
    /* JADX INFO: compiled from: RequestCompressionResolvers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.compression.RequestCompressionResolversKt", m1609f = "RequestCompressionResolvers.kt", m1610i = {0, 0}, m1611l = {25}, m1612m = "resolveDisableRequestCompression", m1613n = {DeviceDimensionProvider.KEY_PLATFORM, "profile"}, m1614nl = {24}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30961 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30961(Continuation<? super C30961> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RequestCompressionResolversKt.resolveDisableRequestCompression(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.compression.RequestCompressionResolversKt$resolveRequestMinCompressionSizeBytes$1 */
    /* JADX INFO: compiled from: RequestCompressionResolvers.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.compression.RequestCompressionResolversKt", m1609f = "RequestCompressionResolvers.kt", m1610i = {0, 0}, m1611l = {37}, m1612m = "resolveRequestMinCompressionSizeBytes", m1613n = {DeviceDimensionProvider.KEY_PLATFORM, "profile"}, m1614nl = {36}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30971(Continuation<? super C30971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RequestCompressionResolversKt.resolveRequestMinCompressionSizeBytes(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveDisableRequestCompression(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super Boolean> continuation) {
        C30961 c30961;
        boolean zBooleanValue;
        if (continuation instanceof C30961) {
            c30961 = (C30961) continuation;
            if ((c30961.label & Integer.MIN_VALUE) != 0) {
                c30961.label -= Integer.MIN_VALUE;
            } else {
                c30961 = new C30961(continuation);
            }
        }
        Object obj = c30961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30961.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Boolean bool = (Boolean) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsDisableRequestCompression(), platformProvider);
            if (bool == null) {
                c30961.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
                c30961.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
                c30961.label = 1;
                obj = lazyAsyncValue.get(c30961);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                zBooleanValue = bool.booleanValue();
                return Boxing.boxBoolean(zBooleanValue);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Boolean disableRequestCompression = AwsProfileKt.getDisableRequestCompression((ConfigSection) obj);
        zBooleanValue = disableRequestCompression != null ? disableRequestCompression.booleanValue() : false;
        return Boxing.boxBoolean(zBooleanValue);
    }

    public static /* synthetic */ Object resolveDisableRequestCompression$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolveDisableRequestCompression(platformProvider, lazyAsyncValue, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveRequestMinCompressionSizeBytes(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super Long> continuation) {
        C30971 c30971;
        long jLongValue;
        if (continuation instanceof C30971) {
            c30971 = (C30971) continuation;
            if ((c30971.label & Integer.MIN_VALUE) != 0) {
                c30971.label -= Integer.MIN_VALUE;
            } else {
                c30971 = new C30971(continuation);
            }
        }
        Object obj = c30971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30971.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Long l = (Long) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsRequestMinCompressionSizeBytes(), platformProvider);
            if (l == null) {
                c30971.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
                c30971.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
                c30971.label = 1;
                obj = lazyAsyncValue.get(c30971);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                jLongValue = l.longValue();
                return Boxing.boxLong(jLongValue);
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Long requestMinCompressionSizeBytes = AwsProfileKt.getRequestMinCompressionSizeBytes((ConfigSection) obj);
        jLongValue = requestMinCompressionSizeBytes != null ? requestMinCompressionSizeBytes.longValue() : 10240L;
        return Boxing.boxLong(jLongValue);
    }

    public static /* synthetic */ Object resolveRequestMinCompressionSizeBytes$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolveRequestMinCompressionSizeBytes(platformProvider, lazyAsyncValue, continuation);
    }
}
