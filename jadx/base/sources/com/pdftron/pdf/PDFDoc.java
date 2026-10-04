package com.pdftron.pdf;

import androidx.credentials.provider.CredentialEntry;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.pdftron.common.PDFNetException;
import com.pdftron.fdf.FDFDoc;
import com.pdftron.filters.FileDescriptorFilter;
import com.pdftron.filters.FileDescriptorReadOnlyFilter;
import com.pdftron.filters.Filter;
import com.pdftron.filters.FilterReader;
import com.pdftron.filters.SecondaryFileFilter;
import com.pdftron.helpers.ReachabilityHelper;
import com.pdftron.pdf.DigitalSignatureField;
import com.pdftron.pdf.ocg.Config;
import com.pdftron.pdf.struct.STree;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.SDFDoc;
import com.pdftron.sdf.SecurityHandler;
import com.pdftron.sdf.SignatureHandler;
import com.pdftron.sdf.UndoManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes7.dex */
public class PDFDoc extends Doc implements AutoCloseable {
    public static final int e_action_trigger_doc_did_print = 21;
    public static final int e_action_trigger_doc_did_save = 19;
    public static final int e_action_trigger_doc_will_close = 17;
    public static final int e_action_trigger_doc_will_print = 20;
    public static final int e_action_trigger_doc_will_save = 18;
    public static final int e_annots_only = 1;
    public static final int e_annots_only_no_links = 5;
    public static final int e_both = 2;
    public static final int e_flatten_all = 8;
    public static final int e_flatten_annots_only = 2;
    public static final int e_flatten_forms_only = 1;
    public static final int e_flatten_link_only = 4;
    public static final int e_forms_only = 0;
    public static final int e_insert_bookmark = 1;
    public static final int e_none = 0;

    /* JADX INFO: renamed from: a */
    private String f1615a;
    public Filter mCustomFilter;

    static native void AddFileAttachment(long j, String str, long j2);

    static native void AddHighlights(long j, String str);

    static native void AddRootBookmark(long j, long j2);

    static native long AddSignatureHandler(long j, SignatureHandler signatureHandler);

    static native long AddStdSignatureHandlerFromBuffer(long j, byte[] bArr, String str);

    static native long AddStdSignatureHandlerFromFile(long j, String str, String str2);

    static native int AppendTextDiffDoc(long j, long j2, long j3, long j4);

    static native int AppendTextDiffPage(long j, long j2, long j3);

    static native void AppendVisualDiff(long j, long j2, long j3, long j4);

    static native void Close(long j);

    static native long CreateDigitalSignatureField(long j);

    static native long CreateDigitalSignatureField(long j, String str);

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

    static native long FDFExtract(long j, int i);

    static native long FDFExtract(long j, long j2, int i);

    static native long FDFExtract(long j, long[] jArr);

    static native long FDFExtract(long j, long[] jArr, long[] jArr2, long[] jArr3);

    static native void FDFMerge(long j, long j2);

    static native void FDFUpdate(long j, long j2);

    static native long FieldCreate(long j, String str, int i, long j2, long j3);

    static native long FieldCreate(long j, String str, int i, String str2, String str3);

    static native void FlattenAnnotations(long j, boolean z);

    static native void FlattenAnnotationsAdvanced(long j, long j2);

    static native void GenerateThumbnails(long j, long j2);

    static native long GetAcroForm(long j);

    static native long GetDigitalSignatureFieldIteratorBegin(long j);

    static native int GetDigitalSignaturePermissions(long j);

    static native long GetDocInfo(long j);

    static native long GetDownloadedByteCount(long j);

    static native long GetField(long j, String str);

    static native long GetFieldIterator(long j, String str);

    static native long GetFieldIteratorBegin(long j);

    static native String GetFileName(long j);

    static native long GetFirstBookmark(long j);

    static native long GetOCGConfig(long j);

    static native long GetOCGs(long j);

    static native long GetOpenAction(long j);

    static native long GetPage(long j, int i);

    static native long GetPageIterator(long j, int i);

    static native long GetPageIteratorBegin(long j);

    static native long GetPageLabel(long j, int i);

    static native long GetPages(long j);

    static native int GetPagesCount(long j);

    static native long GetRoot(long j);

    static native long GetSecurityHandler(long j);

    static native SignatureHandler GetSignatureHandler(long j, long j2);

    static native long GetStructTree(long j);

    static native long GetTotalRemoteByteCount(long j);

    static native long GetTrailer(long j);

    static native long GetTriggerAction(long j, int i);

    static native long GetUndoManager(long j);

    static native long GetViewPrefs(long j);

    static native boolean HasChangesSinceSnapshot(long j);

    static native boolean HasDownloader(long j);

    static native boolean HasOC(long j);

    static native boolean HasRepairedXRef(long j);

    static native boolean HasSignatures(long j);

    static native int HighlightTextDiff(long j, long j2, long j3);

    static native long[] ImportPages(long j, long[] jArr, boolean z);

    static native boolean InitSecurityHandler(long j, Object obj);

    static native boolean InitStdSecurityHandler(long j, String str);

    static native boolean InitStdSecurityHandlerBuffer(long j, byte[] bArr);

    static native void InsertPageSet(long j, int i, long j2, long j3, int i2, ProgressMonitor progressMonitor);

    static native boolean IsEncrypted(long j);

    static native boolean IsLinearized(long j);

    static native boolean IsModified(long j);

    static native boolean IsTagged(long j);

    static native void JSContextInitialize(long j);

    static native void Lock(long j);

    static native void LockRead(long j);

    static native long MemStreamCreateDoc(long j);

    static native long MemStreamCreateMemFilt(long j) throws PDFNetException;

    static native void MemStreamWriteData(long j, byte[] bArr, int i);

    static native void MergeXFDF(long j, long j2, long j3);

