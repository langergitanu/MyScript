package com.revenuecat.purchases.p036ui.revenuecatui.templates;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.revenuecat.purchases.p036ui.revenuecatui.UIConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Template2.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ComposableSingletons$Template2Kt {
    public static final ComposableSingletons$Template2Kt INSTANCE = new ComposableSingletons$Template2Kt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f2951lambda1 = ComposableLambdaKt.composableLambdaInstance(-1707838296, false, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.templates.ComposableSingletons$Template2Kt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            ComposerKt.sourceInformation(composer, "C115@5629L69:Template2.kt#mf3l5c");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1707838296, i, -1, "com.revenuecat.purchases.ui.revenuecatui.templates.ComposableSingletons$Template2Kt.lambda-1.<anonymous> (Template2.kt:115)");
            }
            SpacerKt.Spacer(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, UIConstant.INSTANCE.m13862getDefaultVerticalSpacingD9Ej5fM()), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m14276getLambda1$revenuecatui_defaultsRelease() {
        return f2951lambda1;
    }
}
