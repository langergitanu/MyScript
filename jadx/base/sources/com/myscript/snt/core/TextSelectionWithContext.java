package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class TextSelectionWithContext {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public TextSelectionWithContext(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(TextSelectionWithContext textSelectionWithContext) {
        if (textSelectionWithContext == null) {
            return 0L;
        }
        return textSelectionWithContext.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_TextSelectionWithContext(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setSelectedText(String str) {
        NeboEngineJNI.TextSelectionWithContext_selectedText_set(this.swigCPtr, this, str.getBytes());
    }

    public String getSelectedText() {
        return new String(NeboEngineJNI.TextSelectionWithContext_selectedText_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setContext(String str) {
        NeboEngineJNI.TextSelectionWithContext_context_set(this.swigCPtr, this, str.getBytes());
    }

    public String getContext() {
        return new String(NeboEngineJNI.TextSelectionWithContext_context_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public TextSelectionWithContext() {
        this(NeboEngineJNI.new_TextSelectionWithContext(), true);
    }
}
