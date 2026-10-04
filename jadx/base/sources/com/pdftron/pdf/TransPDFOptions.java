package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class TransPDFOptions extends OptionsBase {
    public TransPDFOptions() throws PDFNetException {
    }

    public TransPDFOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public int getBatchSize() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("BatchSize");
        if (objFindObj == null || objFindObj.isNull()) {
            return 20;
        }
        return (int) objFindObj.getNumber();
    }

    public TransPDFOptions setBatchSize(int i) throws PDFNetException {
        putNumber("BatchSize", i);
        return this;
    }

    public String getPages() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Pages");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public TransPDFOptions setPages(String str) throws PDFNetException {
        putText("Pages", str);
        return this;
    }

    public boolean getResizeSingleLine() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ResizeSingleLine");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public TransPDFOptions setResizeSingleLine(boolean z) throws PDFNetException {
        putBool("ResizeSingleLine", Boolean.valueOf(z));
        return this;
    }

    public String getSourceLanguage() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("SourceLanguage");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "en";
    }

    public TransPDFOptions setSourceLanguage(String str) throws PDFNetException {
        putText("SourceLanguage", str);
        return this;
    }
}
