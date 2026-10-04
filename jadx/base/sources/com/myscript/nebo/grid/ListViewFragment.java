package com.myscript.nebo.grid;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0028R;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.grid.p029ui.compose.NotesListViewKt;
import com.myscript.snt.core.PageKey;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: ListViewFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m1599d2 = {"Lcom/myscript/nebo/grid/ListViewFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/myscript/nebo/grid/INotesViewFragment;", "<init>", "()V", "gridViewModel", "Lcom/myscript/nebo/grid/GridViewModel;", "getGridViewModel", "()Lcom/myscript/nebo/grid/GridViewModel;", "gridViewModel$delegate", "Lkotlin/Lazy;", "maxElevation", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "smoothScrollTo", "", "pageKey", "Lcom/myscript/snt/core/PageKey;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ListViewFragment extends Fragment implements INotesViewFragment {
    public static final String TAG = "ListViewFragment";

    /* JADX INFO: renamed from: gridViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gridViewModel;
    private int maxElevation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final ListViewFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // com.myscript.nebo.grid.INotesViewFragment
    public void smoothScrollTo(PageKey pageKey) {
    }

    public ListViewFragment() {
        final ListViewFragment listViewFragment = this;
        final Function0 function0 = null;
        this.gridViewModel = FragmentViewModelLazyKt.createViewModelLazy(listViewFragment, Reflection.getOrCreateKotlinClass(GridViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.ListViewFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return listViewFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.ListViewFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? listViewFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.grid.ListViewFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GridViewModel.Factory;
            }
        });
    }

    private final GridViewModel getGridViewModel() {
        return (GridViewModel) this.gridViewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.maxElevation = requireContext().getResources().getDimensionPixelSize(C6079R.dimen.elevation_toolbar);
        final Function1 function1 = new Function1() { // from class: com.myscript.nebo.grid.ListViewFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListViewFragment.onCreateView$lambda$0(this.f$0, (PageKey) obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.myscript.nebo.grid.ListViewFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ListViewFragment.onCreateView$lambda$1(this.f$0, (PageKey) obj);
            }
        };
        final View viewFindViewById = requireActivity().findViewById(C6079R.id.activity_main_app_bar_container);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        final ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(531764336, true, new Function2() { // from class: com.myscript.nebo.grid.ListViewFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ListViewFragment.onCreateView$lambda$2$0(composeView, this, function1, function12, viewFindViewById, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(ListViewFragment listViewFragment, PageKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (listViewFragment.getGridViewModel().getIsSelectionMode()) {
            listViewFragment.getGridViewModel().togglePageSelection(it);
        } else {
            listViewFragment.getGridViewModel().openPage(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1(ListViewFragment listViewFragment, PageKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        listViewFragment.getGridViewModel().togglePageSelection(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$0(ComposeView composeView, final ListViewFragment listViewFragment, final Function1 function1, final Function1 function12, final View view, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C47@1875L291,47@1775L391:ListViewFragment.kt#egc4u2");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(531764336, i, -1, "com.myscript.nebo.grid.ListViewFragment.onCreateView.<anonymous>.<anonymous> (ListViewFragment.kt:47)");
            }
            Context context = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ThemeKt.m13017NeboTheme3IgeMak(false, ColorKt.Color(ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorPrimary)), ComposableLambdaKt.rememberComposableLambda(-1820103704, true, new Function2() { // from class: com.myscript.nebo.grid.ListViewFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ListViewFragment.onCreateView$lambda$2$0$0(this.f$0, function1, function12, view, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$0$0(final ListViewFragment listViewFragment, Function1 function1, Function1 function12, final View view, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C48@1964L31,48@1997L151,48@1897L251:ListViewFragment.kt#egc4u2");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1820103704, i, -1, "com.myscript.nebo.grid.ListViewFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (ListViewFragment.kt:48)");
            }
            GridViewModel gridViewModel = listViewFragment.getGridViewModel();
            GridViewModel gridViewModel2 = listViewFragment.getGridViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -1067967193, "CC(remember):ListViewFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(gridViewModel2);
            ListViewFragment$onCreateView$1$1$1$1$1 listViewFragment$onCreateView$1$1$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || listViewFragment$onCreateView$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                listViewFragment$onCreateView$1$1$1$1$1RememberedValue = new ListViewFragment$onCreateView$1$1$1$1$1(gridViewModel2);
                composer.updateRememberedValue(listViewFragment$onCreateView$1$1$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function13 = (Function1) ((KFunction) listViewFragment$onCreateView$1$1$1$1$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, -1067966017, "CC(remember):ListViewFragment.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(view) | composer.changedInstance(listViewFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.myscript.nebo.grid.ListViewFragment$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ListViewFragment.onCreateView$lambda$2$0$0$1$0(view, listViewFragment, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            NotesListViewKt.NotesListViewPane(gridViewModel, function1, function12, function13, (Function2) objRememberedValue, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$0$0$1$0(View view, ListViewFragment listViewFragment, int i, int i2) {
        Intrinsics.checkNotNull(view);
        ToolbarExtKt.setElevationBasedOnScroll(view, i, i2, listViewFragment.maxElevation);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: ListViewFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/grid/ListViewFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/grid/ListViewFragment;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ListViewFragment newInstance() {
            return new ListViewFragment();
        }
    }
}
