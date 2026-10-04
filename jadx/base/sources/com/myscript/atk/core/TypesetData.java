package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class TypesetData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public TypesetData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(TypesetData typesetData) {
        if (typesetData == null) {
            return 0L;
        }
        return typesetData.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_TypesetData(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public int getItemCount() {
        return ATKCoreJNI.TypesetData_getItemCount(this.swigCPtr, this);
    }

    public TypesetItem getItemAt(int i) {
        return new TypesetItem(ATKCoreJNI.TypesetData_getItemAt(this.swigCPtr, this, i), true);
    }

    public TypesetData(TypesetData typesetData) {
        this(ATKCoreJNI.new_TypesetData(getCPtr(typesetData), typesetData), true);
    }
}
