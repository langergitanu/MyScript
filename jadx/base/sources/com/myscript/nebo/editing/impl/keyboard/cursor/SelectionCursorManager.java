package com.myscript.nebo.editing.impl.keyboard.cursor;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.Magnifier;
import com.myscript.android.utils.ScreenUtils;
import com.myscript.atk.core.IntInterval;
import com.myscript.atk.core.PointerInfo;
import com.myscript.atk.core.ViewTransform;
import com.myscript.nebo.editing.C6421R;
import com.myscript.nebo.editing.EditingController;
import com.myscript.nebo.editing.impl.keyboard.InputModel;
import com.myscript.nebo.editing.impl.keyboard.IntRange;
import com.myscript.nebo.editing.impl.keyboard.cursor.HandleView;
import com.myscript.nebo.editing.impl.p027ui.ContextualMenuManager;
import com.myscript.nebo.editing.impl.p027ui.DocumentRenderingView;
import com.myscript.nebo.editing.impl.p027ui.DocumentTouchController;
import com.myscript.snt.core.PageController;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class SelectionCursorManager implements DocumentTouchController.ScrollListener, ViewTreeObserver.OnTouchModeChangeListener, ViewTreeObserver.OnWindowAttachListener, HandleView.IDraggingListener, DocumentTouchController.ZoomListener {
    private static final boolean DBG = false;
    private static final int SCROLL_MARGIN_DEFAULT_VALUE = 5;
    private static final float SCROLL_MARGIN_PERCENT = 10.0f;
    private static final String TAG = "SelectionCursorManager";
    private final WeakReference<ContextualMenuManager> mContextualMenuManagerRef;
    private final int mCursorWidth;
    private WeakReference<CursorsView> mCursorsViewRef;
    private WeakReference<IDragHandleProvider> mDragHandlerRef;
    private final WeakReference<EditingController> mEditingCtrlRef;
    private final InputModel mInputModel;
    private final InsertionPointCursorController mInsertionPointCursorController;
    MagnifierMotionAnimator mMagnifierAnimator;
    private final SelectionModifierCursorController mSelectionModifierCursorController;
    private float mDefaultMargin = -1.0f;
    private boolean mIsHandleVisibleOnScrollOrZoom = false;
    private boolean mIsScrollingOrZooming = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    final Runnable mUpdateMagnifierRunnable = new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager.1
        @Override // java.lang.Runnable
        public void run() {
            SelectionCursorManager.this.mMagnifierAnimator.update();
        }
    };
    private final ViewTreeObserver.OnDrawListener mMagnifierOnDrawListener = new ViewTreeObserver.OnDrawListener() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager.2
        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            DocumentRenderingView renderingView = SelectionCursorManager.this.getRenderingView();
            if (SelectionCursorManager.this.mMagnifierAnimator == null || renderingView == null) {
                return;
            }
            renderingView.post(SelectionCursorManager.this.mUpdateMagnifierRunnable);
        }
    };

    public enum CursorPosition {
        START,
        END
    }

    public enum CursorType {
        CURSOR_TYPE_NONE,
        CURSOR_TYPE_LEFT,
        CURSOR_TYPE_RIGHT
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onHorizontalScrollDisabledChanged(boolean z) {
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoom(float f, float f2, float f3, boolean z) {
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoom(float f, DocumentTouchController.ZoomListener.ZoomFromReference zoomFromReference, boolean z) {
    }

    public SelectionCursorManager(EditingController editingController, DocumentRenderingView documentRenderingView, InputModel inputModel, ContextualMenuManager contextualMenuManager, IDragHandleProvider iDragHandleProvider, CursorsView cursorsView) {
        this.mDragHandlerRef = new WeakReference<>(null);
        this.mCursorsViewRef = new WeakReference<>(null);
        this.mEditingCtrlRef = new WeakReference<>(editingController);
        this.mInputModel = inputModel;
        this.mContextualMenuManagerRef = new WeakReference<>(contextualMenuManager);
        this.mDragHandlerRef = new WeakReference<>(iDragHandleProvider);
        this.mCursorsViewRef = new WeakReference<>(cursorsView);
        if (cursorsView != null) {
            cursorsView.setCursorManager(this);
        }
        this.mCursorWidth = documentRenderingView.getContext().getResources().getDimensionPixelSize(C6421R.dimen.keyboard_cursor_width);
        ViewTreeObserver viewTreeObserver = documentRenderingView.getViewTreeObserver();
        viewTreeObserver.addOnTouchModeChangeListener(this);
        viewTreeObserver.addOnWindowAttachListener(this);
        InsertionPointCursorController insertionPointCursorController = new InsertionPointCursorController(documentRenderingView, this);
        this.mInsertionPointCursorController = insertionPointCursorController;
        insertionPointCursorController.setDraggingListener(this);
        SelectionModifierCursorController selectionModifierCursorController = new SelectionModifierCursorController(documentRenderingView, this);
        this.mSelectionModifierCursorController = selectionModifierCursorController;
        selectionModifierCursorController.setDraggingListener(this);
        if (Build.VERSION.SDK_INT >= 28) {
            this.mMagnifierAnimator = new MagnifierMotionAnimator(new Magnifier(documentRenderingView), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DocumentRenderingView getRenderingView() {
        EditingController editingController = this.mEditingCtrlRef.get();
        if (editingController == null) {
            return null;
        }
        return editingController.getRenderingView();
    }

    public Rect getVisibleRenderingArea() {
        EditingController editingController = this.mEditingCtrlRef.get();
        if (editingController == null) {
            return null;
        }
        return editingController.getVisibleRenderingArea();
    }

    public IDragHandleProvider getDragHandler() {
        return this.mDragHandlerRef.get();
    }

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public void onWindowAttached() {
        DocumentRenderingView renderingView;
        if (this.mMagnifierAnimator == null || (renderingView = getRenderingView()) == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = renderingView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnDrawListener(this.mMagnifierOnDrawListener);
        }
    }

    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
    public void onWindowDetached() {
        DocumentRenderingView renderingView = getRenderingView();
        if (renderingView != null) {
            ViewTreeObserver viewTreeObserver = renderingView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                if (this.mMagnifierAnimator != null) {
                    viewTreeObserver.removeOnDrawListener(this.mMagnifierOnDrawListener);
                }
                viewTreeObserver.removeOnTouchModeChangeListener(this);
                viewTreeObserver.removeOnWindowAttachListener(this);
            }
        }
        this.mInsertionPointCursorController.getHandle().onDetached();
        this.mSelectionModifierCursorController.getStartHandle().onDetached();
        this.mSelectionModifierCursorController.getEndHandle().onDetached();
        finishContextualMenu();
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            return;
        }
        hideInsertionPointCursorController();
        hideSelectionModifierCursorController();
    }

    void hideInsertionPointCursorController() {
        this.mInsertionPointCursorController.hide(finishContextualMenu());
    }

    void hideSelectionModifierCursorController() {
        final boolean zFinishContextualMenu = finishContextualMenu();
        this.mHandler.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$hideSelectionModifierCursorController$0(zFinishContextualMenu);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideSelectionModifierCursorController$0(boolean z) {
        this.mSelectionModifierCursorController.hide(z);
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onScrollTo(int i, int i2) {
        this.mIsHandleVisibleOnScrollOrZoom |= this.mSelectionModifierCursorController.isActive() || this.mInsertionPointCursorController.isActive();
        this.mIsScrollingOrZooming = true;
        updateCursorOrSelection(false);
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onScrollEnd(int i, int i2) {
        onScrollTo(i, i2);
        this.mIsScrollingOrZooming = false;
        updateCursorOrSelection(this.mIsHandleVisibleOnScrollOrZoom);
        this.mIsHandleVisibleOnScrollOrZoom = false;
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoomStarted() {
        this.mIsHandleVisibleOnScrollOrZoom |= this.mSelectionModifierCursorController.isActive() || this.mInsertionPointCursorController.isActive();
        this.mIsScrollingOrZooming = true;
        updateCursorOrSelection(false);
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoomEnded() {
        this.mIsScrollingOrZooming = false;
        updateCursorOrSelection(this.mIsHandleVisibleOnScrollOrZoom);
        this.mIsHandleVisibleOnScrollOrZoom = false;
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ZoomListener
    public void onZoomAt(int i, int i2, float f, boolean z) {
        this.mInputModel.refreshGraphicalCursorsPosition();
        updateCursorOrSelection(this.mIsHandleVisibleOnScrollOrZoom);
    }

    public float getStartHandleHeight() {
        int preferredHeight;
        if (this.mInputModel.hasSelection()) {
            preferredHeight = this.mSelectionModifierCursorController.getStartHandle().getPreferredHeight();
        } else {
            preferredHeight = this.mInsertionPointCursorController.getHandle().getPreferredHeight();
        }
        return preferredHeight;
    }

    public float getEndHandleHeight() {
        int preferredHeight;
        if (this.mInputModel.hasSelection()) {
            preferredHeight = this.mSelectionModifierCursorController.getEndHandle().getPreferredHeight();
        } else {
            preferredHeight = this.mInsertionPointCursorController.getHandle().getPreferredHeight();
        }
        return preferredHeight;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.cursor.HandleView.IDraggingListener
    public void onDraggingStateChanged(HandleView handleView) {
        if (handleView.isDragging()) {
            this.mInputModel.beginBatchEdit(true, false);
        } else {
            this.mInputModel.endBatchEdit();
        }
    }

    public boolean isDraggingHandle() {
        return this.mInputModel.hasSelection() ? this.mSelectionModifierCursorController.isDraggingHandle() : this.mInsertionPointCursorController.isDraggingHandle();
    }

    boolean isScrollingUsingHandle() {
        return this.mInputModel.hasSelection() ? this.mSelectionModifierCursorController.isScrollingUsingHandle() : this.mInsertionPointCursorController.isScrollingUsingHandle();
    }

    float getScrollMargin() {
        EditingController editingController = this.mEditingCtrlRef.get();
        DocumentRenderingView renderingView = getRenderingView();
        if (renderingView == null || editingController == null) {
            return 0.0f;
        }
        if (this.mDefaultMargin == -1.0f) {
            this.mDefaultMargin = TypedValue.applyDimension(5, 5.0f, ScreenUtils.getFixedDisplayMetrics(renderingView.getContext()));
        }
        float f = this.mDefaultMargin;
        return editingController.getVisibleRenderingArea() != null ? Math.min(f, (r0.height() * 10.0f) / 100.0f) : f;
    }

    void showContextualMenu(RectF rectF) {
        IntRange selection;
        DocumentRenderingView renderingView;
        ContextualMenuManager contextualMenuManager = this.mContextualMenuManagerRef.get();
        EditingController editingController = this.mEditingCtrlRef.get();
        if (contextualMenuManager == null || editingController == null || (selection = this.mInputModel.getSelection()) == null || (renderingView = editingController.getRenderingView()) == null) {
            return;
        }
        contextualMenuManager.showContextualMenu(renderingView, rectF, new IntInterval(selection.start, selection.end), this.mInputModel.getText());
    }

    void invalidateContextualMenu(RectF rectF) {
        IntRange selection;
        ContextualMenuManager contextualMenuManager = this.mContextualMenuManagerRef.get();
        if (contextualMenuManager == null || (selection = this.mInputModel.getSelection()) == null) {
            return;
        }
        contextualMenuManager.invalidateContextualMenu(rectF, new IntInterval(selection.start, selection.end), this.mInputModel.getText());
    }

    public boolean finishContextualMenu() {
        ContextualMenuManager contextualMenuManager = this.mContextualMenuManagerRef.get();
        return contextualMenuManager != null && contextualMenuManager.finishContextualMenu();
    }

    int getHorizontalScrollPos() {
        EditingController editingController = this.mEditingCtrlRef.get();
        if (editingController != null) {
            return editingController.getTouchFeatureImpl().getHorizontalScrollPos();
        }
        return 0;
    }

    int getVerticalScrollPos() {
        EditingController editingController = this.mEditingCtrlRef.get();
        if (editingController != null) {
            return editingController.getTouchFeatureImpl().getVerticalScrollPos();
        }
        return 0;
    }

    InputModel getInputModel() {
        return this.mInputModel;
    }

    public void swapCursors() {
        if (this.mInputModel.hasSelection()) {
            this.mSelectionModifierCursorController.swapCursors();
        }
    }

    public boolean cursorsSwapped() {
        return this.mInputModel.hasSelection() && this.mSelectionModifierCursorController.cursorsSwapped();
    }

    void setCursorsSwapped(boolean z) {
        if (this.mInputModel.hasSelection()) {
            this.mSelectionModifierCursorController.setCursorsSwapped(z);
        }
    }

    void onHandleDoubleTap(MotionEvent motionEvent) {
        IDragHandleProvider iDragHandleProvider = this.mDragHandlerRef.get();
        if (iDragHandleProvider != null) {
            iDragHandleProvider.onDoubleTap(motionEvent);
        }
    }

    public float getCursorHeight(CursorPosition cursorPosition) {
        float fScaleY;
        Pair<Float, Float> graphicalCursorHeights = this.mInputModel.getGraphicalCursorHeights();
        float fFloatValue = ((Float) graphicalCursorHeights.first).floatValue();
        float fFloatValue2 = ((Float) (((Float) graphicalCursorHeights.second).floatValue() != -1.0f ? graphicalCursorHeights.second : graphicalCursorHeights.first)).floatValue();
        if (cursorPosition != (cursorsSwapped() ? CursorPosition.END : CursorPosition.START)) {
            fFloatValue = fFloatValue2;
        }
        EditingController editingController = this.mEditingCtrlRef.get();
        ViewTransform viewTransform = null;
        PageController pageControllerNewRef = editingController != null ? editingController.getPageControllerNewRef() : null;
        if (pageControllerNewRef != null) {
            try {
                viewTransform = pageControllerNewRef.getViewTransform();
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (viewTransform != null) {
            try {
                fScaleY = fFloatValue / viewTransform.scaleY();
            } finally {
            }
        } else {
            fScaleY = 0.0f;
        }
        if (viewTransform != null) {
            viewTransform.close();
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
        return fScaleY;
    }

    void setCursorPosition(float f, float f2, CursorType cursorType) {
        int i = cursorType == CursorType.CURSOR_TYPE_LEFT ? 1 : 0;
        float f3 = f2 - 0.1875f;
        EditingController editingController = this.mEditingCtrlRef.get();
        PageController pageControllerNewRef = editingController != null ? editingController.getPageControllerNewRef() : null;
        if (pageControllerNewRef != null) {
            try {
                PointF graphicalCursorStart = i != 0 ? this.mInputModel.getGraphicalCursorStart() : this.mInputModel.getGraphicalCursorEnd();
                if (graphicalCursorStart == null || graphicalCursorStart.x != f || graphicalCursorStart.y != f2) {
                    pageControllerNewRef.setCursorPosition(i ^ 1, new PointerInfo(f, f3), true);
                }
            } catch (Throwable th) {
                if (pageControllerNewRef != null) {
                    try {
                        pageControllerNewRef.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (pageControllerNewRef != null) {
            pageControllerNewRef.close();
        }
    }

    public void updateCursorOrSelection(boolean z) {
        DocumentRenderingView renderingView = getRenderingView();
        if (renderingView == null) {
            return;
        }
        boolean zIsDraggingHandle = (z | isDraggingHandle()) & renderingView.isInTouchMode();
        final boolean z2 = false;
        boolean z3 = this.mInputModel.hasSelection() && this.mInputModel.getGraphicalCursorEnd() == null;
        boolean z4 = zIsDraggingHandle & (!z3);
        if (this.mInputModel.hasSelection() && !z3) {
            hideCursor();
            if (z4 != this.mSelectionModifierCursorController.isActive()) {
                if (z4) {
                    hideInsertionPointCursorController();
                    Handler handler = this.mHandler;
                    final SelectionModifierCursorController selectionModifierCursorController = this.mSelectionModifierCursorController;
                    Objects.requireNonNull(selectionModifierCursorController);
                    handler.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            selectionModifierCursorController.show();
                        }
                    });
                    return;
                }
                hideSelectionModifierCursorController();
                return;
            }
            return;
        }
        if (this.mSelectionModifierCursorController.isActive()) {
            hideSelectionModifierCursorController();
        }
        if (z4 != this.mInsertionPointCursorController.isActive()) {
            if (z4) {
                hideSelectionModifierCursorController();
                this.mInsertionPointCursorController.show();
            } else {
                hideInsertionPointCursorController();
            }
        }
        if (this.mInputModel.hasPosition()) {
            if (!isDraggingHandle() && !this.mIsScrollingOrZooming) {
                z2 = true;
            }
            final CursorsView cursorsView = this.mCursorsViewRef.get();
            if (cursorsView != null) {
                cursorsView.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        cursorsView.showCursor(z2);
                    }
                });
            }
        }
    }

    public void hideCursorOrSelection() {
        hideCursor();
        if (this.mSelectionModifierCursorController.isActive()) {
            hideSelectionModifierCursorController();
            invalidateCursor();
        }
    }

    private void invalidateCursor() {
        RectF cursorOrSelectionRegion;
        CursorsView cursorsView = this.mCursorsViewRef.get();
        if (cursorsView == null || (cursorOrSelectionRegion = getCursorOrSelectionRegion()) == null) {
            return;
        }
        Rect rect = new Rect();
        cursorOrSelectionRegion.roundOut(rect);
        cursorsView.invalidate(rect);
    }

    RectF getCursorRegion() {
        PointF graphicalCursorStart = this.mInputModel.getGraphicalCursorStart();
        if (graphicalCursorStart == null) {
            return null;
        }
        float fRound = Math.round(graphicalCursorStart.x - getHorizontalScrollPos());
        float fRound2 = Math.round(graphicalCursorStart.y - getVerticalScrollPos());
        float f = this.mCursorWidth / 2.0f;
        return new RectF(fRound - f, fRound2 - getCursorHeight(CursorPosition.START), fRound + f, fRound2);
    }

    public RectF getCursorOrSelectionRegion() {
        if (this.mInputModel.hasSelection()) {
            PointF graphicalCursorStart = this.mInputModel.getGraphicalCursorStart();
            PointF graphicalCursorEnd = this.mInputModel.getGraphicalCursorEnd();
            if (graphicalCursorStart == null || graphicalCursorEnd == null) {
                return null;
            }
            int horizontalScrollPos = getHorizontalScrollPos();
            float f = horizontalScrollPos;
            float verticalScrollPos = getVerticalScrollPos();
            return new RectF(graphicalCursorStart.x - f, (graphicalCursorStart.y - getCursorHeight(CursorPosition.START)) - verticalScrollPos, graphicalCursorEnd.x - f, graphicalCursorEnd.y - verticalScrollPos);
        }
        if (this.mInputModel.hasPosition()) {
            return getCursorRegion();
        }
        return null;
    }

    private void hideCursor() {
        if (this.mInsertionPointCursorController.isActive()) {
            hideInsertionPointCursorController();
        }
        final CursorsView cursorsView = this.mCursorsViewRef.get();
        if (cursorsView != null) {
            Objects.requireNonNull(cursorsView);
            cursorsView.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    cursorsView.hideCursor();
                }
            });
        }
    }

    public void cancelMessages() {
        CursorsView cursorsView = this.mCursorsViewRef.get();
        if (cursorsView != null) {
            cursorsView.release();
        }
    }

    public Boolean isMagnifierShowing() {
        MagnifierMotionAnimator magnifierMotionAnimator = this.mMagnifierAnimator;
        return Boolean.valueOf(magnifierMotionAnimator != null && magnifierMotionAnimator.isShowing().booleanValue());
    }
}
