package com.myscript.nebo.p034ui.compose;

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
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeSignInDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$NativeSignInDialogKt {
    public static final ComposableSingletons$NativeSignInDialogKt INSTANCE = new ComposableSingletons$NativeSignInDialogKt();
    private static Function3<RowScope, Composer, Integer, Unit> lambda$965898792 = ComposableLambdaKt.composableLambdaInstance(965898792, false, new Function3() { // from class: com.myscript.nebo.ui.compose.ComposableSingletons$NativeSignInDialogKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NativeSignInDialogKt.lambda_965898792$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$1376509158 = ComposableLambdaKt.composableLambdaInstance(1376509158, false, new Function3() { // from class: com.myscript.nebo.ui.compose.ComposableSingletons$NativeSignInDialogKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NativeSignInDialogKt.lambda_1376509158$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$338064866 = ComposableLambdaKt.composableLambdaInstance(338064866, false, new Function2() { // from class: com.myscript.nebo.ui.compose.ComposableSingletons$NativeSignInDialogKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NativeSignInDialogKt.lambda_338064866$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-1604113599, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f2912lambda$1604113599 = ComposableLambdaKt.composableLambdaInstance(-1604113599, false, new Function2() { // from class: com.myscript.nebo.ui.compose.ComposableSingletons$NativeSignInDialogKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$NativeSignInDialogKt.lambda__1604113599$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1604113599$app_standardRelease, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m13443getLambda$1604113599$app_standardRelease() {
        return f2912lambda$1604113599;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$1376509158$app_standardRelease() {
        return lambda$1376509158;
    }

    public final Function2<Composer, Integer, Unit> getLambda$338064866$app_standardRelease() {
        return lambda$338064866;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$965898792$app_standardRelease() {
        return lambda$965898792;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_338064866$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C288@11488L42,288@11483L48:NativeSignInDialog.kt#h09ego");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(338064866, i, -1, "com.myscript.nebo.ui.compose.ComposableSingletons$NativeSignInDialogKt.lambda$338064866.<anonymous> (NativeSignInDialog.kt:288)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6183R.string.network_off, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1604113599$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C289@11557L62,289@11552L68:NativeSignInDialog.kt#h09ego");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1604113599, i, -1, "com.myscript.nebo.ui.compose.ComposableSingletons$NativeSignInDialogKt.lambda$-1604113599.<anonymous> (NativeSignInDialog.kt:289)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6183R.string.sign_in_no_internet_description, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1376509158$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C292@11716L57,292@11711L63:NativeSignInDialog.kt#h09ego");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1376509158, i, -1, "com.myscript.nebo.ui.compose.ComposableSingletons$NativeSignInDialogKt.lambda$1376509158.<anonymous> (NativeSignInDialog.kt:292)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6183R.string.sign_in_no_internet_cancel, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_965898792$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C297@11914L60,297@11909L66:NativeSignInDialog.kt#h09ego");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(965898792, i, -1, "com.myscript.nebo.ui.compose.ComposableSingletons$NativeSignInDialogKt.lambda$965898792.<anonymous> (NativeSignInDialog.kt:297)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6183R.string.sign_in_no_internet_try_again, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
