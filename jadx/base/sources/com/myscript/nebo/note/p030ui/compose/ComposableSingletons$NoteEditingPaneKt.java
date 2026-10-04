package com.myscript.nebo.note.p030ui.compose;

import android.R;
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
import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: noteEditingPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$NoteEditingPaneKt {
    public static final ComposableSingletons$NoteEditingPaneKt INSTANCE = new ComposableSingletons$NoteEditingPaneKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1152641414 = ComposableLambdaKt.composableLambdaInstance(1152641414, false, new Function3() { // from class: com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteEditingPaneKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NoteEditingPaneKt.lambda_1152641414$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-434548173, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f2908lambda$434548173 = ComposableLambdaKt.composableLambdaInstance(-434548173, false, new Function3() { // from class: com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteEditingPaneKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NoteEditingPaneKt.lambda__434548173$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-434548173$app_standardRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m13287getLambda$434548173$app_standardRelease() {
        return f2908lambda$434548173;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1152641414$app_standardRelease() {
        return lambda$1152641414;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1152641414$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C93@3823L39,93@3811L52:noteEditingPane.kt#ku1rws");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1152641414, i, -1, "com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteEditingPaneKt.lambda$1152641414.<anonymous> (noteEditingPane.kt:93)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(R.string.cancel, composer, 6), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__434548173$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C96@3951L47,96@3939L60:noteEditingPane.kt#ku1rws");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-434548173, i, -1, "com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteEditingPaneKt.lambda$-434548173.<anonymous> (noteEditingPane.kt:96)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6079R.string.note_edition_edit, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
