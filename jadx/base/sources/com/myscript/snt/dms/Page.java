package com.myscript.snt.dms;

import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.SWIGVectorColors;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class Page implements AutoCloseable {
    private transient boolean swigCMemOwn;
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
                NeboDMSJNI.delete_Page(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public Page(PageKey pageKey, PageInfo pageInfo) {
        this(NeboDMSJNI.new_Page(PageKey.getCPtr(pageKey), pageKey, PageInfo.getCPtr(pageInfo), pageInfo), true);
    }

    public PageKey getKey() {
        return new PageKey(NeboDMSJNI.Page_getKey(this.swigCPtr, this), true);
    }

    public String contentType() {
        return new String(NeboDMSJNI.Page_contentType__SWIG_0(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public PageType getType() {
        return PageType.swigToEnum(NeboDMSJNI.Page_getType(this.swigCPtr, this));
    }

    public String getTitle() {
        return new String(NeboDMSJNI.Page_getTitle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String userTitle() {
        return new String(NeboDMSJNI.Page_userTitle(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String language() {
        return new String(NeboDMSJNI.Page_language(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String getBackgroundPattern() {
        return new String(NeboDMSJNI.Page_getBackgroundPattern(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean hasContent() {
        return NeboDMSJNI.Page_hasContent(this.swigCPtr, this);
    }

    public boolean isCorrupted() {
        return NeboDMSJNI.Page_isCorrupted(this.swigCPtr, this);
    }

    public float width() {
        return NeboDMSJNI.Page_width(this.swigCPtr, this);
    }

    public float height() {
        return NeboDMSJNI.Page_height(this.swigCPtr, this);
    }

    public boolean isContainer() {
        return NeboDMSJNI.Page_isContainer(this.swigCPtr, this);
    }

    public long creationDate() {
        return NeboDMSJNI.Page_creationDate(this.swigCPtr, this);
    }

    public long getLastModificationDate() {
        return NeboDMSJNI.Page_getLastModificationDate(this.swigCPtr, this);
    }

    public long metadataModificationDate() {
        return NeboDMSJNI.Page_metadataModificationDate(this.swigCPtr, this);
    }

    public long thumbnailGenerationDate() {
        return NeboDMSJNI.Page_thumbnailGenerationDate(this.swigCPtr, this);
    }

    public int childPages() {
        return NeboDMSJNI.Page_childPages(this.swigCPtr, this);
    }

    public boolean isMigrationNeeded() {
        return NeboDMSJNI.Page_isMigrationNeeded(this.swigCPtr, this);
    }

    public boolean isSupported() {
        return NeboDMSJNI.Page_isSupported(this.swigCPtr, this);
    }

    public SyncState syncState() {
        return SyncState.swigToEnum(NeboDMSJNI.Page_syncState(this.swigCPtr, this));
    }

    public boolean isCloudOnly() {
        return NeboDMSJNI.Page_isCloudOnly(this.swigCPtr, this);
    }

    public boolean isTrashed() {
        return NeboDMSJNI.Page_isTrashed(this.swigCPtr, this);
    }

    public long rowId() {
        return NeboDMSJNI.Page_rowId(this.swigCPtr, this);
    }

    public static PageType fromContentType(String str) {
        return PageType.swigToEnum(NeboDMSJNI.Page_fromContentType(str.getBytes()));
    }

    public static String contentType(PageType pageType) {
        return new String(NeboDMSJNI.Page_contentType__SWIG_1(pageType.swigValue()), StandardCharsets.UTF_8);
    }

    public int hashCode() {
        return NeboDMSJNI.Page_hashCode(this.swigCPtr, this);
    }

    public boolean nativeEquals(Page page) {
        return NeboDMSJNI.Page_nativeEquals(this.swigCPtr, this, getCPtr(page), page);
    }

    public String toString() {
        return new String(NeboDMSJNI.Page_toString(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public int getBackgroundColor() {
        return NeboDMSJNI.Page_getBackgroundColor(this.swigCPtr, this);
    }

    public List<Integer> getCoverColors() {
        return new SWIGVectorColors(NeboDMSJNI.Page_getCoverColors(this.swigCPtr, this), true);
    }

    public static Page derivedRef(Page page) {
        long jPage_derivedRef = NeboDMSJNI.Page_derivedRef(getCPtr(page), page);
        if (jPage_derivedRef == 0) {
            return null;
        }
        return new Page(jPage_derivedRef, true);
    }
}
