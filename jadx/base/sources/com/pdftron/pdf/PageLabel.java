package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PageLabel implements AutoCloseable {
    public static final int e_alphabetic_lowercase = 4;
    public static final int e_alphabetic_uppercase = 3;
    public static final int e_decimal = 0;
    public static final int e_none = 5;
    public static final int e_roman_lowercase = 2;
    public static final int e_roman_uppercase = 1;

    /* JADX INFO: renamed from: a */
    long f1993a;

    /* JADX INFO: renamed from: b */
    private Object f1994b;

    static native long Create(long j, int i, String str, int i2);

    static native void Destroy(long j);

    static native boolean Equals(long j, long j2);

    static native int GetFirstPageNum(long j);

    static native String GetLabelTitle(long j, int i);

    static native int GetLastPageNum(long j);

    static native String GetPrefix(long j);

    static native long GetSDFObj(long j);

    static native int GetStart(long j);

    static native int GetStyle(long j);

    static native int HashCode(long j);

    static native boolean IsValid(long j);

    static native long PageLabelCreate(long j, int i, int i2);

    static native void SetPrefix(long j, String str);

    static native void SetStart(long j, int i);

    static native void SetStyle(long j, int i);

    public static PageLabel create(Doc doc, int i) throws PDFNetException {
        return new PageLabel(Create(doc.__GetHandle(), i, "", 1), doc);
    }

    public static PageLabel create(Doc doc, int i, String str) throws PDFNetException {
        return new PageLabel(Create(doc.__GetHandle(), i, str, 1), doc);
    }

    public static PageLabel create(Doc doc, int i, String str, int i2) throws PDFNetException {
        return new PageLabel(Create(doc.__GetHandle(), i, str, i2), doc);
    }

    public PageLabel() throws PDFNetException {
        this.f1993a = PageLabelCreate(0L, -1, -1);
    }

    public PageLabel(Obj obj) throws PDFNetException {
        this.f1993a = PageLabelCreate(obj.__GetHandle(), -1, -1);
        ReachabilityHelper.ensureReachable(obj);
    }

    public PageLabel(Obj obj, int i) throws PDFNetException {
        this.f1993a = PageLabelCreate(obj.__GetHandle(), i, -1);
        ReachabilityHelper.ensureReachable(obj);
    }

    public PageLabel(Obj obj, int i, int i2) throws PDFNetException {
        this.f1993a = PageLabelCreate(obj.__GetHandle(), i, i2);
        ReachabilityHelper.ensureReachable(obj);
    }

    public void destroy() throws PDFNetException {
        long j = this.f1993a;
        if (j != 0) {
            Destroy(j);
            this.f1993a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        boolean zEquals = Equals(this.f1993a, ((PageLabel) obj).f1993a);
        ReachabilityHelper.ensureReachable(obj);
        return zEquals;
    }

    public int hashCode() {
        return HashCode(this.f1993a);
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1993a);
    }

    public String getLabelTitle(int i) throws PDFNetException {
        return GetLabelTitle(this.f1993a, i);
    }

    public void setStyle(int i) throws PDFNetException {
        SetStyle(this.f1993a, i);
    }

    public int getStyle() throws PDFNetException {
        return GetStyle(this.f1993a);
    }

    public String getPrefix() throws PDFNetException {
        return GetPrefix(this.f1993a);
    }

    public void setPrefix(String str) throws PDFNetException {
        SetPrefix(this.f1993a, str);
    }

    public int getStart() throws PDFNetException {
        return GetStart(this.f1993a);
    }

    public void setStart(int i) throws PDFNetException {
        SetStart(this.f1993a, i);
    }

    public int getFirstPageNum() throws PDFNetException {
        return GetFirstPageNum(this.f1993a);
    }

    public int getLastPageNum() throws PDFNetException {
        return GetLastPageNum(this.f1993a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.f1993a), this.f1994b);
    }

    PageLabel(long j, Object obj) {
        this.f1993a = j;
        this.f1994b = obj;
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        destroy();
    }
}
