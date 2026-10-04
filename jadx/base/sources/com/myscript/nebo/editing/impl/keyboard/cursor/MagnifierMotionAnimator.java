package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Build;
import android.view.animation.LinearInterpolator;
import android.widget.Magnifier;

/* JADX INFO: loaded from: classes7.dex */
class MagnifierMotionAnimator {
    private static final long DURATION = 100;
    private float mAnimationCurrentX;
    private float mAnimationCurrentY;
    private float mAnimationStartX;
    private float mAnimationStartY;
    private final ValueAnimator mAnimator;
    private float mLastX;
    private float mLastY;
    private final Magnifier mMagnifier;
    private boolean mMagnifierIsShowing;
    private final SelectionCursorManager mSelectionCursorManager;

    MagnifierMotionAnimator(Magnifier magnifier, SelectionCursorManager selectionCursorManager) {
        this.mMagnifier = magnifier;
        this.mSelectionCursorManager = selectionCursorManager;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(DURATION);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.MagnifierMotionAnimator$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.lambda$new$0(valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ValueAnimator valueAnimator) {
        float f = this.mAnimationStartX;
        this.mAnimationCurrentX = f + ((this.mLastX - f) * valueAnimator.getAnimatedFraction());
        float f2 = this.mAnimationStartY;
        this.mAnimationCurrentY = f2 + ((this.mLastY - f2) * valueAnimator.getAnimatedFraction());
        SelectionCursorManager selectionCursorManager = this.mSelectionCursorManager;
        if (selectionCursorManager != null && selectionCursorManager.isScrollingUsingHandle()) {
            this.mMagnifier.dismiss();
        } else {
            this.mMagnifier.show(this.mAnimationCurrentX, this.mAnimationCurrentY);
        }
    }

    void show(float f, float f2) {
        if (this.mMagnifierIsShowing && f2 != this.mLastY) {
            if (this.mAnimator.isRunning()) {
                this.mAnimator.cancel();
                this.mAnimationStartX = this.mAnimationCurrentX;
                this.mAnimationStartY = this.mAnimationCurrentY;
            } else {
                this.mAnimationStartX = this.mLastX;
                this.mAnimationStartY = this.mLastY;
            }
            this.mAnimator.start();
        } else if (!this.mAnimator.isRunning() && Build.VERSION.SDK_INT >= 28) {
            this.mMagnifier.show(f, f2);
        }
        this.mLastX = f;
        this.mLastY = f2;
        this.mMagnifierIsShowing = true;
    }

    void update() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mMagnifier.update();
        }
    }

    void dismiss() {
        this.mMagnifier.dismiss();
        this.mAnimator.cancel();
        this.mMagnifierIsShowing = false;
    }

    PointF getLastPosition() {
        if (this.mMagnifier == null || !this.mMagnifierIsShowing) {
            return null;
        }
        return new PointF(this.mLastX, this.mLastY);
    }

    public Boolean isShowing() {
        return Boolean.valueOf(this.mMagnifierIsShowing);
    }

    Magnifier getMagnifier() {
        return this.mMagnifier;
    }
}
