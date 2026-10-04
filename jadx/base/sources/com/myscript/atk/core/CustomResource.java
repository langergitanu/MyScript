package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class CustomResource {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public CustomResource(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(CustomResource customResource) {
        if (customResource == null) {
            return 0L;
        }
        return customResource.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_CustomResource(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public CustomResource(String str, CustomResourceType customResourceType) {
        this(ATKCoreJNI.new_CustomResource__SWIG_0(str.getBytes(), customResourceType.swigValue()), true);
    }

    public CustomResource(String str) {
        this(ATKCoreJNI.new_CustomResource__SWIG_1(str.getBytes()), true);
    }

    public void setResourcePath(String str) {
        ATKCoreJNI.CustomResource_resourcePath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getResourcePath() {
        return new String(ATKCoreJNI.CustomResource_resourcePath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setType(CustomResourceType customResourceType) {
        ATKCoreJNI.CustomResource_type_set(this.swigCPtr, this, customResourceType.swigValue());
    }

    public CustomResourceType getType() {
        return CustomResourceType.swigToEnum(ATKCoreJNI.CustomResource_type_get(this.swigCPtr, this));
    }

    public String toString() {
        return new String(ATKCoreJNI.CustomResource_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
