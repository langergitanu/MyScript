package com.revenuecat.purchases.p036ui.revenuecatui.components.stack;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedStackPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.BadgeStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallStateStore;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.OverflowExtensionsKt;
import com.revenuecat.purchases.paywalls.components.PartialStackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: StackComponentState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\t\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\t¢\u0006\u0002\u0010\u0015J\u001e\u0010s\u001a\u00020t2\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0005J\u001c\u0010u\u001a\u00020a*\u00020a2\u0006\u0010B\u001a\u00020C2\u0006\u0010;\u001a\u00020\u0005H\u0002R\u0013\u0010\u0016\u001a\u00020\u00178F¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u00020\u00178F¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u001c\u001a\u00020\u00178F¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u001f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u001d\u0010$\u001a\u0004\u0018\u00010%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u0004\u0018\u00010*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b+\u0010,R\u0019\u0010.\u001a\b\u0012\u0004\u0012\u0002000/8F¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00103\u001a\u0002048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010#\u001a\u0004\b5\u00106R\u0013\u00108\u001a\u00020\u00178F¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0019R+\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001b\u0010B\u001a\u00020C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bF\u0010#\u001a\u0004\bD\u0010ER\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010I\u001a\u00020C8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bK\u0010#\u001a\u0004\bJ\u0010ER\u001d\u0010L\u001a\u0004\u0018\u00010M8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010#\u001a\u0004\bN\u0010OR\u001d\u0010Q\u001a\u0004\u0018\u00010R8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010#\u001a\u0004\bS\u0010TR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010V\u001a\u0004\u0018\u00010W8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010#\u001a\u0004\bX\u0010YR\u001b\u0010[\u001a\u00020\\8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010#\u001a\u0004\b]\u0010^R\u001b\u0010`\u001a\u00020a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bd\u0010#\u001a\u0004\bb\u0010cR!\u0010e\u001a\u00020f8FX\u0086\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bi\u0010#\u001a\u0004\bg\u0010hR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010j\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010#\u001a\u0004\bk\u0010\u0019R+\u0010m\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\br\u0010A\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006v"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/stack/StackComponentState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", "initialLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "selectedPackageInfoProvider", "Lkotlin/Function0;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "stateStoreProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Landroidx/compose/ui/unit/LayoutDirection;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "applyBottomWindowInsets", "", "getApplyBottomWindowInsets", "()Z", "applyHorizontalWindowInsets", "getApplyHorizontalWindowInsets", "applyTopWindowInsets", "getApplyTopWindowInsets", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "getBackground", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "background$delegate", "Landroidx/compose/runtime/State;", "badge", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "getBadge", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/BadgeStyle;", "badge$delegate", OutlinedTextFieldKt.BorderId, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "getBorder", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BorderStyles;", "border$delegate", "children", "", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "getChildren", "()Ljava/util/List;", TypedValues.Custom.S_DIMENSION, "Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "getDimension", "()Lcom/revenuecat/purchases/paywalls/components/properties/Dimension;", "dimension$delegate", "ignoreHeaderHeight", "getIgnoreHeaderHeight", "<set-?>", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "Landroidx/compose/runtime/MutableState;", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "margin$delegate", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "padding", "getPadding", "padding$delegate", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedStackPartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PresentedStackPartial;", "presentedPartial$delegate", "scrollOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "getScrollOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "scrollOrientation$delegate", "shadow", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "getShadow", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ShadowStyles;", "shadow$delegate", "shape", "Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "getShape", "()Lcom/revenuecat/purchases/paywalls/components/properties/Shape;", "shape$delegate", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size$delegate", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "spacing$delegate", "visible", "getVisible", "visible$delegate", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "update", "", "adjustForMargin", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class StackComponentState {
    public static final int $stable = 0;
    private final boolean applyBottomWindowInsets;
    private final boolean applyHorizontalWindowInsets;
    private final boolean applyTopWindowInsets;

    /* JADX INFO: renamed from: background$delegate, reason: from kotlin metadata */
    private final State background;

    /* JADX INFO: renamed from: badge$delegate, reason: from kotlin metadata */
    private final State badge;

    /* JADX INFO: renamed from: border$delegate, reason: from kotlin metadata */
    private final State border;
    private final List<ComponentStyle> children;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;

    /* JADX INFO: renamed from: dimension$delegate, reason: from kotlin metadata */
    private final State dimension;
    private final boolean ignoreHeaderHeight;

    /* JADX INFO: renamed from: layoutDirection$delegate, reason: from kotlin metadata */
    private final MutableState layoutDirection;

    /* JADX INFO: renamed from: margin$delegate, reason: from kotlin metadata */
    private final State margin;
    private final PackageAwareDelegate packageAwareDelegate;

    /* JADX INFO: renamed from: padding$delegate, reason: from kotlin metadata */
    private final State padding;

    /* JADX INFO: renamed from: presentedPartial$delegate, reason: from kotlin metadata */
    private final State presentedPartial;

    /* JADX INFO: renamed from: scrollOrientation$delegate, reason: from kotlin metadata */
    private final State scrollOrientation;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;

    /* JADX INFO: renamed from: shadow$delegate, reason: from kotlin metadata */
    private final State shadow;

    /* JADX INFO: renamed from: shape$delegate, reason: from kotlin metadata */
    private final State shape;

    /* JADX INFO: renamed from: size$delegate, reason: from kotlin metadata */
    private final State size;

    /* JADX INFO: renamed from: spacing$delegate, reason: from kotlin metadata */
    private final State spacing;
    private final Function0<PaywallStateStore> stateStoreProvider;
    private final StackComponentStyle style;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final State visible;

    /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
    private final MutableState windowSize;

    /* JADX WARN: Multi-variable type inference failed */
    public StackComponentState(WindowWidthSizeClass initialWindowSize, LayoutDirection initialLayoutDirection, StackComponentStyle style, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider, Function0<PaywallStateStore> stateStoreProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
        Intrinsics.checkNotNullParameter(initialLayoutDirection, "initialLayoutDirection");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(selectedPackageInfoProvider, "selectedPackageInfoProvider");
        Intrinsics.checkNotNullParameter(selectedTabIndexProvider, "selectedTabIndexProvider");
        Intrinsics.checkNotNullParameter(selectedOfferEligibilityProvider, "selectedOfferEligibilityProvider");
        Intrinsics.checkNotNullParameter(customVariablesProvider, "customVariablesProvider");
        Intrinsics.checkNotNullParameter(stateStoreProvider, "stateStoreProvider");
        this.style = style;
        this.selectedPackageInfoProvider = selectedPackageInfoProvider;
        this.selectedTabIndexProvider = selectedTabIndexProvider;
        this.selectedOfferEligibilityProvider = selectedOfferEligibilityProvider;
        this.customVariablesProvider = customVariablesProvider;
        this.stateStoreProvider = stateStoreProvider;
        this.windowSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialWindowSize, null, 2, null);
        this.layoutDirection = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialLayoutDirection, null, 2, null);
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0<PresentedStackPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$presentedPartial$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PresentedStackPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (PresentedStackPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke(), new C76871(this.this$0.stateStoreProvider.invoke())));
            }

            /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$presentedPartial$2$1 */
            /* JADX INFO: compiled from: StackComponentState.kt */
            @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
            /* synthetic */ class C76871 extends FunctionReferenceImpl implements Function1<String, JsonPrimitive> {
                C76871(Object obj) {
                    super(1, obj, PaywallStateStore.class, "currentValueOrDefault", "currentValueOrDefault(Ljava/lang/String;)Lkotlinx/serialization/json/JsonPrimitive;", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public final JsonPrimitive invoke(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    return ((PaywallStateStore) this.receiver).currentValueOrDefault(p0);
                }
            }
        });
        this.visible = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$visible$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialStackComponent partial;
                Boolean visible;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.children = style.getChildren();
        this.applyTopWindowInsets = style.getApplyTopWindowInsets();
        this.ignoreHeaderHeight = style.getIgnoreHeaderHeight();
        this.applyBottomWindowInsets = style.getApplyBottomWindowInsets();
        this.applyHorizontalWindowInsets = style.getApplyHorizontalWindowInsets();
        this.dimension = SnapshotStateKt.derivedStateOf(new Function0<Dimension>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$dimension$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Dimension invoke() {
                PartialStackComponent partial;
                Dimension dimension;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (dimension = partial.getDimension()) == null) ? this.this$0.style.getDimension() : dimension;
            }
        });
        this.spacing = SnapshotStateKt.derivedStateOf(new Function0<C1486Dp>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$spacing$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ C1486Dp invoke() {
                return C1486Dp.m11015boximpl(m13980invokeD9Ej5fM());
            }

            /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
            public final float m13980invokeD9Ej5fM() {
                PartialStackComponent partial;
                Float spacing;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (spacing = partial.getSpacing()) == null) {
                    return this.this$0.style.m14007getSpacingD9Ej5fM();
                }
                return C1486Dp.m11017constructorimpl(spacing.floatValue());
            }
        });
        this.background = SnapshotStateKt.derivedStateOf(new Function0<BackgroundStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$background$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackgroundStyles invoke() {
                BackgroundStyles backgroundStyles;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (backgroundStyles = presentedPartial.getBackgroundStyles()) == null) ? this.this$0.style.getBackground() : backgroundStyles;
            }
        });
        this.padding = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$padding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialStackComponent partial;
                Padding padding;
                PaddingValues paddingValues$default;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues$default = PaddingKt.toPaddingValues$default(padding, false, 1, null)) == null) ? this.this$0.style.getPadding() : paddingValues$default;
            }
        });
        this.margin = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$margin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialStackComponent partial;
                Padding margin;
                PaddingValues paddingValues$default;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues$default = PaddingKt.toPaddingValues$default(margin, false, 1, null)) == null) ? this.this$0.style.getMargin() : paddingValues$default;
            }
        });
        this.size = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$size$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                Size size;
                PartialStackComponent partial;
                StackComponentState stackComponentState = this.this$0;
                PresentedStackPartial presentedPartial = stackComponentState.getPresentedPartial();
                if (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) {
                    size = this.this$0.style.getSize();
                }
                return stackComponentState.adjustForMargin(size, this.this$0.getMargin(), this.this$0.getLayoutDirection());
            }
        });
        this.shape = SnapshotStateKt.derivedStateOf(new Function0<Shape>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$shape$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Shape invoke() {
                PartialStackComponent partial;
                Shape shape;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (shape = partial.getShape()) == null) ? this.this$0.style.getShape() : shape;
            }
        });
        this.border = SnapshotStateKt.derivedStateOf(new Function0<BorderStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$border$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BorderStyles invoke() {
                BorderStyles borderStyles;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (borderStyles = presentedPartial.getBorderStyles()) == null) ? this.this$0.style.getBorder() : borderStyles;
            }
        });
        this.shadow = SnapshotStateKt.derivedStateOf(new Function0<ShadowStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$shadow$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ShadowStyles invoke() {
                ShadowStyles shadowStyles;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (shadowStyles = presentedPartial.getShadowStyles()) == null) ? this.this$0.style.getShadow() : shadowStyles;
            }
        });
        this.badge = SnapshotStateKt.derivedStateOf(new Function0<BadgeStyle>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$badge$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BadgeStyle invoke() {
                BadgeStyle badgeStyle;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (badgeStyle = presentedPartial.getBadgeStyle()) == null) ? this.this$0.style.getBadge() : badgeStyle;
            }
        });
        this.scrollOrientation = SnapshotStateKt.derivedStateOf(new Function0<Orientation>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState$scrollOrientation$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Orientation invoke() {
                PartialStackComponent partial;
                StackComponent.Overflow overflow;
                Orientation orientation;
                PresentedStackPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (overflow = partial.getOverflow()) == null || (orientation = OverflowExtensionsKt.toOrientation(overflow, this.this$0.getDimension())) == null) ? this.this$0.style.getScrollOrientation() : orientation;
            }
        });
    }

    public /* synthetic */ StackComponentState(WindowWidthSizeClass windowWidthSizeClass, LayoutDirection layoutDirection, StackComponentStyle stackComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, layoutDirection, stackComponentStyle, function0, function02, function03, (i & 64) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function04, (i & 128) != 0 ? new Function0<PaywallStateStore>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.stack.StackComponentState.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaywallStateStore invoke() {
                return new PaywallStateStore(MapsKt.emptyMap());
            }
        } : function05);
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
    /* JADX WARN: Multi-variable type inference failed */
    public final LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection.getValue();
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection.setValue(layoutDirection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentedStackPartial getPresentedPartial() {
        return (PresentedStackPartial) this.presentedPartial.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public final /* synthetic */ List getChildren() {
        return this.children;
    }

    public final /* synthetic */ boolean getApplyTopWindowInsets() {
        return this.applyTopWindowInsets;
    }

    public final /* synthetic */ boolean getIgnoreHeaderHeight() {
        return this.ignoreHeaderHeight;
    }

    public final /* synthetic */ boolean getApplyBottomWindowInsets() {
        return this.applyBottomWindowInsets;
    }

    public final /* synthetic */ boolean getApplyHorizontalWindowInsets() {
        return this.applyHorizontalWindowInsets;
    }

    public final /* synthetic */ Dimension getDimension() {
        return (Dimension) this.dimension.getValue();
    }

    /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
    public final /* synthetic */ float m13979getSpacingD9Ej5fM() {
        return ((C1486Dp) this.spacing.getValue()).m11031unboximpl();
    }

    public final /* synthetic */ BackgroundStyles getBackground() {
        return (BackgroundStyles) this.background.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin.getValue();
    }

    public final /* synthetic */ Size getSize() {
        return (Size) this.size.getValue();
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

    public final /* synthetic */ BadgeStyle getBadge() {
        return (BadgeStyle) this.badge.getValue();
    }

    public final /* synthetic */ Orientation getScrollOrientation() {
        return (Orientation) this.scrollOrientation.getValue();
    }

    public static /* synthetic */ void update$default(StackComponentState stackComponentState, WindowWidthSizeClass windowWidthSizeClass, LayoutDirection layoutDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            windowWidthSizeClass = null;
        }
        if ((i & 2) != 0) {
            layoutDirection = null;
        }
        stackComponentState.update(windowWidthSizeClass, layoutDirection);
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowSize, LayoutDirection layoutDirection) {
        if (windowSize != null) {
            setWindowSize(windowSize);
        }
        if (layoutDirection != null) {
            setLayoutDirection(layoutDirection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Size adjustForMargin(Size size, PaddingValues paddingValues, LayoutDirection layoutDirection) {
        SizeConstraint.Fixed width = size.getWidth();
        if (width instanceof SizeConstraint.Fixed) {
            width = new SizeConstraint.Fixed(UInt.m14594constructorimpl(UInt.m14594constructorimpl(((SizeConstraint.Fixed) width).getValue() + UnsignedKt.doubleToUInt(androidx.compose.foundation.layout.PaddingKt.calculateStartPadding(paddingValues, layoutDirection))) + UnsignedKt.doubleToUInt(androidx.compose.foundation.layout.PaddingKt.calculateEndPadding(paddingValues, layoutDirection))), null);
        } else {
            if (!(width instanceof SizeConstraint.Fill ? true : width instanceof SizeConstraint.Fit)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        SizeConstraint.Fixed height = size.getHeight();
        if (height instanceof SizeConstraint.Fixed) {
            height = new SizeConstraint.Fixed(UInt.m14594constructorimpl(UInt.m14594constructorimpl(((SizeConstraint.Fixed) height).getValue() + UnsignedKt.doubleToUInt(paddingValues.getTop())) + UnsignedKt.doubleToUInt(paddingValues.getBottom())), null);
        } else {
            if (!(height instanceof SizeConstraint.Fill ? true : height instanceof SizeConstraint.Fit)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return new Size(width, height);
    }
}
