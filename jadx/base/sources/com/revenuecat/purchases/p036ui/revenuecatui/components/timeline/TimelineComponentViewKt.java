package com.revenuecat.purchases.p036ui.revenuecatui.components.timeline;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.ZIndexModifierKt;
import androidx.compose.p004ui.draw.ShadowKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.layout.LayoutKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.tooling.preview.PreviewParameter;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.ConstraintSetForInlineDsl;
import androidx.constraintlayout.compose.LayoutReference;
import androidx.constraintlayout.compose.Measurer;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.iconcomponent.IconComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.OverlayKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.text.TextComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.timeline.TimelineComponentState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.SizeConstraintExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ImagePreviewsKt;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: TimelineComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\n\u001a\u0017\u0010\r\u001a\u00020\u00012\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010\u0010\u001a\u0017\u0010\u0011\u001a\u00020\u00012\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a&\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002\u001a:\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001b\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a3\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\b\u0002\u0010)\u001a\u00020\u001e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0016H\u0003¢\u0006\u0002\u0010+\u001a3\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020,2\u0006\u0010(\u001a\u00020,2\b\b\u0002\u0010)\u001a\u00020\u001e2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0016H\u0003¢\u0006\u0002\u0010-\u001a\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020%0/2\b\b\u0002\u00100\u001a\u00020\u001aH\u0003¢\u0006\u0002\u00101\u001am\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00182\b\b\u0002\u00104\u001a\u00020\u00182\b\b\u0002\u00105\u001a\u00020\u00182\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010:\u001a\u00020\u001a2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020%0/H\u0003¢\u0006\u0002\u0010<\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006=²\u0006\f\u0010>\u001a\u0004\u0018\u00010?X\u008a\u0084\u0002"}, m1599d2 = {"TimelineComponentView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TimelineComponentView_Align_TitleAndDescription_Preview", "(Landroidx/compose/runtime/Composer;I)V", "TimelineComponentView_Align_Title_Preview", "TimelineComponentView_Connector_Margin_Preview", "TimelineComponentView_Size_Preview", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "(Lcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/runtime/Composer;I)V", "TimelineComponentView_TextSize_Preview", "textWidth", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "(Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;Landroidx/compose/runtime/Composer;I)V", "previewConnectorStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;", "width", "", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "color", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "previewIcon", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "Landroidx/compose/ui/graphics/Color;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "paddingValues", "previewIcon-6xbWgXg", "(JJLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;", "previewItem", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "title", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "description", "icon", "connector", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/IconComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ConnectorStyle;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle$ItemStyle;", "previewItems", "", "connectorMargins", "(Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)Ljava/util/List;", "previewStyle", "itemSpacing", "textSpacing", "columnGutter", "iconAlignment", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "visible", "", "padding", FirebaseAnalytics.Param.ITEMS, "(IIILcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Ljava/util/List;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TimelineComponentStyle;", "revenuecatui_defaultsRelease", "biggestIconWidth", "Landroidx/compose/ui/unit/Dp;"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class TimelineComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TimelineComponentView(final TimelineComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final TimelineComponentState timelineComponentStateRememberUpdatedTimelineComponentState;
        Object obj;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(2108618390);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView)P(2,1)66@3728L97,75@3887L6062:TimelineComponentView.kt#1cibm8");
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
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & 147) == 146 || !composerStartRestartGroup.getSkipping()) {
                if (i4 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2108618390, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView (TimelineComponentView.kt:65)");
                }
                timelineComponentStateRememberUpdatedTimelineComponentState = TimelineComponentStateKt.rememberUpdatedTimelineComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
                if (timelineComponentStateRememberUpdatedTimelineComponentState.getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier3 = modifier2;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i5) {
                                TimelineComponentViewKt.TimelineComponentView(style, state, modifier3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                Modifier modifierPadding = PaddingKt.padding(PaddingKt.padding(SizeKt.size$default(modifier2, timelineComponentStateRememberUpdatedTimelineComponentState.getSize(), null, null, 6, null), timelineComponentStateRememberUpdatedTimelineComponentState.getMargin()), timelineComponentStateRememberUpdatedTimelineComponentState.getPadding());
                composerStartRestartGroup.startReplaceGroup(-1003410150);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(ConstraintLayout)P(3,4!1,2)414@18758L7,415@18785L30,416@18832L36,417@18903L34,418@18962L45,419@19033L53,421@19112L652,440@19793L288,449@20174L33,451@20266L729,448@20116L885:ConstraintLayout.kt#fysre8");
                composerStartRestartGroup.startReplaceGroup(212064437);
                ComposerKt.sourceInformation(composerStartRestartGroup, "359@16265L33,360@16347L33,361@16401L70,362@16501L53,363@16587L101,366@16711L54,368@16821L1432,399@18263L441");
                composerStartRestartGroup.endReplaceGroup();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density = (Density) objConsume;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212145251, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Measurer(density);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final Measurer measurer = (Measurer) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212146761, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new ConstraintLayoutScope();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212149031, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState = (MutableState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212150930, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final ConstraintSetForInlineDsl constraintSetForInlineDsl = (ConstraintSetForInlineDsl) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212153210, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212156337, "CC(remember):ConstraintLayout.kt#9igjgp");
                final int i5 = 257;
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(measurer) | composerStartRestartGroup.changed(257);
                MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                    obj = null;
                    measurePolicyRememberedValue = new MeasurePolicy() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$2
                        @Override // androidx.compose.p004ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo1747measure3p2s80s(MeasureScope measureScope, final List<? extends Measurable> list, long j) {
                            mutableState2.getValue();
                            long jM11417performMeasure2eBlSMk = measurer.m11417performMeasure2eBlSMk(j, measureScope.getLayoutDirection(), constraintSetForInlineDsl, list, i5);
                            mutableState.getValue();
                            int iM11188getWidthimpl = IntSize.m11188getWidthimpl(jM11417performMeasure2eBlSMk);
                            int iM11187getHeightimpl = IntSize.m11187getHeightimpl(jM11417performMeasure2eBlSMk);
                            final Measurer measurer2 = measurer;
                            return MeasureScope.layout$default(measureScope, iM11188getWidthimpl, iM11187getHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    measurer2.performLayout(placementScope, list);
                                }
                            }, 4, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                } else {
                    obj = null;
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212177765, "CC(remember):ConstraintLayout.kt#9igjgp");
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$3
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
                            mutableState.setValue(Boolean.valueOf(!((Boolean) r0.getValue()).booleanValue()));
                            constraintSetForInlineDsl.setKnownDirty(true);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                final Function0 function0 = (Function0) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 212189702, "CC(remember):ConstraintLayout.kt#9igjgp");
                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(measurer);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            ToolingUtilsKt.setDesignInfoProvider(semanticsPropertyReceiver, measurer);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                LayoutKt.MultiMeasureLayout(SemanticsModifierKt.semantics$default(modifierPadding, false, (Function1) objRememberedValue7, 1, obj), ComposableLambdaKt.rememberComposableLambda(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt$TimelineComponentView$$inlined$ConstraintLayout$5
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
                        float fM11017constructorimpl;
                        Iterator it;
                        float fM11017constructorimpl2;
                        float fM11017constructorimpl3;
                        int i7;
                        PaddingValues paddingValuesM2847PaddingValues0680j_4;
                        IconComponentStyle icon;
                        Size size;
                        SizeConstraint height;
                        C1486Dp c1486DpDpOrNull;
                        ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor;
                        ConstrainedLayoutReference constrainedLayoutReference;
                        ConstrainedLayoutReference constrainedLayoutReference2;
                        Composer composer4 = composer3;
                        ComposerKt.sourceInformation(composer4, "C457@20608L9,462@20943L28:ConstraintLayout.kt#fysre8");
                        int i8 = 2;
                        if ((i6 & 3) != 2 || !composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1200550679, i6, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                            }
                            mutableState2.setValue(Unit.INSTANCE);
                            int helpersHashCode = constraintLayoutScope.getHelpersHashCode();
                            constraintLayoutScope.reset();
                            ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                            composer4.startReplaceGroup(-425493899);
                            ComposerKt.sourceInformation(composer4, "C83@4232L174:TimelineComponentView.kt#1cibm8");
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            composer4.startReplaceGroup(-290820944);
                            ComposerKt.sourceInformation(composer4, "CC(remember):TimelineComponentView.kt#9igjgp");
                            Object objRememberedValue8 = composer4.rememberedValue();
                            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue8 = SnapshotStateKt.derivedStateOf(new C7818x84728ef8(timelineComponentStateRememberUpdatedTimelineComponentState));
                                composer4.updateRememberedValue(objRememberedValue8);
                            }
                            State state2 = (State) objRememberedValue8;
                            composer4.endReplaceGroup();
                            composer4.startReplaceGroup(-290812107);
                            ComposerKt.sourceInformation(composer4, "*100@4937L80,98@4807L225,106@5108L699,105@5046L987,131@6191L788,128@6047L947");
                            for (TimelineComponentState.ItemState itemState : timelineComponentStateRememberUpdatedTimelineComponentState.getItems()) {
                                ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent3 = constrainedLayoutReferencesCreateRefs.component3();
                                ConstrainedLayoutReference constrainedLayoutReferenceComponent4 = constrainedLayoutReferencesCreateRefs.component4();
                                ConstraintLayoutScope constraintLayoutScope3 = constraintLayoutScope2;
                                LayoutReference[] layoutReferenceArr = new LayoutReference[3];
                                layoutReferenceArr[0] = constrainedLayoutReferenceComponent1;
                                layoutReferenceArr[1] = constrainedLayoutReferenceComponent2;
                                layoutReferenceArr[i8] = constrainedLayoutReferenceComponent3;
                                ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchorM11311createBottomBarrier3ABfNKs$default = ConstraintLayoutBaseScope.m11311createBottomBarrier3ABfNKs$default(constraintLayoutScope3, layoutReferenceArr, 0.0f, i8, null);
                                ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor2 = (ConstraintLayoutBaseScope.HorizontalAnchor) CollectionsKt.lastOrNull((List) arrayList);
                                arrayList2.add(constrainedLayoutReferenceComponent1);
                                int i9 = helpersHashCode;
                                ArrayList arrayList3 = arrayList2;
                                arrayList.add(ConstraintLayoutBaseScope.m11311createBottomBarrier3ABfNKs$default(constraintLayoutScope3, new LayoutReference[]{constrainedLayoutReferenceComponent4}, 0.0f, i8, null));
                                Modifier modifierM2910height3ABfNKs = androidx.compose.foundation.layout.SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(timelineComponentStateRememberUpdatedTimelineComponentState.getItemSpacing()));
                                composer4.startReplaceGroup(-290798478);
                                ComposerKt.sourceInformation(composer4, "CC(remember):TimelineComponentView.kt#9igjgp");
                                boolean zChanged = composer4.changed(horizontalAnchorM11311createBottomBarrier3ABfNKs$default);
                                TimelineComponentViewKt$TimelineComponentView$2$1$1 timelineComponentViewKt$TimelineComponentView$2$1$1RememberedValue = composer4.rememberedValue();
                                if (zChanged || timelineComponentViewKt$TimelineComponentView$2$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    timelineComponentViewKt$TimelineComponentView$2$1$1RememberedValue = new TimelineComponentViewKt$TimelineComponentView$2$1$1(horizontalAnchorM11311createBottomBarrier3ABfNKs$default);
                                    composer4.updateRememberedValue(timelineComponentViewKt$TimelineComponentView$2$1$1RememberedValue);
                                }
                                composer4.endReplaceGroup();
                                SpacerKt.Spacer(constraintLayoutScope2.constrainAs(modifierM2910height3ABfNKs, constrainedLayoutReferenceComponent4, (Function1) timelineComponentViewKt$TimelineComponentView$2$1$1RememberedValue), composer4, 0);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                composer4.startReplaceGroup(-290792387);
                                ComposerKt.sourceInformation(composer4, "CC(remember):TimelineComponentView.kt#9igjgp");
                                boolean zChanged2 = composer4.changed(timelineComponentStateRememberUpdatedTimelineComponentState) | composer4.changed(horizontalAnchor2) | composer4.changed(constrainedLayoutReferenceComponent2) | composer4.changed(constrainedLayoutReferenceComponent3);
                                TimelineComponentViewKt$TimelineComponentView$2$2$1 timelineComponentViewKt$TimelineComponentView$2$2$1RememberedValue = composer4.rememberedValue();
                                if (zChanged2 || timelineComponentViewKt$TimelineComponentView$2$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    TimelineComponentViewKt$TimelineComponentView$2$2$1 timelineComponentViewKt$TimelineComponentView$2$2$1 = new TimelineComponentViewKt$TimelineComponentView$2$2$1(timelineComponentStateRememberUpdatedTimelineComponentState, horizontalAnchor2, constrainedLayoutReferenceComponent2, constrainedLayoutReferenceComponent3, state2);
                                    horizontalAnchor = horizontalAnchor2;
                                    constrainedLayoutReference = constrainedLayoutReferenceComponent2;
                                    constrainedLayoutReference2 = constrainedLayoutReferenceComponent3;
                                    timelineComponentViewKt$TimelineComponentView$2$2$1RememberedValue = timelineComponentViewKt$TimelineComponentView$2$2$1;
                                    composer4.updateRememberedValue(timelineComponentViewKt$TimelineComponentView$2$2$1RememberedValue);
                                } else {
                                    constrainedLayoutReference = constrainedLayoutReferenceComponent2;
                                    constrainedLayoutReference2 = constrainedLayoutReferenceComponent3;
                                    horizontalAnchor = horizontalAnchor2;
                                }
                                composer4.endReplaceGroup();
                                Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent1, (Function1) timelineComponentViewKt$TimelineComponentView$2$2$1RememberedValue);
                                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierConstrainAs);
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer4);
                                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer4, 341218704, "C121@5841L178:TimelineComponentView.kt#1cibm8");
                                IconComponentViewKt.IconComponentView(itemState.getIcon(), state, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), composer3, 0, 0);
                                composer4 = composer3;
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                TextComponentStyle title = itemState.getTitle();
                                PaywallState.Loaded.Components components = state;
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                composer4.startReplaceGroup(-290757642);
                                ComposerKt.sourceInformation(composer4, "CC(remember):TimelineComponentView.kt#9igjgp");
                                boolean zChanged3 = composer4.changed(timelineComponentStateRememberUpdatedTimelineComponentState) | composer4.changed(constrainedLayoutReferenceComponent1) | composer4.changed(horizontalAnchor);
                                TimelineComponentViewKt$TimelineComponentView$2$4$1 timelineComponentViewKt$TimelineComponentView$2$4$1RememberedValue = composer4.rememberedValue();
                                if (zChanged3 || timelineComponentViewKt$TimelineComponentView$2$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    timelineComponentViewKt$TimelineComponentView$2$4$1RememberedValue = new TimelineComponentViewKt$TimelineComponentView$2$4$1(timelineComponentStateRememberUpdatedTimelineComponentState, constrainedLayoutReferenceComponent1, horizontalAnchor);
                                    composer4.updateRememberedValue(timelineComponentViewKt$TimelineComponentView$2$4$1RememberedValue);
                                }
                                composer4.endReplaceGroup();
                                TextComponentViewKt.TextComponentView(title, components, constraintLayoutScope2.constrainAs(companion2, constrainedLayoutReference, (Function1) timelineComponentViewKt$TimelineComponentView$2$4$1RememberedValue), null, composer4, 0, 8);
                                TextComponentStyle description = itemState.getDescription();
                                composer4.startReplaceGroup(-290731176);
                                ComposerKt.sourceInformation(composer4, "*155@7202L325,152@7048L498");
                                if (description != null) {
                                    PaywallState.Loaded.Components components2 = state;
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    composer4.startReplaceGroup(149598086);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):TimelineComponentView.kt#9igjgp");
                                    boolean zChanged4 = composer4.changed(constrainedLayoutReference) | composer4.changed(timelineComponentStateRememberUpdatedTimelineComponentState);
                                    TimelineComponentViewKt$TimelineComponentView$2$5$1$1 timelineComponentViewKt$TimelineComponentView$2$5$1$1RememberedValue = composer4.rememberedValue();
                                    if (zChanged4 || timelineComponentViewKt$TimelineComponentView$2$5$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        timelineComponentViewKt$TimelineComponentView$2$5$1$1RememberedValue = new TimelineComponentViewKt$TimelineComponentView$2$5$1$1(constrainedLayoutReference, timelineComponentStateRememberUpdatedTimelineComponentState);
                                        composer4.updateRememberedValue(timelineComponentViewKt$TimelineComponentView$2$5$1$1RememberedValue);
                                    }
                                    composer4.endReplaceGroup();
                                    TextComponentViewKt.TextComponentView(description, components2, constraintLayoutScope2.constrainAs(companion3, constrainedLayoutReference2, (Function1) timelineComponentViewKt$TimelineComponentView$2$5$1$1RememberedValue), null, composer4, 0, 8);
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                composer4.endReplaceGroup();
                                helpersHashCode = i9;
                                arrayList2 = arrayList3;
                                i8 = 2;
                            }
                            int i10 = helpersHashCode;
                            ArrayList arrayList4 = arrayList2;
                            composer4.endReplaceGroup();
                            composer4.startReplaceGroup(-290710782);
                            ComposerKt.sourceInformation(composer4, "");
                            Iterator it2 = timelineComponentStateRememberUpdatedTimelineComponentState.getItems().iterator();
                            int i11 = 0;
                            while (it2.hasNext()) {
                                int i12 = i11 + 1;
                                TimelineComponentState.ItemState itemState2 = (TimelineComponentState.ItemState) it2.next();
                                boolean z = i11 == timelineComponentStateRememberUpdatedTimelineComponentState.getItems().size() + (-1);
                                ArrayList arrayList5 = arrayList4;
                                ConstrainedLayoutReference constrainedLayoutReference3 = (ConstrainedLayoutReference) arrayList5.get(i11);
                                ConstrainedLayoutReference constrainedLayoutReference4 = (ConstrainedLayoutReference) CollectionsKt.getOrNull(arrayList5, i12);
                                TimelineComponentStyle.ConnectorStyle connector = itemState2.getConnector();
                                composer4.startReplaceGroup(-290702701);
                                ComposerKt.sourceInformation(composer4, "*172@7964L548,191@8991L843,204@9884L15,186@8726L1193");
                                if (connector == null) {
                                    it = it2;
                                    i7 = i12;
                                    arrayList4 = arrayList5;
                                } else {
                                    ConstrainedLayoutReference constrainedLayoutReferenceCreateRef = constraintLayoutScope2.createRef();
                                    Size size2 = itemState2.getIcon().getSize();
                                    composer4.startReplaceGroup(149622693);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):TimelineComponentView.kt#9igjgp");
                                    boolean zChanged5 = composer4.changed(size2) | composer4.changed(constrainedLayoutReferenceCreateRef);
                                    Object objRememberedValue9 = composer4.rememberedValue();
                                    if (zChanged5 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        SizeConstraint height2 = itemState2.getIcon().getSize().getHeight();
                                        if ((height2 instanceof SizeConstraint.Fixed ? (SizeConstraint.Fixed) height2 : null) != null) {
                                            fM11017constructorimpl = C1486Dp.m11017constructorimpl(C1486Dp.m11017constructorimpl(r12.getValue()) / 2);
                                        } else {
                                            fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                                        }
                                        C1486Dp c1486DpTimelineComponentView$lambda$13$lambda$1 = TimelineComponentViewKt.TimelineComponentView$lambda$13$lambda$1(state2);
                                        if (c1486DpTimelineComponentView$lambda$13$lambda$1 != null) {
                                            int iM11031unboximpl = (int) c1486DpTimelineComponentView$lambda$13$lambda$1.m11031unboximpl();
                                            it = it2;
                                            fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(C1486Dp.m11017constructorimpl(iM11031unboximpl - (itemState2.getConnector() != null ? r15.getWidth() : 0)) / 2);
                                        } else {
                                            it = it2;
                                            fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(0);
                                        }
                                        objRememberedValue9 = TuplesKt.m1606to(C1486Dp.m11015boximpl(fM11017constructorimpl2), C1486Dp.m11015boximpl(fM11017constructorimpl));
                                        composer4.updateRememberedValue(objRememberedValue9);
                                    } else {
                                        it = it2;
                                    }
                                    Pair pair = (Pair) objRememberedValue9;
                                    composer4.endReplaceGroup();
                                    TimelineComponentState.ItemState itemState3 = (TimelineComponentState.ItemState) CollectionsKt.getOrNull(timelineComponentStateRememberUpdatedTimelineComponentState.getItems(), i12);
                                    if (itemState3 != null && (icon = itemState3.getIcon()) != null && (size = icon.getSize()) != null && (height = size.getHeight()) != null && (c1486DpDpOrNull = SizeConstraintExtensionsKt.dpOrNull(height)) != null) {
                                        fM11017constructorimpl3 = c1486DpDpOrNull.m11031unboximpl();
                                    } else {
                                        fM11017constructorimpl3 = C1486Dp.m11017constructorimpl(0);
                                    }
                                    float fM11017constructorimpl4 = C1486Dp.m11017constructorimpl(fM11017constructorimpl3 / 2);
                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                    TimelineComponentStyle.ConnectorStyle connector2 = itemState2.getConnector();
                                    if (connector2 == null || (paddingValuesM2847PaddingValues0680j_4 = connector2.getMargin()) == null) {
                                        i7 = i12;
                                        paddingValuesM2847PaddingValues0680j_4 = PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0));
                                    } else {
                                        i7 = i12;
                                    }
                                    arrayList4 = arrayList5;
                                    Modifier modifierZIndex = ZIndexModifierKt.zIndex(OffsetKt.m2811offsetVpY3zN4$default(PaddingKt.padding(companion4, paddingValuesM2847PaddingValues0680j_4), 0.0f, ((C1486Dp) pair.getSecond()).m11031unboximpl(), 1, null), -1.0f);
                                    composer4.startReplaceGroup(149655852);
                                    ComposerKt.sourceInformation(composer4, "CC(remember):TimelineComponentView.kt#9igjgp");
                                    boolean zChanged6 = composer4.changed(pair) | composer4.changed(itemState2) | composer4.changed(constrainedLayoutReference3) | composer4.changed(z) | composer4.changed(constrainedLayoutReference4) | composer4.changed(fM11017constructorimpl4);
                                    TimelineComponentViewKt$TimelineComponentView$2$6$1$1 timelineComponentViewKt$TimelineComponentView$2$6$1$1RememberedValue = composer4.rememberedValue();
                                    if (zChanged6 || timelineComponentViewKt$TimelineComponentView$2$6$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        timelineComponentViewKt$TimelineComponentView$2$6$1$1RememberedValue = new TimelineComponentViewKt$TimelineComponentView$2$6$1$1(pair, itemState2, constrainedLayoutReference3, z, constrainedLayoutReference4, fM11017constructorimpl4);
                                        composer4.updateRememberedValue(timelineComponentViewKt$TimelineComponentView$2$6$1$1RememberedValue);
                                    }
                                    composer4.endReplaceGroup();
                                    BoxKt.Box(OverlayKt.overlay$default(constraintLayoutScope2.constrainAs(modifierZIndex, constrainedLayoutReferenceCreateRef, (Function1) timelineComponentViewKt$TimelineComponentView$2$6$1$1RememberedValue), ColorStyleKt.getForCurrentTheme(connector.getColor(), composer4, 0), null, 2, null), composer4, 0);
                                    Unit unit3 = Unit.INSTANCE;
                                    Unit unit4 = Unit.INSTANCE;
                                }
                                composer4.endReplaceGroup();
                                it2 = it;
                                i11 = i7;
                            }
                            composer4.endReplaceGroup();
                            composer4.endReplaceGroup();
                            if (constraintLayoutScope.getHelpersHashCode() != i10) {
                                EffectsKt.SideEffect(function0, composer4, 6);
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer4.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), measurePolicy, composer2, 48, 0);
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
            }
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView.3
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
                        TimelineComponentViewKt.TimelineComponentView(style, state, modifier4, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        modifier2 = modifier;
        if ((i3 & 147) == 146) {
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            timelineComponentStateRememberUpdatedTimelineComponentState = TimelineComponentStateKt.rememberUpdatedTimelineComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
            if (timelineComponentStateRememberUpdatedTimelineComponentState.getVisible()) {
            }
        }
        final Modifier modifier42 = modifier2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Align_Title_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(747423832);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_Align_Title_Preview)214@10062L20,214@10036L326:TimelineComponentView.kt#1cibm8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(747423832, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Align_Title_Preview (TimelineComponentView.kt:213)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableSingletons$TimelineComponentViewKt.INSTANCE.m14023getLambda1$revenuecatui_defaultsRelease(), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Align_Title_Preview.1
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
                    TimelineComponentViewKt.TimelineComponentView_Align_Title_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Align_TitleAndDescription_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1930279475);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_Align_TitleAndDescription_Preview)227@10489L20,227@10463L340:TimelineComponentView.kt#1cibm8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1930279475, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Align_TitleAndDescription_Preview (TimelineComponentView.kt:226)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableSingletons$TimelineComponentViewKt.INSTANCE.m14024getLambda2$revenuecatui_defaultsRelease(), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Align_TitleAndDescription_Preview.1
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
                    TimelineComponentViewKt.TimelineComponentView_Align_TitleAndDescription_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Connector_Margin_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(475255038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_Connector_Margin_Preview)240@10921L20,240@10895L481:TimelineComponentView.kt#1cibm8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(475255038, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Connector_Margin_Preview (TimelineComponentView.kt:239)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableSingletons$TimelineComponentViewKt.INSTANCE.m14025getLambda3$revenuecatui_defaultsRelease(), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Connector_Margin_Preview.1
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
                    TimelineComponentViewKt.TimelineComponentView_Connector_Margin_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_Size_Preview(@PreviewParameter(provider = SizeParameterProvider.class) final Size size, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(74978622);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_Size_Preview)270@12006L20,270@12028L792,270@11980L840:TimelineComponentView.kt#1cibm8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(size) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(74978622, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Size_Preview (TimelineComponentView.kt:269)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-111498279, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Size_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C271@12038L776:TimelineComponentView.kt#1cibm8");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-111498279, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_Size_Preview.<anonymous> (TimelineComponentView.kt:271)");
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8185getWhite0d7_KjU(), null, 2, null);
                        Size size2 = size;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2016backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1440756992, "C273@12148L64,276@12238L19,272@12101L171,279@12286L518:TimelineComponentView.kt#1cibm8");
                        TimelineComponentViewKt.TimelineComponentView(TimelineComponentViewKt.previewStyle(0, 0, 0, null, false, size2, null, null, null, composer2, 0, 479), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        float f = 16;
                        TextKt.m5868Text4IGK_g("timeline = w:" + size2.getWidth().getClass().getSimpleName() + " x h:" + size2.getHeight().getClass().getSimpleName(), PaddingKt.m2854padding3ABfNKs(BorderKt.m2033borderxT4_qwU(BackgroundKt.m2015backgroundbw27NRU(ShadowKt.m7746shadows4CzXII$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), C1486Dp.m11017constructorimpl(f), RoundedCornerShapeKt.RoundedCornerShape(50), false, 0L, 0L, 28, null), Color.INSTANCE.m8185getWhite0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), C1486Dp.m11017constructorimpl(2), Color.INSTANCE.m8174getBlack0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), C1486Dp.m11017constructorimpl(f)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 0, 0, 131068);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_Size_Preview.2
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
                    TimelineComponentViewKt.TimelineComponentView_Size_Preview(size, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimelineComponentView_TextSize_Preview(@PreviewParameter(provider = SizeConstraintParameterProvider.class) final SizeConstraint sizeConstraint, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(774105102);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TimelineComponentView_TextSize_Preview)305@13279L20,305@13301L4699,305@13253L4747:TimelineComponentView.kt#1cibm8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(sizeConstraint) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(774105102, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_TextSize_Preview (TimelineComponentView.kt:304)");
            }
            ImagePreviewsKt.ProvidePreviewImageLoader(PreviewHelpersKt.previewImageLoader(0, composerStartRestartGroup, 0, 1), ComposableLambdaKt.rememberComposableLambda(-408857751, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_TextSize_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C306@13311L4683:TimelineComponentView.kt#1cibm8");
                    if ((i3 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-408857751, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentView_TextSize_Preview.<anonymous> (TimelineComponentView.kt:306)");
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8185getWhite0d7_KjU(), null, 2, null);
                        SizeConstraint sizeConstraint2 = sizeConstraint;
                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM2016backgroundbw27NRU$default);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer2);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 751979280, "C312@13637L233,311@13589L1288,332@14951L233,331@14903L1206,351@16183L233,350@16135L1254,308@13421L4010,372@17457L19,307@13374L4117,375@17505L479:TimelineComponentView.kt#1cibm8");
                        Size size = new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null));
                        float f = 8;
                        IconComponentStyle iconComponentStyleM14027previewIcon6xbWgXg = TimelineComponentViewKt.m14027previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(39, null), new SizeConstraint.Fixed(39, null)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), composer2, 3456, 3);
                        TimelineComponentViewKt.TimelineComponentView(TimelineComponentViewKt.previewStyle(0, 0, 0, null, false, size, null, null, CollectionsKt.listOf((Object[]) new TimelineComponentStyle.ItemStyle[]{TimelineComponentViewKt.previewItem(PreviewHelpersKt.previewTextComponentStyle("Today", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? com.revenuecat.purchases.paywalls.components.properties.FontWeight.REGULAR : com.revenuecat.purchases.paywalls.components.properties.FontWeight.MEDIUM, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(sizeConstraint2, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("Description of what you get today if you subscribe with multiple lines to check wrapping", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? com.revenuecat.purchases.paywalls.components.properties.FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(sizeConstraint2, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), iconComponentStyleM14027previewIcon6xbWgXg, (TimelineComponentStyle.ConnectorStyle) null, composer2, 0, 8), TimelineComponentViewKt.previewItem(PreviewHelpersKt.previewTextComponentStyle("Day X", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? com.revenuecat.purchases.paywalls.components.properties.FontWeight.REGULAR : com.revenuecat.purchases.paywalls.components.properties.FontWeight.MEDIUM, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(sizeConstraint2, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("We'll remind you that your trial is ending soon", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? com.revenuecat.purchases.paywalls.components.properties.FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(sizeConstraint2, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), TimelineComponentViewKt.m14027previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(39, null), new SizeConstraint.Fixed(39, null)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), composer2, 3456, 3), (TimelineComponentStyle.ConnectorStyle) null, composer2, 0, 8), TimelineComponentViewKt.previewItem(PreviewHelpersKt.previewTextComponentStyle("Day Y", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? com.revenuecat.purchases.paywalls.components.properties.FontWeight.REGULAR : com.revenuecat.purchases.paywalls.components.properties.FontWeight.MEDIUM, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(sizeConstraint2, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("You'll be charged. You can cancel anytime before.", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? com.revenuecat.purchases.paywalls.components.properties.FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(sizeConstraint2, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), TimelineComponentViewKt.m14027previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(39, null), new SizeConstraint.Fixed(39, null)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), composer2, 3456, 3), (TimelineComponentStyle.ConnectorStyle) null, composer2, 3072, 0)}), composer2, ProfileVerifier.CompilationStatus.f379xf2722a21, 223), PreviewHelpersKt.previewEmptyState(null, composer2, 0, 1), null, composer2, 0, 4);
                        float f2 = 16;
                        TextKt.m5868Text4IGK_g("text = w:" + sizeConstraint2.getClass().getSimpleName() + " x h:Fit", PaddingKt.m2854padding3ABfNKs(BorderKt.m2033borderxT4_qwU(BackgroundKt.m2015backgroundbw27NRU(ShadowKt.m7746shadows4CzXII$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), C1486Dp.m11017constructorimpl(f2), RoundedCornerShapeKt.RoundedCornerShape(50), false, 0L, 0L, 28, null), Color.INSTANCE.m8185getWhite0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), C1486Dp.m11017constructorimpl(2), Color.INSTANCE.m8174getBlack0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), C1486Dp.m11017constructorimpl(f2)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, composer2, 0, 0, 131068);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.timeline.TimelineComponentViewKt.TimelineComponentView_TextSize_Preview.2
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
                    TimelineComponentViewKt.TimelineComponentView_TextSize_Preview(sizeConstraint, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimelineComponentStyle previewStyle(int i, int i2, int i3, TimelineComponent.IconAlignment iconAlignment, boolean z, Size size, PaddingValues paddingValues, PaddingValues paddingValues2, List<TimelineComponentStyle.ItemStyle> list, Composer composer, int i4, int i5) {
        composer.startReplaceGroup(-1453577113);
        ComposerKt.sourceInformation(composer, "C(previewStyle)P(2,7!2,8,6,5,4)399@18534L14:TimelineComponentView.kt#1cibm8");
        int i6 = (i5 & 1) != 0 ? 24 : i;
        int i7 = (i5 & 2) != 0 ? 4 : i2;
        int i8 = (i5 & 4) != 0 ? 8 : i3;
        TimelineComponent.IconAlignment iconAlignment2 = (i5 & 8) != 0 ? TimelineComponent.IconAlignment.TitleAndDescription : iconAlignment;
        boolean z2 = (i5 & 16) != 0 ? true : z;
        Size size2 = (i5 & 32) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : size;
        PaddingValues paddingValuesM2847PaddingValues0680j_4 = (i5 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(5)) : paddingValues;
        PaddingValues paddingValuesM2847PaddingValues0680j_42 = (i5 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(5)) : paddingValues2;
        List<TimelineComponentStyle.ItemStyle> listPreviewItems = (i5 & 256) != 0 ? previewItems(null, composer, 0, 1) : list;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1453577113, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewStyle (TimelineComponentView.kt:400)");
        }
        TimelineComponentStyle timelineComponentStyle = new TimelineComponentStyle(i6, i7, i8, iconAlignment2, z2, size2, paddingValuesM2847PaddingValues0680j_4, paddingValuesM2847PaddingValues0680j_42, listPreviewItems, null, null, null, null, CollectionsKt.emptyList(), 5120, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return timelineComponentStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimelineComponentStyle.ItemStyle previewItem(TextComponentStyle textComponentStyle, TextComponentStyle textComponentStyle2, IconComponentStyle iconComponentStyle, TimelineComponentStyle.ConnectorStyle connectorStyle, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-1551417669);
        ComposerKt.sourceInformation(composer, "C(previewItem)P(3,1,2)456@20616L13:TimelineComponentView.kt#1cibm8");
        IconComponentStyle iconComponentStyleM14027previewIcon6xbWgXg = (i2 & 4) != 0 ? m14027previewIcon6xbWgXg(0L, 0L, null, null, composer, 0, 15) : iconComponentStyle;
        TimelineComponentStyle.ConnectorStyle connectorStylePreviewConnectorStyle$default = (i2 & 8) != 0 ? previewConnectorStyle$default(0, null, null, 7, null) : connectorStyle;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1551417669, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewItem (TimelineComponentView.kt:458)");
        }
        TimelineComponentStyle.ItemStyle itemStyle = new TimelineComponentStyle.ItemStyle(textComponentStyle, true, textComponentStyle2, iconComponentStyleM14027previewIcon6xbWgXg, connectorStylePreviewConnectorStyle$default, null, null, null, null, CollectionsKt.emptyList(), 320, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return itemStyle;
    }

    private static final TimelineComponentStyle.ItemStyle previewItem(String str, String str2, IconComponentStyle iconComponentStyle, TimelineComponentStyle.ConnectorStyle connectorStyle, Composer composer, int i, int i2) {
        composer.startReplaceGroup(66138427);
        ComposerKt.sourceInformation(composer, "C(previewItem)P(3,1,2)473@21051L13:TimelineComponentView.kt#1cibm8");
        IconComponentStyle iconComponentStyleM14027previewIcon6xbWgXg = (i2 & 4) != 0 ? m14027previewIcon6xbWgXg(0L, 0L, null, null, composer, 0, 15) : iconComponentStyle;
        TimelineComponentStyle.ConnectorStyle connectorStylePreviewConnectorStyle$default = (i2 & 8) != 0 ? previewConnectorStyle$default(0, null, null, 7, null) : connectorStyle;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(66138427, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewItem (TimelineComponentView.kt:475)");
        }
        boolean z = true;
        TimelineComponentStyle.ItemStyle itemStyle = new TimelineComponentStyle.ItemStyle(PreviewHelpersKt.previewTextComponentStyle(str, (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? com.revenuecat.purchases.paywalls.components.properties.FontWeight.REGULAR : com.revenuecat.purchases.paywalls.components.properties.FontWeight.BOLD, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), z, PreviewHelpersKt.previewTextComponentStyle(str2, (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? com.revenuecat.purchases.paywalls.components.properties.FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), iconComponentStyleM14027previewIcon6xbWgXg, connectorStylePreviewConnectorStyle$default, null, null, null, null, CollectionsKt.emptyList(), 320, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return itemStyle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: previewIcon-6xbWgXg, reason: not valid java name */
    public static final IconComponentStyle m14027previewIcon6xbWgXg(long j, long j2, Size size, PaddingValues paddingValues, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-254474895);
        ComposerKt.sourceInformation(composer, "C(previewIcon)P(1:c#ui.graphics.Color,0:c#ui.graphics.Color,3)502@22042L372:TimelineComponentView.kt#1cibm8");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m8185getWhite0d7_KjU();
        }
        if ((i2 & 2) != 0) {
            j2 = ColorKt.Color(4283919579L);
        }
        Size size2 = (i2 & 4) != 0 ? new Size(new SizeConstraint.Fixed(20, null), new SizeConstraint.Fixed(20, null)) : size;
        PaddingValues paddingValuesM2847PaddingValues0680j_4 = (i2 & 8) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(4)) : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-254474895, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewIcon (TimelineComponentView.kt:501)");
        }
        IconComponentStyle iconComponentStylePreviewIconComponentStyle = PreviewHelpersKt.previewIconComponentStyle(size2, false, new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(j)), null, 2, null), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(j2)), null, 2, null), paddingValuesM2847PaddingValues0680j_4, PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)), null, null, null, composer, ((i >> 6) & 14) | 14352384 | ((i << 3) & 57344), 258);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconComponentStylePreviewIconComponentStyle;
    }

    private static final TimelineComponentStyle.ConnectorStyle previewConnectorStyle(int i, PaddingValues paddingValues, ColorStyle colorStyle) {
        return new TimelineComponentStyle.ConnectorStyle(i, paddingValues, new ColorStyles(colorStyle, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<TimelineComponentStyle.ItemStyle> previewItems(PaddingValues paddingValues, Composer composer, int i, int i2) {
        composer.startReplaceGroup(-2140988222);
        ComposerKt.sourceInformation(composer, "C(previewItems)423@19167L243,431@19558L95,428@19420L318,437@19888L77,434@19748L721:TimelineComponentView.kt#1cibm8");
        PaddingValues paddingValuesM2847PaddingValues0680j_4 = (i2 & 1) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2140988222, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.timeline.previewItems (TimelineComponentView.kt:421)");
        }
        List<TimelineComponentStyle.ItemStyle> listListOf = CollectionsKt.listOf((Object[]) new TimelineComponentStyle.ItemStyle[]{previewItem("Today", "Description of what you get today if you subscribe with multiple lines to check wrapping", (IconComponentStyle) null, previewConnectorStyle$default(0, paddingValuesM2847PaddingValues0680j_4, null, 5, null), composer, 54, 4), previewItem("Day X", "We'll remind you that your trial is ending soon", m14027previewIcon6xbWgXg(0L, 0L, new Size(new SizeConstraint.Fixed(30, null), new SizeConstraint.Fixed(30, null)), null, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 11), previewConnectorStyle$default(0, paddingValuesM2847PaddingValues0680j_4, null, 5, null), composer, 54, 0), previewItem("Day Y", "You'll be charged. You can cancel anytime before.", m14027previewIcon6xbWgXg(Color.INSTANCE.m8174getBlack0d7_KjU(), ColorKt.Color(4279227523L), null, null, composer, 54, 12), previewConnectorStyle$default(0, paddingValuesM2847PaddingValues0680j_4, ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(0.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color(1037443)), 0.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color(4279227523L)), 100.0f)}))), 1, null), composer, 54, 0)});
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return listListOf;
    }

    static /* synthetic */ TimelineComponentStyle.ConnectorStyle previewConnectorStyle$default(int i, PaddingValues paddingValues, ColorStyle colorStyle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8;
        }
        if ((i2 & 2) != 0) {
            paddingValues = PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0));
        }
        if ((i2 & 4) != 0) {
            colorStyle = ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(ColorKt.Color(4290561265L)));
        }
        return previewConnectorStyle(i, paddingValues, colorStyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1486Dp TimelineComponentView$lambda$13$lambda$1(State<C1486Dp> state) {
        return state.getValue();
    }
}
