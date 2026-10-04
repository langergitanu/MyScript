package com.pdftron.fdf;

import androidx.credentials.provider.CredentialEntry;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.SDFDoc;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class FDFDoc implements AutoCloseable {

    /* JADX INFO: renamed from: a */
    private long f1396a;

    static native void Close(long j);

    static native long CreateFromXFDF(String str);

    static native long FDFDocCreate();

    static native long FDFDocCreate(long j);

    static native long FDFDocCreate(String str);

    static native long FDFDocCreate(byte[] bArr);

    static native long FieldCreate(long j, String str, int i, long j2);

    static native long FieldCreate(long j, String str, int i, String str2);

    static native long GetFDF(long j);

    static native long GetField(long j, String str);

    static native long GetFieldIterator(long j, String str);

    static native long GetFieldIteratorBegin(long j);

    static native long GetID(long j);

    static native String GetPDFFileName(long j);

    static native long GetRoot(long j);

    static native long GetSDFDoc(long j);

    static native long GetTrailer(long j);

    static native boolean IsModified(long j);

    static native long MemStreamCreateDoc(long j);

    static native long MemStreamCreateMemFilt(long j) throws PDFNetException;

    static native void MemStreamWriteData(long j, byte[] bArr, int i);

    static native long MergeAnnots(long j, String str, String str2);

    static native void ReadData(byte[] bArr, int i, long j);

    static native void Save(long j, String str);

    static native byte[] Save(long j);

    static native long SaveAsXFDF(long j, String str, long j2);

    static native String SaveAsXFDF(long j, long j2);

    static native long[] SaveStream(long j);

    static native void SetID(long j, long j2);

    static native void SetPDFFileName(long j, String str);

    public FDFDoc() throws PDFNetException {
        this.f1396a = FDFDocCreate();
    }

    public FDFDoc(SDFDoc sDFDoc) throws PDFNetException {
        if (sDFDoc.__GetRefHandle() != null) {
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 36L, "FDFDoc.java", "FDFDoc(SDFDoc)", "SDFDoc is already owned by another document.");
        }
        this.f1396a = sDFDoc.__GetHandle();
        sDFDoc.__SetRef(this);
    }

    public FDFDoc(String str) throws PDFNetException {
        this.f1396a = FDFDocCreate(str);
    }

    public FDFDoc(Filter filter) throws PDFNetException {
        filter.__SetRefHandle(this);
        this.f1396a = FDFDocCreate(filter.__GetHandle());
        ReachabilityHelper.ensureReachable(filter);
    }

    public FDFDoc(byte[] bArr) throws PDFNetException {
        this.f1396a = FDFDocCreate(bArr);
    }

    public FDFDoc(InputStream inputStream) throws PDFNetException, IOException {
        this(inputStream, 1048576);
    }

    public FDFDoc(InputStream inputStream, int i) throws PDFNetException, IOException {
        long jMemStreamCreateMemFilt = 0;
        try {
            jMemStreamCreateMemFilt = MemStreamCreateMemFilt(inputStream.available());
            byte[] bArr = new byte[i];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 != -1) {
                    MemStreamWriteData(jMemStreamCreateMemFilt, bArr, i2);
                } else {
                    this.f1396a = MemStreamCreateDoc(jMemStreamCreateMemFilt);
                    return;
                }
            }
        } catch (PDFNetException e) {
            Filter.__Create(jMemStreamCreateMemFilt, null).destroy();
            throw e;
        } catch (IOException e2) {
            Filter.__Create(jMemStreamCreateMemFilt, null).destroy();
            throw e2;
        }
    }

    protected void finalize() throws Throwable {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        long j = this.f1396a;
        if (j != 0) {
            Close(j);
            this.f1396a = 0L;
        }
    }

    public boolean isModified() throws PDFNetException {
        return IsModified(this.f1396a);
    }

    public void save(String str) throws PDFNetException {
        Save(this.f1396a, str);
    }

    public byte[] save() throws PDFNetException {
        return Save(this.f1396a);
    }

    public void save(OutputStream outputStream) throws PDFNetException, IOException {
        save(outputStream, 1048576);
    }

    public void save(OutputStream outputStream, int i) throws PDFNetException, IOException {
        long[] jArrSaveStream = SaveStream(this.f1396a);
        long j = jArrSaveStream[0];
        long j2 = jArrSaveStream[1];
        byte[] bArr = new byte[i];
        long j3 = i;
        long j4 = j2 - j3;
        while (j < j4) {
            ReadData(bArr, i, j);
            outputStream.write(bArr);
            j += j3;
        }
        int i2 = (int) (j2 - j);
        if (i2 > 0) {
            ReadData(bArr, i2, j);
            outputStream.write(bArr, 0, i2);
        }
    }

    public Obj getTrailer() throws PDFNetException {
        return Obj.__Create(GetTrailer(this.f1396a), this);
    }

    public Obj getRoot() throws PDFNetException {
        return Obj.__Create(GetRoot(this.f1396a), this);
    }

    public Obj getFDF() throws PDFNetException {
        return Obj.__Create(GetFDF(this.f1396a), this);
    }

    public String getPDFFileName() throws PDFNetException {
        return GetPDFFileName(this.f1396a);
    }

    public void setPDFFileName(String str) throws PDFNetException {
        SetPDFFileName(this.f1396a, str);
    }

    public Obj getID() throws PDFNetException {
        return Obj.__Create(GetID(this.f1396a), this);
    }

    public void setID(Obj obj) throws PDFNetException {
        SetID(this.f1396a, obj.__GetHandle());
        ReachabilityHelper.ensureReachable(obj);
    }

    public FDFFieldIterator getFieldIterator() throws PDFNetException {
        return new FDFFieldIterator(GetFieldIteratorBegin(this.f1396a), this);
    }

    public FDFFieldIterator getFieldIterator(String str) throws PDFNetException {
        return new FDFFieldIterator(GetFieldIterator(this.f1396a, str), this);
    }

    public FDFField getField(String str) throws PDFNetException {
        long jGetField = GetField(this.f1396a, str);
        if (jGetField != 0) {
            return new FDFField(jGetField, this);
        }
        return null;
    }

    public FDFField fieldCreate(String str, int i) throws PDFNetException {
        return new FDFField(FieldCreate(this.f1396a, str, i, 0L), this);
    }

    public FDFField fieldCreate(String str, int i, Obj obj) throws PDFNetException {
        FDFField fDFField = new FDFField(FieldCreate(this.f1396a, str, i, obj.__GetHandle()), this);
        ReachabilityHelper.ensureReachable(obj);
        return fDFField;
    }

    public FDFField fieldCreate(String str, int i, String str2) throws PDFNetException {
        return new FDFField(FieldCreate(this.f1396a, str, i, str2), this);
    }

    public SDFDoc getSDFDoc() {
        return SDFDoc.__Create(GetSDFDoc(this.f1396a), this);
    }

    public static FDFDoc createFromXFDF(String str) throws PDFNetException {
        if (str == null) {
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 454L, "FDFDoc.java", "createFromXFDF(String)", "Argument may not be null.");
        }
        return new FDFDoc(CreateFromXFDF(str));
    }

    public void saveAsXFDF(String str) throws PDFNetException {
        SaveAsXFDF(this.f1396a, str, 0L);
    }

    public void saveAsXFDF(String str, XFDFExportOptions xFDFExportOptions) throws PDFNetException {
        SaveAsXFDF(this.f1396a, str, xFDFExportOptions != null ? xFDFExportOptions.m1116a() : 0L);
        ReachabilityHelper.ensureReachable(xFDFExportOptions);
    }

    public String saveAsXFDF() throws PDFNetException {
        return SaveAsXFDF(this.f1396a, 0L);
    }

    public String saveAsXFDF(XFDFExportOptions xFDFExportOptions) throws PDFNetException {
        String strSaveAsXFDF = SaveAsXFDF(this.f1396a, xFDFExportOptions != null ? xFDFExportOptions.m1116a() : 0L);
        ReachabilityHelper.ensureReachable(xFDFExportOptions);
        return strSaveAsXFDF;
    }

    public void mergeAnnots(String str) throws PDFNetException {
        MergeAnnots(this.f1396a, str, "");
    }

    public void mergeAnnots(String str, String str2) throws PDFNetException {
        MergeAnnots(this.f1396a, str, str2);
    }

    public long __GetHandle() {
        return this.f1396a;
    }

    public static FDFDoc __Create(long j) {
        return new FDFDoc(j);
    }

    private FDFDoc(long j) {
        this.f1396a = j;
    }
}
