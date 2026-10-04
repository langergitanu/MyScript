package com.myscript.nebo.grid.p029ui.compose;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.Fill;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.AnnotatedString;
import androidx.compose.p004ui.text.PlatformSpanStyle;
import androidx.compose.p004ui.text.SpanStyle;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontSynthesis;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.intl.LocaleList;
import androidx.compose.p004ui.text.style.BaselineShift;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.text.style.TextGeometricTransform;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.WavUtil;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.grid.FolderUIState;
import com.myscript.nebo.grid.GridViewModel;
import com.myscript.nebo.note.p030ui.compose.CoverData;
import com.myscript.nebo.note.p030ui.compose.CoverKt;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.PageType;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: notesListView.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\r\u001ay\u0010\u000e\u001a\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00052\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u0013\u001a\u009f\u0001\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020\f2\b\u0010$\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010%2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010%2\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0002\u0010(\u001a\u001f\u0010)\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010*\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010+\u001a\u0015\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010.\u001a7\u0010/\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u00102\u001a)\u00103\u001a\u00020\u00012\b\b\u0002\u00104\u001a\u00020\u00122\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010%H\u0007¢\u0006\u0002\u00106¨\u00067²\u0006\n\u00108\u001a\u000209X\u008a\u0084\u0002²\u0006\n\u0010:\u001a\u00020\fX\u008a\u008e\u0002"}, m1599d2 = {"NotesListViewPane", "", "gridViewModel", "Lcom/myscript/nebo/grid/GridViewModel;", "onItemClicked", "Lkotlin/Function1;", "Lcom/myscript/snt/core/PageKey;", "onItemLongClicked", "onThumbnailRequested", "Lcom/myscript/nebo/dms/core/model/PageModel;", "onScroll", "Lkotlin/Function2;", "", "(Lcom/myscript/nebo/grid/GridViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "NotesListView", "notes", "", "isSelectionMode", "", "(Ljava/util/List;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "NoteCompactItem", "title", "", "coverData", "Lcom/myscript/nebo/note/ui/compose/CoverData;", "isSelected", "isContainer", "isCorrupted", "isTooRecent", "isMissingLanguage", "pageType", "Lcom/myscript/snt/dms/PageType;", "searchHitCount", "dateToDisplay", "", "dateDetailsRes", "thumbnailFilePath", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Lcom/myscript/nebo/note/ui/compose/CoverData;ZZZZZLcom/myscript/snt/dms/PageType;IJILjava/lang/String;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;III)V", "NoteTitle", "extension", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "NoteDetail", "detailText", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Thumbnail", "showWarningIcon", "thumbnailPath", "(Lcom/myscript/nebo/note/ui/compose/CoverData;ZZLcom/myscript/snt/dms/PageType;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "RoundedCheckbox", "checked", "onClick", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_standardRelease", "uiState", "Lcom/myscript/nebo/grid/FolderUIState;", "itemHeight"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NotesListViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCompactItem$lambda$1(String str, CoverData coverData, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, PageType pageType, int i, long j, int i2, String str2, boolean z6, Function0 function0, Function0 function02, Modifier modifier, int i3, int i4, int i5, Composer composer, int i6) {
        NoteCompactItem(str, coverData, z, z2, z3, z4, z5, pageType, i, j, i2, str2, z6, function0, function02, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteDetail$lambda$0(String str, int i, Composer composer, int i2) {
        NoteDetail(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteTitle$lambda$1(String str, String str2, int i, int i2, Composer composer, int i3) {
        NoteTitle(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListView$lambda$5(List list, boolean z, Function1 function1, Function1 function12, Function1 function13, Function2 function2, int i, Composer composer, int i2) {
        NotesListView(list, z, function1, function12, function13, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListViewPane$lambda$1(GridViewModel gridViewModel, Function1 function1, Function1 function12, Function1 function13, Function2 function2, int i, Composer composer, int i2) {
        NotesListViewPane(gridViewModel, function1, function12, function13, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoundedCheckbox$lambda$3(boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        RoundedCheckbox(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thumbnail$lambda$1(CoverData coverData, boolean z, boolean z2, PageType pageType, String str, int i, Composer composer, int i2) {
        Thumbnail(coverData, z, z2, pageType, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void NotesListViewPane(final GridViewModel gridViewModel, final Function1<? super PageKey, Unit> onItemClicked, final Function1<? super PageKey, Unit> onItemLongClicked, final Function1<? super PageModel, Unit> onThumbnailRequested, final Function2<? super Integer, ? super Integer, Unit> onScroll, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(gridViewModel, "gridViewModel");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onItemLongClicked, "onItemLongClicked");
        Intrinsics.checkNotNullParameter(onThumbnailRequested, "onThumbnailRequested");
        Intrinsics.checkNotNullParameter(onScroll, "onScroll");
        Composer composerStartRestartGroup = composer.startRestartGroup(1780766473);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesListViewPane)N(gridViewModel,onItemClicked,onItemLongClicked,onThumbnailRequested,onScroll)75@3279L31,77@3316L138:notesListView.kt#r51d28");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(gridViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onItemClicked) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onItemLongClicked) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onThumbnailRequested) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onScroll) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1780766473, i2, -1, "com.myscript.nebo.grid.ui.compose.NotesListViewPane (notesListView.kt:74)");
            }
            State stateObserveAsState = LiveDataAdapterKt.observeAsState(gridViewModel.getFolderUIState(), new FolderUIState(null, null, null, false, false, false, null, null, null, false, null, null, 4095, null), composerStartRestartGroup, 0);
            NotesListView(NotesListViewPane$lambda$0(stateObserveAsState).getPages(), NotesListViewPane$lambda$0(stateObserveAsState).getSelectionModeState().isSelectionMode(), onItemClicked, onItemLongClicked, onThumbnailRequested, onScroll, composerStartRestartGroup, (i2 << 3) & 524160);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListViewKt.NotesListViewPane$lambda$1(gridViewModel, onItemClicked, onItemLongClicked, onThumbnailRequested, onScroll, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void NotesListView(final List<PageModel> notes, final boolean z, final Function1<? super PageKey, Unit> onItemClicked, final Function1<? super PageKey, Unit> onItemLongClicked, final Function1<? super PageModel, Unit> onThumbnailRequested, final Function2<? super Integer, ? super Integer, Unit> onScroll, Composer composer, final int i) {
        int i2;
        Composer composer2;
        final MutableIntState mutableIntState;
        String str;
        Intrinsics.checkNotNullParameter(notes, "notes");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onItemLongClicked, "onItemLongClicked");
        Intrinsics.checkNotNullParameter(onThumbnailRequested, "onThumbnailRequested");
        Intrinsics.checkNotNullParameter(onScroll, "onScroll");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1669532335);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesListView)N(notes,isSelectionMode,onItemClicked,onItemLongClicked,onThumbnailRequested,onScroll)89@3799L23,90@3845L33,95@3933L1592,92@3884L1641,129@5561L449,129@5531L479:notesListView.kt#r51d28");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(notes) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onItemClicked) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onItemLongClicked) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onThumbnailRequested) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onScroll) ? 131072 : 65536;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1669532335, i3, -1, "com.myscript.nebo.grid.ui.compose.NotesListView (notesListView.kt:88)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897205490, "CC(remember):notesListView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1897209865, "CC(remember):notesListView.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 112) == 32) | ((i3 & 57344) == 16384) | composerStartRestartGroup.changedInstance(notes) | ((i3 & 896) == 256) | ((i3 & 7168) == 2048);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                mutableIntState = mutableIntState2;
                str = "CC(remember):notesListView.kt#9igjgp";
                Function1 function1 = new Function1() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesListViewKt.NotesListView$lambda$3$0(notes, onThumbnailRequested, z, onItemClicked, onItemLongClicked, mutableIntState, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            } else {
                mutableIntState = mutableIntState2;
                str = "CC(remember):notesListView.kt#9igjgp";
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LazyDslKt.LazyColumn(null, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue2, composerStartRestartGroup, 0, 509);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerStart(composer2, 1897260818, str);
            boolean zChanged = composer2.changed(lazyListStateRememberLazyListState) | ((458752 & i3) == 131072);
            NotesListViewKt$NotesListView$2$1 notesListViewKt$NotesListView$2$1RememberedValue = composer2.rememberedValue();
            if (zChanged || notesListViewKt$NotesListView$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                notesListViewKt$NotesListView$2$1RememberedValue = new NotesListViewKt$NotesListView$2$1(lazyListStateRememberLazyListState, onScroll, mutableIntState, null);
                composer2.updateRememberedValue(notesListViewKt$NotesListView$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(lazyListStateRememberLazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) notesListViewKt$NotesListView$2$1RememberedValue, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListViewKt.NotesListView$lambda$5(notes, z, onItemClicked, onItemLongClicked, onThumbnailRequested, onScroll, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int NotesListView$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListView$lambda$3$0(final List list, final Function1 function1, final boolean z, final Function1 function12, final Function1 function13, final MutableIntState mutableIntState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function1 function14 = new Function1() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NotesListViewKt.NotesListView$lambda$3$0$0((PageModel) obj);
            }
        };
        final C6589xcbef2058 c6589xcbef2058 = new Function1() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$lambda$3$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(PageModel pageModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((PageModel) obj);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$lambda$3$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function14.invoke(list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$lambda$3$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return c6589xcbef2058.invoke(list.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$lambda$3$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                Composer composer2;
                ComposerKt.sourceInformation(composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & 147) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                final PageModel pageModel = (PageModel) list.get(i);
                composer.startReplaceGroup(425553995);
                ComposerKt.sourceInformation(composer, "CN(noteModel)*120@5176L43,121@5261L46,122@5384L111,106@4363L1146:notesListView.kt#r51d28");
                if (pageModel.isCorrupted()) {
                    composer2 = composer;
                    composer2.startReplaceGroup(425846696);
                    composer2.endReplaceGroup();
                } else {
                    File thumbnailFile = pageModel.getThumbnailFile();
                    if (thumbnailFile != null ? thumbnailFile.isFile() : false) {
                        composer.startReplaceGroup(425640081);
                        ComposerKt.sourceInformation(composer, "101@4264L71,101@4152L183");
                        PageKey pageKey = pageModel.getPageKey();
                        File thumbnailFile2 = pageModel.getThumbnailFile();
                        Long lValueOf = Long.valueOf(pageModel.getLastModificationDate());
                        ComposerKt.sourceInformationMarkerStart(composer, -124812991, "CC(remember):notesListView.kt#9igjgp");
                        boolean zChanged = composer.changed(function1) | composer.changed(pageModel);
                        NotesListViewKt$NotesListView$1$1$2$1$1 notesListViewKt$NotesListView$1$1$2$1$1RememberedValue = composer.rememberedValue();
                        if (zChanged || notesListViewKt$NotesListView$1$1$2$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            notesListViewKt$NotesListView$1$1$2$1$1RememberedValue = new NotesListViewKt$NotesListView$1$1$2$1$1(function1, pageModel, null);
                            composer.updateRememberedValue(notesListViewKt$NotesListView$1$1$2$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        EffectsKt.LaunchedEffect(pageKey, thumbnailFile2, lValueOf, (Function2) notesListViewKt$NotesListView$1$1$2$1$1RememberedValue, composer, 0);
                        composer2 = composer;
                        composer2.endReplaceGroup();
                    }
                }
                String title = pageModel.getTitle();
                CoverData coverData = CoverKt.getCoverData(pageModel);
                boolean isSelected = pageModel.getIsSelected();
                boolean zIsContainer = pageModel.isContainer();
                boolean zIsCorrupted = pageModel.isCorrupted();
                boolean z2 = !pageModel.isSupported();
                boolean zIsLanguageMissing = pageModel.isLanguageMissing();
                PageType pageType = pageModel.getPageType();
                int hitCount = pageModel.getHitCount();
                long dateToDisplay = pageModel.getDateToDisplay();
                int dateDetailsRes = pageModel.getDateDetailsRes();
                File thumbnailFile3 = pageModel.getThumbnailFile();
                String absolutePath = thumbnailFile3 != null ? thumbnailFile3.getAbsolutePath() : null;
                boolean z3 = z;
                ComposerKt.sourceInformationMarkerStart(composer2, -124783835, "CC(remember):notesListView.kt#9igjgp");
                boolean zChanged2 = composer2.changed(function12) | composer2.changed(pageModel);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function15 = function12;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$1$1$2$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function15.invoke(pageModel.getPageKey());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -124781112, "CC(remember):notesListView.kt#9igjgp");
                boolean zChanged3 = composer2.changed(function13) | composer2.changed(pageModel);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChanged3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final Function1 function16 = function13;
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$1$1$2$3$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function16.invoke(pageModel.getPageKey());
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function0 function02 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierAnimateItem$default = LazyItemScope.animateItem$default(lazyItemScope, Modifier.INSTANCE, null, null, null, 7, null);
                ComposerKt.sourceInformationMarkerStart(composer2, -124777111, "CC(remember):notesListView.kt#9igjgp");
                Object objRememberedValue3 = composer2.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    final MutableIntState mutableIntState2 = mutableIntState;
                    objRememberedValue3 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$NotesListView$1$1$2$4$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates layoutCoordinates) {
                            Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
                            mutableIntState2.setIntValue((int) (layoutCoordinates.mo9633getSizeYbymL2g() & 4294967295L));
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                NotesListViewKt.NoteCompactItem(title, coverData, isSelected, zIsContainer, zIsCorrupted, z2, zIsLanguageMissing, pageType, hitCount, dateToDisplay, dateDetailsRes, absolutePath, z3, function0, function02, OnGloballyPositionedModifierKt.onGloballyPositioned(modifierAnimateItem$default, (Function1) objRememberedValue3), composer2, 0, 0, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object NotesListView$lambda$3$0$0(PageModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String strUuid = it.getPageKey().uuid();
        Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
        return strUuid;
    }

    public static final void NoteCompactItem(final String title, final CoverData coverData, final boolean z, final boolean z2, final boolean z3, final boolean z4, final boolean z5, PageType pageType, final int i, final long j, final int i2, final String str, final boolean z6, Function0<Unit> onItemClicked, final Function0<Unit> onItemLongClicked, Modifier modifier, Composer composer, final int i3, final int i4, final int i5) {
        int i6;
        int i7;
        int i8;
        final Function0<Unit> function0;
        Composer composer2;
        PageType pageType2;
        final Modifier modifier2;
        long jM8183getTransparent0d7_KjU;
        String timestampToString;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(coverData, "coverData");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(onItemClicked, "onItemClicked");
        Intrinsics.checkNotNullParameter(onItemLongClicked, "onItemLongClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1840198679);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteCompactItem)N(title,coverData,isSelected,isContainer,isCorrupted,isTooRecent,isMissingLanguage,pageType,searchHitCount,dateToDisplay,dateDetailsRes,thumbnailFilePath,isSelectionMode,onItemClicked,onItemLongClicked,modifier)160@6620L1875:notesListView.kt#r51d28");
        if ((i3 & 6) == 0) {
            i6 = i3 | (composerStartRestartGroup.changed(title) ? 4 : 2);
        } else {
            i6 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 |= composerStartRestartGroup.changed(coverData) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i6 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i6 |= composerStartRestartGroup.changed(z3) ? 16384 : 8192;
        }
        if ((i3 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
            i6 |= composerStartRestartGroup.changed(z4) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i6 |= composerStartRestartGroup.changed(z5) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i7 = 196608;
            i6 |= composerStartRestartGroup.changed(pageType.ordinal()) ? 8388608 : 4194304;
        } else {
            i7 = 196608;
        }
        if ((100663296 & i3) == 0) {
            i6 |= composerStartRestartGroup.changed(i) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i6 |= composerStartRestartGroup.changed(j) ? 536870912 : 268435456;
        }
        int i9 = i6;
        if ((i4 & 6) == 0) {
            i8 = i4 | (composerStartRestartGroup.changed(i2) ? 4 : 2);
        } else {
            i8 = i4;
        }
        if ((i4 & 48) == 0) {
            i8 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i4 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i8 |= composerStartRestartGroup.changed(z6) ? 256 : 128;
        }
        if ((i4 & 3072) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(onItemClicked) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(onItemLongClicked) ? 16384 : 8192;
        }
        int i10 = i5 & 32768;
        if (i10 != 0) {
            i8 |= i7;
        } else if ((i4 & i7) == 0) {
            i8 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        int i11 = i8;
        if (!composerStartRestartGroup.shouldExecute(((i9 & 306783379) == 306783378 && (74899 & i11) == 74898) ? false : true, i9 & 1)) {
            function0 = onItemClicked;
            composer2 = composerStartRestartGroup;
            pageType2 = pageType;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1840198679, i9, i11, "com.myscript.nebo.grid.ui.compose.NoteCompactItem (notesListView.kt:158)");
            }
            Modifier modifierM2072combinedClickablehoGz1lA$default = ClickableKt.m2072combinedClickablehoGz1lA$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), false, null, null, null, onItemLongClicked, null, false, null, onItemClicked, 239, null);
            function0 = onItemClicked;
            if (z) {
                composerStartRestartGroup.startReplaceGroup(1095623452);
                ComposerKt.sourceInformation(composerStartRestartGroup, "167@6927L6");
                jM8183getTransparent0d7_KjU = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1095624436);
                composerStartRestartGroup.endReplaceGroup();
                jM8183getTransparent0d7_KjU = Color.INSTANCE.m8183getTransparent0d7_KjU();
            }
            float f = 24;
            Modifier modifier3 = companion;
            float f2 = 8;
            Modifier modifierM2857paddingqDBjuR0 = PaddingKt.m2857paddingqDBjuR0(BackgroundKt.m2016backgroundbw27NRU$default(modifierM2072combinedClickablehoGz1lA$default, jM8183getTransparent0d7_KjU, null, 2, null), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f2), C1486Dp.m11017constructorimpl(f), C1486Dp.m11017constructorimpl(f2));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2857paddingqDBjuR0);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2138100025, "C170@7176L86,170@7130L132,174@7272L262,181@7544L801,197@8404L85,197@8355L134:notesListView.kt#r51d28");
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z6, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1095029285, true, new Function3() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotesListViewKt.NoteCompactItem$lambda$0$0(z, function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 1572870 | ((i11 >> 3) & 112), 30);
            pageType2 = pageType;
            Thumbnail(coverData, z2, z4 || z5 || z3, pageType2, str, composerStartRestartGroup, ((i9 >> 3) & 14) | ((i9 >> 6) & 112) | ((i9 >> 12) & 7168) | ((i11 << 9) & 57344));
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, PaddingKt.m2856paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), C1486Dp.m11017constructorimpl(f2), 0.0f, 2, null), 1.0f, false, 2, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1217371890, "C187@7745L86,189@7845L490:notesListView.kt#r51d28");
            String str2 = Boolean.valueOf(pageType2 == PageType.PDF).booleanValue() ? ".pdf" : null;
            if (str2 == null) {
                str2 = "";
            }
            NoteTitle(title, str2, composerStartRestartGroup, i9 & 14, 0);
            if (z4) {
                composerStartRestartGroup.startReplaceGroup(177821668);
                ComposerKt.sourceInformation(composerStartRestartGroup, "190@7895L65");
                timestampToString = StringResources_androidKt.stringResource(C6079R.string.grid_view_page_item_update_required, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (z5) {
                composerStartRestartGroup.startReplaceGroup(177824965);
                ComposerKt.sourceInformation(composerStartRestartGroup, "191@7998L66");
                timestampToString = StringResources_androidKt.stringResource(C6079R.string.grid_view_page_item_missing_language, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i2 != 0) {
                composerStartRestartGroup.startReplaceGroup(177828410);
                ComposerKt.sourceInformation(composerStartRestartGroup, "192@8199L7,192@8104L119");
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                String timestampToSimpleDateString = CommonUtils.formatTimestampToSimpleDateString((Context) objConsume, j);
                Intrinsics.checkNotNullExpressionValue(timestampToSimpleDateString, "formatTimestampToSimpleDateString(...)");
                timestampToString = StringResources_androidKt.stringResource(i2, new Object[]{timestampToSimpleDateString}, composerStartRestartGroup, i11 & 14);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(177833343);
                ComposerKt.sourceInformation(composerStartRestartGroup, "193@8297L7");
                ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localContext2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                timestampToString = CommonUtils.formatTimestampToString((Context) objConsume2, j);
                composerStartRestartGroup.endReplaceGroup();
            }
            Intrinsics.checkNotNull(timestampToString);
            NoteDetail(timestampToString, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, i > 0, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-964801188, true, new Function3() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotesListViewKt.NoteCompactItem$lambda$0$2(i, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 1572870, 30);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final PageType pageType3 = pageType2;
            final Function0<Unit> function02 = function0;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListViewKt.NoteCompactItem$lambda$1(title, coverData, z, z2, z3, z4, z5, pageType3, i, j, i2, str, z6, function02, onItemLongClicked, modifier2, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCompactItem$lambda$0$0(boolean z, Function0 function0, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C171@7190L62:notesListView.kt#r51d28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1095029285, i, -1, "com.myscript.nebo.grid.ui.compose.NoteCompactItem.<anonymous>.<anonymous> (notesListView.kt:171)");
        }
        RoundedCheckbox(z, function0, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteCompactItem$lambda$0$2(int i, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C198@8464L6,198@8418L61:notesListView.kt#r51d28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-964801188, i2, -1, "com.myscript.nebo.grid.ui.compose.NoteCompactItem.<anonymous>.<anonymous> (notesListView.kt:198)");
        }
        TextKt.m4524Text4IGK_g(String.valueOf(i), (Modifier) null, MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131066);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NoteTitle(final String title, String str, Composer composer, final int i, final int i2) {
        int i3;
        final String str2;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2112985962);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteTitle)N(title,extension)215@9052L6,205@8570L505:notesListView.kt#r51d28");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                str2 = str;
                i3 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                String str3 = i4 != 0 ? "" : str2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2112985962, i3, -1, "com.myscript.nebo.grid.ui.compose.NoteTitle (notesListView.kt:204)");
                }
                composerStartRestartGroup.startReplaceGroup(940024418);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                composerStartRestartGroup.startReplaceGroup(940025709);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*207@8650L43");
                String strStringResource = title;
                if (strStringResource.length() == 0) {
                    strStringResource = StringResources_androidKt.stringResource(C6079R.string.untitled_page, composerStartRestartGroup, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                builder.append(strStringResource);
                if (str3.length() <= 0) {
                    composerStartRestartGroup.startReplaceGroup(791749624);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(791498803);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@8797L6,209@8840L8");
                    int iPushStyle = builder.pushStyle(new SpanStyle(Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (DefaultConstructorMarker) null));
                    try {
                        builder.append(".pdf");
                        Unit unit = Unit.INSTANCE;
                        builder.pop(iPushStyle);
                        composerStartRestartGroup.endReplaceGroup();
                    } catch (Throwable th) {
                        builder.pop(iPushStyle);
                        throw th;
                    }
                }
                AnnotatedString annotatedString = builder.toAnnotatedString();
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                TextKt.m4525TextIbK3jfQ(annotatedString, null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, null, composer2, 0, 0, 262138);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesListViewKt.NoteTitle$lambda$1(title, str2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        str2 = str;
        if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    public static final void NoteDetail(final String detailText, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(detailText, "detailText");
        Composer composerStartRestartGroup = composer.startRestartGroup(1148457066);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteDetail)N(detailText)223@9196L6,224@9267L10,221@9132L152:notesListView.kt#r51d28");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(detailText) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1148457066, i2, -1, "com.myscript.nebo.grid.ui.compose.NoteDetail (notesListView.kt:220)");
            }
            composer2 = composerStartRestartGroup;
            TextKt.m4524Text4IGK_g(detailText, (Modifier) null, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody2(), composer2, i2 & 14, 0, 65530);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListViewKt.NoteDetail$lambda$0(detailText, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void Thumbnail(final CoverData coverData, final boolean z, final boolean z2, final PageType pageType, final String str, Composer composer, final int i) {
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(coverData, "coverData");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Composer composerStartRestartGroup = composer.startRestartGroup(2028728955);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Thumbnail)N(coverData,isContainer,showWarningIcon,pageType,thumbnailPath)230@9435L2076:notesListView.kt#r51d28");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(coverData) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(pageType.ordinal()) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 16384 : 8192;
        }
        int i4 = i2;
        if (!composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2028728955, i4, -1, "com.myscript.nebo.grid.ui.compose.Thumbnail (notesListView.kt:228)");
            }
            float f = 48;
            Modifier modifierM2910height3ABfNKs = SizeKt.m2910height3ABfNKs(SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(64)), C1486Dp.m11017constructorimpl(f));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2910height3ABfNKs);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1023179434, "C276@11312L193:notesListView.kt#r51d28");
            if (z) {
                composerStartRestartGroup.startReplaceGroup(-1023177110);
                ComposerKt.sourceInformation(composerStartRestartGroup, "236@9613L355");
                float f2 = 5;
                CoverKt.m13292CoverxKlaLpw(coverData, boxScopeInstance.align(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f)), Alignment.INSTANCE.getCenter()), false, C1486Dp.m11017constructorimpl(f2), C1486Dp.m11017constructorimpl(3), C1486Dp.m11017constructorimpl(f2), composerStartRestartGroup, 224256 | (i4 & 14), 4);
                composerStartRestartGroup.endReplaceGroup();
                i3 = i4;
            } else if (pageType == PageType.RawContent) {
                composerStartRestartGroup.startReplaceGroup(-1022754270);
                ComposerKt.sourceInformation(composerStartRestartGroup, "256@10490L6,248@10049L587");
                Modifier modifierAlign = boxScopeInstance.align(AspectRatioKt.aspectRatio$default(SizeKt.m2929width3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f)), 1.3333334f, false, 2, null), Alignment.INSTANCE.getCenter());
                float f3 = 5;
                i3 = i4;
                SingletonAsyncImageKt.m12342AsyncImagegl8XCv8(str, null, BackgroundKt.m2016backgroundbw27NRU$default(BorderKt.m2033borderxT4_qwU(ClipKt.clip(modifierAlign, RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f3))), C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM(), Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f3))), Color.INSTANCE.m8185getWhite0d7_KjU(), null, 2, null), null, null, null, null, 0.0f, null, 0, false, null, composerStartRestartGroup, ((i4 >> 12) & 14) | 48, 0, 4088);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                i3 = i4;
                composerStartRestartGroup.startReplaceGroup(-1022119328);
                ComposerKt.sourceInformation(composerStartRestartGroup, "269@11131L6,261@10689L589");
                float f4 = 5;
                SingletonAsyncImageKt.m12342AsyncImagegl8XCv8(str, null, BackgroundKt.m2016backgroundbw27NRU$default(BorderKt.m2033borderxT4_qwU(ClipKt.clip(boxScopeInstance.align(AspectRatioKt.aspectRatio$default(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f)), 0.75f, false, 2, null), Alignment.INSTANCE.getCenter()), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f4))), C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM(), Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), 0.15f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(f4))), Color.INSTANCE.m8185getWhite0d7_KjU(), null, 2, null), null, null, null, null, 0.0f, null, 0, false, null, composerStartRestartGroup, ((i3 >> 12) & 14) | 48, 0, 4088);
                composerStartRestartGroup.endReplaceGroup();
            }
            AnimatedVisibilityKt.AnimatedVisibility(z2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$NotesListViewKt.INSTANCE.m13258getLambda$2072193315$app_standardRelease(), composerStartRestartGroup, ((i3 >> 6) & 14) | ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListViewKt.Thumbnail$lambda$1(coverData, z, z2, pageType, str, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RoundedCheckbox(boolean z, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function0<Unit> function02;
        final boolean z3;
        final Function0<Unit> function03;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function04;
        Composer composerStartRestartGroup = composer.startRestartGroup(1919535684);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RoundedCheckbox)N(checked,onClick)285@11644L6,286@11698L6,286@11741L8,291@11901L274,296@12177L317,287@11755L739:notesListView.kt#r51d28");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                function02 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z2;
                function03 = function02;
            } else {
                z3 = i4 != 0 ? false : z2;
                function03 = i5 != 0 ? null : function02;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1919535684, i3, -1, "com.myscript.nebo.grid.ui.compose.RoundedCheckbox (notesListView.kt:283)");
                }
                final long jM4203getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU();
                final long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                if (function03 == null) {
                    composerStartRestartGroup.startReplaceGroup(1693253980);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "288@11800L2");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2132831078, "CC(remember):notesListView.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function04 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(2132830737);
                    composerStartRestartGroup.endReplaceGroup();
                    function04 = function03;
                }
                Modifier modifierM2924size3ABfNKs = SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(48));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2132834582, "CC(remember):notesListView.kt#9igjgp");
                boolean zChanged = ((i3 & 14) == 4) | composerStartRestartGroup.changed(jM4203getPrimary0d7_KjU) | composerStartRestartGroup.changed(jM8147copywmQWz5c$default);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    Function1 function1 = new Function1() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesListViewKt.RoundedCheckbox$lambda$1$0(z3, jM4203getPrimary0d7_KjU, jM8147copywmQWz5c$default, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function1);
                    objRememberedValue2 = function1;
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                IconButtonKt.IconButton(function04, DrawModifierKt.drawBehind(modifierM2924size3ABfNKs, (Function1) objRememberedValue2), false, null, ComposableLambdaKt.rememberComposableLambda(166004008, true, new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesListViewKt.RoundedCheckbox$lambda$2(z3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 24576, 12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.NotesListViewKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesListViewKt.RoundedCheckbox$lambda$3(z3, function03, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        function02 = function0;
        if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoundedCheckbox$lambda$2(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C298@12188L300:notesListView.kt#r51d28");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(166004008, i, -1, "com.myscript.nebo.grid.ui.compose.RoundedCheckbox.<anonymous> (notesListView.kt:298)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableSingletons$NotesListViewKt.INSTANCE.m13257getLambda$2048185520$app_standardRelease(), composer, ProfileVerifier.CompilationStatus.f379xf2722a21, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final FolderUIState NotesListViewPane$lambda$0(State<FolderUIState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoundedCheckbox$lambda$1$0(boolean z, long j, long j2, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        DrawScope.m8710drawCircleVaOC9Bg$default(drawBehind, z ? j : j2, drawBehind.mo2191toPx0680j_4(C1486Dp.m11017constructorimpl(12)), 0L, 0.0f, z ? Fill.INSTANCE : new Stroke(0.0f, 0.0f, 0, 0, null, 31, null), null, 0, 108, null);
        return Unit.INSTANCE;
    }
}
