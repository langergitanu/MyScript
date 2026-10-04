package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ValuesMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B-\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00110\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0082\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u00020\u001dH\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ7\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0005*\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0005H\u0002¢\u0006\u0004\b \u0010!R\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b#\u0010\u0018R,\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00058\u0004X\u0084\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/ValuesMapImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Laws/smithy/kotlin/runtime/collections/ValuesMap;", "", "caseInsensitiveName", "", "", "", "initialValues", "<init>", "(ZLjava/util/Map;)V", "name", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "", "names", "()Ljava/util/Set;", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/Object;)Z", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "deepCopyValues", "(Ljava/util/Map;)Ljava/util/Map;", "Z", "getCaseInsensitiveName", "values", "Ljava/util/Map;", "getValues", "()Ljava/util/Map;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ValuesMapImpl<T> implements ValuesMap<T> {
    private final boolean caseInsensitiveName;
    private final Map<String, List<T>> values;

    /* JADX WARN: Multi-variable type inference failed */
    public ValuesMapImpl() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public ValuesMapImpl(boolean z, Map<String, ? extends List<? extends T>> initialValues) {
        Intrinsics.checkNotNullParameter(initialValues, "initialValues");
        this.caseInsensitiveName = z;
        CaseInsensitiveMap caseInsensitiveMapDeepCopyValues = deepCopyValues(initialValues);
        if (getCaseInsensitiveName()) {
            CaseInsensitiveMap caseInsensitiveMap = new CaseInsensitiveMap();
            caseInsensitiveMap.putAll(caseInsensitiveMapDeepCopyValues);
            caseInsensitiveMapDeepCopyValues = caseInsensitiveMap;
        }
        this.values = caseInsensitiveMapDeepCopyValues;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public /* bridge */ void forEach(Function2<? super String, ? super List<? extends T>, Unit> function2) {
        super.forEach(function2);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public /* bridge */ T get(String str) {
        return (T) super.get(str);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public /* synthetic */ ValuesMapImpl(boolean z, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    protected final Map<String, List<T>> getValues() {
        return this.values;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public List<T> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.get(name);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public Set<String> names() {
        return this.values.keySet();
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public Set<Map.Entry<String, List<T>>> entries() {
        return this.values.entrySet();
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean contains(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.containsKey(name);
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean contains(String name, T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<T> all = getAll(name);
        if (all != null) {
            return all.contains(value);
        }
        return false;
    }

    @Override // aws.smithy.kotlin.runtime.collections.ValuesMap
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    public boolean equals(Object other) {
        if (other instanceof ValuesMapImpl) {
            ValuesMapImpl valuesMapImpl = (ValuesMapImpl) other;
            return getCaseInsensitiveName() == valuesMapImpl.getCaseInsensitiveName() && Intrinsics.areEqual(this.values, valuesMapImpl.values);
        }
        if (other instanceof ValuesMap) {
            ValuesMap valuesMap = (ValuesMap) other;
            if (getCaseInsensitiveName() == valuesMap.getCaseInsensitiveName() && Intrinsics.areEqual(entries(), valuesMap.entries())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    private final Map<String, List<T>> deepCopyValues(Map<String, ? extends List<? extends T>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), CollectionsKt.toList((List) entry.getValue()));
        }
        return linkedHashMap;
    }
}
