package com.revenuecat.purchases.p036ui.revenuecatui.components;

import androidx.compose.p004ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.p007ts.PsExtractor;
import com.revenuecat.purchases.p036ui.revenuecatui.components.button.ButtonComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.carousel.CarouselComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.countdown.CountdownComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.header.HeaderComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.iconcomponent.IconComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.image.ImageComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.pkg.PackageComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.stack.StackComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.stickyfooter.StickyFooterComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.CountdownComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.HeaderComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.IconComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ImageComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.PackageComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StackComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.StickyFooterComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabControlButtonComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabControlStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabControlToggleComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TabsComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TextComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.TimelineComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.VideoComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.WebViewComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.components.tabs.TabControlButtonViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.tabs.TabControlToggleViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.tabs.TabsComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.text.TextComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.timeline.TimelineComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.video.VideoComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewComponentViewKt;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComponentView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"ComponentView", "", "style", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "onClick", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "Lkotlin/coroutines/Continuation;", "", "modifier", "Landroidx/compose/ui/Modifier;", "componentInteractionTracker", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ComponentStyle;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/PaywallComponentInteractionTracker;Landroidx/compose/runtime/Composer;II)V", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class ComponentViewKt {
    /* JADX WARN: Removed duplicated region for block: B:127:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void ComponentView(final ComponentStyle style, final PaywallState.Loaded.Components state, final Function2 onClick, Modifier modifier, PaywallComponentInteractionTracker paywallComponentInteractionTracker, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Modifier modifier3;
        final Modifier modifier4;
        Composer composer2;
        final PaywallComponentInteractionTracker paywallComponentInteractionTracker2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        PaywallComponentInteractionTracker paywallComponentInteractionTracker3 = paywallComponentInteractionTracker;
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(2086768586);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ComponentView)P(4,3,2,1):ComponentView.kt#dnqhhd");
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
                    paywallComponentInteractionTracker3 = new PaywallComponentInteractionTracker() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewKt$$ExternalSyntheticLambda0
                        @Override // com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionTracker
                        public final void track(PaywallComponentInteractionData paywallComponentInteractionData) {
                            Intrinsics.checkNotNullParameter(paywallComponentInteractionData, "<anonymous parameter 0>");
                        }
                    };
                }
                PaywallComponentInteractionTracker paywallComponentInteractionTracker4 = paywallComponentInteractionTracker3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2086768586, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.components.ComponentView (ComponentView.kt:55)");
                }
                if (!(style instanceof StackComponentStyle)) {
                    composerStartRestartGroup.startReplaceGroup(754755354);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "56@3773L199");
                    Modifier modifier5 = companion;
                    StackComponentViewKt.StackComponentView((StackComponentStyle) style, state, onClick, modifier5, null, false, null, 0.0f, paywallComponentInteractionTracker4, composerStartRestartGroup, (i3 & 8176) | (234881024 & (i3 << 12)), PsExtractor.VIDEO_STREAM_MASK);
                    modifier3 = modifier5;
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier3 = companion;
                    if (style instanceof TextComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754762649);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "63@4002L166");
                        int i6 = i3 >> 3;
                        TextComponentViewKt.TextComponentView((TextComponentStyle) style, state, modifier3, paywallComponentInteractionTracker4, composerStartRestartGroup, (i3 & 112) | (i6 & 896) | (i6 & 7168), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof ImageComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754768856);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "69@4199L69");
                        ImageComponentViewKt.ImageComponentView((ImageComponentStyle) style, state, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof VideoComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(1923099211);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "71@4309L116");
                        VideoComponentViewKt.VideoComponentView((VideoComponentStyle) style, state, modifier3, null, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 8);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof WebViewComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754777369);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4464L102");
                        WebViewComponentViewKt.WebViewComponentView((WebViewComponentStyle) style, state, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof ButtonComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754781750);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "82@4598L195");
                        ButtonComponentViewKt.ButtonComponentView((ButtonComponentStyle) style, state, onClick, modifier3, paywallComponentInteractionTracker4, composerStartRestartGroup, i3 & 65520, 0);
                        modifier3 = modifier3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof HeaderComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754788952);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4825L133");
                        HeaderComponentViewKt.HeaderComponentView((HeaderComponentStyle) style, state, onClick, modifier3, composerStartRestartGroup, i3 & 8176, 0);
                        modifier3 = modifier3;
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof StickyFooterComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754794497);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4996L206");
                        StickyFooterComponentViewKt.StickyFooterComponentView((StickyFooterComponentStyle) style, state, onClick, modifier3, paywallComponentInteractionTracker4, composerStartRestartGroup, i3 & 65520, 0);
                        modifier3 = modifier3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof PackageComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754802140);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "102@5235L201");
                        PackageComponentViewKt.PackageComponentView((PackageComponentStyle) style, state, onClick, modifier3, paywallComponentInteractionTracker4, composerStartRestartGroup, i3 & 65520, 0);
                        modifier3 = modifier3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof IconComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754809399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "109@5466L68");
                        IconComponentViewKt.IconComponentView((IconComponentStyle) style, state, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof TimelineComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754812667);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "110@5568L72");
                        TimelineComponentViewKt.TimelineComponentView((TimelineComponentStyle) style, state, modifier3, composerStartRestartGroup, (i3 & 112) | ((i3 >> 3) & 896), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof CarouselComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754816189);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "111@5674L202");
                        CarouselComponentViewKt.CarouselComponentView((CarouselComponentStyle) style, state, onClick, modifier3, paywallComponentInteractionTracker4, composerStartRestartGroup, i3 & 65520, 0);
                        modifier3 = modifier3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof TabsComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754823609);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "118@5906L198");
                        TabsComponentViewKt.TabsComponentView((TabsComponentStyle) style, state, onClick, modifier3, paywallComponentInteractionTracker4, composerStartRestartGroup, i3 & 65520, 0);
                        modifier3 = modifier3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof TabControlStyle.Buttons) {
                        composerStartRestartGroup.startReplaceGroup(1925007106);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "126@6220L205");
                        StackComponentViewKt.StackComponentView(((TabControlStyle.Buttons) style).getStack(), state, onClick, modifier3, null, false, null, 0.0f, paywallComponentInteractionTracker4, composerStartRestartGroup, (i3 & 8176) | (234881024 & (i3 << 12)), PsExtractor.VIDEO_STREAM_MASK);
                        modifier3 = modifier3;
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof TabControlStyle.Toggle) {
                        composerStartRestartGroup.startReplaceGroup(1925323554);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "134@6539L205");
                        StackComponentViewKt.StackComponentView(((TabControlStyle.Toggle) style).getStack(), state, onClick, modifier3, null, false, null, 0.0f, paywallComponentInteractionTracker4, composerStartRestartGroup, (i3 & 8176) | (234881024 & (i3 << 12)), PsExtractor.VIDEO_STREAM_MASK);
                        modifier3 = modifier3;
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof TabControlButtonComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754851740);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "141@6786L169");
                        int i7 = i3 >> 3;
                        TabControlButtonViewKt.TabControlButtonView((TabControlButtonComponentStyle) style, state, modifier3, paywallComponentInteractionTracker4, composerStartRestartGroup, (i3 & 112) | (i7 & 896) | (i7 & 7168), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof TabControlToggleComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754858492);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "147@6997L169");
                        int i8 = i3 >> 3;
                        TabControlToggleViewKt.TabControlToggleView((TabControlToggleComponentStyle) style, state, modifier3, paywallComponentInteractionTracker4, composerStartRestartGroup, (i3 & 112) | (i8 & 896) | (i8 & 7168), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else if (style instanceof CountdownComponentStyle) {
                        composerStartRestartGroup.startReplaceGroup(754865049);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "153@7201L198");
                        CountdownComponentViewKt.CountdownComponentView((CountdownComponentStyle) style, state, onClick, modifier3, paywallComponentInteractionTracker4, composerStartRestartGroup, i3 & 65520, 0);
                        modifier3 = modifier3;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(754634387);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
                composer2 = composerStartRestartGroup;
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                composer2 = composerStartRestartGroup;
                modifier4 = modifier2;
                paywallComponentInteractionTracker2 = paywallComponentInteractionTracker3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.ComponentViewKt.ComponentView.2
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

                    public final void invoke(Composer composer3, int i9) {
                        ComponentViewKt.ComponentView(style, state, onClick, modifier4, paywallComponentInteractionTracker2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
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
            PaywallComponentInteractionTracker paywallComponentInteractionTracker42 = paywallComponentInteractionTracker3;
            if (ComposerKt.isTraceInProgress()) {
            }
            if (!(style instanceof StackComponentStyle)) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            composer2 = composerStartRestartGroup;
            paywallComponentInteractionTracker2 = paywallComponentInteractionTracker42;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }
}
