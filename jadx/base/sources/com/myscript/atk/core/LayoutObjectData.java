package com.myscript.atk.core;

/* JADX INFO: loaded from: classes4.dex */
public class LayoutObjectData {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public LayoutObjectData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(LayoutObjectData layoutObjectData) {
        if (layoutObjectData == null) {
            return 0L;
        }
        return layoutObjectData.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_LayoutObjectData(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setUrl(String str) {
        ATKCoreJNI.LayoutObjectData_url_set(this.swigCPtr, this, str);
    }

    public String getUrl() {
        return ATKCoreJNI.LayoutObjectData_url_get(this.swigCPtr, this);
    }

    public void setTransformId(String str) {
        ATKCoreJNI.LayoutObjectData_transformId_set(this.swigCPtr, this, str);
    }

    public String getTransformId() {
        return ATKCoreJNI.LayoutObjectData_transformId_get(this.swigCPtr, this);
    }

    public void setMimeType(String str) {
        ATKCoreJNI.LayoutObjectData_mimeType_set(this.swigCPtr, this, str);
    }

    public String getMimeType() {
        return ATKCoreJNI.LayoutObjectData_mimeType_get(this.swigCPtr, this);
    }

    public Rectangle getRectangle() {
        return new Rectangle(ATKCoreJNI.LayoutObjectData_getRectangle(this.swigCPtr, this), true);
    }

    public void setRectangle(Rectangle rectangle) {
        ATKCoreJNI.LayoutObjectData_setRectangle(this.swigCPtr, this, Rectangle.getCPtr(rectangle), rectangle);
    }

    public LayoutObjectData() {
        this(ATKCoreJNI.new_LayoutObjectData(), true);
    }
}
