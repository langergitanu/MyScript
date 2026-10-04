package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class DiffOptions extends OptionsBase {
    public DiffOptions() throws PDFNetException {
    }

    public DiffOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getAddGroupAnnots() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AddGroupAnnots");
        if (objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public DiffOptions setAddGroupAnnots(boolean z) throws PDFNetException {
        this.mDict.putBool("AddGroupAnnots", z);
        return this;
    }

    public int getBlendMode() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("BlendMode");
        if (objFindObj.isNull()) {
            return 5;
        }
        return (int) objFindObj.getNumber();
    }

    public DiffOptions setBlendMode(int i) throws PDFNetException {
        this.mDict.putNumber("BlendMode", i);
        return this;
    }

    public ColorPt getColorA() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ColorA");
        if (!objFindObj.isNull()) {
            return m1194a(objFindObj.getNumber());
        }
        return m1194a(-3407872.0d);
    }

    public DiffOptions setColorA(ColorPt colorPt) throws PDFNetException {
        this.mDict.putNumber("ColorA", m1193a(colorPt));
        return this;
    }

    public ColorPt getColorB() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ColorB");
        if (!objFindObj.isNull()) {
            return m1194a(objFindObj.getNumber());
        }
        return m1194a(-1.6724788E7d);
    }

    public DiffOptions setColorB(ColorPt colorPt) throws PDFNetException {
        this.mDict.putNumber("ColorB", m1193a(colorPt));
        return this;
    }
}
