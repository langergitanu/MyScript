package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class DMSError {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DMSError(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DMSError dMSError) {
        if (dMSError == null) {
            return 0L;
        }
        return dMSError.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_DMSError(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setMessage(String str) {
        NeboDMSJNI.DMSError_message_set(this.swigCPtr, this, str.getBytes());
    }

    public String getMessage() {
        return new String(NeboDMSJNI.DMSError_message_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setObjectUuid(String str) {
        NeboDMSJNI.DMSError_objectUuid_set(this.swigCPtr, this, str.getBytes());
    }

    public String getObjectUuid() {
        return new String(NeboDMSJNI.DMSError_objectUuid_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public DMSError() {
        this(NeboDMSJNI.new_DMSError(), true);
    }
}
