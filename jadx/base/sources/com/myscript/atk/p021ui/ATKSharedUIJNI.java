package com.myscript.atk.p021ui;

import com.myscript.atk.core.Extent;
import com.myscript.atk.core.Point;
import com.myscript.atk.core.Selection;

/* JADX INFO: loaded from: classes4.dex */
class ATKSharedUIJNI {
    public static final native void ActionMenuCallback_triggerActionAt(long j, ActionMenuCallback actionMenuCallback, int i, long j2, Point point);

    public static final native long ActionMenuData_actions_get(long j, ActionMenuData actionMenuData);

    public static final native void ActionMenuData_actions_set(long j, ActionMenuData actionMenuData, long j2, SWIGActionMenuEntryList sWIGActionMenuEntryList);

    public static final native byte[] ActionMenuData_contentType_get(long j, ActionMenuData actionMenuData);

    public static final native void ActionMenuData_contentType_set(long j, ActionMenuData actionMenuData, byte[] bArr);

    public static final native long ActionMenuData_inputPoint_get(long j, ActionMenuData actionMenuData);

    public static final native void ActionMenuData_inputPoint_set(long j, ActionMenuData actionMenuData, long j2, Point point);

    public static final native long ActionMenuData_menuPoint_get(long j, ActionMenuData actionMenuData);

    public static final native void ActionMenuData_menuPoint_set(long j, ActionMenuData actionMenuData, long j2, Point point);

    public static final native int ActionMenuData_nature_get(long j, ActionMenuData actionMenuData);

    public static final native void ActionMenuData_nature_set(long j, ActionMenuData actionMenuData, int i);

    public static final native long ActionMenuEntryLabels_get();

    public static final native long EMPTY_ACTION_MENU_get();

    public static final native long MenuNatureLabels_get();

    public static final native long MenuTypeLabels_get();

    public static final native void PrompterBox_addWord(long j, PrompterBox prompterBox, long j2, PrompterWord prompterWord);

    public static final native byte[] PrompterBox_getContentFieldId(long j, PrompterBox prompterBox);

    public static final native long PrompterBox_getCurrentExtent(long j, PrompterBox prompterBox);

    public static final native long PrompterBox_getLastEndTimestamp(long j, PrompterBox prompterBox);

    public static final native byte[] PrompterBox_getPrompterId(long j, PrompterBox prompterBox);

    public static final native long PrompterBox_getPrompterWordForId(long j, PrompterBox prompterBox, int i);

    public static final native int PrompterBox_getTagType(long j, PrompterBox prompterBox);

    public static final native long PrompterBox_getWords(long j, PrompterBox prompterBox);

    public static final native void PrompterBox_insertWord(long j, PrompterBox prompterBox, int i, long j2, PrompterWord prompterWord);

    public static final native boolean PrompterBox_removeWord(long j, PrompterBox prompterBox, int i);

    public static final native void PrompterBox_setCurrentExtent(long j, PrompterBox prompterBox, long j2, Extent extent);

    public static final native void PrompterBox_setLastEndTimestamp(long j, PrompterBox prompterBox, long j2);

    public static final native void PrompterBox_setRemoveState(long j, PrompterBox prompterBox, int i);

    public static final native void PrompterBox_setTagType(long j, PrompterBox prompterBox, int i);

    public static final native void PrompterBox_updateContentFieldId(long j, PrompterBox prompterBox, byte[] bArr);

    public static final native void PrompterBox_updateWord(long j, PrompterBox prompterBox, int i, int i2, byte[] bArr, int i3, long j2, long j3, int i4);

    public static final native long PrompterWord_beginTimestamp(long j, PrompterWord prompterWord);

    public static final native long PrompterWord_endTimestamp(long j, PrompterWord prompterWord);

    public static final native int PrompterWord_id(long j, PrompterWord prompterWord);

    public static final native byte[] PrompterWord_label(long j, PrompterWord prompterWord);

    public static final native byte[] PrompterWord_labelWithSpace(long j, PrompterWord prompterWord);

    public static final native int PrompterWord_selectedLabelIndex(long j, PrompterWord prompterWord);

    public static final native void PrompterWord_setBeginTimestamp(long j, PrompterWord prompterWord, long j2);

    public static final native void PrompterWord_setEndTimestamp(long j, PrompterWord prompterWord, long j2);

