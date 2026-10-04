package com.myscript.nebo.p034ui.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.RadioButtonDefaults;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.ColorResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.myscript.android.utils.p019ui.compose.AdaptiveModalDialogKt;
import com.myscript.android.utils.p019ui.compose.ButtonsKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.dms.core.PdfOptimizationLevel;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfOptimization.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\t\u001a7\u0010\n\u001a\u00020\u00012\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0006X\u008a\u008e\u0002"}, m1599d2 = {"PdfOptimizationDialog", "", "show", "", "onConfirm", "Lkotlin/Function1;", "Lcom/myscript/nebo/dms/core/PdfOptimizationLevel;", "onDismiss", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PdfLevelRow", "title", "", "description", "selected", "onSelect", "(IIZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_standardRelease", "selectedLevel"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PdfOptimizationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfLevelRow$lambda$1(int i, int i2, boolean z, Function0 function0, int i3, Composer composer, int i4) {
        PdfLevelRow(i, i2, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfOptimizationDialog$lambda$3(boolean z, Function1 function1, Function0 function0, int i, int i2, Composer composer, int i3) {
        PdfOptimizationDialog(z, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfOptimizationDialog$lambda$0$0(PdfOptimizationLevel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void PdfOptimizationDialog(final boolean z, final Function1<? super PdfOptimizationLevel, Unit> function1, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(284802823);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PdfOptimizationDialog)N(show,onConfirm,onDismiss)47@2020L2,48@2052L2,51@2100L34,52@2176L11,53@2202L3227,50@2063L3366:PdfOptimization.kt#h09ego");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 147) != 146, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1182391031, "CC(remember):PdfOptimization.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PdfOptimizationKt.PdfOptimizationDialog$lambda$0$0((PdfOptimizationLevel) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1182390007, "CC(remember):PdfOptimization.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(284802823, i3, -1, "com.myscript.nebo.ui.compose.PdfOptimizationDialog (PdfOptimization.kt:49)");
            }
            ThemeKt.m13016NeboDialogThemeeopBjH0(false, ColorResources_androidKt.colorResource(C6079R.color.brand_color, composerStartRestartGroup, 0), MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurface(), ComposableLambdaKt.rememberComposableLambda(-842143562, true, new Function2() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfOptimizationKt.PdfOptimizationDialog$lambda$2(z, function0, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Function1<? super PdfOptimizationLevel, Unit> function12 = function1;
        final Function0<Unit> function02 = function0;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfOptimizationKt.PdfOptimizationDialog$lambda$3(z, function12, function02, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfOptimizationDialog$lambda$2(boolean z, Function0 function0, final Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C58@2347L3076,54@2212L3211:PdfOptimization.kt#h09ego");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-842143562, i, -1, "com.myscript.nebo.ui.compose.PdfOptimizationDialog.<anonymous> (PdfOptimization.kt:54)");
            }
            AdaptiveModalDialogKt.AdaptiveModalDialog(z, function0, true, ComposableLambdaKt.rememberComposableLambda(369322480, true, new Function5() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function5
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    return PdfOptimizationKt.PdfOptimizationDialog$lambda$2$0(function1, (BoxScope) obj, ((Boolean) obj2).booleanValue(), (Function0) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, composer, 54), composer, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final PdfOptimizationLevel PdfOptimizationDialog$lambda$2$0$1(MutableState<PdfOptimizationLevel> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfOptimizationDialog$lambda$2$0$3$0$0$0(MutableState mutableState) {
        mutableState.setValue(PdfOptimizationLevel.BEST_QUALITY);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfOptimizationDialog$lambda$2$0$3$0$1$0(MutableState mutableState) {
        mutableState.setValue(PdfOptimizationLevel.BALANCED);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfOptimizationDialog$lambda$2$0$3$0$2$0(MutableState mutableState) {
        mutableState.setValue(PdfOptimizationLevel.BEST_PERFORMANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfOptimizationDialog$lambda$2$0$3$1$0(Function1 function1, MutableState mutableState) {
        function1.invoke(PdfOptimizationDialog$lambda$2$0$1(mutableState));
        return Unit.INSTANCE;
    }

    private static final void PdfLevelRow(final int i, final int i2, final boolean z, final Function0<Unit> function0, Composer composer, final int i3) {
        int i4;
        Function0<Unit> function02;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1412266273);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PdfLevelRow)N(title,description,selected,onSelect)132@5586L882:PdfOptimization.kt#h09ego");
        if ((i3 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i2) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            function02 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        if (!composerStartRestartGroup.shouldExecute((i4 & 1171) != 1170, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1412266273, i4, -1, "com.myscript.nebo.ui.compose.PdfLevelRow (PdfOptimization.kt:131)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            float f = 12;
            Modifier modifierM2856paddingVpY3zN4$default = PaddingKt.m2856paddingVpY3zN4$default(SelectableKt.m3200selectableoSLSa3U$default(Modifier.INSTANCE, z, false, null, null, function02, 14, null), 0.0f, C1486Dp.m11017constructorimpl(f), 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2856paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 263629539, "C141@5933L34,141@5910L58,138@5795L183,144@5988L474:PdfOptimization.kt#h09ego");
            int i5 = i4;
            RadioButtonKt.RadioButton(z, null, null, false, RadioButtonDefaults.INSTANCE.m5470colorsro_MJ88(ColorResources_androidKt.colorResource(C6079R.color.brand_color, composerStartRestartGroup, 0), 0L, 0L, 0L, composerStartRestartGroup, RadioButtonDefaults.$stable << 12, 14), null, composerStartRestartGroup, ((i5 >> 6) & 14) | 48, 44);
            Modifier modifierM2858paddingqDBjuR0$default = PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f), 0.0f, 0.0f, 0.0f, 14, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2858paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM7248constructorimpl2 = Updater.m7248constructorimpl(composerStartRestartGroup);
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -889996871, "C146@6082L21,147@6143L10,148@6205L11,145@6053L187,151@6282L27,152@6349L10,153@6410L11,150@6253L199:PdfOptimization.kt#h09ego");
            composer2 = composerStartRestartGroup;
            TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(i, composerStartRestartGroup, i5 & 14), null, MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getOnSurface(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleMedium(), composer2, 0, 0, 131066);
            TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(i2, composer2, (i5 >> 3) & 14), null, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer2, MaterialTheme.$stable).getBodyMedium(), composer2, 0, 0, 131066);
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
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PdfOptimizationKt.PdfLevelRow$lambda$1(i, i2, z, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PdfOptimizationDialog$lambda$2$0(final Function1 function1, BoxScope AdaptiveModalDialog, boolean z, Function0 unused$var$, Composer composer, int i) {
        int i2;
        final MutableState mutableState;
        Intrinsics.checkNotNullParameter(AdaptiveModalDialog, "$this$AdaptiveModalDialog");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        ComposerKt.sourceInformation(composer, "CN(isCompact)66@2756L58,68@2828L2585:PdfOptimization.kt#h09ego");
        if ((i & 48) == 0) {
            i2 = i | (composer.changed(z) ? 32 : 16);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 1041) != 1040, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(369322480, i2, -1, "com.myscript.nebo.ui.compose.PdfOptimizationDialog.<anonymous>.<anonymous> (PdfOptimization.kt:60)");
            }
            float fM11017constructorimpl = C1486Dp.m11017constructorimpl(z ? 24 : 32);
            float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(z ? 24 : 48);
            float fM11017constructorimpl3 = C1486Dp.m11017constructorimpl(z ? 16 : 20);
            float fM11017constructorimpl4 = C1486Dp.m11017constructorimpl(z ? 60 : 70);
            ComposerKt.sourceInformationMarkerStart(composer, -1563369142, "CC(remember):PdfOptimization.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(PdfOptimizationLevel.BALANCED, null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(fM11017constructorimpl3);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierM2857paddingqDBjuR0 = PaddingKt.m2857paddingqDBjuR0(Modifier.INSTANCE, fM11017constructorimpl2, fM11017constructorimpl4, fM11017constructorimpl2, fM11017constructorimpl);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2857paddingqDBjuR0);
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
            ComposerKt.sourceInformationMarkerStart(composer, -889590727, "C79@3284L53,81@3431L10,82@3496L11,78@3251L347,86@3616L1196,110@4986L28,107@4830L202,114@5083L49,116@5226L10,117@5290L11,113@5050L349:PdfOptimization.kt#h09ego");
            float f = 360;
            TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(C6079R.string.pdf_optim_modal_presentation, composer, 0), SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(f), 1, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurface(), null, 0L, null, null, null, 0L, null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 48, 0, 130040);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -950049782, "C91@3939L53,87@3645L369,97@4317L49,93@4035L353,103@4715L57,99@4409L385:PdfOptimization.kt#h09ego");
            int i3 = C6079R.string.pdf_optim_level_best_quality_title;
            int i4 = C6079R.string.pdf_optim_level_best_quality_desc;
            boolean z2 = PdfOptimizationDialog$lambda$2$0$1(mutableState2) == PdfOptimizationLevel.BEST_QUALITY;
            ComposerKt.sourceInformationMarkerStart(composer, 246456209, "CC(remember):PdfOptimization.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableState = mutableState2;
                objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PdfOptimizationKt.PdfOptimizationDialog$lambda$2$0$3$0$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            } else {
                mutableState = mutableState2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PdfLevelRow(i3, i4, z2, (Function0) objRememberedValue2, composer, 3072);
            int i5 = C6079R.string.pdf_optim_level_balanced_title;
            int i6 = C6079R.string.pdf_optim_level_balanced_desc;
            boolean z3 = PdfOptimizationDialog$lambda$2$0$1(mutableState) == PdfOptimizationLevel.BALANCED;
            ComposerKt.sourceInformationMarkerStart(composer, 246468301, "CC(remember):PdfOptimization.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PdfOptimizationKt.PdfOptimizationDialog$lambda$2$0$3$0$1$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PdfLevelRow(i5, i6, z3, (Function0) objRememberedValue3, composer, 3072);
            int i7 = C6079R.string.pdf_optim_level_best_performance_title;
            int i8 = C6079R.string.pdf_optim_level_best_performance_desc;
            boolean z4 = PdfOptimizationDialog$lambda$2$0$1(mutableState) == PdfOptimizationLevel.BEST_PERFORMANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 246481045, "CC(remember):PdfOptimization.kt#9igjgp");
            Object objRememberedValue4 = composer.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PdfOptimizationKt.PdfOptimizationDialog$lambda$2$0$3$0$2$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            PdfLevelRow(i7, i8, z4, (Function0) objRememberedValue4, composer, 3072);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            int i9 = C6079R.string.pdf_optim_modal_cta;
            Modifier modifierM2929width3ABfNKs = SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(280));
            ComposerKt.sourceInformationMarkerStart(composer, 1218282914, "CC(remember):PdfOptimization.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.myscript.nebo.ui.compose.PdfOptimizationKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PdfOptimizationKt.PdfOptimizationDialog$lambda$2$0$3$1$0(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonsKt.LargeButton(i9, modifierM2929width3ABfNKs, (Function0) objRememberedValue5, composer, 48);
            TextKt.m5870TextNvy7gAk(StringResources_androidKt.stringResource(C6079R.string.pdf_optim_modal_footnote, composer, 0), SizeKt.m2931widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(f), 1, null), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 48, 0, 130040);
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
