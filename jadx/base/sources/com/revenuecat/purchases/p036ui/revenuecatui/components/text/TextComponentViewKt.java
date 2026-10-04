package com.revenuecat.purchases.p036ui.revenuecatui.components.text;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.Shape;
import androidx.compose.p004ui.platform.CompositionLocalsKt;
import androidx.compose.p004ui.platform.UriHandler;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.TextUnit;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.p036ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.ktx.LocalizationKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.BackgroundKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.modifier.SizeKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyleKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.ColorStyles;
import com.revenuecat.purchases.p036ui.revenuecatui.components.properties.FontSpec;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.composables.MarkdownKt;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.VariableProcessor;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.VariableProcessorV2;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.ModifierExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.paywalls.components.CountdownComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: TextComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\u0010\n\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a\r\u0010\u0016\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\f\u001a#\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 H\u0003¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u001eX\u008a\u0084\u0002"}, m1599d2 = {"TextComponentView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "modifier", "Landroidx/compose/ui/Modifier;", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/TextComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "TextComponentView_Preview_Customizations", "(Landroidx/compose/runtime/Composer;I)V", "TextComponentView_Preview_Default", "TextComponentView_Preview_FontSize", "TextComponentView_Preview_HeadingXlExtraBold", "TextComponentView_Preview_HorizontalAlignment", "TextComponentView_Preview_LinearGradient", "TextComponentView_Preview_Markdown", "TextComponentView_Preview_MonospaceFont", "TextComponentView_Preview_RadialGradient", "TextComponentView_Preview_SansSerifFont", "TextComponentView_Preview_SerifFont", "discountPercentage", "", "pricePerMonthMicros", "", "mostExpensiveMicros", "(Ljava/lang/Long;Ljava/lang/Long;)Ljava/lang/Double;", "rememberProcessedText", "", "textState", "Lcom/revenuecat/purchases/ui/revenuecatui/components/text/TextComponentState;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lcom/revenuecat/purchases/ui/revenuecatui/components/text/TextComponentState;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "revenuecatui_defaultsRelease", "processedText"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class TextComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0260  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextComponentView(final TextComponentStyle style, final PaywallState.Loaded.Components state, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final TextComponentState textComponentStateRememberUpdatedTextComponentState;
        boolean z;
        final long jM8184getUnspecified0d7_KjU;
        TextStyle textStyleM10464copyNs73l9s$default;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1685119235);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView)P(3,2,1)61@3485L93,67@3637L82,72@3758L15,93@4590L7,94@4631L653,109@5363L716,109@5293L786:TextComponentView.kt#fyu9x8");
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
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= (i & 4096) == 0 ? composerStartRestartGroup.changed(paywallComponentInteractionTracker3) : composerStartRestartGroup.changedInstance(paywallComponentInteractionTracker3) ? 2048 : 1024;
            }
            if ((i3 & 1171) == 1170 || !composerStartRestartGroup.getSkipping()) {
                final Modifier modifier4 = i5 == 0 ? Modifier.INSTANCE : modifier2;
                if (i4 != 0) {
                    paywallComponentInteractionTracker3 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt$$ExternalSyntheticLambda0
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                        }
                    };
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1685119235, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView (TextComponentView.kt:59)");
                }
                textComponentStateRememberUpdatedTextComponentState = TextComponentStateKt.rememberUpdatedTextComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
                final String strRememberProcessedText = rememberProcessedText(state, textComponentStateRememberUpdatedTextComponentState, composerStartRestartGroup, (i3 >> 3) & 14);
                ColorStyle forCurrentTheme = ColorStyleKt.getForCurrentTheme(textComponentStateRememberUpdatedTextComponentState.getColor(), composerStartRestartGroup, 0);
                ColorStyles backgroundColor = textComponentStateRememberUpdatedTextComponentState.getBackgroundColor();
                composerStartRestartGroup.startReplaceGroup(-1877995118);
                ComposerKt.sourceInformation(composerStartRestartGroup, "73@3832L15");
                final ColorStyle forCurrentTheme2 = backgroundColor != null ? null : ColorStyleKt.getForCurrentTheme(backgroundColor, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                z = forCurrentTheme instanceof ColorStyle.Solid;
                if (!z) {
                    jM8184getUnspecified0d7_KjU = ((ColorStyle.Solid) forCurrentTheme).m13951unboximpl();
                } else {
                    if (!(forCurrentTheme instanceof ColorStyle.Gradient)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    jM8184getUnspecified0d7_KjU = Color.INSTANCE.m8184getUnspecified0d7_KjU();
                }
                if (!z) {
                    composerStartRestartGroup.startReplaceGroup(-1877980351);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "83@4284L7");
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyleM10464copyNs73l9s$default = TextStyle.m10466copyp1EtxEg$default((TextStyle) objConsume, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE(), null, null, null, 0, 0, null, 16646143, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (!(forCurrentTheme instanceof ColorStyle.Gradient)) {
                        composerStartRestartGroup.startReplaceGroup(-1878117789);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(1912271483);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "86@4404L7");
                    ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localTextStyle2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    textStyleM10464copyNs73l9s$default = TextStyle.m10464copyNs73l9s$default((TextStyle) objConsume2, ((ColorStyle.Gradient) forCurrentTheme).m13943unboximpl(), 0.0f, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnit.INSTANCE.m11222getUnspecifiedXSAIIZE(), null, null, null, 0, 0, null, 33292286, null);
                    composerStartRestartGroup.endReplaceGroup();
                }
                final TextStyle textStyle = textStyleM10464copyNs73l9s$default;
                if (textComponentStateRememberUpdatedTextComponentState.getVisible()) {
                    ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localUriHandler);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final UriHandler uriHandler = (UriHandler) objConsume3;
                    String componentName = style.getComponentName();
                    composerStartRestartGroup.startReplaceGroup(-1877968912);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):TextComponentView.kt#9igjgp");
                    boolean zChanged = ((i3 & 7168) == 2048 || ((i3 & 4096) != 0 && composerStartRestartGroup.changed(paywallComponentInteractionTracker3))) | composerStartRestartGroup.changed(uriHandler) | composerStartRestartGroup.changed(componentName);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new UriHandler() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt$TextComponentView$trackingUriHandler$1$1
                            @Override // androidx.compose.p004ui.platform.UriHandler
                            public void openUri(String uri) {
                                Intrinsics.checkNotNullParameter(uri, "uri");
                                paywallComponentInteractionTracker3.track(new PaywallComponentInteractionData(PaywallComponentType.TEXT, style.getComponentName(), "navigate_to_url", uri, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524272, (DefaultConstructorMarker) null));
                                uriHandler.openUri(uri);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalUriHandler().provides((TextComponentViewKt$TextComponentView$trackingUriHandler$1$1) objRememberedValue), ComposableLambdaKt.rememberComposableLambda(-88192040, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView.2
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
                            ComposerKt.sourceInformation(composer3, "C110@5377L692:TextComponentView.kt#fyu9x8");
                            if ((i6 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-88192040, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView.<anonymous> (TextComponentView.kt:110)");
                                }
                                MarkdownKt.m14066MarkdownDkhmgE0(strRememberProcessedText, PaddingKt.padding(ModifierExtensionsKt.applyIfNotNull(PaddingKt.padding(SizeKt.size$default(modifier4, textComponentStateRememberUpdatedTextComponentState.getSize(), textComponentStateRememberUpdatedTextComponentState.getHorizontalAlignment(), null, 4, null), textComponentStateRememberUpdatedTextComponentState.getMargin()), forCurrentTheme2, new Function2<Modifier, ColorStyle, Modifier>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView.2.1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Modifier invoke(Modifier applyIfNotNull, ColorStyle it) {
                                        Intrinsics.checkNotNullParameter(applyIfNotNull, "$this$applyIfNotNull");
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        return BackgroundKt.background$default(applyIfNotNull, it, (Shape) null, 2, (Object) null);
                                    }
                                }), textComponentStateRememberUpdatedTextComponentState.getPadding()), jM8184getUnspecified0d7_KjU, textStyle, TextUnitKt.getSp(textComponentStateRememberUpdatedTextComponentState.getFontSize()), textComponentStateRememberUpdatedTextComponentState.getFontWeight(), textComponentStateRememberUpdatedTextComponentState.getFontFamily(), textComponentStateRememberUpdatedTextComponentState.getHorizontalAlignment(), textComponentStateRememberUpdatedTextComponentState.m14020getTextAlignbuA522U(), false, false, false, composer3, 0, 0, RendererCapabilities.AUDIO_OFFLOAD_SUPPORT_MASK);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker3;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker3;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView.3
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
                        TextComponentViewKt.TextComponentView(style, state, modifier3, paywallComponentInteractionTracker2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
        if ((i3 & 1171) == 1170) {
            if (i5 == 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            textComponentStateRememberUpdatedTextComponentState = TextComponentStateKt.rememberUpdatedTextComponentState(style, state, composerStartRestartGroup, i3 & WebSocketProtocol.PAYLOAD_SHORT);
            final String strRememberProcessedText2 = rememberProcessedText(state, textComponentStateRememberUpdatedTextComponentState, composerStartRestartGroup, (i3 >> 3) & 14);
            ColorStyle forCurrentTheme3 = ColorStyleKt.getForCurrentTheme(textComponentStateRememberUpdatedTextComponentState.getColor(), composerStartRestartGroup, 0);
            ColorStyles backgroundColor2 = textComponentStateRememberUpdatedTextComponentState.getBackgroundColor();
            composerStartRestartGroup.startReplaceGroup(-1877995118);
            ComposerKt.sourceInformation(composerStartRestartGroup, "73@3832L15");
            final ColorStyle forCurrentTheme22 = backgroundColor2 != null ? null : ColorStyleKt.getForCurrentTheme(backgroundColor2, composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceGroup();
            z = forCurrentTheme3 instanceof ColorStyle.Solid;
            if (!z) {
            }
            if (!z) {
            }
            final TextStyle textStyle2 = textStyleM10464copyNs73l9s$default;
            if (textComponentStateRememberUpdatedTextComponentState.getVisible()) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            paywallComponentInteractionTracker2 = paywallComponentInteractionTracker3;
            composer2 = composerStartRestartGroup;
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final String rememberProcessedText(final PaywallState.Loaded.Components components, final TextComponentState textComponentState, Composer composer, int i) {
        composer.startReplaceGroup(-2070949083);
        ComposerKt.sourceInformation(composer, "C(rememberProcessedText)137@6374L1614:TextComponentView.kt#fyu9x8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2070949083, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.rememberProcessedText (TextComponentView.kt:136)");
        }
        composer.startReplaceGroup(1040310122);
        ComposerKt.sourceInformation(composer, "CC(remember):TextComponentView.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(components)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(textComponentState)) || (i & 48) == 32);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<String>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt$rememberProcessedText$processedText$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    VariableProcessor.PackageContext packageContext;
                    Locale javaLocale = LocalizationKt.toJavaLocale(components.getLocale());
                    Locale javaLocale2 = LocalizationKt.toJavaLocale(components.getCurrencyLocale());
                    Package applicablePackage = textComponentState.getApplicablePackage();
                    if (applicablePackage != null) {
                        PaywallState.Loaded.Components components2 = components;
                        Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(applicablePackage.getProduct(), null, 1, null);
                        packageContext = new VariableProcessor.PackageContext(TextComponentViewKt.discountPercentage(pricePricePerMonth$default != null ? Long.valueOf(pricePricePerMonth$default.getAmountMicros()) : null, components2.getMostExpensivePricePerMonthMicros()), !components2.getShowPricesWithDecimals());
                    } else {
                        packageContext = null;
                    }
                    return VariableProcessorV2.INSTANCE.processVariables(textComponentState.getText(), textComponentState.getLocalizedVariableKeys(), components.getVariableConfig(), components.getVariableDataProvider(), packageContext, applicablePackage, textComponentState.getSubscriptionOption(), javaLocale2, javaLocale, components.getCurrentDate(), textComponentState.getCountdownTime(), textComponentState.getCountFrom(), components.getCustomVariables(), components.getDefaultCustomVariables());
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        String strRememberProcessedText$lambda$3 = rememberProcessedText$lambda$3((State) objRememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return strRememberProcessedText$lambda$3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Double discountPercentage(Long l, Long l2) {
        if (l == null || l2 == null || l2.longValue() <= l.longValue()) {
            return null;
        }
        return Double.valueOf((l2.longValue() - l.longValue()) / l2.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_Default(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1838187961);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_Default)195@8660L19,190@8464L222:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1838187961, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_Default (TextComponentView.kt:189)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Hello, world", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_Default.1
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
                    TextComponentViewKt.TextComponentView_Preview_Default(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_HeadingXlExtraBold(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1682911299);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_HeadingXlExtraBold)204@8947L490:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1682911299, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_HeadingXlExtraBold (TextComponentView.kt:201)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, ComposableSingletons$TextComponentViewKt.INSTANCE.m14017getLambda2$revenuecatui_defaultsRelease(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_HeadingXlExtraBold.1
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
                    TextComponentViewKt.TextComponentView_Preview_HeadingXlExtraBold(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_SerifFont(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2065783982);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_SerifFont)229@9837L19,222@9538L325:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2065783982, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_SerifFont (TextComponentView.kt:221)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Hello, world", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : FontSpec.Generic.Serif.INSTANCE, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_SerifFont.1
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
                    TextComponentViewKt.TextComponentView_Preview_SerifFont(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_SansSerifFont(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(570489761);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_SansSerifFont)243@10275L19,236@9972L329:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(570489761, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_SansSerifFont (TextComponentView.kt:235)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Hello, world", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : FontSpec.Generic.SansSerif.INSTANCE, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_SansSerifFont.1
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
                    TextComponentViewKt.TextComponentView_Preview_SansSerifFont(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_MonospaceFont(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-744412312);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_MonospaceFont)257@10713L19,250@10410L329:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-744412312, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_MonospaceFont (TextComponentView.kt:249)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Hello, world", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : FontSpec.Generic.Monospace.INSTANCE, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_MonospaceFont.1
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
                    TextComponentViewKt.TextComponentView_Preview_MonospaceFont(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_FontSize(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(793345132);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_FontSize)271@11098L19,264@10819L305:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(793345132, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_FontSize (TextComponentView.kt:263)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Hello, world", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 4) != 0 ? 15 : 28, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_FontSize.1
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
                    TextComponentViewKt.TextComponentView_Preview_FontSize(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_HorizontalAlignment(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-43764709);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_HorizontalAlignment)285@11561L19,278@11245L471:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-43764709, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_HorizontalAlignment (TextComponentView.kt:277)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Hello, world", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.TRAILING, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), androidx.compose.foundation.layout.SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(400), 0.0f, 2, null), null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_HorizontalAlignment.1
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
                    TextComponentViewKt.TextComponentView_Preview_HorizontalAlignment(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_Customizations(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1310256028);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_Customizations)306@12538L19,294@11827L737:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1310256028, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_Customizations (TextComponentView.kt:293)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Hello, world", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(ColorKt.Color$default(255, 0, 0, 0, 8, null))), null, 2, null), (65520 & 4) != 0 ? 15 : 13, (65520 & 8) != 0 ? FontWeight.REGULAR : FontWeight.BLACK, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(ColorKt.Color$default(222, 222, 222, 0, 8, null))), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(10.0d, 10.0d, 20.0d, 20.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : new Padding(20.0d, 20.0d, 10.0d, 10.0d), (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_Customizations.1
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
                    TextComponentViewKt.TextComponentView_Preview_Customizations(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_Markdown(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1145662669);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_Markdown)319@13000L19,313@12662L364:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1145662669, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_Markdown (TextComponentView.kt:312)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Hello, **bold**, *italic* or _italic2_ with ~strikethrough~, ~~strikethrough2~~ and `monospace`. Click [here](https://revenuecat.com)", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 4) != 0 ? 15 : 0, (65520 & 8) != 0 ? FontWeight.REGULAR : null, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : null, (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : null, (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : null, (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_Markdown.1
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
                    TextComponentViewKt.TextComponentView_Preview_Markdown(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_LinearGradient(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(702292295);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_LinearGradient)357@14670L19,326@13137L1559:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(702292295, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_LinearGradient (TextComponentView.kt:325)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Do not allow people to dim your shine because they are blinded. Tell them to put some sunglasses on.", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Linear(135.0f, CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8176getCyan0d7_KjU()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color$default(0, 102, 255, 0, 8, null)), 30.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color$default(160, 0, 160, 0, 8, null)), 80.0f)}))), null, 2, null), (65520 & 4) != 0 ? 15 : 15, (65520 & 8) != 0 ? FontWeight.REGULAR : FontWeight.MEDIUM, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fixed(UInt.m14594constructorimpl(200), null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(10.0d, 10.0d, 20.0d, 20.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : new Padding(20.0d, 20.0d, 10.0d, 10.0d), (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_LinearGradient.1
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
                    TextComponentViewKt.TextComponentView_Preview_LinearGradient(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TextComponentView_Preview_RadialGradient(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(261376653);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextComponentView_Preview_RadialGradient)394@16305L19,364@14807L1524:TextComponentView.kt#fyu9x8");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(261376653, i, -1, "com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentView_Preview_RadialGradient (TextComponentView.kt:363)");
            }
            TextComponentView(PreviewHelpersKt.previewTextComponentStyle("Do not allow people to dim your shine because they are blinded. Tell them to put some sunglasses on.", (65520 & 2) != 0 ? new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null) : new ColorStyles(ColorStyleKt.toColorStyle(new ColorInfo.Gradient.Radial(CollectionsKt.listOf((Object[]) new ColorInfo.Gradient.Point[]{new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(Color.INSTANCE.m8176getCyan0d7_KjU()), 10.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color$default(0, 102, 255, 0, 8, null)), 80.0f), new ColorInfo.Gradient.Point(ColorKt.m8202toArgb8_81llA(ColorKt.Color$default(160, 0, 160, 0, 8, null)), 100.0f)}))), null, 2, null), (65520 & 4) != 0 ? 15 : 15, (65520 & 8) != 0 ? FontWeight.REGULAR : FontWeight.MEDIUM, (65520 & 16) != 0 ? null : null, (65520 & 32) != 0 ? HorizontalAlignment.CENTER : HorizontalAlignment.LEADING, (65520 & 64) != 0 ? HorizontalAlignment.CENTER : null, (65520 & 128) != 0 ? null : new ColorStyles(ColorStyle.Solid.m13944boximpl(ColorStyle.Solid.m13945constructorimpl(Color.INSTANCE.m8174getBlack0d7_KjU())), null, 2, null), (65520 & 256) != 0, (65520 & 512) != 0 ? new Size(SizeConstraint.Fill.INSTANCE, new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)) : new Size(new SizeConstraint.Fixed(UInt.m14594constructorimpl(200), null), new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) null)), (65520 & 1024) != 0 ? Padding.INSTANCE.getZero() : new Padding(10.0d, 10.0d, 20.0d, 20.0d), (65520 & 2048) != 0 ? Padding.INSTANCE.getZero() : new Padding(20.0d, 20.0d, 10.0d, 10.0d), (65520 & 4096) != 0 ? null : null, (65520 & 8192) == 0 ? null : null, (65520 & 16384) != 0 ? CountdownComponent.CountFrom.DAYS : null, (65520 & 32768) != 0 ? CollectionsKt.emptyList() : null), PreviewHelpersKt.previewEmptyState(null, composerStartRestartGroup, 0, 1), null, null, composerStartRestartGroup, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.text.TextComponentViewKt.TextComponentView_Preview_RadialGradient.1
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
                    TextComponentViewKt.TextComponentView_Preview_RadialGradient(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final String rememberProcessedText$lambda$3(State<String> state) {
        return state.getValue();
    }
}
