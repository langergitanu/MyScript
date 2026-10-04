package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
class PositionListener implements ViewTreeObserver.OnPreDrawListener {
    private final WeakReference<View> mHostView;
    private int mNumberOfListeners;
    private int mPositionX;
    private int mPositionXOnScreen;
    private int mPositionY;
    private int mPositionYOnScreen;
    private final int MAXIMUM_NUMBER_OF_LISTENERS = 7;
    private final TextViewPositionListener[] mPositionListeners = new TextViewPositionListener[7];
    private boolean mPositionHasChanged = true;
    private final int[] mTempCoords = new int[2];

    interface TextViewPositionListener {
        void updatePosition(int i, int i2, boolean z, boolean z2);
    }

    PositionListener(View view) {
        this.mHostView = new WeakReference<>(view);
    }

    void addSubscriber(TextViewPositionListener textViewPositionListener) {
        if (this.mNumberOfListeners == 0) {
            updatePosition();
            View view = this.mHostView.get();
            if (view != null) {
                view.getViewTreeObserver().addOnPreDrawListener(this);
            }
        }
        int i = -1;
        for (int i2 = 0; i2 < 7; i2++) {
            TextViewPositionListener textViewPositionListener2 = this.mPositionListeners[i2];
            if (textViewPositionListener2 == textViewPositionListener) {
                return;
            }
            if (i < 0 && textViewPositionListener2 == null) {
                i = i2;
            }
        }
        this.mPositionListeners[i] = textViewPositionListener;
        this.mNumberOfListeners++;
    }

    void removeSubscriber(TextViewPositionListener textViewPositionListener) {
        View view;
        int i = 0;
        while (true) {
            if (i >= 7) {
                break;
            }
            TextViewPositionListener[] textViewPositionListenerArr = this.mPositionListeners;
            if (textViewPositionListenerArr[i] == textViewPositionListener) {
                textViewPositionListenerArr[i] = null;
                this.mNumberOfListeners--;
                break;
            }
            i++;
        }
        if (this.mNumberOfListeners != 0 || (view = this.mHostView.get()) == null) {
            return;
        }
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }

    int getPositionX() {
        return this.mPositionX;
    }

    int getPositionY() {
        return this.mPositionY;
    }

    int getPositionXOnScreen() {
        return this.mPositionXOnScreen;
    }

    int getPositionYOnScreen() {
        return this.mPositionYOnScreen;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        updatePosition();
        for (int i = 0; i < 7; i++) {
            TextViewPositionListener textViewPositionListener = this.mPositionListeners[i];
            if (textViewPositionListener != null) {
                textViewPositionListener.updatePosition(this.mPositionX, this.mPositionY, this.mPositionHasChanged, false);
            }
        }
        return true;
    }

    private void updatePosition() {
        View view = this.mHostView.get();
        if (view != null) {
            view.getLocationInWindow(this.mTempCoords);
            int[] iArr = this.mTempCoords;
            int i = iArr[0];
            this.mPositionHasChanged = (i == this.mPositionX && iArr[1] == this.mPositionY) ? false : true;
            this.mPositionX = i;
            this.mPositionY = iArr[1];
            view.getLocationOnScreen(iArr);
            int[] iArr2 = this.mTempCoords;
            this.mPositionXOnScreen = iArr2[0];
            this.mPositionYOnScreen = iArr2[1];
        }
    }
}
