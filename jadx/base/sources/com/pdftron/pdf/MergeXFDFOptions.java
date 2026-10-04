package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class MergeXFDFOptions extends OptionsBase {
    public MergeXFDFOptions() throws PDFNetException {
    }

    public MergeXFDFOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getForce() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Force");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public MergeXFDFOptions setForce(boolean z) throws PDFNetException {
        putBool("Force", Boolean.valueOf(z));
        return this;
    }

    public boolean getUseNonStandardRotation() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("UseNonStandardRotation");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public MergeXFDFOptions setUseNonStandardRotation(boolean z) throws PDFNetException {
        putBool("UseNonStandardRotation", Boolean.valueOf(z));
        return this;
    }
}
