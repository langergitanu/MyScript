package com.myscript.nebo.editing.impl.p027ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import com.myscript.android.utils.MotionEventSPenExt;
import com.myscript.atk.core.ButtonType;
import com.myscript.atk.core.EngineError;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.PointerType;
import com.myscript.atk.core.ViewTransform;
import com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector;
import com.myscript.nebo.editing.controller.gesture.ScaleGestureDetector;
import com.myscript.nebo.editing.controller.gesture.TouchGestureDetector;
import com.myscript.nebo.editing.controller.palmrejection.IPalmRejectionPolicy;
import com.myscript.nebo.editing.controller.palmrejection.PalmRejectionFactory;
import com.myscript.nebo.editing.impl.keyboard.cursor.IDragHandleProvider;
import com.myscript.nebo.editing.impl.p027ui.ScaleGestureDetectorListener;
import com.myscript.snt.core.IAutoScrollListener;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.ScrollBarBehavior;
import com.myscript.snt.core.ToolType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentTouchController implements IInputHandler, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener, IDragHandleProvider, ITouchFeature, ScaleGestureDetectorListener.CanvasContextInfo {
    private static final long ANIMATOR_FRAME_DELAY = 16;
    private static final boolean DBG = false;
    private static final int DISABLE_HORIZONTAL_SCROLL_WHEN_PAGE_FITS_MAX_MARGIN_RATIO = 20;
    private static final int DISABLE_HORIZONTAL_SCROLL_WHEN_PAGE_FITS_MIN_MARGIN = 10;
    private static final long ON_DRAG_SCROLL_ANIM_SPEED_FACTOR = 5;
    private static final float OVER_EDGE_RATIO = 0.05f;
    private static final int RESIZE_MINIMUM__EDGE_RATIO = 10;
    private static final int SCROLL_MAX_DURATION = 500;
    private static final float SCROLL_ON_DRAG_SIZE_MM = 15.0f;
    private static final int SCROLL_OUTSIDE_LIMITS_RATIO = 8;
    private static final long SCROLL_TO_ANIMATION_DURATION = 350;
    private static final float SWIPE_VELOCITY_THRESHOLD = 600.0f;
    private static final String TAG = "DocumentTouchController";
    private static final long ZOOM_ANIMATION_DURATION = 200;
    private static final float ZOOM_MAX_DEFAULT_VALUE = 2.0f;
    private static final float ZOOM_MIN_DEFAULT_VALUE = 0.5f;
    private ContentResolver mApplicationContentResolver;
    private final IAutoScrollListener mAutoScrollListener;
    private Animator mCurrentScrollAnimator;
    private final Uri mDeviceAnimationDurationScaleUri;
    private boolean mDeviceAnimationsEnabled;
    private AnimatorSet mDragAnimator;
    private DualTouchGestureDetector mDualTouchGestureDetector;
    private boolean mEnableAddSpaceForKeyboard;
    private final long mEventTimeOffset;
    private final ValueAnimator mFlingAnimator;
    private TouchGestureDetector mGestureDetector;
    private int mHeight;
    private final ValueAnimator mHorizontalAdjustmentAnimator;
    private final ValueAnimator mHorizontalDragAnimator;
    private float mHorizontalScrollLimitPxMax;
    private float mHorizontalScrollLimitPxMin;
    private final ValueAnimator mHorizontalScrollToAnimator;
    private float mKeyboardAddedSpace;
    private int mOverallHorizontalScrollPx;
    private int mOverallVerticalScrollPx;
    private PageController mPageController;
    private final IPalmRejectionPolicy mPalmRejectionPolicy;
    private ExecutorService mPenExecutor;
    private int mPointerStartX;
    private int mPointerStartY;
    private ScaleGestureDetector mScaleGestureDetector;
    private final ScaleGestureDetectorListener mScaleGestureDetectorListener;
    private int mScrollOnDragEdgeXSizePx;
    private int mScrollOnDragEdgeYSizePx;
    private AnimatorSet mScrollToAdjustmentAnimator;
    private AnimatorSet mScrollToAnimator;
    private final OverScroller mScroller;
    private int mScrollerOverEdgeX;
    private int mScrollerOverEdgeY;
    private DualTouchGestureDetector mSpaceManagementDetector;
    private boolean mSwipeEnabled;
    private final ValueAnimator mVerticalAdjustmentAnimator;
    private final ValueAnimator mVerticalDragAnimator;
    private float mVerticalScrollLimitPxMax;
    private float mVerticalScrollLimitPxMin;
    private final ValueAnimator mVerticalScrollToAnimator;
    private ViewTransform mViewTransform;
    private int mWidth;
    private AnimatorSet mZoomAdjustmentAnimator;
    private ZoomListener.ZoomFromReference mZoomAdjustmentReference;
    private float mZoomAtFling;
    private final ValueAnimator mZoomValueAnimator;
    private final List<GestureListener> mGestureListeners = new ArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Extent mPaperExtent = null;
    private final List<WeakReference<ScrollListener>> mScrollListenerRefs = new ArrayList();
    private boolean mIsHorizontalScrolling = false;
    private boolean mIsVerticalScrolling = false;
    private boolean mIsScrollEnabled = false;
    private boolean mIsAutoScrollEnabled = false;
    private boolean mIsHorizontalScrollDisabled = false;
    private boolean mCenterWhenPageWidthFitsScreen = false;
    private ContentObserver mApplicationContentObserver = new ContentObserver(new Handler()) { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController.1
        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            DocumentTouchController documentTouchController = DocumentTouchController.this;
            documentTouchController.mDeviceAnimationsEnabled = documentTouchController.deviceAnimationsEnabled();
        }
    };

    public interface GestureListener {
        void onDoubleTap(MotionEvent motionEvent);

        void onLongPress(MotionEvent motionEvent);

        void onLongPressPost(MotionEvent motionEvent);

        void onLongPressPre(MotionEvent motionEvent);

        void onSingleTapConfirmed(PointerInfo pointerInfo);

        void onSingleTapConfirmedPre(PointerInfo pointerInfo);

        void onSingleTapUp(MotionEvent motionEvent);
    }

    public interface ScrollListener {
        void onHorizontalScrollDisabledChanged(boolean z);

        void onScrollEnd(int i, int i2);

        void onScrollTo(int i, int i2);
    }

    public interface ZoomListener {

        public enum ZoomFromReference {
            ZOOM_FROM_TOP_LEFT,
            ZOOM_FROM_TOP_CENTER,
            ZOOM_FROM_TOP_RIGHT,
            ZOOM_FROM_CENTER_LEFT,
            ZOOM_FROM_CENTER,
            ZOOM_FROM_CENTER_RIGHT,
            ZOOM_FROM_BOTTOM_LEFT,
            ZOOM_FROM_BOTTOM_CENTER,
            ZOOM_FROM_BOTTOM_RIGHT
        }

        void onZoom(float f, float f2, float f3, boolean z);

        void onZoom(float f, ZoomFromReference zoomFromReference, boolean z);

        void onZoomAt(int i, int i2, float f, boolean z);

        void onZoomEnded();

        void onZoomStarted();
    }

    public float checkOverallHorizontalScrollPx(float f, float f2, float f3, float f4) {
        float f5 = f3 * f2;
        float f6 = f2 * f4;
        if (f < f5) {
            f = f5;
        }
        return f > f6 ? f6 : f;
    }

    public float checkOverallVerticalScrollPx(float f, float f2, float f3, float f4) {
        float f5 = f3 * f2;
        float f6 = f2 * f4;
        if (f < f5) {
            f = f5;
        }
        return f > f6 ? f6 : f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    private void runPenEvent(boolean z, Runnable runnable) {
        if (z) {
            runnable.run();
        } else {
            this.mPenExecutor.submit(runnable);
        }
    }

    public DocumentTouchController(Context context) {
        Uri uriFor = Settings.System.getUriFor("animator_duration_scale");
        this.mDeviceAnimationDurationScaleUri = uriFor;
        this.mDeviceAnimationsEnabled = true;
        this.mHorizontalScrollLimitPxMin = 0.0f;
        this.mHorizontalScrollLimitPxMax = 0.0f;
        this.mVerticalScrollLimitPxMin = 0.0f;
        this.mVerticalScrollLimitPxMax = 0.0f;
        this.mEnableAddSpaceForKeyboard = false;
        this.mKeyboardAddedSpace = 0.0f;
        this.mOverallHorizontalScrollPx = 0;
        this.mOverallVerticalScrollPx = 0;
        this.mSwipeEnabled = true;
        this.mScrollerOverEdgeX = 0;
        this.mScrollerOverEdgeY = 0;
        this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER;
        this.mAutoScrollListener = new IAutoScrollListener() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController.2
            @Override // com.myscript.snt.core.IAutoScrollListener
            public void enableAutoScroll() {
                DocumentTouchController.this.mIsAutoScrollEnabled = true;
            }

            @Override // com.myscript.snt.core.IAutoScrollListener
            public void disableAutoScroll() {
                DocumentTouchController.this.mIsAutoScrollEnabled = false;
                DocumentTouchController.this.cancelAnyScroll();
            }
        };
        this.mEventTimeOffset = System.currentTimeMillis() - SystemClock.uptimeMillis();
        this.mGestureDetector = new TouchGestureDetector(context, this, this);
        this.mDualTouchGestureDetector = new DualTouchGestureDetector(context, getDualTouchGestureListener());
        this.mSpaceManagementDetector = new DualTouchGestureDetector(context, getSpaceManageManagementListener());
        ScaleGestureDetectorListener scaleGestureDetectorListener = new ScaleGestureDetectorListener(this);
        this.mScaleGestureDetectorListener = scaleGestureDetectorListener;
        this.mScaleGestureDetector = new ScaleGestureDetector(context, scaleGestureDetectorListener);
        this.mScroller = new OverScroller(context, null, 0.0f, 0.0f, true);
        ValueAnimator.setFrameDelay(16L);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mFlingAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(this);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mOverallHorizontalScrollPx, 0);
        this.mHorizontalDragAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(this);
        valueAnimatorOfInt.addListener(this);
        valueAnimatorOfInt.setRepeatCount(0);
        valueAnimatorOfInt.setStartDelay(0L);
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(this.mOverallVerticalScrollPx, 0);
        this.mVerticalDragAnimator = valueAnimatorOfInt2;
        valueAnimatorOfInt2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt2.addUpdateListener(this);
        valueAnimatorOfInt2.addListener(this);
        valueAnimatorOfInt2.setRepeatCount(0);
        valueAnimatorOfInt2.setStartDelay(0L);
        this.mDragAnimator = new AnimatorSet();
        ValueAnimator valueAnimatorOfInt3 = ValueAnimator.ofInt(this.mOverallHorizontalScrollPx, 0);
        this.mHorizontalScrollToAnimator = valueAnimatorOfInt3;
        valueAnimatorOfInt3.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt3.addUpdateListener(this);
        valueAnimatorOfInt3.addListener(this);
        valueAnimatorOfInt3.setRepeatCount(0);
        valueAnimatorOfInt3.setStartDelay(0L);
        ValueAnimator valueAnimatorOfInt4 = ValueAnimator.ofInt(this.mOverallVerticalScrollPx, 0);
        this.mVerticalScrollToAnimator = valueAnimatorOfInt4;
        valueAnimatorOfInt4.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt4.addUpdateListener(this);
        valueAnimatorOfInt4.addListener(this);
        valueAnimatorOfInt4.setRepeatCount(0);
        valueAnimatorOfInt4.setStartDelay(0L);
        this.mScrollToAnimator = new AnimatorSet();
        ValueAnimator valueAnimatorOfInt5 = ValueAnimator.ofInt(this.mOverallHorizontalScrollPx, 0);
        this.mHorizontalAdjustmentAnimator = valueAnimatorOfInt5;
        valueAnimatorOfInt5.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt5.addUpdateListener(this);
        valueAnimatorOfInt5.addListener(this);
        valueAnimatorOfInt5.setRepeatCount(0);
        valueAnimatorOfInt5.setStartDelay(0L);
        ValueAnimator valueAnimatorOfInt6 = ValueAnimator.ofInt(this.mOverallVerticalScrollPx, 0);
        this.mVerticalAdjustmentAnimator = valueAnimatorOfInt6;
        valueAnimatorOfInt6.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt6.addUpdateListener(this);
        valueAnimatorOfInt6.addListener(this);
        valueAnimatorOfInt6.setRepeatCount(0);
        valueAnimatorOfInt6.setStartDelay(0L);
        this.mScrollToAdjustmentAnimator = new AnimatorSet();
        this.mPalmRejectionPolicy = PalmRejectionFactory.getInstance(this);
        this.mZoomAdjustmentAnimator = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.mZoomValueAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(this);
        valueAnimatorOfFloat2.addListener(this);
        valueAnimatorOfFloat2.setRepeatCount(0);
        valueAnimatorOfFloat2.setStartDelay(0L);
        if (uriFor != null) {
            ContentResolver contentResolver = context.getApplicationContext().getContentResolver();
            this.mApplicationContentResolver = contentResolver;
            contentResolver.registerContentObserver(uriFor, false, this.mApplicationContentObserver);
            this.mDeviceAnimationsEnabled = deviceAnimationsEnabled();
        }
        this.mPenExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return DocumentTouchController.lambda$new$1(runnable);
            }
        });
    }

    static /* synthetic */ Thread lambda$new$1(final Runnable runnable) {
        return new Thread(new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                DocumentTouchController.lambda$new$0(runnable);
            }
        }, "PenEventThread");
    }

    static /* synthetic */ void lambda$new$0(Runnable runnable) {
        try {
            Process.setThreadPriority(-4);
        } catch (Throwable th) {
            Log.w(TAG, "Cannot set thread priority", th);
        }
        runnable.run();
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public void addGestureListener(GestureListener gestureListener) {
        this.mGestureListeners.add(gestureListener);
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public void removeGestureListener(GestureListener gestureListener) {
        this.mGestureListeners.remove(gestureListener);
    }

    public void configureRendering(PageController pageController, ViewTransform viewTransform) {
        this.mPageController = PageController.newRef(pageController);
        this.mViewTransform = ViewTransform.newRef(viewTransform);
        this.mOverallHorizontalScrollPx = 0;
        this.mOverallVerticalScrollPx = 0;
        this.mScrollOnDragEdgeXSizePx = xMmToPx(SCROLL_ON_DRAG_SIZE_MM);
        this.mScrollOnDragEdgeYSizePx = yMmToPx(SCROLL_ON_DRAG_SIZE_MM);
        PageController pageController2 = this.mPageController;
        if (pageController2 != null) {
            pageController2.setAutoScrollListener(this.mAutoScrollListener);
        }
    }

    public boolean isWriting() {
        PageController pageController = this.mPageController;
        if (pageController != null) {
            return pageController.isWriting();
        }
        return false;
    }

    public void resetRendering() {
        PageController pageController = this.mPageController;
        if (pageController != null) {
            pageController.delete();
            this.mPageController = null;
        }
        ViewTransform viewTransform = this.mViewTransform;
        if (viewTransform != null) {
            viewTransform.delete();
            this.mViewTransform = null;
        }
        this.mOverallHorizontalScrollPx = 0;
        this.mOverallVerticalScrollPx = 0;
    }

    public void release() {
        ContentResolver contentResolver;
        cleanUpZoomListener();
        cleanUpScrollListener();
        resetRendering();
        this.mGestureDetector = null;
        this.mDualTouchGestureDetector = null;
        this.mSpaceManagementDetector = null;
        this.mScaleGestureDetector = null;
        ContentObserver contentObserver = this.mApplicationContentObserver;
        if (contentObserver != null && (contentResolver = this.mApplicationContentResolver) != null) {
            contentResolver.unregisterContentObserver(contentObserver);
        }
        this.mApplicationContentObserver = null;
        this.mApplicationContentResolver = null;
        ExecutorService executorService = this.mPenExecutor;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mPenExecutor = null;
        }
    }

    private int xMmToPx(float f) {
        ViewTransform viewTransform = this.mViewTransform;
        if (viewTransform != null) {
            return Math.round(f / viewTransform.scaleX());
        }
        return 0;
    }

    private int yMmToPx(float f) {
        ViewTransform viewTransform = this.mViewTransform;
        if (viewTransform != null) {
            return Math.round(f / viewTransform.scaleY());
        }
        return 0;
    }

    private float xPxToMm(int i) {
        ViewTransform viewTransform = this.mViewTransform;
        if (viewTransform != null) {
            return viewTransform.scaleX() * i;
        }
        return 0.0f;
    }

    private float yPxToMm(int i) {
        ViewTransform viewTransform = this.mViewTransform;
        if (viewTransform != null) {
            return viewTransform.scaleY() * i;
        }
        return 0.0f;
    }

    public void setSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mScrollerOverEdgeX = (int) (i * OVER_EDGE_RATIO);
        this.mScrollerOverEdgeY = (int) (i2 * OVER_EDGE_RATIO);
    }

    public void setPaperSize(Extent extent) {
        this.mPaperExtent = extent;
    }

    public void setScrollsSettings(float f, float f2, float f3, float f4, int i, int i2, float f5, boolean z) {
        float zoom = getZoom();
        this.mHorizontalScrollLimitPxMin = f / zoom;
        this.mHorizontalScrollLimitPxMax = f2 / zoom;
        this.mVerticalScrollLimitPxMin = f3 / zoom;
        this.mVerticalScrollLimitPxMax = f4 / zoom;
        if (z) {
            animateScrollTo(i, i2);
        } else {
            setScrollsPositions(i, i2, f5, false);
        }
        checkPageFitsWidth();
    }

    public void setScrollsPositions(int i, int i2, float f, boolean z) {
        Iterator<ZoomListener> it = getZoomListeners().iterator();
        while (it.hasNext()) {
            it.next().onZoomAt(i, i2, f, z);
        }
        this.mOverallHorizontalScrollPx = toHorizontalScrollRange(i);
        this.mOverallVerticalScrollPx = toVerticalScrollRange(i2);
    }

    @Override // com.myscript.nebo.editing.impl.ui.ScaleGestureDetectorListener.CanvasContextInfo
    public int getScreenWidth() {
        return this.mWidth;
    }

    @Override // com.myscript.nebo.editing.impl.ui.ScaleGestureDetectorListener.CanvasContextInfo
    public int getScreenHeight() {
        return this.mHeight;
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public Rect getScreenVisibleArea() {
        PointF viewportTopLeft = getViewportTopLeft();
        return new Rect(Math.round(viewportTopLeft.x), Math.round(viewportTopLeft.y), Math.round(viewportTopLeft.x + getScreenWidth()), Math.round(viewportTopLeft.y + getScreenHeight()));
    }

    @Override // com.myscript.nebo.editing.impl.ui.ScaleGestureDetectorListener.CanvasContextInfo
    public int getHorizontalScrollLimit() {
        return Math.max(0, Math.round(((-getScaledHorizontalScrollLimitPxMin()) + getScaledHorizontalScrollLimitPxMax()) - this.mWidth));
    }

    @Override // com.myscript.nebo.editing.impl.ui.ScaleGestureDetectorListener.CanvasContextInfo
    public int getVerticalScrollLimit() {
        return Math.max(0, Math.round((getScaledVerticalScrollLimitPxMax() - getScaledVerticalScrollLimitPxMin()) - this.mHeight));
    }

    @Override // com.myscript.nebo.editing.impl.ui.ScaleGestureDetectorListener.CanvasContextInfo
    public PointF getViewportTopLeft() {
        return new PointF(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx), fromVerticalScrollRange(this.mOverallVerticalScrollPx));
    }

    public int getHorizontalScrollLimitInViewRange() {
        return Math.round((-getScaledHorizontalScrollLimitPxMin()) + getScaledHorizontalScrollLimitPxMax());
    }

    public int getVerticalScrollLimitInViewRange() {
        return Math.round((-getScaledVerticalScrollLimitPxMin()) + getScaledVerticalScrollLimitPxMax());
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public int getHorizontalScrollPos() {
        return fromHorizontalScrollRange(this.mOverallHorizontalScrollPx);
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public int getVerticalScrollPos() {
        return fromVerticalScrollRange(this.mOverallVerticalScrollPx);
    }

    public int getOverallHorizontalScrollPx() {
        return this.mOverallHorizontalScrollPx;
    }

    public int getOverallVerticalScrollPx() {
        return this.mOverallVerticalScrollPx;
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public synchronized void addScrollListener(ScrollListener scrollListener) {
        if (scrollListener != null) {
            Iterator<WeakReference<ScrollListener>> it = this.mScrollListenerRefs.iterator();
            while (it.hasNext()) {
                ScrollListener scrollListener2 = it.next().get();
                if (scrollListener2 != null && scrollListener2 == scrollListener) {
                    return;
                }
                if (scrollListener2 == null) {
                    it.remove();
                }
            }
            this.mScrollListenerRefs.add(new WeakReference<>(scrollListener));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void removeScrollListener(ScrollListener scrollListener) {
        if (scrollListener != null) {
            Iterator<WeakReference<ScrollListener>> it = this.mScrollListenerRefs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ScrollListener scrollListener2 = it.next().get();
                if (scrollListener2 != null && scrollListener2 == scrollListener) {
                    break;
                } else if (scrollListener2 == null) {
                    it.remove();
                }
            }
        }
    }

    public synchronized void cleanUpScrollListener() {
        this.mScrollListenerRefs.clear();
    }

    private synchronized List<ScrollListener> getScrollListeners() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<WeakReference<ScrollListener>> it = this.mScrollListenerRefs.iterator();
        while (it.hasNext()) {
            ScrollListener scrollListener = it.next().get();
            if (scrollListener != null) {
                arrayList.add(scrollListener);
            } else {
                it.remove();
            }
        }
        return arrayList;
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public synchronized void addZoomListener(ZoomListener zoomListener) {
        this.mScaleGestureDetectorListener.addZoomListener(zoomListener);
    }

    public void cleanUpZoomListener() {
        this.mScaleGestureDetectorListener.cleanUpZoomListener();
    }

    private synchronized List<ZoomListener> getZoomListeners() {
        return this.mScaleGestureDetectorListener.getZoomListeners();
    }

    public boolean manageTouchEvent(MotionEvent motionEvent) {
        ScaleGestureDetector scaleGestureDetector;
        if (this.mPageController == null || this.mGestureDetector == null) {
            return false;
        }
        int actionMaskedSPen = MotionEventSPenExt.getActionMaskedSPen(motionEvent);
        handleAutoScroll((int) motionEvent.getX(), (int) motionEvent.getY());
        this.mGestureDetector.setCurrentToolType(this.mPageController.currentToolType());
        this.mGestureDetector.setActivePenMode(this.mPageController.isActivePenEnabled());
        PointerType pointerType = getPointerType(motionEvent);
        if (pointerType == PointerType.TOUCH || pointerType == PointerType.DOUBLE_TOUCH) {
            if (this.mPageController.scrollBehavior().getIsZoomAllowed() && (scaleGestureDetector = this.mScaleGestureDetector) != null) {
                scaleGestureDetector.onTouchEvent(motionEvent);
            }
            if (this.mPageController.isFingerWritingAllowed()) {
                DualTouchGestureDetector dualTouchGestureDetector = this.mDualTouchGestureDetector;
                if (dualTouchGestureDetector != null && !dualTouchGestureDetector.onTouchEvent(motionEvent)) {
                    this.mGestureDetector.onTouchEvent(motionEvent);
                } else {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    this.mGestureDetector.onTouchEvent(motionEventObtain);
                }
            } else {
                DualTouchGestureDetector dualTouchGestureDetector2 = this.mSpaceManagementDetector;
                if (dualTouchGestureDetector2 != null && !dualTouchGestureDetector2.onTouchEvent(motionEvent)) {
                    this.mGestureDetector.onTouchEvent(motionEvent);
                } else {
                    MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                    motionEventObtain2.setAction(3);
                    this.mGestureDetector.onTouchEvent(motionEventObtain2);
                }
            }
        } else if (pointerType == PointerType.MOUSE || pointerType == PointerType.PEN) {
            this.mGestureDetector.onTouchEvent(motionEvent);
        }
        boolean zOnTouchEvent = this.mPalmRejectionPolicy.onTouchEvent(motionEvent);
        if (actionMaskedSPen != 1 && actionMaskedSPen != 3) {
            return zOnTouchEvent;
        }
        if (this.mIsHorizontalScrolling || this.mIsVerticalScrolling) {
            scrollEnd();
        }
        adjustToZoomAndScrollRanges();
        return zOnTouchEvent;
    }

    public static PointerType getPointerType(MotionEvent motionEvent) {
        int toolType = motionEvent.getToolType(motionEvent.getActionIndex());
        if (toolType != 2) {
            if (toolType == 3) {
                return PointerType.MOUSE;
            }
            if (toolType != 4) {
                return motionEvent.getPointerCount() == 2 ? PointerType.DOUBLE_TOUCH : PointerType.TOUCH;
            }
        }
        return PointerType.PEN;
    }

    public static ButtonType getButtonType(MotionEvent motionEvent) {
        int actionButton = motionEvent.getActionButton();
        if (actionButton == 1) {
            return ButtonType.PRIMARY;
        }
        if (actionButton == 2) {
            return ButtonType.SECONDARY;
        }
        if (actionButton == 4) {
            return ButtonType.TERTIARY;
        }
        return ButtonType.UNDEFINED;
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.IInputHandler
    public boolean handleEvent(MotionEvent motionEvent) {
        if (this.mPageController == null) {
            return false;
        }
        int actionMaskedSPen = MotionEventSPenExt.getActionMaskedSPen(motionEvent);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float pressure = motionEvent.getPressure();
        motionEvent.getAxisValue(25);
        long eventTime = this.mEventTimeOffset + motionEvent.getEventTime();
        PointerType pointerType = getPointerType(motionEvent);
        ButtonType buttonType = getButtonType(motionEvent);
        final int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        final PointerInfo pointerInfo = new PointerInfo(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx) + x, fromVerticalScrollRange(this.mOverallVerticalScrollPx) + y, eventTime, pressure, pointerType, buttonType, pointerId);
        boolean z = actionMaskedSPen == 0 || actionMaskedSPen == 5;
        int toolType = motionEvent.getToolType(motionEvent.getActionIndex());
        boolean z2 = z && ((toolType == 2 && (motionEvent.getButtonState() & 32) != 0) || toolType == 4);
        boolean z3 = this.mPageController.currentToolType() == ToolType.Pen && !z2;
        if (actionMaskedSPen != 0) {
            if (actionMaskedSPen != 1) {
                if (actionMaskedSPen == 2) {
                    runPenEvent(z3, new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$handleEvent$3(pointerInfo);
                        }
                    });
                    return true;
                }
                if (actionMaskedSPen == 3) {
                    runPenEvent(z3, new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$handleEvent$5(pointerId);
                        }
                    });
                    return true;
                }
                if (actionMaskedSPen != 5) {
                    if (actionMaskedSPen != 6) {
                        return false;
                    }
                }
            }
            runPenEvent(z3, new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$handleEvent$4(pointerInfo);
                }
            });
            return true;
        }
        if (z2) {
            this.mPageController.setEraserStylusButton(true);
        }
        this.mPointerStartX = Math.round(x);
        this.mPointerStartY = Math.round(y);
        runPenEvent(z3, new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleEvent$2(pointerInfo);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleEvent$2(PointerInfo pointerInfo) {
        this.mPageController.penDown(pointerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleEvent$3(PointerInfo pointerInfo) {
        this.mPageController.penMove(pointerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleEvent$4(PointerInfo pointerInfo) {
        try {
            this.mPageController.penUp(pointerInfo);
        } catch (EngineError e) {
            if (e.getErrorId() != 50397184) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleEvent$5(int i) {
        this.mPageController.penAbort(i);
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.IInputHandler
    public boolean handleEventHistory(MotionEvent motionEvent) {
        final int historySize = motionEvent.getHistorySize();
        if (historySize <= 0 || this.mPageController == null) {
            return false;
        }
        final float[] fArr = new float[historySize];
        final float[] fArr2 = new float[historySize];
        final float[] fArr3 = new float[historySize];
        float[] fArr4 = new float[historySize];
        final long[] jArr = new long[historySize];
        int iFromHorizontalScrollRange = fromHorizontalScrollRange(this.mOverallHorizontalScrollPx);
        int iFromVerticalScrollRange = fromVerticalScrollRange(this.mOverallVerticalScrollPx);
        for (int i = 0; i < historySize; i++) {
            fArr[i] = motionEvent.getHistoricalX(i) + iFromHorizontalScrollRange;
            fArr2[i] = motionEvent.getHistoricalY(i) + iFromVerticalScrollRange;
            fArr3[i] = motionEvent.getHistoricalPressure(i);
            fArr4[i] = motionEvent.getHistoricalAxisValue(25, i);
            jArr[i] = this.mEventTimeOffset + motionEvent.getHistoricalEventTime(i);
        }
        final int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        final PointerType pointerType = getPointerType(motionEvent);
        final ButtonType buttonType = getButtonType(motionEvent);
        runPenEvent(this.mPageController.currentToolType() == ToolType.Pen, new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$handleEventHistory$6(historySize, fArr, fArr2, fArr3, jArr, pointerType, buttonType, pointerId);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleEventHistory$6(int i, float[] fArr, float[] fArr2, float[] fArr3, long[] jArr, PointerType pointerType, ButtonType buttonType, int i2) {
        this.mPageController.penMove(i, fArr, fArr2, fArr3, jArr, pointerType, buttonType, i2);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.mScroller.isFinished()) {
            return false;
        }
        cancelAutoScroll();
        scrollEnd();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        Iterator<GestureListener> it = this.mGestureListeners.iterator();
        while (it.hasNext()) {
            it.next().onSingleTapUp(motionEvent);
        }
        return false;
    }

    public void setSwipeEnabled(boolean z) {
        this.mSwipeEnabled = z;
    }

    private boolean canSwipeToIndent(MotionEvent motionEvent) {
        PageController pageController;
        if (this.mSwipeEnabled && (pageController = this.mPageController) != null && motionEvent.getToolType(motionEvent.getActionIndex()) != 2 && pageController.isSwipeToIndentSupported()) {
            return !pageController.isFingerWritingAllowed() || motionEvent.getPointerCount() == 2;
        }
        return false;
    }

    private boolean isHorizontalScrollEnabled(int i) {
        PageController pageController;
        ScrollBarBehavior scrollBarBehaviorScrollBehavior;
        if (this.mIsScrollEnabled && (pageController = this.mPageController) != null && (scrollBarBehaviorScrollBehavior = pageController.scrollBehavior()) != null && scrollBarBehaviorScrollBehavior.getIsHorizontalScrollAllowed()) {
            return !pageController.isFingerWritingAllowed() || i == 2;
        }
        return false;
    }

    private boolean isVerticalScrollEnabled(int i) {
        PageController pageController;
        ScrollBarBehavior scrollBarBehaviorScrollBehavior;
        if (this.mIsScrollEnabled && (pageController = this.mPageController) != null && (scrollBarBehaviorScrollBehavior = pageController.scrollBehavior()) != null && scrollBarBehaviorScrollBehavior.getIsVerticalScrollAllowed()) {
            return !pageController.isFingerWritingAllowed() || i == 2;
        }
        return false;
    }

    public float getMinZoom() {
        PageController pageController = this.mPageController;
        ScrollBarBehavior scrollBarBehaviorScrollBehavior = pageController != null ? pageController.scrollBehavior() : null;
        if (scrollBarBehaviorScrollBehavior != null) {
            return scrollBarBehaviorScrollBehavior.getMinZoom();
        }
        return 0.5f;
    }

    public float getMaxZoom() {
        PageController pageController = this.mPageController;
        ScrollBarBehavior scrollBarBehaviorScrollBehavior = pageController != null ? pageController.scrollBehavior() : null;
        if (scrollBarBehaviorScrollBehavior != null) {
            return scrollBarBehaviorScrollBehavior.getMaxZoom();
        }
        return 2.0f;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int pointerCount = motionEvent != null ? motionEvent.getPointerCount() : -1;
        if (pointerCount <= 0) {
            return false;
        }
        if (isHorizontalScrollEnabled(pointerCount) || isVerticalScrollEnabled(pointerCount)) {
            return manageUserScroll(Math.round(f), Math.round(f2), pointerCount);
        }
        return false;
    }

    public boolean onWheel(float f) {
        boolean zManageUserScroll = manageUserScroll(0, -Math.round(f), 1);
        if (zManageUserScroll) {
            scrollEnd();
            adjustToScrollRangesAnimated();
        }
        return zManageUserScroll;
    }

    private boolean manageUserScroll(int i, int i2, int i3) {
        boolean z = isHorizontalScrollEnabled(i3) && i != 0;
        boolean z2 = isVerticalScrollEnabled(i3) && i2 != 0;
        if (!z && !z2) {
            return false;
        }
        this.mIsHorizontalScrolling = z;
        this.mIsVerticalScrolling = z2;
        if (!z) {
            i = 0;
        }
        if (!z2) {
            i2 = 0;
        }
        offsetScroll(i, i2, false, true);
        return true;
    }

    private void offsetScroll(int i, int i2, boolean z, boolean z2) {
        int adjustedDistanceAtLimitMin = this.mIsHorizontalScrollDisabled ? 0 : i;
        if (z) {
            setOverallHorizontalScrollPx(this.mOverallHorizontalScrollPx + adjustedDistanceAtLimitMin);
            setOverallVerticalScrollPx(this.mOverallVerticalScrollPx + i2);
        } else {
            if (i > 0 && this.mOverallHorizontalScrollPx + i > getHorizontalScrollLimit()) {
                adjustedDistanceAtLimitMin = getAdjustedDistanceAtLimitMax(i, this.mOverallHorizontalScrollPx, getHorizontalScrollLimit());
            }
            if (i < 0) {
                int i3 = this.mOverallHorizontalScrollPx;
                if (i + i3 < 0) {
                    adjustedDistanceAtLimitMin = getAdjustedDistanceAtLimitMin(adjustedDistanceAtLimitMin, i3);
                }
            }
            int adjustedDistanceAtLimitMax = (i2 <= 0 || this.mOverallVerticalScrollPx + i2 <= getVerticalScrollLimit()) ? i2 : getAdjustedDistanceAtLimitMax(i2, this.mOverallVerticalScrollPx, getVerticalScrollLimit());
            if (i2 < 0) {
                int i4 = this.mOverallVerticalScrollPx;
                if (i2 + i4 < 0) {
                    adjustedDistanceAtLimitMax = getAdjustedDistanceAtLimitMin(adjustedDistanceAtLimitMax, i4);
                }
            }
            int i5 = this.mOverallHorizontalScrollPx + adjustedDistanceAtLimitMin;
            this.mOverallHorizontalScrollPx = i5;
            this.mOverallVerticalScrollPx += adjustedDistanceAtLimitMax;
            if (z2) {
                int iMin = Math.min(i5, getHorizontalScrollLimit() + (getScreenWidth() / 8));
                this.mOverallHorizontalScrollPx = iMin;
                this.mOverallHorizontalScrollPx = Math.max(iMin, (-getScreenWidth()) / 8);
                int iMin2 = Math.min(this.mOverallVerticalScrollPx, getVerticalScrollLimit() + (getScreenHeight() / 8));
                this.mOverallVerticalScrollPx = iMin2;
                this.mOverallVerticalScrollPx = Math.max(iMin2, (-getScreenHeight()) / 8);
            }
        }
        checkPageFitsWidth();
        synchronized (this) {
            Iterator<ScrollListener> it = getScrollListeners().iterator();
            while (it.hasNext()) {
                it.next().onScrollTo(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx), fromVerticalScrollRange(this.mOverallVerticalScrollPx));
            }
        }
    }

    private int getAdjustedDistanceAtLimitMin(int i, int i2) {
        if (i2 > 0) {
            return (-i2) + ((i2 + i) / 8);
        }
        return i / 8;
    }

    private int getAdjustedDistanceAtLimitMax(int i, int i2, int i3) {
        if (i2 < i3) {
            return (i3 - i2) + (((i2 + i) - i3) / 8);
        }
        return i / 8;
    }

    private void scrollEnd() {
        this.mIsHorizontalScrolling = false;
        this.mIsVerticalScrolling = false;
        checkPageFitsWidth();
        synchronized (this) {
            Iterator<ScrollListener> it = getScrollListeners().iterator();
            while (it.hasNext()) {
                it.next().onScrollEnd(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx), fromVerticalScrollRange(this.mOverallVerticalScrollPx));
            }
        }
    }

    private void adjustEnd() {
        synchronized (this) {
            Iterator<ScrollListener> it = getScrollListeners().iterator();
            while (it.hasNext()) {
                it.next().onScrollEnd(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx), fromVerticalScrollRange(this.mOverallVerticalScrollPx));
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (isAutoScrollEnabled()) {
            return;
        }
        Iterator<GestureListener> it = this.mGestureListeners.iterator();
        while (it.hasNext()) {
            it.next().onLongPressPre(motionEvent);
        }
        Iterator<GestureListener> it2 = this.mGestureListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onLongPress(motionEvent);
        }
        Iterator<GestureListener> it3 = this.mGestureListeners.iterator();
        while (it3.hasNext()) {
            it3.next().onLongPressPost(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent2.getActionMasked() != 1) {
            return true;
        }
        float x = motionEvent2.getX() - motionEvent.getX();
        float y = motionEvent2.getY() - motionEvent.getY();
        boolean zCanSwipeToIndent = canSwipeToIndent(motionEvent);
        boolean z = Math.abs(x) > Math.abs(y) && Math.abs(f) > SWIPE_VELOCITY_THRESHOLD;
        if (zCanSwipeToIndent && z) {
            PointerInfo pointerInfo = new PointerInfo();
            pointerInfo.setX(motionEvent.getX() + fromHorizontalScrollRange(this.mOverallHorizontalScrollPx));
            pointerInfo.setY(motionEvent.getY() + fromVerticalScrollRange(this.mOverallVerticalScrollPx));
            boolean z2 = x > 0.0f;
            PageController pageController = this.mPageController;
            if (pageController != null && pageController.onSwipe(pointerInfo, z2)) {
                return true;
            }
        }
        boolean zIsHorizontalScrollEnabled = isHorizontalScrollEnabled(motionEvent.getPointerCount());
        boolean zIsVerticalScrollEnabled = isVerticalScrollEnabled(motionEvent.getPointerCount());
        if (!zIsHorizontalScrollEnabled && !zIsVerticalScrollEnabled) {
            return false;
        }
        int i = (!zIsHorizontalScrollEnabled || this.mIsHorizontalScrollDisabled) ? 0 : (int) (-f);
        int i2 = zIsVerticalScrollEnabled ? (int) (-f2) : 0;
        int horizontalScrollLimit = zIsHorizontalScrollEnabled ? getHorizontalScrollLimit() : 0;
        int verticalScrollLimit = zIsVerticalScrollEnabled ? getVerticalScrollLimit() : 0;
        int iMax = zIsHorizontalScrollEnabled ? this.mScrollerOverEdgeX : 0;
        int iMax2 = zIsVerticalScrollEnabled ? this.mScrollerOverEdgeY : 0;
        int i3 = this.mOverallHorizontalScrollPx;
        if (i3 > horizontalScrollLimit) {
            iMax = Math.max(i3 - horizontalScrollLimit, iMax);
        }
        int i4 = this.mOverallHorizontalScrollPx;
        if (i4 < 0) {
            iMax = -i4;
        }
        int i5 = iMax;
        int i6 = this.mOverallVerticalScrollPx;
        if (i6 > verticalScrollLimit) {
            iMax2 = Math.max(i6 - verticalScrollLimit, iMax2);
        }
        int i7 = this.mOverallVerticalScrollPx;
        if (i7 < 0) {
            iMax2 = -i7;
        }
        cancelAnyScroll();
        this.mZoomAtFling = getZoom();
        this.mScroller.fling(this.mOverallHorizontalScrollPx, this.mOverallVerticalScrollPx, i, i2, 0, horizontalScrollLimit, 0, verticalScrollLimit, i5, iMax2);
        ValueAnimator valueAnimator = this.mFlingAnimator;
        this.mCurrentScrollAnimator = valueAnimator;
        valueAnimator.start();
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.mPageController != null) {
            final PointerInfo pointerInfo = new PointerInfo(motionEvent.getX() + fromHorizontalScrollRange(this.mOverallHorizontalScrollPx), motionEvent.getY() + fromVerticalScrollRange(this.mOverallVerticalScrollPx));
            pointerInfo.setPointerType(getPointerType(motionEvent));
            pointerInfo.setButtonType(getButtonType(motionEvent));
            this.mPenExecutor.submit(new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSingleTapConfirmed$7(pointerInfo);
                }
            });
            return true;
        }
        Log.w(TAG, ">>>> no page controller during single tap");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSingleTapConfirmed$7(PointerInfo pointerInfo) {
        Iterator<GestureListener> it = this.mGestureListeners.iterator();
        while (it.hasNext()) {
            it.next().onSingleTapConfirmedPre(pointerInfo);
        }
        this.mPageController.onTap(pointerInfo);
        Iterator<GestureListener> it2 = this.mGestureListeners.iterator();
        while (it2.hasNext()) {
            it2.next().onSingleTapConfirmed(pointerInfo);
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener, com.myscript.nebo.editing.impl.keyboard.cursor.IDragHandleProvider
    public boolean onDoubleTap(MotionEvent motionEvent) {
        final PointerInfo pointerInfo = new PointerInfo(motionEvent.getX() + fromHorizontalScrollRange(this.mOverallHorizontalScrollPx), motionEvent.getY() + fromVerticalScrollRange(this.mOverallVerticalScrollPx));
        pointerInfo.setPointerType(getPointerType(motionEvent));
        pointerInfo.setButtonType(getButtonType(motionEvent));
        PageController pageController = this.mPageController;
        if (pageController != null && pageController.isOverCheckableItem(pointerInfo)) {
            this.mPenExecutor.submit(new Callable() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda5
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f$0.lambda$onDoubleTap$8(pointerInfo);
                }
            });
            return true;
        }
        if (this.mPageController.onDoubleTap(pointerInfo)) {
            return true;
        }
        Iterator<GestureListener> it = this.mGestureListeners.iterator();
        while (it.hasNext()) {
            it.next().onDoubleTap(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$onDoubleTap$8(PointerInfo pointerInfo) throws Exception {
        return Boolean.valueOf(this.mPageController.onTap(pointerInfo));
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator == this.mFlingAnimator) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.computeScrollOffset();
                this.mOverallHorizontalScrollPx = this.mScroller.getCurrX();
                this.mOverallVerticalScrollPx = this.mScroller.getCurrY();
                if (this.mCenterWhenPageWidthFitsScreen && getPaperWidthMm() != -1.0f) {
                    checkPageFitsWidth();
                }
                synchronized (this) {
                    Iterator<ScrollListener> it = getScrollListeners().iterator();
                    while (it.hasNext()) {
                        it.next().onScrollTo(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx, this.mZoomAtFling), fromVerticalScrollRange(this.mOverallVerticalScrollPx, this.mZoomAtFling));
                    }
                }
                return;
            }
            cancelAutoScroll();
            if (adjustToZoomAndScrollRanges()) {
                return;
            }
            scrollEnd();
            return;
        }
        if (valueAnimator == this.mHorizontalDragAnimator) {
            offsetScroll(((Integer) valueAnimator.getAnimatedValue()).intValue() - this.mOverallHorizontalScrollPx, 0, true, false);
            return;
        }
        if (valueAnimator == this.mVerticalDragAnimator) {
            offsetScroll(0, ((Integer) valueAnimator.getAnimatedValue()).intValue() - this.mOverallVerticalScrollPx, true, false);
            return;
        }
        if (valueAnimator == this.mHorizontalScrollToAnimator) {
            offsetScroll(((Integer) valueAnimator.getAnimatedValue()).intValue() - this.mOverallHorizontalScrollPx, 0, false, false);
            return;
        }
        if (valueAnimator == this.mVerticalScrollToAnimator) {
            offsetScroll(0, ((Integer) valueAnimator.getAnimatedValue()).intValue() - this.mOverallVerticalScrollPx, false, false);
            return;
        }
        if (valueAnimator == this.mHorizontalAdjustmentAnimator) {
            offsetScroll(((Integer) valueAnimator.getAnimatedValue()).intValue() - this.mOverallHorizontalScrollPx, 0, false, false);
            return;
        }
        if (valueAnimator == this.mVerticalAdjustmentAnimator) {
            offsetScroll(0, ((Integer) valueAnimator.getAnimatedValue()).intValue() - this.mOverallVerticalScrollPx, false, false);
        } else if (valueAnimator == this.mZoomValueAnimator) {
            Iterator<ZoomListener> it2 = getZoomListeners().iterator();
            while (it2.hasNext()) {
                it2.next().onZoom(((Float) valueAnimator.getAnimatedValue()).floatValue(), this.mZoomAdjustmentReference, true);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (animator == this.mDragAnimator || animator == this.mScrollToAnimator) {
            scrollEnd();
            adjustToZoomAndScrollRanges();
            return;
        }
        if (animator == this.mScrollToAdjustmentAnimator) {
            adjustEnd();
            return;
        }
        if (animator == this.mZoomValueAnimator) {
            for (ZoomListener zoomListener : getZoomListeners()) {
                if (((Float) this.mZoomValueAnimator.getAnimatedValue()).floatValue() != 0.0f) {
                    zoomListener.onZoom(((Float) this.mZoomValueAnimator.getAnimatedValue()).floatValue(), this.mZoomAdjustmentReference, false);
                }
            }
            adjustToScrollRangesAnimated();
        }
    }

    public void cancelAnyScroll() {
        Animator animator = this.mCurrentScrollAnimator;
        if (animator != null) {
            if (animator.isRunning()) {
                this.mCurrentScrollAnimator.cancel();
            }
            this.mCurrentScrollAnimator = null;
        }
    }

    private void cancelAutoScroll() {
        cancelAnyScroll();
        if (this.mFlingAnimator.isStarted()) {
            this.mScroller.forceFinished(true);
            setOverallHorizontalScrollPx(this.mScroller.getCurrX());
            setOverallVerticalScrollPx(this.mScroller.getCurrY());
        }
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public boolean isScrollToAnimatorRunning() {
        AnimatorSet animatorSet = this.mScrollToAnimator;
        return animatorSet != null && animatorSet.isRunning();
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleAutoScroll(int i, int i2) {
        float f;
        boolean z;
        float f2;
        if (isAutoScrollEnabled()) {
            cancelAnyScroll();
            if (!this.mScroller.isFinished()) {
                cancelAutoScroll();
            }
            if (!this.mDragAnimator.isRunning()) {
                this.mDragAnimator.cancel();
            }
            int i3 = this.mScrollOnDragEdgeXSizePx;
            boolean z2 = true;
            float f3 = 1.0f;
            if (i <= i3) {
                int i4 = i3 - i;
                int i5 = i < i3 ? i3 - i : 0;
                int i6 = this.mPointerStartX;
                int iMax = Math.max(i5 - (i6 < i3 ? i3 - i6 : 0), 0);
                int i7 = this.mScrollOnDragEdgeXSizePx;
                if (iMax > i7 / 10) {
                    f2 = iMax / (i7 != 0 ? i7 : 1.0f);
                    if (f2 > 1.0f) {
                        f2 = 1.0f;
                    }
                } else {
                    f2 = 0.0f;
                }
                int iRound = this.mOverallHorizontalScrollPx - Math.round(i4 * f2);
                if (iRound > 0) {
                    this.mHorizontalDragAnimator.setIntValues(iRound, 0);
                    this.mHorizontalDragAnimator.setDuration(((long) Math.max(0, (iRound * 100) / (i4 + 1))) * ON_DRAG_SCROLL_ANIM_SPEED_FACTOR);
                    if (f2 > 0.0f) {
                        z = true;
                    }
                }
                z = false;
            } else {
                int i8 = this.mWidth;
                if (i >= i8 - i3) {
                    int i9 = i - (i8 - i3);
                    int i10 = i > i8 - i3 ? i - (i8 - i3) : 0;
                    int i11 = this.mPointerStartX;
                    int iMax2 = Math.max(0, i10 - (i11 > i8 - i3 ? i11 - (i8 - i3) : 0));
                    int i12 = this.mScrollOnDragEdgeXSizePx;
                    if (iMax2 > i12 / 10) {
                        f = iMax2 / (i12 != 0 ? i12 : 1.0f);
                        if (f > 1.0f) {
                            f = 1.0f;
                        }
                    } else {
                        f = 0.0f;
                    }
                    int iRound2 = this.mOverallHorizontalScrollPx + Math.round(i9 * f);
                    this.mHorizontalDragAnimator.setIntValues(iRound2, getHorizontalScrollLimit());
                    this.mHorizontalDragAnimator.setDuration(((long) Math.max(0, ((getHorizontalScrollLimit() - Math.min(getHorizontalScrollLimit(), iRound2)) * 100) / (i9 + 1))) * ON_DRAG_SCROLL_ANIM_SPEED_FACTOR);
                    if (f > 0.0f) {
                    }
                }
                z = false;
            }
            int i13 = this.mScrollOnDragEdgeYSizePx;
            if (i2 <= i13) {
                int i14 = i13 - i2;
                int i15 = i2 < i13 ? i13 - i2 : 0;
                int i16 = this.mPointerStartY;
                int iMax3 = Math.max(0, i15 - (i16 < i13 ? i13 - i16 : 0));
                int i17 = this.mScrollOnDragEdgeYSizePx;
                if (iMax3 > i17 / 10) {
                    float f4 = iMax3 / (i17 != 0 ? i17 : 1.0f);
                    if (f4 <= 1.0f) {
                        f3 = f4;
                    }
                } else {
                    f3 = 0.0f;
                }
                int iRound3 = this.mOverallVerticalScrollPx - Math.round(i14 * f3);
                if (iRound3 > 0) {
                    this.mVerticalDragAnimator.setIntValues(iRound3, 0);
                    this.mVerticalDragAnimator.setDuration(((long) Math.max(0, (iRound3 * 100) / (i14 + 1))) * ON_DRAG_SCROLL_ANIM_SPEED_FACTOR);
                    if (f3 <= 0.0f) {
                        z2 = false;
                    }
                }
            } else {
                int i18 = this.mHeight;
                if (i2 >= i18 - i13) {
                    int i19 = i2 - (i18 - i13);
                    int i20 = i2 > i18 - i13 ? i2 - (i18 - i13) : 0;
                    int i21 = this.mPointerStartY;
                    int iMax4 = Math.max(0, i20 - (i21 > i18 - i13 ? i21 - (i18 - i13) : 0));
                    int i22 = this.mScrollOnDragEdgeYSizePx;
                    if (iMax4 > i22 / 10) {
                        float f5 = iMax4 / (i22 != 0 ? i22 : 1.0f);
                        if (f5 <= 1.0f) {
                            f3 = f5;
                        }
                    } else {
                        f3 = 0.0f;
                    }
                    int iRound4 = this.mOverallVerticalScrollPx + Math.round(i19 * f3);
                    this.mVerticalDragAnimator.setIntValues(iRound4, getVerticalScrollLimit());
                    this.mVerticalDragAnimator.setDuration(((long) Math.max(0, ((getVerticalScrollLimit() - Math.min(getVerticalScrollLimit(), iRound4)) * 100) / (i19 + 1))) * ON_DRAG_SCROLL_ANIM_SPEED_FACTOR);
                    if (f3 <= 0.0f) {
                    }
                }
            }
            if (z || z2) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.mDragAnimator = animatorSet;
                animatorSet.addListener(this);
                AnimatorSet animatorSet2 = this.mDragAnimator;
                this.mCurrentScrollAnimator = animatorSet2;
                if (z) {
                    animatorSet2.play(this.mHorizontalDragAnimator);
                }
                if (z2) {
                    this.mDragAnimator.play(this.mVerticalDragAnimator);
                }
                this.mDragAnimator.start();
            }
        }
    }

    private int computeAnimationDuration(float f, float f2) {
        return Math.round(((f / 100.0f) * 1000.0f) / (((Math.min(Math.abs(f2), 10.0f) / 10.0f) / 2.0f) + 0.5f));
    }

    private void animateScrollHorizontal(float f, int i, int i2) {
        if (this.mDragAnimator.isRunning()) {
            return;
        }
        this.mDragAnimator.cancel();
        this.mCurrentScrollAnimator = this.mDragAnimator;
        AnimatorSet animatorSet = new AnimatorSet();
        this.mDragAnimator = animatorSet;
        animatorSet.addListener(this);
        this.mHorizontalDragAnimator.setIntValues(i, i2);
        this.mHorizontalDragAnimator.setDuration(computeAnimationDuration(xPxToMm(Math.abs(i2 - i)), xPxToMm(Math.round(f))));
        this.mDragAnimator.play(this.mHorizontalDragAnimator);
        this.mDragAnimator.start();
    }

    private void animateScrollVertical(float f, int i, int i2) {
        if (this.mDragAnimator.isRunning()) {
            return;
        }
        this.mDragAnimator.cancel();
        AnimatorSet animatorSet = new AnimatorSet();
        this.mDragAnimator = animatorSet;
        this.mCurrentScrollAnimator = animatorSet;
        this.mScrollToAdjustmentAnimator.addListener(this);
        this.mVerticalDragAnimator.setIntValues(i, i2);
        this.mVerticalDragAnimator.setDuration(computeAnimationDuration(yPxToMm(Math.abs(i2 - i)), yPxToMm(Math.round(f))));
        this.mDragAnimator.play(this.mVerticalDragAnimator);
        this.mDragAnimator.start();
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.IDragHandleProvider
    public void handleScrollUp(float f) {
        animateScrollVertical(f, this.mOverallVerticalScrollPx, 0);
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.IDragHandleProvider
    public void handleScrollDown(float f) {
        animateScrollVertical(f, this.mOverallVerticalScrollPx, getVerticalScrollLimit());
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.IDragHandleProvider
    public void handleScrollLeft(float f) {
        animateScrollHorizontal(f, this.mOverallHorizontalScrollPx, 0);
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.IDragHandleProvider
    public void handleScrollRight(float f) {
        animateScrollHorizontal(f, this.mOverallHorizontalScrollPx, getHorizontalScrollLimit());
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.IDragHandleProvider
    public void handleStopScroll() {
        if (this.mDragAnimator.isRunning()) {
            this.mDragAnimator.cancel();
            this.mOverallVerticalScrollPx = ((Integer) this.mVerticalDragAnimator.getAnimatedValue()).intValue();
            scrollEnd();
            adjustToScrollRangesAnimated();
        }
    }

    public boolean scrollDelta(int i, int i2, boolean z, boolean z2) {
        float fVerticalScrollLimitPxMax;
        int i3;
        ValueAnimator valueAnimator;
        if (z2) {
            fVerticalScrollLimitPxMax = verticalScrollLimitPxMax();
            i3 = this.mOverallVerticalScrollPx;
            valueAnimator = this.mVerticalDragAnimator;
        } else {
            fVerticalScrollLimitPxMax = this.mHorizontalScrollLimitPxMax;
            i3 = this.mOverallHorizontalScrollPx;
            valueAnimator = this.mHorizontalDragAnimator;
        }
        if (fVerticalScrollLimitPxMax == 0.0f) {
            return false;
        }
        cancelAnyScroll();
        if (i < 0) {
            int iAbs = Math.abs(i);
            int i4 = i + i3;
            int i5 = i4 - i3;
            if (z) {
                valueAnimator.setIntValues(i3, i4);
                valueAnimator.setDuration(Math.max(0, Math.min(Math.round(((z2 ? yPxToMm(iAbs) : xPxToMm(iAbs)) / 100.0f) * 1000.0f), 500)));
                this.mDragAnimator = new AnimatorSet();
                this.mScrollToAdjustmentAnimator.addListener(this);
                this.mDragAnimator.play(valueAnimator);
                this.mDragAnimator.start();
                this.mCurrentScrollAnimator = this.mDragAnimator;
            } else if (z2) {
                offsetScroll(0, i5, true, true);
            } else {
                offsetScroll(i5, 0, true, true);
            }
        } else if (i > i2) {
            int i6 = i - i2;
            int i7 = i3 + i6;
            int i8 = i7 - i3;
            int iAbs2 = Math.abs(i6);
            if (z) {
                valueAnimator.setIntValues(i3, i7);
                valueAnimator.setDuration(Math.max(0, Math.min(Math.round(((z2 ? yPxToMm(iAbs2) : xPxToMm(iAbs2)) / 100.0f) * 1000.0f), 500)));
                this.mDragAnimator = new AnimatorSet();
                this.mScrollToAdjustmentAnimator.addListener(this);
                this.mDragAnimator.play(valueAnimator);
                this.mDragAnimator.start();
                this.mCurrentScrollAnimator = this.mDragAnimator;
            } else {
                if (z2) {
                    offsetScroll(0, i8, true, true);
                } else {
                    offsetScroll(i8, 0, true, true);
                }
                scrollEnd();
                adjustToScrollRangesAnimated();
            }
        }
        return true;
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public void animateScrollTo(final int i, final int i2) {
        this.mHandler.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$animateScrollTo$9(i, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$animateScrollTo$9(int i, int i2) {
        AnimatorSet animatorSet;
        cancelAnyScroll();
        this.mHorizontalScrollToAnimator.setIntValues(this.mOverallHorizontalScrollPx, toHorizontalScrollRange(i));
        this.mHorizontalScrollToAnimator.setDuration(350L);
        this.mVerticalScrollToAnimator.setIntValues(this.mOverallVerticalScrollPx, toVerticalScrollRange(i2));
        this.mVerticalScrollToAnimator.setDuration(350L);
        if (isScrollToAnimatorRunning() && (animatorSet = this.mScrollToAnimator) != null) {
            animatorSet.cancel();
        }
        if (this.mScrollToAdjustmentAnimator.isRunning()) {
            this.mScrollToAdjustmentAnimator.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mScrollToAnimator = animatorSet2;
        animatorSet2.addListener(this);
        this.mScrollToAnimator.play(this.mHorizontalScrollToAnimator);
        this.mScrollToAnimator.play(this.mVerticalScrollToAnimator);
        this.mScrollToAnimator.start();
        this.mCurrentScrollAnimator = this.mScrollToAnimator;
    }

    public boolean adjustToScrollRanges() {
        int i = this.mOverallHorizontalScrollPx;
        int i2 = this.mOverallVerticalScrollPx;
        this.mOverallHorizontalScrollPx = adjustOverallHorizontalScrollPx(i);
        int iAdjustOverallVerticalScrollPx = adjustOverallVerticalScrollPx(i2);
        this.mOverallVerticalScrollPx = iAdjustOverallVerticalScrollPx;
        boolean z = i != this.mOverallHorizontalScrollPx;
        boolean z2 = i2 != iAdjustOverallVerticalScrollPx;
        if (!z && !z2) {
            return false;
        }
        cancelAnyScroll();
        Iterator<ScrollListener> it = getScrollListeners().iterator();
        while (it.hasNext()) {
            it.next().onScrollTo(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx), fromVerticalScrollRange(this.mOverallVerticalScrollPx));
        }
        return true;
    }

    public boolean adjustToScrollRangesAnimated() {
        AnimatorSet animatorSet;
        int i = this.mOverallHorizontalScrollPx;
        int i2 = this.mOverallVerticalScrollPx;
        int iAdjustOverallHorizontalScrollPx = adjustOverallHorizontalScrollPx(i);
        int iAdjustOverallVerticalScrollPx = adjustOverallVerticalScrollPx(i2);
        boolean z = i != iAdjustOverallHorizontalScrollPx;
        boolean z2 = i2 != iAdjustOverallVerticalScrollPx;
        if (!z && !z2) {
            return false;
        }
        cancelAnyScroll();
        this.mHorizontalAdjustmentAnimator.setIntValues(i, iAdjustOverallHorizontalScrollPx);
        this.mHorizontalAdjustmentAnimator.setDuration(350L);
        this.mVerticalAdjustmentAnimator.setIntValues(i2, iAdjustOverallVerticalScrollPx);
        this.mVerticalAdjustmentAnimator.setDuration(350L);
        if (isScrollToAnimatorRunning() && (animatorSet = this.mScrollToAnimator) != null) {
            animatorSet.cancel();
        }
        if (this.mScrollToAdjustmentAnimator.isRunning()) {
            this.mScrollToAdjustmentAnimator.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mScrollToAdjustmentAnimator = animatorSet2;
        animatorSet2.addListener(this);
        AnimatorSet animatorSet3 = this.mScrollToAdjustmentAnimator;
        this.mCurrentScrollAnimator = animatorSet3;
        if (z) {
            animatorSet3.play(this.mHorizontalAdjustmentAnimator);
        }
        if (z2) {
            this.mScrollToAdjustmentAnimator.play(this.mVerticalAdjustmentAnimator);
        }
        this.mScrollToAdjustmentAnimator.start();
        return true;
    }

    public boolean adjustToZoomAndScrollRanges() {
        Animator animator = this.mCurrentScrollAnimator;
        if (animator != null && animator.isStarted()) {
            return false;
        }
        boolean zAdjustToZoomRange = adjustToZoomRange();
        return !zAdjustToZoomRange ? adjustToScrollRangesAnimated() : zAdjustToZoomRange;
    }

    public void setScrollEnabled(boolean z) {
        this.mIsScrollEnabled = z;
    }

    private int toHorizontalScrollRange(int i) {
        return i - Math.round(getScaledHorizontalScrollLimitPxMin());
    }

    private int fromHorizontalScrollRange(int i, float f) {
        return Math.round(getScaledHorizontalScrollLimitPxMin(f)) + i;
    }

    private int fromHorizontalScrollRange(int i) {
        return Math.round(getScaledHorizontalScrollLimitPxMin()) + i;
    }

    private int toVerticalScrollRange(int i) {
        return Math.round(-getScaledVerticalScrollLimitPxMin()) + i;
    }

    private int fromVerticalScrollRange(int i, float f) {
        return Math.round(getScaledVerticalScrollLimitPxMin(f)) + i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int fromVerticalScrollRange(int i) {
        return Math.round(getScaledVerticalScrollLimitPxMin()) + i;
    }

    private void setOverallHorizontalScrollPx(int i) {
        this.mOverallHorizontalScrollPx = adjustOverallHorizontalScrollPx(i);
    }

    private int adjustOverallHorizontalScrollPx(int i) {
        if (i < 0) {
            i = 0;
        }
        return i > getHorizontalScrollLimit() ? getHorizontalScrollLimit() : i;
    }

    private void setOverallVerticalScrollPx(int i) {
        this.mOverallVerticalScrollPx = adjustOverallVerticalScrollPx(i);
    }

    private int adjustOverallVerticalScrollPx(int i) {
        if (i < 0) {
            i = 0;
        }
        return i > getVerticalScrollLimit() ? getVerticalScrollLimit() : i;
    }

    private float getScaledHorizontalScrollLimitPxMin(float f) {
        return f * this.mHorizontalScrollLimitPxMin;
    }

    private float getScaledHorizontalScrollLimitPxMin() {
        return getScaledHorizontalScrollLimitPxMin(getZoom());
    }

    private float getScaledHorizontalScrollLimitPxMax() {
        return getZoom() * this.mHorizontalScrollLimitPxMax;
    }

    private float getScaledVerticalScrollLimitPxMin(float f) {
        return f * this.mVerticalScrollLimitPxMin;
    }

    private float getScaledVerticalScrollLimitPxMin() {
        return getScaledVerticalScrollLimitPxMin(getZoom());
    }

    private int getScaledVerticalScrollLimitPxMax() {
        return Math.round(getZoom() * verticalScrollLimitPxMax());
    }

    private float getZoom() {
        ViewTransform viewTransform = this.mViewTransform;
        if (viewTransform == null || viewTransform.zoomScale() == 0.0f) {
            return 1.0f;
        }
        return 1.0f / this.mViewTransform.zoomScale();
    }

    public void animZoomAdjust(float f, float f2) {
        AnimatorSet animatorSet;
        if (this.mZoomAdjustmentAnimator.isStarted()) {
            this.mZoomAdjustmentAnimator.cancel();
        }
        if (this.mFlingAnimator.isStarted()) {
            this.mZoomAdjustmentAnimator.cancel();
        }
        if (isScrollToAnimatorRunning() && (animatorSet = this.mScrollToAnimator) != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mZoomAdjustmentAnimator = animatorSet2;
        this.mCurrentScrollAnimator = animatorSet2;
        this.mZoomValueAnimator.setFloatValues(f, f2);
        this.mZoomValueAnimator.setDuration(200L);
        this.mZoomAdjustmentAnimator.play(this.mZoomValueAnimator);
        this.mZoomAdjustmentAnimator.start();
    }

    private DualTouchGestureDetector.OnDualTouchGestureListener getDualTouchGestureListener() {
        return new DualTouchGestureDetector.SimpleDualTouchGestureListener() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController.3
            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchLongPressEnd(MotionEvent motionEvent) {
                return true;
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchLongPressMove(MotionEvent motionEvent) {
                return true;
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                ScrollBarBehavior scrollBarBehaviorScrollBehavior = DocumentTouchController.this.mPageController != null ? DocumentTouchController.this.mPageController.scrollBehavior() : null;
                if (scrollBarBehaviorScrollBehavior == null) {
                    return false;
                }
                DocumentTouchController documentTouchController = DocumentTouchController.this;
                if (!scrollBarBehaviorScrollBehavior.getIsHorizontalScrollAllowed()) {
                    f = 0.0f;
                }
                return documentTouchController.onScroll(motionEvent, motionEvent2, f, f2);
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return DocumentTouchController.this.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchDown(MotionEvent motionEvent) {
                DocumentTouchController.this.cancelCurrentMotionEvent(motionEvent);
                return true;
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchSingleTapUp(MotionEvent motionEvent) {
                return DocumentTouchController.this.onSingleTapUp(motionEvent);
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public void onDualTouchSingleTapConfirmed(MotionEvent motionEvent) {
                DocumentTouchController.this.onSingleTapConfirmed(motionEvent);
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public void onDualTouchLongPressStart(MotionEvent motionEvent) {
                DocumentTouchController.this.onLongPress(motionEvent);
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchDoubleTapStart(MotionEvent motionEvent) {
                DocumentTouchController.this.cancelCurrentMotionEvent(motionEvent);
                return true;
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchDoubleTapEnd(MotionEvent motionEvent) {
                DocumentTouchController.this.cancelCurrentMotionEvent(motionEvent);
                DocumentTouchController.this.onDoubleTap(motionEvent);
                return true;
            }
        };
    }

    private DualTouchGestureDetector.OnDualTouchGestureListener getSpaceManageManagementListener() {
        return new DualTouchGestureDetector.SimpleDualTouchGestureListener() { // from class: com.myscript.nebo.editing.impl.ui.DocumentTouchController.4
            private final PointerInfo mDualLongPressPointerInfo = new PointerInfo();

            private void updatePosition(MotionEvent motionEvent) {
                float y = motionEvent.getY();
                if (motionEvent.getPointerCount() > 1) {
                    y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                }
                DocumentTouchController documentTouchController = DocumentTouchController.this;
                this.mDualLongPressPointerInfo.setPosition(motionEvent.getX(), y + documentTouchController.fromVerticalScrollRange(documentTouchController.mOverallVerticalScrollPx));
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public void onDualTouchLongPressStart(MotionEvent motionEvent) {
                if (DocumentTouchController.this.mPageController != null) {
                    updatePosition(motionEvent);
                    if (DocumentTouchController.this.mPageController.isSpaceManagementActivable(this.mDualLongPressPointerInfo)) {
                        DocumentTouchController.this.mPageController.spaceManagement(this.mDualLongPressPointerInfo);
                        DocumentTouchController.this.mPageController.penDown(this.mDualLongPressPointerInfo);
                    }
                }
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchLongPressMove(MotionEvent motionEvent) {
                if (DocumentTouchController.this.mPageController == null) {
                    return true;
                }
                updatePosition(motionEvent);
                DocumentTouchController.this.mPageController.penMove(this.mDualLongPressPointerInfo);
                return true;
            }

            @Override // com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.SimpleDualTouchGestureListener, com.myscript.nebo.editing.controller.gesture.DualTouchGestureDetector.OnDualTouchGestureListener
            public boolean onDualTouchLongPressEnd(MotionEvent motionEvent) {
                if (DocumentTouchController.this.mPageController == null) {
                    return true;
                }
                DocumentTouchController.this.mPageController.penUp(this.mDualLongPressPointerInfo);
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelCurrentMotionEvent(MotionEvent motionEvent) {
        if (this.mPageController != null) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 0; i < pointerCount; i++) {
                this.mPageController.penAbort(motionEvent.getPointerId(i));
            }
        }
    }

    public boolean adjustToZoomRange() {
        float zoom = getZoom();
        float fMin = Math.min(Math.max(zoom, getMinZoom()), getMaxZoom());
        if (zoom == fMin) {
            return false;
        }
        this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER;
        if (fMin > zoom) {
            int i = this.mOverallVerticalScrollPx;
            boolean z = i == 0;
            boolean z2 = i == getVerticalScrollLimit();
            int i2 = this.mOverallHorizontalScrollPx;
            boolean z3 = i2 == 0;
            boolean z4 = i2 == getHorizontalScrollLimit();
            if (z && z3) {
                this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_TOP_LEFT;
            } else if (z && z4) {
                this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_TOP_RIGHT;
            } else if (z2 && z3) {
                this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_BOTTOM_LEFT;
            } else if (z2 && z4) {
                this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_BOTTOM_RIGHT;
            } else if (z) {
                this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_TOP_CENTER;
            } else if (z2) {
                this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_BOTTOM_CENTER;
            } else if (z3) {
                this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER_LEFT;
            } else if (z4) {
                this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER_RIGHT;
            } else {
                this.mZoomAdjustmentReference = ZoomListener.ZoomFromReference.ZOOM_FROM_CENTER;
            }
        }
        animZoomAdjust(zoom, fMin);
        return true;
    }

    public void cancelAnyZoomAdjustAnim() {
        if (this.mZoomAdjustmentAnimator.isStarted()) {
            this.mZoomAdjustmentAnimator.removeAllListeners();
            this.mZoomAdjustmentAnimator.cancel();
        }
    }

    private boolean isAutoScrollEnabled() {
        return this.mIsAutoScrollEnabled && this.mDeviceAnimationsEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deviceAnimationsEnabled() {
        boolean z = this.mDeviceAnimationsEnabled;
        ContentResolver contentResolver = this.mApplicationContentResolver;
        if (contentResolver == null || this.mDeviceAnimationDurationScaleUri == null) {
            return z;
        }
        try {
            return Settings.Global.getFloat(contentResolver, "animator_duration_scale") != 0.0f;
        } catch (Settings.SettingNotFoundException unused) {
            return z;
        }
    }

    public void allowAdditionalSpaceForKeyboard(boolean z) {
        this.mEnableAddSpaceForKeyboard = z;
    }

    public void addExtraSpaceForKeyboard() {
        float zoom = getZoom();
        float maxZoom = getMaxZoom();
        float fMin = Math.min(maxZoom - zoom, maxZoom) / Math.max(maxZoom - getMinZoom(), 1.0f);
        float f = (this.mHeight * 3) / 4.0f;
        if (zoom != 0.0f) {
            f /= zoom;
        }
        this.mKeyboardAddedSpace = this.mEnableAddSpaceForKeyboard ? Math.max(f * fMin, 0.0f) : 0.0f;
    }

    public void removeExtraSpaceForKeyboard() {
        if (this.mKeyboardAddedSpace > 0.0f) {
            this.mKeyboardAddedSpace = 0.0f;
            adjustToScrollRanges();
        }
    }

    private float verticalScrollLimitPxMax() {
        return this.mVerticalScrollLimitPxMax + this.mKeyboardAddedSpace;
    }

    private void checkPageFitsWidth() {
        if (getPaperWidthMm() != -1.0f && getZoom() > 0.0f) {
            float fXMmToPx = xMmToPx(getPaperWidthMm());
            float scaledHorizontalScrollLimitPxMax = ((getScaledHorizontalScrollLimitPxMax() - getScaledHorizontalScrollLimitPxMin()) - fXMmToPx) / 2.0f;
            float scaledHorizontalScrollLimitPxMin = getScaledHorizontalScrollLimitPxMin() + scaledHorizontalScrollLimitPxMax;
            float scaledHorizontalScrollLimitPxMin2 = getScaledHorizontalScrollLimitPxMin() + scaledHorizontalScrollLimitPxMax + fXMmToPx;
            int i = this.mWidth;
            float f = scaledHorizontalScrollLimitPxMin2 - i;
            int i2 = i / 20;
            boolean z = ((float) fromHorizontalScrollRange(this.mOverallHorizontalScrollPx)) < scaledHorizontalScrollLimitPxMin;
            boolean z2 = ((float) fromHorizontalScrollRange(this.mOverallHorizontalScrollPx)) > f;
            float fAbs = Math.abs(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx) - scaledHorizontalScrollLimitPxMin);
            float fAbs2 = Math.abs(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx) - f);
            boolean z3 = this.mIsHorizontalScrollDisabled;
            this.mIsHorizontalScrollDisabled = z && z2;
            if (this.mCenterWhenPageWidthFitsScreen) {
                int i3 = i2 * 2;
                if (fXMmToPx > this.mWidth - i3 && scaledHorizontalScrollLimitPxMin < fromHorizontalScrollRange(this.mOverallHorizontalScrollPx) && f < fromHorizontalScrollRange(this.mOverallHorizontalScrollPx) - i2) {
                    this.mOverallHorizontalScrollPx = toHorizontalScrollRange(Math.round(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx + i2) - fAbs2));
                } else if (fXMmToPx > this.mWidth - i3 && f > fromHorizontalScrollRange(this.mOverallHorizontalScrollPx) && scaledHorizontalScrollLimitPxMin > fromHorizontalScrollRange(this.mOverallHorizontalScrollPx) + i2) {
                    this.mOverallHorizontalScrollPx = toHorizontalScrollRange(Math.round(fromHorizontalScrollRange(this.mOverallHorizontalScrollPx - i2) + fAbs));
                } else if (fXMmToPx < this.mWidth - i3) {
                    this.mOverallHorizontalScrollPx = toHorizontalScrollRange(Math.round(scaledHorizontalScrollLimitPxMin + ((f - scaledHorizontalScrollLimitPxMin) / 2.0f)));
                }
            }
            if (z3 != this.mIsHorizontalScrollDisabled) {
                Iterator<ScrollListener> it = getScrollListeners().iterator();
                while (it.hasNext()) {
                    it.next().onHorizontalScrollDisabledChanged(this.mIsHorizontalScrollDisabled);
                }
            }
        }
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public void enableFeatureCenterWhenPageWidthFitsScreen(boolean z) {
        this.mCenterWhenPageWidthFitsScreen = z;
    }

    @Override // com.myscript.nebo.editing.impl.p027ui.ITouchFeature
    public Extent getPaperExtent() {
        return this.mPaperExtent;
    }

    private float getPaperWidthMm() {
        Extent extent = this.mPaperExtent;
        if (extent == null || !extent.valid()) {
            return -1.0f;
        }
        return this.mPaperExtent.getWidth();
    }
}
