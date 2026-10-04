package com.revenuecat.purchases.p036ui.revenuecatui.components.text;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.intl.Locale;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ComponentViewState;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ConditionContext;
import com.revenuecat.purchases.p036ui.revenuecatui.components.LocalizedTextPartial;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PresentedPartialKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ScreenCondition;
import com.revenuecat.purchases.p036ui.revenuecatui.components.countdown.CountdownTime;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.AlignmentKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.FontKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.PaddingKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.FontSpecKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.state.PackageAwareDelegate;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallStateStore;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.NonEmptyMap;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.PartialTextComponent;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: compiled from: TextComponentState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007\u0012\u001a\b\u0002\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u0007\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007¢\u0006\u0002\u0010\u0015J \u0010\u0080\u0001\u001a\u00030\u0081\u00012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b\"\u0010\u001fR\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b&\u0010'R/\u0010*\u001a\u0004\u0018\u00010)2\b\u0010(\u001a\u0004\u0018\u00010)8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00101\u001a\u0004\u0018\u0001028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001b\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001b\u001a\u0004\b7\u00108R\u001d\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u001b\u001a\u0004\b<\u0010=R\u001d\u0010?\u001a\u0004\u0018\u00010@8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u001b\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bH\u0010\u001b\u001a\u0004\bF\u0010GR!\u0010I\u001a\u00020J8BX\u0082\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bM\u0010\u001b\u001a\u0004\bK\u0010LR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010N\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00110O8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\u001b\u001a\u0004\bQ\u0010RR\u001b\u0010T\u001a\u00020U8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u001b\u001a\u0004\bV\u0010WR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010[\u001a\u00020U8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b]\u0010\u001b\u001a\u0004\b\\\u0010WR\u001d\u0010^\u001a\u0004\u0018\u00010_8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u001b\u001a\u0004\b`\u0010aR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010c\u001a\u00020d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bg\u0010\u001b\u001a\u0004\be\u0010fR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010h\u001a\u0004\u0018\u00010i8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\u001b\u001a\u0004\bj\u0010kR\u001b\u0010m\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\u001b\u001a\u0004\bn\u0010LR#\u0010p\u001a\u0004\u0018\u00010q8FX\u0086\u0084\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\bt\u0010\u001b\u001a\u0004\br\u0010sR\u001b\u0010u\u001a\u00020v8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\by\u0010\u001b\u001a\u0004\bw\u0010xR+\u0010z\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u007f\u00100\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0082\u0001"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/text/TextComponentState;", "", "initialWindowSize", "Landroidx/window/core/layout/WindowWidthSizeClass;", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "localeProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/text/intl/Locale;", "selectedPackageInfoProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "stateStoreProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;", "(Landroidx/window/core/layout/WindowWidthSizeClass;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "applicablePackage", "Lcom/revenuecat/purchases/Package;", "getApplicablePackage", "()Lcom/revenuecat/purchases/Package;", "applicablePackage$delegate", "Landroidx/compose/runtime/State;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "getBackgroundColor", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyles;", "backgroundColor$delegate", "color", "getColor", "color$delegate", "countFrom", "Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "getCountFrom", "()Lcom/revenuecat/purchases/paywalls/components/CountdownComponent$CountFrom;", "<set-?>", "Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;", "countdownTime", "getCountdownTime", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;", "setCountdownTime", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/countdown/CountdownTime;)V", "countdownTime$delegate", "Landroidx/compose/runtime/MutableState;", TtmlNode.ATTR_TTS_FONT_FAMILY, "Landroidx/compose/ui/text/font/FontFamily;", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "fontFamily$delegate", TtmlNode.ATTR_TTS_FONT_SIZE, "getFontSize", "()I", "fontSize$delegate", "fontSpec", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "getFontSpec", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/FontSpec;", "fontSpec$delegate", TtmlNode.ATTR_TTS_FONT_WEIGHT, "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "fontWeight$delegate", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "getHorizontalAlignment", "()Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment$delegate", "localeId", "Lcom/revenuecat/purchases/paywalls/components/common/LocaleId;", "getLocaleId-uqtKvyA", "()Ljava/lang/String;", "localeId$delegate", "localizedVariableKeys", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "Lcom/revenuecat/purchases/paywalls/components/common/VariableLocalizationKey;", "getLocalizedVariableKeys", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/NonEmptyMap;", "localizedVariableKeys$delegate", "margin", "Landroidx/compose/foundation/layout/PaddingValues;", "getMargin", "()Landroidx/compose/foundation/layout/PaddingValues;", "margin$delegate", "packageAwareDelegate", "Lcom/revenuecat/purchases/ui/revenuecatui/components/state/PackageAwareDelegate;", "padding", "getPadding", "padding$delegate", "presentedPartial", "Lcom/revenuecat/purchases/ui/revenuecatui/components/LocalizedTextPartial;", "getPresentedPartial", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/LocalizedTextPartial;", "presentedPartial$delegate", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "getSize", "()Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "size$delegate", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "getSubscriptionOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "subscriptionOption$delegate", "text", "getText", "text$delegate", TtmlNode.ATTR_TTS_TEXT_ALIGN, "Landroidx/compose/ui/text/style/TextAlign;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "textAlign$delegate", "visible", "", "getVisible", "()Z", "visible$delegate", "windowSize", "getWindowSize", "()Landroidx/window/core/layout/WindowWidthSizeClass;", "setWindowSize", "(Landroidx/window/core/layout/WindowWidthSizeClass;)V", "windowSize$delegate", "update", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class TextComponentState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: applicablePackage$delegate, reason: from kotlin metadata */
    private final State applicablePackage;

    /* JADX INFO: renamed from: backgroundColor$delegate, reason: from kotlin metadata */
    private final State backgroundColor;

    /* JADX INFO: renamed from: color$delegate, reason: from kotlin metadata */
    private final State color;

    /* JADX INFO: renamed from: countdownTime$delegate, reason: from kotlin metadata */
    private final MutableState countdownTime;
    private final Function0<Map<String, CustomVariableValue>> customVariablesProvider;

    /* JADX INFO: renamed from: fontFamily$delegate, reason: from kotlin metadata */
    private final State fontFamily;

    /* JADX INFO: renamed from: fontSize$delegate, reason: from kotlin metadata */
    private final State fontSize;

    /* JADX INFO: renamed from: fontSpec$delegate, reason: from kotlin metadata */
    private final State fontSpec;

    /* JADX INFO: renamed from: fontWeight$delegate, reason: from kotlin metadata */
    private final State fontWeight;

    /* JADX INFO: renamed from: horizontalAlignment$delegate, reason: from kotlin metadata */
    private final State horizontalAlignment;

    /* JADX INFO: renamed from: localeId$delegate, reason: from kotlin metadata */
    private final State localeId;
    private final Function0<Locale> localeProvider;

    /* JADX INFO: renamed from: localizedVariableKeys$delegate, reason: from kotlin metadata */
    private final State localizedVariableKeys;

    /* JADX INFO: renamed from: margin$delegate, reason: from kotlin metadata */
    private final State margin;
    private final PackageAwareDelegate packageAwareDelegate;

    /* JADX INFO: renamed from: padding$delegate, reason: from kotlin metadata */
    private final State padding;

    /* JADX INFO: renamed from: presentedPartial$delegate, reason: from kotlin metadata */
    private final State presentedPartial;
    private final Function0<OfferEligibility> selectedOfferEligibilityProvider;
    private final Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider;
    private final Function0<Integer> selectedTabIndexProvider;

    /* JADX INFO: renamed from: size$delegate, reason: from kotlin metadata */
    private final State size;
    private final Function0<PaywallStateStore> stateStoreProvider;
    private final TextComponentStyle style;

    /* JADX INFO: renamed from: subscriptionOption$delegate, reason: from kotlin metadata */
    private final State subscriptionOption;

    /* JADX INFO: renamed from: text$delegate, reason: from kotlin metadata */
    private final State text;

    /* JADX INFO: renamed from: textAlign$delegate, reason: from kotlin metadata */
    private final State textAlign;

    /* JADX INFO: renamed from: visible$delegate, reason: from kotlin metadata */
    private final State visible;

    /* JADX INFO: renamed from: windowSize$delegate, reason: from kotlin metadata */
    private final MutableState windowSize;

    /* JADX WARN: Multi-variable type inference failed */
    public TextComponentState(WindowWidthSizeClass initialWindowSize, TextComponentStyle style, Function0<Locale> localeProvider, Function0<PaywallState.Loaded.Components.SelectedPackageInfo> selectedPackageInfoProvider, Function0<Integer> selectedTabIndexProvider, Function0<? extends OfferEligibility> selectedOfferEligibilityProvider, Function0<? extends Map<String, ? extends CustomVariableValue>> customVariablesProvider, Function0<PaywallStateStore> stateStoreProvider) {
        Intrinsics.checkNotNullParameter(initialWindowSize, "initialWindowSize");
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
        this.packageAwareDelegate = new PackageAwareDelegate(style, selectedPackageInfoProvider, selectedTabIndexProvider, selectedOfferEligibilityProvider);
        this.countdownTime = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.localeId = SnapshotStateKt.derivedStateOf(new Function0<LocaleId>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$localeId$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ LocaleId invoke() {
                return LocaleId.m13797boximpl(m14021invokeuqtKvyA());
            }

            /* JADX INFO: renamed from: invoke-uqtKvyA, reason: not valid java name */
            public final String m14021invokeuqtKvyA() {
                return LocalizationKt.toLocaleId((Locale) this.this$0.localeProvider.invoke());
            }
        });
        this.applicablePackage = SnapshotStateKt.derivedStateOf(new Function0<Package>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$applicablePackage$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Package invoke() {
                Package rcPackage = this.this$0.style.getRcPackage();
                if (rcPackage != null) {
                    return rcPackage;
                }
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                if (selectedPackageInfo != null) {
                    return selectedPackageInfo.getRcPackage();
                }
                return null;
            }
        });
        this.subscriptionOption = SnapshotStateKt.derivedStateOf(new Function0<SubscriptionOption>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$subscriptionOption$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SubscriptionOption invoke() {
                ResolvedOffer resolvedOffer;
                SubscriptionOption subscriptionOption;
                ResolvedOffer resolvedOffer2 = this.this$0.style.getResolvedOffer();
                if (resolvedOffer2 != null && (subscriptionOption = resolvedOffer2.getSubscriptionOption()) != null) {
                    return subscriptionOption;
                }
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                if (selectedPackageInfo == null || (resolvedOffer = selectedPackageInfo.getResolvedOffer()) == null) {
                    return null;
                }
                return resolvedOffer.getSubscriptionOption();
            }
        });
        this.presentedPartial = SnapshotStateKt.derivedStateOf(new Function0<LocalizedTextPartial>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$presentedPartial$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LocalizedTextPartial invoke() {
                Package rcPackage;
                ScreenCondition screenConditionFrom = ScreenCondition.INSTANCE.from(this.this$0.getWindowSize());
                ComponentViewState componentViewState = this.this$0.packageAwareDelegate.isSelected() ? ComponentViewState.SELECTED : ComponentViewState.DEFAULT;
                List overrides = this.this$0.style.getOverrides();
                OfferEligibility offerEligibility = this.this$0.packageAwareDelegate.getOfferEligibility();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = (PaywallState.Loaded.Components.SelectedPackageInfo) this.this$0.selectedPackageInfoProvider.invoke();
                return (LocalizedTextPartial) PresentedPartialKt.buildPresentedPartial(overrides, screenConditionFrom, offerEligibility, componentViewState, new ConditionContext((selectedPackageInfo == null || (rcPackage = selectedPackageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier(), (Map) this.this$0.customVariablesProvider.invoke(), new C77921(this.this$0.stateStoreProvider.invoke())));
            }

            /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$presentedPartial$2$1 */
            /* JADX INFO: compiled from: TextComponentState.kt */
            @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
            /* synthetic */ class C77921 extends FunctionReferenceImpl implements Function1<String, JsonPrimitive> {
                C77921(Object obj) {
                    super(1, obj, PaywallStateStore.class, "currentValueOrDefault", "currentValueOrDefault(Ljava/lang/String;)Lkotlinx/serialization/json/JsonPrimitive;", 0);
                }

                @Override // kotlin.jvm.functions.Function1
                public final JsonPrimitive invoke(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "p0");
                    return ((PaywallStateStore) this.receiver).currentValueOrDefault(p0);
                }
            }
        });
        this.visible = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$visible$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                PartialTextComponent partial;
                Boolean visible;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return Boolean.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (visible = partial.getVisible()) == null) ? this.this$0.style.getVisible() : visible.booleanValue());
            }
        });
        this.text = SnapshotStateKt.derivedStateOf(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$text$2
            {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                NonEmptyMap texts;
                String str;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial != null && (texts = presentedPartial.getTexts()) != null && (str = (String) texts.getOrDefault(LocaleId.m13797boximpl(this.this$0.m14019getLocaleIduqtKvyA()), texts.getEntry().getValue())) != null) {
                    return str;
                }
                NonEmptyMap texts2 = this.this$0.style.getTexts();
                return (String) texts2.getOrDefault(LocaleId.m13797boximpl(this.this$0.m14019getLocaleIduqtKvyA()), texts2.getEntry().getValue());
            }
        });
        this.localizedVariableKeys = SnapshotStateKt.derivedStateOf(new Function0<NonEmptyMap<VariableLocalizationKey, ? extends String>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$localizedVariableKeys$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final NonEmptyMap<VariableLocalizationKey, ? extends String> invoke() {
                NonEmptyMap variableLocalizations = this.this$0.style.getVariableLocalizations();
                NonEmptyMap<VariableLocalizationKey, ? extends String> nonEmptyMap = (NonEmptyMap) LocalizationKt.m13895getBestMatch64pKzr8(variableLocalizations, this.this$0.m14019getLocaleIduqtKvyA());
                return nonEmptyMap == null ? (NonEmptyMap) variableLocalizations.getEntry().getValue() : nonEmptyMap;
            }
        });
        this.color = SnapshotStateKt.derivedStateOf(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$color$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                ColorStyles color;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (color = presentedPartial.getColor()) == null) ? this.this$0.style.getColor() : color;
            }
        });
        this.fontSize = SnapshotStateKt.derivedStateOf(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$fontSize$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                PartialTextComponent partial;
                Integer fontSize;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return Integer.valueOf((presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (fontSize = partial.getFontSize()) == null) ? this.this$0.style.getFontSize() : fontSize.intValue());
            }
        });
        this.fontWeight = SnapshotStateKt.derivedStateOf(new Function0<FontWeight>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$fontWeight$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FontWeight invoke() {
                PartialTextComponent partial;
                FontWeight fontWeight;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                if (presentedPartial != null && (partial = presentedPartial.getPartial()) != null) {
                    Integer fontWeightInt = partial.getFontWeightInt();
                    if (fontWeightInt != null) {
                        fontWeight = new FontWeight(fontWeightInt.intValue());
                    } else {
                        com.revenuecat.purchases.paywalls.components.properties.FontWeight fontWeight2 = partial.getFontWeight();
                        fontWeight = fontWeight2 != null ? FontKt.toFontWeight(fontWeight2) : null;
                    }
                    if (fontWeight != null) {
                        return fontWeight;
                    }
                }
                return this.this$0.style.getFontWeight();
            }
        });
        this.fontSpec = SnapshotStateKt.derivedStateOf(new Function0<FontSpec>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$fontSpec$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FontSpec invoke() {
                FontSpec fontSpec;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (fontSpec = presentedPartial.getFontSpec()) == null) ? this.this$0.style.getFontSpec() : fontSpec;
            }
        });
        this.fontFamily = SnapshotStateKt.derivedStateOf(new Function0<FontFamily>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$fontFamily$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FontFamily invoke() {
                FontSpec fontSpec = this.this$0.getFontSpec();
                if (fontSpec == null) {
                    return null;
                }
                FontWeight fontWeight = this.this$0.getFontWeight();
                if (fontWeight == null) {
                    fontWeight = FontWeight.INSTANCE.getNormal();
                }
                return FontSpecKt.m13957resolveRetOiIg(fontSpec, fontWeight, FontStyle.INSTANCE.m10574getNormal_LCdwA());
            }
        });
        this.textAlign = SnapshotStateKt.derivedStateOf(new Function0<TextAlign>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$textAlign$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: invoke-buA522U, reason: not valid java name and merged with bridge method [inline-methods] */
            public final TextAlign invoke() {
                PartialTextComponent partial;
                HorizontalAlignment horizontalAlignment;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (horizontalAlignment = partial.getHorizontalAlignment()) == null) ? this.this$0.style.getTextAlign() : TextAlign.m10888boximpl(AlignmentKt.toTextAlign(horizontalAlignment));
            }
        });
        this.horizontalAlignment = SnapshotStateKt.derivedStateOf(new Function0<Alignment.Horizontal>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$horizontalAlignment$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Alignment.Horizontal invoke() {
                PartialTextComponent partial;
                HorizontalAlignment horizontalAlignment;
                Alignment.Horizontal alignment;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (horizontalAlignment = partial.getHorizontalAlignment()) == null || (alignment = AlignmentKt.toAlignment(horizontalAlignment)) == null) ? this.this$0.style.getHorizontalAlignment() : alignment;
            }
        });
        this.backgroundColor = SnapshotStateKt.derivedStateOf(new Function0<ColorStyles>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$backgroundColor$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ColorStyles invoke() {
                ColorStyles backgroundColor;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (backgroundColor = presentedPartial.getBackgroundColor()) == null) ? this.this$0.style.getBackgroundColor() : backgroundColor;
            }
        });
        this.size = SnapshotStateKt.derivedStateOf(new Function0<Size>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$size$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                PartialTextComponent partial;
                Size size;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (size = partial.getSize()) == null) ? this.this$0.style.getSize() : size;
            }
        });
        this.padding = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$padding$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTextComponent partial;
                Padding padding;
                PaddingValues paddingValues$default;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (padding = partial.getPadding()) == null || (paddingValues$default = PaddingKt.toPaddingValues$default(padding, false, 1, null)) == null) ? this.this$0.style.getPadding() : paddingValues$default;
            }
        });
        this.margin = SnapshotStateKt.derivedStateOf(new Function0<PaddingValues>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState$margin$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaddingValues invoke() {
                PartialTextComponent partial;
                Padding margin;
                PaddingValues paddingValues$default;
                LocalizedTextPartial presentedPartial = this.this$0.getPresentedPartial();
                return (presentedPartial == null || (partial = presentedPartial.getPartial()) == null || (margin = partial.getMargin()) == null || (paddingValues$default = PaddingKt.toPaddingValues$default(margin, false, 1, null)) == null) ? this.this$0.style.getMargin() : paddingValues$default;
            }
        });
    }

    public /* synthetic */ TextComponentState(WindowWidthSizeClass windowWidthSizeClass, TextComponentStyle textComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(windowWidthSizeClass, textComponentStyle, function0, function02, function03, function04, (i & 64) != 0 ? new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState.1
            @Override // kotlin.jvm.functions.Function0
            public final Map<String, ? extends CustomVariableValue> invoke() {
                return MapsKt.emptyMap();
            }
        } : function05, (i & 128) != 0 ? new Function0<PaywallStateStore>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentState.2
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

    private final void setCountdownTime(CountdownTime countdownTime) {
        this.countdownTime.setValue(countdownTime);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CountdownTime getCountdownTime() {
        return (CountdownTime) this.countdownTime.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getLocaleId-uqtKvyA, reason: not valid java name */
    public final String m14019getLocaleIduqtKvyA() {
        return ((LocaleId) this.localeId.getValue()).m13803unboximpl();
    }

    public final Package getApplicablePackage() {
        return (Package) this.applicablePackage.getValue();
    }

    public final SubscriptionOption getSubscriptionOption() {
        return (SubscriptionOption) this.subscriptionOption.getValue();
    }

    public final /* synthetic */ CountdownComponent.CountFrom getCountFrom() {
        return this.style.getCountFrom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LocalizedTextPartial getPresentedPartial() {
        return (LocalizedTextPartial) this.presentedPartial.getValue();
    }

    public final /* synthetic */ boolean getVisible() {
        return ((Boolean) this.visible.getValue()).booleanValue();
    }

    public final /* synthetic */ String getText() {
        return (String) this.text.getValue();
    }

    public final /* synthetic */ NonEmptyMap getLocalizedVariableKeys() {
        return (NonEmptyMap) this.localizedVariableKeys.getValue();
    }

    public final /* synthetic */ ColorStyles getColor() {
        return (ColorStyles) this.color.getValue();
    }

    public final /* synthetic */ int getFontSize() {
        return ((Number) this.fontSize.getValue()).intValue();
    }

    public final /* synthetic */ FontWeight getFontWeight() {
        return (FontWeight) this.fontWeight.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FontSpec getFontSpec() {
        return (FontSpec) this.fontSpec.getValue();
    }

    public final /* synthetic */ FontFamily getFontFamily() {
        return (FontFamily) this.fontFamily.getValue();
    }

    /* JADX INFO: renamed from: getTextAlign-buA522U, reason: not valid java name */
    public final /* synthetic */ TextAlign m14020getTextAlignbuA522U() {
        return (TextAlign) this.textAlign.getValue();
    }

    public final /* synthetic */ Alignment.Horizontal getHorizontalAlignment() {
        return (Alignment.Horizontal) this.horizontalAlignment.getValue();
    }

    public final /* synthetic */ ColorStyles getBackgroundColor() {
        return (ColorStyles) this.backgroundColor.getValue();
    }

    public final /* synthetic */ Size getSize() {
        return (Size) this.size.getValue();
    }

    public final /* synthetic */ PaddingValues getPadding() {
        return (PaddingValues) this.padding.getValue();
    }

    public final /* synthetic */ PaddingValues getMargin() {
        return (PaddingValues) this.margin.getValue();
    }

    public static /* synthetic */ void update$default(TextComponentState textComponentState, WindowWidthSizeClass windowWidthSizeClass, CountdownTime countdownTime, int i, Object obj) {
        if ((i & 1) != 0) {
            windowWidthSizeClass = null;
        }
        if ((i & 2) != 0) {
            countdownTime = textComponentState.getCountdownTime();
        }
        textComponentState.update(windowWidthSizeClass, countdownTime);
    }

    public final /* synthetic */ void update(WindowWidthSizeClass windowSize, CountdownTime countdownTime) {
        if (windowSize != null) {
            setWindowSize(windowSize);
        }
        setCountdownTime(countdownTime);
    }
}
