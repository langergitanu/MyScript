package com.myscript.nebo.editing.p028ui.compose;

import android.graphics.Rect;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
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
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.ContentAlpha;
import androidx.compose.material.ContentColorKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Alignment;
import androidx.compose.p004ui.ComposedModifierKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.graphics.Color;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.graphics.painter.Painter;
import androidx.compose.p004ui.layout.ContentScale;
import androidx.compose.p004ui.layout.LayoutCoordinates;
import androidx.compose.p004ui.layout.LayoutCoordinatesKt;
import androidx.compose.p004ui.layout.MeasurePolicy;
import androidx.compose.p004ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p004ui.node.ComposeUiNode;
import androidx.compose.p004ui.res.ColorResources_androidKt;
import androidx.compose.p004ui.res.PainterResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.p004ui.unit.C1486Dp;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import androidx.window.core.layout.WindowSizeClass;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImageKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.dms.core.model.SelectionState;
import com.myscript.nebo.editing.ChildPage;
import com.myscript.nebo.editing.ChildPageAction;
import com.myscript.nebo.p034ui.compose.component.DropdownMenuItemKt;
import com.myscript.nebo.p034ui.compose.component.VerticalDividerKt;
import com.pdftron.pdf.pdfa.PDFACompliance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ChildPagesPane.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a·\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0007¢\u0006\u0002\u0010\u001b\u001aË\u0002\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\u001a\b\u0002\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020 2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0007¢\u0006\u0002\u0010&\u001a¹\u0002\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00022\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u001e\b\u0002\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u0002`\u000e2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00012\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007¢\u0006\u0002\u0010*\u001a\u001e\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.H\u0086@¢\u0006\u0002\u0010/\u001a\u0015\u00100\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0002H\u0007¢\u0006\u0002\u00101\u001a\r\u00102\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103\u001a\r\u00104\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103\u001a\r\u00105\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103\u001a\r\u00106\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103\u001a\r\u00107\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103\u001a\r\u00108\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103\u001a\r\u00109\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103\u001a\r\u0010:\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103\u001a\r\u0010;\u001a\u00020\u0006H\u0007¢\u0006\u0002\u00103*.\u0010\u0000\"\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001¨\u0006<²\u0006\n\u0010=\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010>\u001a\u00020 X\u008a\u0084\u0002²\u0006\f\u0010?\u001a\u0004\u0018\u00010@X\u008a\u008e\u0002²\u0006\n\u0010A\u001a\u00020\bX\u008a\u008e\u0002²\u0006\u0010\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u008a\u008e\u0002"}, m1599d2 = {"ChildPageActionsProvider", "Lkotlin/Function1;", "Lcom/myscript/nebo/editing/ChildPage;", "", "Lcom/myscript/nebo/editing/ChildPageAction;", "ChildPagesPane", "", "displayPageInsertionButton", "", "childPages", "Lkotlinx/collections/immutable/ImmutableList;", "onPageClick", "onLongPageClick", "onChildPageActionsRequest", "Lcom/myscript/nebo/editing/ui/compose/ChildPageActionsProvider;", "onInsertPage", "onDuplicatePage", "onMovePageUp", "onMovePageDown", "onExportPage", "onUpdatePageBackground", "onManagePages", "onDeletePage", "onThumbnailRequest", "onAddPageButtonPositionChanged", "Lkotlin/Function2;", "Landroid/graphics/Rect;", "(ZLkotlinx/collections/immutable/ImmutableList;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ChildPagesList", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "modifier", "Landroidx/compose/ui/Modifier;", "onAddPagePositionChanged", "(ZLkotlinx/collections/immutable/ImmutableList;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "AddChildPageButton", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "ChildPageItem", "isManagingPages", "childPage", "(ZLcom/myscript/nebo/editing/ChildPage;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;III)V", "scrollToSelectedChildPage", "lazyListState", "selectedChildPageIndex", "", "(Landroidx/compose/foundation/lazy/LazyListState;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PreviewChildPageItem", "(Lcom/myscript/nebo/editing/ChildPage;Landroidx/compose/runtime/Composer;I)V", "AddChildPageButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "SelectedChildPageItem", "SelectedChildPageItemNight", "NotSelectedChildPageItem", "NotSelectedChildPageItemNight", "SelectedChildPageCorrupted", "SelectedChildPageItemCorruptedNight", "ChildPagesListPreview", "ChildPagesListPreviewNight", "app_standardRelease", "hasDuplicatedIds", "itemPlacementModifier", "lastThumbnailSuccessState", "Lcoil/compose/AsyncImagePainter$State$Success;", "moreMenuOpened", "childPageActions"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChildPagesPaneKt {

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$scrollToSelectedChildPage$1 */
    /* JADX INFO: compiled from: ChildPagesPane.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt", m1609f = "ChildPagesPane.kt", m1610i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m1611l = {477, 482}, m1612m = "scrollToSelectedChildPage", m1613n = {"lazyListState", "layoutInfo", "visibleItemsInfo", "selectedChildPageIndex", "isPartiallyAbove", "isPartiallyBelow", "isVisible", "lazyListState", "layoutInfo", "visibleItemsInfo", "selectedItemInfo", "it", "selectedChildPageIndex", "isPartiallyAbove", "isPartiallyBelow", "isVisible", "$i$a$-let-ChildPagesPaneKt$scrollToSelectedChildPage$2", "scrollDistance"}, m1614nl = {487, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND}, m1615s = {"L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5"}, m1616v = 2)
    static final class C64501 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C64501(Continuation<? super C64501> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChildPagesPaneKt.scrollToSelectedChildPage(null, 0, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddChildPageButton$lambda$0(Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        AddChildPageButton(modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddChildPageButtonPreview$lambda$1(int i, Composer composer, int i2) {
        AddChildPageButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$26(boolean z, ChildPage childPage, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function1 function111, Function1 function112, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        ChildPageItem(z, childPage, function1, function12, function13, function14, function15, function16, function17, function18, function19, function110, function111, function112, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesList$lambda$4(boolean z, ImmutableList immutableList, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function1 function111, Function1 function112, LazyListState lazyListState, Modifier modifier, Function2 function2, int i, int i2, int i3, Composer composer, int i4) {
        ChildPagesList(z, immutableList, function1, function12, function13, function14, function15, function16, function17, function18, function19, function110, function111, function112, lazyListState, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$12(int i, Composer composer, int i2) {
        ChildPagesListPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$12(int i, Composer composer, int i2) {
        ChildPagesListPreviewNight(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesPane$lambda$2(boolean z, ImmutableList immutableList, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, Function1 function19, Function1 function110, Function1 function111, Function1 function112, Function2 function2, int i, int i2, Composer composer, int i3) {
        ChildPagesPane(z, immutableList, function1, function12, function13, function14, function15, function16, function17, function18, function19, function110, function111, function112, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotSelectedChildPageItem$lambda$0(int i, Composer composer, int i2) {
        NotSelectedChildPageItem(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotSelectedChildPageItemNight$lambda$0(int i, Composer composer, int i2) {
        NotSelectedChildPageItemNight(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$11(ChildPage childPage, int i, Composer composer, int i2) {
        PreviewChildPageItem(childPage, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedChildPageCorrupted$lambda$0(int i, Composer composer, int i2) {
        SelectedChildPageCorrupted(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedChildPageItem$lambda$0(int i, Composer composer, int i2) {
        SelectedChildPageItem(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedChildPageItemCorruptedNight$lambda$0(int i, Composer composer, int i2) {
        SelectedChildPageItemCorruptedNight(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectedChildPageItemNight$lambda$0(int i, Composer composer, int i2) {
        SelectedChildPageItemNight(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ChildPagesPane(final boolean z, final ImmutableList<ChildPage> childPages, final Function1<? super ChildPage, Unit> onPageClick, final Function1<? super ChildPage, Unit> onLongPageClick, final Function1<? super ChildPage, ? extends List<? extends ChildPageAction>> onChildPageActionsRequest, final Function1<? super ChildPage, Unit> onInsertPage, final Function1<? super ChildPage, Unit> onDuplicatePage, final Function1<? super ChildPage, Unit> onMovePageUp, final Function1<? super ChildPage, Unit> onMovePageDown, final Function1<? super ChildPage, Unit> onExportPage, final Function1<? super ChildPage, Unit> onUpdatePageBackground, final Function1<? super ChildPage, Unit> onManagePages, final Function1<? super ChildPage, Unit> onDeletePage, final Function1<? super ChildPage, Unit> onThumbnailRequest, final Function2<? super Rect, ? super Boolean, Unit> onAddPageButtonPositionChanged, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        int i4;
        Composer composer2;
        Object obj;
        ChildPagesPaneKt$ChildPagesPane$1$1 childPagesPaneKt$ChildPagesPane$1$1;
        Intrinsics.checkNotNullParameter(childPages, "childPages");
        Intrinsics.checkNotNullParameter(onPageClick, "onPageClick");
        Intrinsics.checkNotNullParameter(onLongPageClick, "onLongPageClick");
        Intrinsics.checkNotNullParameter(onChildPageActionsRequest, "onChildPageActionsRequest");
        Intrinsics.checkNotNullParameter(onInsertPage, "onInsertPage");
        Intrinsics.checkNotNullParameter(onDuplicatePage, "onDuplicatePage");
        Intrinsics.checkNotNullParameter(onMovePageUp, "onMovePageUp");
        Intrinsics.checkNotNullParameter(onMovePageDown, "onMovePageDown");
        Intrinsics.checkNotNullParameter(onExportPage, "onExportPage");
        Intrinsics.checkNotNullParameter(onUpdatePageBackground, "onUpdatePageBackground");
        Intrinsics.checkNotNullParameter(onManagePages, "onManagePages");
        Intrinsics.checkNotNullParameter(onDeletePage, "onDeletePage");
        Intrinsics.checkNotNullParameter(onThumbnailRequest, "onThumbnailRequest");
        Intrinsics.checkNotNullParameter(onAddPageButtonPositionChanged, "onAddPageButtonPositionChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(802191480);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChildPagesPane)N(displayPageInsertionButton,childPages,onPageClick,onLongPageClick,onChildPageActionsRequest,onInsertPage,onDuplicatePage,onMovePageUp,onMovePageDown,onExportPage,onUpdatePageBackground,onManagePages,onDeletePage,onThumbnailRequest,onAddPageButtonPositionChanged)104@4642L23,107@4788L76,107@4749L115,111@4870L657:ChildPagesPane.kt#a4olte");
        if ((i & 6) == 0) {
            z2 = z;
            i3 = i | (composerStartRestartGroup.changed(z2) ? 4 : 2);
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(childPages) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onPageClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onLongPageClick) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onChildPageActionsRequest) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onInsertPage) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onDuplicatePage) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onMovePageUp) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onMovePageDown) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onExportPage) ? 536870912 : 268435456;
        }
        int i5 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(onUpdatePageBackground) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onManagePages) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onDeletePage) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onThumbnailRequest) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(onAddPageButtonPositionChanged) ? 16384 : 8192;
        }
        int i6 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i5 & 306783379) == 306783378 && (i6 & 9363) == 9362) ? false : true, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(802191480, i5, i6, "com.myscript.nebo.editing.ui.compose.ChildPagesPane (ChildPagesPane.kt:103)");
            }
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Iterator<ChildPage> it = childPages.iterator();
            int i7 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i7 = -1;
                    break;
                } else if (it.next().isActive()) {
                    break;
                } else {
                    i7++;
                }
            }
            int i8 = i7;
            Integer numValueOf = Integer.valueOf(i8);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2106893380, "CC(remember):ChildPagesPane.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(lazyListStateRememberLazyListState) | composerStartRestartGroup.changed(i8);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = null;
                childPagesPaneKt$ChildPagesPane$1$1 = new ChildPagesPaneKt$ChildPagesPane$1$1(lazyListStateRememberLazyListState, i8, null);
                composerStartRestartGroup.updateRememberedValue(childPagesPaneKt$ChildPagesPane$1$1);
            } else {
                childPagesPaneKt$ChildPagesPane$1$1 = objRememberedValue;
                obj = null;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) childPagesPaneKt$ChildPagesPane$1$1, composerStartRestartGroup, 0);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, obj);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
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
            Updater.m7256setimpl(composerM7248constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1808190046, "C112@4908L564,131@5481L40:ChildPagesPane.kt#a4olte");
            composer2 = composerStartRestartGroup;
            ChildPagesList(z2, childPages, onPageClick, onLongPageClick, onChildPageActionsRequest, onInsertPage, onDuplicatePage, onMovePageUp, onMovePageDown, onExportPage, onUpdatePageBackground, onManagePages, onDeletePage, onThumbnailRequest, lazyListStateRememberLazyListState, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), onAddPageButtonPositionChanged, composer2, i5 & 2147483646, (i6 & 8190) | ((i6 << 6) & 3670016), 0);
            VerticalDividerKt.m13509VerticalDivideroMI9zvI(null, 0L, C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM(), 0.0f, composer2, RendererCapabilities.DECODER_SUPPORT_MASK, 11);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ChildPagesPaneKt.ChildPagesPane$lambda$2(z, childPages, onPageClick, onLongPageClick, onChildPageActionsRequest, onInsertPage, onDuplicatePage, onMovePageUp, onMovePageDown, onExportPage, onUpdatePageBackground, onManagePages, onDeletePage, onThumbnailRequest, onAddPageButtonPositionChanged, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesList$lambda$0$0(Rect rect, boolean z) {
        Intrinsics.checkNotNullParameter(rect, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final void ChildPagesList(final boolean z, final ImmutableList<ChildPage> childPages, final Function1<? super ChildPage, Unit> onPageClick, final Function1<? super ChildPage, Unit> onLongPageClick, final Function1<? super ChildPage, ? extends List<? extends ChildPageAction>> onChildPageActionsRequest, final Function1<? super ChildPage, Unit> onInsertPage, final Function1<? super ChildPage, Unit> onDuplicatePage, final Function1<? super ChildPage, Unit> onMovePageUp, final Function1<? super ChildPage, Unit> onMovePageDown, final Function1<? super ChildPage, Unit> onExportPage, final Function1<? super ChildPage, Unit> onUpdatePageBackground, final Function1<? super ChildPage, Unit> onManagePages, final Function1<? super ChildPage, Unit> onDeletePage, final Function1<? super ChildPage, Unit> onThumbnailRequest, final LazyListState listState, Modifier modifier, Function2<? super Rect, ? super Boolean, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        Composer composer2;
        final Modifier modifier2;
        final Function2<? super Rect, ? super Boolean, Unit> function22;
        final Function2<? super Rect, ? super Boolean, Unit> function23;
        int i4;
        Intrinsics.checkNotNullParameter(childPages, "childPages");
        Intrinsics.checkNotNullParameter(onPageClick, "onPageClick");
        Intrinsics.checkNotNullParameter(onLongPageClick, "onLongPageClick");
        Intrinsics.checkNotNullParameter(onChildPageActionsRequest, "onChildPageActionsRequest");
        Intrinsics.checkNotNullParameter(onInsertPage, "onInsertPage");
        Intrinsics.checkNotNullParameter(onDuplicatePage, "onDuplicatePage");
        Intrinsics.checkNotNullParameter(onMovePageUp, "onMovePageUp");
        Intrinsics.checkNotNullParameter(onMovePageDown, "onMovePageDown");
        Intrinsics.checkNotNullParameter(onExportPage, "onExportPage");
        Intrinsics.checkNotNullParameter(onUpdatePageBackground, "onUpdatePageBackground");
        Intrinsics.checkNotNullParameter(onManagePages, "onManagePages");
        Intrinsics.checkNotNullParameter(onDeletePage, "onDeletePage");
        Intrinsics.checkNotNullParameter(onThumbnailRequest, "onThumbnailRequest");
        Intrinsics.checkNotNullParameter(listState, "listState");
        Composer composerStartRestartGroup = composer.startRestartGroup(-242536070);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChildPagesList)N(displayPageInsertionButton,childPages,onPageClick,onLongPageClick,onChildPageActionsRequest,onInsertPage,onDuplicatePage,onMovePageUp,onMovePageDown,onExportPage,onUpdatePageBackground,onManagePages,onDeletePage,onThumbnailRequest,listState,modifier,onAddPagePositionChanged)154@6318L11,162@6811L135,171@7072L2209,167@6952L2329:ChildPagesPane.kt#a4olte");
        int i5 = (i & 6) == 0 ? i | (composerStartRestartGroup.changed(z) ? 4 : 2) : i;
        if ((i & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(childPages) ? 32 : 16;
        }
        if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onPageClick) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onLongPageClick) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onChildPageActionsRequest) ? 16384 : 8192;
        }
        if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onInsertPage) ? 131072 : 65536;
        }
        int i6 = 1572864;
        if ((i & 1572864) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onDuplicatePage) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onMovePageUp) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onMovePageDown) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onExportPage) ? 536870912 : 268435456;
        }
        int i7 = i5;
        int i8 = (i2 & 6) == 0 ? i2 | (composerStartRestartGroup.changedInstance(onUpdatePageBackground) ? 4 : 2) : i2;
        if ((i2 & 48) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(onManagePages) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(onDeletePage) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i8 |= composerStartRestartGroup.changedInstance(onThumbnailRequest) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i8 |= composerStartRestartGroup.changed(listState) ? 16384 : 8192;
        }
        int i9 = i3 & 32768;
        if (i9 != 0) {
            i8 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
        } else if ((i2 & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
            i8 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        int i10 = i3 & 65536;
        if (i10 != 0) {
            i8 |= i6;
        } else if ((i2 & 1572864) == 0) {
            i6 = composerStartRestartGroup.changedInstance(function2) ? 1048576 : 524288;
            i8 |= i6;
        }
        int i11 = i8;
        if (!composerStartRestartGroup.shouldExecute(((i7 & 306783379) == 306783378 && (599187 & i11) == 599186) ? false : true, i7 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            function22 = function2;
        } else {
            Modifier modifier3 = i9 != 0 ? Modifier.INSTANCE : modifier;
            if (i10 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1148905787, "CC(remember):ChildPagesPane.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChildPagesPaneKt.ChildPagesList$lambda$0$0((Rect) obj, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function23 = (Function2) objRememberedValue;
            } else {
                function23 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-242536070, i7, i11, "com.myscript.nebo.editing.ui.compose.ChildPagesList (ChildPagesPane.kt:155)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1148889887, "CC(remember):ChildPagesPane.kt#9igjgp");
            int i12 = i7 & 112;
            boolean z2 = i12 == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (ChildPage childPage : childPages) {
                    if (hashSet.add(childPage.getId())) {
                        arrayList.add(childPage);
                    }
                }
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(arrayList.size() != childPages.size()), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            PaddingValues paddingValuesM2847PaddingValues0680j_4 = PaddingKt.m2847PaddingValues0680j_4(C1486Dp.m11017constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1148879461, "CC(remember):ChildPagesPane.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(mutableState) | (i12 == 32) | ((57344 & i11) == 16384) | ((3670016 & i11) == 1048576) | ((i7 & 896) == 256) | ((i7 & 7168) == 2048) | ((57344 & i7) == 16384) | ((458752 & i7) == 131072) | ((3670016 & i7) == 1048576) | ((29360128 & i7) == 8388608) | ((234881024 & i7) == 67108864) | ((1879048192 & i7) == 536870912) | ((i11 & 14) == 4) | ((i11 & 112) == 32) | ((i11 & 896) == 256) | ((i11 & 7168) == 2048) | ((i7 & 14) == 4);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                i4 = i11;
                Function1 function1 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesList$lambda$3$0(childPages, mutableState, onPageClick, onLongPageClick, onChildPageActionsRequest, onInsertPage, onDuplicatePage, onMovePageUp, onMovePageDown, onExportPage, onUpdatePageBackground, onManagePages, onDeletePage, onThumbnailRequest, listState, function23, z, (LazyListScope) obj);
                    }
                };
                composer2 = composerStartRestartGroup;
                composer2.updateRememberedValue(function1);
                objRememberedValue3 = function1;
            } else {
                i4 = i11;
                composer2 = composerStartRestartGroup;
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifier4 = modifier3;
            LazyDslKt.LazyColumn(modifier4, listState, paddingValuesM2847PaddingValues0680j_4, false, null, null, null, false, null, (Function1) objRememberedValue3, composer2, ((i4 >> 15) & 14) | RendererCapabilities.DECODER_SUPPORT_MASK | ((i4 >> 9) & 112), 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function22 = function23;
            modifier2 = modifier4;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.ChildPagesList$lambda$4(z, childPages, onPageClick, onLongPageClick, onChildPageActionsRequest, onInsertPage, onDuplicatePage, onMovePageUp, onMovePageDown, onExportPage, onUpdatePageBackground, onManagePages, onDeletePage, onThumbnailRequest, listState, modifier2, function22, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ChildPagesList$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesList$lambda$3$0(ImmutableList immutableList, MutableState mutableState, final Function1 function1, final Function1 function12, final Function1 function13, final Function1 function14, final Function1 function15, final Function1 function16, final Function1 function17, final Function1 function18, final Function1 function19, final Function1 function110, final Function1 function111, final Function1 function112, final LazyListState lazyListState, final Function2 function2, final boolean z, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function2 function22 = new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ChildPagesPaneKt.ChildPagesList$lambda$3$0$0(((Integer) obj).intValue(), (ChildPage) obj2);
            }
        };
        if (ChildPagesList$lambda$2(mutableState)) {
            function22 = null;
        }
        final ImmutableList immutableList2 = immutableList;
        LazyColumn.items(immutableList2.size(), function22 != null ? new Function1<Integer, Object>() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$ChildPagesList$lambda$3$0$$inlined$itemsIndexed$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function22.invoke(Integer.valueOf(i), immutableList2.get(i));
            }
        } : null, new Function1<Integer, Object>() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$ChildPagesList$lambda$3$0$$inlined$itemsIndexed$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                immutableList2.get(i);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$ChildPagesList$lambda$3$0$$inlined$itemsIndexed$default$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, final int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
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
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                ChildPage childPage = (ChildPage) immutableList2.get(i);
                composer.startReplaceGroup(987362017);
                ComposerKt.sourceInformation(composer, "CN(index,childPage)*175@7364L734,189@8111L574:ChildPagesPane.kt#a4olte");
                ComposerKt.sourceInformationMarkerStart(composer, -1630717286, "CC(remember):ChildPagesPane.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    Modifier modifierAnimateItem$default = LazyItemScope.animateItem$default(lazyItemScope, Modifier.INSTANCE, null, null, null, 7, null);
                    final LazyListState lazyListState2 = lazyListState;
                    final Function2 function23 = function2;
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierAnimateItem$default, new Function1<LayoutCoordinates, Unit>() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$ChildPagesList$2$1$1$itemPlacementModifier$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                            invoke2(layoutCoordinates);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LayoutCoordinates it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if (((LazyListItemInfo) CollectionsKt.first((List) lazyListState2.getLayoutInfo().getVisibleItemsInfo())).getIndex() == i) {
                                long jPositionInWindow = LayoutCoordinatesKt.positionInWindow(it);
                                int i4 = (int) (jPositionInWindow >> 32);
                                int i5 = (int) (jPositionInWindow & 4294967295L);
                                function23.invoke(new Rect(MathKt.roundToInt(Float.intBitsToFloat(i4)), MathKt.roundToInt(Float.intBitsToFloat(i5)) + ((((int) (it.mo9633getSizeYbymL2g() & 4294967295L)) * 2) / 3), MathKt.roundToInt(Float.intBitsToFloat(i4)) + ((int) (it.mo9633getSizeYbymL2g() >> 32)), MathKt.roundToInt(Float.intBitsToFloat(i5)) + ((int) (4294967295L & it.mo9633getSizeYbymL2g()))), true);
                            }
                        }
                    }), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                ChildPagesPaneKt.ChildPageItem(false, childPage, function1, function12, function13, function14, function15, function16, function17, function18, function19, function110, function111, function112, ChildPagesPaneKt.ChildPagesList$lambda$3$0$2$1((MutableState) objRememberedValue), composer, 6, 0, 0);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        final ChildPage childPage = (ChildPage) CollectionsKt.lastOrNull((List) immutableList2);
        if (childPage != null) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(767759946, true, new Function3() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda42
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChildPagesPaneKt.ChildPagesList$lambda$3$0$3(z, function14, childPage, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ChildPagesList$lambda$3$0$0(int i, ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        return childPage.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier ChildPagesList$lambda$3$0$2$1(MutableState<Modifier> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesList$lambda$3$0$3(boolean z, final Function1 function1, final ChildPage childPage, LazyItemScope item, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation(composer, "C215@9189L62,215@9145L106:ChildPagesPane.kt#a4olte");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(767759946, i, -1, "com.myscript.nebo.editing.ui.compose.ChildPagesList.<anonymous>.<anonymous>.<anonymous> (ChildPagesPane.kt:214)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(z ? Modifier.INSTANCE : SizeKt.m2910height3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(0)), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -917061592, "CC(remember):ChildPagesPane.kt#9igjgp");
            boolean zChanged = composer.changed(function1) | composer.changed(childPage);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChildPagesPaneKt.ChildPagesList$lambda$3$0$3$0$0(function1, childPage);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            AddChildPageButton(modifierFillMaxWidth$default, (Function0) objRememberedValue, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesList$lambda$3$0$3$0$0(Function1 function1, ChildPage childPage) {
        function1.invoke(childPage);
        return Unit.INSTANCE;
    }

    public static final void AddChildPageButton(Modifier modifier, final Function0<Unit> onClick, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-132059693);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddChildPageButton)N(modifier,onClick)225@9378L532:ChildPagesPane.kt#a4olte");
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
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-132059693, i3, -1, "com.myscript.nebo.editing.ui.compose.AddChildPageButton (ChildPagesPane.kt:224)");
            }
            ButtonKt.TextButton(onClick, PaddingKt.m2854padding3ABfNKs(modifier3, C1486Dp.m11017constructorimpl(4)), false, null, null, null, null, null, null, ComposableSingletons$ChildPagesPaneKt.INSTANCE.getLambda$526028598$app_standardRelease(), composerStartRestartGroup, ((i3 >> 3) & 14) | 805306368, TypedValues.PositionType.TYPE_CURVE_FIT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.AddChildPageButton$lambda$0(modifier3, onClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$0$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$1$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List ChildPageItem$lambda$2$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$3$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$4$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$5$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$6$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$7$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$8$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$9$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$10$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$11$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x056c  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0575  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0578  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0635  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x06b0  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x06ea  */
    /* JADX WARN: Removed duplicated region for block: B:333:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ChildPageItem(final boolean z, final ChildPage childPage, Function1<? super ChildPage, Unit> function1, Function1<? super ChildPage, Unit> function12, Function1<? super ChildPage, ? extends List<? extends ChildPageAction>> function13, Function1<? super ChildPage, Unit> function14, Function1<? super ChildPage, Unit> function15, Function1<? super ChildPage, Unit> function16, Function1<? super ChildPage, Unit> function17, Function1<? super ChildPage, Unit> function18, Function1<? super ChildPage, Unit> function19, Function1<? super ChildPage, Unit> function110, Function1<? super ChildPage, Unit> function111, Function1<? super ChildPage, Unit> function112, Modifier modifier, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function1<? super ChildPage, Unit> function113;
        int i5;
        Function1<? super ChildPage, Unit> function114;
        int i6;
        Function1<? super ChildPage, ? extends List<? extends ChildPageAction>> function115;
        int i7;
        Function1<? super ChildPage, Unit> function116;
        int i8;
        Function1<? super ChildPage, Unit> function117;
        int i9;
        Function1<? super ChildPage, Unit> function118;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        Composer composer2;
        final Function1<? super ChildPage, Unit> function119;
        final Function1<? super ChildPage, Unit> function120;
        final Function1<? super ChildPage, ? extends List<? extends ChildPageAction>> function121;
        final Function1<? super ChildPage, Unit> function122;
        final Function1<? super ChildPage, Unit> function123;
        final Function1<? super ChildPage, Unit> function124;
        final Function1<? super ChildPage, Unit> function125;
        final Function1<? super ChildPage, Unit> function126;
        final Function1<? super ChildPage, Unit> function127;
        final Function1<? super ChildPage, Unit> function128;
        final Function1<? super ChildPage, Unit> function129;
        final Function1<? super ChildPage, Unit> function130;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Function1<? super ChildPage, Unit> function131;
        final Function1<? super ChildPage, Unit> function132;
        int i24;
        final Function1<? super ChildPage, Unit> function133;
        final Function1<? super ChildPage, Unit> function134;
        int i25;
        final Function1<? super ChildPage, Unit> function135;
        int i26;
        final Function1<? super ChildPage, Unit> function136;
        final Function1<? super ChildPage, Unit> function137;
        final Function1<? super ChildPage, Unit> function138;
        Function1<? super ChildPage, Unit> function139;
        boolean zIsActive;
        long jM4202getOnSurface0d7_KjU;
        long jColor;
        MutableState mutableState;
        MutableState mutableState2;
        boolean z2;
        Function1<? super ChildPage, ? extends List<? extends ChildPageAction>> function140;
        final ChildPage childPage2;
        MutableState mutableState3;
        ChildPagesPaneKt$ChildPageItem$13$1 childPagesPaneKt$ChildPageItem$13$1;
        boolean z3;
        ChildPagesPaneKt$ChildPageItem$14$1 childPagesPaneKt$ChildPageItem$14$1RememberedValue;
        boolean z4;
        Object objRememberedValue;
        boolean z5;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        Composer composerStartRestartGroup = composer.startRestartGroup(1394763452);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChildPageItem)N(isManagingPages,childPage,onPageClick,onLongPageClick,onChildPageActionsRequest,onInsertPage,onDuplicatePage,onMovePageUp,onMovePageDown,onExportPage,onUpdatePageBackground,onManagePages,onDeletePage,onThumbnailRequest,modifier)245@10093L2,246@10144L2,247@10210L15,248@10271L2,249@10322L2,250@10370L2,251@10420L2,252@10468L2,253@10526L2,254@10575L2,255@10623L2,256@10677L2,266@11005L58,276@11452L67,278@11547L34,279@11610L57,280@11703L156,280@11672L187,288@11923L110,288@11865L168,299@12236L30,298@12174L26,303@12433L8279,294@12039L8673:ChildPagesPane.kt#a4olte");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(childPage) ? 32 : 16;
        }
        int i27 = i3 & 4;
        if (i27 != 0) {
            i4 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else {
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                function113 = function1;
                i4 |= composerStartRestartGroup.changedInstance(function113) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 == 0) {
                i4 |= 3072;
            } else {
                if ((i & 3072) == 0) {
                    function114 = function12;
                    i4 |= composerStartRestartGroup.changedInstance(function114) ? 2048 : 1024;
                }
                i6 = i3 & 16;
                if (i6 != 0) {
                    i4 |= 24576;
                } else {
                    if ((i & 24576) == 0) {
                        function115 = function13;
                        i4 |= composerStartRestartGroup.changedInstance(function115) ? 16384 : 8192;
                    }
                    i7 = i3 & 32;
                    if (i7 == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                        function116 = function14;
                    } else {
                        function116 = function14;
                        if ((i & ProfileVerifier.CompilationStatus.f379xf2722a21) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function116) ? 131072 : 65536;
                        }
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        function117 = function15;
                    } else {
                        function117 = function15;
                        if ((i & 1572864) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function117) ? 1048576 : 524288;
                        }
                    }
                    i9 = i3 & 128;
                    if (i9 == 0) {
                        i4 |= 12582912;
                        function118 = function16;
                    } else {
                        function118 = function16;
                        if ((i & 12582912) == 0) {
                            i4 |= composerStartRestartGroup.changedInstance(function118) ? 8388608 : 4194304;
                        }
                    }
                    i10 = i3 & 256;
                    if (i10 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= composerStartRestartGroup.changedInstance(function17) ? 67108864 : 33554432;
                    }
                    i11 = i3 & 512;
                    if (i11 != 0) {
                        if ((i & 805306368) == 0) {
                            i12 = i11;
                            i4 |= composerStartRestartGroup.changedInstance(function18) ? 536870912 : 268435456;
                        }
                        i13 = i3 & 1024;
                        if (i13 != 0) {
                            i15 = i2 | 6;
                            i14 = i13;
                        } else if ((i2 & 6) == 0) {
                            i14 = i13;
                            i15 = i2 | (composerStartRestartGroup.changedInstance(function19) ? 4 : 2);
                        } else {
                            i14 = i13;
                            i15 = i2;
                        }
                        i16 = i3 & 2048;
                        if (i16 != 0) {
                            i15 |= 48;
                            i17 = i16;
                        } else if ((i2 & 48) == 0) {
                            i17 = i16;
                            i15 |= composerStartRestartGroup.changedInstance(function110) ? 32 : 16;
                        } else {
                            i17 = i16;
                        }
                        int i28 = i15;
                        i18 = i3 & 4096;
                        if (i18 != 0) {
                            i19 = i28 | RendererCapabilities.DECODER_SUPPORT_MASK;
                        } else if ((i2 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                            i19 = i28 | (composerStartRestartGroup.changedInstance(function111) ? 256 : 128);
                        } else {
                            i19 = i28;
                        }
                        i20 = i3 & 8192;
                        if (i20 != 0) {
                            i21 = i19 | 3072;
                        } else {
                            int i29 = i19;
                            if ((i2 & 3072) == 0) {
                                i21 = i29 | (composerStartRestartGroup.changedInstance(function112) ? 2048 : 1024);
                            } else {
                                i21 = i29;
                            }
                        }
                        i22 = i3 & 16384;
                        if (i22 != 0) {
                            i23 = i21 | 24576;
                        } else {
                            int i30 = i21;
                            if ((i2 & 24576) == 0) {
                                i23 = i30 | (composerStartRestartGroup.changed(modifier) ? 16384 : 8192);
                            } else {
                                i23 = i30;
                            }
                        }
                        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function119 = function18;
                            function120 = function112;
                            function121 = function115;
                            function122 = function118;
                            function123 = function116;
                            function124 = function117;
                            function125 = function114;
                            function126 = function113;
                            function127 = function17;
                            function128 = function19;
                            function129 = function110;
                            function130 = function111;
                            modifier2 = modifier;
                        } else {
                            if (i27 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337885054, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda24
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$0$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function131 = (Function1) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function131 = function113;
                            }
                            if (i5 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337886686, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda31
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$1$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                function132 = (Function1) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function132 = function114;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337888811, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda32
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$2$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                function115 = (Function1) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            if (i7 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337890750, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda34
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$3$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                function116 = (Function1) objRememberedValue6;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            final Function1<? super ChildPage, Unit> function141 = function116;
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337892382, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue7 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda35
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$4$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function133 = (Function1) objRememberedValue7;
                                i24 = i9;
                            } else {
                                i24 = i9;
                                function133 = function117;
                            }
                            if (i24 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337893918, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue8 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda36
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$5$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                function118 = (Function1) objRememberedValue8;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            }
                            final Function1<? super ChildPage, Unit> function142 = function118;
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337895518, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue9 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda37
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$6$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function134 = (Function1) objRememberedValue9;
                            } else {
                                function134 = function17;
                            }
                            if (i12 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337897054, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue10 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda38
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$7$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function135 = (Function1) objRememberedValue10;
                                i25 = i20;
                            } else {
                                i25 = i20;
                                function135 = function18;
                            }
                            if (i14 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337898910, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue11 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda39
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$8$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function136 = (Function1) objRememberedValue11;
                                i26 = i18;
                            } else {
                                i26 = i18;
                                function136 = function19;
                            }
                            if (i17 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337900478, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue12 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda40
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$9$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function137 = (Function1) objRememberedValue12;
                            } else {
                                function137 = function110;
                            }
                            if (i26 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337902014, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue13 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda25
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$10$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function138 = (Function1) objRememberedValue13;
                            } else {
                                function138 = function111;
                            }
                            if (i25 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337903742, "CC(remember):ChildPagesPane.kt#9igjgp");
                                Object objRememberedValue14 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue14 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda26
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$11$0((ChildPage) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue14);
                                }
                                function139 = (Function1) objRememberedValue14;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function139 = function112;
                            }
                            Modifier.Companion companion = i22 != 0 ? Modifier.INSTANCE : modifier;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1394763452, i4, i23, "com.myscript.nebo.editing.ui.compose.ChildPageItem (ChildPagesPane.kt:258)");
                            }
                            if (z) {
                                zIsActive = childPage.getSelectionState() == SelectionState.SELECTED;
                            } else {
                                zIsActive = childPage.isActive();
                            }
                            if (zIsActive) {
                                composerStartRestartGroup.startReplaceGroup(337911811);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "265@10922L6");
                                jM4202getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4203getPrimary0d7_KjU();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(337912901);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "265@10956L6");
                                jM4202getOnSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).m4202getOnSurface0d7_KjU();
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            final long jColorResource = ColorResources_androidKt.colorResource(C6079R.color.grid_view_page_item_info_background, composerStartRestartGroup, 0);
                            if (childPage.getBackgroundColor() == 16777215) {
                                composerStartRestartGroup.startReplaceGroup(337920743);
                                composerStartRestartGroup.endReplaceGroup();
                                jColor = Color.INSTANCE.m8183getTransparent0d7_KjU();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(337921715);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "272@11307L6");
                                jColor = ColorKt.Color(PageBackgroundUtilsKt.resolveBackgroundColor(childPage.getBackgroundColor(), !MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, MaterialTheme.$stable).isLight()));
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337928607, "CC(remember):ChildPagesPane.kt#9igjgp");
                            Object objRememberedValue15 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue15);
                            }
                            MutableState mutableState4 = (MutableState) objRememberedValue15;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337931614, "CC(remember):ChildPagesPane.kt#9igjgp");
                            Object objRememberedValue16 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                                mutableState = mutableState4;
                                objRememberedValue16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue16);
                            } else {
                                mutableState = mutableState4;
                            }
                            MutableState mutableState5 = (MutableState) objRememberedValue16;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337933653, "CC(remember):ChildPagesPane.kt#9igjgp");
                            Object objRememberedValue17 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                                mutableState2 = mutableState5;
                                objRememberedValue17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue17);
                            } else {
                                mutableState2 = mutableState5;
                            }
                            final MutableState mutableState6 = (MutableState) objRememberedValue17;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Boolean boolValueOf = Boolean.valueOf(ChildPageItem$lambda$16(mutableState2));
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337936728, "CC(remember):ChildPagesPane.kt#9igjgp");
                            Function1<? super ChildPage, ? extends List<? extends ChildPageAction>> function143 = function115;
                            int i31 = i4 & 112;
                            boolean z6 = ((57344 & i4) == 16384) | (i31 == 32);
                            Object objRememberedValue18 = composerStartRestartGroup.rememberedValue();
                            if (z6) {
                                z2 = zIsActive;
                            } else {
                                z2 = zIsActive;
                                if (objRememberedValue18 != Composer.INSTANCE.getEmpty()) {
                                    function140 = function143;
                                    mutableState3 = mutableState2;
                                    childPagesPaneKt$ChildPageItem$13$1 = objRememberedValue18;
                                    childPage2 = childPage;
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) childPagesPaneKt$ChildPageItem$13$1, composerStartRestartGroup, 0);
                                String id = childPage2.getId();
                                String thumbnailFilepath = childPage2.getThumbnailFilepath();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337943722, "CC(remember):ChildPagesPane.kt#9igjgp");
                                z3 = (i31 != 32) | ((i23 & 7168) != 2048);
                                childPagesPaneKt$ChildPageItem$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z3 || childPagesPaneKt$ChildPageItem$14$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                    childPagesPaneKt$ChildPageItem$14$1RememberedValue = new ChildPagesPaneKt$ChildPageItem$14$1(childPage2, function139, null);
                                    composerStartRestartGroup.updateRememberedValue(childPagesPaneKt$ChildPageItem$14$1RememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                EffectsKt.LaunchedEffect(id, thumbnailFilepath, (Function2) childPagesPaneKt$ChildPageItem$14$1RememberedValue, composerStartRestartGroup, 0);
                                Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(companion, C1486Dp.m11017constructorimpl(4));
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337953658, "CC(remember):ChildPagesPane.kt#9igjgp");
                                z4 = (i31 != 32) | ((i4 & 7168) != 2048);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda27
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$23$0(function132, childPage2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                Function0 function0 = (Function0) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337951670, "CC(remember):ChildPagesPane.kt#9igjgp");
                                z5 = (i31 != 32) | ((i4 & 896) != 256);
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (!z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda28
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$24$0(function131, childPage2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierM2072combinedClickablehoGz1lA$default = ClickableKt.m2072combinedClickablehoGz1lA$default(modifierM2854padding3ABfNKs, false, null, null, null, function0, null, false, null, (Function0) objRememberedValue2, 239, null);
                                final MutableState mutableState7 = mutableState;
                                final boolean z7 = z2;
                                final MutableState mutableState8 = mutableState3;
                                Function1<? super ChildPage, Unit> function144 = function131;
                                final ChildPage childPage3 = childPage2;
                                Function1<? super ChildPage, Unit> function145 = function139;
                                Modifier modifier3 = companion;
                                Function1<? super ChildPage, Unit> function146 = function132;
                                final long j = jM4202getOnSurface0d7_KjU;
                                final long j2 = jColor;
                                CardKt.m4173CardFjzlyU(modifierM2072combinedClickablehoGz1lA$default, null, 0L, 0L, BorderStrokeKt.m2051BorderStrokecXLIe8U(C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM(), Color.m8147copywmQWz5c$default(jM4202getOnSurface0d7_KjU, !z2 ? 1.0f : 0.1f, 0.0f, 0.0f, 0.0f, 14, null)), C1486Dp.m11017constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(1860720671, true, new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return ChildPagesPaneKt.ChildPageItem$lambda$25(z7, z, childPage3, jColorResource, j2, mutableState7, j, mutableState8, mutableState6, function141, function133, function142, function134, function135, function136, function138, function137, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, 1769472, 14);
                                composer2 = composerStartRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function123 = function141;
                                function124 = function133;
                                function122 = function142;
                                function127 = function134;
                                function119 = function135;
                                function128 = function136;
                                function130 = function138;
                                function129 = function137;
                                modifier2 = modifier3;
                                function120 = function145;
                                function125 = function146;
                                function121 = function140;
                                function126 = function144;
                            }
                            function140 = function143;
                            childPage2 = childPage;
                            mutableState3 = mutableState2;
                            childPagesPaneKt$ChildPageItem$13$1 = new ChildPagesPaneKt$ChildPageItem$13$1(function143, childPage, mutableState2, mutableState6, null);
                            composerStartRestartGroup.updateRememberedValue(childPagesPaneKt$ChildPageItem$13$1);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) childPagesPaneKt$ChildPageItem$13$1, composerStartRestartGroup, 0);
                            String id2 = childPage2.getId();
                            String thumbnailFilepath2 = childPage2.getThumbnailFilepath();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337943722, "CC(remember):ChildPagesPane.kt#9igjgp");
                            z3 = (i31 != 32) | ((i23 & 7168) != 2048);
                            childPagesPaneKt$ChildPageItem$14$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z3) {
                                childPagesPaneKt$ChildPageItem$14$1RememberedValue = new ChildPagesPaneKt$ChildPageItem$14$1(childPage2, function139, null);
                                composerStartRestartGroup.updateRememberedValue(childPagesPaneKt$ChildPageItem$14$1RememberedValue);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                EffectsKt.LaunchedEffect(id2, thumbnailFilepath2, (Function2) childPagesPaneKt$ChildPageItem$14$1RememberedValue, composerStartRestartGroup, 0);
                                Modifier modifierM2854padding3ABfNKs2 = PaddingKt.m2854padding3ABfNKs(companion, C1486Dp.m11017constructorimpl(4));
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337953658, "CC(remember):ChildPagesPane.kt#9igjgp");
                                if ((i4 & 7168) != 2048) {
                                }
                                z4 = (i31 != 32) | ((i4 & 7168) != 2048);
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (!z4) {
                                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda27
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ChildPagesPaneKt.ChildPageItem$lambda$23$0(function132, childPage2);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    Function0 function02 = (Function0) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 337951670, "CC(remember):ChildPagesPane.kt#9igjgp");
                                    if ((i4 & 896) != 256) {
                                    }
                                    z5 = (i31 != 32) | ((i4 & 896) != 256);
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (!z5) {
                                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda28
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return ChildPagesPaneKt.ChildPageItem$lambda$24$0(function131, childPage2);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        Modifier modifierM2072combinedClickablehoGz1lA$default2 = ClickableKt.m2072combinedClickablehoGz1lA$default(modifierM2854padding3ABfNKs2, false, null, null, null, function02, null, false, null, (Function0) objRememberedValue2, 239, null);
                                        final MutableState mutableState72 = mutableState;
                                        final boolean z72 = z2;
                                        final MutableState mutableState82 = mutableState3;
                                        Function1<? super ChildPage, Unit> function1442 = function131;
                                        final ChildPage childPage32 = childPage2;
                                        Function1<? super ChildPage, Unit> function1452 = function139;
                                        Modifier modifier32 = companion;
                                        Function1<? super ChildPage, Unit> function1462 = function132;
                                        final long j3 = jM4202getOnSurface0d7_KjU;
                                        final long j22 = jColor;
                                        CardKt.m4173CardFjzlyU(modifierM2072combinedClickablehoGz1lA$default2, null, 0L, 0L, BorderStrokeKt.m2051BorderStrokecXLIe8U(C1486Dp.INSTANCE.m11035getHairlineD9Ej5fM(), Color.m8147copywmQWz5c$default(jM4202getOnSurface0d7_KjU, !z2 ? 1.0f : 0.1f, 0.0f, 0.0f, 0.0f, 14, null)), C1486Dp.m11017constructorimpl(0), ComposableLambdaKt.rememberComposableLambda(1860720671, true, new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda29
                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(Object obj, Object obj2) {
                                                return ChildPagesPaneKt.ChildPageItem$lambda$25(z72, z, childPage32, jColorResource, j22, mutableState72, j3, mutableState82, mutableState6, function141, function133, function142, function134, function135, function136, function138, function137, (Composer) obj, ((Integer) obj2).intValue());
                                            }
                                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 1769472, 14);
                                        composer2 = composerStartRestartGroup;
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        function123 = function141;
                                        function124 = function133;
                                        function122 = function142;
                                        function127 = function134;
                                        function119 = function135;
                                        function128 = function136;
                                        function130 = function138;
                                        function129 = function137;
                                        modifier2 = modifier32;
                                        function120 = function1452;
                                        function125 = function1462;
                                        function121 = function140;
                                        function126 = function1442;
                                    }
                                }
                            }
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChildPagesPaneKt.ChildPageItem$lambda$26(z, childPage, function126, function125, function121, function123, function124, function122, function127, function119, function128, function129, function130, function120, modifier2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i4 |= 805306368;
                    i12 = i11;
                    i13 = i3 & 1024;
                    if (i13 != 0) {
                    }
                    i16 = i3 & 2048;
                    if (i16 != 0) {
                    }
                    int i282 = i15;
                    i18 = i3 & 4096;
                    if (i18 != 0) {
                    }
                    i20 = i3 & 8192;
                    if (i20 != 0) {
                    }
                    i22 = i3 & 16384;
                    if (i22 != 0) {
                    }
                    if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                    }
                }
                function115 = function13;
                i7 = i3 & 32;
                if (i7 == 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                i9 = i3 & 128;
                if (i9 == 0) {
                }
                i10 = i3 & 256;
                if (i10 == 0) {
                }
                i11 = i3 & 512;
                if (i11 != 0) {
                }
                i12 = i11;
                i13 = i3 & 1024;
                if (i13 != 0) {
                }
                i16 = i3 & 2048;
                if (i16 != 0) {
                }
                int i2822 = i15;
                i18 = i3 & 4096;
                if (i18 != 0) {
                }
                i20 = i3 & 8192;
                if (i20 != 0) {
                }
                i22 = i3 & 16384;
                if (i22 != 0) {
                }
                if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                }
            }
            function114 = function12;
            i6 = i3 & 16;
            if (i6 != 0) {
            }
            function115 = function13;
            i7 = i3 & 32;
            if (i7 == 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            i9 = i3 & 128;
            if (i9 == 0) {
            }
            i10 = i3 & 256;
            if (i10 == 0) {
            }
            i11 = i3 & 512;
            if (i11 != 0) {
            }
            i12 = i11;
            i13 = i3 & 1024;
            if (i13 != 0) {
            }
            i16 = i3 & 2048;
            if (i16 != 0) {
            }
            int i28222 = i15;
            i18 = i3 & 4096;
            if (i18 != 0) {
            }
            i20 = i3 & 8192;
            if (i20 != 0) {
            }
            i22 = i3 & 16384;
            if (i22 != 0) {
            }
            if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
            }
        }
        function113 = function1;
        i5 = i3 & 8;
        if (i5 == 0) {
        }
        function114 = function12;
        i6 = i3 & 16;
        if (i6 != 0) {
        }
        function115 = function13;
        i7 = i3 & 32;
        if (i7 == 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        i9 = i3 & 128;
        if (i9 == 0) {
        }
        i10 = i3 & 256;
        if (i10 == 0) {
        }
        i11 = i3 & 512;
        if (i11 != 0) {
        }
        i12 = i11;
        i13 = i3 & 1024;
        if (i13 != 0) {
        }
        i16 = i3 & 2048;
        if (i16 != 0) {
        }
        int i282222 = i15;
        i18 = i3 & 4096;
        if (i18 != 0) {
        }
        i20 = i3 & 8192;
        if (i20 != 0) {
        }
        i22 = i3 & 16384;
        if (i22 != 0) {
        }
        if (!composerStartRestartGroup.shouldExecute(((i4 & 306783379) == 306783378 && (i23 & 9363) == 9362) ? false : true, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
        }
    }

    private static final AsyncImagePainter.State.Success ChildPageItem$lambda$13(MutableState<AsyncImagePainter.State.Success> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ChildPageItem$lambda$16(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ChildPageItem$lambda$17(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final List<ChildPageAction> ChildPageItem$lambda$19(MutableState<List<ChildPageAction>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$24$0(Function1 function1, ChildPage childPage) {
        function1.invoke(childPage);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$23$0(Function1 function1, ChildPage childPage) {
        function1.invoke(childPage);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$25(final boolean z, boolean z2, final ChildPage childPage, long j, final long j2, final MutableState mutableState, long j3, final MutableState mutableState2, final MutableState mutableState3, final Function1 function1, final Function1 function12, final Function1 function13, final Function1 function14, final Function1 function15, final Function1 function16, final Function1 function17, final Function1 function18, Composer composer, int i) {
        int i2;
        Composer composer2;
        String str;
        String str2;
        float f;
        String str3;
        String str4;
        boolean z3;
        ComposerKt.sourceInformation(composer, "C304@12443L8263:ChildPagesPane.kt#a4olte");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1860720671, i, -1, "com.myscript.nebo.editing.ui.compose.ChildPageItem.<anonymous> (ChildPagesPane.kt:304)");
            }
            Modifier modifierHeight = IntrinsicKt.height(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), IntrinsicSize.Max);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierHeight);
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
            ComposerKt.sourceInformationMarkerStart(composer, 1313856229, "C308@12575L6983,428@19651L237,428@19571L317:ChildPagesPane.kt#a4olte");
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(spaceBetween, Alignment.INSTANCE.getStart(), composer, 6);
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
            Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -889404456, "C309@12740L3729,309@12648L3821,378@16486L3058:ChildPagesPane.kt#a4olte");
            CrossfadeKt.Crossfade(Boolean.valueOf(childPage.getThumbnailFilepath() != null), (Modifier) null, (FiniteAnimationSpec<Float>) null, "thumbnail crossfade", ComposableLambdaKt.rememberComposableLambda(46019418, true, new Function3() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChildPagesPaneKt.ChildPageItem$lambda$25$0$0$0(childPage, j2, mutableState, ((Boolean) obj).booleanValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 27648, 6);
            Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), j, null, 2, null);
            Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierM2016backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
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
            Updater.m7256setimpl(composerM7248constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m7256setimpl(composerM7248constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m7256setimpl(composerM7248constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m7254reconcileimpl(composerM7248constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m7256setimpl(composerM7248constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1575432218, "C388@17002L10,385@16828L306:ChildPagesPane.kt#a4olte");
            float f2 = 12;
            TextKt.m4524Text4IGK_g(String.valueOf(childPage.getPageNumber()), PaddingKt.m2854padding3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(f2)), j3, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, TextStyle.m10466copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getCaption(), 0L, 0L, FontWeight.INSTANCE.getSemiBold(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 48, 0, 65528);
            if (z2) {
                i2 = 54;
                composer2 = composer;
                str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str2 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                f = f2;
                str3 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
                str4 = "C72@3469L9:Box.kt#2w3rfo";
                z3 = true;
                composer2.startReplaceGroup(1578024995);
                composer2.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1575767606);
                ComposerKt.sourceInformation(composer, "392@17203L2301");
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion2);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor4);
                } else {
                    composer.useNode();
                }
                Composer composerM7248constructorimpl4 = Updater.m7248constructorimpl(composer);
                Updater.m7256setimpl(composerM7248constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -1270183806, "C393@17258L25,393@17237L201,396@17541L26,396@17569L1909,396@17467L2011:ChildPagesPane.kt#a4olte");
                ComposerKt.sourceInformationMarkerStart(composer, 236119449, "CC(remember):ChildPagesPane.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ChildPagesPaneKt.ChildPageItem$lambda$25$0$0$1$0$0$0(mutableState2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str2 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                i2 = 54;
                IconButtonKt.IconButton((Function0) objRememberedValue, null, false, null, ComposableSingletons$ChildPagesPaneKt.INSTANCE.m13174getLambda$1374043972$app_standardRelease(), composer, 24582, 14);
                boolean z4 = !ChildPageItem$lambda$19(mutableState3).isEmpty();
                ComposerKt.sourceInformationMarkerStart(composer, 236128506, "CC(remember):ChildPagesPane.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ChildPagesPaneKt.ChildPageItem$lambda$25$0$0$1$0$1$0(mutableState2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                f = f2;
                str3 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
                str4 = "C72@3469L9:Box.kt#2w3rfo";
                z3 = true;
                AndroidMenu_androidKt.m4104DropdownMenu4kj_NE(z4, (Function0) objRememberedValue2, null, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(460809939, true, new Function3() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ChildPagesPaneKt.ChildPageItem$lambda$25$0$0$1$0$2(mutableState3, function1, childPage, function12, function13, function14, function15, function16, function17, function18, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 1572912, 60);
                composer2 = composer;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            }
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
            AnimatedVisibilityKt.AnimatedVisibility(z, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-612645507, z3, new Function3() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChildPagesPaneKt.ChildPageItem$lambda$25$0$1(z, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, i2), composer2, 200064, 18);
            if (z2 && childPage.getSelectionState() == SelectionState.SELECTED) {
                composer2.startReplaceGroup(1320955135);
                ComposerKt.sourceInformation(composer2, "442@20237L6,436@19980L702");
                Modifier modifierM2854padding3ABfNKs = PaddingKt.m2854padding3ABfNKs(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), C1486Dp.m11017constructorimpl(f));
                float f3 = 32;
                Modifier modifierM2015backgroundbw27NRU = BackgroundKt.m2015backgroundbw27NRU(SizeKt.m2926sizeVpY3zN4(modifierM2854padding3ABfNKs, C1486Dp.m11017constructorimpl(f3), C1486Dp.m11017constructorimpl(f3)), MaterialTheme.INSTANCE.getColors(composer2, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, str);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, str2);
                int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierM2015backgroundbw27NRU);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer2, -553112988, str3);
                if (!(composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor5);
                } else {
                    composer2.useNode();
                }
                Composer composerM7248constructorimpl5 = Updater.m7248constructorimpl(composer2);
                Updater.m7256setimpl(composerM7248constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, str4);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 260050676, "C447@20407L42,446@20367L297:ChildPagesPane.kt#a4olte");
                IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6183R.drawable.ic_check, composer2, 0), (String) null, boxScopeInstance3.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), Color.INSTANCE.m8185getWhite0d7_KjU(), composer2, Painter.$stable | 3120, 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(1321660509);
                composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$25$0$0$0(ChildPage childPage, long j, final MutableState mutableState, boolean z, Composer composer, int i) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        BoxScopeInstance boxScopeInstance;
        int i3;
        ComposerKt.sourceInformation(composer, "CN(hasThumbnail)310@12778L2908:ChildPagesPane.kt#a4olte");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(z) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(46019418, i2, -1, "com.myscript.nebo.editing.ui.compose.ChildPageItem.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChildPagesPane.kt:310)");
            }
            Modifier modifierM2016backgroundbw27NRU$default = BackgroundKt.m2016backgroundbw27NRU$default(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), childPage.getAspectRatio(), false, 2, null), j, null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM2016backgroundbw27NRU$default);
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
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 387238058, "C:ChildPagesPane.kt#a4olte");
            if (z) {
                composer.startReplaceGroup(387214404);
                ComposerKt.sourceInformation(composer, "323@13511L447,332@14006L212,316@13063L1254");
                String thumbnailFilepath = childPage.getThumbnailFilepath();
                Modifier modifierM2912heightInVpY3zN4$default = SizeKt.m2912heightInVpY3zN4$default(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), childPage.getAspectRatio(), false, 2, null), C1486Dp.m11017constructorimpl(96), 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composer, -1234420769, "CC(remember):ChildPagesPane.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChildPagesPaneKt.ChildPageItem$lambda$25$0$0$0$0$0$0(mutableState, (AsyncImagePainter.State) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1234405164, "CC(remember):ChildPagesPane.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChildPagesPaneKt.ChildPageItem$lambda$25$0$0$0$0$1$0(mutableState, (AsyncImagePainter.State) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str2 = "C72@3469L9:Box.kt#2w3rfo";
                str3 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
                str4 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                SingletonAsyncImageKt.m12342AsyncImagegl8XCv8(thumbnailFilepath, null, modifierM2912heightInVpY3zN4$default, function1, (Function1) objRememberedValue2, null, ContentScale.INSTANCE.getFit(), 0.0f, null, 0, false, null, composer, 1600560, 0, 4000);
                composer.endReplaceGroup();
                boxScopeInstance = boxScopeInstance2;
                i3 = 24;
            } else {
                str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                str2 = "C72@3469L9:Box.kt#2w3rfo";
                str3 = "CC(ReusableComposeNode)N(factory,update,content)410@16187L9:Composables.kt#9igjgp";
                str4 = "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh";
                if (!childPage.isCorrupted()) {
                    composer.startReplaceGroup(388517644);
                    ComposerKt.sourceInformation(composer, "339@14407L286");
                    i3 = 24;
                    boxScopeInstance = boxScopeInstance2;
                    ProgressIndicatorKt.m4366CircularProgressIndicatorLxG7B9w(boxScopeInstance.align(SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(24)), Alignment.INSTANCE.getCenter()), 0L, C1486Dp.m11017constructorimpl(2), 0L, 0, composer, RendererCapabilities.DECODER_SUPPORT_MASK, 26);
                    composer.endReplaceGroup();
                } else {
                    boxScopeInstance = boxScopeInstance2;
                    i3 = 24;
                    composer.startReplaceGroup(388846306);
                    composer.endReplaceGroup();
                }
            }
            if (childPage.isCorrupted()) {
                composer.startReplaceGroup(388925573);
                ComposerKt.sourceInformation(composer, "350@14974L7,350@15008L8,347@14801L837");
                Modifier modifierAlign = boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter());
                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composer.consume(localContentColor);
                ComposerKt.sourceInformationMarkerEnd(composer);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(BackgroundKt.m2016backgroundbw27NRU$default(modifierAlign, Color.m8147copywmQWz5c$default(((Color) objConsume).m8158unboximpl(), ContentAlpha.INSTANCE.getDisabled(composer, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, str);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, str4);
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -553112988, str3);
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
                Updater.m7256setimpl(composerM7248constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m7256setimpl(composerM7248constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m7256setimpl(composerM7248constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m7254reconcileimpl(composerM7248constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m7256setimpl(composerM7248constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1833054614, str2);
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 2002167921, "C354@15186L41,359@15524L6,359@15565L8,353@15134L474:ChildPagesPane.kt#a4olte");
                IconKt.m4300Iconww6aTOc(PainterResources_androidKt.painterResource(C6079R.drawable.ic_error, composer, 0), (String) null, boxScopeInstance3.align(SizeKt.m2924size3ABfNKs(Modifier.INSTANCE, C1486Dp.m11017constructorimpl(i3)), Alignment.INSTANCE.getCenter()), Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4207getSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, ContentAlpha.$stable), 0.0f, 0.0f, 0.0f, 14, null), composer, Painter.$stable | 48, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(389783746);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.startReplaceGroup(873595528);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AsyncImagePainter.State ChildPageItem$lambda$25$0$0$0$0$0$0(MutableState mutableState, AsyncImagePainter.State state) {
        AsyncImagePainter.State.Success successChildPageItem$lambda$13;
        Intrinsics.checkNotNullParameter(state, "state");
        return (((state instanceof AsyncImagePainter.State.Error) || (state instanceof AsyncImagePainter.State.Loading)) && (successChildPageItem$lambda$13 = ChildPageItem$lambda$13(mutableState)) != null) ? successChildPageItem$lambda$13 : state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$25$0$0$0$0$1$0(MutableState mutableState, AsyncImagePainter.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AsyncImagePainter.State.Success) {
            mutableState.setValue((AsyncImagePainter.State.Success) state);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$25$0$0$1$0$0$0(MutableState mutableState) {
        ChildPageItem$lambda$17(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$25$0$0$1$0$1$0(MutableState mutableState) {
        ChildPageItem$lambda$17(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$25$0$0$1$0$2(MutableState mutableState, final Function1 function1, final ChildPage childPage, final Function1 function12, final Function1 function13, final Function1 function14, final Function1 function15, final Function1 function16, final Function1 function17, final Function1 function18, final MutableState mutableState2, ColumnScope columnScope, Composer composer, int i) {
        ColumnScope DropdownMenu = columnScope;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*402@17926L1045,401@17850L1400:ChildPagesPane.kt#a4olte");
        int i2 = (i & 6) == 0 ? i | (composer2.changed(DropdownMenu) ? 4 : 2) : i;
        if (!composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(460809939, i2, -1, "com.myscript.nebo.editing.ui.compose.ChildPageItem.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChildPagesPane.kt:397)");
            }
            for (final ChildPageAction childPageAction : ChildPageItem$lambda$19(mutableState)) {
                if (childPageAction.getShowDividerBefore()) {
                    composer2.startReplaceGroup(-1637662260);
                    ComposerKt.sourceInformation(composer2, "399@17766L9");
                    DividerKt.m4242DivideroMI9zvI(null, 0L, 0.0f, 0.0f, composer, 0, 15);
                    composer2 = composer;
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1637576731);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerStart(composer2, 917010930, "CC(remember):ChildPagesPane.kt#9igjgp");
                boolean zChanged = composer2.changed(childPageAction) | composer2.changed(function1) | composer2.changed(childPage) | composer2.changed(function12) | composer2.changed(function13) | composer2.changed(function14) | composer2.changed(function15) | composer2.changed(function16) | composer2.changed(function17) | composer2.changed(function18);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda59
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ChildPagesPaneKt.ChildPageItem$lambda$25$0$0$1$0$2$0$0$0(childPageAction, function1, childPage, function12, function13, function14, function15, function16, function17, function18, mutableState2);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                DropdownMenuItemKt.DropdownMenuItemWithIcon(DropdownMenu, (Function0<Unit>) objRememberedValue, childPageAction.getLabelResId(), Integer.valueOf(childPageAction.getDrawableResId()), false, false, childPageAction.getIsCritical(), composer, i2 & 14, 24);
                composer2 = composer;
                if (childPageAction.getShowDividerAfter()) {
                    composer2.startReplaceGroup(-1636074068);
                    ComposerKt.sourceInformation(composer2, "420@19367L9");
                    DividerKt.m4242DivideroMI9zvI(null, 0L, 0.0f, 0.0f, composer2, 0, 15);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1635988539);
                    composer2.endReplaceGroup();
                }
                DropdownMenu = columnScope;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$25$0$0$1$0$2$0$0$0(ChildPageAction childPageAction, Function1 function1, ChildPage childPage, Function1 function12, Function1 function13, Function1 function14, Function1 function15, Function1 function16, Function1 function17, Function1 function18, MutableState mutableState) {
        ChildPageItem$lambda$17(mutableState, false);
        if (Intrinsics.areEqual(childPageAction, ChildPageAction.Insert.INSTANCE)) {
            function1.invoke(childPage);
        } else if (Intrinsics.areEqual(childPageAction, ChildPageAction.Duplicate.INSTANCE)) {
            function12.invoke(childPage);
        } else if (Intrinsics.areEqual(childPageAction, ChildPageAction.MoveUp.INSTANCE)) {
            function13.invoke(childPage);
        } else if (Intrinsics.areEqual(childPageAction, ChildPageAction.MoveDown.INSTANCE)) {
            function14.invoke(childPage);
        } else if (Intrinsics.areEqual(childPageAction, ChildPageAction.Export.INSTANCE)) {
            function15.invoke(childPage);
        } else if (Intrinsics.areEqual(childPageAction, ChildPageAction.UpdateBackground.INSTANCE)) {
            function16.invoke(childPage);
        } else if (Intrinsics.areEqual(childPageAction, ChildPageAction.Remove.INSTANCE)) {
            function17.invoke(childPage);
        } else {
            if (!Intrinsics.areEqual(childPageAction, ChildPageAction.ManagePages.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            function18.invoke(childPage);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPageItem$lambda$25$0$1(boolean z, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C431@19753L6,429@19669L205:ChildPagesPane.kt#a4olte");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-612645507, i, -1, "com.myscript.nebo.editing.ui.compose.ChildPageItem.<anonymous>.<anonymous>.<anonymous> (ChildPagesPane.kt:429)");
        }
        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(BackgroundKt.m2016backgroundbw27NRU$default(Modifier.INSTANCE, Color.m8147copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m4203getPrimary0d7_KjU(), z ? 0.1f : 0.0f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), 0.0f, 1, null);
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)N(content,modifier,measurePolicy)81@3355L27,84@3521L415:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxSize$default);
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
        ComposerKt.sourceInformationMarkerStart(composer, 1713746560, "C:ChildPagesPane.kt#a4olte");
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x016a, code lost:
    
        if (r14 == r0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x019c, code lost:
    
        if (androidx.compose.foundation.lazy.LazyListState.animateScrollToItem$default(r12, r13, 0, r4, 2, null) == r0) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0106 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object scrollToSelectedChildPage(LazyListState lazyListState, int i, Continuation<? super Unit> continuation) {
        C64501 c64501;
        int i2;
        int i3;
        Iterator<T> it;
        int i4;
        Object next;
        if (continuation instanceof C64501) {
            c64501 = (C64501) continuation;
            if ((c64501.label & Integer.MIN_VALUE) != 0) {
                c64501.label -= Integer.MIN_VALUE;
            } else {
                c64501 = new C64501(continuation);
            }
        }
        C64501 c645012 = c64501;
        Object objScrollBy = c645012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c645012.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(objScrollBy);
            if (i >= 0) {
                LazyListLayoutInfo layoutInfo = lazyListState.getLayoutInfo();
                List<LazyListItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
                List<LazyListItemInfo> list = visibleItemsInfo;
                boolean z = list instanceof Collection;
                if (z && list.isEmpty()) {
                    i2 = 0;
                    if (z) {
                        while (r9.hasNext()) {
                        }
                        i3 = 0;
                        if (z) {
                        }
                    }
                } else {
                    for (LazyListItemInfo lazyListItemInfo : list) {
                        if (lazyListItemInfo.getIndex() == i && lazyListItemInfo.getOffset() < 0) {
                            i2 = 1;
                            break;
                        }
                    }
                    i2 = 0;
                    if (z || !list.isEmpty()) {
                        for (LazyListItemInfo lazyListItemInfo2 : list) {
                            if (lazyListItemInfo2.getIndex() == i && lazyListItemInfo2.getOffset() + lazyListItemInfo2.getSize() > layoutInfo.getViewportEndOffset()) {
                                i3 = 1;
                                break;
                            }
                        }
                        i3 = 0;
                        if (z && list.isEmpty()) {
                            i4 = 0;
                            if (i4 != 0) {
                            }
                            c645012.L$0 = SpillingKt.nullOutSpilledVariable(lazyListState);
                            c645012.L$1 = SpillingKt.nullOutSpilledVariable(layoutInfo);
                            c645012.L$2 = SpillingKt.nullOutSpilledVariable(visibleItemsInfo);
                            c645012.I$0 = i;
                            c645012.I$1 = i2;
                            c645012.I$2 = i3;
                            c645012.I$3 = i4;
                            c645012.label = 1;
                        } else {
                            it = list.iterator();
                            while (it.hasNext()) {
                                if (((LazyListItemInfo) it.next()).getIndex() == i) {
                                    i4 = 1;
                                    break;
                                }
                            }
                            i4 = 0;
                            if (i4 != 0 || i2 != 0) {
                                c645012.L$0 = SpillingKt.nullOutSpilledVariable(lazyListState);
                                c645012.L$1 = SpillingKt.nullOutSpilledVariable(layoutInfo);
                                c645012.L$2 = SpillingKt.nullOutSpilledVariable(visibleItemsInfo);
                                c645012.I$0 = i;
                                c645012.I$1 = i2;
                                c645012.I$2 = i3;
                                c645012.I$3 = i4;
                                c645012.label = 1;
                            } else if (i3 != 0) {
                                Iterator<T> it2 = list.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        next = null;
                                        break;
                                    }
                                    next = it2.next();
                                    if (((LazyListItemInfo) next).getIndex() == i) {
                                        break;
                                    }
                                }
                                LazyListItemInfo lazyListItemInfo3 = (LazyListItemInfo) next;
                                if (lazyListItemInfo3 != null) {
                                    int offset = (lazyListItemInfo3.getOffset() + lazyListItemInfo3.getSize()) - layoutInfo.getViewportEndOffset();
                                    c645012.L$0 = SpillingKt.nullOutSpilledVariable(lazyListState);
                                    c645012.L$1 = SpillingKt.nullOutSpilledVariable(layoutInfo);
                                    c645012.L$2 = SpillingKt.nullOutSpilledVariable(visibleItemsInfo);
                                    c645012.L$3 = SpillingKt.nullOutSpilledVariable(lazyListItemInfo3);
                                    c645012.L$4 = SpillingKt.nullOutSpilledVariable(lazyListItemInfo3);
                                    c645012.I$0 = i;
                                    c645012.I$1 = i2;
                                    c645012.I$2 = i3;
                                    c645012.I$3 = i4;
                                    c645012.I$4 = 0;
                                    c645012.I$5 = offset;
                                    c645012.label = 2;
                                    objScrollBy = ScrollExtensionsKt.scrollBy(lazyListState, offset, c645012);
                                }
                            }
                            return coroutine_suspended;
                        }
                    } else {
                        i3 = 0;
                        if (z) {
                            it = list.iterator();
                            while (it.hasNext()) {
                            }
                            i4 = 0;
                            if (i4 != 0) {
                            }
                            c645012.L$0 = SpillingKt.nullOutSpilledVariable(lazyListState);
                            c645012.L$1 = SpillingKt.nullOutSpilledVariable(layoutInfo);
                            c645012.L$2 = SpillingKt.nullOutSpilledVariable(visibleItemsInfo);
                            c645012.I$0 = i;
                            c645012.I$1 = i2;
                            c645012.I$2 = i3;
                            c645012.I$3 = i4;
                            c645012.label = 1;
                        }
                    }
                }
            }
        } else {
            if (i5 == 1) {
                int i6 = c645012.I$3;
                int i7 = c645012.I$2;
                int i8 = c645012.I$1;
                int i9 = c645012.I$0;
                ResultKt.throwOnFailure(objScrollBy);
                return Unit.INSTANCE;
            }
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i10 = c645012.I$5;
            int i11 = c645012.I$4;
            int i12 = c645012.I$3;
            int i13 = c645012.I$2;
            int i14 = c645012.I$1;
            int i15 = c645012.I$0;
            ResultKt.throwOnFailure(objScrollBy);
            Boxing.boxFloat(((Number) objScrollBy).floatValue());
        }
        return Unit.INSTANCE;
    }

    public static final void PreviewChildPageItem(final ChildPage childPage, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        Composer composerStartRestartGroup = composer.startRestartGroup(31886157);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewChildPageItem)N(childPage)490@22015L2,490@22047L15,490@22079L2,490@22101L2,490@22120L2,490@22141L2,490@22160L2,490@22189L2,490@22209L2,490@22228L2,490@22253L2,490@21939L317:ChildPagesPane.kt#a4olte");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(childPage) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(31886157, i2, -1, "com.myscript.nebo.editing.ui.compose.PreviewChildPageItem (ChildPagesPane.kt:489)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577829935, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$0$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577830972, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$1$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function12 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577831983, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda44
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$2$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function13 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577832687, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda55
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$3$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function14 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577833295, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda66
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$4$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function1 function15 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577833967, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda75
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$5$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function1 function16 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577834575, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda76
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$6$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Function1 function17 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577835503, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda77
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$7$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            Function1 function18 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577836143, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$8$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            Function1 function19 = (Function1) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577836751, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$9$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            Function1 function110 = (Function1) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 577837551, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.PreviewChildPageItem$lambda$10$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ChildPageItem(false, childPage, function1, null, function12, function13, function14, function15, function16, function17, function18, function19, function110, (Function1) objRememberedValue11, null, composerStartRestartGroup, ((i2 << 3) & 112) | 920347014, 3510, 16392);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.PreviewChildPageItem$lambda$11(childPage, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$0$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List PreviewChildPageItem$lambda$1$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$10$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$2$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$3$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$4$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$5$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$6$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$7$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$8$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewChildPageItem$lambda$9$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void AddChildPageButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(786433610);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddChildPageButtonPreview)496@22338L2,496@22319L21:ChildPagesPane.kt#a4olte");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(786433610, i, -1, "com.myscript.nebo.editing.ui.compose.AddChildPageButtonPreview (ChildPagesPane.kt:495)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -151543060, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AddChildPageButton(null, (Function0) objRememberedValue, composerStartRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.AddChildPageButtonPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SelectedChildPageItem(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(930865281);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectedChildPageItem)503@22552L43:ChildPagesPane.kt#a4olte");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(930865281, i, -1, "com.myscript.nebo.editing.ui.compose.SelectedChildPageItem (ChildPagesPane.kt:501)");
            }
            PreviewChildPageItem(new ChildPage("1", true, 1, 100, TextFieldImplKt.AnimationDuration, 0, null, null, false, null, 992, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.SelectedChildPageItem$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SelectedChildPageItemNight(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1108766127);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectedChildPageItemNight)510@22807L43:ChildPagesPane.kt#a4olte");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1108766127, i, -1, "com.myscript.nebo.editing.ui.compose.SelectedChildPageItemNight (ChildPagesPane.kt:508)");
            }
            PreviewChildPageItem(new ChildPage("1", true, 1, 100, TextFieldImplKt.AnimationDuration, 0, null, null, false, null, 992, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.SelectedChildPageItemNight$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void NotSelectedChildPageItem(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-431763638);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotSelectedChildPageItem)517@23070L43:ChildPagesPane.kt#a4olte");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-431763638, i, -1, "com.myscript.nebo.editing.ui.compose.NotSelectedChildPageItem (ChildPagesPane.kt:515)");
            }
            PreviewChildPageItem(new ChildPage("2", false, 2, 100, TextFieldImplKt.AnimationDuration, 0, null, null, false, null, 992, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.NotSelectedChildPageItem$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void NotSelectedChildPageItemNight(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(806442118);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotSelectedChildPageItemNight)524@23333L43:ChildPagesPane.kt#a4olte");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(806442118, i, -1, "com.myscript.nebo.editing.ui.compose.NotSelectedChildPageItemNight (ChildPagesPane.kt:522)");
            }
            PreviewChildPageItem(new ChildPage("2", false, 2, 100, TextFieldImplKt.AnimationDuration, 0, null, null, false, null, 992, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.NotSelectedChildPageItemNight$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SelectedChildPageCorrupted(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-374762730);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectedChildPageCorrupted)531@23609L43:ChildPagesPane.kt#a4olte");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374762730, i, -1, "com.myscript.nebo.editing.ui.compose.SelectedChildPageCorrupted (ChildPagesPane.kt:529)");
            }
            PreviewChildPageItem(new ChildPage("1", false, 1, 100, TextFieldImplKt.AnimationDuration, 0, null, null, true, null, PDFACompliance.e_PDFA7_3_6, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda74
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.SelectedChildPageCorrupted$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SelectedChildPageItemCorruptedNight(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(442089197);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectedChildPageItemCorruptedNight)538@23901L43:ChildPagesPane.kt#a4olte");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(442089197, i, -1, "com.myscript.nebo.editing.ui.compose.SelectedChildPageItemCorruptedNight (ChildPagesPane.kt:536)");
            }
            PreviewChildPageItem(new ChildPage("1", false, 1, 100, TextFieldImplKt.AnimationDuration, 0, null, null, true, null, PDFACompliance.e_PDFA7_3_6, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.SelectedChildPageItemCorruptedNight$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ChildPagesListPreview(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-141098816);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChildPagesListPreview)562@24636L23,552@24350L2,553@24380L2,563@24697L15,554@24407L2,555@24437L2,556@24464L2,557@24493L2,558@24520L2,559@24557L2,560@24585L2,561@24612L2,564@24743L2,549@24270L476:ChildPagesPane.kt#a4olte");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-141098816, i, -1, "com.myscript.nebo.editing.ui.compose.ChildPagesListPreview (ChildPagesPane.kt:543)");
            }
            PersistentList persistentListPersistentListOf = ExtensionsKt.persistentListOf(new ChildPage("1", false, 1, 100, 100, 0, null, null, false, null, 992, null), new ChildPage("2", true, 2, 100, TextFieldImplKt.AnimationDuration, 0, null, null, false, null, 992, null), new ChildPage("3", false, 3, 100, 100, 0, null, null, false, null, 992, null));
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            PersistentList persistentList = persistentListPersistentListOf;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843000770, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda45
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$0$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843001730, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda49
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$1$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function12 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843011887, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda50
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$2$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function13 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843002594, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda51
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$3$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function14 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843003554, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda52
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$4$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function1 function15 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843004418, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda53
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$5$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function1 function16 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843005346, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda54
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$6$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Function1 function17 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843006210, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda56
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$7$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            Function1 function18 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843007394, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda57
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$8$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            Function1 function19 = (Function1) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843008290, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda58
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$9$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            Function1 function110 = (Function1) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843009154, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda46
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$10$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            Function1 function111 = (Function1) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1843013346, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda47
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreview$lambda$11$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            ChildPagesList(true, persistentList, function1, function12, function13, function14, function15, function16, function17, function18, function19, function110, function111, (Function1) objRememberedValue12, lazyListStateRememberLazyListState, null, null, composer2, 920350086, 3510, 98304);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.ChildPagesListPreview$lambda$12(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$0$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$1$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$3$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$4$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$5$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$6$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$7$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$8$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$9$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$10$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List ChildPagesListPreview$lambda$2$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreview$lambda$11$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final void ChildPagesListPreviewNight(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1634770128);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ChildPagesListPreviewNight)588@25449L23,578@25163L2,579@25193L2,589@25510L15,580@25220L2,581@25250L2,582@25277L2,583@25306L2,584@25333L2,585@25370L2,586@25398L2,587@25425L2,590@25556L2,575@25083L476:ChildPagesPane.kt#a4olte");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1634770128, i, -1, "com.myscript.nebo.editing.ui.compose.ChildPagesListPreviewNight (ChildPagesPane.kt:569)");
            }
            PersistentList persistentListPersistentListOf = ExtensionsKt.persistentListOf(new ChildPage("1", false, 1, 100, 100, 0, null, null, false, null, 992, null), new ChildPage("2", true, 2, 100, TextFieldImplKt.AnimationDuration, 0, null, null, false, null, 992, null), new ChildPage("3", false, 3, 100, 100, 0, null, null, false, null, 992, null));
            LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            PersistentList persistentList = persistentListPersistentListOf;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943927694, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda60
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$0$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943926734, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda64
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$1$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function12 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943916577, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda65
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$2$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function13 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943925870, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda67
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$3$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function14 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943924910, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda68
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$4$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function1 function15 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943924046, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda69
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$5$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function1 function16 = (Function1) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943923118, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda70
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$6$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            Function1 function17 = (Function1) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943922254, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda71
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$7$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            Function1 function18 = (Function1) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943921070, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda72
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$8$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            Function1 function19 = (Function1) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943920174, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda73
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$9$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            Function1 function110 = (Function1) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943919310, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda61
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$10$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            Function1 function111 = (Function1) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -943915118, "CC(remember):ChildPagesPane.kt#9igjgp");
            Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue12 = new Function1() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda62
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$11$0((ChildPage) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            ChildPagesList(true, persistentList, function1, function12, function13, function14, function15, function16, function17, function18, function19, function110, function111, (Function1) objRememberedValue12, lazyListStateRememberLazyListState, null, null, composer2, 920350086, 3510, 98304);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.editing.ui.compose.ChildPagesPaneKt$$ExternalSyntheticLambda63
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesPaneKt.ChildPagesListPreviewNight$lambda$12(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$0$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$1$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$3$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$4$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$5$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$6$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$7$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$8$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$9$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$10$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List ChildPagesListPreviewNight$lambda$2$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPagesListPreviewNight$lambda$11$0(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}
