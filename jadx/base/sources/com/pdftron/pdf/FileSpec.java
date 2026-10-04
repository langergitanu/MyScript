package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class FileSpec {

    /* JADX INFO: renamed from: a */
    long f1544a;

    /* JADX INFO: renamed from: b */
    Object f1545b;

    static native long Create(long j, String str, boolean z);

    static native long CreateURL(long j, String str);

    static native boolean Export(long j, String str);

    static native long GetFileData(long j);

    static native String GetFilePath(long j);

    static native boolean IsValid(long j);

    static native void SetDesc(long j, String str);

    public static FileSpec create(Doc doc, String str) throws PDFNetException {
        FileSpec fileSpec = new FileSpec(Create(doc.__GetHandle(), str, true), doc);
        ReachabilityHelper.ensureReachable(doc);
        return fileSpec;
    }

    public static FileSpec create(Doc doc, String str, boolean z) throws PDFNetException {
        FileSpec fileSpec = new FileSpec(Create(doc.__GetHandle(), str, z), doc);
        ReachabilityHelper.ensureReachable(doc);
        return fileSpec;
    }

    public static FileSpec createURL(Doc doc, String str) throws PDFNetException {
        FileSpec fileSpec = new FileSpec(CreateURL(doc.__GetHandle(), str), doc);
        ReachabilityHelper.ensureReachable(doc);
        return fileSpec;
    }

    public FileSpec(Obj obj) {
        this.f1544a = obj.__GetHandle();
        this.f1545b = obj.__GetRefHandle();
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(getClass()) && this.f1544a == ((FileSpec) obj).f1544a;
    }

    public int hashCode() {
        return (int) this.f1544a;
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1544a);
    }

    public boolean export() throws PDFNetException {
        return Export(this.f1544a, "");
    }

    public boolean export(String str) throws PDFNetException {
        return Export(this.f1544a, str);
    }

    public Filter getFileData() throws PDFNetException {
        return Filter.__Create(GetFileData(this.f1544a), null);
    }

    public String getFilePath() throws PDFNetException {
        return GetFilePath(this.f1544a);
    }

    public void setDesc(String str) throws PDFNetException {
        SetDesc(this.f1544a, str);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f1544a, this.f1545b);
    }

    private FileSpec(long j, Object obj) {
        this.f1544a = j;
        this.f1545b = obj;
    }

    public static FileSpec __Create(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new FileSpec(j, obj);
    }

    public long __GetHandle() {
        return this.f1544a;
    }

    public Object __GetRefHandle() {
        return this.f1545b;
    }
}
