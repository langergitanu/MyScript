package com.revenuecat.purchases.p036ui.revenuecatui.components.image;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.text.intl.Locale;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedImagePartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.FitModeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.ShapeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.SizeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.AspectRatio;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallStateStore;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.paywalls.components.PartialImageComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.ImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UnsignedKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: ImageComponentState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\r\u0012\u001a\b\u0002\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\r\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r¢\u0006\u0002\u0010\u001bJ>\u0010\u0081\u0001\u001a\u00030\u0082\u00012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\t¢\u0006\u0003\u0010\u0083\u0001JA\u0010\u0084\u0001\u001a\u00030\u0085\u0001*\u00030\u0085\u00012\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\b\u0010\u0089\u0001\u001a\u00030\u0088\u00012\u0006\u00104\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u001d\u0010\u008c\u0001\u001a\u00020l*\u00020l2\u0006\u0010?\u001a\u00020@2\u0006\u00104\u001a\u00020\u0005H\u0002R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\u0004\u0018\u00010#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020(8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b)\u0010*R \u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00160\rX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010-\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R+\u00104\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u0010:\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010!\u001a\u0004\b<\u0010=R\u001b\u0010?\u001a\u00020@8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010!\u001a\u0004\bA\u0010BR+\u0010D\u001a\u00020\t2\u0006\u0010,\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bI\u00103\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010J\u001a\u00020K8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010!\u001a\u0004\bL\u0010MR\u001d\u0010O\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010!\u001a\u0004\bP\u0010\u001fR\u001d\u0010R\u001a\u0004\u0018\u00010S8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010!\u001a\u0004\bT\u0010UR\u000e\u0010W\u001a\u00020XX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010Y\u001a\u00020K8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010!\u001a\u0004\bZ\u0010MR\u001d\u0010\\\u001a\u0004\u0018\u00010]8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010!\u001a\u0004\b^\u0010_R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010a\u001a\u0004\u0018\u00010b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010!\u001a\u0004\bc\u0010dR\u001d\u0010f\u001a\u0004\u0018\u00010g8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bj\u0010!\u001a\u0004\bh\u0010iR\u001b\u0010k\u001a\u00020l8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u0010!\u001a\u0004\bm\u0010nR\u001b\u0010p\u001a\u00020l8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\br\u0010!\u001a\u0004\bq\u0010nR\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010s\u001a\u00020t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010!\u001a\u0004\bu\u0010vR\u001b\u0010x\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bz\u0010!\u001a\u0004\by\u0010/R,\u0010{\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0013\n\u0005\b\u0080\u0001\u00103\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u008d\u0001"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/image/ImageComponentState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", "initialDensity", "Landroidx/compose/ui/unit/Density;", "initialDarkMode", "", "initialLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;", "localeProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/text/intl/Locale;", "selectedPackageInfoProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "stateStoreProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Landroidx/compose/ui/unit/Density;ZLandroidx/compose/ui/unit/LayoutDirection;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "aspectRatio", "Lcom/revenuecat/purchases/ui/revenuecatui/components/modifier/AspectRatio;", "getAspectRatio", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/modifier/AspectRatio;", "aspectRatio$delegate", "Landroidx/compose/runtime/State;", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "border$delegate", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "contentScale$delegate", "<set-?>", "darkMode", "getDarkMode", "()Z", "setDarkMode", "(Z)V", "darkMode$delegate", "Landroidx/compose/runtime/MutableState;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "imageAspectRatio", "", "getImageAspectRatio", "()F", "imageAspectRatio$delegate", "imageUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "getImageUrls", "()Lcom/revenuecat/purchases/paywalls/components/properties/ImageUrls;", "imageUrls$delegate", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "margin$delegate", "marginAdjustedAspectRatio", "getMarginAdjustedAspectRatio", "marginAdjustedAspectRatio$delegate", "overlay", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getOverlay", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "overlay$delegate", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "padding", "getPadding", "padding$delegate", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedImagePartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedImagePartial;", "presentedPartial$delegate", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "shadow$delegate", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "shape$delegate", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size$delegate", "sizePlusMargin", "getSizePlusMargin", "sizePlusMargin$delegate", "themeImageUrls", "Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "getThemeImageUrls", "()Lcom/revenuecat/purchases/paywalls/components/properties/ThemeImageUrls;", "themeImageUrls$delegate", "visible", "getVisible", "visible$delegate", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "update", "", "(Landroidx/window/core/layout/WindowWidthSizeClass;Landroidx/compose/ui/unit/Density;Ljava/lang/Boolean;Landroidx/compose/ui/unit/LayoutDirection;)V", "adjustDimension", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "other", "thisImageDimensionPx", "Lkotlin/UInt;", "otherImageDimensionPx", "adjustDimension-yOCu0fQ", "(Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;IILandroidx/compose/ui/unit/Density;)Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "adjustForImage", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class ImageComponentState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: aspectRatio$delegate, reason: from kotlin metadata */
    private final State aspectRatio;

    /* JADX INFO: renamed from: border$delegate, reason: from kotlin metadata */
    private final State border;

    /* JADX INFO: renamed from: contentScale$delegate, reason: from kotlin metadata */
    private final State contentScale;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;

    /* JADX INFO: renamed from: darkMode$delegate, reason: from kotlin metadata */
    private final MutableState darkMode;

    /* JADX INFO: renamed from: density$delegate, reason: from kotlin metadata */
    private final MutableState density;

    /* JADX INFO: renamed from: imageAspectRatio$delegate, reason: from kotlin metadata */
    private final State imageAspectRatio;

    /* JADX INFO: renamed from: imageUrls$delegate, reason: from kotlin metadata */
    private final State imageUrls;

    /* JADX INFO: renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;
    private final Function0<Locale> localeProvider;

    /* JADX INFO: renamed from: margin$delegate, reason: from kotlin metadata */
    private final State margin;

    /* JADX INFO: renamed from: marginAdjustedAspectRatio$delegate, reason: from kotlin metadata */
    private final State marginAdjustedAspectRatio;

    /* JADX INFO: renamed from: overlay$delegate, reason: from kotlin metadata */
    private final State overlay;
    private final PackageAwareDelegate packageAwareDelegate;

    /* JADX INFO: renamed from: padding$delegate, reason: from kotlin metadata */
    private final State padding;

    /* JADX INFO: renamed from: presentedPartial$delegate, reason: from kotlin metadata */
    private final State presentedPartial;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;

    /* JADX INFO: renamed from: shadow$delegate, reason: from kotlin metadata */
    private final State shadow;

    /* JADX INFO: renamed from: shape$delegate, reason: from kotlin metadata */
    private final State shape;

    /* JADX INFO: renamed from: size$delegate, reason: from kotlin metadata */
    private final State size;

    /* JADX INFO: renamed from: sizePlusMargin$delegate, reason: from kotlin metadata */
    private final State sizePlusMargin;
    private final Function0<PaywallStateStore> stateStoreProvider;
    private final ImageComponentStyle style;

    /* JADX INFO: renamed from: themeImageUrls$delegate, reason: from kotlin metadata */
    private final State themeImageUrls;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final State visible;

    /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
    private final MutableState windowSize;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageComponentState(WindowWidthSizeClass initialWindowSize, Density initialDensity, boolean z, LayoutDirection initialLayoutDirection, ImageComponentStyle style, Function0<Locale> localeProvider, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider, Function0<PaywallStateStore> stateStoreProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
        Intrinsics.checkNotNullParameter(initialDensity, "initialDensity");
        Intrinsics.checkNotNullParameter(initialLayoutDirection, "initialLayoutDirection");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(localeProvider, "localeProvider");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        Intrinsics.checkNotNullParameter(customVariablesProvider, "customVariablesProvider");
        Intrinsics.checkNotNullParameter(stateStoreProvider, "stateStoreProvider");
        this.style = style;
        this.localeProvider = localeProvider;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.customVariablesProvider = customVariablesProvider;
        this.stateStoreProvider = stateStoreProvider;
        this.windowSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialWindowSize, null, 2, null);
        this.density = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialDensity, null, 2, null);
        this.darkMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z), null, 2, null);
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialLayoutDirection, null, 2, null);
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0<PresentedImagePartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$presentedPartial$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PresentedImagePartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedImagePartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke(), new C76201(this.this$0.stateStoreProvider.invoke())));
            }

            /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$presentedPartial$2$1 */
            /* JADX INFO: compiled from: ImageComponentState.kt */
            @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
            /* synthetic */ class C76201 extends FunctionReferenceImpl implements Function1<String, JsonPrimitive> {
                C76201(Object obj) {
                    super(1, obj, PaywallStateStore.class, "currentValueOrDefault", "currentValueOrDefault(Ljava/lang/String;)Lkotlinx/serialization/json/JsonPrimitive;", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public final JsonPrimitive invoke(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    return ((PaywallStateStore) this.receiver).currentValueOrDefault(p0);
                }
            }
        });
        this.themeImageUrls = SnapshotStateKt.derivedStateOf(new Function0<ThemeImageUrls>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$themeImageUrls$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final ThemeImageUrls invoke() {
                NonEmptyMap sources;
                ThemeImageUrls themeImageUrls;
                String localeId = LocalizationKt.toLocaleId((Locale) this.this$0.localeProvider.invoke());
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial != null && (sources = presentedPartial.getSources()) != null && (themeImageUrls = (ThemeImageUrls) sources.getOrDefault(LocaleId.m13797boximpl(localeId), sources.getEntry().getValue())) != null) {
                    return themeImageUrls;
                }
                NonEmptyMap sources2 = this.this$0.style.getSources();
                return (ThemeImageUrls) sources2.getOrDefault(LocaleId.m13797boximpl(localeId), sources2.getEntry().getValue());
            }
        });
        this.visible = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$visible$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialImageComponent partial;
                Boolean visible;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.imageUrls = SnapshotStateKt.derivedStateOf(new Function0<ImageUrls>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$imageUrls$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageUrls invoke() {
                ImageUrls dark;
                return (!this.this$0.getDarkMode() || (dark = this.this$0.getThemeImageUrls().getDark()) == null) ? this.this$0.getThemeImageUrls().getLight() : dark;
            }
        });
        this.imageAspectRatio = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$imageAspectRatio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(((float) UnsignedKt.uintToDouble(this.this$0.getImageUrls().getWidth())) / ((float) UnsignedKt.uintToDouble(this.this$0.getImageUrls().getHeight())));
            }
        });
        this.size = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$size$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                Size size;
                PartialImageComponent partial;
                ImageComponentState imageComponentState = this.this$0;
                PresentedImagePartial presentedPartial = imageComponentState.getPresentedPartial();
                if (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) {
                    size = this.this$0.style.getSize();
                }
                return imageComponentState.adjustForImage(size, this.this$0.getImageUrls(), this.this$0.getDensity());
            }
        });
        this.aspectRatio = SnapshotStateKt.derivedStateOf(new Function0<AspectRatio>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$aspectRatio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AspectRatio invoke() {
                Size size = this.this$0.getSize();
                ImageComponentState imageComponentState = this.this$0;
                SizeConstraint height = size.getHeight();
                if (height instanceof SizeConstraint.Fit) {
                    SizeConstraint width = size.getWidth();
                    if (!(width instanceof SizeConstraint.Fit) && !(width instanceof SizeConstraint.Fill)) {
                        if (width instanceof SizeConstraint.Fixed) {
                            return null;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    return new AspectRatio(imageComponentState.getImageAspectRatio(), true);
                }
                if (height instanceof SizeConstraint.Fill) {
                    SizeConstraint width2 = size.getWidth();
                    if (width2 instanceof SizeConstraint.Fit) {
                        return new AspectRatio(imageComponentState.getImageAspectRatio(), false);
                    }
                    if ((width2 instanceof SizeConstraint.Fill) || (width2 instanceof SizeConstraint.Fixed)) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (!(height instanceof SizeConstraint.Fixed)) {
                    throw new NoWhenBranchMatchedException();
                }
                SizeConstraint width3 = size.getWidth();
                if ((width3 instanceof SizeConstraint.Fit) || (width3 instanceof SizeConstraint.Fill)) {
                    return null;
                }
                if (width3 instanceof SizeConstraint.Fixed) {
                    return new AspectRatio(((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) width3).getValue())) / ((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) height).getValue())), true);
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        this.padding = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$padding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialImageComponent partial;
                Padding padding;
                PaddingValues paddingValues$default;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues$default = PaddingKt.toPaddingValues$default(padding, false, 1, null)) == null) ? this.this$0.style.getPadding() : paddingValues$default;
            }
        });
        this.margin = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$margin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialImageComponent partial;
                Padding margin;
                PaddingValues paddingValues$default;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues$default = PaddingKt.toPaddingValues$default(margin, false, 1, null)) == null) ? this.this$0.style.getMargin() : paddingValues$default;
            }
        });
        this.sizePlusMargin = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$sizePlusMargin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                return SizeKt.addMargin(this.this$0.getSize(), this.this$0.getMargin(), this.this$0.getLayoutDirection());
            }
        });
        this.marginAdjustedAspectRatio = SnapshotStateKt.derivedStateOf(new Function0<AspectRatio>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$marginAdjustedAspectRatio$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AspectRatio invoke() {
                Size sizePlusMargin = this.this$0.getSizePlusMargin();
                SizeConstraint height = sizePlusMargin.getHeight();
                if (height instanceof SizeConstraint.Fixed) {
                    SizeConstraint width = sizePlusMargin.getWidth();
                    if (width instanceof SizeConstraint.Fit ? true : width instanceof SizeConstraint.Fill) {
                        return null;
                    }
                    if (width instanceof SizeConstraint.Fixed) {
                        return new AspectRatio(((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) width).getValue())) / ((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) height).getValue())), true);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                if (height instanceof SizeConstraint.Fit ? true : height instanceof SizeConstraint.Fill) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        });
        this.shape = SnapshotStateKt.derivedStateOf(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$shape$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                PartialImageComponent partial;
                MaskShape maskShape;
                Shape shape;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (maskShape = partial.getMaskShape()) == null || (shape = ShapeKt.toShape(maskShape)) == null) ? this.this$0.style.getShape() : shape;
            }
        });
        this.border = SnapshotStateKt.derivedStateOf(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$border$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                BorderStyles border;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (border = presentedPartial.getBorder()) == null) ? this.this$0.style.getBorder() : border;
            }
        });
        this.shadow = SnapshotStateKt.derivedStateOf(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$shadow$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                ShadowStyles shadow;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (shadow = presentedPartial.getShadow()) == null) ? this.this$0.style.getShadow() : shadow;
            }
        });
        this.overlay = SnapshotStateKt.derivedStateOf(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$overlay$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                ColorStyles overlay;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (overlay = presentedPartial.getOverlay()) == null) ? this.this$0.style.getOverlay() : overlay;
            }
        });
        this.contentScale = SnapshotStateKt.derivedStateOf(new Function0<ContentScale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState$contentScale$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ContentScale invoke() {
                PartialImageComponent partial;
                FitMode fitMode;
                ContentScale contentScale;
                PresentedImagePartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (fitMode = partial.getFitMode()) == null || (contentScale = FitModeKt.toContentScale(fitMode)) == null) ? this.this$0.style.getContentScale() : contentScale;
            }
        });
    }

    public /* synthetic */ ImageComponentState(WindowWidthSizeClass windowWidthSizeClass, Density density, boolean z, LayoutDirection layoutDirection, ImageComponentStyle imageComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, density, z, layoutDirection, imageComponentStyle, function0, function02, function03, function04, (i & 512) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function05, (i & 1024) != 0 ? new Function0<PaywallStateStore>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentState.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaywallStateStore invoke() {
                return new PaywallStateStore(MapsKt.emptyMap());
            }
        } : function06);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final WindowWidthSizeClass getWindowSize() {
        return (WindowWidthSizeClass) this.windowSize.getValue();
    }

    private final void setWindowSize(WindowWidthSizeClass windowWidthSizeClass) {
        this.windowSize.setValue(windowWidthSizeClass);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Density getDensity() {
        return (Density) this.density.getValue();
    }

    private final void setDensity(Density density) {
        this.density.setValue(density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getDarkMode() {
        return ((Boolean) this.darkMode.getValue()).booleanValue();
    }

    private final void setDarkMode(boolean z) {
        this.darkMode.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedImagePartial getPresentedPartial() {
        return (PresentedImagePartial) this.presentedPartial.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ThemeImageUrls getThemeImageUrls() {
        return (ThemeImageUrls) this.themeImageUrls.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public final /* synthetic */ ImageUrls getImageUrls() {
        return (ImageUrls) this.imageUrls.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getImageAspectRatio() {
        return ((Number) this.imageAspectRatio.getValue()).floatValue();
    }

    public final /* synthetic */ Size getSize() {
        return (Size) this.size.getValue();
    }

    public final /* synthetic */ AspectRatio getAspectRatio() {
        return (AspectRatio) this.aspectRatio.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin.getValue();
    }

    public final /* synthetic */ Size getSizePlusMargin() {
        return (Size) this.sizePlusMargin.getValue();
    }

    public final /* synthetic */ AspectRatio getMarginAdjustedAspectRatio() {
        return (AspectRatio) this.marginAdjustedAspectRatio.getValue();
    }

    public final /* synthetic */ Shape getShape() {
        return (Shape) this.shape.getValue();
    }

    public final /* synthetic */ BorderStyles getBorder() {
        return (BorderStyles) this.border.getValue();
    }

    public final /* synthetic */ ShadowStyles getShadow() {
        return (ShadowStyles) this.shadow.getValue();
    }

    public final /* synthetic */ ColorStyles getOverlay() {
        return (ColorStyles) this.overlay.getValue();
    }

    public final /* synthetic */ ContentScale getContentScale() {
        return (ContentScale) this.contentScale.getValue();
    }

    public static /* synthetic */ void update$default(ImageComponentState imageComponentState, WindowWidthSizeClass windowWidthSizeClass, Density density, Boolean bool, LayoutDirection layoutDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            windowWidthSizeClass = null;
        }
        if ((i & 2) != 0) {
            density = null;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        if ((i & 8) != 0) {
            layoutDirection = null;
        }
        imageComponentState.update(windowWidthSizeClass, density, bool, layoutDirection);
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowSize, Density density, Boolean darkMode, LayoutDirection layoutDirection) {
        if (windowSize != null) {
            setWindowSize(windowSize);
        }
        if (density != null) {
            setDensity(density);
        }
        if (darkMode != null) {
            setDarkMode(darkMode.booleanValue());
        }
        if (layoutDirection != null) {
            setLayoutDirection(layoutDirection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Size adjustForImage(Size size, ImageUrls imageUrls, Density density) {
        return new Size(m13888adjustDimensionyOCu0fQ(size.getWidth(), size.getHeight(), imageUrls.getWidth(), imageUrls.getHeight(), density), m13888adjustDimensionyOCu0fQ(size.getHeight(), size.getWidth(), imageUrls.getHeight(), imageUrls.getWidth(), density));
    }

    /* JADX INFO: renamed from: adjustDimension-yOCu0fQ, reason: not valid java name */
    private final SizeConstraint m13888adjustDimensionyOCu0fQ(SizeConstraint sizeConstraint, SizeConstraint sizeConstraint2, int i, int i2, Density density) {
        if (sizeConstraint instanceof SizeConstraint.Fit) {
            if (sizeConstraint2 instanceof SizeConstraint.Fit) {
                return new SizeConstraint.Fixed(UnsignedKt.doubleToUInt(density.mo2188toDpu2uoSUM(i)), null);
            }
            if (!(sizeConstraint2 instanceof SizeConstraint.Fill)) {
                if (sizeConstraint2 instanceof SizeConstraint.Fixed) {
                    return new SizeConstraint.Fixed(UnsignedKt.doubleToUInt(density.mo2187toDpu2uoSUM((((float) UnsignedKt.uintToDouble(((SizeConstraint.Fixed) sizeConstraint2).getValue())) / density.mo2188toDpu2uoSUM(i2)) * i)), null);
                }
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (!(sizeConstraint instanceof SizeConstraint.Fill ? true : sizeConstraint instanceof SizeConstraint.Fixed)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return sizeConstraint;
    }
}
