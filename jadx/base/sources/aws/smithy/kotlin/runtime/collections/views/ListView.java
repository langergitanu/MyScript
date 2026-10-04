package aws.smithy.kotlin.runtime.collections.views;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: ListView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010*\n\u0002\b\n\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B=\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0082\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0016J'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0096\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001c¨\u0006\u001d"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/ListView;", "Src", "Dest", "Laws/smithy/kotlin/runtime/collections/views/CollectionView;", "", "src", "Lkotlin/Function1;", "src2Dest", "dest2Src", "<init>", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", FirebaseAnalytics.Param.INDEX, "get", "(I)Ljava/lang/Object;", "element", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", "Ljava/util/List;", "Lkotlin/jvm/functions/Function1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ListView<Src, Dest> extends CollectionView<Src, Dest> implements List<Dest>, KMappedMarker {
    private final Function1<Dest, Src> dest2Src;
    private final List<Src> src;
    private final Function1<Src, Dest> src2Dest;

    @Override // java.util.List
    public void add(int i, Dest dest) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends Dest> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Dest remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<Dest> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Dest set(int i, Dest dest) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void sort(Comparator<? super Dest> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ListView(List<? extends Src> src, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        super(src, src2Dest, dest2Src);
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        this.src = src;
        this.src2Dest = src2Dest;
        this.dest2Src = dest2Src;
    }

    @Override // java.util.List
    public Dest get(int index) {
        return (Dest) this.src2Dest.invoke(this.src.get(index));
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return this.src.indexOf(this.dest2Src.invoke(element));
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return this.src.lastIndexOf(this.dest2Src.invoke(element));
    }

    @Override // java.util.List
    public ListIterator<Dest> listIterator() {
        return ConvertersKt.asView((ListIterator) this.src.listIterator(), (Function1) this.src2Dest);
    }

    @Override // java.util.List
    public ListIterator<Dest> listIterator(int index) {
        return ConvertersKt.asView((ListIterator) this.src.listIterator(index), (Function1) this.src2Dest);
    }

    @Override // java.util.List
    public List<Dest> subList(int fromIndex, int toIndex) {
        return ConvertersKt.asView((List) this.src.subList(fromIndex, toIndex), (Function1) this.src2Dest, (Function1) this.dest2Src);
    }
}
