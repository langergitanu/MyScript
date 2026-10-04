package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class MetadataInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MetadataInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MetadataInfo metadataInfo) {
        if (metadataInfo == null) {
            return 0L;
        }
        return metadataInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_MetadataInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setKey(String str) {
        NeboDMSJNI.MetadataInfo_key_set(this.swigCPtr, this, str.getBytes());
    }

    public String getKey() {
        return new String(NeboDMSJNI.MetadataInfo_key_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setValue(String str) {
        NeboDMSJNI.MetadataInfo_value_set(this.swigCPtr, this, str.getBytes());
    }

    public String getValue() {
        return new String(NeboDMSJNI.MetadataInfo_value_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTimestamp(long j) {
        NeboDMSJNI.MetadataInfo_timestamp_set(this.swigCPtr, this, j);
    }

    public long getTimestamp() {
        return NeboDMSJNI.MetadataInfo_timestamp_get(this.swigCPtr, this);
    }

    public MetadataInfo() {
        this(NeboDMSJNI.new_MetadataInfo__SWIG_0(), true);
    }

    public MetadataInfo(String str, String str2, long j) {
        this(NeboDMSJNI.new_MetadataInfo__SWIG_1(str.getBytes(), str2.getBytes(), j), true);
    }
}
