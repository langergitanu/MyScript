package com.myscript.atk.text;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class ChildPageCursor {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ChildPageCursor(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ChildPageCursor childPageCursor) {
        if (childPageCursor == null) {
            return 0L;
        }
        return childPageCursor.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_ChildPageCursor(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ChildPageCursor() {
        this(ATKTextJNI.new_ChildPageCursor__SWIG_0(), true);
    }

    public ChildPageCursor(String str, long j) {
        this(ATKTextJNI.new_ChildPageCursor__SWIG_1(str.getBytes(), j), true);
    }

    public void clear() {
        ATKTextJNI.ChildPageCursor_clear(this.swigCPtr, this);
    }

    public void setId(String str) {
        ATKTextJNI.ChildPageCursor_id_set(this.swigCPtr, this, str.getBytes());
    }

    public String getId() {
        return new String(ATKTextJNI.ChildPageCursor_id_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setIndex(long j) {
        ATKTextJNI.ChildPageCursor_index_set(this.swigCPtr, this, j);
    }

    public long getIndex() {
        return ATKTextJNI.ChildPageCursor_index_get(this.swigCPtr, this);
    }
}
