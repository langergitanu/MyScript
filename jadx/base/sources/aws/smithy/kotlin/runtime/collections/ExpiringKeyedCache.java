package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.util.ExpiringValue;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ExpiringKeyedCache.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003JB\u0010\t\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u00002(\u0010\b\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0005H¦@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00028\u0000H¦@¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012À\u0006\u0003"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/ExpiringKeyedCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", SubscriberAttributeKt.JSON_NAME_KEY, "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Laws/smithy/kotlin/runtime/util/ExpiringValue;", "valueLookup", "get", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "invalidate", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getSize", "()I", "size", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ExpiringKeyedCache<K, V> {
    Object get(K k, Function2<? super K, ? super Continuation<? super ExpiringValue<V>>, ? extends Object> function2, Continuation<? super V> continuation);

    int getSize();

    Object invalidate(K k, Continuation<? super Unit> continuation);
}
