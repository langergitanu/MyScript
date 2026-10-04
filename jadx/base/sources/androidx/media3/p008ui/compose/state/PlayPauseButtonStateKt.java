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

/* JADX INFO: compiled from: PlayPauseButtonState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"rememberPlayPauseButtonState", "Landroidx/media3/ui/compose/state/PlayPauseButtonState;", "player", "Landroidx/media3/common/Player;", "(Landroidx/media3/common/Player;Landroidx/compose/runtime/Composer;I)Landroidx/media3/ui/compose/state/PlayPauseButtonState;", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class PlayPauseButtonStateKt {
    public static final PlayPauseButtonState rememberPlayPauseButtonState(Player player, Composer composer, int i) {
        composer.startReplaceGroup(1585922024);
        ComposerKt.sourceInformation(composer, "C(rememberPlayPauseButtonState)38@1583L49,39@1658L34,39@1635L57:PlayPauseButtonState.kt#axn2az");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1585922024, i, -1, "androidx.media3.ui.compose.state.rememberPlayPauseButtonState (PlayPauseButtonState.kt:37)");
        }
        composer.startReplaceGroup(-1936579788);
        ComposerKt.sourceInformation(composer, "CC(remember):PlayPauseButtonState.kt#9igjgp");
        boolean zChanged = composer.changed(player);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new PlayPauseButtonState(player);
            composer.updateRememberedValue(objRememberedValue);
        }
        PlayPauseButtonState playPauseButtonState = (PlayPauseButtonState) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1936577403);
        ComposerKt.sourceInformation(composer, "CC(remember):PlayPauseButtonState.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(playPauseButtonState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new PlayPauseButtonStateKt$rememberPlayPauseButtonState$1$1(playPauseButtonState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return playPauseButtonState;
    }
}
