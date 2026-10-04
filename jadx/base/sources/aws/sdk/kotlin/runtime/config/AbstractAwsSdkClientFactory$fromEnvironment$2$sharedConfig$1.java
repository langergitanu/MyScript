package aws.sdk.kotlin.runtime.config;

import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.smithy.kotlin.runtime.util.PlatformProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractAwsSdkClientFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/AwsSharedConfig;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.AbstractAwsSdkClientFactory$fromEnvironment$2$sharedConfig$1", m1609f = "AbstractAwsSdkClientFactory.kt", m1610i = {}, m1611l = {72}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
final class AbstractAwsSdkClientFactory$fromEnvironment$2$sharedConfig$1 extends SuspendLambda implements Function1<Continuation<? super AwsSharedConfig>, Object> {
    final /* synthetic */ PlatformProvider $platform;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractAwsSdkClientFactory$fromEnvironment$2$sharedConfig$1(PlatformProvider platformProvider, Continuation<? super AbstractAwsSdkClientFactory$fromEnvironment$2$sharedConfig$1> continuation) {
        super(1, continuation);
        this.$platform = platformProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AbstractAwsSdkClientFactory$fromEnvironment$2$sharedConfig$1(this.$platform, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super AwsSharedConfig> continuation) {
        return ((AbstractAwsSdkClientFactory$fromEnvironment$2$sharedConfig$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
        Object objLoadAwsSharedConfig$default = AwsConfigLoaderKt.loadAwsSharedConfig$default(this.$platform, null, null, this, 6, null);
        return objLoadAwsSharedConfig$default == coroutine_suspended ? coroutine_suspended : objLoadAwsSharedConfig$default;
    }
}
