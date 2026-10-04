package aws.smithy.kotlin.runtime.http.middleware;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.p007ts.TsExtractor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: RetryMiddleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
@DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.http.middleware.RetryMiddleware", m1609f = "RetryMiddleware.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, m1611l = {88, TsExtractor.TS_STREAM_TYPE_AC3, 97}, m1612m = "tryAttempt-BWLJW6A", m1613n = {"request", "next", "it", "attemptTimeout", "scope$iv", "duration$iv", "$completion$iv", "$completion", "attempt", "$i$a$-mapCatching-RetryMiddleware$tryAttempt$result$1", "$i$f$scopedTimeout-hhJSO8g", "$i$a$-scopedTimeout-hhJSO8g-RetryMiddleware$tryAttempt$result$1$1", "request", "next", "it", "attemptTimeout", "scope$iv", "duration$iv", "$completion$iv", "attempt", "$i$a$-mapCatching-RetryMiddleware$tryAttempt$result$1", "$i$f$scopedTimeout-hhJSO8g", "request", "next", "result", "callList", NotificationCompat.CATEGORY_CALL, "httpRequest", "attempt"}, m1614nl = {WebSocketProtocol.PAYLOAD_SHORT, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 99}, m1615s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, m1616v = 2)
final class RetryMiddleware$tryAttempt$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RetryMiddleware<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetryMiddleware$tryAttempt$1(RetryMiddleware<I, O> retryMiddleware, Continuation<? super RetryMiddleware$tryAttempt$1> continuation) {
        super(continuation);
        this.this$0 = retryMiddleware;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM12216tryAttemptBWLJW6A = this.this$0.m12216tryAttemptBWLJW6A(null, null, 0, this);
        return objM12216tryAttemptBWLJW6A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM12216tryAttemptBWLJW6A : Result.m14498boximpl(objM12216tryAttemptBWLJW6A);
    }
}
