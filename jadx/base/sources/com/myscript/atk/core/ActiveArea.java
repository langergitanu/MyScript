package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class ActiveArea {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ActiveArea(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ActiveArea activeArea) {
        if (activeArea == null) {
            return 0L;
        }
        return activeArea.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_ActiveArea(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public String getId() {
        return new String(ATKCoreJNI.ActiveArea_getId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public int getIndex() {
        return ATKCoreJNI.ActiveArea_getIndex(this.swigCPtr, this);
    }

    public void setIndex(int i) {
        ATKCoreJNI.ActiveArea_setIndex(this.swigCPtr, this, i);
    }

    public void setExtent(Extent extent) {
        ATKCoreJNI.ActiveArea_setExtent(this.swigCPtr, this, Extent.getCPtr(extent));
    }

    public Extent getExtent() {
        return new Extent(ATKCoreJNI.ActiveArea_getExtent(this.swigCPtr, this), true);
    }

    public int getFieldCount(ContentFieldType contentFieldType) {
        return ATKCoreJNI.ActiveArea_getFieldCount(this.swigCPtr, this, contentFieldType.swigValue());
    }

    public String getFieldNameAt(ContentFieldType contentFieldType, int i) {
        return ATKCoreJNI.ActiveArea_getFieldNameAt(this.swigCPtr, this, contentFieldType.swigValue(), i);
    }

    public SWIGTYPE_p_myscript__document__ContentFieldIterator getFields() {
        return new SWIGTYPE_p_myscript__document__ContentFieldIterator(ATKCoreJNI.ActiveArea_getFields(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_myscript__document__ContentFieldIterator getFieldsForType(ContentFieldType contentFieldType) {
        return new SWIGTYPE_p_myscript__document__ContentFieldIterator(ATKCoreJNI.ActiveArea_getFieldsForType(this.swigCPtr, this, contentFieldType.swigValue()), true);
    }

    public void setCustomAttribute(String str, String str2) {
        ATKCoreJNI.ActiveArea_setCustomAttribute(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public String getCustomAttribute(String str) {
        return new String(ATKCoreJNI.ActiveArea_getCustomAttribute(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public void removeCustomAttribute(String str) {
        ATKCoreJNI.ActiveArea_removeCustomAttribute(this.swigCPtr, this, str.getBytes());
    }

    public int getCustomAttributeCount() {
        return ATKCoreJNI.ActiveArea_getCustomAttributeCount(this.swigCPtr, this);
    }

    public void setCustomAttributeAsFloat(String str, float f) {
        ATKCoreJNI.ActiveArea_setCustomAttributeAsFloat(this.swigCPtr, this, str.getBytes(), f);
    }

    public float getCustomAttributeAsFloat(String str, float f) {
        return ATKCoreJNI.ActiveArea_getCustomAttributeAsFloat(this.swigCPtr, this, str.getBytes(), f);
    }

    public void setCustomAttributeAsInt64(String str, long j) {
        ATKCoreJNI.ActiveArea_setCustomAttributeAsInt64(this.swigCPtr, this, str.getBytes(), j);
    }

    public long getCustomAttributeAsInt64(String str, long j) {
        return ATKCoreJNI.ActiveArea_getCustomAttributeAsInt64(this.swigCPtr, this, str.getBytes(), j);
    }

    public ActiveArea(ActiveArea activeArea) {
        this(ATKCoreJNI.new_ActiveArea(getCPtr(activeArea), activeArea), true);
    }
}
