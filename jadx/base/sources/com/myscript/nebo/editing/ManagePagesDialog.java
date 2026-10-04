package com.myscript.nebo.editing;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.C0028R;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.p004ui.graphics.ColorKt;
import androidx.compose.p004ui.platform.ComposeView;
import androidx.compose.p004ui.platform.ViewCompositionStrategy;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.C6014R;
import com.myscript.android.utils.ContextExtKt;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.android.utils.DialogUtilsKt;
import com.myscript.android.utils.SelectionMode;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.dms.p026ui.compose.ThemeKt;
import com.myscript.nebo.editing.p028ui.compose.ManagePagesPaneKt;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.p022ai.presentation.AIQuizViewModel;
import com.myscript.nebo.p022ai.presentation.AISummarizeViewModel;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.myscript.nebo.p022ai.presentation.compose.AIMode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlinx.collections.immutable.ImmutableList;

/* JADX INFO: compiled from: ManagePagesDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000·\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001.\b\u0007\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00100\u001a\u000201H\u0016J&\u00102\u001a\u0004\u0018\u00010$2\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001a\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020$2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0012\u0010<\u001a\u00020=2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u00020:H\u0016J\u0018\u0010?\u001a\u00020:2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020:2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u00020:2\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020:H\u0016J\u000e\u0010L\u001a\u00020:2\u0006\u0010M\u001a\u00020NJ\u0016\u0010O\u001a\u00020:2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020:0QH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020&8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006S"}, m1599d2 = {"Lcom/myscript/nebo/editing/ManagePagesDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroidx/core/view/MenuProvider;", "<init>", "()V", "viewModel", "Lcom/myscript/nebo/editing/ChildPagesViewModel;", "getViewModel", "()Lcom/myscript/nebo/editing/ChildPagesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "aiContainerViewModel", "Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel;", "getAiContainerViewModel", "()Lcom/myscript/nebo/ai/presentation/compose/AIContainerViewModel;", "aiContainerViewModel$delegate", "aiSummarizeViewModel", "Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel;", "getAiSummarizeViewModel", "()Lcom/myscript/nebo/ai/presentation/AISummarizeViewModel;", "aiSummarizeViewModel$delegate", "aiQuizViewModel", "Lcom/myscript/nebo/ai/presentation/AIQuizViewModel;", "getAiQuizViewModel", "()Lcom/myscript/nebo/ai/presentation/AIQuizViewModel;", "aiQuizViewModel$delegate", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "toolbarcontainer", "Landroid/widget/FrameLayout;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "composeView", "Landroid/view/View;", "aiSummarizationActive", "", "getAiSummarizationActive", "()Z", "aiQuizActive", "getAiQuizActive", "selectionMode", "Lcom/myscript/android/utils/SelectionMode;", "selectionModeCallback", "com/myscript/nebo/editing/ManagePagesDialog$selectionModeCallback$1", "Lcom/myscript/nebo/editing/ManagePagesDialog$selectionModeCallback$1;", "getTheme", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onCreateDialog", "Landroid/app/Dialog;", "onDestroy", "onCreateMenu", "menu", "Landroid/view/Menu;", "menuInflater", "Landroid/view/MenuInflater;", "onPrepareMenu", "onMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "dismiss", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "showDeleteConfirmationDialog", "onDeleteConfirm", "Lkotlin/Function0;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ManagePagesDialog extends DialogFragment implements MenuProvider {
    public static final String AI_QUIZ_ACTIVE = "isAIQuizActive";
    public static final String AI_SUMMARIZATION_ACTIVE = "isAISummarizationActive";
    public static final String TAG = "ManagePagesDialog";

    /* JADX INFO: renamed from: aiContainerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy aiContainerViewModel;

    /* JADX INFO: renamed from: aiQuizViewModel$delegate, reason: from kotlin metadata */
    private final Lazy aiQuizViewModel;

    /* JADX INFO: renamed from: aiSummarizeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy aiSummarizeViewModel;
    private View composeView;
    private SelectionMode selectionMode;
    private Toolbar toolbar;
    private FrameLayout toolbarcontainer;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.editing.ManagePagesDialog$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ManagePagesDialog.logger_delegate$lambda$0(this.f$0);
        }
    });
    private final ManagePagesDialog$selectionModeCallback$1 selectionModeCallback = new ManagePagesDialog$selectionModeCallback$1(this);

    public ManagePagesDialog() {
        final ManagePagesDialog managePagesDialog = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(managePagesDialog, Reflection.getOrCreateKotlinClass(ChildPagesViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return managePagesDialog.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? managePagesDialog.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.editing.ManagePagesDialog$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ManagePagesDialog.viewModel_delegate$lambda$0();
            }
        });
        this.aiContainerViewModel = FragmentViewModelLazyKt.createViewModelLazy(managePagesDialog, Reflection.getOrCreateKotlinClass(AIContainerViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return managePagesDialog.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? managePagesDialog.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return managePagesDialog.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.aiSummarizeViewModel = FragmentViewModelLazyKt.createViewModelLazy(managePagesDialog, Reflection.getOrCreateKotlinClass(AISummarizeViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return managePagesDialog.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? managePagesDialog.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$9
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return managePagesDialog.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
        this.aiQuizViewModel = FragmentViewModelLazyKt.createViewModelLazy(managePagesDialog, Reflection.getOrCreateKotlinClass(AIQuizViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return managePagesDialog.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? managePagesDialog.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.myscript.nebo.editing.ManagePagesDialog$special$$inlined$activityViewModels$default$12
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return managePagesDialog.requireActivity().getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChildPagesViewModel getViewModel() {
        return (ChildPagesViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0() {
        return ChildPagesViewModel.INSTANCE.getFactory();
    }

    private final AIContainerViewModel getAiContainerViewModel() {
        return (AIContainerViewModel) this.aiContainerViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AISummarizeViewModel getAiSummarizeViewModel() {
        return (AISummarizeViewModel) this.aiSummarizeViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIQuizViewModel getAiQuizViewModel() {
        return (AIQuizViewModel) this.aiQuizViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(ManagePagesDialog managePagesDialog) {
        Context context = managePagesDialog.getContext();
        Object applicationContext = context != null ? context.getApplicationContext() : null;
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) applicationContext).provideTechnicalLogger();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getAiSummarizationActive() {
        return requireArguments().getBoolean(AI_SUMMARIZATION_ACTIVE, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getAiQuizActive() {
        return requireArguments().getBoolean(AI_QUIZ_ACTIVE, false);
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return C6014R.style.AutoSize_DialogNoTitle;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = LayoutInflater.from(requireActivity()).inflate(C6079R.layout.manage_pages_dialog, container);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        Toolbar toolbar = (Toolbar) viewInflate.findViewById(C6079R.id.manage_pages_dialog_fragment_toolbar);
        this.toolbar = toolbar;
        if (toolbar != null) {
            toolbar.addMenuProvider(this);
        }
        this.toolbarcontainer = (FrameLayout) viewInflate.findViewById(C6079R.id.manage_pages_dialog_fragment_toolbar_container);
        View viewFindViewById = viewInflate.findViewById(C6079R.id.manage_pages_dialog_compose);
        final ComposeView composeView = (ComposeView) viewFindViewById;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1418762328, true, new Function2() { // from class: com.myscript.nebo.editing.ManagePagesDialog$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ManagePagesDialog.onCreateView$lambda$0$0$0(composeView, this, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        this.composeView = viewFindViewById;
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(ComposeView composeView, final ManagePagesDialog managePagesDialog, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C165@7547L358,162@7275L630:ManagePagesDialog.kt#v1cuvs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1418762328, i, -1, "com.myscript.nebo.editing.ManagePagesDialog.onCreateView.<anonymous>.<anonymous>.<anonymous> (ManagePagesDialog.kt:162)");
            }
            Context context = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            long jColor = ColorKt.Color(ContextExtKt.resolveColorAttribute(context, C0028R.attr.colorPrimary));
            Context context2 = composeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            ThemeKt.m13016NeboDialogThemeeopBjH0(false, jColor, ColorKt.Color(ContextExtKt.resolveColorAttribute(context2, android.R.attr.colorBackgroundFloating)), ComposableLambdaKt.rememberComposableLambda(-493397865, true, new Function2() { // from class: com.myscript.nebo.editing.ManagePagesDialog$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ManagePagesDialog.onCreateView$lambda$0$0$0$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 3072, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0$0(ManagePagesDialog managePagesDialog, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C168@7671L30,169@7749L30,170@7830L27,166@7573L310:ManagePagesDialog.kt#v1cuvs");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-493397865, i, -1, "com.myscript.nebo.editing.ManagePagesDialog.onCreateView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ManagePagesDialog.kt:166)");
            }
            ChildPagesViewModel viewModel = managePagesDialog.getViewModel();
            ChildPagesViewModel viewModel2 = managePagesDialog.getViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -1708941707, "CC(remember):ManagePagesDialog.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(viewModel2);
            ManagePagesDialog$onCreateView$1$1$1$1$1$1 managePagesDialog$onCreateView$1$1$1$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || managePagesDialog$onCreateView$1$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                managePagesDialog$onCreateView$1$1$1$1$1$1RememberedValue = new ManagePagesDialog$onCreateView$1$1$1$1$1$1(viewModel2);
                composer.updateRememberedValue(managePagesDialog$onCreateView$1$1$1$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function1 = (Function1) ((KFunction) managePagesDialog$onCreateView$1$1$1$1$1$1RememberedValue);
            ChildPagesViewModel viewModel3 = managePagesDialog.getViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -1708939211, "CC(remember):ManagePagesDialog.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(viewModel3);
            ManagePagesDialog$onCreateView$1$1$1$1$2$1 managePagesDialog$onCreateView$1$1$1$1$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || managePagesDialog$onCreateView$1$1$1$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                managePagesDialog$onCreateView$1$1$1$1$2$1RememberedValue = new ManagePagesDialog$onCreateView$1$1$1$1$2$1(viewModel3);
                composer.updateRememberedValue(managePagesDialog$onCreateView$1$1$1$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function12 = (Function1) ((KFunction) managePagesDialog$onCreateView$1$1$1$1$2$1RememberedValue);
            ChildPagesViewModel viewModel4 = managePagesDialog.getViewModel();
            ComposerKt.sourceInformationMarkerStart(composer, -1708936622, "CC(remember):ManagePagesDialog.kt#9igjgp");
            boolean zChangedInstance3 = composer.changedInstance(viewModel4);
            ManagePagesDialog$onCreateView$1$1$1$1$3$1 managePagesDialog$onCreateView$1$1$1$1$3$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance3 || managePagesDialog$onCreateView$1$1$1$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                managePagesDialog$onCreateView$1$1$1$1$3$1RememberedValue = new ManagePagesDialog$onCreateView$1$1$1$1$3$1(viewModel4);
                composer.updateRememberedValue(managePagesDialog$onCreateView$1$1$1$1$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ManagePagesPaneKt.ManagePagesPane(viewModel, function1, function12, (Function1) ((KFunction) managePagesDialog$onCreateView$1$1$1$1$3$1RememberedValue), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.setTitle(getString(C6079R.string.manage_pages_select_pages));
        }
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 != null) {
            toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.editing.ManagePagesDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ManagePagesDialog.onViewCreated$lambda$0(this.f$0, view2);
                }
            });
        }
        getViewModel().isSelectionMode().observe(getViewLifecycleOwner(), new ManagePagesDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.ManagePagesDialog$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ManagePagesDialog.onViewCreated$lambda$1(this.f$0, (Boolean) obj);
            }
        }));
        getViewModel().getChildPages().observe(getViewLifecycleOwner(), new ManagePagesDialog$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.editing.ManagePagesDialog$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ManagePagesDialog.onViewCreated$lambda$2(this.f$0, (ImmutableList) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(ManagePagesDialog managePagesDialog, View view) {
        managePagesDialog.getAiContainerViewModel().setMode(AIMode.NONE);
        managePagesDialog.getAiQuizViewModel().closeQuiz();
        managePagesDialog.getAiSummarizeViewModel().closeSummarize();
        managePagesDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$1(ManagePagesDialog managePagesDialog, Boolean bool) {
        if (bool.booleanValue()) {
            managePagesDialog.selectionMode = SelectionMode.startSelectionMode(managePagesDialog.requireActivity(), managePagesDialog.toolbarcontainer, managePagesDialog.selectionModeCallback);
        } else {
            SelectionMode selectionMode = managePagesDialog.selectionMode;
            if (selectionMode != null) {
                selectionMode.finish();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(ManagePagesDialog managePagesDialog, ImmutableList immutableList) {
        SelectionMode selectionMode = managePagesDialog.selectionMode;
        if (selectionMode != null) {
            selectionMode.invalidate();
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(dialogOnCreateDialog);
        DialogUtilsKt.configureForEdgeToEdge(dialogOnCreateDialog);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "apply(...)");
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Toolbar toolbar = this.toolbar;
        if (toolbar != null) {
            toolbar.removeMenuProvider(this);
        }
        super.onDestroy();
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
        menuInflater.inflate(C6079R.menu.manage_pages_menu, menu);
    }

    @Override // androidx.core.view.MenuProvider
    public void onPrepareMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        super.onPrepareMenu(menu);
        MenuItem menuItemFindItem = menu.findItem(C6079R.id.manage_pages_select_all);
        if (menuItemFindItem != null) {
            menuItemFindItem.setVisible(getViewModel().getCanSelectAll());
        }
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        if (menuItem.getItemId() != C6079R.id.manage_pages_select_all) {
            return false;
        }
        getViewModel().toggleSelectionMode(true);
        getViewModel().selectAllPages();
        return true;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        getViewModel().toggleSelectionMode(false);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        getViewModel().toggleSelectionMode(false);
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        DialogFragmentExt.showAtMostOnce(this, manager, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDeleteConfirmationDialog(final Function0<Unit> onDeleteConfirm) {
        new MaterialAlertDialogBuilder(requireActivity()).setTitle((CharSequence) getResources().getQuantityString(C6079R.plurals.manage_pages_delete_confirm_title, getViewModel().getSelectedPagesCount(), Integer.valueOf(getViewModel().getSelectedPagesCount()))).setMessage((CharSequence) getResources().getQuantityString(C6079R.plurals.manage_pages_delete_confirm_message, getViewModel().getSelectedPagesCount(), Integer.valueOf(getViewModel().getSelectedPagesCount()))).setPositiveButton(C6079R.string.manage_pages_delete, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.editing.ManagePagesDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                onDeleteConfirm.invoke();
            }
        }).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: compiled from: ManagePagesDialog.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/editing/ManagePagesDialog$Companion;", "", "<init>", "()V", "TAG", "", "AI_SUMMARIZATION_ACTIVE", "AI_QUIZ_ACTIVE", "newInstance", "Lcom/myscript/nebo/editing/ManagePagesDialog;", "aiSummarizationActive", "", "aiQuizActive", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ManagePagesDialog newInstance$default(Companion companion, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = false;
            }
            return companion.newInstance(z, z2);
        }

        public final ManagePagesDialog newInstance(boolean aiSummarizationActive, boolean aiQuizActive) {
            ManagePagesDialog managePagesDialog = new ManagePagesDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ManagePagesDialog.AI_SUMMARIZATION_ACTIVE, aiSummarizationActive);
            bundle.putBoolean(ManagePagesDialog.AI_QUIZ_ACTIVE, aiQuizActive);
            managePagesDialog.setArguments(bundle);
            return managePagesDialog;
        }
    }
}
