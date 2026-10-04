package aws.smithy.kotlin.runtime.collections.views;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: MapView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010&\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u0005Bk\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u0019\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00028\u0003H\u0096\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u0017J\u001b\u0010\u001a\u001a\u0004\u0018\u00018\u00032\u0006\u0010\u0014\u001a\u00028\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u0015H\u0096\u0080\u0004¢\u0006\u0004\b\u001c\u0010\u001dR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001fR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001fR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001fR \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR'\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u000e0 8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001b\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010 8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0015\u0010)\u001a\u00020&8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001b\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00030*8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/MapView;", "KSrc", "KDest", "VSrc", "VDest", "", "src", "Lkotlin/Function1;", "kSrc2Dest", "kDest2Src", "vSrc2Dest", "vDest2Src", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "Laws/smithy/kotlin/runtime/collections/views/EntryView;", "fwdEntryView", "(Ljava/util/Map$Entry;)Laws/smithy/kotlin/runtime/collections/views/EntryView;", "dest", "revEntryView", SubscriberAttributeKt.JSON_NAME_KEY, "", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "()Z", "Ljava/util/Map;", "Lkotlin/jvm/functions/Function1;", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, "", "getSize", "()I", "size", "", "getValues", "()Ljava/util/Collection;", "values", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class MapView<KSrc, KDest, VSrc, VDest> implements Map<KDest, VDest>, KMappedMarker {
    private final Function1<KDest, KSrc> kDest2Src;
    private final Function1<KSrc, KDest> kSrc2Dest;
    private final Map<KSrc, VSrc> src;
    private final Function1<VDest, VSrc> vDest2Src;
    private final Function1<VSrc, VDest> vSrc2Dest;

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public VDest compute(KDest kdest, BiFunction<? super KDest, ? super VDest, ? extends VDest> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public VDest computeIfAbsent(KDest kdest, Function<? super KDest, ? extends VDest> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public VDest computeIfPresent(KDest kdest, BiFunction<? super KDest, ? super VDest, ? extends VDest> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public VDest merge(KDest kdest, VDest vdest, BiFunction<? super VDest, ? super VDest, ? extends VDest> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public VDest put(KDest kdest, VDest vdest) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends KDest, ? extends VDest> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public VDest putIfAbsent(KDest kdest, VDest vdest) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public VDest remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public VDest replace(KDest kdest, VDest vdest) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean replace(KDest kdest, VDest vdest, VDest vdest2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super KDest, ? super VDest, ? extends VDest> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MapView(Map<KSrc, ? extends VSrc> src, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super KDest, ? extends KSrc> kDest2Src, Function1<? super VSrc, ? extends VDest> vSrc2Dest, Function1<? super VDest, ? extends VSrc> vDest2Src) {
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
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<KDest, VDest>> entrySet() {
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

    @Override // java.util.Map
    public final /* bridge */ Collection<VDest> values() {
        return getValues();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EntryView<KSrc, KDest, VSrc, VDest> fwdEntryView(Map.Entry<? extends KSrc, ? extends VSrc> src) {
        return new EntryView<>(src, this.kSrc2Dest, this.vSrc2Dest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EntryView<KDest, KSrc, VDest, VSrc> revEntryView(Map.Entry<? extends KDest, ? extends VDest> dest) {
        return new EntryView<>(dest, this.kDest2Src, this.vDest2Src);
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.src.containsKey(this.kDest2Src.invoke(key));
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.src.containsValue(this.vDest2Src.invoke(value));
    }

    public Set<Map.Entry<KDest, VDest>> getEntries() {
        return ConvertersKt.m12156asView((Set) this.src.entrySet(), (Function1) new MapView$entries$1(this), (Function1) new MapView$entries$2(this));
    }

    @Override // java.util.Map
    public VDest get(Object key) {
        VSrc vsrc = this.src.get(this.kDest2Src.invoke(key));
        if (vsrc != null) {
            return this.vSrc2Dest.invoke(vsrc);
        }
        return null;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.src.isEmpty();
    }

    public Set<KDest> getKeys() {
        return ConvertersKt.m12156asView((Set) this.src.keySet(), (Function1) this.kSrc2Dest, (Function1) this.kDest2Src);
    }

    public int getSize() {
        return this.src.size();
    }

    public Collection<VDest> getValues() {
        return ConvertersKt.m12157asView((Collection) this.src.values(), (Function1) this.vSrc2Dest, (Function1) this.vDest2Src);
    }
}
