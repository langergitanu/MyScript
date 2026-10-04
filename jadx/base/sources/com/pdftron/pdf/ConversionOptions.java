package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class ConversionOptions extends OptionsBase {
    public ConversionOptions() throws PDFNetException {
    }

    public ConversionOptions(String str) throws PDFNetException {
        super(str);
    }

    public String getFileExtension() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FileExtension");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public ConversionOptions setFileExtension(String str) throws PDFNetException {
        putText("FileExtension", str);
        return this;
    }

    public boolean getEnableExternalMediaDownloads() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("EnableExternalMediaDownloads");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public ConversionOptions setEnableExternalMediaDownloads(boolean z) throws PDFNetException {
        putBool("EnableExternalMediaDownloads", Boolean.valueOf(z));
        return this;
    }
}
