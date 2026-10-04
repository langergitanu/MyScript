package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public class SingleColumnWithoutTopMarginGridFactoryStrategy extends SingleColumnGridFactoryStrategy {
    private transient boolean swigCMemOwnDerived;
    private transient long swigCPtr;

    public SingleColumnWithoutTopMarginGridFactoryStrategy(long j, boolean z) {
        super(NeboEngineJNI.m1093xeb0a99e2(j), true);
        this.swigCMemOwnDerived = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SingleColumnWithoutTopMarginGridFactoryStrategy singleColumnWithoutTopMarginGridFactoryStrategy) {
        if (singleColumnWithoutTopMarginGridFactoryStrategy == null) {
            return 0L;
        }
        return singleColumnWithoutTopMarginGridFactoryStrategy.swigCPtr;
    }

    @Override // com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwnDerived) {
                this.swigCMemOwnDerived = false;
                NeboEngineJNI.delete_SingleColumnWithoutTopMarginGridFactoryStrategy(j);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    @Override // com.myscript.snt.core.SingleColumnGridFactoryStrategy, com.myscript.snt.core.IGridFactoryStrategy
    public float getTopMargin(float f, float f2, float f3) {
        return NeboEngineJNI.SingleColumnWithoutTopMarginGridFactoryStrategy_getTopMargin(this.swigCPtr, this, f, f2, f3);
    }

    public SingleColumnWithoutTopMarginGridFactoryStrategy() {
        this(NeboEngineJNI.new_SingleColumnWithoutTopMarginGridFactoryStrategy(), true);
    }
}
