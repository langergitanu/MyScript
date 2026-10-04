package com.myscript.nebo.p022ai.presentation.compose.components;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
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
import com.myscript.nebo.p022ai.presentation.QuizSourceAction;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ChooseNoteDropDownMenu.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, m1599d2 = {"ChooseNoteDropDownMenu", "", "quizSourceActions", "", "Lcom/myscript/nebo/ai/presentation/QuizSourceAction;", "onOptionSelected", "Lkotlin/Function1;", "closeClick", "Lkotlin/Function0;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "nebo-ai_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChooseNoteDropDownMenuKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChooseNoteDropDownMenu$lambda$1(List list, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        ChooseNoteDropDownMenu(list, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ChooseNoteDropDownMenu(final List<? extends QuizSourceAction> quizSourceActions, final Function1<? super QuizSourceAction, Unit> onOptionSelected, final Function0<Unit> closeClick, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(quizSourceActions, "quizSourceActions");
        Intrinsics.checkNotNullParameter(onOptionSelected, "onOptionSelected");
        Intrinsics.checkNotNullParameter(closeClick, "closeClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1651294015);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChooseNoteDropDownMenu)N(quizSourceActions,onOptionSelected,closeClick)26@957L1246:ChooseNoteDropDownMenu.kt#ysqczk");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(quizSourceActions) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onOptionSelected) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(closeClick) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651294015, i2, -1, "com.myscript.nebo.ai.presentation.compose.components.ChooseNoteDropDownMenu (ChooseNoteDropDownMenu.kt:25)");
            }
            Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getBottomEnd(), false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWrapContentSize$default);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -585616256, "C32@1144L16,33@1171L1027,30@1070L1128:ChooseNoteDropDownMenu.kt#ysqczk");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2097099573, "CC(remember):ChooseNoteDropDownMenu.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.ChooseNoteDropDownMenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChooseNoteDropDownMenuKt.ChooseNoteDropDownMenu$lambda$0$0$0(closeClick);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidMenu_androidKt.m4104DropdownMenu4kj_NE(true, (Function0) objRememberedValue, null, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(2028399080, true, new Function3() { // from class: com.myscript.nebo.ai.presentation.compose.components.ChooseNoteDropDownMenuKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChooseNoteDropDownMenuKt.ChooseNoteDropDownMenu$lambda$0$1(quizSourceActions, onOptionSelected, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572870, 60);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.ai.presentation.compose.components.ChooseNoteDropDownMenuKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChooseNoteDropDownMenuKt.ChooseNoteDropDownMenu$lambda$1(quizSourceActions, onOptionSelected, closeClick, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChooseNoteDropDownMenu$lambda$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChooseNoteDropDownMenu$lambda$0$1(List list, final Function1 function1, ColumnScope DropdownMenu, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C*37@1351L72,35@1239L252:ChooseNoteDropDownMenu.kt#ysqczk");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2028399080, i, -1, "com.myscript.nebo.ai.presentation.compose.components.ChooseNoteDropDownMenu.<anonymous>.<anonymous> (ChooseNoteDropDownMenu.kt:34)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final QuizSourceAction quizSourceAction = (QuizSourceAction) it.next();
                int drawableResId = quizSourceAction.getDrawableResId();
                int labelResId = quizSourceAction.getLabelResId();
                ComposerKt.sourceInformationMarkerStart(composer, 1873421803, "CC(remember):ChooseNoteDropDownMenu.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changed(quizSourceAction);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.ai.presentation.compose.components.ChooseNoteDropDownMenuKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ChooseNoteDropDownMenuKt.ChooseNoteDropDownMenu$lambda$0$1$0$0$0(function1, quizSourceAction);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                AIDropdownMenuKt.DropdownMenuItemWithIcon((Function0<Unit>) objRememberedValue, labelResId, (ImageVector) null, Integer.valueOf(drawableResId), false, false, composer, 0, 52);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChooseNoteDropDownMenu$lambda$0$1$0$0$0(Function1 function1, QuizSourceAction quizSourceAction) {
        function1.invoke(quizSourceAction);
        return Unit.INSTANCE;
    }
}
