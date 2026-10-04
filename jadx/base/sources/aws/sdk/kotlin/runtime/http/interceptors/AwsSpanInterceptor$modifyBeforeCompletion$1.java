package aws.sdk.kotlin.runtime.http.interceptors;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AwsSpanInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.sdk.kotlin.runtime.http.interceptors.AwsSpanInterceptor", m1609f = "AwsSpanInterceptor.kt", m1610i = {0, 0, 0}, m1611l = {36}, m1612m = "modifyBeforeCompletion-gIAlu-s", m1613n = {WebViewMessageType.CONTEXT, "httpResp", TtmlNode.TAG_SPAN}, m1614nl = {-1}, m1615s = {"L$0", "L$1", "L$2"}, m1616v = 2)
final class AwsSpanInterceptor$modifyBeforeCompletion$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AwsSpanInterceptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AwsSpanInterceptor$modifyBeforeCompletion$1(AwsSpanInterceptor awsSpanInterceptor, Continuation<? super AwsSpanInterceptor$modifyBeforeCompletion$1> continuation) {
        super(continuation);
        this.this$0 = awsSpanInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objMo12027modifyBeforeCompletiongIAlus = this.this$0.mo12027modifyBeforeCompletiongIAlus(null, this);
        return objMo12027modifyBeforeCompletiongIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo12027modifyBeforeCompletiongIAlus : Result.m14498boximpl(objMo12027modifyBeforeCompletiongIAlus);
    }
}
