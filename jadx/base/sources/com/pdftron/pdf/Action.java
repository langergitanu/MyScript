package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;

/* JADX INFO: loaded from: classes7.dex */
public class Action {
    public static final int e_GoTo = 0;
    public static final int e_GoTo3DView = 17;
    public static final int e_GoToE = 2;
    public static final int e_GoToR = 1;
    public static final int e_Hide = 8;
    public static final int e_ImportData = 12;
    public static final int e_JavaScript = 13;
    public static final int e_Launch = 3;
    public static final int e_Movie = 7;
    public static final int e_Named = 9;
    public static final int e_Rendition = 15;
    public static final int e_ResetForm = 11;
    public static final int e_SetOCGState = 14;
    public static final int e_Sound = 6;
    public static final int e_SubmitForm = 10;
    public static final int e_Thread = 4;
    public static final int e_Trans = 16;
    public static final int e_URI = 5;
    public static final int e_Unknown = 18;
    public static final int e_canonical_format = 9;
    public static final int e_embed_form = 13;
    public static final int e_excl_F_key = 11;
    public static final int e_excl_non_user_annots = 10;
    public static final int e_exclude = 0;
    public static final int e_export_format = 2;
    public static final int e_get_method = 3;
    public static final int e_include_annotations = 7;
    public static final int e_include_append_saves = 6;
    public static final int e_include_no_value_fields = 1;
    public static final int e_submit_coordinates = 4;
    public static final int e_submit_pdf = 8;
    public static final int e_xfdf = 5;

    /* JADX INFO: renamed from: a */
    long f1435a;

    /* JADX INFO: renamed from: b */
    private Object f1436b;

    static native long CreateGoto(long j);

    static native long CreateGoto(byte[] bArr, long j);

    static native long CreateGotoRemote(long j, int i);

    static native long CreateGotoRemote(long j, int i, boolean z);

    static native long CreateHideField(long j, String[] strArr);

    static native long CreateImportData(long j, String str);

    static native long CreateJavaScript(long j, String str);

    static native long CreateLaunch(long j, String str);

    static native long CreateResetForm(long j);

    static native long CreateSubmitForm(long j);

    static native long CreateURI(long j, String str);

    static native void Execute(long j);

    static native long ExecuteKeyStrokeAction(long j, long j2);

    static native long GetDest(long j);

    static native int GetFormActionFlag(long j, int i);

    static native long GetNext(long j);

    static native int GetType(long j);

    static native boolean IsValid(long j);

    static native boolean NeedsWriteLock(long j);

    static native void SetFormActionFlag(long j, int i, boolean z);

    public static Action createGoto(Destination destination) throws PDFNetException {
        return new Action(CreateGoto(destination.f1516a), destination.f1517b);
    }

    public static Action createGoto(byte[] bArr, Destination destination) throws PDFNetException {
        return new Action(CreateGoto(bArr, destination.f1516a), destination.f1517b);
    }

    public static Action createGotoRemote(FileSpec fileSpec, int i) throws PDFNetException {
        return new Action(CreateGotoRemote(fileSpec.f1544a, i), fileSpec.f1545b);
    }

    public static Action createGotoRemote(FileSpec fileSpec, int i, boolean z) throws PDFNetException {
        return new Action(CreateGotoRemote(fileSpec.f1544a, i, z), fileSpec.f1545b);
    }

    public static Action createURI(PDFDoc pDFDoc, String str) throws PDFNetException {
        return new Action(CreateURI(pDFDoc.__GetHandle(), str), pDFDoc);
    }

    public static Action createSubmitForm(FileSpec fileSpec) throws PDFNetException {
        return new Action(CreateSubmitForm(fileSpec.f1544a), fileSpec.f1545b);
    }

    public static Action createLaunch(PDFDoc pDFDoc, String str) {
        return new Action(CreateLaunch(pDFDoc.__GetHandle(), str), pDFDoc);
    }

    public static Action createHideField(PDFDoc pDFDoc, String[] strArr) {
        return new Action(CreateHideField(pDFDoc.__GetHandle(), strArr), pDFDoc);
    }

    public static Action createImportData(PDFDoc pDFDoc, String str) {
        return new Action(CreateImportData(pDFDoc.__GetHandle(), str), pDFDoc);
    }

    public static Action createResetForm(PDFDoc pDFDoc) {
        return new Action(CreateResetForm(pDFDoc.__GetHandle()), pDFDoc);
    }

    public static Action createJavaScript(PDFDoc pDFDoc, String str) {
        return new Action(CreateJavaScript(pDFDoc.__GetHandle(), str), pDFDoc);
    }

    public Action(Obj obj) throws PDFNetException {
        this.f1435a = obj.__GetHandle();
        this.f1436b = obj.__GetRefHandle();
    }

    public boolean needsWriteLock() throws PDFNetException {
        return NeedsWriteLock(this.f1435a);
    }

    public KeyStrokeActionResult executeKeyStrokeAction(KeyStrokeEventData keyStrokeEventData) throws PDFNetException {
        KeyStrokeActionResult keyStrokeActionResult = new KeyStrokeActionResult(ExecuteKeyStrokeAction(this.f1435a, keyStrokeEventData.f1581a));
        ReachabilityHelper.ensureReachable(keyStrokeEventData);
        return keyStrokeActionResult;
    }

    public void Execute() throws PDFNetException {
        Execute(this.f1435a);
    }

    public Obj GetNext() throws PDFNetException {
        return Obj.__Create(GetNext(this.f1435a), this.f1436b);
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(getClass()) && this.f1435a == ((Action) obj).f1435a;
    }

    public int hashCode() {
        return (int) this.f1435a;
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.f1435a);
    }

    public int getType() throws PDFNetException {
        return GetType(this.f1435a);
    }

    public Destination getDest() throws PDFNetException {
        return new Destination(GetDest(this.f1435a), this.f1436b);
    }

    public int getFormActionFlag(int i) throws PDFNetException {
        return GetFormActionFlag(this.f1435a, i);
    }

    public void setFormActionFlag(int i, boolean z) throws PDFNetException {
        SetFormActionFlag(this.f1435a, i, z);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.f1435a, this.f1436b);
    }

    Action(long j, Object obj) {
        this.f1435a = j;
        this.f1436b = obj;
    }

    public static Action __Create(long j, Object obj) {
        if (j == 0) {
            return null;
        }
        return new Action(j, obj);
    }

    public long __GetHandle() {
        return this.f1435a;
    }

    public Object __GetRefHandle() {
        return this.f1436b;
    }
}
