package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.time.Instant;
import aws.smithy.kotlin.runtime.util.ExpiringValue;
import com.google.android.gms.location.LocationRequest;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okhttp3.internal.http.HttpStatusCodesKt;

/* JADX INFO: compiled from: PeriodicSweepCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJB\u0010\u0010\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u00002(\u0010\u000f\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R&\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010#\u001a\u00020\"*\u0006\u0012\u0002\b\u00030\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/PeriodicSweepCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Laws/smithy/kotlin/runtime/collections/ExpiringKeyedCache;", "Lkotlin/time/Duration;", "minimumSweepPeriod", "Laws/smithy/kotlin/runtime/time/Clock;", "clock", "<init>", "(JLaws/smithy/kotlin/runtime/time/Clock;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Laws/smithy/kotlin/runtime/util/ExpiringValue;", "", "valueLookup", "get", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "invalidate", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sweep", "()V", "J", "Laws/smithy/kotlin/runtime/time/Clock;", "", "map", "Ljava/util/Map;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Laws/smithy/kotlin/runtime/time/Instant;", "nextSweep", "Laws/smithy/kotlin/runtime/time/Instant;", "", "isExpired", "(Laws/smithy/kotlin/runtime/util/ExpiringValue;)Z", "", "getSize", "()I", "size", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PeriodicSweepCache<K, V> implements ExpiringKeyedCache<K, V> {
    private final Clock clock;
    private final Map<K, ExpiringValue<V>> map;
    private final long minimumSweepPeriod;
    private final Mutex mutex;
    private Instant nextSweep;

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.collections.PeriodicSweepCache$get$1 */
    /* JADX INFO: compiled from: PeriodicSweepCache.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.collections.PeriodicSweepCache", m1609f = "PeriodicSweepCache.kt", m1610i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, m1611l = {102, 53}, m1612m = "get", m1613n = {SubscriberAttributeKt.JSON_NAME_KEY, "valueLookup", "$this$withLock_u24default$iv", "$i$f$withLock", SubscriberAttributeKt.JSON_NAME_KEY, "valueLookup", "$this$withLock_u24default$iv", "current", "$i$f$withLock", "$i$a$-withLock$default-PeriodicSweepCache$get$2"}, m1614nl = {HttpStatusCodesKt.HTTP_EARLY_HINTS, LocationRequest.PRIORITY_NO_POWER}, m1615s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, m1616v = 2)
    static final class C36731 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PeriodicSweepCache<K, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36731(PeriodicSweepCache<K, V> periodicSweepCache, Continuation<? super C36731> continuation) {
            super(continuation);
            this.this$0 = periodicSweepCache;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.get(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.collections.PeriodicSweepCache$invalidate$1 */
    /* JADX INFO: compiled from: PeriodicSweepCache.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.collections.PeriodicSweepCache", m1609f = "PeriodicSweepCache.kt", m1610i = {0, 0, 0}, m1611l = {102}, m1612m = "invalidate", m1613n = {SubscriberAttributeKt.JSON_NAME_KEY, "$this$withLock_u24default$iv", "$i$f$withLock"}, m1614nl = {HttpStatusCodesKt.HTTP_EARLY_HINTS}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C36741 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PeriodicSweepCache<K, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36741(PeriodicSweepCache<K, V> periodicSweepCache, Continuation<? super C36741> continuation) {
            super(continuation);
            this.this$0 = periodicSweepCache;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.invalidate(null, this);
        }
    }

    public /* synthetic */ PeriodicSweepCache(long j, Clock clock, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, clock);
    }

    private PeriodicSweepCache(long j, Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.minimumSweepPeriod = j;
        this.clock = clock;
        this.map = new LinkedHashMap();
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.nextSweep = clock.getNow().m12289plusLRDsOJo(j);
    }

    public /* synthetic */ PeriodicSweepCache(long j, Clock.System system, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? Clock.System.INSTANCE : system, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // aws.smithy.kotlin.runtime.collections.ExpiringKeyedCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object get(K k, Function2<? super K, ? super Continuation<? super ExpiringValue<V>>, ? extends Object> function2, Continuation<? super V> continuation) throws Throwable {
        C36731 c36731;
        Function2<? super K, ? super Continuation<? super ExpiringValue<V>>, ? extends Object> function22;
        Mutex mutex;
        int i;
        Throwable th;
        Mutex mutex2;
        Object obj;
        Object value;
        if (continuation instanceof C36731) {
            c36731 = (C36731) continuation;
            if ((c36731.label & Integer.MIN_VALUE) != 0) {
                c36731.label -= Integer.MIN_VALUE;
            } else {
                c36731 = new C36731(this, continuation);
            }
        }
        Object objInvoke = c36731.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c36731.label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objInvoke);
                Mutex mutex3 = this.mutex;
                c36731.L$0 = k;
                c36731.L$1 = function2;
                c36731.L$2 = mutex3;
                c36731.I$0 = 0;
                c36731.label = 1;
                if (mutex3.lock(null, c36731) != coroutine_suspended) {
                    function22 = function2;
                    mutex = mutex3;
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c36731.I$1;
                int i4 = c36731.I$0;
                mutex2 = (Mutex) c36731.L$2;
                obj = c36731.L$0;
                try {
                    ResultKt.throwOnFailure(objInvoke);
                    this.map.put((K) obj, (ExpiringValue) objInvoke);
                    mutex = mutex2;
                    value = ((ExpiringValue) objInvoke).getValue();
                    mutex.unlock(null);
                    return value;
                } catch (Throwable th2) {
                    th = th2;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i5 = c36731.I$0;
            mutex = (Mutex) c36731.L$2;
            function22 = (Function2) c36731.L$1;
            Object obj2 = c36731.L$0;
            ResultKt.throwOnFailure(objInvoke);
            i = i5;
            k = (Object) obj2;
            if (this.clock.getNow().compareTo(this.nextSweep) > 0) {
                sweep();
            }
            ExpiringValue<V> expiringValue = this.map.get(k);
            if (expiringValue != null && !isExpired(expiringValue)) {
                value = expiringValue.getValue();
                mutex.unlock(null);
                return value;
            }
            c36731.L$0 = k;
            c36731.L$1 = SpillingKt.nullOutSpilledVariable(function22);
            c36731.L$2 = mutex;
            c36731.L$3 = SpillingKt.nullOutSpilledVariable(expiringValue);
            c36731.I$0 = i;
            c36731.I$1 = 0;
            c36731.label = 2;
            objInvoke = function22.invoke(k, c36731);
            if (objInvoke != coroutine_suspended) {
                Mutex mutex4 = mutex;
                obj = k;
                mutex2 = mutex4;
                this.map.put((K) obj, (ExpiringValue) objInvoke);
                mutex = mutex2;
                value = ((ExpiringValue) objInvoke).getValue();
                mutex.unlock(null);
                return value;
            }
            return coroutine_suspended;
        } catch (Throwable th3) {
            Mutex mutex5 = mutex;
            th = th3;
            mutex2 = mutex5;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // aws.smithy.kotlin.runtime.collections.ExpiringKeyedCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invalidate(K k, Continuation<? super Unit> continuation) {
        C36741 c36741;
        Mutex mutex;
        if (continuation instanceof C36741) {
            c36741 = (C36741) continuation;
            if ((c36741.label & Integer.MIN_VALUE) != 0) {
                c36741.label -= Integer.MIN_VALUE;
            } else {
                c36741 = new C36741(this, continuation);
            }
        }
        Object obj = c36741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36741.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mutex;
            c36741.L$0 = k;
            c36741.L$1 = mutex;
            c36741.I$0 = 0;
            c36741.label = 1;
            if (mutex.lock(null, c36741) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c36741.I$0;
            Mutex mutex2 = (Mutex) c36741.L$1;
            Object obj2 = c36741.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            k = (K) obj2;
        }
        try {
            this.map.remove(k);
            if (this.clock.getNow().compareTo(this.nextSweep) > 0) {
                sweep();
            }
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    private final boolean isExpired(ExpiringValue<?> expiringValue) {
        return this.clock.getNow().compareTo(expiringValue.getExpiresAt()) >= 0;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ExpiringKeyedCache
    public int getSize() {
        return this.map.size();
    }

    private final void sweep() {
        Iterator<Map.Entry<K, ExpiringValue<V>>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            if (isExpired(it.next().getValue())) {
                it.remove();
            }
        }
        this.nextSweep = this.clock.getNow().m12289plusLRDsOJo(this.minimumSweepPeriod);
    }
}
