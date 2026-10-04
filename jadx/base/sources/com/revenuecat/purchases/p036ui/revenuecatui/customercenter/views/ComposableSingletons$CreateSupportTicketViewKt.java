package com.revenuecat.purchases.p036ui.revenuecatui.customercenter.views;

import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateSupportTicketView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ComposableSingletons$CreateSupportTicketViewKt {
    public static final ComposableSingletons$CreateSupportTicketViewKt INSTANCE = new ComposableSingletons$CreateSupportTicketViewKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<SnackbarData, Composer, Integer, Unit> f2937lambda1 = ComposableLambdaKt.composableLambdaInstance(-1015639048, false, new Function3<SnackbarData, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CreateSupportTicketViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(SnackbarData snackbarData, Composer composer, Integer num) {
            invoke(snackbarData, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(SnackbarData snackbarData, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
            ComposerKt.sourceInformation(composer, "C363@12821L11,364@12890L11,361@12727L202:CreateSupportTicketView.kt#870w7w");
            if ((i & 6) == 0) {
                i2 = i | (composer.changed(snackbarData) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1015639048, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.ComposableSingletons$CreateSupportTicketViewKt.lambda-1.<anonymous> (CreateSupportTicketView.kt:361)");
                }
                SnackbarKt.m5684SnackbarsDKtq54(snackbarData, null, false, null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getErrorContainer(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnErrorContainer(), 0L, 0L, 0L, composer, i2 & 14, 462);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$revenuecatui_defaultsRelease, reason: not valid java name */
    public final Function3<SnackbarData, Composer, Integer, Unit> m14150getLambda1$revenuecatui_defaultsRelease() {
        return f2937lambda1;
    }
}
