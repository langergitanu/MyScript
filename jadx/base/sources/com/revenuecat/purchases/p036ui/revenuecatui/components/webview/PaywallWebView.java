package com.revenuecat.purchases.p036ui.revenuecatui.components.webview;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PaywallWebView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0017R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001c"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/webview/PaywallWebView;", "Landroid/webkit/WebView;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "canScrollHorizontallyReference", "Lkotlin/Function1;", "", "", "canScrollVerticallyReference", "claimedForWebView", "downX", "", "downY", "gestureActive", "lastTotalDx", "lastTotalDy", "touchSlop", "trackedPointerId", "webContentWantsGesture", "Ljava/lang/Boolean;", "claimForWebViewIfNeeded", "", "onContentGestureVerdict", "wantsGesture", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class PaywallWebView extends WebView {
    public static final int $stable = 8;
    private final Function1<Integer, Boolean> canScrollHorizontallyReference;
    private final Function1<Integer, Boolean> canScrollVerticallyReference;
    private boolean claimedForWebView;
    private float downX;
    private float downY;
    private boolean gestureActive;
    private float lastTotalDx;
    private float lastTotalDy;
    private final int touchSlop;
    private int trackedPointerId;
    private Boolean webContentWantsGesture;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaywallWebView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.canScrollHorizontallyReference = new PaywallWebView$canScrollHorizontallyReference$1(this);
        this.canScrollVerticallyReference = new PaywallWebView$canScrollVerticallyReference$1(this);
        this.trackedPointerId = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
    @Override // android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.downX = event.getX();
            this.downY = event.getY();
            this.trackedPointerId = event.getPointerId(0);
            this.lastTotalDx = 0.0f;
            this.lastTotalDy = 0.0f;
            this.webContentWantsGesture = null;
            this.claimedForWebView = false;
            this.gestureActive = true;
        } else if (actionMasked == 1) {
            this.gestureActive = false;
        } else if (actionMasked == 2) {
            Pair<Float, Float> pairTrackedPointerDelta = PaywallWebViewKt.trackedPointerDelta(event, this.trackedPointerId, this.downX, this.downY);
            if (pairTrackedPointerDelta == null) {
                return super.onTouchEvent(event);
            }
            this.lastTotalDx = pairTrackedPointerDelta.getFirst().floatValue();
            this.lastTotalDy = pairTrackedPointerDelta.getSecond().floatValue();
            claimForWebViewIfNeeded();
        } else if (actionMasked == 3) {
        }
        return super.onTouchEvent(event);
    }

    public final /* synthetic */ void onContentGestureVerdict(final boolean wantsGesture) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.webview.PaywallWebView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onContentGestureVerdict(wantsGesture);
                }
            });
        } else if (this.gestureActive) {
            this.webContentWantsGesture = Boolean.valueOf(wantsGesture);
            claimForWebViewIfNeeded();
        }
    }

    private final void claimForWebViewIfNeeded() {
        if (!this.claimedForWebView && PaywallWebViewKt.shouldWebViewOwnGesture(this.lastTotalDx, this.lastTotalDy, this.touchSlop, this.webContentWantsGesture, this.canScrollHorizontallyReference, this.canScrollVerticallyReference)) {
            this.claimedForWebView = true;
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }
}
