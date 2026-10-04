package com.myscript.nebo.editing.impl.keyboard;

import android.os.Handler;
import android.os.Looper;
import com.myscript.atk.core.IntInterval;
import com.myscript.atk.text.IKeyboardListener;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public class KeyboardListener implements IKeyboardListener {
    private static final boolean DBG = false;
    private static final String TAG = "KeyboardListener";
    private final CursorSwappedListener mCursorSwappedListener;
    private final InputModel mInputModel;
    private final KeyboardVisibilityListener mKeyboardVisibilityListener;
    private final Handler mPostHandler = new Handler(Looper.getMainLooper());

    @FunctionalInterface
    public interface CursorSwappedListener {
        void onCursorSwapped();
    }

    @FunctionalInterface
    public interface KeyboardVisibilityListener {
        void onKeyboardHidden();
    }

    @Override // com.myscript.atk.text.IKeyboardListener
    public void setInputMethodAvailability(boolean z) {
    }

    public KeyboardListener(InputModel inputModel, CursorSwappedListener cursorSwappedListener, KeyboardVisibilityListener keyboardVisibilityListener) {
        this.mCursorSwappedListener = cursorSwappedListener;
        this.mKeyboardVisibilityListener = keyboardVisibilityListener;
        this.mInputModel = inputModel;
    }

    private void runOnUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            this.mPostHandler.post(runnable);
        }
    }

    @Override // com.myscript.atk.text.IKeyboardListener
    public void setCurrentText(final String str, final IntInterval intInterval) {
        runOnUiThread(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.KeyboardListener$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setCurrentText$0(str, intInterval);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCurrentText$0(String str, IntInterval intInterval) {
        this.mInputModel.beginBatchEdit(false);
        this.mInputModel.setGraphemSelection(null);
        this.mInputModel.setText(str);
        this.mInputModel.setGraphemSelection(intInterval);
        this.mInputModel.endBatchEdit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCursorsPosition$1(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mInputModel.setGraphicalCursorsPosition(f, f2, f3, f4, f5, f6);
    }

    @Override // com.myscript.atk.text.IKeyboardListener
    public void setCursorsPosition(final float f, final float f2, final float f3, final float f4, final float f5, final float f6) {
        runOnUiThread(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.KeyboardListener$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setCursorsPosition$1(f, f2, f3, f4, f5, f6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCurrentRange$2(IntInterval intInterval) {
        this.mInputModel.setGraphemSelection(intInterval);
    }

    @Override // com.myscript.atk.text.IKeyboardListener
    public void setCurrentRange(final IntInterval intInterval) {
        runOnUiThread(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.KeyboardListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$setCurrentRange$2(intInterval);
            }
        });
    }

    @Override // com.myscript.atk.text.IKeyboardListener
    public void hideKeyboard() {
        final KeyboardVisibilityListener keyboardVisibilityListener = this.mKeyboardVisibilityListener;
        Objects.requireNonNull(keyboardVisibilityListener);
        runOnUiThread(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.KeyboardListener$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                keyboardVisibilityListener.onKeyboardHidden();
            }
        });
    }

    @Override // com.myscript.atk.text.IKeyboardListener
    public void cursorSwapped() {
        final CursorSwappedListener cursorSwappedListener = this.mCursorSwappedListener;
        Objects.requireNonNull(cursorSwappedListener);
        runOnUiThread(new Runnable() { // from class: com.myscript.nebo.editing.impl.keyboard.KeyboardListener$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                cursorSwappedListener.onCursorSwapped();
            }
        });
    }

    public boolean isKeyboardActive() {
        return this.mInputModel.getGraphicalCursorStart() != null && this.mInputModel.isCursorValid();
    }
}
