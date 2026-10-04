package com.myscript.snt.dms;

/* JADX INFO: loaded from: classes7.dex */
public class ObjectWithTrashState {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ObjectWithTrashState(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ObjectWithTrashState objectWithTrashState) {
        if (objectWithTrashState == null) {
            return 0L;
        }
        return objectWithTrashState.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_ObjectWithTrashState(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static class Trash {
        protected transient boolean swigCMemOwn;
        private transient long swigCPtr;

        public Trash(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        public static long getCPtr(Trash trash) {
            if (trash == null) {
                return 0L;
            }
            return trash.swigCPtr;
        }

        protected void finalize() {
            delete();
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    NeboDMSJNI.delete_ObjectWithTrashState_Trash(j);
                }
                this.swigCPtr = 0L;
            }
        }

        public void setState(TrashState trashState) {
            NeboDMSJNI.ObjectWithTrashState_Trash_state_set(this.swigCPtr, this, trashState.swigValue());
        }

        public TrashState getState() {
            return TrashState.swigToEnum(NeboDMSJNI.ObjectWithTrashState_Trash_state_get(this.swigCPtr, this));
        }

        public void setTimestamp(long j) {
            NeboDMSJNI.ObjectWithTrashState_Trash_timestamp_set(this.swigCPtr, this, j);
        }

        public long getTimestamp() {
            return NeboDMSJNI.ObjectWithTrashState_Trash_timestamp_get(this.swigCPtr, this);
        }

        public Trash() {
            this(NeboDMSJNI.new_ObjectWithTrashState_Trash(), true);
        }
    }

    public void setObject(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.ObjectWithTrashState_object_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getObject() {
        long jObjectWithTrashState_object_get = NeboDMSJNI.ObjectWithTrashState_object_get(this.swigCPtr, this);
        if (jObjectWithTrashState_object_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jObjectWithTrashState_object_get, false);
    }

    public void setTrash(Trash trash) {
        NeboDMSJNI.ObjectWithTrashState_trash_set(this.swigCPtr, this, Trash.getCPtr(trash), trash);
    }

    public Trash getTrash() {
        long jObjectWithTrashState_trash_get = NeboDMSJNI.ObjectWithTrashState_trash_get(this.swigCPtr, this);
        if (jObjectWithTrashState_trash_get == 0) {
            return null;
        }
        return new Trash(jObjectWithTrashState_trash_get, false);
    }

    public ObjectWithTrashState() {
        this(NeboDMSJNI.new_ObjectWithTrashState(), true);
    }
}
