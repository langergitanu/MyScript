package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class AdvancedImagingConvertOptions extends OptionsBase {
    public AdvancedImagingConvertOptions() throws PDFNetException {
    }

    public AdvancedImagingConvertOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public double getDefaultDPI() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Default-dpi");
        if (objFindObj == null || objFindObj.isNull()) {
            return 72.0d;
        }
        return objFindObj.getNumber();
    }

    public AdvancedImagingConvertOptions setDefaultDPI(double d) throws PDFNetException {
        putNumber("Default-dpi", d);
        return this;
    }
}
