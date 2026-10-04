package com.myscript.nebo.editing;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.livedata.LiveDataAdapterKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.ColorExt;
import com.myscript.android.utils.ComposeViewManager;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.ColorPolicyRepositoryProvider;
import com.myscript.nebo.common.utils.PageBackgroundUtilsKt;
import com.myscript.nebo.discoverability.p024ui.TooltipUIState;
import com.myscript.nebo.discoverability.p024ui.compose.TooltipComposableProviderImpl;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.editing.ManagePagesDialog;
import com.myscript.nebo.editing.background.PageBackgroundFragment;
import com.myscript.nebo.editing.discoverability.EditingDiscoverableFeature;
import com.myscript.nebo.editing.p028ui.compose.ChildPagesPaneKt;
import com.myscript.nebo.freemium.FreemiumLimitationTrigger;
import com.myscript.nebo.freemium.FreemiumLimitationViewModel;
import com.myscript.nebo.note.p030ui.PageBackgroundColor;
import com.myscript.nebo.note.p030ui.PageBackgroundPattern;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.PDFManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

/* JADX INFO: compiled from: ChildPagesFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0015H\u0002J\u0012\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010,\u001a\u00020\u00152\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u001a\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00105\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000RL\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013j\u0004\u0018\u0001`\u00162\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013j\u0004\u0018\u0001`\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b\u001e\u0010\u001f¨\u00067²\u0006\u0010\u00108\u001a\b\u0012\u0004\u0012\u00020209X\u008a\u0084\u0002"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPagesFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "discoverabilityTooltip", "Landroidx/compose/ui/platform/ComposeView;", "viewModel", "Lcom/myscript/nebo/editing/ChildPagesViewModel;", "getViewModel", "()Lcom/myscript/nebo/editing/ChildPagesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "editableValue", "Lcom/myscript/nebo/editing/PageIndicatorEditText;", "addPageButtonRect", "Landroid/graphics/Rect;", "addPageButtonVisible", "", "value", "Lkotlin/Function1;", "", "", "Lcom/myscript/nebo/editing/PageIndicatorChangedListener;", "pageIndicatorChangedListener", "getPageIndicatorChangedListener", "()Lkotlin/jvm/functions/Function1;", "setPageIndicatorChangedListener", "(Lkotlin/jvm/functions/Function1;)V", "freemiumLimitationViewModel", "Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "getFreemiumLimitationViewModel", "()Lcom/myscript/nebo/freemium/FreemiumLimitationViewModel;", "freemiumLimitationViewModel$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "updateTooltip", "tooltipUIState", "Lcom/myscript/nebo/discoverability/ui/TooltipUIState;", "updatePageWidgetState", "state", "Lcom/myscript/nebo/editing/ChildPagesNavigationState;", "computeBackgroundUIState", "Lcom/myscript/nebo/editing/BackgroundSettingsUIState;", "childPage", "Lcom/myscript/nebo/editing/ChildPage;", "onViewCreated", "view", "onDestroyView", "Companion", "app_standardRelease", "childPages", "Lkotlinx/collections/immutable/ImmutableList;"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ChildPagesFragment extends Fragment {
    public static final String TAG = "ChildPagesFragment";
    private Rect addPageButtonRect;
    private boolean addPageButtonVisible;
    private ComposeView discoverabilityTooltip;
    private PageIndicatorEditText editableValue;

    /* JADX INFO: renamed from: freemiumLimitationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy freemiumLimitationViewModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final ChildPagesFragment newInstance() {
        return INSTANCE.newInstance();
    }

    public ChildPagesFragment() {
        final ChildPagesFragment childPagesFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(childPagesFragment, Reflection.getOrCreateKotlinClass(ChildPagesViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.ChildPagesFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return childPagesFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.ChildPagesFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? childPagesFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ChildPagesFragment.viewModel_delegate$lambda$0();
            }
        });
        this.freemiumLimitationViewModel = FragmentViewModelLazyKt.createViewModelLazy(childPagesFragment, Reflection.getOrCreateKotlinClass(FreemiumLimitationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.ChildPagesFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return childPagesFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.ChildPagesFragment$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? childPagesFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FreemiumLimitationViewModel.Factory;
            }
        });
    }

    private final ChildPagesViewModel getViewModel() {
        return (ChildPagesViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0() {
        return ChildPagesViewModel.INSTANCE.getFactory();
    }

    public final Function1<Integer, Unit> getPageIndicatorChangedListener() {
        PageIndicatorEditText pageIndicatorEditText = this.editableValue;
        if (pageIndicatorEditText != null) {
            return pageIndicatorEditText.getPageIndicatorChangedListener();
        }
        return null;
    }

    public final void setPageIndicatorChangedListener(Function1<? super Integer, Unit> function1) {
        PageIndicatorEditText pageIndicatorEditText = this.editableValue;
        if (pageIndicatorEditText != null) {
            pageIndicatorEditText.setPageIndicatorChangedListener(function1);
        }
    }

    private final FreemiumLimitationViewModel getFreemiumLimitationViewModel() {
        return (FreemiumLimitationViewModel) this.freemiumLimitationViewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final Function1 function1 = new Function1() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChildPagesFragment.onCreateView$lambda$0(this.f$0, (ChildPage) obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChildPagesFragment.onCreateView$lambda$1((ChildPage) obj);
            }
        };
        final ChildPagesFragment$onCreateView$onChildPageActionsRequest$1 childPagesFragment$onCreateView$onChildPageActionsRequest$1 = new ChildPagesFragment$onCreateView$onChildPageActionsRequest$1(getViewModel());
        final Function1 function13 = new Function1() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChildPagesFragment.onCreateView$lambda$2(this.f$0, (ChildPage) obj);
            }
        };
        final ChildPagesFragment$onCreateView$onDuplicatePage$1 childPagesFragment$onCreateView$onDuplicatePage$1 = new ChildPagesFragment$onCreateView$onDuplicatePage$1(getViewModel());
        final ChildPagesFragment$onCreateView$onMovePageUp$1 childPagesFragment$onCreateView$onMovePageUp$1 = new ChildPagesFragment$onCreateView$onMovePageUp$1(getViewModel());
        final ChildPagesFragment$onCreateView$onMovePageDown$1 childPagesFragment$onCreateView$onMovePageDown$1 = new ChildPagesFragment$onCreateView$onMovePageDown$1(getViewModel());
        final Function1 function14 = new Function1() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChildPagesFragment.onCreateView$lambda$3((ChildPage) obj);
            }
        };
        final Function1 function15 = new Function1() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChildPagesFragment.onCreateView$lambda$4(this.f$0, (ChildPage) obj);
            }
        };
        final Function1 function16 = new Function1() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChildPagesFragment.onCreateView$lambda$5(this.f$0, (ChildPage) obj);
            }
        };
        final Function1 function17 = new Function1() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChildPagesFragment.onCreateView$lambda$6(this.f$0, (ChildPage) obj);
            }
        };
        final ChildPagesFragment$onCreateView$onThumbnailRequest$1 childPagesFragment$onCreateView$onThumbnailRequest$1 = new ChildPagesFragment$onCreateView$onThumbnailRequest$1(getViewModel());
        View viewInflate = inflater.inflate(C6079R.layout.child_pages_fragment, (ViewGroup) null);
        PageIndicatorEditText pageIndicatorEditText = (PageIndicatorEditText) viewInflate.findViewById(C6079R.id.child_pages_widget);
        pageIndicatorEditText.setPageIndicatorChangedListener(new ChildPagesFragment$onCreateView$1$1$1(getViewModel()));
        this.editableValue = pageIndicatorEditText;
        final ComposeView composeView = (ComposeView) viewInflate.findViewById(C6079R.id.child_pages_list);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-2057232388, true, new Function2() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ChildPagesFragment.onCreateView$lambda$7$1$0(composeView, this, function1, function12, childPagesFragment$onCreateView$onChildPageActionsRequest$1, function13, childPagesFragment$onCreateView$onDuplicatePage$1, childPagesFragment$onCreateView$onMovePageUp$1, childPagesFragment$onCreateView$onMovePageDown$1, function14, function16, function15, function17, childPagesFragment$onCreateView$onThumbnailRequest$1, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        View viewFindViewById = viewInflate.findViewById(C6079R.id.discoverability_tooltip);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.discoverabilityTooltip = (ComposeView) viewFindViewById;
        getViewModel().getDiscoveryTooltip().observe(getViewLifecycleOwner(), new ChildPagesFragment$sam$androidx_lifecycle_Observer$0(new ChildPagesFragment$onCreateView$1$3(this)));
        Intrinsics.checkNotNullExpressionValue(viewInflate, "apply(...)");
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(ChildPagesFragment childPagesFragment, ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        childPagesFragment.getViewModel().selectPage(it, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1(ChildPage it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2(final ChildPagesFragment childPagesFragment, final ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        if (childPagesFragment.getViewModel().getPaginatedContainer() instanceof PDFManager) {
            childPagesFragment.getFreemiumLimitationViewModel().tryUsePremiumFeature(FreemiumLimitationTrigger.TRIGGER_PDF_INSERT_BLANK_PAGE, new Function0() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ChildPagesFragment.onCreateView$lambda$2$0(this.f$0, childPage);
                }
            });
        } else {
            ChildPagesViewModel.insertPage$default(childPagesFragment.getViewModel(), childPage, false, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$0(ChildPagesFragment childPagesFragment, ChildPage childPage) {
        ChildPagesViewModel.insertPage$default(childPagesFragment.getViewModel(), childPage, false, 2, null);
        childPagesFragment.getViewModel().discover(EditingDiscoverableFeature.PdfAddPageFeature.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$3(ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$4(ChildPagesFragment childPagesFragment, ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        ManagePagesDialog managePagesDialogNewInstance$default = ManagePagesDialog.Companion.newInstance$default(ManagePagesDialog.INSTANCE, false, false, 3, null);
        FragmentManager parentFragmentManager = childPagesFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        managePagesDialogNewInstance$default.show(parentFragmentManager);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$5(ChildPagesFragment childPagesFragment, ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        if (childPagesFragment.getViewModel().getCanConfigureBackground()) {
            PageKey pageKeyCreateKeyFromUuid = PageKey.createKeyFromUuid(childPage.getId());
            PageBackgroundFragment.Companion companion = PageBackgroundFragment.INSTANCE;
            Intrinsics.checkNotNull(pageKeyCreateKeyFromUuid);
            companion.newInstance(false, true, pageKeyCreateKeyFromUuid, childPagesFragment.computeBackgroundUIState(childPage)).show(childPagesFragment.getParentFragmentManager(), PageBackgroundFragment.TAG);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$6(final ChildPagesFragment childPagesFragment, final ChildPage childPage) {
        Intrinsics.checkNotNullParameter(childPage, "childPage");
        new MaterialAlertDialogBuilder(childPagesFragment.requireContext()).setTitle(C6421R.string.dialog_action_delete_page_title).setMessage(C6421R.string.dialog_action_delete_page_content).setPositiveButton(C6421R.string.dialog_action_delete_confirm, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ChildPagesFragment.onCreateView$lambda$6$0(this.f$0, childPage, dialogInterface, i);
            }
        }).setNegativeButton(C6183R.string.dialog_cancel, (DialogInterface.OnClickListener) null).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6$0(ChildPagesFragment childPagesFragment, ChildPage childPage, DialogInterface dialogInterface, int i) {
        childPagesFragment.getViewModel().deletePage(childPage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$7$1$0(ComposeView composeView, final ChildPagesFragment childPagesFragment, final Function1 function1, final Function1 function12, final KFunction kFunction, final Function1 function13, final KFunction kFunction2, final KFunction kFunction3, final KFunction kFunction4, final Function1 function14, final Function1 function15, final Function1 function16, final Function1 function17, final KFunction kFunction5, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C131@6258L1114,131@6158L1214:ChildPagesFragment.kt#v1cuvs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2057232388, i, -1, "com.myscript.nebo.editing.ChildPagesFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (ChildPagesFragment.kt:131)");
            }
            Context context = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ThemeKt.m13017NeboTheme3IgeMak(false, ColorKt.Color(ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorPrimary)), ComposableLambdaKt.rememberComposableLambda(1408157060, true, new Function2() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChildPagesFragment.onCreateView$lambda$7$1$0$0(this.f$0, function1, function12, kFunction, function13, kFunction2, kFunction3, kFunction4, function14, function15, function16, function17, kFunction5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, RendererCapabilities.DECODER_SUPPORT_MASK, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$7$1$0$0(final ChildPagesFragment childPagesFragment, Function1 function1, Function1 function12, KFunction kFunction, Function1 function13, KFunction kFunction2, KFunction kFunction3, KFunction kFunction4, Function1 function14, Function1 function15, Function1 function16, Function1 function17, KFunction kFunction5, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C132@6323L34,149@7072L252,134@6383L967:ChildPagesFragment.kt#v1cuvs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408157060, i, -1, "com.myscript.nebo.editing.ChildPagesFragment.onCreateView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ChildPagesFragment.kt:132)");
            }
            State stateObserveAsState = LiveDataAdapterKt.observeAsState(childPagesFragment.getViewModel().getChildPages(), ExtensionsKt.persistentListOf(), composer, 48);
            boolean displayPageInsertionButton = childPagesFragment.getViewModel().getDisplayPageInsertionButton();
            ImmutableList<ChildPage> immutableListOnCreateView$lambda$7$1$0$0$0 = onCreateView$lambda$7$1$0$0$0(stateObserveAsState);
            Function1 function18 = (Function1) kFunction;
            Function1 function19 = (Function1) kFunction2;
            Function1 function110 = (Function1) kFunction3;
            Function1 function111 = (Function1) kFunction4;
            Function1 function112 = (Function1) kFunction5;
            ComposerKt.sourceInformationMarkerStart(composer, 324262720, "CC(remember):ChildPagesFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(childPagesFragment);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function2() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChildPagesFragment.onCreateView$lambda$7$1$0$0$1$0(this.f$0, (Rect) obj, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ChildPagesPaneKt.ChildPagesPane(displayPageInsertionButton, immutableListOnCreateView$lambda$7$1$0$0$0, function1, function12, function18, function13, function19, function110, function111, function14, function15, function16, function17, function112, (Function2) objRememberedValue, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$7$1$0$0$1$0(ChildPagesFragment childPagesFragment, Rect addButtonRect, boolean z) {
        Intrinsics.checkNotNullParameter(addButtonRect, "addButtonRect");
        childPagesFragment.addPageButtonRect = addButtonRect;
        childPagesFragment.addPageButtonVisible = z;
        childPagesFragment.updateTooltip();
        return Unit.INSTANCE;
    }

    private final void updateTooltip() {
        updateTooltip(getViewModel().getDiscoveryTooltip().getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateTooltip(TooltipUIState tooltipUIState) {
        TooltipUIState tooltipUIStateCopy$default = null;
        Object userData = tooltipUIState != null ? tooltipUIState.getUserData() : null;
        TooltipUIState tooltipUIState2 = (userData instanceof EditingDiscoverableFeature.DiscoverableFeatureDestination ? (EditingDiscoverableFeature.DiscoverableFeatureDestination) userData : null) == EditingDiscoverableFeature.DiscoverableFeatureDestination.CHILD_PAGES ? tooltipUIState : null;
        ComposeViewManager composeViewManager = ComposeViewManager.INSTANCE;
        ComposeView composeView = this.discoverabilityTooltip;
        if (composeView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discoverabilityTooltip");
            composeView = null;
        }
        if (tooltipUIState2 != null) {
            ChildPagesPanelVisibilityState value = getViewModel().isChildPagesPanelVisible().getValue();
            if (value != null) {
                boolean z = value.isVisible() && this.addPageButtonVisible;
                tooltipUIStateCopy$default = TooltipUIState.copy$default(tooltipUIState2, 0, 0, null, 0, null, z, null, null, 223, null);
            }
        }
        composeViewManager.setComposableContent(composeView, new TooltipComposableProviderImpl(tooltipUIStateCopy$default, this.addPageButtonRect, new C63151(getViewModel())));
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesFragment$updateTooltip$1 */
    /* JADX INFO: compiled from: ChildPagesFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C63151 extends FunctionReferenceImpl implements Function0<Unit> {
        C63151(Object obj) {
            super(0, obj, ChildPagesViewModel.class, "dismissCurrentTooltip", "dismissCurrentTooltip()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((ChildPagesViewModel) this.receiver).dismissCurrentTooltip();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePageWidgetState(ChildPagesNavigationState state) {
        PageIndicatorEditText pageIndicatorEditText = this.editableValue;
        if (pageIndicatorEditText != null) {
            pageIndicatorEditText.setState(state.getSelectedPageNumber(), state.getPageCount());
        }
    }

    private final BackgroundSettingsUIState computeBackgroundUIState(ChildPage childPage) {
        if (!getViewModel().getCanConfigureBackground()) {
            throw new IllegalArgumentException(("Page background configuration not expected for " + childPage).toString());
        }
        List<Integer> light_background_colors = PageBackgroundUtilsKt.getLIGHT_BACKGROUND_COLORS();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(light_background_colors, 10));
        Iterator<T> it = light_background_colors.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            int opaque = ColorExt.getOpaque(((Number) it.next()).intValue());
            int iResolveBackgroundColor = PageBackgroundUtilsKt.resolveBackgroundColor(opaque, DarkModeUtils.isDarkMode(this));
            if (ColorExt.getOpaque(childPage.getBackgroundColor()) != opaque) {
                z = false;
            }
            arrayList.add(new PageBackgroundColor(opaque, iResolveBackgroundColor, z));
        }
        ArrayList arrayList2 = arrayList;
        List<BackgroundPattern> background_patterns = PageBackgroundUtilsKt.getBACKGROUND_PATTERNS();
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(background_patterns, 10));
        for (BackgroundPattern backgroundPattern : background_patterns) {
            arrayList3.add(new PageBackgroundPattern(backgroundPattern, childPage.getBackgroundPattern() == backgroundPattern));
        }
        return new BackgroundSettingsUIState(arrayList2, arrayList3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ComponentCallbacks2 application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.common.ColorPolicyRepositoryProvider");
        ((ColorPolicyRepositoryProvider) application).provideColorPolicyRepository().getColorPolicy().observe(getViewLifecycleOwner(), new ChildPagesFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.ChildPagesFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ChildPagesFragment.onViewCreated$lambda$0(this.f$0, (IColorInversionPolicy) obj);
            }
        }));
        getViewModel().getChildPagesNavigationState().observe(getViewLifecycleOwner(), new ChildPagesFragment$sam$androidx_lifecycle_Observer$0(new C63142(this)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$0(ChildPagesFragment childPagesFragment, IColorInversionPolicy iColorInversionPolicy) {
        ChildPagesViewModel viewModel = childPagesFragment.getViewModel();
        Intrinsics.checkNotNull(iColorInversionPolicy);
        viewModel.setColorInversionPolicy(iColorInversionPolicy);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.editing.ChildPagesFragment$onViewCreated$2 */
    /* JADX INFO: compiled from: ChildPagesFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C63142 extends FunctionReferenceImpl implements Function1<ChildPagesNavigationState, Unit> {
        C63142(Object obj) {
            super(1, obj, ChildPagesFragment.class, "updatePageWidgetState", "updatePageWidgetState(Lcom/myscript/nebo/editing/ChildPagesNavigationState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChildPagesNavigationState childPagesNavigationState) {
            invoke2(childPagesNavigationState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChildPagesNavigationState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((ChildPagesFragment) this.receiver).updatePageWidgetState(p0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        PageIndicatorEditText pageIndicatorEditText = this.editableValue;
        if (pageIndicatorEditText != null) {
            pageIndicatorEditText.setPageIndicatorChangedListener(null);
        }
        this.editableValue = null;
        super.onDestroyView();
    }

    /* JADX INFO: compiled from: ChildPagesFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/editing/ChildPagesFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/editing/ChildPagesFragment;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ChildPagesFragment newInstance() {
            return new ChildPagesFragment();
        }
    }

    private static final ImmutableList<ChildPage> onCreateView$lambda$7$1$0$0$0(State<? extends ImmutableList<ChildPage>> state) {
        return state.getValue();
    }
}
