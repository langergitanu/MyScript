package com.myscript.nebo.discoverability.p024ui.compose;

import android.graphics.Rect;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.myscript.android.utils.ComposeViewManager;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TooltipComposableProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\bH\u0017¢\u0006\u0002\u0010\fR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/discoverability/ui/compose/TooltipComposableProviderImpl;", "Lcom/myscript/android/utils/ComposeViewManager$ComposableProvider;", "state", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "targetRect", "Landroid/graphics/Rect;", "onTooltipDismissed", "Lkotlin/Function0;", "", "<init>", "(Lcom/myscript/nebo/discoverability/ui/TooltipUIState;Landroid/graphics/Rect;Lkotlin/jvm/functions/Function0;)V", "ProvideComposableContent", "(Landroidx/compose/runtime/Composer;I)V", "discoverability_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TooltipComposableProviderImpl implements ComposeViewManager.ComposableProvider {
    public static final int $stable = 8;
    private final Function0<Unit> onTooltipDismissed;
    private final TooltipUIState state;
    private final Rect targetRect;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProvideComposableContent$lambda$0(TooltipComposableProviderImpl tooltipComposableProviderImpl, int i, Composer composer, int i2) {
        tooltipComposableProviderImpl.ProvideComposableContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public TooltipComposableProviderImpl(TooltipUIState tooltipUIState, Rect rect, Function0<Unit> onTooltipDismissed) {
        Intrinsics.checkNotNullParameter(onTooltipDismissed, "onTooltipDismissed");
        this.state = tooltipUIState;
        this.targetRect = rect;
        this.onTooltipDismissed = onTooltipDismissed;
    }

    @Override // com.myscript.android.utils.ComposeViewManager.ComposableProvider
    public void ProvideComposableContent(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(119059314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideComposableContent)12@543L61:TooltipComposableProviderImpl.kt#g50l23");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(119059314, i2, -1, "com.myscript.nebo.discoverability.ui.compose.TooltipComposableProviderImpl.ProvideComposableContent (TooltipComposableProviderImpl.kt:11)");
            }
            DiscoverabilityTooltipKt.DiscoverabilityTooltip(this.state, this.targetRect, this.onTooltipDismissed, composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.discoverability.ui.compose.TooltipComposableProviderImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TooltipComposableProviderImpl.ProvideComposableContent$lambda$0(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
