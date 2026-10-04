package com.myscript.nebo.p034ui.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.Html_androidKt;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
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
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.window.core.layout.WindowSizeClass;
import com.myscript.android.utils.p019ui.compose.AdaptiveModalDialogKt;
import com.myscript.android.utils.p019ui.compose.ButtonsKt;
import com.myscript.nebo.C6079R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataCollectDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a\r\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, m1599d2 = {"DataCollectDialog", "", "showPopup", "", "onEnable", "Lkotlin/Function0;", "onDismissDialog", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DataCollectDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DataCollectDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DataCollectDialog$lambda$2(boolean z, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        DataCollectDialog(z, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DataCollectDialogPreview$lambda$2(int i, Composer composer, int i2) {
        DataCollectDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DataCollectDialog(boolean z, final Function0<Unit> onEnable, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        final boolean z2;
        final Function0<Unit> function02;
        Function0<Unit> function03;
        Intrinsics.checkNotNullParameter(onEnable, "onEnable");
        Composer composerStartRestartGroup = composer.startRestartGroup(1273973566);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DataCollectDialog)N(showPopup,onEnable,onDismissDialog)34@1362L2,39@1499L1919,36@1373L2045:DataCollectDialog.kt#h09ego");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onEnable) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z2 = z;
            function02 = function0;
        } else {
            boolean z3 = i4 != 0 ? false : z;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 222921248, "CC(remember):DataCollectDialog.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.ui.compose.DataCollectDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function03 = (Function0) objRememberedValue;
            } else {
                function03 = function0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1273973566, i3, -1, "com.myscript.nebo.ui.compose.DataCollectDialog (DataCollectDialog.kt:35)");
            }
            AdaptiveModalDialogKt.AdaptiveModalDialog(z3, function03, false, ComposableLambdaKt.rememberComposableLambda(345917508, true, new Function5() { // from class: com.myscript.nebo.ui.compose.DataCollectDialogKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function5
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    return DataCollectDialogKt.DataCollectDialog$lambda$1(onEnable, (BoxScope) obj, ((Boolean) obj2).booleanValue(), (Function0) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 3456 | ((i3 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z2 = z3;
            function02 = function03;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.DataCollectDialogKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataCollectDialogKt.DataCollectDialog$lambda$2(z2, onEnable, function02, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void DataCollectDialogPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1917481786);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DataCollectDialogPreview)89@3544L2,90@3574L2,87@3480L102:DataCollectDialog.kt#h09ego");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1917481786, i, -1, "com.myscript.nebo.ui.compose.DataCollectDialogPreview (DataCollectDialog.kt:86)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -159023128, "CC(remember):DataCollectDialog.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ui.compose.DataCollectDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -159022168, "CC(remember):DataCollectDialog.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.DataCollectDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            DataCollectDialog(true, function0, (Function0) objRememberedValue2, composerStartRestartGroup, 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.DataCollectDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DataCollectDialogKt.DataCollectDialogPreview$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DataCollectDialog$lambda$1(Function0 function0, BoxScope AdaptiveModalDialog, boolean z, Function0 onDismiss, Composer composer, int i) {
        int i2;
        TextStyle displaySmall;
        TextStyle bodyLarge;
        Intrinsics.checkNotNullParameter(AdaptiveModalDialog, "$this$AdaptiveModalDialog");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        ComposerKt.sourceInformation(composer, "CN(isCompact,onDismiss)47@1967L1445:DataCollectDialog.kt#h09ego");
        if ((i & 48) == 0) {
            i2 = i | (composer.changed(z) ? 32 : 16);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 1041) != 1040, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(345917508, i2, -1, "com.myscript.nebo.ui.compose.DataCollectDialog.<anonymous> (DataCollectDialog.kt:41)");
            }
            float fM11017constructorimpl = C1486Dp.m11017constructorimpl(z ? 32 : 48);
            float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(z ? 24 : 32);
            float fM11017constructorimpl3 = C1486Dp.m11017constructorimpl(z ? 16 : 24);
            if (z) {
                composer.startReplaceGroup(1714252369);
                ComposerKt.sourceInformation(composer, "44@1768L10");
                displaySmall = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineSmall();
            } else {
                composer.startReplaceGroup(1714253776);
                ComposerKt.sourceInformation(composer, "44@1812L10");
                displaySmall = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getDisplaySmall();
            }
            composer.endReplaceGroup();
            TextStyle textStyle = displaySmall;
            if (z) {
                composer.startReplaceGroup(1714256462);
                ComposerKt.sourceInformation(composer, "45@1896L10");
                bodyLarge = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium();
            } else {
                composer.startReplaceGroup(1714257773);
                ComposerKt.sourceInformation(composer, "45@1937L10");
                bodyLarge = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge();
            }
            composer.endReplaceGroup();
            TextStyle textStyle2 = bodyLarge;
            Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(z ? 600 : WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND), 1, null), fM11017constructorimpl2, fM11017constructorimpl);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(fM11017constructorimpl3);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2855paddingVpY3zN4);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1332544014, "C56@2400L40,54@2307L206,60@2555L50,61@2645L11,59@2526L272,67@2899L56,69@3014L11,65@2811L382,75@3207L195:DataCollectDialog.kt#h09ego");
            ImageKt.Image(PainterResources_androidKt.painterResource(C6079R.drawable.data_collect, composer, 0), "data collect icon", SizeKt.m2912heightInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(PsExtractor.VIDEO_STREAM_MASK), 1, null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composer, Painter.$stable | 432, 120);
            TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(C6079R.string.data_collect_dialog_title, composer, 0), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), null, 0L, null, null, null, 0L, null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TextStyle.m10466copyp1EtxEg$default(textStyle, 0L, 0L, FontWeight.INSTANCE.getBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 130042);
            TextKt.m5871TextZ58ophY(Html_androidKt.fromHtml$default(AnnotatedString.INSTANCE, StringResources_androidKt.stringResource(C6079R.string.data_collect_dialog_description, composer, 0), null, null, 6, null), null, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), 0.48f, 0.0f, 0.0f, 0.0f, 14, null), null, 0L, null, null, null, 0L, null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), TextUnitKt.getSp(24), 0, false, 0, 0, null, null, textStyle2, composer, 0, 48, 259066);
            ButtonsKt.LargeButton(C6079R.string.data_collect_dialog_button, SizeKt.m2910height3ABfNKs(SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(SensibleDefaults.X_OFFSET), 0.0f, 2, null), C1486Dp.m11017constructorimpl(40)), function0, composer, 48);
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
}
