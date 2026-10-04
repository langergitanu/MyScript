package com.myscript.snt.dms;

import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class MonkeyOperationData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MonkeyOperationData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MonkeyOperationData monkeyOperationData) {
        if (monkeyOperationData == null) {
            return 0L;
        }
        return monkeyOperationData.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_MonkeyOperationData(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setDevice(int i) {
        NeboDMSJNI.MonkeyOperationData_device_set(this.swigCPtr, this, i);
    }

    public int getDevice() {
        return NeboDMSJNI.MonkeyOperationData_device_get(this.swigCPtr, this);
    }

    public void setStep(int i) {
        NeboDMSJNI.MonkeyOperationData_step_set(this.swigCPtr, this, i);
    }

    public int getStep() {
        return NeboDMSJNI.MonkeyOperationData_step_get(this.swigCPtr, this);
    }

    public void setOperation(MonkeyOperation monkeyOperation) {
        NeboDMSJNI.MonkeyOperationData_operation_set(this.swigCPtr, this, monkeyOperation.swigValue());
    }

    public MonkeyOperation getOperation() {
        return MonkeyOperation.swigToEnum(NeboDMSJNI.MonkeyOperationData_operation_get(this.swigCPtr, this));
    }

    public void setCollectionKey(CollectionKey collectionKey) {
        NeboDMSJNI.MonkeyOperationData_collectionKey_set(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public CollectionKey getCollectionKey() {
        long jMonkeyOperationData_collectionKey_get = NeboDMSJNI.MonkeyOperationData_collectionKey_get(this.swigCPtr, this);
        if (jMonkeyOperationData_collectionKey_get == 0) {
            return null;
        }
        return new CollectionKey(jMonkeyOperationData_collectionKey_get, false);
    }

    public void setNotebookKey(NotebookKey notebookKey) {
        NeboDMSJNI.MonkeyOperationData_notebookKey_set(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public NotebookKey getNotebookKey() {
        long jMonkeyOperationData_notebookKey_get = NeboDMSJNI.MonkeyOperationData_notebookKey_get(this.swigCPtr, this);
        if (jMonkeyOperationData_notebookKey_get == 0) {
            return null;
        }
        return new NotebookKey(jMonkeyOperationData_notebookKey_get, false);
    }

    public void setPageContainerKey(PageKey pageKey) {
        NeboDMSJNI.MonkeyOperationData_pageContainerKey_set(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public PageKey getPageContainerKey() {
        long jMonkeyOperationData_pageContainerKey_get = NeboDMSJNI.MonkeyOperationData_pageContainerKey_get(this.swigCPtr, this);
        if (jMonkeyOperationData_pageContainerKey_get == 0) {
            return null;
        }
        return new PageKey(jMonkeyOperationData_pageContainerKey_get, false);
    }

    public void setPageKey(PageKey pageKey) {
        NeboDMSJNI.MonkeyOperationData_pageKey_set(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public PageKey getPageKey() {
        long jMonkeyOperationData_pageKey_get = NeboDMSJNI.MonkeyOperationData_pageKey_get(this.swigCPtr, this);
        if (jMonkeyOperationData_pageKey_get == 0) {
            return null;
        }
        return new PageKey(jMonkeyOperationData_pageKey_get, false);
    }

    public void setNewPositionIndex(int i) {
        NeboDMSJNI.MonkeyOperationData_newPositionIndex_set(this.swigCPtr, this, i);
    }

    public int getNewPositionIndex() {
        return NeboDMSJNI.MonkeyOperationData_newPositionIndex_get(this.swigCPtr, this);
    }

    public void setDisabled(boolean z) {
        NeboDMSJNI.MonkeyOperationData_disabled_set(this.swigCPtr, this, z);
    }

    public boolean getDisabled() {
        return NeboDMSJNI.MonkeyOperationData_disabled_get(this.swigCPtr, this);
    }

    public void setNewUuid(String str) {
        NeboDMSJNI.MonkeyOperationData_newUuid_set(this.swigCPtr, this, str.getBytes());
    }

    public String getNewUuid() {
        return new String(NeboDMSJNI.MonkeyOperationData_newUuid_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public MonkeyOperationData() {
        this(NeboDMSJNI.new_MonkeyOperationData(), true);
    }
}
