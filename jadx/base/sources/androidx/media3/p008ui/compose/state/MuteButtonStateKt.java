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

/* JADX INFO: compiled from: MuteButtonState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"rememberMuteButtonState", "Landroidx/media3/ui/compose/state/MuteButtonState;", "player", "Landroidx/media3/common/Player;", "(Landroidx/media3/common/Player;Landroidx/compose/runtime/Composer;I)Landroidx/media3/ui/compose/state/MuteButtonState;", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class MuteButtonStateKt {
    public static final MuteButtonState rememberMuteButtonState(Player player, Composer composer, int i) {
        composer.startReplaceGroup(-605397571);
        ComposerKt.sourceInformation(composer, "C(rememberMuteButtonState)35@1366L44,36@1436L29,36@1413L52:MuteButtonState.kt#axn2az");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-605397571, i, -1, "androidx.media3.ui.compose.state.rememberMuteButtonState (MuteButtonState.kt:34)");
        }
        composer.startReplaceGroup(796504556);
        ComposerKt.sourceInformation(composer, "CC(remember):MuteButtonState.kt#9igjgp");
        boolean zChanged = composer.changed(player);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new MuteButtonState(player);
            composer.updateRememberedValue(objRememberedValue);
        }
        MuteButtonState muteButtonState = (MuteButtonState) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(796506781);
        ComposerKt.sourceInformation(composer, "CC(remember):MuteButtonState.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(muteButtonState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new MuteButtonStateKt$rememberMuteButtonState$1$1(muteButtonState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return muteButtonState;
    }
}
