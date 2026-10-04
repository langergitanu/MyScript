package com.airbnb.lottie.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: LottieRetrySignal.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"rememberLottieRetrySignal", "Lcom/airbnb/lottie/compose/LottieRetrySignal;", "(Landroidx/compose/runtime/Composer;I)Lcom/airbnb/lottie/compose/LottieRetrySignal;", "lottie-compose_release"}, m1600k = 2, m1601mv = {1, 9, 0}, m1603xi = 48)
public final class LottieRetrySignalKt {
    public static final LottieRetrySignal rememberLottieRetrySignal(Composer composer, int i) {
        composer.startReplaceableGroup(-1266611990);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1266611990, i, -1, "com.airbnb.lottie.compose.rememberLottieRetrySignal (LottieRetrySignal.kt:17)");
        }
        composer.startReplaceableGroup(1025108850);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new LottieRetrySignal();
            composer.updateRememberedValue(objRememberedValue);
        }
        LottieRetrySignal lottieRetrySignal = (LottieRetrySignal) objRememberedValue;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return lottieRetrySignal;
    }
}
