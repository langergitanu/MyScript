package aws.smithy.kotlin.runtime.collections.views;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [VDest, VSrc, KSrc, KDest] */
/* JADX INFO: compiled from: MutableMapView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
final /* synthetic */ class MutableMapView$entries$1<KDest, KSrc, VDest, VSrc> extends FunctionReferenceImpl implements Function1<Map.Entry<KSrc, VSrc>, MutableEntryView<KSrc, KDest, VSrc, VDest>> {
    MutableMapView$entries$1(Object obj) {
        super(1, obj, MutableMapView.class, "fwdEntryView", "fwdEntryView(Ljava/util/Map$Entry;)Laws/smithy/kotlin/runtime/collections/views/MutableEntryView;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final MutableEntryView<KSrc, KDest, VSrc, VDest> invoke(Map.Entry<KSrc, VSrc> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((MutableMapView) this.receiver).fwdEntryView((Map.Entry) p0);
    }
}
