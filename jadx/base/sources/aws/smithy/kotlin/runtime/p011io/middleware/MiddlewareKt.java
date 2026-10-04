package aws.smithy.kotlin.runtime.p011io.middleware;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.Handler;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Middleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b*x\b\u0007\u0010\r\u001a\u0004\b\u0000\u0010\u0000\u001a\u0004\b\u0001\u0010\u0001\"0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\t20\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tB\u0002\b\f¨\u0006\u000e"}, m1599d2 = {"Request", "Response", "Laws/smithy/kotlin/runtime/io/Handler;", "handler", "", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "middleware", "decorate", "(Laws/smithy/kotlin/runtime/io/Handler;[Laws/smithy/kotlin/runtime/io/middleware/Middleware;)Laws/smithy/kotlin/runtime/io/Handler;", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "Laws/smithy/kotlin/runtime/InternalApi;", "MiddlewareFn", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MiddlewareKt {
    @InternalApi
    public static /* synthetic */ void MiddlewareFn$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InternalApi
    public static final <Request, Response> Handler<Request, Response> decorate(Handler<? super Request, ? extends Response> handler, Middleware<Request, Response>... middleware) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        if (middleware.length == 0) {
            return handler;
        }
        List listDropLast = ArraysKt.dropLast(middleware, 1);
        DecoratedHandler decoratedHandler = new DecoratedHandler(handler, (Middleware) ArraysKt.last(middleware));
        if (!listDropLast.isEmpty()) {
            ListIterator listIterator = listDropLast.listIterator(listDropLast.size());
            while (listIterator.hasPrevious()) {
                decoratedHandler = new DecoratedHandler(decoratedHandler, (Middleware) listIterator.previous());
            }
        }
        return decoratedHandler;
    }
}
