package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public abstract class IGridFactoryStrategy {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public IGridFactoryStrategy(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(IGridFactoryStrategy iGridFactoryStrategy) {
        if (iGridFactoryStrategy == null) {
            return 0L;
        }
        return iGridFactoryStrategy.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_IGridFactoryStrategy(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public float width(float f, float f2, float f3) {
        return NeboEngineJNI.IGridFactoryStrategy_width(this.swigCPtr, this, f, f2, f3);
    }

    public float left(float f, float f2, float f3) {
        return NeboEngineJNI.IGridFactoryStrategy_left(this.swigCPtr, this, f, f2, f3);
    }

    public float getTopMargin(float f, float f2, float f3) {
        return NeboEngineJNI.IGridFactoryStrategy_getTopMargin(this.swigCPtr, this, f, f2, f3);
    }

    public float getLeftMargin(float f, float f2, float f3) {
        return NeboEngineJNI.IGridFactoryStrategy_getLeftMargin(this.swigCPtr, this, f, f2, f3);
    }

    public float getRightMargin(float f, float f2, float f3) {
        return NeboEngineJNI.IGridFactoryStrategy_getRightMargin(this.swigCPtr, this, f, f2, f3);
    }

    public int getColumnCount(float f, float f2, float f3) {
        return NeboEngineJNI.IGridFactoryStrategy_getColumnCount(this.swigCPtr, this, f, f2, f3);
    }

    public float columnGutter(float f, float f2, float f3) {
        return NeboEngineJNI.IGridFactoryStrategy_columnGutter(this.swigCPtr, this, f, f2, f3);
    }

    public boolean compact(CompactMode compactMode, float f, float f2, float f3) {
        return NeboEngineJNI.IGridFactoryStrategy_compact(this.swigCPtr, this, compactMode.swigValue(), f, f2, f3);
    }
}
