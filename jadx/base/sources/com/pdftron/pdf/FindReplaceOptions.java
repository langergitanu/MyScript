package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class FindReplaceOptions extends OptionsBase {

    public enum HorizAlignment {
        e_left(1),
        e_center(2),
        e_right(3),
        e_full(4);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, HorizAlignment> f1546b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1548a;

        static {
            for (HorizAlignment horizAlignment : values()) {
                f1546b.put(Integer.valueOf(horizAlignment.f1548a), horizAlignment);
            }
        }

        HorizAlignment(int i) {
            this.f1548a = i;
        }

        /* JADX INFO: renamed from: a */
        static HorizAlignment m1156a(int i) {
            return f1546b.get(Integer.valueOf(i));
        }
    }

    public enum ReflowType {
        e_text(1),
        e_line(2),
        e_para(3);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, ReflowType> f1552b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1554a;

        static {
            for (ReflowType reflowType : values()) {
                f1552b.put(Integer.valueOf(reflowType.f1554a), reflowType);
            }
        }

        ReflowType(int i) {
            this.f1554a = i;
        }

        /* JADX INFO: renamed from: a */
        static ReflowType m1158a(int i) {
            return f1552b.get(Integer.valueOf(i));
        }
    }

    public enum MatchType {
        e_exact(1),
        e_wildcards(2),
        e_regex(3);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, MatchType> f1549b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        final int f1551a;

        static {
            for (MatchType matchType : values()) {
                f1549b.put(Integer.valueOf(matchType.f1551a), matchType);
            }
        }

        MatchType(int i) {
            this.f1551a = i;
        }

        /* JADX INFO: renamed from: a */
        static MatchType m1157a(int i) {
            return f1549b.get(Integer.valueOf(i));
        }
    }

    public FindReplaceOptions() throws PDFNetException {
    }

    public FindReplaceOptions(String str) throws PDFNetException {
        super(str);
    }

    @Override // com.pdftron.pdf.OptionsBase
    /* JADX INFO: renamed from: a */
    final long mo1134a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public HorizAlignment getAlignment() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Alignment");
        if (objFindObj != null && !objFindObj.isNull()) {
            return HorizAlignment.m1156a((int) objFindObj.getNumber());
        }
        return HorizAlignment.m1156a(1);
    }

    public FindReplaceOptions setAlignment(HorizAlignment horizAlignment) throws PDFNetException {
        putNumber("Alignment", horizAlignment.f1548a);
        return this;
    }

    public int getBatchSize() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("BatchSize");
        if (objFindObj == null || objFindObj.isNull()) {
            return 20;
        }
        return (int) objFindObj.getNumber();
    }

    public FindReplaceOptions setBatchSize(int i) throws PDFNetException {
        putNumber("BatchSize", i);
        return this;
    }

    public boolean getMatchCase() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("MatchCase");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public FindReplaceOptions setMatchCase(boolean z) throws PDFNetException {
        putBool("MatchCase", Boolean.valueOf(z));
        return this;
    }

    public MatchType getMatchMode() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("MatchMode");
        if (objFindObj != null && !objFindObj.isNull()) {
            return MatchType.m1157a((int) objFindObj.getNumber());
        }
        return MatchType.m1157a(1);
    }

    public FindReplaceOptions setMatchMode(MatchType matchType) throws PDFNetException {
        putNumber("MatchMode", matchType.f1551a);
        return this;
    }

    public String getPages() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("Pages");
        if (objFindObj != null && !objFindObj.isNull()) {
            return objFindObj.getAsPDFText();
        }
        return "";
    }

    public FindReplaceOptions setPages(String str) throws PDFNetException {
        putText("Pages", str);
        return this;
    }

    public ReflowType getReflowMode() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("ReflowMode");
        if (objFindObj != null && !objFindObj.isNull()) {
            return ReflowType.m1158a((int) objFindObj.getNumber());
        }
        return ReflowType.m1158a(3);
    }

    public FindReplaceOptions setReflowMode(ReflowType reflowType) throws PDFNetException {
        putNumber("ReflowMode", reflowType.f1554a);
        return this;
    }

    public boolean getWholeWords() throws PDFNetException {
        Obj objFindObj = this.mDict.findObj("WholeWords");
        if (objFindObj == null || objFindObj.isNull()) {
            return false;
        }
        return objFindObj.getBool();
    }

    public FindReplaceOptions setWholeWords(boolean z) throws PDFNetException {
        putBool("WholeWords", Boolean.valueOf(z));
        return this;
    }
}
