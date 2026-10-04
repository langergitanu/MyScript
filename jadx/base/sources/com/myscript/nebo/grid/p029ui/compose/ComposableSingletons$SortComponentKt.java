package com.myscript.nebo.grid.p029ui.compose;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.IconKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.res.VectorResources_androidKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: sortComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$SortComponentKt {
    public static final ComposableSingletons$SortComponentKt INSTANCE = new ComposableSingletons$SortComponentKt();

    /* JADX INFO: renamed from: lambda$-1129831460, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f2906lambda$1129831460 = ComposableLambdaKt.composableLambdaInstance(-1129831460, false, new Function2() { // from class: com.myscript.nebo.grid.ui.compose.ComposableSingletons$SortComponentKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$SortComponentKt.lambda__1129831460$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1129831460$app_standardRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m13259getLambda$1129831460$app_standardRelease() {
        return f2906lambda$1129831460;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1129831460$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C66@2611L34,66@2594L91:sortComponent.kt#r51d28");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1129831460, i, -1, "com.myscript.nebo.grid.ui.compose.ComposableSingletons$SortComponentKt.lambda$-1129831460.<anonymous> (sortComponent.kt:66)");
            }
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6079R.drawable.ic_sort, composer, 6), "alt", PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), 0L, composer, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
