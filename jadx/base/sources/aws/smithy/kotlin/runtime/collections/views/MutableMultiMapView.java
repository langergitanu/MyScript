package aws.smithy.kotlin.runtime.collections.views;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import aws.smithy.kotlin.runtime.collections.Entry;
import aws.smithy.kotlin.runtime.collections.MultiMap;
import aws.smithy.kotlin.runtime.collections.MutableMultiMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: MutableMultiMapView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\b\n\u0002\u0010\u001f\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u0005Bk\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00030\u000f2\u0006\u0010\u000e\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011JM\u0010\u0014\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f0\u00132\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f0\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JM\u0010\u0017\u001a&\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f0\u00132\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f0\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001a\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001fJ%\u0010\"\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00028\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00030 H\u0016¢\u0006\u0004\b\"\u0010#J-\u0010\"\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00030 H\u0016¢\u0006\u0004\b\"\u0010$J\u0011\u0010%\u001a\u00020\u001eH\u0096\u0080\u0004¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0080\u0004¢\u0006\u0004\b'\u0010(J\u001f\u0010)\u001a\u00020\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u000fH\u0096\u0080\u0004¢\u0006\u0004\b)\u0010*J!\u0010+\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0082\u0004¢\u0006\u0004\b+\u0010\u0011J\u0011\u0010,\u001a\u00020\u0019H\u0096\u0080\u0004¢\u0006\u0004\b,\u0010-J/\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00028\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00030\u000fH\u0096\u0080\b¢\u0006\u0004\b.\u0010/J-\u00102\u001a\u00020\u001e2\u001a\u00101\u001a\u0016\u0012\u0006\b\u0001\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f00H\u0096\u0080\u0004¢\u0006\u0004\b2\u00103J!\u00104\u001a\n\u0012\u0004\u0012\u00028\u0003\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0080\b¢\u0006\u0004\b4\u0010\u0011J\u001f\u00104\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00028\u0003H\u0017¢\u0006\u0004\b5\u0010\u001bJ!\u00106\u001a\u0004\u0018\u00018\u00032\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b6\u00107J'\u00108\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00028\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00030 H\u0016¢\u0006\u0004\b8\u00109J'\u0010:\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00028\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00030 H\u0016¢\u0006\u0004\b:\u00109R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010;R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010<R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010<R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010<R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010<R,\u0010=\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010<R,\u0010>\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u000f0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010<R-\u0010B\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f0\u00120?8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b@\u0010AR&\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030D0C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u001b\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00010?8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\bH\u0010AR\u0015\u0010L\u001a\u00020\u001c8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\bJ\u0010KR!\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000f0M8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\bN\u0010O¨\u0006P"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/MutableMultiMapView;", "KSrc", "KDest", "VSrc", "VDest", "Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "src", "Lkotlin/Function1;", "kSrc2Dest", "kDest2Src", "vSrc2Dest", "vDest2Src", "<init>", "(Laws/smithy/kotlin/runtime/collections/MutableMultiMap;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", SubscriberAttributeKt.JSON_NAME_KEY, "", "ensureKey", "(Ljava/lang/Object;)Ljava/util/List;", "", "Laws/smithy/kotlin/runtime/collections/views/MutableEntryView;", "fwdEntryView", "(Ljava/util/Map$Entry;)Laws/smithy/kotlin/runtime/collections/views/MutableEntryView;", "dest", "revEntryView", "value", "", "add", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "", FirebaseAnalytics.Param.INDEX, "", "(Ljava/lang/Object;ILjava/lang/Object;)V", "", "values", "addAll", "(Ljava/lang/Object;Ljava/util/Collection;)Z", "(Ljava/lang/Object;ILjava/util/Collection;)Z", "clear", "()V", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "(Ljava/util/List;)Z", "get", "isEmpty", "()Z", "put", "(Ljava/lang/Object;Ljava/util/List;)Ljava/util/List;", "", TypedValues.TransitionType.S_FROM, "putAll", "(Ljava/util/Map;)V", "remove", "removeElement", "removeAt", "(Ljava/lang/Object;I)Ljava/lang/Object;", "removeAll", "(Ljava/lang/Object;Ljava/util/Collection;)Ljava/lang/Boolean;", "retainAll", "Laws/smithy/kotlin/runtime/collections/MutableMultiMap;", "Lkotlin/jvm/functions/Function1;", "vListSrc2Dest", "vListDest2Src", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Lkotlin/sequences/Sequence;", "", "getEntryValues", "()Lkotlin/sequences/Sequence;", "entryValues", "getKeys", UserMetadata.KEYDATA_FILENAME, "getSize", "()I", "size", "", "getValues", "()Ljava/util/Collection;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MutableMultiMapView<KSrc, KDest, VSrc, VDest> implements MutableMultiMap<KDest, VDest> {
    private final Function1<KDest, KSrc> kDest2Src;
    private final Function1<KSrc, KDest> kSrc2Dest;
    private final MutableMultiMap<KSrc, VSrc> src;
    private final Function1<VDest, VSrc> vDest2Src;
    private final Function1<List<VDest>, List<VSrc>> vListDest2Src;
    private final Function1<List<VSrc>, List<VDest>> vListSrc2Dest;
    private final Function1<VSrc, VDest> vSrc2Dest;

    /* JADX WARN: Multi-variable type inference failed */
    public MutableMultiMapView(MutableMultiMap<KSrc, VSrc> src, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super KDest, ? extends KSrc> kDest2Src, Function1<? super VSrc, ? extends VDest> vSrc2Dest, Function1<? super VDest, ? extends VSrc> vDest2Src) {
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
        this.vListSrc2Dest = new Function1() { // from class: aws.smithy.kotlin.runtime.collections.views.MutableMultiMapView$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MutableMultiMapView.vListSrc2Dest$lambda$0(this.f$0, (List) obj);
            }
        };
        this.vListDest2Src = new Function1() { // from class: aws.smithy.kotlin.runtime.collections.views.MutableMultiMapView$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MutableMultiMapView.vListDest2Src$lambda$0(this.f$0, (List) obj);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public /* bridge */ void addAll(Map<KDest, ? extends List<? extends VDest>> map) {
        super.addAll(map);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public /* bridge */ boolean contains(KDest kdest, VDest vdest) {
        return super.contains(kdest, vdest);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (TypeIntrinsics.isMutableList(obj)) {
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

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap, java.util.Map
    public /* bridge */ List<VDest> put(KDest kdest, VDest vdest) {
        return super.put(kdest, vdest);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public /* bridge */ MultiMap<KDest, VDest> toMultiMap() {
        return super.toMultiMap();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<List<VDest>> values() {
        return getValues();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List vListSrc2Dest$lambda$0(MutableMultiMapView mutableMultiMapView, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return ConvertersKt.m12154asView(it, (Function1) mutableMultiMapView.vSrc2Dest, (Function1) mutableMultiMapView.vDest2Src);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List vListDest2Src$lambda$0(MutableMultiMapView mutableMultiMapView, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ArrayList arrayList = new ArrayList();
        Function1<VDest, VSrc> function1 = mutableMultiMapView.vDest2Src;
        Iterator it2 = it.iterator();
        while (it2.hasNext()) {
            arrayList.add(function1.invoke((VDest) it2.next()));
        }
        return arrayList;
    }

    private final List<VDest> ensureKey(KDest key) {
        List<VDest> list = (List) get((Object) key);
        if (list != null) {
            return list;
        }
        this.src.put(this.kDest2Src.invoke(key), new ArrayList());
        return (List) MapsKt.getValue(this, key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableEntryView<KSrc, KDest, List<VSrc>, List<VDest>> fwdEntryView(Map.Entry<KSrc, List<VSrc>> src) {
        return new MutableEntryView<>(src, this.kSrc2Dest, this.vListSrc2Dest, this.vListDest2Src);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableEntryView<KDest, KSrc, List<VDest>, List<VSrc>> revEntryView(Map.Entry<KDest, List<VDest>> dest) {
        return new MutableEntryView<>(dest, this.kDest2Src, this.vListDest2Src, this.vListSrc2Dest);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public boolean add(KDest key, VDest value) {
        return ensureKey(key).add(value);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public void add(KDest key, int index, VDest value) {
        ensureKey(key).add(index, value);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public boolean addAll(KDest key, Collection<? extends VDest> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return ensureKey(key).addAll(values);
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public boolean addAll(KDest key, int index, Collection<? extends VDest> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return ensureKey(key).addAll(index, values);
    }

    @Override // java.util.Map
    public void clear() {
        this.src.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.src.containsKey(this.kDest2Src.invoke(key));
    }

    public boolean containsValue(List<VDest> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.src.containsValue(this.vListDest2Src.invoke(value));
    }

    public Set<Map.Entry<KDest, List<VDest>>> getEntries() {
        return ConvertersKt.asView((Set) this.src.entrySet(), (Function1) new MutableMultiMapView$entries$1(this), (Function1) new MutableMultiMapView$entries$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Entry _get_entryValues_$lambda$0(MutableMultiMapView mutableMultiMapView, Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "<destruct>");
        return new Entry(mutableMultiMapView.kSrc2Dest.invoke((KSrc) entry.getKey()), mutableMultiMapView.vSrc2Dest.invoke((VSrc) entry.getValue()));
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public Sequence<Map.Entry<KDest, VDest>> getEntryValues() {
        return SequencesKt.map(this.src.getEntryValues(), new Function1() { // from class: aws.smithy.kotlin.runtime.collections.views.MutableMultiMapView$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MutableMultiMapView._get_entryValues_$lambda$0(this.f$0, (Map.Entry) obj);
            }
        });
    }

    @Override // java.util.Map
    public List<VDest> get(Object key) {
        List<VSrc> list = (List) this.src.get(this.kDest2Src.invoke(key));
        if (list != null) {
            return this.vListSrc2Dest.invoke(list);
        }
        return null;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.src.isEmpty();
    }

    public Set<KDest> getKeys() {
        return ConvertersKt.asView((Set) this.src.keySet(), (Function1) this.kSrc2Dest, (Function1) this.kDest2Src);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.util.Map
    public List<VDest> put(KDest key, List<VDest> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        List<VSrc> listPut = this.src.put(this.kDest2Src.invoke(key), (VSrc) this.vListDest2Src.invoke(value));
        if (listPut != null) {
            return this.vListSrc2Dest.invoke(listPut);
        }
        return null;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends KDest, ? extends List<VDest>> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Iterator<T> it = from.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            this.src.put(this.kDest2Src.invoke((KDest) entry.getKey()), this.vListDest2Src.invoke((List) entry.getValue()));
        }
    }

    @Override // java.util.Map
    public List<VDest> remove(Object key) {
        List<VSrc> list = (List) this.src.remove(this.kDest2Src.invoke(key));
        if (list != null) {
            return this.vListSrc2Dest.invoke(list);
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public boolean removeElement(KDest key, VDest value) {
        return this.src.removeElement(this.kDest2Src.invoke(key), this.vDest2Src.invoke(value));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public VDest removeAt(KDest key, int index) {
        Object objRemoveAt = this.src.removeAt(this.kDest2Src.invoke(key), index);
        if (objRemoveAt != null) {
            return (VDest) this.vSrc2Dest.invoke(objRemoveAt);
        }
        return null;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public Boolean removeAll(KDest key, Collection<? extends VDest> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        return this.src.removeAll(this.kDest2Src.invoke(key), ConvertersKt.m12157asView((Collection) values, (Function1) this.vDest2Src, (Function1) this.vSrc2Dest));
    }

    @Override // aws.smithy.kotlin.runtime.collections.MutableMultiMap
    public Boolean retainAll(KDest key, Collection<? extends VDest> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        List list = (List) this.src.get(this.kDest2Src.invoke(key));
        if (list != null) {
            return Boolean.valueOf(list.retainAll(ConvertersKt.m12157asView((Collection) values, (Function1) this.vDest2Src, (Function1) this.vSrc2Dest)));
        }
        return null;
    }

    public int getSize() {
        return this.src.size();
    }

    public Collection<List<VDest>> getValues() {
        return ConvertersKt.asView((Collection) this.src.values(), (Function1) this.vListSrc2Dest, (Function1) this.vListDest2Src);
    }
}
