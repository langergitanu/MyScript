package com.myscript.nebo.editing.impl.keyboard;

import android.graphics.PointF;
import android.util.Log;
import android.util.Pair;
import android.view.inputmethod.ExtractedTextRequest;
import com.myscript.atk.core.IntInterval;
import com.myscript.atk.core.ViewTransform;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class InputModel {
    private static final Pair<Float, Float> CLEARED_GRAPHICAL_CURSOR_HEIGHTS = new Pair<>(Float.valueOf(0.0f), Float.valueOf(-1.0f));
    private static final String FAKE_SPACE_CHAR = " ";
    private ExtractedTextRequest mExtractedTextRequest;
    private IntRange mGraphemRange;
    private final ViewTransformProvider mViewTransformProvider;
    private final String TAG = "InputModel";
    private final Boolean DBG = false;
    private LastGraphicalPosition mLastGraphicalPosition = new LastGraphicalPosition();
    private String mText = "";
    private IntRange mSelection = null;
    private IntRange mComposing = null;
    private boolean mCloseComposingOnBatchEnd = false;
    private PointF mGraphicalCursorStart = null;
    private PointF mGraphicalCursorEnd = null;
    private Pair<Float, Float> mGraphicalCursorHeights = CLEARED_GRAPHICAL_CURSOR_HEIGHTS;
    private WeakReference<InputModelListener> mInputModelListenerRef = new WeakReference<>(null);
    private int mBatchEditCount = 0;
    private boolean mPendingSelectionUpdate = false;
    private boolean mPendingGraphicalCursorUpdate = false;
    private boolean mBatchGraphicalCursorUpdate = false;

    public interface InputModelListener {
        void onGraphicalCursorChanged();

        void onSelectionChanged();

        void onTextChanged();
    }

    public interface ViewTransformProvider {
        ViewTransform getCurrentViewTransformNewRef();
    }

    private static class LastGraphicalPosition {
        float heightEnd;
        float heightStart;
        boolean isValid;
        float xEnd;
        float xStart;
        float yEnd;
        float yStart;

        LastGraphicalPosition() {
            invalidate();
        }

        LastGraphicalPosition(float f, float f2, float f3, float f4, float f5, float f6) {
            update(f, f2, f3, f4, f5, f6);
        }

        void invalidate() {
            this.isValid = false;
        }

        void update(float f, float f2, float f3, float f4, float f5, float f6) {
            this.isValid = true;
            this.xStart = f;
            this.yStart = f2;
            this.xEnd = f3;
            this.yEnd = f4;
            this.heightStart = f5;
            this.heightEnd = f6;
        }
    }

    public InputModel(ViewTransformProvider viewTransformProvider) {
        this.mViewTransformProvider = viewTransformProvider;
    }

    public void setInputModelListener(InputModelListener inputModelListener) {
        this.mInputModelListenerRef = new WeakReference<>(inputModelListener);
    }

    public void clear() {
        this.mSelection = null;
        this.mGraphemRange = null;
        closeComposing();
        this.mText = "";
        this.mGraphicalCursorStart = null;
        this.mGraphicalCursorEnd = null;
        this.mLastGraphicalPosition.invalidate();
        this.mGraphicalCursorHeights = CLEARED_GRAPHICAL_CURSOR_HEIGHTS;
        this.mBatchEditCount = 0;
        sendPendingNotification();
    }

    public void setText(String str) {
        IntRange composing = getComposing();
        if (this.DBG.booleanValue()) {
            Log.d(this.TAG, "setText: " + str);
        }
        try {
            beginBatchEdit(false);
            this.mText = FAKE_SPACE_CHAR + str;
            setSelection(this.mSelection);
            if (composing != null) {
                setComposing(composing.start, composing.end);
            }
            InputModelListener inputModelListener = this.mInputModelListenerRef.get();
            if (inputModelListener != null) {
                inputModelListener.onTextChanged();
            }
        } finally {
            endBatchEdit();
        }
    }

    public String getText() {
        return this.mText;
    }

    public void setGraphemSelection(IntInterval intInterval) {
        IntRange intRange = intInterval == null ? null : new IntRange(intInterval.getBegin(), intInterval.getEnd());
        if (IntRange.equals(intRange, this.mGraphemRange)) {
            return;
        }
        this.mGraphemRange = intRange;
        if (intRange == null) {
            setSelection(null);
            return;
        }
        if (this.mText.equals(FAKE_SPACE_CHAR)) {
            int length = FAKE_SPACE_CHAR.length();
            setSelection(new IntRange(length, length));
        } else {
            int length2 = FAKE_SPACE_CHAR.length();
            IntRange intRange2 = new IntRange(intRange.start + length2, length2 + intRange.end);
            setSelection(new IntRange(KeyboardUtils.charIndexFromGraphemeIndex(this.mText, intRange2.start, intRange2.end)));
        }
    }

    private void setSelection(IntRange intRange) {
        int length = this.mText.length();
        IntRange intRange2 = null;
        if (intRange != null && intRange.start >= 0) {
            intRange2 = new IntRange(Math.min(intRange.start, length), Math.min(intRange.end, length));
        }
        if (IntRange.equals(this.mSelection, intRange2)) {
            return;
        }
        this.mSelection = intRange2;
        this.mPendingSelectionUpdate = true;
        sendPendingNotification();
    }

    public IntRange getSelection() {
        if (this.DBG.booleanValue()) {
            Log.d(this.TAG, "getSelection: " + this.mSelection);
        }
        return this.mSelection;
    }

    public boolean hasSelection() {
        if (this.mGraphicalCursorStart != null && this.mGraphicalCursorEnd != null) {
            return true;
        }
        IntRange intRange = this.mSelection;
        return (intRange == null || intRange.size() == 0) ? false : true;
    }

    public boolean hasPosition() {
        IntRange intRange = this.mSelection;
        return intRange != null && intRange.size() == 0;
    }

    public boolean isCursorValid() {
        return this.mSelection != null;
    }

    public void refreshGraphicalCursorsPosition() {
        if (this.mLastGraphicalPosition.isValid) {
            setGraphicalCursorsPosition(this.mLastGraphicalPosition.xStart, this.mLastGraphicalPosition.yStart, this.mLastGraphicalPosition.xEnd, this.mLastGraphicalPosition.yEnd, this.mLastGraphicalPosition.heightStart, this.mLastGraphicalPosition.heightEnd);
        }
    }

    public void setGraphicalCursorsPosition(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mLastGraphicalPosition.update(f, f2, f3, f4, f5, f6);
        ViewTransform currentViewTransformNewRef = this.mViewTransformProvider.getCurrentViewTransformNewRef();
        if (currentViewTransformNewRef == null) {
            if (currentViewTransformNewRef != null) {
                currentViewTransformNewRef.close();
                return;
            }
            return;
        }
        try {
            if (f != -1.0f && f2 != -1.0f) {
                float fMapX = currentViewTransformNewRef.mapX(f);
                float fMapY = currentViewTransformNewRef.mapY(f2);
                if (this.DBG.booleanValue()) {
                    Log.i(this.TAG, "Backend >---> Handle : x = " + f + " , y = " + f2 + " and mapX = " + fMapX + ", mapY = " + fMapY);
                }
                PointF pointF = this.mGraphicalCursorStart;
                if (pointF == null || pointF.x != fMapX || this.mGraphicalCursorStart.y != fMapY) {
                    this.mGraphicalCursorStart = new PointF(fMapX, fMapY);
                }
            } else {
                this.mGraphicalCursorStart = null;
            }
            if (f3 != -1.0f && f4 != -1.0f) {
                float fMapX2 = currentViewTransformNewRef.mapX(f3);
                float fMapY2 = currentViewTransformNewRef.mapY(f4);
                PointF pointF2 = this.mGraphicalCursorEnd;
                if (pointF2 == null || pointF2.x != fMapX2 || this.mGraphicalCursorEnd.y != fMapY2) {
                    PointF pointF3 = new PointF(fMapX2, fMapY2);
                    if (this.mGraphicalCursorStart == null) {
                        this.mGraphicalCursorStart = pointF3;
                    } else {
                        this.mGraphicalCursorEnd = pointF3;
                    }
                }
            } else {
                this.mGraphicalCursorEnd = null;
            }
            if (currentViewTransformNewRef != null) {
                currentViewTransformNewRef.close();
            }
            this.mGraphicalCursorHeights = new Pair<>(Float.valueOf(f5), Float.valueOf(f6));
            this.mPendingGraphicalCursorUpdate = true;
            sendPendingNotification();
        } finally {
        }
    }

    public PointF getGraphicalCursorStart() {
        return this.mGraphicalCursorStart;
    }

    public PointF getGraphicalCursorEnd() {
        return this.mGraphicalCursorEnd;
    }

    public Pair<Float, Float> getGraphicalCursorHeights() {
        return this.mGraphicalCursorHeights;
    }

    public void beginBatchEdit(boolean z) {
        beginBatchEdit(z, true);
    }

    public void beginBatchEdit(boolean z, boolean z2) {
        int i = this.mBatchEditCount;
        if (i == 0) {
            this.mCloseComposingOnBatchEnd = !z;
            this.mBatchGraphicalCursorUpdate = z2;
        }
        this.mBatchEditCount = i + 1;
        if (this.DBG.booleanValue()) {
            Log.d(this.TAG, "beginBatchEdit>" + this.mBatchEditCount + " keepComposing=" + z + " batchGraphicalCursorUpdate=" + z2, new Exception());
        }
    }

    private void sendPendingNotification() {
        InputModelListener inputModelListener = this.mInputModelListenerRef.get();
        if (this.mBatchEditCount != 0) {
            if (this.mBatchGraphicalCursorUpdate || !this.mPendingGraphicalCursorUpdate || inputModelListener == null) {
                return;
            }
            this.mPendingGraphicalCursorUpdate = false;
            inputModelListener.onGraphicalCursorChanged();
            return;
        }
        if (IntRange.intersect(this.mComposing, this.mSelection) == null) {
            this.mComposing = null;
        }
        if (inputModelListener != null) {
            if (this.mPendingSelectionUpdate) {
                this.mPendingSelectionUpdate = false;
                inputModelListener.onSelectionChanged();
            }
            if (this.mPendingGraphicalCursorUpdate) {
                this.mPendingGraphicalCursorUpdate = false;
                inputModelListener.onGraphicalCursorChanged();
            }
        }
    }

    public boolean endBatchEdit() {
        int i = this.mBatchEditCount - 1;
        this.mBatchEditCount = i;
        if (i < 0) {
            this.mBatchEditCount = 0;
        }
        if (this.DBG.booleanValue()) {
            Log.d(this.TAG, "endBatchEdit>" + this.mBatchEditCount + ((this.mBatchEditCount == 0 && this.mCloseComposingOnBatchEnd) ? " and composing closed" : ""));
        }
        if (this.mBatchEditCount == 0 && this.mCloseComposingOnBatchEnd) {
            closeComposing();
        }
        sendPendingNotification();
        return this.mBatchEditCount > 0;
    }

    void setComposing(int i, int i2) {
        IntRange intRange;
        if (this.DBG.booleanValue()) {
            Log.d(this.TAG, "setComposing start=" + i + " end=" + i2);
        }
        if (i < 0 || i2 < 0 || i == i2) {
            intRange = null;
        } else {
            int length = this.mText.length();
            intRange = new IntRange(Math.min(i, length), Math.min(i2, length));
        }
        if (IntRange.equals(this.mComposing, intRange)) {
            return;
        }
        this.mComposing = intRange;
        this.mPendingSelectionUpdate = true;
        sendPendingNotification();
    }

    void closeComposing() {
        if (this.DBG.booleanValue()) {
            Log.d(this.TAG, "closeComposing");
        }
        setComposing(-1, -1);
    }

    IntRange getComposing() {
        return this.mComposing;
    }

    void setExtractedTextRequest(ExtractedTextRequest extractedTextRequest) {
        this.mExtractedTextRequest = extractedTextRequest;
    }

    ExtractedTextRequest getExtractedTextRequest() {
        return this.mExtractedTextRequest;
    }
}
