package com.myscript.nebo.editing;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.app.NotificationCompat;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EditingActivity.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, m1599d2 = {"closeInputMethod", "", "Landroid/view/View;", "cancelSwipeGesture", "Landroidx/viewpager2/widget/ViewPager2;", "containsEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "app_standardRelease"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class EditingActivityKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void closeInputMethod(View view) {
        Object systemService = view.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelSwipeGesture(ViewPager2 viewPager2) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, ((long) 100) + jUptimeMillis, 3, 0.0f, 0.0f, 0);
        viewPager2.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean containsEvent(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = iArr[0];
        if (rawX <= r3 + view.getWidth() && f <= rawX) {
            float f2 = iArr[1];
            if (rawY <= r0 + view.getHeight() && f2 <= rawY) {
                return true;
            }
        }
        return false;
    }
}
