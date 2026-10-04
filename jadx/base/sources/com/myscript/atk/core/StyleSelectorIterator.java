package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class StyleSelectorIterator {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public StyleSelectorIterator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(StyleSelectorIterator styleSelectorIterator) {
        if (styleSelectorIterator == null) {
            return 0L;
        }
        return styleSelectorIterator.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_StyleSelectorIterator(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public boolean isAtEnd() {
        return ATKCoreJNI.StyleSelectorIterator_isAtEnd(this.swigCPtr, this);
    }

    public void next() {
        ATKCoreJNI.StyleSelectorIterator_next(this.swigCPtr, this);
    }

    public boolean equals(SWIGTYPE_p_myscript__engine__Iterator sWIGTYPE_p_myscript__engine__Iterator) {
        return ATKCoreJNI.StyleSelectorIterator_equals(this.swigCPtr, this, SWIGTYPE_p_myscript__engine__Iterator.getCPtr(sWIGTYPE_p_myscript__engine__Iterator));
    }

    public String getSelector() {
        return new String(ATKCoreJNI.StyleSelectorIterator_getSelector(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public InkStyle getResolvedStyle() {
        return new InkStyle(ATKCoreJNI.StyleSelectorIterator_getResolvedStyle(this.swigCPtr, this), true);
    }

    public StyleSelectorIterator(StyleSelectorIterator styleSelectorIterator) {
        this(ATKCoreJNI.new_StyleSelectorIterator(getCPtr(styleSelectorIterator), styleSelectorIterator), true);
    }
}
