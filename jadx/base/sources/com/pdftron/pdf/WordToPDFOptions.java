package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class WordToPDFOptions extends ConversionOptions {
    public WordToPDFOptions() throws PDFNetException {
    }

    public WordToPDFOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public String getLayoutResourcesPluginPath() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("LayoutResourcesPluginPath");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public WordToPDFOptions setLayoutResourcesPluginPath(String str) throws PDFNetException {
        this.mDict.putString("LayoutResourcesPluginPath", str);
        return this;
    }

    public String getResourceDocPath() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ResourceDocPath");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public WordToPDFOptions setResourceDocPath(String str) throws PDFNetException {
        this.mDict.putString("ResourceDocPath", str);
        return this;
    }

    public String getSmartSubstitutionPluginPath() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("SmartSubstitutionPluginPath");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public WordToPDFOptions setSmartSubstitutionPluginPath(String str) throws PDFNetException {
        this.mDict.putString("SmartSubstitutionPluginPath", str);
        return this;
    }
}
