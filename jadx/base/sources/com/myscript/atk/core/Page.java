package com.myscript.atk.core;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Page {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Page(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Page page) {
        if (page == null) {
            return 0L;
        }
        return page.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Page(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public Page() {
        this(ATKCoreJNI.new_Page__SWIG_0(), true);
    }

    public Page(Page page) {
        this(ATKCoreJNI.new_Page__SWIG_1(getCPtr(page), page), true);
    }

    public Document document() {
        long jPage_document = ATKCoreJNI.Page_document(this.swigCPtr, this);
        if (jPage_document == 0) {
            return null;
        }
        return new Document(jPage_document, true);
    }

    public String getStyleSheet() {
        return new String(ATKCoreJNI.Page_getStyleSheet(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setStyleSheetFromFile(String str) {
        ATKCoreJNI.Page_setStyleSheetFromFile(this.swigCPtr, this, str.getBytes());
    }

    public void setStyleSheetFromString(String str) {
        ATKCoreJNI.Page_setStyleSheetFromString(this.swigCPtr, this, str.getBytes());
    }

    public String theme() {
        return new String(ATKCoreJNI.Page_theme(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTheme(String str) {
        ATKCoreJNI.Page_setTheme(this.swigCPtr, this, str.getBytes());
    }

    public Json getMetadata() {
        return new Json(ATKCoreJNI.Page_getMetadata(this.swigCPtr, this), true);
    }

    public void setMetadata(Json json) {
        ATKCoreJNI.Page_setMetadata(this.swigCPtr, this, Json.getCPtr(json), json);
    }

    public Json metadataOverride() {
        return new Json(ATKCoreJNI.Page_metadataOverride(this.swigCPtr, this), true);
    }

    public void setMetadataOverride(Json json) {
        ATKCoreJNI.Page_setMetadataOverride(this.swigCPtr, this, Json.getCPtr(json), json);
    }

    public Selection paste(Selection selection) {
        return new Selection(ATKCoreJNI.Page_paste(this.swigCPtr, this, Selection.getCPtr(selection), selection), true);
    }

    public boolean preventUndo() {
        return ATKCoreJNI.Page_preventUndo(this.swigCPtr, this);
    }

    public boolean canUndo() {
        return ATKCoreJNI.Page_canUndo(this.swigCPtr, this);
    }

    public boolean undo() {
        return ATKCoreJNI.Page_undo(this.swigCPtr, this);
    }

    public boolean canRedo() {
        return ATKCoreJNI.Page_canRedo(this.swigCPtr, this);
    }

    public boolean redo() {
        return ATKCoreJNI.Page_redo(this.swigCPtr, this);
    }

    public Layout getLayout() {
        return new Layout(ATKCoreJNI.Page_getLayout(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_myscript__ink__Ink ink() {
        return new SWIGTYPE_p_myscript__ink__Ink(ATKCoreJNI.Page_ink(this.swigCPtr, this), true);
    }

    public Content getContent() {
        return new Content(ATKCoreJNI.Page_getContent__SWIG_0(this.swigCPtr, this), true);
    }

    public Content getContent(SWIGTYPE_p_myscript__configurationmanager__ConfigurationManager sWIGTYPE_p_myscript__configurationmanager__ConfigurationManager) {
        return new Content(ATKCoreJNI.Page_getContent__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_myscript__configurationmanager__ConfigurationManager.getCPtr(sWIGTYPE_p_myscript__configurationmanager__ConfigurationManager)), true);
    }

    public boolean valid() {
        return ATKCoreJNI.Page_valid(this.swigCPtr, this);
    }

    public String getId() {
        return new String(ATKCoreJNI.Page_getId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public Page createTemporaryClone() {
        return new Page(ATKCoreJNI.Page_createTemporaryClone(this.swigCPtr, this), true);
    }

    public void setObjectManager(SWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t sWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t) {
        ATKCoreJNI.Page_setObjectManager(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t));
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t getObjectManager() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__IObjectManager_t(ATKCoreJNI.Page_getObjectManager(this.swigCPtr, this), true);
    }

    public void setTextStructureProvider(SWIGTYPE_p_std__shared_ptrT_atk__core__TextStructureProvider_t sWIGTYPE_p_std__shared_ptrT_atk__core__TextStructureProvider_t) {
        ATKCoreJNI.Page_setTextStructureProvider(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_atk__core__TextStructureProvider_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_atk__core__TextStructureProvider_t));
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__TextStructureProvider_t getTextStructureProvider() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__TextStructureProvider_t(ATKCoreJNI.Page_getTextStructureProvider(this.swigCPtr, this), true);
    }

    public static Page loadFromSerializedPath(String str) {
        return new Page(ATKCoreJNI.Page_loadFromSerializedPath(str.getBytes()), true);
    }

    public String serializePath() {
        return new String(ATKCoreJNI.Page_serializePath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void applyConfigurationChangeset(Json json) {
        ATKCoreJNI.Page_applyConfigurationChangeset(this.swigCPtr, this, Json.getCPtr(json), json);
    }

    public JsonType getConfigurationType(String str, String str2) {
        return JsonType.swigToEnum(ATKCoreJNI.Page_getConfigurationType(this.swigCPtr, this, str.getBytes(), str2.getBytes()));
    }

    public Json configuration() {
        return new Json(ATKCoreJNI.Page_configuration(this.swigCPtr, this), true);
    }

    public void addConfigurationListener(C6022xed8d9446 c6022xed8d9446) {
        ATKCoreJNI.Page_addConfigurationListener(this.swigCPtr, this, C6022xed8d9446.getCPtr(c6022xed8d9446));
    }

    public void removeConfigurationListener(C6022xed8d9446 c6022xed8d9446) {
        ATKCoreJNI.Page_removeConfigurationListener(this.swigCPtr, this, C6022xed8d9446.getCPtr(c6022xed8d9446));
    }

    public boolean isInitialized() {
        return ATKCoreJNI.Page_isInitialized(this.swigCPtr, this);
    }

    public int hashCode() {
        return ATKCoreJNI.Page_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(Page page) {
        return ATKCoreJNI.Page_nativeEquals(this.swigCPtr, this, getCPtr(page), page);
    }

    public String toString() {
        return new String(ATKCoreJNI.Page_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }
}
