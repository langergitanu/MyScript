package com.revenuecat.purchases.p036ui.revenuecatui.composables;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.p036ui.revenuecatui.C7495R;
import com.revenuecat.purchases.p036ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.p036ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.ColorsFactory;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.p036ui.revenuecatui.data.testdata.templates.Template2TestDataKt;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.UrisKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: Footer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0003¢\u0006\u0002\u0010\u000e\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0001¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\u0018\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001aB\u0010\u0019\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\n\u001a\u00020\u000b2\f\b\u0001\u0010\u001d\u001a\u00020\u001e\"\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u001e\u0010#\u001a\u00020\u0001*\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, m1599d2 = {"Footer", "", "mode", "Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;", "configuration", "Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;", "colors", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "childModifier", "Landroidx/compose/ui/Modifier;", "allPlansTapped", "Lkotlin/Function0;", "(Lcom/revenuecat/purchases/ui/revenuecatui/PaywallMode;Lcom/revenuecat/purchases/paywalls/PaywallData$Configuration;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "templateConfiguration", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FooterPreview", "(Landroidx/compose/runtime/Composer;I)V", "openURL", WebViewMessageType.CONTEXT, "Landroid/content/Context;", ImagesContract.URL, "Ljava/net/URL;", "Button", "Landroidx/compose/foundation/layout/RowScope;", "color", "Landroidx/compose/ui/graphics/Color;", "texts", "", "", "action", "Button-sW7UJKQ", "(Landroidx/compose/foundation/layout/RowScope;JLandroidx/compose/ui/Modifier;[ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Separator", "Separator-RPmYEkk", "(Landroidx/compose/foundation/layout/RowScope;JLandroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class FooterKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0192  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Footer(final TemplateConfiguration templateConfiguration, final PaywallViewModel viewModel, Modifier modifier, TemplateConfiguration.Colors colors, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        TemplateConfiguration.Colors colors2;
        int i4;
        Function0<Unit> function02;
        TemplateConfiguration.Colors currentColors;
        int i5;
        final TemplateConfiguration.Colors colors3;
        Function0<Unit> function03;
        int currentCompositeKeyHash;
        Composer composerM7248constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Function0<Unit> function04;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(templateConfiguration, "templateConfiguration");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1570484492);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Footer)P(3,4,1,2)64@3120L331:Footer.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(templateConfiguration) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(viewModel) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) != 0) {
                if ((i2 & 8) == 0) {
                    colors2 = colors;
                    int i7 = composerStartRestartGroup.changed(colors2) ? 2048 : 1024;
                    i3 |= i7;
                } else {
                    colors2 = colors;
                }
                i3 |= i7;
            } else {
                colors2 = colors;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function02 = function0;
                    i3 |= composerStartRestartGroup.changedInstance(function02) ? 16384 : 8192;
                }
                if ((i3 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "61@3050L18");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 8) == 0) {
                            currentColors = templateConfiguration.getCurrentColors(composerStartRestartGroup, i3 & 14);
                            i3 &= -7169;
                        } else {
                            currentColors = colors2;
                        }
                        if (i4 == 0) {
                            function03 = null;
                            Modifier modifier3 = companion;
                            i5 = i3;
                            colors3 = currentColors;
                            modifier2 = modifier3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1570484492, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Footer (Footer.kt:63)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
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
                            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM7248constructorimpl.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 9300996, "C65@3137L281,73@3427L18:Footer.kt#51odh9");
                            int i8 = i5 << 6;
                            Footer(templateConfiguration.getMode(), templateConfiguration.getConfiguration(), colors3, viewModel, modifier2, function03, composerStartRestartGroup, ((i5 >> 3) & 896) | (i8 & 7168) | (i8 & 57344) | ((i5 << 3) & 458752), 0);
                            InsetSpacersKt.SystemBarsSpacer(composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function04 = function03;
                        } else {
                            Modifier modifier4 = companion;
                            i5 = i3;
                            colors3 = currentColors;
                            modifier2 = modifier4;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        i5 = i3;
                        colors3 = colors2;
                    }
                    function03 = function02;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion22);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (!composerStartRestartGroup.getInserting()) {
                    }
                    composerM7248constructorimpl = Updater.m7248constructorimpl(composerStartRestartGroup);
                    Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM7248constructorimpl.getInserting()) {
                        composerM7248constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM7248constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 9300996, "C65@3137L281,73@3427L18:Footer.kt#51odh9");
                        int i82 = i5 << 6;
                        Footer(templateConfiguration.getMode(), templateConfiguration.getConfiguration(), colors3, viewModel, modifier2, function03, composerStartRestartGroup, ((i5 >> 3) & 896) | (i82 & 7168) | (i82 & 57344) | ((i5 << 3) & 458752), 0);
                        InsetSpacersKt.SystemBarsSpacer(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function04 = function03;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    colors3 = colors2;
                    function04 = function02;
                }
                final Modifier modifier5 = modifier2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.Footer.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i9) {
                            FooterKt.Footer(templateConfiguration, viewModel, modifier5, colors3, function04, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= 24576;
            function02 = function0;
            if ((i3 & 9363) != 9362) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "61@3050L18");
                if ((i & 1) != 0) {
                    if (i6 == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if (i4 == 0) {
                    }
                }
            }
            final Modifier modifier52 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 3072) != 0) {
        }
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        function02 = function0;
        if ((i3 & 9363) != 9362) {
        }
        final Modifier modifier522 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Footer(final PaywallMode paywallMode, final PaywallData.Configuration configuration, final TemplateConfiguration.Colors colors, final PaywallViewModel paywallViewModel, Modifier modifier, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        PaywallData.Configuration configuration2;
        TemplateConfiguration.Colors colors2;
        int i4;
        Modifier modifier2;
        int i5;
        Function0<Unit> function02;
        Modifier.Companion companion;
        final Function0<Unit> function03;
        boolean z;
        float fM11017constructorimpl;
        int currentCompositeKeyHash;
        Composer composerM7248constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        RowScopeInstance rowScopeInstance;
        Function0<Unit> function04;
        boolean z2;
        Modifier modifier3;
        RowScopeInstance rowScopeInstance2;
        int i6;
        final URL termsOfServiceURL;
        Function0<Unit> function05;
        final URL privacyURL;
        final Function0<Unit> function06;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(603087565);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Footer)P(4,3,2,5,1)88@3907L7,99@4356L3681:Footer.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(paywallMode) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                configuration2 = configuration;
                i3 |= composerStartRestartGroup.changedInstance(configuration2) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    colors2 = colors;
                    i3 |= composerStartRestartGroup.changed(colors2) ? 256 : 128;
                }
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= composerStartRestartGroup.changed(paywallViewModel) ? 2048 : 1024;
                }
                i4 = i2 & 16;
                if (i4 != 0) {
                    i3 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        modifier2 = modifier;
                        i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
                    }
                    i5 = i2 & 32;
                    if (i5 != 0) {
                        if ((196608 & i) == 0) {
                            function02 = function0;
                            i3 |= composerStartRestartGroup.changedInstance(function02) ? 131072 : 65536;
                        }
                        if ((74899 & i3) != 74898 || !composerStartRestartGroup.getSkipping()) {
                            companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                            function03 = i5 == 0 ? null : function02;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(603087565, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Footer (Footer.kt:86)");
                            }
                            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localView);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final Context context = ((View) objConsume).getContext();
                            z = (paywallMode == PaywallMode.FOOTER_CONDENSED || function03 == null) ? false : true;
                            if (!z || configuration2.getDisplayRestorePurchases() || configuration2.getTermsOfServiceURL() != null || configuration2.getPrivacyURL() != null) {
                                fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                            } else {
                                fM11017constructorimpl = C1486Dp.m11017constructorimpl(UIConstant.INSTANCE.m13862getDefaultVerticalSpacingD9Ej5fM() * 2);
                            }
                            Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), IntrinsicSize.Min), UIConstant.INSTANCE.m13859getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, UIConstant.INSTANCE.m13859getDefaultHorizontalPaddingD9Ej5fM(), fM11017constructorimpl, 2, null);
                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composerStartRestartGroup, 54);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2858paddingqDBjuR0$default);
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
                            rowScopeInstance = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 11033617, "C:Footer.kt#51odh9");
                            long jM14206getText10d7_KjU = colors2.m14206getText10d7_KjU();
                            composerStartRestartGroup.startReplaceGroup(-1108024003);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "118@5046L400,114@4899L562,132@5660L24");
                            if (z || function03 == null) {
                                function04 = function03;
                                z2 = true;
                                modifier3 = companion;
                                rowScopeInstance2 = rowScopeInstance;
                                i6 = 2048;
                            } else {
                                int[] iArr = {C7495R.string.all_plans};
                                composerStartRestartGroup.startReplaceGroup(-1108017445);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Footer.kt#9igjgp");
                                boolean z3 = ((i3 & 458752) == 131072) | ((i3 & 7168) == 2048);
                                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Footer$3$1$1
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
                                            PaywallViewModel.trackComponentInteraction$default(paywallViewModel, PaywallComponentType.BUTTON, PaywallLegacyComponentInteraction.ALL_PLANS_BUTTON_NAME, PaywallLegacyComponentInteraction.Value.TOGGLE_ALL_PLANS, null, 8, null);
                                            function03.invoke();
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                function04 = function03;
                                z2 = true;
                                modifier3 = companion;
                                rowScopeInstance2 = rowScopeInstance;
                                i6 = 2048;
                                m14052ButtonsW7UJKQ(rowScopeInstance2, jM14206getText10d7_KjU, modifier3, iArr, (Function0) objRememberedValue, composerStartRestartGroup, 6 | ((i3 >> 6) & 896));
                                if (configuration.getDisplayRestorePurchases() || configuration.getTermsOfServiceURL() != null || configuration.getPrivacyURL() != null) {
                                    m14053SeparatorRPmYEkk(rowScopeInstance2, jM14206getText10d7_KjU, composerStartRestartGroup, 6);
                                }
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            composerStartRestartGroup.startReplaceGroup(-1107995562);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "142@5953L383,137@5775L561,152@6449L24");
                            if (configuration.getDisplayRestorePurchases()) {
                                int[] iArr2 = {C7495R.string.restore_purchases, C7495R.string.restore};
                                composerStartRestartGroup.startReplaceGroup(-1107988438);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Footer.kt#9igjgp");
                                boolean z4 = (i3 & 7168) == i6 ? z2 : false;
                                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Footer$3$2$1
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
                                m14052ButtonsW7UJKQ(rowScopeInstance2, jM14206getText10d7_KjU, modifier3, iArr2, (Function0) objRememberedValue2, composerStartRestartGroup, ((i3 >> 6) & 896) | 6);
                                if (configuration.getTermsOfServiceURL() != null || configuration.getPrivacyURL() != null) {
                                    m14053SeparatorRPmYEkk(rowScopeInstance2, jM14206getText10d7_KjU, composerStartRestartGroup, 6);
                                }
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            termsOfServiceURL = configuration.getTermsOfServiceURL();
                            composerStartRestartGroup.startReplaceGroup(-1107969259);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*162@6737L463,157@6558L642");
                            if (termsOfServiceURL != null) {
                                function05 = function04;
                            } else {
                                int[] iArr3 = {C7495R.string.terms_and_conditions, C7495R.string.terms};
                                composerStartRestartGroup.startReplaceGroup(-546661383);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Footer.kt#9igjgp");
                                function05 = function04;
                                boolean zChangedInstance = ((i3 & 7168) == 2048 ? z2 : false) | composerStartRestartGroup.changedInstance(termsOfServiceURL) | composerStartRestartGroup.changedInstance(context);
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Footer$3$3$1$1
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
                                            String string = termsOfServiceURL.toString();
                                            Intrinsics.checkNotNullExpressionValue(string, "it.toString()");
                                            paywallViewModel.trackComponentInteraction(PaywallComponentType.BUTTON, PaywallLegacyComponentInteraction.TERMS_LINK_NAME, PaywallLegacyComponentInteraction.Value.NAVIGATE_TO_TERMS, string);
                                            Context context2 = context;
                                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                                            FooterKt.openURL(context2, termsOfServiceURL);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                m14052ButtonsW7UJKQ(rowScopeInstance2, jM14206getText10d7_KjU, modifier3, iArr3, (Function0) objRememberedValue3, composerStartRestartGroup, 6 | ((i3 >> 6) & 896));
                                composerStartRestartGroup.startReplaceGroup(-1107948375);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "174@7270L24");
                                if (configuration.getPrivacyURL() != null) {
                                    m14053SeparatorRPmYEkk(rowScopeInstance2, jM14206getText10d7_KjU, composerStartRestartGroup, 6);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                Unit unit = Unit.INSTANCE;
                                Unit unit2 = Unit.INSTANCE;
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            privacyURL = configuration.getPrivacyURL();
                            composerStartRestartGroup.startReplaceGroup(-1107943312);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*184@7547L474,179@7372L649");
                            if (privacyURL != null) {
                                int[] iArr4 = {C7495R.string.privacy_policy, C7495R.string.privacy};
                                composerStartRestartGroup.startReplaceGroup(-546635452);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Footer.kt#9igjgp");
                                boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(privacyURL) | ((i3 & 7168) == 2048 ? z2 : false) | composerStartRestartGroup.changedInstance(context);
                                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Footer$3$4$1$1
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
                                            String string = privacyURL.toString();
                                            Intrinsics.checkNotNullExpressionValue(string, "it.toString()");
                                            paywallViewModel.trackComponentInteraction(PaywallComponentType.BUTTON, PaywallLegacyComponentInteraction.PRIVACY_LINK_NAME, PaywallLegacyComponentInteraction.Value.NAVIGATE_TO_PRIVACY_POLICY, string);
                                            Context context2 = context;
                                            Intrinsics.checkNotNullExpressionValue(context2, "context");
                                            FooterKt.openURL(context2, privacyURL);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                m14052ButtonsW7UJKQ(rowScopeInstance2, jM14206getText10d7_KjU, modifier3, iArr4, (Function0) objRememberedValue4, composerStartRestartGroup, 6 | ((i3 >> 6) & 896));
                                Unit unit3 = Unit.INSTANCE;
                                Unit unit4 = Unit.INSTANCE;
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
                            function06 = function05;
                            modifier4 = modifier3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            function06 = function02;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.Footer.4
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
                                    FooterKt.Footer(paywallMode, configuration, colors, paywallViewModel, modifier4, function06, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                    function02 = function0;
                    if ((74899 & i3) != 74898) {
                        if (i4 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<View> localView2 = AndroidCompositionLocals_androidKt.getLocalView();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localView2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Context context2 = ((View) objConsume2).getContext();
                        if (paywallMode == PaywallMode.FOOTER_CONDENSED) {
                            if (!z) {
                                fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                                Modifier modifierM2858paddingqDBjuR0$default2 = PaddingKt.m2858paddingqDBjuR0$default(IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), IntrinsicSize.Min), UIConstant.INSTANCE.m13859getDefaultHorizontalPaddingD9Ej5fM(), 0.0f, UIConstant.INSTANCE.m13859getDefaultHorizontalPaddingD9Ej5fM(), fM11017constructorimpl, 2, null);
                                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(center2, centerVertically2, composerStartRestartGroup, 54);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2858paddingqDBjuR0$default2);
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
                                    rowScopeInstance = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 11033617, "C:Footer.kt#51odh9");
                                    long jM14206getText10d7_KjU2 = colors2.m14206getText10d7_KjU();
                                    composerStartRestartGroup.startReplaceGroup(-1108024003);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "118@5046L400,114@4899L562,132@5660L24");
                                    if (z) {
                                        function04 = function03;
                                        z2 = true;
                                        modifier3 = companion;
                                        rowScopeInstance2 = rowScopeInstance;
                                        i6 = 2048;
                                        composerStartRestartGroup.endReplaceGroup();
                                        composerStartRestartGroup.startReplaceGroup(-1107995562);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "142@5953L383,137@5775L561,152@6449L24");
                                        if (configuration.getDisplayRestorePurchases()) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        termsOfServiceURL = configuration.getTermsOfServiceURL();
                                        composerStartRestartGroup.startReplaceGroup(-1107969259);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "*162@6737L463,157@6558L642");
                                        if (termsOfServiceURL != null) {
                                        }
                                        composerStartRestartGroup.endReplaceGroup();
                                        privacyURL = configuration.getPrivacyURL();
                                        composerStartRestartGroup.startReplaceGroup(-1107943312);
                                        ComposerKt.sourceInformation(composerStartRestartGroup, "*184@7547L474,179@7372L649");
                                        if (privacyURL != null) {
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
                                        function06 = function05;
                                        modifier4 = modifier3;
                                    }
                                }
                            }
                        }
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                modifier2 = modifier;
                i5 = i2 & 32;
                if (i5 != 0) {
                }
                function02 = function0;
                if ((74899 & i3) != 74898) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            colors2 = colors;
            if ((i2 & 8) != 0) {
            }
            i4 = i2 & 16;
            if (i4 != 0) {
            }
            modifier2 = modifier;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            function02 = function0;
            if ((74899 & i3) != 74898) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        configuration2 = configuration;
        if ((i2 & 4) == 0) {
        }
        colors2 = colors;
        if ((i2 & 8) != 0) {
        }
        i4 = i2 & 16;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        function02 = function0;
        if ((74899 & i3) != 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Separator-RPmYEkk, reason: not valid java name */
    public static final void m14053SeparatorRPmYEkk(final RowScope rowScope, final long j, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1035469312);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Separator)P(0:c#ui.graphics.Color)200@8104L368:Footer.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035469312, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Separator (Footer.kt:199)");
            }
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenter(), false, 2, null), 0.5f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613100548, "C206@8262L204:Footer.kt#51odh9");
            BoxKt.Box(BackgroundKt.m2016backgroundbw27NRU$default(ClipKt.clip(SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(5)), RoundedCornerShapeKt.getCircleShape()), j, null, 2, null), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Separator$2
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
                    FooterKt.m14053SeparatorRPmYEkk(rowScope, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Button-sW7UJKQ, reason: not valid java name */
    public static final void m14052ButtonsW7UJKQ(final RowScope rowScope, final long j, final Modifier modifier, final int[] iArr, final Function0<Unit> function0, Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-806477784);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Button)P(2:c#ui.graphics.Color,1,3)227@8745L29,229@8780L1961:Footer.kt#51odh9");
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        composerStartRestartGroup.startMovableGroup(2067025279, Integer.valueOf(iArr.length));
        for (int i3 : iArr) {
            i2 |= composerStartRestartGroup.changed(i3) ? 2048 : 0;
        }
        composerStartRestartGroup.endMovableGroup();
        if ((i2 & 7168) == 0) {
            i2 |= 1024;
        }
        if ((i2 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-806477784, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button (Footer.kt:222)");
            }
            final String strStringResource = StringResources_androidKt.stringResource(ArraysKt.first(iArr), composerStartRestartGroup, 0);
            int i4 = i2;
            Modifier modifierAlign = rowScope.align(RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null), Alignment.INSTANCE.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -520340198, "C235@8938L14,239@9131L141,243@9284L1451,234@8904L1831:Footer.kt#51odh9");
            composerStartRestartGroup.startReplaceGroup(814498096);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Footer.kt#9igjgp");
            boolean z = (i4 & 57344) == 16384;
            FooterKt$Button$1$1$1 footerKt$Button$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || footerKt$Button$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                footerKt$Button$1$1$1RememberedValue = new FooterKt$Button$1$1$1(function0);
                composerStartRestartGroup.updateRememberedValue(footerKt$Button$1$1$1RememberedValue);
            }
            KFunction kFunction = (KFunction) footerKt$Button$1$1$1RememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            PaddingValues paddingValuesM2847PaddingValues0680j_4 = PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(4));
            Modifier modifierAlign2 = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
            composerStartRestartGroup.startReplaceGroup(814504399);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Footer.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strStringResource);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semantics) {
                        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                        SemanticsPropertiesKt.setText(semantics, new AnnotatedString(strStringResource, null, null, 6, null));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            ButtonKt.TextButton((Function0) kFunction, SemanticsModifierKt.semantics(modifierAlign2, true, (Function1) objRememberedValue), false, null, null, null, null, paddingValuesM2847PaddingValues0680j_4, null, ComposableLambdaKt.rememberComposableLambda(365963733, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope2, Composer composer3, Integer num) {
                    invoke(rowScope2, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer composer3, int i5) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    ComposerKt.sourceInformation(composer3, "C246@9459L1266:Footer.kt#51odh9");
                    int i6 = (i5 & 6) == 0 ? i5 | (composer3.changed(TextButton) ? 4 : 2) : i5;
                    if ((i6 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(365963733, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button.<anonymous>.<anonymous> (Footer.kt:246)");
                        }
                        Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3.1
                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                                Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }
                        });
                        composer3.startReplaceGroup(-1033561293);
                        ComposerKt.sourceInformation(composer3, "*251@9680L478");
                        int[] iArr2 = iArr;
                        final Modifier modifier2 = modifier;
                        final long j2 = j;
                        ArrayList arrayList = new ArrayList(iArr2.length);
                        for (final int i7 : iArr2) {
                            arrayList.add(ComposableLambdaKt.rememberComposableLambda(-1943754282, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i8) {
                                    ComposerKt.sourceInformation(composer4, "C253@9755L18,256@9940L7,252@9710L422:Footer.kt#51odh9");
                                    if ((i8 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1943754282, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Footer.kt:252)");
                                        }
                                        String strStringResource2 = StringResources_androidKt.stringResource(i7, composer4, 0);
                                        int iM10895getCentere0LSkKk = TextAlign.INSTANCE.m10895getCentere0LSkKk();
                                        TextKt.m5868Text4IGK_g(strStringResource2, modifier2, j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m10888boximpl(iM10895getCentere0LSkKk), 0L, 0, false, 1, 0, (Function1) null, FooterConstants.INSTANCE.style(composer4, 6), composer4, 0, 3456, 52728);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54));
                        }
                        ArrayList arrayList2 = arrayList;
                        composer3.endReplaceGroup();
                        composer3.startReplaceGroup(-1033543484);
                        ComposerKt.sourceInformation(composer3, "*264@10238L431");
                        int[] iArr3 = iArr;
                        final Modifier modifier3 = modifier;
                        final long j3 = j;
                        ArrayList arrayList3 = new ArrayList(iArr3.length);
                        for (final int i8 : iArr3) {
                            arrayList3.add(ComposableLambdaKt.rememberComposableLambda(1301841013, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$1$3$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i9) {
                                    ComposerKt.sourceInformation(composer4, "C266@10313L18,269@10498L7,265@10268L375:Footer.kt#51odh9");
                                    if ((i9 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1301841013, i9, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.Button.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Footer.kt:265)");
                                        }
                                        String strStringResource2 = StringResources_androidKt.stringResource(i8, composer4, 0);
                                        int iM10895getCentere0LSkKk = TextAlign.INSTANCE.m10895getCentere0LSkKk();
                                        TextKt.m5868Text4IGK_g(strStringResource2, modifier3, j3, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m10888boximpl(iM10895getCentere0LSkKk), 0L, 0, true, 0, 0, (Function1) null, FooterConstants.INSTANCE.style(composer4, 6), composer4, 0, RendererCapabilities.DECODER_SUPPORT_MASK, 60920);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }, composer3, 54));
                        }
                        composer3.endReplaceGroup();
                        AdaptiveComposableKt.AdaptiveComposable(TextButton, modifierClearAndSetSemantics, FooterKt.Button_sW7UJKQ$merge(arrayList2, arrayList3), composer3, i6 & 14, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composer2, 817889280, 380);
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
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt$Button$2
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
                    RowScope rowScope2 = rowScope;
                    long j2 = j;
                    Modifier modifier2 = modifier;
                    int[] iArr2 = iArr;
                    FooterKt.m14052ButtonsW7UJKQ(rowScope2, j2, modifier2, Arrays.copyOf(iArr2, iArr2.length), function0, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<T> Button_sW7UJKQ$merge(List<? extends T> list, List<? extends T> list2) {
        return CollectionsKt.plus((Collection) list, (Iterable) list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openURL(final Context context, URL url) {
        String string = url.toString();
        Intrinsics.checkNotNullExpressionValue(string, "url.toString()");
        UrisKt.openUriOrElse(context, string, new Function1<Exception, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.openURL.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exception) {
                String string2;
                Intrinsics.checkNotNullParameter(exception, "exception");
                if (exception instanceof ActivityNotFoundException) {
                    string2 = context.getString(C7495R.string.no_browser_cannot_open_link);
                } else {
                    string2 = context.getString(C7495R.string.cannot_open_link);
                }
                Intrinsics.checkNotNullExpressionValue(string2, "if (exception is Activit…nnot_open_link)\n        }");
                Toast.makeText(context, string2, 0).show();
                Logger.INSTANCE.m1587w(string2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FooterPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1861228911);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FooterPreview)301@11377L703:Footer.kt#51odh9");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1861228911, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.FooterPreview (Footer.kt:300)");
            }
            Footer(PaywallMode.FULL_SCREEN, new PaywallData.Configuration(CollectionsKt.emptyList(), (String) null, new PaywallData.Configuration.Images((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null), (Map) null, Template2TestDataKt.getTemplate2(TestData.INSTANCE).getConfig().getColors(), (Map) null, (List) null, false, true, new URL("https://revenuecat.com/tos"), new URL("https://revenuecat.com/privacy"), 104, (DefaultConstructorMarker) null), ColorsFactory.INSTANCE.create(Template2TestDataKt.getTemplate2(TestData.INSTANCE).getConfig().getColors().getLight()), new MockViewModel(PaywallMode.FULL_SCREEN, TestData.INSTANCE.getTemplate2Offering(), null, false, false, null, 60, null), null, null, composerStartRestartGroup, 6, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.FooterKt.FooterPreview.1
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
                    FooterKt.FooterPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
