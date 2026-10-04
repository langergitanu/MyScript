package com.revenuecat.purchases.p036ui.revenuecatui.components.stack;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerticalStack.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ComposableSingletons$VerticalStackKt {
    public static final ComposableSingletons$VerticalStackKt INSTANCE = new ComposableSingletons$VerticalStackKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<ColumnScope, Composer, Integer, Unit> f2923lambda1 = ComposableLambdaKt.composableLambdaInstance(-988616884, false, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.ComposableSingletons$VerticalStackKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope columnScope, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(columnScope, "$this$null");
            ComposerKt.sourceInformation(composer, "C:VerticalStack.kt#280jdz");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-988616884, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.stack.ComposableSingletons$VerticalStackKt.lambda-1.<anonymous> (VerticalStack.kt:88)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m13977getLambda1$revenuecatui_defaultsRelease() {
        return f2923lambda1;
    }
}
