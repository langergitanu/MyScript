package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.filters.FilterReader;
import com.pdftron.helpers.ReachabilityHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public class SDFDoc extends Doc implements AutoCloseable {
    public static final int e_compatibility = 32;
    public static final int e_hex_strings = 4;
    public static final int e_incremental = 1;
    public static final int e_linearized = 16;
    public static final int e_omit_xref = 8;
    public static final int e_remove_unused = 2;

    /* JADX INFO: renamed from: a */
    private Object f2184a;

    static native boolean CanSaveToPath(long j, String str, long j2);

    static native void ClearMarks(long j);

    static native long CreateIndirectArray(long j);

    static native long CreateIndirectBool(long j, boolean z);

    static native long CreateIndirectDict(long j);

    static native long CreateIndirectName(long j, String str);

    static native long CreateIndirectNull(long j);

    static native long CreateIndirectNumber(long j, double d);

    static native long CreateIndirectStream(long j, long j2, long j3);

    static native long CreateIndirectStream(long j, byte[] bArr, long j2);

    static native long CreateIndirectString(long j, String str);

    static native long CreateIndirectString(long j, byte[] bArr);

    static native void Destroy(long j);

    static native void EnableDiskCaching(long j, boolean z);

    static native String GetFileName(long j);

    static native String GetHeader(long j);

    static native long GetHintStream(long j);

    static native long GetLinearizationDict(long j);

    static native long GetObj(long j, long j2);

    static native long GetSecurityHandler(long j);

    static native long GetTrailer(long j);

    static native boolean HasRepairedXRef(long j);

    static native long ImportObj(long j, long j2, boolean z);

    static native long[] ImportObjs(long j, long[] jArr, long[] jArr2);

    static native boolean InitSecurityHandler(long j, Object obj);

    static native boolean InitStdSecurityHandler(long j, String str);

    static native boolean InitStdSecurityHandlerBuffer(long j, byte[] bArr);

    static native boolean IsEncrypted(long j);

    static native boolean IsFullSaveRequired(long j);

    static native boolean IsLinearized(long j);

    static native boolean IsModified(long j);

    static native void Lock(long j);

    static native void LockRead(long j);

    static native long MemStreamCreateDoc(long j);

    static native long MemStreamCreateMemFilt(long j) throws PDFNetException;

    static native void MemStreamWriteData(long j, byte[] bArr, int i);

    static native void ReadData(byte[] bArr, int i, long j);

    static native void RemoveSecurity(long j);

    static native long SDFDocCreate();

    static native long SDFDocCreate(long j);

    static native long SDFDocCreate(String str);

    static native long SDFDocCreate(byte[] bArr);

    static native void Save(long j, String str, long j2, ProgressMonitor progressMonitor, String str2);

    static native byte[] Save(long j, long j2, ProgressMonitor progressMonitor, String str);

    static native long[] SaveStream(long j, long j2, ProgressMonitor progressMonitor, String str);

    static native void SetSecurityHandler(long j, long j2);

    static native void Swap(long j, long j2, long j3);

    static native boolean TryLock(long j, int i);

    static native boolean TryLockRead(long j, int i);

    static native void Unlock(long j);

    static native void UnlockRead(long j);

    static native long XRefSize(long j);

    public SDFDoc() throws PDFNetException {
        this.impl = SDFDocCreate();
        this.f2184a = null;
    }

    public SDFDoc(String str) throws PDFNetException {
        this.impl = SDFDocCreate(str);
        this.f2184a = null;
    }

    public SDFDoc(Filter filter) throws PDFNetException {
        filter.__SetRefHandle(this);
        this.impl = SDFDocCreate(filter.__GetHandle());
        this.f2184a = null;
    }

    public SDFDoc(byte[] bArr) throws PDFNetException {
        this.impl = SDFDocCreate(bArr);
    }

    public SDFDoc(InputStream inputStream) throws PDFNetException, IOException {
        this(inputStream, 1048576);
    }

    public SDFDoc(InputStream inputStream, int i) throws PDFNetException, IOException {
        long jMemStreamCreateMemFilt = 0;
        try {
            jMemStreamCreateMemFilt = MemStreamCreateMemFilt(inputStream.available());
            byte[] bArr = new byte[i];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 != -1) {
                    MemStreamWriteData(jMemStreamCreateMemFilt, bArr, i2);
                } else {
                    this.impl = MemStreamCreateDoc(jMemStreamCreateMemFilt);
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

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        if (this.impl == 0 || this.f2184a != null) {
            return;
        }
        Destroy(this.impl);
        this.impl = 0L;
    }

    protected void finalize() throws Throwable {
        close();
    }

    public boolean isEncrypted() throws PDFNetException {
        return IsEncrypted(this.impl);
    }

    public boolean initSecurityHandler() throws PDFNetException {
        return InitSecurityHandler(this.impl, null);
    }

    public boolean initSecurityHandler(Object obj) throws PDFNetException {
        return InitSecurityHandler(this.impl, obj);
    }

    public boolean initStdSecurityHandler(String str) throws PDFNetException {
        return InitStdSecurityHandler(this.impl, str);
    }

    public boolean initStdSecurityHandler(byte[] bArr) throws PDFNetException {
        return InitStdSecurityHandlerBuffer(this.impl, bArr);
    }

    public boolean isModified() throws PDFNetException {
        return IsModified(this.impl);
    }

    public boolean hasRepairedXRef() throws PDFNetException {
        return HasRepairedXRef(this.impl);
    }

    public void enableDiskCaching(boolean z) {
        EnableDiskCaching(this.impl, z);
    }

    public boolean isFullSaveRequired() throws PDFNetException {
        return IsFullSaveRequired(this.impl);
    }

    public boolean canSaveToPath(String str, long j) throws PDFNetException {
        return CanSaveToPath(this.impl, str, j);
    }

    public boolean canSaveToPath(String str, SaveMode saveMode) throws PDFNetException {
        return CanSaveToPath(this.impl, str, saveMode.getValue());
    }

    public Obj getTrailer() throws PDFNetException {
        return Obj.__Create(GetTrailer(this.impl), this);
    }

    public Obj getObj(long j) throws PDFNetException {
        return Obj.__Create(GetObj(this.impl, j), this);
    }

    public Obj importObj(Obj obj, boolean z) throws PDFNetException {
        return Obj.__Create(ImportObj(this.impl, obj.f2180a, z), this);
    }

    public Obj[] importObjs(Obj[] objArr) throws PDFNetException {
        return importObjs(objArr, null);
    }

    public Obj[] importObjs(Obj[] objArr, Obj[] objArr2) throws PDFNetException {
        long[] jArr;
        int length = objArr.length;
        long[] jArr2 = new long[length];
        for (int i = 0; i < length; i++) {
            jArr2[i] = objArr[i].f2180a;
        }
        if (objArr2 != null) {
            int length2 = objArr2.length;
            jArr = new long[length2];
            for (int i2 = 0; i2 < length2; i2++) {
                jArr[i2] = objArr2[i2].f2180a;
            }
        } else {
            jArr = null;
        }
        long[] jArrImportObjs = ImportObjs(this.impl, jArr2, jArr);
        Obj[] objArr3 = new Obj[jArrImportObjs.length];
        for (int i3 = 0; i3 < jArrImportObjs.length; i3++) {
            objArr3[i3] = Obj.__Create(jArrImportObjs[i3], this);
        }
        return objArr3;
    }

    public long xRefSize() throws PDFNetException {
        return XRefSize(this.impl);
    }

    public void clearMarks() throws PDFNetException {
        ClearMarks(this.impl);
    }

    public enum SaveMode {
        INCREMENTAL(1),
        REMOVE_UNUSED(2),
        HEX_STRINGS(4),
        OMIT_XREF(8),
        LINEARIZED(16),
        COMPATIBILITY(32),
        NO_FLAGS(0);


        /* JADX INFO: renamed from: a */
        private final int f2186a;

        SaveMode(int i) {
            this.f2186a = i;
        }

        public final int getValue() {
            return this.f2186a;
        }
    }

    public void save(String str, long j, ProgressMonitor progressMonitor, String str2) throws PDFNetException {
        Save(this.impl, str, j, progressMonitor, str2);
    }

    public void save(String str, SaveMode saveMode, ProgressMonitor progressMonitor, String str2) throws PDFNetException {
        Save(this.impl, str, saveMode.getValue(), progressMonitor, str2);
    }

    public byte[] save(long j, ProgressMonitor progressMonitor, String str) throws PDFNetException {
        return Save(this.impl, j, progressMonitor, str);
    }

    public byte[] save(SaveMode saveMode, ProgressMonitor progressMonitor, String str) throws PDFNetException {
        return Save(this.impl, saveMode.getValue(), progressMonitor, str);
    }

    public void save(OutputStream outputStream, long j, ProgressMonitor progressMonitor, String str) throws PDFNetException, IOException {
        save(outputStream, j, progressMonitor, str, 1048576);
    }

    public void save(OutputStream outputStream, SaveMode saveMode, ProgressMonitor progressMonitor, String str) throws PDFNetException, IOException {
        save(outputStream, saveMode.getValue(), progressMonitor, str, 1048576);
    }

    public void save(OutputStream outputStream, long j, ProgressMonitor progressMonitor, String str, int i) throws PDFNetException, IOException {
        long[] jArrSaveStream = SaveStream(this.impl, j, progressMonitor, str);
        long j2 = jArrSaveStream[0];
        long j3 = jArrSaveStream[1];
        byte[] bArr = new byte[i];
        long j4 = i;
        long j5 = j3 - j4;
        while (j2 < j5) {
            ReadData(bArr, i, j2);
            outputStream.write(bArr);
            j2 += j4;
        }
        int i2 = (int) (j3 - j2);
        if (i2 > 0) {
            ReadData(bArr, i2, j2);
            outputStream.write(bArr, 0, i2);
        }
    }

    public void save(OutputStream outputStream, SaveMode saveMode, ProgressMonitor progressMonitor, String str, int i) throws PDFNetException, IOException {
        save(outputStream, saveMode.getValue(), progressMonitor, str, i);
    }

    public String getHeader() throws PDFNetException {
        return GetHeader(this.impl);
    }

    public SecurityHandler getSecurityHandler() {
        return SecurityHandler.__Create(GetSecurityHandler(this.impl), this);
    }

    public void setSecurityHandler(SecurityHandler securityHandler) {
        securityHandler.f2188b = this;
        SetSecurityHandler(this.impl, securityHandler.f2187a);
        ReachabilityHelper.ensureReachable(securityHandler);
    }

    public void swap(long j, long j2) throws PDFNetException {
        Swap(this.impl, j, j2);
    }

    public Obj createIndirectName(String str) throws PDFNetException {
        return Obj.__Create(CreateIndirectName(this.impl, str), this);
    }

    public Obj createIndirectArray() throws PDFNetException {
        return Obj.__Create(CreateIndirectArray(this.impl), this);
    }

    public Obj createIndirectBool(boolean z) throws PDFNetException {
        return Obj.__Create(CreateIndirectBool(this.impl, z), this);
    }

    public Obj createIndirectDict() throws PDFNetException {
        return Obj.__Create(CreateIndirectDict(this.impl), this);
    }

    public Obj createIndirectNull() throws PDFNetException {
        return Obj.__Create(CreateIndirectNull(this.impl), this);
    }

    public Obj createIndirectNumber(double d) throws PDFNetException {
        return Obj.__Create(CreateIndirectNumber(this.impl, d), this);
    }

    public Obj createIndirectString(byte[] bArr) throws PDFNetException {
        return Obj.__Create(CreateIndirectString(this.impl, bArr), this);
    }

    public Obj createIndirectString(String str) throws PDFNetException {
        return Obj.__Create(CreateIndirectString(this.impl, str), this);
    }

    public Obj createIndirectStream(FilterReader filterReader) throws PDFNetException {
        return Obj.__Create(CreateIndirectStream(this.impl, filterReader.__GetHandle(), 0L), this);
    }

    public Obj createIndirectStream(FilterReader filterReader, Filter filter) throws PDFNetException {
        if (filter != null) {
            filter.__SetRefHandle(this);
        }
        Obj obj__Create = Obj.__Create(CreateIndirectStream(this.impl, filterReader.__GetHandle(), filter.__GetHandle()), this);
        ReachabilityHelper.ensureReachable(filterReader);
        ReachabilityHelper.ensureReachable(filter);
        return obj__Create;
    }

    public Obj createIndirectStream(byte[] bArr) throws PDFNetException {
        return Obj.__Create(CreateIndirectStream(this.impl, bArr, 0L), this);
    }

    public Obj createIndirectStream(byte[] bArr, Filter filter) throws PDFNetException {
        if (filter != null) {
            filter.__SetRefHandle(this);
        }
        Obj obj__Create = Obj.__Create(CreateIndirectStream(this.impl, bArr, filter.__GetHandle()), this);
        ReachabilityHelper.ensureReachable(filter);
        return obj__Create;
    }

    public boolean isLinearized() throws PDFNetException {
        return IsLinearized(this.impl);
    }

    public Obj getLinearizationDict() throws PDFNetException {
        return Obj.__Create(GetLinearizationDict(this.impl), this);
    }

    public Obj getHintStream() throws PDFNetException {
        return Obj.__Create(GetHintStream(this.impl), this);
    }

    public void lock() throws PDFNetException {
        Lock(this.impl);
    }

    public void unlock() throws PDFNetException {
        Unlock(this.impl);
    }

    public boolean timedLock(int i) throws PDFNetException {
        return TryLock(this.impl, i);
    }

    public void lockRead() throws PDFNetException {
        LockRead(this.impl);
    }

    public void unlockRead() throws PDFNetException {
        UnlockRead(this.impl);
    }

    public boolean tryLockRead() throws PDFNetException {
        return TryLockRead(this.impl, 0);
    }

    public boolean timedLockRead(int i) throws PDFNetException {
        return TryLockRead(this.impl, i);
    }

    public String getFileName() throws PDFNetException {
        return GetFileName(this.impl);
    }

    SDFDoc(long j, Object obj) {
        this.impl = j;
        this.f2184a = obj;
    }

    public static SDFDoc __Create(long j, Object obj) {
        return new SDFDoc(j, obj);
    }

    public void __SetRef(Object obj) {
        this.f2184a = obj;
    }

    public Object __GetRefHandle() {
        return this.f2184a;
    }

    @Override // com.pdftron.sdf.Doc
    public long __GetHandle() {
        return this.impl;
    }

    public void removeSecurity() {
        RemoveSecurity(this.impl);
    }
}
