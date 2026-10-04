package com.myscript.nebo.p022ai.presentation.compose.quiz;

import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.res.VectorResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AIQuizQuestionsLoaderCard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$AIQuizQuestionsLoaderCardKt {
    public static final ComposableSingletons$AIQuizQuestionsLoaderCardKt INSTANCE = new ComposableSingletons$AIQuizQuestionsLoaderCardKt();

    /* JADX INFO: renamed from: lambda$-537129514, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f2901lambda$537129514 = ComposableLambdaKt.composableLambdaInstance(-537129514, false, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizQuestionsLoaderCardKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AIQuizQuestionsLoaderCardKt.lambda__537129514$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-537129514$nebo_ai_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m12905getLambda$537129514$nebo_ai_release() {
        return f2901lambda$537129514;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__537129514$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C68@2692L46,70@2846L6,67@2636L248:AIQuizQuestionsLoaderCard.kt#nf75a9");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-537129514, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizQuestionsLoaderCardKt.lambda$-537129514.<anonymous> (AIQuizQuestionsLoaderCard.kt:67)");
            }
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_close, composer, 6), "close button", (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
