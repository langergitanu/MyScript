package com.myscript.nebo.p022ai.presentation.compose.quiz;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.res.VectorResources_androidKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AIQuizOneTimeCard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$AIQuizOneTimeCardKt {
    public static final ComposableSingletons$AIQuizOneTimeCardKt INSTANCE = new ComposableSingletons$AIQuizOneTimeCardKt();

    /* JADX INFO: renamed from: lambda$-1451167876, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f2900lambda$1451167876 = ComposableLambdaKt.composableLambdaInstance(-1451167876, false, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizOneTimeCardKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AIQuizOneTimeCardKt.lambda__1451167876$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1451167876$nebo_ai_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12904getLambda$1451167876$nebo_ai_release() {
        return f2900lambda$1451167876;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1451167876$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C71@2807L53,69@2686L304:AIQuizOneTimeCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1451167876, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizOneTimeCardKt.lambda$-1451167876.<anonymous> (AIQuizOneTimeCard.kt:69)");
            }
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_quiz_outline, composer, 6), "FAB", SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(24)), Color.INSTANCE.m8185getWhite0d7_KjU(), composer, 3504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
