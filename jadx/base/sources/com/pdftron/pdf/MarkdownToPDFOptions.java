package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class MarkdownToPDFOptions extends ConversionOptions {
    public String getFontFace() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FontFace");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public MarkdownToPDFOptions setFontFace(String str) throws PDFNetException {
        putText("FontFace", str);
        return this;
    }
}
