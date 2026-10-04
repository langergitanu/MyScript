package com.myscript.nebo.p034ui.compose;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.myscript.nebo.C6079R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RenewalOffer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ComposableSingletons$RenewalOfferKt {
    public static final ComposableSingletons$RenewalOfferKt INSTANCE = new ComposableSingletons$RenewalOfferKt();

    /* JADX INFO: renamed from: lambda$-754074725, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f2913lambda$754074725 = ComposableLambdaKt.composableLambdaInstance(-754074725, false, new Function3() { // from class: com.myscript.nebo.ui.compose.ComposableSingletons$RenewalOfferKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$RenewalOfferKt.lambda__754074725$lambda$0((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-754074725$app_standardRelease, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m13444getLambda$754074725$app_standardRelease() {
        return f2913lambda$754074725;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__754074725$lambda$0(RowScope OutlinedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation(composer, "C101@4312L52,100@4271L177:RenewalOffer.kt#h09ego");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-754074725, i, -1, "com.myscript.nebo.ui.compose.ComposableSingletons$RenewalOfferKt.lambda$-754074725.<anonymous> (RenewalOffer.kt:100)");
            }
            TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(C6079R.string.renewal_offer_dialog_button, composer, 0), null, 0L, null, 0L, null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 1572864, 0, 262078);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
