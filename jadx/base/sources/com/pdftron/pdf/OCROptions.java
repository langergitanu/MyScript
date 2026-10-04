package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class OCROptions extends OptionsBase {
    public OCROptions() throws PDFNetException {
    }

    public OCROptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getAutoRotate() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AutoRotate");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OCROptions setAutoRotate(boolean z) throws PDFNetException {
        putBool("AutoRotate", Boolean.valueOf(z));
        return this;
    }

    public int getDPI() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DPI");
        if (objFindObj == null || objFindObj.isNull()) {
            return 0;
        }
        return (int) objFindObj.getNumber();
    }

    public OCROptions addDPI(int i) throws PDFNetException {
        putNumber("DPI", i);
        return this;
    }

    public boolean getIgnoreExistingText() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("IncludeExistingText");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public OCROptions setIgnoreExistingText(boolean z) throws PDFNetException {
        putBool("IncludeExistingText", Boolean.valueOf(z));
        return this;
    }

    public boolean getIncludeExistingText() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("IncludeExistingText");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public OCROptions setIncludeExistingText(boolean z) throws PDFNetException {
        putBool("IncludeExistingText", Boolean.valueOf(z));
        return this;
    }

    public OCROptions addIgnoreZonesForPage(RectCollection rectCollection, int i) throws PDFNetException {
        insertRectCollection("IgnoreZones", rectCollection, i - 1);
        return this;
    }

    public OCROptions addLang(String str) throws PDFNetException {
        pushBackText("Langs", str);
        return this;
    }

    public String getOCREngine() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("OCREngine");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OCROptions setOCREngine(String str) throws PDFNetException {
        putText("OCREngine", str);
        return this;
    }

    public OCROptions addTextZonesForPage(RectCollection rectCollection, int i) throws PDFNetException {
        insertRectCollection("TextZones", rectCollection, i - 1);
        return this;
    }

    public boolean getUsePDFPageCoords() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("UsePDFPageCoords");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public OCROptions setUsePDFPageCoords(boolean z) throws PDFNetException {
        putBool("UsePDFPageCoords", Boolean.valueOf(z));
        return this;
    }
}
