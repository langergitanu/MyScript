package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.R;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Magnifier;
import android.widget.PopupWindow;
import com.myscript.nebo.editing.C6421R;
import com.myscript.nebo.editing.impl.keyboard.IntRange;
import com.myscript.nebo.editing.impl.keyboard.cursor.PositionListener;
import com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager;
import java.lang.ref.WeakReference;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HandleView extends View implements PositionListener.TextViewPositionListener {
    private static final boolean DBG = false;
    private static final String TAG = "HandleView";
    private final PopupWindow mContainer;
    IDraggingListener mDraggingListener;
    protected Drawable mDrawable;
    protected final Drawable mDrawableLtr;
    protected final Drawable mDrawableRtl;
    protected int mHorizontalGravity;
    protected WeakReference<View> mHostViewRef;
    protected int mHotspotX;
    protected boolean mIsContextualMenuShown;
    private boolean mIsDragging;
    SelectionCursorManager.CursorType mLastIgnoredHandle;
    float mLastIgnoredX;
    float mLastIgnoredY;
    private int mLastParentX;
    private int mLastParentXOnScreen;
    private int mLastParentY;
    private int mLastParentYOnScreen;
    private final int mMinSize;
    private boolean mPositionHasChanged;
    protected final PositionListener mPositionListener;
    private int mPositionX;
    private int mPositionY;
    private int mPreviousHorizontalScrollPos;
    protected float mPreviousPositionX;
    protected float mPreviousPositionY;
    private int mPreviousVerticalScrollPos;
    private EnumSet<ScrollingDirection> mScrollingDirection;
    protected final SelectionCursorManager mSelectionCursorManager;
    public boolean mSwapped;
    private final float mTouchOffsetY;
    private final PointF mTouchPosition;
    protected boolean mWasContextualMenuShown;

    public interface IDraggingListener {
        void onDraggingStateChanged(HandleView handleView);
    }

    private enum ScrollingDirection {
        SCROLLING_TOP,
        SCROLLING_BOTTOM,
        SCROLLING_LEFT,
        SCROLLING_RIGHT
    }

    public abstract PointF getCurrentCursorPosition();

    protected abstract SelectionCursorManager.CursorPosition getCursorPosition();

    protected abstract float getHorizontal();

    protected abstract int getHorizontalGravity(boolean z);

    protected abstract int getHotspotX(Drawable drawable, boolean z);

    abstract HandleView getOtherSelectionHandle();

    protected boolean isStartHandle() {
        return true;
    }

    public void onDetached() {
    }

    void onHandleMoved() {
    }

    protected abstract void updateSelection(float f, float f2);

    HandleView(View view, Drawable drawable, Drawable drawable2, int i, SelectionCursorManager selectionCursorManager) {
        super(view.getContext());
        this.mPreviousPositionX = -1.0f;
        this.mPreviousPositionY = -1.0f;
        this.mPreviousHorizontalScrollPos = -1;
        this.mPreviousVerticalScrollPos = -1;
        this.mPositionHasChanged = true;
        this.mTouchPosition = new PointF();
        this.mScrollingDirection = EnumSet.noneOf(ScrollingDirection.class);
        this.mLastIgnoredHandle = SelectionCursorManager.CursorType.CURSOR_TYPE_NONE;
        this.mSwapped = false;
        this.mIsContextualMenuShown = false;
        this.mWasContextualMenuShown = false;
        setId(i);
        this.mHostViewRef = new WeakReference<>(view);
        this.mSelectionCursorManager = selectionCursorManager;
        this.mPositionListener = new PositionListener(view);
        PopupWindow popupWindow = new PopupWindow(getContext(), (AttributeSet) null, R.attr.textSelectHandleWindowStyle);
        this.mContainer = popupWindow;
        popupWindow.setSplitTouchEnabled(true);
        popupWindow.setClippingEnabled(false);
        popupWindow.setWindowLayoutType(1002);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setContentView(this);
        this.mDrawableLtr = drawable;
        this.mDrawableRtl = drawable2;
        this.mMinSize = getContext().getResources().getDimensionPixelSize(C6421R.dimen.text_handle_min_size);
        updateDrawable();
        this.mTouchOffsetY = getPreferredHeight() * (-0.3f);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.HandleView.1
            private final GestureDetector gestureDetector;

            {
                this.gestureDetector = new GestureDetector(HandleView.this.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.HandleView.1.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onDoubleTap(MotionEvent motionEvent) {
                        HandleView.this.dismissMagnifier();
                        float cursorHeight = HandleView.this.mSelectionCursorManager.getCursorHeight(HandleView.this.getCursorPosition()) / 2.0f;
                        HandleView.this.mSelectionCursorManager.onHandleDoubleTap(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), HandleView.this.contentToViewportHorizontalOffset(Math.round((motionEvent.getRawX() - HandleView.this.mLastParentXOnScreen) + HandleView.this.mLastParentX)), HandleView.this.contentToViewportVerticalOffset(Math.round((motionEvent.getRawY() - HandleView.this.mLastParentYOnScreen) + HandleView.this.mLastParentY)) - cursorHeight, motionEvent.getMetaState()));
                        return true;
                    }
                });
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return this.gestureDetector.onTouchEvent(motionEvent);
            }
        });
    }

    int getCursorHorizontalPosition() {
        return viewportToContentHorizontalOffset(getHorizontal() - 0.5f);
    }

    protected void updateDrawable() {
        if (this.mIsDragging) {
            return;
        }
        Drawable drawable = this.mDrawable;
        Drawable drawable2 = this.mDrawableLtr;
        this.mDrawable = drawable2;
        this.mHotspotX = getHotspotX(drawable2, false);
        this.mHorizontalGravity = getHorizontalGravity(false);
        if (drawable == this.mDrawable || !isShowing()) {
            return;
        }
        int cursorHorizontalPosition = (getCursorHorizontalPosition() - this.mHotspotX) - getHorizontalOffset();
        this.mPositionX = cursorHorizontalPosition;
        this.mPositionX = viewportToContentHorizontalOffset(cursorHorizontalPosition);
        this.mPositionHasChanged = true;
        updatePosition(this.mLastParentX, this.mLastParentY, false, false);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getPreferredWidth(), getPreferredHeight());
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        PointF currentCursorPosition = getCurrentCursorPosition();
        if (!isShowing() || currentCursorPosition == null) {
            return;
        }
        positionAtCursorPosition(currentCursorPosition.x, currentCursorPosition.y, true);
    }

    public void forceRepaint() {
        super.invalidate();
    }

    public int getPreferredWidth() {
        return Math.max(this.mDrawable.getIntrinsicWidth(), this.mMinSize);
    }

    public int getPreferredHeight() {
        return Math.max(this.mDrawable.getIntrinsicHeight(), this.mMinSize);
    }

    public void show() {
        if (isShowing()) {
            return;
        }
        this.mPositionListener.addSubscriber(this);
        PointF currentCursorPosition = getCurrentCursorPosition();
        if (currentCursorPosition != null) {
            positionAtCursorPosition(currentCursorPosition.x, currentCursorPosition.y, true);
        }
    }

    protected void dismiss() {
        this.mSwapped = false;
        setDraggingState(false);
        this.mContainer.dismiss();
        onDetached();
    }

    public void hide() {
        dismiss();
        this.mPositionListener.removeSubscriber(this);
    }

    public boolean isShowing() {
        return this.mContainer.isShowing();
    }

    private boolean isHandleOnVisibleVisibleArea() {
        RectF handleOverallRect;
        Rect visibleRenderingArea = this.mSelectionCursorManager.getVisibleRenderingArea();
        if (visibleRenderingArea == null || (handleOverallRect = getHandleOverallRect()) == null) {
            return false;
        }
        Rect rect = new Rect();
        handleOverallRect.round(rect);
        return visibleRenderingArea.contains(rect);
    }

    protected void positionAtCursorPosition(float f, float f2, boolean z) {
        PointF currentCursorPosition = getCurrentCursorPosition();
        if (currentCursorPosition == null) {
            return;
        }
        boolean z2 = (f == this.mPreviousPositionX && f2 == this.mPreviousPositionY && this.mPreviousHorizontalScrollPos == this.mSelectionCursorManager.getHorizontalScrollPos() && this.mPreviousVerticalScrollPos == this.mSelectionCursorManager.getVerticalScrollPos()) ? false : true;
        if (z2 || z) {
            this.mPreviousPositionX = f;
            this.mPreviousPositionY = f2;
            this.mPreviousHorizontalScrollPos = this.mSelectionCursorManager.getHorizontalScrollPos();
            this.mPreviousVerticalScrollPos = this.mSelectionCursorManager.getVerticalScrollPos();
            if (z2) {
                updateSelection(f, f2);
            }
            this.mPositionX = (getCursorHorizontalPosition() - this.mHotspotX) - getHorizontalOffset();
            this.mPositionY = viewportToContentVerticalOffset(currentCursorPosition.y);
            this.mPositionHasChanged = true;
        }
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.PositionListener.TextViewPositionListener
    public void updatePosition(int i, int i2, boolean z, boolean z2) {
        PointF currentCursorPosition;
        View view = this.mHostViewRef.get();
        if (view == null || (currentCursorPosition = getCurrentCursorPosition()) == null) {
            return;
        }
        positionAtCursorPosition(currentCursorPosition.x, currentCursorPosition.y, z2);
        boolean z3 = (getVisibility() == 0) != isHandleOnVisibleVisibleArea();
        if (z || this.mPositionHasChanged || z3) {
            if (this.mIsDragging) {
                onHandleMoved();
            }
            int horizontalOffset = this.mPositionX + this.mHotspotX + getHorizontalOffset();
            int[] iArr = {horizontalOffset, this.mPositionY};
            iArr[0] = horizontalOffset - (this.mHotspotX + getHorizontalOffset());
            if (isShowing()) {
                this.mContainer.update(Math.max(iArr[0], 0), iArr[1], -1, -1);
            } else {
                try {
                    this.mContainer.showAtLocation(view, 0, Math.max(iArr[0], 0), iArr[1]);
                } catch (IllegalStateException unused) {
                }
            }
            this.mPositionHasChanged = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int intrinsicWidth = this.mDrawable.getIntrinsicWidth();
        int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
        int horizontalOffset = getHorizontalOffset();
        this.mDrawable.setBounds(horizontalOffset, 0, intrinsicWidth + horizontalOffset, intrinsicHeight);
        if (!isHandleOnVisibleVisibleArea() || isScrolling()) {
            return;
        }
        this.mDrawable.draw(canvas);
    }

    private int getHorizontalOffset() {
        int preferredWidth = getPreferredWidth();
        int intrinsicWidth = this.mDrawable.getIntrinsicWidth();
        int i = this.mHorizontalGravity;
        if (i != 3) {
            return i != 5 ? (preferredWidth - intrinsicWidth) / 2 : preferredWidth - intrinsicWidth;
        }
        return 0;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float fWidth;
        View view = this.mHostViewRef.get();
        if (view == null) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mLastParentX = this.mPositionListener.getPositionX();
            this.mLastParentY = this.mPositionListener.getPositionY();
            this.mLastParentXOnScreen = this.mPositionListener.getPositionXOnScreen();
            this.mLastParentYOnScreen = this.mPositionListener.getPositionYOnScreen();
            getLocationOnScreen(new int[2]);
            this.mTouchPosition.set(motionEvent.getRawX() - r0[0], motionEvent.getRawY() - r0[1]);
            setDraggingState(true);
        } else if (actionMasked == 1) {
            stopScrollHandleOutsideView();
            updateDrawable();
        } else if (actionMasked == 2) {
            float rawX = (motionEvent.getRawX() - this.mLastParentXOnScreen) + this.mLastParentX;
            float rawY = (motionEvent.getRawY() - this.mLastParentYOnScreen) + this.mLastParentY;
            view.getLocationOnScreen(new int[2]);
            float f = rawX - this.mLastParentX;
            float f2 = rawY - this.mLastParentY;
            Rect visibleRenderingArea = this.mSelectionCursorManager.getVisibleRenderingArea();
            if (visibleRenderingArea != null) {
                positionAtCursorPosition(Math.round(contentToViewportHorizontalOffset(Math.round(rawX - this.mTouchPosition.x))) + this.mHotspotX + getHorizontalOffset(), Math.round(contentToViewportVerticalOffset(Math.round(rawY - this.mTouchPosition.y)) + this.mTouchOffsetY), false);
                float scrollMargin = this.mSelectionCursorManager.getScrollMargin();
                if (visibleRenderingArea.height() > 2.0f * scrollMargin) {
                    if (f2 <= scrollMargin) {
                        if (isDragging()) {
                            this.mScrollingDirection.add(ScrollingDirection.SCROLLING_TOP);
                            float f3 = -f2;
                            fWidth = f3 > 0.0f ? f3 : 0.0f;
                            IDragHandleProvider dragHandler = this.mSelectionCursorManager.getDragHandler();
                            if (dragHandler != null) {
                                dragHandler.handleScrollUp(fWidth);
                            }
                        }
                    } else if (f2 >= visibleRenderingArea.height() - scrollMargin) {
                        if (isDragging()) {
                            fWidth = f2 - ((float) visibleRenderingArea.height()) > 0.0f ? f2 - visibleRenderingArea.height() : 0.0f;
                            this.mScrollingDirection.add(ScrollingDirection.SCROLLING_BOTTOM);
                            IDragHandleProvider dragHandler2 = this.mSelectionCursorManager.getDragHandler();
                            if (dragHandler2 != null) {
                                dragHandler2.handleScrollDown(fWidth);
                            }
                        }
                    } else if (f <= scrollMargin) {
                        if (isDragging()) {
                            this.mScrollingDirection.add(ScrollingDirection.SCROLLING_LEFT);
                            float f4 = -f;
                            fWidth = f4 > 0.0f ? f4 : 0.0f;
                            IDragHandleProvider dragHandler3 = this.mSelectionCursorManager.getDragHandler();
                            if (dragHandler3 != null) {
                                dragHandler3.handleScrollLeft(fWidth);
                            }
                        }
                    } else if (f >= visibleRenderingArea.width() - scrollMargin) {
                        if (isDragging()) {
                            fWidth = f - ((float) visibleRenderingArea.width()) > 0.0f ? f - visibleRenderingArea.width() : 0.0f;
                            this.mScrollingDirection.add(ScrollingDirection.SCROLLING_RIGHT);
                            IDragHandleProvider dragHandler4 = this.mSelectionCursorManager.getDragHandler();
                            if (dragHandler4 != null) {
                                dragHandler4.handleScrollRight(fWidth);
                            }
                        }
                    } else if (isDragging() && !this.mScrollingDirection.isEmpty()) {
                        IDragHandleProvider dragHandler5 = this.mSelectionCursorManager.getDragHandler();
                        if (dragHandler5 != null) {
                            dragHandler5.handleStopScroll();
                        }
                        this.mScrollingDirection = EnumSet.noneOf(ScrollingDirection.class);
                        if (this.mSelectionCursorManager.mMagnifierAnimator != null) {
                            post(this.mSelectionCursorManager.mUpdateMagnifierRunnable);
                        }
                    }
                } else {
                    setDraggingState(false);
                }
            }
        } else if (actionMasked == 3) {
            stopScrollHandleOutsideView();
            updateDrawable();
        }
        return true;
    }

    public void setDraggingListener(IDraggingListener iDraggingListener) {
        this.mDraggingListener = iDraggingListener;
    }

    private void setDraggingState(boolean z) {
        if (this.mIsDragging != z) {
            this.mIsDragging = z;
            IDraggingListener iDraggingListener = this.mDraggingListener;
            if (iDraggingListener != null) {
                iDraggingListener.onDraggingStateChanged(this);
            }
        }
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public boolean isScrolling() {
        return !this.mScrollingDirection.isEmpty();
    }

    private void stopScrollHandleOutsideView() {
        SelectionCursorManager.CursorPosition cursorPosition;
        if (isDragging()) {
            if (this.mScrollingDirection.contains(ScrollingDirection.SCROLLING_TOP)) {
                IDragHandleProvider dragHandler = this.mSelectionCursorManager.getDragHandler();
                if (dragHandler != null) {
                    dragHandler.handleStopScroll();
                }
                this.mScrollingDirection.remove(ScrollingDirection.SCROLLING_TOP);
                if (this.mLastIgnoredHandle != SelectionCursorManager.CursorType.CURSOR_TYPE_NONE) {
                    RectF handlePositionOverallRect = getHandlePositionOverallRect();
                    if (handlePositionOverallRect != null) {
                        this.mSelectionCursorManager.setCursorPosition(this.mLastIgnoredX, contentToViewportVerticalOffset(viewportToViewportAbsoluteVerticalOffset(Math.round(handlePositionOverallRect.height()))), this.mLastIgnoredHandle);
                    }
                    this.mLastIgnoredHandle = SelectionCursorManager.CursorType.CURSOR_TYPE_NONE;
                }
            }
            if (this.mScrollingDirection.contains(ScrollingDirection.SCROLLING_BOTTOM)) {
                IDragHandleProvider dragHandler2 = this.mSelectionCursorManager.getDragHandler();
                if (dragHandler2 != null) {
                    dragHandler2.handleStopScroll();
                }
                this.mScrollingDirection.remove(ScrollingDirection.SCROLLING_BOTTOM);
                if (this.mLastIgnoredHandle != SelectionCursorManager.CursorType.CURSOR_TYPE_NONE) {
                    RectF handlePositionOverallRect2 = getHandlePositionOverallRect();
                    Rect visibleRenderingArea = this.mSelectionCursorManager.getVisibleRenderingArea();
                    if (handlePositionOverallRect2 != null && visibleRenderingArea != null) {
                        SelectionCursorManager selectionCursorManager = this.mSelectionCursorManager;
                        if (this.mLastIgnoredHandle == (this.mSwapped ? SelectionCursorManager.CursorType.CURSOR_TYPE_RIGHT : SelectionCursorManager.CursorType.CURSOR_TYPE_LEFT)) {
                            cursorPosition = SelectionCursorManager.CursorPosition.START;
                        } else {
                            cursorPosition = SelectionCursorManager.CursorPosition.END;
                        }
                        this.mSelectionCursorManager.setCursorPosition(this.mLastIgnoredX, contentToViewportVerticalOffset(Math.round((visibleRenderingArea.bottom - Math.round(handlePositionOverallRect2.height())) - Math.round(selectionCursorManager.getCursorHeight(cursorPosition)))), this.mLastIgnoredHandle);
                    }
                    this.mLastIgnoredHandle = SelectionCursorManager.CursorType.CURSOR_TYPE_NONE;
                }
            }
            if (this.mScrollingDirection.contains(ScrollingDirection.SCROLLING_LEFT)) {
                IDragHandleProvider dragHandler3 = this.mSelectionCursorManager.getDragHandler();
                if (dragHandler3 != null) {
                    dragHandler3.handleStopScroll();
                }
                this.mScrollingDirection.remove(ScrollingDirection.SCROLLING_LEFT);
                if (this.mLastIgnoredHandle != SelectionCursorManager.CursorType.CURSOR_TYPE_NONE) {
                    RectF handlePositionOverallRect3 = getHandlePositionOverallRect();
                    if (handlePositionOverallRect3 != null) {
                        this.mSelectionCursorManager.setCursorPosition(contentToViewportHorizontalOffset(viewportToViewportAbsoluteHorizontalOffset(Math.round(handlePositionOverallRect3.width()))), this.mLastIgnoredY, this.mLastIgnoredHandle);
                    }
                    this.mLastIgnoredHandle = SelectionCursorManager.CursorType.CURSOR_TYPE_NONE;
                }
            }
            if (this.mScrollingDirection.contains(ScrollingDirection.SCROLLING_RIGHT)) {
                IDragHandleProvider dragHandler4 = this.mSelectionCursorManager.getDragHandler();
                if (dragHandler4 != null) {
                    dragHandler4.handleStopScroll();
                }
                this.mScrollingDirection.remove(ScrollingDirection.SCROLLING_RIGHT);
                if (this.mLastIgnoredHandle != SelectionCursorManager.CursorType.CURSOR_TYPE_NONE) {
                    RectF handlePositionOverallRect4 = getHandlePositionOverallRect();
                    if (handlePositionOverallRect4 != null) {
                        this.mSelectionCursorManager.setCursorPosition(contentToViewportHorizontalOffset(viewportToViewportAbsoluteHorizontalOffset(Math.round(handlePositionOverallRect4.width()))), this.mLastIgnoredY, this.mLastIgnoredHandle);
                    }
                    this.mLastIgnoredHandle = SelectionCursorManager.CursorType.CURSOR_TYPE_NONE;
                }
            }
            setDraggingState(false);
            this.mSelectionCursorManager.setCursorsSwapped(false);
            this.mSelectionCursorManager.updateCursorOrSelection(true);
        }
    }

    private boolean tooLargeTextForMagnifier() {
        MagnifierMotionAnimator magnifierMotionAnimator = this.mSelectionCursorManager.mMagnifierAnimator;
        if (magnifierMotionAnimator == null) {
            return false;
        }
        Magnifier magnifier = magnifierMotionAnimator.getMagnifier();
        return Math.max(this.mSelectionCursorManager.getCursorHeight(SelectionCursorManager.CursorPosition.START), this.mSelectionCursorManager.getCursorHeight(SelectionCursorManager.CursorPosition.END)) > ((float) Math.round(((float) magnifier.getHeight()) / magnifier.getZoom())) * 2.0f;
    }

    private boolean obtainMagnifierShowCoordinates(PointF pointF, SelectionCursorManager.CursorPosition cursorPosition) {
        float cursorHeight = this.mSelectionCursorManager.getCursorHeight(cursorPosition) / 2.0f;
        int[] iArr = {this.mPositionX + this.mHotspotX + getHorizontalOffset(), this.mPositionY};
        iArr[0] = Math.round(viewportToViewportRelativeHorizontalOffset(r1));
        iArr[1] = Math.round(viewportToViewportRelativeVerticalOffset(iArr[1]) - cursorHeight);
        pointF.x = iArr[0];
        pointF.y = iArr[1];
        return true;
    }

    private boolean handleOverlapsMagnifier(HandleView handleView, Rect rect) {
        PopupWindow popupWindow = handleView.mContainer;
        int[] iArr = new int[2];
        popupWindow.getContentView().getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return Rect.intersects(new Rect(i, i2, popupWindow.getContentView().getWidth() + i, popupWindow.getContentView().getHeight() + i2), rect);
    }

    private void updateVisibility(float f, float f2) {
        Point point = new Point(Math.round(f), Math.round(f2));
        MagnifierMotionAnimator magnifierMotionAnimator = this.mSelectionCursorManager.mMagnifierAnimator;
        if (magnifierMotionAnimator == null) {
            return;
        }
        Magnifier magnifier = magnifierMotionAnimator.getMagnifier();
        Rect rect = new Rect(point.x - (magnifier.getWidth() / 2), point.y - (magnifier.getWidth() / 2), point.x + (magnifier.getWidth() / 2), point.y + (magnifier.getWidth() / 2));
        setVisible(!handleOverlapsMagnifier(this, rect));
        HandleView otherSelectionHandle = getOtherSelectionHandle();
        if (otherSelectionHandle != null) {
            otherSelectionHandle.setVisible(!handleOverlapsMagnifier(otherSelectionHandle, rect));
        }
    }

    protected final void updateMagnifier(SelectionCursorManager.CursorPosition cursorPosition) {
        MagnifierMotionAnimator magnifierMotionAnimator = this.mSelectionCursorManager.mMagnifierAnimator;
        if (Build.VERSION.SDK_INT < 28 || magnifierMotionAnimator == null) {
            return;
        }
        PointF pointF = new PointF();
        if (!tooLargeTextForMagnifier() && obtainMagnifierShowCoordinates(pointF, cursorPosition)) {
            magnifierMotionAnimator.show(pointF.x, pointF.y);
            updateVisibility(pointF.x, pointF.y);
        } else {
            dismissMagnifier();
        }
    }

    protected final void dismissMagnifier() {
        MagnifierMotionAnimator magnifierMotionAnimator = this.mSelectionCursorManager.mMagnifierAnimator;
        if (Build.VERSION.SDK_INT < 28 || magnifierMotionAnimator == null) {
            return;
        }
        magnifierMotionAnimator.dismiss();
        setVisible(true);
        HandleView otherSelectionHandle = getOtherSelectionHandle();
        if (otherSelectionHandle != null) {
            otherSelectionHandle.setVisible(true);
        }
    }

    private void setVisible(boolean z) {
        this.mContainer.getContentView().setVisibility(z ? 0 : 4);
    }

    RectF getHandlePositionOverallRect() {
        PointF currentCursorPosition;
        if (getVisibility() != 0 || (currentCursorPosition = getCurrentCursorPosition()) == null) {
            return null;
        }
        return new RectF(contentToViewPortRelativeHorizontalOffset(currentCursorPosition.x) - this.mHotspotX, contentToViewPortRelativeVerticalOffset(currentCursorPosition.y), r1 + getWidth(), r0 + getHeight());
    }

    RectF getHandleOverallRect() {
        if (getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], getWidth() + r1, getHeight() + r0);
    }

    protected void showContextualMenu() {
        RectF rectFComputeSelectionRect = computeSelectionRect();
        this.mSelectionCursorManager.showContextualMenu(rectFComputeSelectionRect);
        this.mIsContextualMenuShown = true;
        this.mSelectionCursorManager.invalidateContextualMenu(rectFComputeSelectionRect);
    }

    protected void finishContextualMenu() {
        this.mSelectionCursorManager.finishContextualMenu();
        this.mIsContextualMenuShown = false;
    }

    private RectF computeSelectionRect() {
        PointF graphicalCursorStart = this.mSelectionCursorManager.getInputModel().getGraphicalCursorStart();
        PointF graphicalCursorEnd = this.mSelectionCursorManager.getInputModel().getGraphicalCursorEnd();
        if (graphicalCursorStart == null) {
            return new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        boolean z = this.mSelectionCursorManager.getInputModel().hasSelection() && graphicalCursorEnd != null;
        float cursorHeight = this.mSelectionCursorManager.getCursorHeight(SelectionCursorManager.CursorPosition.START);
        float f = graphicalCursorStart.x;
        float f2 = graphicalCursorStart.y - cursorHeight;
        return new RectF(f, f2, z ? graphicalCursorEnd.x : f, z ? graphicalCursorEnd.y : f2);
    }

    protected PointF positionFromStartTop() {
        PointF graphicalCursorStart = this.mSelectionCursorManager.getInputModel().getGraphicalCursorStart();
        if (graphicalCursorStart == null) {
            graphicalCursorStart = new PointF(0.0f, 0.0f);
        }
        return new PointF(graphicalCursorStart.x, graphicalCursorStart.y - this.mSelectionCursorManager.getCursorHeight(SelectionCursorManager.CursorPosition.START));
    }

    protected PointF positionFromEndTop() {
        PointF graphicalCursorEnd = this.mSelectionCursorManager.getInputModel().getGraphicalCursorEnd();
        if (graphicalCursorEnd == null) {
            graphicalCursorEnd = new PointF(0.0f, 0.0f);
        }
        return new PointF(graphicalCursorEnd.x, graphicalCursorEnd.y - this.mSelectionCursorManager.getCursorHeight(SelectionCursorManager.CursorPosition.END));
    }

    private Point getLocationInWindow() {
        View view = this.mHostViewRef.get();
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    float contentToViewportHorizontalOffset(int i) {
        if (getLocationInWindow() == null) {
            return 0.0f;
        }
        return (i - r0.x) + this.mSelectionCursorManager.getHorizontalScrollPos();
    }

    float contentToViewportVerticalOffset(int i) {
        if (getLocationInWindow() == null) {
            return 0.0f;
        }
        return (i - r0.y) + this.mSelectionCursorManager.getVerticalScrollPos();
    }

    float contentToViewportVerticalOffsetTemp(float f) {
        if (getLocationInWindow() == null) {
            return 0.0f;
        }
        return f - r0.y;
    }

    int viewportToContentHorizontalOffset(float f) {
        Point locationInWindow = getLocationInWindow();
        if (locationInWindow == null) {
            return 0;
        }
        return (((int) f) + locationInWindow.x) - this.mSelectionCursorManager.getHorizontalScrollPos();
    }

    int viewportToContentVerticalOffset(float f) {
        Point locationInWindow = getLocationInWindow();
        if (locationInWindow == null) {
            return 0;
        }
        return (((int) f) + locationInWindow.y) - this.mSelectionCursorManager.getVerticalScrollPos();
    }

    int viewportToViewportRelativeHorizontalOffset(int i) {
        Point locationInWindow = getLocationInWindow();
        if (locationInWindow == null) {
            return 0;
        }
        return i - locationInWindow.x;
    }

    int viewportToViewportRelativeVerticalOffset(int i) {
        Point locationInWindow = getLocationInWindow();
        if (locationInWindow == null) {
            return 0;
        }
        return i - locationInWindow.y;
    }

    int viewportToViewportAbsoluteHorizontalOffset(int i) {
        Point locationInWindow = getLocationInWindow();
        if (locationInWindow == null) {
            return 0;
        }
        return i + locationInWindow.x;
    }

    int viewportToViewportAbsoluteVerticalOffset(int i) {
        Point locationInWindow = getLocationInWindow();
        if (locationInWindow == null) {
            return 0;
        }
        return i + locationInWindow.y;
    }

    int contentToViewPortRelativeHorizontalOffset(float f) {
        if (getLocationInWindow() == null) {
            return 0;
        }
        return ((int) f) - this.mSelectionCursorManager.getHorizontalScrollPos();
    }

    int contentToViewPortRelativeVerticalOffset(float f) {
        if (getLocationInWindow() == null) {
            return 0;
        }
        return ((int) f) - this.mSelectionCursorManager.getVerticalScrollPos();
    }

    protected int getSelectionStart() {
        IntRange selection = this.mSelectionCursorManager.getInputModel().getSelection();
        if (selection != null) {
            return selection.start;
        }
        return -1;
    }

    protected int getSelectionEnd() {
        IntRange selection = this.mSelectionCursorManager.getInputModel().getSelection();
        if (selection != null) {
            return selection.end;
        }
        return -1;
    }
}
