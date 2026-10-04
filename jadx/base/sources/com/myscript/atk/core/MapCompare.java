package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class MapCompare {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MapCompare(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MapCompare mapCompare) {
        if (mapCompare == null) {
            return 0L;
        }
        return mapCompare.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_MapCompare(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public MapCompare() {
        this(ATKCoreJNI.new_MapCompare(), true);
    }
}
