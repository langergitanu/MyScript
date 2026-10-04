package aws.smithy.kotlin.runtime.p011io.middleware;

import androidx.core.app.NotificationCompat;
import aws.smithy.kotlin.runtime.p011io.Handler;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Middleware.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B/\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\u00028\u00012\u0006\u0010\t\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJH\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u00020\u0017HÖ\u0081\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u00020\u001aHÖ\u0081\u0004¢\u0006\u0004\b\u001b\u0010\u001cR#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001e\u0010\rR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b \u0010\u000f¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/middleware/DecoratedHandler;", "Request", "Response", "Laws/smithy/kotlin/runtime/io/Handler;", "handler", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "with", "<init>", "(Laws/smithy/kotlin/runtime/io/Handler;Laws/smithy/kotlin/runtime/io/middleware/Middleware;)V", "request", NotificationCompat.CATEGORY_CALL, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "()Laws/smithy/kotlin/runtime/io/Handler;", "component2", "()Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "copy", "(Laws/smithy/kotlin/runtime/io/Handler;Laws/smithy/kotlin/runtime/io/middleware/Middleware;)Laws/smithy/kotlin/runtime/io/middleware/DecoratedHandler;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Laws/smithy/kotlin/runtime/io/Handler;", "getHandler", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "getWith", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* data */ class DecoratedHandler<Request, Response> implements Handler<Request, Response> {
    private final Handler<Request, Response> handler;
    private final Middleware<Request, Response> with;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DecoratedHandler copy$default(DecoratedHandler decoratedHandler, Handler handler, Middleware middleware, int i, Object obj) {
        if ((i & 1) != 0) {
            handler = decoratedHandler.handler;
        }
        if ((i & 2) != 0) {
            middleware = decoratedHandler.with;
        }
        return decoratedHandler.copy(handler, middleware);
    }

    public final Handler<Request, Response> component1() {
        return this.handler;
    }

    public final Middleware<Request, Response> component2() {
        return this.with;
    }

    public final DecoratedHandler<Request, Response> copy(Handler<? super Request, ? extends Response> handler, Middleware<Request, Response> with) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(with, "with");
        return new DecoratedHandler<>(handler, with);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DecoratedHandler)) {
            return false;
        }
        DecoratedHandler decoratedHandler = (DecoratedHandler) other;
        return Intrinsics.areEqual(this.handler, decoratedHandler.handler) && Intrinsics.areEqual(this.with, decoratedHandler.with);
    }

    public int hashCode() {
        return (this.handler.hashCode() * 31) + this.with.hashCode();
    }

    public String toString() {
        return "DecoratedHandler(handler=" + this.handler + ", with=" + this.with + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DecoratedHandler(Handler<? super Request, ? extends Response> handler, Middleware<Request, Response> with) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(with, "with");
        this.handler = handler;
        this.with = with;
    }

    public final Handler<Request, Response> getHandler() {
        return this.handler;
    }

    public final Middleware<Request, Response> getWith() {
        return this.with;
    }

    @Override // aws.smithy.kotlin.runtime.p011io.Handler
    public Object call(Request request, Continuation<? super Response> continuation) {
        return this.with.handle(request, this.handler, continuation);
    }
}
