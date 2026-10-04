package androidx.media3.p008ui.compose.modifiers;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Size;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.LayoutModifierKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.layout.ScaleFactor;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: extensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, m1599d2 = {"resizeWithContentScale", "Landroidx/compose/ui/Modifier;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "sourceSizeDp", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "resizeWithContentScale-XrYQPog", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/geometry/Size;Landroidx/compose/ui/unit/Density;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ExtensionsKt {
    /* JADX INFO: renamed from: resizeWithContentScale-XrYQPog, reason: not valid java name */
    public static final Modifier m11722resizeWithContentScaleXrYQPog(Modifier resizeWithContentScale, final ContentScale contentScale, Size size, final Density density, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(resizeWithContentScale, "$this$resizeWithContentScale");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        composer.startReplaceGroup(-363477779);
        ComposerKt.sourceInformation(composer, "C(resizeWithContentScale)P(!1,2:c#ui.geometry.Size)40@1477L7,*47@1645L720:extensions.kt#n864xs");
        if ((i2 & 4) != 0) {
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            density = (Density) objConsume;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-363477779, i, -1, "androidx.media3.ui.compose.modifiers.resizeWithContentScale (extensions.kt:42)");
        }
        boolean z = true;
        Modifier.Companion companionLayout = null;
        Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, false, 3, null);
        if (size != null) {
            final long jM7977unboximpl = size.m7977unboximpl();
            Modifier.Companion companion = Modifier.INSTANCE;
            composer.startReplaceGroup(-1859173400);
            ComposerKt.sourceInformation(composer, "CC(remember):extensions.kt#9igjgp");
            boolean zChanged = ((((i & 7168) ^ 3072) > 2048 && composer.changed(density)) || (i & 3072) == 2048) | composer.changed(jM7977unboximpl);
            if ((((i & 112) ^ 48) <= 32 || !composer.changed(contentScale)) && (i & 48) != 32) {
                z = false;
            }
            boolean z2 = zChanged | z;
            Object objRememberedValue = composer.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function3() { // from class: androidx.media3.ui.compose.modifiers.ExtensionsKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ExtensionsKt.resizeWithContentScale_XrYQPog$lambda$4$lambda$3$lambda$2(density, contentScale, jM7977unboximpl, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceGroup();
            companionLayout = LayoutModifierKt.layout(companion, (Function3) objRememberedValue);
        }
        if (companionLayout == null) {
            companionLayout = Modifier.INSTANCE;
        }
        Modifier modifierThen = resizeWithContentScale.then(modifierWrapContentSize$default.then(companionLayout));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierThen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult resizeWithContentScale_XrYQPog$lambda$4$lambda$3$lambda$2(Density density, ContentScale contentScale, long j, MeasureScope layout, Measurable measurable, Constraints constraints) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long jSize = androidx.compose.p004ui.geometry.SizeKt.Size(density.mo2191toPx0680j_4(C1486Dp.m11017constructorimpl(Size.m7972getWidthimpl(j))), density.mo2191toPx0680j_4(C1486Dp.m11017constructorimpl(Size.m7969getHeightimpl(j))));
        long jMo9618computeScaleFactorH7hwNQA = contentScale.mo9618computeScaleFactorH7hwNQA(jSize, androidx.compose.p004ui.geometry.SizeKt.Size(Constraints.m10970getMaxWidthimpl(constraints.getValue()), Constraints.m10969getMaxHeightimpl(constraints.getValue())));
        final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(constraints.getValue(), 0, MathKt.roundToInt(Size.m7972getWidthimpl(jSize) * ScaleFactor.m9741getScaleXimpl(jMo9618computeScaleFactorH7hwNQA)), 0, MathKt.roundToInt(Size.m7969getHeightimpl(jSize) * ScaleFactor.m9742getScaleYimpl(jMo9618computeScaleFactorH7hwNQA)), 5, null));
        return MeasureScope.layout$default(layout, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.media3.ui.compose.modifiers.ExtensionsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExtensionsKt.m312x52295c0(placeableMo9625measureBRTryo0, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: resizeWithContentScale_XrYQPog$lambda$4$lambda$3$lambda$2$lambda$1 */
    public static final Unit m312x52295c0(Placeable placeable, Placeable.PlacementScope layout) {
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        Placeable.PlacementScope.place$default(layout, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
