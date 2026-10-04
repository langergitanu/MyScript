package com.myscript.nebo.trash.p033ui.compose;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: trashedPages.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$TrashedPagesKt {
    public static final ComposableSingletons$TrashedPagesKt INSTANCE = new ComposableSingletons$TrashedPagesKt();

    /* JADX INFO: renamed from: lambda$-1018431757, reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f2910lambda$1018431757 = ComposableLambdaKt.composableLambdaInstance(-1018431757, false, new Function3() { // from class: com.myscript.nebo.trash.ui.compose.ComposableSingletons$TrashedPagesKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TrashedPagesKt.lambda__1018431757$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-186940644, reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f2911lambda$186940644 = ComposableLambdaKt.composableLambdaInstance(-186940644, false, new Function3() { // from class: com.myscript.nebo.trash.ui.compose.ComposableSingletons$TrashedPagesKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$TrashedPagesKt.lambda__186940644$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-1018431757$app_standardRelease, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m13432getLambda$1018431757$app_standardRelease() {
        return f2910lambda$1018431757;
    }

    /* JADX INFO: renamed from: getLambda$-186940644$app_standardRelease, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m13433getLambda$186940644$app_standardRelease() {
        return f2911lambda$186940644;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1018431757$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C283@13326L16:trashedPages.kt#qp0phu");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1018431757, i, -1, "com.myscript.nebo.trash.ui.compose.ComposableSingletons$TrashedPagesKt.lambda$-1018431757.<anonymous> (trashedPages.kt:283)");
        }
        TrashedPagesKt.SelectionState(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__186940644$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C336@15578L6,336@15530L65:trashedPages.kt#qp0phu");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-186940644, i, -1, "com.myscript.nebo.trash.ui.compose.ComposableSingletons$TrashedPagesKt.lambda$-186940644.<anonymous> (trashedPages.kt:336)");
        }
        ProgressIndicatorKt.m4366CircularProgressIndicatorLxG7B9w(null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.0f, 0L, 0, composer, 0, 29);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
