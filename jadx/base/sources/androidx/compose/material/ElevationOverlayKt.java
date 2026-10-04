package androidx.compose.material;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ElevationOverlay.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0004\b\n\u0010\u000b\"\u0019\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0004¨\u0006\u000e"}, m1599d2 = {"LocalElevationOverlay", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/ElevationOverlay;", "getLocalElevationOverlay", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "calculateForegroundColor", "Landroidx/compose/ui/graphics/Color;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "elevation", "Landroidx/compose/ui/unit/Dp;", "calculateForegroundColor-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "LocalAbsoluteElevation", "getLocalAbsoluteElevation", "material"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ElevationOverlayKt {
    private static final ProvidableCompositionLocal<ElevationOverlay> LocalElevationOverlay = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.ElevationOverlayKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ElevationOverlayKt.LocalElevationOverlay$lambda$0();
        }
    });
    private static final ProvidableCompositionLocal<C1486Dp> LocalAbsoluteElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material.ElevationOverlayKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ElevationOverlayKt.LocalAbsoluteElevation$lambda$0();
        }
    }, 1, null);

    public static final ProvidableCompositionLocal<ElevationOverlay> getLocalElevationOverlay() {
        return LocalElevationOverlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ElevationOverlay LocalElevationOverlay$lambda$0() {
        return DefaultElevationOverlay.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: calculateForegroundColor-CLU3JFs, reason: not valid java name */
    public static final long m4266calculateForegroundColorCLU3JFs(long j, float f, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1613340891, "C(calculateForegroundColor)N(backgroundColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp)87@3454L32:ElevationOverlay.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1613340891, i, -1, "androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:85)");
        }
        long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(ColorsKt.m4221contentColorForek8zF_U(j, composer, i & 14), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jM8147copywmQWz5c$default;
    }

    public static final ProvidableCompositionLocal<C1486Dp> getLocalAbsoluteElevation() {
        return LocalAbsoluteElevation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1486Dp LocalAbsoluteElevation$lambda$0() {
        return C1486Dp.m11015boximpl(C1486Dp.m11017constructorimpl(0));
    }
}
