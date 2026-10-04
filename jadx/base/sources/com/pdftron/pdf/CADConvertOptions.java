package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class CADConvertOptions extends OptionsBase {

    public enum LayoutSortOrder {
        e_default_order(0),
        e_alphabetic_order(1),
        e_alphanumeric_order(2);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, LayoutSortOrder> f1451b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1453a;

        static {
            for (LayoutSortOrder layoutSortOrder : values()) {
                f1451b.put(Integer.valueOf(layoutSortOrder.f1453a), layoutSortOrder);
            }
        }

        LayoutSortOrder(int i) {
            this.f1453a = i;
        }

        /* JADX INFO: renamed from: a */
        static LayoutSortOrder m1137a(int i) {
            return f1451b.get(Integer.valueOf(i));
        }
    }

    public CADConvertOptions() throws PDFNetException {
    }

    public CADConvertOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getAllowThinLines() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Thin-lines");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public CADConvertOptions setAllowThinLines(boolean z) throws PDFNetException {
        putBool("Thin-lines", Boolean.valueOf(z));
        return this;
    }

    public boolean getAutoRotate() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Auto-rotate");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public CADConvertOptions setAutoRotate(boolean z) throws PDFNetException {
        putBool("Auto-rotate", Boolean.valueOf(z));
        return this;
    }

    public ColorPt getBackgroundColor() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Background-color");
        if (objFindObj != null && !objFindObj.isNull()) {
            return m1194a(objFindObj.getNumber());
        }
        return m1194a(-1.0d);
    }

    public CADConvertOptions setBackgroundColor(ColorPt colorPt) throws PDFNetException {
        putNumber("Background-color", m1193a(colorPt));
        return this;
    }

    public String getColorMode() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ColorMode");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "Original";
    }

    public CADConvertOptions setColorMode(String str) throws PDFNetException {
        putText("ColorMode", str);
        return this;
    }

    public boolean getIncludeInvisibleLayers() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Include-invisible-layers");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public CADConvertOptions setIncludeInvisibleLayers(boolean z) throws PDFNetException {
        putBool("Include-invisible-layers", Boolean.valueOf(z));
        return this;
    }

    public boolean getIncludeModel() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("IncludeModel");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public CADConvertOptions setIncludeModel(boolean z) throws PDFNetException {
        putBool("IncludeModel", Boolean.valueOf(z));
        return this;
    }

    public boolean getIncludeNonPlottableLayers() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Include-non-plottable-layers");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public CADConvertOptions setIncludeNonPlottableLayers(boolean z) throws PDFNetException {
        putBool("Include-non-plottable-layers", Boolean.valueOf(z));
        return this;
    }

    public LayoutSortOrder getLayoutSortOrder() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("LayoutSortOrder");
        if (objFindObj != null && !objFindObj.isNull()) {
            return LayoutSortOrder.m1137a((int) objFindObj.getNumber());
        }
        return LayoutSortOrder.m1137a(0);
    }

    public CADConvertOptions setLayoutSortOrder(LayoutSortOrder layoutSortOrder) throws PDFNetException {
        putNumber("LayoutSortOrder", layoutSortOrder.f1453a);
        return this;
    }

    public int getMaxXrefDepth() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("XRef-depth");
        if (objFindObj == null || objFindObj.isNull()) {
            return 1000;
        }
        return (int) objFindObj.getNumber();
    }

    public CADConvertOptions setMaxXrefDepth(int i) throws PDFNetException {
        putNumber("XRef-depth", i);
        return this;
    }

    public double getPageHeight() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Page-height");
        if (objFindObj == null || objFindObj.isNull()) {
            return 594.0d;
        }
        return objFindObj.getNumber();
    }

    public CADConvertOptions setPageHeight(double d) throws PDFNetException {
        putNumber("Page-height", d);
        return this;
    }

    public double getPageWidth() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Page-width");
        if (objFindObj == null || objFindObj.isNull()) {
            return 840.0d;
        }
        return objFindObj.getNumber();
    }

    public CADConvertOptions setPageWidth(double d) throws PDFNetException {
        putNumber("Page-width", d);
        return this;
    }

    public double getRasterDPI() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Raster-dpi");
        if (objFindObj == null || objFindObj.isNull()) {
            return 72.0d;
        }
        return objFindObj.getNumber();
    }

    public CADConvertOptions setRasterDPI(double d) throws PDFNetException {
        putNumber("Raster-dpi", d);
        return this;
    }

    public CADConvertOptions addSheets(String str) throws PDFNetException {
        pushBackText("Sheets", str);
        return this;
    }

    public boolean getUnderlineTextDataFields() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Underline-text-data-fields");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public CADConvertOptions setUnderlineTextDataFields(boolean z) throws PDFNetException {
        putBool("Underline-text-data-fields", Boolean.valueOf(z));
        return this;
    }

    public boolean getUseScaleFromDocument() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("UseScaleFromDocument");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public CADConvertOptions setUseScaleFromDocument(boolean z) throws PDFNetException {
        putBool("UseScaleFromDocument", Boolean.valueOf(z));
        return this;
    }

    public boolean getZoomToExtents() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ZoomToExtents");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public CADConvertOptions setZoomToExtents(boolean z) throws PDFNetException {
        putBool("ZoomToExtents", Boolean.valueOf(z));
        return this;
    }
}
