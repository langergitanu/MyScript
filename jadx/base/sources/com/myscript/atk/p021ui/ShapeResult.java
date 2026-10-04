package com.myscript.atk.p021ui;

import com.myscript.atk.core.Selection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ShapeResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ShapeResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ShapeResult shapeResult) {
        if (shapeResult == null) {
            return 0L;
        }
        return shapeResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKSharedUIJNI.delete_ShapeResult(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public List<ShapeCandidate> candidatesFromSelection(Selection selection) {
        return new SWIGShapeCandidate(ATKSharedUIJNI.ShapeResult_candidatesFromSelection(this.swigCPtr, this, Selection.getCPtr(selection), selection), true);
    }

    public boolean setCandidate(Selection selection, int i) {
        return ATKSharedUIJNI.ShapeResult_setCandidate(this.swigCPtr, this, Selection.getCPtr(selection), selection, i);
    }
}
