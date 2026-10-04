package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class SyncStateWithCauses {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SyncStateWithCauses(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SyncStateWithCauses syncStateWithCauses) {
        if (syncStateWithCauses == null) {
            return 0L;
        }
        return syncStateWithCauses.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SyncStateWithCauses(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setSyncState(SyncState syncState) {
        NeboDMSJNI.SyncStateWithCauses_syncState_set(this.swigCPtr, this, syncState.swigValue());
    }

    public SyncState getSyncState() {
        return SyncState.swigToEnum(NeboDMSJNI.SyncStateWithCauses_syncState_get(this.swigCPtr, this));
    }

    public void setCauses(SWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t sWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t) {
        NeboDMSJNI.SyncStateWithCauses_causes_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t.getCPtr(sWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t));
    }

    public SWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t getCauses() {
        long jSyncStateWithCauses_causes_get = NeboDMSJNI.SyncStateWithCauses_causes_get(this.swigCPtr, this);
        if (jSyncStateWithCauses_causes_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t(jSyncStateWithCauses_causes_get, false);
    }

    public SyncStateWithCauses(SyncState syncState) {
        this(NeboDMSJNI.new_SyncStateWithCauses__SWIG_0(syncState.swigValue()), true);
    }

    public SyncStateWithCauses(SyncState syncState, SyncStateCause syncStateCause) {
        this(NeboDMSJNI.new_SyncStateWithCauses__SWIG_1(syncState.swigValue(), syncStateCause.swigValue()), true);
    }

    public SyncStateWithCauses(SyncState syncState, SWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t sWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t) {
        this(NeboDMSJNI.new_SyncStateWithCauses__SWIG_2(syncState.swigValue(), SWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t.getCPtr(sWIGTYPE_p_std__vectorT_snt__dms__SyncStateCause_t)), true);
    }
}
