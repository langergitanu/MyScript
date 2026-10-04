package com.revenuecat.purchases.p036ui.revenuecatui.components.image;

import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.material3.adaptive.AndroidWindowAdaptiveInfo_androidKt;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.text.intl.Locale;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.window.core.layout.WindowWidthSizeClass;
import com.revenuecat.purchases.p036ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.OfferEligibility;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallStateStore;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageComponentState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0018\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e0\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0005H\u0003¢\u0006\u0002\u0010\u0013\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, m1599d2 = {"rememberUpdatedImageComponentState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/image/ImageComponentState;", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;", "localeProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/text/intl/Locale;", "selectedPackageInfoProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components$SelectedPackageInfo;", "selectedTabIndexProvider", "", "selectedOfferEligibilityProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/OfferEligibility;", "customVariablesProvider", "", "", "Lcom/revenuecat/purchases/ui/revenuecatui/CustomVariableValue;", "stateStoreProvider", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallStateStore;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/image/ImageComponentState;", "paywallState", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ImageComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/components/image/ImageComponentState;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class ImageComponentStateKt {
    public static final /* synthetic */ ImageComponentState rememberUpdatedImageComponentState(ImageComponentStyle style, final PaywallState.Loaded.Components paywallState, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(paywallState, "paywallState");
        composer.startReplaceGroup(-2056019880);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedImageComponentState)P(1)54@3006L23,55@3065L36,56@3134L33,57@3208L41,58@3281L38,59@3346L27,52@2930L446:ImageComponentState.kt#2dmy50");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2056019880, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.rememberUpdatedImageComponentState (ImageComponentState.kt:52)");
        }
        composer.startReplaceGroup(1344448282);
        ComposerKt.sourceInformation(composer, "CC(remember):ImageComponentState.kt#9igjgp");
        int i2 = (i & 112) ^ 48;
        boolean z = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<Locale>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentStateKt$rememberUpdatedImageComponentState$1$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Locale invoke() {
                    return paywallState.getLocale();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function0 = (Function0) objRememberedValue;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1344450183);
        ComposerKt.sourceInformation(composer, "CC(remember):ImageComponentState.kt#9igjgp");
        boolean z2 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function0) new Function0<PaywallState.Loaded.Components.SelectedPackageInfo>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentStateKt$rememberUpdatedImageComponentState$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PaywallState.Loaded.Components.SelectedPackageInfo invoke() {
                    return paywallState.getSelectedPackageInfo();
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        Function0 function02 = (Function0) objRememberedValue2;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1344452388);
        ComposerKt.sourceInformation(composer, "CC(remember):ImageComponentState.kt#9igjgp");
        boolean z3 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue3 = composer.rememberedValue();
        if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = (Function0) new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentStateKt$rememberUpdatedImageComponentState$3$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(paywallState.getSelectedTabIndex());
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        Function0 function03 = (Function0) objRememberedValue3;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1344454764);
        ComposerKt.sourceInformation(composer, "CC(remember):ImageComponentState.kt#9igjgp");
        boolean z4 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue4 = composer.rememberedValue();
        if (z4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue4 = (Function0) new Function0<OfferEligibility>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentStateKt$rememberUpdatedImageComponentState$4$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final OfferEligibility invoke() {
                    return paywallState.getSelectedOfferEligibility();
                }
            };
            composer.updateRememberedValue(objRememberedValue4);
        }
        Function0 function04 = (Function0) objRememberedValue4;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1344457097);
        ComposerKt.sourceInformation(composer, "CC(remember):ImageComponentState.kt#9igjgp");
        boolean z5 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue5 = composer.rememberedValue();
        if (z5 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue5 = (Function0) new Function0<Map<String, ? extends CustomVariableValue>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentStateKt$rememberUpdatedImageComponentState$5$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends CustomVariableValue> invoke() {
                    return paywallState.getMergedCustomVariables();
                }
            };
            composer.updateRememberedValue(objRememberedValue5);
        }
        Function0 function05 = (Function0) objRememberedValue5;
        composer.endReplaceGroup();
        composer.startReplaceGroup(1344459166);
        ComposerKt.sourceInformation(composer, "CC(remember):ImageComponentState.kt#9igjgp");
        boolean z6 = (i2 > 32 && composer.changed(paywallState)) || (i & 48) == 32;
        Object objRememberedValue6 = composer.rememberedValue();
        if (z6 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue6 = (Function0) new Function0<PaywallStateStore>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.image.ImageComponentStateKt$rememberUpdatedImageComponentState$6$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final PaywallStateStore invoke() {
                    return paywallState.getStateStore();
                }
            };
            composer.updateRememberedValue(objRememberedValue6);
        }
        composer.endReplaceGroup();
        ImageComponentState imageComponentStateRememberUpdatedImageComponentState = rememberUpdatedImageComponentState(style, function0, function02, function03, function04, function05, (Function0) objRememberedValue6, composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageComponentStateRememberUpdatedImageComponentState;
    }

    private static final /* synthetic */ ImageComponentState rememberUpdatedImageComponentState(ImageComponentStyle imageComponentStyle, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, Composer composer, int i) {
        Density density;
        composer.startReplaceGroup(-1531990806);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedImageComponentState)P(6,1,3,4,2)75@3916L27,76@4012L7,77@4039L21,78@4108L7,*80@4128L643:ImageComponentState.kt#2dmy50");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1531990806, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.image.rememberUpdatedImageComponentState (ImageComponentState.kt:74)");
        }
        WindowWidthSizeClass windowWidthSizeClass = AndroidWindowAdaptiveInfo_androidKt.currentWindowAdaptiveInfo(composer, 0).getWindowSizeClass().getWindowWidthSizeClass();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density2 = (Density) objConsume;
        boolean zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composer, 0);
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
        composer.startReplaceGroup(1344484806);
        ComposerKt.sourceInformation(composer, "CC(remember):ImageComponentState.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(imageComponentStyle)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            density = density2;
            ImageComponentState imageComponentState = new ImageComponentState(windowWidthSizeClass, density, zIsSystemInDarkTheme, layoutDirection, imageComponentStyle, function0, function02, function03, function04, function05, function06);
            composer.updateRememberedValue(imageComponentState);
            objRememberedValue = imageComponentState;
        } else {
            density = density2;
        }
        ImageComponentState imageComponentState2 = (ImageComponentState) objRememberedValue;
        composer.endReplaceGroup();
        imageComponentState2.update(windowWidthSizeClass, density, Boolean.valueOf(zIsSystemInDarkTheme), layoutDirection);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return imageComponentState2;
    }
}
