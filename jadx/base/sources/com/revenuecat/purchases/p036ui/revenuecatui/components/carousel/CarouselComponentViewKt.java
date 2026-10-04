package com.revenuecat.purchases.p036ui.revenuecatui.components.carousel;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpKt;
import androidx.compose.p004ui.unit.IntSize;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BorderKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.ShadowKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: CarouselComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000ä\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011\u001a5\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0003¢\u0006\u0002\u0010\u001f\u001a-\u0010 \u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0003¢\u0006\u0002\u0010$\u001a \u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002\u001a\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0002\u001a'\u0010.\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u001cH\u0000¢\u0006\u0002\u00100\u001a\u0018\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\fH\u0002\u001aÀ\u0001\u00104\u001a\u00020\u00032\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u000207062\b\b\u0002\u00108\u001a\u00020\u001c2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020\u001a2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020D2\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010K2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010L\u001a\u00020\u001a2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a*\u0010O\u001a\u0002072\u0006\u0010P\u001a\u00020Q2\u0006\u0010A\u001a\u00020B2\u0006\u0010R\u001a\u00020SH\u0002ø\u0001\u0000¢\u0006\u0004\bT\u0010U\u001a\u0012\u0010V\u001a\u00020#2\b\b\u0002\u0010W\u001a\u00020XH\u0002\u001a\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020706H\u0002\u001a3\u0010Z\u001a\u00020\u0001*\u00020[2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\\\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006]²\u0006\n\u0010^\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\n\u0010_\u001a\u00020`X\u008a\u0084\u0002²\u0006\n\u0010a\u001a\u00020bX\u008a\u0084\u0002²\u0006\n\u0010c\u001a\u00020?X\u008a\u0084\u0002²\u0006\n\u0010d\u001a\u00020?X\u008a\u0084\u0002²\u0006\n\u0010e\u001a\u00020?X\u008a\u0084\u0002²\u0006\n\u0010f\u001a\u00020?X\u008a\u0084\u0002²\u0006\n\u0010R\u001a\u00020?X\u008a\u0084\u0002²\u0006\n\u0010g\u001a\u00020?X\u008a\u0084\u0002"}, m1599d2 = {"CarouselComponentView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "CarouselComponentView_Loop_Preview", "(Landroidx/compose/runtime/Composer;I)V", "CarouselComponentView_Preview", "CarouselComponentView_Top_Preview", "EnableAutoAdvance", "autoAdvance", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;", "pagerState", "Landroidx/compose/foundation/pager/PagerState;", "shouldLoop", "", "pageCount", "", "skipProgrammaticPageTracking", "Lcom/revenuecat/purchases/ui/revenuecatui/components/carousel/ProgrammaticPageTrackingFlag;", "(Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;Landroidx/compose/foundation/pager/PagerState;ZILcom/revenuecat/purchases/ui/revenuecatui/components/carousel/ProgrammaticPageTrackingFlag;Landroidx/compose/runtime/Composer;I)V", "Indicator", "pageIndex", "pageControl", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;", "(Landroidx/compose/foundation/pager/PagerState;IILcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;Landroidx/compose/runtime/Composer;I)V", "fillPageModifierOrEmpty", "carouselHeight", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "measuredHeightPx", "density", "Landroidx/compose/ui/unit/Density;", "getInitialPage", "carouselState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/carousel/CarouselComponentState;", "nextAutoAdvanceTargetPage", "currentPage", "(ZII)Ljava/lang/Integer;", "pageHeightModifier", "pageHeight", "fillPageModifier", "previewCarouselComponentStyle", "pages", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "initialPageIndex", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "visible", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "sidePagePeek", "Landroidx/compose/ui/unit/Dp;", "spacing", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Landroidx/compose/ui/graphics/Color;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "margin", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "borderStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "shadowStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "loop", "previewCarouselComponentStyle-2XaYeUA", "(Ljava/util/List;ILandroidx/compose/ui/Alignment$Vertical;ZLcom/revenuecat/purchases/paywalls/components/properties/Size;FFJLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Lcom/revenuecat/purchases/paywalls/components/properties/Shape;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;ZLcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages;)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle;", "previewPage", "pageText", "", "height", "Lkotlin/UInt;", "previewPage-ecKwGiE", "(Ljava/lang/String;JI)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "previewPageControl", "position", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl$Position;", "previewPages", "PagerIndicator", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/CarouselComponentStyle$PageControlStyles;ILandroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsRelease", "pagerHeightPx", "composeShape", "Landroidx/compose/ui/graphics/Shape;", "progress", "", "targetWidth", "targetHeight", "targetStrokeWidth", "width", "strokeWidth"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class CarouselComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:184:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void CarouselComponentView(final CarouselComponentStyle style, final PaywallState.Loaded.Components state, final Function2 clickHandler, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        final CarouselComponentState carouselComponentStateRememberUpdatedCarouselComponentState;
        int i6;
        ShadowStyle shadowStyle;
        ProgrammaticPageTrackingFlag programmaticPageTrackingFlag;
        int i7;
        BackgroundStyle backgroundStyle;
        BorderStyle borderStyle;
        ShadowStyle shadowStyle2;
        final PagerState pagerState;
        final int i8;
        int i9;
        final CarouselComponentState carouselComponentState;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker3;
        final Modifier modifier3;
        CarouselComponentViewKt$CarouselComponentView$4$1 carouselComponentViewKt$CarouselComponentView$4$1;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(1295878738);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CarouselComponentView)P(4,3!1,2)90@5062L97,107@5639L116,107@5593L162,115@5796L43,171@8450L7,172@8483L54,179@8803L35,180@8889L39,182@9009L102,175@8645L2012:CarouselComponentView.kt#zahkep");
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
        int i10 = i2 & 8;
        if (i10 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= (i & 32768) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker4) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker4) ? 16384 : 8192;
            }
            i5 = i3;
            if ((i5 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i10 == 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    paywallComponentInteractionTracker4 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$$ExternalSyntheticLambda0
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                        }
                    };
                }
                final PaywallComponentInteractionTracker paywallComponentInteractionTracker5 = paywallComponentInteractionTracker4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1295878738, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView (CarouselComponentView.kt:89)");
                }
                int i11 = i5 & 14;
                carouselComponentStateRememberUpdatedCarouselComponentState = CarouselComponentStateKt.rememberUpdatedCarouselComponentState(style, state, composerStartRestartGroup, i5 & WebSocketProtocol.PAYLOAD_SHORT);
                if (carouselComponentStateRememberUpdatedCarouselComponentState.getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final Modifier modifier5 = modifier4;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView.2
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

                            public final void invoke(Composer composer2, int i12) {
                                CarouselComponentViewKt.CarouselComponentView(style, state, clickHandler, modifier5, paywallComponentInteractionTracker5, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                BackgroundStyles background = carouselComponentStateRememberUpdatedCarouselComponentState.getBackground();
                composerStartRestartGroup.startReplaceGroup(481651206);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*99@5280L27");
                BackgroundStyle backgroundStyleRememberBackgroundStyle = background == null ? null : BackgroundStyleKt.rememberBackgroundStyle(background, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                BorderStyles border = carouselComponentStateRememberUpdatedCarouselComponentState.getBorder();
                composerStartRestartGroup.startReplaceGroup(481653771);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*100@5360L32");
                BorderStyle borderStyleRememberBorderStyle = border == null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                ShadowStyles shadow = carouselComponentStateRememberUpdatedCarouselComponentState.getShadow();
                composerStartRestartGroup.startReplaceGroup(481656491);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*101@5445L32");
                ShadowStyle shadowStyleRememberShadowStyle = shadow == null ? null : ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                final int size = style.getPages().size();
                BorderStyle borderStyle2 = borderStyleRememberBorderStyle;
                int initialPage = getInitialPage(carouselComponentStateRememberUpdatedCarouselComponentState);
                composerStartRestartGroup.startReplaceGroup(481662967);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(carouselComponentStateRememberUpdatedCarouselComponentState) | composerStartRestartGroup.changed(size);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function0) new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$pagerState$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Integer invoke() {
                            return Integer.valueOf(carouselComponentStateRememberUpdatedCarouselComponentState.getLoop() ? Integer.MAX_VALUE : size);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                ShadowStyle shadowStyle3 = shadowStyleRememberShadowStyle;
                PagerState pagerStateRememberPagerState = PagerStateKt.rememberPagerState(initialPage, 0.0f, (Function0) objRememberedValue, composerStartRestartGroup, 0, 2);
                composerStartRestartGroup.startReplaceGroup(481667918);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new ProgrammaticPageTrackingFlag();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ProgrammaticPageTrackingFlag programmaticPageTrackingFlag2 = (ProgrammaticPageTrackingFlag) objRememberedValue2;
                composerStartRestartGroup.endReplaceGroup();
                CarouselComponent.AutoAdvancePages autoAdvance = carouselComponentStateRememberUpdatedCarouselComponentState.getAutoAdvance();
                composerStartRestartGroup.startReplaceGroup(481670516);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*118@5901L174");
                if (autoAdvance == null) {
                    shadowStyle = shadowStyle3;
                    programmaticPageTrackingFlag = programmaticPageTrackingFlag2;
                    i6 = i5;
                    i7 = size;
                } else {
                    i6 = i5;
                    EnableAutoAdvance(autoAdvance, pagerStateRememberPagerState, carouselComponentStateRememberUpdatedCarouselComponentState.getLoop(), size, programmaticPageTrackingFlag2, composerStartRestartGroup, 0);
                    shadowStyle = shadowStyle3;
                    programmaticPageTrackingFlag = programmaticPageTrackingFlag2;
                    i7 = size;
                    composerStartRestartGroup = composerStartRestartGroup;
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(481678949);
                ComposerKt.sourceInformation(composerStartRestartGroup, "135@6335L1508,128@6116L1727");
                if (i7 > 0) {
                    Object[] objArr = {pagerStateRememberPagerState, Integer.valueOf(i7), style.getComponentName(), style.getPageContextNames(), Integer.valueOf(style.getInitialPageIndex()), paywallComponentInteractionTracker5};
                    backgroundStyle = backgroundStyleRememberBackgroundStyle;
                    composerStartRestartGroup.startReplaceGroup(481686631);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    boolean zChanged2 = (i11 == 4) | composerStartRestartGroup.changed(pagerStateRememberPagerState) | composerStartRestartGroup.changedInstance(programmaticPageTrackingFlag) | composerStartRestartGroup.changed(i7) | ((i6 & 57344) == 16384 || ((i6 & 32768) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker5)));
                    Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        paywallComponentInteractionTracker2 = paywallComponentInteractionTracker5;
                        borderStyle = borderStyle2;
                        shadowStyle2 = shadowStyle;
                        int i12 = i7;
                        carouselComponentState = carouselComponentStateRememberUpdatedCarouselComponentState;
                        i9 = 0;
                        CarouselComponentViewKt$CarouselComponentView$4$1 carouselComponentViewKt$CarouselComponentView$4$12 = new CarouselComponentViewKt$CarouselComponentView$4$1(pagerStateRememberPagerState, programmaticPageTrackingFlag, i12, paywallComponentInteractionTracker2, style, null);
                        pagerState = pagerStateRememberPagerState;
                        i8 = i12;
                        carouselComponentViewKt$CarouselComponentView$4$1 = carouselComponentViewKt$CarouselComponentView$4$12;
                        composerStartRestartGroup.updateRememberedValue(carouselComponentViewKt$CarouselComponentView$4$1);
                    } else {
                        pagerState = pagerStateRememberPagerState;
                        borderStyle = borderStyle2;
                        shadowStyle2 = shadowStyle;
                        carouselComponentViewKt$CarouselComponentView$4$1 = objRememberedValue3;
                        i8 = i7;
                        i9 = 0;
                        carouselComponentState = carouselComponentStateRememberUpdatedCarouselComponentState;
                        paywallComponentInteractionTracker2 = paywallComponentInteractionTracker5;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(objArr, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) carouselComponentViewKt$CarouselComponentView$4$1, composerStartRestartGroup, i9);
                } else {
                    backgroundStyle = backgroundStyleRememberBackgroundStyle;
                    borderStyle = borderStyle2;
                    shadowStyle2 = shadowStyle;
                    pagerState = pagerStateRememberPagerState;
                    i8 = i7;
                    i9 = 0;
                    carouselComponentState = carouselComponentStateRememberUpdatedCarouselComponentState;
                    paywallComponentInteractionTracker2 = paywallComponentInteractionTracker5;
                }
                composerStartRestartGroup.endReplaceGroup();
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Density density = (Density) objConsume;
                List pages = carouselComponentState.getPages();
                composerStartRestartGroup.startReplaceGroup(481753913);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(pages);
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = SnapshotIntStateKt.mutableIntStateOf(i9);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MutableIntState mutableIntState = (MutableIntState) objRememberedValue4;
                composerStartRestartGroup.endReplaceGroup();
                final Modifier modifierFillPageModifierOrEmpty = fillPageModifierOrEmpty(carouselComponentState.getSize().getHeight(), CarouselComponentView$lambda$9(mutableIntState), density);
                Modifier modifier6 = modifier4;
                Modifier modifierPadding = PaddingKt.padding(SizeKt.size$default(modifier4, carouselComponentState.getSize(), null, null, 6, null), carouselComponentState.getMargin());
                composerStartRestartGroup.startReplaceGroup(481764134);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged4 = composerStartRestartGroup.changed(carouselComponentState);
                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (zChanged4 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$5$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return ShadowKt.shadow(applyIfNotNull, it, carouselComponentState.getShape());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(modifierPadding, shadowStyle2, (Function2) objRememberedValue5);
                composerStartRestartGroup.startReplaceGroup(481766890);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged5 = composerStartRestartGroup.changed(carouselComponentState);
                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChanged5 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function2) new Function2<Modifier, BackgroundStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$6$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, BackgroundStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return BackgroundKt.background(applyIfNotNull, it, carouselComponentState.getShape());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierClip = ClipKt.clip(ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull, backgroundStyle, (Function2) objRememberedValue6), carouselComponentState.getShape());
                composerStartRestartGroup.startReplaceGroup(481770793);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged6 = composerStartRestartGroup.changed(carouselComponentState);
                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged6 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$7$1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return PaddingKt.m2854padding3ABfNKs(BorderKt.border(applyIfNotNull, it, carouselComponentState.getShape()), it.m13932getWidthD9Ej5fM());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierPadding2 = PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(modifierClip, borderStyle, (Function2) objRememberedValue7), carouselComponentState.getPadding());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, i9);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, i9);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding2);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 588960891, "C209@10068L29,210@10109L405,202@9593L921:CarouselComponentView.kt#zahkep");
                Function2<Composer, Integer, Unit> function2 = new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$8$pageControl$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        return invoke(composer2, num.intValue());
                    }

                    public final Unit invoke(Composer composer2, int i13) {
                        Composer composer3;
                        Unit unit3;
                        composer2.startReplaceGroup(-1232729786);
                        ComposerKt.sourceInformation(composer2, "C*190@9266L159:CarouselComponentView.kt#zahkep");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1232729786, i13, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView.<anonymous>.<anonymous> (CarouselComponentView.kt:189)");
                        }
                        CarouselComponentStyle.PageControlStyles pageControl = carouselComponentState.getPageControl();
                        if (pageControl == null) {
                            unit3 = null;
                            composer3 = composer2;
                        } else {
                            composer3 = composer2;
                            CarouselComponentViewKt.PagerIndicator(columnScopeInstance, pageControl, i8, pagerState, null, composer3, 0, 8);
                            unit3 = Unit.INSTANCE;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceGroup();
                        return unit3;
                    }
                };
                composerStartRestartGroup.startReplaceGroup(1820121854);
                ComposerKt.sourceInformation(composerStartRestartGroup, "199@9560L13");
                CarouselComponentStyle.PageControlStyles pageControl = carouselComponentState.getPageControl();
                if ((pageControl != null ? pageControl.getPosition() : null) == CarouselComponent.PageControl.Position.TOP) {
                    function2.invoke(composerStartRestartGroup, Integer.valueOf(i9));
                }
                composerStartRestartGroup.endReplaceGroup();
                PaddingValues paddingValuesM2849PaddingValuesYgX7TsA$default = PaddingKt.m2849PaddingValuesYgX7TsA$default(C1486Dp.m11017constructorimpl(carouselComponentState.m13875getPagePeekD9Ej5fM() + carouselComponentState.m13876getPageSpacingD9Ej5fM()), 0.0f, 2, null);
                float fM13876getPageSpacingD9Ej5fM = carouselComponentState.m13876getPageSpacingD9Ej5fM();
                int i13 = i9;
                Alignment.Vertical pageAlignment = carouselComponentState.getPageAlignment();
                Modifier.Companion companion = Modifier.INSTANCE;
                composerStartRestartGroup.startReplaceGroup(1820141247);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                boolean zChanged7 = composerStartRestartGroup.changed(mutableIntState);
                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChanged7 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = (Function1) new Function1<IntSize, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$8$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IntSize intSize) {
                            m13882invokeozmzZPI(intSize.m11192unboximpl());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
                        public final void m13882invokeozmzZPI(long j) {
                            mutableIntState.setIntValue(IntSize.m11187getHeightimpl(j));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(companion, (Function1) objRememberedValue8);
                final CarouselComponentState carouselComponentState2 = carouselComponentState;
                final PaywallComponentInteractionTracker paywallComponentInteractionTracker6 = paywallComponentInteractionTracker2;
                Composer composer2 = composerStartRestartGroup;
                CarouselComponent.PageControl.Position position = null;
                PagerKt.m3174HorizontalPageroI3XNZo(pagerState, modifierOnSizeChanged, paddingValuesM2849PaddingValuesYgX7TsA$default, null, i8, fM13876getPageSpacingD9Ej5fM, pageAlignment, null, false, false, null, null, null, ComposableLambdaKt.rememberComposableLambda(2144257594, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$8$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer3, Integer num2) {
                        invoke(pagerScope, num.intValue(), composer3, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerScope HorizontalPager, int i14, Composer composer3, int i15) {
                        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
                        ComposerKt.sourceInformation(composer3, "C212@10197L307:CarouselComponentView.kt#zahkep");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2144257594, i15, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView.<anonymous>.<anonymous> (CarouselComponentView.kt:211)");
                        }
                        StackComponentStyle stackComponentStyle = (StackComponentStyle) carouselComponentState2.getPages().get(i14 % i8);
                        StackComponentViewKt.StackComponentView(stackComponentStyle, state, clickHandler, CarouselComponentViewKt.pageHeightModifier(stackComponentStyle.getSize().getHeight(), modifierFillPageModifierOrEmpty), null, false, null, 0.0f, paywallComponentInteractionTracker6, composer3, 0, PsExtractor.VIDEO_STREAM_MASK);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composer2, 0, 3072, 8072);
                composerStartRestartGroup = composer2;
                composerStartRestartGroup.startReplaceGroup(1820155937);
                ComposerKt.sourceInformation(composerStartRestartGroup, "222@10628L13");
                CarouselComponentStyle.PageControlStyles pageControl2 = carouselComponentState2.getPageControl();
                if (pageControl2 != null) {
                    position = pageControl2.getPosition();
                }
                if (position == CarouselComponent.PageControl.Position.BOTTOM) {
                    function2.invoke(composerStartRestartGroup, Integer.valueOf(i13));
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paywallComponentInteractionTracker3 = paywallComponentInteractionTracker6;
                modifier3 = modifier6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paywallComponentInteractionTracker3 = paywallComponentInteractionTracker4;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i14) {
                        CarouselComponentViewKt.CarouselComponentView(style, state, clickHandler, modifier3, paywallComponentInteractionTracker3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
        i5 = i3;
        if ((i5 & 9363) == 9362) {
            if (i10 == 0) {
            }
            if (i4 != 0) {
            }
            final PaywallComponentInteractionTracker paywallComponentInteractionTracker52 = paywallComponentInteractionTracker4;
            if (ComposerKt.isTraceInProgress()) {
            }
            int i112 = i5 & 14;
            carouselComponentStateRememberUpdatedCarouselComponentState = CarouselComponentStateKt.rememberUpdatedCarouselComponentState(style, state, composerStartRestartGroup, i5 & WebSocketProtocol.PAYLOAD_SHORT);
            if (carouselComponentStateRememberUpdatedCarouselComponentState.getVisible()) {
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final int CarouselComponentView$lambda$9(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02a7 A[LOOP:0: B:112:0x02a5->B:113:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PagerIndicator(final ColumnScope columnScope, final CarouselComponentStyle.PageControlStyles pageControlStyles, final int i, final PagerState pagerState, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        PagerState pagerState2;
        int i5;
        Modifier modifier2;
        int i6;
        boolean zChanged;
        Object objRememberedValue;
        final State state;
        boolean zChanged2;
        Object objRememberedValue2;
        boolean zChanged3;
        Object objRememberedValue3;
        boolean zChanged4;
        Object objRememberedValue4;
        int i7;
        int currentCompositeKeyHash;
        Composer composerM7248constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final CarouselComponentStyle.PageControlStyles pageControlStyles2 = pageControlStyles;
        int i8 = i;
        Composer composerStartRestartGroup = composer.startRestartGroup(736305479);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PagerIndicator)P(1,2,3)237@11125L78,243@11373L28,244@11452L32,245@11526L28,239@11209L760:CarouselComponentView.kt#zahkep");
        if ((i3 & Integer.MIN_VALUE) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(columnScope) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 1) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(pageControlStyles2) ? 32 : 16;
        }
        if ((i3 & 2) != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(i8) ? 256 : 128;
        }
        if ((i3 & 4) != 0) {
            i4 |= 3072;
        } else {
            if ((i2 & 3072) == 0) {
                pagerState2 = pagerState;
                i4 |= composerStartRestartGroup.changed(pagerState2) ? 2048 : 1024;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    modifier2 = modifier;
                    i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                }
                i6 = i4;
                if ((i6 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
                    if (i5 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(736305479, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.PagerIndicator (CarouselComponentView.kt:233)");
                    }
                    ColorStyles backgroundColor = pageControlStyles2.getBackgroundColor();
                    composerStartRestartGroup.startReplaceGroup(740984634);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "234@10919L15");
                    ColorStyle forCurrentTheme = backgroundColor != null ? null : ColorStyleKt.getForCurrentTheme(backgroundColor, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    BorderStyles border = pageControlStyles2.getBorder();
                    composerStartRestartGroup.startReplaceGroup(740986515);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*235@10983L32");
                    BorderStyle borderStyleRememberBorderStyle = border != null ? null : BorderStyleKt.rememberBorderStyle(border, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    ShadowStyles shadow = pageControlStyles2.getShadow();
                    composerStartRestartGroup.startReplaceGroup(740989171);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*236@11066L32");
                    ShadowStyle shadowStyleRememberShadowStyle = shadow != null ? ShadowStyleKt.rememberShadowStyle(shadow, composerStartRestartGroup, 0) : null;
                    composerStartRestartGroup.endReplaceGroup();
                    Shape shape = pageControlStyles2.getShape();
                    composerStartRestartGroup.startReplaceGroup(740991289);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(shape);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.p004ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$composeShape$2$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final androidx.compose.p004ui.graphics.Shape invoke() {
                                return ShapeKt.toShape(pageControlStyles2.getShape());
                            }
                        });
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    state = (State) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierPadding = PaddingKt.padding(columnScope.align(modifier2, Alignment.INSTANCE.getCenterHorizontally()), pageControlStyles2.getMargin());
                    composerStartRestartGroup.startReplaceGroup(740999175);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return ShadowKt.shadow(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$19(state));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierApplyIfNotNull = ModifierExtensionsKt.applyIfNotNull(modifierPadding, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2);
                    composerStartRestartGroup.startReplaceGroup(741001707);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(state);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = (Function2) new Function2<Modifier, ColorStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, ColorStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return BackgroundKt.background(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$19(state));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierApplyIfNotNull2 = ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull, forCurrentTheme, (Function2) objRememberedValue3);
                    composerStartRestartGroup.startReplaceGroup(741004071);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(state);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return BorderKt.border(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$19(state));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierPadding2 = PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull2, borderStyleRememberBorderStyle, (Function2) objRememberedValue4), pageControlStyles2.getPadding());
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    i7 = 0;
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding2);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (!composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                    Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1296476520, "C:CarouselComponentView.kt#zahkep");
                    composerStartRestartGroup.startReplaceGroup(-96725509);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*251@11767L186");
                    while (i7 < i8) {
                        int i9 = i8;
                        int i10 = i7;
                        Indicator(pagerState2, i10, i9, pageControlStyles2, composerStartRestartGroup, ((i6 >> 9) & 14) | (i6 & 896) | ((i6 << 6) & 7168));
                        i7 = i10 + 1;
                        pageControlStyles2 = pageControlStyles;
                        i8 = i;
                        pagerState2 = pagerState;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                }
                final Modifier modifier3 = modifier2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.PagerIndicator.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            CarouselComponentViewKt.PagerIndicator(columnScope, pageControlStyles, i, pagerState, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                        }
                    });
                    return;
                }
                return;
            }
            i4 |= 24576;
            modifier2 = modifier;
            i6 = i4;
            if ((i6 & 9363) != 9362) {
                if (i5 != 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                ColorStyles backgroundColor2 = pageControlStyles2.getBackgroundColor();
                composerStartRestartGroup.startReplaceGroup(740984634);
                ComposerKt.sourceInformation(composerStartRestartGroup, "234@10919L15");
                if (backgroundColor2 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                BorderStyles border2 = pageControlStyles2.getBorder();
                composerStartRestartGroup.startReplaceGroup(740986515);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*235@10983L32");
                if (border2 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                ShadowStyles shadow2 = pageControlStyles2.getShadow();
                composerStartRestartGroup.startReplaceGroup(740989171);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*236@11066L32");
                if (shadow2 != null) {
                }
                composerStartRestartGroup.endReplaceGroup();
                Shape shape2 = pageControlStyles2.getShape();
                composerStartRestartGroup.startReplaceGroup(740991289);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(shape2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<androidx.compose.p004ui.graphics.Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$composeShape$2$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final androidx.compose.p004ui.graphics.Shape invoke() {
                            return ShapeKt.toShape(pageControlStyles2.getShape());
                        }
                    });
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    state = (State) objRememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierPadding3 = PaddingKt.padding(columnScope.align(modifier2, Alignment.INSTANCE.getCenterHorizontally()), pageControlStyles2.getMargin());
                    composerStartRestartGroup.startReplaceGroup(740999175);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(state);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = (Function2) new Function2<Modifier, ShadowStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Modifier invoke(Modifier applyIfNotNull, ShadowStyle it) {
                                Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                Intrinsics.checkNotNullParameter(it, "it");
                                return ShadowKt.shadow(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$19(state));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierApplyIfNotNull3 = ModifierExtensionsKt.applyIfNotNull(modifierPadding3, shadowStyleRememberShadowStyle, (Function2) objRememberedValue2);
                        composerStartRestartGroup.startReplaceGroup(741001707);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(state);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = (Function2) new Function2<Modifier, ColorStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Modifier invoke(Modifier applyIfNotNull, ColorStyle it) {
                                    Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    return BackgroundKt.background(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$19(state));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            composerStartRestartGroup.endReplaceGroup();
                            Modifier modifierApplyIfNotNull22 = ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull3, forCurrentTheme, (Function2) objRememberedValue3);
                            composerStartRestartGroup.startReplaceGroup(741004071);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
                            zChanged4 = composerStartRestartGroup.changed(state);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged4) {
                                objRememberedValue4 = (Function2) new Function2<Modifier, BorderStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$PagerIndicator$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, BorderStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return BorderKt.border(applyIfNotNull, it, CarouselComponentViewKt.PagerIndicator$lambda$19(state));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                composerStartRestartGroup.endReplaceGroup();
                                Modifier modifierPadding22 = PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(modifierApplyIfNotNull22, borderStyleRememberBorderStyle, (Function2) objRememberedValue4), pageControlStyles2.getPadding());
                                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, centerVertically2, composerStartRestartGroup, 54);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                i7 = 0;
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding22);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                }
                                composerStartRestartGroup.startReusableNode();
                                if (!composerStartRestartGroup.getInserting()) {
                                }
                                composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!composerM7248constructorimpl.getInserting()) {
                                    composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1296476520, "C:CarouselComponentView.kt#zahkep");
                                    composerStartRestartGroup.startReplaceGroup(-96725509);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*251@11767L186");
                                    while (i7 < i8) {
                                    }
                                    composerStartRestartGroup.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endNode();
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final Modifier modifier32 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        pagerState2 = pagerState;
        i5 = i3 & 8;
        if (i5 != 0) {
        }
        modifier2 = modifier;
        i6 = i4;
        if ((i6 & 9363) != 9362) {
        }
        final Modifier modifier322 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Indicator(final PagerState pagerState, final int i, final int i2, final CarouselComponentStyle.PageControlStyles pageControlStyles, Composer composer, final int i3) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-532758904);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Indicator)P(3,2,1)269@12210L871,291@13106L198,300@13329L200,310@13560L226,320@13805L58,323@13882L59,328@14000L15,329@14101L15,342@14694L64,352@15021L110,346@14764L374:CarouselComponentView.kt#zahkep");
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(pagerState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(pageControlStyles) ? 2048 : 1024;
        }
        if ((i4 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532758904, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.Indicator (CarouselComponentView.kt:268)");
            }
            composerStartRestartGroup.startReplaceGroup(-106534697);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$progress$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        int currentPage = pagerState.getCurrentPage() % i2;
                        int i5 = i;
                        float currentPageOffsetFraction = 0.0f;
                        if (i5 == currentPage) {
                            if (pagerState.getCurrentPageOffsetFraction() >= 0.0f) {
                                currentPageOffsetFraction = 1.0f - pagerState.getCurrentPageOffsetFraction();
                            } else {
                                currentPageOffsetFraction = pagerState.getCurrentPageOffsetFraction() + 1.0f;
                            }
                        } else if (i5 == currentPage + 1 && pagerState.getCurrentPageOffsetFraction() >= 0.0f) {
                            currentPageOffsetFraction = pagerState.getCurrentPageOffsetFraction();
                        } else if (i == currentPage - 1 && pagerState.getCurrentPageOffsetFraction() < 0.0f) {
                            currentPageOffsetFraction = -pagerState.getCurrentPageOffsetFraction();
                        }
                        return Float.valueOf(currentPageOffsetFraction);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final State state = (State) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-106506698);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<C1486Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$targetWidth$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ C1486Dp invoke() {
                        return C1486Dp.m11015boximpl(m13885invokeD9Ej5fM());
                    }

                    /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m13885invokeD9Ej5fM() {
                        return DpKt.m11060lerpMdfbLM(pageControlStyles.getDefault().m13999getWidthD9Ej5fM(), pageControlStyles.getActive().m13999getWidthD9Ej5fM(), CarouselComponentViewKt.Indicator$lambda$26(state));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            State state2 = (State) objRememberedValue2;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-106499560);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<C1486Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$targetHeight$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ C1486Dp invoke() {
                        return C1486Dp.m11015boximpl(m13883invokeD9Ej5fM());
                    }

                    /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m13883invokeD9Ej5fM() {
                        return DpKt.m11060lerpMdfbLM(pageControlStyles.getDefault().m13997getHeightD9Ej5fM(), pageControlStyles.getActive().m13997getHeightD9Ej5fM(), CarouselComponentViewKt.Indicator$lambda$26(state));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            State state3 = (State) objRememberedValue3;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-106492142);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<C1486Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$targetStrokeWidth$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ C1486Dp invoke() {
                        return C1486Dp.m11015boximpl(m13884invokeD9Ej5fM());
                    }

                    /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m13884invokeD9Ej5fM() {
                        C1486Dp c1486DpM13998getStrokeWidthlTKBWiU = pageControlStyles.getDefault().m13998getStrokeWidthlTKBWiU();
                        float fM11031unboximpl = c1486DpM13998getStrokeWidthlTKBWiU != null ? c1486DpM13998getStrokeWidthlTKBWiU.m11031unboximpl() : C1486Dp.m11017constructorimpl(0);
                        C1486Dp c1486DpM13998getStrokeWidthlTKBWiU2 = pageControlStyles.getActive().m13998getStrokeWidthlTKBWiU();
                        return DpKt.m11060lerpMdfbLM(fM11031unboximpl, c1486DpM13998getStrokeWidthlTKBWiU2 != null ? c1486DpM13998getStrokeWidthlTKBWiU2.m11031unboximpl() : C1486Dp.m11017constructorimpl(0), CarouselComponentViewKt.Indicator$lambda$26(state));
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            State state4 = (State) objRememberedValue4;
            composerStartRestartGroup.endReplaceGroup();
            State<C1486Dp> stateM1892animateDpAsStateAjpBEmI = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(Indicator$lambda$28(state2), null, null, null, composerStartRestartGroup, 0, 14);
            State<C1486Dp> stateM1892animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(Indicator$lambda$30(state3), null, null, null, composerStartRestartGroup, 0, 14);
            ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(pageControlStyles.getDefault().getColor(), composerStartRestartGroup, 0);
            ColorStyle.Solid solid = forCurrentTheme instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme : null;
            long jM13951unboximpl = solid != null ? solid.m13951unboximpl() : Color.INSTANCE.m8183getTransparent0d7_KjU();
            ColorStyle forCurrentTheme2 = ColorStyleKt.getForCurrentTheme(pageControlStyles.getActive().getColor(), composerStartRestartGroup, 0);
            ColorStyle.Solid solid2 = forCurrentTheme2 instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme2 : null;
            long jM8199lerpjxsXWHM = ColorKt.m8199lerpjxsXWHM(jM13951unboximpl, solid2 != null ? solid2.m13951unboximpl() : Color.INSTANCE.m8183getTransparent0d7_KjU(), Indicator$lambda$26(state));
            boolean z = ((pageControlStyles.getDefault().getStrokeColor() == null && pageControlStyles.getActive().getStrokeColor() == null) || (pageControlStyles.getDefault().m13998getStrokeWidthlTKBWiU() == null && pageControlStyles.getActive().m13998getStrokeWidthlTKBWiU() == null)) ? false : true;
            ColorStyles strokeColor = pageControlStyles.getDefault().getStrokeColor();
            composerStartRestartGroup.startReplaceGroup(-106463201);
            ComposerKt.sourceInformation(composerStartRestartGroup, "337@14471L15");
            ColorStyle forCurrentTheme3 = strokeColor == null ? null : ColorStyleKt.getForCurrentTheme(strokeColor, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceGroup();
            ColorStyle.Solid solid3 = forCurrentTheme3 instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme3 : null;
            long jM13951unboximpl2 = solid3 != null ? solid3.m13951unboximpl() : Color.INSTANCE.m8183getTransparent0d7_KjU();
            ColorStyles strokeColor2 = pageControlStyles.getActive().getStrokeColor();
            composerStartRestartGroup.startReplaceGroup(-106459745);
            ComposerKt.sourceInformation(composerStartRestartGroup, "338@14579L15");
            ColorStyle forCurrentTheme4 = strokeColor2 == null ? null : ColorStyleKt.getForCurrentTheme(strokeColor2, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceGroup();
            ColorStyle.Solid solid4 = forCurrentTheme4 instanceof ColorStyle.Solid ? (ColorStyle.Solid) forCurrentTheme4 : null;
            final long jM8199lerpjxsXWHM2 = ColorKt.m8199lerpjxsXWHM(jM13951unboximpl2, solid4 != null ? solid4.m13951unboximpl() : Color.INSTANCE.m8183getTransparent0d7_KjU(), Indicator$lambda$26(state));
            final State<C1486Dp> stateM1892animateDpAsStateAjpBEmI3 = AnimateAsStateKt.m1892animateDpAsStateAjpBEmI(Indicator$lambda$32(state4), null, null, null, composerStartRestartGroup, 0, 14);
            Modifier modifierM2926sizeVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m2926sizeVpY3zN4(androidx.compose.foundation.BackgroundKt.m2016backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m2856paddingVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(pageControlStyles.m14003getSpacingD9Ej5fM() / 2), 0.0f, 2, null), ShapeKt.toShape(Shape.Pill.INSTANCE)), jM8199lerpjxsXWHM, null, 2, null), Indicator$lambda$33(stateM1892animateDpAsStateAjpBEmI), Indicator$lambda$34(stateM1892animateDpAsStateAjpBEmI2));
            composerStartRestartGroup.startReplaceGroup(-106445506);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateM1892animateDpAsStateAjpBEmI3) | composerStartRestartGroup.changed(jM8199lerpjxsXWHM2);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$Indicator$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Modifier invoke(Modifier conditional) {
                        Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                        return androidx.compose.foundation.BorderKt.m2033borderxT4_qwU(conditional, CarouselComponentViewKt.Indicator$lambda$35(stateM1892animateDpAsStateAjpBEmI3), jM8199lerpjxsXWHM2, ShapeKt.toShape(Shape.Pill.INSTANCE));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            composerStartRestartGroup.endReplaceGroup();
            BoxKt.Box(ModifierExtensionsKt.conditional(modifierM2926sizeVpY3zN4, z, (Function1) objRememberedValue5), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.Indicator.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    CarouselComponentViewKt.Indicator(pagerState, i, i2, pageControlStyles, composer2, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EnableAutoAdvance(final CarouselComponent.AutoAdvancePages autoAdvancePages, final PagerState pagerState, final boolean z, final int i, final ProgrammaticPageTrackingFlag programmaticPageTrackingFlag, Composer composer, final int i2) {
        int i3;
        PagerState pagerState2;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1138617307);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(EnableAutoAdvance)P(!1,2,3)366@15404L1037,366@15383L1058:CarouselComponentView.kt#zahkep");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(autoAdvancePages) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            pagerState2 = pagerState;
            i3 |= composerStartRestartGroup.changed(pagerState2) ? 32 : 16;
        } else {
            pagerState2 = pagerState;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 = i;
            i3 |= composerStartRestartGroup.changed(i4) ? 2048 : 1024;
        } else {
            i4 = i;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(programmaticPageTrackingFlag) ? 16384 : 8192;
        }
        if ((i3 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1138617307, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.EnableAutoAdvance (CarouselComponentView.kt:365)");
            }
            Unit unit = Unit.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(907030462);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):CarouselComponentView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(autoAdvancePages) | ((i3 & 112) == 32) | ((i3 & 896) == 256) | ((i3 & 7168) == 2048) | composerStartRestartGroup.changedInstance(programmaticPageTrackingFlag);
            CarouselComponentViewKt$EnableAutoAdvance$1$1 carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue = new CarouselComponentViewKt$EnableAutoAdvance$1$1(autoAdvancePages, pagerState2, z, i4, programmaticPageTrackingFlag, null);
                composerStartRestartGroup.updateRememberedValue(carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) carouselComponentViewKt$EnableAutoAdvance$1$1RememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.EnableAutoAdvance.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    CarouselComponentViewKt.EnableAutoAdvance(autoAdvancePages, pagerState, z, i, programmaticPageTrackingFlag, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    public static final Integer nextAutoAdvanceTargetPage(boolean z, int i, int i2) {
        if (i <= 0) {
            return null;
        }
        if (z) {
            return Integer.valueOf(i2 + 1);
        }
        if (i2 >= i - 1) {
            return null;
        }
        return Integer.valueOf(i2 + 1);
    }

    private static final Modifier fillPageModifierOrEmpty(SizeConstraint sizeConstraint, int i, Density density) {
        if ((sizeConstraint instanceof SizeConstraint.Fit) && i > 0) {
            return androidx.compose.foundation.layout.SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, density.mo2188toDpu2uoSUM(i));
        }
        return Modifier.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier pageHeightModifier(SizeConstraint sizeConstraint, Modifier modifier) {
        return sizeConstraint instanceof SizeConstraint.Fill ? modifier : Modifier.INSTANCE;
    }

    private static final int getInitialPage(CarouselComponentState carouselComponentState) {
        if (carouselComponentState.getLoop()) {
            int i = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            while (i % carouselComponentState.getPages().size() != carouselComponentState.getInitialPageIndex()) {
                i++;
            }
            return i;
        }
        return carouselComponentState.getInitialPageIndex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CarouselComponentView_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(697064564);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CarouselComponentView_Preview)463@18753L222:CarouselComponentView.kt#zahkep");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(697064564, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView_Preview (CarouselComponentView.kt:462)");
            }
            Modifier modifierM2016backgroundbw27NRU$default = androidx.compose.foundation.BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8185getWhite0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2016backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1687474917, "C466@18908L19,464@18812L157:CarouselComponentView.kt#zahkep");
            CarouselComponentView(m13880previewCarouselComponentStyle2XaYeUA$default(null, 0, null, false, null, 0.0f, 0.0f, 0L, null, null, null, null, null, null, false, null, 65535, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new CarouselComponentViewKt$CarouselComponentView_Preview$1$1(null), null, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView_Preview.2
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
                    CarouselComponentViewKt.CarouselComponentView_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CarouselComponentView_Top_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(897820094);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CarouselComponentView_Top_Preview)475@19054L329:CarouselComponentView.kt#zahkep");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(897820094, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView_Top_Preview (CarouselComponentView.kt:474)");
            }
            Modifier modifierM2016backgroundbw27NRU$default = androidx.compose.foundation.BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8185getWhite0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2016backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2116633786, "C480@19316L19,476@19113L264:CarouselComponentView.kt#zahkep");
            CarouselComponentView(m13880previewCarouselComponentStyle2XaYeUA$default(null, 0, null, false, null, 0.0f, 0.0f, 0L, null, null, null, null, null, previewPageControl(CarouselComponent.PageControl.Position.TOP), false, null, GeneratorBase.SURR2_LAST, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new CarouselComponentViewKt$CarouselComponentView_Top_Preview$1$1(null), null, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView_Top_Preview.2
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
                    CarouselComponentViewKt.CarouselComponentView_Top_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CarouselComponentView_Loop_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-172536871);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CarouselComponentView_Loop_Preview)489@19463L528:CarouselComponentView.kt#zahkep");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-172536871, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentView_Loop_Preview (CarouselComponentView.kt:488)");
            }
            Modifier modifierM2016backgroundbw27NRU$default = androidx.compose.foundation.BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.INSTANCE.m8185getWhite0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2016backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -921699828, "C499@19924L19,490@19522L463:CarouselComponentView.kt#zahkep");
            CarouselComponentView(m13880previewCarouselComponentStyle2XaYeUA$default(null, 0, null, false, null, 0.0f, 0.0f, 0L, null, null, null, null, null, null, true, new CarouselComponent.AutoAdvancePages(1000, 500, CarouselComponent.AutoAdvancePages.TransitionType.FADE), 16383, null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new CarouselComponentViewKt$CarouselComponentView_Loop_Preview$1$1(null), null, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.CarouselComponentView_Loop_Preview.2
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
                    CarouselComponentViewKt.CarouselComponentView_Loop_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: previewCarouselComponentStyle-2XaYeUA$default, reason: not valid java name */
    static /* synthetic */ CarouselComponentStyle m13880previewCarouselComponentStyle2XaYeUA$default(List list, int i, Alignment.Vertical vertical, boolean z, Size size, float f, float f2, long j, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, CarouselComponentStyle.PageControlStyles pageControlStyles, boolean z2, CarouselComponent.AutoAdvancePages autoAdvancePages, int i2, Object obj) {
        List list2;
        int i3;
        Alignment.Vertical vertical2;
        BorderStyles borderStyles2;
        CarouselComponent.AutoAdvancePages autoAdvancePages2;
        CarouselComponentStyle.PageControlStyles pageControlStylesPreviewPageControl$default;
        List listPreviewPages = (i2 & 1) != 0 ? previewPages() : list;
        int i4 = (i2 & 2) != 0 ? 0 : i;
        Alignment.Vertical centerVertically = (i2 & 4) != 0 ? Alignment.INSTANCE.getCenterVertically() : vertical;
        boolean z3 = (i2 & 8) != 0 ? true : z;
        Size size2 = (i2 & 16) != 0 ? new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : size;
        float fM11017constructorimpl = (i2 & 32) != 0 ? C1486Dp.m11017constructorimpl(20) : f;
        float fM11017constructorimpl2 = (i2 & 64) != 0 ? C1486Dp.m11017constructorimpl(8) : f2;
        long jM8180getLightGray0d7_KjU = (i2 & 128) != 0 ? Color.INSTANCE.m8180getLightGray0d7_KjU() : j;
        PaddingValues paddingValuesM2847PaddingValues0680j_4 = (i2 & 256) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : paddingValues;
        PaddingValues paddingValuesM2849PaddingValuesYgX7TsA$default = (i2 & 512) != 0 ? PaddingKt.m2849PaddingValuesYgX7TsA$default(0.0f, C1486Dp.m11017constructorimpl(16), 1, null) : paddingValues2;
        Shape.Rectangle rectangle = (i2 & 1024) != 0 ? new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null) : shape;
        if ((i2 & 2048) != 0) {
            list2 = listPreviewPages;
            i3 = i4;
            vertical2 = centerVertically;
            borderStyles2 = new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null);
        } else {
            list2 = listPreviewPages;
            i3 = i4;
            vertical2 = centerVertically;
            borderStyles2 = borderStyles;
        }
        ShadowStyles shadowStyles2 = (i2 & 4096) != 0 ? new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(5), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(3), null) : shadowStyles;
        if ((i2 & 8192) != 0) {
            autoAdvancePages2 = null;
            pageControlStylesPreviewPageControl$default = previewPageControl$default(null, 1, null);
        } else {
            autoAdvancePages2 = null;
            pageControlStylesPreviewPageControl$default = pageControlStyles;
        }
        boolean z4 = (i2 & 16384) != 0 ? false : z2;
        if ((i2 & 32768) != 0) {
            autoAdvancePages = autoAdvancePages2;
        }
        return m13879previewCarouselComponentStyle2XaYeUA(list2, i3, vertical2, z3, size2, fM11017constructorimpl, fM11017constructorimpl2, jM8180getLightGray0d7_KjU, paddingValuesM2847PaddingValues0680j_4, paddingValuesM2849PaddingValuesYgX7TsA$default, rectangle, borderStyles2, shadowStyles2, pageControlStylesPreviewPageControl$default, z4, autoAdvancePages);
    }

    /* JADX INFO: renamed from: previewCarouselComponentStyle-2XaYeUA, reason: not valid java name */
    private static final CarouselComponentStyle m13879previewCarouselComponentStyle2XaYeUA(List<StackComponentStyle> list, int i, Alignment.Vertical vertical, boolean z, Size size, float f, float f2, long j, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, BorderStyles borderStyles, ShadowStyles shadowStyles, CarouselComponentStyle.PageControlStyles pageControlStyles, boolean z2, CarouselComponent.AutoAdvancePages autoAdvancePages) {
        int size2 = list.size();
        ArrayList arrayList = new ArrayList(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList.add(null);
        }
        return new CarouselComponentStyle(list, arrayList, i, vertical, z, size, f, f2, BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(j)), null, 2, null))), paddingValues, paddingValues2, shape, borderStyles, shadowStyles, pageControlStyles, z2, autoAdvancePages, null, null, null, null, CollectionsKt.emptyList(), null, 5505024, null);
    }

    static /* synthetic */ CarouselComponentStyle.PageControlStyles previewPageControl$default(CarouselComponent.PageControl.Position position, int i, Object obj) {
        if ((i & 1) != 0) {
            position = CarouselComponent.PageControl.Position.BOTTOM;
        }
        return previewPageControl(position);
    }

    private static final CarouselComponentStyle.PageControlStyles previewPageControl(CarouselComponent.PageControl.Position position) {
        float f = 4;
        float f2 = 8;
        return new CarouselComponentStyle.PageControlStyles(position, C1486Dp.m11017constructorimpl(f), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f2)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f2)), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8179getGreen0d7_KjU())), null, 2, null), Shape.Pill.INSTANCE, new BorderStyles(C1486Dp.m11017constructorimpl(f), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(20), C1486Dp.m11017constructorimpl(f2), C1486Dp.m11017constructorimpl(f2), null), new CarouselComponentStyle.IndicatorStyles(C1486Dp.m11017constructorimpl(14), C1486Dp.m11017constructorimpl(10), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null), C1486Dp.m11015boximpl(C1486Dp.m11017constructorimpl(2)), null), new CarouselComponentStyle.IndicatorStyles(C1486Dp.m11017constructorimpl(f2), C1486Dp.m11017constructorimpl(f2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8178getGray0d7_KjU())), null, 2, null), null, null, null), null);
    }

    private static final List<StackComponentStyle> previewPages() {
        return CollectionsKt.listOf((Object[]) new StackComponentStyle[]{m13881previewPageecKwGiE("Page 1", Color.INSTANCE.m8182getRed0d7_KjU(), 200), m13881previewPageecKwGiE("Page 2", Color.INSTANCE.m8179getGreen0d7_KjU(), 100), m13881previewPageecKwGiE("Page 3", Color.INSTANCE.m8175getBlue0d7_KjU(), 300), m13881previewPageecKwGiE("Page 4", Color.INSTANCE.m8186getYellow0d7_KjU(), 200)});
    }

    /* JADX INFO: renamed from: previewPage-ecKwGiE, reason: not valid java name */
    private static final StackComponentStyle m13881previewPageecKwGiE(String str, long j, int i) {
        return new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle(str, (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.CENTER), true, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fixed(i, null)), C1486Dp.m11017constructorimpl(8), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(j)), null, 2, null))), PaddingKt.m2849PaddingValuesYgX7TsA$default(0.0f, C1486Dp.m11017constructorimpl(16), 1, null), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)), new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null), null, null, null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.p004ui.graphics.Shape PagerIndicator$lambda$19(State<? extends androidx.compose.p004ui.graphics.Shape> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Indicator$lambda$26(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Indicator$lambda$28(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    private static final float Indicator$lambda$30(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    private static final float Indicator$lambda$32(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    private static final float Indicator$lambda$33(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    private static final float Indicator$lambda$34(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Indicator$lambda$35(State<C1486Dp> state) {
        return state.getValue().m11031unboximpl();
    }
}
