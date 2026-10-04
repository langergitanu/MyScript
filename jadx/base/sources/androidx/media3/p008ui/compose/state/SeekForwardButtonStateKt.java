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

/* JADX INFO: compiled from: SeekForwardButtonState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"rememberSeekForwardButtonState", "Landroidx/media3/ui/compose/state/SeekForwardButtonState;", "player", "Landroidx/media3/common/Player;", "(Landroidx/media3/common/Player;Landroidx/compose/runtime/Composer;I)Landroidx/media3/ui/compose/state/SeekForwardButtonState;", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SeekForwardButtonStateKt {
    public static final SeekForwardButtonState rememberSeekForwardButtonState(Player player, Composer composer, int i) {
        composer.startReplaceGroup(-437514019);
        ComposerKt.sourceInformation(composer, "C(rememberSeekForwardButtonState)36@1445L51,37@1522L36,37@1499L59:SeekForwardButtonState.kt#axn2az");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-437514019, i, -1, "androidx.media3.ui.compose.state.rememberSeekForwardButtonState (SeekForwardButtonState.kt:35)");
        }
        composer.startReplaceGroup(1997234251);
        ComposerKt.sourceInformation(composer, "CC(remember):SeekForwardButtonState.kt#9igjgp");
        boolean zChanged = composer.changed(player);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SeekForwardButtonState(player);
            composer.updateRememberedValue(objRememberedValue);
        }
        SeekForwardButtonState seekForwardButtonState = (SeekForwardButtonState) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1997236700);
        ComposerKt.sourceInformation(composer, "CC(remember):SeekForwardButtonState.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(seekForwardButtonState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new SeekForwardButtonStateKt$rememberSeekForwardButtonState$1$1(seekForwardButtonState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return seekForwardButtonState;
    }
}
