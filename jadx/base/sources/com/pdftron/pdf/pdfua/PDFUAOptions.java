package com.pdftron.pdf.pdfua;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.OptionsBase;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PDFUAOptions extends OptionsBase {
    public PDFUAOptions() throws PDFNetException {
    }

    public PDFUAOptions(String str) throws PDFNetException {
        super(str);
    }

    /* JADX INFO: renamed from: a */
    final long m1539a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public int getConformanceLevel() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Conformance");
        if (objFindObj == null || objFindObj.isNull()) {
            return 0;
        }
        return (int) objFindObj.getNumber();
    }

    public PDFUAOptions setConformanceLevel(int i) throws PDFNetException {
        putNumber("Conformance", i);
        return this;
    }

    public String getDefaultLangCode() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DefaultLangCode");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public PDFUAOptions setDefaultLangCode(String str) throws PDFNetException {
        putText("DefaultLangCode", str);
        return this;
    }

    public String getFigureAltTextPrefix() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FigureAltTextPrefix");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public PDFUAOptions setFigureAltTextPrefix(String str) throws PDFNetException {
        putText("FigureAltTextPrefix", str);
        return this;
    }

    public boolean getFirstStop() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FirstStop");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public PDFUAOptions setFirstStop(boolean z) throws PDFNetException {
        putBool("FirstStop", Boolean.valueOf(z));
        return this;
    }

    public int getMaxRefObjs() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("MaxRefObjs");
        if (objFindObj == null || objFindObj.isNull()) {
            return 10;
        }
        return (int) objFindObj.getNumber();
    }

    public PDFUAOptions setMaxRefObjs(int i) throws PDFNetException {
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

    public PDFUAOptions setPassword(String str) throws PDFNetException {
        putText("Password", str);
        return this;
    }

    public boolean getSaveLinearized() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("SaveLinearized");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public PDFUAOptions setSaveLinearized(boolean z) throws PDFNetException {
        putBool("SaveLinearized", Boolean.valueOf(z));
        return this;
    }
}
