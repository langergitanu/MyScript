package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* JADX INFO: compiled from: TimePicker.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"defaultTimePickerLayoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "(Landroidx/compose/runtime/Composer;I)I", "material3"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class TimePicker_androidKt {
    public static final int defaultTimePickerLayoutType(Composer composer, int i) {
        int iM5949getVerticalQJTpgSE;
        ComposerKt.sourceInformationMarkerStart(composer, -721362352, "C(defaultTimePickerLayoutType)26@977L7:TimePicker.android.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-721362352, i, -1, "androidx.compose.material3.defaultTimePickerLayoutType (TimePicker.android.kt:26)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Configuration configuration = (Configuration) objConsume;
        if (configuration.screenHeightDp < configuration.screenWidthDp) {
            iM5949getVerticalQJTpgSE = TimePickerLayoutType.INSTANCE.m5948getHorizontalQJTpgSE();
        } else {
            iM5949getVerticalQJTpgSE = TimePickerLayoutType.INSTANCE.m5949getVerticalQJTpgSE();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iM5949getVerticalQJTpgSE;
    }
}
