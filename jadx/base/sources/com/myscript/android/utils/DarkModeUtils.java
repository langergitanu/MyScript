package com.myscript.android.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DarkModeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0006\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\b¨\u0006\t"}, m1599d2 = {"isDarkMode", "", "Landroid/content/Context;", "Landroid/app/Activity;", "(Landroid/app/Activity;)Z", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Z", "Landroid/view/View;", "(Landroid/view/View;)Z", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DarkModeUtils {
    public static final boolean isDarkMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final boolean isDarkMode(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        return isDarkMode((Context) activity);
    }

    public static final boolean isDarkMode(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Context contextRequireContext = fragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        return isDarkMode(contextRequireContext);
    }

    public static final boolean isDarkMode(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return isDarkMode(context);
    }
}
