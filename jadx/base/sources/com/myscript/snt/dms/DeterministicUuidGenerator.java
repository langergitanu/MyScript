package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class DeterministicUuidGenerator {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DeterministicUuidGenerator(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DeterministicUuidGenerator deterministicUuidGenerator) {
        if (deterministicUuidGenerator == null) {
            return 0L;
        }
        return deterministicUuidGenerator.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_DeterministicUuidGenerator(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public DeterministicUuidGenerator(long j) {
        this(NeboDMSJNI.new_DeterministicUuidGenerator__SWIG_0(j), true);
    }

    public DeterministicUuidGenerator() {
        this(NeboDMSJNI.new_DeterministicUuidGenerator__SWIG_1(), true);
    }

    public void reset() {
        NeboDMSJNI.DeterministicUuidGenerator_reset(this.swigCPtr, this);
    }

    public String generateUUID() {
        return new String(NeboDMSJNI.DeterministicUuidGenerator_generateUUID(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
