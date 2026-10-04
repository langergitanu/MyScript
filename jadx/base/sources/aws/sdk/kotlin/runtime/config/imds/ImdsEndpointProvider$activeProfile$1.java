package aws.sdk.kotlin.runtime.config.imds;

import aws.sdk.kotlin.runtime.config.profile.AwsConfigLoaderKt;
import aws.sdk.kotlin.runtime.config.profile.AwsSharedConfig;
import aws.sdk.kotlin.runtime.config.profile.ConfigSection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ImdsEndpointProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002H\n"}, m1599d2 = {"<anonymous>", "Laws/sdk/kotlin/runtime/config/profile/ConfigSection;", "Laws/sdk/kotlin/runtime/config/profile/AwsProfile;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider$activeProfile$1", m1609f = "ImdsEndpointProvider.kt", m1610i = {}, m1611l = {26}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {-1}, m1615s = {}, m1616v = 2)
final class ImdsEndpointProvider$activeProfile$1 extends SuspendLambda implements Function1<Continuation<? super ConfigSection>, Object> {
    int label;
    final /* synthetic */ ImdsEndpointProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ImdsEndpointProvider$activeProfile$1(ImdsEndpointProvider imdsEndpointProvider, Continuation<? super ImdsEndpointProvider$activeProfile$1> continuation) {
        super(1, continuation);
        this.this$0 = imdsEndpointProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ImdsEndpointProvider$activeProfile$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ConfigSection> continuation) {
        return ((ImdsEndpointProvider$activeProfile$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = AwsConfigLoaderKt.loadAwsSharedConfig$default(this.this$0.platformProvider, null, null, this, 6, null);
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
