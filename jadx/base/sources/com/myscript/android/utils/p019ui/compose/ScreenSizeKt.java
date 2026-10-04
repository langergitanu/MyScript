package com.myscript.android.utils.p019ui.compose;

import android.content.res.Configuration;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* JADX INFO: compiled from: ScreenSize.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, m1599d2 = {"isPhone", "", "(Landroidx/compose/runtime/Composer;I)Z", "isLandscape", "isPhoneInLandscape", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ScreenSizeKt {
    public static final boolean isPhone(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1359660649, "C(isPhone)10@312L7:ScreenSize.kt#vd5fha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1359660649, i, -1, "com.myscript.android.utils.ui.compose.isPhone (ScreenSize.kt:9)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean z = ((Configuration) objConsume).smallestScreenWidthDp <= 600;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return z;
    }

    public static final boolean isLandscape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2031218186, "C(isLandscape)18@516L7:ScreenSize.kt#vd5fha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2031218186, i, -1, "com.myscript.android.utils.ui.compose.isLandscape (ScreenSize.kt:17)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        boolean z = ((Configuration) objConsume).orientation == 2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return z;
    }

    public static final boolean isPhoneInLandscape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 331713523, "C(isPhoneInLandscape)24@662L9:ScreenSize.kt#vd5fha");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(331713523, i, -1, "com.myscript.android.utils.ui.compose.isPhoneInLandscape (ScreenSize.kt:23)");
        }
        boolean zIsLandscape = false;
        if (isPhone(composer, 0)) {
            composer.startReplaceGroup(949117632);
            ComposerKt.sourceInformation(composer, "24@675L13");
            zIsLandscape = isLandscape(composer, 0);
        } else {
            composer.startReplaceGroup(-642123243);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return zIsLandscape;
    }
}
