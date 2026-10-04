package com.myscript.nebo.note.p030ui.compose;

import androidx.compose.animation.AnimatedVisibilityScope;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: pageBackgroundPatterns.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$PageBackgroundPatternsKt {
    public static final ComposableSingletons$PageBackgroundPatternsKt INSTANCE = new ComposableSingletons$PageBackgroundPatternsKt();

    /* JADX INFO: renamed from: lambda$-207129885, reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f2909lambda$207129885 = ComposableLambdaKt.composableLambdaInstance(-207129885, false, new Function3() { // from class: com.myscript.nebo.note.ui.compose.ComposableSingletons$PageBackgroundPatternsKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PageBackgroundPatternsKt.lambda__207129885$lambda$0((AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-207129885$app_standardRelease, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m13290getLambda$207129885$app_standardRelease() {
        return f2909lambda$207129885;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__207129885$lambda$0(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C77@3668L65,79@3828L6,76@3616L227:pageBackgroundPatterns.kt#ku1rws");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-207129885, i, -1, "com.myscript.nebo.note.ui.compose.ComposableSingletons$PageBackgroundPatternsKt.lambda$-207129885.<anonymous> (pageBackgroundPatterns.kt:76)");
        }
        IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6183R.drawable.ic_check, composer, 6), "checked", (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), composer, 48, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
