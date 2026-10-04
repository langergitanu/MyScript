package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutItemObject extends LayoutItem {
    private transient long swigCPtr;

    public LayoutItemObject(long j, boolean z) {
        super(ATKCoreJNI.LayoutItemObject_SWIGUpcast(j), z);
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutItemObject layoutItemObject) {
        if (layoutItemObject == null) {
            return 0L;
        }
        return layoutItemObject.swigCPtr;
    }

    @Override // com.myscript.atk.core.LayoutItem
    protected void finalize() {
        delete();
    }

    @Override // com.myscript.atk.core.LayoutItem
    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LayoutItemObject(this.swigCPtr);
            }
            this.swigCPtr = 0L;
        }
        super.delete();
    }

    public String getUrl() {
        return new String(ATKCoreJNI.LayoutItemObject_getUrl(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public LayoutObjectData getData() {
        return new LayoutObjectData(ATKCoreJNI.LayoutItemObject_getData(this.swigCPtr, this), true);
    }

    public Transform getTransform() {
        return new Transform(ATKCoreJNI.LayoutItemObject_getTransform(this.swigCPtr, this), true);
    }

    public void setCustomAttribute(String str, String str2) {
        ATKCoreJNI.LayoutItemObject_setCustomAttribute(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public String getCustomAttribute(String str) {
        return new String(ATKCoreJNI.LayoutItemObject_getCustomAttribute(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public void removeCustomAttribute(String str) {
        ATKCoreJNI.LayoutItemObject_removeCustomAttribute(this.swigCPtr, this, str.getBytes());
    }

    public int getCustomAttributeCount() {
        return ATKCoreJNI.LayoutItemObject_getCustomAttributeCount(this.swigCPtr, this);
    }

    public void setCustomAttributeAsFloat(String str, float f) {
        ATKCoreJNI.LayoutItemObject_setCustomAttributeAsFloat(this.swigCPtr, this, str.getBytes(), f);
    }

    public float getCustomAttributeAsFloat(String str, float f) {
        return ATKCoreJNI.LayoutItemObject_getCustomAttributeAsFloat(this.swigCPtr, this, str.getBytes(), f);
    }

    public void setCustomAttributeAsInt64(String str, long j) {
        ATKCoreJNI.LayoutItemObject_setCustomAttributeAsInt64(this.swigCPtr, this, str.getBytes(), j);
    }

    public long getCustomAttributeAsInt64(String str, long j) {
        return ATKCoreJNI.LayoutItemObject_getCustomAttributeAsInt64(this.swigCPtr, this, str.getBytes(), j);
    }
}
