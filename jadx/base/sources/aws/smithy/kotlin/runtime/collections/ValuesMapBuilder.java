package aws.smithy.kotlin.runtime.collections;

import androidx.exifinterface.media.ExifInterface;
import aws.smithy.kotlin.runtime.InternalApi;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ValuesMap.kt */
/* JADX INFO: loaded from: classes4.dex */
@InternalApi
@Metadata(m1598d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010&\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0004\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u0011J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0018\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u00170\u0012¢\u0006\u0004\b\u0018\u0010\u0014J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u001c\u0010\u001bJ\u001a\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u001f\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010\u001bJ\u001b\u0010\"\u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00192\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0004\b$\u0010#J#\u0010\"\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%¢\u0006\u0004\b\"\u0010'J#\u0010$\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\t2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%¢\u0006\u0004\b$\u0010'J\u001d\u0010)\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010(2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b)\u0010\rJ\r\u0010*\u001a\u00020\u0019¢\u0006\u0004\b*\u0010+J\u001d\u0010)\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b)\u0010\u0011J\r\u0010,\u001a\u00020\u0019¢\u0006\u0004\b,\u0010+J\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0016¢\u0006\u0004\b-\u0010.J%\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b/\u00100R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00101\u001a\u0004\b2\u0010\u0016R,\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(038\u0004X\u0084\u0004¢\u0006\f\n\u0004\b&\u00104\u001a\u0004\b5\u00106¨\u00067"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/ValuesMapBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "caseInsensitiveName", "", "size", "<init>", "(ZI)V", "", "name", "", "getAll", "(Ljava/lang/String;)Ljava/util/List;", "contains", "(Ljava/lang/String;)Z", "value", "(Ljava/lang/String;Ljava/lang/Object;)Z", "", "names", "()Ljava/util/Set;", "isEmpty", "()Z", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "", "set", "(Ljava/lang/String;Ljava/lang/Object;)V", "setMissing", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "append", "Laws/smithy/kotlin/runtime/collections/ValuesMap;", "valuesMap", "appendAll", "(Laws/smithy/kotlin/runtime/collections/ValuesMap;)V", "appendMissing", "", "values", "(Ljava/lang/String;Ljava/lang/Iterable;)V", "", "remove", "removeKeysWithNoEntries", "()V", "clear", "build", "()Laws/smithy/kotlin/runtime/collections/ValuesMap;", "ensureListForKey", "(Ljava/lang/String;I)Ljava/util/List;", "Z", "getCaseInsensitiveName", "", "Ljava/util/Map;", "getValues", "()Ljava/util/Map;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ValuesMapBuilder<T> {
    private final boolean caseInsensitiveName;
    private final Map<String, List<T>> values;

    /* JADX WARN: Multi-variable type inference failed */
    public ValuesMapBuilder() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    public ValuesMapBuilder(boolean z, int i) {
        this.caseInsensitiveName = z;
        this.values = z ? new CaseInsensitiveMap<>() : new LinkedHashMap<>(i);
    }

    public /* synthetic */ ValuesMapBuilder(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 8 : i);
    }

    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    protected final Map<String, List<T>> getValues() {
        return this.values;
    }

    public final List<T> getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.get(name);
    }

    public final boolean contains(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.containsKey(name);
    }

    public final boolean contains(String name, T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<T> list = this.values.get(name);
        if (list != null) {
            return list.contains(value);
        }
        return false;
    }

    public final Set<String> names() {
        return this.values.keySet();
    }

    public final boolean isEmpty() {
        return this.values.isEmpty();
    }

    public final Set<Map.Entry<String, List<T>>> entries() {
        return this.values.entrySet();
    }

    public final void set(String name, T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<T> listEnsureListForKey = ensureListForKey(name, 1);
        listEnsureListForKey.clear();
        listEnsureListForKey.add(value);
    }

    public final void setMissing(String name, T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.values.containsKey(name)) {
            return;
        }
        set(name, value);
    }

    public final T get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<T> all = getAll(name);
        if (all != null) {
            return (T) CollectionsKt.firstOrNull((List) all);
        }
        return null;
    }

    public final void append(String name, T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        ensureListForKey(name, 1).add(value);
    }

    public final void appendAll(ValuesMap<T> valuesMap) {
        Intrinsics.checkNotNullParameter(valuesMap, "valuesMap");
        valuesMap.forEach(new Function2() { // from class: aws.smithy.kotlin.runtime.collections.ValuesMapBuilder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ValuesMapBuilder.appendAll$lambda$0(this.f$0, (String) obj, (List) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendAll$lambda$0(ValuesMapBuilder valuesMapBuilder, String name, List values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        valuesMapBuilder.appendAll(name, values);
        return Unit.INSTANCE;
    }

    public final void appendMissing(ValuesMap<T> valuesMap) {
        Intrinsics.checkNotNullParameter(valuesMap, "valuesMap");
        valuesMap.forEach(new Function2() { // from class: aws.smithy.kotlin.runtime.collections.ValuesMapBuilder$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ValuesMapBuilder.appendMissing$lambda$0(this.f$0, (String) obj, (List) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit appendMissing$lambda$0(ValuesMapBuilder valuesMapBuilder, String name, List values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        valuesMapBuilder.appendMissing(name, values);
        return Unit.INSTANCE;
    }

    public final void appendAll(String name, Iterable<? extends T> values) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        Collection collection = values instanceof Collection ? (Collection) values : null;
        List<T> listEnsureListForKey = ensureListForKey(name, collection != null ? collection.size() : 2);
        Iterator<? extends T> it = values.iterator();
        while (it.hasNext()) {
            listEnsureListForKey.add(it.next());
        }
    }

    public final void appendMissing(String name, Iterable<? extends T> values) {
        Set setEmptySet;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        List<T> list = this.values.get(name);
        if (list == null || (setEmptySet = CollectionsKt.toSet(list)) == null) {
            setEmptySet = SetsKt.emptySet();
        }
        ArrayList arrayList = new ArrayList();
        for (T t : values) {
            if (!setEmptySet.contains(t)) {
                arrayList.add(t);
            }
        }
        appendAll(name, arrayList);
    }

    public final List<T> remove(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.values.remove(name);
    }

    public final void removeKeysWithNoEntries() {
        Map<String, List<T>> map = this.values;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, List<T>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            remove((String) ((Map.Entry) it.next()).getKey());
        }
    }

    public final boolean remove(String name, T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<T> list = this.values.get(name);
        if (list != null) {
            return list.remove(value);
        }
        return false;
    }

    public final void clear() {
        this.values.clear();
    }

    public ValuesMap<T> build() {
        return new ValuesMapImpl(this.caseInsensitiveName, this.values);
    }

    private final List<T> ensureListForKey(String name, int size) {
        List<T> list = this.values.get(name);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(size);
        this.values.put(name, arrayList);
        return arrayList;
    }
}
