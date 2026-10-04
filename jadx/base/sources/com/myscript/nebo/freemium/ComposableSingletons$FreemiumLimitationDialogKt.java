package com.myscript.nebo.freemium;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FreemiumLimitationDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$FreemiumLimitationDialogKt {
    public static final ComposableSingletons$FreemiumLimitationDialogKt INSTANCE = new ComposableSingletons$FreemiumLimitationDialogKt();
    private static Function3<BoxScope, Composer, Integer, Unit> lambda$227765896 = ComposableLambdaKt.composableLambdaInstance(227765896, false, new Function3() { // from class: com.myscript.nebo.freemium.ComposableSingletons$FreemiumLimitationDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$FreemiumLimitationDialogKt.lambda_227765896$lambda$0((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<BoxScope, Composer, Integer, Unit> getLambda$227765896$app_standardRelease() {
        return lambda$227765896;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_227765896$lambda$0(BoxScope GradientButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(GradientButton, "$this$GradientButton");
        ComposerKt.sourceInformation(composer, "C201@7062L66,202@7164L6,200@7037L153:FreemiumLimitationDialog.kt#d60tuo");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(227765896, i, -1, "com.myscript.nebo.freemium.ComposableSingletons$FreemiumLimitationDialogKt.lambda$227765896.<anonymous> (FreemiumLimitationDialog.kt:200)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6471R.string.freemium_limitation_dialog_subscribe, composer, 0), (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4200getOnPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
