package com.revenuecat.purchases.p036ui.revenuecatui.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.p036ui.revenuecatui.C7495R;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.p036ui.revenuecatui.extensions.UrisKt;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: URLOpener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/utils/URLOpener;", "", "()V", "openURL", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", ImagesContract.URL, "", FirebaseAnalytics.Param.METHOD, "Lcom/revenuecat/purchases/ui/revenuecatui/utils/URLOpeningMethod;", "openURL$revenuecatui_defaultsRelease", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class URLOpener {
    public static final int $stable = 0;
    public static final URLOpener INSTANCE = new URLOpener();

    /* JADX INFO: compiled from: URLOpener.kt */
    @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[URLOpeningMethod.values().length];
            try {
                iArr[URLOpeningMethod.IN_APP_BROWSER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[URLOpeningMethod.EXTERNAL_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[URLOpeningMethod.DEEP_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private URLOpener() {
    }

    public final /* synthetic */ boolean openURL$revenuecatui_defaultsRelease(Context context, String url, URLOpeningMethod method) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        int i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
        if (i == 1) {
            CustomTabsIntent customTabsIntentBuild = new CustomTabsIntent.Builder().build();
            Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "Builder()\n                    .build()");
            try {
                customTabsIntentBuild.launchUrl(context, Uri.parse(url));
            } catch (ActivityNotFoundException e) {
                openURL$handleException(booleanRef, context, e);
            } catch (IllegalArgumentException e2) {
                openURL$handleException(booleanRef, context, e2);
            }
        } else if (i == 2 || i == 3) {
            UrisKt.openUriOrElse(context, url, new URLOpener$openURL$1(booleanRef, context));
        }
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openURL$handleException(Ref.BooleanRef booleanRef, Context context, Exception exc) {
        String string;
        booleanRef.element = false;
        if (exc instanceof ActivityNotFoundException) {
            string = context.getString(C7495R.string.no_browser_cannot_open_link);
        } else {
            string = context.getString(C7495R.string.cannot_open_link);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (exception is Activit…_open_link)\n            }");
        Toast.makeText(context, string, 0).show();
        Logger.INSTANCE.m1585e(string, exc);
    }
}
