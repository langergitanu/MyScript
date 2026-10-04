package com.myscript.nebo.common.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import com.myscript.android.utils.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayMetricsExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m1599d2 = {"fixedDisplayMetrics", "Landroid/util/DisplayMetrics;", "Landroid/content/Context;", "getFixedDisplayMetrics", "(Landroid/content/Context;)Landroid/util/DisplayMetrics;", "common_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DisplayMetricsExtKt {
    public static final DisplayMetrics getFixedDisplayMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        DisplayMetrics fixedDisplayMetrics = ScreenUtils.getFixedDisplayMetrics(context);
        Intrinsics.checkNotNullExpressionValue(fixedDisplayMetrics, "getFixedDisplayMetrics(...)");
        return fixedDisplayMetrics;
    }
}
