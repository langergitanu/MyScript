package aws.sdk.kotlin.services.p010s3.internal;

import aws.sdk.kotlin.runtime.config.profile.AwsProfileKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import aws.sdk.kotlin.services.p010s3.S3Client;
import aws.smithy.kotlin.runtime.config.EnvironmentSettingKt;
import aws.smithy.kotlin.runtime.util.LazyAsyncValue;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;

/* JADX INFO: compiled from: FinalizeS3Config.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0080@¢\u0006\u0002\u0010\t\"\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00060\fj\u0002`\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b*\u00060\fj\u0002`\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\"\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b*\u00060\fj\u0002`\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, m1599d2 = {"finalizeS3Config", "", "builder", "Laws/sdk/kotlin/services/s3/S3Client$Builder;", "sharedConfig", "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;", "provider", "Laws/smithy/kotlin/runtime/util/PlatformProvider;", "(Laws/sdk/kotlin/services/s3/S3Client$Builder;Laws/smithy/kotlin/runtime/util/LazyAsyncValue;Laws/smithy/kotlin/runtime/util/PlatformProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "useArnRegion", "", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;", "getUseArnRegion", "(Laws/sdk/kotlin/runtime/config/profile/ConfigSection;)Ljava/lang/Boolean;", "disableMrap", "getDisableMrap", "disableS3ExpressSessionAuth", "getDisableS3ExpressSessionAuth", "s3"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FinalizeS3ConfigKt {

    /* JADX INFO: renamed from: aws.sdk.kotlin.services.s3.internal.FinalizeS3ConfigKt$finalizeS3Config$1 */
    /* JADX INFO: compiled from: FinalizeS3Config.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.sdk.kotlin.services.s3.internal.FinalizeS3ConfigKt", m1609f = "FinalizeS3Config.kt", m1610i = {0, 0, 0}, m1611l = {20}, m1612m = "finalizeS3Config", m1613n = {"builder", "sharedConfig", "provider"}, m1614nl = {21}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
    static final class C31431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C31431(Continuation<? super C31431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FinalizeS3ConfigKt.finalizeS3Config(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object finalizeS3Config(S3Client.Builder builder, LazyAsyncValue<AwsSharedConfig> lazyAsyncValue, PlatformProvider platformProvider, Continuation<? super Unit> continuation) {
        C31431 c31431;
        if (continuation instanceof C31431) {
            c31431 = (C31431) continuation;
            if ((c31431.label & Integer.MIN_VALUE) != 0) {
                c31431.label -= Integer.MIN_VALUE;
            } else {
                c31431 = new C31431(continuation);
            }
        }
        Object obj = c31431.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c31431.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            c31431.L$0 = builder;
            c31431.L$1 = SpillingKt.nullOutSpilledVariable(lazyAsyncValue);
            c31431.L$2 = platformProvider;
            c31431.label = 1;
            obj = lazyAsyncValue.get(c31431);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            platformProvider = (PlatformProvider) c31431.L$2;
            builder = (S3Client.Builder) c31431.L$0;
            ResultKt.throwOnFailure(obj);
        }
        ConfigSection activeProfile = ((AwsSharedConfig) obj).getActiveProfile();
        S3Client.Config.Builder config = builder.getConfig();
        Boolean useArnRegion = builder.getConfig().getUseArnRegion();
        if (useArnRegion == null && (useArnRegion = (Boolean) EnvironmentSettingKt.resolve(S3Setting.INSTANCE.getUseArnRegion(), platformProvider)) == null) {
            useArnRegion = getUseArnRegion(activeProfile);
        }
        config.setUseArnRegion(useArnRegion);
        S3Client.Config.Builder config2 = builder.getConfig();
        Boolean disableMrap = builder.getConfig().getDisableMrap();
        if (disableMrap == null && (disableMrap = (Boolean) EnvironmentSettingKt.resolve(S3Setting.INSTANCE.getDisableMultiRegionAccessPoints(), platformProvider)) == null) {
            disableMrap = getDisableMrap(activeProfile);
        }
        config2.setDisableMrap(disableMrap);
        S3Client.Config.Builder config3 = builder.getConfig();
        Boolean disableS3ExpressSessionAuth = builder.getConfig().getDisableS3ExpressSessionAuth();
        if (disableS3ExpressSessionAuth == null && (disableS3ExpressSessionAuth = (Boolean) EnvironmentSettingKt.resolve(S3Setting.INSTANCE.getDisableS3ExpressSessionAuth(), platformProvider)) == null) {
            disableS3ExpressSessionAuth = getDisableS3ExpressSessionAuth(activeProfile);
        }
        config3.setDisableS3ExpressSessionAuth(disableS3ExpressSessionAuth);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object finalizeS3Config$default(S3Client.Builder builder, LazyAsyncValue lazyAsyncValue, PlatformProvider platformProvider, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            platformProvider = PlatformProvider.INSTANCE.getSystem();
        }
        return finalizeS3Config(builder, lazyAsyncValue, platformProvider, continuation);
    }

    private static final Boolean getUseArnRegion(ConfigSection configSection) {
        return AwsProfileKt.getBooleanOrNull$default(configSection, "s3_use_arn_region", null, 2, null);
    }

    private static final Boolean getDisableMrap(ConfigSection configSection) {
        return AwsProfileKt.getBooleanOrNull$default(configSection, "s3_disable_multiregion_access_points", null, 2, null);
    }

    private static final Boolean getDisableS3ExpressSessionAuth(ConfigSection configSection) {
        return AwsProfileKt.getBooleanOrNull$default(configSection, "s3_disable_express_session_auth", null, 2, null);
    }
}
