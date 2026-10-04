package com.revenuecat.purchases.p036ui.revenuecatui.components.button;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.ConstraintsKt;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
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
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.TsExtractor;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.TransitionViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.button.ButtonComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BackgroundStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.BorderStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ShadowStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.stack.StackComponentStateKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallProductIdentifierKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.WebCheckoutUrlResolverKt;
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
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ButtonComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aU\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u001b\u001a\r\u0010\u001c\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u001b\u001a\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a!\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0002\u0010$\u001a\u0017\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010'H\u0003¢\u0006\u0002\u0010(\u001a\u0015\u0010%\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010+\u001a\u000e\u0010,\u001a\u0004\u0018\u00010-*\u00020\u0012H\u0002\u001a<\u0010.\u001a\u00020/*\u0002002\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020/2\u0006\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u00067²\u0006\n\u00108\u001a\u000209X\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010;\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010=\u001a\u00020\u0001X\u008a\u0084\u0002"}, m1599d2 = {"ALPHA_DISABLED", "", "BRIGHTNESS_CUTOFF", "COEFFICIENT_LUMINANCE_BLUE", "COEFFICIENT_LUMINANCE_GREEN", "COEFFICIENT_LUMINANCE_RED", "brightness", "Landroidx/compose/ui/graphics/Color;", "getBrightness-8_81llA", "(J)F", "ButtonComponentView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "onClick", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "ButtonComponentView_Preview_Default", "(Landroidx/compose/runtime/Composer;I)V", "ButtonComponentView_Preview_Narrow", "packageForPurchaseButtonInteraction", "Lcom/revenuecat/purchases/Package;", "action", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;", "previewButtonComponentStyle", "stackComponentStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/StackComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action;Landroidx/compose/runtime/Composer;II)Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle;", "progressColorFor", "backgroundStyles", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/BackgroundStyles;Landroidx/compose/runtime/Composer;I)J", "colorStyle", "Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/properties/ColorStyle;)J", "navigationUrlForComponentInteraction", "", "progressSize", "", "Landroidx/compose/ui/unit/Density;", "stackWidthPx", "stackHeightPx", "stackMarginStartPx", "stackMarginEndPx", "stackMarginTopPx", "stackMarginBottomPx", "revenuecatui_defaultsRelease", "myActionInProgress", "", "contentAlpha", "progressAlpha", "animatedContentAlpha", "animatedProgressAlpha"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class ButtonComponentViewKt {
    private static final float ALPHA_DISABLED = 0.6f;
    private static final float BRIGHTNESS_CUTOFF = 0.6f;
    private static final float COEFFICIENT_LUMINANCE_BLUE = 0.114f;
    private static final float COEFFICIENT_LUMINANCE_GREEN = 0.587f;
    private static final float COEFFICIENT_LUMINANCE_RED = 0.299f;

    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ButtonComponentView(final ButtonComponentStyle style, final PaywallState.Loaded.Components state, final Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> onClick, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-743701222);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonComponentView)P(4,3,2,1)84@4652L114,92@4870L8301,92@4824L8347:ButtonComponentView.kt#5w7xmn");
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
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
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
                Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    paywallComponentInteractionTracker3 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$$ExternalSyntheticLambda0
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                        }
                    };
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-743701222, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView (ButtonComponentView.kt:83)");
                }
                if (StackComponentStateKt.rememberUpdatedStackComponentState(style.getStackComponentStyle(), state, composerStartRestartGroup, i3 & 112).getVisible()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup2 != null) {
                        final PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker3;
                        final Modifier modifier4 = companion;
                        scopeUpdateScopeEndRestartGroup2.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView.2
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

                            public final void invoke(Composer composer2, int i6) {
                                ButtonComponentViewKt.ButtonComponentView(style, state, onClick, modifier4, paywallComponentInteractionTracker4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                PaywallComponentInteractionTracker paywallComponentInteractionTracker5 = paywallComponentInteractionTracker3;
                Modifier modifier5 = companion;
                TransitionViewKt.TransitionView(style.getTransition(), ComposableLambdaKt.rememberComposableLambda(-2001426318, true, new C75803(style, state, modifier5, paywallComponentInteractionTracker5, onClick), composerStartRestartGroup, 54), composerStartRestartGroup, 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker5;
                modifier3 = modifier5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker3;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView.4
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

                    public final void invoke(Composer composer2, int i6) {
                        ButtonComponentViewKt.ButtonComponentView(style, state, onClick, modifier3, paywallComponentInteractionTracker2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            if (i5 == 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (StackComponentStateKt.rememberUpdatedStackComponentState(style.getStackComponentStyle(), state, composerStartRestartGroup, i3 & 112).getVisible()) {
            }
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$3 */
    /* JADX INFO: compiled from: ButtonComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, m1599d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    static final class C75803 extends Lambda implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ PaywallComponentInteractionTracker $componentInteractionTracker;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function2<PaywallAction, Continuation<? super Unit>, Object> $onClick;
        final /* synthetic */ PaywallState.Loaded.Components $state;
        final /* synthetic */ ButtonComponentStyle $style;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C75803(ButtonComponentStyle buttonComponentStyle, PaywallState.Loaded.Components components, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2) {
            super(2);
            this.$style = buttonComponentStyle;
            this.$state = components;
            this.$modifier = modifier;
            this.$componentInteractionTracker = paywallComponentInteractionTracker;
            this.$onClick = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ButtonComponentStyle buttonComponentStyle;
            ComposerKt.sourceInformation(composer, "C94@4991L100,99@5122L24,103@5370L34,104@5433L131,107@5594L66,108@5697L47,109@5782L48,111@5883L7,112@5915L121,115@6064L124,118@6215L155,121@6395L153,201@11214L1940,129@7017L6148:ButtonComponentView.kt#5w7xmn");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2001426318, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView.<anonymous> (ButtonComponentView.kt:94)");
            }
            final ButtonComponentState buttonComponentStateRememberButtonComponentState = ButtonComponentStateKt.rememberButtonComponentState(this.$style, this.$state, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)482@20332L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, -954367824, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composer);
            final PaywallState.Loaded.Components components = this.$state;
            composer.startReplaceGroup(-1790156860);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-1790154747);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$3$contentAlpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        float f;
                        if (ButtonComponentViewKt.C75803.invoke$lambda$2(mutableState)) {
                            f = 0.0f;
                        } else {
                            f = components.getActionInProgress() ? 0.6f : 1.0f;
                        }
                        return Float.valueOf(f);
                    }
                });
                composer.updateRememberedValue(objRememberedValue3);
            }
            State state = (State) objRememberedValue3;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-1790149660);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$3$progressAlpha$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(ButtonComponentViewKt.C75803.invoke$lambda$2(mutableState) ? 1.0f : 0.0f);
                    }
                });
                composer.updateRememberedValue(objRememberedValue4);
            }
            composer.endReplaceGroup();
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(invoke$lambda$5(state), null, 0.0f, null, null, composer, 0, 30);
            State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(invoke$lambda$7((State) objRememberedValue4), null, 0.0f, null, null, composer, 0, 30);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            Object margin = this.$style.getStackComponentStyle().getMargin();
            composer.startReplaceGroup(-1790139333);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged = composer.changed(margin);
            ButtonComponentStyle buttonComponentStyle2 = this.$style;
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = C1486Dp.m11015boximpl(buttonComponentStyle2.getStackComponentStyle().getMargin().getTop());
                composer.updateRememberedValue(objRememberedValue5);
            }
            final float fM11031unboximpl = ((C1486Dp) objRememberedValue5).m11031unboximpl();
            composer.endReplaceGroup();
            Object margin2 = this.$style.getStackComponentStyle().getMargin();
            composer.startReplaceGroup(-1790134562);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged2 = composer.changed(margin2);
            ButtonComponentStyle buttonComponentStyle3 = this.$style;
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = C1486Dp.m11015boximpl(buttonComponentStyle3.getStackComponentStyle().getMargin().getBottom());
                composer.updateRememberedValue(objRememberedValue6);
            }
            final float fM11031unboximpl2 = ((C1486Dp) objRememberedValue6).m11031unboximpl();
            composer.endReplaceGroup();
            Object margin3 = this.$style.getStackComponentStyle().getMargin();
            composer.startReplaceGroup(-1790129699);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged3 = composer.changed(margin3) | composer.changed(layoutDirection);
            ButtonComponentStyle buttonComponentStyle4 = this.$style;
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = C1486Dp.m11015boximpl(PaddingKt.calculateStartPadding(buttonComponentStyle4.getStackComponentStyle().getMargin(), layoutDirection));
                composer.updateRememberedValue(objRememberedValue7);
            }
            final float fM11031unboximpl3 = ((C1486Dp) objRememberedValue7).m11031unboximpl();
            composer.endReplaceGroup();
            Object margin4 = this.$style.getStackComponentStyle().getMargin();
            composer.startReplaceGroup(-1790123941);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged4 = composer.changed(margin4) | composer.changed(layoutDirection);
            ButtonComponentStyle buttonComponentStyle5 = this.$style;
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = C1486Dp.m11015boximpl(PaddingKt.calculateEndPadding(buttonComponentStyle5.getStackComponentStyle().getMargin(), layoutDirection));
                composer.updateRememberedValue(objRememberedValue8);
            }
            final float fM11031unboximpl4 = ((C1486Dp) objRememberedValue8).m11031unboximpl();
            composer.endReplaceGroup();
            final ButtonComponentStyle buttonComponentStyle6 = this.$style;
            final PaywallState.Loaded.Components components2 = this.$state;
            final PaywallComponentInteractionTracker paywallComponentInteractionTracker = this.$componentInteractionTracker;
            final Function2<PaywallAction, Continuation<? super Unit>, Object> function2 = this.$onClick;
            Modifier modifier = this.$modifier;
            composer.startReplaceGroup(-1789967946);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged5 = composer.changed(fM11031unboximpl3) | composer.changed(fM11031unboximpl4) | composer.changed(fM11031unboximpl) | composer.changed(fM11031unboximpl2);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = (MeasurePolicy) new MeasurePolicy() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$3$2$1
                    @Override // androidx.compose.p004ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo1747measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
                        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
                        Intrinsics.checkNotNullParameter(measurables, "measurables");
                        final Placeable placeableMo9625measureBRTryo0 = measurables.get(0).mo9625measureBRTryo0(j);
                        final float f = Layout.mo2191toPx0680j_4(fM11031unboximpl3);
                        float f2 = Layout.mo2191toPx0680j_4(fM11031unboximpl4);
                        final float f3 = Layout.mo2191toPx0680j_4(fM11031unboximpl);
                        float f4 = Layout.mo2191toPx0680j_4(fM11031unboximpl2);
                        int iProgressSize = ButtonComponentViewKt.progressSize(Layout, placeableMo9625measureBRTryo0.getWidth(), placeableMo9625measureBRTryo0.getHeight(), f, f2, f3, f4);
                        final Placeable placeableMo9625measureBRTryo02 = measurables.get(1).mo9625measureBRTryo0(ConstraintsKt.Constraints(iProgressSize, iProgressSize, iProgressSize, iProgressSize));
                        int width = placeableMo9625measureBRTryo0.getWidth();
                        int height = placeableMo9625measureBRTryo0.getHeight();
                        final float f5 = (height - f3) - f4;
                        final float f6 = (width - f) - f2;
                        return MeasureScope.layout$default(Layout, width, height, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$3$2$1.1
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
                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo0, 0, 0, 0.0f, 4, null);
                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo9625measureBRTryo02, ((int) f) + MathKt.roundToInt((f6 / 2.0f) - (r2.getWidth() / 2.0f)), ((int) f3) + MathKt.roundToInt((f5 / 2.0f) - (placeableMo9625measureBRTryo02.getHeight() / 2.0f)), 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue9;
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 790710970, "C139@7529L3374,131@7065L3857,197@11064L54,195@10939L198:ButtonComponentView.kt#5w7xmn");
            StackComponentStyle stackComponentStyle = buttonComponentStyle6.getStackComponentStyle();
            float fInvoke$lambda$8 = invoke$lambda$8(stateAnimateFloatAsState);
            boolean z = !components.getActionInProgress();
            ButtonComponentViewKt$ButtonComponentView$3$1$1 buttonComponentViewKt$ButtonComponentView$3$1$1 = new ButtonComponentViewKt$ButtonComponentView$3$1$1(null);
            composer.startReplaceGroup(-390121041);
            ComposerKt.sourceInformation(composer, "CC(remember):ButtonComponentView.kt#9igjgp");
            boolean zChanged6 = composer.changed(buttonComponentStateRememberButtonComponentState) | composer.changed(components2) | composer.changed(buttonComponentStyle6) | composer.changedInstance(paywallComponentInteractionTracker) | composer.changedInstance(coroutineScope) | composer.changedInstance(function2);
            Object objRememberedValue10 = composer.rememberedValue();
            if (zChanged6 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                buttonComponentStyle = buttonComponentStyle6;
                objRememberedValue10 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$3$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        StoreProduct product;
                        PaywallAction.External.LaunchWebCheckout action = buttonComponentStateRememberButtonComponentState.getAction();
                        if (action == null) {
                            return;
                        }
                        ButtonComponentViewKt.C75803.invoke$lambda$3(mutableState, true);
                        PaywallState.Loaded.Components.update$default(components2, null, null, true, 3, null);
                        if (ButtonComponentInteractionKt.isPurchaseRelated(buttonComponentStyle6.getAction())) {
                            Package packagePackageForPurchaseButtonInteraction = ButtonComponentViewKt.packageForPurchaseButtonInteraction(buttonComponentStyle6.getAction(), components2);
                            String strResolvedWebCheckoutInteractionUrl = WebCheckoutUrlResolverKt.resolvedWebCheckoutInteractionUrl(action, components2);
                            if ((action instanceof PaywallAction.External.LaunchWebCheckout) && strResolvedWebCheckoutInteractionUrl != null) {
                                action = PaywallAction.External.LaunchWebCheckout.copy$default((PaywallAction.External.LaunchWebCheckout) action, null, null, false, null, strResolvedWebCheckoutInteractionUrl, 15, null);
                            }
                            PaywallComponentInteractionTracker paywallComponentInteractionTracker2 = paywallComponentInteractionTracker;
                            String componentName = buttonComponentStyle6.getComponentName();
                            String description = buttonComponentStyle6.getAction().getDescription();
                            String strPaywallProductIdentifier = null;
                            String identifier = packagePackageForPurchaseButtonInteraction != null ? packagePackageForPurchaseButtonInteraction.getIdentifier() : null;
                            if (packagePackageForPurchaseButtonInteraction != null && (product = packagePackageForPurchaseButtonInteraction.getProduct()) != null) {
                                strPaywallProductIdentifier = PaywallProductIdentifierKt.paywallProductIdentifier(product);
                            }
                            paywallComponentInteractionTracker2.track(PaywallComponentInteractionFactoriesKt.paywallPurchaseButtonAction(componentName, description, strResolvedWebCheckoutInteractionUrl, identifier, strPaywallProductIdentifier));
                        } else {
                            ButtonComponentInteraction buttonComponentInteractionComponentInteraction = ButtonComponentInteractionKt.componentInteraction(buttonComponentStyle6.getAction(), ButtonComponentViewKt.navigationUrlForComponentInteraction(action));
                            if (buttonComponentInteractionComponentInteraction != null) {
                                paywallComponentInteractionTracker.track(new PaywallComponentInteractionData(PaywallComponentType.BUTTON, buttonComponentStyle6.getComponentName(), buttonComponentInteractionComponentInteraction.getValue(), buttonComponentInteractionComponentInteraction.getUrl(), (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524272, (DefaultConstructorMarker) null));
                            }
                        }
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C75811(function2, action, components2, mutableState, null), 3, null);
                    }

                    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$3$1$2$1$1 */
                    /* JADX INFO: compiled from: ButtonComponentView.kt */
                    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
                    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView$3$1$2$1$1", m1609f = "ButtonComponentView.kt", m1610i = {}, m1611l = {TsExtractor.TS_PACKET_SIZE}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
                    static final class C75811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ PaywallAction $actionForClick;
                        final /* synthetic */ MutableState<Boolean> $myActionInProgress$delegate;
                        final /* synthetic */ Function2<PaywallAction, Continuation<? super Unit>, Object> $onClick;
                        final /* synthetic */ PaywallState.Loaded.Components $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        C75811(Function2<? super PaywallAction, ? super Continuation<? super Unit>, ? extends Object> function2, PaywallAction paywallAction, PaywallState.Loaded.Components components, MutableState<Boolean> mutableState, Continuation<? super C75811> continuation) {
                            super(2, continuation);
                            this.$onClick = function2;
                            this.$actionForClick = paywallAction;
                            this.$state = components;
                            this.$myActionInProgress$delegate = mutableState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C75811(this.$onClick, this.$actionForClick, this.$state, this.$myActionInProgress$delegate, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C75811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            try {
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    Function2<PaywallAction, Continuation<? super Unit>, Object> function2 = this.$onClick;
                                    PaywallAction paywallAction = this.$actionForClick;
                                    this.label = 1;
                                    if (function2.invoke(paywallAction, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                ButtonComponentViewKt.C75803.invoke$lambda$3(this.$myActionInProgress$delegate, false);
                                PaywallState.Loaded.Components.update$default(this.$state, null, null, Boxing.boxBoolean(false), 3, null);
                                return Unit.INSTANCE;
                            } catch (Throwable th) {
                                ButtonComponentViewKt.C75803.invoke$lambda$3(this.$myActionInProgress$delegate, false);
                                PaywallState.Loaded.Components.update$default(this.$state, null, null, Boxing.boxBoolean(false), 3, null);
                                throw th;
                            }
                        }
                    }
                };
                composer.updateRememberedValue(objRememberedValue10);
            } else {
                buttonComponentStyle = buttonComponentStyle6;
            }
            composer.endReplaceGroup();
            StackComponentViewKt.StackComponentView(stackComponentStyle, components2, buttonComponentViewKt$ButtonComponentView$3$1$1, null, (Function0) objRememberedValue10, z, null, fInvoke$lambda$8, paywallComponentInteractionTracker, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 72);
            ProgressIndicatorKt.m5449CircularProgressIndicatorLxG7B9w(AlphaKt.alpha(Modifier.INSTANCE, invoke$lambda$9(stateAnimateFloatAsState2)), ButtonComponentViewKt.progressColorFor(buttonComponentStyle.getStackComponentStyle().getBackground(), composer, 0), 0.0f, 0L, 0, composer, 0, 28);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invoke$lambda$2(MutableState<Boolean> mutableState) {
            return mutableState.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        private static final float invoke$lambda$5(State<Float> state) {
            return state.getValue().floatValue();
        }

        private static final float invoke$lambda$7(State<Float> state) {
            return state.getValue().floatValue();
        }

        private static final float invoke$lambda$8(State<Float> state) {
            return state.getValue().floatValue();
        }

        private static final float invoke$lambda$9(State<Float> state) {
            return state.getValue().floatValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int progressSize(Density density, int i, int i2, float f, float f2, float f3, float f4) {
        float fM11017constructorimpl;
        float fMo2187toDpu2uoSUM = density.mo2187toDpu2uoSUM(Math.min((i - f) - f2, (i2 - f3) - f4));
        if (C1486Dp.m11016compareTo0680j_4(fMo2187toDpu2uoSUM, C1486Dp.m11017constructorimpl(32)) < 0) {
            if (C1486Dp.m11016compareTo0680j_4(fMo2187toDpu2uoSUM, C1486Dp.m11017constructorimpl(24)) < 0) {
                if (C1486Dp.m11016compareTo0680j_4(fMo2187toDpu2uoSUM, C1486Dp.m11017constructorimpl(16)) < 0) {
                    float f5 = 8;
                    if (C1486Dp.m11016compareTo0680j_4(fMo2187toDpu2uoSUM, C1486Dp.m11017constructorimpl(f5)) >= 0) {
                        fM11017constructorimpl = C1486Dp.m11017constructorimpl(fMo2187toDpu2uoSUM - C1486Dp.m11017constructorimpl(f5));
                    } else {
                        fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                    }
                } else {
                    fM11017constructorimpl = C1486Dp.m11017constructorimpl(8);
                }
            } else {
                fM11017constructorimpl = C1486Dp.m11017constructorimpl(fMo2187toDpu2uoSUM - C1486Dp.m11017constructorimpl(16));
            }
        } else {
            fM11017constructorimpl = C1486Dp.m11017constructorimpl(16);
        }
        return density.mo2185roundToPx0680j_4(C1486Dp.m11017constructorimpl(RangesKt.coerceIn(C1486Dp.m11017constructorimpl(fMo2187toDpu2uoSUM - fM11017constructorimpl), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(38))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long progressColorFor(BackgroundStyles backgroundStyles, Composer composer, int i) {
        long jM8185getWhite0d7_KjU;
        composer.startReplaceGroup(-1216934903);
        ComposerKt.sourceInformation(composer, "C(progressColorFor)276@14253L15:ButtonComponentView.kt#5w7xmn");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216934903, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.progressColorFor (ButtonComponentView.kt:272)");
        }
        composer.startReplaceGroup(-1002992644);
        ComposerKt.sourceInformation(composer, "273@14086L21");
        if (backgroundStyles == null) {
            long jM8185getWhite0d7_KjU2 = DarkThemeKt.isSystemInDarkTheme(composer, 0) ? Color.INSTANCE.m8185getWhite0d7_KjU() : Color.INSTANCE.m8174getBlack0d7_KjU();
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return jM8185getWhite0d7_KjU2;
        }
        composer.endReplaceGroup();
        if (backgroundStyles instanceof BackgroundStyles.Color) {
            jM8185getWhite0d7_KjU = progressColorFor(ColorStyleKt.getForCurrentTheme(((BackgroundStyles.Color) backgroundStyles).m13928unboximpl(), composer, 0));
        } else {
            if (!(backgroundStyles instanceof BackgroundStyles.Image) && !(backgroundStyles instanceof BackgroundStyles.Video)) {
                throw new NoWhenBranchMatchedException();
            }
            jM8185getWhite0d7_KjU = Color.INSTANCE.m8185getWhite0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return jM8185getWhite0d7_KjU;
    }

    private static final long progressColorFor(ColorStyle colorStyle) {
        if (colorStyle instanceof ColorStyle.Solid) {
            return m13874getBrightness8_81llA(((ColorStyle.Solid) colorStyle).m13951unboximpl()) > 0.6f ? Color.INSTANCE.m8174getBlack0d7_KjU() : Color.INSTANCE.m8185getWhite0d7_KjU();
        }
        if (!(colorStyle instanceof ColorStyle.Gradient)) {
            throw new NoWhenBranchMatchedException();
        }
        List colors$revenuecatui_defaultsRelease = ((ColorStyle.Gradient) colorStyle).m13943unboximpl().getColors$revenuecatui_defaultsRelease();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(colors$revenuecatui_defaultsRelease, 10));
        Iterator it = colors$revenuecatui_defaultsRelease.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(m13874getBrightness8_81llA(((Color) it.next()).m8158unboximpl())));
        }
        return CollectionsKt.averageOfFloat(arrayList) > 0.6000000238418579d ? Color.INSTANCE.m8174getBlack0d7_KjU() : Color.INSTANCE.m8185getWhite0d7_KjU();
    }

    /* JADX INFO: renamed from: getBrightness-8_81llA, reason: not valid java name */
    private static final float m13874getBrightness8_81llA(long j) {
        return (Color.m8154getRedimpl(j) * COEFFICIENT_LUMINANCE_RED) + (Color.m8153getGreenimpl(j) * COEFFICIENT_LUMINANCE_GREEN) + (Color.m8151getBlueimpl(j) * COEFFICIENT_LUMINANCE_BLUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String navigationUrlForComponentInteraction(PaywallAction paywallAction) {
        if (paywallAction instanceof PaywallAction.External.NavigateTo) {
            PaywallAction.External.NavigateTo.Destination destination = ((PaywallAction.External.NavigateTo) paywallAction).getDestination();
            if (destination instanceof PaywallAction.External.NavigateTo.Destination.Url) {
                return ((PaywallAction.External.NavigateTo.Destination.Url) destination).getUrl();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Package packageForPurchaseButtonInteraction(ButtonComponentStyle.Action action, PaywallState.Loaded.Components components) {
        Package rcPackage;
        if (action instanceof ButtonComponentStyle.Action.PurchasePackage) {
            rcPackage = ((ButtonComponentStyle.Action.PurchasePackage) action).getRcPackage();
        } else if (action instanceof ButtonComponentStyle.Action.WebCheckout) {
            rcPackage = ((ButtonComponentStyle.Action.WebCheckout) action).getRcPackage();
        } else if (action instanceof ButtonComponentStyle.Action.CustomWebCheckout) {
            rcPackage = ((ButtonComponentStyle.Action.CustomWebCheckout) action).getRcPackage();
        } else {
            boolean z = action instanceof ButtonComponentStyle.Action.WebProductSelection;
            rcPackage = null;
        }
        if (rcPackage != null) {
            return rcPackage;
        }
        PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo = components.getSelectedPackageInfo();
        if (selectedPackageInfo != null) {
            return selectedPackageInfo.getRcPackage();
        }
        return null;
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Default$1 */
    /* JADX INFO: compiled from: ButtonComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Default$1", m1609f = "ButtonComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75841 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C75841(Continuation<? super C75841> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75841(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C75841) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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
    public static final void ButtonComponentView_Preview_Default(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-291258808);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonComponentView_Preview_Default)326@16143L29,326@16174L19,326@16123L76:ButtonComponentView.kt#5w7xmn");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-291258808, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView_Preview_Default (ButtonComponentView.kt:325)");
            }
            ButtonComponentView(previewButtonComponentStyle(null, null, composerStartRestartGroup, 0, 3), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C75841(null), null, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView_Preview_Default.2
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
                    ButtonComponentViewKt.ButtonComponentView_Preview_Default(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ButtonComponentView_Preview_Narrow(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1236087174);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonComponentView_Preview_Narrow)333@16316L386,343@16720L19,332@16279L490:ButtonComponentView.kt#5w7xmn");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1236087174, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentView_Preview_Narrow (ButtonComponentView.kt:331)");
            }
            ButtonComponentView(previewButtonComponentStyle(PreviewHelpersKt.m13867previewStackComponentStyle7SJwSw(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle("Restore purchases", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), (31966 & 2) != 0 ? new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START) : null, (31966 & 4) != 0, (31966 & 8) != 0 ? new Size(new SizeConstraint.Fixed(200, null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (31966 & 16) != 0 ? C1486Dp.m11017constructorimpl(16) : 0.0f, (31966 & 32) != 0 ? BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))) : null, (31966 & 64) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 128) != 0 ? PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(0)) : null, (31966 & 256) != 0 ? new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)) : null, (31966 & 512) != 0 ? new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null) : null, (31966 & 1024) != 0 ? null : null, (31966 & 2048) != 0 ? null : null, (31966 & 4096) != 0 ? null : null, (31966 & 8192) == 0 ? null : null, (31966 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null), null, composerStartRestartGroup, 0, 2), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), new C75861(null), null, null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt.ButtonComponentView_Preview_Narrow.2
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
                    ButtonComponentViewKt.ButtonComponentView_Preview_Narrow(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Narrow$1 */
    /* JADX INFO: compiled from: ButtonComponentView.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, m1599d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;"}, m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.revenuecat.purchases.ui.revenuecatui.components.button.ButtonComponentViewKt$ButtonComponentView_Preview_Narrow$1", m1609f = "ButtonComponentView.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1615s = {})
    static final class C75861 extends SuspendLambda implements Function2<PaywallAction, Continuation<? super Unit>, Object> {
        int label;

        C75861(Continuation<? super C75861> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C75861(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PaywallAction paywallAction, Continuation<? super Unit> continuation) {
            return ((C75861) create(paywallAction, continuation)).invokeSuspend(Unit.INSTANCE);
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

    private static final ButtonComponentStyle previewButtonComponentStyle(StackComponentStyle stackComponentStyle, ButtonComponentStyle.Action action, Composer composer, int i, int i2) {
        StackComponentStyle stackComponentStyle2;
        composer.startReplaceGroup(-1733277159);
        ComposerKt.sourceInformation(composer, "C(previewButtonComponentStyle)P(1):ButtonComponentView.kt#5w7xmn");
        if ((i2 & 1) != 0) {
            float f = 16;
            stackComponentStyle2 = new StackComponentStyle(CollectionsKt.listOf(PreviewHelpersKt.previewTextComponentStyle("Restore purchases", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : null, (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8186getYellow0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(8.0d, 8.0d, 8.0d, 8.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : new Padding(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 24.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 24.0d), (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null)), new Dimension.Vertical(HorizontalAlignment.CENTER, FlexDistribution.START), true, new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), C1486Dp.m11017constructorimpl(f), BackgroundStyles.Color.m13922boximpl(BackgroundStyles.Color.m13923constructorimpl(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8182getRed0d7_KjU())), null, 2, null))), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f)), new Shape.Rectangle(new CornerRadiuses.C7411Dp(20.0d)), new BorderStyles(C1486Dp.m11017constructorimpl(2), new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8175getBlue0d7_KjU())), null, 2, null), null), new ShadowStyles(new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), C1486Dp.m11017constructorimpl(10), C1486Dp.m11017constructorimpl(0), C1486Dp.m11017constructorimpl(3), null), null, null, null, null, null, null, null, CountdownComponent.CountFrom.DAYS, CollectionsKt.emptyList(), false, false, false, false, 15810560, null);
        } else {
            stackComponentStyle2 = stackComponentStyle;
        }
        ButtonComponentStyle.Action action2 = (i2 & 2) != 0 ? ButtonComponentStyle.Action.RestorePurchases.INSTANCE : action;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1733277159, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.button.previewButtonComponentStyle (ButtonComponentView.kt:384)");
        }
        ButtonComponentStyle buttonComponentStyle = new ButtonComponentStyle(stackComponentStyle2, action2, null, null, null, 28, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return buttonComponentStyle;
    }
}
