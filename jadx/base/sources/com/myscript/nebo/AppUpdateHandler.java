package com.myscript.nebo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppUpdateHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m1599d2 = {"Lcom/myscript/nebo/AppUpdateHandler;", "", "<init>", "()V", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "appUpdateResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroidx/activity/result/IntentSenderRequest;", "registerActivity", "", "onResume", "checkForAppUpdates", "launchUpdateFlow", "info", "Lcom/google/android/play/core/appupdate/AppUpdateInfo;", "unregisterActivity", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class AppUpdateHandler {
    public static final boolean ENABLE_IMMEDIATE_UPDATE = false;
    public static final String TAG = "AppUpdateHandler";
    private AppCompatActivity activity;
    private AppUpdateManager appUpdateManager;
    private ActivityResultLauncher<IntentSenderRequest> appUpdateResultLauncher;
    public static final int $stable = 8;

    private final void checkForAppUpdates() {
    }

    private final void launchUpdateFlow(AppUpdateInfo info) {
    }

    public final void onResume() {
    }

    public final void registerActivity(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void unregisterActivity() {
    }

    private static final void registerActivity$lambda$0(AppUpdateHandler appUpdateHandler, AppCompatActivity appCompatActivity, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int resultCode = result.getResultCode();
        if (resultCode != -1) {
            if (resultCode == 0) {
                appUpdateHandler.checkForAppUpdates();
            } else {
                appCompatActivity.finishAffinity();
            }
        }
    }

    private static final Unit onResume$lambda$0(AppUpdateHandler appUpdateHandler, AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 3) {
            Intrinsics.checkNotNull(appUpdateInfo);
            appUpdateHandler.launchUpdateFlow(appUpdateInfo);
        }
        return Unit.INSTANCE;
    }

    private static final Unit checkForAppUpdates$lambda$0(AppUpdateHandler appUpdateHandler, AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 2) {
            Intrinsics.checkNotNull(appUpdateInfo);
            appUpdateHandler.launchUpdateFlow(appUpdateInfo);
        }
        return Unit.INSTANCE;
    }
}
