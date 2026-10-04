package com.revenuecat.purchases.p036ui.revenuecatui.components.pkg;

import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.PsExtractor;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.p036ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.PackageComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: PackageComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"PackageComponentView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/PackageComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/PackageComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class PackageComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:133:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void PackageComponentView(final PackageComponentStyle style, final PaywallState.Loaded.Components state, final Function2 clickHandler, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final PackageComponentStyle packageComponentStyle;
        Function2 function2;
        Function0 function0;
        final Modifier modifier3;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(1721763196);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PackageComponentView)P(4,3!1,2)25@1152L73,29@1284L131,36@1530L196,33@1421L1042:PackageComponentView.kt#axw9sz");
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
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(clickHandler) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= (i & 32768) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker3) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker3) ? 16384 : 8192;
            }
            if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    paywallComponentInteractionTracker3 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt$$ExternalSyntheticLambda0
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                        }
                    };
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1721763196, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentView (PackageComponentView.kt:24)");
                }
                int i6 = i3 & 14;
                int i7 = i3 & 112;
                if (PackageComponentStateKt.rememberUpdatedPackageComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT).getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker3;
                        final Modifier modifier4 = companion;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt.PackageComponentView.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i8) {
                                PackageComponentViewKt.PackageComponentView(style, state, clickHandler, modifier4, paywallComponentInteractionTracker4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                packageComponentStyle = style;
                function2 = clickHandler;
                Modifier modifier5 = companion;
                final PaywallComponentInteractionTracker paywallComponentInteractionTracker5 = paywallComponentInteractionTracker3;
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = state.getSelectedPackageInfo();
                String uniqueId = selectedPackageInfo != null ? selectedPackageInfo.getUniqueId() : null;
                String uniqueId2 = packageComponentStyle.getUniqueId();
                composerStartRestartGroup.startReplaceGroup(-1617515408);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PackageComponentView.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(uniqueId) | composerStartRestartGroup.changed(uniqueId2);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = Boolean.valueOf(!Intrinsics.areEqual(state.getSelectedPackageInfo() != null ? r0.getUniqueId() : null, packageComponentStyle.getUniqueId()));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                boolean zBooleanValue = ((Boolean) objRememberedValue).booleanValue();
                composerStartRestartGroup.endReplaceGroup();
                StackComponentStyle stackComponentStyle = packageComponentStyle.getStackComponentStyle();
                composerStartRestartGroup.startReplaceGroup(-1617496077);
                ComposerKt.sourceInformation(composerStartRestartGroup, "44@1912L500");
                if (packageComponentStyle.isSelectable()) {
                    composerStartRestartGroup.startReplaceGroup(-1617494943);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PackageComponentView.kt#9igjgp");
                    boolean z = ((57344 & i3) == 16384 || ((i3 & 32768) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker5))) | (i6 == 4) | (i7 == 32);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt$PackageComponentView$3$1
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
                                PaywallComponentInteractionTracker paywallComponentInteractionTracker6 = paywallComponentInteractionTracker5;
                                String componentName = packageComponentStyle.getComponentName();
                                Package rcPackage = packageComponentStyle.getRcPackage();
                                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo2 = state.getSelectedPackageInfo();
                                paywallComponentInteractionTracker6.track(PaywallComponentInteractionFactoriesKt.paywallPackageRowSelection(componentName, rcPackage, selectedPackageInfo2 != null ? selectedPackageInfo2.getRcPackage() : null, state.defaultPackageForPackageRowAnalytics()));
                                state.update(packageComponentStyle.getUniqueId());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function0 = (Function0) objRememberedValue2;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    function0 = null;
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-1617507471);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PackageComponentView.kt#9igjgp");
                boolean zChangedInstance = (i6 == 4) | composerStartRestartGroup.changedInstance(function2);
                PackageComponentViewKt$PackageComponentView$4$1 packageComponentViewKt$PackageComponentView$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || packageComponentViewKt$PackageComponentView$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    packageComponentViewKt$PackageComponentView$4$1RememberedValue = new PackageComponentViewKt$PackageComponentView$4$1(packageComponentStyle, function2, null);
                    composerStartRestartGroup.updateRememberedValue(packageComponentViewKt$PackageComponentView$4$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                StackComponentViewKt.StackComponentView(stackComponentStyle, state, (Function2) packageComponentViewKt$PackageComponentView$4$1RememberedValue, modifier5, function0, zBooleanValue, null, 0.0f, paywallComponentInteractionTracker5, composerStartRestartGroup, (i3 & 7280) | ((i3 << 12) & 234881024), PsExtractor.AUDIO_STREAM);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker3;
                packageComponentStyle = style;
                function2 = clickHandler;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                final PackageComponentStyle packageComponentStyle2 = packageComponentStyle;
                final Function2 function22 = function2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.pkg.PackageComponentViewKt.PackageComponentView.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) {
                        PackageComponentViewKt.PackageComponentView(packageComponentStyle2, state, function22, modifier3, paywallComponentInteractionTracker2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        if ((i3 & 9363) == 9362) {
            if (i5 == 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            int i62 = i3 & 14;
            int i72 = i3 & 112;
            if (PackageComponentStateKt.rememberUpdatedPackageComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT).getVisible()) {
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
