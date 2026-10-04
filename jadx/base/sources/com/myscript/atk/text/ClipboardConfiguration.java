package com.myscript.atk.text;

/* JADX INFO: loaded from: classes4.dex */
public class ClipboardConfiguration {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public ClipboardConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(ClipboardConfiguration clipboardConfiguration) {
        if (clipboardConfiguration == null) {
            return 0L;
        }
        return clipboardConfiguration.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKTextJNI.delete_ClipboardConfiguration(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setExportImage(boolean z) {
        ATKTextJNI.ClipboardConfiguration_exportImage_set(this.swigCPtr, this, z);
    }

    public boolean getExportImage() {
        return ATKTextJNI.ClipboardConfiguration_exportImage_get(this.swigCPtr, this);
    }

    public void setExportHeader(boolean z) {
        ATKTextJNI.ClipboardConfiguration_exportHeader_set(this.swigCPtr, this, z);
    }

    public boolean getExportHeader() {
        return ATKTextJNI.ClipboardConfiguration_exportHeader_get(this.swigCPtr, this);
    }

    public void setSaveInsteadOfSaveToTemp(boolean z) {
        ATKTextJNI.ClipboardConfiguration_saveInsteadOfSaveToTemp_set(this.swigCPtr, this, z);
    }

    public boolean getSaveInsteadOfSaveToTemp() {
        return ATKTextJNI.ClipboardConfiguration_saveInsteadOfSaveToTemp_get(this.swigCPtr, this);
    }

    public ClipboardConfiguration() {
        this(ATKTextJNI.new_ClipboardConfiguration(), true);
    }
}
