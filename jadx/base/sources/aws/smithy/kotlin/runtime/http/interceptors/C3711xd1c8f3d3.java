package aws.smithy.kotlin.runtime.http.interceptors;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: aws.smithy.kotlin.runtime.http.interceptors.DiscoveredEndpointErrorInterceptor$modifyBeforeAttemptCompletion$1 */
/* JADX INFO: compiled from: DiscoveredEndpointErrorInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.interceptors.DiscoveredEndpointErrorInterceptor", m1609f = "DiscoveredEndpointErrorInterceptor.kt", m1610i = {0, 0, 0}, m1611l = {33}, m1612m = "modifyBeforeAttemptCompletion-gIAlu-s", m1613n = {WebViewMessageType.CONTEXT, "e", "$i$a$-let-DiscoveredEndpointErrorInterceptor$modifyBeforeAttemptCompletion$2"}, m1614nl = {34}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
final class C3711xd1c8f3d3 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiscoveredEndpointErrorInterceptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3711xd1c8f3d3(DiscoveredEndpointErrorInterceptor discoveredEndpointErrorInterceptor, Continuation<? super C3711xd1c8f3d3> continuation) {
        super(continuation);
        this.this$0 = discoveredEndpointErrorInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo12026modifyBeforeAttemptCompletiongIAlus = this.this$0.mo12026modifyBeforeAttemptCompletiongIAlus(null, this);
        return objMo12026modifyBeforeAttemptCompletiongIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo12026modifyBeforeAttemptCompletiongIAlus : Result.m14498boximpl(objMo12026modifyBeforeAttemptCompletiongIAlus);
    }
}
