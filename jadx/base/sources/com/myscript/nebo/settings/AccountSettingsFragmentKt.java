package com.myscript.nebo.settings;

import android.content.Context;
import android.content.DialogInterface;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.cloudsync.CloudManager;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AccountSettingsFragment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¨\u0006\u000b"}, m1599d2 = {"computeAccountFreemiumDisplayState", "Lcom/myscript/nebo/settings/AccountFreemiumDisplayState;", "hasPaidEntitlement", "", "isFreePeriod", "showSignOutConfirmationDialog", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "completion", "Lkotlin/Function0;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AccountSettingsFragmentKt {
    public static final AccountFreemiumDisplayState computeAccountFreemiumDisplayState(boolean z, boolean z2) {
        int i;
        if (z) {
            i = C6079R.string.pref_account_in_apps_premium_title;
        } else if (z2) {
            i = C6079R.string.pref_account_in_apps_trial_title;
        } else {
            i = C6079R.string.pref_account_in_apps_freemium_title;
        }
        return new AccountFreemiumDisplayState(i, z ? C6079R.string.pref_account_freemium_summary_paid : C6079R.string.pref_account_freemium_summary_free, z);
    }

    public static final void showSignOutConfirmationDialog(Context context, final Function0<Unit> completion) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Object applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.myscript.nebo.cloudsync.CloudManager.Provider");
        CloudManager cloudManagerProvideCloudManager = ((CloudManager.Provider) applicationContext).provideCloudManager();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
        if (cloudManagerProvideCloudManager.isCloudConnected()) {
            materialAlertDialogBuilder.setTitle(C6079R.string.sso_login_disconnect_dialog_title);
            materialAlertDialogBuilder.setMessage(C6079R.string.sso_login_disconnect_dialog_message);
        } else {
            materialAlertDialogBuilder.setMessage((CharSequence) context.getString(C6079R.string.sso_login_disconnect_dialog_title));
        }
        materialAlertDialogBuilder.setPositiveButton(C6079R.string.sso_login_disconnect_dialog_positive_button, new DialogInterface.OnClickListener() { // from class: com.myscript.nebo.settings.AccountSettingsFragmentKt$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                completion.invoke();
            }
        });
        materialAlertDialogBuilder.setNegativeButton(C6079R.string.sso_login_disconnect_dialog_negative_button, (DialogInterface.OnClickListener) null);
        materialAlertDialogBuilder.create().show();
    }
}
