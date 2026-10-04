package com.myscript.nebo.backup.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConfirmSyncDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002¨\u0006\u000e"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/ConfirmSyncDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onSyncAndBackup", "", "onBackupOnly", "onCancel", "ConfirmSyncDialogResult", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ConfirmSyncDialogFragment extends DialogFragment {
    private static final String CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_BACKUP = "CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_BACKUP";
    private static final String CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_SYNC = "CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_SYNC";
    private static final String CONFIRM_SYNC_DIALOG_FRAGMENT_MESSAGE = "CONFIRM_SYNC_DIALOG_FRAGMENT_MESSAGE";
    private static final String CONFIRM_SYNC_DIALOG_FRAGMENT_TITLE = "CONFIRM_SYNC_DIALOG_FRAGMENT_TITLE";
    public static final String RESULT_CODE = "RESULT_CODE";
    public static final String TAG = "ConfirmSyncDialogFragment";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ConfirmSyncDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/ConfirmSyncDialogFragment$ConfirmSyncDialogResult;", "", "<init>", "(Ljava/lang/String;I)V", "ButtonSync", "ButtonBackup", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ConfirmSyncDialogResult {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ConfirmSyncDialogResult[] $VALUES;
        public static final ConfirmSyncDialogResult ButtonSync = new ConfirmSyncDialogResult("ButtonSync", 0);
        public static final ConfirmSyncDialogResult ButtonBackup = new ConfirmSyncDialogResult("ButtonBackup", 1);

        private static final /* synthetic */ ConfirmSyncDialogResult[] $values() {
            return new ConfirmSyncDialogResult[]{ButtonSync, ButtonBackup};
        }

        public static EnumEntries<ConfirmSyncDialogResult> getEntries() {
            return $ENTRIES;
        }

        public static ConfirmSyncDialogResult valueOf(String str) {
            return (ConfirmSyncDialogResult) Enum.valueOf(ConfirmSyncDialogResult.class, str);
        }

        public static ConfirmSyncDialogResult[] values() {
            return (ConfirmSyncDialogResult[]) $VALUES.clone();
        }

        private ConfirmSyncDialogResult(String str, int i) {
        }

        static {
            ConfirmSyncDialogResult[] confirmSyncDialogResultArr$values = $values();
            $VALUES = confirmSyncDialogResultArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(confirmSyncDialogResultArr$values);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(contextRequireContext);
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        String string = bundleRequireArguments.getString(CONFIRM_SYNC_DIALOG_FRAGMENT_TITLE);
        if (string == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        materialAlertDialogBuilder.setTitle((CharSequence) string);
        String string2 = bundleRequireArguments.getString(CONFIRM_SYNC_DIALOG_FRAGMENT_MESSAGE);
        if (string2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        materialAlertDialogBuilder.setMessage((CharSequence) string2);
        String string3 = bundleRequireArguments.getString(CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_SYNC);
        if (string3 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        String string4 = bundleRequireArguments.getString(CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_BACKUP);
        if (string4 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        materialAlertDialogBuilder.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.myscript.nebo.backup.dialog.ConfirmSyncDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return ConfirmSyncDialogFragment.onCreateDialog$lambda$0$0(this.f$0, dialogInterface, i, keyEvent);
            }
        });
        materialAlertDialogBuilder.setPositiveButton((CharSequence) string3, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.backup.dialog.ConfirmSyncDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.onSyncAndBackup();
            }
        });
        materialAlertDialogBuilder.setNegativeButton((CharSequence) string4, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.backup.dialog.ConfirmSyncDialogFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.onBackupOnly();
            }
        });
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$0$0(ConfirmSyncDialogFragment confirmSyncDialogFragment, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (!confirmSyncDialogFragment.isAdded() || i != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        confirmSyncDialogFragment.onCancel();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSyncAndBackup() {
        dismiss();
        Bundle bundle = new Bundle();
        bundle.putInt("RESULT_CODE", ConfirmSyncDialogResult.ButtonSync.ordinal());
        Intent intentPutExtras = new Intent().putExtras(bundle);
        Intrinsics.checkNotNullExpressionValue(intentPutExtras, "putExtras(...)");
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(getTargetRequestCode(), -1, intentPutExtras);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackupOnly() {
        dismiss();
        Bundle bundle = new Bundle();
        bundle.putInt("RESULT_CODE", ConfirmSyncDialogResult.ButtonBackup.ordinal());
        Intent intentPutExtras = new Intent().putExtras(bundle);
        Intrinsics.checkNotNullExpressionValue(intentPutExtras, "putExtras(...)");
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(getTargetRequestCode(), -1, intentPutExtras);
        }
    }

    private final void onCancel() {
        dismiss();
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(getTargetRequestCode(), 0, null);
        }
    }

    /* JADX INFO: compiled from: ConfirmSyncDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/ConfirmSyncDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "RESULT_CODE", ConfirmSyncDialogFragment.CONFIRM_SYNC_DIALOG_FRAGMENT_TITLE, ConfirmSyncDialogFragment.CONFIRM_SYNC_DIALOG_FRAGMENT_MESSAGE, ConfirmSyncDialogFragment.CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_SYNC, ConfirmSyncDialogFragment.CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_BACKUP, "newInstance", "Lcom/myscript/nebo/backup/dialog/ConfirmSyncDialogFragment;", "title", "message", "syncButton", "backupButton", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConfirmSyncDialogFragment newInstance(String title, String message, String syncButton, String backupButton) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(syncButton, "syncButton");
            Intrinsics.checkNotNullParameter(backupButton, "backupButton");
            ConfirmSyncDialogFragment confirmSyncDialogFragment = new ConfirmSyncDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ConfirmSyncDialogFragment.CONFIRM_SYNC_DIALOG_FRAGMENT_TITLE, title);
            bundle.putString(ConfirmSyncDialogFragment.CONFIRM_SYNC_DIALOG_FRAGMENT_MESSAGE, message);
            bundle.putString(ConfirmSyncDialogFragment.CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_SYNC, syncButton);
            bundle.putString(ConfirmSyncDialogFragment.CONFIRM_SYNC_DIALOG_FRAGMENT_BUTTON_BACKUP, backupButton);
            confirmSyncDialogFragment.setArguments(bundle);
            return confirmSyncDialogFragment;
        }
    }
}
