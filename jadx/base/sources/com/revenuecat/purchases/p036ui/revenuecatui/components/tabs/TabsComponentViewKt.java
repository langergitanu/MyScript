package com.revenuecat.purchases.p036ui.revenuecatui.components.tabs;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.p036ui.revenuecatui.components.LocalizedTextPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedOverride;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.ShadowKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabControlButtonComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabControlStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyListKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyMapKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResultKt;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.PartialTextComponent;
import com.revenuecat.purchases.paywalls.components.common.ComponentOverride;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: TabsComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aU\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0013\u001a\u0094\u0001\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, m1599d2 = {"DURATION_MS_CROSS_FADE", "", "TabsComponentView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TabsComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "TabsComponentView_Preview", "(Landroidx/compose/runtime/Composer;I)V", "previewStackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "children", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", TypedValues.Custom.S_DIMENSION, "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "visible", "", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "spacing", "Landroidx/compose/ui/unit/Dp;", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "tabIndex", "previewStackComponentStyle-gNPyAyM", "(Ljava/util/List;Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;FLcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Ljava/lang/Integer;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class TabsComponentViewKt {
    private static final int DURATION_MS_CROSS_FADE = 220;

    /* JADX WARN: Removed duplicated region for block: B:131:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TabsComponentView(final TabsComponentStyle style, final PaywallState.Loaded.Components components, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> clickHandler, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        TabsComponentState tabsComponentStateRememberUpdatedTabsComponentState;
        String id;
        Object objRememberedValue;
        MutableState mutableState;
        boolean zChanged;
        TabsComponentViewKt$TabsComponentView$2$1 tabsComponentViewKt$TabsComponentView$2$1RememberedValue;
        final TabsComponentState tabsComponentState;
        String str;
        int i5;
        final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2;
        final Modifier modifier3;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final PaywallState.Loaded.Components state = components;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1956395062);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabsComponentView)P(4,3!1,2)81@5039L93,93@5863L42,94@5959L329,94@5910L378,112@6748L31,113@6825L35,115@6937L49,121@7241L389,108@6577L1053:TabsComponentView.kt#fyu6fh");
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
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= (32768 & i) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker3) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker3) ? 16384 : 8192;
            }
            if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    paywallComponentInteractionTracker3 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$$ExternalSyntheticLambda0
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                        }
                    };
                }
                final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1956395062, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentView (TabsComponentView.kt:79)");
                }
                int i7 = i3 & 14;
                int i8 = i3 & 112;
                tabsComponentStateRememberUpdatedTabsComponentState = TabsComponentStateKt.rememberUpdatedTabsComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
                id = ((TabsComponentStyle.Tab) style.getTabs().get(RangesKt.coerceIn(state.getSelectedTabIndex(), (ClosedRange<Integer>) new IntRange(0, CollectionsKt.getLastIndex(style.getTabs()))))).getId();
                composerStartRestartGroup.startReplaceGroup(-389992211);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                Boolean boolValueOf = Boolean.valueOf(tabsComponentStateRememberUpdatedTabsComponentState.getVisible());
                composerStartRestartGroup.startReplaceGroup(-389988852);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
                zChanged = (i7 != 4) | composerStartRestartGroup.changed(tabsComponentStateRememberUpdatedTabsComponentState) | composerStartRestartGroup.changed(id) | (i8 != 32);
                tabsComponentViewKt$TabsComponentView$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || tabsComponentViewKt$TabsComponentView$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    tabsComponentState = tabsComponentStateRememberUpdatedTabsComponentState;
                    str = id;
                    i5 = 0;
                    tabsComponentViewKt$TabsComponentView$2$1RememberedValue = new TabsComponentViewKt$TabsComponentView$2$1(tabsComponentState, str, mutableState, style, state, null);
                    composerStartRestartGroup.updateRememberedValue(tabsComponentViewKt$TabsComponentView$2$1RememberedValue);
                } else {
                    tabsComponentState = tabsComponentStateRememberUpdatedTabsComponentState;
                    str = id;
                    i5 = 0;
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(boolValueOf, str, (Function2) tabsComponentViewKt$TabsComponentView$2$1RememberedValue, composerStartRestartGroup, i5);
                if (tabsComponentState.getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier4 = companion;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView.3
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

                            public final void invoke(Composer composer2, int i9) {
                                TabsComponentViewKt.TabsComponentView(style, components, clickHandler, modifier4, paywallComponentInteractionTracker4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                state = components;
                function2 = clickHandler;
                Modifier modifier5 = companion;
                BackgroundStyles background = tabsComponentState.getBackground();
                composerStartRestartGroup.startReplaceGroup(-389975866);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*104@6380L27");
                BackgroundStyle backgroundStyleRememberBackgroundStyle = background == null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composerStartRestartGroup, i5);
                composerStartRestartGroup.endReplaceGroup();
                BorderStyles border = tabsComponentState.getBorder();
                composerStartRestartGroup.startReplaceGroup(-389973429);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*105@6456L32");
                BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, i5);
                composerStartRestartGroup.endReplaceGroup();
                ShadowStyles shadow = tabsComponentState.getShadow();
                composerStartRestartGroup.startReplaceGroup(-389970837);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*106@6537L32");
                ShadowStyle shadowStyleRememberShadowStyle = shadow == null ? null : ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, i5);
                composerStartRestartGroup.endReplaceGroup();
                Integer numValueOf = Integer.valueOf(state.getSelectedTabIndex());
                Modifier modifierPadding = PaddingKt.padding(modifier5, tabsComponentState.getMargin());
                composerStartRestartGroup.startReplaceGroup(-389963902);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(tabsComponentState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView$4$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return ShadowKt.shadow(applyIfNotNull, it, tabsComponentState.getShape());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(modifierPadding, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2);
                composerStartRestartGroup.startReplaceGroup(-389961434);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(tabsComponentState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function2) new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView$5$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return BackgroundKt.background(applyIfNotNull, it, tabsComponentState.getShape());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierClip = ClipKt.clip(ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull, backgroundStyleRememberBackgroundStyle, (Function2) objRememberedValue3), tabsComponentState.getShape());
                composerStartRestartGroup.startReplaceGroup(-389957836);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
                boolean zChanged4 = composerStartRestartGroup.changed(tabsComponentState);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView$6$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return PaddingKt.m2854padding3ABfNKs(BorderKt.border(applyIfNotNull, it, tabsComponentState.getShape()), it.m13932getWidthD9Ej5fM());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                AnimatedContentKt.AnimatedContent(numValueOf, PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(modifierClip, borderStyleRememberBorderStyle, (Function2) objRememberedValue4), tabsComponentState.getPadding()), new Function1<AnimatedContentTransitionScope<Integer>, ContentTransform>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView.7
                    @Override // kotlin.jvm.functions.Function1
                    public final ContentTransform invoke(AnimatedContentTransitionScope<Integer> AnimatedContent) {
                        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(TabsComponentViewKt.DURATION_MS_CROSS_FADE, 0, null, 4, null), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(TabsComponentViewKt.DURATION_MS_CROSS_FADE, 0, null, 6, null), 0.0f, 2, null));
                    }
                }, null, null, null, ComposableLambdaKt.rememberComposableLambda(-867411776, true, new Function4<AnimatedContentScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView.8
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, Integer num, Composer composer2, Integer num2) {
                        invoke(animatedContentScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(AnimatedContentScope AnimatedContent, int i9, Composer composer2, int i10) {
                        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                        ComposerKt.sourceInformation(composer2, "C124@7425L199:TabsComponentView.kt#fyu6fh");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-867411776, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentView.<anonymous> (TabsComponentView.kt:123)");
                        }
                        StackComponentViewKt.StackComponentView(((TabsComponentStyle.Tab) tabsComponentState.getTabs().get(RangesKt.coerceIn(i9, (ClosedRange<Integer>) new IntRange(0, CollectionsKt.getLastIndex(tabsComponentState.getTabs()))))).getStack(), state, function2, null, null, false, null, 0.0f, paywallComponentInteractionTracker4, composer2, 0, 248);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 1573248, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker3;
                function2 = clickHandler;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView.9
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

                    public final void invoke(Composer composer2, int i9) {
                        TabsComponentViewKt.TabsComponentView(style, state, function2, modifier3, paywallComponentInteractionTracker2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            if (i6 == 0) {
            }
            if (i4 != 0) {
            }
            final PaywallComponentInteractionTracker paywallComponentInteractionTracker42 = paywallComponentInteractionTracker3;
            if (ComposerKt.isTraceInProgress()) {
            }
            int i72 = i3 & 14;
            int i82 = i3 & 112;
            tabsComponentStateRememberUpdatedTabsComponentState = TabsComponentStateKt.rememberUpdatedTabsComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
            id = ((TabsComponentStyle.Tab) style.getTabs().get(RangesKt.coerceIn(state.getSelectedTabIndex(), (ClosedRange<Integer>) new IntRange(0, CollectionsKt.getLastIndex(style.getTabs()))))).getId();
            composerStartRestartGroup.startReplaceGroup(-389992211);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            mutableState = (MutableState) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            Boolean boolValueOf2 = Boolean.valueOf(tabsComponentStateRememberUpdatedTabsComponentState.getVisible());
            composerStartRestartGroup.startReplaceGroup(-389988852);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TabsComponentView.kt#9igjgp");
            zChanged = (i72 != 4) | composerStartRestartGroup.changed(tabsComponentStateRememberUpdatedTabsComponentState) | composerStartRestartGroup.changed(id) | (i82 != 32);
            tabsComponentViewKt$TabsComponentView$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                tabsComponentState = tabsComponentStateRememberUpdatedTabsComponentState;
                str = id;
                i5 = 0;
                tabsComponentViewKt$TabsComponentView$2$1RememberedValue = new TabsComponentViewKt$TabsComponentView$2$1(tabsComponentState, str, mutableState, style, state, null);
                composerStartRestartGroup.updateRememberedValue(tabsComponentViewKt$TabsComponentView$2$1RememberedValue);
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(boolValueOf2, str, (Function2) tabsComponentViewKt$TabsComponentView$2$1RememberedValue, composerStartRestartGroup, i5);
                if (tabsComponentState.getVisible()) {
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TabsComponentView_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1844948686);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabsComponentView_Preview)284@13805L19,205@10509L3350:TabsComponentView.kt#fyu6fh");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1844948686, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentView_Preview (TabsComponentView.kt:137)");
            }
            PresentedOverride presentedOverride = new PresentedOverride(CollectionsKt.listOf(ComponentOverride.Condition.Selected.INSTANCE), (PresentedPartial) ResultKt.getOrThrow(LocalizedTextPartial.INSTANCE.invoke(new PartialTextComponent((Boolean) null, (String) null, (ColorScheme) null, (ColorScheme) null, (String) null, FontWeight.EXTRA_BOLD, (Integer) null, (Integer) null, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, 4063, (DefaultConstructorMarker) null), NonEmptyMapKt.nonEmptyMapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), NonEmptyMapKt.nonEmptyMapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("dummy")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("dummy"))), new Pair[0])), new Pair[0]), MapsKt.emptyMap(), MapsKt.emptyMap())));
            float f = 8;
            StackComponentStyle stackComponentStyleM14015previewStackComponentStylegNPyAyM$default = m14015previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf((Object[]) new TabControlButtonComponentStyle[]{new TabControlButtonComponentStyle(0, "t0", m14015previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle("Tab 1", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : 0, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : CollectionsKt.listOf(presentedOverride))), null, false, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), 0.0f, null, null, null, null, null, null, null, 4086, null), null, null, null, null, 0, 248, null), new TabControlButtonComponentStyle(1, "t1", m14015previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle("Tab 2", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : 1, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : CollectionsKt.listOf(presentedOverride))), null, false, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), 0.0f, null, null, null, null, null, null, null, 4086, null), null, null, null, null, 0, 248, null), new TabControlButtonComponentStyle(2, "t2", m14015previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle("Tab 3", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : 2, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : CollectionsKt.listOf(presentedOverride))), null, false, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), 0.0f, null, null, null, null, null, null, null, 4086, null), null, null, null, null, 0, 248, null)}), new Dimension.Horizontal(VerticalAlignment.CENTER, FlexDistribution.CENTER), false, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f), null, null, null, null, null, null, null, 4068, null);
            float f2 = 16;
            TabsComponentView(new TabsComponentStyle(true, new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f2)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f2)), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8180getLightGray0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8177getDarkGray0d7_KjU()))))), new Shape.Rectangle(new CornerRadiuses.C7411Dp(16.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(f), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU()))), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU()))), C1486Dp.m11017constructorimpl(6), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(10), null), new TabControlStyle.Buttons(m14015previewStackComponentStylegNPyAyM$default(CollectionsKt.emptyList(), null, false, null, 0.0f, null, null, null, null, null, null, null, 4094, null)), NonEmptyListKt.nonEmptyListOf(new TabsComponentStyle.Tab("tab1", m14015previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(stackComponentStyleM14015previewStackComponentStylegNPyAyM$default, PreviewHelpersKt.previewTextComponentStyle("Tab 1 content", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), null, false, null, 0.0f, BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU()))))), null, null, null, null, null, null, 4062, null)), new TabsComponentStyle.Tab("tab2", m14015previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(stackComponentStyleM14015previewStackComponentStylegNPyAyM$default, PreviewHelpersKt.previewTextComponentStyle("Tab 2 content", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), null, false, null, 0.0f, BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8179getGreen0d7_KjU()))))), null, null, null, null, null, null, 4062, null)), new TabsComponentStyle.Tab("tab3", m14015previewStackComponentStylegNPyAyM$default(CollectionsKt.listOf(stackComponentStyleM14015previewStackComponentStylegNPyAyM$default, PreviewHelpersKt.previewTextComponentStyle("Tab 3 content", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), null, false, null, 0.0f, BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU()))))), null, null, null, null, null, null, 4062, null))), CollectionsKt.emptyList(), null, 2048, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C77881(null), null, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt.TabsComponentView_Preview.2
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
                    TabsComponentViewKt.TabsComponentView_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView_Preview$1 */
    /* JADX INFO: compiled from: TabsComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.tabs.TabsComponentViewKt$TabsComponentView_Preview$1", m1609f = "TabsComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C77881 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C77881(Continuation<? super C77881> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C77881(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C77881) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: previewStackComponentStyle-gNPyAyM$default, reason: not valid java name */
    static /* synthetic */ StackComponentStyle m14015previewStackComponentStylegNPyAyM$default(List list, Dimension dimension, boolean z, Size size, float f, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            dimension = new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER);
        }
        if ((i & 4) != 0) {
            z = true;
        }
        return m14014previewStackComponentStylegNPyAyM(list, dimension, z, (i & 8) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE) : size, (i & 16) != 0 ? C1486Dp.m11017constructorimpl(0) : f, (i & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8183getTransparent0d7_KjU())), null, 2, null))) : backgroundStyles, (i & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues, (i & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues2, (i & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)) : shape, (i & 512) != 0 ? null : borderStyles, (i & 1024) != 0 ? null : shadowStyles, (i & 2048) != 0 ? null : num);
    }

    /* JADX INFO: renamed from: previewStackComponentStyle-gNPyAyM, reason: not valid java name */
    private static final StackComponentStyle m14014previewStackComponentStylegNPyAyM(List<? extends ComponentStyle> list, Dimension dimension, boolean z, Size size, float f, BackgroundStyles backgroundStyles, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, Integer num) {
        return new StackComponentStyle(list, dimension, z, size, f, backgroundStyles, paddingValues, paddingValues2, shape, borderStyles, shadowStyles, null, null, null, null, num, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
    }
}
