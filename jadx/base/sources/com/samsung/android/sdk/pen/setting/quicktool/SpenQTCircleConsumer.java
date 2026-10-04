package com.samsung.android.sdk.pen.setting.quicktool;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SpenQTCircleConsumer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m1599d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTCircleConsumer;", "", "<init>", "()V", "mTargetView", "Landroid/view/View;", "mCenter", "Landroid/graphics/PointF;", "mRadius", "", "mStroke", "", "mParent", "Landroid/view/ViewParent;", "close", "", "setView", "view", "radius", "stroke", "setViewParent", "parent", "mOnConsumedTouchListener", "Landroid/view/View$OnTouchListener;", "mOnConsumedHoverListener", "Landroid/view/View$OnHoverListener;", "isConsumed", "", "x", "y", "initCenter", "isInnerTouch", "Companion", "SDK_debug"}, m1600k = 1, m1601mv = {2, 0, 0}, m1603xi = 48)
public final class SpenQTCircleConsumer {
    private static final String TAG = "SpenQTCircleCenter";
    private ViewParent mParent;
    private float mRadius;
    private int mStroke;
    private View mTargetView;
    private PointF mCenter = new PointF();
    private final View.OnTouchListener mOnConsumedTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTCircleConsumer$$ExternalSyntheticLambda0
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return SpenQTCircleConsumer.mOnConsumedTouchListener$lambda$0(this.f$0, view, motionEvent);
        }
    };
    private final View.OnHoverListener mOnConsumedHoverListener = new View.OnHoverListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenQTCircleConsumer$$ExternalSyntheticLambda1
        @Override // android.view.View.OnHoverListener
        public final boolean onHover(View view, MotionEvent motionEvent) {
            return SpenQTCircleConsumer.mOnConsumedHoverListener$lambda$1(this.f$0, view, motionEvent);
        }
    };

    public final void close() {
        View view = this.mTargetView;
        if (view != null) {
            view.setOnHoverListener(null);
        }
        View view2 = this.mTargetView;
        if (view2 != null) {
            view2.setOnTouchListener(null);
        }
        this.mTargetView = null;
    }

    public final void setView(View view, float radius, int stroke) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mTargetView = view;
        this.mRadius = radius;
        this.mStroke = stroke;
        this.mCenter.set(0.0f, 0.0f);
        View view2 = this.mTargetView;
        if (view2 != null) {
            view2.setOnHoverListener(this.mOnConsumedHoverListener);
        }
        View view3 = this.mTargetView;
        if (view3 != null) {
            view3.setOnTouchListener(this.mOnConsumedTouchListener);
        }
    }

    public final void setViewParent(ViewParent parent) {
        this.mParent = parent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnConsumedTouchListener$lambda$0(SpenQTCircleConsumer spenQTCircleConsumer, View view, MotionEvent motionEvent) {
        ViewParent viewParent;
        boolean zIsConsumed = spenQTCircleConsumer.isConsumed(motionEvent.getX(), motionEvent.getY());
        if (zIsConsumed && (viewParent = spenQTCircleConsumer.mParent) != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
        }
        return zIsConsumed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mOnConsumedHoverListener$lambda$1(SpenQTCircleConsumer spenQTCircleConsumer, View view, MotionEvent motionEvent) {
        return spenQTCircleConsumer.isConsumed(motionEvent.getX(), motionEvent.getY());
    }

    private final boolean isConsumed(float x, float y) {
        if (this.mTargetView == null) {
            return false;
        }
        if (((int) this.mCenter.x) == 0 && ((int) this.mCenter.y) == 0) {
            initCenter();
        }
        return isInnerTouch(x, y);
    }

    private final void initCenter() {
        if (this.mTargetView != null) {
            this.mCenter.x = r0.getWidth() / 2.0f;
            this.mCenter.y = r0.getHeight() / 2.0f;
        }
    }

    private final boolean isInnerTouch(float x, float y) {
        return Math.sqrt(Math.pow((double) (x - this.mCenter.x), 2.0d) + Math.pow((double) (y - this.mCenter.y), 2.0d)) <= ((double) (this.mRadius + ((float) (this.mStroke / 2))));
    }
}
