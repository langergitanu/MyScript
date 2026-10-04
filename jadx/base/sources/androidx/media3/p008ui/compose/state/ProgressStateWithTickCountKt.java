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

/* JADX INFO: compiled from: ProgressStateWithTickCount.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\"\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"rememberProgressStateWithTickCount", "Landroidx/media3/ui/compose/state/ProgressStateWithTickCount;", "player", "Landroidx/media3/common/Player;", "totalTickCount", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/media3/common/Player;ILkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/Composer;II)Landroidx/media3/ui/compose/state/ProgressStateWithTickCount;", "POSITION_CORRECTION_OFFSET_MS", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ProgressStateWithTickCountKt {
    private static final int POSITION_CORRECTION_OFFSET_MS = 10;

    public static final ProgressStateWithTickCount rememberProgressStateWithTickCount(Player player, int i, CoroutineScope coroutineScope, Composer composer, int i2, int i3) {
        composer.startReplaceGroup(957774810);
        ComposerKt.sourceInformation(composer, "C(rememberProgressStateWithTickCount)P(!1,2)63@3127L24,65@3207L78,66@3311L27,66@3288L50,67@3372L54,67@3341L85:ProgressStateWithTickCount.kt#axn2az");
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
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
            ComposerKt.traceEventStart(957774810, i2, -1, "androidx.media3.ui.compose.state.rememberProgressStateWithTickCount (ProgressStateWithTickCount.kt:64)");
        }
        composer.startReplaceGroup(1625560668);
        ComposerKt.sourceInformation(composer, "CC(remember):ProgressStateWithTickCount.kt#9igjgp");
        boolean zChanged = composer.changed(player);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ProgressStateWithTickCount(player, i, coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ProgressStateWithTickCount progressStateWithTickCount = (ProgressStateWithTickCount) objRememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1625563945);
        ComposerKt.sourceInformation(composer, "CC(remember):ProgressStateWithTickCount.kt#9igjgp");
        boolean zChangedInstance = composer.changedInstance(progressStateWithTickCount);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function2) new C2483x76f5d022(progressStateWithTickCount, null);
            composer.updateRememberedValue(objRememberedValue3);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(player, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composer, i2 & 14);
        Integer numValueOf = Integer.valueOf(i);
        composer.startReplaceGroup(1625565924);
        ComposerKt.sourceInformation(composer, "CC(remember):ProgressStateWithTickCount.kt#9igjgp");
        boolean zChangedInstance2 = composer.changedInstance(progressStateWithTickCount) | ((((i2 & 112) ^ 48) > 32 && composer.changed(i)) || (i2 & 48) == 32);
        Object objRememberedValue4 = composer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function2) new C2484x76f5d3e3(progressStateWithTickCount, i, null);
            composer.updateRememberedValue(objRememberedValue4);
        }
        composer.endReplaceGroup();
        EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composer, (i2 >> 3) & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return progressStateWithTickCount;
    }
}
