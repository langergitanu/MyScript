package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class TaggingOptions extends OptionsBase {
    public TaggingOptions() throws PDFNetException {
    }

    public TaggingOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public String getDescription() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Description");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public TaggingOptions setDescription(String str) throws PDFNetException {
        putText("Description", str);
        return this;
    }

    public int getInsertIndex() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("InsertIndex");
        if (objFindObj == null || objFindObj.isNull()) {
            return -1;
        }
        return (int) objFindObj.getNumber();
    }

    public TaggingOptions setInsertIndex(int i) throws PDFNetException {
        putNumber("InsertIndex", i);
        return this;
    }
}
