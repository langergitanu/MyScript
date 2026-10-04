package aws.smithy.kotlin.runtime.collections.views;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterable;

/* JADX INFO: compiled from: MutableIterableView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\b\u0012\u0004\u0012\u00028\u00010\u0004B)\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\nH\u0096\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/MutableIterableView;", "Src", "Dest", "Laws/smithy/kotlin/runtime/collections/views/IterableView;", "", "src", "Lkotlin/Function1;", "src2Dest", "<init>", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)V", "", "iterator", "()Ljava/util/Iterator;", "Ljava/lang/Iterable;", "Lkotlin/jvm/functions/Function1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MutableIterableView<Src, Dest> extends IterableView<Src, Dest> implements Iterable<Dest>, KMutableIterable {
    private final Iterable<Src> src;
    private final Function1<Src, Dest> src2Dest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutableIterableView(Iterable<? extends Src> src, Function1<? super Src, ? extends Dest> src2Dest) {
        super(src, src2Dest);
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        this.src = src;
        this.src2Dest = src2Dest;
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.IterableView, java.lang.Iterable
    public Iterator<Dest> iterator() {
        return ConvertersKt.m12153asView((Iterator) this.src.iterator(), (Function1) this.src2Dest);
    }
}
