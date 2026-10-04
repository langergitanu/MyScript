package aws.smithy.kotlin.runtime.collections.views;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: compiled from: MutableMapView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00052\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u0006Bk\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u0011\u0010\u0016\u001a\u00020\u0015H\u0096\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001a\u001a\u0004\u0018\u00018\u00032\u0006\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00028\u0003H\u0096\u0080\b¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001e\u001a\u00020\u00152\u0014\u0010\u001d\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u001cH\u0096\u0080\u0004¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u0004\u0018\u00018\u00032\u0006\u0010\u0018\u001a\u00028\u0001H\u0096\u0080\b¢\u0006\u0004\b \u0010!R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\"R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010#R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010#R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010#R'\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u000f0$8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001b\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00010$8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b(\u0010&R\u001b\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00030*8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u0006."}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/MutableMapView;", "KSrc", "KDest", "VSrc", "VDest", "Laws/smithy/kotlin/runtime/collections/views/MapView;", "", "src", "Lkotlin/Function1;", "kSrc2Dest", "kDest2Src", "vSrc2Dest", "vDest2Src", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "Laws/smithy/kotlin/runtime/collections/views/MutableEntryView;", "fwdEntryView", "(Ljava/util/Map$Entry;)Laws/smithy/kotlin/runtime/collections/views/MutableEntryView;", "dest", "revEntryView", "", "clear", "()V", SubscriberAttributeKt.JSON_NAME_KEY, "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", TypedValues.TransitionType.S_FROM, "putAll", "(Ljava/util/Map;)V", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/Map;", "Lkotlin/jvm/functions/Function1;", "", "getEntries", "()Ljava/util/Set;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, "", "getValues", "()Ljava/util/Collection;", "values", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class MutableMapView<KSrc, KDest, VSrc, VDest> extends MapView<KSrc, KDest, VSrc, VDest> implements Map<KDest, VDest>, KMutableMap {
    private final Function1<KDest, KSrc> kDest2Src;
    private final Function1<KSrc, KDest> kSrc2Dest;
    private final Map<KSrc, VSrc> src;
    private final Function1<VDest, VSrc> vDest2Src;
    private final Function1<VSrc, VDest> vSrc2Dest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutableMapView(Map<KSrc, VSrc> src, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super KDest, ? extends KSrc> kDest2Src, Function1<? super VSrc, ? extends VDest> vSrc2Dest, Function1<? super VDest, ? extends VSrc> vDest2Src) {
        super(src, kSrc2Dest, kDest2Src, vSrc2Dest, vDest2Src);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableEntryView<KSrc, KDest, VSrc, VDest> fwdEntryView(Map.Entry<KSrc, VSrc> src) {
        return new MutableEntryView<>(src, this.kSrc2Dest, this.vSrc2Dest, this.vDest2Src);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableEntryView<KDest, KSrc, VDest, VSrc> revEntryView(Map.Entry<KDest, VDest> dest) {
        return new MutableEntryView<>(dest, this.kDest2Src, this.vDest2Src, this.vSrc2Dest);
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.MapView, java.util.Map
    public void clear() {
        this.src.clear();
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.MapView
    public Set<Map.Entry<KDest, VDest>> getEntries() {
        return ConvertersKt.asView((Set) this.src.entrySet(), (Function1) new MutableMapView$entries$1(this), (Function1) new MutableMapView$entries$2(this));
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.MapView
    public Set<KDest> getKeys() {
        return ConvertersKt.asView((Set) this.src.keySet(), (Function1) this.kSrc2Dest, (Function1) this.kDest2Src);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // aws.smithy.kotlin.runtime.collections.views.MapView, java.util.Map
    public VDest put(KDest key, VDest value) {
        VSrc vsrcPut = this.src.put(this.kDest2Src.invoke(key), this.vDest2Src.invoke(value));
        if (vsrcPut != null) {
            return this.vSrc2Dest.invoke(vsrcPut);
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.MapView, java.util.Map
    public void putAll(Map<? extends KDest, ? extends VDest> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        Iterator<T> it = from.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            this.src.put(this.kDest2Src.invoke((KDest) key), this.vDest2Src.invoke((VDest) value));
        }
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.MapView, java.util.Map
    public VDest remove(Object key) {
        VSrc vsrcRemove = this.src.remove(this.kDest2Src.invoke(key));
        if (vsrcRemove != null) {
            return this.vSrc2Dest.invoke(vsrcRemove);
        }
        return null;
    }

    @Override // aws.smithy.kotlin.runtime.collections.views.MapView
    public Collection<VDest> getValues() {
        return ConvertersKt.asView((Collection) this.src.values(), (Function1) this.vSrc2Dest, (Function1) this.vDest2Src);
    }
}
