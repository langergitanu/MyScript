package androidx.compose.material3.adaptive;

import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.WindowInfo;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.window.core.layout.WindowSizeClass;
import kotlin.Metadata;

/* JADX INFO: compiled from: WindowAdaptiveInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0007¨\u0006\n"}, m1599d2 = {"currentWindowAdaptiveInfo", "Landroidx/compose/material3/adaptive/WindowAdaptiveInfo;", "supportLargeAndXLargeWidth", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/adaptive/WindowAdaptiveInfo;", "currentWindowDpSize", "Landroidx/compose/ui/unit/DpSize;", "(Landroidx/compose/runtime/Composer;I)J", "currentWindowSize", "Landroidx/compose/ui/unit/IntSize;", "adaptive"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class WindowAdaptiveInfoKt {
    public static final WindowAdaptiveInfo currentWindowAdaptiveInfo(boolean z, Composer composer, int i, int i2) {
        WindowSizeClass windowSizeClassM6160computeFromDpSizeNXuqAC8$default;
        ComposerKt.sourceInformationMarkerStart(composer, -1272950086, "C(currentWindowAdaptiveInfo)N(supportLargeAndXLargeWidth)40@1756L21,48@2067L18:WindowAdaptiveInfo.kt#8avflz");
        if ((i2 & 1) != 0) {
            z = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1272950086, i, -1, "androidx.compose.material3.adaptive.currentWindowAdaptiveInfo (WindowAdaptiveInfo.kt:39)");
        }
        long jCurrentWindowDpSize = currentWindowDpSize(composer, 0);
        if (z) {
            windowSizeClassM6160computeFromDpSizeNXuqAC8$default = WindowSizeClassHelperKt.m6162computeFromDpSizeV2NXuqAC8$default(WindowSizeClass.INSTANCE, jCurrentWindowDpSize, null, null, 6, null);
        } else {
            windowSizeClassM6160computeFromDpSizeNXuqAC8$default = WindowSizeClassHelperKt.m6160computeFromDpSizeNXuqAC8$default(WindowSizeClass.INSTANCE, jCurrentWindowDpSize, null, null, 6, null);
        }
        WindowAdaptiveInfo windowAdaptiveInfo = new WindowAdaptiveInfo(windowSizeClassM6160computeFromDpSizeNXuqAC8$default, AndroidPosture_androidKt.calculatePosture(composer, 0));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowAdaptiveInfo;
    }

    public static final long currentWindowDpSize(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -830991774, "C(currentWindowDpSize)60@2348L7:WindowAdaptiveInfo.kt#8avflz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-830991774, i, -1, "androidx.compose.material3.adaptive.currentWindowDpSize (WindowAdaptiveInfo.kt:60)");
        }
        composer.startReplaceGroup(280825064);
        ComposerKt.sourceInformation(composer, "*60@2359L19");
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jMo2189toDpSizekrfVVM = ((Density) objConsume).mo2189toDpSizekrfVVM(IntSizeKt.m11200toSizeozmzZPI(currentWindowSize(composer, 0)));
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jMo2189toDpSizekrfVVM;
    }

    public static final long currentWindowSize(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -854401115, "C(currentWindowSize)68@2723L7:WindowAdaptiveInfo.kt#8avflz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-854401115, i, -1, "androidx.compose.material3.adaptive.currentWindowSize (WindowAdaptiveInfo.kt:68)");
        }
        ProvidableCompositionLocal<WindowInfo> localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localWindowInfo);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jMo10138getContainerSizeYbymL2g = ((WindowInfo) objConsume).mo10138getContainerSizeYbymL2g();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return jMo10138getContainerSizeYbymL2g;
    }
}
