package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class CursorsView extends View {
    private static final int BLINK = 500;
    private static final boolean DBG = false;
    private static final String TAG = "CursorsView";
    private final Runnable mBlinkRunnable;
    private Drawable mCursorDrawable;
    private WeakReference<SelectionCursorManager> mCursorManagerRef;
    private boolean mCursorVisible;
    private final Handler mHandler;
    private Paint mPainterDebug;
    private boolean mReleased;

    public CursorsView(Context context) {
        this(context, null, 0, 0);
    }

    public CursorsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public CursorsView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public CursorsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mCursorVisible = false;
        this.mReleased = false;
        this.mCursorManagerRef = new WeakReference<>(null);
        this.mPainterDebug = new Paint(1);
        if (attributeSet != null) {
            Resources.Theme theme = context.getTheme();
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(R.attr.textCursorDrawable, typedValue, true);
            this.mCursorDrawable = ResourcesCompat.getDrawable(context.getResources(), typedValue.resourceId, theme);
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mBlinkRunnable = new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.CursorsView.1
            @Override // java.lang.Runnable
            public void run() {
                CursorsView.this.mCursorVisible = !r0.mCursorVisible;
                CursorsView.this.postInvalidate();
                synchronized (CursorsView.this.mHandler) {
                    if (!CursorsView.this.mReleased) {
                        CursorsView.this.mHandler.postDelayed(CursorsView.this.mBlinkRunnable, 500L);
                    } else {
                        CursorsView.this.mHandler.removeCallbacksAndMessages(null);
                    }
                }
            }
        };
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF cursorRegion;
        super.onDraw(canvas);
        SelectionCursorManager selectionCursorManager = this.mCursorManagerRef.get();
        if (!this.mCursorVisible || selectionCursorManager == null || (cursorRegion = selectionCursorManager.getCursorRegion()) == null) {
            return;
        }
        canvas.save();
        this.mCursorDrawable.setBounds(Math.round(cursorRegion.left), Math.round(cursorRegion.top), Math.round(cursorRegion.right), Math.round(cursorRegion.bottom));
        this.mCursorDrawable.draw(canvas);
        canvas.restore();
    }

    public void setCursorManager(SelectionCursorManager selectionCursorManager) {
        this.mCursorManagerRef = new WeakReference<>(selectionCursorManager);
    }

    public void hideCursor() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mCursorVisible = false;
        invalidate();
    }

    public void showCursor(boolean z) {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mCursorVisible = true;
        synchronized (this.mHandler) {
            if (z) {
                if (!this.mReleased) {
                    this.mHandler.postDelayed(this.mBlinkRunnable, 500L);
                }
                invalidate();
            } else {
                invalidate();
            }
        }
    }

    public void release() {
        synchronized (this.mHandler) {
            this.mReleased = true;
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
