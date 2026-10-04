package com.myscript.nebo.p034ui.compose;

import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorFilter;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.p004ui.unit.TextUnitKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.myscript.android.utils.p019ui.compose.AdaptiveModalDialogKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RenewalOffer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a\r\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\n\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\u000b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\t\u001a\r\u0010\f\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\t¨\u0006\r"}, m1599d2 = {"RenewalOfferDialog", "", "show", "", "onConfirm", "Lkotlin/Function0;", "onDismiss", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "RenewalOfferDialogPhonePreview", "(Landroidx/compose/runtime/Composer;I)V", "RenewalOfferDialogTabletPreview", "RenewalOfferDialogPhoneLandscapePreview", "RenewalOfferDialogTabletPortraitPreview", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RenewalOfferKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenewalOfferDialog$lambda$3(boolean z, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        RenewalOfferDialog(z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenewalOfferDialogPhoneLandscapePreview$lambda$0(int i, Composer composer, int i2) {
        RenewalOfferDialogPhoneLandscapePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenewalOfferDialogPhonePreview$lambda$0(int i, Composer composer, int i2) {
        RenewalOfferDialogPhonePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenewalOfferDialogTabletPortraitPreview$lambda$0(int i, Composer composer, int i2) {
        RenewalOfferDialogTabletPortraitPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenewalOfferDialogTabletPreview$lambda$0(int i, Composer composer, int i2) {
        RenewalOfferDialogTabletPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RenewalOfferDialog(final boolean z, final Function0<Unit> function0, final Function0<Unit> function02, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1065385476);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RenewalOfferDialog)N(show,onConfirm,onDismiss)43@1857L2,44@1889L2,46@1948L11,46@1969L2549,46@1900L2618:RenewalOffer.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1633228262, "CC(remember):RenewalOffer.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.ui.compose.RenewalOfferKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1633229286, "CC(remember):RenewalOffer.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.RenewalOfferKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function02 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1065385476, i3, -1, "com.myscript.nebo.ui.compose.RenewalOfferDialog (RenewalOffer.kt:45)");
            }
            ThemeKt.m13016NeboDialogThemeeopBjH0(false, 0L, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), ComposableLambdaKt.rememberComposableLambda(308631283, true, new Function2() { // from class: com.myscript.nebo.ui.compose.RenewalOfferKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RenewalOfferKt.RenewalOfferDialog$lambda$2(z, function02, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Function0<Unit> function03 = function0;
        final Function0<Unit> function04 = function02;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.RenewalOfferKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RenewalOfferKt.RenewalOfferDialog$lambda$3(z, function03, function04, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenewalOfferDialog$lambda$2(boolean z, Function0 function0, final Function0 function02, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C51@2115L2397,47@1979L2533:RenewalOffer.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(308631283, i, -1, "com.myscript.nebo.ui.compose.RenewalOfferDialog.<anonymous> (RenewalOffer.kt:47)");
            }
            AdaptiveModalDialogKt.AdaptiveModalDialog(z, function0, false, ComposableLambdaKt.rememberComposableLambda(205179821, true, new Function5() { // from class: com.myscript.nebo.ui.compose.RenewalOfferKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function5
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    return RenewalOfferKt.RenewalOfferDialog$lambda$2$0(function02, (BoxScope) obj, ((Boolean) obj2).booleanValue(), (Function0) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composer, 54), composer, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RenewalOfferDialog$lambda$2$0(Function0 function0, BoxScope AdaptiveModalDialog, boolean z, Function0 unused$var$, Composer composer, int i) {
        int i2;
        Modifier modifierAspectRatio$default;
        Intrinsics.checkNotNullParameter(AdaptiveModalDialog, "$this$AdaptiveModalDialog");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        ComposerKt.sourceInformation(composer, "CN(isCompact)62@2475L2027:RenewalOffer.kt#h09ego");
        if ((i & 48) == 0) {
            i2 = i | (composer.changed(z) ? 32 : 16);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 1041) != 1040, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(205179821, i2, -1, "com.myscript.nebo.ui.compose.RenewalOfferDialog.<anonymous>.<anonymous> (RenewalOffer.kt:53)");
            }
            if (z) {
                modifierAspectRatio$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            } else {
                modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(600)), 1.5f, false, 2, null);
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAspectRatio$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1236416190, "C64@2559L54,63@2522L269,70@2809L1679:RenewalOffer.kt#h09ego");
            ImageKt.Image(PainterResources_androidKt.painterResource(C6079R.drawable.renewal_offer_illustration, composer, 0), (String) null, boxScopeInstance.matchParentSize(Modifier.INSTANCE), (Alignment) null, ContentScale.INSTANCE.getCrop(), 0.0f, (ColorFilter) null, composer, Painter.$stable | 24624, 104);
            float f = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            Alignment.Horizontal start = Alignment.INSTANCE.getStart();
            float f2 = 24;
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomStart()), C1486Dp.m11017constructorimpl(f2));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, start, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM2854padding3ABfNKs);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -640446860, "C78@3157L51,79@3256L10,77@3120L418,87@3597L53,88@3698L10,86@3560L293,97@4109L48,93@3875L595:RenewalOffer.kt#h09ego");
            String strStringResource = StringResources_androidKt.stringResource(C6079R.string.renewal_offer_dialog_title, composer, 0);
            TextStyle headlineMedium = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineMedium();
            float f3 = 400;
            TextKt.m5870TextNvy7gAk(strStringResource, SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(f3), 1, null), Color.INSTANCE.m8185getWhite0d7_KjU(), null, z ? TextUnitKt.getSp(24) : TextUnitKt.getSp(28), null, FontWeight.INSTANCE.getBlack(), null, 0L, null, null, 0L, 0, false, 0, 0, null, headlineMedium, composer, 1573296, 0, 130984);
            TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(C6079R.string.renewal_offer_dialog_message, composer, 0), SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(f3), 1, null), Color.INSTANCE.m8185getWhite0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 432, 0, 131064);
            ButtonKt.OutlinedButton(function0, PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(f), 0.0f, 0.0f, 13, null), false, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f2)), ButtonDefaults.INSTANCE.m4686outlinedButtonColorsro_MJ88(0L, Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, 0L, composer, (ButtonDefaults.$stable << 12) | 48, 13), null, BorderStrokeKt.m2051BorderStrokecXLIe8U(C1486Dp.m11017constructorimpl(2), Color.INSTANCE.m8185getWhite0d7_KjU()), null, null, ComposableSingletons$RenewalOfferKt.INSTANCE.m13444getLambda$754074725$app_standardRelease(), composer, 806879280, 420);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void RenewalOfferDialogPhonePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-844533150);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RenewalOfferDialogPhonePreview)116@4760L31:RenewalOffer.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-844533150, i, -1, "com.myscript.nebo.ui.compose.RenewalOfferDialogPhonePreview (RenewalOffer.kt:115)");
            }
            RenewalOfferDialog(true, null, null, composerStartRestartGroup, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.RenewalOfferKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RenewalOfferKt.RenewalOfferDialogPhonePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void RenewalOfferDialogTabletPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-196062538);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RenewalOfferDialogTabletPreview)122@4908L31:RenewalOffer.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-196062538, i, -1, "com.myscript.nebo.ui.compose.RenewalOfferDialogTabletPreview (RenewalOffer.kt:121)");
            }
            RenewalOfferDialog(true, null, null, composerStartRestartGroup, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.RenewalOfferKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RenewalOfferKt.RenewalOfferDialogTabletPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void RenewalOfferDialogPhoneLandscapePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1662832433);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RenewalOfferDialogPhoneLandscapePreview)130@5230L31:RenewalOffer.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1662832433, i, -1, "com.myscript.nebo.ui.compose.RenewalOfferDialogPhoneLandscapePreview (RenewalOffer.kt:129)");
            }
            RenewalOfferDialog(true, null, null, composerStartRestartGroup, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.RenewalOfferKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RenewalOfferKt.RenewalOfferDialogPhoneLandscapePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void RenewalOfferDialogTabletPortraitPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1019114213);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RenewalOfferDialogTabletPortraitPreview)136@5396L31:RenewalOffer.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1019114213, i, -1, "com.myscript.nebo.ui.compose.RenewalOfferDialogTabletPortraitPreview (RenewalOffer.kt:135)");
            }
            RenewalOfferDialog(true, null, null, composerStartRestartGroup, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.RenewalOfferKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RenewalOfferKt.RenewalOfferDialogTabletPortraitPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
