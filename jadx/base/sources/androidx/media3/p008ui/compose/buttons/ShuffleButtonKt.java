package androidx.media3.p008ui.compose.buttons;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.common.Player;
import androidx.media3.p008ui.compose.state.ShuffleButtonState;
import androidx.media3.p008ui.compose.state.ShuffleButtonStateKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShuffleButton.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001c\u0010\u0004\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0007¢\u0006\u0002\b\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, m1599d2 = {"ShuffleButton", "", "player", "Landroidx/media3/common/Player;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Landroidx/media3/ui/compose/state/ShuffleButtonState;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "(Landroidx/media3/common/Player;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "lib-ui-compose_release"}, m1600k = 2, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class ShuffleButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShuffleButton$lambda$0(Player player, Function3 function3, int i, Composer composer, int i2) {
        ShuffleButton(player, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ShuffleButton(final Player player, final Function3<? super ShuffleButtonState, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-12021950);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShuffleButton)P(1)36@1411L34,36@1446L9:ShuffleButton.kt#v3x2m3");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(player) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-12021950, i2, -1, "androidx.media3.ui.compose.buttons.ShuffleButton (ShuffleButton.kt:35)");
            }
            content.invoke(ShuffleButtonStateKt.rememberShuffleButtonState(player, composerStartRestartGroup, i2 & 14), composerStartRestartGroup, Integer.valueOf(i2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.media3.ui.compose.buttons.ShuffleButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShuffleButtonKt.ShuffleButton$lambda$0(player, content, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
