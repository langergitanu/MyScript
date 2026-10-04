package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CloudFileRequest {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudFileRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudFileRequest cloudFileRequest) {
        if (cloudFileRequest == null) {
            return 0L;
        }
        return cloudFileRequest.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudFileRequest(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CloudFileRequest(long j, CloudFile cloudFile, String str, String str2) {
        this(NeboDMSJNI.new_CloudFileRequest__SWIG_0(j, CloudFile.getCPtr(cloudFile), cloudFile, str.getBytes(), str2.getBytes()), true);
    }

    public CloudFileRequest(long j, CloudFile cloudFile, String str) {
        this(NeboDMSJNI.new_CloudFileRequest__SWIG_1(j, CloudFile.getCPtr(cloudFile), cloudFile, str.getBytes()), true);
    }

    public CloudFileRequest(CloudFile cloudFile, String str) {
        this(NeboDMSJNI.new_CloudFileRequest__SWIG_2(CloudFile.getCPtr(cloudFile), cloudFile, str.getBytes()), true);
    }

    public CloudFileRequest(String str) {
        this(NeboDMSJNI.new_CloudFileRequest__SWIG_3(str.getBytes()), true);
    }

    public void setRequestId(long j) {
        NeboDMSJNI.CloudFileRequest_requestId_set(this.swigCPtr, this, j);
    }

    public long getRequestId() {
        return NeboDMSJNI.CloudFileRequest_requestId_get(this.swigCPtr, this);
    }

    public void setFile(CloudFile cloudFile) {
        NeboDMSJNI.CloudFileRequest_file_set(this.swigCPtr, this, CloudFile.getCPtr(cloudFile), cloudFile);
    }

    public CloudFile getFile() {
        long jCloudFileRequest_file_get = NeboDMSJNI.CloudFileRequest_file_get(this.swigCPtr, this);
        if (jCloudFileRequest_file_get == 0) {
            return null;
        }
        return new CloudFile(jCloudFileRequest_file_get, false);
    }

    public void setOutputPath(String str) {
        NeboDMSJNI.CloudFileRequest_outputPath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getOutputPath() {
        return new String(NeboDMSJNI.CloudFileRequest_outputPath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setRevision(String str) {
        NeboDMSJNI.CloudFileRequest_revision_set(this.swigCPtr, this, str.getBytes());
    }

    public String getRevision() {
        return new String(NeboDMSJNI.CloudFileRequest_revision_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