    static native void MergeXFDFString(long j, String str, long j2);

    static native void MergeXFDFString_old(long j, String str, String str2);

    static native void MergeXFDF_old(long j, long j2, String str);

    static native void MovePageSet(long j, int i, long j2, long j3, int i2, ProgressMonitor progressMonitor);

    static native long PDFDocCreate();

    static native long PDFDocCreate(String str);

    static native long PDFDocCreate(byte[] bArr);

    static native long PDFDocCreateFilter(long j);

    static native long PageCreate(long j, long j2);

    static native void PageInsert(long j, long j2, long j3);

    static native void PagePushBack(long j, long j2);

    static native void PagePushFront(long j, long j2);

    static native void PageRemove(long j, long j2);

    static native void ReadData(byte[] bArr, int i, long j);

    static native void RefreshAnnotAppearances(long j, long j2);

    static native void RefreshFieldAppearances(long j);

    static native void RemovePageLabel(long j, int i);

    static native void RemoveSecurity(long j);

    static native SignatureHandler RemoveSignatureHandler(long j, long j2);

    static native void Save(long j, String str, long j2, ProgressMonitor progressMonitor);

    static native byte[] Save(long j, long j2, ProgressMonitor progressMonitor);

    static native void SaveCustomFilter(long j, long j2, long j3);

    static native long SaveCustomFilter2(long j, long j2, long j3);

    static native void SaveCustomSignatureCustomFilter(long j, byte[] bArr, long j2, long j3);

    static native void SaveCustomSignaturePath(long j, byte[] bArr, long j2, String str);

    static native boolean SaveIncrementalData(long j, String str);

    static native long[] SaveStream(long j, long j2, ProgressMonitor progressMonitor);

    static native void SaveViewerOptimized(long j, String str, long j2);

    static native byte[] SaveViewerOptimizedBuffer(long j, long j2);

    static native void SetOpenAction(long j, long j2);

    static native void SetPageLabel(long j, int i, long j2);

    static native void SetSecurityHandler(long j, long j2);

    static native boolean TryLock(long j, int i);

    static native boolean TryLockRead(long j, int i);

    static native void Unlock(long j);

    static native void UnlockRead(long j);

    static native int VerifySignedDigitalSignatures(long j, long j2);

    public enum InsertBookmarkMode {
        NONE(0),
        INSERT(1),
        INSERT_GOTO(2);


        /* JADX INFO: renamed from: a */
        private final int f1621a;

        InsertBookmarkMode(int i) {
            this.f1621a = i;
        }

        public final int getValue() {
            return this.f1621a;
        }
    }

    public enum FlattenMode {
        FORMS(1),
        ANNOTS(2),
        LINK(4),
        ALL(8);


        /* JADX INFO: renamed from: a */
        private final int f1619a;

        FlattenMode(int i) {
            this.f1619a = i;
        }

        public final int getValue() {
            return this.f1619a;
        }
    }

    public PDFDoc() throws PDFNetException {
        this.mCustomFilter = null;
        this.f1615a = null;
        this.impl = PDFDocCreate();
    }

