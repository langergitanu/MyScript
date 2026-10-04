package com.myscript.nebo.p022ai.presentation.compose.quiz;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p004ui.Modifier;
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

/* JADX INFO: compiled from: AIQuizChoicePromptPane.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$AIQuizChoicePromptPaneKt {
    public static final ComposableSingletons$AIQuizChoicePromptPaneKt INSTANCE = new ComposableSingletons$AIQuizChoicePromptPaneKt();
    private static Function2<Composer, Integer, Unit> lambda$514477163 = ComposableLambdaKt.composableLambdaInstance(514477163, false, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizChoicePromptPaneKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$AIQuizChoicePromptPaneKt.lambda_514477163$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$514477163$nebo_ai_release() {
        return lambda$514477163;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_514477163$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C79@2977L46,81@3115L6,77@2880L265:AIQuizChoicePromptPane.kt#nf75a9");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514477163, i, -1, "com.myscript.nebo.ai.presentation.compose.quiz.ComposableSingletons$AIQuizChoicePromptPaneKt.lambda$514477163.<anonymous> (AIQuizChoicePromptPane.kt:77)");
            }
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_close, composer, 6), "close button", SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(24)), MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
