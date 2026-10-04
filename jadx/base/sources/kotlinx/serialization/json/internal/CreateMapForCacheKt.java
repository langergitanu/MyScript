package kotlinx.serialization.json.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: compiled from: createMapForCache.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u001a(\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, m1599d2 = {"createMapForCache", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "initialCapacity", "", "kotlinx-serialization-json"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class CreateMapForCacheKt {
    public static final <K, V> Map<K, V> createMapForCache(int i) {
        return new ConcurrentHashMap(i);
    }
}
