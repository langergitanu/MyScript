package aws.sdk.kotlin.runtime.config.checksums;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.profile.AwsProfileKt;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.smithy.kotlin.runtime.client.config.RequestHttpChecksumConfig;
import aws.smithy.kotlin.runtime.client.config.ResponseHttpChecksumConfig;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import com.revenuecat.purchases.common.localrules.DeviceDimensionProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: ResolveFlexibleChecksumsConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b\u001a*\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b¨\u0006\u000b"}, m1599d2 = {"resolveRequestChecksumCalculation", "Laws/smithy/kotlin/runtime/client/config/RequestHttpChecksumConfig;", DeviceDimensionProvider.KEY_PLATFORM, "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "profile", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveResponseChecksumValidation", "Laws/smithy/kotlin/runtime/client/config/ResponseHttpChecksumConfig;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResolveFlexibleChecksumsConfigKt {

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.checksums.ResolveFlexibleChecksumsConfigKt$resolveRequestChecksumCalculation$1 */
    /* JADX INFO: compiled from: ResolveFlexibleChecksumsConfig.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.checksums.ResolveFlexibleChecksumsConfigKt", m1609f = "ResolveFlexibleChecksumsConfig.kt", m1610i = {0, 0}, m1611l = {27}, m1612m = "resolveRequestChecksumCalculation", m1613n = {DeviceDimensionProvider.KEY_PLATFORM, "profile"}, m1614nl = {-1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30941 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30941(Continuation<? super C30941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolveFlexibleChecksumsConfigKt.resolveRequestChecksumCalculation(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.checksums.ResolveFlexibleChecksumsConfigKt$resolveResponseChecksumValidation$1 */
    /* JADX INFO: compiled from: ResolveFlexibleChecksumsConfig.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.checksums.ResolveFlexibleChecksumsConfigKt", m1609f = "ResolveFlexibleChecksumsConfig.kt", m1610i = {0, 0}, m1611l = {37}, m1612m = "resolveResponseChecksumValidation", m1613n = {DeviceDimensionProvider.KEY_PLATFORM, "profile"}, m1614nl = {-1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C30951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C30951(Continuation<? super C30951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolveFlexibleChecksumsConfigKt.resolveResponseChecksumValidation(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveRequestChecksumCalculation(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super RequestHttpChecksumConfig> continuation) {
        C30941 c30941;
        if (continuation instanceof C30941) {
            c30941 = (C30941) continuation;
            if ((c30941.label & Integer.MIN_VALUE) != 0) {
                c30941.label -= Integer.MIN_VALUE;
            } else {
                c30941 = new C30941(continuation);
            }
        }
        Object obj = c30941.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30941.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestHttpChecksumConfig requestHttpChecksumConfig = (RequestHttpChecksumConfig) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsRequestChecksumCalculation(), platformProvider);
            if (requestHttpChecksumConfig != null) {
                return requestHttpChecksumConfig;
            }
            c30941.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c30941.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c30941.label = 1;
            obj = lazyAsyncValue.get(c30941);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        RequestHttpChecksumConfig requestChecksumCalculation = AwsProfileKt.getRequestChecksumCalculation((ConfigSection) obj);
        return requestChecksumCalculation == null ? RequestHttpChecksumConfig.WHEN_SUPPORTED : requestChecksumCalculation;
    }

    public static /* synthetic */ Object resolveRequestChecksumCalculation$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolveRequestChecksumCalculation(platformProvider, lazyAsyncValue, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveResponseChecksumValidation(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super ResponseHttpChecksumConfig> continuation) {
        C30951 c30951;
        if (continuation instanceof C30951) {
            c30951 = (C30951) continuation;
            if ((c30951.label & Integer.MIN_VALUE) != 0) {
                c30951.label -= Integer.MIN_VALUE;
            } else {
                c30951 = new C30951(continuation);
            }
        }
        Object obj = c30951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c30951.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ResponseHttpChecksumConfig responseHttpChecksumConfig = (ResponseHttpChecksumConfig) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsResponseChecksumValidation(), platformProvider);
            if (responseHttpChecksumConfig != null) {
                return responseHttpChecksumConfig;
            }
            c30951.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c30951.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c30951.label = 1;
            obj = lazyAsyncValue.get(c30951);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ResponseHttpChecksumConfig responseChecksumValidation = AwsProfileKt.getResponseChecksumValidation((ConfigSection) obj);
        return responseChecksumValidation == null ? ResponseHttpChecksumConfig.WHEN_SUPPORTED : responseChecksumValidation;
    }

    public static /* synthetic */ Object resolveResponseChecksumValidation$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolveResponseChecksumValidation(platformProvider, lazyAsyncValue, continuation);
    }
}
