package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class CloudFileData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CloudFileData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CloudFileData cloudFileData) {
        if (cloudFileData == null) {
            return 0L;
        }
        return cloudFileData.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_CloudFileData(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CloudFileData() {
        this(NeboDMSJNI.new_CloudFileData__SWIG_0(), true);
    }

    public CloudFileData(CloudFileData cloudFileData) {
        this(NeboDMSJNI.new_CloudFileData__SWIG_1(getCPtr(cloudFileData), cloudFileData), true);
    }

    public void setId(String str) {
        NeboDMSJNI.CloudFileData_setId(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasId() {
        return NeboDMSJNI.CloudFileData_hasId(this.swigCPtr, this);
    }

    /* JADX INFO: renamed from: id */
    public String m1102id() {
        return new String(NeboDMSJNI.CloudFileData_id(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setParentId(String str) {
        NeboDMSJNI.CloudFileData_setParentId(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasParentId() {
        return NeboDMSJNI.CloudFileData_hasParentId(this.swigCPtr, this);
    }

    public String parentId() {
        return new String(NeboDMSJNI.CloudFileData_parentId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setName(String str) {
        NeboDMSJNI.CloudFileData_setName(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasName() {
        return NeboDMSJNI.CloudFileData_hasName(this.swigCPtr, this);
    }

    public String name() {
        return new String(NeboDMSJNI.CloudFileData_name(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setPath(String str) {
        NeboDMSJNI.CloudFileData_setPath(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasPath() {
        return NeboDMSJNI.CloudFileData_hasPath(this.swigCPtr, this);
    }

    public String path() {
        return new String(NeboDMSJNI.CloudFileData_path(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setLastModificationDate(long j) {
        NeboDMSJNI.CloudFileData_setLastModificationDate(this.swigCPtr, this, j);
    }

    public boolean hasLastModificationDate() {
        return NeboDMSJNI.CloudFileData_hasLastModificationDate(this.swigCPtr, this);
    }

    public long lastModificationDate() {
        return NeboDMSJNI.CloudFileData_lastModificationDate(this.swigCPtr, this);
    }

    public void setIsFolder(boolean z) {
        NeboDMSJNI.CloudFileData_setIsFolder(this.swigCPtr, this, z);
    }

    public boolean hasIsFolder() {
        return NeboDMSJNI.CloudFileData_hasIsFolder(this.swigCPtr, this);
    }

    public boolean isFolder() {
        return NeboDMSJNI.CloudFileData_isFolder(this.swigCPtr, this);
    }

    public void setRevision(String str) {
        NeboDMSJNI.CloudFileData_setRevision(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasRevision() {
        return NeboDMSJNI.CloudFileData_hasRevision(this.swigCPtr, this);
    }

    public String revision() {
        return new String(NeboDMSJNI.CloudFileData_revision(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setSize(long j) {
        NeboDMSJNI.CloudFileData_setSize(this.swigCPtr, this, j);
    }

    public boolean hasSize() {
        return NeboDMSJNI.CloudFileData_hasSize(this.swigCPtr, this);
    }

    public long size() {
        return NeboDMSJNI.CloudFileData_size(this.swigCPtr, this);
    }

    public void setMimeType(String str) {
        NeboDMSJNI.CloudFileData_setMimeType(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasMimeType() {
        return NeboDMSJNI.CloudFileData_hasMimeType(this.swigCPtr, this);
    }

    public String mimeType() {
        return new String(NeboDMSJNI.CloudFileData_mimeType(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
