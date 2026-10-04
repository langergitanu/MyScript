package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PaywallWebView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001au\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\t2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\tH\u0000¢\u0006\u0002\u0010\u000e\u001a6\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, m1599d2 = {"shouldWebViewOwnGesture", "", "totalDx", "", "totalDy", "touchSlop", "", "webContentWantsGesture", "canScrollHorizontally", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "direction", "canScrollVertically", "(FFILjava/lang/Boolean;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Z", "trackedPointerDelta", "Lkotlin/Pair;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "trackedPointerId", "downX", "downY", "revenuecatui_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* synthetic */ class PaywallWebViewKt {
    public static final boolean shouldWebViewOwnGesture(float f, float f2, int i, Boolean bool, Function1<? super Integer, Boolean> canScrollHorizontally, Function1<? super Integer, Boolean> canScrollVertically) {
        Intrinsics.checkNotNullParameter(canScrollHorizontally, "canScrollHorizontally");
        Intrinsics.checkNotNullParameter(canScrollVertically, "canScrollVertically");
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            return true;
        }
        float fCoerceAtLeast = RangesKt.coerceAtLeast(i / 2, 1);
        if (Math.abs(f) < fCoerceAtLeast && Math.abs(f2) < fCoerceAtLeast) {
            return false;
        }
        if (Math.abs(f2) >= Math.abs(f)) {
            return canScrollVertically.invoke(Integer.valueOf(f2 >= 0.0f ? -1 : 1)).booleanValue();
        }
        return canScrollHorizontally.invoke(Integer.valueOf(f >= 0.0f ? -1 : 1)).booleanValue();
    }

    public static final Pair<Float, Float> trackedPointerDelta(MotionEvent event, int i, float f, float f2) {
        Intrinsics.checkNotNullParameter(event, "event");
        int iFindPointerIndex = event.findPointerIndex(i);
        if (iFindPointerIndex == -1) {
            return null;
        }
        return TuplesKt.m1606to(Float.valueOf(event.getX(iFindPointerIndex) - f), Float.valueOf(event.getY(iFindPointerIndex) - f2));
    }
}
