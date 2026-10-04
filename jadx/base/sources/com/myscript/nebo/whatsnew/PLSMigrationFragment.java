package com.myscript.nebo.whatsnew;

import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.CommonUtils;
import com.myscript.nebo.databinding.PlsMigrationActivityBinding;
import com.myscript.nebo.log.TechnicalLogger;
import com.myscript.nebo.log.TechnicalLoggerExt;
import com.myscript.nebo.log.TechnicalLoggerProvider;
import com.myscript.nebo.storage.StorageState;
import com.myscript.nebo.whatsnew.PLSMigrationScreenState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PLSMigrationFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/PLSMigrationFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "logger", "Lcom/myscript/nebo/log/TechnicalLogger;", "getLogger", "()Lcom/myscript/nebo/log/TechnicalLogger;", "logger$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/myscript/nebo/whatsnew/PLSMigrationViewModel;", "getViewModel", "()Lcom/myscript/nebo/whatsnew/PLSMigrationViewModel;", "viewModel$delegate", "binding", "Lcom/myscript/nebo/databinding/PlsMigrationActivityBinding;", "lowStorageAlertDialog", "Landroid/content/DialogInterface;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onResume", "onStop", "onStateUpdate", "state", "Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState;", "showLowDiskSpaceAlertDialogIfNeeded", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PLSMigrationFragment extends Fragment {
    public static final String PLS_MIGRATION_DONE_KEY = "PLS_MIGRATION_DONE_KEY";
    public static final String PLS_MIGRATION_KEY = "PLS_MIGRATION_KEY";
    private static final String TAG = "PLSMigrationActivity";
    private PlsMigrationActivityBinding binding;

    /* JADX INFO: renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger = LazyKt.lazy(new Function0() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return PLSMigrationFragment.logger_delegate$lambda$0(this.f$0);
        }
    });
    private DialogInterface lowStorageAlertDialog;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final int $stable = 8;

    public PLSMigrationFragment() {
        final PLSMigrationFragment pLSMigrationFragment = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PLSMigrationFragment.viewModel_delegate$lambda$0();
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return pLSMigrationFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function02.invoke();
            }
        });
        final Function0 function03 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(pLSMigrationFragment, Reflection.getOrCreateKotlinClass(PLSMigrationViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function03;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM11616viewModels$lambda1 = FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM11616viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM11616viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, function0);
    }

    private final TechnicalLogger getLogger() {
        return (TechnicalLogger) this.logger.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TechnicalLogger logger_delegate$lambda$0(PLSMigrationFragment pLSMigrationFragment) {
        ComponentCallbacks2 application = pLSMigrationFragment.requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.myscript.nebo.log.TechnicalLoggerProvider");
        return ((TechnicalLoggerProvider) application).provideTechnicalLogger();
    }

    private final PLSMigrationViewModel getViewModel() {
        return (PLSMigrationViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0() {
        return PLSMigrationViewModel.INSTANCE.getFactory();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreate(savedInstanceState);
        PlsMigrationActivityBinding plsMigrationActivityBindingInflate = PlsMigrationActivityBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(plsMigrationActivityBindingInflate, "inflate(...)");
        this.binding = plsMigrationActivityBindingInflate;
        getViewModel().getState().observe(getViewLifecycleOwner(), new PLSMigrationFragment$sam$androidx_lifecycle_Observer$0(new C69051(this)));
        getViewModel().getStorageState().observe(getViewLifecycleOwner(), new PLSMigrationFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PLSMigrationFragment.onCreateView$lambda$0(this.f$0, (StorageState) obj);
            }
        }));
        PlsMigrationActivityBinding plsMigrationActivityBinding = this.binding;
        if (plsMigrationActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            plsMigrationActivityBinding = null;
        }
        ConstraintLayout root = plsMigrationActivityBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.whatsnew.PLSMigrationFragment$onCreateView$1 */
    /* JADX INFO: compiled from: PLSMigrationFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C69051 extends FunctionReferenceImpl implements Function1<PLSMigrationScreenState, Unit> {
        C69051(Object obj) {
            super(1, obj, PLSMigrationFragment.class, "onStateUpdate", "onStateUpdate(Lcom/myscript/nebo/whatsnew/PLSMigrationScreenState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PLSMigrationScreenState pLSMigrationScreenState) {
            invoke2(pLSMigrationScreenState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PLSMigrationScreenState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((PLSMigrationFragment) this.receiver).onStateUpdate(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0(PLSMigrationFragment pLSMigrationFragment, StorageState storageState) {
        pLSMigrationFragment.showLowDiskSpaceAlertDialogIfNeeded();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        PlsMigrationActivityBinding plsMigrationActivityBinding = this.binding;
        if (plsMigrationActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            plsMigrationActivityBinding = null;
        }
        plsMigrationActivityBinding.plsMigrationCta.setOnClickListener(new View.OnClickListener() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PLSMigrationFragment.onStart$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(PLSMigrationFragment pLSMigrationFragment, View view) {
        PLSMigrationScreenState value = pLSMigrationFragment.getViewModel().getState().getValue();
        if ((value instanceof PLSMigrationScreenState.EndWithoutSync) || (value instanceof PLSMigrationScreenState.EndWithSync)) {
            TechnicalLoggerExt.logAction$default(pLSMigrationFragment.getLogger(), TAG, "Leave PLS migration screen", null, 4, null);
            FragmentKt.setFragmentResult(pLSMigrationFragment, PLS_MIGRATION_KEY, BundleKt.bundleOf(TuplesKt.m1606to(PLS_MIGRATION_DONE_KEY, true)));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Force storage state update onResume", null, 4, null);
        getViewModel().forceRefreshAvailableDiskSpace();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        PlsMigrationActivityBinding plsMigrationActivityBinding = this.binding;
        if (plsMigrationActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            plsMigrationActivityBinding = null;
        }
        plsMigrationActivityBinding.plsMigrationCta.setOnClickListener(null);
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onStateUpdate(PLSMigrationScreenState state) {
        PlsMigrationActivityBinding plsMigrationActivityBinding = this.binding;
        if (plsMigrationActivityBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            plsMigrationActivityBinding = null;
        }
        plsMigrationActivityBinding.plsMigrationIllustration.setImageResource(state.getIllustrationRes());
        ImageView plsMigrationIllustration = plsMigrationActivityBinding.plsMigrationIllustration;
        Intrinsics.checkNotNullExpressionValue(plsMigrationIllustration, "plsMigrationIllustration");
        plsMigrationIllustration.setVisibility(getResources().getBoolean(C6079R.bool.pls_migration_show_illustration) ? 0 : 8);
        plsMigrationActivityBinding.plsMigrationTitle.setText(state.getTitleRes());
        plsMigrationActivityBinding.plsMigrationText.setText(state.getTextRes());
        if (state instanceof PLSMigrationScreenState.Preparing) {
            TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Migration preparing", null, 4, null);
            ContentLoadingProgressBar plsMigrationProgress = plsMigrationActivityBinding.plsMigrationProgress;
            Intrinsics.checkNotNullExpressionValue(plsMigrationProgress, "plsMigrationProgress");
            plsMigrationProgress.setVisibility(0);
            plsMigrationActivityBinding.plsMigrationProgress.setProgress(0);
            MaterialButton plsMigrationCta = plsMigrationActivityBinding.plsMigrationCta;
            Intrinsics.checkNotNullExpressionValue(plsMigrationCta, "plsMigrationCta");
            plsMigrationCta.setVisibility(8);
        } else if (state instanceof PLSMigrationScreenState.Migrating) {
            PLSMigrationScreenState.Migrating migrating = (PLSMigrationScreenState.Migrating) state;
            if (migrating.getMigrationProgress() == 0 || migrating.getMigrationProgress() == migrating.getMigrationTotal()) {
                TechnicalLoggerExt.logAction(getLogger(), TAG, "Migration update", new PLSMigrationFragment$onStateUpdate$1$1(state));
            }
            ContentLoadingProgressBar plsMigrationProgress2 = plsMigrationActivityBinding.plsMigrationProgress;
            Intrinsics.checkNotNullExpressionValue(plsMigrationProgress2, "plsMigrationProgress");
            plsMigrationProgress2.setVisibility(0);
            ContentLoadingProgressBar plsMigrationProgress3 = plsMigrationActivityBinding.plsMigrationProgress;
            Intrinsics.checkNotNullExpressionValue(plsMigrationProgress3, "plsMigrationProgress");
            ViewExt.animateProgress(plsMigrationProgress3, migrating.getMigrationProgress());
            plsMigrationActivityBinding.plsMigrationProgress.setMax(migrating.getMigrationTotal());
            MaterialButton plsMigrationCta2 = plsMigrationActivityBinding.plsMigrationCta;
            Intrinsics.checkNotNullExpressionValue(plsMigrationCta2, "plsMigrationCta");
            plsMigrationCta2.setVisibility(8);
            plsMigrationActivityBinding.plsMigrationCta.setText((CharSequence) null);
        } else {
            if (!(state instanceof PLSMigrationScreenState.EndWithSync) && !(state instanceof PLSMigrationScreenState.EndWithoutSync)) {
                throw new NoWhenBranchMatchedException();
            }
            TechnicalLoggerExt.logAction$default(getLogger(), TAG, "Migration done", null, 4, null);
            ContentLoadingProgressBar plsMigrationProgress4 = plsMigrationActivityBinding.plsMigrationProgress;
            Intrinsics.checkNotNullExpressionValue(plsMigrationProgress4, "plsMigrationProgress");
            plsMigrationProgress4.setVisibility(8);
            MaterialButton plsMigrationCta3 = plsMigrationActivityBinding.plsMigrationCta;
            Intrinsics.checkNotNullExpressionValue(plsMigrationCta3, "plsMigrationCta");
            plsMigrationCta3.setVisibility(0);
            plsMigrationActivityBinding.plsMigrationCta.setText(state.getCtaLabelRes());
        }
        showLowDiskSpaceAlertDialogIfNeeded();
    }

    private final void showLowDiskSpaceAlertDialogIfNeeded() {
        PLSMigrationScreenState value = getViewModel().getState().getValue();
        if ((value instanceof PLSMigrationScreenState.Migrating) && !((PLSMigrationScreenState.Migrating) value).isOngoing()) {
            if (this.lowStorageAlertDialog == null) {
                final MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(requireActivity());
                materialAlertDialogBuilder.setTitle(C6079R.string.pls_migration_low_storage_title);
                materialAlertDialogBuilder.setMessage((CharSequence) getString(C6079R.string.pls_migration_low_storage_message, CommonUtils.getHumanReadableByteCount(getViewModel().getRequiredSpace(), true)));
                materialAlertDialogBuilder.setPositiveButton(C6079R.string.pls_migration_low_storage_settings_cta, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        PLSMigrationFragment.showLowDiskSpaceAlertDialogIfNeeded$lambda$0$0(this.f$0, dialogInterface, i);
                    }
                });
                materialAlertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.myscript.nebo.whatsnew.PLSMigrationFragment$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        PLSMigrationFragment.showLowDiskSpaceAlertDialogIfNeeded$lambda$0$2(materialAlertDialogBuilder, this, dialogInterface);
                    }
                });
                materialAlertDialogBuilder.setCancelable(false);
                AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
                this.lowStorageAlertDialog = alertDialogCreate;
                alertDialogCreate.setCancelable(false);
                alertDialogCreate.setCanceledOnTouchOutside(false);
                alertDialogCreate.show();
                return;
            }
            return;
        }
        DialogInterface dialogInterface = this.lowStorageAlertDialog;
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.lowStorageAlertDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLowDiskSpaceAlertDialogIfNeeded$lambda$0$0(PLSMigrationFragment pLSMigrationFragment, DialogInterface dialogInterface, int i) {
        TechnicalLoggerExt.logAction$default(pLSMigrationFragment.getLogger(), TAG, "Low storage dialog settings", null, 4, null);
        pLSMigrationFragment.startActivity(new Intent("android.os.storage.action.MANAGE_STORAGE"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLowDiskSpaceAlertDialogIfNeeded$lambda$0$1(PLSMigrationFragment pLSMigrationFragment, DialogInterface dialogInterface, int i) {
        TechnicalLoggerExt.logAction$default(pLSMigrationFragment.getLogger(), TAG, "Low storage dialog acknowledge", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLowDiskSpaceAlertDialogIfNeeded$lambda$0$2(MaterialAlertDialogBuilder materialAlertDialogBuilder, PLSMigrationFragment pLSMigrationFragment, DialogInterface dialogInterface) {
        materialAlertDialogBuilder.setOnDismissListener((DialogInterface.OnDismissListener) null);
        pLSMigrationFragment.lowStorageAlertDialog = null;
    }
}
