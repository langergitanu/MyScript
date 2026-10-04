package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutGroup {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LayoutGroup(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutGroup layoutGroup) {
        if (layoutGroup == null) {
            return 0L;
        }
        return layoutGroup.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LayoutGroup(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Extent getExtent() {
        return new Extent(ATKCoreJNI.LayoutGroup_getExtent(this.swigCPtr, this), true);
    }

    public boolean isLayer() {
        return ATKCoreJNI.LayoutGroup_isLayer(this.swigCPtr, this);
    }

    public int getChildGroupCount() {
        return ATKCoreJNI.LayoutGroup_getChildGroupCount(this.swigCPtr, this);
    }

    public LayoutGroup getChildGroupAt(int i) {
        return new LayoutGroup(ATKCoreJNI.LayoutGroup_getChildGroupAt(this.swigCPtr, this, i), true);
    }

    public LayoutGroup getParentGroup() {
        return new LayoutGroup(ATKCoreJNI.LayoutGroup_getParentGroup(this.swigCPtr, this), true);
    }

    public int getIndexInParentGroup() {
        return ATKCoreJNI.LayoutGroup_getIndexInParentGroup(this.swigCPtr, this);
    }

    public void removeChildGroupAt(int i) {
        ATKCoreJNI.LayoutGroup_removeChildGroupAt(this.swigCPtr, this, i);
    }

    public void removeChildGroup(LayoutGroup layoutGroup) {
        ATKCoreJNI.LayoutGroup_removeChildGroup(this.swigCPtr, this, getCPtr(layoutGroup), layoutGroup);
    }

    public LayoutGroup appendChildGroup() {
        return new LayoutGroup(ATKCoreJNI.LayoutGroup_appendChildGroup(this.swigCPtr, this), true);
    }

    public void setChildGroupIndex(LayoutGroup layoutGroup, int i) {
        ATKCoreJNI.LayoutGroup_setChildGroupIndex(this.swigCPtr, this, getCPtr(layoutGroup), layoutGroup, i);
    }

    public Rectangle getBox() {
        return new Rectangle(ATKCoreJNI.LayoutGroup_getBox(this.swigCPtr, this), true);
    }

    public void setBox(Rectangle rectangle) {
        ATKCoreJNI.LayoutGroup_setBox(this.swigCPtr, this, Rectangle.getCPtr(rectangle));
    }

    public String getId() {
        return new String(ATKCoreJNI.LayoutGroup_getId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setCustomAttribute(String str, String str2) {
        ATKCoreJNI.LayoutGroup_setCustomAttribute(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public String getCustomAttribute(String str) {
        return new String(ATKCoreJNI.LayoutGroup_getCustomAttribute(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public void removeCustomAttribute(String str) {
        ATKCoreJNI.LayoutGroup_removeCustomAttribute(this.swigCPtr, this, str.getBytes());
    }

    public int getCustomAttributeCount() {
        return ATKCoreJNI.LayoutGroup_getCustomAttributeCount(this.swigCPtr, this);
    }

    public void setCustomAttributeAsFloat(String str, float f) {
        ATKCoreJNI.LayoutGroup_setCustomAttributeAsFloat(this.swigCPtr, this, str.getBytes(), f);
    }

    public float getCustomAttributeAsFloat(String str, float f) {
        return ATKCoreJNI.LayoutGroup_getCustomAttributeAsFloat(this.swigCPtr, this, str.getBytes(), f);
    }

    public void setCustomAttributeAsInt64(String str, long j) {
        ATKCoreJNI.LayoutGroup_setCustomAttributeAsInt64(this.swigCPtr, this, str.getBytes(), j);
    }

    public long getCustomAttributeAsInt64(String str, long j) {
        return ATKCoreJNI.LayoutGroup_getCustomAttributeAsInt64(this.swigCPtr, this, str.getBytes(), j);
    }

    public void addToGroup(Selection selection) {
        ATKCoreJNI.LayoutGroup_addToGroup(this.swigCPtr, this, Selection.getCPtr(selection), selection);
    }

    public void removeFromGroup(Selection selection) {
        ATKCoreJNI.LayoutGroup_removeFromGroup(this.swigCPtr, this, Selection.getCPtr(selection), selection);
    }
}
