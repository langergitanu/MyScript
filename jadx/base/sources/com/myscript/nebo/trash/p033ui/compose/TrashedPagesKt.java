package com.myscript.nebo.trash.p033ui.compose;

import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.draw.AlphaKt;
import androidx.compose.p004ui.draw.ClipKt;
import androidx.compose.p004ui.draw.DrawModifierKt;
import androidx.compose.p004ui.draw.RotateKt;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.RectangleShapeKt;
import androidx.compose.p004ui.graphics.Shadow;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawStyle;
import androidx.compose.p004ui.graphics.drawscope.Stroke;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.graphics.vector.ImageVector;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.res.ColorResources_androidKt;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.res.PrimitiveResources_androidKt;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.res.VectorResources_androidKt;
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
import androidx.compose.p004ui.text.style.TextOverflow;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.core.app.FrameMetricsAggregator;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.WavUtil;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.dms.core.model.PageModel;
import com.myscript.nebo.dms.core.model.SelectionState;
import com.myscript.nebo.grid.DisplayMode;
import com.myscript.nebo.grid.p029ui.compose.NotesDisplayModeKt;
import com.myscript.nebo.grid.p029ui.compose.NotesListViewKt;
import com.myscript.nebo.note.p030ui.compose.CoverData;
import com.myscript.nebo.note.p030ui.compose.CoverKt;
import com.myscript.nebo.p034ui.compose.component.EmptyStateKt;
import com.myscript.nebo.trash.TrashViewModel;
import com.myscript.nebo.trash.TrashedPagesUIState;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.PageType;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.collections.immutable.ImmutableList;

