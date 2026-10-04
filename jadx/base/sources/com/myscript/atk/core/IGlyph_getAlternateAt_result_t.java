package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class IGlyph_getAlternateAt_result_t {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IGlyph_getAlternateAt_result_t(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IGlyph_getAlternateAt_result_t iGlyph_getAlternateAt_result_t) {
        if (iGlyph_getAlternateAt_result_t == null) {
            return 0L;
        }
        return iGlyph_getAlternateAt_result_t.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_IGlyph_getAlternateAt_result_t(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setP(float f) {
        ATKCoreJNI.IGlyph_getAlternateAt_result_t_p_set(this.swigCPtr, this, f);
    }

    public float getP() {
        return ATKCoreJNI.IGlyph_getAlternateAt_result_t_p_get(this.swigCPtr, this);
    }

    public void setLabel(String str) {
        ATKCoreJNI.IGlyph_getAlternateAt_result_t_label_set(this.swigCPtr, this, str.getBytes());
    }

    public String getLabel() {
        return new String(ATKCoreJNI.IGlyph_getAlternateAt_result_t_label_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public IGlyph_getAlternateAt_result_t() {
        this(ATKCoreJNI.new_IGlyph_getAlternateAt_result_t(), true);
    }
}
