package aws.sdk.kotlin.runtime.config.useragent;

import aws.sdk.kotlin.runtime.InternalSdkApi;
import aws.sdk.kotlin.runtime.config.AwsSdkSetting;
import aws.sdk.kotlin.runtime.config.profile.AwsProfileKt;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
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

/* JADX INFO: compiled from: ResolveUserAgent.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005H\u0087@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"resolveUserAgentAppId", "", DeviceDimensionProvider.KEY_PLATFORM, "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "profile", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "(Laws/smithy/kotlin/runtime/util/PlatformProvider;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aws-config"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ResolveUserAgentKt {

    /* JADX INFO: renamed from: aws.sdk.kotlin.runtime.config.useragent.ResolveUserAgentKt$resolveUserAgentAppId$1 */
    /* JADX INFO: compiled from: ResolveUserAgent.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.useragent.ResolveUserAgentKt", m1609f = "ResolveUserAgent.kt", m1610i = {0, 0}, m1611l = {21}, m1612m = "resolveUserAgentAppId", m1613n = {DeviceDimensionProvider.KEY_PLATFORM, "profile"}, m1614nl = {-1}, m1615s = {"L$0", "L$1"}, m1616v = 2)
    static final class C31281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C31281(Continuation<? super C31281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ResolveUserAgentKt.resolveUserAgentAppId(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @InternalSdkApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object resolveUserAgentAppId(PlatformProvider platformProvider, LazyAsyncValue<ConfigSection> lazyAsyncValue, Continuation<? super String> continuation) {
        C31281 c31281;
        if (continuation instanceof C31281) {
            c31281 = (C31281) continuation;
            if ((c31281.label & Integer.MIN_VALUE) != 0) {
                c31281.label -= Integer.MIN_VALUE;
            } else {
                c31281 = new C31281(continuation);
            }
        }
        Object obj = c31281.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31281.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) EnvironmentSettingKt.resolve(AwsSdkSetting.INSTANCE.getAwsAppId(), platformProvider);
            if (str != null) {
                return str;
            }
            c31281.L$0 = SpillingKt.nullOutSpilledVariable(platformProvider);
            c31281.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c31281.label = 1;
            obj = lazyAsyncValue.get(c31281);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return AwsProfileKt.getSdkUserAgentAppId((ConfigSection) obj);
    }

    public static /* synthetic */ Object resolveUserAgentAppId$default(PlatformProvider platformProvider, LazyAsyncValue lazyAsyncValue, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return resolveUserAgentAppId(platformProvider, lazyAsyncValue, continuation);
    }
}
