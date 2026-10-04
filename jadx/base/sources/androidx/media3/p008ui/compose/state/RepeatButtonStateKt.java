package androidx.media3.p008ui.compose.state;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.media3.common.Player;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RepeatButtonState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m1599d2 = {"rememberRepeatButtonState", "Landroidx/media3/ui/compose/state/RepeatButtonState;", "player", "Landroidx/media3/common/Player;", "toggleModeSequence", "", "", "(Landroidx/media3/common/Player;Ljava/util/List;Landroidx/compose/runtime/Composer;II)Landroidx/media3/ui/compose/state/RepeatButtonState;", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class RepeatButtonStateKt {
    public static final RepeatButtonState rememberRepeatButtonState(Player player, List<Integer> list, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-1136736939);
        ComposerKt.sourceInformation(composer, "C(rememberRepeatButtonState)40@1565L66,41@1657L31,41@1634L54:RepeatButtonState.kt#axn2az");
        if ((i2 & 2) != 0) {
            list = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2});
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1136736939, i, -1, "androidx.media3.ui.compose.state.rememberRepeatButtonState (RepeatButtonState.kt:39)");
        }
        composer.startReplaceGroup(-1518558176);
        ComposerKt.sourceInformation(composer, "CC(remember):RepeatButtonState.kt#9igjgp");
        boolean zChanged = composer.changed(player);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new RepeatButtonState(player, list);
            composer.updateRememberedValue(objRememberedValue);
        }
        RepeatButtonState repeatButtonState = (RepeatButtonState) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(-1518555267);
        ComposerKt.sourceInformation(composer, "CC(remember):RepeatButtonState.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(repeatButtonState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new RepeatButtonStateKt$rememberRepeatButtonState$1$1(repeatButtonState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return repeatButtonState;
    }
}
