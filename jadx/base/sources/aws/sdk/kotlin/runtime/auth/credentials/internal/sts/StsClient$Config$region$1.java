package aws.sdk.kotlin.runtime.auth.credentials.internal.sts;

import aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient;
import aws.sdk.kotlin.runtime.region.ResolveRegionKt;
import aws.smithy.kotlin.runtime.client.region.RegionProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: StsClient.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.auth.credentials.internal.sts.StsClient$Config$region$1", m1609f = "StsClient.kt", m1610i = {}, m1611l = {101, 101}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {101, -1}, m1615s = {}, m1616v = 2)
final class StsClient$Config$region$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ StsClient.Config.Builder $builder;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StsClient$Config$region$1(StsClient.Config.Builder builder, Continuation<? super StsClient$Config$region$1> continuation) {
        super(2, continuation);
        this.$builder = builder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StsClient$Config$region$1(this.$builder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((StsClient$Config$region$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        if (r5 == r0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        if (r5 != r0) goto L22;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RegionProvider regionProvider = this.$builder.getRegionProvider();
            if (regionProvider != null) {
                this.label = 1;
                obj = regionProvider.getRegion(this);
            } else {
                this.label = 2;
                obj = ResolveRegionKt.resolveRegion$default(null, null, this, 3, null);
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (String) obj;
        }
        ResultKt.throwOnFailure(obj);
        String str = (String) obj;
        if (str != null) {
            return str;
        }
        this.label = 2;
        obj = ResolveRegionKt.resolveRegion$default(null, null, this, 3, null);
    }
}
