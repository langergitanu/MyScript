package aws.smithy.kotlin.runtime.collections.views;

import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;

/* JADX INFO: compiled from: MutableListIteratorView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B=\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\fH\u0096\u0080\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013¨\u0006\u0014"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/MutableListIteratorView;", "Src", "Dest", "Laws/smithy/kotlin/runtime/collections/views/ListIteratorView;", "", "src", "Lkotlin/Function1;", "src2Dest", "dest2Src", "<init>", "(Ljava/util/ListIterator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "element", "", "add", "(Ljava/lang/Object;)V", "remove", "()V", "set", "Ljava/util/ListIterator;", "Lkotlin/jvm/functions/Function1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class MutableListIteratorView<Src, Dest> extends ListIteratorView<Src, Dest> implements ListIterator<Dest>, KMutableListIterator {
    private final Function1<Dest, Src> dest2Src;
    private final ListIterator<Src> src;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutableListIteratorView(ListIterator<Src> src, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        super(src, src2Dest);
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        this.src = src;
        this.dest2Src = dest2Src;
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.ListIteratorView, java.util.ListIterator
    public void add(Dest element) {
        this.src.add(this.dest2Src.invoke(element));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.IteratorView, java.util.Iterator
    public void remove() {
        this.src.remove();
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.ListIteratorView, java.util.ListIterator
    public void set(Dest element) {
        this.src.set(this.dest2Src.invoke(element));
    }
}
