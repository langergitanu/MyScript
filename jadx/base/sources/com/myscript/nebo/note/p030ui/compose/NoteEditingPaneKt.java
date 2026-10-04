package com.myscript.nebo.note.p030ui.compose;

import android.content.res.Configuration;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.note.NoteEditingUIState;
import com.myscript.nebo.note.NoteEditingViewModel;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

/* JADX INFO: compiled from: noteEditingPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\f\u001a\u0087\u0001\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00142\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u0084\u0002"}, m1599d2 = {"NoteEditingPane", "", "noteEditingViewModel", "Lcom/myscript/nebo/note/NoteEditingViewModel;", "onNoteNameChanged", "Lkotlin/Function1;", "", "onCoverColorChanged", "", "onEdit", "Lkotlin/Function0;", "onDismiss", "(Lcom/myscript/nebo/note/NoteEditingViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NoteEditingPaneContent", "showCoverSection", "", "noteName", "coverData", "Lcom/myscript/nebo/note/ui/compose/CoverData;", "availableCovers", "Lkotlinx/collections/immutable/ImmutableList;", "onCoverChanged", "(ZLjava/lang/String;Lcom/myscript/nebo/note/ui/compose/CoverData;Lkotlinx/collections/immutable/ImmutableList;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_standardRelease", "uiState", "Lcom/myscript/nebo/note/NoteEditingUIState;"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NoteEditingPaneKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteEditingPane$lambda$1(NoteEditingViewModel noteEditingViewModel, Function1 function1, Function1 function12, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        NoteEditingPane(noteEditingViewModel, function1, function12, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteEditingPaneContent$lambda$1(boolean z, String str, CoverData coverData, ImmutableList immutableList, Function1 function1, Function1 function12, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        NoteEditingPaneContent(z, str, coverData, immutableList, function1, function12, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void NoteEditingPane(final NoteEditingViewModel noteEditingViewModel, final Function1<? super String, Unit> onNoteNameChanged, final Function1<? super Integer, Unit> onCoverColorChanged, final Function0<Unit> onEdit, final Function0<Unit> onDismiss, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(noteEditingViewModel, "noteEditingViewModel");
        Intrinsics.checkNotNullParameter(onNoteNameChanged, "onNoteNameChanged");
        Intrinsics.checkNotNullParameter(onCoverColorChanged, "onCoverColorChanged");
        Intrinsics.checkNotNullParameter(onEdit, "onEdit");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerStartRestartGroup = composer.startRestartGroup(1085047332);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteEditingPane)N(noteEditingViewModel,onNoteNameChanged,onCoverColorChanged,onEdit,onDismiss)37@1594L36,39@1636L385:noteEditingPane.kt#ku1rws");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(noteEditingViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onNoteNameChanged) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCoverColorChanged) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onEdit) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismiss) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1085047332, i2, -1, "com.myscript.nebo.note.ui.compose.NoteEditingPane (noteEditingPane.kt:35)");
            }
            State stateObserveAsState = LiveDataAdapterKt.observeAsState(noteEditingViewModel.getNoteEditingUIState(), new NoteEditingUIState(null, false, null, null, 15, null), composerStartRestartGroup, 0);
            NoteEditingPaneContent(NoteEditingPane$lambda$0(stateObserveAsState).getCanEditCover(), NoteEditingPane$lambda$0(stateObserveAsState).getNoteTitle(), NoteEditingPane$lambda$0(stateObserveAsState).getNoteCover(), NoteEditingPane$lambda$0(stateObserveAsState).getAvailableNoteCovers(), onNoteNameChanged, onCoverColorChanged, onEdit, onDismiss, composerStartRestartGroup, (i2 << 9) & 33546240, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteEditingPaneKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NoteEditingPaneKt.NoteEditingPane$lambda$1(noteEditingViewModel, onNoteNameChanged, onCoverColorChanged, onEdit, onDismiss, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NoteEditingPaneContent(final boolean z, final String noteName, final CoverData coverData, final ImmutableList<CoverData> availableCovers, Function1<? super String, Unit> function1, Function1<? super Integer, Unit> function12, Function0<Unit> function0, Function0<Unit> function02, Composer composer, final int i, final int i2) {
        int i3;
        Function1<? super String, Unit> function13;
        int i4;
        Function1<? super Integer, Unit> function14;
        int i5;
        Function0<Unit> function03;
        int i6;
        Function0<Unit> function04;
        final Function1<? super String, Unit> function15;
        final Function0<Unit> function05;
        final Function0<Unit> function06;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifierWrapContentSize$default;
        Function1<? super String, Unit> function16;
        int i7;
        int i8;
        float f;
        String str;
        Function0<Unit> function07;
        Function0<Unit> function08;
        Intrinsics.checkNotNullParameter(noteName, "noteName");
        Intrinsics.checkNotNullParameter(coverData, "coverData");
        Intrinsics.checkNotNullParameter(availableCovers, "availableCovers");
        Composer composerStartRestartGroup = composer.startRestartGroup(-378819011);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteEditingPaneContent)N(showCoverSection,noteName,coverData,availableCovers,onNoteNameChanged,onCoverChanged,onEdit,onDismiss)61@2436L7,76@2919L21,71@2667L1362:noteEditingPane.kt#ku1rws");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(noteName) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(coverData) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(availableCovers) ? 2048 : 1024;
        }
        int i9 = i2 & 16;
        if (i9 != 0) {
            i3 |= 24576;
        } else {
            if ((i & 24576) == 0) {
                function13 = function1;
                i3 |= composerStartRestartGroup.changedInstance(function13) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    function14 = function12;
                    i3 |= composerStartRestartGroup.changedInstance(function14) ? 131072 : 65536;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                    function03 = function0;
                } else {
                    function03 = function0;
                    if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function03) ? 1048576 : 524288;
                    }
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                    function04 = function02;
                } else {
                    function04 = function02;
                    if ((i & 12582912) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function04) ? 8388608 : 4194304;
                    }
                }
                if (!composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function15 = function13;
                    function05 = function03;
                    function06 = function04;
                } else {
                    Function1<? super String, Unit> function17 = i9 != 0 ? null : function13;
                    Function1<? super Integer, Unit> function18 = i4 != 0 ? null : function14;
                    Function0<Unit> function09 = i5 != 0 ? null : function03;
                    Function0<Unit> function010 = i6 != 0 ? null : function04;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-378819011, i3, -1, "com.myscript.nebo.note.ui.compose.NoteEditingPaneContent (noteEditingPane.kt:59)");
                    }
                    ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localConfiguration);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (C1486Dp.m11016compareTo0680j_4(C1486Dp.m11017constructorimpl(((Configuration) objConsume).screenWidthDp), C1486Dp.m11017constructorimpl(600)) < 0) {
                        modifierWrapContentSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    } else {
                        modifierWrapContentSize$default = SizeKt.wrapContentSize$default(Modifier.INSTANCE, null, false, 3, null);
                    }
                    float f2 = 24;
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f2));
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(PaddingKt.m2856paddingVpY3zN4$default(modifierWrapContentSize$default, C1486Dp.m11017constructorimpl(f2), 0.0f, 2, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
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
                    Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1670690223, "C83@3290L157,85@3457L566:noteEditingPane.kt#ku1rws");
                    if (z) {
                        composerStartRestartGroup.startReplaceGroup(1670688331);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "79@2990L68,80@3071L199");
                        int i10 = i3 >> 6;
                        i7 = i3;
                        str = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                        i8 = 1;
                        function16 = function17;
                        f = 0.0f;
                        CoverKt.m13292CoverxKlaLpw(coverData, SizeKt.m2912heightInVpY3zN4$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(SensibleDefaults.X_OFFSET), 1, null), false, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, (i10 & 14) | 48, 60);
                        ImmutableList<CoverData> immutableList = availableCovers;
                        Iterator<CoverData> it = immutableList.iterator();
                        int i11 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i11 = -1;
                                break;
                            } else if (Intrinsics.areEqual(it.next().getColors(), coverData.getColors())) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                        Function1<? super Integer, Unit> function19 = function18;
                        composerStartRestartGroup = composerStartRestartGroup;
                        NoteKt.NotebookCoverList(immutableList, i11, PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(16), 0.0f, 0.0f, 13, null), function19, composerStartRestartGroup, ((i7 >> 9) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | (i10 & 7168), 0);
                        function14 = function19;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        function16 = function17;
                        i7 = i3;
                        i8 = 1;
                        f = 0.0f;
                        str = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                        function14 = function18;
                        composerStartRestartGroup.startReplaceGroup(1670980475);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    int i12 = i7 >> 3;
                    function15 = function16;
                    NoteKt.NoteNameField(noteName, PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, C1486Dp.m11017constructorimpl(8), 0.0f, 0.0f, 13, null), C6079R.string.note_creation_name_hint_notebook, function15, composerStartRestartGroup, (i12 & 14) | 48 | (i12 & 7168), 0);
                    float f3 = 16;
                    Arrangement.Horizontal horizontalM2529spacedByD5KLDUw = Arrangement.INSTANCE.m2529spacedByD5KLDUw(C1486Dp.m11017constructorimpl(f3), Alignment.INSTANCE.getEnd());
                    Alignment.Vertical bottom = Alignment.INSTANCE.getBottom();
                    Modifier modifierM2856paddingVpY3zN4$default = PaddingKt.m2856paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, f, i8, null), f, C1486Dp.m11017constructorimpl(f3), i8, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalM2529spacedByD5KLDUw, bottom, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, str);
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2856paddingVpY3zN4$default);
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
                    Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1195376222, "C92@3755L122,95@3890L123:noteEditingPane.kt#ku1rws");
                    if (function010 == null) {
                        composerStartRestartGroup.startReplaceGroup(1195402013);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "92@3789L2");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978224005, "CC(remember):noteEditingPane.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.myscript.nebo.note.ui.compose.NoteEditingPaneKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function07 = (Function0) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1978223602);
                        composerStartRestartGroup.endReplaceGroup();
                        function07 = function010;
                    }
                    ButtonKt.TextButton(function07, null, false, null, null, null, null, null, null, ComposableSingletons$NoteEditingPaneKt.INSTANCE.getLambda$1152641414$app_standardRelease(), composerStartRestartGroup, 805306368, TypedValues.PositionType.TYPE_POSITION_TYPE);
                    if (function09 == null) {
                        composerStartRestartGroup.startReplaceGroup(1195528989);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@3917L2");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1978228101, "CC(remember):noteEditingPane.kt#9igjgp");
                        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.note.ui.compose.NoteEditingPaneKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        function08 = (Function0) objRememberedValue2;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1978227791);
                        composerStartRestartGroup.endReplaceGroup();
                        function08 = function09;
                    }
                    ButtonKt.Button(function08, null, false, null, null, null, null, null, null, ComposableSingletons$NoteEditingPaneKt.INSTANCE.m13287getLambda$434548173$app_standardRelease(), composerStartRestartGroup, 805306368, TypedValues.PositionType.TYPE_POSITION_TYPE);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function05 = function09;
                    function06 = function010;
                }
                final Function1<? super Integer, Unit> function110 = function14;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.note.ui.compose.NoteEditingPaneKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NoteEditingPaneKt.NoteEditingPaneContent$lambda$1(z, noteName, coverData, availableCovers, function15, function110, function05, function06, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
            function14 = function12;
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            i6 = i2 & 128;
            if (i6 != 0) {
            }
            if (!composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
            }
            final Function1 function1102 = function14;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function13 = function1;
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        function14 = function12;
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        i6 = i2 & 128;
        if (i6 != 0) {
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 4793491) != 4793490, i3 & 1)) {
        }
        final Function1 function11022 = function14;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final NoteEditingUIState NoteEditingPane$lambda$0(State<NoteEditingUIState> state) {
        return state.getValue();
    }
}
