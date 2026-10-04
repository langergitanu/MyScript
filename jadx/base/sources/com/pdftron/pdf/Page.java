package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Page {
    public static final int e_0 = 0;
    public static final int e_180 = 2;
    public static final int e_270 = 3;
    public static final int e_90 = 1;
    public static final int e_action_trigger_page_close = 12;
    public static final int e_action_trigger_page_open = 11;
    public static final int e_art = 4;
    public static final int e_bleed = 2;
    public static final int e_crop = 1;
    public static final int e_media = 0;
    public static final int e_trim = 3;
    public static final int e_user_crop = 5;

    /* JADX INFO: renamed from: a */
    long f1990a;

    /* JADX INFO: renamed from: b */
    Object f1991b;

    static native int AddRotations(int i, int i2);

    static native void AnnotInsert(long j, int i, long j2);

    static native void AnnotInsertWithTagging(long j, int i, long j2, long j3, long j4);

    static native void AnnotPushBack(long j, long j2);

    static native void AnnotPushFront(long j, long j2);

    static native void AnnotRemove(long j, int i);

    static native void AnnotRemove(long j, long j2);

    static native int DegreeToRotation(int i);

    static native void FlattenField(long j, long j2);

    static native long GetAnnot(long j, int i);

    static native long GetAnnots(long j);

    static native long GetBox(long j, int i);

    static native long GetContents(long j);

    static native long GetCropBox(long j);

    static native long GetDefaultMatrix(long j, boolean z, int i, int i2);

    static native int GetIndex(long j);

    static native long GetMediaBox(long j);

    static native int GetNumAnnots(long j);

    static native double GetPageHeight(long j, int i);

    static native double GetPageWidth(long j, int i);

    static native long GetResourceDict(long j);

    static native int GetRotation(long j);

    static native long GetThumb(long j);

    static native int[] GetThumbInfo(long j);

    static native long GetTriggerAction(long j, int i);

    static native double GetUserUnitSize(long j);

    static native long GetVisibleContentBox(long j);

    static native boolean HasTransition(long j);

    static native boolean IsValid(long j);

    static native int RotationToDegree(int i);

    static native void Scale(long j, double d);

    static native void SetBox(long j, int i, long j2);

    static native void SetCropBox(long j, long j2);

    static native void SetMediaBox(long j, long j2);

    static native void SetRotation(long j, int i);

    static native void SetUserUnitSize(long j, double d);

    static native int SubtractRotations(int i, int i2);

    public Page() {
        this.f1990a = 0L;
    }

    public Page(Obj obj) {
        this.f1990a = obj.__GetHandle();
        this.f1991b = obj.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1990a);
    }

    public int getIndex() throws PDFNetException {
        return GetIndex(this.f1990a);
    }

    public Obj getTriggerAction(int i) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.f1990a, i), this.f1991b);
    }

    public Rect getBox(int i) throws PDFNetException {
        return new Rect(GetBox(this.f1990a, i));
    }

    public void setBox(int i, Rect rect) throws PDFNetException {
        SetBox(this.f1990a, i, rect.f2037a);
        ReachabilityHelper.ensureReachable(rect);
    }

    public Rect getCropBox() throws PDFNetException {
        return new Rect(GetCropBox(this.f1990a));
    }

    public void setCropBox(Rect rect) throws PDFNetException {
        SetCropBox(this.f1990a, rect.f2037a);
        ReachabilityHelper.ensureReachable(rect);
    }

    public Rect getMediaBox() throws PDFNetException {
        return new Rect(GetMediaBox(this.f1990a));
    }

    public void setMediaBox(Rect rect) throws PDFNetException {
        SetMediaBox(this.f1990a, rect.f2037a);
        ReachabilityHelper.ensureReachable(rect);
    }

    public Rect getVisibleContentBox() throws PDFNetException {
        return new Rect(GetVisibleContentBox(this.f1990a));
    }

    public static int addRotations(int i, int i2) throws PDFNetException {
        return AddRotations(i, i2);
    }

    public static int subtractRotations(int i, int i2) throws PDFNetException {
        return SubtractRotations(i, i2);
    }

    public static int rotationToDegree(int i) throws PDFNetException {
        return RotationToDegree(i);
    }

    public static int degreeToRotation(int i) throws PDFNetException {
        return DegreeToRotation(i);
    }

    public int getRotation() throws PDFNetException {
        return GetRotation(this.f1990a);
    }

    public void setRotation(int i) throws PDFNetException {
        SetRotation(this.f1990a, i);
    }

    public double getPageWidth() throws PDFNetException {
        return GetPageWidth(this.f1990a, 1);
    }

    public double getPageWidth(int i) throws PDFNetException {
        return GetPageWidth(this.f1990a, i);
    }

    public double getPageHeight() throws PDFNetException {
        return GetPageHeight(this.f1990a, 1);
    }

    public double getPageHeight(int i) throws PDFNetException {
        return GetPageHeight(this.f1990a, i);
    }

    public Matrix2D getDefaultMatrix() throws PDFNetException {
        return Matrix2D.__Create(GetDefaultMatrix(this.f1990a, false, 1, 0));
    }

    public Matrix2D getDefaultMatrix(boolean z, int i, int i2) throws PDFNetException {
        return Matrix2D.__Create(GetDefaultMatrix(this.f1990a, z, i, i2));
    }

    public Obj getAnnots() throws PDFNetException {
        return Obj.__Create(GetAnnots(this.f1990a), this.f1991b);
    }

    public int getNumAnnots() throws PDFNetException {
        return GetNumAnnots(this.f1990a);
    }

    public Annot getAnnot(int i) throws PDFNetException {
        return new Annot(GetAnnot(this.f1990a, i), this.f1991b);
    }

    public void annotInsert(int i, Annot annot) throws PDFNetException {
        AnnotInsert(this.f1990a, i, annot.f1439a);
        ReachabilityHelper.ensureReachable(annot);
    }

    public void annotInsertWithTagging(int i, Annot annot, Obj obj, TaggingOptions taggingOptions) throws PDFNetException {
        AnnotInsertWithTagging(this.f1990a, i, annot.f1439a, obj.__GetHandle(), taggingOptions.mo1134a());
    }

    public void annotPushBack(Annot annot) throws PDFNetException {
        AnnotPushBack(this.f1990a, annot.f1439a);
        ReachabilityHelper.ensureReachable(annot);
    }

    public void annotPushFront(Annot annot) throws PDFNetException {
        AnnotPushFront(this.f1990a, annot.f1439a);
        ReachabilityHelper.ensureReachable(annot);
    }

    public void annotRemove(Annot annot) throws PDFNetException {
        AnnotRemove(this.f1990a, annot.f1439a);
        ReachabilityHelper.ensureReachable(annot);
    }

    public void annotRemove(int i) throws PDFNetException {
        AnnotRemove(this.f1990a, i);
    }

    public void scale(double d) throws PDFNetException {
        Scale(this.f1990a, d);
    }

    public void flattenField(Field field) throws PDFNetException {
        FlattenField(this.f1990a, field.f1541a);
        ReachabilityHelper.ensureReachable(field);
    }

    public boolean hasTransition() throws PDFNetException {
        return HasTransition(this.f1990a);
    }

    public double getUserUnitSize() throws PDFNetException {
        return GetUserUnitSize(this.f1990a);
    }

    public void setUserUnitSize(double d) throws PDFNetException {
        SetUserUnitSize(this.f1990a, d);
    }

    public Obj getResourceDict() throws PDFNetException {
        return Obj.__Create(GetResourceDict(this.f1990a), this.f1991b);
    }

    public Obj getContents() throws PDFNetException {
        return Obj.__Create(GetContents(this.f1990a), this.f1991b);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f1990a, this.f1991b);
    }

    public Obj findInheritedAttribute(String str) throws PDFNetException {
        return Obj.__Create(this.f1990a, str);
    }

    public Obj getThumb() throws PDFNetException {
        return Obj.__Create(GetThumb(this.f1990a), this.f1991b);
    }

    public int[] getThumbInfo() throws PDFNetException {
        return GetThumbInfo(this.f1990a);
    }

    public static Page __Create(long j, Object obj) {
        return new Page(j, obj);
    }

    Page(long j, Object obj) {
        this.f1990a = j;
        this.f1991b = obj;
    }

    public long __GetHandle() {
        return this.f1990a;
    }
}
