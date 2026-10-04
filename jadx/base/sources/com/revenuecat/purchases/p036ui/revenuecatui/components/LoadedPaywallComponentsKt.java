package com.revenuecat.purchases.p036ui.revenuecatui.components;

import android.content.res.Configuration;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.layout.LayoutModifierKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.text.intl.Locale;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.SimpleBottomSheetScaffoldKt;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.SimpleSheetState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Result;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.HeaderComponent;
import com.revenuecat.purchases.paywalls.components.PaywallComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.TextComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.FlexDistribution;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.components.properties.TwoDimensionalAlignment;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoadedPaywallComponents.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aM\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000f\u001aF\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001al\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010!\u001aJ\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0002\u001a\u00020\u00032\"\u0010%\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0080@¢\u0006\u0002\u0010&\u001a\u0014\u0010'\u001a\u00020(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*H\u0002\u001a\r\u0010+\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010,\u001a\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0000\u001a\u0014\u00100\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u00101\u001a\u00020\n*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001aM\u00102\u001a\u00020\u0001*\u0002032\u0006\u00104\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\"\u00105\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0000¢\u0006\u0002\u00106¨\u00067"}, m1599d2 = {"LoadedPaywallComponents", "", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "clickHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "LoadedPaywallComponents_BottomSheet_FitSize_Preview", "(Landroidx/compose/runtime/Composer;I)V", "LoadedPaywallComponents_BottomSheet_NullSize_Preview", "LoadedPaywallComponents_Preview", "LoadedPaywallComponents_Preview_Bless", "OverlayLayout", "hasHeader", "", "hasFooter", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PaywallComponentsScaffold", "background", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;", "headerContent", "footerContent", "mainContent", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "handleClick", "action", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "externalClickHandler", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewBottomSheet", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;", "size", "Lcom/revenuecat/purchases/paywalls/components/properties/Size;", "previewHelloWorldPaywallState", "(Landroidx/compose/runtime/Composer;I)Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "shouldWrapMainContentInVerticalScroll", "rootStack", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "footerBottomPadding", "headerTopPadding", "show", "Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;", "sheet", "onClick", "(Lcom/revenuecat/purchases/ui/revenuecatui/composables/SimpleSheetState;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Lkotlin/jvm/functions/Function2;)V", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class LoadedPaywallComponentsKt {
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoadedPaywallComponents(final PaywallState.Loaded.Components state, final Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> clickHandler, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int i5;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
        boolean zChangedInstance;
        LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1 loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue;
        boolean zChanged;
        Object objRememberedValue;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1348878952);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents)P(3!1,2)91@5757L7,94@5870L95,99@6092L21,100@6140L86,104@6304L1667,104@6232L1739:LoadedPaywallComponents.kt#dnqhhd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(clickHandler) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
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
            i5 = i3;
            if ((i5 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                Modifier modifier4 = i6 == 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    paywallComponentInteractionTracker4 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$$ExternalSyntheticLambda1
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                        }
                    };
                }
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1348878952, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents (LoadedPaywallComponents.kt:90)");
                }
                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                PaywallState.Loaded.Components.update$default(state, ((Configuration) objConsume).getLocales(), null, null, 6, null);
                composerStartRestartGroup.startReplaceGroup(174570419);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                zChangedInstance = ((i5 & 14) != 4) | composerStartRestartGroup.changedInstance(clickHandler) | ((i5 & 7168) != 2048 || ((i5 & 4096) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker2)));
                loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue = new LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1(state, clickHandler, paywallComponentInteractionTracker2, null);
                    composerStartRestartGroup.updateRememberedValue(loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue);
                }
                final Function2 function2 = (Function2) loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue;
                composerStartRestartGroup.endReplaceGroup();
                final boolean zShouldWrapMainContentInVerticalScroll = shouldWrapMainContentInVerticalScroll(state.getStack());
                final ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                Locale locale = state.getLocale();
                composerStartRestartGroup.startReplaceGroup(174579050);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(locale);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = LocaleHelpersKt.toLayoutDirection(LocalizationKt.toJavaLocale(state.getLocale()));
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                ProvidedValue<LayoutDirection> providedValueProvides = CompositionLocalsKt.getLocalLayoutDirection().provides((LayoutDirection) objRememberedValue);
                paywallComponentInteractionTracker3 = paywallComponentInteractionTracker2;
                final Modifier modifier5 = modifier4;
                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(-925503272, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.2
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

                    public final void invoke(Composer composer2, int i7) {
                        ComposableLambda composableLambdaRememberComposableLambda;
                        ComposerKt.sourceInformation(composer2, "C129@7216L749,105@6314L1651:LoadedPaywallComponents.kt#dnqhhd");
                        if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-925503272, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous> (LoadedPaywallComponents.kt:105)");
                            }
                            PaywallState.Loaded.Components components = state;
                            Modifier modifier6 = modifier5;
                            final ComponentStyle header = components.getHeader();
                            composer2.startReplaceGroup(-89290707);
                            ComposerKt.sourceInformation(composer2, "*109@6480L263");
                            ComposableLambda composableLambdaRememberComposableLambda2 = null;
                            if (header == null) {
                                composableLambdaRememberComposableLambda = null;
                            } else {
                                final PaywallState.Loaded.Components components2 = state;
                                final Function2<PaywallAction, Continuation<? super Unit>, Object> function22 = function2;
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2034843347, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$1$1
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

                                    public final void invoke(Composer composer3, int i8) {
                                        ComposerKt.sourceInformation(composer3, "C110@6502L223:LoadedPaywallComponents.kt#dnqhhd");
                                        if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2034843347, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:110)");
                                            }
                                            ComponentViewKt.ComponentView(header, components2, function22, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer3, 3072, 16);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                            }
                            composer2.endReplaceGroup();
                            final ComponentStyle stickyFooter = state.getStickyFooter();
                            composer2.startReplaceGroup(-89278976);
                            ComposerKt.sourceInformation(composer2, "*119@6844L346");
                            if (stickyFooter != null) {
                                final PaywallState.Loaded.Components components3 = state;
                                final Function2<PaywallAction, Continuation<? super Unit>, Object> function23 = function2;
                                final PaywallComponentInteractionTracker paywallComponentInteractionTracker5 = paywallComponentInteractionTracker3;
                                composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-991055378, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$2$1
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

                                    public final void invoke(Composer composer3, int i8) {
                                        ComposerKt.sourceInformation(composer3, "C120@6866L306:LoadedPaywallComponents.kt#dnqhhd");
                                        if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-991055378, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:120)");
                                            }
                                            ComponentViewKt.ComponentView(stickyFooter, components3, function23, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paywallComponentInteractionTracker5, composer3, 3072, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54);
                            }
                            composer2.endReplaceGroup();
                            final PaywallState.Loaded.Components components4 = state;
                            final boolean z = zShouldWrapMainContentInVerticalScroll;
                            final ScrollState scrollState = scrollStateRememberScrollState;
                            final Function2<PaywallAction, Continuation<? super Unit>, Object> function24 = function2;
                            final PaywallComponentInteractionTracker paywallComponentInteractionTracker6 = paywallComponentInteractionTracker3;
                            LoadedPaywallComponentsKt.PaywallComponentsScaffold(components, modifier6, null, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, ComposableLambdaKt.rememberComposableLambda(-97368662, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.2.3
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

                                public final void invoke(Composer composer3, int i8) {
                                    ComposerKt.sourceInformation(composer3, "C137@7566L79,140@7733L71,143@7866L74,130@7230L725:LoadedPaywallComponents.kt#dnqhhd");
                                    if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-97368662, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:130)");
                                        }
                                        ComponentStyle stack = components4.getStack();
                                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                        boolean z2 = z;
                                        composer3.startReplaceGroup(1279955233);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                                        boolean zChanged2 = composer3.changed(scrollState);
                                        final ScrollState scrollState2 = scrollState;
                                        Object objRememberedValue2 = composer3.rememberedValue();
                                        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue2 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$3$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Modifier invoke(Modifier conditional) {
                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                    return ScrollKt.verticalScroll$default(conditional, scrollState2, false, null, false, 14, null);
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue2);
                                        }
                                        composer3.endReplaceGroup();
                                        Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierFillMaxSize$default, z2, (Function1) objRememberedValue2);
                                        boolean z3 = (components4.getHeader() == null || components4.getMainStackHasHeroImage()) ? false : true;
                                        composer3.startReplaceGroup(1279960569);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                                        boolean zChanged3 = composer3.changed(components4);
                                        final PaywallState.Loaded.Components components5 = components4;
                                        Object objRememberedValue3 = composer3.rememberedValue();
                                        if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue3 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$3$2$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Modifier invoke(Modifier conditional) {
                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                    return LoadedPaywallComponentsKt.headerTopPadding(conditional, components5);
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue3);
                                        }
                                        composer3.endReplaceGroup();
                                        Modifier modifierConditional2 = ModifierExtensionsKt.conditional(modifierConditional, z3, (Function1) objRememberedValue3);
                                        boolean z4 = components4.getStickyFooter() != null;
                                        composer3.startReplaceGroup(1279964828);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                                        boolean zChanged4 = composer3.changed(components4);
                                        final PaywallState.Loaded.Components components6 = components4;
                                        Object objRememberedValue4 = composer3.rememberedValue();
                                        if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            objRememberedValue4 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$3$3$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Modifier invoke(Modifier conditional) {
                                                    Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                    return LoadedPaywallComponentsKt.footerBottomPadding(conditional, components6);
                                                }
                                            };
                                            composer3.updateRememberedValue(objRememberedValue4);
                                        }
                                        composer3.endReplaceGroup();
                                        ComponentViewKt.ComponentView(stack, components4, function24, ModifierExtensionsKt.conditional(modifierConditional2, z4, (Function1) objRememberedValue4), paywallComponentInteractionTracker6, composer3, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.f379xf2722a21, 4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paywallComponentInteractionTracker3 = paywallComponentInteractionTracker4;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.3
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

                    public final void invoke(Composer composer2, int i7) {
                        LoadedPaywallComponentsKt.LoadedPaywallComponents(state, clickHandler, modifier3, paywallComponentInteractionTracker3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
        i5 = i3;
        if ((i5 & 1171) == 1170) {
            if (i6 == 0) {
            }
            if (i4 != 0) {
            }
            paywallComponentInteractionTracker2 = paywallComponentInteractionTracker4;
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Configuration> localConfiguration2 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localConfiguration2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PaywallState.Loaded.Components.update$default(state, ((Configuration) objConsume2).getLocales(), null, null, 6, null);
            composerStartRestartGroup.startReplaceGroup(174570419);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
            if ((i5 & 7168) != 2048) {
                zChangedInstance = ((i5 & 14) != 4) | composerStartRestartGroup.changedInstance(clickHandler) | ((i5 & 7168) != 2048 || ((i5 & 4096) != 0 && composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker2)));
                loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue = new LoadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1(state, clickHandler, paywallComponentInteractionTracker2, null);
                    composerStartRestartGroup.updateRememberedValue(loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue);
                    final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function22 = (Function2) loadedPaywallComponentsKt$LoadedPaywallComponents$onClick$1$1RememberedValue;
                    composerStartRestartGroup.endReplaceGroup();
                    final boolean zShouldWrapMainContentInVerticalScroll2 = shouldWrapMainContentInVerticalScroll(state.getStack());
                    final ScrollState scrollStateRememberScrollState2 = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
                    Locale locale2 = state.getLocale();
                    composerStartRestartGroup.startReplaceGroup(174579050);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(locale2);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = LocaleHelpersKt.toLayoutDirection(LocalizationKt.toJavaLocale(state.getLocale()));
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        ProvidedValue<LayoutDirection> providedValueProvides2 = CompositionLocalsKt.getLocalLayoutDirection().provides((LayoutDirection) objRememberedValue);
                        paywallComponentInteractionTracker3 = paywallComponentInteractionTracker2;
                        final Modifier modifier52 = modifier4;
                        CompositionLocalKt.CompositionLocalProvider(providedValueProvides2, ComposableLambdaKt.rememberComposableLambda(-925503272, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.2
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

                            public final void invoke(Composer composer2, int i7) {
                                ComposableLambda composableLambdaRememberComposableLambda;
                                ComposerKt.sourceInformation(composer2, "C129@7216L749,105@6314L1651:LoadedPaywallComponents.kt#dnqhhd");
                                if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-925503272, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous> (LoadedPaywallComponents.kt:105)");
                                    }
                                    PaywallState.Loaded.Components components = state;
                                    Modifier modifier6 = modifier52;
                                    final ComponentStyle header = components.getHeader();
                                    composer2.startReplaceGroup(-89290707);
                                    ComposerKt.sourceInformation(composer2, "*109@6480L263");
                                    ComposableLambda composableLambdaRememberComposableLambda2 = null;
                                    if (header == null) {
                                        composableLambdaRememberComposableLambda = null;
                                    } else {
                                        final PaywallState.Loaded.Components components2 = state;
                                        final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function222 = function22;
                                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2034843347, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$1$1
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

                                            public final void invoke(Composer composer3, int i8) {
                                                ComposerKt.sourceInformation(composer3, "C110@6502L223:LoadedPaywallComponents.kt#dnqhhd");
                                                if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-2034843347, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:110)");
                                                    }
                                                    ComponentViewKt.ComponentView(header, components2, function222, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer3, 3072, 16);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, composer2, 54);
                                    }
                                    composer2.endReplaceGroup();
                                    final ComponentStyle stickyFooter = state.getStickyFooter();
                                    composer2.startReplaceGroup(-89278976);
                                    ComposerKt.sourceInformation(composer2, "*119@6844L346");
                                    if (stickyFooter != null) {
                                        final PaywallState.Loaded.Components components3 = state;
                                        final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function23 = function22;
                                        final PaywallComponentInteractionTracker paywallComponentInteractionTracker5 = paywallComponentInteractionTracker3;
                                        composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-991055378, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$2$1
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

                                            public final void invoke(Composer composer3, int i8) {
                                                ComposerKt.sourceInformation(composer3, "C120@6866L306:LoadedPaywallComponents.kt#dnqhhd");
                                                if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-991055378, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:120)");
                                                    }
                                                    ComponentViewKt.ComponentView(stickyFooter, components3, function23, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), paywallComponentInteractionTracker5, composer3, 3072, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, composer2, 54);
                                    }
                                    composer2.endReplaceGroup();
                                    final PaywallState.Loaded.Components components4 = state;
                                    final boolean z = zShouldWrapMainContentInVerticalScroll2;
                                    final ScrollState scrollState = scrollStateRememberScrollState2;
                                    final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function24 = function22;
                                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker6 = paywallComponentInteractionTracker3;
                                    LoadedPaywallComponentsKt.PaywallComponentsScaffold(components, modifier6, null, composableLambdaRememberComposableLambda, composableLambdaRememberComposableLambda2, ComposableLambdaKt.rememberComposableLambda(-97368662, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents.2.3
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

                                        public final void invoke(Composer composer3, int i8) {
                                            ComposerKt.sourceInformation(composer3, "C137@7566L79,140@7733L71,143@7866L74,130@7230L725:LoadedPaywallComponents.kt#dnqhhd");
                                            if ((i8 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-97368662, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:130)");
                                                }
                                                ComponentStyle stack = components4.getStack();
                                                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                                                boolean z2 = z;
                                                composer3.startReplaceGroup(1279955233);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                                                boolean zChanged2 = composer3.changed(scrollState);
                                                final ScrollState scrollState2 = scrollState;
                                                Object objRememberedValue2 = composer3.rememberedValue();
                                                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue2 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$3$1$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return ScrollKt.verticalScroll$default(conditional, scrollState2, false, null, false, 14, null);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(objRememberedValue2);
                                                }
                                                composer3.endReplaceGroup();
                                                Modifier modifierConditional = ModifierExtensionsKt.conditional(modifierFillMaxSize$default, z2, (Function1) objRememberedValue2);
                                                boolean z3 = (components4.getHeader() == null || components4.getMainStackHasHeroImage()) ? false : true;
                                                composer3.startReplaceGroup(1279960569);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                                                boolean zChanged3 = composer3.changed(components4);
                                                final PaywallState.Loaded.Components components5 = components4;
                                                Object objRememberedValue3 = composer3.rememberedValue();
                                                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue3 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$3$2$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return LoadedPaywallComponentsKt.headerTopPadding(conditional, components5);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(objRememberedValue3);
                                                }
                                                composer3.endReplaceGroup();
                                                Modifier modifierConditional2 = ModifierExtensionsKt.conditional(modifierConditional, z3, (Function1) objRememberedValue3);
                                                boolean z4 = components4.getStickyFooter() != null;
                                                composer3.startReplaceGroup(1279964828);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                                                boolean zChanged4 = composer3.changed(components4);
                                                final PaywallState.Loaded.Components components6 = components4;
                                                Object objRememberedValue4 = composer3.rememberedValue();
                                                if (zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    objRememberedValue4 = (Function1) new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents$2$3$3$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Modifier invoke(Modifier conditional) {
                                                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                                                            return LoadedPaywallComponentsKt.footerBottomPadding(conditional, components6);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(objRememberedValue4);
                                                }
                                                composer3.endReplaceGroup();
                                                ComponentViewKt.ComponentView(stack, components4, function24, ModifierExtensionsKt.conditional(modifierConditional2, z4, (Function1) objRememberedValue4), paywallComponentInteractionTracker6, composer3, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.f379xf2722a21, 4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier52;
                    }
                }
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PaywallComponentsScaffold(final PaywallState.Loaded.Components state, Modifier modifier, BackgroundStyle backgroundStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> mainContent, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final BackgroundStyle backgroundStyle2;
        final Modifier modifier4;
        Modifier modifierBackground$default;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        BackgroundStyle backgroundStyleRememberBackgroundStyle = backgroundStyle;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(mainContent, "mainContent");
        Composer composerStartRestartGroup = composer.startRestartGroup(569601410);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallComponentsScaffold)P(5,4!1,2)172@8919L1471,169@8776L1614:LoadedPaywallComponents.kt#dnqhhd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                if ((i2 & 4) != 0) {
                    i6 = 128;
                    i3 |= i6;
                } else {
                    if ((i & 512) == 0 ? composerStartRestartGroup.changed(backgroundStyleRememberBackgroundStyle) : composerStartRestartGroup.changedInstance(backgroundStyleRememberBackgroundStyle)) {
                        i6 = 256;
                    }
                    i3 |= i6;
                }
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    function23 = function2;
                    i3 |= composerStartRestartGroup.changedInstance(function23) ? 2048 : 1024;
                }
                i5 = i2 & 16;
                if (i5 == 0) {
                    if ((i & 24576) == 0) {
                        function24 = function22;
                        i3 |= composerStartRestartGroup.changedInstance(function24) ? 16384 : 8192;
                    }
                    if ((i2 & 32) == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    } else if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(mainContent) ? 131072 : 65536;
                    }
                    if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "164@8578L41");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i7 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                backgroundStyleRememberBackgroundStyle = BackgroundStyleKt.rememberBackgroundStyle(state.getBackground(), composerStartRestartGroup, 0);
                                i3 &= -897;
                            }
                            if (i4 != 0) {
                                function23 = null;
                            }
                            if (i5 == 0) {
                                modifier3 = modifier2;
                                function24 = null;
                            }
                            int i8 = i3;
                            final Function2<? super Composer, ? super Integer, Unit> function27 = function23;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(569601410, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.components.PaywallComponentsScaffold (LoadedPaywallComponents.kt:168)");
                            }
                            SimpleSheetState sheet = state.getSheet();
                            Modifier modifier5 = (backgroundStyleRememberBackgroundStyle == null || (modifierBackground$default = BackgroundKt.background$default(modifier3, backgroundStyleRememberBackgroundStyle, (Shape) null, 2, (Object) null)) == null) ? modifier3 : modifierBackground$default;
                            final BackgroundStyle backgroundStyle3 = backgroundStyleRememberBackgroundStyle;
                            final Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                            SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold(sheet, modifier5, ComposableLambdaKt.rememberComposableLambda(-1445408041, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold.2
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
                                    ComposerKt.sourceInformation(composer2, "C173@8991L1393,173@8929L1455:LoadedPaywallComponents.kt#dnqhhd");
                                    if ((i9 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1445408041, i9, -1, "com.revenuecat.purchases.ui.revenuecatui.components.PaywallComponentsScaffold.<anonymous> (LoadedPaywallComponents.kt:173)");
                                        }
                                        PaywallState.Loaded.Components components = state;
                                        BackgroundStyle backgroundStyle4 = backgroundStyle3;
                                        final PaywallState.Loaded.Components components2 = state;
                                        final Function2<Composer, Integer, Unit> function29 = function27;
                                        final Function2<Composer, Integer, Unit> function210 = function28;
                                        final Function2<Composer, Integer, Unit> function211 = mainContent;
                                        WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyle4, null, null, ComposableLambdaKt.rememberComposableLambda(618249412, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold.2.1
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

                                            public final void invoke(Composer composer3, int i10) {
                                                ComposerKt.sourceInformation(composer3, "C185@9677L697,178@9384L990:LoadedPaywallComponents.kt#dnqhhd");
                                                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(618249412, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.components.PaywallComponentsScaffold.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:178)");
                                                    }
                                                    PaywallState.Loaded.Components components3 = components2;
                                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold.2.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                            invoke2(semanticsPropertyReceiver);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                            SemanticsPropertiesKt.setTraversalGroup(semantics, true);
                                                        }
                                                    }, 1, null);
                                                    boolean z = function29 != null;
                                                    boolean z2 = function210 != null;
                                                    final Function2<Composer, Integer, Unit> function212 = function211;
                                                    final Function2<Composer, Integer, Unit> function213 = function29;
                                                    final Function2<Composer, Integer, Unit> function214 = function210;
                                                    LoadedPaywallComponentsKt.OverlayLayout(components3, modifierSemantics$default, z, z2, ComposableLambdaKt.rememberComposableLambda(1280656761, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold.2.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                            invoke(composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i11) {
                                                            ComposerKt.sourceInformation(composer4, "C187@9753L13,201@10352L8:LoadedPaywallComponents.kt#dnqhhd");
                                                            if ((i11 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1280656761, i11, -1, "com.revenuecat.purchases.ui.revenuecatui.components.PaywallComponentsScaffold.<anonymous>.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:187)");
                                                                }
                                                                function212.invoke(composer4, 0);
                                                                Function2<Composer, Integer, Unit> function215 = function213;
                                                                composer4.startReplaceGroup(-1444190971);
                                                                ComposerKt.sourceInformation(composer4, "*190@9895L323");
                                                                if (function215 != null) {
                                                                    Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$PaywallComponentsScaffold$2$1$2$1$1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                            invoke2(semanticsPropertyReceiver);
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                                                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                                            SemanticsPropertiesKt.setTraversalGroup(semantics, true);
                                                                            SemanticsPropertiesKt.setTraversalIndex(semantics, -1.0f);
                                                                        }
                                                                    }, 1, null);
                                                                    ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierSemantics$default2);
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
                                                                    ComposerKt.sourceInformationMarkerStart(composer4, 563904529, "C197@10188L8:LoadedPaywallComponents.kt#dnqhhd");
                                                                    function215.invoke(composer4, 0);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    composer4.endNode();
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    Unit unit = Unit.INSTANCE;
                                                                }
                                                                composer4.endReplaceGroup();
                                                                Function2<Composer, Integer, Unit> function216 = function214;
                                                                if (function216 != null) {
                                                                    function216.invoke(composer4, 0);
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }, composer3, 54), composer3, 24576, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, composer2, 54), composer2, 24576, 12);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function25 = function28;
                            function26 = function27;
                            backgroundStyle2 = backgroundStyle3;
                            modifier4 = modifier3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                        }
                        modifier3 = modifier2;
                        int i82 = i3;
                        final Function2<? super Composer, ? super Integer, Unit> function272 = function23;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        SimpleSheetState sheet2 = state.getSheet();
                        if (backgroundStyleRememberBackgroundStyle == null) {
                            final BackgroundStyle backgroundStyle32 = backgroundStyleRememberBackgroundStyle;
                            final Function2<? super Composer, ? super Integer, Unit> function282 = function24;
                            SimpleBottomSheetScaffoldKt.SimpleBottomSheetScaffold(sheet2, modifier5, ComposableLambdaKt.rememberComposableLambda(-1445408041, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold.2
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
                                    ComposerKt.sourceInformation(composer2, "C173@8991L1393,173@8929L1455:LoadedPaywallComponents.kt#dnqhhd");
                                    if ((i9 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1445408041, i9, -1, "com.revenuecat.purchases.ui.revenuecatui.components.PaywallComponentsScaffold.<anonymous> (LoadedPaywallComponents.kt:173)");
                                        }
                                        PaywallState.Loaded.Components components = state;
                                        BackgroundStyle backgroundStyle4 = backgroundStyle32;
                                        final PaywallState.Loaded.Components components2 = state;
                                        final Function2<? super Composer, ? super Integer, Unit> function29 = function272;
                                        final Function2<? super Composer, ? super Integer, Unit> function210 = function282;
                                        final Function2<? super Composer, ? super Integer, Unit> function211 = mainContent;
                                        WithOptionalBackgroundOverlayKt.WithOptionalBackgroundOverlay(components, backgroundStyle4, null, null, ComposableLambdaKt.rememberComposableLambda(618249412, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold.2.1
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

                                            public final void invoke(Composer composer3, int i10) {
                                                ComposerKt.sourceInformation(composer3, "C185@9677L697,178@9384L990:LoadedPaywallComponents.kt#dnqhhd");
                                                if ((i10 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(618249412, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.components.PaywallComponentsScaffold.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:178)");
                                                    }
                                                    PaywallState.Loaded.Components components3 = components2;
                                                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold.2.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                            invoke2(semanticsPropertyReceiver);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                            SemanticsPropertiesKt.setTraversalGroup(semantics, true);
                                                        }
                                                    }, 1, null);
                                                    boolean z = function29 != null;
                                                    boolean z2 = function210 != null;
                                                    final Function2<? super Composer, ? super Integer, Unit> function212 = function211;
                                                    final Function2<? super Composer, ? super Integer, Unit> function213 = function29;
                                                    final Function2<? super Composer, ? super Integer, Unit> function214 = function210;
                                                    LoadedPaywallComponentsKt.OverlayLayout(components3, modifierSemantics$default, z, z2, ComposableLambdaKt.rememberComposableLambda(1280656761, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold.2.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                            invoke(composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i11) {
                                                            ComposerKt.sourceInformation(composer4, "C187@9753L13,201@10352L8:LoadedPaywallComponents.kt#dnqhhd");
                                                            if ((i11 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1280656761, i11, -1, "com.revenuecat.purchases.ui.revenuecatui.components.PaywallComponentsScaffold.<anonymous>.<anonymous>.<anonymous> (LoadedPaywallComponents.kt:187)");
                                                                }
                                                                function212.invoke(composer4, 0);
                                                                Function2<Composer, Integer, Unit> function215 = function213;
                                                                composer4.startReplaceGroup(-1444190971);
                                                                ComposerKt.sourceInformation(composer4, "*190@9895L323");
                                                                if (function215 != null) {
                                                                    Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$PaywallComponentsScaffold$2$1$2$1$1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                            invoke2(semanticsPropertyReceiver);
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                                                                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                                            SemanticsPropertiesKt.setTraversalGroup(semantics, true);
                                                                            SemanticsPropertiesKt.setTraversalIndex(semantics, -1.0f);
                                                                        }
                                                                    }, 1, null);
                                                                    ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                                    ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierSemantics$default2);
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
                                                                    ComposerKt.sourceInformationMarkerStart(composer4, 563904529, "C197@10188L8:LoadedPaywallComponents.kt#dnqhhd");
                                                                    function215.invoke(composer4, 0);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    composer4.endNode();
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                                    Unit unit = Unit.INSTANCE;
                                                                }
                                                                composer4.endReplaceGroup();
                                                                Function2<Composer, Integer, Unit> function216 = function214;
                                                                if (function216 != null) {
                                                                    function216.invoke(composer4, 0);
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }, composer3, 54), composer3, 24576, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, composer2, 54), composer2, 24576, 12);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function25 = function282;
                            function26 = function272;
                            backgroundStyle2 = backgroundStyle32;
                            modifier4 = modifier3;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        backgroundStyle2 = backgroundStyleRememberBackgroundStyle;
                        modifier4 = modifier2;
                        function26 = function23;
                        function25 = function24;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.PaywallComponentsScaffold.3
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
                                LoadedPaywallComponentsKt.PaywallComponentsScaffold(state, modifier4, backgroundStyle2, function26, function25, mainContent, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 24576;
                function24 = function22;
                if ((i2 & 32) == 0) {
                }
                if ((74899 & i3) == 74898) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "164@8578L41");
                    if ((i & 1) != 0) {
                        if (i7 != 0) {
                        }
                        if ((i2 & 4) != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 == 0) {
                            modifier3 = modifier2;
                        }
                        int i822 = i3;
                        final Function2<? super Composer, ? super Integer, Unit> function2722 = function23;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        SimpleSheetState sheet22 = state.getSheet();
                        if (backgroundStyleRememberBackgroundStyle == null) {
                        }
                    }
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function23 = function2;
            i5 = i2 & 16;
            if (i5 == 0) {
            }
            function24 = function22;
            if ((i2 & 32) == 0) {
            }
            if ((74899 & i3) == 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function23 = function2;
        i5 = i2 & 16;
        if (i5 == 0) {
        }
        function24 = function22;
        if ((i2 & 32) == 0) {
        }
        if ((74899 & i3) == 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OverlayLayout(final PaywallState.Loaded.Components state, Modifier modifier, boolean z, boolean z2, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z3;
        int i5;
        final boolean z4;
        boolean z5;
        MeasurePolicy measurePolicyRememberedValue;
        int currentCompositeKeyHash;
        Composer composerM7248constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1440458947);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OverlayLayout)P(4,3,2,1)233@11686L1812,230@11616L1882:LoadedPaywallComponents.kt#dnqhhd");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    z3 = z;
                    i3 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        z4 = z2;
                        i3 |= composerStartRestartGroup.changed(z4) ? 2048 : 1024;
                    }
                    if ((i2 & 16) == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(content) ? 16384 : 8192;
                    }
                    if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                        if (i6 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = false;
                        }
                        if (i5 != 0) {
                            z4 = false;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1440458947, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.OverlayLayout (LoadedPaywallComponents.kt:229)");
                        }
                        composerStartRestartGroup.startReplaceGroup(497811167);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                        z5 = ((i3 & 896) != 256) | ((i3 & 7168) != 2048) | ((i3 & 14) == 4);
                        measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z5 || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                            measurePolicyRememberedValue = new MeasurePolicy() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$OverlayLayout$1$1
                                @Override // androidx.compose.p004ui.layout.MeasurePolicy
                                /* JADX INFO: renamed from: measure-3p2s80s */
                                public final MeasureResult mo1747measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, final long j) {
                                    Measurable measurable;
                                    Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                                    Intrinsics.checkNotNullParameter(measurables, "measurables");
                                    Measurable measurable2 = z3 ? measurables.get(1) : null;
                                    if (z4) {
                                        measurable = measurables.get(z3 ? 2 : 1);
                                    } else {
                                        measurable = null;
                                    }
                                    Placeable placeableMo9625measureBRTryo0 = measurable2 != null ? measurable2.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                                    final Placeable placeableMo9625measureBRTryo02 = measurable != null ? measurable.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                                    if (z3) {
                                        state.setHeaderHeightPx$revenuecatui_defaultsRelease(placeableMo9625measureBRTryo0 != null ? placeableMo9625measureBRTryo0.getHeight() : 0);
                                    }
                                    if (z4) {
                                        state.setFooterHeightPx$revenuecatui_defaultsRelease(placeableMo9625measureBRTryo02 != null ? placeableMo9625measureBRTryo02.getHeight() : 0);
                                    }
                                    final Placeable placeableMo9625measureBRTryo03 = measurables.get(0).mo9625measureBRTryo0(j);
                                    final Placeable placeable = placeableMo9625measureBRTryo0;
                                    return MeasureScope.layout$default(Layout, Constraints.m10970getMaxWidthimpl(j), Constraints.m10969getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$OverlayLayout$1$1.1
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
                                        public final void invoke2(Placeable.PlacementScope layout) {
                                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                            Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo03, 0, 0, 0.0f, 4, null);
                                            Placeable placeable2 = placeable;
                                            if (placeable2 != null) {
                                                Placeable.PlacementScope.placeRelative$default(layout, placeable2, 0, 0, 0.0f, 4, null);
                                            }
                                            Placeable placeable3 = placeableMo9625measureBRTryo02;
                                            if (placeable3 != null) {
                                                Placeable.PlacementScope.placeRelative$default(layout, placeable3, 0, Constraints.m10969getMaxHeightimpl(j) - placeableMo9625measureBRTryo02.getHeight(), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        }
                        MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        int i7 = ((i3 >> 12) & 14) | (i3 & 112);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int i8 = ((i7 << 6) & 896) | 6;
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
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        content.invoke(composerStartRestartGroup, Integer.valueOf((i8 >> 6) & 14));
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                    }
                    final boolean z6 = z3;
                    final boolean z7 = z4;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        final Modifier modifier3 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.OverlayLayout.2
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
                                LoadedPaywallComponentsKt.OverlayLayout(state, modifier3, z6, z7, content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                z4 = z2;
                if ((i2 & 16) == 0) {
                }
                if ((i3 & 9363) == 9362) {
                    if (i6 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composerStartRestartGroup.startReplaceGroup(497811167);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                    z5 = ((i3 & 896) != 256) | ((i3 & 7168) != 2048) | ((i3 & 14) == 4);
                    measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z5) {
                        measurePolicyRememberedValue = new MeasurePolicy() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$OverlayLayout$1$1
                            @Override // androidx.compose.p004ui.layout.MeasurePolicy
                            /* JADX INFO: renamed from: measure-3p2s80s */
                            public final MeasureResult mo1747measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, final long j) {
                                Measurable measurable;
                                Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                                Intrinsics.checkNotNullParameter(measurables, "measurables");
                                Measurable measurable2 = z3 ? measurables.get(1) : null;
                                if (z4) {
                                    measurable = measurables.get(z3 ? 2 : 1);
                                } else {
                                    measurable = null;
                                }
                                Placeable placeableMo9625measureBRTryo0 = measurable2 != null ? measurable2.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                                final Placeable placeableMo9625measureBRTryo02 = measurable != null ? measurable.mo9625measureBRTryo0(Constraints.m10960copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)) : null;
                                if (z3) {
                                    state.setHeaderHeightPx$revenuecatui_defaultsRelease(placeableMo9625measureBRTryo0 != null ? placeableMo9625measureBRTryo0.getHeight() : 0);
                                }
                                if (z4) {
                                    state.setFooterHeightPx$revenuecatui_defaultsRelease(placeableMo9625measureBRTryo02 != null ? placeableMo9625measureBRTryo02.getHeight() : 0);
                                }
                                final Placeable placeableMo9625measureBRTryo03 = measurables.get(0).mo9625measureBRTryo0(j);
                                final Placeable placeable = placeableMo9625measureBRTryo0;
                                return MeasureScope.layout$default(Layout, Constraints.m10970getMaxWidthimpl(j), Constraints.m10969getMaxHeightimpl(j), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$OverlayLayout$1$1.1
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
                                    public final void invoke2(Placeable.PlacementScope layout) {
                                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                        Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo03, 0, 0, 0.0f, 4, null);
                                        Placeable placeable2 = placeable;
                                        if (placeable2 != null) {
                                            Placeable.PlacementScope.placeRelative$default(layout, placeable2, 0, 0, 0.0f, 4, null);
                                        }
                                        Placeable placeable3 = placeableMo9625measureBRTryo02;
                                        if (placeable3 != null) {
                                            Placeable.PlacementScope.placeRelative$default(layout, placeable3, 0, Constraints.m10969getMaxHeightimpl(j) - placeableMo9625measureBRTryo02.getHeight(), 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
                        MeasurePolicy measurePolicy2 = (MeasurePolicy) measurePolicyRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        int i72 = ((i3 >> 12) & 14) | (i3 & 112);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int i82 = ((i72 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (!composerStartRestartGroup.getInserting()) {
                        }
                        composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                        Updater.m7256setimpl(composerM7248constructorimpl, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM7248constructorimpl.getInserting()) {
                            composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            content.invoke(composerStartRestartGroup, Integer.valueOf((i82 >> 6) & 14));
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                    }
                }
                final boolean z62 = z3;
                final boolean z72 = z4;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            z3 = z;
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            z4 = z2;
            if ((i2 & 16) == 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            final boolean z622 = z3;
            final boolean z722 = z4;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z3 = z;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        z4 = z2;
        if ((i2 & 16) == 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        final boolean z6222 = z3;
        final boolean z7222 = z4;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final Modifier headerTopPadding(Modifier modifier, final PaywallState.Loaded.Components state) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.headerTopPadding.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m13865invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m13865invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final int headerHeightPx = state.getHeaderHeightPx();
                final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(ConstraintsKt.m10990offsetNN6EwU$default(j, 0, -headerHeightPx, 1, null));
                return MeasureScope.layout$default(layout, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight() + headerHeightPx, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.headerTopPadding.1.1
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
                    public final void invoke2(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable.PlacementScope.placeRelative$default(layout2, placeableMo9625measureBRTryo0, 0, headerHeightPx, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    public static final Modifier footerBottomPadding(Modifier modifier, final PaywallState.Loaded.Components state) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        return LayoutModifierKt.layout(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.footerBottomPadding.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m13864invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m13864invoke3p2s80s(MeasureScope layout, Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                int footerHeightPx = state.getFooterHeightPx();
                final Placeable placeableMo9625measureBRTryo0 = measurable.mo9625measureBRTryo0(ConstraintsKt.m10990offsetNN6EwU$default(j, 0, -footerHeightPx, 1, null));
                return MeasureScope.layout$default(layout, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight() + footerHeightPx, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.footerBottomPadding.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Placeable.PlacementScope.placeRelative$default(layout2, placeableMo9625measureBRTryo0, 0, 0, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        });
    }

    public static final boolean shouldWrapMainContentInVerticalScroll(ComponentStyle rootStack) {
        Intrinsics.checkNotNullParameter(rootStack, "rootStack");
        StackComponentStyle stackComponentStyle = rootStack instanceof StackComponentStyle ? (StackComponentStyle) rootStack : null;
        return (stackComponentStyle != null ? stackComponentStyle.getScrollOrientation() : null) != Orientation.Vertical;
    }

    public static final Object handleClick(PaywallAction paywallAction, PaywallState.Loaded.Components components, Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Continuation<? super Unit> continuation) {
        if (paywallAction instanceof PaywallAction.External) {
            Object objInvoke = function2.invoke(paywallAction, continuation);
            return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
        }
        if ((paywallAction instanceof PaywallAction.Internal) && (((PaywallAction.Internal) paywallAction) instanceof PaywallAction.Internal.NavigateTo)) {
            PaywallAction.Internal.NavigateTo navigateTo = (PaywallAction.Internal.NavigateTo) paywallAction;
            if (navigateTo.getDestination() instanceof PaywallAction.Internal.NavigateTo.Destination.Sheet) {
                ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet = ((PaywallAction.Internal.NavigateTo.Destination.Sheet) navigateTo.getDestination()).getSheet();
                String name = sheet.getName();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = components.getSelectedPackageInfo();
                paywallComponentInteractionTracker.track(PaywallComponentInteractionFactoriesKt.paywallPackageSelectionSheetOpen(name, selectedPackageInfo != null ? selectedPackageInfo.getRcPackage() : null));
                show(components.getSheet(), sheet, components, paywallComponentInteractionTracker, new C75292(components, function2, paywallComponentInteractionTracker, null));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$handleClick$2 */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$handleClick$2", m1609f = "LoadedPaywallComponents.kt", m1610i = {}, m1611l = {PDFACompliance.e_PDFA3_2_6}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75292 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        final /* synthetic */ PaywallComponentInteractionTracker $componentInteractionTracker;
        final /* synthetic */ Function2<PaywallAction.External, Continuation<? super Unit>, Object> $externalClickHandler;
        final /* synthetic */ PaywallState.Loaded.Components $state;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C75292(PaywallState.Loaded.Components components, Function2<? super PaywallAction.External, ? super Continuation<? super Unit>, ? extends Object> function2, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Continuation<? super C75292> continuation) {
            super(2, continuation);
            this.$state = components;
            this.$externalClickHandler = function2;
            this.$componentInteractionTracker = paywallComponentInteractionTracker;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C75292 c75292 = new C75292(this.$state, this.$externalClickHandler, this.$componentInteractionTracker, continuation);
            c75292.L$0 = obj;
            return c75292;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C75292) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LoadedPaywallComponentsKt.handleClick((PaywallAction) this.L$0, this.$state, this.$externalClickHandler, this.$componentInteractionTracker, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final void show(final SimpleSheetState simpleSheetState, final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet, final PaywallState.Loaded.Components state, final PaywallComponentInteractionTracker componentInteractionTracker, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> onClick) {
        Intrinsics.checkNotNullParameter(simpleSheetState, "<this>");
        Intrinsics.checkNotNullParameter(sheet, "sheet");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(componentInteractionTracker, "componentInteractionTracker");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        simpleSheetState.show(sheet.getBackgroundBlur(), ComposableLambdaKt.composableLambdaInstance(-591146401, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C349@17373L208,345@17189L577:LoadedPaywallComponents.kt#dnqhhd");
                if ((i & 3) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-591146401, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.show.<anonymous> (LoadedPaywallComponents.kt:345)");
                    }
                    ComponentStyle stack = sheet.getStack();
                    Modifier modifierConditional = ModifierExtensionsKt.conditional(ModifierExtensionsKt.applyIfNotNull(Modifier.INSTANCE, sheet.getSize(), new Function2<Modifier, Size, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.1.1
                        @Override // kotlin.jvm.functions.Function2
                        public final Modifier invoke(Modifier applyIfNotNull, Size it) {
                            Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                            Intrinsics.checkNotNullParameter(it, "it");
                            return com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt.size$default(applyIfNotNull, it, null, null, 6, null);
                        }
                    }), sheet.getSize() == null, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.1.2
                        @Override // kotlin.jvm.functions.Function1
                        public final Modifier invoke(Modifier conditional) {
                            Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                            return SizeKt.fillMaxWidth$default(conditional, 0.0f, 1, null);
                        }
                    });
                    PaywallState.Loaded.Components components = state;
                    composer.startReplaceGroup(1731083003);
                    ComposerKt.sourceInformation(composer, "CC(remember):LoadedPaywallComponents.kt#9igjgp");
                    boolean zChanged = composer.changed(simpleSheetState) | composer.changedInstance(onClick);
                    SimpleSheetState simpleSheetState2 = simpleSheetState;
                    Function2<PaywallAction, Continuation<? super Unit>, Object> function2 = onClick;
                    LoadedPaywallComponentsKt$show$1$3$1 loadedPaywallComponentsKt$show$1$3$1RememberedValue = composer.rememberedValue();
                    if (zChanged || loadedPaywallComponentsKt$show$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        loadedPaywallComponentsKt$show$1$3$1RememberedValue = new LoadedPaywallComponentsKt$show$1$3$1(simpleSheetState2, function2, null);
                        composer.updateRememberedValue(loadedPaywallComponentsKt$show$1$3$1RememberedValue);
                    }
                    composer.endReplaceGroup();
                    ComponentViewKt.ComponentView(stack, components, (Function2) loadedPaywallComponentsKt$show$1$3$1RememberedValue, modifierConditional, componentInteractionTracker, composer, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }), sheet.getId(), new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.show.2
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
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = state.getSelectedPackageInfo();
                PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfoPeekSelectedPackageInfoAfterSheetDismiss = state.peekSelectedPackageInfoAfterSheetDismiss();
                componentInteractionTracker.track(PaywallComponentInteractionFactoriesKt.paywallPackageSelectionSheetClose(sheet.getName(), selectedPackageInfo != null ? selectedPackageInfo.getRcPackage() : null, selectedPackageInfoPeekSelectedPackageInfoAfterSheetDismiss != null ? selectedPackageInfoPeekSelectedPackageInfoAfterSheetDismiss.getRcPackage() : null));
                state.resetToDefaultPackage();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1173704376);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview)381@18621L31,382@18657L137:LoadedPaywallComponents.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1173704376, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview (LoadedPaywallComponents.kt:380)");
            }
            LoadedPaywallComponents(previewHelloWorldPaywallState(composerStartRestartGroup, 0), new C75191(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composerStartRestartGroup, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview.2
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
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview$1 */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview$1", m1609f = "LoadedPaywallComponents.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75191 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C75191(Continuation<? super C75191> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75191(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C75191) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_BottomSheet_NullSize_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-398756048);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_BottomSheet_NullSize_Preview)393@18904L31,402@19148L137:LoadedPaywallComponents.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-398756048, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_BottomSheet_NullSize_Preview (LoadedPaywallComponents.kt:392)");
            }
            PaywallState.Loaded.Components componentsPreviewHelloWorldPaywallState = previewHelloWorldPaywallState(composerStartRestartGroup, 0);
            show(componentsPreviewHelloWorldPaywallState.getSheet(), previewBottomSheet(null), componentsPreviewHelloWorldPaywallState, new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$$ExternalSyntheticLambda0
                @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                    Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                }
            }, new C75162(null));
            LoadedPaywallComponents(componentsPreviewHelloWorldPaywallState, new C75173(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composerStartRestartGroup, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_NullSize_Preview.4
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
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_NullSize_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$2 */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$2", m1609f = "LoadedPaywallComponents.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75162 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C75162(Continuation<? super C75162> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75162(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C75162) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$3 */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_NullSize_Preview$3", m1609f = "LoadedPaywallComponents.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75173 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C75173(Continuation<? super C75173> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75173(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C75173) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_BottomSheet_FitSize_Preview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(561912880);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_BottomSheet_FitSize_Preview)413@19394L31,422@19669L137:LoadedPaywallComponents.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(561912880, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_BottomSheet_FitSize_Preview (LoadedPaywallComponents.kt:412)");
            }
            PaywallState.Loaded.Components componentsPreviewHelloWorldPaywallState = previewHelloWorldPaywallState(composerStartRestartGroup, 0);
            show(componentsPreviewHelloWorldPaywallState.getSheet(), previewBottomSheet(new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null))), componentsPreviewHelloWorldPaywallState, new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$$ExternalSyntheticLambda2
                @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                    Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                }
            }, new C75132(null));
            LoadedPaywallComponents(componentsPreviewHelloWorldPaywallState, new C75143(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composerStartRestartGroup, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_FitSize_Preview.4
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
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_BottomSheet_FitSize_Preview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$2 */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$2", m1609f = "LoadedPaywallComponents.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75132 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C75132(Continuation<? super C75132> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75132(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C75132) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$3 */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_BottomSheet_FitSize_Preview$3", m1609f = "LoadedPaywallComponents.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75143 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C75143(Continuation<? super C75143> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75143(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C75143) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadedPaywallComponents_Preview_Bless(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-485118556);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywallComponents_Preview_Bless)595@29465L48,603@29761L137:LoadedPaywallComponents.kt#dnqhhd");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-485118556, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponents_Preview_Bless (LoadedPaywallComponents.kt:433)");
            }
            ColorScheme colorScheme = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())), new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8185getWhite0d7_KjU())));
            ColorScheme colorScheme2 = new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8185getWhite0d7_KjU())), new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())));
            DefaultConstructorMarker defaultConstructorMarker = null;
            Integer num = null;
            Padding padding = null;
            List list = null;
            String str = null;
            int i2 = 13564;
            int i3 = 0;
            Offering offering = new Offering("id", "description", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_paywall_id", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new StackComponent[]{new StackComponent(CollectionsKt.listOf(TestData.Components.INSTANCE.getMonthlyPackageComponent()), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.CENTER), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), (Float) null, new ColorScheme(new ColorInfo.Gradient.Linear(60.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color(255, 255, 255, 255)), 40.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color$default(5, 124, 91, 0, 8, null)), 100.0f)})), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, (Padding) null, (Padding) null, (com.revenuecat.purchases.paywalls.components.properties.Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65490, (DefaultConstructorMarker) null), new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m13834constructorimpl("title"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, FontWeight.SEMI_BOLD, num, 28, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), padding, new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 40.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), list, str, 13404, defaultConstructorMarker), new TextComponent(LocalizationKey.m13834constructorimpl("feature-1"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), padding, new Padding(8.0d, 8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), list, str, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m13834constructorimpl("feature-2"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), padding, new Padding(8.0d, 8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), list, str, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m13834constructorimpl("feature-3"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), padding, new Padding(8.0d, 8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), list, str, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m13834constructorimpl("feature-4"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), padding, new Padding(8.0d, 8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), list, str, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m13834constructorimpl("feature-5"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), padding, new Padding(8.0d, 8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), list, str, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m13834constructorimpl("feature-6"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), padding, new Padding(8.0d, 8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), list, str, i2, defaultConstructorMarker), new TextComponent(LocalizationKey.m13834constructorimpl("offer"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, num, i3, HorizontalAlignment.LEADING, new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), padding, new Padding(48.0d, 8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), list, str, i2, defaultConstructorMarker), new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("cta"), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8185getWhite0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, FontWeight.BOLD, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16348, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.CENTER), new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(ColorKt.Color$default(5, 124, 91, 0, 8, null))), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, new Padding(8.0d, 8.0d, 32.0d, 32.0d), new Padding(8.0d, 8.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE), Shape.Pill.INSTANCE, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 64594, (DefaultConstructorMarker) null), new TextComponent(LocalizationKey.m13834constructorimpl("terms"), colorScheme, (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, str, 16380, defaultConstructorMarker)}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.LEADING, FlexDistribution.END), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), (Float) null, (ColorScheme) null, (Background) null, new Padding(16.0d, 16.0d, 32.0d, 32.0d), (Padding) null, (com.revenuecat.purchases.paywalls.components.properties.Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65394, (DefaultConstructorMarker) null)}), (Boolean) null, new Dimension.ZLayer(TwoDimensionalAlignment.BOTTOM), new Size(SizeConstraint.Fill.INSTANCE, SizeConstraint.Fill.INSTANCE), (Float) null, colorScheme2, (Background) null, (Padding) null, (Padding) null, (com.revenuecat.purchases.paywalls.components.properties.Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65490, (DefaultConstructorMarker) null), new Background.Color(colorScheme2), (StickyFooterComponent) null, (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("title")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Unlock bless."))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("feature-1")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("✓ Enjoy a 7 day trial"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("feature-2")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("✓ Change currencies"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("feature-3")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("✓ Access more trend charts"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("feature-4")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("✓ Create custom categories"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("feature-5")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("✓ Get a special premium icon"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("feature-6")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("✓ Receive our love and gratitude for your support"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("offer")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Try 7 days free, then $19.98/year. Cancel anytime."))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("cta")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Continue"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("terms")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Privacy & Terms")))))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
            Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composerStartRestartGroup, 0);
            PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
            Intrinsics.checkNotNull(components);
            LoadedPaywallComponents(OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview_Bless$state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null), new C75211(null), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composerStartRestartGroup, 432, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview_Bless.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                    invoke(composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    LoadedPaywallComponentsKt.LoadedPaywallComponents_Preview_Bless(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview_Bless$1 */
    /* JADX INFO: compiled from: LoadedPaywallComponents.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt$LoadedPaywallComponents_Preview_Bless$1", m1609f = "LoadedPaywallComponents.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75211 extends SuspendLambda implements Function2<PaywallAction.External, Continuation<? super Unit>, Object> {
        int label;

        C75211(Continuation<? super C75211> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75211(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction.External external, Continuation<? super Unit> continuation) {
            return ((C75211) create(external, continuation)).invokeSuspend(Unit.INSTANCE);
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

    /* JADX WARN: Multi-variable type inference failed */
    private static final PaywallState.Loaded.Components previewHelloWorldPaywallState(Composer composer, int i) {
        composer.startReplaceGroup(-1486758699);
        ComposerKt.sourceInformation(composer, "C(previewHelloWorldPaywallState)683@33240L48:LoadedPaywallComponents.kt#dnqhhd");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1486758699, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.previewHelloWorldPaywallState (LoadedPaywallComponents.kt:613)");
        }
        Offering offering = new Offering("id", "description", MapsKt.emptyMap(), CollectionsKt.listOf(TestData.Packages.INSTANCE.getMonthly()), null, new Offering.PaywallComponents(PreviewHelpersKt.previewUiConfig$default(null, null, null, 7, null), new PaywallComponentsData("preview_paywall_id", "template", new URL("https://assets.pawwalls.com"), new ComponentsConfig(new PaywallComponentsConfig(new StackComponent(CollectionsKt.listOf((Object[]) new PaywallComponent[]{new TextComponent(LocalizationKey.m13834constructorimpl("hello-world"), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) null, (String) null, (FontWeight) null, (Integer) null, 0, (HorizontalAlignment) null, (Size) null, (Padding) null, (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null), TestData.Components.INSTANCE.getMonthlyPackageComponent()}), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8176getCyan0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, (Padding) null, (Padding) null, (com.revenuecat.purchases.paywalls.components.properties.Shape) null, (Border) null, (Shadow) null, (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 65498, (DefaultConstructorMarker) null), new Background.Color(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8175getBlue0d7_KjU())), new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8182getRed0d7_KjU())))), new StickyFooterComponent(new StackComponent(CollectionsKt.listOf(new TextComponent(LocalizationKey.m13834constructorimpl("sticky-footer"), new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Boolean) null, (ColorScheme) (0 == true ? 1 : 0), (String) null, (FontWeight) (0 == true ? 1 : 0), (Integer) (0 == true ? 1 : 0), 0, (HorizontalAlignment) (0 == true ? 1 : 0), (Size) (0 == true ? 1 : 0), (Padding) (0 == true ? 1 : 0), (Padding) null, (List) null, (String) null, 16380, (DefaultConstructorMarker) null)), (Boolean) null, new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), (Size) null, (Float) null, new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8185getWhite0d7_KjU())), (ColorInfo) null, 2, (DefaultConstructorMarker) null), (Background) null, (Padding) null, (Padding) null, new Shape.Rectangle(new CornerRadiuses.C7411Dp(10.0d, 10.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)), (Border) null, new Shadow(new ColorScheme(new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8174getBlack0d7_KjU())), new ColorInfo.Hex(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8186getYellow0d7_KjU()))), 10.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, -5.0d), (Badge) null, (StackComponent.Overflow) null, (List) null, (String) null, 62938, (DefaultConstructorMarker) null)), (HeaderComponent) null, 8, (DefaultConstructorMarker) null)), MapsKt.mapOf(TuplesKt.m1606to(LocaleId.m13797boximpl(LocaleId.m13798constructorimpl("en_US")), MapsKt.mapOf(TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("hello-world")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Hello, world!"))), TuplesKt.m1606to(LocalizationKey.m13833boximpl(LocalizationKey.m13834constructorimpl("sticky-footer")), LocalizationData.Text.m13815boximpl(LocalizationData.Text.m13816constructorimpl("Sticky Footer")))))), LocaleId.m13798constructorimpl("en_US"), 0, (List) null, (ExitOffers) null, (ProductChangeConfig) null, false, (Map) null, 4032, (DefaultConstructorMarker) null)), null, 80, null);
        Result resultValidatePaywallComponentsDataOrNullForPreviews = PreviewHelpersKt.validatePaywallComponentsDataOrNullForPreviews(offering, composer, 0);
        PaywallValidationResult.Components components = resultValidatePaywallComponentsDataOrNullForPreviews != null ? (PaywallValidationResult.Components) com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResultKt.getOrThrow(resultValidatePaywallComponentsDataOrNullForPreviews) : null;
        Intrinsics.checkNotNull(components);
        PaywallState.Loaded.Components componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, components, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.LoadedPaywallComponentsKt.previewHelloWorldPaywallState.1
            @Override // kotlin.jvm.functions.Function0
            public final Date invoke() {
                return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
            }
        }, new MockPurchasesType(null, null, null, null, null, null, 63, null), null, null, null, null, null, 496, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return componentsPaywallState$default;
    }

    static /* synthetic */ ButtonComponentStyle.Action.NavigateTo.Destination.Sheet previewBottomSheet$default(Size size, int i, Object obj) {
        if ((i & 1) != 0) {
            size = null;
        }
        return previewBottomSheet(size);
    }

    private static final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet previewBottomSheet(Size size) {
        return new ButtonComponentStyle.Action.NavigateTo.Destination.Sheet("", "", PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(CollectionsKt.listOf((Object[]) new TextComponentStyle[]{PreviewHelpersKt.previewTextComponentStyle("This is a bottom sheet.", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("This is a bottom sheet.", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewTextComponentStyle("This is a bottom sheet.", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)}), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8185getWhite0d7_KjU())), null, 2, null))), (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : new Shape.Rectangle(new CornerRadiuses.C7411Dp(16.0d, 16.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)), (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), true, size);
    }
}
