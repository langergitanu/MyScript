package com.survicate.surveys.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.survicate.surveys.C8369R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenUtils.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/utils/ScreenUtils;", "", "<init>", "()V", "isWideScreen", "", "resources", "Landroid/content/res/Resources;", "isLandscapeOrientation", "getScreenWidth", "", "windowManager", "Landroid/view/WindowManager;", "isDarkMode", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class ScreenUtils {
    public static final ScreenUtils INSTANCE = new ScreenUtils();

    private ScreenUtils() {
    }

    @JvmStatic
    public static final boolean isWideScreen(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return resources.getBoolean(C8369R.bool.isWideScreen);
    }

    public final boolean isLandscapeOrientation(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return resources.getBoolean(C8369R.bool.isLandscape);
    }

    @JvmStatic
    public static final int getScreenWidth(WindowManager windowManager) {
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        if (Build.VERSION.SDK_INT >= 30) {
            return windowManager.getCurrentWindowMetrics().getBounds().width();
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public final boolean isDarkMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