    public PDFDoc(SDFDoc sDFDoc) throws PDFNetException {
        this.mCustomFilter = null;
        this.f1615a = null;
        if (sDFDoc.__GetRefHandle() != null) {
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 78L, "PDFDoc.java", "PDFDoc(SDFDoc)", "SDFDoc is already owned by another document.");
        }
        this.impl = sDFDoc.__GetHandle();
        sDFDoc.__SetRef(this);
    }

    public PDFDoc(String str) throws PDFNetException {
        this.mCustomFilter = null;
        this.f1615a = str;
        this.impl = PDFDocCreate(str);
    }

    public PDFDoc(Filter filter) throws PDFNetException {
        this.f1615a = null;
        this.mCustomFilter = filter;
        filter.__SetRefHandle(this);
        this.impl = PDFDocCreateFilter(filter.__GetHandle());
        ReachabilityHelper.ensureReachable(filter);
    }

    public PDFDoc(byte[] bArr) throws PDFNetException {
        this.mCustomFilter = null;
        this.f1615a = null;
        if (bArr == null) {
            throw new PDFNetException("", 0L, "PDFDoc.java", "PDFDoc(byte[])", "Memory buffer is null.");
        }
        this.impl = PDFDocCreate(bArr);
    }

    public PDFDoc(InputStream inputStream) throws PDFNetException, IOException {
        this(inputStream, 1048576);
    }

    public PDFDoc(InputStream inputStream, int i) throws PDFNetException, IOException {
        long jMemStreamCreateMemFilt;
        byte[] bArr;
        this.mCustomFilter = null;
        this.f1615a = null;
        long j = 0;
        try {
            jMemStreamCreateMemFilt = MemStreamCreateMemFilt(inputStream.available());
            try {
                bArr = new byte[i];
            } catch (PDFNetException e) {
                e = e;
                j = jMemStreamCreateMemFilt;
            } catch (IOException e2) {
                e = e2;
                j = jMemStreamCreateMemFilt;
                Filter.__Create(j, null).destroy();
                throw e;
            }
        } catch (PDFNetException e3) {
            e = e3;
        } catch (IOException e4) {
            e = e4;
        }
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 != -1) {
                MemStreamWriteData(jMemStreamCreateMemFilt, bArr, i2);
            } else {
                this.impl = MemStreamCreateDoc(jMemStreamCreateMemFilt);
                return;
            }
            Filter.__Create(j, null).destroy();
            throw e;
        }
    }

    protected void finalize() throws Throwable {
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws PDFNetException {
        if (this.impl != 0) {
            Close(this.impl);
            this.impl = 0L;
            m1196a();
            this.mCustomFilter = null;
            this.f1615a = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1196a() throws PDFNetException {
        Filter filter = this.mCustomFilter;
        if (filter != null) {
            if (filter instanceof FileDescriptorFilter) {
                ((FileDescriptorFilter) filter).close();
            } else if (filter instanceof FileDescriptorReadOnlyFilter) {
                ((FileDescriptorReadOnlyFilter) filter).close();
            } else if (filter instanceof SecondaryFileFilter) {
                ((SecondaryFileFilter) filter).close();
            }
        }
    }

    public enum ActionTriggerMode {
        DOC_WILL_CLOSE(17),
        DOC_WILL_SAVE(18),
        DOC_DID_SAVE(19),
        DOC_WILL_PRINT(20),
        DOC_DID_PRINT(21);


        /* JADX INFO: renamed from: a */
        private final int f1617a;

        ActionTriggerMode(int i) {
            this.f1617a = i;
        }

        public final int getValue() {
            return this.f1617a;
        }
    }

    public Obj getTriggerAction(int i) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.impl, i), this);
    }

    public Obj getTriggerAction(ActionTriggerMode actionTriggerMode) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.impl, actionTriggerMode.getValue()), this);
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

    public SecurityHandler getSecurityHandler() {
        SecurityHandler securityHandler__Create = SecurityHandler.__Create(GetSecurityHandler(this.impl), this);
        if (securityHandler__Create.__GetHandle() == 0) {
            return null;
        }
        return securityHandler__Create;
    }

    public void setSecurityHandler(SecurityHandler securityHandler) {
        SetSecurityHandler(this.impl, securityHandler.__GetHandle());
        securityHandler.__SetRefHandle(this);
    }

    public PDFDocInfo getDocInfo() throws PDFNetException {
        return new PDFDocInfo(GetDocInfo(this.impl), this);
    }

    public PDFDocViewPrefs getViewPrefs() throws PDFNetException {
        return new PDFDocViewPrefs(GetViewPrefs(this.impl), this);
    }

    public boolean isModified() throws PDFNetException {
        return IsModified(this.impl);
    }

    public boolean hasChangesSinceSnapshot() throws PDFNetException {
        return HasChangesSinceSnapshot(this.impl);
    }

    public boolean hasRepairedXRef() throws PDFNetException {
        return HasRepairedXRef(this.impl);
    }

    public boolean isLinearized() throws PDFNetException {
        return IsLinearized(this.impl);
    }

    public void save(String str, long j, ProgressMonitor progressMonitor) throws PDFNetException {
        Save(this.impl, str, j, progressMonitor);
    }

    public void save(String str, SDFDoc.SaveMode saveMode, ProgressMonitor progressMonitor) throws PDFNetException {
        save(str, saveMode.getValue(), progressMonitor);
    }

    public void save(String str, SDFDoc.SaveMode[] saveModeArr, ProgressMonitor progressMonitor) throws PDFNetException {
        long value = 0;
        if (saveModeArr != null) {
            for (SDFDoc.SaveMode saveMode : saveModeArr) {
                value |= (long) saveMode.getValue();
            }
        }
        save(str, value, progressMonitor);
    }

    public byte[] save(long j, ProgressMonitor progressMonitor) throws PDFNetException {
        return Save(this.impl, j, progressMonitor);
    }

    public byte[] save(SDFDoc.SaveMode saveMode, ProgressMonitor progressMonitor) throws PDFNetException {
        return save(saveMode.getValue(), progressMonitor);
    }

    public byte[] save(SDFDoc.SaveMode[] saveModeArr, ProgressMonitor progressMonitor) throws PDFNetException {
        long value = 0;
        if (saveModeArr != null) {
            for (SDFDoc.SaveMode saveMode : saveModeArr) {
                value |= (long) saveMode.getValue();
            }
        }
        return save(value, progressMonitor);
    }

    public void save(OutputStream outputStream, long j, ProgressMonitor progressMonitor) throws PDFNetException, IOException {
        save(outputStream, j, progressMonitor, 1048576);
    }

    public void save(OutputStream outputStream, SDFDoc.SaveMode saveMode, ProgressMonitor progressMonitor) throws PDFNetException, IOException {
        save(outputStream, saveMode.getValue(), progressMonitor, 1048576);
    }

    public void save(OutputStream outputStream, SDFDoc.SaveMode[] saveModeArr, ProgressMonitor progressMonitor) throws PDFNetException, IOException {
        long value = 0;
        if (saveModeArr != null) {
            for (SDFDoc.SaveMode saveMode : saveModeArr) {
                value |= (long) saveMode.getValue();
            }
        }
        save(outputStream, value, progressMonitor, 1048576);
    }

    public void save(OutputStream outputStream, long j, ProgressMonitor progressMonitor, int i) throws PDFNetException, IOException {
        long[] jArrSaveStream = SaveStream(this.impl, j, progressMonitor);
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

    public void save(OutputStream outputStream, SDFDoc.SaveMode saveMode, ProgressMonitor progressMonitor, int i) throws PDFNetException, IOException {
        save(outputStream, saveMode.getValue(), progressMonitor, i);
    }

    public void save(OutputStream outputStream, SDFDoc.SaveMode[] saveModeArr, ProgressMonitor progressMonitor, int i) throws PDFNetException, IOException {
        long value = 0;
        if (saveModeArr != null) {
            for (SDFDoc.SaveMode saveMode : saveModeArr) {
                value |= (long) saveMode.getValue();
            }
        }
        save(outputStream, value, progressMonitor, i);
    }

    public void save(Filter filter, long j) throws PDFNetException, IOException {
        if ((filter instanceof FileDescriptorFilter) && filter.isInputFilter()) {
            FileDescriptorFilter fileDescriptorFilter = (FileDescriptorFilter) filter;
            if (fileDescriptorFilter.canWriteOnInputFilter()) {
                FileDescriptorFilter fileDescriptorFilterCreateOutputIterator = fileDescriptorFilter.createOutputIterator();
                if (fileDescriptorFilterCreateOutputIterator != null && !fileDescriptorFilterCreateOutputIterator.isInputFilter()) {
                    SaveCustomFilter(this.impl, fileDescriptorFilterCreateOutputIterator.__GetHandle(), j);
                }
                ReachabilityHelper.ensureReachable(fileDescriptorFilterCreateOutputIterator);
                m1196a();
                this.mCustomFilter = filter;
                filter.__SetRefHandle(this);
                return;
            }
        }
        if ((filter instanceof SecondaryFileFilter) && filter.isInputFilter()) {
            SecondaryFileFilter secondaryFileFilterCreateOutputIterator = ((SecondaryFileFilter) filter).createOutputIterator();
            if (secondaryFileFilterCreateOutputIterator == null || secondaryFileFilterCreateOutputIterator.isInputFilter()) {
                return;
            }
            try {
                SaveCustomFilter(this.impl, secondaryFileFilterCreateOutputIterator.__GetHandle(), j);
                return;
            } finally {
                secondaryFileFilterCreateOutputIterator.close();
            }
        }
        if (!filter.isInputFilter()) {
            SaveCustomFilter(this.impl, filter.__GetHandle(), j);
            ReachabilityHelper.ensureReachable(filter);
            return;
        }
        throw new PDFNetException(CredentialEntry.FALSE_STRING, 568L, "PDFDoc.java", "PDFDoc(save)", "The filter is not an output filter.");
    }

    public void save(Filter filter, SDFDoc.SaveMode saveMode) throws PDFNetException, IOException {
        save(filter, saveMode.getValue());
    }

    public void save(Filter filter, SDFDoc.SaveMode[] saveModeArr) throws PDFNetException, IOException {
        long value = 0;
        if (saveModeArr != null) {
            for (SDFDoc.SaveMode saveMode : saveModeArr) {
                value |= (long) saveMode.getValue();
            }
        }
        save(filter, value);
    }

    public void save(long j) throws PDFNetException, IOException {
        if (j != 32769) {
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 1082L, "PDFDoc.java", "PDFDoc(save)", "This flag is not supported.");
        }
        Filter filter = this.mCustomFilter;
        if (filter != null && (filter instanceof FileDescriptorFilter)) {
            FileDescriptorFilter fileDescriptorFilterCreateOutputIterator = ((FileDescriptorFilter) filter).createOutputIterator();
            if (fileDescriptorFilterCreateOutputIterator != null && !fileDescriptorFilterCreateOutputIterator.isInputFilter()) {
                this.mCustomFilter = FileDescriptorFilter.__Create(SaveCustomFilter2(this.impl, fileDescriptorFilterCreateOutputIterator.__GetHandle(), j), fileDescriptorFilterCreateOutputIterator);
                return;
            }
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 1092L, "PDFDoc.java", "PDFDoc.save(long)", "The filter is not an output filter.");
        }
        if (filter != null && (filter instanceof SecondaryFileFilter)) {
            SecondaryFileFilter secondaryFileFilterCreateOutputIterator = ((SecondaryFileFilter) filter).createOutputIterator();
            if (secondaryFileFilterCreateOutputIterator != null && !secondaryFileFilterCreateOutputIterator.isInputFilter()) {
                try {
                    SaveCustomFilter2(this.impl, secondaryFileFilterCreateOutputIterator.__GetHandle(), j);
                    return;
                } finally {
                    secondaryFileFilterCreateOutputIterator.close();
                }
            }
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 1105L, "PDFDoc.java", "PDFDoc.save(long)", "The filter is not an output filter.");
        }
        throw new PDFNetException(CredentialEntry.FALSE_STRING, 1110L, "PDFDoc.java", "PDFDoc(save)", "Custom filter is not valid.");
    }

    public void save() throws PDFNetException, IOException {
        if (this.f1615a != null) {
            Save(this.impl, this.f1615a, 1L, null);
        } else {
            save(32769L);
        }
    }

    public boolean saveIncrementalData(String str) throws PDFNetException {
        return SaveIncrementalData(this.impl, str);
    }

    public void saveCustomSignature(byte[] bArr, DigitalSignatureField digitalSignatureField, String str) throws PDFNetException, IOException {
        SaveCustomSignaturePath(this.impl, bArr, digitalSignatureField.__GetHandle(), str);
        ReachabilityHelper.ensureReachable(digitalSignatureField);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void saveCustomSignature(byte[] bArr, DigitalSignatureField digitalSignatureField, Filter filter) throws PDFNetException, IOException {
        if ((filter instanceof FileDescriptorFilter) && filter.isInputFilter()) {
            FileDescriptorFilter fileDescriptorFilter = (FileDescriptorFilter) filter;
            if (fileDescriptorFilter.canWriteOnInputFilter()) {
                FileDescriptorFilter fileDescriptorFilterCreateOutputIterator = fileDescriptorFilter.createOutputIterator();
                if (fileDescriptorFilterCreateOutputIterator != null && !fileDescriptorFilterCreateOutputIterator.isInputFilter()) {
                    SaveCustomSignatureCustomFilter(this.impl, bArr, digitalSignatureField.__GetHandle(), fileDescriptorFilterCreateOutputIterator.__GetHandle());
                }
                ReachabilityHelper.ensureReachable(fileDescriptorFilterCreateOutputIterator);
                m1196a();
                this.mCustomFilter = filter;
                filter.__SetRefHandle(this);
            }
        } else if ((filter instanceof SecondaryFileFilter) && filter.isInputFilter()) {
            SecondaryFileFilter secondaryFileFilterCreateOutputIterator = ((SecondaryFileFilter) filter).createOutputIterator();
            if (secondaryFileFilterCreateOutputIterator != null && !secondaryFileFilterCreateOutputIterator.isInputFilter()) {
                try {
                    SaveCustomSignatureCustomFilter(this.impl, bArr, digitalSignatureField.__GetHandle(), secondaryFileFilterCreateOutputIterator.__GetHandle());
                } finally {
                    secondaryFileFilterCreateOutputIterator.close();
                }
            }
        } else if (!filter.isInputFilter()) {
            SaveCustomSignatureCustomFilter(this.impl, bArr, digitalSignatureField.__GetHandle(), filter.__GetHandle());
            ReachabilityHelper.ensureReachable(filter);
        } else {
            throw new PDFNetException(CredentialEntry.FALSE_STRING, 1204L, "PDFDoc.java", "PDFDoc(saveCustomSignature)", "The filter is not an output filter.");
        }
        ReachabilityHelper.ensureReachable(digitalSignatureField);
    }

    public PageIterator getPageIterator() throws PDFNetException {
        return new PageIterator(GetPageIteratorBegin(this.impl), this);
    }

    public PageIterator getPageIterator(int i) throws PDFNetException {
        return new PageIterator(GetPageIterator(this.impl, i), this);
    }

    public Page getPage(int i) throws PDFNetException {
        long jGetPage = GetPage(this.impl, i);
        if (jGetPage != 0) {
            return new Page(jGetPage, this);
        }
        return null;
    }

    public void pageRemove(PageIterator pageIterator) throws PDFNetException {
        PageRemove(this.impl, pageIterator.m1466a());
        ReachabilityHelper.ensureReachable(pageIterator);
    }

    public void pageInsert(PageIterator pageIterator, Page page) throws PDFNetException {
        PageInsert(this.impl, pageIterator.m1466a(), page.f1990a);
        ReachabilityHelper.ensureReachable(pageIterator);
        ReachabilityHelper.ensureReachable(page);
    }

    public void insertPages(int i, PDFDoc pDFDoc, int i2, int i3, int i4, ProgressMonitor progressMonitor) throws PDFNetException {
        PageSet pageSet = new PageSet();
        pageSet.addRange(i2, i3);
        insertPages(i, pDFDoc, pageSet, i4, progressMonitor);
        pageSet.destroy();
    }

    public void insertPages(int i, PDFDoc pDFDoc, int i2, int i3, InsertBookmarkMode insertBookmarkMode, ProgressMonitor progressMonitor) throws PDFNetException {
        insertPages(i, pDFDoc, i2, i3, insertBookmarkMode.getValue(), progressMonitor);
    }

    public void insertPages(int i, PDFDoc pDFDoc, PageSet pageSet, int i2, ProgressMonitor progressMonitor) throws PDFNetException {
        InsertPageSet(this.impl, i, pDFDoc.impl, pageSet.f1995a, i2, progressMonitor);
        ReachabilityHelper.ensureReachable(pageSet);
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    public void insertPages(int i, PDFDoc pDFDoc, PageSet pageSet, InsertBookmarkMode insertBookmarkMode, ProgressMonitor progressMonitor) throws PDFNetException {
        insertPages(i, pDFDoc, pageSet, insertBookmarkMode.getValue(), progressMonitor);
    }

    public void movePages(int i, PDFDoc pDFDoc, int i2, int i3, int i4, ProgressMonitor progressMonitor) throws PDFNetException {
        PageSet pageSet = new PageSet();
        pageSet.addRange(i2, i3);
        movePages(i, pDFDoc, pageSet, i4, progressMonitor);
        pageSet.destroy();
    }

    public void movePages(int i, PDFDoc pDFDoc, int i2, int i3, InsertBookmarkMode insertBookmarkMode, ProgressMonitor progressMonitor) throws PDFNetException {
        movePages(i, pDFDoc, i2, i3, insertBookmarkMode.getValue(), progressMonitor);
    }

    public void movePages(int i, PDFDoc pDFDoc, PageSet pageSet, int i2, ProgressMonitor progressMonitor) throws PDFNetException {
        MovePageSet(this.impl, i, pDFDoc.impl, pageSet.f1995a, i2, progressMonitor);
        ReachabilityHelper.ensureReachable(pageSet);
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    public void movePages(int i, PDFDoc pDFDoc, PageSet pageSet, InsertBookmarkMode insertBookmarkMode, ProgressMonitor progressMonitor) throws PDFNetException {
        MovePageSet(this.impl, i, pDFDoc.impl, pageSet.f1995a, insertBookmarkMode.getValue(), progressMonitor);
        ReachabilityHelper.ensureReachable(pageSet);
        ReachabilityHelper.ensureReachable(pDFDoc);
    }

    public void pagePushFront(Page page) throws PDFNetException {
        PagePushFront(this.impl, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
    }

    public void pagePushBack(Page page) throws PDFNetException {
        PagePushBack(this.impl, page.f1990a);
        ReachabilityHelper.ensureReachable(page);
    }

    public Page[] importPages(Page[] pageArr) throws PDFNetException {
        return importPages(pageArr, false);
    }

    public Page[] importPages(Page[] pageArr, boolean z) throws PDFNetException {
        long[] jArr = new long[pageArr.length];
        for (int i = 0; i < pageArr.length; i++) {
            jArr[i] = pageArr[i].f1990a;
        }
        long[] jArrImportPages = ImportPages(this.impl, jArr, z);
        Page[] pageArr2 = new Page[jArrImportPages.length];
        for (int i2 = 0; i2 < jArrImportPages.length; i2++) {
            pageArr2[i2] = new Page(jArrImportPages[i2], this);
        }
        ReachabilityHelper.ensureReachable(pageArr);
        return pageArr2;
    }

    public int appendTextDiff(Page page, Page page2) throws PDFNetException {
        int iAppendTextDiffPage = AppendTextDiffPage(this.impl, page.f1990a, page2.f1990a);
        ReachabilityHelper.ensureReachable(page);
        ReachabilityHelper.ensureReachable(page2);
        return iAppendTextDiffPage;
    }

    public int appendTextDiff(PDFDoc pDFDoc, PDFDoc pDFDoc2) throws PDFNetException {
        int iAppendTextDiffDoc = AppendTextDiffDoc(this.impl, pDFDoc.__GetHandle(), pDFDoc2.__GetHandle(), 0L);
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(pDFDoc2);
        return iAppendTextDiffDoc;
    }

    public int appendTextDiff(PDFDoc pDFDoc, PDFDoc pDFDoc2, TextDiffOptions textDiffOptions) throws PDFNetException {
        int iAppendTextDiffDoc = AppendTextDiffDoc(this.impl, pDFDoc.__GetHandle(), pDFDoc2.__GetHandle(), textDiffOptions == null ? 0L : textDiffOptions.mo1134a());
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(pDFDoc2);
        ReachabilityHelper.ensureReachable(textDiffOptions);
        return iAppendTextDiffDoc;
    }

    public static int highlightTextDiff(PDFDoc pDFDoc, PDFDoc pDFDoc2, TextDiffOptions textDiffOptions) throws PDFNetException {
        int iHighlightTextDiff = HighlightTextDiff(pDFDoc.__GetHandle(), pDFDoc2.__GetHandle(), textDiffOptions == null ? 0L : textDiffOptions.mo1134a());
        ReachabilityHelper.ensureReachable(pDFDoc);
        ReachabilityHelper.ensureReachable(pDFDoc2);
        ReachabilityHelper.ensureReachable(textDiffOptions);
        return iHighlightTextDiff;
    }

    public Page pageCreate() throws PDFNetException {
        return pageCreate(new Rect(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 612.0d, 792.0d));
    }

    public Page pageCreate(Rect rect) throws PDFNetException {
        Page page = new Page(PageCreate(this.impl, rect.f2037a), this);
        ReachabilityHelper.ensureReachable(rect);
        return page;
    }

    public Bookmark getFirstBookmark() throws PDFNetException {
        return new Bookmark(GetFirstBookmark(this.impl), this);
    }

    public void addRootBookmark(Bookmark bookmark) throws PDFNetException {
        AddRootBookmark(this.impl, bookmark.f1449a);
        ReachabilityHelper.ensureReachable(bookmark);
    }

    public Obj getTrailer() throws PDFNetException {
        return Obj.__Create(GetTrailer(this.impl), this);
    }

    public Obj getRoot() throws PDFNetException {
        return Obj.__Create(GetRoot(this.impl), this);
    }

    public void initializeJSContext() throws PDFNetException {
        JSContextInitialize(this.impl);
    }

    public Obj getPages() throws PDFNetException {
        return Obj.__Create(GetPages(this.impl), this);
    }

    public int getPageCount() throws PDFNetException {
        return GetPagesCount(this.impl);
    }

    public FieldIterator getFieldIterator() throws PDFNetException {
        return new FieldIterator(GetFieldIteratorBegin(this.impl), this);
    }

    public FieldIterator getFieldIterator(String str) throws PDFNetException {
        return new FieldIterator(GetFieldIterator(this.impl, str), this);
    }

    public Field getField(String str) throws PDFNetException {
        long jGetField = GetField(this.impl, str);
        if (jGetField != 0) {
            return new Field(jGetField, this);
        }
        return null;
    }

    public Field fieldCreate(String str, int i) throws PDFNetException {
        return new Field(FieldCreate(this.impl, str, i, 0L, 0L), this);
    }

    public Field fieldCreate(String str, int i, Obj obj) throws PDFNetException {
        Field field = new Field(FieldCreate(this.impl, str, i, obj.__GetHandle(), 0L), this);
        ReachabilityHelper.ensureReachable(obj);
        return field;
    }

    public Field fieldCreate(String str, int i, Obj obj, Obj obj2) throws PDFNetException {
        Field field = new Field(FieldCreate(this.impl, str, i, obj.__GetHandle(), obj2.__GetHandle()), this);
        ReachabilityHelper.ensureReachable(obj);
        ReachabilityHelper.ensureReachable(obj2);
        return field;
    }

    public Field fieldCreate(String str, int i, String str2, String str3) throws PDFNetException {
        return new Field(FieldCreate(this.impl, str, i, str2, str3), this);
    }

    public Field fieldCreate(String str, int i, String str2) throws PDFNetException {
        return new Field(FieldCreate(this.impl, str, i, str2, ""), this);
    }

    public void refreshFieldAppearances() throws PDFNetException {
        RefreshFieldAppearances(this.impl);
    }

    public void refreshAnnotAppearances() throws PDFNetException {
        RefreshAnnotAppearances(this.impl, 0L);
    }

    public void refreshAnnotAppearances(RefreshOptions refreshOptions) throws PDFNetException {
        RefreshAnnotAppearances(this.impl, refreshOptions != null ? refreshOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(refreshOptions);
    }

    public void flattenAnnotations(boolean z) throws PDFNetException {
        FlattenAnnotations(this.impl, z);
    }

    public void flattenAnnotations() throws PDFNetException {
        FlattenAnnotations(this.impl, false);
    }

    public void flattenAnnotationsAdvanced(long j) throws PDFNetException {
        FlattenAnnotationsAdvanced(this.impl, j);
    }

    public void flattenAnnotationsAdvanced(FlattenMode[] flattenModeArr) throws PDFNetException {
        long value = 0;
        if (flattenModeArr != null) {
            for (FlattenMode flattenMode : flattenModeArr) {
                value |= (long) flattenMode.getValue();
            }
        }
        FlattenAnnotationsAdvanced(this.impl, value);
    }

    public Obj getAcroForm() throws PDFNetException {
        return Obj.__Create(GetAcroForm(this.impl), this);
    }

    public FDFDoc fdfExtract() throws PDFNetException {
        return FDFDoc.__Create(FDFExtract(this.impl, 0));
    }

    public FDFDoc fdfExtract(int i) throws PDFNetException {
        return FDFDoc.__Create(FDFExtract(this.impl, i));
    }

    public FDFDoc fdfExtract(PageSet pageSet, int i) throws PDFNetException {
        FDFDoc fDFDoc__Create = FDFDoc.__Create(FDFExtract(this.impl, pageSet.f1995a, i));
        ReachabilityHelper.ensureReachable(pageSet);
        return fDFDoc__Create;
    }

    public FDFDoc fdfExtract(ArrayList<Annot> arrayList) throws PDFNetException {
        long[] jArr = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            jArr[i] = arrayList.get(i).getSDFObj().__GetHandle();
        }
        FDFDoc fDFDoc__Create = FDFDoc.__Create(FDFExtract(this.impl, jArr));
        ReachabilityHelper.ensureReachable(arrayList);
        return fDFDoc__Create;
    }

    public FDFDoc fdfExtract(Annot[] annotArr) throws PDFNetException {
        long[] jArr = new long[annotArr.length];
        for (int i = 0; i < annotArr.length; i++) {
            jArr[i] = annotArr[i].getSDFObj().__GetHandle();
        }
        FDFDoc fDFDoc__Create = FDFDoc.__Create(FDFExtract(this.impl, jArr));
        ReachabilityHelper.ensureReachable(annotArr);
        return fDFDoc__Create;
    }

    public FDFDoc fdfExtract(ArrayList<Annot> arrayList, ArrayList<Annot> arrayList2, ArrayList<Annot> arrayList3) throws PDFNetException {
        if (arrayList == null) {
            arrayList = new ArrayList<>(0);
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList<>(0);
        }
        if (arrayList3 == null) {
            arrayList3 = new ArrayList<>(0);
        }
        long[] jArr = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            jArr[i] = arrayList.get(i).getSDFObj().__GetHandle();
        }
        long[] jArr2 = new long[arrayList2.size()];
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            jArr2[i2] = arrayList2.get(i2).getSDFObj().__GetHandle();
        }
        long[] jArr3 = new long[arrayList3.size()];
        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
            jArr3[i3] = arrayList3.get(i3).getSDFObj().__GetHandle();
        }
        FDFDoc fDFDoc__Create = FDFDoc.__Create(FDFExtract(this.impl, jArr, jArr2, jArr3));
        ReachabilityHelper.ensureReachable(arrayList);
        ReachabilityHelper.ensureReachable(arrayList2);
        ReachabilityHelper.ensureReachable(arrayList3);
        return fDFDoc__Create;
    }

    public void fdfMerge(FDFDoc fDFDoc) throws PDFNetException {
        FDFMerge(this.impl, fDFDoc.__GetHandle());
        ReachabilityHelper.ensureReachable(fDFDoc);
    }

    public void fdfUpdate(FDFDoc fDFDoc) throws PDFNetException {
        FDFUpdate(this.impl, fDFDoc.__GetHandle());
        ReachabilityHelper.ensureReachable(fDFDoc);
    }

    public void mergeXFDF(Filter filter, String str) throws PDFNetException {
        MergeXFDF_old(this.impl, filter.__GetHandle(), str);
        ReachabilityHelper.ensureReachable(filter);
    }

    public void mergeXFDF(Filter filter, MergeXFDFOptions mergeXFDFOptions) throws PDFNetException {
        MergeXFDF(this.impl, filter.__GetHandle(), mergeXFDFOptions != null ? mergeXFDFOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(mergeXFDFOptions);
        ReachabilityHelper.ensureReachable(filter);
    }

    public void mergeXFDFString(String str, String str2) throws PDFNetException {
        MergeXFDFString_old(this.impl, str, str2);
    }

    public void mergeXFDFString(String str, MergeXFDFOptions mergeXFDFOptions) throws PDFNetException {
        MergeXFDFString(this.impl, str, mergeXFDFOptions != null ? mergeXFDFOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(mergeXFDFOptions);
    }

    public Action getOpenAction() throws PDFNetException {
        return new Action(GetOpenAction(this.impl), this);
    }

    public void setOpenAction(Action action) throws PDFNetException {
        SetOpenAction(this.impl, action.f1435a);
        ReachabilityHelper.ensureReachable(action);
    }

    public void addFileAttachment(String str, FileSpec fileSpec) throws PDFNetException {
        AddFileAttachment(this.impl, str, fileSpec.f1544a);
        ReachabilityHelper.ensureReachable(fileSpec);
    }

    public PageLabel getPageLabel(int i) throws PDFNetException {
        return new PageLabel(GetPageLabel(this.impl, i), this);
    }

    public void setPageLabel(int i, PageLabel pageLabel) throws PDFNetException {
        SetPageLabel(this.impl, i, pageLabel.f1993a);
        ReachabilityHelper.ensureReachable(pageLabel);
    }

    public void removePageLabel(int i) throws PDFNetException {
        RemovePageLabel(this.impl, i);
    }

    public STree getStructTree() throws PDFNetException {
        return STree.__Create(GetStructTree(this.impl), this);
    }

    public boolean hasOC() throws PDFNetException {
        return HasOC(this.impl);
    }

    public Obj getOCGs() throws PDFNetException {
        return Obj.__Create(GetOCGs(this.impl), this);
    }

    public Config getOCGConfig() throws PDFNetException {
        return Config.__Create(GetOCGConfig(this.impl), this);
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
        Obj obj__Create = Obj.__Create(CreateIndirectStream(this.impl, filterReader.__GetHandle(), 0L), this);
        ReachabilityHelper.ensureReachable(filterReader);
        return obj__Create;
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

    public SDFDoc getSDFDoc() {
        return SDFDoc.__Create(this.impl, this);
    }

    public void lock() throws PDFNetException {
        Lock(this.impl);
    }

    public void unlock() throws PDFNetException {
        Unlock(this.impl);
    }

    public boolean tryLock() throws PDFNetException {
        return TryLock(this.impl, 0);
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

    public void generateThumbnails(long j) throws PDFNetException {
        GenerateThumbnails(this.impl, j);
    }

    public void appendVisualDiff(Page page, Page page2, DiffOptions diffOptions) throws PDFNetException {
        AppendVisualDiff(this.impl, page != null ? page.f1990a : 0L, page2 != null ? page2.f1990a : 0L, diffOptions != null ? diffOptions.mo1134a() : 0L);
        ReachabilityHelper.ensureReachable(diffOptions);
        ReachabilityHelper.ensureReachable(page);
        ReachabilityHelper.ensureReachable(page2);
    }

    public long getDownloadedByteCount() throws PDFNetException {
        return GetDownloadedByteCount(this.impl);
    }

    public long getTotalRemoteByteCount() throws PDFNetException {
        return GetTotalRemoteByteCount(this.impl);
    }

    public boolean hasDownloader() throws PDFNetException {
        return HasDownloader(this.impl);
    }

    public UndoManager getUndoManager() throws PDFNetException {
        return new UndoManager(GetUndoManager(this.impl));
    }

    public void removeSecurity() {
        RemoveSecurity(this.impl);
    }

    public void addHighlights(String str) {
        AddHighlights(this.impl, str);
    }

    public boolean isTagged() {
        return IsTagged(this.impl);
    }

    public boolean hasSignatures() {
        return HasSignatures(this.impl);
    }

    public long addSignatureHandler(SignatureHandler signatureHandler) throws PDFNetException {
        return AddSignatureHandler(this.impl, signatureHandler);
    }

    public long addStdSignatureHandler(String str, String str2) throws PDFNetException {
        return AddStdSignatureHandlerFromFile(this.impl, str, str2);
    }

    public long addStdSignatureHandler(byte[] bArr, String str) throws PDFNetException {
        return AddStdSignatureHandlerFromBuffer(this.impl, bArr, str);
    }

    public void removeSignatureHandler(long j) throws PDFNetException {
        RemoveSignatureHandler(this.impl, j);
    }

    public SignatureHandler getSignatureHandler(long j) throws PDFNetException {
        return GetSignatureHandler(this.impl, j);
    }

    public DigitalSignatureField createDigitalSignatureField(String str) throws PDFNetException {
        return new DigitalSignatureField(CreateDigitalSignatureField(this.impl, str), this);
    }

    public DigitalSignatureField createDigitalSignatureField() throws PDFNetException {
        return new DigitalSignatureField(CreateDigitalSignatureField(this.impl), this);
    }

    public DigitalSignatureFieldIterator getDigitalSignatureFieldIterator() throws PDFNetException {
        return new DigitalSignatureFieldIterator(GetDigitalSignatureFieldIteratorBegin(this.impl), this);
    }

    public DigitalSignatureField.DocumentPermissions getDigitalSignaturePermissions() throws PDFNetException {
        return DigitalSignatureField.DocumentPermissions.m1153a(GetDigitalSignaturePermissions(this.impl));
    }

    public void saveViewerOptimized(String str, ViewerOptimizedOptions viewerOptimizedOptions) throws PDFNetException {
        SaveViewerOptimized(this.impl, str, viewerOptimizedOptions.f2100a.__GetHandle());
        ReachabilityHelper.ensureReachable(viewerOptimizedOptions);
    }

    public byte[] saveViewerOptimized(ViewerOptimizedOptions viewerOptimizedOptions) throws PDFNetException {
        byte[] bArrSaveViewerOptimizedBuffer = SaveViewerOptimizedBuffer(this.impl, viewerOptimizedOptions.f2100a.__GetHandle());
        ReachabilityHelper.ensureReachable(viewerOptimizedOptions);
        return bArrSaveViewerOptimizedBuffer;
    }

    public enum SignaturesVerificationStatus {
        e_unsigned(0),
        e_failure(1),
        e_untrusted(2),
        e_unsupported(3),
        e_verified(4);


        /* JADX INFO: renamed from: b */
        private static HashMap<Integer, SignaturesVerificationStatus> f1622b = new HashMap<>();

        /* JADX INFO: renamed from: a */
        private int f1624a;

        static {
            for (SignaturesVerificationStatus signaturesVerificationStatus : values()) {
                f1622b.put(Integer.valueOf(signaturesVerificationStatus.f1624a), signaturesVerificationStatus);
            }
        }

        SignaturesVerificationStatus(int i) {
            this.f1624a = i;
        }

        /* JADX INFO: renamed from: a */
        static SignaturesVerificationStatus m1197a(int i) {
            return f1622b.get(Integer.valueOf(i));
        }
    }

    public SignaturesVerificationStatus verifySignedDigitalSignatures(VerificationOptions verificationOptions) throws PDFNetException {
        SignaturesVerificationStatus signaturesVerificationStatusM1197a = SignaturesVerificationStatus.m1197a(VerifySignedDigitalSignatures(this.impl, verificationOptions.__GetHandle()));
        ReachabilityHelper.ensureReachable(verificationOptions);
        return signaturesVerificationStatusM1197a;
    }

    PDFDoc(long j) {
        this.mCustomFilter = null;
        this.f1615a = null;
        this.impl = j;
    }

    public static PDFDoc __Create(long j) {
        return new PDFDoc(j);
    }

    @Override // com.pdftron.sdf.Doc
    public long __GetHandle() {
        return this.impl;
    }
}
