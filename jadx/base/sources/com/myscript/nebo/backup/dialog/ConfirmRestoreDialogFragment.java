package com.myscript.nebo.backup.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConfirmRestoreDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/ConfirmRestoreDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCancel", "", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ConfirmRestoreDialogFragment extends DialogFragment {
    private static final String CONFIRM_RESTORE_DIALOG_FRAGMENT_MESSAGE = "CONFIRM_RESTORE_DIALOG_FRAGMENT_MESSAGE";
    private static final String CONFIRM_RESTORE_DIALOG_FRAGMENT_TITLE = "CONFIRM_RESTORE_DIALOG_FRAGMENT_TITLE";
    public static final String TAG = "ConfirmRestoreDialogFragment";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(contextRequireContext);
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        String string = bundleRequireArguments.getString(CONFIRM_RESTORE_DIALOG_FRAGMENT_TITLE);
        if (string == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        materialAlertDialogBuilder.setTitle((CharSequence) string);
        String string2 = bundleRequireArguments.getString(CONFIRM_RESTORE_DIALOG_FRAGMENT_MESSAGE);
        if (string2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        materialAlertDialogBuilder.setMessage((CharSequence) string2);
        materialAlertDialogBuilder.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.myscript.nebo.backup.dialog.ConfirmRestoreDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return ConfirmRestoreDialogFragment.onCreateDialog$lambda$0$0(this.f$0, dialogInterface, i, keyEvent);
            }
        });
        materialAlertDialogBuilder.setPositiveButton(C6183R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.backup.dialog.ConfirmRestoreDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ConfirmRestoreDialogFragment.onCreateDialog$lambda$0$1(this.f$0, dialogInterface, i);
            }
        });
        materialAlertDialogBuilder.setNegativeButton(C6183R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.backup.dialog.ConfirmRestoreDialogFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.onCancel();
            }
        });
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$0$0(ConfirmRestoreDialogFragment confirmRestoreDialogFragment, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (!confirmRestoreDialogFragment.isAdded() || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        confirmRestoreDialogFragment.onCancel();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$1(ConfirmRestoreDialogFragment confirmRestoreDialogFragment, DialogInterface dialogInterface, int i) {
        confirmRestoreDialogFragment.dismiss();
        Fragment targetFragment = confirmRestoreDialogFragment.getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(confirmRestoreDialogFragment.getTargetRequestCode(), -1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCancel() {
        dismiss();
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(getTargetRequestCode(), 0, null);
        }
    }

    /* JADX INFO: compiled from: ConfirmRestoreDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/ConfirmRestoreDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", ConfirmRestoreDialogFragment.CONFIRM_RESTORE_DIALOG_FRAGMENT_TITLE, ConfirmRestoreDialogFragment.CONFIRM_RESTORE_DIALOG_FRAGMENT_MESSAGE, "newInstance", "Lcom/myscript/nebo/backup/dialog/ConfirmRestoreDialogFragment;", "title", "message", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConfirmRestoreDialogFragment newInstance(String title, String message) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            ConfirmRestoreDialogFragment confirmRestoreDialogFragment = new ConfirmRestoreDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ConfirmRestoreDialogFragment.CONFIRM_RESTORE_DIALOG_FRAGMENT_TITLE, title);
            bundle.putString(ConfirmRestoreDialogFragment.CONFIRM_RESTORE_DIALOG_FRAGMENT_MESSAGE, message);
            confirmRestoreDialogFragment.setArguments(bundle);
            return confirmRestoreDialogFragment;
        }
    }
}
