package com.myscript.snt.core;

import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.Page;
import com.myscript.atk.core.SWIGVectorString;
import com.myscript.atk.core.ViewTransform;
import com.myscript.snt.core.NeboSanitizer;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DocumentController {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DocumentController(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DocumentController documentController) {
        if (documentController == null) {
            return 0L;
        }
        return documentController.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_DocumentController(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setWorkingPath(String str) {
        NeboEngineJNI.DocumentController_setWorkingPath(this.swigCPtr, this, str.getBytes());
    }

    public void setPublicAuthorId(String str) {
        NeboEngineJNI.DocumentController_setPublicAuthorId(this.swigCPtr, this, str.getBytes());
    }

    @Deprecated
    public PageController getTemporaryPageController(Page page, DisplayContext displayContext, RecoContext recoContext, SWIGTYPE_p_std__mapT_std__string_std__string_t sWIGTYPE_p_std__mapT_std__string_std__string_t) {
        long jDocumentController_getTemporaryPageController = NeboEngineJNI.DocumentController_getTemporaryPageController(this.swigCPtr, this, Page.getCPtr(page), page, DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext, SWIGTYPE_p_std__mapT_std__string_std__string_t.getCPtr(sWIGTYPE_p_std__mapT_std__string_std__string_t));
        if (jDocumentController_getTemporaryPageController == 0) {
            return null;
        }
        return new PageController(jDocumentController_getTemporaryPageController, true);
    }

    public PageController standalonePageController(String str, int i, DisplayContext displayContext, RecoContext recoContext, SWIGTYPE_p_std__mapT_std__string_std__string_t sWIGTYPE_p_std__mapT_std__string_std__string_t) {
        long jDocumentController_standalonePageController__SWIG_0 = NeboEngineJNI.DocumentController_standalonePageController__SWIG_0(this.swigCPtr, this, str.getBytes(), i, DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext, SWIGTYPE_p_std__mapT_std__string_std__string_t.getCPtr(sWIGTYPE_p_std__mapT_std__string_std__string_t));
        if (jDocumentController_standalonePageController__SWIG_0 == 0) {
            return null;
        }
        return new PageController(jDocumentController_standalonePageController__SWIG_0, true);
    }

    @Deprecated
    public Page getTemporaryPage(PageKey pageKey, String str) {
        return new Page(NeboEngineJNI.DocumentController_getTemporaryPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes()), true);
    }

    public void saveAs(NotebookKey notebookKey, String str) {
        NeboEngineJNI.DocumentController_saveAs(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes());
    }

    public void save(NotebookKey notebookKey, boolean z, boolean z2) {
        NeboEngineJNI.DocumentController_save__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, z, z2);
    }

    public void save(NotebookKey notebookKey, boolean z) {
        NeboEngineJNI.DocumentController_save__SWIG_1(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, z);
    }

    public void save(NotebookKey notebookKey) {
        NeboEngineJNI.DocumentController_save__SWIG_2(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void saveToTemp(NotebookKey notebookKey) {
        NeboEngineJNI.DocumentController_saveToTemp__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public long save(PageKey pageKey, boolean z) {
        return NeboEngineJNI.DocumentController_save__SWIG_3(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, z);
    }

    public long save(PageKey pageKey) {
        return NeboEngineJNI.DocumentController_save__SWIG_4(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public long saveToTemp(PageKey pageKey) {
        return NeboEngineJNI.DocumentController_saveToTemp__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public String lastOpenedPageId(NotebookKey notebookKey) {
        return new String(NeboEngineJNI.DocumentController_lastOpenedPageId(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey), StandardCharsets.UTF_8);
    }

    public PageKey lastOpenedPageKey(NotebookKey notebookKey) {
        return new PageKey(NeboEngineJNI.DocumentController_lastOpenedPageKey(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey), true);
    }

    public void setLastOpenedPageId(PageKey pageKey) {
        NeboEngineJNI.DocumentController_setLastOpenedPageId(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public void removeLastOpenedPageId(NotebookKey notebookKey) {
        NeboEngineJNI.DocumentController_removeLastOpenedPageId(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void tagCorruptionInfoPage(PageKey pageKey, NeboSanitizer.SanitizerResult sanitizerResult) {
        NeboEngineJNI.DocumentController_tagCorruptionInfoPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, NeboSanitizer.SanitizerResult.getCPtr(sanitizerResult), sanitizerResult);
    }

    public void untagCorruptedPage(PageKey pageKey) {
        NeboEngineJNI.DocumentController_untagCorruptedPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public void setDocumentConfRequester(IDocumentConfRequester iDocumentConfRequester) {
        NeboEngineJNI.DocumentController_setDocumentConfRequester(this.swigCPtr, this, iDocumentConfRequester);
    }

    public List<String> confsDir() {
        return new SWIGVectorString(NeboEngineJNI.DocumentController_confsDir(this.swigCPtr, this), true);
    }

    public void setDocumentCorruptedPageListener(IDocumentCorruptedPageListener iDocumentCorruptedPageListener) {
        NeboEngineJNI.DocumentController_setDocumentCorruptedPageListener(this.swigCPtr, this, iDocumentCorruptedPageListener);
    }

    public void setTypesetListener(ITypesetListener iTypesetListener) {
        NeboEngineJNI.DocumentController_setTypesetListener(this.swigCPtr, this, iTypesetListener);
    }

    public void addDocumentControllerListener(SWIGTYPE_p_std__shared_ptrT_snt__DocumentControllerListener_t sWIGTYPE_p_std__shared_ptrT_snt__DocumentControllerListener_t) {
        NeboEngineJNI.DocumentController_addDocumentControllerListener(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_snt__DocumentControllerListener_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__DocumentControllerListener_t));
    }

    public void removeDocumentControllerListener(SWIGTYPE_p_std__shared_ptrT_snt__DocumentControllerListener_t sWIGTYPE_p_std__shared_ptrT_snt__DocumentControllerListener_t) {
        NeboEngineJNI.DocumentController_removeDocumentControllerListener(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_snt__DocumentControllerListener_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__DocumentControllerListener_t));
    }

    public void removeAllDocumentControllerListeners() {
        NeboEngineJNI.DocumentController_removeAllDocumentControllerListeners(this.swigCPtr, this);
    }

    public void addPageSaveListener(IPageSaveListener iPageSaveListener) {
        NeboEngineJNI.DocumentController_addPageSaveListener(this.swigCPtr, this, iPageSaveListener);
    }

    public void removePageSaveListener(IPageSaveListener iPageSaveListener) {
        NeboEngineJNI.DocumentController_removePageSaveListener(this.swigCPtr, this, iPageSaveListener);
    }

    public Thumbnailer getThumbnailer() {
        long jDocumentController_getThumbnailer = NeboEngineJNI.DocumentController_getThumbnailer(this.swigCPtr, this);
        if (jDocumentController_getThumbnailer == 0) {
            return null;
        }
        return new Thumbnailer(jDocumentController_getThumbnailer, true);
    }

    public void setThumbnailConfiguration(ThumbnailConfiguration thumbnailConfiguration) {
        NeboEngineJNI.DocumentController_setThumbnailConfiguration__SWIG_0(this.swigCPtr, this, ThumbnailConfiguration.getCPtr(thumbnailConfiguration), thumbnailConfiguration);
    }

    public void setThumbnailConfiguration(float f, float f2, String str, IColorInversionPolicy iColorInversionPolicy) {
        NeboEngineJNI.DocumentController_setThumbnailConfiguration__SWIG_1(this.swigCPtr, this, f, f2, str.getBytes(), iColorInversionPolicy);
    }

    public String thumbnailParentPath(PageKey pageKey) {
        return new String(NeboEngineJNI.DocumentController_thumbnailParentPath(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), StandardCharsets.UTF_8);
    }

    public String thumbnailPath(PageKey pageKey, long j, long j2) {
        return new String(NeboEngineJNI.DocumentController_thumbnailPath(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, j, j2), StandardCharsets.UTF_8);
    }

    public void clearThumbnails() {
        NeboEngineJNI.DocumentController_clearThumbnails(this.swigCPtr, this);
    }

    public boolean createThumbnail(PageKey pageKey, ViewTransform viewTransform, boolean z) {
        return NeboEngineJNI.DocumentController_createThumbnail__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, ViewTransform.getCPtr(viewTransform), viewTransform, z);
    }

    public boolean createThumbnail(PageKey pageKey, ViewTransform viewTransform) {
        return NeboEngineJNI.DocumentController_createThumbnail__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, ViewTransform.getCPtr(viewTransform), viewTransform);
    }

    public String resetPageUUID(PageKey pageKey) {
        return new String(NeboEngineJNI.DocumentController_resetPageUUID(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), StandardCharsets.UTF_8);
    }

    public String rootNotesPath() {
        return new String(NeboEngineJNI.DocumentController_rootNotesPath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__NeboExporter_t neboExporter() {
        return new SWIGTYPE_p_std__shared_ptrT_snt__NeboExporter_t(NeboEngineJNI.DocumentController_neboExporter(this.swigCPtr, this), true);
    }

    public void configureMetadataForDuplicatedPage(PageKey pageKey) {
        NeboEngineJNI.DocumentController_configureMetadataForDuplicatedPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public PageController standalonePageController(String str, int i, DisplayContext displayContext, RecoContext recoContext, SWIGOptionContext sWIGOptionContext) {
        long jDocumentController_standalonePageController__SWIG_1 = NeboEngineJNI.DocumentController_standalonePageController__SWIG_1(this.swigCPtr, this, str.getBytes(), i, DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext, SWIGOptionContext.getCPtr(sWIGOptionContext), sWIGOptionContext);
        if (jDocumentController_standalonePageController__SWIG_1 == 0) {
            return null;
        }
        return new PageController(jDocumentController_standalonePageController__SWIG_1, true);
    }

    public PageControllerSanitized getPageController(PageKey pageKey, DisplayContext displayContext, RecoContext recoContext, SWIGOptionContext sWIGOptionContext) {
        return new PageControllerSanitized(NeboEngineJNI.DocumentController_getPageController(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext, SWIGOptionContext.getCPtr(sWIGOptionContext), sWIGOptionContext), true);
    }
}
