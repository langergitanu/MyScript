package com.revenuecat.purchases.p036ui.revenuecatui.composables;

import android.app.Activity;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.SolidColor;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.TestTagKt;
import androidx.compose.p004ui.semantics.SemanticsModifierKt;
import androidx.compose.p004ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p004ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.p036ui.revenuecatui.UIConstant;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.ProcessedLocalizedConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.p036ui.revenuecatui.data.testdata.MockViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.PackageExtensionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.HelperFunctionsKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.PaywallProductIdentifierKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.TestTag;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PurchaseButton.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aJ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0016\u001a$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a!\u0010\u001e\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020\u001aX\u008a\u0084\u0002"}, m1599d2 = {TestTag.PURCHASE_BUTTON_TAG, "", "state", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;", "viewModel", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;", "childModifier", "Landroidx/compose/ui/Modifier;", "horizontalPadding", "Landroidx/compose/ui/unit/Dp;", "colors", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;", "PurchaseButton-hGBTI10", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Legacy;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;Landroidx/compose/ui/Modifier;FLcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;II)V", Keys.PACKAGES, "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;", "selectedPackage", "Landroidx/compose/runtime/MutableState;", "Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageInfo;", "PurchaseButton-WH-ejsw", "(Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Lcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$PackageConfiguration;Landroidx/compose/runtime/MutableState;Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallViewModel;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PurchaseButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "buttonBrush", "Landroidx/compose/ui/graphics/Brush;", "primaryColor", "Landroidx/compose/ui/graphics/Color;", "secondaryColor", "buttonBrush-A47ccPs", "(JLandroidx/compose/ui/graphics/Color;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Brush;", "LoadingSpinner", "Landroidx/compose/foundation/layout/BoxScope;", "shouldShow", "", "(Landroidx/compose/foundation/layout/BoxScope;ZLcom/revenuecat/purchases/ui/revenuecatui/data/processed/TemplateConfiguration$Colors;Landroidx/compose/runtime/Composer;I)V", "revenuecatui_defaultsRelease", "labelOpacity", "", "primaryCTAColor", "secondaryCTAColorState"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PurchaseButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:86:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0135  */
    /* JADX INFO: renamed from: PurchaseButton-hGBTI10, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m14088PurchaseButtonhGBTI10(final PaywallState.Loaded.Legacy state, final PaywallViewModel viewModel, Modifier modifier, float f, TemplateConfiguration.Colors colors, Composer composer, final int i, final int i2) {
        int i3;
        float fM13859getDefaultHorizontalPaddingD9Ej5fM;
        TemplateConfiguration.Colors colors2;
        final Modifier modifier2;
        final TemplateConfiguration.Colors currentColors;
        final float f2;
        final Modifier modifier3;
        final TemplateConfiguration.Colors colors3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(885662377);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseButton)P(3,4!1,2:c#ui.unit.Dp)61@3085L313,61@3010L388:PurchaseButton.kt#51odh9");
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
            i3 |= composerStartRestartGroup.changed(viewModel) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                fM13859getDefaultHorizontalPaddingD9Ej5fM = f;
                int i5 = composerStartRestartGroup.changed(fM13859getDefaultHorizontalPaddingD9Ej5fM) ? 2048 : 1024;
                i3 |= i5;
            } else {
                fM13859getDefaultHorizontalPaddingD9Ej5fM = f;
            }
            i3 |= i5;
        } else {
            fM13859getDefaultHorizontalPaddingD9Ej5fM = f;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                colors2 = colors;
                int i6 = composerStartRestartGroup.changed(colors2) ? 16384 : 8192;
                i3 |= i6;
            } else {
                colors2 = colors;
            }
            i3 |= i6;
        } else {
            colors2 = colors;
        }
        if ((i3 & 9363) != 9362 || !composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "59@2982L18");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier;
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    fM13859getDefaultHorizontalPaddingD9Ej5fM = UIConstant.INSTANCE.m13859getDefaultHorizontalPaddingD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    currentColors = state.getTemplateConfiguration().getCurrentColors(composerStartRestartGroup, 0);
                    modifier2 = companion;
                    f2 = fM13859getDefaultHorizontalPaddingD9Ej5fM;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(885662377, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton (PurchaseButton.kt:60)");
                    }
                    DisableTouchesComposableKt.DisableTouchesComposable(viewModel.getActionInProgress().getValue().booleanValue(), ComposableLambdaKt.rememberComposableLambda(22366153, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$1
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
                            ComposerKt.sourceInformation(composer2, "C62@3095L297:PurchaseButton.kt#51odh9");
                            if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(22366153, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous> (PurchaseButton.kt:62)");
                                }
                                PurchaseButtonKt.m14087PurchaseButtonWHejsw(currentColors, state.getTemplateConfiguration().getPackages(), state.getSelectedPackage(), viewModel, f2, modifier2, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    colors3 = currentColors;
                } else {
                    modifier2 = companion;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                modifier2 = modifier;
            }
            f2 = fM13859getDefaultHorizontalPaddingD9Ej5fM;
            currentColors = colors2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            DisableTouchesComposableKt.DisableTouchesComposable(viewModel.getActionInProgress().getValue().booleanValue(), ComposableLambdaKt.rememberComposableLambda(22366153, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$1
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
                    ComposerKt.sourceInformation(composer2, "C62@3095L297:PurchaseButton.kt#51odh9");
                    if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(22366153, i7, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous> (PurchaseButton.kt:62)");
                        }
                        PurchaseButtonKt.m14087PurchaseButtonWHejsw(currentColors, state.getTemplateConfiguration().getPackages(), state.getSelectedPackage(), viewModel, f2, modifier2, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            colors3 = currentColors;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier;
            f2 = fM13859getDefaultHorizontalPaddingD9Ej5fM;
            colors3 = colors2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$2
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
                    PurchaseButtonKt.m14088PurchaseButtonhGBTI10(state, viewModel, modifier3, f2, colors3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x022b  */
    /* JADX INFO: renamed from: PurchaseButton-WH-ejsw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m14087PurchaseButtonWHejsw(final TemplateConfiguration.Colors colors, final TemplateConfiguration.PackageConfiguration packageConfiguration, final MutableState<TemplateConfiguration.PackageInfo> mutableState, final PaywallViewModel paywallViewModel, final float f, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Modifier modifier2;
        int currentCompositeKeyHash;
        Composer composerM7248constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        final Activity activity;
        final Modifier modifier3;
        Color colorM14204getCallToActionSecondaryBackgroundQN2ZGVo;
        Color colorM8138boximpl;
        boolean z;
        Object objRememberedValue;
        boolean zChangedInstance;
        Object objRememberedValue2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-366633237);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseButton)P(1,3,4,5,2:c#ui.unit.Dp)83@3765L4785:PurchaseButton.kt#51odh9");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(colors) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(packageConfiguration) ? 32 : 16;
            }
            if ((i2 & 4) == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i3 |= composerStartRestartGroup.changed(mutableState) ? 256 : 128;
            }
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= composerStartRestartGroup.changed(paywallViewModel) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= composerStartRestartGroup.changed(f) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    modifier2 = modifier;
                    i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
                }
                if ((74899 & i3) != 74898 || !composerStartRestartGroup.getSkipping()) {
                    Modifier.Companion companion = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-366633237, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton (PurchaseButton.kt:82)");
                    }
                    Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m2856paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), f, 0.0f, 2, null), TestTag.PURCHASE_BUTTON_TAG);
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1608511131, "C91@4088L7,93@4125L213,99@4371L188,107@4829L232,117@5303L552,129@5913L47,130@6005L5,145@6782L168,132@6053L691,149@6962L1582,114@5174L3370:PurchaseButton.kt#51odh9");
                    ProvidableCompositionLocal<Activity> localActivity = HelperFunctionsKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localActivity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    activity = (Activity) objConsume;
                    modifier3 = companion;
                    final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(!paywallViewModel.getActionInProgress().getValue().booleanValue() ? 0.0f : 1.0f, UIConstant.INSTANCE.defaultAnimation(), 0.0f, "PurchaseButton.label", null, composerStartRestartGroup, 3072, 20);
                    State<Color> stateM1865animateColorAsStateeuL9pac = SingleValueAnimationKt.m1865animateColorAsStateeuL9pac(colors.m14202getCallToActionBackground0d7_KjU(), UIConstant.INSTANCE.getDefaultColorAnimation(), "primaryCTAColor", null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 8);
                    Color colorM14204getCallToActionSecondaryBackgroundQN2ZGVo2 = colors.m14204getCallToActionSecondaryBackgroundQN2ZGVo();
                    State<Color> stateM1865animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m1865animateColorAsStateeuL9pac(colorM14204getCallToActionSecondaryBackgroundQN2ZGVo2 == null ? colorM14204getCallToActionSecondaryBackgroundQN2ZGVo2.m8158unboximpl() : colors.m14202getCallToActionBackground0d7_KjU(), UIConstant.INSTANCE.getDefaultColorAnimation(), "secondaryCTAColor", null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 8);
                    colorM14204getCallToActionSecondaryBackgroundQN2ZGVo = colors.m14204getCallToActionSecondaryBackgroundQN2ZGVo();
                    if (colorM14204getCallToActionSecondaryBackgroundQN2ZGVo == null) {
                        colorM14204getCallToActionSecondaryBackgroundQN2ZGVo.m8158unboximpl();
                        colorM8138boximpl = Color.m8138boximpl(PurchaseButton_WH_ejsw$lambda$6$lambda$2(stateM1865animateColorAsStateeuL9pac2));
                    } else {
                        colorM8138boximpl = null;
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
                    composerStartRestartGroup.startReplaceGroup(329017995);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PurchaseButton.kt#9igjgp");
                    int i5 = i3 & 896;
                    z = i5 != 256;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$1$1
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
                                TemplateConfiguration.PackageInfo value = mutableState.getValue();
                                SemanticsPropertiesKt.setText(semantics, new AnnotatedString(IntroEligibilityStateViewKt.introEligibilityText(PackageExtensionsKt.getOfferEligibility(value), value.getLocalization().getCallToActionWithIntroOffer(), value.getLocalization().getCallToActionWithMultipleIntroOffers(), value.getLocalization().getCallToAction()), null, null, 6, null));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    Modifier modifierBackground$default = BackgroundKt.background$default(SemanticsModifierKt.semantics(modifierFillMaxWidth$default, true, (Function1) objRememberedValue), m14090buttonBrushA47ccPs(PurchaseButton_WH_ejsw$lambda$6$lambda$1(stateM1865animateColorAsStateeuL9pac), colorM8138boximpl, composerStartRestartGroup, 0), ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, ButtonDefaults.$stable), 0.0f, 4, null);
                    ButtonColors buttonColorsM4676buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m4676buttonColorsro_MJ88(Color.INSTANCE.m8183getTransparent0d7_KjU(), colors.m14203getCallToActionForeground0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 12);
                    composerStartRestartGroup.startReplaceGroup(329042134);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PurchaseButton.kt#9igjgp");
                    zChangedInstance = (i5 != 256) | ((i3 & 7168) != 2048) | composerStartRestartGroup.changedInstance(activity);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$2$1
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
                                Package rcPackage = mutableState.getValue().getRcPackage();
                                paywallViewModel.trackComponentInteraction(PaywallComponentInteractionFactoriesKt.paywallPurchaseButtonAction(PaywallLegacyComponentInteraction.PURCHASE_BUTTON_NAME, PaywallLegacyComponentInteraction.Value.IN_APP_CHECKOUT, null, rcPackage.getIdentifier(), PaywallProductIdentifierKt.paywallProductIdentifier(rcPackage.getProduct())));
                                paywallViewModel.purchaseSelectedPackage(activity);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ButtonKt.Button((Function0) objRememberedValue2, modifierBackground$default, false, null, buttonColorsM4676buttonColorsro_MJ88, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1286977873, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                            invoke(rowScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope Button, Composer composer2, int i6) {
                            Intrinsics.checkNotNullParameter(Button, "$this$Button");
                            ComposerKt.sourceInformation(composer2, "C150@6976L1558:PurchaseButton.kt#51odh9");
                            if ((i6 & 17) != 16 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1286977873, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous>.<anonymous> (PurchaseButton.kt:150)");
                                }
                                Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3.1
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
                                TemplateConfiguration.PackageConfiguration packageConfiguration2 = packageConfiguration;
                                MutableState<TemplateConfiguration.PackageInfo> mutableState2 = mutableState;
                                final TemplateConfiguration.Colors colors2 = colors;
                                final State<Float> state = stateAnimateFloatAsState;
                                PaywallViewModel paywallViewModel2 = paywallViewModel;
                                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierClearAndSetSemantics);
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
                                Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM7248constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    composerM7248constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    composerM7248constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 974696953, "C157@7282L940,154@7135L1087,175@8240L280:PurchaseButton.kt#51odh9");
                                ConsistentPackageContentViewKt.ConsistentPackageContentView(packageConfiguration2.getAll(), mutableState2.getValue(), ComposableLambdaKt.rememberComposableLambda(98081200, true, new Function3<TemplateConfiguration.PackageInfo, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.PackageInfo packageInfo, Composer composer3, Integer num) {
                                        invoke(packageInfo, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(TemplateConfiguration.PackageInfo it, Composer composer3, int i7) {
                                        int i8;
                                        Intrinsics.checkNotNullParameter(it, "it");
                                        ComposerKt.sourceInformation(composer3, "C166@7872L10,159@7359L845:PurchaseButton.kt#51odh9");
                                        if ((i7 & 6) == 0) {
                                            i8 = i7 | (composer3.changed(it) ? 4 : 2);
                                        } else {
                                            i8 = i7;
                                        }
                                        if ((i8 & 19) != 18 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(98081200, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PurchaseButton.kt:158)");
                                            }
                                            ProcessedLocalizedConfiguration localization = it.getLocalization();
                                            IntroEligibilityStateViewKt.m14057IntroEligibilityStateViewQETHhvg(localization.getCallToAction(), localization.getCallToActionWithIntroOffer(), localization.getCallToActionWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(it), colors2.m14203getCallToActionForeground0d7_KjU(), MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), FontWeight.INSTANCE.getSemiBold(), TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), false, AlphaKt.alpha(PaddingKt.m2856paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(C1486Dp.m11017constructorimpl(UIConstant.INSTANCE.m13862getDefaultVerticalSpacingD9Ej5fM() * 2) / 3), 1, null), PurchaseButtonKt.PurchaseButton_WH_ejsw$lambda$6$lambda$0(state)), composer3, 102236160, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK);
                                Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierMatchParentSize);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor3);
                                } else {
                                    composer2.useNode();
                                }
                                Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composer2);
                                Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (composerM7248constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                    composerM7248constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                    composerM7248constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                }
                                Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1871273461, "C179@8424L78:PurchaseButton.kt#51odh9");
                                PurchaseButtonKt.LoadingSpinner(boxScopeInstance2, paywallViewModel2.getActionInProgress().getValue().booleanValue(), colors2, composer2, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 492);
                    composerStartRestartGroup = composerStartRestartGroup;
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
                    modifier3 = modifier2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            PurchaseButtonKt.m14087PurchaseButtonWHejsw(colors, packageConfiguration, mutableState, paywallViewModel, f, modifier3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
            modifier2 = modifier;
            if ((74899 & i3) != 74898) {
                if (i4 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                Modifier modifierTestTag2 = TestTagKt.testTag(PaddingKt.m2856paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), f, 0.0f, 2, null), TestTag.PURCHASE_BUTTON_TAG);
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1608511131, "C91@4088L7,93@4125L213,99@4371L188,107@4829L232,117@5303L552,129@5913L47,130@6005L5,145@6782L168,132@6053L691,149@6962L1582,114@5174L3370:PurchaseButton.kt#51odh9");
                    ProvidableCompositionLocal<Activity> localActivity2 = HelperFunctionsKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localActivity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    activity = (Activity) objConsume2;
                    modifier3 = companion;
                    final State<Float> stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!paywallViewModel.getActionInProgress().getValue().booleanValue() ? 0.0f : 1.0f, UIConstant.INSTANCE.defaultAnimation(), 0.0f, "PurchaseButton.label", null, composerStartRestartGroup, 3072, 20);
                    State<Color> stateM1865animateColorAsStateeuL9pac3 = SingleValueAnimationKt.m1865animateColorAsStateeuL9pac(colors.m14202getCallToActionBackground0d7_KjU(), UIConstant.INSTANCE.getDefaultColorAnimation(), "primaryCTAColor", null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 8);
                    Color colorM14204getCallToActionSecondaryBackgroundQN2ZGVo22 = colors.m14204getCallToActionSecondaryBackgroundQN2ZGVo();
                    State<Color> stateM1865animateColorAsStateeuL9pac22 = SingleValueAnimationKt.m1865animateColorAsStateeuL9pac(colorM14204getCallToActionSecondaryBackgroundQN2ZGVo22 == null ? colorM14204getCallToActionSecondaryBackgroundQN2ZGVo22.m8158unboximpl() : colors.m14202getCallToActionBackground0d7_KjU(), UIConstant.INSTANCE.getDefaultColorAnimation(), "secondaryCTAColor", null, composerStartRestartGroup, RendererCapabilities.DECODER_SUPPORT_MASK, 8);
                    colorM14204getCallToActionSecondaryBackgroundQN2ZGVo = colors.m14204getCallToActionSecondaryBackgroundQN2ZGVo();
                    if (colorM14204getCallToActionSecondaryBackgroundQN2ZGVo == null) {
                    }
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null);
                    composerStartRestartGroup.startReplaceGroup(329017995);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PurchaseButton.kt#9igjgp");
                    int i52 = i3 & 896;
                    if (i52 != 256) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$1$1
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
                                TemplateConfiguration.PackageInfo value = mutableState.getValue();
                                SemanticsPropertiesKt.setText(semantics, new AnnotatedString(IntroEligibilityStateViewKt.introEligibilityText(PackageExtensionsKt.getOfferEligibility(value), value.getLocalization().getCallToActionWithIntroOffer(), value.getLocalization().getCallToActionWithMultipleIntroOffers(), value.getLocalization().getCallToAction()), null, null, 6, null));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        composerStartRestartGroup.endReplaceGroup();
                        Modifier modifierBackground$default2 = BackgroundKt.background$default(SemanticsModifierKt.semantics(modifierFillMaxWidth$default2, true, (Function1) objRememberedValue), m14090buttonBrushA47ccPs(PurchaseButton_WH_ejsw$lambda$6$lambda$1(stateM1865animateColorAsStateeuL9pac3), colorM8138boximpl, composerStartRestartGroup, 0), ButtonDefaults.INSTANCE.getShape(composerStartRestartGroup, ButtonDefaults.$stable), 0.0f, 4, null);
                        ButtonColors buttonColorsM4676buttonColorsro_MJ882 = ButtonDefaults.INSTANCE.m4676buttonColorsro_MJ88(Color.INSTANCE.m8183getTransparent0d7_KjU(), colors.m14203getCallToActionForeground0d7_KjU(), 0L, 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 12) | 6, 12);
                        composerStartRestartGroup.startReplaceGroup(329042134);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):PurchaseButton.kt#9igjgp");
                        zChangedInstance = (i52 != 256) | ((i3 & 7168) != 2048) | composerStartRestartGroup.changedInstance(activity);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$2$1
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
                                    Package rcPackage = mutableState.getValue().getRcPackage();
                                    paywallViewModel.trackComponentInteraction(PaywallComponentInteractionFactoriesKt.paywallPurchaseButtonAction(PaywallLegacyComponentInteraction.PURCHASE_BUTTON_NAME, PaywallLegacyComponentInteraction.Value.IN_APP_CHECKOUT, null, rcPackage.getIdentifier(), PaywallProductIdentifierKt.paywallProductIdentifier(rcPackage.getProduct())));
                                    paywallViewModel.purchaseSelectedPackage(activity);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            composerStartRestartGroup.endReplaceGroup();
                            ButtonKt.Button((Function0) objRememberedValue2, modifierBackground$default2, false, null, buttonColorsM4676buttonColorsro_MJ882, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1286977873, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                                    invoke(rowScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope Button, Composer composer2, int i6) {
                                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                                    ComposerKt.sourceInformation(composer2, "C150@6976L1558:PurchaseButton.kt#51odh9");
                                    if ((i6 & 17) != 16 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1286977873, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous>.<anonymous> (PurchaseButton.kt:150)");
                                        }
                                        Modifier modifierClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3.1
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
                                        TemplateConfiguration.PackageConfiguration packageConfiguration2 = packageConfiguration;
                                        MutableState<TemplateConfiguration.PackageInfo> mutableState2 = mutableState;
                                        final TemplateConfiguration.Colors colors2 = colors;
                                        final State<Float> state = stateAnimateFloatAsState2;
                                        PaywallViewModel paywallViewModel2 = paywallViewModel;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap22 = composer2.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier22 = ComposedModifierKt.materializeModifier(composer2, modifierClearAndSetSemantics);
                                        Function0<ComposeUiNode> constructor22 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor22);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer2);
                                        Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap22, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM7248constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            composerM7248constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            composerM7248constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier22, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 974696953, "C157@7282L940,154@7135L1087,175@8240L280:PurchaseButton.kt#51odh9");
                                        ConsistentPackageContentViewKt.ConsistentPackageContentView(packageConfiguration2.getAll(), mutableState2.getValue(), ComposableLambdaKt.rememberComposableLambda(98081200, true, new Function3<TemplateConfiguration.PackageInfo, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt$PurchaseButton$3$3$2$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(TemplateConfiguration.PackageInfo packageInfo, Composer composer3, Integer num) {
                                                invoke(packageInfo, composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(TemplateConfiguration.PackageInfo it, Composer composer3, int i7) {
                                                int i8;
                                                Intrinsics.checkNotNullParameter(it, "it");
                                                ComposerKt.sourceInformation(composer3, "C166@7872L10,159@7359L845:PurchaseButton.kt#51odh9");
                                                if ((i7 & 6) == 0) {
                                                    i8 = i7 | (composer3.changed(it) ? 4 : 2);
                                                } else {
                                                    i8 = i7;
                                                }
                                                if ((i8 & 19) != 18 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(98081200, i8, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButton.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PurchaseButton.kt:158)");
                                                    }
                                                    ProcessedLocalizedConfiguration localization = it.getLocalization();
                                                    IntroEligibilityStateViewKt.m14057IntroEligibilityStateViewQETHhvg(localization.getCallToAction(), localization.getCallToActionWithIntroOffer(), localization.getCallToActionWithMultipleIntroOffers(), PackageExtensionsKt.getOfferEligibility(it), colors2.m14203getCallToActionForeground0d7_KjU(), MaterialTheme.INSTANCE.getTypography(composer3, MaterialTheme.$stable).getTitleMedium(), FontWeight.INSTANCE.getSemiBold(), TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), false, AlphaKt.alpha(PaddingKt.m2856paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(C1486Dp.m11017constructorimpl(UIConstant.INSTANCE.m13862getDefaultVerticalSpacingD9Ej5fM() * 2) / 3), 1, null), PurchaseButtonKt.PurchaseButton_WH_ejsw$lambda$6$lambda$0(state)), composer3, 102236160, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }, composer2, 54), composer2, RendererCapabilities.DECODER_SUPPORT_MASK);
                                        Modifier modifierMatchParentSize = boxScopeInstance.matchParentSize(Modifier.INSTANCE);
                                        ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierMatchParentSize);
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor3);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composer2);
                                        Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM7248constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM7248constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            composerM7248constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            composerM7248constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 1871273461, "C179@8424L78:PurchaseButton.kt#51odh9");
                                        PurchaseButtonKt.LoadingSpinner(boxScopeInstance2, paywallViewModel2.getActionInProgress().getValue().booleanValue(), colors2, composer2, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306368, 492);
                            composerStartRestartGroup = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                    }
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        if ((i2 & 4) == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        modifier2 = modifier;
        if ((74899 & i3) != 74898) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /* JADX INFO: renamed from: buttonBrush-A47ccPs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Brush m14090buttonBrushA47ccPs(long j, Color color, Composer composer, int i) {
        SolidColor solidColor;
        ComposerKt.sourceInformationMarkerStart(composer, -58833710, "C(buttonBrush)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color):PurchaseButton.kt#51odh9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-58833710, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.buttonBrush (PurchaseButton.kt:188)");
        }
        if (color != null) {
            solidColor = Brush.Companion.m8103verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m8138boximpl(j), Color.m8138boximpl(color.m8158unboximpl())}), 0.0f, 0.0f, 0, 14, (Object) null);
            if (solidColor == null) {
                solidColor = new SolidColor(j, null);
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return solidColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadingSpinner(final BoxScope boxScope, boolean z, final TemplateConfiguration.Colors colors, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-268216038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LoadingSpinner)P(1)207@9274L160,201@8974L460:PurchaseButton.kt#51odh9");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(colors) ? 256 : 128;
        }
        if ((i2 & 147) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-268216038, i2, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.LoadingSpinner (PurchaseButton.kt:200)");
            }
            z2 = z;
            AnimatedVisibilityKt.AnimatedVisibility(z2, boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), EnterExitTransitionKt.fadeIn$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), EnterExitTransitionKt.fadeOut$default(UIConstant.INSTANCE.defaultAnimation(), 0.0f, 2, null), "PurchaseButton.LoadingSpinner", ComposableLambdaKt.rememberComposableLambda(-1498164238, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.LoadingSpinner.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt.sourceInformation(composer2, "C208@9284L144:PurchaseButton.kt#51odh9");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1498164238, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.LoadingSpinner.<anonymous> (PurchaseButton.kt:208)");
                    }
                    ProgressIndicatorKt.m5449CircularProgressIndicatorLxG7B9w(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), colors.m14203getCallToActionForeground0d7_KjU(), 0.0f, 0L, 0, composer2, 0, 28);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 3) & 14) | 221184, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z2 = z;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.LoadingSpinner.2
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
                    PurchaseButtonKt.LoadingSpinner(boxScope, z2, colors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchaseButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1498117025);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PurchaseButtonPreview)222@9697L87:PurchaseButton.kt#51odh9");
        if (i != 0 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1498117025, i, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonPreview (PurchaseButton.kt:217)");
            }
            MockViewModel mockViewModel = new MockViewModel(null, TestData.INSTANCE.getTemplate2Offering(), null, true, false, null, 53, null);
            PaywallState.Loaded.Legacy legacyLoadedLegacyState = mockViewModel.loadedLegacyState();
            if (legacyLoadedLegacyState != null) {
                m14088PurchaseButtonhGBTI10(legacyLoadedLegacyState, mockViewModel, null, 0.0f, null, composerStartRestartGroup, 0, 28);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PurchaseButtonKt.PurchaseButtonPreview.1
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
                    PurchaseButtonKt.PurchaseButtonPreview(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float PurchaseButton_WH_ejsw$lambda$6$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long PurchaseButton_WH_ejsw$lambda$6$lambda$1(State<Color> state) {
        return state.getValue().m8158unboximpl();
    }

    private static final long PurchaseButton_WH_ejsw$lambda$6$lambda$2(State<Color> state) {
        return state.getValue().m8158unboximpl();
    }
}
