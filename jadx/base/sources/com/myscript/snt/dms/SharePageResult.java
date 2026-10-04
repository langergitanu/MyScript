package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class SharePageResult {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SharePageResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SharePageResult sharePageResult) {
        if (sharePageResult == null) {
            return 0L;
        }
        return sharePageResult.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_SharePageResult(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setIsSuccess(boolean z) {
        NeboDMSJNI.SharePageResult_isSuccess_set(this.swigCPtr, this, z);
    }

    public boolean getIsSuccess() {
        return NeboDMSJNI.SharePageResult_isSuccess_get(this.swigCPtr, this);
    }

    public void setUploadedDateMicroSeconds(long j) {
        NeboDMSJNI.SharePageResult_uploadedDateMicroSeconds_set(this.swigCPtr, this, j);
    }

    public long getUploadedDateMicroSeconds() {
        return NeboDMSJNI.SharePageResult_uploadedDateMicroSeconds_get(this.swigCPtr, this);
    }

    public void setSharedLink(String str) {
        NeboDMSJNI.SharePageResult_sharedLink_set(this.swigCPtr, this, str.getBytes());
    }

    public String getSharedLink() {
        return new String(NeboDMSJNI.SharePageResult_sharedLink_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setReturnCode(SharePageRequestResultCode sharePageRequestResultCode) {
        NeboDMSJNI.SharePageResult_returnCode_set(this.swigCPtr, this, sharePageRequestResultCode.swigValue());
    }

    public SharePageRequestResultCode getReturnCode() {
        return SharePageRequestResultCode.swigToEnum(NeboDMSJNI.SharePageResult_returnCode_get(this.swigCPtr, this));
    }

    public SharePageResult() {
        this(NeboDMSJNI.new_SharePageResult(), true);
    }
}
