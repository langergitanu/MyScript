package com.myscript.nebo.p022ai.presentation.compose.components;

import androidx.compose.foundation.layout.RowScope;
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
import com.myscript.nebo.p022ai.C6091R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChooseNoteCard.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$ChooseNoteCardKt {
    public static final ComposableSingletons$ChooseNoteCardKt INSTANCE = new ComposableSingletons$ChooseNoteCardKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1091125464 = ComposableLambdaKt.composableLambdaInstance(1091125464, false, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$ChooseNoteCardKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ChooseNoteCardKt.lambda_1091125464$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1091125464$nebo_ai_release() {
        return lambda$1091125464;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1091125464$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C108@3860L39,108@3848L52:ChooseNoteCard.kt#ysqczk");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1091125464, i, -1, "com.myscript.nebo.ai.presentation.compose.components.ComposableSingletons$ChooseNoteCardKt.lambda$1091125464.<anonymous> (ChooseNoteCard.kt:108)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6091R.string.ai_submit, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
