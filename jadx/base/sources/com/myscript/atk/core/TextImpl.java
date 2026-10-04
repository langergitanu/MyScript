package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class TextImpl {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public TextImpl(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(TextImpl textImpl) {
        if (textImpl == null) {
            return 0L;
        }
        return textImpl.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_TextImpl(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public TextImpl(String str) {
        this(ATKCoreJNI.new_TextImpl(str.getBytes()), true);
    }

    public int getGlyphCount() {
        return ATKCoreJNI.TextImpl_getGlyphCount(this.swigCPtr, this);
    }

    public String getGlyphLabelAt(int i) {
        return new String(ATKCoreJNI.TextImpl_getGlyphLabelAt(this.swigCPtr, this, i), StandardCharsets.UTF_8);
    }

    public int getGlyphUtf8BeginAt(int i) {
        return ATKCoreJNI.TextImpl_getGlyphUtf8BeginAt(this.swigCPtr, this, i);
    }

    public int getGlyphUtf8EndAt(int i) {
        return ATKCoreJNI.TextImpl_getGlyphUtf8EndAt(this.swigCPtr, this, i);
    }

    public int getGlyphUtf16BeginAt(int i) {
        return ATKCoreJNI.TextImpl_getGlyphUtf16BeginAt(this.swigCPtr, this, i);
    }

    public int getGlyphUtf16EndAt(int i) {
        return ATKCoreJNI.TextImpl_getGlyphUtf16EndAt(this.swigCPtr, this, i);
    }

    public int getGlyphIndexUtf8At(int i) {
        return ATKCoreJNI.TextImpl_getGlyphIndexUtf8At(this.swigCPtr, this, i);
    }

    public int getGlyphIndexUtf16At(int i) {
        return ATKCoreJNI.TextImpl_getGlyphIndexUtf16At(this.swigCPtr, this, i);
    }
}
