package aws.smithy.kotlin.runtime.collections.views;

import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: ListIteratorView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u00020\rH\u0096\u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0010\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u00020\rH\u0096\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/ListIteratorView;", "Src", "Dest", "Laws/smithy/kotlin/runtime/collections/views/IteratorView;", "", "src", "Lkotlin/Function1;", "src2Dest", "<init>", "(Ljava/util/ListIterator;Lkotlin/jvm/functions/Function1;)V", "", "hasPrevious", "()Z", "", "nextIndex", "()I", "previous", "()Ljava/lang/Object;", "previousIndex", "Ljava/util/ListIterator;", "Lkotlin/jvm/functions/Function1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ListIteratorView<Src, Dest> extends IteratorView<Src, Dest> implements ListIterator<Dest>, KMappedMarker {
    private final ListIterator<Src> src;
    private final Function1<Src, Dest> src2Dest;

    @Override // java.util.ListIterator
    public void add(Dest dest) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(Dest dest) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ListIteratorView(ListIterator<? extends Src> src, Function1<? super Src, ? extends Dest> src2Dest) {
        super(src, src2Dest);
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        this.src = src;
        this.src2Dest = src2Dest;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.src.hasPrevious();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.src.nextIndex();
    }

    @Override // java.util.ListIterator
    public Dest previous() {
        return (Dest) this.src2Dest.invoke(this.src.previous());
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.src.previousIndex();
    }
}
