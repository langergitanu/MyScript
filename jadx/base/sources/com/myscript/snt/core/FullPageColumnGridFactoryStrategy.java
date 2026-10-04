package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class FullPageColumnGridFactoryStrategy extends SingleColumnWithoutTopMarginGridFactoryStrategy {
    private transient boolean swigCMemOwnDerived;
    private transient long swigCPtr;

    public FullPageColumnGridFactoryStrategy(long j, boolean z) {
        super(NeboEngineJNI.FullPageColumnGridFactoryStrategy_SWIGSmartPtrUpcast(j), true);
        this.swigCMemOwnDerived = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(FullPageColumnGridFactoryStrategy fullPageColumnGridFactoryStrategy) {
        if (fullPageColumnGridFactoryStrategy == null) {
            return 0L;
        }
        return fullPageColumnGridFactoryStrategy.swigCPtr;
    }

    @Override // com.myscript.snt.core.SingleColumnWithoutTopMarginGridFactoryStrategy, com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.snt.core.SingleColumnWithoutTopMarginGridFactoryStrategy, com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwnDerived) {
                this.swigCMemOwnDerived = false;
                NeboEngineJNI.delete_FullPageColumnGridFactoryStrategy(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public static float getFullPageColumnGap() {
        return NeboEngineJNI.FullPageColumnGridFactoryStrategy_FullPageColumnGap_get();
    }

    @Override // com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    public float width(float f, float f2, float f3) {
        return NeboEngineJNI.FullPageColumnGridFactoryStrategy_width(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    public float left(float f, float f2, float f3) {
        return NeboEngineJNI.FullPageColumnGridFactoryStrategy_left(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    public float getLeftMargin(float f, float f2, float f3) {
        return NeboEngineJNI.FullPageColumnGridFactoryStrategy_getLeftMargin(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    public float getRightMargin(float f, float f2, float f3) {
        return NeboEngineJNI.FullPageColumnGridFactoryStrategy_getRightMargin(this.swigCPtr, this, f, f2, f3);
    }

    @Override // com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    public float columnGutter(float f, float f2, float f3) {
        return NeboEngineJNI.FullPageColumnGridFactoryStrategy_columnGutter(this.swigCPtr, this, f, f2, f3);
    }

    public FullPageColumnGridFactoryStrategy() {
        this(NeboEngineJNI.new_FullPageColumnGridFactoryStrategy(), true);
    }
}
