package com.myscript.atk.p021ui;

import com.myscript.atk.core.DocumentType;
import com.myscript.atk.core.Extent;
import com.myscript.atk.core.SWIGVectorString;
import com.myscript.atk.core.Selection;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SmartGuideComponent implements AutoCloseable {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public SmartGuideComponent(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(SmartGuideComponent smartGuideComponent) {
        if (smartGuideComponent == null) {
            return 0L;
        }
        return smartGuideComponent.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                ATKSharedUIJNI.delete_SmartGuideComponent(j);
            }
            this.swigCPtr = 0L;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        delete();
    }

    public void clearSmartGuide() {
        ATKSharedUIJNI.SmartGuideComponent_clearSmartGuide__SWIG_0(this.swigCPtr, this);
    }

    public void clearSmartGuide(String str) {
        ATKSharedUIJNI.SmartGuideComponent_clearSmartGuide__SWIG_1(this.swigCPtr, this, str.getBytes());
    }

    public void clearPrompter() {
        ATKSharedUIJNI.SmartGuideComponent_clearPrompter(this.swigCPtr, this);
    }

    public void changeVisibility(boolean z, boolean z2) {
        ATKSharedUIJNI.SmartGuideComponent_changeVisibility__SWIG_0(this.swigCPtr, this, z, z2);
    }

    public void changeVisibility(boolean z) {
        ATKSharedUIJNI.SmartGuideComponent_changeVisibility__SWIG_1(this.swigCPtr, this, z);
    }

    public boolean activateText(String str, String str2, Extent extent, boolean z, boolean z2, boolean z3, boolean z4) {
        return ATKSharedUIJNI.SmartGuideComponent_activateText__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, z, z2, z3, z4);
    }

    public boolean activateText(String str, String str2, Extent extent, boolean z, boolean z2, boolean z3) {
        return ATKSharedUIJNI.SmartGuideComponent_activateText__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, z, z2, z3);
    }

    public boolean activateText(String str, String str2, Extent extent, boolean z, boolean z2) {
        return ATKSharedUIJNI.SmartGuideComponent_activateText__SWIG_2(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, z, z2);
    }

    public boolean activateText(String str, String str2, Extent extent, boolean z) {
        return ATKSharedUIJNI.SmartGuideComponent_activateText__SWIG_3(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, z);
    }

    public boolean activateText(String str, String str2, Extent extent) {
        return ATKSharedUIJNI.SmartGuideComponent_activateText__SWIG_4(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent);
    }

    public boolean activateTextAndUpdate(String str, String str2, Extent extent, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return ATKSharedUIJNI.SmartGuideComponent_activateTextAndUpdate__SWIG_0(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, z, z2, z3, z4, z5);
    }

    public boolean activateTextAndUpdate(String str, String str2, Extent extent, boolean z, boolean z2, boolean z3, boolean z4) {
        return ATKSharedUIJNI.SmartGuideComponent_activateTextAndUpdate__SWIG_1(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, z, z2, z3, z4);
    }

    public boolean activateTextAndUpdate(String str, String str2, Extent extent, boolean z, boolean z2, boolean z3) {
        return ATKSharedUIJNI.SmartGuideComponent_activateTextAndUpdate__SWIG_2(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, z, z2, z3);
    }

    public boolean activateTextAndUpdate(String str, String str2, Extent extent, boolean z, boolean z2) {
        return ATKSharedUIJNI.SmartGuideComponent_activateTextAndUpdate__SWIG_3(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, z, z2);
    }

    public boolean activateTextAndUpdate(String str, String str2, Extent extent, boolean z) {
        return ATKSharedUIJNI.SmartGuideComponent_activateTextAndUpdate__SWIG_4(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent, z);
    }

    public boolean activateTextAndUpdate(String str, String str2, Extent extent) {
        return ATKSharedUIJNI.SmartGuideComponent_activateTextAndUpdate__SWIG_5(this.swigCPtr, this, str.getBytes(), str2.getBytes(), Extent.getCPtr(extent), extent);
    }

    public void activateBlockType(SmartGuideBlockType smartGuideBlockType) {
        ATKSharedUIJNI.SmartGuideComponent_activateBlockType__SWIG_0(this.swigCPtr, this, smartGuideBlockType.swigValue());
    }

    public SmartGuideBlockType currentSmartGuideBlockType() {
        return SmartGuideBlockType.swigToEnum(ATKSharedUIJNI.SmartGuideComponent_currentSmartGuideBlockType(this.swigCPtr, this));
    }

    public boolean activateBlockType(String str, SmartGuideBlockType smartGuideBlockType, Extent extent, boolean z, boolean z2, boolean z3, boolean z4) {
        return ATKSharedUIJNI.SmartGuideComponent_activateBlockType__SWIG_1(this.swigCPtr, this, str.getBytes(), smartGuideBlockType.swigValue(), Extent.getCPtr(extent), extent, z, z2, z3, z4);
    }

    public boolean activateBlockType(String str, SmartGuideBlockType smartGuideBlockType, Extent extent, boolean z, boolean z2, boolean z3) {
        return ATKSharedUIJNI.SmartGuideComponent_activateBlockType__SWIG_2(this.swigCPtr, this, str.getBytes(), smartGuideBlockType.swigValue(), Extent.getCPtr(extent), extent, z, z2, z3);
    }

    public boolean activateBlockType(String str, SmartGuideBlockType smartGuideBlockType, Extent extent, boolean z, boolean z2) {
        return ATKSharedUIJNI.SmartGuideComponent_activateBlockType__SWIG_3(this.swigCPtr, this, str.getBytes(), smartGuideBlockType.swigValue(), Extent.getCPtr(extent), extent, z, z2);
    }

    public boolean activateBlockType(String str, SmartGuideBlockType smartGuideBlockType, Extent extent, boolean z) {
        return ATKSharedUIJNI.SmartGuideComponent_activateBlockType__SWIG_4(this.swigCPtr, this, str.getBytes(), smartGuideBlockType.swigValue(), Extent.getCPtr(extent), extent, z);
    }

    public boolean activateBlockType(String str, SmartGuideBlockType smartGuideBlockType, Extent extent) {
        return ATKSharedUIJNI.SmartGuideComponent_activateBlockType__SWIG_5(this.swigCPtr, this, str.getBytes(), smartGuideBlockType.swigValue(), Extent.getCPtr(extent), extent);
    }

    public void disableText() {
        ATKSharedUIJNI.SmartGuideComponent_disableText(this.swigCPtr, this);
    }

    public void activateShape(String str, Selection selection, Selection selection2, Extent extent, boolean z, boolean z2, boolean z3) {
        ATKSharedUIJNI.SmartGuideComponent_activateShape__SWIG_0(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Selection.getCPtr(selection2), selection2, Extent.getCPtr(extent), extent, z, z2, z3);
    }

    public void activateShape(String str, Selection selection, Selection selection2, Extent extent, boolean z, boolean z2) {
        ATKSharedUIJNI.SmartGuideComponent_activateShape__SWIG_1(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Selection.getCPtr(selection2), selection2, Extent.getCPtr(extent), extent, z, z2);
    }

    public void activateShape(String str, Selection selection, Selection selection2, Extent extent, boolean z) {
        ATKSharedUIJNI.SmartGuideComponent_activateShape__SWIG_2(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Selection.getCPtr(selection2), selection2, Extent.getCPtr(extent), extent, z);
    }

    public void activateShapeAndUpdate(String str, Selection selection, Selection selection2, Extent extent, boolean z, boolean z2, boolean z3) {
        ATKSharedUIJNI.SmartGuideComponent_activateShapeAndUpdate__SWIG_0(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Selection.getCPtr(selection2), selection2, Extent.getCPtr(extent), extent, z, z2, z3);
    }

    public void activateShapeAndUpdate(String str, Selection selection, Selection selection2, Extent extent, boolean z, boolean z2) {
        ATKSharedUIJNI.SmartGuideComponent_activateShapeAndUpdate__SWIG_1(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Selection.getCPtr(selection2), selection2, Extent.getCPtr(extent), extent, z, z2);
    }

    public void activateShapeAndUpdate(String str, Selection selection, Selection selection2, Extent extent, boolean z) {
        ATKSharedUIJNI.SmartGuideComponent_activateShapeAndUpdate__SWIG_2(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Selection.getCPtr(selection2), selection2, Extent.getCPtr(extent), extent, z);
    }

    public void disableShape() {
        ATKSharedUIJNI.SmartGuideComponent_disableShape(this.swigCPtr, this);
    }

    public void activateMulti(String str, Selection selection, Extent extent, boolean z, boolean z2) {
        ATKSharedUIJNI.SmartGuideComponent_activateMulti__SWIG_0(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Extent.getCPtr(extent), extent, z, z2);
    }

    public void activateMulti(String str, Selection selection, Extent extent, boolean z) {
        ATKSharedUIJNI.SmartGuideComponent_activateMulti__SWIG_1(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Extent.getCPtr(extent), extent, z);
    }

    public void activateMulti(String str, Selection selection, Extent extent) {
        ATKSharedUIJNI.SmartGuideComponent_activateMulti__SWIG_2(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Extent.getCPtr(extent), extent);
    }

    public void activateMultiAndUpdate(String str, Selection selection, Extent extent, boolean z, boolean z2) {
        ATKSharedUIJNI.SmartGuideComponent_activateMultiAndUpdate__SWIG_0(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Extent.getCPtr(extent), extent, z, z2);
    }

    public void activateMultiAndUpdate(String str, Selection selection, Extent extent, boolean z) {
        ATKSharedUIJNI.SmartGuideComponent_activateMultiAndUpdate__SWIG_1(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Extent.getCPtr(extent), extent, z);
    }

    public void activateMultiAndUpdate(String str, Selection selection, Extent extent) {
        ATKSharedUIJNI.SmartGuideComponent_activateMultiAndUpdate__SWIG_2(this.swigCPtr, this, str.getBytes(), Selection.getCPtr(selection), selection, Extent.getCPtr(extent), extent);
    }

    public void disableMulti() {
        ATKSharedUIJNI.SmartGuideComponent_disableMulti(this.swigCPtr, this);
    }

    public void update(Extent extent, String str, boolean z) {
        ATKSharedUIJNI.SmartGuideComponent_update__SWIG_0(this.swigCPtr, this, Extent.getCPtr(extent), extent, str.getBytes(), z);
    }

    public void update(Extent extent, String str) {
        ATKSharedUIJNI.SmartGuideComponent_update__SWIG_1(this.swigCPtr, this, Extent.getCPtr(extent), extent, str.getBytes());
    }

    public void update(Extent extent) {
        ATKSharedUIJNI.SmartGuideComponent_update__SWIG_2(this.swigCPtr, this, Extent.getCPtr(extent), extent);
    }

    public void update() {
        ATKSharedUIJNI.SmartGuideComponent_update__SWIG_3(this.swigCPtr, this);
    }

    public void updateContentFieldId(String str) {
        ATKSharedUIJNI.SmartGuideComponent_updateContentFieldId(this.swigCPtr, this, str.getBytes());
    }

    public String prompterId() {
        return new String(ATKSharedUIJNI.SmartGuideComponent_prompterId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public String contentFieldId() {
        return new String(ATKSharedUIJNI.SmartGuideComponent_contentFieldId(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setAvailableActions(int i) {
        ATKSharedUIJNI.SmartGuideComponent_setAvailableActions(this.swigCPtr, this, i);
    }

    public int availableActions() {
        return ATKSharedUIJNI.SmartGuideComponent_availableActions(this.swigCPtr, this);
    }

    public Selection shapeSelection() {
        return new Selection(ATKSharedUIJNI.SmartGuideComponent_shapeSelection(this.swigCPtr, this), true);
    }

    public void setSmartGuideListener(ISmartGuideComponentListener iSmartGuideComponentListener) {
        ATKSharedUIJNI.SmartGuideComponent_setSmartGuideListener(this.swigCPtr, this, iSmartGuideComponentListener);
    }

    public PrompterBox currentPrompterBox() {
        long jSmartGuideComponent_currentPrompterBox = ATKSharedUIJNI.SmartGuideComponent_currentPrompterBox(this.swigCPtr, this);
        if (jSmartGuideComponent_currentPrompterBox == 0) {
            return null;
        }
        return new PrompterBox(jSmartGuideComponent_currentPrompterBox, true);
    }

    public PrompterShapeSupport simplifyShapeLabel(String str) {
        return PrompterShapeSupport.swigToEnum(ATKSharedUIJNI.SmartGuideComponent_simplifyShapeLabel(this.swigCPtr, this, str.getBytes()));
    }

    public void setShowConversionPreview(boolean z) {
        ATKSharedUIJNI.SmartGuideComponent_setShowConversionPreview(this.swigCPtr, this, z);
    }

    public boolean isConversionPreviewShown() {
        return ATKSharedUIJNI.SmartGuideComponent_isConversionPreviewShown(this.swigCPtr, this);
    }

    public boolean isSmartGuideVisible() {
        return ATKSharedUIJNI.SmartGuideComponent_isSmartGuideVisible(this.swigCPtr, this);
    }

    public boolean isProcessPending(String str) {
        return ATKSharedUIJNI.SmartGuideComponent_isProcessPending(this.swigCPtr, this, str.getBytes());
    }

    public void changeTextCandidate(PrompterWord prompterWord, int i) {
        ATKSharedUIJNI.SmartGuideComponent_changeTextCandidate(this.swigCPtr, this, PrompterWord.getCPtr(prompterWord), prompterWord, i);
    }

    public void changeShapeCandidate(ShapeCandidate shapeCandidate, int i) {
        ATKSharedUIJNI.SmartGuideComponent_changeShapeCandidate(this.swigCPtr, this, ShapeCandidate.getCPtr(shapeCandidate), shapeCandidate, i);
    }

    public void setAsDrawing() {
        ATKSharedUIJNI.SmartGuideComponent_setAsDrawing(this.swigCPtr, this);
    }

    public void setAsText() {
        ATKSharedUIJNI.SmartGuideComponent_setAsText(this.swigCPtr, this);
    }

    public List<String> candidateLabelsForWord(PrompterWord prompterWord) {
        return new SWIGVectorString(ATKSharedUIJNI.SmartGuideComponent_candidateLabelsForWord(this.swigCPtr, this, PrompterWord.getCPtr(prompterWord), prompterWord), true);
    }

    public List<ShapeCandidate> candidateLabelsForShape() {
        return new SWIGShapeCandidate(ATKSharedUIJNI.SmartGuideComponent_candidateLabelsForShape(this.swigCPtr, this), true);
    }

    public void typesetCurrentBox() {
        ATKSharedUIJNI.SmartGuideComponent_typesetCurrentBox(this.swigCPtr, this);
    }

    public void exportBox(DocumentType documentType, String str, String str2) {
        ATKSharedUIJNI.SmartGuideComponent_exportBox(this.swigCPtr, this, documentType.swigValue(), str.getBytes(), str2.getBytes());
    }

    public void exportCurrentBox(DocumentType documentType, String str) {
        ATKSharedUIJNI.SmartGuideComponent_exportCurrentBox(this.swigCPtr, this, documentType.swigValue(), str.getBytes());
    }

    public void deleteBox(String str) {
        ATKSharedUIJNI.SmartGuideComponent_deleteBox(this.swigCPtr, this, str.getBytes());
    }

    public void cancelProcess() {
        ATKSharedUIJNI.SmartGuideComponent_cancelProcess(this.swigCPtr, this);
    }

    public void changeStyle(int i) {
        ATKSharedUIJNI.SmartGuideComponent_changeStyle(this.swigCPtr, this, i);
    }

    public void textify() {
        ATKSharedUIJNI.SmartGuideComponent_textify(this.swigCPtr, this);
    }

    public void listify(String str) {
        ATKSharedUIJNI.SmartGuideComponent_listify(this.swigCPtr, this, str.getBytes());
    }

    public void removeDeletedWord() {
        ATKSharedUIJNI.SmartGuideComponent_removeDeletedWord(this.swigCPtr, this);
    }

    public boolean setValueForOption(String str, int i) {
        return ATKSharedUIJNI.SmartGuideComponent_setValueForOption(this.swigCPtr, this, str.getBytes(), i);
    }

    public boolean isFullBlock() {
        return ATKSharedUIJNI.SmartGuideComponent_isFullBlock(this.swigCPtr, this);
    }

    public void processTextBox() {
        ATKSharedUIJNI.SmartGuideComponent_processTextBox(this.swigCPtr, this);
    }

    public void setIsUIReady(boolean z) {
        ATKSharedUIJNI.SmartGuideComponent_setIsUIReady(this.swigCPtr, this, z);
    }

    public boolean isUIReady() {
        return ATKSharedUIJNI.SmartGuideComponent_isUIReady(this.swigCPtr, this);
    }

    public void startTimer() {
        ATKSharedUIJNI.SmartGuideComponent_startTimer(this.swigCPtr, this);
    }

    public void stopTimer() {
        ATKSharedUIJNI.SmartGuideComponent_stopTimer(this.swigCPtr, this);
    }

    public boolean hasRecognitionUpdate() {
        return ATKSharedUIJNI.SmartGuideComponent_hasRecognitionUpdate(this.swigCPtr, this);
    }

    public String getOptionValueKey(int i) {
        return new String(ATKSharedUIJNI.SmartGuideComponent_getOptionValueKey(this.swigCPtr, this, i), StandardCharsets.UTF_8);
    }

    public boolean getOptionValueValue(int i) {
        return ATKSharedUIJNI.SmartGuideComponent_getOptionValueValue(this.swigCPtr, this, i);
    }

    public static SmartGuideComponent newRef(SmartGuideComponent smartGuideComponent) {
        long jSmartGuideComponent_newRef = ATKSharedUIJNI.SmartGuideComponent_newRef(getCPtr(smartGuideComponent), smartGuideComponent);
        if (jSmartGuideComponent_newRef == 0) {
            return null;
        }
        return new SmartGuideComponent(jSmartGuideComponent_newRef, true);
    }
}
