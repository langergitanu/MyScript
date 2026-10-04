package aws.smithy.kotlin.runtime.p011io.middleware;

import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.p011io.Handler;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Phase.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001#B\u0007¢\u0006\u0004\b\u0004\u0010\u0005Jk\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0007\u001a\u00020\u00062R\u0010\u0010\u001aN\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\b¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0016\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00182\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0019J+\u0010\u0016\u001a\u00020\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u001bJ6\u0010\u001e\u001a\u00028\u0001\"\u0014\b\u0002\u0010\u001c*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u001d\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0002H\u0096@¢\u0006\u0004\b\u001e\u0010\u001fR&\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/middleware/Phase;", "Request", "Response", "Laws/smithy/kotlin/runtime/io/middleware/Middleware;", "<init>", "()V", "Laws/smithy/kotlin/runtime/io/middleware/Phase$Order;", "order", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "req", "Laws/smithy/kotlin/runtime/io/Handler;", "next", "Lkotlin/coroutines/Continuation;", "", "interceptor", "", "intercept", "(Laws/smithy/kotlin/runtime/io/middleware/Phase$Order;Lkotlin/jvm/functions/Function3;)V", "Laws/smithy/kotlin/runtime/io/middleware/ModifyRequest;", "transform", "register", "(Laws/smithy/kotlin/runtime/io/middleware/ModifyRequest;Laws/smithy/kotlin/runtime/io/middleware/Phase$Order;)V", "Laws/smithy/kotlin/runtime/io/middleware/ModifyResponse;", "(Laws/smithy/kotlin/runtime/io/middleware/ModifyResponse;Laws/smithy/kotlin/runtime/io/middleware/Phase$Order;)V", "middleware", "(Laws/smithy/kotlin/runtime/io/middleware/Middleware;Laws/smithy/kotlin/runtime/io/middleware/Phase$Order;)V", "H", "request", "handle", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/io/Handler;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/collections/ArrayDeque;", "middlewares", "Lkotlin/collections/ArrayDeque;", "Order", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Phase<Request, Response> implements Middleware<Request, Response> {
    private final ArrayDeque<Middleware<Request, Response>> middlewares = new ArrayDeque<>();

    /* JADX INFO: compiled from: Phase.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Order.values().length];
            try {
                iArr[Order.Before.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Order.After.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: Phase.kt */
    @InternalApi
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Laws/smithy/kotlin/runtime/io/middleware/Phase$Order;", "", "<init>", "(Ljava/lang/String;I)V", "Before", "After", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Order {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Order[] $VALUES;
        public static final Order Before = new Order("Before", 0);
        public static final Order After = new Order("After", 1);

        private static final /* synthetic */ Order[] $values() {
            return new Order[]{Before, After};
        }

        public static EnumEntries<Order> getEntries() {
            return $ENTRIES;
        }

        public static Order valueOf(String str) {
            return (Order) Enum.valueOf(Order.class, str);
        }

        public static Order[] values() {
            return (Order[]) $VALUES.clone();
        }

        private Order(String str, int i) {
        }

        static {
            Order[] orderArr$values = $values();
            $VALUES = orderArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(orderArr$values);
        }
    }

    public static /* synthetic */ void intercept$default(Phase phase, Order order, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            order = Order.After;
        }
        phase.intercept(order, function3);
    }

    public final void intercept(Order order, Function3<? super Request, ? super Handler<? super Request, ? extends Response>, ? super Continuation<? super Response>, ? extends Object> interceptor) {
        Intrinsics.checkNotNullParameter(order, "order");
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        register(new MiddlewareLambda(interceptor), order);
    }

    public static /* synthetic */ void register$default(Phase phase, ModifyRequest modifyRequest, Order order, int i, Object obj) {
        if ((i & 2) != 0) {
            order = Order.After;
        }
        phase.register(modifyRequest, order);
    }

    public final void register(ModifyRequest<Request> transform, Order order) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(order, "order");
        register(new ModifyRequestMiddleware(transform), order);
    }

    public static /* synthetic */ void register$default(Phase phase, ModifyResponse modifyResponse, Order order, int i, Object obj) {
        if ((i & 2) != 0) {
            order = Order.After;
        }
        phase.register(modifyResponse, order);
    }

    public final void register(ModifyResponse<Response> transform, Order order) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        Intrinsics.checkNotNullParameter(order, "order");
        register(new ModifyResponseMiddleware(transform), order);
    }

    public static /* synthetic */ void register$default(Phase phase, Middleware middleware, Order order, int i, Object obj) {
        if ((i & 2) != 0) {
            order = Order.After;
        }
        phase.register(middleware, order);
    }

    public final void register(Middleware<Request, Response> middleware, Order order) {
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        Intrinsics.checkNotNullParameter(order, "order");
        int i = WhenMappings.$EnumSwitchMapping$0[order.ordinal()];
        if (i == 1) {
            this.middlewares.addFirst(middleware);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.middlewares.addLast(middleware);
        }
    }

    @Override // aws.smithy.kotlin.runtime.p011io.middleware.Middleware
    public <H extends Handler<? super Request, ? extends Response>> Object handle(Request request, H h, Continuation<? super Response> continuation) {
        if (this.middlewares.isEmpty()) {
            return h.call(request, continuation);
        }
        Middleware[] middlewareArr = (Middleware[]) this.middlewares.toArray(new Middleware[0]);
        return MiddlewareKt.decorate(h, (Middleware[]) Arrays.copyOf(middlewareArr, middlewareArr.length)).call(request, continuation);
    }
}
