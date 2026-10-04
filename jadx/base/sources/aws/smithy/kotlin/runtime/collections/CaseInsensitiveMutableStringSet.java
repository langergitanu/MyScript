package aws.smithy.kotlin.runtime.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableSet;

/* JADX INFO: compiled from: CaseInsensitiveMutableStringSet.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0080\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u00020\fH\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u000f\u0010\u000bJ\u001f\u0010\u0012\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096\u0082\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u00020\u0018H\u0096\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\tH\u0096\u0080\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0080\b¢\u0006\u0004\b\u001d\u0010\u000bJ\u0011\u0010\u001e\u001a\u00020\u0002H\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0096\u0080\b¢\u0006\u0004\b \u0010\u0013J\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020!H\u0096\u0082\u0004¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0096\u0080\b¢\u0006\u0004\b$\u0010\u0013J\u001f\u0010%\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0096\u0080\b¢\u0006\u0004\b%\u0010\u0013R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0015\u0010)\u001a\u00020\u00188VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b(\u0010\u001a¨\u0006*"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/CaseInsensitiveMutableStringSet;", "", "", "", "Laws/smithy/kotlin/runtime/collections/CaseInsensitiveString;", "initialValues", "<init>", "(Ljava/lang/Iterable;)V", "element", "", "add", "(Ljava/lang/String;)Z", "", "clear", "()V", "contains", "", "elements", "containsAll", "(Ljava/util/Collection;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "isEmpty", "()Z", "remove", "toString", "()Ljava/lang/String;", "addAll", "", "iterator", "()Ljava/util/Iterator;", "removeAll", "retainAll", "delegate", "Ljava/util/Set;", "getSize", "size", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CaseInsensitiveMutableStringSet implements Set<String>, KMutableSet {
    private final Set<CaseInsensitiveString> delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public CaseInsensitiveMutableStringSet() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    public CaseInsensitiveMutableStringSet(Iterable<CaseInsensitiveString> initialValues) {
        Intrinsics.checkNotNullParameter(initialValues, "initialValues");
        this.delegate = CollectionsKt.toMutableSet(initialValues);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof String) {
            return contains((String) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public /* synthetic */ CaseInsensitiveMutableStringSet(Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? SetsKt.emptySet() : set);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(String element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.delegate.add(CaseInsensitiveStringKt.toInsensitive(element));
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.delegate.clear();
    }

    public boolean contains(String element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.delegate.contains(CaseInsensitiveStringKt.toInsensitive(element));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<?> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object other) {
        return (other instanceof CaseInsensitiveMutableStringSet) && Intrinsics.areEqual(this.delegate, ((CaseInsensitiveMutableStringSet) other).delegate);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    public boolean remove(String element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return this.delegate.remove(CaseInsensitiveStringKt.toInsensitive(element));
    }

    public int getSize() {
        return this.delegate.size();
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends String> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (add((String) it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    /* JADX INFO: renamed from: aws.smithy.kotlin.runtime.collections.CaseInsensitiveMutableStringSet$iterator$1 */
    /* JADX INFO: compiled from: CaseInsensitiveMutableStringSet.kt */
    @Metadata(m1598d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0011\u0010\u0004\u001a\u00020\u0003H\u0096\u0082\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0002H\u0096\u0082\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\t\u001a\u00020\bH\u0096\u0080\u0004¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00018\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"aws/smithy/kotlin/runtime/collections/CaseInsensitiveMutableStringSet$iterator$1", "", "", "", "hasNext", "()Z", "next", "()Ljava/lang/String;", "", "remove", "()V", "Laws/smithy/kotlin/runtime/collections/CaseInsensitiveString;", "delegate", "Ljava/util/Iterator;", "getDelegate", "()Ljava/util/Iterator;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class C36691 implements Iterator<String>, KMutableIterator {
        private final Iterator<CaseInsensitiveString> delegate;

        C36691(CaseInsensitiveMutableStringSet caseInsensitiveMutableStringSet) {
            this.delegate = caseInsensitiveMutableStringSet.delegate.iterator();
        }

        public final Iterator<CaseInsensitiveString> getDelegate() {
            return this.delegate;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.delegate.hasNext();
        }

        @Override // java.util.Iterator
        public String next() {
            return this.delegate.next().getNormalized();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.delegate.remove();
        }
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<String> iterator() {
        return new C36691(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> elements) {
        boolean z;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<?> collection = elements;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(CaseInsensitiveStringKt.toInsensitive((String) it.next()));
        }
        Set set = CollectionsKt.toSet(arrayList);
        Set<CaseInsensitiveString> set2 = this.delegate;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : set2) {
            if (!set.contains((CaseInsensitiveString) obj)) {
                arrayList2.add(obj);
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (true) {
            while (it2.hasNext()) {
                z = this.delegate.remove((CaseInsensitiveString) it2.next()) || z;
            }
            return z;
        }
    }
}
