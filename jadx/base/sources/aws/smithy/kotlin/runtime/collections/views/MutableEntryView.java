package aws.smithy.kotlin.runtime.collections.views;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: compiled from: MutableEntryView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00052\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00030\u0006BW\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00028\u00032\u0006\u0010\u000e\u001a\u00028\u0003H\u0096\u0080\b¢\u0006\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012¨\u0006\u0013"}, m1599d2 = {"Laws/smithy/kotlin/runtime/collections/views/MutableEntryView;", "KSrc", "KDest", "VSrc", "VDest", "Laws/smithy/kotlin/runtime/collections/views/EntryView;", "", "src", "Lkotlin/Function1;", "kSrc2Dest", "vSrc2Dest", "vDest2Src", "<init>", "(Ljava/util/Map$Entry;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "newValue", "setValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/util/Map$Entry;", "Lkotlin/jvm/functions/Function1;", "runtime-core"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class MutableEntryView<KSrc, KDest, VSrc, VDest> extends EntryView<KSrc, KDest, VSrc, VDest> implements Map.Entry<KDest, VDest>, KMutableMap.Entry {
    private final Function1<KSrc, KDest> kSrc2Dest;
    private final Map.Entry<KSrc, VSrc> src;
    private final Function1<VDest, VSrc> vDest2Src;
    private final Function1<VSrc, VDest> vSrc2Dest;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MutableEntryView(Map.Entry<KSrc, VSrc> src, Function1<? super KSrc, ? extends KDest> kSrc2Dest, Function1<? super VSrc, ? extends VDest> vSrc2Dest, Function1<? super VDest, ? extends VSrc> vDest2Src) {
        super(src, kSrc2Dest, vSrc2Dest);
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(kSrc2Dest, "kSrc2Dest");
        Intrinsics.checkNotNullParameter(vSrc2Dest, "vSrc2Dest");
        Intrinsics.checkNotNullParameter(vDest2Src, "vDest2Src");
        this.src = src;
        this.kSrc2Dest = kSrc2Dest;
        this.vSrc2Dest = vSrc2Dest;
        this.vDest2Src = vDest2Src;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // aws.smithy.kotlin.runtime.collections.views.EntryView, java.util.Map.Entry
    public VDest setValue(VDest newValue) {
        return this.vSrc2Dest.invoke(this.src.setValue(this.vDest2Src.invoke(newValue)));
    }
}
