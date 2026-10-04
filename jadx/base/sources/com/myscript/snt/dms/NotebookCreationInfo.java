package com.myscript.snt.dms;

import com.myscript.snt.core.CollectionKey;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class NotebookCreationInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public NotebookCreationInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(NotebookCreationInfo notebookCreationInfo) {
        if (notebookCreationInfo == null) {
            return 0L;
        }
        return notebookCreationInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_NotebookCreationInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setParentCollectionKey(CollectionKey collectionKey) {
        NeboDMSJNI.NotebookCreationInfo_parentCollectionKey_set(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public CollectionKey getParentCollectionKey() {
        long jNotebookCreationInfo_parentCollectionKey_get = NeboDMSJNI.NotebookCreationInfo_parentCollectionKey_get(this.swigCPtr, this);
        if (jNotebookCreationInfo_parentCollectionKey_get == 0) {
            return null;
        }
        return new CollectionKey(jNotebookCreationInfo_parentCollectionKey_get, false);
    }

    public void setCoverColor(long j) {
        NeboDMSJNI.NotebookCreationInfo_coverColor_set(this.swigCPtr, this, j);
    }

    public long getCoverColor() {
        return NeboDMSJNI.NotebookCreationInfo_coverColor_get(this.swigCPtr, this);
    }

    public void setNotebookName(String str) {
        NeboDMSJNI.NotebookCreationInfo_notebookName_set(this.swigCPtr, this, str.getBytes());
    }

    public String getNotebookName() {
        return new String(NeboDMSJNI.NotebookCreationInfo_notebookName_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setImportNotebook(boolean z) {
        NeboDMSJNI.NotebookCreationInfo_importNotebook_set(this.swigCPtr, this, z);
    }

    public boolean getImportNotebook() {
        return NeboDMSJNI.NotebookCreationInfo_importNotebook_get(this.swigCPtr, this);
    }

    public NotebookCreationInfo() {
        this(NeboDMSJNI.new_NotebookCreationInfo__SWIG_0(), true);
    }

    public NotebookCreationInfo(CollectionKey collectionKey, long j, String str) {
        this(NeboDMSJNI.new_NotebookCreationInfo__SWIG_1(CollectionKey.getCPtr(collectionKey), collectionKey, j, str.getBytes()), true);
    }

    public boolean isValid() {
        return NeboDMSJNI.NotebookCreationInfo_isValid(this.swigCPtr, this);
    }
}
