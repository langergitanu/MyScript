package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CloudFile {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudFile(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudFile cloudFile) {
        if (cloudFile == null) {
            return 0L;
        }
        return cloudFile.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudFile(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setId(String str) {
        NeboDMSJNI.CloudFile_id_set(this.swigCPtr, this, str.getBytes());
    }

    public String getId() {
        return new String(NeboDMSJNI.CloudFile_id_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setPath(String str) {
        NeboDMSJNI.CloudFile_path_set(this.swigCPtr, this, str.getBytes());
    }

    public String getPath() {
        return new String(NeboDMSJNI.CloudFile_path_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public CloudFile() {
        this(NeboDMSJNI.new_CloudFile(), true);
    }
}
