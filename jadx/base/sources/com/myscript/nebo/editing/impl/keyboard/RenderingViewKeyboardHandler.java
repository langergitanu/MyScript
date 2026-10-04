package com.myscript.nebo.editing.impl.keyboard;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.method.TextKeyListener;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow;
import com.myscript.atk.core.ContentTypes;
import com.myscript.atk.core.KeyboardAction;
import com.myscript.atk.core.PointerInfo;
import com.myscript.nebo.editing.impl.keyboard.InputModel;
import com.myscript.nebo.editing.impl.keyboard.cursor.SelectionCursorManager;
import com.myscript.nebo.editing.impl.p027ui.DocumentTouchController;
import com.myscript.snt.core.PageController;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class RenderingViewKeyboardHandler implements InputModel.InputModelListener, ViewTreeObserver.OnGlobalLayoutListener, DocumentTouchController.GestureListener, IKeyboardViewCallback {
    private static final boolean DBG = false;
    private static final String TAG = "RenderingViewKeyboardHandler";
    private Handler mIMDisplayHandler;
    private final InputMethodManager mIMM;
    private final InputModel mInputModel;
    private IntRange mKeyEditableSelection;
    private Handler mLayoutHandler;
    private PageController mPageController;
    private View mPopupView;
    private PopupWindow mPopupWindow;
    private SelectionCursorManager mSelectionCursorManager;
    private WeakReference<View> mTargetViewRef;
    private final WeakReference<DocumentTouchController> mTouchControllerRef;
    private boolean mProcessFocusLost = true;
    private boolean mShowIMOnNewLayout = false;
    private int mCurrentWindowHeight = 0;
    private boolean mIsKeyboardShown = false;
    private boolean mSingleTapTransaction = false;
    private boolean mIgnoreSingleTap = false;
    private PointF mLastCursorStart = null;
    private PointF mLastCursorEnd = null;
    private Editable mKeyEditable = new SpannableStringBuilder();
    private boolean mNeedToCheckCursorVisibility = false;

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.GestureListener
    public void onDoubleTap(MotionEvent motionEvent) {
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.GestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.GestureListener
    public void onLongPressPost(MotionEvent motionEvent) {
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.GestureListener
    public void onLongPressPre(MotionEvent motionEvent) {
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.GestureListener
    public void onSingleTapUp(MotionEvent motionEvent) {
    }

    public RenderingViewKeyboardHandler(View view, PageController pageController, InputModel inputModel, SelectionCursorManager selectionCursorManager, DocumentTouchController documentTouchController) {
        this.mInputModel = inputModel;
        inputModel.setInputModelListener(this);
        this.mTargetViewRef = new WeakReference<>(view);
        this.mPageController = PageController.newRef(pageController);
        this.mSelectionCursorManager = selectionCursorManager;
        this.mTouchControllerRef = new WeakReference<>(documentTouchController);
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager == null) {
            throw new RuntimeException("Unable to find InputMethodService");
        }
        this.mIMM = inputMethodManager;
        this.mLayoutHandler = new Handler(Looper.getMainLooper());
        this.mIMDisplayHandler = new Handler(Looper.getMainLooper());
        PopupWindow popupWindow = new PopupWindow(view.getContext(), (AttributeSet) null, 0);
        this.mPopupWindow = popupWindow;
        popupWindow.setTouchable(false);
        this.mPopupWindow.setSoftInputMode(21);
        this.mPopupWindow.setInputMethodMode(1);
        this.mPopupView = new View(view.getContext(), null, 0);
        this.mPopupView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mPopupWindow.setContentView(this.mPopupView);
        this.mPopupWindow.setWidth(0);
        this.mPopupWindow.setHeight(-1);
    }

    public static Activity getActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private void enableIMDetection(boolean z) {
        View viewFindViewById;
        if (z) {
            Activity activity = getActivity(this.mPopupView.getContext());
            if (activity == null || activity.isFinishing() || activity.isDestroyed() || (viewFindViewById = activity.findViewById(R.id.content)) == null) {
                return;
            }
            this.mPopupView.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.mPopupWindow.showAtLocation(viewFindViewById, 0, 0, 0);
            return;
        }
        this.mPopupView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.mPopupWindow.dismiss();
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.IKeyboardViewCallback
    /* JADX INFO: renamed from: onFocusChanged, reason: merged with bridge method [inline-methods] */
    public void lambda$onFocusChanged$0(final View view, final boolean z) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.mLayoutHandler.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.RenderingViewKeyboardHandler$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onFocusChanged$0(view, z);
                }
            });
            return;
        }
        View view2 = this.mTargetViewRef.get();
        if (view2 == null || view2.getId() != view.getId()) {
            return;
        }
        if (!z) {
            if (this.mProcessFocusLost) {
                this.mInputModel.clear();
                this.mSelectionCursorManager.hideCursorOrSelection();
                this.mSelectionCursorManager.finishContextualMenu();
                PageController pageController = this.mPageController;
                if (pageController != null && this.mIsKeyboardShown) {
                    pageController.keyboardAction(KeyboardAction.CLOSE);
                    this.mIsKeyboardShown = false;
                }
                this.mIMDisplayHandler.removeCallbacksAndMessages(null);
                enableIMDetection(false);
                this.mIMM.hideSoftInputFromWindow(view2.getWindowToken(), 0);
                this.mLastCursorStart = null;
                this.mLastCursorEnd = null;
                return;
            }
            this.mShowIMOnNewLayout = true;
            return;
        }
        this.mLastCursorStart = null;
        this.mLastCursorEnd = null;
        requestShowIM(0);
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.IKeyboardViewCallback
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (this.mTargetViewRef.get() != null) {
            requestShowIM(0);
        }
        NeboInputConnection neboInputConnection = new NeboInputConnection(this);
        editorInfo.initialSelStart = 0;
        editorInfo.initialSelEnd = 0;
        editorInfo.inputType = 147457;
        editorInfo.imeOptions = 1073741824;
        editorInfo.imeOptions |= 268435456;
        editorInfo.imeOptions |= 33554432;
        editorInfo.privateImeOptions = "com.lge.android.editmode.noContent";
        editorInfo.initialCapsMode = 0;
        return neboInputConnection;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.mLayoutHandler.removeCallbacksAndMessages(null);
        this.mLayoutHandler.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.RenderingViewKeyboardHandler$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onGlobalLayout$1();
            }
        });
        if (this.mShowIMOnNewLayout) {
            requestShowIM(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGlobalLayout$1() {
        Rect rect = new Rect();
        this.mPopupView.getWindowVisibleDisplayFrame(rect);
        if (this.mCurrentWindowHeight != rect.height()) {
            this.mCurrentWindowHeight = rect.height();
            ensureCursorVisible(false, true);
        } else if (this.mNeedToCheckCursorVisibility) {
            ensureCursorVisible(true, true);
        }
    }

    private void requestShowIM(int i) {
        enableIMDetection(true);
        this.mIMDisplayHandler.removeCallbacksAndMessages(null);
        this.mIMDisplayHandler.postDelayed(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.RenderingViewKeyboardHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$requestShowIM$2();
            }
        }, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestShowIM$2() {
        View view = this.mTargetViewRef.get();
        if (view != null && view.hasFocus() && this.mIMM.showSoftInput(view, 0)) {
            this.mIsKeyboardShown = true;
            DocumentTouchController documentTouchController = this.mTouchControllerRef.get();
            if (documentTouchController != null) {
                documentTouchController.addExtraSpaceForKeyboard();
            }
            this.mShowIMOnNewLayout = false;
        }
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.InputModel.InputModelListener
    public void onGraphicalCursorChanged() {
        boolean zHasSelection = this.mInputModel.hasSelection();
        this.mSelectionCursorManager.updateCursorOrSelection(!this.mInputModel.getText().isEmpty() && ((this.mInputModel.hasPosition() && this.mSingleTapTransaction) || zHasSelection));
        this.mNeedToCheckCursorVisibility = true;
        this.mLayoutHandler.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.RenderingViewKeyboardHandler$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onGraphicalCursorChanged$3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGraphicalCursorChanged$3() {
        ensureCursorVisible(true, false);
    }

    public Rect getVisibleRenderingArea() {
        View view = this.mTargetViewRef.get();
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        if (this.mPopupWindow.isShowing()) {
            Rect rect2 = new Rect();
            this.mPopupView.getWindowVisibleDisplayFrame(rect2);
            rect.top = rect2.top;
            rect.bottom = rect2.bottom;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        Rect rect3 = new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
        if (rect3.intersect(rect)) {
            return rect3;
        }
        return null;
    }

    private void ensureCursorVisible(boolean z, boolean z2) {
        Rect visibleRenderingArea;
        PointF pointF;
        Integer numValueOf;
        DocumentTouchController documentTouchController;
        DocumentTouchController documentTouchController2;
        float fMax;
        PointF pointF2;
        PointF pointF3;
        this.mNeedToCheckCursorVisibility = false;
        Integer numValueOf2 = null;
        if (this.mSelectionCursorManager.isDraggingHandle()) {
            this.mLastCursorStart = null;
            this.mLastCursorEnd = null;
            return;
        }
        View view = this.mTargetViewRef.get();
        if ((this.mInputModel.hasSelection() || this.mInputModel.hasPosition()) && (visibleRenderingArea = getVisibleRenderingArea()) != null) {
            Rect rect = new Rect(visibleRenderingArea);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            rect.offset(-iArr[0], -iArr[1]);
            RectF cursorOrSelectionRegion = this.mSelectionCursorManager.getCursorOrSelectionRegion();
            if (cursorOrSelectionRegion == null) {
                return;
            }
            PointF graphicalCursorStart = this.mInputModel.getGraphicalCursorStart();
            PointF graphicalCursorEnd = this.mInputModel.getGraphicalCursorEnd();
            float fMax2 = Math.max(this.mSelectionCursorManager.getCursorHeight(SelectionCursorManager.CursorPosition.START), this.mSelectionCursorManager.getCursorHeight(SelectionCursorManager.CursorPosition.END));
            float fMax3 = 0.0f;
            if (this.mInputModel.hasSelection()) {
                if (graphicalCursorStart == null || (pointF3 = this.mLastCursorStart) == null || graphicalCursorStart.equals(pointF3)) {
                    if ((graphicalCursorEnd != null && (pointF2 = this.mLastCursorEnd) != null && !graphicalCursorEnd.equals(pointF2)) || z2) {
                        pointF = new PointF(cursorOrSelectionRegion.right, cursorOrSelectionRegion.bottom - fMax2);
                        fMax = Math.max(16.0f, fMax2 + this.mSelectionCursorManager.getEndHandleHeight());
                    }
                    pointF = null;
                } else {
                    pointF = new PointF(cursorOrSelectionRegion.right, cursorOrSelectionRegion.top);
                    fMax = Math.max(16.0f, fMax2 + this.mSelectionCursorManager.getStartHandleHeight());
                }
                fMax3 = fMax;
            } else if (this.mInputModel.hasPosition()) {
                pointF = new PointF(cursorOrSelectionRegion.right, cursorOrSelectionRegion.top);
                fMax3 = Math.max(16.0f, fMax2 + this.mSelectionCursorManager.getStartHandleHeight());
            } else {
                pointF = null;
            }
            this.mLastCursorStart = graphicalCursorStart;
            if (graphicalCursorEnd != null) {
                graphicalCursorStart = graphicalCursorEnd;
            }
            this.mLastCursorEnd = graphicalCursorStart;
            if (pointF != null) {
                RectF rectF = new RectF(cursorOrSelectionRegion.left, pointF.y - 16.0f, pointF.x + 16.0f, pointF.y + fMax3);
                if (rectF.height() >= rect.height()) {
                    numValueOf = Integer.valueOf(Math.round(rectF.centerY() + rect.centerY()));
                } else if (rectF.top < rect.top) {
                    numValueOf = Integer.valueOf(Math.round(rectF.top));
                } else {
                    numValueOf = rectF.bottom > ((float) rect.bottom) ? Integer.valueOf(Math.round(rectF.bottom)) : null;
                }
                if (rectF.width() >= rect.width()) {
                    numValueOf2 = Integer.valueOf(Math.round(rectF.centerX() + rect.centerX()));
                } else if (rectF.left < rect.left) {
                    numValueOf2 = Integer.valueOf(Math.round(rectF.left));
                } else if (rectF.right > rect.right) {
                    numValueOf2 = Integer.valueOf(Math.round(rectF.right));
                }
                if (numValueOf != null && (documentTouchController2 = this.mTouchControllerRef.get()) != null) {
                    documentTouchController2.scrollDelta(numValueOf.intValue(), rect.bottom, z, true);
                }
                if (numValueOf2 == null || (documentTouchController = this.mTouchControllerRef.get()) == null) {
                    return;
                }
                documentTouchController.scrollDelta(numValueOf2.intValue(), rect.right, z, false);
            }
        }
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.InputModel.InputModelListener
    public void onTextChanged() {
        View view = this.mTargetViewRef.get();
        if (view != null) {
            view.postInvalidate();
        }
    }

    private void keyboardActionOnPageController(KeyboardAction keyboardAction, KeyEvent keyEvent) {
        PageController pageController = this.mPageController;
        if (pageController == null) {
            return;
        }
        pageController.updateKeyboardModifiers(keyEvent.isAltPressed(), keyEvent.isShiftPressed(), keyEvent.isCtrlPressed());
        this.mPageController.keyboardAction(keyboardAction);
        this.mPageController.updateKeyboardModifiers(false, false, false);
    }

    private int getKeyAction(int i) {
        if (i == 61) {
            return KeyboardAction.TABULATION.ordinal();
        }
        if (i == 112) {
            return KeyboardAction.DEL.ordinal();
        }
        if (i == 160 || i == 66) {
            return KeyboardAction.ENTER.ordinal();
        }
        if (i == 67) {
            return KeyboardAction.BACKSPACE.ordinal();
        }
        if (i == 122) {
            return KeyboardAction.HOME.ordinal();
        }
        if (i != 123) {
            switch (i) {
                case 19:
                    return KeyboardAction.UP.ordinal();
                case 20:
                    return KeyboardAction.DOWN.ordinal();
                case 21:
                    return KeyboardAction.LEFT.ordinal();
                case 22:
                    return KeyboardAction.RIGHT.ordinal();
                default:
                    return -1;
            }
        }
        return KeyboardAction.END.ordinal();
    }

    private IntRange getKbEditableSelection() {
        Editable editable = this.mKeyEditable;
        int spanStart = -1;
        int spanStart2 = -1;
        for (Object obj : editable.getSpans(0, editable.length(), Object.class)) {
            if ((this.mKeyEditable.getSpanFlags(obj) & 546) == 546) {
                spanStart = this.mKeyEditable.getSpanStart(obj);
            }
            if ((this.mKeyEditable.getSpanFlags(obj) & 34) == 34) {
                spanStart2 = this.mKeyEditable.getSpanStart(obj);
                if (spanStart == -1) {
                    spanStart = spanStart2;
                }
            }
        }
        if (spanStart == -1) {
            return null;
        }
        return new IntRange(spanStart, spanStart2);
    }

    private void mergeKeyToText() {
        if (this.mKeyEditable.length() != 0) {
            try {
                NeboInputConnection.beginBatchEdit(this, true);
                NeboInputConnection.finishComposingText(this);
                NeboInputConnection.commitText(this, this.mKeyEditable, 1);
                IntRange kbEditableSelection = getKbEditableSelection();
                if (kbEditableSelection != null && kbEditableSelection.start != kbEditableSelection.end) {
                    IntRange selection = this.mInputModel.getSelection();
                    if (selection != null) {
                        IntRange intRangeOffset = kbEditableSelection.offset(selection.end - this.mKeyEditable.length());
                        this.mKeyEditableSelection = intRangeOffset;
                        NeboInputConnection.setSelection(this, intRangeOffset.start, this.mKeyEditableSelection.end);
                    }
                } else {
                    this.mKeyEditable.clear();
                }
            } finally {
                NeboInputConnection.endBatchEdit(this);
            }
        }
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.IKeyboardViewCallback
    public boolean doKeyDown(int i, KeyEvent keyEvent) {
        View view = this.mTargetViewRef.get();
        if (view == null) {
            return false;
        }
        int keyAction = getKeyAction(i);
        if (keyAction != -1) {
            keyboardActionOnPageController(KeyboardAction.swigToEnum(keyAction), keyEvent);
            return true;
        }
        boolean zOnKeyDown = getTextKeyListener().onKeyDown(view, this.mKeyEditable, i, keyEvent);
        mergeKeyToText();
        return zOnKeyDown;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.IKeyboardViewCallback
    public boolean doKeyUp(int i, KeyEvent keyEvent) {
        View view = this.mTargetViewRef.get();
        if (view == null) {
            return false;
        }
        if (getKeyAction(i) != -1) {
            return true;
        }
        boolean z = this.mKeyEditable.length() == 0;
        boolean zOnKeyUp = getTextKeyListener().onKeyUp(view, this.mKeyEditable, i, keyEvent);
        if (z) {
            this.mKeyEditable.clear();
        }
        return zOnKeyUp;
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.IKeyboardViewCallback
    public boolean doKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        boolean zOnKeyOther;
        View view = this.mTargetViewRef.get();
        if (view == null) {
            return false;
        }
        int keyAction = getKeyAction(i);
        if (keyAction != -1) {
            try {
                NeboInputConnection.beginBatchEdit(this, false);
                keyboardActionOnPageController(KeyboardAction.swigToEnum(keyAction), keyEvent);
                return true;
            } finally {
                NeboInputConnection.endBatchEdit(this);
            }
        }
        TextKeyListener textKeyListener = getTextKeyListener();
        try {
            zOnKeyOther = textKeyListener.onKeyOther(view, this.mKeyEditable, keyEvent);
        } catch (AbstractMethodError unused) {
            zOnKeyOther = false;
        } catch (IndexOutOfBoundsException unused2) {
            this.mKeyEditable.clear();
            zOnKeyOther = false;
        }
        if (!zOnKeyOther) {
            KeyEvent keyEventChangeAction = KeyEvent.changeAction(keyEvent, 0);
            KeyEvent keyEventChangeAction2 = KeyEvent.changeAction(keyEvent, 1);
            while (true) {
                i2--;
                if (i2 <= 0) {
                    break;
                }
                textKeyListener.onKeyDown(view, this.mKeyEditable, i, keyEventChangeAction);
                textKeyListener.onKeyUp(view, this.mKeyEditable, i, keyEventChangeAction2);
            }
        }
        mergeKeyToText();
        return true;
    }

    boolean clearMetaKeyStates(int i) {
        View view = this.mTargetViewRef.get();
        if (view == null) {
            return true;
        }
        try {
            getTextKeyListener().clearMetaKeyState(view, this.mKeyEditable, i);
            return true;
        } catch (AbstractMethodError unused) {
            return true;
        }
    }

    void dispatchKeyEvent(KeyEvent keyEvent) {
        View view = this.mTargetViewRef.get();
        if (view != null) {
            view.dispatchKeyEvent(keyEvent);
        }
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.InputModel.InputModelListener
    public void onSelectionChanged() {
        int i;
        int i2;
        int i3;
        int i4;
        ExtractedText extractedText;
        IntRange selection = this.mInputModel.getSelection();
        if (this.mKeyEditable.length() != 0 && !IntRange.equals(selection, this.mKeyEditableSelection)) {
            this.mKeyEditableSelection = null;
            this.mKeyEditable.clear();
        }
        View view = this.mTargetViewRef.get();
        if (view != null) {
            if (this.mIMM.isActive(view)) {
                if (selection != null) {
                    int i5 = selection.start;
                    int i6 = selection.end;
                    IntRange composing = this.mInputModel.getComposing();
                    if (composing != null) {
                        int i7 = composing.start;
                        i4 = composing.end;
                        i3 = i7;
                        i2 = i6;
                    } else {
                        i2 = i6;
                        i3 = -1;
                        i4 = -1;
                    }
                    i = i5;
                } else {
                    i = -1;
                    i2 = -1;
                    i3 = -1;
                    i4 = -1;
                }
                this.mIMM.updateSelection(view, i, i2, i3, i4);
                ExtractedTextRequest extractedTextRequest = this.mInputModel.getExtractedTextRequest();
                if (extractedTextRequest != null && (extractedText = NeboInputConnection.getExtractedText(this, extractedTextRequest, 0)) != null) {
                    this.mIMM.updateExtractedText(view, extractedTextRequest.token, extractedText);
                }
                if (i == -1 && i2 == -1) {
                    this.mSelectionCursorManager.finishContextualMenu();
                }
            }
            view.sendAccessibilityEvent(8192);
            view.postInvalidate();
        }
    }

    private TextKeyListener getTextKeyListener() {
        return TextKeyListener.getInstance();
    }

    public void unbind() {
        enableIMDetection(false);
        this.mInputModel.setInputModelListener(null);
        PageController pageController = this.mPageController;
        if (pageController != null) {
            pageController.delete();
            this.mPageController = null;
        }
    }

    public void enableKeyboard() {
        View view = this.mTargetViewRef.get();
        boolean z = true;
        boolean z2 = (view == null || view.hasFocus()) ? false : true;
        if (!this.mInputModel.hasPosition() && !this.mInputModel.hasSelection()) {
            z = false;
        }
        if (z2 && z) {
            view.requestFocus();
        }
    }

    @Override // com.myscript.nebo.editing.impl.keyboard.IKeyboardViewCallback
    public void enableFocusLostProcessing(boolean z) {
        this.mProcessFocusLost = z;
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.GestureListener
    public void onSingleTapConfirmedPre(PointerInfo pointerInfo) {
        boolean z = true;
        this.mSingleTapTransaction = true;
        if (!this.mPageController.pageType().equals(ContentTypes.PDF) || (!this.mInputModel.hasPosition() && !this.mInputModel.hasSelection())) {
            z = false;
        }
        this.mIgnoreSingleTap = z;
    }

    @Override // com.myscript.nebo.editing.impl.ui.DocumentTouchController.GestureListener
    public void onSingleTapConfirmed(PointerInfo pointerInfo) {
        final boolean z = this.mIgnoreSingleTap;
        this.mLayoutHandler.post(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.RenderingViewKeyboardHandler$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onSingleTapConfirmed$4(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSingleTapConfirmed$4(boolean z) {
        this.mSingleTapTransaction = false;
        if (z) {
            return;
        }
        enableKeyboard();
        View view = this.mTargetViewRef.get();
        if (view == null || !view.hasFocus()) {
            return;
        }
        if (this.mInputModel.hasPosition() || this.mInputModel.hasSelection()) {
            requestShowIM(0);
        }
    }

    InputModel getInputModel() {
        return this.mInputModel;
    }

    PageController getPageControllerRef() {
        return PageController.newRef(this.mPageController);
    }
}
