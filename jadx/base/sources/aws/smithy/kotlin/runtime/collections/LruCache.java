package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\t\u0010\nJ \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001H\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\u000f\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R0\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0016j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R#\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001b0\u001a8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010 \u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0012¨\u0006!"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/LruCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "", "capacity", "<init>", "(I)V", "k", "get", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "", "put", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "I", "getCapacity", "()I", "Lkotlinx/coroutines/sync/Mutex;", "mu", "Lkotlinx/coroutines/sync/Mutex;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "map", "Ljava/util/LinkedHashMap;", "", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getSize", "size", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LruCache<K, V> {
    private final int capacity;
    private final Mutex mu = MutexKt.Mutex$default(false, 1, null);
    private final LinkedHashMap<K, V> map = new LinkedHashMap<>();

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.collections.LruCache$get$1 */
    /* JADX INFO: compiled from: LruCache.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.collections.LruCache", m1609f = "LruCache.kt", m1610i = {0, 0, 0}, m1611l = {85}, m1612m = "get", m1613n = {"k", "$this$withLock_u24default$iv", "$i$f$withLock"}, m1614nl = {86}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C36701 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LruCache<K, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36701(LruCache<K, V> lruCache, Continuation<? super C36701> continuation) {
            super(continuation);
            this.this$0 = lruCache;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.get(null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.collections.LruCache$put$1 */
    /* JADX INFO: compiled from: LruCache.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.collections.LruCache", m1609f = "LruCache.kt", m1610i = {0, 0, 0, 0}, m1611l = {85}, m1612m = "put", m1613n = {"k", "v", "$this$withLock_u24default$iv", "$i$f$withLock"}, m1614nl = {86}, m1615s = {"L$0", "L$1", "L$2", "I$0"}, m1616v = 2)
    static final class C36711 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LruCache<K, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36711(LruCache<K, V> lruCache, Continuation<? super C36711> continuation) {
            super(continuation);
            this.this$0 = lruCache;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.put(null, null, this);
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.collections.LruCache$remove$1 */
    /* JADX INFO: compiled from: LruCache.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "aws.smithy.kotlin.runtime.collections.LruCache", m1609f = "LruCache.kt", m1610i = {0, 0, 0}, m1611l = {85}, m1612m = "remove", m1613n = {"k", "$this$withLock_u24default$iv", "$i$f$withLock"}, m1614nl = {86}, m1615s = {"L$0", "L$1", "I$0"}, m1616v = 2)
    static final class C36721 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LruCache<K, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C36721(LruCache<K, V> lruCache, Continuation<? super C36721> continuation) {
            super(continuation);
            this.this$0 = lruCache;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.remove(null, this);
        }
    }

    public LruCache(int i) {
        this.capacity = i;
        if (i <= 0) {
            throw new IllegalArgumentException(("cache capacity must be greater than 0, was " + i).toString());
        }
    }

    public final int getCapacity() {
        return this.capacity;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(K k, Continuation<? super V> continuation) {
        C36701 c36701;
        Mutex mutex;
        if (continuation instanceof C36701) {
            c36701 = (C36701) continuation;
            if ((c36701.label & Integer.MIN_VALUE) != 0) {
                c36701.label -= Integer.MIN_VALUE;
            } else {
                c36701 = new C36701(this, continuation);
            }
        }
        Object obj = c36701.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36701.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mu;
            c36701.L$0 = k;
            c36701.L$1 = mutex;
            c36701.I$0 = 0;
            c36701.label = 1;
            if (mutex.lock(null, c36701) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c36701.I$0;
            Mutex mutex2 = (Mutex) c36701.L$1;
            Object obj2 = c36701.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            k = (K) obj2;
        }
        try {
            LruCacheKt.moveKeyToBack(this.map, k);
            return this.map.get(k);
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object put(K k, V v, Continuation<? super Unit> continuation) {
        C36711 c36711;
        Mutex mutex;
        if (continuation instanceof C36711) {
            c36711 = (C36711) continuation;
            if ((c36711.label & Integer.MIN_VALUE) != 0) {
                c36711.label -= Integer.MIN_VALUE;
            } else {
                c36711 = new C36711(this, continuation);
            }
        }
        Object obj = c36711.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36711.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mu;
            c36711.L$0 = k;
            c36711.L$1 = v;
            c36711.L$2 = mutex;
            c36711.I$0 = 0;
            c36711.label = 1;
            if (mutex.lock(null, c36711) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c36711.I$0;
            Mutex mutex2 = (Mutex) c36711.L$2;
            v = (V) c36711.L$1;
            Object obj2 = c36711.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            k = (K) obj2;
        }
        try {
            if (!this.map.containsKey(k) && this.map.size() == this.capacity) {
                LinkedHashMap<K, V> linkedHashMap = this.map;
                Set<K> setKeySet = linkedHashMap.keySet();
                Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
                linkedHashMap.remove(CollectionsKt.first(setKeySet));
            }
            this.map.put(k, v);
            LruCacheKt.moveKeyToBack(this.map, k);
            return Unit.INSTANCE;
        } finally {
            mutex.unlock(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object remove(K k, Continuation<? super V> continuation) {
        C36721 c36721;
        Mutex mutex;
        if (continuation instanceof C36721) {
            c36721 = (C36721) continuation;
            if ((c36721.label & Integer.MIN_VALUE) != 0) {
                c36721.label -= Integer.MIN_VALUE;
            } else {
                c36721 = new C36721(this, continuation);
            }
        }
        Object obj = c36721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c36721.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.mu;
            c36721.L$0 = k;
            c36721.L$1 = mutex;
            c36721.I$0 = 0;
            c36721.label = 1;
            if (mutex.lock(null, c36721) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c36721.I$0;
            Mutex mutex2 = (Mutex) c36721.L$1;
            Object obj2 = c36721.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            k = (K) obj2;
        }
        try {
            return this.map.remove(k);
        } finally {
            mutex.unlock(null);
        }
    }

    public final Set<Map.Entry<K, V>> getEntries() {
        return MapsKt.toMap(this.map).entrySet();
    }

    public final int getSize() {
        return this.map.size();
    }
}
