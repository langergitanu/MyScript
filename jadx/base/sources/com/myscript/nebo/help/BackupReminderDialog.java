package com.myscript.nebo.help;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.android.utils.DialogFragmentExt;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.utils.NewFeatureVisibilityHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackupReminderDialog.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/help/BackupReminderDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BackupReminderDialog extends DialogFragment {
    public static final String TAG = "BackupReminderDialog";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final BackupReminderDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View viewInflate = getLayoutInflater().inflate(C6079R.layout.backup_discover_dialog_layout, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(C6079R.id.backup_discover_dialog_message)).setLinksClickable(false);
        View viewFindViewById = viewInflate.findViewById(C6079R.id.backup_discover_dialog_image);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        viewFindViewById.setVisibility(requireContext().getResources().getBoolean(C6079R.bool.backup_reminder_show_illustration) ? 0 : 8);
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(requireContext(), C6079R.style.AlertDialogPositiveButtonAffordance).setTitle(C6079R.string.backup_discover_dialog_title).setView(viewInflate).setPositiveButton(C6079R.string.backup_discover_dialog_confirm, (DialogInterface.OnClickListener) null).setCancelable(false).create();
        final Window window = alertDialogCreate.getWindow();
        if (window != null) {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            decorView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.help.BackupReminderDialog$onCreateDialog$lambda$0$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    view.removeOnLayoutChangeListener(this);
                    int dimensionPixelSize = this.this$0.requireContext().getResources().getDimensionPixelSize(C6079R.dimen.backup_discover_dialog_message_max_width);
                    if (view.getWidth() > dimensionPixelSize) {
                        Window window2 = window;
                        window2.setLayout(dimensionPixelSize, window2.getAttributes().height);
                    }
                }
            });
        }
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "also(...)");
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        NewFeatureVisibilityHelper.markFeatureDiscovered$default(contextRequireContext, NewFeatureVisibilityHelper.Key.BACKUP_REMINDER, false, 2, null);
        super.onDismiss(dialog);
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        DialogFragmentExt.showAtMostOnce(this, manager, TAG);
    }

    /* JADX INFO: compiled from: BackupReminderDialog.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/help/BackupReminderDialog$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/help/BackupReminderDialog;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BackupReminderDialog newInstance() {
            return new BackupReminderDialog();
        }
    }
}
