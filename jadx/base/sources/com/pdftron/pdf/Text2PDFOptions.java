package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;

/* JADX INFO: loaded from: classes7.dex */
public class Text2PDFOptions {

    /* JADX INFO: renamed from: a */
    private ObjSet f2059a;

    /* JADX INFO: renamed from: b */
    private Obj f2060b;

    public Text2PDFOptions() throws PDFNetException {
        ObjSet objSet = new ObjSet();
        this.f2059a = objSet;
        this.f2060b = objSet.createDict();
    }

    public int getBytesPerBite() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("BytesPerBite");
        if (objFindObj.isNull()) {
            return 1024;
        }
        return (int) objFindObj.getNumber();
    }

    public Text2PDFOptions setBytesPerBite(int i) throws PDFNetException {
        this.f2060b.putNumber("BytesPerBite", i);
        return this;
    }

    public String getFontFace() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("FontFace");
        if (!objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "Arial";
    }

    public Text2PDFOptions setFontFace(String str) throws PDFNetException {
        this.f2060b.putString("FontFace", str);
        return this;
    }

    public double getFontSize() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("FontSize");
        if (objFindObj.isNull()) {
            return 12.0d;
        }
        return objFindObj.getNumber();
    }

    public Text2PDFOptions setFontSize(double d) throws PDFNetException {
        this.f2060b.putNumber("FontSize", d);
        return this;
    }

    public double getLineHeightMultiplier() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("LineHeightMultiplier");
        if (objFindObj.isNull()) {
            return 1.15d;
        }
        return objFindObj.getNumber();
    }

    public Text2PDFOptions setLineHeightMultiplier(double d) throws PDFNetException {
        this.f2060b.putNumber("LineHeightMultiplier", d);
        return this;
    }

    public double getMarginBottom() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("MarginBottom");
        if (objFindObj.isNull()) {
            return 1.25d;
        }
        return objFindObj.getNumber();
    }

    public Text2PDFOptions setMarginBottom(double d) throws PDFNetException {
        this.f2060b.putNumber("MarginBottom", d);
        return this;
    }

    public double getMarginLeft() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("MarginLeft");
        if (objFindObj.isNull()) {
            return 1.25d;
        }
        return objFindObj.getNumber();
    }

    public Text2PDFOptions setMarginLeft(double d) throws PDFNetException {
        this.f2060b.putNumber("MarginLeft", d);
        return this;
    }

    public double getMarginRight() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("MarginRight");
        if (objFindObj.isNull()) {
            return 1.25d;
        }
        return objFindObj.getNumber();
    }

    public Text2PDFOptions setMarginRight(double d) throws PDFNetException {
        this.f2060b.putNumber("MarginRight", d);
        return this;
    }

    public double getMarginTop() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("MarginTop");
        if (objFindObj.isNull()) {
            return 1.25d;
        }
        return objFindObj.getNumber();
    }

    public Text2PDFOptions setMarginTop(double d) throws PDFNetException {
        this.f2060b.putNumber("MarginTop", d);
        return this;
    }

    public double getPageHeight() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("PageHeight");
        if (objFindObj.isNull()) {
            return 11.0d;
        }
        return objFindObj.getNumber();
    }

    public Text2PDFOptions setPageHeight(double d) throws PDFNetException {
        this.f2060b.putNumber("PageHeight", d);
        return this;
    }

    public double getPageWidth() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("PageWidth");
        if (objFindObj.isNull()) {
            return 8.5d;
        }
        return objFindObj.getNumber();
    }

    public Text2PDFOptions setPageWidth(double d) throws PDFNetException {
        this.f2060b.putNumber("PageWidth", d);
        return this;
    }

    public boolean getUseSourceCodeFormatting() throws PDFNetException {
        Obj objFindObj = this.f2060b.findObj("UseSourceCodeFormatting");
        if (objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public Text2PDFOptions setUseSourceCodeFormatting(boolean z) throws PDFNetException {
        this.f2060b.putBool("UseSourceCodeFormatting", z);
        return this;
    }
}
