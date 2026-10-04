package com.myscript.nebo.cloudsync.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.utils.PlatformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ForwardCompatibilityDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/dialogs/ForwardCompatibilityDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ForwardCompatibilityDialogFragment extends DialogFragment {
    public static final String TAG = "ForwardCompatibilityDialogFragment";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final ForwardCompatibilityDialogFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int i;
        int i2;
        final boolean z = getResources().getBoolean(C6079R.bool.open_play_store_to_update);
        if (z) {
            i = C6079R.string.forward_compatibility_dialog_later;
            i2 = C6079R.string.forward_compatibility_dialog_open_store;
        } else {
            i = C6183R.string.dialog_ok;
            i2 = C6079R.string.forward_compatibility_dialog_learn_more;
        }
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(requireActivity()).setTitle(C6079R.string.forward_compatibility_dialog_title).setMessage(C6079R.string.forward_compatibility_dialog_message).setPositiveButton(i, (DialogInterface.OnClickListener) null).setNegativeButton(i2, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.cloudsync.dialogs.ForwardCompatibilityDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ForwardCompatibilityDialogFragment.onCreateDialog$lambda$0(z, this, dialogInterface, i3);
            }
        }).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(boolean z, ForwardCompatibilityDialogFragment forwardCompatibilityDialogFragment, DialogInterface dialogInterface, int i) {
        if (z) {
            PlatformUtils.openPlayStore(forwardCompatibilityDialogFragment.getContext());
        } else {
            PlatformUtils.openUrl(forwardCompatibilityDialogFragment.getContext(), forwardCompatibilityDialogFragment.getString(C6079R.string.nebo_upgrade_needed_url));
        }
    }

    /* JADX INFO: compiled from: ForwardCompatibilityDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/dialogs/ForwardCompatibilityDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/myscript/nebo/cloudsync/dialogs/ForwardCompatibilityDialogFragment;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ForwardCompatibilityDialogFragment newInstance() {
            return new ForwardCompatibilityDialogFragment();
        }
    }
}
