package com.myscript.nebo.editing.impl.keyboard;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: loaded from: classes7.dex */
public interface IKeyboardViewCallback {
    boolean doKeyDown(int i, KeyEvent keyEvent);

    boolean doKeyMultiple(int i, int i2, KeyEvent keyEvent);

    boolean doKeyUp(int i, KeyEvent keyEvent);

    void enableFocusLostProcessing(boolean z);

    InputConnection onCreateInputConnection(EditorInfo editorInfo);

    void onFocusChanged(View view, boolean z);
}
