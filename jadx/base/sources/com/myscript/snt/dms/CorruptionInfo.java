package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CorruptionInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CorruptionInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CorruptionInfo corruptionInfo) {
        if (corruptionInfo == null) {
            return 0L;
        }
        return corruptionInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CorruptionInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setSource(String str) {
        NeboDMSJNI.CorruptionInfo_source_set(this.swigCPtr, this, str.getBytes());
    }

    public String getSource() {
        return new String(NeboDMSJNI.CorruptionInfo_source_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setReason(String str) {
        NeboDMSJNI.CorruptionInfo_reason_set(this.swigCPtr, this, str.getBytes());
    }

    public String getReason() {
        return new String(NeboDMSJNI.CorruptionInfo_reason_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setMessage(String str) {
        NeboDMSJNI.CorruptionInfo_message_set(this.swigCPtr, this, str.getBytes());
    }

    public String getMessage() {
        return new String(NeboDMSJNI.CorruptionInfo_message_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setSignature(String str) {
        NeboDMSJNI.CorruptionInfo_signature_set(this.swigCPtr, this, str.getBytes());
    }

    public String getSignature() {
        return new String(NeboDMSJNI.CorruptionInfo_signature_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setVersion(String str) {
        NeboDMSJNI.CorruptionInfo_version_set(this.swigCPtr, this, str.getBytes());
    }

    public String getVersion() {
        return new String(NeboDMSJNI.CorruptionInfo_version_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTimestamp(long j) {
        NeboDMSJNI.CorruptionInfo_timestamp_set(this.swigCPtr, this, j);
    }

    public long getTimestamp() {
        return NeboDMSJNI.CorruptionInfo_timestamp_get(this.swigCPtr, this);
    }

    public CorruptionInfo() {
        this(NeboDMSJNI.new_CorruptionInfo(), true);
    }
}
