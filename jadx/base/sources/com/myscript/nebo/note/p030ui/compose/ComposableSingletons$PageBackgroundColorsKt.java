package com.myscript.nebo.note.p030ui.compose;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.res.VectorResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: pageBackgroundColors.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$PageBackgroundColorsKt {
    public static final ComposableSingletons$PageBackgroundColorsKt INSTANCE = new ComposableSingletons$PageBackgroundColorsKt();
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> lambda$1036225052 = ComposableLambdaKt.composableLambdaInstance(1036225052, false, new Function3() { // from class: com.myscript.nebo.note.ui.compose.ComposableSingletons$PageBackgroundColorsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PageBackgroundColorsKt.lambda_1036225052$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> getLambda$1036225052$app_standardRelease() {
        return lambda$1036225052;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1036225052$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C79@3468L65,81@3628L6,78@3416L248:pageBackgroundColors.kt#ku1rws");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1036225052, i, -1, "com.myscript.nebo.note.ui.compose.ComposableSingletons$PageBackgroundColorsKt.lambda$1036225052.<anonymous> (pageBackgroundColors.kt:78)");
        }
        IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_check, composer, 6), "checked", (Modifier) null, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composer, 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
