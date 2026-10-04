package com.pdftron.fdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.OptionsBase;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class XFDFExportOptions extends OptionsBase {
    public XFDFExportOptions() throws PDFNetException {
    }

    public XFDFExportOptions(String str) throws PDFNetException {
        super(str);
    }

    /* JADX INFO: renamed from: a */
    final long m1116a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getWriteAnnotationAppearance() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("WriteAnnotationAppearance");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public XFDFExportOptions setWriteAnnotationAppearance(boolean z) throws PDFNetException {
        putBool("WriteAnnotationAppearance", Boolean.valueOf(z));
        return this;
    }

    public boolean getWriteImagedata() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("WriteImagedata");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public XFDFExportOptions setWriteImagedata(boolean z) throws PDFNetException {
        putBool("WriteImagedata", Boolean.valueOf(z));
        return this;
    }
}
