package com.revenuecat.purchases.p036ui.revenuecatui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.UriHandler;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DensityKt;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.p036ui.revenuecatui.components.LoadedPaywallComponentsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.LoadedWorkflowPaywallKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.CloseButtonKt;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.ErrorDialogKt;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModelFactory;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModelImpl;
import com.revenuecat.purchases.p036ui.revenuecatui.data.WorkflowPaywallUiState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.PaywallTemplate;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.defaultpaywall.DefaultPaywallViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.fonts.PaywallThemeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ContextExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallProductIdentifierKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallResourceProviderKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallWarning;
import com.revenuecat.purchases.p036ui.revenuecatui.templates.Template1Kt;
import com.revenuecat.purchases.p036ui.revenuecatui.templates.Template2Kt;
import com.revenuecat.purchases.p036ui.revenuecatui.templates.Template3Kt;
import com.revenuecat.purchases.p036ui.revenuecatui.templates.Template4Kt;
import com.revenuecat.purchases.p036ui.revenuecatui.templates.Template5Kt;
import com.revenuecat.purchases.p036ui.revenuecatui.templates.Template7Kt;
import com.revenuecat.purchases.p036ui.revenuecatui.utils.URLOpener;
import com.revenuecat.purchases.p036ui.revenuecatui.utils.URLOpeningMethod;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: InternalPaywall.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u0010\u0011\u001a(\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000b2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0016\u001a-\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019H\u0001¢\u0006\u0002\u0010\u001b\u001a \u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0002\u001a1\u0010!\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010$\u0012\u0006\u0012\u0004\u0018\u00010%0\"2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010&\u001a\u0011\u0010'\u001a\u00020(*\u00020\tH\u0003¢\u0006\u0002\u0010)\u001a\u0019\u0010*\u001a\u00020\u001e*\u00020\t2\u0006\u0010+\u001a\u00020(H\u0003¢\u0006\u0002\u0010,\u001a\u001c\u0010-\u001a\u00020\u000b*\u00020\u001e2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0002\u001a&\u00102\u001a\u000203*\u0002032\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u000206H\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00069"}, m1599d2 = {"InternalPaywall", "", "options", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;II)V", "LoadedPaywall", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "isDarkTheme", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;ZLandroidx/compose/runtime/Composer;I)V", "NotifyingUriHandler", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "PaywallFontScaling", "automaticallyScaleFontSize", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TemplatePaywall", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;I)V", "getPaywallViewModel", "shouldDisplayBlock", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallOptions;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "handleLaunchWebCheckout", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "action", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "rememberPaywallActionHandler", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "configurationWithOverriddenLocale", "Landroid/content/res/Configuration;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroidx/compose/runtime/Composer;I)Landroid/content/res/Configuration;", "contextWithConfiguration", "configuration", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Landroid/content/res/Configuration;Landroidx/compose/runtime/Composer;I)Landroid/content/Context;", "handleUrlDestination", ImagesContract.URL, "", FirebaseAnalytics.Param.METHOD, "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "screenModeBackground", "Landroidx/compose/ui/Modifier;", "isInFullScreenMode", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "Landroidx/compose/ui/graphics/Color;", "screenModeBackground-mxwnekA", "(Landroidx/compose/ui/Modifier;ZJ)Landroidx/compose/ui/Modifier;", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class InternalPaywallKt {

    /* JADX INFO: compiled from: InternalPaywall.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaywallTemplate.values().length];
            try {
                iArr[PaywallTemplate.TEMPLATE_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_5.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PaywallTemplate.TEMPLATE_7.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ButtonComponent.UrlMethod.values().length];
            try {
                iArr2[ButtonComponent.UrlMethod.IN_APP_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ButtonComponent.UrlMethod.EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ButtonComponent.UrlMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ButtonComponent.UrlMethod.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PaywallFontScaling(final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2095974644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PaywallFontScaling):InternalPaywall.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2095974644, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallFontScaling (InternalPaywall.kt:81)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(574565882);
                ComposerKt.sourceInformation(composerStartRestartGroup, "83@4572L9");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(574602183);
                ComposerKt.sourceInformation(composerStartRestartGroup, "85@4630L7,88@4758L33,86@4646L145");
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalDensity().provides(DensityKt.Density(((Density) objConsume).getDensity(), 1.0f)), ComposableLambdaKt.rememberComposableLambda(1480886312, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.PaywallFontScaling.1
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

                    public final void invoke(Composer composer2, int i3) {
                        ComposerKt.sourceInformation(composer2, "C89@4772L9:InternalPaywall.kt#ao8ymz");
                        if ((i3 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1480886312, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.PaywallFontScaling.<anonymous> (InternalPaywall.kt:89)");
                        }
                        function2.invoke(composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.PaywallFontScaling.2
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

                public final void invoke(Composer composer2, int i3) {
                    InternalPaywallKt.PaywallFontScaling(z, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NotifyingUriHandler(final PaywallViewModel paywallViewModel, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(964997897);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotifyingUriHandler)P(1)103@5176L7,104@5214L329,114@5549L89:InternalPaywall.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(paywallViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(964997897, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.NotifyingUriHandler (InternalPaywall.kt:102)");
            }
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final UriHandler uriHandler = (UriHandler) objConsume;
            composerStartRestartGroup.startReplaceGroup(-1842667081);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
            boolean zChanged = ((i2 & 14) == 4) | composerStartRestartGroup.changed(uriHandler);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new UriHandler() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$NotifyingUriHandler$notifyingUriHandler$1$1
                    @Override // androidx.compose.p004ui.platform.UriHandler
                    public void openUri(String uri) {
                        Intrinsics.checkNotNullParameter(uri, "uri");
                        uriHandler.openUri(uri);
                        paywallViewModel.notifyUrlOpened(uri);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalUriHandler().provides((InternalPaywallKt$NotifyingUriHandler$notifyingUriHandler$1$1) objRememberedValue), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.NotifyingUriHandler.1
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

                public final void invoke(Composer composer2, int i3) {
                    InternalPaywallKt.NotifyingUriHandler(paywallViewModel, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InternalPaywall(final PaywallOptions options, PaywallViewModel paywallViewModel, Composer composer, final int i, final int i2) {
        int i3;
        final PaywallViewModel paywallViewModel2;
        int i4;
        boolean z;
        Object objRememberedValue;
        boolean z2;
        Object objRememberedValue2;
        final ColorScheme colorScheme;
        final boolean zIsSystemInDarkTheme;
        boolean zChanged;
        Object objRememberedValue3;
        int i5;
        boolean z3;
        Object objRememberedValue4;
        Intrinsics.checkNotNullParameter(options, "options");
        Composer composerStartRestartGroup = composer.startRestartGroup(458565693);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(InternalPaywall)123@5860L119,123@5832L147,130@5997L103,130@5985L115,136@6138L11,137@6167L21,138@6204L145,138@6193L156,143@6383L29,145@6458L144,151@6658L482,151@6608L532,165@7196L668,165@7146L718,187@8189L1933,183@7984L2138:InternalPaywall.kt#ao8ymz");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(options) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                paywallViewModel2 = paywallViewModel;
                int i6 = composerStartRestartGroup.changed(paywallViewModel2) ? 32 : 16;
                i3 |= i6;
            } else {
                paywallViewModel2 = paywallViewModel;
            }
            i3 |= i6;
        } else {
            paywallViewModel2 = paywallViewModel;
        }
        if ((i3 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "121@5794L28");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composerStartRestartGroup.startReplaceGroup(-1568418429);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                i4 = (i3 & 112) ^ 48;
                if (i4 <= 32) {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z) {
                        objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                paywallViewModel2.onPaywallPresented();
                                final PaywallViewModel paywallViewModel3 = paywallViewModel2;
                                return new DisposableEffectResult() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        paywallViewModel3.onPaywallDismissed();
                                    }
                                };
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(paywallViewModel2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, (i3 >> 3) & 14);
                        composerStartRestartGroup.startReplaceGroup(-1568414061);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                        if (i4 <= 32) {
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$2$1
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
                                        if (paywallViewModel2.handleBackNavigation()) {
                                            return;
                                        }
                                        PaywallViewModel.closePaywall$default(paywallViewModel2, null, 1, null);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                composerStartRestartGroup.endReplaceGroup();
                                BackHandlerKt.BackHandler(false, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1);
                                colorScheme = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable);
                                zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                                composerStartRestartGroup.startReplaceGroup(-1568407395);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                                if (i4 <= 32) {
                                    zChanged = ((i4 <= 32 && composerStartRestartGroup.changed(paywallViewModel2)) || (i3 & 48) == 32) | composerStartRestartGroup.changed(colorScheme) | composerStartRestartGroup.changed(zIsSystemInDarkTheme);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged) {
                                        objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$3$1
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
                                                paywallViewModel2.refreshStateIfLocaleChanged();
                                                paywallViewModel2.refreshStateIfColorsChanged(colorScheme, zIsSystemInDarkTheme);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                        composerStartRestartGroup.endReplaceGroup();
                                        EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                                        final PaywallState paywallState = (PaywallState) FlowExtKt.collectAsStateWithLifecycle(paywallViewModel2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7).getValue();
                                        composerStartRestartGroup.startReplaceGroup(-1568399268);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                                        if (i4 > 32) {
                                            i5 = 48;
                                            if ((i3 & 48) != 32) {
                                                z3 = true;
                                            }
                                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                            if (z3) {
                                            }
                                        }
                                    }
                                } else {
                                    zChanged = ((i4 <= 32 && composerStartRestartGroup.changed(paywallViewModel2)) || (i3 & 48) == 32) | composerStartRestartGroup.changed(colorScheme) | composerStartRestartGroup.changed(zIsSystemInDarkTheme);
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (zChanged) {
                                    }
                                }
                            }
                        } else {
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (z2) {
                            }
                        }
                    }
                } else {
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (z) {
                    }
                }
            } else {
                if ((i2 & 2) != 0) {
                    paywallViewModel2 = getPaywallViewModel(options, null, composerStartRestartGroup, i3 & 14, 2);
                    i3 &= -113;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(458565693, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall (InternalPaywall.kt:122)");
                }
                composerStartRestartGroup.startReplaceGroup(-1568418429);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                i4 = (i3 & 112) ^ 48;
                z = (i4 <= 32 && composerStartRestartGroup.changed(paywallViewModel2)) || (i3 & 48) == 32;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            paywallViewModel2.onPaywallPresented();
                            final PaywallViewModel paywallViewModel3 = paywallViewModel2;
                            return new DisposableEffectResult() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$1$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    paywallViewModel3.onPaywallDismissed();
                                }
                            };
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(paywallViewModel2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, (i3 >> 3) & 14);
                composerStartRestartGroup.startReplaceGroup(-1568414061);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                z2 = (i4 <= 32 && composerStartRestartGroup.changed(paywallViewModel2)) || (i3 & 48) == 32;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$2$1
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
                            if (paywallViewModel2.handleBackNavigation()) {
                                return;
                            }
                            PaywallViewModel.closePaywall$default(paywallViewModel2, null, 1, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                BackHandlerKt.BackHandler(false, (Function0) objRememberedValue2, composerStartRestartGroup, 0, 1);
                colorScheme = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable);
                zIsSystemInDarkTheme = DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceGroup(-1568407395);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                zChanged = ((i4 <= 32 && composerStartRestartGroup.changed(paywallViewModel2)) || (i3 & 48) == 32) | composerStartRestartGroup.changed(colorScheme) | composerStartRestartGroup.changed(zIsSystemInDarkTheme);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$3$1
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
                            paywallViewModel2.refreshStateIfLocaleChanged();
                            paywallViewModel2.refreshStateIfColorsChanged(colorScheme, zIsSystemInDarkTheme);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                final PaywallState paywallState2 = (PaywallState) FlowExtKt.collectAsStateWithLifecycle(paywallViewModel2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7).getValue();
                composerStartRestartGroup.startReplaceGroup(-1568399268);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                if (i4 > 32 || !composerStartRestartGroup.changed(paywallViewModel2)) {
                    i5 = 48;
                    if ((i3 & 48) != 32) {
                        z3 = false;
                    }
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (z3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$$ExternalSyntheticLambda0
                            @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                            public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                                InternalPaywallKt.InternalPaywall$lambda$5$lambda$4(paywallViewModel2, paywallComponentInteractionData);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker = (PaywallComponentInteractionTracker) objRememberedValue4;
                    composerStartRestartGroup.endReplaceGroup();
                    PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1925201086, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i7) {
                            ComposerKt.sourceInformation(composer2, "C156@6910L224,152@6668L466:InternalPaywall.kt#ao8ymz");
                            if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1925201086, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:152)");
                                }
                                PaywallState paywallState3 = paywallState2;
                                boolean z4 = (paywallState3 instanceof PaywallState.Loading) || (paywallState3 instanceof PaywallState.Error);
                                EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                final PaywallOptions paywallOptions = options;
                                final PaywallViewModel paywallViewModel3 = paywallViewModel2;
                                AnimatedVisibilityKt.AnimatedVisibility(z4, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, ComposableLambdaKt.rememberComposableLambda(272980506, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                        invoke(animatedVisibilityScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i8) {
                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                        ComposerKt.sourceInformation(composer3, "C160@7086L23,157@6924L200:InternalPaywall.kt#ao8ymz");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(272980506, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:157)");
                                        }
                                        PaywallMode mode = paywallOptions.getMode();
                                        boolean shouldDisplayDismissButton = paywallOptions.getShouldDisplayDismissButton();
                                        PaywallViewModel paywallViewModel4 = paywallViewModel3;
                                        composer3.startReplaceGroup(1191380961);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):InternalPaywall.kt#9igjgp");
                                        boolean zChanged2 = composer3.changed(paywallViewModel4);
                                        InternalPaywallKt$InternalPaywall$4$1$1$1 internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue = composer3.rememberedValue();
                                        if (zChanged2 || internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$4$1$1$1(paywallViewModel4);
                                            composer3.updateRememberedValue(internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue);
                                        }
                                        composer3.endReplaceGroup();
                                        LoadingPaywallKt.LoadingPaywall(mode, shouldDisplayDismissButton, (Function0<Unit>) internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue, composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.f379xf2722a21, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i5);
                    PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1460021447, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i7) {
                            ComposerKt.sourceInformation(composer2, "C170@7423L435,166@7206L652:InternalPaywall.kt#ao8ymz");
                            if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1460021447, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:166)");
                                }
                                boolean z4 = paywallState2 instanceof PaywallState.Loaded.Legacy;
                                EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                final PaywallState paywallState3 = paywallState2;
                                final PaywallViewModel paywallViewModel3 = paywallViewModel2;
                                final boolean z5 = zIsSystemInDarkTheme;
                                AnimatedVisibilityKt.AnimatedVisibility(z4, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, ComposableLambdaKt.rememberComposableLambda(-2131421167, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                        invoke(animatedVisibilityScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i8) {
                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                        ComposerKt.sourceInformation(composer3, "C172@7496L73:InternalPaywall.kt#ao8ymz");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2131421167, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:171)");
                                        }
                                        PaywallState paywallState4 = paywallState3;
                                        if (paywallState4 instanceof PaywallState.Loaded.Legacy) {
                                            InternalPaywallKt.LoadedPaywall((PaywallState.Loaded.Legacy) paywallState4, paywallViewModel3, z5, composer3, 0);
                                        } else {
                                            Logger.INSTANCE.m1584e("State is not loaded while transitioning animation. This may happen if state changes from being loaded to a different state. This should not happen.");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.f379xf2722a21, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i5);
                    int i7 = i5;
                    AnimatedVisibilityKt.AnimatedVisibility(paywallState2 instanceof PaywallState.Loaded.Components, (Modifier) null, EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1024882965, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                            invoke(animatedVisibilityScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i8) {
                            PaywallComponentsData dataOrNull;
                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                            ComposerKt.sourceInformation(composer2, "C204@8933L928,202@8787L1074:InternalPaywall.kt#ao8ymz");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1024882965, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:188)");
                            }
                            PaywallState paywallState3 = paywallState2;
                            if (paywallState3 instanceof PaywallState.Loaded.Components) {
                                Offering.PaywallComponents paywallComponents = ((PaywallState.Loaded.Components) paywallState3).getOffering().getPaywallComponents();
                                composer2.startReplaceGroup(-1503536342);
                                ComposerKt.sourceInformation(composer2, "198@8678L82,191@8376L384");
                                if (paywallComponents != null) {
                                    String identifier = ((PaywallState.Loaded.Components) paywallState2).getOffering().getIdentifier();
                                    PaywallComponentsData dataOrNull2 = paywallComponents.getDataOrNull();
                                    String id = dataOrNull2 != null ? dataOrNull2.getId() : null;
                                    PaywallComponentsData dataOrNull3 = paywallComponents.getDataOrNull();
                                    Object[] objArr = {identifier, id, dataOrNull3 != null ? Integer.valueOf(dataOrNull3.getRevision()) : null, options.getMode(), ((PaywallState.Loaded.Components) paywallState2).getLocale().toString(), Boolean.valueOf(zIsSystemInDarkTheme)};
                                    composer2.startReplaceGroup(-1503525475);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):InternalPaywall.kt#9igjgp");
                                    boolean zChanged2 = composer2.changed(paywallViewModel2);
                                    PaywallViewModel paywallViewModel3 = paywallViewModel2;
                                    InternalPaywallKt$InternalPaywall$6$1$1 internalPaywallKt$InternalPaywall$6$1$1RememberedValue = composer2.rememberedValue();
                                    if (zChanged2 || internalPaywallKt$InternalPaywall$6$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        internalPaywallKt$InternalPaywall$6$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$6$1$1(paywallViewModel3, null);
                                        composer2.updateRememberedValue(internalPaywallKt$InternalPaywall$6$1$1RememberedValue);
                                    }
                                    composer2.endReplaceGroup();
                                    EffectsKt.LaunchedEffect(objArr, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) internalPaywallKt$InternalPaywall$6$1$1RememberedValue, composer2, 0);
                                }
                                composer2.endReplaceGroup();
                                boolean automaticallyScaleFontSize = (paywallComponents == null || (dataOrNull = paywallComponents.getDataOrNull()) == null) ? true : dataOrNull.getAutomaticallyScaleFontSize();
                                final PaywallViewModel paywallViewModel4 = paywallViewModel2;
                                final PaywallComponentInteractionTracker paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
                                final PaywallState paywallState4 = paywallState2;
                                InternalPaywallKt.PaywallFontScaling(automaticallyScaleFontSize, ComposableLambdaKt.rememberComposableLambda(781998052, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.6.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i9) {
                                        ComposerKt.sourceInformation(composer3, "C205@8982L865,205@8951L896:InternalPaywall.kt#ao8ymz");
                                        if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(781998052, i9, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:205)");
                                            }
                                            PaywallViewModel paywallViewModel5 = paywallViewModel4;
                                            final PaywallViewModel paywallViewModel6 = paywallViewModel4;
                                            final PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker2;
                                            final PaywallState paywallState5 = paywallState4;
                                            InternalPaywallKt.NotifyingUriHandler(paywallViewModel5, ComposableLambdaKt.rememberComposableLambda(-414156817, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.6.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i10) {
                                                    ComposerKt.sourceInformation(composer4, "C:InternalPaywall.kt#ao8ymz");
                                                    if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-414156817, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous>.<anonymous> (InternalPaywall.kt:206)");
                                                        }
                                                        WorkflowPaywallUiState value = paywallViewModel6.getWorkflowState().getValue();
                                                        if (value != null) {
                                                            composer4.startReplaceGroup(-154107873);
                                                            ComposerKt.sourceInformation(composer4, "210@9260L31,211@9336L39,208@9127L362");
                                                            PaywallViewModel paywallViewModel7 = paywallViewModel6;
                                                            composer4.startReplaceGroup(826317480);
                                                            ComposerKt.sourceInformation(composer4, "CC(remember):InternalPaywall.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(paywallViewModel7);
                                                            InternalPaywallKt$InternalPaywall$6$2$1$1$1 internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue = composer4.rememberedValue();
                                                            if (zChanged3 || internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$6$2$1$1$1(paywallViewModel7);
                                                                composer4.updateRememberedValue(internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue);
                                                            }
                                                            composer4.endReplaceGroup();
                                                            LoadedWorkflowPaywallKt.LoadedWorkflowPaywall(value, (Function1) ((KFunction) internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue), InternalPaywallKt.rememberPaywallActionHandler(paywallViewModel6, composer4, 0), paywallComponentInteractionTracker3, null, null, composer4, 0, 48);
                                                            composer4.endReplaceGroup();
                                                        } else {
                                                            composer4.startReplaceGroup(-153698239);
                                                            ComposerKt.sourceInformation(composer4, "217@9654L39,215@9543L264");
                                                            LoadedPaywallComponentsKt.LoadedPaywallComponents((PaywallState.Loaded.Components) paywallState5, InternalPaywallKt.rememberPaywallActionHandler(paywallViewModel6, composer4, 0), null, paywallComponentInteractionTracker3, composer4, 0, 4);
                                                            composer4.endReplaceGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }, composer3, 54), composer3, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54), composer2, 48);
                            } else {
                                Logger.INSTANCE.m1584e("State is not loaded while transitioning animation. This may happen if state changes from being loaded to a different state. This should not happen.");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 18);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (!(paywallState2 instanceof PaywallState.Loading)) {
                        composerStartRestartGroup.startReplaceGroup(-1372051212);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (paywallState2 instanceof PaywallState.Error) {
                        composerStartRestartGroup.startReplaceGroup(-1372006975);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "235@10279L171,235@10229L221");
                        PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1440901149, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i8) {
                                ComposerKt.sourceInformation(composer2, "C236@10297L139:InternalPaywall.kt#ao8ymz");
                                if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1440901149, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:236)");
                                    }
                                    ErrorDialogKt.ErrorDialog(options.getDismissRequest(), ((PaywallState.Error) paywallState2).getErrorMessage(), composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, i7);
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (paywallState2 instanceof PaywallState.Loaded) {
                        composerStartRestartGroup.startReplaceGroup(-1371718830);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*245@10591L188");
                        final PurchasesError value = paywallViewModel2.getActionError().getValue();
                        if (value != null) {
                            final ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-2015353972, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$8$errorDialog$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i8) {
                                    ComposerKt.sourceInformation(composer2, "C247@10667L27,246@10613L148:InternalPaywall.kt#ao8ymz");
                                    if ((i8 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2015353972, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:246)");
                                        }
                                        PaywallViewModel paywallViewModel3 = paywallViewModel2;
                                        composer2.startReplaceGroup(1191495557);
                                        ComposerKt.sourceInformation(composer2, "CC(remember):InternalPaywall.kt#9igjgp");
                                        boolean zChanged2 = composer2.changed(paywallViewModel3);
                                        InternalPaywallKt$InternalPaywall$8$errorDialog$1$1$1 internalPaywallKt$InternalPaywall$8$errorDialog$1$1$1RememberedValue = composer2.rememberedValue();
                                        if (zChanged2 || internalPaywallKt$InternalPaywall$8$errorDialog$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            internalPaywallKt$InternalPaywall$8$errorDialog$1$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$8$errorDialog$1$1$1(paywallViewModel3);
                                            composer2.updateRememberedValue(internalPaywallKt$InternalPaywall$8$errorDialog$1$1$1RememberedValue);
                                        }
                                        composer2.endReplaceGroup();
                                        ErrorDialogKt.ErrorDialog((Function0) ((KFunction) internalPaywallKt$InternalPaywall$8$errorDialog$1$1$1RememberedValue), value.getMessage(), composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54);
                            PaywallState.Loaded loaded = (PaywallState.Loaded) paywallState2;
                            if (loaded instanceof PaywallState.Loaded.Legacy) {
                                composerStartRestartGroup.startReplaceGroup(-1503455538);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "252@10914L17,252@10864L67");
                                PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-533250649, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$InternalPaywall$8$1
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
                                        ComposerKt.sourceInformation(composer2, "C252@10916L13:InternalPaywall.kt#ao8ymz");
                                        if ((i8 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-533250649, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:252)");
                                        }
                                        composableLambdaRememberComposableLambda.invoke(composer2, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, i7);
                                composerStartRestartGroup.endReplaceGroup();
                            } else if (loaded instanceof PaywallState.Loaded.Components) {
                                composerStartRestartGroup.startReplaceGroup(-1503451592);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "253@10989L13");
                                composableLambdaRememberComposableLambda.invoke(composerStartRestartGroup, 6);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(637671255);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1371186250);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    i5 = 48;
                }
                z3 = true;
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (z3) {
                    objRememberedValue4 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$$ExternalSyntheticLambda0
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            InternalPaywallKt.InternalPaywall$lambda$5$lambda$4(paywallViewModel2, paywallComponentInteractionData);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    final PaywallComponentInteractionTracker paywallComponentInteractionTracker2 = (PaywallComponentInteractionTracker) objRememberedValue4;
                    composerStartRestartGroup.endReplaceGroup();
                    PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1925201086, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i72) {
                            ComposerKt.sourceInformation(composer2, "C156@6910L224,152@6668L466:InternalPaywall.kt#ao8ymz");
                            if ((i72 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1925201086, i72, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:152)");
                                }
                                PaywallState paywallState3 = paywallState2;
                                boolean z4 = (paywallState3 instanceof PaywallState.Loading) || (paywallState3 instanceof PaywallState.Error);
                                EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                final PaywallOptions paywallOptions = options;
                                final PaywallViewModel paywallViewModel3 = paywallViewModel2;
                                AnimatedVisibilityKt.AnimatedVisibility(z4, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, ComposableLambdaKt.rememberComposableLambda(272980506, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                        invoke(animatedVisibilityScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i8) {
                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                        ComposerKt.sourceInformation(composer3, "C160@7086L23,157@6924L200:InternalPaywall.kt#ao8ymz");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(272980506, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:157)");
                                        }
                                        PaywallMode mode = paywallOptions.getMode();
                                        boolean shouldDisplayDismissButton = paywallOptions.getShouldDisplayDismissButton();
                                        PaywallViewModel paywallViewModel4 = paywallViewModel3;
                                        composer3.startReplaceGroup(1191380961);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):InternalPaywall.kt#9igjgp");
                                        boolean zChanged2 = composer3.changed(paywallViewModel4);
                                        InternalPaywallKt$InternalPaywall$4$1$1$1 internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue = composer3.rememberedValue();
                                        if (zChanged2 || internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                            internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$4$1$1$1(paywallViewModel4);
                                            composer3.updateRememberedValue(internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue);
                                        }
                                        composer3.endReplaceGroup();
                                        LoadingPaywallKt.LoadingPaywall(mode, shouldDisplayDismissButton, (Function0<Unit>) internalPaywallKt$InternalPaywall$4$1$1$1RememberedValue, composer3, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.f379xf2722a21, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i5);
                    PaywallThemeKt.PaywallTheme(options.getFontProvider(), ComposableLambdaKt.rememberComposableLambda(-1460021447, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i72) {
                            ComposerKt.sourceInformation(composer2, "C170@7423L435,166@7206L652:InternalPaywall.kt#ao8ymz");
                            if ((i72 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1460021447, i72, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:166)");
                                }
                                boolean z4 = paywallState2 instanceof PaywallState.Loaded.Legacy;
                                EnterTransition enterTransitionFadeIn$default = EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                ExitTransition exitTransitionFadeOut$default = EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null);
                                final PaywallState paywallState3 = paywallState2;
                                final PaywallViewModel paywallViewModel3 = paywallViewModel2;
                                final boolean z5 = zIsSystemInDarkTheme;
                                AnimatedVisibilityKt.AnimatedVisibility(z4, (Modifier) null, enterTransitionFadeIn$default, exitTransitionFadeOut$default, (String) null, ComposableLambdaKt.rememberComposableLambda(-2131421167, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                        invoke(animatedVisibilityScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer3, int i8) {
                                        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                                        ComposerKt.sourceInformation(composer3, "C172@7496L73:InternalPaywall.kt#ao8ymz");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2131421167, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:171)");
                                        }
                                        PaywallState paywallState4 = paywallState3;
                                        if (paywallState4 instanceof PaywallState.Loaded.Legacy) {
                                            InternalPaywallKt.LoadedPaywall((PaywallState.Loaded.Legacy) paywallState4, paywallViewModel3, z5, composer3, 0);
                                        } else {
                                            Logger.INSTANCE.m1584e("State is not loaded while transitioning animation. This may happen if state changes from being loaded to a different state. This should not happen.");
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.f379xf2722a21, 18);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, i5);
                    int i72 = i5;
                    AnimatedVisibilityKt.AnimatedVisibility(paywallState2 instanceof PaywallState.Loaded.Components, (Modifier) null, EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1024882965, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                            invoke(animatedVisibilityScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i8) {
                            PaywallComponentsData dataOrNull;
                            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                            ComposerKt.sourceInformation(composer2, "C204@8933L928,202@8787L1074:InternalPaywall.kt#ao8ymz");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1024882965, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous> (InternalPaywall.kt:188)");
                            }
                            PaywallState paywallState3 = paywallState2;
                            if (paywallState3 instanceof PaywallState.Loaded.Components) {
                                Offering.PaywallComponents paywallComponents = ((PaywallState.Loaded.Components) paywallState3).getOffering().getPaywallComponents();
                                composer2.startReplaceGroup(-1503536342);
                                ComposerKt.sourceInformation(composer2, "198@8678L82,191@8376L384");
                                if (paywallComponents != null) {
                                    String identifier = ((PaywallState.Loaded.Components) paywallState2).getOffering().getIdentifier();
                                    PaywallComponentsData dataOrNull2 = paywallComponents.getDataOrNull();
                                    String id = dataOrNull2 != null ? dataOrNull2.getId() : null;
                                    PaywallComponentsData dataOrNull3 = paywallComponents.getDataOrNull();
                                    Object[] objArr = {identifier, id, dataOrNull3 != null ? Integer.valueOf(dataOrNull3.getRevision()) : null, options.getMode(), ((PaywallState.Loaded.Components) paywallState2).getLocale().toString(), Boolean.valueOf(zIsSystemInDarkTheme)};
                                    composer2.startReplaceGroup(-1503525475);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):InternalPaywall.kt#9igjgp");
                                    boolean zChanged2 = composer2.changed(paywallViewModel2);
                                    PaywallViewModel paywallViewModel3 = paywallViewModel2;
                                    InternalPaywallKt$InternalPaywall$6$1$1 internalPaywallKt$InternalPaywall$6$1$1RememberedValue = composer2.rememberedValue();
                                    if (zChanged2 || internalPaywallKt$InternalPaywall$6$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                        internalPaywallKt$InternalPaywall$6$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$6$1$1(paywallViewModel3, null);
                                        composer2.updateRememberedValue(internalPaywallKt$InternalPaywall$6$1$1RememberedValue);
                                    }
                                    composer2.endReplaceGroup();
                                    EffectsKt.LaunchedEffect(objArr, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) internalPaywallKt$InternalPaywall$6$1$1RememberedValue, composer2, 0);
                                }
                                composer2.endReplaceGroup();
                                boolean automaticallyScaleFontSize = (paywallComponents == null || (dataOrNull = paywallComponents.getDataOrNull()) == null) ? true : dataOrNull.getAutomaticallyScaleFontSize();
                                final PaywallViewModel paywallViewModel4 = paywallViewModel2;
                                final PaywallComponentInteractionTracker paywallComponentInteractionTracker22 = paywallComponentInteractionTracker2;
                                final PaywallState paywallState4 = paywallState2;
                                InternalPaywallKt.PaywallFontScaling(automaticallyScaleFontSize, ComposableLambdaKt.rememberComposableLambda(781998052, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.6.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i9) {
                                        ComposerKt.sourceInformation(composer3, "C205@8982L865,205@8951L896:InternalPaywall.kt#ao8ymz");
                                        if ((i9 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(781998052, i9, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:205)");
                                            }
                                            PaywallViewModel paywallViewModel5 = paywallViewModel4;
                                            final PaywallViewModel paywallViewModel6 = paywallViewModel4;
                                            final PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker22;
                                            final PaywallState paywallState5 = paywallState4;
                                            InternalPaywallKt.NotifyingUriHandler(paywallViewModel5, ComposableLambdaKt.rememberComposableLambda(-414156817, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.6.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i10) {
                                                    ComposerKt.sourceInformation(composer4, "C:InternalPaywall.kt#ao8ymz");
                                                    if ((i10 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-414156817, i10, -1, "com.revenuecat.purchases.ui.revenuecatui.InternalPaywall.<anonymous>.<anonymous>.<anonymous> (InternalPaywall.kt:206)");
                                                        }
                                                        WorkflowPaywallUiState value2 = paywallViewModel6.getWorkflowState().getValue();
                                                        if (value2 != null) {
                                                            composer4.startReplaceGroup(-154107873);
                                                            ComposerKt.sourceInformation(composer4, "210@9260L31,211@9336L39,208@9127L362");
                                                            PaywallViewModel paywallViewModel7 = paywallViewModel6;
                                                            composer4.startReplaceGroup(826317480);
                                                            ComposerKt.sourceInformation(composer4, "CC(remember):InternalPaywall.kt#9igjgp");
                                                            boolean zChanged3 = composer4.changed(paywallViewModel7);
                                                            InternalPaywallKt$InternalPaywall$6$2$1$1$1 internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue = composer4.rememberedValue();
                                                            if (zChanged3 || internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue = new InternalPaywallKt$InternalPaywall$6$2$1$1$1(paywallViewModel7);
                                                                composer4.updateRememberedValue(internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue);
                                                            }
                                                            composer4.endReplaceGroup();
                                                            LoadedWorkflowPaywallKt.LoadedWorkflowPaywall(value2, (Function1) ((KFunction) internalPaywallKt$InternalPaywall$6$2$1$1$1RememberedValue), InternalPaywallKt.rememberPaywallActionHandler(paywallViewModel6, composer4, 0), paywallComponentInteractionTracker3, null, null, composer4, 0, 48);
                                                            composer4.endReplaceGroup();
                                                        } else {
                                                            composer4.startReplaceGroup(-153698239);
                                                            ComposerKt.sourceInformation(composer4, "217@9654L39,215@9543L264");
                                                            LoadedPaywallComponentsKt.LoadedPaywallComponents((PaywallState.Loaded.Components) paywallState5, InternalPaywallKt.rememberPaywallActionHandler(paywallViewModel6, composer4, 0), null, paywallComponentInteractionTracker3, composer4, 0, 4);
                                                            composer4.endReplaceGroup();
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }, composer3, 54), composer3, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54), composer2, 48);
                            } else {
                                Logger.INSTANCE.m1584e("State is not loaded while transitioning animation. This may happen if state changes from being loaded to a different state. This should not happen.");
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProfileVerifier.CompilationStatus.f379xf2722a21, 18);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (!(paywallState2 instanceof PaywallState.Loading)) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.InternalPaywall.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i8) {
                    InternalPaywallKt.InternalPaywall(options, paywallViewModel2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InternalPaywall$lambda$5$lambda$4(PaywallViewModel paywallViewModel, PaywallComponentInteractionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        paywallViewModel.trackComponentInteraction(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void LoadedPaywall(final PaywallState.Loaded.Legacy legacy, final PaywallViewModel paywallViewModel, final boolean z, Composer composer, final int i) {
        int i2;
        Integer numValueOf;
        PaywallComponentsData dataOrNull;
        int revision;
        PaywallData paywall;
        String id;
        PaywallComponentsData dataOrNull2;
        boolean z2;
        InternalPaywallKt$LoadedPaywall$1$1 internalPaywallKt$LoadedPaywall$1$1RememberedValue;
        final PaywallState.Loaded.Legacy legacy2;
        Composer composer2;
        final boolean z3 = z;
        Composer composerStartRestartGroup = composer.startRestartGroup(296169652);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadedPaywall)P(1,2)267@11262L7,279@11770L58,272@11576L252,282@11860L7,328@14085L18,329@14119L969:InternalPaywall.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(legacy) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(296169652, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.LoadedPaywall (InternalPaywall.kt:266)");
            }
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String languageTags = ((Configuration) objConsume).getLocales().toLanguageTags();
            Intrinsics.checkNotNullExpressionValue(languageTags, "configuration.locales.toLanguageTags()");
            Offering offering = legacy.getOffering();
            PaywallData paywall2 = offering.getPaywall();
            if (paywall2 != null) {
                revision = paywall2.getRevision();
            } else {
                Offering.PaywallComponents paywallComponents = offering.getPaywallComponents();
                if (paywallComponents == null || (dataOrNull = paywallComponents.getDataOrNull()) == null) {
                    numValueOf = null;
                    paywall = offering.getPaywall();
                    if (paywall != null || (id = paywall.getId()) == null) {
                        Offering.PaywallComponents paywallComponents2 = offering.getPaywallComponents();
                        id = (paywallComponents2 != null || (dataOrNull2 = paywallComponents2.getDataOrNull()) == null) ? null : dataOrNull2.getId();
                    }
                    Object[] objArr = {offering.getIdentifier(), id, numValueOf, legacy.getTemplateConfiguration().getMode(), languageTags, Boolean.valueOf(z3)};
                    composerStartRestartGroup.startReplaceGroup(-492336770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                    int i3 = i2 & 112;
                    z2 = i3 != 32;
                    internalPaywallKt$LoadedPaywall$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2 || internalPaywallKt$LoadedPaywall$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        internalPaywallKt$LoadedPaywall$1$1RememberedValue = new InternalPaywallKt$LoadedPaywall$1$1(paywallViewModel, null);
                        composerStartRestartGroup.updateRememberedValue(internalPaywallKt$LoadedPaywall$1$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    EffectsKt.LaunchedEffect(objArr, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) internalPaywallKt$LoadedPaywall$1$1RememberedValue, composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Activity activity = ContextExtensionsKt.getActivity((Context) objConsume2);
                    composerStartRestartGroup.startReplaceGroup(-492330105);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "286@11999L11,287@12067L11,288@12097L1911");
                    if (legacy.getValidationWarning() == null) {
                        long background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getBackground();
                        int i4 = i2;
                        long onSurface = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface();
                        Modifier modifierM13853screenModeBackgroundmxwnekA = m13853screenModeBackgroundmxwnekA(Modifier.INSTANCE, PaywallStateKt.isInFullScreenMode(legacy), background);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM13853screenModeBackgroundmxwnekA);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 193363187, "C295@12462L24,296@12517L745,309@13292L411,291@12225L1493,322@13960L23,318@13731L267:InternalPaywall.kt#ao8ymz");
                        List<TemplateConfiguration.PackageInfo> all = legacy.getTemplateConfiguration().getPackages().getAll();
                        TemplateConfiguration.PackageInfo value = legacy.getSelectedPackage().getValue();
                        PaywallWarning validationWarning = legacy.getValidationWarning();
                        composerStartRestartGroup.startReplaceGroup(2084453339);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                        boolean z4 = i3 == 32;
                        InternalPaywallKt$LoadedPaywall$2$1$1 internalPaywallKt$LoadedPaywall$2$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z4 || internalPaywallKt$LoadedPaywall$2$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            internalPaywallKt$LoadedPaywall$2$1$1RememberedValue = new InternalPaywallKt$LoadedPaywall$2$1$1(paywallViewModel);
                            composerStartRestartGroup.updateRememberedValue(internalPaywallKt$LoadedPaywall$2$1$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        Function1 function1 = (Function1) ((KFunction) internalPaywallKt$LoadedPaywall$2$1$1RememberedValue);
                        composerStartRestartGroup.startReplaceGroup(2084455820);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                        boolean zChangedInstance = ((i4 & 14) == 4) | (i3 == 32) | composerStartRestartGroup.changedInstance(activity);
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$LoadedPaywall$2$2$1
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
                                    Package rcPackage = legacy.getSelectedPackage().getValue().getRcPackage();
                                    paywallViewModel.trackComponentInteraction(PaywallComponentInteractionFactoriesKt.paywallPurchaseButtonAction(PaywallLegacyComponentInteraction.PURCHASE_BUTTON_NAME, PaywallLegacyComponentInteraction.Value.IN_APP_CHECKOUT, null, rcPackage.getIdentifier(), PaywallProductIdentifierKt.paywallProductIdentifier(rcPackage.getProduct())));
                                    paywallViewModel.purchaseSelectedPackage(activity);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function0 = (Function0) objRememberedValue;
                        composerStartRestartGroup.endReplaceGroup();
                        composerStartRestartGroup.startReplaceGroup(2084480286);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                        boolean z5 = i3 == 32;
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$LoadedPaywall$2$3$1
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
                                    PaywallViewModel.trackComponentInteraction$default(paywallViewModel, PaywallComponentType.BUTTON, PaywallLegacyComponentInteraction.RESTORE_BUTTON_NAME, PaywallLegacyComponentInteraction.Value.RESTORE_PURCHASES, null, 8, null);
                                    paywallViewModel.restorePurchases();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        DefaultPaywallViewKt.DefaultPaywallView(all, value, validationWarning, function1, function0, (Function0) objRememberedValue2, null, null, composerStartRestartGroup, 0, PsExtractor.AUDIO_STREAM);
                        boolean shouldDisplayDismissButton = legacy.getShouldDisplayDismissButton();
                        Color colorM8138boximpl = Color.m8138boximpl(onSurface);
                        boolean zBooleanValue = paywallViewModel.getActionInProgress().getValue().booleanValue();
                        composerStartRestartGroup.startReplaceGroup(2084501274);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                        boolean z6 = i3 == 32;
                        InternalPaywallKt$LoadedPaywall$2$4$1 internalPaywallKt$LoadedPaywall$2$4$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z6 || internalPaywallKt$LoadedPaywall$2$4$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            internalPaywallKt$LoadedPaywall$2$4$1RememberedValue = new InternalPaywallKt$LoadedPaywall$2$4$1(paywallViewModel);
                            composerStartRestartGroup.updateRememberedValue(internalPaywallKt$LoadedPaywall$2$4$1RememberedValue);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        CloseButtonKt.m14042CloseButtondrOMvmE(boxScopeInstance, shouldDisplayDismissButton, colorM8138boximpl, zBooleanValue, (Function0) internalPaywallKt$LoadedPaywall$2$4$1RememberedValue, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.LoadedPaywall.3
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
                                    InternalPaywallKt.LoadedPaywall(legacy, paywallViewModel, z, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                                }
                            });
                            return;
                        }
                        return;
                    }
                    int i5 = i2;
                    legacy2 = legacy;
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                    Modifier modifierM13853screenModeBackgroundmxwnekA2 = m13853screenModeBackgroundmxwnekA(Modifier.INSTANCE, PaywallStateKt.isInFullScreenMode(legacy2), legacy2.getTemplateConfiguration().getCurrentColors(composer2, 0).m14201getBackground0d7_KjU());
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM13853screenModeBackgroundmxwnekA2);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer2);
                    Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM7248constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM7248constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM7248constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 195326479, "C332@14259L35,333@14325L123,339@14569L39,342@14734L77,337@14458L353,347@14934L13,349@15048L23,345@14820L262:InternalPaywall.kt#ao8ymz");
                    int i6 = i5 & 14;
                    Configuration configurationConfigurationWithOverriddenLocale = configurationWithOverriddenLocale(legacy2, composer2, i6);
                    Locale locale = legacy2.getTemplateConfiguration().getLocale();
                    composer2.startReplaceGroup(2084513054);
                    ComposerKt.sourceInformation(composer2, "CC(remember):InternalPaywall.kt#9igjgp");
                    boolean zChanged = composer2.changed(locale);
                    Object objRememberedValue3 = composer2.rememberedValue();
                    if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = LocaleHelpersKt.toLayoutDirection(legacy2.getTemplateConfiguration().getLocale());
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    composer2.endReplaceGroup();
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{HelperFunctionsKt.getLocalActivity().provides(activity), AndroidCompositionLocals_androidKt.getLocalContext().provides(contextWithConfiguration(legacy2, configurationConfigurationWithOverriddenLocale, composer2, i6)), AndroidCompositionLocals_androidKt.getLocalConfiguration().provides(configurationConfigurationWithOverriddenLocale), CompositionLocalsKt.getLocalLayoutDirection().provides((LayoutDirection) objRememberedValue3)}, ComposableLambdaKt.rememberComposableLambda(-697868038, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$LoadedPaywall$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i7) {
                            ComposerKt.sourceInformation(composer3, "C343@14748L53:InternalPaywall.kt#ao8ymz");
                            if ((i7 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-697868038, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.LoadedPaywall.<anonymous>.<anonymous> (InternalPaywall.kt:343)");
                            }
                            InternalPaywallKt.TemplatePaywall(legacy2, paywallViewModel, composer3, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, ProvidedValue.$stable | 48);
                    boolean shouldDisplayDismissButton2 = legacy2.getShouldDisplayDismissButton();
                    Color colorM14205getCloseButtonQN2ZGVo = PaywallStateKt.getCurrentColors(legacy2, composer2, i6).m14205getCloseButtonQN2ZGVo();
                    boolean zBooleanValue2 = paywallViewModel.getActionInProgress().getValue().booleanValue();
                    composer2.startReplaceGroup(2084536090);
                    ComposerKt.sourceInformation(composer2, "CC(remember):InternalPaywall.kt#9igjgp");
                    boolean z7 = i3 == 32;
                    InternalPaywallKt$LoadedPaywall$4$2$1 internalPaywallKt$LoadedPaywall$4$2$1RememberedValue = composer2.rememberedValue();
                    if (z7 || internalPaywallKt$LoadedPaywall$4$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        internalPaywallKt$LoadedPaywall$4$2$1RememberedValue = new InternalPaywallKt$LoadedPaywall$4$2$1(paywallViewModel);
                        composer2.updateRememberedValue(internalPaywallKt$LoadedPaywall$4$2$1RememberedValue);
                    }
                    composer2.endReplaceGroup();
                    z3 = z3;
                    CloseButtonKt.m14042CloseButtondrOMvmE(boxScopeInstance2, shouldDisplayDismissButton2, colorM14205getCloseButtonQN2ZGVo, zBooleanValue2, (Function0) internalPaywallKt$LoadedPaywall$4$2$1RememberedValue, composer2, 6);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    revision = dataOrNull.getRevision();
                }
            }
            numValueOf = Integer.valueOf(revision);
            paywall = offering.getPaywall();
            if (paywall != null) {
                Offering.PaywallComponents paywallComponents22 = offering.getPaywallComponents();
                if (paywallComponents22 != null) {
                    Object[] objArr2 = {offering.getIdentifier(), id, numValueOf, legacy.getTemplateConfiguration().getMode(), languageTags, Boolean.valueOf(z3)};
                    composerStartRestartGroup.startReplaceGroup(-492336770);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):InternalPaywall.kt#9igjgp");
                    int i32 = i2 & 112;
                    if (i32 != 32) {
                    }
                    internalPaywallKt$LoadedPaywall$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        internalPaywallKt$LoadedPaywall$1$1RememberedValue = new InternalPaywallKt$LoadedPaywall$1$1(paywallViewModel, null);
                        composerStartRestartGroup.updateRememberedValue(internalPaywallKt$LoadedPaywall$1$1RememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(objArr2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) internalPaywallKt$LoadedPaywall$1$1RememberedValue, composerStartRestartGroup, 0);
                        ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume22 = composerStartRestartGroup.consume(localContext2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Activity activity2 = ContextExtensionsKt.getActivity((Context) objConsume22);
                        composerStartRestartGroup.startReplaceGroup(-492330105);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "286@11999L11,287@12067L11,288@12097L1911");
                        if (legacy.getValidationWarning() == null) {
                        }
                    }
                }
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            legacy2 = legacy;
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.LoadedPaywall.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i7) {
                    InternalPaywallKt.LoadedPaywall(legacy2, paywallViewModel, z3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TemplatePaywall(PaywallState.Loaded.Legacy legacy, PaywallViewModel paywallViewModel, Composer composer, final int i) {
        int i2;
        final PaywallState.Loaded.Legacy legacy2;
        final PaywallViewModel paywallViewModel2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1883481085);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TemplatePaywall):InternalPaywall.kt#ao8ymz");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(legacy) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(paywallViewModel) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1883481085, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.TemplatePaywall (InternalPaywall.kt:355)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[legacy.getTemplateConfiguration().getTemplate().ordinal()]) {
                case 1:
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    composerStartRestartGroup.startReplaceGroup(-820277666);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "357@15286L47");
                    Template1Kt.Template1(legacy2, paywallViewModel2, composerStartRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 2:
                    composerStartRestartGroup.startReplaceGroup(-820274914);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "358@15372L47");
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    Template2Kt.Template2(legacy2, paywallViewModel2, null, composerStartRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT, 4);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
                case 3:
                    composerStartRestartGroup.startReplaceGroup(-820272162);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "359@15458L47");
                    Template3Kt.Template3(legacy, paywallViewModel, composerStartRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
                    composerStartRestartGroup.endReplaceGroup();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                case 4:
                    composerStartRestartGroup.startReplaceGroup(-820269410);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "360@15544L47");
                    Template4Kt.Template4(legacy, paywallViewModel, composerStartRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
                    composerStartRestartGroup.endReplaceGroup();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                case 5:
                    composerStartRestartGroup.startReplaceGroup(-820266658);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "361@15630L47");
                    Template5Kt.Template5(legacy, paywallViewModel, composerStartRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
                    composerStartRestartGroup.endReplaceGroup();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                case 6:
                    composerStartRestartGroup.startReplaceGroup(-820263906);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "362@15716L47");
                    Template7Kt.Template7(legacy, paywallViewModel, composerStartRestartGroup, i2 & WebSocketProtocol.PAYLOAD_SHORT);
                    composerStartRestartGroup.endReplaceGroup();
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    break;
                default:
                    legacy2 = legacy;
                    paywallViewModel2 = paywallViewModel;
                    composerStartRestartGroup.startReplaceGroup(341673811);
                    composerStartRestartGroup.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            legacy2 = legacy;
            paywallViewModel2 = paywallViewModel;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt.TemplatePaywall.1
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
                    InternalPaywallKt.TemplatePaywall(legacy2, paywallViewModel2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final PaywallViewModel getPaywallViewModel(PaywallOptions options, Function1<? super CustomerInfo, Boolean> function1, Composer composer, int i, int i2) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(options, "options");
        composer.startReplaceGroup(-1725540891);
        ComposerKt.sourceInformation(composer, "C(getPaywallViewModel)372@15981L7,378@16249L11,379@16274L21,381@16372L17,373@16028L379:InternalPaywall.kt#ao8ymz");
        Function1<? super CustomerInfo, Boolean> function12 = (i2 & 2) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1725540891, i, -1, "com.revenuecat.purchases.ui.revenuecatui.getPaywallViewModel (InternalPaywall.kt:371)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context applicationContext = ((Context) objConsume).getApplicationContext();
        String strValueOf = String.valueOf(options.hashCode());
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        PaywallViewModelFactory paywallViewModelFactory = new PaywallViewModelFactory(PaywallResourceProviderKt.toResourceProvider(applicationContext), options, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable), DarkThemeKt.isSystemInDarkTheme(composer, 0), function12, HelperFunctionsKt.isInPreviewMode(composer, 0));
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, 6);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) Reflection.getOrCreateKotlinClass(PaywallViewModelImpl.class), current, strValueOf, paywallViewModelFactory, defaultViewModelCreationExtras, composer, 0, 0);
        composer.endReplaceableGroup();
        PaywallViewModelImpl paywallViewModelImpl = (PaywallViewModelImpl) viewModel;
        paywallViewModelImpl.updateOptions(options);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return paywallViewModelImpl;
    }

    private static final Context contextWithConfiguration(PaywallState.Loaded.Legacy legacy, Configuration configuration, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2083869389, "C(contextWithConfiguration)391@16637L7:InternalPaywall.kt#ao8ymz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2083869389, i, -1, "com.revenuecat.purchases.ui.revenuecatui.contextWithConfiguration (InternalPaywall.kt:390)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        if (contextCreateConfigurationContext != null) {
            context = contextCreateConfigurationContext;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return context;
    }

    private static final Configuration configurationWithOverriddenLocale(PaywallState.Loaded.Legacy legacy, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 761546839, "C(configurationWithOverriddenLocale)400@16974L7:InternalPaywall.kt#ao8ymz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(761546839, i, -1, "com.revenuecat.purchases.ui.revenuecatui.configurationWithOverriddenLocale (InternalPaywall.kt:399)");
        }
        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Configuration configuration = new Configuration((Configuration) objConsume);
        configuration.setLocale(legacy.getTemplateConfiguration().getLocale());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return configuration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<PaywallAction.External, Continuation<? super Unit>, Object> rememberPaywallActionHandler(PaywallViewModel paywallViewModel, Composer composer, int i) {
        composer.startReplaceGroup(-1933557776);
        ComposerKt.sourceInformation(composer, "C(rememberPaywallActionHandler)408@17236L7,410@17307L1839:InternalPaywall.kt#ao8ymz");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1933557776, i, -1, "com.revenuecat.purchases.ui.revenuecatui.rememberPaywallActionHandler (InternalPaywall.kt:407)");
        }
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Context context = (Context) objConsume;
        Activity activity = ContextExtensionsKt.getActivity(context);
        composer.startReplaceGroup(-1196998585);
        ComposerKt.sourceInformation(composer, "CC(remember):InternalPaywall.kt#9igjgp");
        boolean z = (((i & 14) ^ 6) > 4 && composer.changed(paywallViewModel)) || (i & 6) == 4;
        InternalPaywallKt$rememberPaywallActionHandler$1$1 internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue = composer.rememberedValue();
        if (z || internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue = new InternalPaywallKt$rememberPaywallActionHandler$1$1(paywallViewModel, activity, context, null);
            composer.updateRememberedValue(internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue);
        }
        Function2<PaywallAction.External, Continuation<? super Unit>, Object> function2 = (Function2) internalPaywallKt$rememberPaywallActionHandler$1$1RememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleLaunchWebCheckout(Context context, PaywallViewModel paywallViewModel, PaywallAction.External.LaunchWebCheckout launchWebCheckout) {
        String webCheckoutUrl = paywallViewModel.getWebCheckoutUrl(launchWebCheckout);
        if (webCheckoutUrl == null) {
            Logger.INSTANCE.m1584e("Web checkout URL cannot be found, not launching web checkout.");
            return;
        }
        paywallViewModel.invalidateCustomerInfoCache();
        if (handleUrlDestination(context, webCheckoutUrl, launchWebCheckout.getOpenMethod())) {
            paywallViewModel.notifyWebCheckoutOpened();
        }
        if (launchWebCheckout.getAutoDismiss()) {
            Logger.INSTANCE.m1583d("Auto-dismissing paywall after launching web checkout.");
            PaywallViewModel.closePaywall$default(paywallViewModel, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean handleUrlDestination(Context context, String str, ButtonComponent.UrlMethod urlMethod) {
        URLOpeningMethod uRLOpeningMethod;
        int i = WhenMappings.$EnumSwitchMapping$1[urlMethod.ordinal()];
        if (i == 1) {
            uRLOpeningMethod = URLOpeningMethod.IN_APP_BROWSER;
        } else if (i == 2) {
            uRLOpeningMethod = URLOpeningMethod.EXTERNAL_BROWSER;
        } else {
            if (i != 3) {
                if (i == 4) {
                    Logger.INSTANCE.m1584e("Ignoring button click with unknown open method for URL: '" + str + "'. This is a bug in the SDK.");
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
            uRLOpeningMethod = URLOpeningMethod.DEEP_LINK;
        }
        return URLOpener.INSTANCE.openURL$revenuecatui_defaultsRelease(context, str, uRLOpeningMethod);
    }

    /* JADX INFO: renamed from: screenModeBackground-mxwnekA, reason: not valid java name */
    private static final Modifier m13853screenModeBackgroundmxwnekA(Modifier modifier, boolean z, final long j) {
        return ModifierExtensionsKt.conditional(ModifierExtensionsKt.conditional(modifier, z, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$screenModeBackground$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Modifier invoke(Modifier conditional) {
                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                return BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), j, null, 2, null);
            }
        }), !z, new Function1<Modifier, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.InternalPaywallKt$screenModeBackground$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Modifier invoke(Modifier conditional) {
                Intrinsics.checkNotNullParameter(conditional, "$this$conditional");
                return BackgroundKt.m2016backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m3237RoundedCornerShapea9UjIt4$default(UIConstant.INSTANCE.m13858getDefaultCornerRadiusD9Ej5fM(), UIConstant.INSTANCE.m13858getDefaultCornerRadiusD9Ej5fM(), 0.0f, 0.0f, 12, null)), j, null, 2, null);
            }
        });
    }
}
