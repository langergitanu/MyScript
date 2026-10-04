package androidx.media3.p008ui.compose.state;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.media3.common.Player;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ShuffleButtonState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"rememberShuffleButtonState", "Landroidx/media3/ui/compose/state/ShuffleButtonState;", "player", "Landroidx/media3/common/Player;", "(Landroidx/media3/common/Player;Landroidx/compose/runtime/Composer;I)Landroidx/media3/ui/compose/state/ShuffleButtonState;", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ShuffleButtonStateKt {
    public static final ShuffleButtonState rememberShuffleButtonState(Player player, Composer composer, int i) {
        composer.startReplaceGroup(-782917103);
        ComposerKt.sourceInformation(composer, "C(rememberShuffleButtonState)35@1377L47,36@1450L32,36@1427L55:ShuffleButtonState.kt#axn2az");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-782917103, i, -1, "androidx.media3.ui.compose.state.rememberShuffleButtonState (ShuffleButtonState.kt:34)");
        }
        composer.startReplaceGroup(473654395);
        ComposerKt.sourceInformation(composer, "CC(remember):ShuffleButtonState.kt#9igjgp");
        boolean zChanged = composer.changed(player);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new ShuffleButtonState(player);
            composer.updateRememberedValue(objRememberedValue);
        }
        ShuffleButtonState shuffleButtonState = (ShuffleButtonState) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(473656716);
        ComposerKt.sourceInformation(composer, "CC(remember):ShuffleButtonState.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(shuffleButtonState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new ShuffleButtonStateKt$rememberShuffleButtonState$1$1(shuffleButtonState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return shuffleButtonState;
    }
}
