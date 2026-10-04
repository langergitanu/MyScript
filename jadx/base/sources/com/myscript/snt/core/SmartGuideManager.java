package com.myscript.snt.core;

import com.myscript.atk.p021ui.ISmartGuideComponentListener;
import com.myscript.atk.p021ui.SmartGuideComponent;

/* JADX INFO: loaded from: classes7.dex */
public class SmartGuideManager implements AutoCloseable {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SmartGuideManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SmartGuideManager smartGuideManager) {
        if (smartGuideManager == null) {
            return 0L;
        }
        return smartGuideManager.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_SmartGuideManager(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public SmartGuideComponent getSmartGuideComponent() {
        long jSmartGuideManager_getSmartGuideComponent = NeboEngineJNI.SmartGuideManager_getSmartGuideComponent(this.swigCPtr, this);
        if (jSmartGuideManager_getSmartGuideComponent == 0) {
            return null;
        }
        return new SmartGuideComponent(jSmartGuideManager_getSmartGuideComponent, true);
    }

    public void setSmartGuideComponent(SmartGuideComponent smartGuideComponent) {
        NeboEngineJNI.SmartGuideManager_setSmartGuideComponent(this.swigCPtr, this, SmartGuideComponent.getCPtr(smartGuideComponent), smartGuideComponent);
    }

    public void setSmartGuideComponentListener(ISmartGuideComponentListener iSmartGuideComponentListener) {
        NeboEngineJNI.SmartGuideManager_setSmartGuideComponentListener(this.swigCPtr, this, iSmartGuideComponentListener);
    }

    public void hide(boolean z) {
        NeboEngineJNI.SmartGuideManager_hide(this.swigCPtr, this, z);
    }

    public void enableFullBlock(boolean z) {
        NeboEngineJNI.SmartGuideManager_enableFullBlock(this.swigCPtr, this, z);
    }

    public void reflowGridChanged(LayoutGrid layoutGrid) {
        NeboEngineJNI.SmartGuideManager_reflowGridChanged(this.swigCPtr, this, LayoutGrid.getCPtr(layoutGrid), layoutGrid);
    }

    public void reflowRollback(boolean z) {
        NeboEngineJNI.SmartGuideManager_reflowRollback(this.swigCPtr, this, z);
    }

    public void clearSmartGuideIfCurrentBoxIsRemoved() {
        NeboEngineJNI.SmartGuideManager_clearSmartGuideIfCurrentBoxIsRemoved(this.swigCPtr, this);
    }

    public void clearSmartGuide() {
        NeboEngineJNI.SmartGuideManager_clearSmartGuide__SWIG_0(this.swigCPtr, this);
    }

    public void clearSmartGuide(String str) {
        NeboEngineJNI.SmartGuideManager_clearSmartGuide__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    public boolean isBoxExistForPrompterId(String str) {
        return NeboEngineJNI.SmartGuideManager_isBoxExistForPrompterId(this.swigCPtr, this, str.getBytes());
    }

    public void setStartWritingOnPrompter(boolean z) {
        NeboEngineJNI.SmartGuideManager_setStartWritingOnPrompter(this.swigCPtr, this, z);
    }

    public boolean startWritingOnPrompter() {
        return NeboEngineJNI.SmartGuideManager_startWritingOnPrompter(this.swigCPtr, this);
    }

    public void setSettingsShowConversionPreview(boolean z) {
        NeboEngineJNI.SmartGuideManager_setSettingsShowConversionPreview(this.swigCPtr, this, z);
    }

    public boolean settingsShowConversionPreview() {
        return NeboEngineJNI.SmartGuideManager_settingsShowConversionPreview(this.swigCPtr, this);
    }

    public boolean isSmartGuideVisible() {
        return NeboEngineJNI.SmartGuideManager_isSmartGuideVisible(this.swigCPtr, this);
    }

    public void setSearchController(SearchController searchController) {
        NeboEngineJNI.SmartGuideManager_setSearchController(this.swigCPtr, this, SearchController.getCPtr(searchController), searchController);
    }

    public static SmartGuideManager newRef(SmartGuideManager smartGuideManager) {
        long jSmartGuideManager_newRef = NeboEngineJNI.SmartGuideManager_newRef(getCPtr(smartGuideManager), smartGuideManager);
        if (jSmartGuideManager_newRef == 0) {
            return null;
        }
        return new SmartGuideManager(jSmartGuideManager_newRef, true);
    }
}
