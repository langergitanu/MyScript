package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Function implements AutoCloseable {
    public static final int e_exponential = 2;
    public static final int e_postscript = 4;
    public static final int e_sampled = 0;
    public static final int e_stitching = 3;

    /* JADX INFO: renamed from: a */
    private long f1559a;

    /* JADX INFO: renamed from: b */
    private Object f1560b;

    static native void Destroy(long j);

    static native double[] Eval(long j, double[] dArr);

    static native long FunctionCreateFromObj(long j);

    static native int GetInputCardinality(long j);

    static native int GetOutputCardinality(long j);

    static native long GetSDFObj(long j);

    static native int GetType(long j);

    public Function(Obj obj) {
        this.f1559a = FunctionCreateFromObj(obj.__GetHandle());
        this.f1560b = obj.__GetRefHandle();
    }

    public void destroy() {
        long j = this.f1559a;
        if (j != 0) {
            Destroy(j);
            this.f1559a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public int getType() throws PDFNetException {
        return GetType(this.f1559a);
    }

    public int getInputCardinality() throws PDFNetException {
        return GetInputCardinality(this.f1559a);
    }

    public int getOutputCardinality() throws PDFNetException {
        return GetOutputCardinality(this.f1559a);
    }

    public double[] eval(double[] dArr) throws PDFNetException {
        return Eval(this.f1559a, dArr);
    }

    public Obj getSDFObj() {
        return Obj.__Create(GetSDFObj(this.f1559a), this.f1560b);
    }

    private Function(long j, Object obj) {
        this.f1559a = j;
        this.f1560b = obj;
    }

    /* JADX INFO: renamed from: a */
    static Function m1159a(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new Function(j, obj);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
