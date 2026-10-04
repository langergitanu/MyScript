package aws.smithy.kotlin.runtime.collections.views;

import aws.smithy.kotlin.runtime.collections.MultiMap;
import aws.smithy.kotlin.runtime.collections.MutableMultiMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Converters.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000®\u0001\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010*\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001aE\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\n\u001aE\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\r\u001aY\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0010\u001aE\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0013\u001a\u009f\u0001\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u001d\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0016\"\u0004\b\u0003\u0010\u0017*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u001e\u001a\u009f\u0001\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030 \"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0016\"\u0004\b\u0003\u0010\u0017*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u001f2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010!\u001aY\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\"2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0000¢\u0006\u0004\b\u0006\u0010$\u001aE\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000%2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010'\u001aE\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010)\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000(2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\u0006\u0010*\u001aY\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000+2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0000¢\u0006\u0004\b\u0006\u0010-\u001aY\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010/\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000.2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0000¢\u0006\u0004\b\u0006\u00100\u001a\u009f\u0001\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u000302\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0016\"\u0004\b\u0003\u0010\u0017*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002012\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u00103\u001a\u009f\u0001\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u000305\"\u0004\b\u0000\u0010\u0014\"\u0004\b\u0001\u0010\u0015\"\u0004\b\u0002\u0010\u0016\"\u0004\b\u0003\u0010\u0017*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0002042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u00106\u001aY\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000108\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u0000072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0000¢\u0006\u0004\b\u0006\u00109\u001aY\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010;\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000:2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0000¢\u0006\u0004\b\u0006\u0010<¨\u0006="}, m1599d2 = {"Src", "Dest", "", "Lkotlin/Function1;", "src2Dest", "dest2Src", "asView", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "", "Laws/smithy/kotlin/runtime/collections/views/IterableView;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/IterableView;", "", "Laws/smithy/kotlin/runtime/collections/views/IteratorView;", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/IteratorView;", "", "Laws/smithy/kotlin/runtime/collections/views/ListView;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/ListView;", "", "Laws/smithy/kotlin/runtime/collections/views/ListIteratorView;", "(Ljava/util/ListIterator;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/ListIteratorView;", "KSrc", "KDest", "VSrc", "VDest", "", "kSrc2Dest", "kDest2Src", "vSrc2Dest", "vDest2Src", "Laws/smithy/kotlin/runtime/collections/views/MapView;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MapView;", "Laws/smithy/kotlin/runtime/collections/MultiMap;", "Laws/smithy/kotlin/runtime/collections/views/MultiMapView;", "(Laws/smithy/kotlin/runtime/collections/MultiMap;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MultiMapView;", "", "Laws/smithy/kotlin/runtime/collections/views/MutableCollectionView;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MutableCollectionView;", "", "Laws/smithy/kotlin/runtime/collections/views/MutableIterableView;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MutableIterableView;", "", "Laws/smithy/kotlin/runtime/collections/views/MutableIteratorView;", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MutableIteratorView;", "", "Laws/smithy/kotlin/runtime/collections/views/MutableListView;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MutableListView;", "", "Laws/smithy/kotlin/runtime/collections/views/MutableListIteratorView;", "(Ljava/util/ListIterator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MutableListIteratorView;", "", "Laws/smithy/kotlin/runtime/collections/views/MutableMapView;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MutableMapView;", "Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "Laws/smithy/kotlin/runtime/collections/views/MutableMultiMapView;", "(Laws/smithy/kotlin/runtime/collections/MutableMultiMap;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MutableMultiMapView;", "", "Laws/smithy/kotlin/runtime/collections/views/MutableSetView;", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/MutableSetView;", "", "Laws/smithy/kotlin/runtime/collections/views/SetView;", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Laws/smithy/kotlin/runtime/collections/views/SetView;", "runtime-core"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ConvertersKt {
    /* JADX INFO: renamed from: asView, reason: collision with other method in class */
    public static final <Src, Dest> Collection<Dest> m12157asView(Collection<? extends Src> collection, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        return new CollectionView(collection, src2Dest, dest2Src);
    }

    public static final <Src, Dest> IterableView<Src, Dest> asView(Iterable<? extends Src> iterable, Function1<? super Src, ? extends Dest> src2Dest) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        return new IterableView<>(iterable, src2Dest);
    }

    public static final <Src, Dest> IteratorView<Src, Dest> asView(Iterator<? extends Src> it, Function1<? super Src, ? extends Dest> src2Dest) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        return new IteratorView<>(it, src2Dest);
    }

    public static final <Src, Dest> ListView<Src, Dest> asView(List<? extends Src> list, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        return new ListView<>(list, src2Dest, dest2Src);
    }

    public static final <Src, Dest> ListIteratorView<Src, Dest> asView(ListIterator<? extends Src> listIterator, Function1<? super Src, ? extends Dest> src2Dest) {
        Intrinsics.checkNotNullParameter(listIterator, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        return new ListIteratorView<>(listIterator, src2Dest);
    }

    public static final <KSrc, KDest, VSrc, VDest> MapView<KSrc, KDest, VSrc, VDest> asView(Map<KSrc, ? extends VSrc> map, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super KDest, ? extends KSrc> kDest2Src, Function1<? super VSrc, ? extends VDest> vSrc2Dest, Function1<? super VDest, ? extends VSrc> vDest2Src) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(kSrc2Dest, "kSrc2Dest");
        Intrinsics.checkNotNullParameter(kDest2Src, "kDest2Src");
        Intrinsics.checkNotNullParameter(vSrc2Dest, "vSrc2Dest");
        Intrinsics.checkNotNullParameter(vDest2Src, "vDest2Src");
        return new MapView<>(map, kSrc2Dest, kDest2Src, vSrc2Dest, vDest2Src);
    }

    public static final <KSrc, KDest, VSrc, VDest> MultiMapView<KSrc, KDest, VSrc, VDest> asView(MultiMap<KSrc, VSrc> multiMap, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super KDest, ? extends KSrc> kDest2Src, Function1<? super VSrc, ? extends VDest> vSrc2Dest, Function1<? super VDest, ? extends VSrc> vDest2Src) {
        Intrinsics.checkNotNullParameter(multiMap, "<this>");
        Intrinsics.checkNotNullParameter(kSrc2Dest, "kSrc2Dest");
        Intrinsics.checkNotNullParameter(kDest2Src, "kDest2Src");
        Intrinsics.checkNotNullParameter(vSrc2Dest, "vSrc2Dest");
        Intrinsics.checkNotNullParameter(vDest2Src, "vDest2Src");
        return new MultiMapView<>(multiMap, kSrc2Dest, kDest2Src, vSrc2Dest, vDest2Src);
    }

    public static final <Src, Dest> MutableCollectionView<Src, Dest> asView(Collection<Src> collection, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        return new MutableCollectionView<>(collection, src2Dest, dest2Src);
    }

    /* JADX INFO: renamed from: asView, reason: collision with other method in class */
    public static final <Src, Dest> MutableIterableView<Src, Dest> m12152asView(Iterable<? extends Src> iterable, Function1<? super Src, ? extends Dest> src2Dest) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        return new MutableIterableView<>(iterable, src2Dest);
    }

    /* JADX INFO: renamed from: asView, reason: collision with other method in class */
    public static final <Src, Dest> MutableIteratorView<Src, Dest> m12153asView(Iterator<? extends Src> it, Function1<? super Src, ? extends Dest> src2Dest) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        return new MutableIteratorView<>(it, src2Dest);
    }

    /* JADX INFO: renamed from: asView, reason: collision with other method in class */
    public static final <Src, Dest> MutableListView<Src, Dest> m12154asView(List<Src> list, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        return new MutableListView<>(list, src2Dest, dest2Src);
    }

    public static final <Src, Dest> MutableListIteratorView<Src, Dest> asView(ListIterator<Src> listIterator, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        Intrinsics.checkNotNullParameter(listIterator, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        return new MutableListIteratorView<>(listIterator, src2Dest, dest2Src);
    }

    /* JADX INFO: renamed from: asView, reason: collision with other method in class */
    public static final <KSrc, KDest, VSrc, VDest> MutableMapView<KSrc, KDest, VSrc, VDest> m12155asView(Map<KSrc, VSrc> map, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super KDest, ? extends KSrc> kDest2Src, Function1<? super VSrc, ? extends VDest> vSrc2Dest, Function1<? super VDest, ? extends VSrc> vDest2Src) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(kSrc2Dest, "kSrc2Dest");
        Intrinsics.checkNotNullParameter(kDest2Src, "kDest2Src");
        Intrinsics.checkNotNullParameter(vSrc2Dest, "vSrc2Dest");
        Intrinsics.checkNotNullParameter(vDest2Src, "vDest2Src");
        return new MutableMapView<>(map, kSrc2Dest, kDest2Src, vSrc2Dest, vDest2Src);
    }

    public static final <KSrc, KDest, VSrc, VDest> MutableMultiMapView<KSrc, KDest, VSrc, VDest> asView(MutableMultiMap<KSrc, VSrc> mutableMultiMap, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super KDest, ? extends KSrc> kDest2Src, Function1<? super VSrc, ? extends VDest> vSrc2Dest, Function1<? super VDest, ? extends VSrc> vDest2Src) {
        Intrinsics.checkNotNullParameter(mutableMultiMap, "<this>");
        Intrinsics.checkNotNullParameter(kSrc2Dest, "kSrc2Dest");
        Intrinsics.checkNotNullParameter(kDest2Src, "kDest2Src");
        Intrinsics.checkNotNullParameter(vSrc2Dest, "vSrc2Dest");
        Intrinsics.checkNotNullParameter(vDest2Src, "vDest2Src");
        return new MutableMultiMapView<>(mutableMultiMap, kSrc2Dest, kDest2Src, vSrc2Dest, vDest2Src);
    }

    public static final <Src, Dest> MutableSetView<Src, Dest> asView(Set<Src> set, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        return new MutableSetView<>(set, src2Dest, dest2Src);
    }

    /* JADX INFO: renamed from: asView, reason: collision with other method in class */
    public static final <Src, Dest> SetView<Src, Dest> m12156asView(Set<? extends Src> set, Function1<? super Src, ? extends Dest> src2Dest, Function1<? super Dest, ? extends Src> dest2Src) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(src2Dest, "src2Dest");
        Intrinsics.checkNotNullParameter(dest2Src, "dest2Src");
        return new SetView<>(set, src2Dest, dest2Src);
    }
}
