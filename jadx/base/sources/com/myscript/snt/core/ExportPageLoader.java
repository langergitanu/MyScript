package com.myscript.snt.core;

import com.myscript.atk.core.Page;

/* JADX INFO: loaded from: classes7.dex */
public class ExportPageLoader {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ExportPageLoader(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ExportPageLoader exportPageLoader) {
        if (exportPageLoader == null) {
            return 0L;
        }
        return exportPageLoader.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ExportPageLoader(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Page load(ExportPageModel exportPageModel) {
        return new Page(NeboEngineJNI.ExportPageLoader_load(this.swigCPtr, this, ExportPageModel.getCPtr(exportPageModel), exportPageModel), true);
    }
}
