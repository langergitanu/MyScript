package com.myscript.nebo.grid.p029ui.compose;

import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ChipKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.TextKt;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.res.StringResources_androidKt;
import androidx.compose.p004ui.text.TextLayoutResult;
import androidx.compose.p004ui.text.TextStyle;
import androidx.compose.p004ui.text.font.FontFamily;
import androidx.compose.p004ui.text.font.FontStyle;
import androidx.compose.p004ui.text.font.FontWeight;
import androidx.compose.p004ui.text.style.TextAlign;
import androidx.compose.p004ui.text.style.TextDecoration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.grid.FolderUIState;
import com.myscript.nebo.grid.GridViewModel;
import com.myscript.nebo.grid.Order;
import com.myscript.nebo.grid.Sort;
import com.myscript.nebo.grid.SortState;
import com.myscript.nebo.p034ui.compose.component.DropdownMenuItemKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.p041ws.WebSocketProtocol;

/* JADX INFO: compiled from: sortComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\u001au\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000e\u001au\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0012\u001a)\u0010\u0013\u001a\u00020\u00012\b\b\u0001\u0010\u0014\u001a\u00020\u00152\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0016\u001a\u009b\u0001\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\r2\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u0003¢\u0006\u0002\u0010\u001f\u001a\r\u0010 \u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010!\u001a\r\u0010\"\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010!¨\u0006#²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002"}, m1599d2 = {"SortComponent", "", "gridViewModel", "Lcom/myscript/nebo/grid/GridViewModel;", "sortMenuToggle", "Lkotlin/Function0;", "onSortOptionClicked", "Lkotlin/Function1;", "Lcom/myscript/nebo/grid/Sort;", "Lkotlin/ParameterName;", "name", "option", "onOrderOptionClicked", "Lcom/myscript/nebo/grid/Order;", "(Lcom/myscript/nebo/grid/GridViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "sortState", "Lcom/myscript/nebo/grid/SortState;", "onSortButtonClicked", "(Lcom/myscript/nebo/grid/SortState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SortingButton", "optionNameRes", "", "(ILkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SortContextualMenu", "expanded", "", "currentSorting", "currentOrder", "availableOrderings", "", "onMenuDismissRequest", "(ZLcom/myscript/nebo/grid/Sort;Lcom/myscript/nebo/grid/Order;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SortComponentPreview", "(Landroidx/compose/runtime/Composer;I)V", "SortContextualMenuPreview", "app_standardRelease", "uiState", "Lcom/myscript/nebo/grid/FolderUIState;"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SortComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortComponent$lambda$1(GridViewModel gridViewModel, Function0 function0, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        SortComponent(gridViewModel, (Function0<Unit>) function0, (Function1<? super Sort, Unit>) function1, (Function1<? super Order, Unit>) function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortComponent$lambda$2(SortState sortState, Function0 function0, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        SortComponent(sortState, (Function0<Unit>) function0, (Function1<? super Sort, Unit>) function1, (Function1<? super Order, Unit>) function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortComponentPreview$lambda$0(int i, Composer composer, int i2) {
        SortComponentPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortContextualMenu$lambda$2(boolean z, Sort sort, Order order, List list, Function1 function1, Function1 function12, Function0 function0, int i, int i2, Composer composer, int i3) {
        SortContextualMenu(z, sort, order, list, function1, function12, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortContextualMenuPreview$lambda$0(int i, Composer composer, int i2) {
        SortContextualMenuPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortingButton$lambda$2(int i, Function0 function0, int i2, int i3, Composer composer, int i4) {
        SortingButton(i, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SortComponent(final GridViewModel gridViewModel, Function0<Unit> function0, Function1<? super Sort, Unit> function1, Function1<? super Order, Unit> function12, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function02;
        int i4;
        int i5;
        Function1<? super Order, Unit> function13;
        final Function1<? super Sort, Unit> function14;
        final Function0<Unit> function03;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(gridViewModel, "gridViewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(428977546);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SortComponent)N(gridViewModel,sortMenuToggle,onSortOptionClicked,onOrderOptionClicked)37@1530L31,39@1567L103:sortComponent.kt#r51d28");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(gridViewModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                function02 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        function13 = function12;
                        i3 |= composerStartRestartGroup.changedInstance(function13) ? 2048 : 1024;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function14 = function1;
                        function03 = function02;
                    } else {
                        Function0<Unit> function04 = i6 != 0 ? null : function02;
                        Function1<? super Sort, Unit> function15 = i4 != 0 ? null : function1;
                        if (i5 != 0) {
                            function13 = null;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(428977546, i3, -1, "com.myscript.nebo.grid.ui.compose.SortComponent (sortComponent.kt:36)");
                        }
                        SortComponent(SortComponent$lambda$0(LiveDataAdapterKt.observeAsState(gridViewModel.getFolderUIState(), new FolderUIState(null, null, null, false, false, false, null, null, null, false, null, null, 4095, null), composerStartRestartGroup, 0)).getSortState(), function04, function15, function13, composerStartRestartGroup, i3 & 8176, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function03 = function04;
                        function14 = function15;
                    }
                    final Function1<? super Order, Unit> function16 = function13;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SortComponentKt.SortComponent$lambda$1(gridViewModel, function03, function14, function16, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                function13 = function12;
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                }
                final Function1 function162 = function13;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            function13 = function12;
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
            }
            final Function1 function1622 = function13;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function02 = function0;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        function13 = function12;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        final Function1 function16222 = function13;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SortComponent(SortState sortState, Function0<Unit> function0, Function1<? super Sort, Unit> function1, Function1<? super Order, Unit> function12, Composer composer, final int i, final int i2) {
        final SortState sortState2;
        int i3;
        Function0<Unit> function02;
        int i4;
        Function1<? super Sort, Unit> function13;
        int i5;
        Function1<? super Order, Unit> function14;
        final Function0<Unit> function03;
        final Function1<? super Sort, Unit> function15;
        final Function1<? super Order, Unit> function16;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(442311605);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SortComponent)N(sortState,onSortButtonClicked,onSortOptionClicked,onOrderOptionClicked)49@1929L61,51@1996L387:sortComponent.kt#r51d28");
        if ((i & 6) == 0) {
            sortState2 = sortState;
            i3 = (composerStartRestartGroup.changedInstance(sortState2) ? 4 : 2) | i;
        } else {
            sortState2 = sortState;
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i3 |= 48;
        } else {
            if ((i & 48) == 0) {
                function02 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
            } else {
                if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                    function13 = function1;
                    i3 |= composerStartRestartGroup.changedInstance(function13) ? 256 : 128;
                }
                i5 = i2 & 8;
                if (i5 == 0) {
                    if ((i & 3072) == 0) {
                        function14 = function12;
                        i3 |= composerStartRestartGroup.changedInstance(function14) ? 2048 : 1024;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function03 = function02;
                        function15 = function13;
                        function16 = function14;
                    } else {
                        if (i6 != 0) {
                            function02 = null;
                        }
                        Function1<? super Sort, Unit> function17 = i4 == 0 ? function13 : null;
                        Function1<? super Order, Unit> function18 = i5 != 0 ? null : function14;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(442311605, i3, -1, "com.myscript.nebo.grid.ui.compose.SortComponent (sortComponent.kt:47)");
                        }
                        SortingButton(sortState2.getSorting().getNameRes(), function02, composerStartRestartGroup, i3 & 112, 0);
                        Function0<Unit> function04 = function02;
                        SortContextualMenu(sortState2.isMenuOpen(), sortState2.getSorting(), sortState2.getOrder(), sortState2.getAvailableOrderings(), function17, function18, function04, composerStartRestartGroup, ((i3 << 6) & 516096) | ((i3 << 15) & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function15 = function17;
                        function16 = function18;
                        function03 = function04;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SortComponentKt.SortComponent$lambda$2(sortState2, function03, function15, function16, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= 3072;
                function14 = function12;
                if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function13 = function1;
            i5 = i2 & 8;
            if (i5 == 0) {
            }
            function14 = function12;
            if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        function02 = function0;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function13 = function1;
        i5 = i2 & 8;
        if (i5 == 0) {
        }
        function14 = function12;
        if (composerStartRestartGroup.shouldExecute((i3 & 1171) == 1170, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SortingButton(final int i, Function0<Unit> function0, Composer composer, final int i2, final int i3) {
        int i4;
        Function0<Unit> function02;
        final Function0<Unit> function03;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1146674948);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SortingButton)N(optionNameRes,onSortButtonClicked)68@2723L33,69@2763L63,64@2544L282:sortComponent.kt#r51d28");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i5 = i3 & 2;
        if (i5 == 0) {
            if ((i2 & 48) == 0) {
                function02 = function0;
                i4 |= composerStartRestartGroup.changedInstance(function02) ? 32 : 16;
            }
            if (composerStartRestartGroup.shouldExecute((i4 & 19) == 18, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function03 = function02;
            } else {
                final Function0<Unit> function04 = i5 != 0 ? null : function02;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1146674948, i4, -1, "com.myscript.nebo.grid.ui.compose.SortingButton (sortComponent.kt:63)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1851978941, "CC(remember):sortComponent.kt#9igjgp");
                boolean z = (i4 & 112) == 32;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SortComponentKt.SortingButton$lambda$0$0(function04);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function03 = function04;
                ChipKt.Chip((Function0) objRememberedValue, null, false, null, null, null, null, ComposableSingletons$SortComponentKt.INSTANCE.m13259getLambda$1129831460$app_standardRelease(), ComposableLambdaKt.rememberComposableLambda(-1927192429, true, new Function3() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SortComponentKt.SortingButton$lambda$1(i, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 113246208, WebSocketProtocol.PAYLOAD_SHORT);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SortComponentKt.SortingButton$lambda$2(i, function03, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                return;
            }
            return;
        }
        i4 |= 48;
        function02 = function0;
        if (composerStartRestartGroup.shouldExecute((i4 & 19) == 18, i4 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortingButton$lambda$0$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortingButton$lambda$1(int i, RowScope Chip, Composer composer, int i2) {
        Intrinsics.checkNotNullParameter(Chip, "$this$Chip");
        ComposerKt.sourceInformation(composer, "C70@2785L34,70@2773L47:sortComponent.kt#r51d28");
        if (!composer.shouldExecute((i2 & 17) != 16, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1927192429, i2, -1, "com.myscript.nebo.grid.ui.compose.SortingButton.<anonymous> (sortComponent.kt:70)");
            }
            TextKt.m4524Text4IGK_g(StringResources_androidKt.stringResource(i, composer, 0), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SortContextualMenu(boolean z, Sort sort, Order order, List<? extends Order> list, Function1<? super Sort, Unit> function1, Function1<? super Order, Unit> function12, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        List<? extends Order> listEmptyList;
        int i4;
        Function1<? super Sort, Unit> function13;
        int i5;
        Function1<? super Order, Unit> function14;
        int i6;
        Composer composer2;
        final Sort sort2;
        final Function0<Unit> function02;
        final boolean z3;
        final List<? extends Order> list2;
        final Function1<? super Sort, Unit> function15;
        final Function1<? super Order, Unit> function16;
        final Order order2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1136541321);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SortContextualMenu)N(expanded,currentSorting,currentOrder,availableOrderings,onSortOptionClicked,onOrderOptionClicked,onMenuDismissRequest)85@3334L34,85@3412L958,85@3281L1089:sortComponent.kt#r51d28");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(sort == null ? -1 : sort.ordinal()) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(order == null ? -1 : order.ordinal()) ? 256 : 128;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 3072;
        } else {
            if ((i & 3072) == 0) {
                listEmptyList = list;
                i3 |= composerStartRestartGroup.changedInstance(listEmptyList) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else {
                if ((i & 24576) == 0) {
                    function13 = function1;
                    i3 |= composerStartRestartGroup.changedInstance(function13) ? 16384 : 8192;
                }
                i5 = i2 & 32;
                if (i5 == 0) {
                    if ((196608 & i) == 0) {
                        function14 = function12;
                        i3 |= composerStartRestartGroup.changedInstance(function14) ? 131072 : 65536;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i3 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
                    }
                    if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        sort2 = sort;
                        function02 = function0;
                        z3 = z2;
                        list2 = listEmptyList;
                        function15 = function13;
                        function16 = function14;
                        order2 = order;
                    } else {
                        boolean z4 = i7 != 0 ? false : z2;
                        Sort sort3 = i8 != 0 ? Sort.Manual : sort;
                        Order order3 = i9 != 0 ? Order.Ascending : order;
                        if (i10 != 0) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        if (i4 != 0) {
                            function13 = null;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        }
                        final Function0<Unit> function03 = i6 != 0 ? null : function0;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1136541321, i3, -1, "com.myscript.nebo.grid.ui.compose.SortContextualMenu (sortComponent.kt:82)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1294500775, "CC(remember):sortComponent.kt#9igjgp");
                        boolean z5 = (3670016 & i3) == 1048576;
                        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return SortComponentKt.SortContextualMenu$lambda$0$0(function03);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Sort sort4 = sort3;
                        final Order order4 = order3;
                        final List<? extends Order> list3 = listEmptyList;
                        final Function1<? super Sort, Unit> function17 = function13;
                        final Function1<? super Order, Unit> function18 = function14;
                        composer2 = composerStartRestartGroup;
                        AndroidMenu_androidKt.m4104DropdownMenu4kj_NE(z4, (Function0) objRememberedValue, AnimationModifierKt.animateContentSize$default(Modifier.INSTANCE, null, null, 3, null), 0L, null, null, ComposableLambdaKt.rememberComposableLambda(1974070506, true, new Function3() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return SortComponentKt.SortContextualMenu$lambda$1(list3, sort4, function17, order4, function18, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i3 & 14) | 1572864, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        sort2 = sort3;
                        order2 = order3;
                        function02 = function03;
                        z3 = z4;
                        list2 = list3;
                        function15 = function17;
                        function16 = function18;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SortComponentKt.SortContextualMenu$lambda$2(z3, sort2, order2, list2, function15, function16, function02, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                        return;
                    }
                    return;
                }
                i3 |= ProfileVerifier.CompilationStatus.f379xf2722a21;
                function14 = function12;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup == null) {
                }
            }
            function13 = function1;
            i5 = i2 & 32;
            if (i5 == 0) {
            }
            function14 = function12;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
            }
        }
        listEmptyList = list;
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        function13 = function1;
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        function14 = function12;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 599187) == 599186, i3 & 1)) {
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortContextualMenu$lambda$0$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortContextualMenu$lambda$1(List list, Sort sort, final Function1 function1, Order order, final Function1 function12, ColumnScope columnScope, Composer composer, int i) {
        int i2;
        String str;
        ColumnScope DropdownMenu = columnScope;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer, "C:sortComponent.kt#r51d28");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(DropdownMenu) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1974070506, i2, -1, "com.myscript.nebo.grid.ui.compose.SortContextualMenu.<anonymous> (sortComponent.kt:86)");
            }
            composer.startReplaceGroup(-1293787448);
            ComposerKt.sourceInformation(composer, "*89@3579L40,88@3523L284");
            Iterator<Sort> it = Sort.getEntries().iterator();
            while (true) {
                str = "CC(remember):sortComponent.kt#9igjgp";
                if (!it.hasNext()) {
                    break;
                }
                final Sort next = it.next();
                boolean z = next == sort;
                ComposerKt.sourceInformationMarkerStart(composer, -1365149457, "CC(remember):sortComponent.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changed(next.ordinal());
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SortComponentKt.SortContextualMenu$lambda$1$0$0$0(function1, next);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                int nameRes = next.getNameRes();
                Integer numValueOf = Integer.valueOf(C6183R.drawable.ic_check);
                numValueOf.intValue();
                if (!z) {
                    numValueOf = null;
                }
                DropdownMenuItemKt.DropdownMenuItemWithIcon(DropdownMenu, (Function0<Unit>) function0, nameRes, numValueOf, true, false, false, composer, (i2 & 14) | 24576, 48);
                DropdownMenu = columnScope;
            }
            composer.endReplaceGroup();
            if (!list.isEmpty()) {
                composer.startReplaceGroup(-1452276957);
                ComposerKt.sourceInformation(composer, "96@3877L9,*100@4074L42,99@4014L326");
                DividerKt.m4242DivideroMI9zvI(null, 0L, 0.0f, 0.0f, composer, 0, 15);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    final Order order2 = (Order) it2.next();
                    boolean z2 = order2 == order;
                    ComposerKt.sourceInformationMarkerStart(composer, -1325645146, str);
                    boolean zChanged2 = composer.changed(function12) | composer.changed(order2.ordinal());
                    Object objRememberedValue2 = composer.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return SortComponentKt.SortContextualMenu$lambda$1$1$0$0(function12, order2);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue2);
                    }
                    Function0 function02 = (Function0) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    int nameRes2 = order2.getNameRes(sort);
                    Integer numValueOf2 = Integer.valueOf(C6183R.drawable.ic_check);
                    numValueOf2.intValue();
                    if (!z2) {
                        numValueOf2 = null;
                    }
                    DropdownMenuItemKt.DropdownMenuItemWithIcon(columnScope, (Function0<Unit>) function02, nameRes2, numValueOf2, true, false, false, composer, (i2 & 14) | 24576, 48);
                    str = str;
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1451795496);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortContextualMenu$lambda$1$0$0$0(Function1 function1, Sort sort) {
        if (function1 != null) {
            function1.invoke(sort);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SortContextualMenu$lambda$1$1$0$0(Function1 function1, Order order) {
        if (function1 != null) {
            function1.invoke(order);
        }
        return Unit.INSTANCE;
    }

    private static final void SortComponentPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1349425018);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SortComponentPreview)113@4436L109:sortComponent.kt#r51d28");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1349425018, i, -1, "com.myscript.nebo.grid.ui.compose.SortComponentPreview (sortComponent.kt:112)");
            }
            SortComponent(new SortState(Sort.CreationDate, null, Order.Ascending, true, 2, null), (Function0<Unit>) null, (Function1<? super Sort, Unit>) null, (Function1<? super Order, Unit>) null, composerStartRestartGroup, 0, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SortComponentKt.SortComponentPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void SortContextualMenuPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1833594171);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SortContextualMenuPreview)119@4616L20:sortComponent.kt#r51d28");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1833594171, i, -1, "com.myscript.nebo.grid.ui.compose.SortContextualMenuPreview (sortComponent.kt:118)");
            }
            SortContextualMenu(false, null, null, null, null, null, null, composerStartRestartGroup, 0, 127);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.myscript.nebo.grid.ui.compose.SortComponentKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SortComponentKt.SortContextualMenuPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final FolderUIState SortComponent$lambda$0(State<FolderUIState> state) {
        return state.getValue();
    }
}
