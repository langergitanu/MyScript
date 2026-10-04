package com.pdftron.pdf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Bookmark {

    /* JADX INFO: renamed from: a */
    long f1449a;

    /* JADX INFO: renamed from: b */
    private Object f1450b;

    static native long AddChild(long j, String str);

    static native void AddChild(long j, long j2);

    static native long AddNext(long j, String str);

    static native void AddNext(long j, long j2);

    static native long AddPrev(long j, String str);

    static native void AddPrev(long j, long j2);

    static native long Create(long j, String str);

    static native void Delete(long j);

    static native long Find(long j, String str);

    static native long GetAction(long j);

    static native double[] GetColor(long j);

    static native long GetFirstChild(long j);

    static native int GetFlags(long j);

    static native int GetIndent(long j);

    static native long GetLastChild(long j);

    static native long GetNext(long j);

    static native int GetOpenCount(long j);

    static native long GetParent(long j);

    static native long GetPrev(long j);

    static native String GetTitle(long j);

    static native long GetTitleObj(long j);

    static native boolean HasChildren(long j);

    static native boolean IsOpen(long j);

    static native boolean IsValid(long j);

    static native void RemoveAction(long j);

    static native void SetAction(long j, long j2);

    static native void SetColor(long j, double d, double d2, double d3);

    static native void SetFlags(long j, int i);

    static native void SetOpen(long j, boolean z);

    static native void SetTitle(long j, String str);

    static native void Unlink(long j);

    public static Bookmark create(PDFDoc pDFDoc, String str) throws PDFNetException {
        Bookmark bookmark = new Bookmark(Create(pDFDoc.__GetHandle(), str), pDFDoc);
        ReachabilityHelper.ensureReachable(pDFDoc);
        return bookmark;
    }

    public Bookmark() {
        this.f1449a = 0L;
        this.f1450b = null;
    }

    public Bookmark(Obj obj) {
        this.f1449a = obj.__GetHandle();
        this.f1450b = obj.__GetRefHandle();
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(getClass()) && ((Bookmark) obj).f1449a == this.f1449a;
    }

    public int hashCode() {
        return (int) this.f1449a;
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1449a);
    }

    public boolean hasChildren() throws PDFNetException {
        return HasChildren(this.f1449a);
    }

    public Bookmark getNext() throws PDFNetException {
        return new Bookmark(GetNext(this.f1449a), this.f1450b);
    }

    public Bookmark getPrev() throws PDFNetException {
        return new Bookmark(GetPrev(this.f1449a), this.f1450b);
    }

    public Bookmark getFirstChild() throws PDFNetException {
        return new Bookmark(GetFirstChild(this.f1449a), this.f1450b);
    }

    public Bookmark getLastChild() throws PDFNetException {
        return new Bookmark(GetLastChild(this.f1449a), this.f1450b);
    }

    public Bookmark getParent() throws PDFNetException {
        return new Bookmark(GetParent(this.f1449a), this.f1450b);
    }

    public Bookmark find(String str) throws PDFNetException {
        return new Bookmark(Find(this.f1449a, str), this.f1450b);
    }

    public Bookmark addChild(String str) throws PDFNetException {
        return new Bookmark(AddChild(this.f1449a, str), this.f1450b);
    }

    public void addChild(Bookmark bookmark) throws PDFNetException {
        AddChild(this.f1449a, bookmark.f1449a);
        ReachabilityHelper.ensureReachable(bookmark);
    }

    public Bookmark addNext(String str) throws PDFNetException {
        return new Bookmark(AddNext(this.f1449a, str), this.f1450b);
    }

    public void addNext(Bookmark bookmark) throws PDFNetException {
        AddNext(this.f1449a, bookmark.f1449a);
        ReachabilityHelper.ensureReachable(bookmark);
    }

    public Bookmark addPrev(String str) throws PDFNetException {
        return new Bookmark(AddPrev(this.f1449a, str), this.f1450b);
    }

    public void addPrev(Bookmark bookmark) throws PDFNetException {
        AddPrev(this.f1449a, bookmark.f1449a);
        ReachabilityHelper.ensureReachable(bookmark);
    }

    public void delete() throws PDFNetException {
        Delete(this.f1449a);
    }

    public void unlink() throws PDFNetException {
        Unlink(this.f1449a);
    }

    public int getIndent() throws PDFNetException {
        return GetIndent(this.f1449a);
    }

    public boolean isOpen() throws PDFNetException {
        return IsOpen(this.f1449a);
    }

    public void setOpen(boolean z) throws PDFNetException {
        SetOpen(this.f1449a, z);
    }

    public int getOpenCount() throws PDFNetException {
        return GetOpenCount(this.f1449a);
    }

    public String getTitle() throws PDFNetException {
        return GetTitle(this.f1449a);
    }

    public Obj getTitleObj() throws PDFNetException {
        return Obj.__Create(GetTitleObj(this.f1449a), this.f1450b);
    }

    public void setTitle(String str) throws PDFNetException {
        SetTitle(this.f1449a, str);
    }

    public Action getAction() throws PDFNetException {
        return new Action(GetAction(this.f1449a), this.f1450b);
    }

    public void setAction(Action action) throws PDFNetException {
        SetAction(this.f1449a, action.f1435a);
        ReachabilityHelper.ensureReachable(action);
    }

    public void removeAction() throws PDFNetException {
        RemoveAction(this.f1449a);
    }

    public int getFlags() throws PDFNetException {
        return GetFlags(this.f1449a);
    }

    public void setFlags(int i) throws PDFNetException {
        SetFlags(this.f1449a, i);
    }

    public double[] getColor() throws PDFNetException {
        return GetColor(this.f1449a);
    }

    public void setColor() throws PDFNetException {
        SetColor(this.f1449a, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public void setColor(double d, double d2, double d3) throws PDFNetException {
        SetColor(this.f1449a, d, d2, d3);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f1449a, this.f1450b);
    }

    Bookmark(long j, Object obj) {
        this.f1449a = j;
        this.f1450b = obj;
    }
}
