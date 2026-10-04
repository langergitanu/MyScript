package com.myscript.atk.text;

import com.myscript.atk.core.IntInterval;

/* JADX INFO: loaded from: classes4.dex */
public interface IKeyboardListener {
    void cursorSwapped();

    void hideKeyboard();

    void setCurrentRange(IntInterval intInterval);

    void setCurrentText(String str, IntInterval intInterval);

    void setCursorsPosition(float f, float f2, float f3, float f4, float f5, float f6);

    void setInputMethodAvailability(boolean z);
}
