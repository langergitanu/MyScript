package aws.smithy.kotlin.runtime.collections.views;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [VDest, VSrc, KSrc, KDest] */
/* JADX INFO: compiled from: MapView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class MapView$entries$1<KDest, KSrc, VDest, VSrc> extends FunctionReferenceImpl implements Function1<Map.Entry<? extends KSrc, ? extends VSrc>, EntryView<KSrc, KDest, VSrc, VDest>> {
    MapView$entries$1(Object obj) {
        super(1, obj, MapView.class, "fwdEntryView", "fwdEntryView(Ljava/util/Map$Entry;)Laws/smithy/kotlin/runtime/collections/views/EntryView;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final EntryView<KSrc, KDest, VSrc, VDest> invoke(Map.Entry<? extends KSrc, ? extends VSrc> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((MapView) this.receiver).fwdEntryView(p0);
    }
}
