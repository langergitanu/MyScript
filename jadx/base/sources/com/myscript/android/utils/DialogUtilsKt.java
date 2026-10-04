package com.myscript.android.utils;

import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DialogUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, m1599d2 = {"configureForEdgeToEdge", "", "Landroid/app/Dialog;", "android-utils_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DialogUtilsKt {
    public static final void configureForEdgeToEdge(Dialog dialog) {
        WindowManager.LayoutParams attributes;
        Intrinsics.checkNotNullParameter(dialog, "<this>");
        Window window = dialog.getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                WindowManager.LayoutParams attributes2 = window.getAttributes();
                if (attributes2 != null) {
                    attributes2.layoutInDisplayCutoutMode = 3;
                }
            } else if (Build.VERSION.SDK_INT >= 28 && (attributes = window.getAttributes()) != null) {
                attributes.layoutInDisplayCutoutMode = 1;
            }
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            ViewExt.configureForEdgeToEdge(decorView);
        }
    }
}
