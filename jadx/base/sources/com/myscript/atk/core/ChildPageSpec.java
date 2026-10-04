package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class ChildPageSpec {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ChildPageSpec(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ChildPageSpec childPageSpec) {
        if (childPageSpec == null) {
            return 0L;
        }
        return childPageSpec.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_ChildPageSpec(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ChildPageSpec() {
        this(ATKCoreJNI.new_ChildPageSpec__SWIG_0(), true);
    }

    public ChildPageSpec(String str, Extent extent) {
        this(ATKCoreJNI.new_ChildPageSpec__SWIG_1(str.getBytes(), Extent.getCPtr(extent), extent), true);
    }

    public void setId(String str) {
        ATKCoreJNI.ChildPageSpec_id_set(this.swigCPtr, this, str.getBytes());
    }

    public String getId() {
        return new String(ATKCoreJNI.ChildPageSpec_id_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setExtent(Extent extent) {
        ATKCoreJNI.ChildPageSpec_extent_set(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    public Extent getExtent() {
        long jChildPageSpec_extent_get = ATKCoreJNI.ChildPageSpec_extent_get(this.swigCPtr, this);
        if (jChildPageSpec_extent_get == 0) {
            return null;
        }
        return new Extent(jChildPageSpec_extent_get, false);
    }
}
