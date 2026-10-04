package com.revenuecat.purchases.p036ui.revenuecatui.components.tabs;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.tooling.preview.PreviewParameter;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.media3.exoplayer.RendererCapabilities;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabControlToggleComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.SwitchDefaults;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.SwitchKt;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: TabControlToggleView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u00012\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002"}, m1599d2 = {"TabControlToggleView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlToggleComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabControlToggleComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "TabControlToggleView_Gradient_Preview", "(Landroidx/compose/runtime/Composer;I)V", "TabControlToggleView_Preview", "checked", "", "(ZLandroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class TabControlToggleViewKt {
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TabControlToggleView(final TabControlToggleComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Object objRememberedValue;
        boolean z;
        Object objRememberedValue2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-732103151);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabControlToggleView)P(3,2,1)39@2101L58,43@2226L529,61@2989L15,62@3057L15,63@3128L15,64@3199L15,59@2848L377,41@2165L1067:TabControlToggleView.kt#fyu6fh");
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
                i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker2) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker2) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    paywallComponentInteractionTracker2 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt$$ExternalSyntheticLambda0
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                        }
                    };
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-732103151, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleView (TabControlToggleView.kt:38)");
                }
                composerStartRestartGroup.startReplaceGroup(251512316);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlToggleView.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt$TabControlToggleView$checked$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(state.getSelectedTabIndex() > 0);
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                boolean zTabControlToggleView$lambda$2 = TabControlToggleView$lambda$2((State) objRememberedValue);
                composerStartRestartGroup.startReplaceGroup(251516787);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlToggleView.kt#9igjgp");
                z = ((i3 & 112) != 32) | ((i3 & 7168) != 2048 || ((i3 & 4096) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker2))) | ((i3 & 14) == 4);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function1) new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt$TabControlToggleView$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            if (z2 == state.getSelectedTabIndex()) {
                                return;
                            }
                            PaywallState.Loaded.Components.update$default(state, null, Integer.valueOf(z2 ? 1 : 0), null, 5, null);
                            paywallComponentInteractionTracker2.track(new PaywallComponentInteractionData(PaywallComponentType.SWITCH, style.getComponentName(), z2 ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524280, (DefaultConstructorMarker) null));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifier5 = modifier4;
                composer2 = composerStartRestartGroup;
                SwitchKt.Switch(zTabControlToggleView$lambda$2, (Function1) objRememberedValue2, SizeKt.size$default(modifier4, style.getSize(), null, null, 6, null), null, false, SwitchDefaults.INSTANCE.m14094colorslRJcREg(ColorStyleKt.getForCurrentTheme(style.getThumbColorOn(), composerStartRestartGroup, 0), ColorStyleKt.getForCurrentTheme(style.getTrackColorOn(), composerStartRestartGroup, 0), null, 0L, ColorStyleKt.getForCurrentTheme(style.getThumbColorOff(), composerStartRestartGroup, 0), ColorStyleKt.getForCurrentTheme(style.getTrackColorOff(), composerStartRestartGroup, 0), null, 0L, null, null, null, 0L, null, null, null, 0L, composer2, 0, 1572864, 65484), null, composer2, 0, 88);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
            }
            final PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt.TabControlToggleView.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i6) {
                        TabControlToggleViewKt.TabControlToggleView(style, state, modifier3, paywallComponentInteractionTracker3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            if (ComposerKt.isTraceInProgress()) {
            }
            composerStartRestartGroup.startReplaceGroup(251512316);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlToggleView.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            composerStartRestartGroup.endReplaceGroup();
            boolean zTabControlToggleView$lambda$22 = TabControlToggleView$lambda$2((State) objRememberedValue);
            composerStartRestartGroup.startReplaceGroup(251516787);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabControlToggleView.kt#9igjgp");
            if ((i3 & 7168) != 2048) {
                z = ((i3 & 112) != 32) | ((i3 & 7168) != 2048 || ((i3 & 4096) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker2))) | ((i3 & 14) == 4);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z) {
                    objRememberedValue2 = (Function1) new Function1<Boolean, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt$TabControlToggleView$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            if (z2 == state.getSelectedTabIndex()) {
                                return;
                            }
                            PaywallState.Loaded.Components.update$default(state, null, Integer.valueOf(z2 ? 1 : 0), null, 5, null);
                            paywallComponentInteractionTracker2.track(new PaywallComponentInteractionData(PaywallComponentType.SWITCH, style.getComponentName(), z2 ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524280, (DefaultConstructorMarker) null));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifier52 = modifier4;
                    composer2 = composerStartRestartGroup;
                    SwitchKt.Switch(zTabControlToggleView$lambda$22, (Function1) objRememberedValue2, SizeKt.size$default(modifier4, style.getSize(), null, null, 6, null), null, false, SwitchDefaults.INSTANCE.m14094colorslRJcREg(ColorStyleKt.getForCurrentTheme(style.getThumbColorOn(), composerStartRestartGroup, 0), ColorStyleKt.getForCurrentTheme(style.getTrackColorOn(), composerStartRestartGroup, 0), null, 0L, ColorStyleKt.getForCurrentTheme(style.getThumbColorOff(), composerStartRestartGroup, 0), ColorStyleKt.getForCurrentTheme(style.getTrackColorOff(), composerStartRestartGroup, 0), null, 0L, null, null, null, 0L, null, null, null, 0L, composer2, 0, 1572864, 65484), null, composer2, 0, 88);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier52;
                }
            }
        }
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker32 = paywallComponentInteractionTracker2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabControlToggleView_Preview(@PreviewParameter(provider = CheckedPreviewProvider.class) final boolean z, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(259221708);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabControlToggleView_Preview)99@4480L60,80@3665L882:TabControlToggleView.kt#fyu6fh");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(259221708, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleView_Preview (TabControlToggleView.kt:78)");
            }
            TabControlToggleView(new TabControlToggleComponentStyle(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU()))), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU()))), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8179getGreen0d7_KjU()))), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8179getGreen0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU()))), null, 16, null), PreviewHelpersKt.previewEmptyState(Integer.valueOf(z ? 1 : 0), composerStartRestartGroup, 0, 0), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt.TabControlToggleView_Preview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    TabControlToggleViewKt.TabControlToggleView_Preview(z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabControlToggleView_Gradient_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-813499163);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabControlToggleView_Gradient_Preview)146@5893L19,121@5004L915:TabControlToggleView.kt#fyu6fh");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-813499163, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleView_Gradient_Preview (TabControlToggleView.kt:105)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8182getRed0d7_KjU()), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8179getGreen0d7_KjU()), 35.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8175getBlue0d7_KjU()), 100.0f)});
            TabControlToggleView(new TabControlToggleComponentStyle(new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(listListOf)), null, 2, null), new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(listListOf)), null, 2, null), new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, listListOf)), null, 2, null), new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(90.0f, listListOf)), null, 2, null), null, 16, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabControlToggleViewKt.TabControlToggleView_Gradient_Preview.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    TabControlToggleViewKt.TabControlToggleView_Gradient_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final boolean TabControlToggleView$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
