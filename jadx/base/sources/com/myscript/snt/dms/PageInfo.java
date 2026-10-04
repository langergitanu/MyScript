package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class PageInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public PageInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(PageInfo pageInfo) {
        if (pageInfo == null) {
            return 0L;
        }
        return pageInfo.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_PageInfo(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setObject(SWIGTYPE_p_snt__dms__Object sWIGTYPE_p_snt__dms__Object) {
        NeboDMSJNI.PageInfo_object_set(this.swigCPtr, this, SWIGTYPE_p_snt__dms__Object.getCPtr(sWIGTYPE_p_snt__dms__Object));
    }

    public SWIGTYPE_p_snt__dms__Object getObject() {
        long jPageInfo_object_get = NeboDMSJNI.PageInfo_object_get(this.swigCPtr, this);
        if (jPageInfo_object_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_snt__dms__Object(jPageInfo_object_get, false);
    }

    public void setLastModificationDate(long j) {
        NeboDMSJNI.PageInfo_lastModificationDate_set(this.swigCPtr, this, j);
    }

    public long getLastModificationDate() {
        return NeboDMSJNI.PageInfo_lastModificationDate_get(this.swigCPtr, this);
    }

    public void setMetadataModificationDate(long j) {
        NeboDMSJNI.PageInfo_metadataModificationDate_set(this.swigCPtr, this, j);
    }

    public long getMetadataModificationDate() {
        return NeboDMSJNI.PageInfo_metadataModificationDate_get(this.swigCPtr, this);
    }

    public void setThumbnailGenerationDate(long j) {
        NeboDMSJNI.PageInfo_thumbnailGenerationDate_set(this.swigCPtr, this, j);
    }

    public long getThumbnailGenerationDate() {
        return NeboDMSJNI.PageInfo_thumbnailGenerationDate_get(this.swigCPtr, this);
    }

    public void setLanguage(String str) {
        NeboDMSJNI.PageInfo_language_set(this.swigCPtr, this, str.getBytes());
    }

    public String getLanguage() {
        return new String(NeboDMSJNI.PageInfo_language_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setPageType(String str) {
        NeboDMSJNI.PageInfo_pageType_set(this.swigCPtr, this, str.getBytes());
    }

    public String getPageType() {
        return new String(NeboDMSJNI.PageInfo_pageType_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setAutomaticTitle(String str) {
        NeboDMSJNI.PageInfo_automaticTitle_set(this.swigCPtr, this, str.getBytes());
    }

    public String getAutomaticTitle() {
        return new String(NeboDMSJNI.PageInfo_automaticTitle_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTitle(String str) {
        NeboDMSJNI.PageInfo_title_set(this.swigCPtr, this, str.getBytes());
    }

    public String getTitle() {
        return new String(NeboDMSJNI.PageInfo_title_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setTitleIsNull(boolean z) {
        NeboDMSJNI.PageInfo_titleIsNull_set(this.swigCPtr, this, z);
    }

    public boolean getTitleIsNull() {
        return NeboDMSJNI.PageInfo_titleIsNull_get(this.swigCPtr, this);
    }

    public void setBackgroundColor(int i) {
        NeboDMSJNI.PageInfo_backgroundColor_set(this.swigCPtr, this, i);
    }

    public int getBackgroundColor() {
        return NeboDMSJNI.PageInfo_backgroundColor_get(this.swigCPtr, this);
    }

    public void setBackgroundColorIsNull(boolean z) {
        NeboDMSJNI.PageInfo_backgroundColorIsNull_set(this.swigCPtr, this, z);
    }

    public boolean getBackgroundColorIsNull() {
        return NeboDMSJNI.PageInfo_backgroundColorIsNull_get(this.swigCPtr, this);
    }

    public void setBackgroundPattern(String str) {
        NeboDMSJNI.PageInfo_backgroundPattern_set(this.swigCPtr, this, str.getBytes());
    }

    public String getBackgroundPattern() {
        return new String(NeboDMSJNI.PageInfo_backgroundPattern_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setBackgroundPatternIsNull(boolean z) {
        NeboDMSJNI.PageInfo_backgroundPatternIsNull_set(this.swigCPtr, this, z);
    }

    public boolean getBackgroundPatternIsNull() {
        return NeboDMSJNI.PageInfo_backgroundPatternIsNull_get(this.swigCPtr, this);
    }

    public void setCoverColors(SWIGTYPE_p_std__vectorT_unsigned_int_t sWIGTYPE_p_std__vectorT_unsigned_int_t) {
        NeboDMSJNI.PageInfo_coverColors_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_unsigned_int_t.getCPtr(sWIGTYPE_p_std__vectorT_unsigned_int_t));
    }

    public SWIGTYPE_p_std__vectorT_unsigned_int_t getCoverColors() {
        long jPageInfo_coverColors_get = NeboDMSJNI.PageInfo_coverColors_get(this.swigCPtr, this);
        if (jPageInfo_coverColors_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_unsigned_int_t(jPageInfo_coverColors_get, false);
    }

    public void setOs(String str) {
        NeboDMSJNI.PageInfo_os_set(this.swigCPtr, this, str.getBytes());
    }

    public String getOs() {
        return new String(NeboDMSJNI.PageInfo_os_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setAppVersion(String str) {
        NeboDMSJNI.PageInfo_appVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getAppVersion() {
        return new String(NeboDMSJNI.PageInfo_appVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setCreationAppVersion(String str) {
        NeboDMSJNI.PageInfo_creationAppVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getCreationAppVersion() {
        return new String(NeboDMSJNI.PageInfo_creationAppVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setHasContent(boolean z) {
        NeboDMSJNI.PageInfo_hasContent_set(this.swigCPtr, this, z);
    }

    public boolean getHasContent() {
        return NeboDMSJNI.PageInfo_hasContent_get(this.swigCPtr, this);
    }

    public void setIsValid(boolean z) {
        NeboDMSJNI.PageInfo_isValid_set(this.swigCPtr, this, z);
    }

    public boolean getIsValid() {
        return NeboDMSJNI.PageInfo_isValid_get(this.swigCPtr, this);
    }

    public void setCorruptedInfo(CorruptionInfo corruptionInfo) {
        NeboDMSJNI.PageInfo_corruptedInfo_set(this.swigCPtr, this, CorruptionInfo.getCPtr(corruptionInfo), corruptionInfo);
    }

    public CorruptionInfo getCorruptedInfo() {
        long jPageInfo_corruptedInfo_get = NeboDMSJNI.PageInfo_corruptedInfo_get(this.swigCPtr, this);
        if (jPageInfo_corruptedInfo_get == 0) {
            return null;
        }
        return new CorruptionInfo(jPageInfo_corruptedInfo_get, false);
    }

    public void setResetedFieldsInfo(SWIGTYPE_p_std__vectorT_snt__dms__CorruptionInfo_t sWIGTYPE_p_std__vectorT_snt__dms__CorruptionInfo_t) {
        NeboDMSJNI.PageInfo_resetedFieldsInfo_set(this.swigCPtr, this, SWIGTYPE_p_std__vectorT_snt__dms__CorruptionInfo_t.getCPtr(sWIGTYPE_p_std__vectorT_snt__dms__CorruptionInfo_t));
    }

    public SWIGTYPE_p_std__vectorT_snt__dms__CorruptionInfo_t getResetedFieldsInfo() {
        long jPageInfo_resetedFieldsInfo_get = NeboDMSJNI.PageInfo_resetedFieldsInfo_get(this.swigCPtr, this);
        if (jPageInfo_resetedFieldsInfo_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__vectorT_snt__dms__CorruptionInfo_t(jPageInfo_resetedFieldsInfo_get, false);
    }

    public void setCorruptedWarningInfo(CorruptionInfo corruptionInfo) {
        NeboDMSJNI.PageInfo_corruptedWarningInfo_set(this.swigCPtr, this, CorruptionInfo.getCPtr(corruptionInfo), corruptionInfo);
    }

    public CorruptionInfo getCorruptedWarningInfo() {
        long jPageInfo_corruptedWarningInfo_get = NeboDMSJNI.PageInfo_corruptedWarningInfo_get(this.swigCPtr, this);
        if (jPageInfo_corruptedWarningInfo_get == 0) {
            return null;
        }
        return new CorruptionInfo(jPageInfo_corruptedWarningInfo_get, false);
    }

    public void setDocVersion(String str) {
        NeboDMSJNI.PageInfo_docVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getDocVersion() {
        return new String(NeboDMSJNI.PageInfo_docVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setDrawingVersion(String str) {
        NeboDMSJNI.PageInfo_drawingVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getDrawingVersion() {
        return new String(NeboDMSJNI.PageInfo_drawingVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setDiagramVersion(String str) {
        NeboDMSJNI.PageInfo_diagramVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getDiagramVersion() {
        return new String(NeboDMSJNI.PageInfo_diagramVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setMathVersion(String str) {
        NeboDMSJNI.PageInfo_mathVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getMathVersion() {
        return new String(NeboDMSJNI.PageInfo_mathVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setIsContainer(boolean z) {
        NeboDMSJNI.PageInfo_isContainer_set(this.swigCPtr, this, z);
    }

    public boolean getIsContainer() {
        return NeboDMSJNI.PageInfo_isContainer_get(this.swigCPtr, this);
    }

    public void setWidth(float f) {
        NeboDMSJNI.PageInfo_width_set(this.swigCPtr, this, f);
    }

    public float getWidth() {
        return NeboDMSJNI.PageInfo_width_get(this.swigCPtr, this);
    }

    public void setHeight(float f) {
        NeboDMSJNI.PageInfo_height_set(this.swigCPtr, this, f);
    }

    public float getHeight() {
        return NeboDMSJNI.PageInfo_height_get(this.swigCPtr, this);
    }

    public void setWelcomeVersion(String str) {
        NeboDMSJNI.PageInfo_welcomeVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getWelcomeVersion() {
        return new String(NeboDMSJNI.PageInfo_welcomeVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setChildPageCount(int i) {
        NeboDMSJNI.PageInfo_childPageCount_set(this.swigCPtr, this, i);
    }

    public int getChildPageCount() {
        return NeboDMSJNI.PageInfo_childPageCount_get(this.swigCPtr, this);
    }

    public void setEmbeddedContentType(String str) {
        NeboDMSJNI.PageInfo_embeddedContentType_set(this.swigCPtr, this, str.getBytes());
    }

    public String getEmbeddedContentType() {
        return new String(NeboDMSJNI.PageInfo_embeddedContentType_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setEmbeddedContentObjectUrl(String str) {
        NeboDMSJNI.PageInfo_embeddedContentObjectUrl_set(this.swigCPtr, this, str.getBytes());
    }

    public String getEmbeddedContentObjectUrl() {
        return new String(NeboDMSJNI.PageInfo_embeddedContentObjectUrl_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setEmbeddedContentFilename(String str) {
        NeboDMSJNI.PageInfo_embeddedContentFilename_set(this.swigCPtr, this, str.getBytes());
    }

    public String getEmbeddedContentFilename() {
        return new String(NeboDMSJNI.PageInfo_embeddedContentFilename_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setEmbeddedContentInitDone(boolean z) {
        NeboDMSJNI.PageInfo_embeddedContentInitDone_set(this.swigCPtr, this, z);
    }

    public boolean getEmbeddedContentInitDone() {
        return NeboDMSJNI.PageInfo_embeddedContentInitDone_get(this.swigCPtr, this);
    }

    public void setTrashState(TrashState trashState) {
        NeboDMSJNI.PageInfo_trashState_set(this.swigCPtr, this, trashState.swigValue());
    }

    public TrashState getTrashState() {
        return TrashState.swigToEnum(NeboDMSJNI.PageInfo_trashState_get(this.swigCPtr, this));
    }

    public PageInfo() {
        this(NeboDMSJNI.new_PageInfo(), true);
    }

    public boolean valid() {
        return NeboDMSJNI.PageInfo_valid(this.swigCPtr, this);
    }
}
