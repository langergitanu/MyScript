package com.pdftron.pdf.pdfa;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.OptionsBase;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PDFAOptions extends OptionsBase {
    public PDFAOptions(int i) throws PDFNetException {
        setConformance(i);
    }

    public PDFAOptions(String str) throws PDFNetException {
        super(str);
    }

    /* JADX INFO: renamed from: a */
    final long m1538a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public int getConformance() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Conformance");
        if (objFindObj == null || objFindObj.isNull()) {
            return 2;
        }
        return (int) objFindObj.getNumber();
    }

    public PDFAOptions setConformance(int i) throws PDFNetException {
        putNumber("Conformance", i);
        return this;
    }

    public int getDPI() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Dpi");
        if (objFindObj == null || objFindObj.isNull()) {
            return 300;
        }
        return (int) objFindObj.getNumber();
    }

    public PDFAOptions setDPI(int i) throws PDFNetException {
        putNumber("Dpi", i);
        return this;
    }

    public boolean getFirstStop() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FirstStop");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public PDFAOptions setFirstStop(boolean z) throws PDFNetException {
        putBool("FirstStop", Boolean.valueOf(z));
        return this;
    }

    public boolean getFlattenTransparency() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Flatten");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public PDFAOptions setFlattenTransparency(boolean z) throws PDFNetException {
        putBool("Flatten", Boolean.valueOf(z));
        return this;
    }

    public int getMaxRefObjs() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("MaxRefObjs");
        if (objFindObj == null || objFindObj.isNull()) {
            return 10;
        }
        return (int) objFindObj.getNumber();
    }

    public PDFAOptions setMaxRefObjs(int i) throws PDFNetException {
        putNumber("MaxRefObjs", i);
        return this;
    }

    public String getPassword() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Password");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public PDFAOptions setPassword(String str) throws PDFNetException {
        putText("Password", str);
        return this;
    }
}
