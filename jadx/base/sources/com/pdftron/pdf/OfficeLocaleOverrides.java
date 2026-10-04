package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class OfficeLocaleOverrides extends ConversionOptions {
    public OfficeLocaleOverrides() throws PDFNetException {
    }

    public OfficeLocaleOverrides(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public String getAccountingFormat1() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AccountingFormat1");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setAccountingFormat1(String str) throws PDFNetException {
        putText("AccountingFormat1", str);
        return this;
    }

    public String getAccountingFormat2() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AccountingFormat2");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setAccountingFormat2(String str) throws PDFNetException {
        putText("AccountingFormat2", str);
        return this;
    }

    public String getAccountingFormat3() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AccountingFormat3");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setAccountingFormat3(String str) throws PDFNetException {
        putText("AccountingFormat3", str);
        return this;
    }

    public String getAccountingFormat4() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AccountingFormat4");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setAccountingFormat4(String str) throws PDFNetException {
        putText("AccountingFormat4", str);
        return this;
    }

    public String getAccountingFormat5() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AccountingFormat5");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setAccountingFormat5(String str) throws PDFNetException {
        putText("AccountingFormat5", str);
        return this;
    }

    public String getAccountingFormat6() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AccountingFormat6");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setAccountingFormat6(String str) throws PDFNetException {
        putText("AccountingFormat6", str);
        return this;
    }

    public String getAccountingFormat7() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AccountingFormat7");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setAccountingFormat7(String str) throws PDFNetException {
        putText("AccountingFormat7", str);
        return this;
    }

    public String getAccountingFormat8() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("AccountingFormat8");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setAccountingFormat8(String str) throws PDFNetException {
        putText("AccountingFormat8", str);
        return this;
    }

    public String getCurrencyFormat1() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("CurrencyFormat1");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setCurrencyFormat1(String str) throws PDFNetException {
        putText("CurrencyFormat1", str);
        return this;
    }

    public String getCurrencyFormat2() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("CurrencyFormat2");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setCurrencyFormat2(String str) throws PDFNetException {
        putText("CurrencyFormat2", str);
        return this;
    }

    public String getCurrencyFormat3() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("CurrencyFormat3");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setCurrencyFormat3(String str) throws PDFNetException {
        putText("CurrencyFormat3", str);
        return this;
    }

    public String getCurrencyFormat4() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("CurrencyFormat4");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setCurrencyFormat4(String str) throws PDFNetException {
        putText("CurrencyFormat4", str);
        return this;
    }

    public String getDateFormat1() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DateFormat1");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setDateFormat1(String str) throws PDFNetException {
        putText("DateFormat1", str);
        return this;
    }

    public String getDateFormat2() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DateFormat2");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setDateFormat2(String str) throws PDFNetException {
        putText("DateFormat2", str);
        return this;
    }

    public String getDateFormat3() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DateFormat3");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setDateFormat3(String str) throws PDFNetException {
        putText("DateFormat3", str);
        return this;
    }

    public String getDateFormat4() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DateFormat4");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setDateFormat4(String str) throws PDFNetException {
        putText("DateFormat4", str);
        return this;
    }

    public String getDatetTimeFormat() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("DatetTimeFormat");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setDatetTimeFormat(String str) throws PDFNetException {
        putText("DatetTimeFormat", str);
        return this;
    }

    public String getFixedNumberFormat1() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FixedNumberFormat1");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setFixedNumberFormat1(String str) throws PDFNetException {
        putText("FixedNumberFormat1", str);
        return this;
    }

    public String getFixedNumberFormat2() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FixedNumberFormat2");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setFixedNumberFormat2(String str) throws PDFNetException {
        putText("FixedNumberFormat2", str);
        return this;
    }

    public String getFixedNumberFormat3() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FixedNumberFormat3");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setFixedNumberFormat3(String str) throws PDFNetException {
        putText("FixedNumberFormat3", str);
        return this;
    }

    public String getFixedNumberFormat4() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FixedNumberFormat4");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setFixedNumberFormat4(String str) throws PDFNetException {
        putText("FixedNumberFormat4", str);
        return this;
    }

    public String getFractionNumberFormat1() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FractionNumberFormat1");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setFractionNumberFormat1(String str) throws PDFNetException {
        putText("FractionNumberFormat1", str);
        return this;
    }

    public String getFractionNumberFormat2() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("FractionNumberFormat2");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setFractionNumberFormat2(String str) throws PDFNetException {
        putText("FractionNumberFormat2", str);
        return this;
    }

    public String getPercentageFormat1() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("PercentageFormat1");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setPercentageFormat1(String str) throws PDFNetException {
        putText("PercentageFormat1", str);
        return this;
    }

    public String getPercentageFormat2() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("PercentageFormat2");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setPercentageFormat2(String str) throws PDFNetException {
        putText("PercentageFormat2", str);
        return this;
    }

    public String getScientificNumberFormat1() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ScientificNumberFormat1");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setScientificNumberFormat1(String str) throws PDFNetException {
        putText("ScientificNumberFormat1", str);
        return this;
    }

    public String getScientificNumberFormat2() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ScientificNumberFormat2");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setScientificNumberFormat2(String str) throws PDFNetException {
        putText("ScientificNumberFormat2", str);
        return this;
    }

    public String getTextFormat() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TextFormat");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setTextFormat(String str) throws PDFNetException {
        putText("TextFormat", str);
        return this;
    }

    public String getTimeFormat1() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TimeFormat1");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setTimeFormat1(String str) throws PDFNetException {
        putText("TimeFormat1", str);
        return this;
    }

    public String getTimeFormat2() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TimeFormat2");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setTimeFormat2(String str) throws PDFNetException {
        putText("TimeFormat2", str);
        return this;
    }

    public String getTimeFormat3() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TimeFormat3");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setTimeFormat3(String str) throws PDFNetException {
        putText("TimeFormat3", str);
        return this;
    }

    public String getTimeFormat4() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TimeFormat4");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setTimeFormat4(String str) throws PDFNetException {
        putText("TimeFormat4", str);
        return this;
    }

    public String getTimeSpanFormat1() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TimeSpanFormat1");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setTimeSpanFormat1(String str) throws PDFNetException {
        putText("TimeSpanFormat1", str);
        return this;
    }

    public String getTimeSpanFormat2() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TimeSpanFormat2");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setTimeSpanFormat2(String str) throws PDFNetException {
        putText("TimeSpanFormat2", str);
        return this;
    }

    public String getTimeSpanFormat3() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("TimeSpanFormat3");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public OfficeLocaleOverrides setTimeSpanFormat3(String str) throws PDFNetException {
        putText("TimeSpanFormat3", str);
        return this;
    }
}
