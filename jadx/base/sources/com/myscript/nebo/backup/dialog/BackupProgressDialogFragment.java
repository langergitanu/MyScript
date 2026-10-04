package com.myscript.nebo.backup.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.myscript.nebo.backup.BackupRestoreViewModel;
import com.myscript.nebo.backup.BackupState;
import com.myscript.nebo.backup.dialog.ProgressDialogFragment;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: BackupProgressDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0011\u001a\u00020\u000fH\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/BackupProgressDialogFragment;", "Lcom/myscript/nebo/backup/dialog/ProgressDialogFragment;", "<init>", "()V", "viewModel", "Lcom/myscript/nebo/backup/BackupRestoreViewModel;", "getViewModel", "()Lcom/myscript/nebo/backup/BackupRestoreViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onBack", "onCancel", "updateUI", "state", "Lcom/myscript/nebo/backup/BackupState;", "backupProgress", "current", "", "total", "backupFinished", "backupFile", "Ljava/io/File;", "backupCanceled", "backupError", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BackupProgressDialogFragment extends ProgressDialogFragment {
    public static final String BACKUP_PATH = "BACKUP_PATH";
    public static final String TAG = "BackupProgressDialogFragment";

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public BackupProgressDialogFragment() {
        final BackupProgressDialogFragment backupProgressDialogFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(backupProgressDialogFragment, Reflection.getOrCreateKotlinClass(BackupRestoreViewModel.class), new Function0<ViewModelStore>() { // from class: com.myscript.nebo.backup.dialog.BackupProgressDialogFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return backupProgressDialogFragment.requireActivity().getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.myscript.nebo.backup.dialog.BackupProgressDialogFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? backupProgressDialogFragment.requireActivity().getDefaultViewModelCreationExtras() : creationExtras;
            }
        }, new Function0() { // from class: com.myscript.nebo.backup.dialog.BackupProgressDialogFragment$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BackupProgressDialogFragment.viewModel_delegate$lambda$0();
            }
        });
    }

    private final BackupRestoreViewModel getViewModel() {
        return (BackupRestoreViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewModelProvider.Factory viewModel_delegate$lambda$0() {
        return BackupRestoreViewModel.INSTANCE.getFactory();
    }

    @Override // com.myscript.nebo.backup.dialog.ProgressDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        getViewModel().getBackupState().observe(this, new Observer() { // from class: com.myscript.nebo.backup.dialog.BackupProgressDialogFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BackupProgressDialogFragment.onCreateDialog$lambda$0(this.f$0, (BackupState) obj);
            }
        });
        return super.onCreateDialog(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(BackupProgressDialogFragment backupProgressDialogFragment, BackupState backupState) {
        Intrinsics.checkNotNull(backupState);
        backupProgressDialogFragment.updateUI(backupState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BackupState value = getViewModel().getBackupState().getValue();
        if (value != null) {
            updateUI(value);
        }
    }

    @Override // com.myscript.nebo.backup.dialog.ProgressDialogFragment
    protected void onBack() {
        backupCanceled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.myscript.nebo.backup.dialog.ProgressDialogFragment
    public void onCancel() {
        backupCanceled();
    }

    private final void updateUI(BackupState state) {
        if (state instanceof BackupState.Progress) {
            BackupState.Progress progress = (BackupState.Progress) state;
            backupProgress(progress.getCurrent(), progress.getTotal());
            return;
        }
        if (state instanceof BackupState.Done) {
            backupFinished(((BackupState.Done) state).getBackupFile());
            return;
        }
        if (Intrinsics.areEqual(state, BackupState.Canceled.INSTANCE)) {
            backupCanceled();
        } else if (state instanceof BackupState.BackupError) {
            backupError();
        } else if (!Intrinsics.areEqual(state, BackupState.Idle.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void backupProgress(int current, int total) {
        ProgressDialog progressDialog = getProgressDialog();
        if (progressDialog != null) {
            progressDialog.setIndeterminate(false);
        }
        ProgressDialog progressDialog2 = getProgressDialog();
        if (progressDialog2 != null) {
            progressDialog2.setProgressNumberFormat(null);
        }
        ProgressDialog progressDialog3 = getProgressDialog();
        if (progressDialog3 != null) {
            progressDialog3.setProgressPercentFormat(null);
        }
        ProgressDialog progressDialog4 = getProgressDialog();
        if (progressDialog4 != null) {
            progressDialog4.setMax(total);
        }
        ProgressDialog progressDialog5 = getProgressDialog();
        if (progressDialog5 != null) {
            progressDialog5.setProgress(current);
        }
    }

    private final void backupFinished(File backupFile) {
        if (isAdded()) {
            Fragment targetFragment = getTargetFragment();
            if ((targetFragment != null ? targetFragment.getContext() : null) != null) {
                dismiss();
                Bundle bundle = new Bundle();
                bundle.putString("BACKUP_PATH", backupFile.getAbsolutePath());
                Intent intentPutExtras = new Intent().putExtras(bundle);
                Intrinsics.checkNotNullExpressionValue(intentPutExtras, "putExtras(...)");
                Fragment targetFragment2 = getTargetFragment();
                if (targetFragment2 != null) {
                    targetFragment2.onActivityResult(getTargetRequestCode(), -1, intentPutExtras);
                }
            }
        }
    }

    private final void backupCanceled() {
        if (isAdded()) {
            dismiss();
            Bundle bundle = new Bundle();
            bundle.putInt("RESULT_CODE", ProgressDialogFragment.ProgressDialogResult.Canceled.ordinal());
            Intent intentPutExtras = new Intent().putExtras(bundle);
            Intrinsics.checkNotNullExpressionValue(intentPutExtras, "putExtras(...)");
            Fragment targetFragment = getTargetFragment();
            if (targetFragment != null) {
                targetFragment.onActivityResult(getTargetRequestCode(), 0, intentPutExtras);
            }
        }
    }

    private final void backupError() {
        if (isAdded()) {
            dismiss();
            Bundle bundle = new Bundle();
            bundle.putInt("RESULT_CODE", ProgressDialogFragment.ProgressDialogResult.Error.ordinal());
            Intent intentPutExtras = new Intent().putExtras(bundle);
            Intrinsics.checkNotNullExpressionValue(intentPutExtras, "putExtras(...)");
            Fragment targetFragment = getTargetFragment();
            if (targetFragment != null) {
                targetFragment.onActivityResult(getTargetRequestCode(), 0, intentPutExtras);
            }
        }
    }

    /* JADX INFO: compiled from: BackupProgressDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/BackupProgressDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "BACKUP_PATH", "newInstance", "Lcom/myscript/nebo/backup/dialog/BackupProgressDialogFragment;", "title", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BackupProgressDialogFragment newInstance(String title) {
            Intrinsics.checkNotNullParameter(title, "title");
            BackupProgressDialogFragment backupProgressDialogFragment = new BackupProgressDialogFragment();
            ProgressDialogFragment.setupArguments$default(backupProgressDialogFragment, title, null, false, false, 12, null);
            return backupProgressDialogFragment;
        }
    }
}
