package com.pdftron.pdf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class OfficeToPDFOptions extends ConversionOptions {

    public static final class UpdateDynamicFields {
        public static final int e_update_all = -1;
        public static final int e_update_doc_props = 1;
        public static final int e_update_none = 0;
    }

    public enum StructureTagLevel {
        e_default(0),
        e_none(1);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, StructureTagLevel> f1591b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1593a;

        static {
            for (StructureTagLevel structureTagLevel : values()) {
                f1591b.put(Integer.valueOf(structureTagLevel.f1593a), structureTagLevel);
            }
        }

        StructureTagLevel(int i) {
            this.f1593a = i;
        }

        /* JADX INFO: renamed from: a */
        static StructureTagLevel m1170a(int i) {
            return f1591b.get(Integer.valueOf(i));
        }
    }

    public enum DisplayComments {
        e_off(0),
        e_annotations(1);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, DisplayComments> f1585b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1587a;

        static {
            for (DisplayComments displayComments : values()) {
                f1585b.put(Integer.valueOf(displayComments.f1587a), displayComments);
            }
        }

        DisplayComments(int i) {
            this.f1587a = i;
        }

        /* JADX INFO: renamed from: a */
        static DisplayComments m1168a(int i) {
            return f1585b.get(Integer.valueOf(i));
        }
    }

    public enum DisplaySpeakerNotes {
        e_no_speaker_notes(0),
        e_speaker_notes_annotations(1);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, DisplaySpeakerNotes> f1588b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1590a;

        static {
            for (DisplaySpeakerNotes displaySpeakerNotes : values()) {
                f1588b.put(Integer.valueOf(displaySpeakerNotes.f1590a), displaySpeakerNotes);
            }
        }

        DisplaySpeakerNotes(int i) {
            this.f1590a = i;
        }

        /* JADX INFO: renamed from: a */
        static DisplaySpeakerNotes m1169a(int i) {
            return f1588b.get(Integer.valueOf(i));
        }
    }

    public enum AnimationMode {
        e_ignore(0),
        e_paginate(1);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, AnimationMode> f1582b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1584a;

        static {
            for (AnimationMode animationMode : values()) {
                f1582b.put(Integer.valueOf(animationMode.f1584a), animationMode);
            }
        }

        AnimationMode(int i) {
            this.f1584a = i;
        }

        /* JADX INFO: renamed from: a */
        static AnimationMode m1167a(int i) {
            return f1582b.get(Integer.valueOf(i));
        }
    }

    public OfficeToPDFOptions() throws PDFNetException {
    }

    public OfficeToPDFOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public AnimationMode getAnimationHandling() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AnimationMode");
        if (objFindObj != null && !objFindObj.isNull()) {
            return AnimationMode.m1167a((int) objFindObj.getNumber());
        }
        return AnimationMode.m1167a(0);
    }

    public OfficeToPDFOptions setAnimationHandling(AnimationMode animationMode) throws PDFNetException {
        putNumber("AnimationMode", animationMode.f1584a);
        return this;
    }

    public boolean getApplyPageBreaksToSheet() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ApplyPageBreaksToSheet");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setApplyPageBreaksToSheet(boolean z) throws PDFNetException {
        putBool("ApplyPageBreaksToSheet", Boolean.valueOf(z));
        return this;
    }

    public boolean getDisableExcelHeadersFooters() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DisableExcelHeadersFooters");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setDisableExcelHeadersFooters(boolean z) throws PDFNetException {
        putBool("DisableExcelHeadersFooters", Boolean.valueOf(z));
        return this;
    }

    public boolean getDisableExcelMargins() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DisableExcelMargins");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setDisableExcelMargins(boolean z) throws PDFNetException {
        putBool("DisableExcelMargins", Boolean.valueOf(z));
        return this;
    }

    public boolean getDisableSheetHeightLimit() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DisableSheetHeightLimit");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setDisableSheetHeightLimit(boolean z) throws PDFNetException {
        putBool("DisableSheetHeightLimit", Boolean.valueOf(z));
        return this;
    }

    public boolean getDisplayChangeTracking() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DisplayChangeTracking");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setDisplayChangeTracking(boolean z) throws PDFNetException {
        putBool("DisplayChangeTracking", Boolean.valueOf(z));
        return this;
    }

    public DisplayComments getDisplayComments() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DisplayComments");
        if (objFindObj != null && !objFindObj.isNull()) {
            return DisplayComments.m1168a((int) objFindObj.getNumber());
        }
        return DisplayComments.m1168a(0);
    }

    public OfficeToPDFOptions setDisplayComments(DisplayComments displayComments) throws PDFNetException {
        putNumber("DisplayComments", displayComments.f1587a);
        return this;
    }

    public boolean getDisplayHiddenCells() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DisplayHiddenCells");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setDisplayHiddenCells(boolean z) throws PDFNetException {
        putBool("DisplayHiddenCells", Boolean.valueOf(z));
        return this;
    }

    public boolean getDisplayHiddenText() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DisplayHiddenText");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setDisplayHiddenText(boolean z) throws PDFNetException {
        putBool("DisplayHiddenText", Boolean.valueOf(z));
        return this;
    }

    public DisplaySpeakerNotes getDisplaySpeakerNotes() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DisplaySpeakerNotes");
        if (objFindObj != null && !objFindObj.isNull()) {
            return DisplaySpeakerNotes.m1169a((int) objFindObj.getNumber());
        }
        return DisplaySpeakerNotes.m1169a(0);
    }

    public OfficeToPDFOptions setDisplaySpeakerNotes(DisplaySpeakerNotes displaySpeakerNotes) throws PDFNetException {
        putNumber("DisplaySpeakerNotes", displaySpeakerNotes.f1590a);
        return this;
    }

    public double getExcelDefaultCellBorderWidth() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ExcelDefaultCellBorderWidth");
        return (objFindObj == null || objFindObj.isNull()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : objFindObj.getNumber();
    }

    public OfficeToPDFOptions setExcelDefaultCellBorderWidth(double d) throws PDFNetException {
        putNumber("ExcelDefaultCellBorderWidth", d);
        return this;
    }

    public int getExcelMaxAllowedCellCount() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ExcelMaxAllowedCellCount");
        if (objFindObj == null || objFindObj.isNull()) {
            return 0;
        }
        return (int) objFindObj.getNumber();
    }

    public OfficeToPDFOptions setExcelMaxAllowedCellCount(int i) throws PDFNetException {
        putNumber("ExcelMaxAllowedCellCount", i);
        return this;
    }

    public boolean getHideTotalNumberOfPages() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("HideTotalNumberOfPages");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setHideTotalNumberOfPages(boolean z) throws PDFNetException {
        putBool("HideTotalNumberOfPages", Boolean.valueOf(z));
        return this;
    }

    public boolean getIncludeBookmarks() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("IncludeBookmarks");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setIncludeBookmarks(boolean z) throws PDFNetException {
        putBool("IncludeBookmarks", Boolean.valueOf(z));
        return this;
    }

    public boolean getIncrementalSave() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("IncrementalSave");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setIncrementalSave(boolean z) throws PDFNetException {
        putBool("IncrementalSave", Boolean.valueOf(z));
        return this;
    }

    public String getLayoutResourcesPluginPath() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("LayoutResourcesPluginPath");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeToPDFOptions setLayoutResourcesPluginPath(String str) throws PDFNetException {
        putText("LayoutResourcesPluginPath", str);
        return this;
    }

    public String getLocale() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Locale");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeToPDFOptions setLocale(String str) throws PDFNetException {
        putText("Locale", str);
        return this;
    }

    public String getPassword() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Password");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeToPDFOptions setPassword(String str) throws PDFNetException {
        putText("Password", str);
        return this;
    }

    public String getResourceDocPath() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ResourceDocPath");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeToPDFOptions setResourceDocPath(String str) throws PDFNetException {
        putText("ResourceDocPath", str);
        return this;
    }

    public boolean getShowExcelGridlines() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ShowExcelGridlines");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setShowExcelGridlines(boolean z) throws PDFNetException {
        putBool("ShowExcelGridlines", Boolean.valueOf(z));
        return this;
    }

    public String getSmartSubstitutionPluginPath() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("SmartSubstitutionPluginPath");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeToPDFOptions setSmartSubstitutionPluginPath(String str) throws PDFNetException {
        putText("SmartSubstitutionPluginPath", str);
        return this;
    }

    public StructureTagLevel getStructureTagLevel() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("structure_tag_level");
        if (objFindObj != null && !objFindObj.isNull()) {
            return StructureTagLevel.m1170a((int) objFindObj.getNumber());
        }
        return StructureTagLevel.m1170a(0);
    }

    public OfficeToPDFOptions setStructureTagLevel(StructureTagLevel structureTagLevel) throws PDFNetException {
        putNumber("structure_tag_level", structureTagLevel.f1593a);
        return this;
    }

    public String getTemplateLeftDelimiter() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TemplateLeftDelimiter");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "{{";
    }

    public OfficeToPDFOptions setTemplateLeftDelimiter(String str) throws PDFNetException {
        putText("TemplateLeftDelimiter", str);
        return this;
    }

    public String getTemplateParamsJson() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TemplateParamsJson");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeToPDFOptions setTemplateParamsJson(String str) throws PDFNetException {
        putText("TemplateParamsJson", str);
        return this;
    }

    public String getTemplateRightDelimiter() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TemplateRightDelimiter");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "}}";
    }

    public OfficeToPDFOptions setTemplateRightDelimiter(String str) throws PDFNetException {
        putText("TemplateRightDelimiter", str);
        return this;
    }

    public boolean getTemplateStrictMode() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TemplateStrictMode");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setTemplateStrictMode(boolean z) throws PDFNetException {
        putBool("TemplateStrictMode", Boolean.valueOf(z));
        return this;
    }

    public int getUpdateDynamicFields() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("UpdateDynamicFields");
        if (objFindObj == null || objFindObj.isNull()) {
            return 0;
        }
        return (int) objFindObj.getNumber();
    }

    public OfficeToPDFOptions setUpdateDynamicFields(int i) throws PDFNetException {
        putNumber("UpdateDynamicFields", i);
        return this;
    }

    public boolean getUpdateTableOfContents() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("UpdateTableOfContents");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OfficeToPDFOptions setUpdateTableOfContents(boolean z) throws PDFNetException {
        putBool("UpdateTableOfContents", Boolean.valueOf(z));
        return this;
    }
}
