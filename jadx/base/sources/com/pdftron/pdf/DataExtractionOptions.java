package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class DataExtractionOptions extends OptionsBase {
    public DataExtractionOptions() throws PDFNetException {
    }

    public DataExtractionOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getDeepLearningAssist() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DeepLearningAssist");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public DataExtractionOptions setDeepLearningAssist(boolean z) throws PDFNetException {
        putBool("DeepLearningAssist", Boolean.valueOf(z));
        return this;
    }

    public boolean getDetectEmptyFields() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DetectEmptyFields");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public DataExtractionOptions setDetectEmptyFields(boolean z) throws PDFNetException {
        putBool("DetectEmptyFields", Boolean.valueOf(z));
        return this;
    }

    public DataExtractionOptions addExclusionZonesForPage(RectCollection rectCollection, int i) throws PDFNetException {
        insertRectCollection("ExclusionZones", rectCollection, i - 1);
        return this;
    }

    public String getFormExtractionEngine() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FormExtractionEngine");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "Form";
    }

    public DataExtractionOptions setFormExtractionEngine(String str) throws PDFNetException {
        putText("FormExtractionEngine", str);
        return this;
    }

    public DataExtractionOptions addInclusionZonesForPage(RectCollection rectCollection, int i) throws PDFNetException {
        insertRectCollection("InclusionZones", rectCollection, i - 1);
        return this;
    }

    public String getLanguage() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Language");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public DataExtractionOptions setLanguage(String str) throws PDFNetException {
        putText("Language", str);
        return this;
    }

    public double getMinimumConfidenceThreshold() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("MinimumConfidenceThreshold");
        if (objFindObj == null || objFindObj.isNull()) {
            return 0.25d;
        }
        return objFindObj.getNumber();
    }

    public DataExtractionOptions setMinimumConfidenceThreshold(double d) throws PDFNetException {
        putNumber("MinimumConfidenceThreshold", d);
        return this;
    }

    public String getOverlappingFormFieldBehavior() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("OverlappingFormFieldBehavior");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "KeepNew";
    }

    public DataExtractionOptions setOverlappingFormFieldBehavior(String str) throws PDFNetException {
        putText("OverlappingFormFieldBehavior", str);
        return this;
    }

    public String getPDFPassword() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("PDFPassword");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public DataExtractionOptions setPDFPassword(String str) throws PDFNetException {
        putText("PDFPassword", str);
        return this;
    }

    public String getPages() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Pages");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public DataExtractionOptions setPages(String str) throws PDFNetException {
        putText("Pages", str);
        return this;
    }

    public boolean getTextRecoveryNSE() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TextRecoveryNSE");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public DataExtractionOptions setTextRecoveryNSE(boolean z) throws PDFNetException {
        putBool("TextRecoveryNSE", Boolean.valueOf(z));
        return this;
    }
}
