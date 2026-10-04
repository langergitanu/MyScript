package aws.smithy.kotlin.runtime.util;

import androidx.compose.p004ui.spatial.RectListKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: LazyAsyncValue.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B%\u0012\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR.\u0010\u0006\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m1599d2 = {"Laws/smithy/kotlin/runtime/util/LazyAsyncValueImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/util/LazyAsyncValue;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "initializer", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "get", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/sync/Mutex;", "mu", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/jvm/functions/Function1;", "value", "Ljava/lang/Object;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
final class LazyAsyncValueImpl<T> implements LazyAsyncValue<T> {
    private Function1<? super Continuation<? super T>, ? extends Object> initializer;
    private final Mutex mu;
    private Object value;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl$get$1 */
    /* JADX INFO: compiled from: LazyAsyncValue.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.util.LazyAsyncValueImpl", m1609f = "LazyAsyncValue.kt", m1610i = {0, 0, 1, 1, 1}, m1611l = {61, 48}, m1612m = "get", m1613n = {"$this$withLock_u24default$iv", "$i$f$withLock", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-LazyAsyncValueImpl$get$2"}, m1614nl = {RectListKt.BitOffsetForGesturable, 49}, m1615s = {"L$0", "I$0", "L$0", "I$0", "I$1"}, m1616v = 2)
    static final class C37981 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LazyAsyncValueImpl<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C37981(LazyAsyncValueImpl<? extends T> lazyAsyncValueImpl, Continuation<? super C37981> continuation) {
            super(continuation);
            this.this$0 = lazyAsyncValueImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.get(this);
        }
    }

    public LazyAsyncValueImpl(Function1<? super Continuation<? super T>, ? extends Object> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.mu = MutexKt.Mutex$default(false, 1, null);
        this.initializer = initializer;
        this.value = UNINITIALIZED_VALUE.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.util.LazyAsyncValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object get(Continuation<? super T> continuation) throws Throwable {
        C37981 c37981;
        Mutex mutex;
        int i;
        Mutex mutex2;
        Throwable th;
        LazyAsyncValueImpl<T> lazyAsyncValueImpl;
        if (continuation instanceof C37981) {
            c37981 = (C37981) continuation;
            if ((c37981.label & Integer.MIN_VALUE) != 0) {
                c37981.label -= Integer.MIN_VALUE;
            } else {
                c37981 = new C37981(this, continuation);
            }
        }
        Object obj = c37981.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c37981.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = this.mu;
                c37981.L$0 = mutex;
                c37981.I$0 = 0;
                c37981.label = 1;
                if (mutex.lock(null, c37981) != coroutine_suspended) {
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c37981.I$1;
                int i4 = c37981.I$0;
                lazyAsyncValueImpl = (LazyAsyncValueImpl) c37981.L$1;
                mutex2 = (Mutex) c37981.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    lazyAsyncValueImpl.value = obj;
                    this.initializer = null;
                    Object obj2 = this.value;
                    mutex2.unlock(null);
                    return obj2;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            i = c37981.I$0;
            Mutex mutex3 = (Mutex) c37981.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            if (this.value == UNINITIALIZED_VALUE.INSTANCE) {
                Function1<? super Continuation<? super T>, ? extends Object> function1 = this.initializer;
                Intrinsics.checkNotNull(function1);
                c37981.L$0 = mutex;
                c37981.L$1 = this;
                c37981.I$0 = i;
                c37981.I$1 = 0;
                c37981.label = 2;
                Object objInvoke = function1.invoke(c37981);
                if (objInvoke != coroutine_suspended) {
                    mutex2 = mutex;
                    obj = objInvoke;
                    lazyAsyncValueImpl = this;
                    lazyAsyncValueImpl.value = obj;
                    this.initializer = null;
                    Object obj22 = this.value;
                    mutex2.unlock(null);
                    return obj22;
                }
                return coroutine_suspended;
            }
            mutex2 = mutex;
            Object obj222 = this.value;
            mutex2.unlock(null);
            return obj222;
        } catch (Throwable th3) {
            mutex2 = mutex;
            th = th3;
            mutex2.unlock(null);
            throw th;
        }
    }
}
