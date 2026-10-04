package com.myscript.nebo.sso.p032ui.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.activity.result.ActivityResultLauncher;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import com.google.android.gms.common.internal.ImagesContract;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginActivityHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001aD\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\f¨\u0006\u0011"}, m1599d2 = {"getLoginActivityIntent", "Landroid/content/Intent;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "origin", "", "getCustomTabsPackageName", "launchTab", "", "activity", "Landroid/app/Activity;", "activityLauncher", "Lkotlin/Function0;", "Landroidx/activity/result/ActivityResultLauncher;", ImagesContract.URL, "browserPackageName", "onTabLaunched", "sso_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class LoginActivityHelperKt {
    public static final Intent getLoginActivityIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getLoginActivityIntent$default(context, null, 2, null);
    }

    public static /* synthetic */ Intent getLoginActivityIntent$default(Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return getLoginActivityIntent(context, str);
    }

    public static final Intent getLoginActivityIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        return FallbackLoginActivity.INSTANCE.newIntent(context, str);
    }

    public static final String getCustomTabsPackageName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
        customTabsIntentBuild.intent.setData(Uri.parse("http://google.com"));
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "apply(...)");
        PackageManager packageManager = context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(customTabsIntentBuild.intent, 131072);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        List<ResolveInfo> list = listQueryIntentActivities;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ResolveInfo) it.next()).activityInfo.packageName);
        }
        return CustomTabsClient.getPackageName(context, arrayList, true);
    }

    public static /* synthetic */ void launchTab$default(Activity activity, Function0 function0, String str, String str2, Function0 function02, int i, Object obj) {
        if ((i & 16) != 0) {
            function02 = new Function0() { // from class: com.myscript.nebo.sso.ui.login.LoginActivityHelperKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        launchTab(activity, function0, str, str2, function02);
    }

    public static final void launchTab(final Activity activity, final Function0<? extends ActivityResultLauncher<Intent>> activityLauncher, final String url, String browserPackageName, final Function0<Unit> onTabLaunched) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(activityLauncher, "activityLauncher");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(browserPackageName, "browserPackageName");
        Intrinsics.checkNotNullParameter(onTabLaunched, "onTabLaunched");
        CustomTabsClient.bindCustomTabsService(activity, browserPackageName, new CustomTabsServiceConnection() { // from class: com.myscript.nebo.sso.ui.login.LoginActivityHelperKt$launchTab$connection$1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName p0) {
            }

            @Override // androidx.browser.customtabs.CustomTabsServiceConnection
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient client) {
                Intrinsics.checkNotNullParameter(componentName, "componentName");
                Intrinsics.checkNotNullParameter(client, "client");
                client.warmup(0L);
                CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
                String str = url;
                customTabsIntentBuild.intent.setFlags(335544320);
                customTabsIntentBuild.intent.setData(Uri.parse(str));
                Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "apply(...)");
                ActivityResultLauncher<Intent> activityResultLauncherInvoke = activityLauncher.invoke();
                if (activityResultLauncherInvoke != null) {
                    Intent intent = customTabsIntentBuild.intent;
                    Intrinsics.checkNotNullExpressionValue(intent, "intent");
                    activityResultLauncherInvoke.launch(intent);
                }
                onTabLaunched.invoke();
                activity.unbindService(this);
            }
        });
    }
}
