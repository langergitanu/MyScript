package com.myscript.snt.dms;

import com.myscript.atk.core.BackgroundPattern;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.SWIGVectorString;
import com.myscript.snt.core.ChildPageThumbnailGenerator;
import com.myscript.snt.core.IThumbnailerImageRequester;
import com.myscript.snt.core.PageController;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class PDFManager implements AutoCloseable, IPaginatedContainer {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PDFManager(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PDFManager pDFManager) {
        if (pDFManager == null) {
            return 0L;
        }
        return pDFManager.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_PDFManager(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public static PDFManager create(PageController pageController) {
        long jPDFManager_create = NeboDMSJNI.PDFManager_create(PageController.getCPtr(pageController), pageController);
        if (jPDFManager_create == 0) {
            return null;
        }
        return new PDFManager(jPDFManager_create, true);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public boolean isValidPageId(String str) {
        return NeboDMSJNI.PDFManager_isValidPageId(this.swigCPtr, this, str.getBytes());
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public List<PageProperties> pages() {
        return new SWIGVectorPageProperties(NeboDMSJNI.PDFManager_pages(this.swigCPtr, this), true);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public long pageCount() {
        return NeboDMSJNI.PDFManager_pageCount(this.swigCPtr, this);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public PageProperties pageProperties(String str) {
        return new PageProperties(NeboDMSJNI.PDFManager_pageProperties(this.swigCPtr, this, str.getBytes()), true);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public String pageAt(long j) {
        return new String(NeboDMSJNI.PDFManager_pageAt(this.swigCPtr, this, j), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public String selectedPage() {
        return new String(NeboDMSJNI.PDFManager_selectedPage(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public String createPage(String str, boolean z) {
        return new String(NeboDMSJNI.PDFManager_createPage__SWIG_0(this.swigCPtr, this, str.getBytes(), z), StandardCharsets.UTF_8);
    }

    public String createPage(String str) {
        return new String(NeboDMSJNI.PDFManager_createPage__SWIG_1(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public String duplicatePage(String str, boolean z) {
        return new String(NeboDMSJNI.PDFManager_duplicatePage__SWIG_0(this.swigCPtr, this, str.getBytes(), z), StandardCharsets.UTF_8);
    }

    public String duplicatePage(String str) {
        return new String(NeboDMSJNI.PDFManager_duplicatePage__SWIG_1(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public void movePage(String str, String str2, boolean z) {
        NeboDMSJNI.PDFManager_movePage__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), z);
    }

    public void movePage(String str, String str2) {
        NeboDMSJNI.PDFManager_movePage__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public void removePage(String str) {
        NeboDMSJNI.PDFManager_removePage(this.swigCPtr, this, str.getBytes());
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public void removePages(List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        NeboDMSJNI.PDFManager_removePages(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public void selectPage(String str, boolean z) {
        NeboDMSJNI.PDFManager_selectPage__SWIG_0(this.swigCPtr, this, str.getBytes(), z);
    }

    public void selectPage(String str) {
        NeboDMSJNI.PDFManager_selectPage__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public List<PageAction> pageActions(String str) {
        return new SWIGVectorPageAction(NeboDMSJNI.PDFManager_pageActions(this.swigCPtr, this, str.getBytes()), true);
    }

    public static PDFManager newRef(PDFManager pDFManager) {
        long jPDFManager_newRef = NeboDMSJNI.PDFManager_newRef(getCPtr(pDFManager), pDFManager);
        if (jPDFManager_newRef == 0) {
            return null;
        }
        return new PDFManager(jPDFManager_newRef, true);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public void setPageBackgroundColor(String str, int i) {
        NeboDMSJNI.PDFManager_setPageBackgroundColor(this.swigCPtr, this, str.getBytes(), i);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public void setPageBackgroundPattern(String str, BackgroundPattern backgroundPattern) {
        NeboDMSJNI.PDFManager_setPageBackgroundPattern(this.swigCPtr, this, str.getBytes(), backgroundPattern.swigValue());
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public void addListener(IPaginatedContainerListener iPaginatedContainerListener) {
        NeboDMSJNI.PDFManager_addListener(this.swigCPtr, this, iPaginatedContainerListener);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public void removeListener(IPaginatedContainerListener iPaginatedContainerListener) {
        NeboDMSJNI.PDFManager_removeListener(this.swigCPtr, this, iPaginatedContainerListener);
    }

    @Override // com.myscript.snt.dms.IPaginatedContainer
    public ChildPageThumbnailGenerator createChildPageThumbnailGenerator(IThumbnailerImageRequester iThumbnailerImageRequester, IColorInversionPolicy iColorInversionPolicy) {
        long jPDFManager_createChildPageThumbnailGenerator = NeboDMSJNI.PDFManager_createChildPageThumbnailGenerator(this.swigCPtr, this, iThumbnailerImageRequester, iColorInversionPolicy);
        if (jPDFManager_createChildPageThumbnailGenerator == 0) {
            return null;
        }
        return new ChildPageThumbnailGenerator(jPDFManager_createChildPageThumbnailGenerator, true);
    }
}
