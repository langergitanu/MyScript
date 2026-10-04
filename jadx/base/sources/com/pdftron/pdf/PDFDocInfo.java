package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class PDFDocInfo {

    /* JADX INFO: renamed from: a */
    private long f1625a;

    /* JADX INFO: renamed from: b */
    private Object f1626b;

    static native String GetAuthor(long j);

    static native long GetAuthorObj(long j);

    static native long GetCreationDate(long j);

    static native String GetCreator(long j);

    static native long GetCreatorObj(long j);

    static native String GetKeywords(long j);

    static native long GetKeywordsObj(long j);

    static native long GetModDate(long j);

    static native String GetProducer(long j);

    static native long GetProducerObj(long j);

    static native String GetSubject(long j);

    static native long GetSubjectObj(long j);

    static native String GetTitle(long j);

    static native long GetTitleObj(long j);

    static native void SetAuthor(long j, String str);

    static native void SetCreationDate(long j, long j2);

    static native void SetCreator(long j, String str);

    static native void SetKeywords(long j, String str);

    static native void SetModDate(long j, long j2);

    static native void SetProducer(long j, String str);

    static native void SetSubject(long j, String str);

    static native void SetTitle(long j, String str);

    public String getTitle() throws PDFNetException {
        return GetTitle(this.f1625a);
    }

    public Obj getTitleObj() throws PDFNetException {
        return Obj.__Create(GetTitleObj(this.f1625a), this.f1626b);
    }

    public void setTitle(String str) throws PDFNetException {
        SetTitle(this.f1625a, str);
    }

    public String getAuthor() throws PDFNetException {
        return GetAuthor(this.f1625a);
    }

    public Obj getAuthorObj() throws PDFNetException {
        return Obj.__Create(GetAuthorObj(this.f1625a), this.f1626b);
    }

    public void setAuthor(String str) throws PDFNetException {
        SetAuthor(this.f1625a, str);
    }

    public String getSubject() throws PDFNetException {
        return GetSubject(this.f1625a);
    }

    public Obj getSubjectObj() throws PDFNetException {
        return Obj.__Create(GetSubjectObj(this.f1625a), this.f1626b);
    }

    public void setSubject(String str) throws PDFNetException {
        SetSubject(this.f1625a, str);
    }

    public String getKeywords() throws PDFNetException {
        return GetKeywords(this.f1625a);
    }

    public Obj getKeywordsObj() throws PDFNetException {
        return Obj.__Create(GetKeywordsObj(this.f1625a), this.f1626b);
    }

    public void setKeywords(String str) throws PDFNetException {
        SetKeywords(this.f1625a, str);
    }

    public String getCreator() throws PDFNetException {
        return GetCreator(this.f1625a);
    }

    public Obj getCreatorObj() throws PDFNetException {
        return Obj.__Create(GetCreatorObj(this.f1625a), this.f1626b);
    }

    public void setCreator(String str) throws PDFNetException {
        SetCreator(this.f1625a, str);
    }

    public String getProducer() throws PDFNetException {
        return GetProducer(this.f1625a);
    }

    public Obj getProducerObj() throws PDFNetException {
        return Obj.__Create(GetProducerObj(this.f1625a), this.f1626b);
    }

    public void setProducer(String str) throws PDFNetException {
        SetProducer(this.f1625a, str);
    }

    public Date getCreationDate() throws PDFNetException {
        return new Date(GetCreationDate(this.f1625a));
    }

    public void setCreationDate(Date date) throws PDFNetException {
        SetCreationDate(this.f1625a, date.f1515a);
        ReachabilityHelper.ensureReachable(date);
    }

    public Date getModDate() throws PDFNetException {
        return new Date(GetModDate(this.f1625a));
    }

    public void setModDate(Date date) throws PDFNetException {
        SetModDate(this.f1625a, date.f1515a);
        ReachabilityHelper.ensureReachable(date);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f1625a, this.f1626b);
    }

    public PDFDocInfo(Obj obj) {
        this.f1625a = obj.__GetHandle();
        this.f1626b = obj.__GetRefHandle();
    }

    PDFDocInfo(long j, Object obj) {
        this.f1625a = j;
        this.f1626b = obj;
    }
}
