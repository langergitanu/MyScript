package androidx.media3.p008ui.compose.state;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.media3.common.Player;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ProgressStateWithTickInterval.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a+\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m1599d2 = {"rememberProgressStateWithTickInterval", "Landroidx/media3/ui/compose/state/ProgressStateWithTickInterval;", "player", "Landroidx/media3/common/Player;", "tickIntervalMs", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/media3/common/Player;JLkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/Composer;II)Landroidx/media3/ui/compose/state/ProgressStateWithTickInterval;", "POSITION_CORRECTION_OFFSET_MS", "", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ProgressStateWithTickIntervalKt {
    private static final int POSITION_CORRECTION_OFFSET_MS = 10;

    public static final ProgressStateWithTickInterval rememberProgressStateWithTickInterval(Player player, long j, CoroutineScope coroutineScope, Composer composer, int i, int i2) {
        composer.startReplaceGroup(1758030871);
        ComposerKt.sourceInformation(composer, "C(rememberProgressStateWithTickInterval)P(!1,2)55@2651L24,58@2754L107,61@2887L43,61@2864L66:ProgressStateWithTickInterval.kt#axn2az");
        if ((i2 & 2) != 0) {
            j = 0;
        }
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, -954367824, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1758030871, i, -1, "androidx.media3.ui.compose.state.rememberProgressStateWithTickInterval (ProgressStateWithTickInterval.kt:56)");
        }
        composer.startReplaceGroup(2099733489);
        ComposerKt.sourceInformation(composer, "CC(remember):ProgressStateWithTickInterval.kt#9igjgp");
        boolean zChanged = composer.changed(player) | ((((i & 112) ^ 48) > 32 && composer.changed(j)) || (i & 48) == 32);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ProgressStateWithTickInterval(player, j, coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ProgressStateWithTickInterval progressStateWithTickInterval = (ProgressStateWithTickInterval) objRememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(2099737681);
        ComposerKt.sourceInformation(composer, "CC(remember):ProgressStateWithTickInterval.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(progressStateWithTickInterval);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function2) new C2488x8c4c4f2a(progressStateWithTickInterval, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return progressStateWithTickInterval;
    }
}
