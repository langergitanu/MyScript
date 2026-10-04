package androidx.compose.material;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.compose.p004ui.C1271R;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: Strings.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m1599d2 = {"getString", "", TypedValues.Custom.S_STRING, "Landroidx/compose/material/Strings;", "getString-4foXLRw", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "material"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class Strings_androidKt {
    /* JADX INFO: renamed from: getString-4foXLRw, reason: not valid java name */
    public static final String m4442getString4foXLRw(int i, Composer composer, int i2) {
        String string;
        ComposerKt.sourceInformationMarkerStart(composer, -726638443, "C(getString)N(string:c#material.Strings)26@969L7,27@1010L7:Strings.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-726638443, i2, -1, "androidx.compose.material.getString (Strings.android.kt:25)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Resources resources = ((Context) objConsume).getResources();
        if (Strings.m4430equalsimpl0(i, Strings.INSTANCE.m4438getNavigationMenuUdPEhr4())) {
            string = resources.getString(C1271R.string.navigation_menu);
        } else if (Strings.m4430equalsimpl0(i, Strings.INSTANCE.m4434getCloseDrawerUdPEhr4())) {
            string = resources.getString(C1271R.string.close_drawer);
        } else if (Strings.m4430equalsimpl0(i, Strings.INSTANCE.m4435getCloseSheetUdPEhr4())) {
            string = resources.getString(C1271R.string.close_sheet);
        } else if (Strings.m4430equalsimpl0(i, Strings.INSTANCE.m4436getDefaultErrorMessageUdPEhr4())) {
            string = resources.getString(C1271R.string.default_error_message);
        } else if (Strings.m4430equalsimpl0(i, Strings.INSTANCE.m4437getExposedDropdownMenuUdPEhr4())) {
            string = resources.getString(C1271R.string.dropdown_menu);
        } else if (Strings.m4430equalsimpl0(i, Strings.INSTANCE.m4440getSliderRangeStartUdPEhr4())) {
            string = resources.getString(C1271R.string.range_start);
        } else if (Strings.m4430equalsimpl0(i, Strings.INSTANCE.m4439getSliderRangeEndUdPEhr4())) {
            string = resources.getString(C1271R.string.range_end);
        } else {
            string = Strings.m4430equalsimpl0(i, Strings.INSTANCE.m4441getSnackbarPaneTitleUdPEhr4()) ? resources.getString(C0868R.string.mc2_snackbar_pane_title) : "";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return string;
    }
}
