package com.revenuecat.purchases.p036ui.revenuecatui.components.tabs;

import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabControlButtonComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TabControlButtonView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m1599d2 = {"TabControlButtonView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlButtonComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlButtonComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class TabControlButtonViewKt {
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TabControlButtonView(final TabControlButtonComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
        boolean z;
        boolean z2;
        Object objRememberedValue;
        final Modifier modifier3;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-817335501);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabControlButtonView)P(3,2,1)28@1281L1962,21@979L2271:TabControlButtonView.kt#fyu6fh");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(style) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker4) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker4) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    paywallComponentInteractionTracker4 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlButtonViewKt$$ExternalSyntheticLambda0
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                        }
                    };
                }
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-817335501, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlButtonView (TabControlButtonView.kt:20)");
                }
                StackComponentStyle stack = style.getStack();
                C77782 c77782 = new C77782(null);
                composerStartRestartGroup.startReplaceGroup(80475210);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlButtonView.kt#9igjgp");
                z = false;
                int i6 = i3 & 112;
                boolean z3 = ((i3 & 14) != 4) | (i6 != 32);
                if ((i3 & 7168) != 2048 || ((i3 & 4096) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker2))) {
                    z = true;
                }
                z2 = z3 | z;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlButtonViewKt$TabControlButtonView$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            List tabIdsOrdered = style.getTabIdsOrdered();
                            int tabIndex = style.getTabIndex();
                            List list = tabIdsOrdered;
                            if (!list.isEmpty()) {
                                tabIndex = RangesKt.coerceIn(tabIndex, 0, CollectionsKt.getLastIndex(tabIdsOrdered));
                            }
                            if (!list.isEmpty()) {
                                int iCoerceIn = RangesKt.coerceIn(state.getSelectedTabIndex(), 0, CollectionsKt.getLastIndex(tabIdsOrdered));
                                if (iCoerceIn == tabIndex) {
                                    PaywallState.Loaded.Components.update$default(state, null, Integer.valueOf(tabIndex), null, 5, null);
                                    return;
                                } else {
                                    String str = (String) tabIdsOrdered.get(iCoerceIn);
                                    String tabId = style.getTabId();
                                    paywallComponentInteractionTracker2.track(PaywallComponentInteractionFactoriesKt.paywallTabControlButtonSelection(style.getTabsComponentName(), tabId, Integer.valueOf(iCoerceIn), Integer.valueOf(tabIndex), (String) style.getTabContextNamesById().get(str), (String) style.getTabContextNamesById().get(tabId), Integer.valueOf(style.getTabsDefaultTabIndex())));
                                }
                            } else {
                                paywallComponentInteractionTracker2.track(PaywallComponentInteractionFactoriesKt.paywallTabControlButtonSelection(style.getTabsComponentName(), style.getTabId(), null, null, null, null, null));
                            }
                            PaywallState.Loaded.Components.update$default(state, null, Integer.valueOf(tabIndex), null, 5, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i7 = i6 | RendererCapabilities.DECODER_SUPPORT_MASK | ((i3 << 3) & 7168) | ((i3 << 15) & 234881024);
                modifier3 = companion;
                StackComponentViewKt.StackComponentView(stack, state, c77782, modifier3, (Function0) objRememberedValue, false, null, 0.0f, paywallComponentInteractionTracker2, composerStartRestartGroup, i7, 224);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paywallComponentInteractionTracker3 = paywallComponentInteractionTracker2;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paywallComponentInteractionTracker3 = paywallComponentInteractionTracker4;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlButtonViewKt.TabControlButtonView.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        TabControlButtonViewKt.TabControlButtonView(style, state, modifier3, paywallComponentInteractionTracker3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i3 & 1171) == 1170) {
            if (i5 == 0) {
            }
            if (i4 != 0) {
            }
            paywallComponentInteractionTracker2 = paywallComponentInteractionTracker4;
            if (ComposerKt.isTraceInProgress()) {
            }
            StackComponentStyle stack2 = style.getStack();
            C77782 c777822 = new C77782(null);
            composerStartRestartGroup.startReplaceGroup(80475210);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlButtonView.kt#9igjgp");
            z = false;
            int i62 = i3 & 112;
            boolean z32 = ((i3 & 14) != 4) | (i62 != 32);
            if ((i3 & 7168) != 2048) {
                z = true;
                z2 = z32 | z;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlButtonViewKt$TabControlButtonView$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            List tabIdsOrdered = style.getTabIdsOrdered();
                            int tabIndex = style.getTabIndex();
                            List list = tabIdsOrdered;
                            if (!list.isEmpty()) {
                                tabIndex = RangesKt.coerceIn(tabIndex, 0, CollectionsKt.getLastIndex(tabIdsOrdered));
                            }
                            if (!list.isEmpty()) {
                                int iCoerceIn = RangesKt.coerceIn(state.getSelectedTabIndex(), 0, CollectionsKt.getLastIndex(tabIdsOrdered));
                                if (iCoerceIn == tabIndex) {
                                    PaywallState.Loaded.Components.update$default(state, null, Integer.valueOf(tabIndex), null, 5, null);
                                    return;
                                } else {
                                    String str = (String) tabIdsOrdered.get(iCoerceIn);
                                    String tabId = style.getTabId();
                                    paywallComponentInteractionTracker2.track(PaywallComponentInteractionFactoriesKt.paywallTabControlButtonSelection(style.getTabsComponentName(), tabId, Integer.valueOf(iCoerceIn), Integer.valueOf(tabIndex), (String) style.getTabContextNamesById().get(str), (String) style.getTabContextNamesById().get(tabId), Integer.valueOf(style.getTabsDefaultTabIndex())));
                                }
                            } else {
                                paywallComponentInteractionTracker2.track(PaywallComponentInteractionFactoriesKt.paywallTabControlButtonSelection(style.getTabsComponentName(), style.getTabId(), null, null, null, null, null));
                            }
                            PaywallState.Loaded.Components.update$default(state, null, Integer.valueOf(tabIndex), null, 5, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    composerStartRestartGroup.endReplaceGroup();
                    int i72 = i62 | RendererCapabilities.DECODER_SUPPORT_MASK | ((i3 << 3) & 7168) | ((i3 << 15) & 234881024);
                    modifier3 = companion;
                    StackComponentViewKt.StackComponentView(stack2, state, c777822, modifier3, (Function0) objRememberedValue, false, null, 0.0f, paywallComponentInteractionTracker2, composerStartRestartGroup, i72, 224);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    paywallComponentInteractionTracker3 = paywallComponentInteractionTracker2;
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlButtonViewKt$TabControlButtonView$2 */
    /* JADX INFO: compiled from: TabControlButtonView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlButtonViewKt$TabControlButtonView$2", m1609f = "TabControlButtonView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77782 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77782(Continuation<? super C77782> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77782(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77782) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }
}
