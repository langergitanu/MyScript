package com.myscript.nebo.cloudsync.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.cloudsync.CloudManager;
import com.myscript.nebo.common.C6183R;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudTokenInvalidDialogFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/dialogs/CloudTokenInvalidDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setResult", "", "action", "", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CloudTokenInvalidDialogFragment extends DialogFragment {
    public static final String ACTION_DISCONNECT = "disconnect";
    public static final String ACTION_RECONNECT = "reconnect";
    private static final String ARG_PROVIDER = "arg_provider";
    private static final String ARG_TOKEN_INVALIDATED = "arg_token_invalidated";
    public static final String KEY_ACTION = "key_action";
    public static final String KEY_PROVIDER = "key_provider";
    public static final String KEY_TOKEN_INVALIDATED = "key_token_invalidated";
    public static final String REQUEST_KEY = "cloud_token_invalid_result";
    public static final String TAG = "CloudTokenInvalidDialogFragment";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final CloudTokenInvalidDialogFragment newInstance(CloudManager.CloudProviderType cloudProviderType, boolean z) {
        return INSTANCE.newInstance(cloudProviderType, z);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(requireActivity()).setTitle(C6079R.string.sync_disabled).setMessage(C6079R.string.sync_disconnected_alert_message).setPositiveButton(C6079R.string.sync_disconnected_alert_enable_button, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.setResult(CloudTokenInvalidDialogFragment.ACTION_RECONNECT);
            }
        }).setNegativeButton(C6183R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.setResult(CloudTokenInvalidDialogFragment.ACTION_DISCONNECT);
            }
        }).create();
        setCancelable(false);
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "apply(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setResult(String action) {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_PROVIDER)) == null) {
            return;
        }
        Bundle arguments2 = getArguments();
        getParentFragmentManager().setFragmentResult(REQUEST_KEY, BundleKt.bundleOf(TuplesKt.m1606to(KEY_ACTION, action), TuplesKt.m1606to(KEY_PROVIDER, string), TuplesKt.m1606to(KEY_TOKEN_INVALIDATED, Boolean.valueOf(arguments2 != null ? arguments2.getBoolean(ARG_TOKEN_INVALIDATED, false) : false))));
    }

    /* JADX INFO: compiled from: CloudTokenInvalidDialogFragment.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/cloudsync/dialogs/CloudTokenInvalidDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_KEY", "KEY_ACTION", "KEY_PROVIDER", "KEY_TOKEN_INVALIDATED", "ACTION_RECONNECT", "ACTION_DISCONNECT", "ARG_PROVIDER", "ARG_TOKEN_INVALIDATED", "newInstance", "Lcom/myscript/nebo/cloudsync/dialogs/CloudTokenInvalidDialogFragment;", "provider", "Lcom/myscript/nebo/cloudsync/CloudManager$CloudProviderType;", "tokenInvalidated", "", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CloudTokenInvalidDialogFragment newInstance$default(Companion companion, CloudManager.CloudProviderType cloudProviderType, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.newInstance(cloudProviderType, z);
        }

        @JvmStatic
        public final CloudTokenInvalidDialogFragment newInstance(CloudManager.CloudProviderType provider, boolean tokenInvalidated) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            CloudTokenInvalidDialogFragment cloudTokenInvalidDialogFragment = new CloudTokenInvalidDialogFragment();
            cloudTokenInvalidDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.m1606to(CloudTokenInvalidDialogFragment.ARG_PROVIDER, provider.name()), TuplesKt.m1606to(CloudTokenInvalidDialogFragment.ARG_TOKEN_INVALIDATED, Boolean.valueOf(tokenInvalidated))));
            return cloudTokenInvalidDialogFragment;
        }
    }
}
