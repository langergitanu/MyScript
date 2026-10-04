package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class JsonObjectIterator {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public JsonObjectIterator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(JsonObjectIterator jsonObjectIterator) {
        if (jsonObjectIterator == null) {
            return 0L;
        }
        return jsonObjectIterator.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_JsonObjectIterator(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isAtEnd() {
        return ATKCoreJNI.JsonObjectIterator_isAtEnd(this.swigCPtr, this);
    }

    public void next() {
        ATKCoreJNI.JsonObjectIterator_next(this.swigCPtr, this);
    }

    public boolean equals(SWIGTYPE_p_myscript__engine__Iterator sWIGTYPE_p_myscript__engine__Iterator) {
        return ATKCoreJNI.JsonObjectIterator_equals(this.swigCPtr, this, SWIGTYPE_p_myscript__engine__Iterator.getCPtr(sWIGTYPE_p_myscript__engine__Iterator));
    }

    public String getKey() {
        return new String(ATKCoreJNI.JsonObjectIterator_getKey(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public Json getValue() {
        return new Json(ATKCoreJNI.JsonObjectIterator_getValue(this.swigCPtr, this), true);
    }

    public JsonObjectIterator(SWIGTYPE_p_std__nullptr_t sWIGTYPE_p_std__nullptr_t) {
        this(ATKCoreJNI.new_JsonObjectIterator__SWIG_0(SWIGTYPE_p_std__nullptr_t.getCPtr(sWIGTYPE_p_std__nullptr_t)), true);
    }

    public JsonObjectIterator(JsonObjectIterator jsonObjectIterator) {
        this(ATKCoreJNI.new_JsonObjectIterator__SWIG_1(getCPtr(jsonObjectIterator), jsonObjectIterator), true);
    }
}
