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

/* JADX INFO: compiled from: SeekBackButtonState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"rememberSeekBackButtonState", "Landroidx/media3/ui/compose/state/SeekBackButtonState;", "player", "Landroidx/media3/common/Player;", "(Landroidx/media3/common/Player;Landroidx/compose/runtime/Composer;I)Landroidx/media3/ui/compose/state/SeekBackButtonState;", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SeekBackButtonStateKt {
    public static final SeekBackButtonState rememberSeekBackButtonState(Player player, Composer composer, int i) {
        composer.startReplaceGroup(-1960190237);
        ComposerKt.sourceInformation(composer, "C(rememberSeekBackButtonState)36@1433L48,37@1507L33,37@1484L56:SeekBackButtonState.kt#axn2az");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1960190237, i, -1, "androidx.media3.ui.compose.state.rememberSeekBackButtonState (SeekBackButtonState.kt:35)");
        }
        composer.startReplaceGroup(1071069610);
        ComposerKt.sourceInformation(composer, "CC(remember):SeekBackButtonState.kt#9igjgp");
        boolean zChanged = composer.changed(player);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SeekBackButtonState(player);
            composer.updateRememberedValue(objRememberedValue);
        }
        SeekBackButtonState seekBackButtonState = (SeekBackButtonState) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1071071963);
        ComposerKt.sourceInformation(composer, "CC(remember):SeekBackButtonState.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(seekBackButtonState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new SeekBackButtonStateKt$rememberSeekBackButtonState$1$1(seekBackButtonState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return seekBackButtonState;
    }
}
