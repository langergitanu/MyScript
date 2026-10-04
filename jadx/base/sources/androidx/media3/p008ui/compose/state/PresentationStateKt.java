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

/* JADX INFO: compiled from: PresentationState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"rememberPresentationState", "Landroidx/media3/ui/compose/state/PresentationState;", "player", "Landroidx/media3/common/Player;", "keepContentOnReset", "", "(Landroidx/media3/common/Player;ZLandroidx/compose/runtime/Composer;II)Landroidx/media3/ui/compose/state/PresentationState;", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class PresentationStateKt {
    public static final PresentationState rememberPresentationState(Player player, boolean z, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-1006141136);
        ComposerKt.sourceInformation(composer, "C(rememberPresentationState)P(1)51@2058L50,52@2134L37,52@2111L60,53@2209L61,53@2174L96:PresentationState.kt#axn2az");
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1006141136, i, -1, "androidx.media3.ui.compose.state.rememberPresentationState (PresentationState.kt:50)");
        }
        composer.startReplaceGroup(2097651363);
        ComposerKt.sourceInformation(composer, "CC(remember):PresentationState.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new PresentationState(z);
            composer.updateRememberedValue(objRememberedValue);
        }
        PresentationState presentationState = (PresentationState) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(2097653782);
        ComposerKt.sourceInformation(composer, "CC(remember):PresentationState.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(presentationState) | composer.changedInstance(player);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function2) new PresentationStateKt$rememberPresentationState$1$1(presentationState, player, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, i & 14);
        Boolean boolValueOf = Boolean.valueOf(z);
        composer.startReplaceGroup(2097656206);
        ComposerKt.sourceInformation(composer, "CC(remember):PresentationState.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(presentationState) | ((((i & 112) ^ 48) > 32 && composer.changed(z)) || (i & 48) == 32);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function2) new PresentationStateKt$rememberPresentationState$2$1(presentationState, z, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer, (i >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return presentationState;
    }
}
