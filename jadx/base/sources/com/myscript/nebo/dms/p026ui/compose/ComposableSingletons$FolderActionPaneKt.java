package com.myscript.nebo.dms.p026ui.compose;

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
import com.myscript.nebo.dms.C6208R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: folderActionPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$FolderActionPaneKt {
    public static final ComposableSingletons$FolderActionPaneKt INSTANCE = new ComposableSingletons$FolderActionPaneKt();
    private static Function2<Composer, Integer, Unit> lambda$519803061 = ComposableLambdaKt.composableLambdaInstance(519803061, false, new Function2() { // from class: com.myscript.nebo.dms.ui.compose.ComposableSingletons$FolderActionPaneKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$FolderActionPaneKt.lambda_519803061$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-305670707, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f2902lambda$305670707 = ComposableLambdaKt.composableLambdaInstance(-305670707, false, new Function3() { // from class: com.myscript.nebo.dms.ui.compose.ComposableSingletons$FolderActionPaneKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$FolderActionPaneKt.lambda__305670707$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-305670707$dms_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m13003getLambda$305670707$dms_release() {
        return f2902lambda$305670707;
    }

    public final Function2<Composer, Integer, Unit> getLambda$519803061$dms_release() {
        return lambda$519803061;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_519803061$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C130@6018L47,130@6013L53:folderActionPane.kt#3ga04k");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(519803061, i, -1, "com.myscript.nebo.dms.ui.compose.ComposableSingletons$FolderActionPaneKt.lambda$519803061.<anonymous> (folderActionPane.kt:130)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6208R.string.folder_title_hint, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__305670707$lambda$0(RowScope TextButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        ComposerKt.sourceInformation(composer, "C151@6995L49,151@6983L62:folderActionPane.kt#3ga04k");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-305670707, i, -1, "com.myscript.nebo.dms.ui.compose.ComposableSingletons$FolderActionPaneKt.lambda$-305670707.<anonymous> (folderActionPane.kt:151)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(C6183R.string.dialog_cancel, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
