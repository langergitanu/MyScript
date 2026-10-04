package aws.smithy.kotlin.runtime.collections.views;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

/* JADX INFO: compiled from: MutableListView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0013\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B=\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0001H\u0096\u0080\b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\r\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u0012J'\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0080\b¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0015\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0080\b¢\u0006\u0004\b\u0015\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0011H\u0096\u0080\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u001aH\u0096\u0082\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010 J\u0019\u0010!\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0080\b¢\u0006\u0004\b!\u0010\"J'\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000fH\u0096\u0080\u0004¢\u0006\u0004\b%\u0010&J!\u0010'\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00028\u0001H\u0096\u0082\b¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0080\b¢\u0006\u0004\b)\u0010\u0017J\u001f\u0010*\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0080\b¢\u0006\u0004\b*\u0010\u0017J\u0019\u0010+\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0001H\u0096\u0080\b¢\u0006\u0004\b+\u0010\u000eR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010.R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010/R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010/¨\u00060"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/MutableListView;", "Src", "Dest", "Laws/smithy/kotlin/runtime/collections/views/ListView;", "", "src", "Lkotlin/Function1;", "src2Dest", "dest2Src", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "element", "", "add", "(Ljava/lang/Object;)Z", "", FirebaseAnalytics.Param.INDEX, "", "(ILjava/lang/Object;)V", "", "elements", "addAll", "(ILjava/util/Collection;)Z", "(Ljava/util/Collection;)Z", "clear", "()V", "", "iterator", "()Ljava/util/Iterator;", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "removeAt", "(I)Ljava/lang/Object;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "retainAll", "removeAll", "remove", "Ljava/util/List;", "getSrc$runtime_core", "()Ljava/util/List;", "Lkotlin/jvm/functions/Function1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class MutableListView<Src, Dest> extends ListView<Src, Dest> implements List<Dest>, KMutableList {
    private final Function1<Dest, Src> dest2Src;
    private final List<Src> src;
    private final Function1<Src, Dest> src2Dest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutableListView(List<Src> src, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        super(src, src2Dest, dest2Src);
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        this.src = src;
        this.src2Dest = src2Dest;
        this.dest2Src = dest2Src;
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.ListView, java.util.List
    public final /* bridge */ Dest remove(int i) {
        return removeAt(i);
    }

    public final List<Src> getSrc$runtime_core() {
        return this.src;
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.CollectionView, java.util.Collection
    public boolean add(Dest element) {
        return this.src.add(this.dest2Src.invoke(element));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.ListView, java.util.List
    public void add(int index, Dest element) {
        this.src.add(index, this.dest2Src.invoke(element));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.ListView, java.util.List
    public boolean addAll(int index, Collection<? extends Dest> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.src.addAll(index, ConvertersKt.m12157asView((Collection) elements, (Function1) this.dest2Src, (Function1) this.src2Dest));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.CollectionView, java.util.Collection
    public boolean addAll(Collection<? extends Dest> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.src.addAll(ConvertersKt.m12157asView((Collection) elements, (Function1) this.dest2Src, (Function1) this.src2Dest));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.CollectionView, java.util.Collection
    public void clear() {
        this.src.clear();
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.IterableView, java.lang.Iterable
    public Iterator<Dest> iterator() {
        return ConvertersKt.m12153asView((Iterator) this.src.iterator(), (Function1) this.src2Dest);
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.ListView, java.util.List
    public ListIterator<Dest> listIterator() {
        return ConvertersKt.asView(this.src.listIterator(), this.src2Dest, this.dest2Src);
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.ListView, java.util.List
    public ListIterator<Dest> listIterator(int index) {
        return ConvertersKt.asView(this.src.listIterator(index), this.src2Dest, this.dest2Src);
    }

    public Dest removeAt(int index) {
        return (Dest) this.src2Dest.invoke(this.src.remove(index));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.ListView, java.util.List
    public List<Dest> subList(int fromIndex, int toIndex) {
        return ConvertersKt.m12154asView((List) this.src.subList(fromIndex, toIndex), (Function1) this.src2Dest, (Function1) this.dest2Src);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // aws.smithy.kotlin.runtime.collections.views.ListView, java.util.List
    public Dest set(int index, Dest element) {
        return this.src2Dest.invoke(this.src.set(index, this.dest2Src.invoke(element)));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.CollectionView, java.util.Collection
    public boolean retainAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.src.retainAll(ConvertersKt.m12157asView((Collection) elements, (Function1) this.dest2Src, (Function1) this.src2Dest));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.CollectionView, java.util.Collection
    public boolean removeAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return this.src.removeAll(ConvertersKt.m12157asView((Collection) elements, (Function1) this.dest2Src, (Function1) this.src2Dest));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.CollectionView, java.util.Collection
    public boolean remove(Object element) {
        return this.src.remove(this.dest2Src.invoke(element));
    }
}
