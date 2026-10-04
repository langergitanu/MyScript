package com.myscript.nebo.grid;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.android.utils.ViewExt;
import com.myscript.nebo.C6079R;
import com.myscript.snt.core.PageKey;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: DownloadLanguageDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, m1599d2 = {"Lcom/myscript/nebo/grid/DownloadLanguageDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "pageKey", "Lcom/myscript/snt/core/PageKey;", "progressBar", "Landroid/widget/ProgressBar;", "message", "Landroid/widget/TextView;", "downloadSuccess", "", "downloadLanguageViewModel", "Lcom/myscript/nebo/grid/DownloadLanguageViewModel;", "getDownloadLanguageViewModel", "()Lcom/myscript/nebo/grid/DownloadLanguageViewModel;", "downloadLanguageViewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "updateUI", "state", "Lcom/myscript/nebo/grid/LanguageDownloadUIState;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DownloadLanguageDialogFragment extends DialogFragment {
    private static final String ARGUMENTS_LANGUAGE_TAG = "ARGUMENTS_LANGUAGE_TAG";
    private static final String ARGUMENTS_NOTE_KEY = "ARGUMENTS_NOTE_KEY";
    public static final String NOTEKEY_RESULT_KEY = "NOTEKEY_RESULT_KEY";
    public static final String REQUEST_KEY = "DownloadLanguageDialogFragment_REQUEST_KEY";
    public static final String SUCCESS_RESULT_KEY = "SUCCESS_RESULT_KEY";
    private static final String TAG = "DownloadLanguageDialogFragment";

    /* JADX INFO: renamed from: downloadLanguageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy downloadLanguageViewModel;
    private boolean downloadSuccess;
    private TextView message;
    private PageKey pageKey;
    private ProgressBar progressBar;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: DownloadLanguageDialogFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Status.values().length];
            try {
                iArr[Status.Downloading.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Status.Downloaded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Status.Failed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final DownloadLanguageDialogFragment newInstance(PageKey pageKey, String str) {
        return INSTANCE.newInstance(pageKey, str);
    }

    public DownloadLanguageDialogFragment() {
        final DownloadLanguageDialogFragment downloadLanguageDialogFragment = this;
        Function0 function0 = new Function0() { // from class: com.myscript.nebo.grid.DownloadLanguageDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DownloadLanguageDialogFragment.downloadLanguageViewModel_delegate$lambda$0(this.f$0);
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.myscript.nebo.grid.DownloadLanguageDialogFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return downloadLanguageDialogFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.myscript.nebo.grid.DownloadLanguageDialogFragment$special$$inlined$viewModels$default$2
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
        this.downloadLanguageViewModel = FragmentViewModelLazyKt.createViewModelLazy(downloadLanguageDialogFragment, Reflection.getOrCreateKotlinClass(DownloadLanguageViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.grid.DownloadLanguageDialogFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m11616viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.grid.DownloadLanguageDialogFragment$special$$inlined$viewModels$default$4
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

    private final DownloadLanguageViewModel getDownloadLanguageViewModel() {
        return (DownloadLanguageViewModel) this.downloadLanguageViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory downloadLanguageViewModel_delegate$lambda$0(DownloadLanguageDialogFragment downloadLanguageDialogFragment) {
        String string = downloadLanguageDialogFragment.requireArguments().getString(ARGUMENTS_LANGUAGE_TAG);
        if (string == null) {
            throw new IllegalStateException("Missing language argument".toString());
        }
        return DownloadLanguageViewModel.INSTANCE.Factory(string);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String string;
        PageKey pageKeyDeserialize;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARGUMENTS_NOTE_KEY)) == null || (pageKeyDeserialize = PageKey.deserialize(string)) == null) {
            throw new IllegalStateException("Missing note key argument".toString());
        }
        this.pageKey = pageKeyDeserialize;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        View viewInflate = LayoutInflater.from(contextRequireContext).inflate(C6079R.layout.download_missing_language_dialog, (ViewGroup) null);
        MaterialAlertDialogBuilder cancelable = new MaterialAlertDialogBuilder(contextRequireContext).setView(viewInflate).setTitle(C6079R.string.download_language_dialog_title).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.grid.DownloadLanguageDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.dismiss();
            }
        }).setCancelable(false);
        Intrinsics.checkNotNullExpressionValue(cancelable, "setCancelable(...)");
        this.progressBar = (ProgressBar) viewInflate.findViewById(C6079R.id.download_missing_language_progress);
        this.message = (TextView) viewInflate.findViewById(C6079R.id.download_missing_language_message);
        getDownloadLanguageViewModel().getDownloadUIState().observe(this, new DownloadLanguageDialogFragment$sam$androidx_lifecycle_Observer$0(new C64721(this)));
        AlertDialog alertDialogCreate = cancelable.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.grid.DownloadLanguageDialogFragment$onCreateDialog$1 */
    /* JADX INFO: compiled from: DownloadLanguageDialogFragment.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C64721 extends FunctionReferenceImpl implements Function1<LanguageDownloadUIState, Unit> {
        C64721(Object obj) {
            super(1, obj, DownloadLanguageDialogFragment.class, "updateUI", "updateUI(Lcom/myscript/nebo/grid/LanguageDownloadUIState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LanguageDownloadUIState languageDownloadUIState) {
            invoke2(languageDownloadUIState);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LanguageDownloadUIState p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((DownloadLanguageDialogFragment) this.receiver).updateUI(p0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI(LanguageDownloadUIState state) {
        int i = WhenMappings.$EnumSwitchMapping$0[state.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.downloadSuccess = true;
                dismiss();
                return;
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                TextView textView = this.message;
                if (textView != null) {
                    textView.setText(getString(C6079R.string.downloading_language_failed));
                    return;
                }
                return;
            }
        }
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setMax(state.getMax());
        }
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            ViewExt.animateProgress(progressBar2, state.getProgress());
        }
        TextView textView2 = this.message;
        if (textView2 != null) {
            textView2.setText(getString(C6079R.string.downloading_language, state.getLanguageDisplayName()));
        }
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        DialogFragmentExt.showAtMostOnce(this, manager, TAG);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        DownloadLanguageDialogFragment downloadLanguageDialogFragment = this;
        Bundle bundle = new Bundle();
        bundle.putBoolean(SUCCESS_RESULT_KEY, this.downloadSuccess);
        PageKey pageKey = this.pageKey;
        if (pageKey == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageKey");
            pageKey = null;
        }
        bundle.putString(NOTEKEY_RESULT_KEY, pageKey.serialize());
        Unit unit = Unit.INSTANCE;
        FragmentKt.setFragmentResult(downloadLanguageDialogFragment, REQUEST_KEY, bundle);
        super.onDismiss(dialog);
    }

    /* JADX INFO: compiled from: DownloadLanguageDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/grid/DownloadLanguageDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_KEY", DownloadLanguageDialogFragment.SUCCESS_RESULT_KEY, DownloadLanguageDialogFragment.NOTEKEY_RESULT_KEY, DownloadLanguageDialogFragment.ARGUMENTS_NOTE_KEY, DownloadLanguageDialogFragment.ARGUMENTS_LANGUAGE_TAG, "newInstance", "Lcom/myscript/nebo/grid/DownloadLanguageDialogFragment;", SubscriberAttributeKt.JSON_NAME_KEY, "Lcom/myscript/snt/core/PageKey;", "languageTag", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DownloadLanguageDialogFragment newInstance(PageKey key, String languageTag) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(languageTag, "languageTag");
            DownloadLanguageDialogFragment downloadLanguageDialogFragment = new DownloadLanguageDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable(DownloadLanguageDialogFragment.ARGUMENTS_NOTE_KEY, key.serialize());
            bundle.putString(DownloadLanguageDialogFragment.ARGUMENTS_LANGUAGE_TAG, languageTag);
            downloadLanguageDialogFragment.setArguments(bundle);
            return downloadLanguageDialogFragment;
        }
    }
}
