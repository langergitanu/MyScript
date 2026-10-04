package androidx.media3.p008ui.compose.indicators;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.p008ui.compose.state.ProgressStateWithTickCount;
import androidx.media3.p008ui.compose.state.ProgressStateWithTickCountKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ProgressIndicator.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m1599d2 = {"ProgressIndicator", "", "player", "Landroidx/media3/common/Player;", "totalTickCount", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/media3/ui/compose/state/ProgressStateWithTickCount;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "(Landroidx/media3/common/Player;ILkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ProgressIndicatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProgressIndicator$lambda$0(Player player, int i, CoroutineScope coroutineScope, Function3 function3, int i2, int i3, Composer composer, int i4) {
        ProgressIndicator(player, i, coroutineScope, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ProgressIndicator(final Player player, int i, CoroutineScope coroutineScope, final Function3<? super ProgressStateWithTickCount, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i2, final int i3) {
        int i4;
        final int i5;
        final CoroutineScope coroutineScope2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1584785372);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProgressIndicator)P(1,3,2)45@1878L24,48@1972L65,48@2038L9:ProgressIndicator.kt#vmohc0");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(player) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i6 = i3 & 2;
        if (i6 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= ((i3 & 4) == 0 && composerStartRestartGroup.changedInstance(coroutineScope)) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(content) ? 2048 : 1024;
        }
        if ((i4 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i6 != 0) {
                    i = 0;
                }
                if ((i3 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -954367824, "CC(remember):Effects.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup));
                        composerStartRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        objRememberedValue = compositionScopedCoroutineScopeCanceller;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i4 &= -897;
                }
                int i7 = i;
                CoroutineScope coroutineScope3 = coroutineScope;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1584785372, i4, -1, "androidx.media3.ui.compose.indicators.ProgressIndicator (ProgressIndicator.kt:47)");
                }
                content.invoke(ProgressStateWithTickCountKt.rememberProgressStateWithTickCount(player, i7, coroutineScope3, composerStartRestartGroup, i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 0), composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i5 = i7;
                coroutineScope2 = coroutineScope3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                }
                int i72 = i;
                CoroutineScope coroutineScope32 = coroutineScope;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                content.invoke(ProgressStateWithTickCountKt.rememberProgressStateWithTickCount(player, i72, coroutineScope32, composerStartRestartGroup, i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 0), composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 112));
                if (ComposerKt.isTraceInProgress()) {
                }
                i5 = i72;
                coroutineScope2 = coroutineScope32;
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            i5 = i;
            coroutineScope2 = coroutineScope;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.media3.ui.compose.indicators.ProgressIndicatorKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProgressIndicatorKt.ProgressIndicator$lambda$0(player, i5, coroutineScope2, content, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
