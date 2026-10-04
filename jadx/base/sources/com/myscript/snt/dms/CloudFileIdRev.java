package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CloudFileIdRev {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudFileIdRev(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudFileIdRev cloudFileIdRev) {
        if (cloudFileIdRev == null) {
            return 0L;
        }
        return cloudFileIdRev.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudFileIdRev(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setId(String str) {
        NeboDMSJNI.CloudFileIdRev_id_set(this.swigCPtr, this, str.getBytes());
    }

    public String getId() {
        return new String(NeboDMSJNI.CloudFileIdRev_id_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setRevision(String str) {
        NeboDMSJNI.CloudFileIdRev_revision_set(this.swigCPtr, this, str.getBytes());
    }

    public String getRevision() {
        return new String(NeboDMSJNI.CloudFileIdRev_revision_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public CloudFileIdRev() {
        this(NeboDMSJNI.new_CloudFileIdRev(), true);
    }
}
