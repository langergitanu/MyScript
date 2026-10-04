package com.myscript.nebo.p022ai.presentation.compose.components;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BlinkingCursor.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u0084\u0002"}, m1599d2 = {"BlinkingCursor", "", "(Landroidx/compose/runtime/Composer;I)V", "nebo-ai_release", "alpha", ""}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BlinkingCursorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BlinkingCursor$lambda$1(int i, Composer composer, int i2) {
        BlinkingCursor(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BlinkingCursor(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(390005208);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BlinkingCursor)22@883L38,25@1042L249,38@1416L6,35@1297L162:BlinkingCursor.kt#ysqczk");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(390005208, i, -1, "com.myscript.nebo.ai.presentation.compose.components.BlinkingCursor (BlinkingCursor.kt:20)");
            }
            BoxKt.Box(BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.m2926sizeVpY3zN4(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(2), C1486Dp.m11017constructorimpl(18)), Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), BlinkingCursor$lambda$0(InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("", composerStartRestartGroup, 6, 0), 1.0f, 0.0f, AnimationSpecKt.m1903infiniteRepeatable9IiC70o$default(AnimationSpecKt.tween$default(500, 0, EasingKt.getLinearEasing(), 2, null), RepeatMode.Reverse, 0L, 4, null), "", composerStartRestartGroup, InfiniteTransition.$stable | 25008 | (InfiniteRepeatableSpec.$stable << 9), 0)), 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.BlinkingCursorKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlinkingCursorKt.BlinkingCursor$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float BlinkingCursor$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
