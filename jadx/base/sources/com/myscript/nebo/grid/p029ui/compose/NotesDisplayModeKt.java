package com.myscript.nebo.grid.p029ui.compose;

import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.res.VectorResources_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.myscript.nebo.grid.FolderUIState;
import com.myscript.nebo.grid.GridViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: notesDisplayMode.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a/\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002"}, m1599d2 = {"NotesDisplayMode", "", "gridViewModel", "Lcom/myscript/nebo/grid/GridViewModel;", "(Lcom/myscript/nebo/grid/GridViewModel;Landroidx/compose/runtime/Composer;I)V", "DisplayModeButton", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "", "onButtonClicked", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_standardRelease", "uiState", "Lcom/myscript/nebo/grid/FolderUIState;"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NotesDisplayModeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeButton$lambda$1(Modifier modifier, int i, Function0 function0, int i2, int i3, Composer composer, int i4) {
        DisplayModeButton(modifier, i, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesDisplayMode$lambda$2(GridViewModel gridViewModel, int i, Composer composer, int i2) {
        NotesDisplayMode(gridViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NotesDisplayMode(final GridViewModel gridViewModel, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(gridViewModel, "gridViewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-169303364);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesDisplayMode)N(gridViewModel)19@734L31,21@848L37,21@771L115:notesDisplayMode.kt#r51d28");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(gridViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-169303364, i2, -1, "com.myscript.nebo.grid.ui.compose.NotesDisplayMode (notesDisplayMode.kt:18)");
            }
            int iconResource = NotesDisplayMode$lambda$0(LiveDataAdapterKt.observeAsState(gridViewModel.getFolderUIState(), new FolderUIState(null, null, null, false, false, false, null, null, null, false, null, null, 4095, null), composerStartRestartGroup, 0)).getDisplayMode().getIconResource();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 508231329, "CC(remember):notesDisplayMode.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(gridViewModel);
            NotesDisplayModeKt$NotesDisplayMode$1$1 notesDisplayModeKt$NotesDisplayMode$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || notesDisplayModeKt$NotesDisplayMode$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                notesDisplayModeKt$NotesDisplayMode$1$1RememberedValue = new NotesDisplayModeKt$NotesDisplayMode$1$1(gridViewModel);
                composerStartRestartGroup.updateRememberedValue(notesDisplayModeKt$NotesDisplayMode$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            DisplayModeButton(null, iconResource, (Function0) ((KFunction) notesDisplayModeKt$NotesDisplayMode$1$1RememberedValue), composerStartRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesDisplayModeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesDisplayModeKt.NotesDisplayMode$lambda$2(gridViewModel, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void DisplayModeButton(Modifier modifier, final int i, Function0<Unit> onButtonClicked, Composer composer, final int i2, final int i3) {
        int i4;
        final Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(onButtonClicked, "onButtonClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-615779079);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DisplayModeButton)N(modifier,icon,onButtonClicked)26@1073L134,26@1014L193:notesDisplayMode.kt#r51d28");
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onButtonClicked) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i4 & 147) != 146, i4 & 1)) {
            function0 = onButtonClicked;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-615779079, i4, -1, "com.myscript.nebo.grid.ui.compose.DisplayModeButton (notesDisplayMode.kt:25)");
            }
            IconButtonKt.IconButton(onButtonClicked, modifier2, false, null, ComposableLambdaKt.rememberComposableLambda(20308701, true, new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesDisplayModeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesDisplayModeKt.DisplayModeButton$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 6) & 14) | 24576 | ((i4 << 3) & 112), 12);
            function0 = onButtonClicked;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesDisplayModeKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesDisplayModeKt.DisplayModeButton$lambda$1(modifier3, i, function0, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisplayModeButton$lambda$0(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C27@1114L20,27@1157L6,27@1083L118:notesDisplayMode.kt#r51d28");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(20308701, i2, -1, "com.myscript.nebo.grid.ui.compose.DisplayModeButton.<anonymous> (notesDisplayMode.kt:27)");
            }
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, i, composer, 6), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final FolderUIState NotesDisplayMode$lambda$0(State<FolderUIState> state) {
        return state.getValue();
    }
}
