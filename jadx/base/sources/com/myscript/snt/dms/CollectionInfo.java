package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CollectionInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CollectionInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CollectionInfo collectionInfo) {
        if (collectionInfo == null) {
            return 0L;
        }
        return collectionInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CollectionInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setObject(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.CollectionInfo_object_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getObject() {
        long jCollectionInfo_object_get = NeboDMSJNI.CollectionInfo_object_get(this.swigCPtr, this);
        if (jCollectionInfo_object_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jCollectionInfo_object_get, false);
    }

    public void setName(String str) {
        NeboDMSJNI.CollectionInfo_name_set(this.swigCPtr, this, str.getBytes());
    }

    public String getName() {
        return new String(NeboDMSJNI.CollectionInfo_name_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTrashState(TrashState trashState) {
        NeboDMSJNI.CollectionInfo_trashState_set(this.swigCPtr, this, trashState.swigValue());
    }

    public TrashState getTrashState() {
        return TrashState.swigToEnum(NeboDMSJNI.CollectionInfo_trashState_get(this.swigCPtr, this));
    }

    public boolean valid() {
        return NeboDMSJNI.CollectionInfo_valid(this.swigCPtr, this);
    }

    public CollectionInfo() {
        this(NeboDMSJNI.new_CollectionInfo__SWIG_0(), true);
    }

    public CollectionInfo(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object, String str, TrashState trashState) {
        this(NeboDMSJNI.new_CollectionInfo__SWIG_1(SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object), str.getBytes(), trashState.swigValue()), true);
    }
}
