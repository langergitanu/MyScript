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

/* JADX INFO: compiled from: PlaybackSpeedState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"rememberPlaybackSpeedState", "Landroidx/media3/ui/compose/state/PlaybackSpeedState;", "player", "Landroidx/media3/common/Player;", "(Landroidx/media3/common/Player;Landroidx/compose/runtime/Composer;I)Landroidx/media3/ui/compose/state/PlaybackSpeedState;", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class PlaybackSpeedStateKt {
    public static final PlaybackSpeedState rememberPlaybackSpeedState(Player player, Composer composer, int i) {
        composer.startReplaceGroup(-552324560);
        ComposerKt.sourceInformation(composer, "C(rememberPlaybackSpeedState)36@1429L47,37@1502L32,37@1479L55:PlaybackSpeedState.kt#axn2az");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-552324560, i, -1, "androidx.media3.ui.compose.state.rememberPlaybackSpeedState (PlaybackSpeedState.kt:35)");
        }
        composer.startReplaceGroup(-959433606);
        ComposerKt.sourceInformation(composer, "CC(remember):PlaybackSpeedState.kt#9igjgp");
        boolean zChanged = composer.changed(player);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new PlaybackSpeedState(player);
            composer.updateRememberedValue(objRememberedValue);
        }
        PlaybackSpeedState playbackSpeedState = (PlaybackSpeedState) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-959431285);
        ComposerKt.sourceInformation(composer, "CC(remember):PlaybackSpeedState.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(playbackSpeedState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new PlaybackSpeedStateKt$rememberPlaybackSpeedState$1$1(playbackSpeedState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return playbackSpeedState;
    }
}
