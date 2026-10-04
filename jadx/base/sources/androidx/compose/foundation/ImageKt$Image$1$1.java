package androidx.compose.foundation;

import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Image.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
final class ImageKt$Image$1$1 implements MeasurePolicy {
    public static final ImageKt$Image$1$1 INSTANCE = new ImageKt$Image$1$1();

    ImageKt$Image$1$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope placementScope) {
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p004ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo1747measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        return MeasureScope.layout$default(measureScope, Constraints.m10972getMinWidthimpl(j), Constraints.m10971getMinHeightimpl(j), null, new Function1() { // from class: androidx.compose.foundation.ImageKt$Image$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ImageKt$Image$1$1.measure_3p2s80s$lambda$0((Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }
}
