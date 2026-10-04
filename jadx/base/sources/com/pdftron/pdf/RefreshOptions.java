package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class RefreshOptions extends OptionsBase {
    public RefreshOptions() throws PDFNetException {
    }

    public RefreshOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getDrawBackgroundOnly() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DrawBackgroundOnly");
        if (objFindObj != null) {
            return objFindObj.getBool();
        }
        return true;
    }

    public RefreshOptions setDrawBackgroundOnly(boolean z) throws PDFNetException {
        putBool("DrawBackgroundOnly", Boolean.valueOf(z));
        return this;
    }

    public boolean getRefreshExisting() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("RefreshExisting");
        if (objFindObj != null) {
            return objFindObj.getBool();
        }
        return true;
    }

    public RefreshOptions setRefreshExisting(boolean z) throws PDFNetException {
        putBool("RefreshExisting", Boolean.valueOf(z));
        return this;
    }

    public boolean getUseNonStandardRotation() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("UseNonStandardRotation");
        if (objFindObj != null) {
            return objFindObj.getBool();
        }
        return false;
    }

    public RefreshOptions setUseNonStandardRotation(boolean z) throws PDFNetException {
        putBool("UseNonStandardRotation", Boolean.valueOf(z));
        return this;
    }

    public boolean getUseRoundedCorners() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("UseRoundedCorners");
        if (objFindObj != null) {
            return objFindObj.getBool();
        }
        return false;
    }

    public RefreshOptions setUseRoundedCorners(boolean z) throws PDFNetException {
        putBool("UseRoundedCorners", Boolean.valueOf(z));
        return this;
    }
}
