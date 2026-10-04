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

/* JADX INFO: compiled from: noteCreationPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$NoteCreationPaneKt {
    public static final ComposableSingletons$NoteCreationPaneKt INSTANCE = new ComposableSingletons$NoteCreationPaneKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1131034022 = ComposableLambdaKt.composableLambdaInstance(1131034022, false, new Function3() { // from class: com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteCreationPaneKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NoteCreationPaneKt.lambda_1131034022$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-505829485, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f2907lambda$505829485 = ComposableLambdaKt.composableLambdaInstance(-505829485, false, new Function3() { // from class: com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteCreationPaneKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NoteCreationPaneKt.lambda__505829485$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$23323743 = ComposableLambdaKt.composableLambdaInstance(23323743, false, new Function3() { // from class: com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteCreationPaneKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NoteCreationPaneKt.lambda_23323743$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-505829485$app_standardRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m13286getLambda$505829485$app_standardRelease() {
        return f2907lambda$505829485;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1131034022$app_standardRelease() {
        return lambda$1131034022;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$23323743$app_standardRelease() {
        return lambda$23323743;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1131034022$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C164@8607L39,164@8595L52:noteCreationPane.kt#ku1rws");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1131034022, i, -1, "com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteCreationPaneKt.lambda$1131034022.<anonymous> (noteCreationPane.kt:164)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(R.string.cancel, composer, 6), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__505829485$lambda$0(RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C167@8761L50,167@8749L63:noteCreationPane.kt#ku1rws");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-505829485, i, -1, "com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteCreationPaneKt.lambda$-505829485.<anonymous> (noteCreationPane.kt:167)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6079R.string.note_creation_create, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_23323743$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C331@16029L59,331@16024L65:noteCreationPane.kt#ku1rws");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(23323743, i, -1, "com.myscript.nebo.note.ui.compose.ComposableSingletons$NoteCreationPaneKt.lambda$23323743.<anonymous> (noteCreationPane.kt:331)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6079R.string.note_creation_manage_language, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
