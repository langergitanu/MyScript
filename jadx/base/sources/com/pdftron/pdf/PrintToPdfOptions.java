package com.pdftron.pdf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PrintToPdfOptions extends OptionsBase {
    public PrintToPdfOptions() throws PDFNetException {
    }

    public PrintToPdfOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public double getHorizontalPageMargin() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("horizontal-page-margin");
        if (objFindObj == null || objFindObj.isNull()) {
            return 18.0d;
        }
        return objFindObj.getNumber();
    }

    public PrintToPdfOptions setHorizontalPageMargin(double d) throws PDFNetException {
        putNumber("horizontal-page-margin", d);
        return this;
    }

    public double getPageHeight() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("page-height");
        return (objFindObj == null || objFindObj.isNull()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : objFindObj.getNumber();
    }

    public PrintToPdfOptions setPageHeight(double d) throws PDFNetException {
        putNumber("page-height", d);
        return this;
    }

    public String getPageOrientation() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("page-orientation");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public PrintToPdfOptions setPageOrientation(String str) throws PDFNetException {
        putText("page-orientation", str);
        return this;
    }

    public double getPageWidth() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("page-width");
        return (objFindObj == null || objFindObj.isNull()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : objFindObj.getNumber();
    }

    public PrintToPdfOptions setPageWidth(double d) throws PDFNetException {
        putNumber("page-width", d);
        return this;
    }

    public double getVerticalPageMargin() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("vertical-page-margin");
        if (objFindObj == null || objFindObj.isNull()) {
            return 18.0d;
        }
        return objFindObj.getNumber();
    }

    public PrintToPdfOptions setVerticalPageMargin(double d) throws PDFNetException {
        putNumber("vertical-page-margin", d);
        return this;
    }
}
