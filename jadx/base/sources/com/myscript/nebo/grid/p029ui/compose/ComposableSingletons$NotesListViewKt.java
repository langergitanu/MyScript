package com.myscript.nebo.grid.p029ui.compose;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: notesListView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$NotesListViewKt {
    public static final ComposableSingletons$NotesListViewKt INSTANCE = new ComposableSingletons$NotesListViewKt();

    /* JADX INFO: renamed from: lambda$-2072193315, reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f2905lambda$2072193315 = ComposableLambdaKt.composableLambdaInstance(-2072193315, false, new Function3() { // from class: com.myscript.nebo.grid.ui.compose.ComposableSingletons$NotesListViewKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NotesListViewKt.lambda__2072193315$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2048185520, reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f2904lambda$2048185520 = ComposableLambdaKt.composableLambdaInstance(-2048185520, false, new Function3() { // from class: com.myscript.nebo.grid.ui.compose.ComposableSingletons$NotesListViewKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$NotesListViewKt.lambda__2048185520$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-2048185520$app_standardRelease, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m13257getLambda$2048185520$app_standardRelease() {
        return f2904lambda$2048185520;
    }

    /* JADX INFO: renamed from: getLambda$-2072193315$app_standardRelease, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m13258getLambda$2072193315$app_standardRelease() {
        return f2905lambda$2072193315;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2072193315$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C277@11387L41,277@11485L8,277@11372L123:notesListView.kt#r51d28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2072193315, i, -1, "com.myscript.nebo.grid.ui.compose.ComposableSingletons$NotesListViewKt.lambda$-2072193315.<anonymous> (notesListView.kt:277)");
        }
        IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6079R.drawable.ic_error, composer, 0), (String) null, AlphaKt.alpha(Modifier.INSTANCE, ContentAlpha.INSTANCE.getDisabled(composer, ContentAlpha.$stable)), 0L, composer, Painter.$stable | 48, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2048185520$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C300@12276L42,301@12361L6,299@12240L238:notesListView.kt#r51d28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2048185520, i, -1, "com.myscript.nebo.grid.ui.compose.ComposableSingletons$NotesListViewKt.lambda$-2048185520.<anonymous> (notesListView.kt:299)");
        }
        IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6183R.drawable.ic_check, composer, 0), (String) null, SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(16)), MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4200getOnPrimary0d7_KjU(), composer, Painter.$stable | 432, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
