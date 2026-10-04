package aws.smithy.kotlin.runtime.collections.views;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: EntryView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u0005BC\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\rR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0015\u0010\u0010\u001a\u00028\u00018VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0012\u001a\u00028\u00038VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/EntryView;", "KSrc", "KDest", "VSrc", "VDest", "", "src", "Lkotlin/Function1;", "kSrc2Dest", "vSrc2Dest", "<init>", "(Ljava/util/Map$Entry;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Ljava/util/Map$Entry;", "Lkotlin/jvm/functions/Function1;", "getKey", "()Ljava/lang/Object;", SubscriberAttributeKt.JSON_NAME_KEY, "getValue", "value", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class EntryView<KSrc, KDest, VSrc, VDest> implements Map.Entry<KDest, VDest>, KMappedMarker {
    private final Function1<KSrc, KDest> kSrc2Dest;
    private final Map.Entry<KSrc, VSrc> src;
    private final Function1<VSrc, VDest> vSrc2Dest;

    @Override // java.util.Map.Entry
    public VDest setValue(VDest vdest) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EntryView(Map.Entry<? extends KSrc, ? extends VSrc> src, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super VSrc, ? extends VDest> vSrc2Dest) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(kSrc2Dest, "kSrc2Dest");
        Intrinsics.checkNotNullParameter(vSrc2Dest, "vSrc2Dest");
        this.src = src;
        this.kSrc2Dest = kSrc2Dest;
        this.vSrc2Dest = vSrc2Dest;
    }

    @Override // java.util.Map.Entry
    public KDest getKey() {
        return (KDest) this.kSrc2Dest.invoke(this.src.getKey());
    }

    @Override // java.util.Map.Entry
    public VDest getValue() {
        return (VDest) this.vSrc2Dest.invoke(this.src.getValue());
    }
}
