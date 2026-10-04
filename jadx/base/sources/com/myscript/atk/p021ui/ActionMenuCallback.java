package com.myscript.atk.p021ui;

import com.myscript.atk.core.Point;

/* JADX INFO: loaded from: classes4.dex */
public class ActionMenuCallback {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ActionMenuCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ActionMenuCallback actionMenuCallback) {
        if (actionMenuCallback == null) {
            return 0L;
        }
        return actionMenuCallback.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKSharedUIJNI.delete_ActionMenuCallback(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void triggerActionAt(ActionMenuEntry actionMenuEntry, Point point) {
        ATKSharedUIJNI.ActionMenuCallback_triggerActionAt(this.swigCPtr, this, actionMenuEntry.swigValue(), Point.getCPtr(point), point);
    }
}
