package aws.smithy.kotlin.runtime.p011io.middleware;

import aws.smithy.kotlin.runtime.p011io.Handler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModifyRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010\f\u001a\u00028\u0001\"\u0014\b\u0002\u0010\t*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0002H\u0096@¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/middleware/ModifyRequestMiddleware;", "Request", "Response", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "Laws/smithy/kotlin/runtime/io/middleware/ModifyRequest;", "transform", "<init>", "(Laws/smithy/kotlin/runtime/io/middleware/ModifyRequest;)V", "Laws/smithy/kotlin/runtime/io/Handler;", "H", "request", "next", "handle", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Laws/smithy/kotlin/runtime/io/middleware/ModifyRequest;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ModifyRequestMiddleware<Request, Response> implements Middleware<Request, Response> {
    private final ModifyRequest<Request> transform;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware$handle$1 */
    /* JADX INFO: compiled from: ModifyRequest.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware", m1609f = "ModifyRequest.kt", m1610i = {0, 0, 1, 1}, m1611l = {25, 25}, m1612m = "handle", m1613n = {"request", "next", "request", "next"}, m1614nl = {25, -1}, m1615s = {"L$0", "L$1", "L$0", "L$1"}, m1616v = 2)
    static final class C37631<H extends Handler<? super Request, ? extends Response>> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ ModifyRequestMiddleware<Request, Response> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37631(ModifyRequestMiddleware<Request, Response> modifyRequestMiddleware, Continuation<? super C37631> continuation) {
            super(continuation);
            this.this$0 = modifyRequestMiddleware;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handle(null, null, this);
        }
    }

    public ModifyRequestMiddleware(ModifyRequest<Request> transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        this.transform = transform;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.p011io.middleware.Middleware
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <H extends Handler<? super Request, ? extends Response>> Object handle(Request request, H h, Continuation<? super Response> continuation) {
        C37631 c37631;
        Object obj;
        Handler handler;
        Handler handler2;
        if (continuation instanceof C37631) {
            c37631 = (C37631) continuation;
            if ((c37631.label & Integer.MIN_VALUE) != 0) {
                c37631.label -= Integer.MIN_VALUE;
            } else {
                c37631 = new C37631(this, continuation);
            }
        }
        Object obj2 = c37631.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c37631.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            ModifyRequest<Request> modifyRequest = this.transform;
            c37631.L$0 = SpillingKt.nullOutSpilledVariable(request);
            c37631.L$1 = SpillingKt.nullOutSpilledVariable(h);
            c37631.L$2 = h;
            c37631.label = 1;
            Object objModifyRequest = modifyRequest.modifyRequest(request, c37631);
            if (objModifyRequest != coroutine_suspended) {
                obj = objModifyRequest;
                handler = h;
                handler2 = h;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj3 = c37631.L$0;
            ResultKt.throwOnFailure(obj2);
            return obj2;
        }
        Handler handler3 = (H) c37631.L$2;
        Handler handler4 = (Handler) c37631.L$1;
        Object obj4 = c37631.L$0;
        ResultKt.throwOnFailure(obj2);
        handler = handler4;
        request = (Request) obj4;
        obj = obj2;
        handler2 = handler3;
        c37631.L$0 = SpillingKt.nullOutSpilledVariable(request);
        c37631.L$1 = SpillingKt.nullOutSpilledVariable(handler);
        c37631.L$2 = null;
        c37631.label = 2;
        Object objCall = handler2.call(obj, c37631);
        return objCall == coroutine_suspended ? coroutine_suspended : objCall;
    }
}
