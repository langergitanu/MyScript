package com.myscript.snt.dms;

import com.myscript.snt.core.NotebookKey;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class Notebook implements AutoCloseable {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Notebook(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Notebook notebook) {
        if (notebook == null) {
            return 0L;
        }
        return notebook.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_Notebook(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public Notebook(NotebookKey notebookKey, NotebookInfo notebookInfo) {
        this(NeboDMSJNI.new_Notebook(NotebookKey.getCPtr(notebookKey), notebookKey, NotebookInfo.getCPtr(notebookInfo), notebookInfo), true);
    }

    public NotebookKey getKey() {
        return new NotebookKey(NeboDMSJNI.Notebook_getKey(this.swigCPtr, this), true);
    }

    public String getName() {
        return new String(NeboDMSJNI.Notebook_getName(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean isValid() {
        return NeboDMSJNI.Notebook_isValid(this.swigCPtr, this);
    }

    public long getLastModificationDate() {
        return NeboDMSJNI.Notebook_getLastModificationDate(this.swigCPtr, this);
    }

    public boolean isSupported() {
        return NeboDMSJNI.Notebook_isSupported(this.swigCPtr, this);
    }

    public boolean isWelcome() {
        return NeboDMSJNI.Notebook_isWelcome(this.swigCPtr, this);
    }

    public SyncState syncState() {
        return SyncState.swigToEnum(NeboDMSJNI.Notebook_syncState(this.swigCPtr, this));
    }

    public SyncProgress syncProgress() {
        return SyncProgress.swigToEnum(NeboDMSJNI.Notebook_syncProgress(this.swigCPtr, this));
    }

    public boolean isCloudOnly() {
        return NeboDMSJNI.Notebook_isCloudOnly(this.swigCPtr, this);
    }

    public boolean isCorrupted() {
        return NeboDMSJNI.Notebook_isCorrupted(this.swigCPtr, this);
    }

    public boolean isTrashed() {
        return NeboDMSJNI.Notebook_isTrashed(this.swigCPtr, this);
    }

    public int hashCode() {
        return NeboDMSJNI.Notebook_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(Notebook notebook) {
        return NeboDMSJNI.Notebook_nativeEquals(this.swigCPtr, this, getCPtr(notebook), notebook);
    }

    public String toString() {
        return new String(NeboDMSJNI.Notebook_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public int getCoverColor2() {
        return NeboDMSJNI.Notebook_getCoverColor2(this.swigCPtr, this);
    }

    public static Notebook derivedRef(Notebook notebook) {
        long jNotebook_derivedRef = NeboDMSJNI.Notebook_derivedRef(getCPtr(notebook), notebook);
        if (jNotebook_derivedRef == 0) {
            return null;
        }
        return new Notebook(jNotebook_derivedRef, true);
    }
}
