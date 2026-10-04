package com.myscript.nebo.utils;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.myscript.nebo.C6079R;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SupportUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m1599d2 = {"openSupportWebsite", "", "Landroid/app/Activity;", "Landroidx/fragment/app/Fragment;", "getSupportURL", "", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class SupportUtilsKt {
    public static final void openSupportWebsite(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Activity activity2 = activity;
        PlatformUtils.openUrl(activity2, getSupportURL(activity2));
    }

    public static final void openSupportWebsite(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        FragmentActivity fragmentActivity = fragmentActivityRequireActivity;
        PlatformUtils.openUrl(fragmentActivity, getSupportURL(fragmentActivity));
    }

    public static final String getSupportURL(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(C6079R.string.corrupted_page_support);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
