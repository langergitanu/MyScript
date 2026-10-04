package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class GuideIterator {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public GuideIterator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(GuideIterator guideIterator) {
        if (guideIterator == null) {
            return 0L;
        }
        return guideIterator.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_GuideIterator(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isAtEnd() {
        return ATKCoreJNI.GuideIterator_isAtEnd(this.swigCPtr, this);
    }

    public void next() {
        ATKCoreJNI.GuideIterator_next(this.swigCPtr, this);
    }

    public String getId() {
        return new String(ATKCoreJNI.GuideIterator_getId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public GuideData getData() {
        return new GuideData(ATKCoreJNI.GuideIterator_getData(this.swigCPtr, this), true);
    }

    public void remove() {
        ATKCoreJNI.GuideIterator_remove(this.swigCPtr, this);
    }

    public GuideIterator(GuideIterator guideIterator) {
        this(ATKCoreJNI.new_GuideIterator__SWIG_0(getCPtr(guideIterator), guideIterator), true);
    }
}
