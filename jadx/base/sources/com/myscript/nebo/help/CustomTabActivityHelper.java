package com.myscript.nebo.help;

import android.app.Activity;
import android.net.Uri;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.google.android.gms.common.internal.ImagesContract;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.C6183R;
import com.myscript.nebo.common.utils.PlatformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomTabActivityHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, m1599d2 = {"Lcom/myscript/nebo/help/CustomTabActivityHelper;", "Lcom/myscript/nebo/help/ServiceConnectionCallback;", "<init>", "()V", "customTabsSession", "Landroidx/browser/customtabs/CustomTabsSession;", "customTabsClient", "Landroidx/browser/customtabs/CustomTabsClient;", "customTabsConnection", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "connectionCallback", "Lcom/myscript/nebo/help/CustomTabActivityHelper$ConnectionCallback;", "session", "getSession", "()Landroidx/browser/customtabs/CustomTabsSession;", "bindCustomTabsService", "", "activity", "Landroid/app/Activity;", "unbindCustomTabsService", "openHelpCustomTab", ImagesContract.URL, "", "onServiceConnected", "client", "onServiceDisconnected", "ConnectionCallback", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CustomTabActivityHelper implements ServiceConnectionCallback {
    private static final int HELP_CUSTOM_TAB_BACKGROUND_INTERACT_OFF_VALUE = 2;
    private static final String TAG = "CustomTabActivityHelper";
    private ConnectionCallback connectionCallback;
    private CustomTabsClient customTabsClient;
    private CustomTabsServiceConnection customTabsConnection;
    private CustomTabsSession customTabsSession;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: CustomTabActivityHelper.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/help/CustomTabActivityHelper$ConnectionCallback;", "", "onCustomTabsConnected", "", "onCustomTabsDisconnected", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ConnectionCallback {
        void onCustomTabsConnected();

        void onCustomTabsDisconnected();
    }

    @JvmStatic
    public static final void openCustomTab(Activity activity, CustomTabsIntent customTabsIntent, String str) {
        INSTANCE.openCustomTab(activity, customTabsIntent, str);
    }

    public final CustomTabsSession getSession() {
        CustomTabsClient customTabsClient = this.customTabsClient;
        if (customTabsClient == null) {
            this.customTabsSession = null;
        } else if (this.customTabsSession == null) {
            this.customTabsSession = customTabsClient != null ? customTabsClient.newSession(null) : null;
        }
        return this.customTabsSession;
    }

    public final void bindCustomTabsService(Activity activity) {
        Activity activity2;
        String packageNameToUse;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.customTabsClient != null || (packageNameToUse = CustomTabsHelper.INSTANCE.getPackageNameToUse((activity2 = activity))) == null) {
            return;
        }
        ServiceConnection serviceConnection = new ServiceConnection(this);
        this.customTabsConnection = serviceConnection;
        CustomTabsClient.bindCustomTabsService(activity2, packageNameToUse, serviceConnection);
    }

    public final void unbindCustomTabsService(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CustomTabsServiceConnection customTabsServiceConnection = this.customTabsConnection;
        if (customTabsServiceConnection != null) {
            activity.unbindService(customTabsServiceConnection);
        }
        this.customTabsConnection = null;
        this.customTabsClient = null;
        this.customTabsSession = null;
    }

    public final void openHelpCustomTab(Activity activity, String url) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder(getSession()).build();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
        customTabsIntentBuild.intent.putExtra("androidx.browser.customtabs.extra.INITIAL_ACTIVITY_HEIGHT_IN_PIXEL", activity.getResources().getDisplayMetrics().heightPixels / 2);
        customTabsIntentBuild.intent.putExtra("androidx.browser.customtabs.extra.TOOLBAR_CORNER_RADIUS_IN_PIXEL", activity.getResources().getDimension(C6079R.dimen.help_custom_tab_corner_radius_max));
        customTabsIntentBuild.intent.putExtra("androix.browser.customtabs.extra.ENABLE_BACKGROUND_INTERACTION", 2);
        INSTANCE.openCustomTab(activity, customTabsIntentBuild, url);
    }

    @Override // com.myscript.nebo.help.ServiceConnectionCallback
    public void onServiceConnected(CustomTabsClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.customTabsClient = client;
        if (client != null) {
            client.warmup(0L);
        }
        ConnectionCallback connectionCallback = this.connectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsConnected();
        }
    }

    @Override // com.myscript.nebo.help.ServiceConnectionCallback
    public void onServiceDisconnected() {
        this.customTabsClient = null;
        this.customTabsSession = null;
        ConnectionCallback connectionCallback = this.connectionCallback;
        if (connectionCallback != null) {
            connectionCallback.onCustomTabsDisconnected();
        }
    }

    /* JADX INFO: compiled from: CustomTabActivityHelper.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/myscript/nebo/help/CustomTabActivityHelper$Companion;", "", "<init>", "()V", "TAG", "", "HELP_CUSTOM_TAB_BACKGROUND_INTERACT_OFF_VALUE", "", "openCustomTab", "", "activity", "Landroid/app/Activity;", "customTabsIntent", "Landroidx/browser/customtabs/CustomTabsIntent;", ImagesContract.URL, "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void openCustomTab(Activity activity, CustomTabsIntent customTabsIntent, String url) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(customTabsIntent, "customTabsIntent");
            Intrinsics.checkNotNullParameter(url, "url");
            Activity activity2 = activity;
            String packageNameToUse = CustomTabsHelper.INSTANCE.getPackageNameToUse(activity2);
            if (packageNameToUse != null && Intrinsics.areEqual(packageNameToUse, activity.getString(C6183R.string.chrome_package_name))) {
                try {
                    customTabsIntent.intent.setPackage(packageNameToUse);
                    customTabsIntent.launchUrl(activity, Uri.parse(url));
                    return;
                } catch (Exception unused) {
                    Log.e(CustomTabActivityHelper.TAG, "Fallback to default browser");
                    if (PlatformUtils.openUrl(activity2, url)) {
                        return;
                    }
                    Log.e(CustomTabActivityHelper.TAG, "No app found to handle url intent");
                    return;
                }
            }
            if (PlatformUtils.openUrl(activity2, url)) {
                return;
            }
            Log.e(CustomTabActivityHelper.TAG, "No app found to handle url intent");
        }
    }
}
