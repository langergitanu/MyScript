package com.pdftron.pdf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class SVGConvertOptions extends OptionsBase {
    public SVGConvertOptions() throws PDFNetException {
    }

    public SVGConvertOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getConvertLinks() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ConvertLinks");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public SVGConvertOptions setConvertLinks(boolean z) throws PDFNetException {
        putBool("ConvertLinks", Boolean.valueOf(z));
        return this;
    }

    public String getDefaultFontFamily() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DefaultFontFamily");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public SVGConvertOptions setDefaultFontFamily(String str) throws PDFNetException {
        putText("DefaultFontFamily", str);
        return this;
    }

    public String getFallbackFontFamily() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FallbackFontFamily");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public SVGConvertOptions setFallbackFontFamily(String str) throws PDFNetException {
        putText("FallbackFontFamily", str);
        return this;
    }

    public double getFallbackHeight() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FallbackHeight");
        return (objFindObj == null || objFindObj.isNull()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : objFindObj.getNumber();
    }

    public SVGConvertOptions setFallbackHeight(double d) throws PDFNetException {
        putNumber("FallbackHeight", d);
        return this;
    }

    public double getFallbackWidth() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FallbackWidth");
        return (objFindObj == null || objFindObj.isNull()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : objFindObj.getNumber();
    }

    public SVGConvertOptions setFallbackWidth(double d) throws PDFNetException {
        putNumber("FallbackWidth", d);
        return this;
    }

    public boolean getForceSRGB() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ForceSRGB");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public SVGConvertOptions setForceSRGB(boolean z) throws PDFNetException {
        putBool("ForceSRGB", Boolean.valueOf(z));
        return this;
    }

    public double getForcedHeight() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ForcedHeight");
        return (objFindObj == null || objFindObj.isNull()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : objFindObj.getNumber();
    }

    public SVGConvertOptions setForcedHeight(double d) throws PDFNetException {
        putNumber("ForcedHeight", d);
        return this;
    }

    public double getForcedWidth() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ForcedWidth");
        return (objFindObj == null || objFindObj.isNull()) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : objFindObj.getNumber();
    }

    public SVGConvertOptions setForcedWidth(double d) throws PDFNetException {
        putNumber("ForcedWidth", d);
        return this;
    }

    public boolean getHonorIccProfile() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("HonorIccProfile");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public SVGConvertOptions setHonorIccProfile(boolean z) throws PDFNetException {
        putBool("HonorIccProfile", Boolean.valueOf(z));
        return this;
    }

    public boolean getInline() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Inline");
        if (objFindObj == null || objFindObj.isNull()) {
            return true;
        }
        return objFindObj.getBool();
    }

    public SVGConvertOptions setInline(boolean z) throws PDFNetException {
        putBool("Inline", Boolean.valueOf(z));
        return this;
    }

    public String getLang() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Lang");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public SVGConvertOptions setLang(String str) throws PDFNetException {
        putText("Lang", str);
        return this;
    }
}
