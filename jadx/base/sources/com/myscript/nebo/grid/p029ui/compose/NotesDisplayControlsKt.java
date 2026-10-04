package com.myscript.nebo.grid.p029ui.compose;

import android.content.Context;
import androidx.appcompat.C0028R;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.grid.GridViewModel;
import com.myscript.nebo.grid.Order;
import com.myscript.nebo.grid.Sort;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: notesDisplayControls.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, m1599d2 = {"setNotesDisplayControlsContent", "", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "gridViewModel", "Lcom/myscript/nebo/grid/GridViewModel;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NotesDisplayControlsKt {
    public static final void setNotesDisplayControlsContent(final ComposeView composeView, final GridViewModel gridViewModel) {
        Intrinsics.checkNotNullParameter(composeView, "composeView");
        Intrinsics.checkNotNullParameter(gridViewModel, "gridViewModel");
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(382578668, true, new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesDisplayControlsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NotesDisplayControlsKt.setNotesDisplayControlsContent$lambda$0(composeView, gridViewModel, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setNotesDisplayControlsContent$lambda$0(ComposeView composeView, final GridViewModel gridViewModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C15@655L450,15@543L562:notesDisplayControls.kt#r51d28");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(382578668, i, -1, "com.myscript.nebo.grid.ui.compose.setNotesDisplayControlsContent.<anonymous> (notesDisplayControls.kt:15)");
            }
            Context context = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ThemeKt.m13017NeboTheme3IgeMak(false, ColorKt.Color(ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorPrimary)), ComposableLambdaKt.rememberComposableLambda(-78153868, true, new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesDisplayControlsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesDisplayControlsKt.setNotesDisplayControlsContent$lambda$0$0(gridViewModel, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setNotesDisplayControlsContent$lambda$0$0(GridViewModel gridViewModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C16@669L426:notesDisplayControls.kt#r51d28");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-78153868, i, -1, "com.myscript.nebo.grid.ui.compose.setNotesDisplayControlsContent.<anonymous>.<anonymous> (notesDisplayControls.kt:16)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 459811157, "C17@739L31,21@899L29,22@976L25,23@1050L30,19@788L293:notesDisplayControls.kt#r51d28");
            NotesDisplayModeKt.NotesDisplayMode(gridViewModel, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 153384757, "CC(remember):notesDisplayControls.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(gridViewModel);
            NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$1$1 notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$1$1RememberedValue = new NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$1$1(gridViewModel);
                composer.updateRememberedValue(notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function0 function0 = (Function0) ((KFunction) notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$1$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 153387217, "CC(remember):notesDisplayControls.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(gridViewModel);
            NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$2$1 notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$2$1RememberedValue = new NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$2$1(gridViewModel);
                composer.updateRememberedValue(notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function1 = (Function1) ((KFunction) notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$2$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 153389590, "CC(remember):notesDisplayControls.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(gridViewModel);
            NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$3$1 notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$3$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance3 || notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$3$1RememberedValue = new NotesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$3$1(gridViewModel);
                composer.updateRememberedValue(notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SortComponentKt.SortComponent(gridViewModel, (Function0<Unit>) function0, (Function1<? super Sort, Unit>) function1, (Function1<? super Order, Unit>) ((KFunction) notesDisplayControlsKt$setNotesDisplayControlsContent$1$1$1$3$1RememberedValue), composer, 0, 0);
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
