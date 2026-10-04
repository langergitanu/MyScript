package aws.smithy.kotlin.runtime.collections.views;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: IteratorView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\n\u001a\u00020\tH\u0096\u0082\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u00028\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/IteratorView;", "Src", "Dest", "", "src", "Lkotlin/Function1;", "src2Dest", "<init>", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "Ljava/util/Iterator;", "Lkotlin/jvm/functions/Function1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class IteratorView<Src, Dest> implements Iterator<Dest>, KMappedMarker {
    private final Iterator<Src> src;
    private final Function1<Src, Dest> src2Dest;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IteratorView(Iterator<? extends Src> src, Function1<? super Src, ? extends Dest> src2Dest) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        this.src = src;
        this.src2Dest = src2Dest;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.src.hasNext();
    }

    @Override // java.util.Iterator
    public Dest next() {
        return (Dest) this.src2Dest.invoke(this.src.next());
    }
}
