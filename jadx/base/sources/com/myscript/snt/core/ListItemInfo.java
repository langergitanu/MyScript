package com.myscript.snt.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class ListItemInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ListItemInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ListItemInfo listItemInfo) {
        if (listItemInfo == null) {
            return 0L;
        }
        return listItemInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_ListItemInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public ListItemInfo(String str, ListItemType listItemType, float f, float f2, int i, String str2) {
        this(NeboEngineJNI.new_ListItemInfo__SWIG_0(str.getBytes(), listItemType.swigValue(), f, f2, i, str2.getBytes()), true);
    }

    public ListItemInfo() {
        this(NeboEngineJNI.new_ListItemInfo__SWIG_1(), true);
    }

    public String uuid() {
        return new String(NeboEngineJNI.ListItemInfo_uuid(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public ListItemType type() {
        return ListItemType.swigToEnum(NeboEngineJNI.ListItemInfo_type(this.swigCPtr, this));
    }

    public void setType(ListItemType listItemType) {
        NeboEngineJNI.ListItemInfo_setType(this.swigCPtr, this, listItemType.swigValue());
    }

    public float rightLimitOffset() {
        return NeboEngineJNI.ListItemInfo_rightLimitOffset(this.swigCPtr, this);
    }

    public void setRightLimitOffset(float f) {
        NeboEngineJNI.ListItemInfo_setRightLimitOffset(this.swigCPtr, this, f);
    }

    public float rightLimitOffsetForSmallTypeset() {
        return NeboEngineJNI.ListItemInfo_rightLimitOffsetForSmallTypeset(this.swigCPtr, this);
    }

    public void setRightLimitOffsetForSmallTypeset(float f) {
        NeboEngineJNI.ListItemInfo_setRightLimitOffsetForSmallTypeset(this.swigCPtr, this, f);
    }

    public int wordCountBeforeOffset() {
        return NeboEngineJNI.ListItemInfo_wordCountBeforeOffset(this.swigCPtr, this);
    }

    public void setWordCountBeforeOffset(int i) {
        NeboEngineJNI.ListItemInfo_setWordCountBeforeOffset(this.swigCPtr, this, i);
    }

    public String bulletValue() {
        return new String(NeboEngineJNI.ListItemInfo_bulletValue(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setBulletValue(String str) {
        NeboEngineJNI.ListItemInfo_setBulletValue(this.swigCPtr, this, str.getBytes());
    }
}
