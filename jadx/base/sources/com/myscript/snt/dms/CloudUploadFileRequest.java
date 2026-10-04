package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CloudUploadFileRequest {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudUploadFileRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudUploadFileRequest cloudUploadFileRequest) {
        if (cloudUploadFileRequest == null) {
            return 0L;
        }
        return cloudUploadFileRequest.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudUploadFileRequest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CloudUploadFileRequest(long j, CloudFile cloudFile, String str) {
        this(NeboDMSJNI.new_CloudUploadFileRequest__SWIG_0(j, CloudFile.getCPtr(cloudFile), cloudFile, str.getBytes()), true);
    }

    public CloudUploadFileRequest(CloudFile cloudFile, String str) {
        this(NeboDMSJNI.new_CloudUploadFileRequest__SWIG_1(CloudFile.getCPtr(cloudFile), cloudFile, str.getBytes()), true);
    }

    public void setRequestId(long j) {
        NeboDMSJNI.CloudUploadFileRequest_requestId_set(this.swigCPtr, this, j);
    }

    public long getRequestId() {
        return NeboDMSJNI.CloudUploadFileRequest_requestId_get(this.swigCPtr, this);
    }

    public void setFile(CloudFile cloudFile) {
        NeboDMSJNI.CloudUploadFileRequest_file_set(this.swigCPtr, this, CloudFile.getCPtr(cloudFile), cloudFile);
    }

    public CloudFile getFile() {
        long jCloudUploadFileRequest_file_get = NeboDMSJNI.CloudUploadFileRequest_file_get(this.swigCPtr, this);
        if (jCloudUploadFileRequest_file_get == 0) {
            return null;
        }
        return new CloudFile(jCloudUploadFileRequest_file_get, false);
    }

    public void setLocalPath(String str) {
        NeboDMSJNI.CloudUploadFileRequest_localPath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getLocalPath() {
        return new String(NeboDMSJNI.CloudUploadFileRequest_localPath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
