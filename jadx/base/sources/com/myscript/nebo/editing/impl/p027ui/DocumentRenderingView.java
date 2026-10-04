package com.myscript.nebo.editing.impl.p027ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.InvalidateType;
import com.myscript.atk.core.p020ui.IUpdatableRendering;
import com.myscript.nebo.editing.C6421R;
import com.myscript.nebo.editing.EditingController;
import com.myscript.nebo.editing.impl.keyboard.IKeyboardViewCallback;
import com.myscript.nebo.editing.impl.keyboard.KeyboardListener;
import com.myscript.nebo.editing.impl.p027ui.DocumentTouchController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentRenderingView extends View implements DocumentTouchController.ScrollListener, KeyboardListener.KeyboardVisibilityListener, IUpdatableRendering {
    private static final boolean DBG = false;
    public static final float DEFAULT_FONT_SIZE = 16.0f;
    public static final float DEFAULT_LINE_HEIGHT = 1.5f;
    private static final String TAG = "DocumentRenderingView";
    private EditingController mEditingController;
    private final float mFontSize;
    private final Rect mGestureExclusionRectangle;
    private final List<Rect> mGestureExclusionRectangles;
    private PointerIcon mHoverPointerIcon;
    private boolean mInteractionAllowed;
    private final boolean mKeyboardEnabled;
    private WeakReference<IKeyboardViewCallback> mKeyboardHandlerRef;
    private final float mLineHeight;
    private RendererWrapper mRendererWrapper;
    private OnResizeListener mResizeListener;
    private View.OnHoverListener mSecondaryHoverListener;
    private WeakReference<DocumentTouchController> mTouchControllerRef;

    public interface OnResizeListener {
        void onBeforeResize(int i, int i2);

        void onResize(int i, int i2);
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onScrollEnd(int i, int i2) {
    }

    public void setHoverPointerIcon(PointerIcon pointerIcon) {
        this.mHoverPointerIcon = pointerIcon;
    }

    @Override // android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        PointerIcon pointerIcon = this.mHoverPointerIcon;
        return pointerIcon != null ? pointerIcon : super.onResolvePointerIcon(motionEvent, i);
    }

    public DocumentRenderingView(Context context) {
        this(context, null, 0, 0);
    }

    public DocumentRenderingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }

    public DocumentRenderingView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DocumentRenderingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mKeyboardHandlerRef = new WeakReference<>(null);
        this.mTouchControllerRef = new WeakReference<>(null);
        this.mInteractionAllowed = true;
        ArrayList arrayList = new ArrayList();
        this.mGestureExclusionRectangles = arrayList;
        Rect rect = new Rect();
        this.mGestureExclusionRectangle = rect;
        this.mHoverPointerIcon = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6421R.styleable.DocumentRenderingView, i, i2);
        try {
            this.mFontSize = typedArrayObtainStyledAttributes.getFloat(C6421R.styleable.DocumentRenderingView_text_fontSize, 16.0f);
            this.mLineHeight = typedArrayObtainStyledAttributes.getFloat(C6421R.styleable.DocumentRenderingView_text_lineHeight, 1.5f);
            this.mInteractionAllowed = typedArrayObtainStyledAttributes.getBoolean(C6421R.styleable.DocumentRenderingView_interactionAllowed, true);
            this.mKeyboardEnabled = typedArrayObtainStyledAttributes.getBoolean(C6421R.styleable.DocumentRenderingView_keyboardInputEnabled, true);
            typedArrayObtainStyledAttributes.recycle();
            if (isInEditMode()) {
                return;
            }
            setFocusable(true);
            setClickable(true);
            setLongClickable(true);
            setFocusableInTouchMode(true);
            if (Build.VERSION.SDK_INT >= 33) {
                setAutoHandwritingEnabled(false);
            }
            final int dimensionPixelSize = getResources().getDimensionPixelSize(C6421R.dimen.gesture_exclusion_zone_height);
            arrayList.add(rect);
            if (Build.VERSION.SDK_INT >= 29) {
                setOnHoverListener(new View.OnHoverListener() { // from class: com.myscript.nebo.editing.impl.ui.DocumentRenderingView$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnHoverListener
                    public final boolean onHover(View view, MotionEvent motionEvent) {
                        return this.f$0.lambda$new$0(dimensionPixelSize, view, motionEvent);
                    }
                });
            }
            addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.myscript.nebo.editing.impl.ui.DocumentRenderingView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
                    this.f$0.lambda$new$1(view, i3, i4, i5, i6, i7, i8, i9, i10);
                }
            });
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(int i, View view, MotionEvent motionEvent) {
        float f = i / 2;
        this.mGestureExclusionRectangle.set(getLeft(), (int) (motionEvent.getY() - f), getRight(), (int) (motionEvent.getY() + f));
        setSystemGestureExclusionRects(this.mGestureExclusionRectangles);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Rect rect = new Rect(i5, i6, i7, i8);
        Rect rect2 = new Rect(i, i2, i3, i4);
        if (rect2.width() == rect.width() && rect2.height() == rect.height()) {
            return;
        }
        postInvalidate();
    }

    public boolean isInteractionAllowed() {
        return this.mInteractionAllowed;
    }

    public float getDefaultFontSize() {
        return this.mFontSize;
    }

    public float getDefaultLineHeight() {
        return this.mLineHeight;
    }

    public void setEditingController(EditingController editingController) {
        this.mEditingController = editingController;
    }

    public void setSecondaryHoverListener(View.OnHoverListener onHoverListener) {
        this.mSecondaryHoverListener = onHoverListener;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        int action;
        View.OnHoverListener onHoverListener = this.mSecondaryHoverListener;
        if (onHoverListener != null && ((action = motionEvent.getAction()) == 9 || action == 7 || action == 10)) {
            onHoverListener.onHover(this, motionEvent);
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public EditingController getEditingController() {
        return this.mEditingController;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.mResizeListener != null && getLayerType() != 2) {
            this.mResizeListener.onBeforeResize(i, i2);
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mResizeListener == null || getLayerType() == 2) {
            return;
        }
        this.mResizeListener.onResize(i, i2);
    }

    public void setResizeListener(OnResizeListener onResizeListener) {
        this.mResizeListener = onResizeListener;
    }

    public void setDocumentTouchController(DocumentTouchController documentTouchController) {
        this.mTouchControllerRef = new WeakReference<>(documentTouchController);
    }

    public void setRenderingThread(RendererWrapper rendererWrapper) {
        this.mRendererWrapper = rendererWrapper;
    }

    private int validInvalidateType() {
        return InvalidateType.DOCUMENT.swigValue() | InvalidateType.CAPTURE.swigValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        DocumentTouchController documentTouchController;
        if (Build.VERSION.SDK_INT >= 35 && (documentTouchController = this.mTouchControllerRef.get()) != null && documentTouchController.isWriting()) {
            setRequestedFrameRate(-4.0f);
        }
        RendererWrapper rendererWrapper = this.mRendererWrapper;
        if (rendererWrapper != null) {
            rendererWrapper.handleRenderingRequest(canvas, validInvalidateType());
        }
    }

    @Override // com.myscript.atk.core.p020ui.IUpdatableRendering
    public void invalidate(int i) {
        if (this.mRendererWrapper == null || (i & validInvalidateType()) == 0) {
            return;
        }
        postInvalidate();
    }

    @Override // com.myscript.atk.core.p020ui.IUpdatableRendering
    public void invalidate(Extent extent, int i) {
        if (this.mRendererWrapper == null || (i & validInvalidateType()) == 0) {
            return;
        }
        Rect rect = new Rect();
        if (this.mRendererWrapper.extentToViewRect(extent, rect)) {
            if (rect.intersect(0, 0, getWidth(), getHeight())) {
                postInvalidate(rect.left, rect.top, rect.right, rect.bottom);
                return;
            }
            return;
        }
        postInvalidate();
    }

    public void release() {
        this.mGestureExclusionRectangle.setEmpty();
        this.mGestureExclusionRectangles.clear();
        if (Build.VERSION.SDK_INT >= 29) {
            setSystemGestureExclusionRects(this.mGestureExclusionRectangles);
        }
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.mInteractionAllowed) {
            return false;
        }
        if (!isInEditMode() && isAttachedToWindow()) {
            DocumentTouchController documentTouchController = this.mTouchControllerRef.get();
            if (documentTouchController != null && documentTouchController.manageTouchEvent(motionEvent)) {
                z = true;
            }
            int action = motionEvent.getAction();
            if (documentTouchController != null && documentTouchController.isWriting() && action == 2) {
                requestUnbufferedDispatch(motionEvent);
            }
        }
        return z;
    }

    public void setInteractionAllowed(boolean z) {
        this.mInteractionAllowed = z;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        DocumentTouchController documentTouchController;
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && (documentTouchController = this.mTouchControllerRef.get()) != null) {
            return documentTouchController.onWheel(motionEvent.getAxisValue(9) * 40.0f);
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onScrollTo(int i, int i2) {
        awakenScrollBars();
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.ScrollListener
    public void onHorizontalScrollDisabledChanged(boolean z) {
        setHorizontalScrollBarEnabled(!z);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        if (isInEditMode()) {
            return 0;
        }
        return getWidth();
    }

    @Override // android.view.View
    protected int computeVerticalScrollExtent() {
        if (isInEditMode()) {
            return 0;
        }
        return getHeight();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        DocumentTouchController documentTouchController = this.mTouchControllerRef.get();
        if (isInEditMode() || documentTouchController == null) {
            return 0;
        }
        return documentTouchController.getHorizontalScrollLimitInViewRange();
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        DocumentTouchController documentTouchController = this.mTouchControllerRef.get();
        if (isInEditMode() || documentTouchController == null) {
            return 0;
        }
        return documentTouchController.getVerticalScrollLimitInViewRange();
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        DocumentTouchController documentTouchController = this.mTouchControllerRef.get();
        if (documentTouchController != null) {
            return documentTouchController.getOverallHorizontalScrollPx();
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeVerticalScrollOffset() {
        DocumentTouchController documentTouchController = this.mTouchControllerRef.get();
        if (documentTouchController != null) {
            return documentTouchController.getOverallVerticalScrollPx();
        }
        return 0;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IKeyboardViewCallback iKeyboardViewCallback;
        if (isEnabled() && (iKeyboardViewCallback = this.mKeyboardHandlerRef.get()) != null) {
            return iKeyboardViewCallback.doKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        IKeyboardViewCallback iKeyboardViewCallback;
        if (isEnabled() && (iKeyboardViewCallback = this.mKeyboardHandlerRef.get()) != null) {
            return iKeyboardViewCallback.doKeyMultiple(i, i2, keyEvent);
        }
        return super.onKeyMultiple(i, i2, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        IKeyboardViewCallback iKeyboardViewCallback;
        if (isEnabled() && (iKeyboardViewCallback = this.mKeyboardHandlerRef.get()) != null) {
            return iKeyboardViewCallback.doKeyUp(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void configureKeyboardSupport(IKeyboardViewCallback iKeyboardViewCallback) {
        if (this.mKeyboardEnabled) {
            this.mKeyboardHandlerRef = new WeakReference<>(iKeyboardViewCallback);
            setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.myscript.nebo.editing.impl.ui.DocumentRenderingView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    this.f$0.lambda$configureKeyboardSupport$2(view, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureKeyboardSupport$2(View view, boolean z) {
        IKeyboardViewCallback iKeyboardViewCallback = this.mKeyboardHandlerRef.get();
        if (iKeyboardViewCallback != null) {
            iKeyboardViewCallback.onFocusChanged(view, z);
        }
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return this.mKeyboardHandlerRef.get() != null;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        DocumentTouchController documentTouchController = this.mTouchControllerRef.get();
        if (documentTouchController != null) {
            documentTouchController.addExtraSpaceForKeyboard();
        }
        IKeyboardViewCallback iKeyboardViewCallback = this.mKeyboardHandlerRef.get();
        if (iKeyboardViewCallback != null) {
            return iKeyboardViewCallback.onCreateInputConnection(editorInfo);
        }
        return super.onCreateInputConnection(editorInfo);
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.KeyboardListener.KeyboardVisibilityListener
    public void onKeyboardHidden() {
        IKeyboardViewCallback iKeyboardViewCallback = this.mKeyboardHandlerRef.get();
        if (iKeyboardViewCallback != null) {
            iKeyboardViewCallback.enableFocusLostProcessing(true);
            if (hasFocus()) {
                clearFocus();
                return;
            }
            iKeyboardViewCallback.onFocusChanged(this, false);
            DocumentTouchController documentTouchController = this.mTouchControllerRef.get();
            if (documentTouchController != null) {
                documentTouchController.removeExtraSpaceForKeyboard();
            }
        }
    }
}
