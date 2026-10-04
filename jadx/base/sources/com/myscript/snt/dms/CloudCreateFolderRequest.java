package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CloudCreateFolderRequest {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudCreateFolderRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudCreateFolderRequest cloudCreateFolderRequest) {
        if (cloudCreateFolderRequest == null) {
            return 0L;
        }
        return cloudCreateFolderRequest.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudCreateFolderRequest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CloudCreateFolderRequest(long j, CloudFile cloudFile, String str) {
        this(NeboDMSJNI.new_CloudCreateFolderRequest__SWIG_0(j, CloudFile.getCPtr(cloudFile), cloudFile, str.getBytes()), true);
    }

    public CloudCreateFolderRequest(CloudFile cloudFile, String str) {
        this(NeboDMSJNI.new_CloudCreateFolderRequest__SWIG_1(CloudFile.getCPtr(cloudFile), cloudFile, str.getBytes()), true);
    }

    public void setRequestId(long j) {
        NeboDMSJNI.CloudCreateFolderRequest_requestId_set(this.swigCPtr, this, j);
    }

    public long getRequestId() {
        return NeboDMSJNI.CloudCreateFolderRequest_requestId_get(this.swigCPtr, this);
    }

    public void setParent(CloudFile cloudFile) {
        NeboDMSJNI.CloudCreateFolderRequest_parent_set(this.swigCPtr, this, CloudFile.getCPtr(cloudFile), cloudFile);
    }

    public CloudFile getParent() {
        long jCloudCreateFolderRequest_parent_get = NeboDMSJNI.CloudCreateFolderRequest_parent_get(this.swigCPtr, this);
        if (jCloudCreateFolderRequest_parent_get == 0) {
            return null;
        }
        return new CloudFile(jCloudCreateFolderRequest_parent_get, false);
    }

    public void setName(String str) {
        NeboDMSJNI.CloudCreateFolderRequest_name_set(this.swigCPtr, this, str.getBytes());
    }

    public String getName() {
        return new String(NeboDMSJNI.CloudCreateFolderRequest_name_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
