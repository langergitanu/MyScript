package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class TextDiffOptions extends OptionsBase {
    public TextDiffOptions() throws PDFNetException {
    }

    public TextDiffOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public ColorPt getColorA() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ColorA");
        if (objFindObj != null && !objFindObj.isNull()) {
            return m1194a(objFindObj.getNumber());
        }
        return m1194a(-1682873.0d);
    }

    public TextDiffOptions setColorA(ColorPt colorPt) throws PDFNetException {
        this.mDict.putNumber("ColorA", m1193a(colorPt));
        return this;
    }

    public double getOpacityA() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("OpacityA");
        if (objFindObj == null || objFindObj.isNull()) {
            return 0.5d;
        }
        return objFindObj.getNumber();
    }

    public TextDiffOptions setOpacityA(double d) throws PDFNetException {
        this.mDict.putNumber("OpacityA", d);
        return this;
    }

    public ColorPt getColorB() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ColorB");
        if (objFindObj != null && !objFindObj.isNull()) {
            return m1194a(objFindObj.getNumber());
        }
        return m1194a(-1.0688974E7d);
    }

    public TextDiffOptions setColorB(ColorPt colorPt) throws PDFNetException {
        this.mDict.putNumber("ColorB", m1193a(colorPt));
        return this;
    }

    public double getOpacityB() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("OpacityB");
        if (objFindObj == null || objFindObj.isNull()) {
            return 0.5d;
        }
        return objFindObj.getNumber();
    }

    public TextDiffOptions setOpacityB(double d) throws PDFNetException {
        this.mDict.putNumber("OpacityB", d);
        return this;
    }

    public ColorPt getExtraMoveColor() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ExtraMoveColor");
        if (objFindObj != null && !objFindObj.isNull()) {
            return m1194a(objFindObj.getNumber());
        }
        return m1194a(-69040.0d);
    }

    public TextDiffOptions setExtraMoveColor(ColorPt colorPt) throws PDFNetException {
        this.mDict.putNumber("ExtraMoveColor", m1193a(colorPt));
        return this;
    }

    public double getExtraMoveOpacity() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ExtraMoveOpacity");
        if (objFindObj == null || objFindObj.isNull()) {
            return 0.8d;
        }
        return objFindObj.getNumber();
    }

    public TextDiffOptions setExtraMoveOpacity(double d) throws PDFNetException {
        this.mDict.putNumber("ExtraMoveOpacity", d);
        return this;
    }

    public boolean getCompareUsingZOrder() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("CompareUsingZOrder");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public TextDiffOptions setCompareUsingZOrder(boolean z) throws PDFNetException {
        putBool("CompareUsingZOrder", Boolean.valueOf(z));
        return this;
    }

    public boolean getExtraMoveHighlight() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ExtraMoveHighlight");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public TextDiffOptions setExtraMoveHighlight(boolean z) throws PDFNetException {
        putBool("ExtraMoveHighlight", Boolean.valueOf(z));
        return this;
    }

    public boolean getShowPlaceholders() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ShowPlaceholders");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public TextDiffOptions setShowPlaceholders(boolean z) throws PDFNetException {
        putBool("ShowPlaceholders", Boolean.valueOf(z));
        return this;
    }

    public boolean getCompareStyles() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("CompareStyles");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public TextDiffOptions setCompareStyles(boolean z) throws PDFNetException {
        putBool("CompareStyles", Boolean.valueOf(z));
        return this;
    }

    public TextDiffOptions addIgnoreZonesForPage(RectCollection rectCollection, int i) throws PDFNetException {
        insertRectCollection("IgnoreZones", rectCollection, i - 1);
        return this;
    }
}
