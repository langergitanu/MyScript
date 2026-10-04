package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CloudCreateFileRequest {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudCreateFileRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudCreateFileRequest cloudCreateFileRequest) {
        if (cloudCreateFileRequest == null) {
            return 0L;
        }
        return cloudCreateFileRequest.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudCreateFileRequest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CloudCreateFileRequest(long j, CloudFile cloudFile, String str, String str2, String str3) {
        this(NeboDMSJNI.new_CloudCreateFileRequest__SWIG_0(j, CloudFile.getCPtr(cloudFile), cloudFile, str.getBytes(), str2.getBytes(), str3.getBytes()), true);
    }

    public CloudCreateFileRequest(CloudFile cloudFile, String str, String str2, String str3) {
        this(NeboDMSJNI.new_CloudCreateFileRequest__SWIG_1(CloudFile.getCPtr(cloudFile), cloudFile, str.getBytes(), str2.getBytes(), str3.getBytes()), true);
    }

    public void setRequestId(long j) {
        NeboDMSJNI.CloudCreateFileRequest_requestId_set(this.swigCPtr, this, j);
    }

    public long getRequestId() {
        return NeboDMSJNI.CloudCreateFileRequest_requestId_get(this.swigCPtr, this);
    }

    public void setParent(CloudFile cloudFile) {
        NeboDMSJNI.CloudCreateFileRequest_parent_set(this.swigCPtr, this, CloudFile.getCPtr(cloudFile), cloudFile);
    }

    public CloudFile getParent() {
        long jCloudCreateFileRequest_parent_get = NeboDMSJNI.CloudCreateFileRequest_parent_get(this.swigCPtr, this);
        if (jCloudCreateFileRequest_parent_get == 0) {
            return null;
        }
        return new CloudFile(jCloudCreateFileRequest_parent_get, false);
    }

    public void setName(String str) {
        NeboDMSJNI.CloudCreateFileRequest_name_set(this.swigCPtr, this, str.getBytes());
    }

    public String getName() {
        return new String(NeboDMSJNI.CloudCreateFileRequest_name_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setMimeType(String str) {
        NeboDMSJNI.CloudCreateFileRequest_mimeType_set(this.swigCPtr, this, str.getBytes());
    }

    public String getMimeType() {
        return new String(NeboDMSJNI.CloudCreateFileRequest_mimeType_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setLocalPath(String str) {
        NeboDMSJNI.CloudCreateFileRequest_localPath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getLocalPath() {
        return new String(NeboDMSJNI.CloudCreateFileRequest_localPath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
