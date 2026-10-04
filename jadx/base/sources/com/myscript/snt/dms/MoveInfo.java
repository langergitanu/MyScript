package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class MoveInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MoveInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MoveInfo moveInfo) {
        if (moveInfo == null) {
            return 0L;
        }
        return moveInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_MoveInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setOldParent(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.MoveInfo_oldParent_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getOldParent() {
        long jMoveInfo_oldParent_get = NeboDMSJNI.MoveInfo_oldParent_get(this.swigCPtr, this);
        if (jMoveInfo_oldParent_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jMoveInfo_oldParent_get, false);
    }

    public void setOldChildIndex(int i) {
        NeboDMSJNI.MoveInfo_oldChildIndex_set(this.swigCPtr, this, i);
    }

    public int getOldChildIndex() {
        return NeboDMSJNI.MoveInfo_oldChildIndex_get(this.swigCPtr, this);
    }

    public void setNewParent(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.MoveInfo_newParent_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getNewParent() {
        long jMoveInfo_newParent_get = NeboDMSJNI.MoveInfo_newParent_get(this.swigCPtr, this);
        if (jMoveInfo_newParent_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jMoveInfo_newParent_get, false);
    }

    public void setNewChildIndex(int i) {
        NeboDMSJNI.MoveInfo_newChildIndex_set(this.swigCPtr, this, i);
    }

    public int getNewChildIndex() {
        return NeboDMSJNI.MoveInfo_newChildIndex_get(this.swigCPtr, this);
    }

    public MoveInfo() {
        this(NeboDMSJNI.new_MoveInfo__SWIG_0(), true);
    }

    public MoveInfo(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object, int i, SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object2, int i2) {
        this(NeboDMSJNI.new_MoveInfo__SWIG_1(SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object), i, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object2), i2), true);
    }
}