/* JADX INFO: compiled from: trashedPages.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\t\u001ao\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0013\u001aW\u0010\u0014\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0019\u001aW\u0010\u001a\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0015\u001a'\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u001d\u001a!\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 H\u0003¢\u0006\u0002\u0010\"\u001a\u0015\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0003¢\u0006\u0002\u0010&\u001a[\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00062\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010)\u001aA\u0010*\u001a\u00020\u00012\b\u0010+\u001a\u0004\u0018\u00010 2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u00101\u001a\u0015\u00102\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u00103\u001a\r\u00104\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00105¨\u00066²\u0006\n\u00107\u001a\u000208X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u000208X\u008a\u0084\u0002"}, m1599d2 = {"TrashedPagesPane", "", "trashViewModel", "Lcom/myscript/nebo/trash/TrashViewModel;", "onPageClick", "Lkotlin/Function1;", "Lcom/myscript/nebo/dms/core/model/PageModel;", "onPageLongClick", "onThumbnailNeeded", "(Lcom/myscript/nebo/trash/TrashViewModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TrashedPagesPaneContent", "pages", "Lkotlinx/collections/immutable/ImmutableList;", "displayMode", "Lcom/myscript/nebo/grid/DisplayMode;", "remainingPagesCount", "", "isTrashEmpty", "", "(Lkotlinx/collections/immutable/ImmutableList;Lcom/myscript/nebo/grid/DisplayMode;IZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TrashedPagesGrid", "(Lkotlinx/collections/immutable/ImmutableList;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TrashDisplayMode", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lcom/myscript/nebo/trash/TrashViewModel;Landroidx/compose/runtime/Composer;II)V", "TrashedPagesList", "NotebookDescription", "trashedPagesCount", "(Landroidx/compose/ui/Modifier;IILandroidx/compose/runtime/Composer;II)V", "PageTitle", "title", "", "extension", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "FormattedModificationDate", DiagnosticsEntry.TIMESTAMP_KEY, "", "(JLandroidx/compose/runtime/Composer;I)V", "TrashedPageItem", "pageModel", "(Lcom/myscript/nebo/dms/core/model/PageModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Thumbnail", "thumbnailFile", "childPageCount", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "pageType", "Lcom/myscript/snt/dms/PageType;", "isLoading", "(Ljava/lang/String;IILcom/myscript/snt/dms/PageType;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CorruptedState", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "SelectionState", "(Landroidx/compose/runtime/Composer;I)V", "app_standardRelease", "uiState", "Lcom/myscript/nebo/trash/TrashedPagesUIState;"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class TrashedPagesKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CorruptedState$lambda$1(Modifier modifier, int i, Composer composer, int i2) {
        CorruptedState(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FormattedModificationDate$lambda$0(long j, int i, Composer composer, int i2) {
        FormattedModificationDate(j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotebookDescription$lambda$1(Modifier modifier, int i, int i2, int i3, int i4, Composer composer, int i5) {
        NotebookDescription(modifier, i, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageTitle$lambda$1(String str, String str2, int i, int i2, Composer composer, int i3) {
        PageTitle(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionState$lambda$1(int i, Composer composer, int i2) {
        SelectionState(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thumbnail$lambda$1(String str, int i, int i2, PageType pageType, boolean z, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        Thumbnail(str, i, i2, pageType, z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashDisplayMode$lambda$2(Modifier modifier, TrashViewModel trashViewModel, int i, int i2, Composer composer, int i3) {
        TrashDisplayMode(modifier, trashViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPageItem$lambda$4(PageModel pageModel, Function1 function1, Function1 function12, Function1 function13, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TrashedPageItem(pageModel, function1, function12, function13, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPagesGrid$lambda$1(ImmutableList immutableList, Function1 function1, Function1 function12, Function1 function13, int i, Composer composer, int i2) {
        TrashedPagesGrid(immutableList, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPagesList$lambda$1(ImmutableList immutableList, Function1 function1, Function1 function12, Function1 function13, int i, Composer composer, int i2) {
        TrashedPagesList(immutableList, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPagesPane$lambda$1(TrashViewModel trashViewModel, Function1 function1, Function1 function12, Function1 function13, int i, Composer composer, int i2) {
        TrashedPagesPane(trashViewModel, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPagesPaneContent$lambda$1(ImmutableList immutableList, DisplayMode displayMode, int i, boolean z, Function1 function1, Function1 function12, Function1 function13, int i2, Composer composer, int i3) {
        TrashedPagesPaneContent(immutableList, displayMode, i, z, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void TrashedPagesPane(final TrashViewModel trashViewModel, final Function1<? super PageModel, Unit> onPageClick, final Function1<? super PageModel, Unit> onPageLongClick, final Function1<? super PageModel, Unit> onThumbnailNeeded, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(trashViewModel, "trashViewModel");
        Intrinsics.checkNotNullParameter(onPageClick, "onPageClick");
        Intrinsics.checkNotNullParameter(onPageLongClick, "onPageLongClick");
        Intrinsics.checkNotNullParameter(onThumbnailNeeded, "onThumbnailNeeded");
        Composer composerStartRestartGroup = composer.startRestartGroup(938534367);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrashedPagesPane)N(trashViewModel,onPageClick,onPageLongClick,onThumbnailNeeded)93@4443L37,95@4486L203:trashedPages.kt#qp0phu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(trashViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPageClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPageLongClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onThumbnailNeeded) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(938534367, i2, -1, "com.myscript.nebo.trash.ui.compose.TrashedPagesPane (trashedPages.kt:92)");
            }
            State stateObserveAsState = LiveDataAdapterKt.observeAsState(trashViewModel.getTrashedPagesState(), new TrashedPagesUIState(null, null, 0, false, false, false, null, 127, null), composerStartRestartGroup, 0);
            TrashedPagesPaneContent(TrashedPagesPane$lambda$0(stateObserveAsState).getPages(), TrashedPagesPane$lambda$0(stateObserveAsState).getDisplayMode(), TrashedPagesPane$lambda$0(stateObserveAsState).getRemainingPagesCount(), TrashedPagesPane$lambda$0(stateObserveAsState).isTrashEmpty(), onPageClick, onPageLongClick, onThumbnailNeeded, composerStartRestartGroup, 4186112 & (i2 << 9));
            if (TrashedPagesPane$lambda$0(stateObserveAsState).getShowProgress()) {
                composerStartRestartGroup.startReplaceGroup(-359272235);
                ComposerKt.sourceInformation(composerStartRestartGroup, "98@4731L126");
                ProgressIndicatorKt.m4366CircularProgressIndicatorLxG7B9w(SizeKt.wrapContentSize$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenter(), false, 2, null), 0L, 0.0f, 0L, 0, composerStartRestartGroup, 6, 30);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-359135773);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesKt.TrashedPagesPane$lambda$1(trashViewModel, onPageClick, onPageLongClick, onThumbnailNeeded, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TrashedPagesPaneContent(final ImmutableList<PageModel> pages, final DisplayMode displayMode, final int i, final boolean z, final Function1<? super PageModel, Unit> onPageClick, final Function1<? super PageModel, Unit> onPageLongClick, final Function1<? super PageModel, Unit> onThumbnailNeeded, Composer composer, final int i2) {
        int i3;
        int i4;
        boolean z2;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(displayMode, "displayMode");
        Intrinsics.checkNotNullParameter(onPageClick, "onPageClick");
        Intrinsics.checkNotNullParameter(onPageLongClick, "onPageLongClick");
        Intrinsics.checkNotNullParameter(onThumbnailNeeded, "onThumbnailNeeded");
        Composer composerStartRestartGroup = composer.startRestartGroup(1619253802);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrashedPagesPaneContent)N(pages,displayMode,remainingPagesCount,isTrashEmpty,onPageClick,onPageLongClick,onThumbnailNeeded)107@5207L757,107@5133L831:trashedPages.kt#qp0phu");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(pages) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(displayMode) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 = i;
            i3 |= composerStartRestartGroup.changed(i4) ? 256 : 128;
        } else {
            i4 = i;
        }
        if ((i2 & 3072) == 0) {
            z2 = z;
            i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
        } else {
            z2 = z;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPageClick) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPageLongClick) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onThumbnailNeeded) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1619253802, i3, -1, "com.myscript.nebo.trash.ui.compose.TrashedPagesPaneContent (trashedPages.kt:106)");
            }
            final int i5 = i4;
            final boolean z3 = z2;
            CrossfadeKt.Crossfade(Boolean.valueOf(pages.isEmpty()), (Modifier) null, (FiniteAnimationSpec<Float>) null, "empty state crossfade", ComposableLambdaKt.rememberComposableLambda(1729087499, true, new Function3() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TrashedPagesKt.TrashedPagesPaneContent$lambda$0(z3, pages, i5, displayMode, onPageClick, onPageLongClick, onThumbnailNeeded, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 27648, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesKt.TrashedPagesPaneContent$lambda$1(pages, displayMode, i, z, onPageClick, onPageLongClick, onThumbnailNeeded, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPagesPaneContent$lambda$0(boolean z, ImmutableList immutableList, int i, DisplayMode displayMode, Function1 function1, Function1 function12, Function1 function13, boolean z2, Composer composer, int i2) {
        int i3;
        ComposerKt.sourceInformation(composer, "CN(isEmpty):trashedPages.kt#qp0phu");
        if ((i2 & 6) == 0) {
            i3 = i2 | (composer.changed(z2) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if (composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1729087499, i3, -1, "com.myscript.nebo.trash.ui.compose.TrashedPagesPaneContent.<anonymous> (trashedPages.kt:108)");
            }
            if (z2) {
                composer.startReplaceGroup(1702944563);
                ComposerKt.sourceInformation(composer, "110@5345L122,111@5480L43");
                EmptyStateKt.EmptyState(C6183R.drawable.ic_delete_outline, StringResources_androidKt.stringResource(z ? C6079R.string.trash_empty_state_message : C6079R.string.trashed_pages_empty_folder_message, composer, 0), null, composer, 0, 4);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1703244116);
                ComposerKt.sourceInformation(composer, "113@5553L395");
                ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
                Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -781423602, "C114@5578L99:trashedPages.kt#qp0phu");
                float f = 8;
                NotebookDescription(PaddingKt.m2858paddingqDBjuR0$default(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f), 0.0f, 0.0f, C1486Dp.m11017constructorimpl(f), 6, null), immutableList.size(), i, composer, 6, 0);
                if (Intrinsics.areEqual(displayMode, DisplayMode.Grid.INSTANCE)) {
                    composer.startReplaceGroup(-2103412199);
                    ComposerKt.sourceInformation(composer, "116@5743L72");
                    TrashedPagesGrid(immutableList, function1, function12, function13, composer, 0);
                    composer.endReplaceGroup();
                } else {
                    if (!Intrinsics.areEqual(displayMode, DisplayMode.List.INSTANCE)) {
                        composer.startReplaceGroup(-2103413599);
                        composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceGroup(-2103408967);
                    ComposerKt.sourceInformation(composer, "117@5844L72");
                    TrashedPagesList(immutableList, function1, function12, function13, composer, 0);
                    composer.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void TrashedPagesGrid(final ImmutableList<PageModel> pages, final Function1<? super PageModel, Unit> onPageClick, final Function1<? super PageModel, Unit> onPageLongClick, final Function1<? super PageModel, Unit> onThumbnailNeeded, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(onPageClick, "onPageClick");
        Intrinsics.checkNotNullParameter(onPageLongClick, "onPageLongClick");
        Intrinsics.checkNotNullParameter(onThumbnailNeeded, "onThumbnailNeeded");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1367020521);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrashedPagesGrid)N(pages,onPageClick,onPageLongClick,onThumbnailNeeded)132@6381L154,127@6153L382:trashedPages.kt#qp0phu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(pages) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPageClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPageLongClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onThumbnailNeeded) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1367020521, i2, -1, "com.myscript.nebo.trash.ui.compose.TrashedPagesGrid (trashedPages.kt:125)");
            }
            GridAutoFit gridAutoFit = new GridAutoFit(C1486Dp.m11017constructorimpl(PsExtractor.VIDEO_STREAM_MASK), null);
            float f = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_42 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(f));
            PaddingValues paddingValuesM2847PaddingValues0680j_4 = PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(f));
            GridAutoFit gridAutoFit2 = gridAutoFit;
            Arrangement.HorizontalOrVertical horizontalOrVertical = horizontalOrVerticalM2528spacedBy0680j_4;
            Arrangement.HorizontalOrVertical horizontalOrVertical2 = horizontalOrVerticalM2528spacedBy0680j_42;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 553284881, "CC(remember):trashedPages.kt#9igjgp");
            boolean z = ((i2 & 14) == 4) | ((i2 & 112) == 32) | ((i2 & 896) == 256) | ((i2 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TrashedPagesKt.TrashedPagesGrid$lambda$0$0(pages, onPageClick, onPageLongClick, onThumbnailNeeded, (LazyGridScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LazyGridDslKt.LazyVerticalGrid(gridAutoFit2, null, null, paddingValuesM2847PaddingValues0680j_4, false, horizontalOrVertical, horizontalOrVertical2, null, false, null, (Function1) objRememberedValue, composer2, 1772544, 0, 918);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesKt.TrashedPagesGrid$lambda$1(pages, onPageClick, onPageLongClick, onThumbnailNeeded, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPagesGrid$lambda$0$0(ImmutableList immutableList, final Function1 function1, final Function1 function12, final Function1 function13, LazyGridScope LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        final ImmutableList immutableList2 = immutableList;
        final C6871x1c38514f c6871x1c38514f = new Function1() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$TrashedPagesGrid$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(PageModel pageModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((PageModel) obj);
            }
        };
        LazyVerticalGrid.items(immutableList2.size(), null, null, new Function1<Integer, Object>() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$TrashedPagesGrid$lambda$0$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return c6871x1c38514f.invoke(immutableList2.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1117249557, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$TrashedPagesGrid$lambda$0$0$$inlined$items$default$5
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)539@23988L22:LazyGridDsl.kt#7791vq");
                if ((i2 & 6) == 0) {
                    i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
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
                    ComposerKt.traceEventStart(-1117249557, i3, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:539)");
                }
                PageModel pageModel = (PageModel) immutableList2.get(i);
                composer.startReplaceGroup(894779213);
                ComposerKt.sourceInformation(composer, "CN(it)*134@6418L101:trashedPages.kt#qp0phu");
                TrashedPagesKt.TrashedPageItem(pageModel, function1, function12, function13, Modifier.INSTANCE, composer, 24576, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    public static final void TrashDisplayMode(Modifier modifier, final TrashViewModel trashViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(trashViewModel, "trashViewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-915307677);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrashDisplayMode)N(modifier,trashViewModel)141@6689L37,143@6794L38,143@6732L101:trashedPages.kt#qp0phu");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(trashViewModel) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-915307677, i3, -1, "com.myscript.nebo.trash.ui.compose.TrashDisplayMode (trashedPages.kt:140)");
            }
            int iconResource = TrashDisplayMode$lambda$0(LiveDataAdapterKt.observeAsState(trashViewModel.getTrashedPagesState(), new TrashedPagesUIState(null, null, 0, false, false, false, null, 127, null), composerStartRestartGroup, 0)).getDisplayMode().getIconResource();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 857625897, "CC(remember):trashedPages.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(trashViewModel);
            TrashedPagesKt$TrashDisplayMode$1$1 trashedPagesKt$TrashDisplayMode$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || trashedPagesKt$TrashDisplayMode$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                trashedPagesKt$TrashDisplayMode$1$1RememberedValue = new TrashedPagesKt$TrashDisplayMode$1$1(trashViewModel);
                composerStartRestartGroup.updateRememberedValue(trashedPagesKt$TrashDisplayMode$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            NotesDisplayModeKt.DisplayModeButton(companion, iconResource, (Function0) ((KFunction) trashedPagesKt$TrashDisplayMode$1$1RememberedValue), composerStartRestartGroup, i3 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesKt.TrashDisplayMode$lambda$2(companion, trashViewModel, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TrashedPagesList(final ImmutableList<PageModel> pages, final Function1<? super PageModel, Unit> onPageClick, final Function1<? super PageModel, Unit> onPageLongClick, final Function1<? super PageModel, Unit> onThumbnailNeeded, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(onPageClick, "onPageClick");
        Intrinsics.checkNotNullParameter(onPageLongClick, "onPageLongClick");
        Intrinsics.checkNotNullParameter(onThumbnailNeeded, "onThumbnailNeeded");
        Composer composerStartRestartGroup = composer.startRestartGroup(-835562049);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrashedPagesList)N(pages,onPageClick,onPageLongClick,onThumbnailNeeded)148@7032L1217,148@7021L1228:trashedPages.kt#qp0phu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(pages) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPageClick) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPageLongClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onThumbnailNeeded) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-835562049, i2, -1, "com.myscript.nebo.trash.ui.compose.TrashedPagesList (trashedPages.kt:147)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 183762336, "CC(remember):trashedPages.kt#9igjgp");
            boolean z = ((i2 & 14) == 4) | ((i2 & 7168) == 2048) | ((i2 & 112) == 32) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return TrashedPagesKt.TrashedPagesList$lambda$0$0(pages, onThumbnailNeeded, onPageClick, onPageLongClick, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, 0, FrameMetricsAggregator.EVERY_DURATION);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesKt.TrashedPagesList$lambda$1(pages, onPageClick, onPageLongClick, onThumbnailNeeded, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPagesList$lambda$0$0(ImmutableList immutableList, final Function1 function1, final Function1 function12, final Function1 function13, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final ImmutableList immutableList2 = immutableList;
        final Function1 function14 = new Function1() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TrashedPagesKt.TrashedPagesList$lambda$0$0$0((PageModel) obj);
            }
        };
        final C6876xc67caaa7 c6876xc67caaa7 = new Function1() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$TrashedPagesList$lambda$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(PageModel pageModel) {
                return null;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((PageModel) obj);
            }
        };
        LazyColumn.items(immutableList2.size(), new Function1<Integer, Object>() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$TrashedPagesList$lambda$0$0$$inlined$items$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function14.invoke(immutableList2.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$TrashedPagesList$lambda$0$0$$inlined$items$default$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return c6876xc67caaa7.invoke(immutableList2.get(i));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$TrashedPagesList$lambda$0$0$$inlined$items$default$4
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:41:0x00d1  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                String absolutePath;
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
                final PageModel pageModel = (PageModel) immutableList2.get(i);
                composer.startReplaceGroup(-1762330002);
                ComposerKt.sourceInformation(composer, "CN(page)*173@8134L28,174@8200L32,159@7426L807:trashedPages.kt#qp0phu");
                if (pageModel.isCorrupted()) {
                    composer.startReplaceGroup(-1762055622);
                    composer.endReplaceGroup();
                } else {
                    File thumbnailFile = pageModel.getThumbnailFile();
                    if (thumbnailFile == null || (absolutePath = thumbnailFile.getAbsolutePath()) == null) {
                        absolutePath = "";
                    }
                    if (!new File(absolutePath).isFile()) {
                        composer.startReplaceGroup(-1762207460);
                        ComposerKt.sourceInformation(composer, "154@7335L63,154@7272L126");
                        PageKey pageKey = pageModel.getPageKey();
                        File thumbnailFile2 = pageModel.getThumbnailFile();
                        ComposerKt.sourceInformationMarkerStart(composer, -56842905, "CC(remember):trashedPages.kt#9igjgp");
                        boolean zChanged = composer.changed(function1) | composer.changed(pageModel);
                        Object objRememberedValue = composer.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = (Function2) new TrashedPagesKt$TrashedPagesList$1$1$2$1$1(function1, pageModel, null);
                            composer.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        EffectsKt.LaunchedEffect(pageKey, thumbnailFile2, (Function2) objRememberedValue, composer, 0);
                        composer.endReplaceGroup();
                    }
                }
                String title = pageModel.getTitle();
                CoverData coverData = CoverKt.getCoverData(pageModel);
                boolean isSelected = pageModel.getIsSelected();
                boolean zIsContainer = pageModel.isContainer();
                boolean zIsCorrupted = pageModel.isCorrupted();
                boolean z = !pageModel.isSupported();
                boolean zIsLanguageMissing = pageModel.isLanguageMissing();
                PageType pageType = pageModel.getPageType();
                int hitCount = pageModel.getHitCount();
                String absolutePath2 = null;
                long lastModificationDate = pageModel.getLastModificationDate();
                File thumbnailFile3 = pageModel.getThumbnailFile();
                if (thumbnailFile3 != null) {
                    absolutePath2 = thumbnailFile3.getAbsolutePath();
                }
                boolean z2 = pageModel.getSelectionState() != SelectionState.NOT_SELECTABLE;
                ComposerKt.sourceInformationMarkerStart(composer, -56817372, "CC(remember):trashedPages.kt#9igjgp");
                boolean zChanged2 = composer.changed(function12) | composer.changed(pageModel);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final Function1 function15 = function12;
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$TrashedPagesList$1$1$2$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function15.invoke(pageModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -56815256, "CC(remember):trashedPages.kt#9igjgp");
                boolean zChanged3 = composer.changed(function13) | composer.changed(pageModel);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    final Function1 function16 = function13;
                    objRememberedValue3 = (Function0) new Function0<Unit>() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$TrashedPagesList$1$1$2$3$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function16.invoke(pageModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                NotesListViewKt.NoteCompactItem(title, coverData, isSelected, zIsContainer, zIsCorrupted, z, zIsLanguageMissing, pageType, hitCount, lastModificationDate, 0, absolutePath2, z2, function0, (Function0) objRememberedValue3, null, composer, 0, 6, 32768);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TrashedPagesList$lambda$0$0$0(PageModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String strUuid = it.getPageKey().uuid();
        Intrinsics.checkNotNullExpressionValue(strUuid, "uuid(...)");
        return strUuid;
    }

    private static final void NotebookDescription(Modifier modifier, final int i, final int i2, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier.Companion companion;
        Composer composerStartRestartGroup = composer.startRestartGroup(-716999707);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotebookDescription)N(modifier,trashedPagesCount,remainingPagesCount)181@8403L120,182@8549L124,183@8704L6,183@8747L8,185@8762L294:trashedPages.kt#qp0phu");
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i5 & 147) != 146, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            companion = i6 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-716999707, i5, -1, "com.myscript.nebo.trash.ui.compose.NotebookDescription (trashedPages.kt:180)");
            }
            String strPluralStringResource = StringResources_androidKt.pluralStringResource(C6079R.plurals.trashed_notebook_detail_deleted_notes, i, new Object[]{Integer.valueOf(i)}, composerStartRestartGroup, i5 & 112);
            String strPluralStringResource2 = StringResources_androidKt.pluralStringResource(C6079R.plurals.trashed_folder_detail_remaining_pages, i2, new Object[]{Integer.valueOf(i2)}, composerStartRestartGroup, (i5 >> 3) & 112);
            long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM2528spacedBy0680j_4 = Arrangement.INSTANCE.m2528spacedBy0680j_4(C1486Dp.m11017constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM2528spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1126384762, "C186@8853L56,186@8838L111,187@9033L10,187@8958L92:trashedPages.kt#qp0phu");
            IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6183R.drawable.ic_delete_outline, composerStartRestartGroup, 0), "", (Modifier) null, jM8147copywmQWz5c$default, composerStartRestartGroup, Painter.$stable | 48, 4);
            TextKt.m4524Text4IGK_g(strPluralStringResource + " " + strPluralStringResource2, (Modifier) null, jM8147copywmQWz5c$default, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody1(), composerStartRestartGroup, 0, 0, 65530);
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesKt.NotebookDescription$lambda$1(companion, i, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void PageTitle(final String str, String str2, Composer composer, final int i, final int i2) {
        int i3;
        String str3;
        Composer composer2;
        final String str4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float disabled;
        Composer composerStartRestartGroup = composer.startRestartGroup(626854232);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PageTitle)N(title,extension)194@9175L6,195@9254L8,205@9641L10,196@9268L595:trashedPages.kt#qp0phu");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                str3 = str2;
                i3 |= composerStartRestartGroup.changed(str3) ? 32 : 16;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                str4 = str3;
            } else {
                String str5 = i4 != 0 ? null : str3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(626854232, i3, -1, "com.myscript.nebo.trash.ui.compose.PageTitle (trashedPages.kt:192)");
                }
                long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null);
                composerStartRestartGroup.startReplaceGroup(1111502423);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                composerStartRestartGroup.startReplaceGroup(1111503823);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*198@9348L43");
                String str6 = str;
                String strStringResource = str6.length() == 0 ? StringResources_androidKt.stringResource(C6079R.string.untitled_page, composerStartRestartGroup, 0) : str6;
                composerStartRestartGroup.endReplaceGroup();
                builder.append(strStringResource);
                if (str5 != null) {
                    int iPushStyle = builder.pushStyle(new SpanStyle(jM8147copywmQWz5c$default, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (DefaultConstructorMarker) null));
                    try {
                        builder.append(str5);
                        Unit unit = Unit.INSTANCE;
                    } finally {
                        builder.pop(iPushStyle);
                    }
                }
                AnnotatedString annotatedString = builder.toAnnotatedString();
                composerStartRestartGroup.endReplaceGroup();
                TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBody2();
                Modifier.Companion companion = Modifier.INSTANCE;
                if (str6.length() == 0) {
                    composerStartRestartGroup.startReplaceGroup(1111516352);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@9731L8");
                    disabled = ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1162635462);
                    composerStartRestartGroup.endReplaceGroup();
                    disabled = 1.0f;
                }
                str4 = str5;
                composer2 = composerStartRestartGroup;
                TextKt.m4525TextIbK3jfQ(annotatedString, AlphaKt.alpha(companion, disabled), 0L, 0L, null, null, null, 0L, null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, TextOverflow.INSTANCE.m10953getEllipsisgIe3tQ8(), false, 2, 0, null, null, body2, composer2, 0, 3120, 120316);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TrashedPagesKt.PageTitle$lambda$1(str, str4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 48;
        str3 = str2;
        if (composerStartRestartGroup.shouldExecute((i3 & 19) == 18, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    private static final void FormattedModificationDate(final long j, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-677744565);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FormattedModificationDate)N(timestamp)214@9994L7,215@10049L6,215@10092L8,216@10137L10,214@9940L258:trashedPages.kt#qp0phu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-677744565, i2, -1, "com.myscript.nebo.trash.ui.compose.FormattedModificationDate (trashedPages.kt:213)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String timestampToString = CommonUtils.formatTimestampToString((Context) objConsume, j);
            Intrinsics.checkNotNullExpressionValue(timestampToString, "formatTimestampToString(...)");
            composer2 = composerStartRestartGroup;
            TextKt.m4524Text4IGK_g(timestampToString, (Modifier) null, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composerStartRestartGroup, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.m10888boximpl(TextAlign.INSTANCE.m10895getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getCaption(), composer2, 0, 0, 65018);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesKt.FormattedModificationDate$lambda$0(j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TrashedPageItem(final PageModel pageModel, final Function1<? super PageModel, Unit> function1, final Function1<? super PageModel, Unit> function12, final Function1<? super PageModel, Unit> function13, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM4202getOnSurface0d7_KjU;
        final boolean z;
        boolean z2;
        Object objRememberedValue;
        boolean z3;
        Object objRememberedValue2;
        String absolutePath;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2106760904);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TrashedPageItem)N(pageModel,onPageClick,onPageLongClick,onThumbnailNeeded,modifier)239@11100L30,238@11030L26,244@11353L2005,234@10867L2491:trashedPages.kt#qp0phu");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(pageModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function13) ? 2048 : 1024;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2106760904, i3, -1, "com.myscript.nebo.trash.ui.compose.TrashedPageItem (trashedPages.kt:222)");
                }
                if (pageModel.getIsSelected()) {
                    composerStartRestartGroup.startReplaceGroup(-1667624001);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@10516L6");
                    jM4202getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1667622911);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@10550L6");
                    jM4202getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                long j = jM4202getOnSurface0d7_KjU;
                if (!pageModel.isCorrupted()) {
                    File thumbnailFile = pageModel.getThumbnailFile();
                    if (thumbnailFile == null || (absolutePath = thumbnailFile.getAbsolutePath()) == null) {
                        absolutePath = "";
                    }
                    if (!new File(absolutePath).isFile()) {
                        z = true;
                    }
                    if (!z) {
                    }
                    Modifier modifierHeight = IntrinsicKt.height(companion, IntrinsicSize.Max);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1667605514, "CC(remember):trashedPages.kt#9igjgp");
                    int i5 = i3 & 14;
                    z2 = ((i3 & 896) != 256) | (i5 != 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TrashedPagesKt.TrashedPageItem$lambda$1$0(function12, pageModel);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        Function0 function0 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1667607758, "CC(remember):trashedPages.kt#9igjgp");
                        z3 = ((i3 & 112) != 32) | (i5 != 4);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z3) {
                            objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return TrashedPagesKt.TrashedPageItem$lambda$2$0(function1, pageModel);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierM2072combinedClickablehoGz1lA$default = ClickableKt.m2072combinedClickablehoGz1lA$default(modifierHeight, false, null, null, null, function0, null, false, null, (Function0) objRememberedValue2, 239, null);
                            RoundedCornerShape roundedCornerShapeM3235RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(8));
                            BorderStroke borderStrokeM2051BorderStrokecXLIe8U = BorderStrokeKt.m2051BorderStrokecXLIe8U(C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM(), Color.m8147copywmQWz5c$default(j, !pageModel.getIsSelected() ? 1.0f : 0.1f, 0.0f, 0.0f, 0.0f, 14, null));
                            float fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1078353947, true, new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TrashedPagesKt.TrashedPageItem$lambda$3(pageModel, z, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            Modifier modifier4 = companion;
                            composer2 = composerStartRestartGroup;
                            CardKt.m4173CardFjzlyU(modifierM2072combinedClickablehoGz1lA$default, roundedCornerShapeM3235RoundedCornerShape0680j_4, 0L, 0L, borderStrokeM2051BorderStrokecXLIe8U, fM11017constructorimpl, composableLambdaRememberComposableLambda, composer2, 1769472, 12);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier4;
                        }
                    }
                } else {
                    z = false;
                    if (!z) {
                        composerStartRestartGroup.startReplaceGroup(-156536899);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "229@10803L52,229@10730L125");
                        PageKey pageKey = pageModel.getPageKey();
                        File thumbnailFile2 = pageModel.getThumbnailFile();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1667614996, "CC(remember):trashedPages.kt#9igjgp");
                        boolean z4 = ((i3 & 7168) == 2048) | ((i3 & 14) == 4);
                        TrashedPagesKt$TrashedPageItem$1$1 trashedPagesKt$TrashedPageItem$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z4 || trashedPagesKt$TrashedPageItem$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            trashedPagesKt$TrashedPageItem$1$1RememberedValue = new TrashedPagesKt$TrashedPageItem$1$1(function13, pageModel, null);
                            composerStartRestartGroup.updateRememberedValue(trashedPagesKt$TrashedPageItem$1$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(pageKey, thumbnailFile2, (Function2) trashedPagesKt$TrashedPageItem$1$1RememberedValue, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-156401398);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    Modifier modifierHeight2 = IntrinsicKt.height(companion, IntrinsicSize.Max);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1667605514, "CC(remember):trashedPages.kt#9igjgp");
                    int i52 = i3 & 14;
                    z2 = ((i3 & 896) != 256) | (i52 != 4);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TrashedPagesKt.TrashedPageItem$lambda$1$0(function12, pageModel);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function02 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1667607758, "CC(remember):trashedPages.kt#9igjgp");
                    z3 = ((i3 & 112) != 32) | (i52 != 4);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return TrashedPagesKt.TrashedPageItem$lambda$2$0(function1, pageModel);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierM2072combinedClickablehoGz1lA$default2 = ClickableKt.m2072combinedClickablehoGz1lA$default(modifierHeight2, false, null, null, null, function02, null, false, null, (Function0) objRememberedValue2, 239, null);
                    RoundedCornerShape roundedCornerShapeM3235RoundedCornerShape0680j_42 = RoundedCornerShapeKt.m3235RoundedCornerShape0680j_4(C1486Dp.m11017constructorimpl(8));
                    BorderStroke borderStrokeM2051BorderStrokecXLIe8U2 = BorderStrokeKt.m2051BorderStrokecXLIe8U(C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM(), Color.m8147copywmQWz5c$default(j, !pageModel.getIsSelected() ? 1.0f : 0.1f, 0.0f, 0.0f, 0.0f, 14, null));
                    float fM11017constructorimpl2 = C1486Dp.m11017constructorimpl(0);
                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1078353947, true, new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TrashedPagesKt.TrashedPageItem$lambda$3(pageModel, z, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    Modifier modifier42 = companion;
                    composer2 = composerStartRestartGroup;
                    CardKt.m4173CardFjzlyU(modifierM2072combinedClickablehoGz1lA$default2, roundedCornerShapeM3235RoundedCornerShape0680j_42, 0L, 0L, borderStrokeM2051BorderStrokecXLIe8U2, fM11017constructorimpl2, composableLambdaRememberComposableLambda2, composer2, 1769472, 12);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier42;
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TrashedPagesKt.TrashedPageItem$lambda$4(pageModel, function1, function12, function13, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i3 |= 24576;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) == 9362, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPageItem$lambda$2$0(Function1 function1, PageModel pageModel) {
        function1.invoke(pageModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TrashedPageItem$lambda$1$0(Function1 function1, PageModel pageModel) {
        function1.invoke(pageModel);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0255  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void Thumbnail(final String str, final int i, final int i2, final PageType pageType, final boolean z, Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        Modifier modifier4;
        float fM11017constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(1459007556);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Thumbnail)N(thumbnailFile,childPageCount,backgroundColor,pageType,isLoading,modifier)330@15369L232:trashedPages.kt#qp0phu");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(pageType.ordinal()) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        int i7 = i4 & 32;
        if (i7 == 0) {
            if ((196608 & i3) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            if (composerStartRestartGroup.shouldExecute((74899 & i5) == 74898, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1459007556, i5, -1, "com.myscript.nebo.trash.ui.compose.Thumbnail (trashedPages.kt:289)");
                }
                if (str != null) {
                    composerStartRestartGroup.startReplaceGroup(225340031);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (pageType == PageType.PDF) {
                        composerStartRestartGroup.startReplaceGroup(225351749);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "305@14181L225,298@13809L682");
                        int i8 = i5;
                        final long jM8147copywmQWz5c$default = Color.m8147copywmQWz5c$default(Color.INSTANCE.m8174getBlack0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null);
                        boolean z2 = i > 1;
                        Modifier modifierRotate = RotateKt.rotate(BorderKt.m2033borderxT4_qwU(PaddingKt.m2854padding3ABfNKs(companion, C1486Dp.m11017constructorimpl(8)), C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM(), jM8147copywmQWz5c$default, RectangleShapeKt.getRectangleShape()), z2 ? 4.0f : 0.0f);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1946948613, "CC(remember):trashedPages.kt#9igjgp");
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return TrashedPagesKt.Thumbnail$lambda$0$0(jM8147copywmQWz5c$default, (DrawScope) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i6 = i8;
                        modifier4 = companion;
                        SingletonAsyncImageKt.m12342AsyncImagegl8XCv8(str, null, RotateKt.rotate(DrawModifierKt.drawBehind(modifierRotate, (Function1) objRememberedValue), z2 ? -4.0f : 0.0f), null, null, null, null, 0.0f, null, 0, false, null, composerStartRestartGroup, (i8 & 14) | 48, 0, 4088);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        i6 = i5;
                        Modifier modifier5 = companion;
                        composerStartRestartGroup.startReplaceGroup(226207628);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "314@14693L21,319@14937L410");
                        long jColor = ColorKt.Color(PageBackgroundUtilsKt.resolveBackgroundColor(i2, DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0)));
                        if (Color.m8149equalsimpl0(jColor, Color.INSTANCE.m8174getBlack0d7_KjU())) {
                            composerStartRestartGroup.startReplaceGroup(226449800);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "316@14817L92");
                            jColor = ColorResources_androidKt.colorResource(C6183R.color.black_thumbnail_background_special_case, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(226593950);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(AspectRatioKt.aspectRatio$default(modifier5, 1.0f, false, 2, null), jColor, null, 2, null);
                        if (pageType == PageType.RawContent) {
                            composerStartRestartGroup.startReplaceGroup(1946983071);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "325@15263L59");
                            fM11017constructorimpl = PrimitiveResources_androidKt.dimensionResource(C6079R.dimen.grid_item_thumbnail_padding, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1946985158);
                            composerStartRestartGroup.endReplaceGroup();
                            fM11017constructorimpl = C1486Dp.m11017constructorimpl(0);
                        }
                        modifier4 = modifier5;
                        SingletonAsyncImageKt.m12342AsyncImagegl8XCv8(str, null, PaddingKt.m2854padding3ABfNKs(modifierM2016backgroundbw27NRU$default, fM11017constructorimpl), null, null, null, null, 0.0f, null, 0, false, null, composerStartRestartGroup, (i6 & 14) | 48, 0, 4088);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    i6 = i5;
                    modifier4 = companion;
                    composerStartRestartGroup.startReplaceGroup(227030430);
                    composerStartRestartGroup.endReplaceGroup();
                }
                int i9 = i6 >> 12;
                AnimatedVisibilityKt.AnimatedVisibility(z, modifier4, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableSingletons$TrashedPagesKt.INSTANCE.m13433getLambda$186940644$app_standardRelease(), composerStartRestartGroup, (i9 & 14) | 200064 | (i9 & 112), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TrashedPagesKt.Thumbnail$lambda$1(str, i, i2, pageType, z, modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i5 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
        modifier2 = modifier;
        if (composerStartRestartGroup.shouldExecute((74899 & i5) == 74898, i5 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thumbnail$lambda$0$0(long j, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        DrawScope.m8723drawRectnJ9OG0$default(drawBehind, j, 0L, drawBehind.mo8729getSizeNHjbRc(), 0.0f, new Stroke(drawBehind.mo2191toPx0680j_4(C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM()), 0.0f, 0, 0, null, 30, null), null, 0, 106, null);
        DrawScope.m8723drawRectnJ9OG0$default(drawBehind, Color.INSTANCE.m8185getWhite0d7_KjU(), 0L, drawBehind.mo8729getSizeNHjbRc(), 0.0f, null, null, 0, PDFACompliance.e_PDFA1_2_2, null);
        return Unit.INSTANCE;
    }

    private static final void CorruptedState(final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1197848299);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CorruptedState)N(modifier)342@15670L604:trashedPages.kt#qp0phu");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1197848299, i2, -1, "com.myscript.nebo.trash.ui.compose.CorruptedState (trashedPages.kt:341)");
            }
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(modifier, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1372842062, "C344@15756L42,346@15866L45,343@15708L263,351@16028L37,350@15980L288:trashedPages.kt#qp0phu");
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6079R.drawable.ic_top_triangle, composerStartRestartGroup, 6), (String) null, SizeKt.m2924size3ABfNKs(modifier, C1486Dp.m11017constructorimpl(48)), ColorResources_androidKt.colorResource(C6079R.color.corrupted_page_warning, composerStartRestartGroup, 0), composerStartRestartGroup, 48, 0);
            IconKt.m4301Iconww6aTOc(VectorResources_androidKt.vectorResource(ImageVector.INSTANCE, C6079R.drawable.ic_warning, composerStartRestartGroup, 6), (String) null, SizeKt.m2924size3ABfNKs(PaddingKt.m2854padding3ABfNKs(modifier, C1486Dp.m11017constructorimpl(4)), C1486Dp.m11017constructorimpl(20)), Color.INSTANCE.m8185getWhite0d7_KjU(), composerStartRestartGroup, 3120, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesKt.CorruptedState$lambda$1(modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SelectionState(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1185484770);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionState)367@16423L6,365@16326L618:trashedPages.kt#qp0phu");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1185484770, i, -1, "com.myscript.nebo.trash.ui.compose.SelectionState (trashedPages.kt:364)");
            }
            Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2016backgroundbw27NRU$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2142614072, "C373@16651L6,369@16475L463:trashedPages.kt#qp0phu");
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(BackgroundKt.m2016backgroundbw27NRU$default(boxScopeInstance.align(ClipKt.clip(PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(8)), RoundedCornerShapeKt.getCircleShape()), Alignment.INSTANCE.getBottomEnd()), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), null, 2, null), C1486Dp.m11017constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM2854padding3ABfNKs);
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
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -607048064, "C378@16759L42,380@16897L6,377@16723L205:trashedPages.kt#qp0phu");
            IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6183R.drawable.ic_check, composerStartRestartGroup, 0), "Selected", (Modifier) null, MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4200getOnPrimary0d7_KjU(), composerStartRestartGroup, Painter.$stable | 48, 4);
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
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.trash.ui.compose.TrashedPagesKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrashedPagesKt.SelectionState$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final TrashedPagesUIState TrashedPagesPane$lambda$0(State<TrashedPagesUIState> state) {
        return state.getValue();
    }

    private static final TrashedPagesUIState TrashDisplayMode$lambda$0(State<TrashedPagesUIState> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit TrashedPageItem$lambda$3(PageModel pageModel, boolean z, Composer composer, int i) {
        int i2;
        String str;
        float f;
        FiniteAnimationSpec finiteAnimationSpec;
        String str2;
        ComposerKt.sourceInformation(composer, "C245@11363L1852,282@13225L127:trashedPages.kt#qp0phu");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1078353947, i, -1, "com.myscript.nebo.trash.ui.compose.TrashedPageItem.<anonymous> (trashedPages.kt:245)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1239009494, "C247@11385L1222,273@12751L58,270@12621L584:trashedPages.kt#qp0phu");
            Modifier modifierAspectRatio$default = AspectRatioKt.aspectRatio$default(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 1.0f, false, 2, null);
            if (pageModel.getPageType() == PageType.PDF || pageModel.isContainer()) {
                composer.startReplaceGroup(1009805116);
                ComposerKt.sourceInformation(composer, "251@11620L43");
                i2 = C6079R.color.grid_background;
            } else {
                composer.startReplaceGroup(1009806699);
                ComposerKt.sourceInformation(composer, "251@11669L58");
                i2 = C6079R.color.grid_view_page_item_background;
            }
            long jColorResource = ColorResources_androidKt.colorResource(i2, composer, 0);
            composer.endReplaceGroup();
            Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(BackgroundKt.m2016backgroundbw27NRU$default(modifierAspectRatio$default, jColorResource, null, 2, null), C1486Dp.m11017constructorimpl(pageModel.isContainer() ? 8 : 0));
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
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
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -631604407, "C:trashedPages.kt#qp0phu");
            if (pageModel.isContainer()) {
                composer.startReplaceGroup(-631590861);
                ComposerKt.sourceInformation(composer, "256@11935L240");
                f = 0.0f;
                str = "C89@4557L9:Column.kt#2w3rfo";
                str2 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
                finiteAnimationSpec = null;
                CoverKt.m13292CoverxKlaLpw(CoverKt.getCoverData(pageModel), CoverKt.isPortrait(pageModel) ? Modifier.INSTANCE : SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, 0.0f, 0.0f, 0.0f, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 56);
                composer.endReplaceGroup();
            } else {
                str = "C89@4557L9:Column.kt#2w3rfo";
                f = 0.0f;
                finiteAnimationSpec = null;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
                if (!pageModel.isEmpty()) {
                    composer.startReplaceGroup(-631285015);
                    ComposerKt.sourceInformation(composer, "262@12245L186");
                    File thumbnailFile = pageModel.getThumbnailFile();
                    Thumbnail(thumbnailFile != null ? thumbnailFile.getAbsolutePath() : null, pageModel.getChildPageCount(), pageModel.getBackgroundColor(), pageModel.getPageType(), z, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), composer, 0, 0);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-631067829);
                    composer.endReplaceGroup();
                }
            }
            if (pageModel.isCorrupted()) {
                composer.startReplaceGroup(-631020120);
                ComposerKt.sourceInformation(composer, "266@12516L59");
                CorruptedState(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-630924981);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierM2855paddingVpY3zN4 = PaddingKt.m2855paddingVpY3zN4(BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(64)), f, 1, finiteAnimationSpec), ColorResources_androidKt.colorResource(C6079R.color.grid_view_page_item_info_background, composer, 0), null, 2, null), C1486Dp.m11017constructorimpl(8), C1486Dp.m11017constructorimpl(4));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM2855paddingVpY3zN4);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, str2);
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM7248constructorimpl3 = Updater.m7248constructorimpl(composer);
            Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, str);
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1399924474, "C277@13029L88,278@13134L57:trashedPages.kt#qp0phu");
            PageTitle(pageModel.getTitle(), Boolean.valueOf(pageModel.getPageType() == PageType.PDF).booleanValue() ? ".pdf" : finiteAnimationSpec, composer, 0, 0);
            FormattedModificationDate(pageModel.getLastModificationDate(), composer, 0);
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
            AnimatedVisibilityKt.AnimatedVisibility(pageModel.getIsSelected(), (Modifier) null, EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec, f, 3, finiteAnimationSpec), EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec, f, 3, finiteAnimationSpec), (String) null, ComposableSingletons$TrashedPagesKt.INSTANCE.m13432getLambda$1018431757$app_standardRelease(), composer, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
