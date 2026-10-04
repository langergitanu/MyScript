package com.myscript.nebo.penpanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.myscript.android.utils.DarkModeUtils;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.PointerType;
import com.myscript.atk.core.p020ui.AndroidStroker;
import com.myscript.nebo.common.CommonUtils;

/* JADX INFO: loaded from: classes7.dex */
public class InkTestView extends View {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float DEFAULT_INK_WIDTH_MM = 0.7f;
    private Path androidRenderingPath;
    private ViewPropertyAnimator animator;
    private CountDownTimer countDownTimer;
    private PointerInfo currentPoint;
    private com.myscript.atk.core.Path currentStrokePath;
    private Bitmap dryInkBitmap;
    private Canvas dryInkCanvas;
    private int lastPointerIndex;
    private boolean mIsCapacitivePenModeEnabled;
    private OnPenDetectedListener mPenDetectedListener;
    private WritingListener mWritingListener;
    private AndroidStroker stroker;
    private Paint style;

    public interface OnPenDetectedListener {
        void onPenDetected();
    }

    public interface WritingListener {
        void onWritingStarted();

        void onWritingStopped();
    }

    public InkTestView(Context context) {
        super(context);
        this.lastPointerIndex = -1;
        init();
    }

    public InkTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastPointerIndex = -1;
        init();
    }

    public InkTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastPointerIndex = -1;
        init();
    }

    public InkTestView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.lastPointerIndex = -1;
        init();
    }

    private void init() {
        if (isInEditMode()) {
            return;
        }
        Paint paint = new Paint(1);
        this.style = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.style.setStrokeJoin(Paint.Join.ROUND);
        this.currentPoint = new PointerInfo(0.0f, 0.0f, 0L, 0.0f, PointerType.PEN);
        this.currentStrokePath = new com.myscript.atk.core.Path();
        this.androidRenderingPath = new Path();
        String string = getResources().getString(C6693R.string.default_pen_brush);
        this.stroker = new AndroidStroker(0.0f, AndroidStroker.getStroking(string));
        setInkBrush(string);
        setInkWidthMM(0.7f);
        setInkColor(DarkModeUtils.isDarkMode(this) ? -1 : -16777216);
        this.mIsCapacitivePenModeEnabled = !CommonUtils.isActivePenMode(getContext());
    }

    public void setInkWidth(float f) {
        this.stroker.setWidth(f);
        this.style.setStrokeWidth(f);
    }

    public void setInkWidthMM(float f) {
        setInkWidth(TypedValue.applyDimension(5, f, ScreenUtils.getFixedDisplayMetrics(getContext())));
    }

    public void setInkColor(int i) {
        this.style.setColor(i);
    }

    public void setInkBrush(String str) {
        setInkStroking(AndroidStroker.getStroking(str));
    }

    public void setInkStroking(int i) {
        this.stroker.setStroking(i);
        this.style.setStyle(AndroidStroker.isFill(i) ? Paint.Style.FILL : Paint.Style.STROKE);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        resetDryInkBitmap(i, i2);
    }

    private void resetDryInkBitmap(int i, int i2) {
        destroy();
        this.dryInkCanvas = new Canvas();
        if (i <= 0 || i2 <= 0) {
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.dryInkBitmap = bitmapCreateBitmap;
        this.dryInkCanvas.setBitmap(bitmapCreateBitmap);
    }

    public void destroy() {
        Bitmap bitmap = this.dryInkBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        if (isInEditMode() || (bitmap = this.dryInkBitmap) == null) {
            return;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        com.myscript.atk.core.Path path = this.currentStrokePath;
        if (path == null || path.empty()) {
            return;
        }
        this.stroker.stroke(this.currentStrokePath, this.androidRenderingPath);
        canvas.drawPath(this.androidRenderingPath, this.style);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        boolean zIsStylus = isStylus(motionEvent);
        if (!zIsStylus && !this.mIsCapacitivePenModeEnabled) {
            return false;
        }
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (actionIndex != this.lastPointerIndex) {
                        return false;
                    }
                    int historySize = motionEvent.getHistorySize();
                    for (int i = 0; i < historySize; i++) {
                        float historicalX = motionEvent.getHistoricalX(this.lastPointerIndex, i);
                        float historicalY = motionEvent.getHistoricalY(this.lastPointerIndex, i);
                        if (Float.compare(this.currentPoint.getX(), historicalX) != 0 || Float.compare(this.currentPoint.getY(), historicalY) != 0) {
                            this.currentPoint.setX(historicalX);
                            this.currentPoint.setY(historicalY);
                            this.currentPoint.setF(motionEvent.getPressure(actionIndex));
                            this.currentPoint.setT(motionEvent.getHistoricalEventTime(i));
                            this.currentStrokePath.lineTo(this.currentPoint);
                        }
                    }
                    if (Float.compare(this.currentPoint.getX(), x) != 0 || Float.compare(this.currentPoint.getY(), y) != 0) {
                        this.currentPoint.setX(x);
                        this.currentPoint.setY(y);
                        this.currentPoint.setF(motionEvent.getPressure(actionIndex));
                        this.currentPoint.setT(motionEvent.getEventTime());
                        this.currentStrokePath.lineTo(this.currentPoint);
                    }
                    invalidate();
                    return true;
                }
                if (actionMasked == 3) {
                    resetTimerAndAnimation();
                    if (isStylusButtonPressed(motionEvent)) {
                        this.currentStrokePath.clear();
                        this.lastPointerIndex = -1;
                        invalidate();
                        return true;
                    }
                } else if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return false;
                    }
                }
            }
            if (motionEvent.getActionIndex() != this.lastPointerIndex) {
                return false;
            }
            if (Float.compare(this.currentPoint.getX(), x) != 0 || Float.compare(this.currentPoint.getY(), y) != 0) {
                this.currentPoint.setX(x);
                this.currentPoint.setY(y);
                this.currentPoint.setF(motionEvent.getPressure(actionIndex));
                this.currentPoint.setT(motionEvent.getEventTime());
                this.currentStrokePath.endTo(this.currentPoint);
            }
            this.stroker.stroke(this.currentStrokePath, this.androidRenderingPath);
            this.dryInkCanvas.drawPath(this.androidRenderingPath, this.style);
            this.currentStrokePath.clear();
            invalidate();
            startFadingCountDown();
            OnPenDetectedListener onPenDetectedListener = this.mPenDetectedListener;
            if (onPenDetectedListener != null) {
                onPenDetectedListener.onPenDetected();
            }
            this.lastPointerIndex = -1;
            getParent().requestDisallowInterceptTouchEvent(false);
            WritingListener writingListener = this.mWritingListener;
            if (writingListener != null) {
                writingListener.onWritingStopped();
            }
            return true;
        }
        if (zIsStylus && this.mIsCapacitivePenModeEnabled) {
            updateActivePenAndCapacitivePen();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        resetTimerAndAnimation();
        if (this.lastPointerIndex != -1) {
            return false;
        }
        this.lastPointerIndex = motionEvent.getActionIndex();
        this.androidRenderingPath.reset();
        this.currentPoint.setX(x);
        this.currentPoint.setY(y);
        this.currentPoint.setF(motionEvent.getPressure(actionIndex));
        this.currentPoint.setT(motionEvent.getEventTime());
        this.currentStrokePath.clear();
        this.currentStrokePath.startAt(this.currentPoint);
        invalidate();
        WritingListener writingListener2 = this.mWritingListener;
        if (writingListener2 != null) {
            writingListener2.onWritingStarted();
        }
        return true;
    }

    private void updateActivePenAndCapacitivePen() {
        CommonUtils.saveActivePenMode(getContext(), true);
        CommonUtils.savePenUsed(getContext(), true);
        this.mIsCapacitivePenModeEnabled = false;
    }

    private void resetTimerAndAnimation() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        ViewPropertyAnimator viewPropertyAnimator = this.animator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            resetDryInkBitmap(getWidth(), getHeight());
            setAlpha(1.0f);
            this.animator = null;
        }
    }

    private void startFadingCountDown() {
        this.countDownTimer = getCountDownTimer().start();
    }

    private CountDownTimer getCountDownTimer() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            return countDownTimer;
        }
        long integer = getResources().getInteger(C6693R.integer.delay_before_fading_strokes_in_millis);
        return new CountDownTimer(integer, integer) { // from class: com.myscript.nebo.penpanel.InkTestView.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                InkTestView.this.fade();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fade() {
        Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(getContext(), 17563662);
        ViewPropertyAnimator viewPropertyAnimatorAnimate = animate();
        this.animator = viewPropertyAnimatorAnimate;
        viewPropertyAnimatorAnimate.alpha(0.0f).setInterpolator(interpolatorLoadInterpolator).setDuration(getResources().getInteger(C6693R.integer.ink_testview_fading_duration)).start();
    }

    private boolean isStylus(MotionEvent motionEvent) {
        return motionEvent.getToolType(motionEvent.getActionIndex()) == 2;
    }

    private boolean isStylusButtonPressed(MotionEvent motionEvent) {
        return (motionEvent.getButtonState() & 102) != 0;
    }

    public void setOnPenDetectedListener(OnPenDetectedListener onPenDetectedListener) {
        this.mPenDetectedListener = onPenDetectedListener;
    }

    public void setCapacitiveInputAllowed(boolean z) {
        this.mIsCapacitivePenModeEnabled = z;
    }

    public void setWritingListener(WritingListener writingListener) {
        this.mWritingListener = writingListener;
    }

    public void reset() {
        resetTimerAndAnimation();
        resetDryInkBitmap(getWidth(), getHeight());
    }
}
