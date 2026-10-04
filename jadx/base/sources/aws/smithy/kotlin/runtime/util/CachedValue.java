package aws.smithy.kotlin.runtime.util;

import androidx.concurrent.futures.C1519xc40028dd;
import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;

/* JADX INFO: compiled from: CachedValue.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003B-\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB-\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u0018\u001a\u00028\u00002\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0014H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010&¨\u0006'"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/CachedValue;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Closeable;", "Laws/smithy/kotlin/runtime/io/Closeable;", "Laws/smithy/kotlin/runtime/util/ExpiringValue;", "value", "Lkotlin/time/Duration;", "bufferTime", "Laws/smithy/kotlin/runtime/time/Clock;", "clock", "<init>", "(Laws/smithy/kotlin/runtime/util/ExpiringValue;JLaws/smithy/kotlin/runtime/time/Clock;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Laws/smithy/kotlin/runtime/time/Instant;", "expiresAt", "(Ljava/lang/Object;Laws/smithy/kotlin/runtime/time/Instant;JLaws/smithy/kotlin/runtime/time/Clock;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "isExpired", "(Laws/smithy/kotlin/runtime/util/ExpiringValue;)Z", "get", "()Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "initializer", "getOrLoad", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "close", "()V", "Laws/smithy/kotlin/runtime/util/ExpiringValue;", "J", "Laws/smithy/kotlin/runtime/time/Clock;", "Lkotlinx/coroutines/sync/Semaphore;", "gate", "Lkotlinx/coroutines/sync/Semaphore;", "getRef", "()Laws/smithy/kotlin/runtime/util/ExpiringValue;", "ref", "()Z", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CachedValue<T> implements Closeable {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _ref$FU = AtomicReferenceFieldUpdater.newUpdater(CachedValue.class, Object.class, "_ref");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(CachedValue.class, "closed");
    private volatile /* synthetic */ Object _ref;
    private final long bufferTime;
    private final Clock clock;
    private volatile /* synthetic */ int closed;
    private final Semaphore gate;
    private ExpiringValue<T> value;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.util.CachedValue$getOrLoad$1 */
    /* JADX INFO: compiled from: CachedValue.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.util.CachedValue", m1609f = "CachedValue.kt", m1610i = {0, 0, 0, 1, 1, 1, 1, 1}, m1611l = {96, 80}, m1612m = "getOrLoad", m1613n = {"initializer", "$this$withPermit$iv", "$i$f$withPermit", "initializer", "$this$withPermit$iv", "curr", "$i$f$withPermit", "$i$a$-withPermit-CachedValue$getOrLoad$2"}, m1614nl = {97, 82}, m1615s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, m1616v = 2)
    static final class C37961 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CachedValue<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C37961(CachedValue<T> cachedValue, Continuation<? super C37961> continuation) {
            super(continuation);
            this.this$0 = cachedValue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getOrLoad(null, this);
        }
    }

    public /* synthetic */ CachedValue(ExpiringValue expiringValue, long j, Clock clock, DefaultConstructorMarker defaultConstructorMarker) {
        this(expiringValue, j, clock);
    }

    public /* synthetic */ CachedValue(Object obj, Instant instant, long j, Clock clock, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, instant, j, clock);
    }

    private CachedValue(ExpiringValue<T> expiringValue, long j, Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.value = expiringValue;
        this.bufferTime = j;
        this.clock = clock;
        this.gate = SemaphoreKt.Semaphore$default(1, 0, 2, null);
        this._ref = this.value;
        this.closed = 0;
    }

    public /* synthetic */ CachedValue(ExpiringValue expiringValue, long j, Clock.System system, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : expiringValue, (i & 2) != 0 ? Duration.INSTANCE.m15951getZEROUwyO8pc() : j, (i & 4) != 0 ? Clock.System.INSTANCE : system, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private CachedValue(T t, Instant expiresAt, long j, Clock clock) {
        this(new ExpiringValue(t, expiresAt), j, clock, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
        Intrinsics.checkNotNullParameter(clock, "clock");
    }

    public /* synthetic */ CachedValue(Object obj, Instant instant, long j, Clock.System system, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, instant, (i & 4) != 0 ? Duration.INSTANCE.m15951getZEROUwyO8pc() : j, (i & 8) != 0 ? Clock.System.INSTANCE : system, (DefaultConstructorMarker) null);
    }

    private final ExpiringValue<T> getRef() {
        return (ExpiringValue) this._ref;
    }

    public final boolean isExpired() {
        if (this.closed != 0) {
            throw new IllegalStateException("value is closed".toString());
        }
        ExpiringValue<T> ref = getRef();
        if (ref != null) {
            return isExpired(ref);
        }
        return true;
    }

    private final boolean isExpired(ExpiringValue<T> value) {
        return this.clock.getNow().compareTo(value.getExpiresAt().m12288minusLRDsOJo(this.bufferTime)) >= 0;
    }

    public final T get() {
        if (this.closed != 0) {
            throw new IllegalStateException("value is closed".toString());
        }
        ExpiringValue<T> ref = getRef();
        if (ref == null || isExpired(ref)) {
            return null;
        }
        return ref.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x003c, B:37:0x00a2, B:39:0x00a8, B:41:0x00b0, B:44:0x00b8, B:45:0x00c3, B:46:0x00c4, B:47:0x00cd), top: B:54:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x003c, B:37:0x00a2, B:39:0x00a8, B:41:0x00b0, B:44:0x00b8, B:45:0x00c3, B:46:0x00c4, B:47:0x00cd), top: B:54:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getOrLoad(Function1<? super Continuation<? super ExpiringValue<T>>, ? extends Object> function1, Continuation<? super T> continuation) throws Throwable {
        C37961 c37961;
        Semaphore semaphore;
        int i;
        Semaphore semaphore2;
        ExpiringValue<T> expiringValue;
        if (continuation instanceof C37961) {
            c37961 = (C37961) continuation;
            if ((c37961.label & Integer.MIN_VALUE) != 0) {
                c37961.label -= Integer.MIN_VALUE;
            } else {
                c37961 = new C37961(this, continuation);
            }
        }
        Object objInvoke = c37961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c37961.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Semaphore semaphore3 = this.gate;
                c37961.L$0 = function1;
                c37961.L$1 = semaphore3;
                c37961.I$0 = 0;
                c37961.label = 1;
                if (semaphore3.acquire(c37961) != coroutine_suspended) {
                    semaphore = semaphore3;
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c37961.I$1;
                int i4 = c37961.I$0;
                expiringValue = (ExpiringValue) c37961.L$2;
                semaphore2 = (Semaphore) c37961.L$1;
                try {
                    ResultKt.throwOnFailure(objInvoke);
                    ExpiringValue expiringValue2 = (ExpiringValue) objInvoke;
                    if (this.closed == 0) {
                        throw new IllegalStateException("value is closed".toString());
                    }
                    if (!C1519xc40028dd.m48m(_ref$FU, this, expiringValue, expiringValue2)) {
                        throw new IllegalStateException("value changed during getOrLoad".toString());
                    }
                    Object value = expiringValue2.getValue();
                    semaphore2.release();
                    return value;
                } catch (Throwable th) {
                    th = th;
                    semaphore2.release();
                    throw th;
                }
            }
            int i5 = c37961.I$0;
            semaphore = (Semaphore) c37961.L$1;
            Function1<? super Continuation<? super ExpiringValue<T>>, ? extends Object> function12 = (Function1) c37961.L$0;
            ResultKt.throwOnFailure(objInvoke);
            i = i5;
            function1 = function12;
            if (this.closed != 0) {
                throw new IllegalStateException("value is closed".toString());
            }
            ExpiringValue<T> ref = getRef();
            if (ref != null && !isExpired(ref)) {
                T value2 = ref.getValue();
                semaphore.release();
                return value2;
            }
            c37961.L$0 = SpillingKt.nullOutSpilledVariable(function1);
            c37961.L$1 = semaphore;
            c37961.L$2 = ref;
            c37961.I$0 = i;
            c37961.I$1 = 0;
            c37961.label = 2;
            objInvoke = function1.invoke(c37961);
            if (objInvoke != coroutine_suspended) {
                semaphore2 = semaphore;
                expiringValue = ref;
                ExpiringValue expiringValue22 = (ExpiringValue) objInvoke;
                if (this.closed == 0) {
                }
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            semaphore2 = semaphore;
            semaphore2.release();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Object obj;
        if (closed$FU.compareAndSet(this, 0, 1)) {
            do {
                obj = this._ref;
            } while (!C1519xc40028dd.m48m(_ref$FU, this, obj, null));
        }
    }
}