    public static final native void PrompterWord_setState(long j, PrompterWord prompterWord, int i);

    public static final native void PrompterWord_setWordIndex(long j, PrompterWord prompterWord, int i);

    public static final native int PrompterWord_state(long j, PrompterWord prompterWord);

    public static final native boolean PrompterWord_updateWord(long j, PrompterWord prompterWord, int i, byte[] bArr, int i2, long j2, long j3, int i3);

    public static final native int PrompterWord_wordIndex(long j, PrompterWord prompterWord);

    public static final native int SWIGActionMenuEntryList_at(long j, SWIGActionMenuEntryList sWIGActionMenuEntryList, int i);

    public static final native void SWIGActionMenuEntryList_push_back(long j, SWIGActionMenuEntryList sWIGActionMenuEntryList, int i);

    public static final native int SWIGActionMenuEntryList_size(long j, SWIGActionMenuEntryList sWIGActionMenuEntryList);

    public static final native long SWIGPrompterWordList_at(long j, SWIGPrompterWordList sWIGPrompterWordList, int i);

    public static final native void SWIGPrompterWordList_push_back(long j, SWIGPrompterWordList sWIGPrompterWordList, long j2, PrompterWord prompterWord);

    public static final native int SWIGPrompterWordList_size(long j, SWIGPrompterWordList sWIGPrompterWordList);

    public static final native long SWIGShapeCandidate_at(long j, SWIGShapeCandidate sWIGShapeCandidate, int i);

    public static final native void SWIGShapeCandidate_push_back(long j, SWIGShapeCandidate sWIGShapeCandidate, long j2, ShapeCandidate shapeCandidate);

    public static final native int SWIGShapeCandidate_size(long j, SWIGShapeCandidate sWIGShapeCandidate);

    public static final native byte[] ShapeCandidate_label_get(long j, ShapeCandidate shapeCandidate);

    public static final native void ShapeCandidate_label_set(long j, ShapeCandidate shapeCandidate, byte[] bArr);

    public static final native boolean ShapeCandidate_selected_get(long j, ShapeCandidate shapeCandidate);

    public static final native void ShapeCandidate_selected_set(long j, ShapeCandidate shapeCandidate, boolean z);

    public static final native long ShapeResult_candidatesFromSelection(long j, ShapeResult shapeResult, long j2, Selection selection);

    public static final native boolean ShapeResult_setCandidate(long j, ShapeResult shapeResult, long j2, Selection selection, int i);

    public static final native void SmartGuideComponent_activateBlockType__SWIG_0(long j, SmartGuideComponent smartGuideComponent, int i);

    public static final native boolean SmartGuideComponent_activateBlockType__SWIG_1(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, int i, long j2, Extent extent, boolean z, boolean z2, boolean z3, boolean z4);

    public static final native boolean SmartGuideComponent_activateBlockType__SWIG_2(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, int i, long j2, Extent extent, boolean z, boolean z2, boolean z3);

    public static final native boolean SmartGuideComponent_activateBlockType__SWIG_3(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, int i, long j2, Extent extent, boolean z, boolean z2);

    public static final native boolean SmartGuideComponent_activateBlockType__SWIG_4(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, int i, long j2, Extent extent, boolean z);

    public static final native boolean SmartGuideComponent_activateBlockType__SWIG_5(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, int i, long j2, Extent extent);

    public static final native void SmartGuideComponent_activateMultiAndUpdate__SWIG_0(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Extent extent, boolean z, boolean z2);

    public static final native void SmartGuideComponent_activateMultiAndUpdate__SWIG_1(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Extent extent, boolean z);

    public static final native void SmartGuideComponent_activateMultiAndUpdate__SWIG_2(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Extent extent);

    public static final native void SmartGuideComponent_activateMulti__SWIG_0(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Extent extent, boolean z, boolean z2);

    public static final native void SmartGuideComponent_activateMulti__SWIG_1(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Extent extent, boolean z);

    public static final native void SmartGuideComponent_activateMulti__SWIG_2(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Extent extent);

    public static final native void SmartGuideComponent_activateShapeAndUpdate__SWIG_0(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Selection selection2, long j4, Extent extent, boolean z, boolean z2, boolean z3);

    public static final native void SmartGuideComponent_activateShapeAndUpdate__SWIG_1(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Selection selection2, long j4, Extent extent, boolean z, boolean z2);

