package aws.smithy.kotlin.runtime.p011io.middleware;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.Handler;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Middleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003BM\u0012D\u0010\t\u001a@\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\b¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\u000f\u001a\u00028\u0001\"\u0014\b\u0002\u0010\f*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0002H\u0096@¢\u0006\u0004\b\u000f\u0010\u0010JN\u0010\u0011\u001a@\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\bHÂ\u0003¢\u0006\u0004\b\u0011\u0010\u0012Jd\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002F\b\u0002\u0010\t\u001a@\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001a\u001a\u00020\u0019HÖ\u0081\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001d\u001a\u00020\u001cHÖ\u0081\u0004¢\u0006\u0004\b\u001d\u0010\u001eRR\u0010\t\u001a@\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001f¨\u0006 "}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/middleware/MiddlewareLambda;", "Request", "Response", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "Lkotlin/Function3;", "Laws/smithy/kotlin/runtime/io/Handler;", "Lkotlin/coroutines/Continuation;", "", "Laws/smithy/kotlin/runtime/io/middleware/MiddlewareFn;", "fn", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "H", "request", "next", "handle", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Lkotlin/jvm/functions/Function3;", "copy", "(Lkotlin/jvm/functions/Function3;)Laws/smithy/kotlin/runtime/io/middleware/MiddlewareLambda;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function3;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final /* data */ class MiddlewareLambda<Request, Response> implements Middleware<Request, Response> {
    private final Function3<Request, Handler<? super Request, ? extends Response>, Continuation<? super Response>, Object> fn;

    private final Function3<Request, Handler<? super Request, ? extends Response>, Continuation<? super Response>, Object> component1() {
        return this.fn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MiddlewareLambda copy$default(MiddlewareLambda middlewareLambda, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            function3 = middlewareLambda.fn;
        }
        return middlewareLambda.copy(function3);
    }

    public final MiddlewareLambda<Request, Response> copy(Function3<? super Request, ? super Handler<? super Request, ? extends Response>, ? super Continuation<? super Response>, ? extends Object> fn) {
        Intrinsics.checkNotNullParameter(fn, "fn");
        return new MiddlewareLambda<>(fn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MiddlewareLambda) && Intrinsics.areEqual(this.fn, ((MiddlewareLambda) other).fn);
    }

    public int hashCode() {
        return this.fn.hashCode();
    }

    public String toString() {
        return "MiddlewareLambda(fn=" + this.fn + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MiddlewareLambda(Function3<? super Request, ? super Handler<? super Request, ? extends Response>, ? super Continuation<? super Response>, ? extends Object> fn) {
        Intrinsics.checkNotNullParameter(fn, "fn");
        this.fn = fn;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.middleware.Middleware
    public <H extends Handler<? super Request, ? extends Response>> Object handle(Request request, H h, Continuation<? super Response> continuation) {
        return this.fn.invoke(request, h, continuation);
    }
}
