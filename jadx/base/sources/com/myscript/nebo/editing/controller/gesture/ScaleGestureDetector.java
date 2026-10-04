package com.myscript.nebo.editing.controller.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScaleGestureDetector.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/editing/controller/gesture/ScaleGestureDetector;", "Landroid/view/ScaleGestureDetector;", WebViewMessageType.CONTEXT, "Landroid/content/Context;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "<init>", "(Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V", "needToIgnore", "", "secondPointerId", "", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "Companion", "editing_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class ScaleGestureDetector extends android.view.ScaleGestureDetector {
    private static final int WAIT_FOR_NEW_TOUCH_POINT_DELAY = 40;
    private boolean needToIgnore;
    private int secondPointerId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleGestureDetector(Context context, ScaleGestureDetector.OnScaleGestureListener listener) {
        super(context, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.secondPointerId = -1;
    }

    @Override // android.view.ScaleGestureDetector
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getActionMasked() == 0) {
            this.needToIgnore = false;
            this.secondPointerId = -1;
        } else if (event.getActionMasked() == 5) {
            this.needToIgnore = event.getEventTime() - event.getDownTime() > 200;
            if (this.secondPointerId == -1 && event.getPointerCount() == 2) {
                this.secondPointerId = event.getPointerId(1);
            }
        }
        boolean z = event.getAction() == 2 && event.getEventTime() < event.getDownTime() + ((long) 40);
        boolean z2 = event.getPointerCount() == 2 && event.getPointerId(1) != this.secondPointerId;
        if (this.needToIgnore || event.getPointerCount() != 2 || z || z2) {
            return false;
        }
        return super.onTouchEvent(event);
    }
}
