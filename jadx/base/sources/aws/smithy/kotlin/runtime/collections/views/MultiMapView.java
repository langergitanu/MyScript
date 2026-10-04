package aws.smithy.kotlin.runtime.collections.views;

import aws.smithy.kotlin.runtime.collections.Entry;
import aws.smithy.kotlin.runtime.collections.MultiMap;
import aws.smithy.kotlin.runtime.collections.MutableMultiMap;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: MultiMapView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010&\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u0005Bk\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\f\u0010\rJM\u0010\u0011\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f0\u00102\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012JM\u0010\u0014\u001a&\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f0\u00102\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f0\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0019\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00030\u000fH\u0096\u0080\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00028\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u00020\u0016H\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u001fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010!R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!R,\u0010\"\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R,\u0010#\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R-\u0010'\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f0\u000e0$8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b%\u0010&R,\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u000e0(8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00010$8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b-\u0010&R\u0015\u00102\u001a\u00020/8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b0\u00101R!\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00067"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/MultiMapView;", "KSrc", "KDest", "VSrc", "VDest", "Laws/smithy/kotlin/runtime/collections/MultiMap;", "src", "Lkotlin/Function1;", "kSrc2Dest", "kDest2Src", "vSrc2Dest", "vDest2Src", "<init>", "(Laws/smithy/kotlin/runtime/collections/MultiMap;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "", "Laws/smithy/kotlin/runtime/collections/views/EntryView;", "fwdEntryView", "(Ljava/util/Map$Entry;)Laws/smithy/kotlin/runtime/collections/views/EntryView;", "dest", "revEntryView", SubscriberAttributeKt.JSON_NAME_KEY, "", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "(Ljava/util/List;)Z", "get", "(Ljava/lang/Object;)Ljava/util/List;", "isEmpty", "()Z", "Laws/smithy/kotlin/runtime/collections/MultiMap;", "Lkotlin/jvm/functions/Function1;", "vListSrc2Dest", "vListDest2Src", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Lkotlin/sequences/Sequence;", "entryValues", "Lkotlin/sequences/Sequence;", "getEntryValues", "()Lkotlin/sequences/Sequence;", "getKeys", UserMetadata.KEYDATA_FILENAME, "", "getSize", "()I", "size", "", "getValues", "()Ljava/util/Collection;", "values", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MultiMapView<KSrc, KDest, VSrc, VDest> implements MultiMap<KDest, VDest> {
    private final Sequence<Map.Entry<KDest, VDest>> entryValues;
    private final Function1<KDest, KSrc> kDest2Src;
    private final Function1<KSrc, KDest> kSrc2Dest;
    private final MultiMap<KSrc, VSrc> src;
    private final Function1<VDest, VSrc> vDest2Src;
    private final Function1<List<? extends VDest>, List<VSrc>> vListDest2Src;
    private final Function1<List<? extends VSrc>, List<VDest>> vListSrc2Dest;
    private final Function1<VSrc, VDest> vSrc2Dest;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public List<VDest> compute(KDest kdest, BiFunction<? super KDest, ? super List<? extends VDest>, ? extends List<? extends VDest>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public List<VDest> computeIfAbsent(KDest kdest, Function<? super KDest, ? extends List<? extends VDest>> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public List<VDest> computeIfPresent(KDest kdest, BiFunction<? super KDest, ? super List<? extends VDest>, ? extends List<? extends VDest>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<VDest> merge(KDest kdest, List<? extends VDest> list, BiFunction<? super List<? extends VDest>, ? super List<? extends VDest>, ? extends List<? extends VDest>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<VDest> put(KDest kdest, List<? extends VDest> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends KDest, ? extends List<? extends VDest>> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<VDest> putIfAbsent(KDest kdest, List<? extends VDest> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public List<VDest> remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public List<VDest> replace(KDest kdest, List<? extends VDest> list) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean replace(KDest kdest, List<? extends VDest> list, List<? extends VDest> list2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super KDest, ? super List<? extends VDest>, ? extends List<? extends VDest>> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MultiMapView(MultiMap<KSrc, VSrc> src, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super KDest, ? extends KSrc> kDest2Src, Function1<? super VSrc, ? extends VDest> vSrc2Dest, Function1<? super VDest, ? extends VSrc> vDest2Src) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(kSrc2Dest, "kSrc2Dest");
        Intrinsics.checkNotNullParameter(kDest2Src, "kDest2Src");
        Intrinsics.checkNotNullParameter(vSrc2Dest, "vSrc2Dest");
        Intrinsics.checkNotNullParameter(vDest2Src, "vDest2Src");
        this.src = src;
        this.kSrc2Dest = kSrc2Dest;
        this.kDest2Src = kDest2Src;
        this.vSrc2Dest = vSrc2Dest;
        this.vDest2Src = vDest2Src;
        this.vListSrc2Dest = new Function1() { // from class: aws.smithy.kotlin.runtime.collections.views.MultiMapView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultiMapView.vListSrc2Dest$lambda$0(this.f$0, (List) obj);
            }
        };
        this.vListDest2Src = new Function1() { // from class: aws.smithy.kotlin.runtime.collections.views.MultiMapView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultiMapView.vListDest2Src$lambda$0(this.f$0, (List) obj);
            }
        };
        this.entryValues = SequencesKt.map(src.getEntryValues(), new Function1() { // from class: aws.smithy.kotlin.runtime.collections.views.MultiMapView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MultiMapView.entryValues$lambda$0(this.f$0, (Map.Entry) obj);
            }
        });
    }

    @Override // aws.smithy.kotlin.runtime.collections.MultiMap
    public /* bridge */ boolean contains(KDest kdest, VDest vdest) {
        return super.contains(kdest, vdest);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof List) {
            return containsValue((List) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<KDest, List<VDest>>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<KDest> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // aws.smithy.kotlin.runtime.collections.MultiMap
    public /* bridge */ MutableMultiMap<KDest, VDest> toMutableMultiMap() {
        return super.toMutableMultiMap();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<List<VDest>> values() {
        return getValues();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List vListSrc2Dest$lambda$0(MultiMapView multiMapView, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ConvertersKt.asView(it, (Function1) multiMapView.vSrc2Dest, (Function1) multiMapView.vDest2Src);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List vListDest2Src$lambda$0(MultiMapView multiMapView, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ConvertersKt.asView(it, (Function1) multiMapView.vDest2Src, (Function1) multiMapView.vSrc2Dest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EntryView<KSrc, KDest, List<VSrc>, List<VDest>> fwdEntryView(Map.Entry<? extends KSrc, ? extends List<? extends VSrc>> src) {
        return new EntryView<>(src, this.kSrc2Dest, this.vListSrc2Dest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EntryView<KDest, KSrc, List<VDest>, List<VSrc>> revEntryView(Map.Entry<? extends KDest, ? extends List<? extends VDest>> dest) {
        return new EntryView<>(dest, this.kDest2Src, this.vListDest2Src);
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.src.containsKey(this.kDest2Src.invoke(key));
    }

    public boolean containsValue(List<? extends VDest> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.src.containsValue(this.vListDest2Src.invoke(value));
    }

    public Set<Map.Entry<KDest, List<VDest>>> getEntries() {
        return ConvertersKt.m12156asView((Set) this.src.entrySet(), (Function1) new MultiMapView$entries$1(this), (Function1) new MultiMapView$entries$2(this));
    }

    @Override // java.util.Map
    public List<VDest> get(Object key) {
        List<? extends VSrc> list = (List) this.src.get(this.kDest2Src.invoke(key));
        if (list != null) {
            return this.vListSrc2Dest.invoke(list);
        }
        return null;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.src.isEmpty();
    }

    @Override // aws.smithy.kotlin.runtime.collections.MultiMap
    public Sequence<Map.Entry<KDest, VDest>> getEntryValues() {
        return this.entryValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Entry entryValues$lambda$0(MultiMapView multiMapView, Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        return new Entry(multiMapView.kSrc2Dest.invoke((KSrc) entry.getKey()), multiMapView.vSrc2Dest.invoke((VSrc) entry.getValue()));
    }

    public Set<KDest> getKeys() {
        return ConvertersKt.m12156asView((Set) this.src.keySet(), (Function1) this.kSrc2Dest, (Function1) this.kDest2Src);
    }

    public int getSize() {
        return this.src.size();
    }

    public Collection<List<VDest>> getValues() {
        return ConvertersKt.m12157asView((Collection) this.src.values(), (Function1) this.vListSrc2Dest, (Function1) this.vListDest2Src);
    }
}
