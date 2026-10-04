package com.myscript.nebo.sso.p032ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.sso.C6821R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SSOTokenInvalidatedDialogFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/SSOTokenInvalidatedDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "callback", "Lcom/myscript/nebo/sso/ui/SSOTokenInvalidatedDialogFragment$Callback;", "getCallback", "()Lcom/myscript/nebo/sso/ui/SSOTokenInvalidatedDialogFragment$Callback;", "setCallback", "(Lcom/myscript/nebo/sso/ui/SSOTokenInvalidatedDialogFragment$Callback;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "Callback", "Companion", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SSOTokenInvalidatedDialogFragment extends DialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "SSOTokenInvalidatedDialogFragment";
    private Callback callback;

    /* JADX INFO: compiled from: SSOTokenInvalidatedDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/SSOTokenInvalidatedDialogFragment$Callback;", "", "onLoginRequested", "", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Callback {
        void onLoginRequested();
    }

    @JvmStatic
    public static final SSOTokenInvalidatedDialogFragment newInstance(Callback callback) {
        return INSTANCE.newInstance(callback);
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(requireActivity()).setTitle(C6821R.string.sso_token_invalidated_dialog_title).setMessage(C6821R.string.sso_token_invalidated_dialog_message).setPositiveButton(C6821R.string.sso_token_invalidated_dialog_login, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.sso.ui.SSOTokenInvalidatedDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SSOTokenInvalidatedDialogFragment.onCreateDialog$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(C6821R.string.sso_token_invalidated_dialog_later, (DialogInterface.OnClickListener) null).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(SSOTokenInvalidatedDialogFragment sSOTokenInvalidatedDialogFragment, DialogInterface dialogInterface, int i) {
        Callback callback = sSOTokenInvalidatedDialogFragment.callback;
        if (callback != null) {
            callback.onLoginRequested();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        this.callback = null;
        super.onDismiss(dialog);
    }

    /* JADX INFO: compiled from: SSOTokenInvalidatedDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/myscript/nebo/sso/ui/SSOTokenInvalidatedDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/sso/ui/SSOTokenInvalidatedDialogFragment;", "callback", "Lcom/myscript/nebo/sso/ui/SSOTokenInvalidatedDialogFragment$Callback;", "sso_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SSOTokenInvalidatedDialogFragment newInstance(Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            SSOTokenInvalidatedDialogFragment sSOTokenInvalidatedDialogFragment = new SSOTokenInvalidatedDialogFragment();
            sSOTokenInvalidatedDialogFragment.setCallback(callback);
            return sSOTokenInvalidatedDialogFragment;
        }
    }
}