    public static final native void SmartGuideComponent_activateShapeAndUpdate__SWIG_2(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Selection selection2, long j4, Extent extent, boolean z);

    public static final native void SmartGuideComponent_activateShape__SWIG_0(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Selection selection2, long j4, Extent extent, boolean z, boolean z2, boolean z3);

    public static final native void SmartGuideComponent_activateShape__SWIG_1(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Selection selection2, long j4, Extent extent, boolean z, boolean z2);

    public static final native void SmartGuideComponent_activateShape__SWIG_2(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, long j2, Selection selection, long j3, Selection selection2, long j4, Extent extent, boolean z);

    public static final native boolean SmartGuideComponent_activateTextAndUpdate__SWIG_0(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    public static final native boolean SmartGuideComponent_activateTextAndUpdate__SWIG_1(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent, boolean z, boolean z2, boolean z3, boolean z4);

    public static final native boolean SmartGuideComponent_activateTextAndUpdate__SWIG_2(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent, boolean z, boolean z2, boolean z3);

    public static final native boolean SmartGuideComponent_activateTextAndUpdate__SWIG_3(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent, boolean z, boolean z2);

    public static final native boolean SmartGuideComponent_activateTextAndUpdate__SWIG_4(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent, boolean z);

    public static final native boolean SmartGuideComponent_activateTextAndUpdate__SWIG_5(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent);

    public static final native boolean SmartGuideComponent_activateText__SWIG_0(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent, boolean z, boolean z2, boolean z3, boolean z4);

    public static final native boolean SmartGuideComponent_activateText__SWIG_1(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent, boolean z, boolean z2, boolean z3);

    public static final native boolean SmartGuideComponent_activateText__SWIG_2(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent, boolean z, boolean z2);

    public static final native boolean SmartGuideComponent_activateText__SWIG_3(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent, boolean z);

    public static final native boolean SmartGuideComponent_activateText__SWIG_4(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, byte[] bArr2, long j2, Extent extent);

    public static final native int SmartGuideComponent_availableActions(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_cancelProcess(long j, SmartGuideComponent smartGuideComponent);

    public static final native long SmartGuideComponent_candidateLabelsForShape(long j, SmartGuideComponent smartGuideComponent);

    public static final native long SmartGuideComponent_candidateLabelsForWord(long j, SmartGuideComponent smartGuideComponent, long j2, PrompterWord prompterWord);

    public static final native void SmartGuideComponent_changeShapeCandidate(long j, SmartGuideComponent smartGuideComponent, long j2, ShapeCandidate shapeCandidate, int i);

    public static final native void SmartGuideComponent_changeStyle(long j, SmartGuideComponent smartGuideComponent, int i);

    public static final native void SmartGuideComponent_changeTextCandidate(long j, SmartGuideComponent smartGuideComponent, long j2, PrompterWord prompterWord, int i);

    public static final native void SmartGuideComponent_changeVisibility__SWIG_0(long j, SmartGuideComponent smartGuideComponent, boolean z, boolean z2);

    public static final native void SmartGuideComponent_changeVisibility__SWIG_1(long j, SmartGuideComponent smartGuideComponent, boolean z);

    public static final native void SmartGuideComponent_clearPrompter(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_clearSmartGuide__SWIG_0(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_clearSmartGuide__SWIG_1(long j, SmartGuideComponent smartGuideComponent, byte[] bArr);

    public static final native byte[] SmartGuideComponent_contentFieldId(long j, SmartGuideComponent smartGuideComponent);

    public static final native long SmartGuideComponent_currentPrompterBox(long j, SmartGuideComponent smartGuideComponent);

    public static final native int SmartGuideComponent_currentSmartGuideBlockType(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_deleteBox(long j, SmartGuideComponent smartGuideComponent, byte[] bArr);

    public static final native void SmartGuideComponent_disableMulti(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_disableShape(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_disableText(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_exportBox(long j, SmartGuideComponent smartGuideComponent, int i, byte[] bArr, byte[] bArr2);

    public static final native void SmartGuideComponent_exportCurrentBox(long j, SmartGuideComponent smartGuideComponent, int i, byte[] bArr);

    public static final native byte[] SmartGuideComponent_getOptionValueKey(long j, SmartGuideComponent smartGuideComponent, int i);

    public static final native boolean SmartGuideComponent_getOptionValueValue(long j, SmartGuideComponent smartGuideComponent, int i);

    public static final native boolean SmartGuideComponent_hasRecognitionUpdate(long j, SmartGuideComponent smartGuideComponent);

    public static final native boolean SmartGuideComponent_isConversionPreviewShown(long j, SmartGuideComponent smartGuideComponent);

    public static final native boolean SmartGuideComponent_isFullBlock(long j, SmartGuideComponent smartGuideComponent);

    public static final native boolean SmartGuideComponent_isProcessPending(long j, SmartGuideComponent smartGuideComponent, byte[] bArr);

    public static final native boolean SmartGuideComponent_isSmartGuideVisible(long j, SmartGuideComponent smartGuideComponent);

    public static final native boolean SmartGuideComponent_isUIReady(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_listify(long j, SmartGuideComponent smartGuideComponent, byte[] bArr);

    public static final native long SmartGuideComponent_newRef(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_processTextBox(long j, SmartGuideComponent smartGuideComponent);

    public static final native byte[] SmartGuideComponent_prompterId(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_removeDeletedWord(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_setAsDrawing(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_setAsText(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_setAvailableActions(long j, SmartGuideComponent smartGuideComponent, int i);

    public static final native void SmartGuideComponent_setIsUIReady(long j, SmartGuideComponent smartGuideComponent, boolean z);

    public static final native void SmartGuideComponent_setShowConversionPreview(long j, SmartGuideComponent smartGuideComponent, boolean z);

    public static final native void SmartGuideComponent_setSmartGuideListener(long j, SmartGuideComponent smartGuideComponent, ISmartGuideComponentListener iSmartGuideComponentListener);

    public static final native boolean SmartGuideComponent_setValueForOption(long j, SmartGuideComponent smartGuideComponent, byte[] bArr, int i);

    public static final native long SmartGuideComponent_shapeSelection(long j, SmartGuideComponent smartGuideComponent);

    public static final native int SmartGuideComponent_simplifyShapeLabel(long j, SmartGuideComponent smartGuideComponent, byte[] bArr);

    public static final native void SmartGuideComponent_startTimer(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_stopTimer(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_textify(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_typesetCurrentBox(long j, SmartGuideComponent smartGuideComponent);

    public static final native void SmartGuideComponent_updateContentFieldId(long j, SmartGuideComponent smartGuideComponent, byte[] bArr);

    public static final native void SmartGuideComponent_update__SWIG_0(long j, SmartGuideComponent smartGuideComponent, long j2, Extent extent, byte[] bArr, boolean z);

    public static final native void SmartGuideComponent_update__SWIG_1(long j, SmartGuideComponent smartGuideComponent, long j2, Extent extent, byte[] bArr);

    public static final native void SmartGuideComponent_update__SWIG_2(long j, SmartGuideComponent smartGuideComponent, long j2, Extent extent);

    public static final native void SmartGuideComponent_update__SWIG_3(long j, SmartGuideComponent smartGuideComponent);

    public static void clinit() {
    }

    public static final native void delete_ActionMenuCallback(long j);

    public static final native void delete_ActionMenuData(long j);

    public static final native void delete_PrompterBox(long j);

    public static final native void delete_PrompterWord(long j);

    public static final native void delete_SWIGActionMenuEntryList(long j);

    public static final native void delete_SWIGPrompterWordList(long j);

    public static final native void delete_SWIGShapeCandidate(long j);

    public static final native void delete_ShapeCandidate(long j);

    public static final native void delete_ShapeResult(long j);

    public static final native void delete_SmartGuideComponent(long j);

    public static final native long new_ActionMenuData();

    public static final native long new_PrompterBox__SWIG_0(byte[] bArr);

    public static final native long new_PrompterBox__SWIG_1(long j, PrompterBox prompterBox);

    public static final native long new_PrompterWord(int i, byte[] bArr, int i2, long j, long j2, int i3);

    public static final native long new_SWIGActionMenuEntryList();

    public static final native long new_SWIGPrompterWordList();

    public static final native long new_SWIGShapeCandidate();

    public static final native long new_ShapeCandidate__SWIG_0(byte[] bArr, boolean z);

    public static final native long new_ShapeCandidate__SWIG_1(long j, ShapeCandidate shapeCandidate);

    ATKSharedUIJNI() {
    }

    static {
        clinit();
    }
}
