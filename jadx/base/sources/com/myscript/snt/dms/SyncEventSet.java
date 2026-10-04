package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class SyncEventSet {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SyncEventSet(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SyncEventSet syncEventSet) {
        if (syncEventSet == null) {
            return 0L;
        }
        return syncEventSet.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SyncEventSet(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setLocal(SyncEvent syncEvent) {
        NeboDMSJNI.SyncEventSet_local_set(this.swigCPtr, this, SyncEvent.getCPtr(syncEvent), syncEvent);
    }

    public SyncEvent getLocal() {
        long jSyncEventSet_local_get = NeboDMSJNI.SyncEventSet_local_get(this.swigCPtr, this);
        if (jSyncEventSet_local_get == 0) {
            return null;
        }
        return new SyncEvent(jSyncEventSet_local_get, false);
    }

    public void setCloud(SyncEvent syncEvent) {
        NeboDMSJNI.SyncEventSet_cloud_set(this.swigCPtr, this, SyncEvent.getCPtr(syncEvent), syncEvent);
    }

    public SyncEvent getCloud() {
        long jSyncEventSet_cloud_get = NeboDMSJNI.SyncEventSet_cloud_get(this.swigCPtr, this);
        if (jSyncEventSet_cloud_get == 0) {
            return null;
        }
        return new SyncEvent(jSyncEventSet_cloud_get, false);
    }

    public void setMerged(SyncEvent syncEvent) {
        NeboDMSJNI.SyncEventSet_merged_set(this.swigCPtr, this, SyncEvent.getCPtr(syncEvent), syncEvent);
    }

    public SyncEvent getMerged() {
        long jSyncEventSet_merged_get = NeboDMSJNI.SyncEventSet_merged_get(this.swigCPtr, this);
        if (jSyncEventSet_merged_get == 0) {
            return null;
        }
        return new SyncEvent(jSyncEventSet_merged_get, false);
    }

    public SyncEventSet() {
        this(NeboDMSJNI.new_SyncEventSet(), true);
    }
}
