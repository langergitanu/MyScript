package com.myscript.atk.core;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Content {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public Content(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(Content content) {
        if (content == null) {
            return 0L;
        }
        return content.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKCoreJNI.delete_Content(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void addConfigurationSearchDir(File file) {
        addConfigurationSearchDir(file.getAbsolutePath());
    }

    public Content() {
        this(ATKCoreJNI.new_Content(), true);
    }

    public void addConfigurationSearchDir(String str) {
        ATKCoreJNI.Content_addConfigurationSearchDir(this.swigCPtr, this, str.getBytes());
    }

    public List<String> getSearchDirs() {
        return new SWIGVectorString(ATKCoreJNI.Content_getSearchDirs(this.swigCPtr, this), true);
    }

    public void clearSearchPath() {
        ATKCoreJNI.Content_clearSearchPath(this.swigCPtr, this);
    }

    public void process(String str) {
        ATKCoreJNI.Content_process(this.swigCPtr, this, str.getBytes());
    }

    public void skipOneProcess(String str) {
        ATKCoreJNI.Content_skipOneProcess(this.swigCPtr, this, str.getBytes());
    }

    public void cleanSkipOneProcess(String str) {
        ATKCoreJNI.Content_cleanSkipOneProcess(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasFieldToSkip() {
        return ATKCoreJNI.Content_hasFieldToSkip(this.swigCPtr, this);
    }

    public void cancelProcessing() {
        ATKCoreJNI.Content_cancelProcessing(this.swigCPtr, this);
    }

    public boolean isCanceling() {
        return ATKCoreJNI.Content_isCanceling(this.swigCPtr, this);
    }

    public boolean autoProcess() {
        return ATKCoreJNI.Content_autoProcess(this.swigCPtr, this);
    }

    public void enableAutoProcess() {
        ATKCoreJNI.Content_enableAutoProcess(this.swigCPtr, this);
    }

    public void disableAutoProcess(boolean z) {
        ATKCoreJNI.Content_disableAutoProcess__SWIG_0(this.swigCPtr, this, z);
    }

    public void disableAutoProcess() {
        ATKCoreJNI.Content_disableAutoProcess__SWIG_1(this.swigCPtr, this);
    }

    public boolean isProcessPendingOrRequired(ContentFieldType contentFieldType) {
        return ATKCoreJNI.Content_isProcessPendingOrRequired__SWIG_0(this.swigCPtr, this, contentFieldType.swigValue());
    }

    public boolean isProcessPendingOrRequired() {
        return ATKCoreJNI.Content_isProcessPendingOrRequired__SWIG_1(this.swigCPtr, this);
    }

    public boolean isProcessPending(SWIGTYPE_p_myscript__document__ContentField sWIGTYPE_p_myscript__document__ContentField) {
        return ATKCoreJNI.Content_isProcessPending__SWIG_0(this.swigCPtr, this, SWIGTYPE_p_myscript__document__ContentField.getCPtr(sWIGTYPE_p_myscript__document__ContentField));
    }

    public boolean isProcessPending(String str) {
        return ATKCoreJNI.Content_isProcessPending__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    public boolean isProcessPendingOnPage() {
        return ATKCoreJNI.Content_isProcessPendingOnPage(this.swigCPtr, this);
    }

    public void setMaxRecognitionThreadCount(ContentFieldType contentFieldType, long j) {
        ATKCoreJNI.Content_setMaxRecognitionThreadCount(this.swigCPtr, this, contentFieldType.swigValue(), j);
    }

    public void enableAutoBeautification(SWIGTYPE_p_myscript__document__ContentField sWIGTYPE_p_myscript__document__ContentField, boolean z) {
        ATKCoreJNI.Content_enableAutoBeautification(this.swigCPtr, this, SWIGTYPE_p_myscript__document__ContentField.getCPtr(sWIGTYPE_p_myscript__document__ContentField), z);
    }

    public TypesetData getTypesetData(String str, Selection selection) {
        return new TypesetData(ATKCoreJNI.Content_getTypesetData__SWIG_0(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection), true);
    }

    public TypesetData getTypesetData(SWIGTYPE_p_myscript__document__ContentField sWIGTYPE_p_myscript__document__ContentField, Selection selection) {
        return new TypesetData(ATKCoreJNI.Content_getTypesetData__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_myscript__document__ContentField.getCPtr(sWIGTYPE_p_myscript__document__ContentField), Selection.getCPtr(selection), selection), true);
    }

    public boolean applyTypesetData(TypesetData typesetData, Selection selection) {
        return ATKCoreJNI.Content_applyTypesetData(this.swigCPtr, this, TypesetData.getCPtr(typesetData), typesetData, Selection.getCPtr(selection), selection);
    }

    public Selection addGuide(String str, String str2, String str3, GuideData guideData, String str4, boolean z) {
        return new Selection(ATKCoreJNI.Content_addGuide__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), GuideData.getCPtr(guideData), guideData, str4.getBytes(), z), true);
    }

    public Selection addGuide(String str, String str2, String str3, GuideData guideData, String str4) {
        return new Selection(ATKCoreJNI.Content_addGuide__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), GuideData.getCPtr(guideData), guideData, str4.getBytes()), true);
    }

    public Selection addGuide(String str, String str2, String str3, GuideData guideData) {
        return new Selection(ATKCoreJNI.Content_addGuide__SWIG_2(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), GuideData.getCPtr(guideData), guideData), true);
    }

    public Selection addGuide(String str, String str2, String str3, GuideData guideData, GuidePositioning guidePositioning, String str4, boolean z) {
        return new Selection(ATKCoreJNI.Content_addGuide__SWIG_3(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), GuideData.getCPtr(guideData), guideData, GuidePositioning.getCPtr(guidePositioning), guidePositioning, str4.getBytes(), z), true);
    }

    public Selection addGuide(String str, String str2, String str3, GuideData guideData, GuidePositioning guidePositioning, String str4) {
        return new Selection(ATKCoreJNI.Content_addGuide__SWIG_4(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), GuideData.getCPtr(guideData), guideData, GuidePositioning.getCPtr(guidePositioning), guidePositioning, str4.getBytes()), true);
    }

    public Selection addGuide(String str, String str2, String str3, GuideData guideData, GuidePositioning guidePositioning) {
        return new Selection(ATKCoreJNI.Content_addGuide__SWIG_5(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), GuideData.getCPtr(guideData), guideData, GuidePositioning.getCPtr(guidePositioning), guidePositioning), true);
    }

    public void removeGuide(String str) {
        ATKCoreJNI.Content_removeGuide(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasGuide(String str) {
        return ATKCoreJNI.Content_hasGuide(this.swigCPtr, this, str.getBytes());
    }

    public GuideData getGuide(String str) {
        return new GuideData(ATKCoreJNI.Content_getGuide(this.swigCPtr, this, str.getBytes()), true);
    }

    public boolean addGuide(String str, String str2) {
        return ATKCoreJNI.Content_addGuide__SWIG_6(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public GuideIterator getGuides(String str) {
        return new GuideIterator(ATKCoreJNI.Content_getGuides(this.swigCPtr, this, str.getBytes()), true);
    }

    public void setLineSpacing(String str, float f) {
        ATKCoreJNI.Content_setLineSpacing(this.swigCPtr, this, str.getBytes(), f);
    }

    public boolean hasLineSpacing(String str) {
        return ATKCoreJNI.Content_hasLineSpacing(this.swigCPtr, this, str.getBytes());
    }

    public float getLineSpacing(String str) {
        return ATKCoreJNI.Content_getLineSpacing(this.swigCPtr, this, str.getBytes());
    }

    public void removeLineSpacing(String str) {
        ATKCoreJNI.Content_removeLineSpacing(this.swigCPtr, this, str.getBytes());
    }

    public void transformGuide(String str, Transform transform) {
        ATKCoreJNI.Content_transformGuide(this.swigCPtr, this, str.getBytes(), Transform.getCPtr(transform), transform);
    }

    public void setMathRecognizerTimeOut(float f) {
        ATKCoreJNI.Content_setMathRecognizerTimeOut(this.swigCPtr, this, f);
    }

    public void addContentField(String str, ContentFieldType contentFieldType) {
        ATKCoreJNI.Content_addContentField(this.swigCPtr, this, str.getBytes(), contentFieldType.swigValue());
    }

    public void configure(String str, String str2, String str3, String str4) {
        ATKCoreJNI.Content_configure__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes());
    }

    public void configure(String str, String str2, String str3) {
        ATKCoreJNI.Content_configure__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), str3.getBytes());
    }

    public void configure(String str, String str2) {
        ATKCoreJNI.Content_configure__SWIG_2(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public void configure(String str) {
        ATKCoreJNI.Content_configure__SWIG_3(this.swigCPtr, this, str.getBytes());
    }

    public void setCustomResources(ContentFieldType contentFieldType, List<CustomResource> list) {
        SWIGVectorCustomResource sWIGVectorCustomResource = new SWIGVectorCustomResource(list);
        ATKCoreJNI.Content_setCustomResources(this.swigCPtr, this, contentFieldType.swigValue(), SWIGVectorCustomResource.getCPtr(sWIGVectorCustomResource), sWIGVectorCustomResource);
    }

    public boolean valid() {
        return ATKCoreJNI.Content_valid(this.swigCPtr, this);
    }

    public boolean addContentFieldFromOtherContentField(String str, String str2) {
        return ATKCoreJNI.Content_addContentFieldFromOtherContentField(this.swigCPtr, this, str.getBytes(), str2.getBytes());
    }

    public boolean removeContentField(String str) {
        return ATKCoreJNI.Content_removeContentField(this.swigCPtr, this, str.getBytes());
    }

    public boolean hasContentField(String str) {
        return ATKCoreJNI.Content_hasContentField(this.swigCPtr, this, str.getBytes());
    }

    public boolean addItems(String str, Selection selection) {
        return ATKCoreJNI.Content_addItems(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection);
    }

    public boolean removeItems(String str, Selection selection) {
        return ATKCoreJNI.Content_removeItems(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection);
    }

    public boolean clearField(String str) {
        return ATKCoreJNI.Content_clearField(this.swigCPtr, this, str.getBytes());
    }

    public int getActiveAreaCount() {
        return ATKCoreJNI.Content_getActiveAreaCount(this.swigCPtr, this);
    }

    public boolean activeAreaExist(String str) {
        return ATKCoreJNI.Content_activeAreaExist(this.swigCPtr, this, str.getBytes());
    }

    public ActiveArea addActiveArea(Extent extent, String str) {
        return new ActiveArea(ATKCoreJNI.Content_addActiveArea(this.swigCPtr, this, Extent.getCPtr(extent), str.getBytes()), true);
    }

    public ActiveArea getActiveArea(String str) {
        return new ActiveArea(ATKCoreJNI.Content_getActiveArea(this.swigCPtr, this, str.getBytes()), true);
    }

    public boolean removeActiveArea(String str) {
        return ATKCoreJNI.Content_removeActiveArea(this.swigCPtr, this, str.getBytes());
    }

    public ActiveArea getActiveAreaAt(int i) {
        return new ActiveArea(ATKCoreJNI.Content_getActiveAreaAt(this.swigCPtr, this, i), true);
    }

    public int getFieldCount(ContentFieldType contentFieldType) {
        return ATKCoreJNI.Content_getFieldCount(this.swigCPtr, this, contentFieldType.swigValue());
    }

    public String getFieldName(ContentFieldType contentFieldType, int i) {
        return new String(ATKCoreJNI.Content_getFieldName(this.swigCPtr, this, contentFieldType.swigValue(), i), StandardCharsets.UTF_8);
    }

    public String field(ContentFieldType contentFieldType, int i) {
        return ATKCoreJNI.Content_field(this.swigCPtr, this, contentFieldType.swigValue(), i);
    }

    public long tagId(String str) {
        return ATKCoreJNI.Content_tagId(this.swigCPtr, this, str.getBytes());
    }

    public Selection getFieldInput(String str) {
        return new Selection(ATKCoreJNI.Content_getFieldInput__SWIG_0(this.swigCPtr, this, str.getBytes()), true);
    }

    public Selection getFieldInput(SWIGTYPE_p_myscript__document__ContentField sWIGTYPE_p_myscript__document__ContentField) {
        return new Selection(ATKCoreJNI.Content_getFieldInput__SWIG_1(this.swigCPtr, this, SWIGTYPE_p_myscript__document__ContentField.getCPtr(sWIGTYPE_p_myscript__document__ContentField)), true);
    }

    public Selection fieldsInput(String str, ContentFieldType contentFieldType) {
        return new Selection(ATKCoreJNI.Content_fieldsInput(this.swigCPtr, this, str.getBytes(), contentFieldType.swigValue()), true);
    }

    public void sync() {
        ATKCoreJNI.Content_sync(this.swigCPtr, this);
    }

    public Page page() {
        return new Page(ATKCoreJNI.Content_page(this.swigCPtr, this), true);
    }

    public SWIGTYPE_p_std__shared_ptrT_atk__core__Scheduler_t patchApplicationScheduler() {
        return new SWIGTYPE_p_std__shared_ptrT_atk__core__Scheduler_t(ATKCoreJNI.Content_patchApplicationScheduler(this.swigCPtr, this), true);
    }
}
