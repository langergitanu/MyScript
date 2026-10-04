package com.myscript.nebo.backup.dialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProgressDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0014J\b\u0010\u0014\u001a\u00020\tH\u0014J.\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001aH\u0004R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/ProgressDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "progressDialog", "Landroid/app/ProgressDialog;", "getProgressDialog", "()Landroid/app/ProgressDialog;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onSaveInstanceState", "outState", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onBack", "onCancel", "setupArguments", "title", "", "message", "isIndeterminate", "", "isCancelable", "ProgressDialogResult", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public class ProgressDialogFragment extends DialogFragment {
    private static final int PROGRESS_DEFAULT_CURRENT_VALUE = 0;
    private static final int PROGRESS_DEFAULT_MAX_VALUE = 100;
    private static final String PROGRESS_DIALOG_FRAGMENT_IS_CANCELABLE = "PROGRESS_DIALOG_FRAGMENT_IS_CANCELABLE";
    private static final String PROGRESS_DIALOG_FRAGMENT_IS_INDETERMINATE = "PROGRESS_DIALOG_FRAGMENT_IS_INDETERMINATE";
    private static final String PROGRESS_DIALOG_FRAGMENT_LAST_MAX_VALUE = "PROGRESS_DIALOG_FRAGMENT_LAST_MAX_VALUE";
    private static final String PROGRESS_DIALOG_FRAGMENT_LAST_PROGRESS_VALUE = "PROGRESS_DIALOG_FRAGMENT_LAST_PROGRESS_VALUE";
    private static final String PROGRESS_DIALOG_FRAGMENT_MESSAGE = "PROGRESS_DIALOG_FRAGMENT_MESSAGE";
    private static final String PROGRESS_DIALOG_FRAGMENT_TITLE = "PROGRESS_DIALOG_FRAGMENT_TITLE";
    public static final String RESULT_CODE = "RESULT_CODE";
    public static final String TAG = "ProgressDialogFragment";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: ProgressDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/ProgressDialogFragment$ProgressDialogResult;", "", "<init>", "(Ljava/lang/String;I)V", "Canceled", "Error", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class ProgressDialogResult {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProgressDialogResult[] $VALUES;
        public static final ProgressDialogResult Canceled = new ProgressDialogResult("Canceled", 0);
        public static final ProgressDialogResult Error = new ProgressDialogResult("Error", 1);

        private static final /* synthetic */ ProgressDialogResult[] $values() {
            return new ProgressDialogResult[]{Canceled, Error};
        }

        public static EnumEntries<ProgressDialogResult> getEntries() {
            return $ENTRIES;
        }

        public static ProgressDialogResult valueOf(String str) {
            return (ProgressDialogResult) Enum.valueOf(ProgressDialogResult.class, str);
        }

        public static ProgressDialogResult[] values() {
            return (ProgressDialogResult[]) $VALUES.clone();
        }

        private ProgressDialogResult(String str, int i) {
        }

        static {
            ProgressDialogResult[] progressDialogResultArr$values = $values();
            $VALUES = progressDialogResultArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(progressDialogResultArr$values);
        }
    }

    protected final ProgressDialog getProgressDialog() {
        Dialog dialog = getDialog();
        if (dialog instanceof ProgressDialog) {
            return (ProgressDialog) dialog;
        }
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(requireArguments().getBoolean(PROGRESS_DIALOG_FRAGMENT_IS_CANCELABLE));
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.myscript.nebo.backup.dialog.ProgressDialogFragment$onCreateDialog$1] */
    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ?? r1 = new ProgressDialog(getActivity()) { // from class: com.myscript.nebo.backup.dialog.ProgressDialogFragment.onCreateDialog.1
            {
                super(fragmentActivity);
            }

            @Override // android.app.Dialog
            public void onBackPressed() {
                ProgressDialogFragment.this.onBack();
            }
        };
        Bundle bundleRequireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(bundleRequireArguments, "requireArguments(...)");
        String string = bundleRequireArguments.getString(PROGRESS_DIALOG_FRAGMENT_TITLE);
        if (string == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        r1.setTitle(string);
        r1.setMessage(bundleRequireArguments.getString(PROGRESS_DIALOG_FRAGMENT_MESSAGE));
        int i = savedInstanceState != null ? savedInstanceState.getInt(PROGRESS_DIALOG_FRAGMENT_LAST_PROGRESS_VALUE, 0) : 0;
        int i2 = savedInstanceState != null ? savedInstanceState.getInt(PROGRESS_DIALOG_FRAGMENT_LAST_MAX_VALUE, 100) : 100;
        boolean z = i == 0;
        r1.setCanceledOnTouchOutside(false);
        r1.setProgressStyle(1);
        r1.setProgress(i);
        r1.setMax(i2);
        r1.setIndeterminate(z || bundleRequireArguments.getBoolean(PROGRESS_DIALOG_FRAGMENT_IS_INDETERMINATE));
        r1.setProgressNumberFormat(null);
        r1.setProgressPercentFormat(null);
        r1.setButton(-2, getString(C6183R.string.dialog_cancel), new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.backup.dialog.ProgressDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f$0.onCancel();
            }
        });
        return (Dialog) r1;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        ProgressDialog progressDialog = getProgressDialog();
        if (progressDialog != null) {
            outState.putInt(PROGRESS_DIALOG_FRAGMENT_LAST_PROGRESS_VALUE, progressDialog.getProgress());
        }
        ProgressDialog progressDialog2 = getProgressDialog();
        if (progressDialog2 != null) {
            outState.putInt(PROGRESS_DIALOG_FRAGMENT_LAST_MAX_VALUE, progressDialog2.getMax());
        }
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

    protected void onBack() {
        onCancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCancel() {
        if (isAdded()) {
            dismiss();
            Fragment targetFragment = getTargetFragment();
            if (targetFragment != null) {
                targetFragment.onActivityResult(getTargetRequestCode(), 0, null);
            }
        }
    }

    public static /* synthetic */ void setupArguments$default(ProgressDialogFragment progressDialogFragment, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupArguments");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        progressDialogFragment.setupArguments(str, str2, z, z2);
    }

    protected final void setupArguments(String title, String message, boolean isIndeterminate, boolean isCancelable) {
        Intrinsics.checkNotNullParameter(title, "title");
        Bundle bundle = new Bundle();
        bundle.putString(PROGRESS_DIALOG_FRAGMENT_TITLE, title);
        if (message != null) {
            bundle.putString(PROGRESS_DIALOG_FRAGMENT_MESSAGE, message);
        }
        bundle.putBoolean(PROGRESS_DIALOG_FRAGMENT_IS_INDETERMINATE, isIndeterminate);
        bundle.putBoolean(PROGRESS_DIALOG_FRAGMENT_IS_CANCELABLE, isCancelable);
        setArguments(bundle);
    }

    /* JADX INFO: compiled from: ProgressDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/backup/dialog/ProgressDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "RESULT_CODE", ProgressDialogFragment.PROGRESS_DIALOG_FRAGMENT_TITLE, ProgressDialogFragment.PROGRESS_DIALOG_FRAGMENT_MESSAGE, ProgressDialogFragment.PROGRESS_DIALOG_FRAGMENT_LAST_PROGRESS_VALUE, ProgressDialogFragment.PROGRESS_DIALOG_FRAGMENT_LAST_MAX_VALUE, ProgressDialogFragment.PROGRESS_DIALOG_FRAGMENT_IS_INDETERMINATE, ProgressDialogFragment.PROGRESS_DIALOG_FRAGMENT_IS_CANCELABLE, "PROGRESS_DEFAULT_CURRENT_VALUE", "", "PROGRESS_DEFAULT_MAX_VALUE", "newInstance", "Lcom/myscript/nebo/backup/dialog/ProgressDialogFragment;", "title", "message", "isIndeterminate", "", "isCancelable", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ProgressDialogFragment newInstance$default(Companion companion, String str, String str2, boolean z, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return companion.newInstance(str, str2, z, z2);
        }

        public final ProgressDialogFragment newInstance(String title, String message, boolean isIndeterminate, boolean isCancelable) {
            Intrinsics.checkNotNullParameter(title, "title");
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
            progressDialogFragment.setupArguments(title, message, isIndeterminate, isCancelable);
            return progressDialogFragment;
        }
    }
}
