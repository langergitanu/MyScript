package com.myscript.nebo.backup.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.utils.PlatformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InformationDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0002¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/InformationDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onOk", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class InformationDialogFragment extends DialogFragment {
    private static final String INFORMATION_DIALOG_FRAGMENT_DISPLAY_SUPPORT_ACTION = "INFORMATION_DIALOG_FRAGMENT_DISPLAY_SUPPORT_ACTION";
    private static final String INFORMATION_DIALOG_FRAGMENT_MESSAGE = "INFORMATION_DIALOG_FRAGMENT_MESSAGE";
    private static final String INFORMATION_DIALOG_FRAGMENT_TITLE = "INFORMATION_DIALOG_FRAGMENT_TITLE";
    public static final String TAG = "InfoDialogFragment";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(contextRequireContext);
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        String string = bundleRequireArguments.getString(INFORMATION_DIALOG_FRAGMENT_TITLE);
        if (string == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        materialAlertDialogBuilder.setTitle((CharSequence) string);
        String string2 = bundleRequireArguments.getString(INFORMATION_DIALOG_FRAGMENT_MESSAGE);
        if (string2 == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        materialAlertDialogBuilder.setMessage((CharSequence) string2);
        boolean z = bundleRequireArguments.getBoolean(INFORMATION_DIALOG_FRAGMENT_DISPLAY_SUPPORT_ACTION, false);
        materialAlertDialogBuilder.setPositiveButton(C6183R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.backup.dialog.InformationDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.onOk();
            }
        });
        if (z) {
            materialAlertDialogBuilder.setNeutralButton(C6079R.string.backup_error_alert_support, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.backup.dialog.InformationDialogFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    InformationDialogFragment.onCreateDialog$lambda$0$1(contextRequireContext, dialogInterface, i);
                }
            });
        }
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$1(Context context, DialogInterface dialogInterface, int i) {
        if (PlatformUtils.openUrl(context, C6079R.string.backup_support_url)) {
            return;
        }
        Log.d(TAG, "Can't open support url");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ActivityResultCaller targetFragment = getTargetFragment();
        DialogInterface.OnDismissListener onDismissListener = targetFragment instanceof DialogInterface.OnDismissListener ? (DialogInterface.OnDismissListener) targetFragment : null;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onOk() {
        dismiss();
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(getTargetRequestCode(), -1, null);
        }
    }

    /* JADX INFO: compiled from: InformationDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/InformationDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", InformationDialogFragment.INFORMATION_DIALOG_FRAGMENT_TITLE, InformationDialogFragment.INFORMATION_DIALOG_FRAGMENT_MESSAGE, InformationDialogFragment.INFORMATION_DIALOG_FRAGMENT_DISPLAY_SUPPORT_ACTION, "newInstance", "Lcom/myscript/nebo/backup/dialog/InformationDialogFragment;", "title", "message", "displaySupportButton", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ InformationDialogFragment newInstance$default(Companion companion, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.newInstance(str, str2, z);
        }

        public final InformationDialogFragment newInstance(String title, String message, boolean displaySupportButton) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            InformationDialogFragment informationDialogFragment = new InformationDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(InformationDialogFragment.INFORMATION_DIALOG_FRAGMENT_TITLE, title);
            bundle.putString(InformationDialogFragment.INFORMATION_DIALOG_FRAGMENT_MESSAGE, message);
            bundle.putBoolean(InformationDialogFragment.INFORMATION_DIALOG_FRAGMENT_DISPLAY_SUPPORT_ACTION, displaySupportButton);
            informationDialogFragment.setArguments(bundle);
            return informationDialogFragment;
        }
    }
}
