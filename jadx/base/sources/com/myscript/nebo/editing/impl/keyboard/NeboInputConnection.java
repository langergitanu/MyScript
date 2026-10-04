package com.myscript.nebo.editing.impl.keyboard;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import com.myscript.atk.core.EngineError;
import com.myscript.atk.core.KeyboardAction;
import com.myscript.snt.core.PageController;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class NeboInputConnection implements InputConnection {
    private static final boolean DBG = false;
    private static final String TAG = "NeboInputConnection";
    private WeakReference<RenderingViewKeyboardHandler> mKeyboardHandlerRef;

    /* JADX INFO: Access modifiers changed from: private */
    enum SelectionIndex {
        Start,
        End
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i) {
        return false;
    }

    NeboInputConnection(RenderingViewKeyboardHandler renderingViewKeyboardHandler) {
        this.mKeyboardHandlerRef = new WeakReference<>(renderingViewKeyboardHandler);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        return commitText(this.mKeyboardHandlerRef.get(), charSequence, i);
    }

    static boolean commitText(RenderingViewKeyboardHandler renderingViewKeyboardHandler, CharSequence charSequence, int i) {
        boolean z = false;
        if (renderingViewKeyboardHandler == null) {
            return false;
        }
        try {
            beginBatchEdit(renderingViewKeyboardHandler, true);
            if (charSequence.length() == 1 && charSequence.charAt(0) == '\n') {
                if (sendKeyEvent(renderingViewKeyboardHandler, new KeyEvent(0, 66)) && sendKeyEvent(renderingViewKeyboardHandler, new KeyEvent(1, 66))) {
                    z = true;
                }
                return z;
            }
            if (setComposingText(renderingViewKeyboardHandler, charSequence, i) && finishComposingText(renderingViewKeyboardHandler)) {
                z = true;
            }
            return z;
        } finally {
            endBatchEdit(renderingViewKeyboardHandler);
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        return setSelection(this.mKeyboardHandlerRef.get(), i, i2);
    }

    static boolean setSelection(RenderingViewKeyboardHandler renderingViewKeyboardHandler, final int i, final int i2) {
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null) {
            return false;
        }
        IntRange selection = inputModel.getSelection();
        if ((selection == null && (i < 0 || i2 < 0)) || (selection != null && selection.start == i && selection.end == i2)) {
            return true;
        }
        String text = inputModel.getText();
        IntRange intRangeOffset = new IntRange(i, i2).offset(-1);
        Pair<Integer, Integer> pairGraphemeIndexFromCharIndex = KeyboardUtils.graphemeIndexFromCharIndex(text, intRangeOffset.start, intRangeOffset.end);
        final int iIntValue = ((Integer) pairGraphemeIndexFromCharIndex.first).intValue();
        final int iIntValue2 = ((Integer) pairGraphemeIndexFromCharIndex.second).intValue();
        try {
            final PageController pageControllerRef = renderingViewKeyboardHandler.getPageControllerRef();
            try {
                beginBatchEdit(renderingViewKeyboardHandler, true);
                if (pageControllerRef == null) {
                    if (pageControllerRef != null) {
                        pageControllerRef.close();
                    }
                    return false;
                }
                pageControllerRef.notifyKeyboardListenerAtMostOnce(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.NeboInputConnection$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        NeboInputConnection.lambda$setSelection$0(pageControllerRef, iIntValue, i, i2, iIntValue2);
                    }
                });
                if (pageControllerRef != null) {
                    pageControllerRef.close();
                }
                return true;
            } finally {
            }
        } finally {
        }
        endBatchEdit(renderingViewKeyboardHandler);
    }

    static /* synthetic */ void lambda$setSelection$0(PageController pageController, int i, int i2, int i3, int i4) {
        try {
            pageController.setCursorIndex(SelectionIndex.Start.ordinal(), i);
            if (i2 == i3) {
                pageController.unsetCursor(SelectionIndex.End.ordinal());
            } else {
                pageController.setCursorIndex(SelectionIndex.End.ordinal(), i4);
            }
        } catch (EngineError e) {
            Log.e(TAG, "MyScript Engine exception:", e);
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        return commitText("\n", 1);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i, int i2) {
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandlerRef.get();
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null) {
            return null;
        }
        IntRange selection = inputModel.getSelection();
        if (selection == null) {
            return "";
        }
        return inputModel.getText().substring(Math.max(0, selection.start - i), selection.start);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i, int i2) {
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandlerRef.get();
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null) {
            return null;
        }
        IntRange selection = inputModel.getSelection();
        if (selection == null) {
            return "";
        }
        String text = inputModel.getText();
        return text.substring(selection.end, Math.min(selection.end + i, text.length()));
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i) {
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandlerRef.get();
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null) {
            return null;
        }
        IntRange selection = inputModel.getSelection();
        if (selection == null || selection.size() == 0) {
            return "";
        }
        return inputModel.getText().substring(selection.start, selection.end);
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i) {
        IntRange selection;
        int iIndexOf;
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandlerRef.get();
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        int i2 = 0;
        if (inputModel == null || (selection = inputModel.getSelection()) == null) {
            return 0;
        }
        String text = inputModel.getText();
        int i3 = selection.start;
        int capsMode = TextUtils.getCapsMode(text, i3, i);
        if ((i & 16384) != 0 && (capsMode & 16384) == 0 && text.indexOf(10) != -1) {
            int iLastIndexOf = text.lastIndexOf(10, i3 - 1);
            if (iLastIndexOf == -1) {
                iIndexOf = text.indexOf(32, 1);
            } else {
                i2 = iLastIndexOf;
                iIndexOf = text.substring(iLastIndexOf).indexOf(32);
            }
            if (iIndexOf == (i3 - i2) - 1) {
                return capsMode | 16384;
            }
        }
        return capsMode;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandlerRef.get();
        return renderingViewKeyboardHandler != null && renderingViewKeyboardHandler.clearMetaKeyStates(i);
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.mKeyboardHandlerRef = new WeakReference<>(null);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        return getExtractedText(this.mKeyboardHandlerRef.get(), extractedTextRequest, i);
    }

    static ExtractedText getExtractedText(RenderingViewKeyboardHandler renderingViewKeyboardHandler, ExtractedTextRequest extractedTextRequest, int i) {
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null || extractedTextRequest == null) {
            return null;
        }
        if ((i & 1) != 0) {
            inputModel.setExtractedTextRequest(extractedTextRequest);
        }
        ExtractedText extractedText = new ExtractedText();
        extractedText.partialEndOffset = -1;
        extractedText.partialStartOffset = -1;
        extractedText.flags = 0;
        String text = inputModel.getText();
        int length = text.length();
        IntRange selection = inputModel.getSelection();
        int iMin = extractedTextRequest.hintMaxChars == 0 ? length : Math.min(length, extractedTextRequest.hintMaxChars);
        if (selection == null) {
            extractedText.text = text.substring(0, iMin);
            extractedText.selectionStart = -1;
            extractedText.selectionEnd = -1;
            extractedText.startOffset = 0;
            return extractedText;
        }
        int size = selection.size();
        if (size > iMin) {
            iMin = size;
        }
        int i2 = iMin - size;
        int i3 = i2 >> 1;
        if (selection.start - i3 <= 0) {
            extractedText.startOffset = 0;
        } else {
            if (selection.end + (i2 - i3) >= length) {
                extractedText.startOffset = length - iMin;
            } else {
                extractedText.startOffset = selection.start - i3;
            }
        }
        extractedText.selectionStart = selection.start - extractedText.startOffset;
        extractedText.selectionEnd = selection.end - extractedText.startOffset;
        extractedText.text = text.substring(extractedText.startOffset, extractedText.startOffset + iMin);
        return extractedText;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        return setComposingText(this.mKeyboardHandlerRef.get(), charSequence, i);
    }

    private static boolean setComposingText(RenderingViewKeyboardHandler renderingViewKeyboardHandler, CharSequence charSequence, int i) {
        Pair<Integer, Integer> pair;
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null) {
            return false;
        }
        try {
            PageController pageControllerRef = renderingViewKeyboardHandler.getPageControllerRef();
            try {
                beginBatchEdit(renderingViewKeyboardHandler, true);
                if (pageControllerRef == null) {
                    if (pageControllerRef != null) {
                        pageControllerRef.close();
                    }
                    return false;
                }
                String string = charSequence.toString();
                IntRange composing = inputModel.getComposing();
                if (composing != null) {
                    finishComposingText(renderingViewKeyboardHandler);
                } else {
                    composing = inputModel.getSelection();
                }
                if (composing != null) {
                    IntRange intRangeOffset = composing.offset(-1);
                    pair = KeyboardUtils.graphemeIndexFromCharIndex(inputModel.getText(), intRangeOffset.start, intRangeOffset.end);
                } else {
                    pair = new Pair<>(-1, -1);
                }
                pageControllerRef.insertText(string, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue());
                IntRange selection = inputModel.getSelection();
                if (selection != null) {
                    int i2 = selection.start;
                    setComposingRegion(renderingViewKeyboardHandler, i2 - string.length(), i2);
                    int length = i > 0 ? i2 + (i - 1) : i2 - (string.length() + i);
                    setSelection(renderingViewKeyboardHandler, length, length);
                }
                if (pageControllerRef != null) {
                    pageControllerRef.close();
                }
                return true;
            } finally {
            }
        } finally {
        }
        endBatchEdit(renderingViewKeyboardHandler);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        return setComposingRegion(this.mKeyboardHandlerRef.get(), i, i2);
    }

    private static boolean setComposingRegion(RenderingViewKeyboardHandler renderingViewKeyboardHandler, int i, int i2) {
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null) {
            return false;
        }
        inputModel.setComposing(i, i2);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return finishComposingText(this.mKeyboardHandlerRef.get());
    }

    static boolean finishComposingText(RenderingViewKeyboardHandler renderingViewKeyboardHandler) {
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null) {
            return false;
        }
        inputModel.closeComposing();
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        return beginBatchEdit(this.mKeyboardHandlerRef.get(), true);
    }

    static boolean beginBatchEdit(RenderingViewKeyboardHandler renderingViewKeyboardHandler, boolean z) {
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null) {
            return false;
        }
        inputModel.beginBatchEdit(z);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return endBatchEdit(this.mKeyboardHandlerRef.get());
    }

    static boolean endBatchEdit(RenderingViewKeyboardHandler renderingViewKeyboardHandler) {
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null) {
            return false;
        }
        return inputModel.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return sendKeyEvent(this.mKeyboardHandlerRef.get(), keyEvent);
    }

    static boolean sendKeyEvent(RenderingViewKeyboardHandler renderingViewKeyboardHandler, KeyEvent keyEvent) {
        if (renderingViewKeyboardHandler == null) {
            return false;
        }
        renderingViewKeyboardHandler.dispatchKeyEvent(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        IntRange selection;
        boolean zCommitText;
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandlerRef.get();
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        boolean z = false;
        if (inputModel == null || (selection = inputModel.getSelection()) == null) {
            return false;
        }
        try {
            beginBatchEdit();
            IntRange composing = inputModel.getComposing();
            if (composing != null) {
                composing = new IntRange(computeIndexOnDeletion(composing.start, selection, i, i2), computeIndexOnDeletion(composing.end, selection, i, i2));
            }
            if (i2 > 0) {
                setComposingRegion(selection.end, selection.end + i2);
                zCommitText = commitText("", 1);
            } else {
                zCommitText = true;
            }
            if (i > 0) {
                boolean z2 = zCommitText & (zCommitText && setComposingRegion(Math.max(1, selection.end - i), selection.end));
                zCommitText = z2 & (z2 && commitText("", 1));
            }
            if (selection.start == i) {
                PageController pageControllerRef = renderingViewKeyboardHandler.getPageControllerRef();
                if (pageControllerRef != null) {
                    try {
                        pageControllerRef.keyboardAction(KeyboardAction.BACKSPACE);
                    } finally {
                    }
                }
                if (pageControllerRef != null) {
                    pageControllerRef.close();
                }
            }
            if (composing != null) {
                if (zCommitText && setComposingRegion(composing.start, composing.end)) {
                    z = true;
                }
                zCommitText &= z;
            }
            return zCommitText;
        } finally {
            endBatchEdit();
        }
    }

    private int computeIndexOnDeletion(int i, IntRange intRange, int i2, int i3) {
        int i4 = intRange.start - i2;
        return i > i4 ? i > intRange.start ? i > intRange.end ? i > intRange.end + i3 ? (i - i2) - i3 : intRange.end - i2 : i - i2 : i4 : i;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        IntRange selection;
        RenderingViewKeyboardHandler renderingViewKeyboardHandler = this.mKeyboardHandlerRef.get();
        InputModel inputModel = renderingViewKeyboardHandler != null ? renderingViewKeyboardHandler.getInputModel() : null;
        if (inputModel == null || (selection = inputModel.getSelection()) == null) {
            return false;
        }
        try {
            beginBatchEdit();
            String text = inputModel.getText();
            int iOffsetByCodePoints = selection.start;
            try {
                iOffsetByCodePoints = text.offsetByCodePoints(selection.start, -i);
            } catch (IndexOutOfBoundsException unused) {
            }
            int length = text.length() - selection.end;
            try {
                length = text.offsetByCodePoints(selection.end, i2);
            } catch (IndexOutOfBoundsException unused2) {
            }
            return deleteSurroundingText(iOffsetByCodePoints, length);
        } finally {
            endBatchEdit();
        }
    }
}
