package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class MultiColumnGridFactoryStrategy extends IGridFactoryStrategy {
    private transient boolean swigCMemOwnDerived;
    private transient long swigCPtr;

    public MultiColumnGridFactoryStrategy(long j, boolean z) {
        super(NeboEngineJNI.MultiColumnGridFactoryStrategy_SWIGSmartPtrUpcast(j), true);
        this.swigCMemOwnDerived = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MultiColumnGridFactoryStrategy multiColumnGridFactoryStrategy) {
        if (multiColumnGridFactoryStrategy == null) {
            return 0L;
        }
        return multiColumnGridFactoryStrategy.swigCPtr;
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwnDerived) {
                this.swigCMemOwnDerived = false;
                NeboEngineJNI.delete_MultiColumnGridFactoryStrategy(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    public float width(float f, float f2, float f3) {
        return NeboEngineJNI.MultiColumnGridFactoryStrategy_width(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    public float left(float f, float f2, float f3) {
        return NeboEngineJNI.MultiColumnGridFactoryStrategy_left(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    public float getTopMargin(float f, float f2, float f3) {
        return NeboEngineJNI.MultiColumnGridFactoryStrategy_getTopMargin(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    public float getLeftMargin(float f, float f2, float f3) {
        return NeboEngineJNI.MultiColumnGridFactoryStrategy_getLeftMargin(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    public float getRightMargin(float f, float f2, float f3) {
        return NeboEngineJNI.MultiColumnGridFactoryStrategy_getRightMargin(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    public int getColumnCount(float f, float f2, float f3) {
        return NeboEngineJNI.MultiColumnGridFactoryStrategy_getColumnCount(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    public float columnGutter(float f, float f2, float f3) {
        return NeboEngineJNI.MultiColumnGridFactoryStrategy_columnGutter(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.IGridFactoryStrategy
    public boolean compact(CompactMode compactMode, float f, float f2, float f3) {
        return NeboEngineJNI.MultiColumnGridFactoryStrategy_compact(this.swigCPtr, this, compactMode.swigValue(), f, f2, f3);
    }

    public MultiColumnGridFactoryStrategy() {
        this(NeboEngineJNI.new_MultiColumnGridFactoryStrategy(), true);
    }
}
