package com.myscript.nebo.p022ai.presentation.compose;

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
import com.myscript.nebo.p022ai.C6091R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: NewAIFeaturesCard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$NewAIFeaturesCardKt {
    public static final ComposableSingletons$NewAIFeaturesCardKt INSTANCE = new ComposableSingletons$NewAIFeaturesCardKt();
    private static Function2<Composer, Integer, Unit> lambda$1442398031 = ComposableLambdaKt.composableLambdaInstance(1442398031, false, new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.ComposableSingletons$NewAIFeaturesCardKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NewAIFeaturesCardKt.lambda_1442398031$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    public final Function2<Composer, Integer, Unit> getLambda$1442398031$nebo_ai_release() {
        return lambda$1442398031;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1442398031$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@2856L43,70@2735L294:NewAIFeaturesCard.kt#ez9f2c");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1442398031, i, -1, "com.myscript.nebo.ai.presentation.compose.ComposableSingletons$NewAIFeaturesCardKt.lambda$1442398031.<anonymous> (NewAIFeaturesCard.kt:70)");
            }
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6091R.drawable.ic_sparkles, composer, 6), "FAB", SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(24)), Color.INSTANCE.m8185getWhite0d7_KjU(), composer, 3504, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
