package androidx.datastore.preferences.core;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Actual.jvmAndroid.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0000\u001a\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006H\u0000\u001a\b\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, m1599d2 = {"immutableMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "map", "immutableCopyOfSet", "", ExifInterface.GPS_DIRECTION_TRUE, "set", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "datastore-preferences-core"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class Actual_jvmAndroidKt {
    public static final <K, V> Map<K, V> immutableMap(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    public static final <T> Set<T> immutableCopyOfSet(Set<? extends T> set) {
        Intrinsics.checkNotNullParameter(set, "set");
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(CollectionsKt.toSet(set));
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public static final CoroutineDispatcher ioDispatcher() {
        return Dispatchers.getIO();
    }
}
