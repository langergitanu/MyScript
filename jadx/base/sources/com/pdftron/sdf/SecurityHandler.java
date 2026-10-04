package com.pdftron.sdf;

/* JADX INFO: loaded from: classes7.dex */
public class SecurityHandler implements AutoCloseable, Cloneable {
    public static final int e_AES = 3;
    public static final int e_AES_256 = 4;
    public static final int e_RC4_128 = 2;
    public static final int e_RC4_40 = 1;
    public static final int e_access_support = 9;
    public static final int e_assemble_doc = 10;
    public static final int e_doc_modify = 3;
    public static final int e_doc_open = 2;
    public static final int e_extract_content = 6;
    public static final int e_fill_forms = 8;
    public static final int e_mod_annot = 7;
    public static final int e_owner = 1;
    public static final int e_print = 4;
    public static final int e_print_high = 5;

    /* JADX INFO: renamed from: a */
    long f2187a;

    /* JADX INFO: renamed from: b */
    Object f2188b;

    static native void ChangeMasterPassword(long j, String str);

    static native void ChangeMasterPasswordBuffer(long j, byte[] bArr);

    static native void ChangeRevisionNumber(long j, int i);

    static native void ChangeUserPassword(long j, String str);

    static native void ChangeUserPasswordBuffer(long j, byte[] bArr);

    static native long Clone(long j);

    static native void Destroy(long j);

    static native int GetEncryptionAlgorithmID(long j);

    static native String GetHandlerDocName(long j);

    static native int GetKeyLength(long j);

    static native String GetMasterPassword(long j);

    static native boolean GetPermission(long j, int i);

    static native int GetRevisionNumber(long j);

    static native String GetUserPassword(long j);

    static native boolean IsAES(long j);

    static native boolean IsAES(long j, long j2);

    static native boolean IsMasterPasswordRequired(long j);

    static native boolean IsModified(long j);

    static native boolean IsRC4(long j);

    static native boolean IsUserPasswordRequired(long j);

    static native long SecurityHandlerCreate();

    static native long SecurityHandlerCreate(int i);

    static native long SecurityHandlerCreate(int i, int i2);

    static native void SetEncryptMetadata(long j, boolean z);

    static native void SetModified(long j, boolean z);

    static native void SetPermission(long j, int i, boolean z);

    public boolean getPermission(int i) {
        return GetPermission(this.f2187a, i);
    }

    public Object clone() {
        return new SecurityHandler(Clone(this.f2187a), (Object) null);
    }

    public int getKeyLength() {
        return GetKeyLength(this.f2187a);
    }

    public int getEncryptionAlgorithmID() {
        return GetEncryptionAlgorithmID(this.f2187a);
    }

    public String getHandlerDocName() {
        return GetHandlerDocName(this.f2187a);
    }

    public boolean isModified() {
        return IsModified(this.f2187a);
    }

    public void setModified() {
        SetModified(this.f2187a, true);
    }

    public void setModified(boolean z) {
        SetModified(this.f2187a, z);
    }

    public SecurityHandler(int i) {
        this.f2187a = SecurityHandlerCreate(i);
        this.f2188b = null;
    }

    public SecurityHandler(int i, int i2) {
        this.f2187a = SecurityHandlerCreate(i, i2);
        this.f2188b = null;
    }

    public SecurityHandler() {
        this.f2187a = SecurityHandlerCreate();
        this.f2188b = null;
    }

    protected void finalize() throws Throwable {
        destroy();
    }

    public void destroy() {
        long j = this.f2187a;
        if (j == 0 || this.f2188b != null) {
            return;
        }
        Destroy(j);
        this.f2187a = 0L;
    }

    public void changeUserPassword(String str) {
        ChangeUserPassword(this.f2187a, str);
    }

    public void changeUserPassword(byte[] bArr) {
        ChangeUserPasswordBuffer(this.f2187a, bArr);
    }

    public String getUserPassword() {
        return GetUserPassword(this.f2187a);
    }

    public void changeMasterPassword(String str) {
        ChangeMasterPassword(this.f2187a, str);
    }

    public void changeMasterPassword(byte[] bArr) {
        ChangeMasterPasswordBuffer(this.f2187a, bArr);
    }

    public String getMasterPassword() {
        return GetMasterPassword(this.f2187a);
    }

    public void setPermission(int i, boolean z) {
        SetPermission(this.f2187a, i, z);
    }

    public void changeRevisionNumber(int i) {
        ChangeRevisionNumber(this.f2187a, i);
    }

    public void setEncryptMetadata(boolean z) {
        SetEncryptMetadata(this.f2187a, z);
    }

    public int getRevisionNumber() {
        return GetRevisionNumber(this.f2187a);
    }

    public boolean isUserPasswordRequired() {
        return IsUserPasswordRequired(this.f2187a);
    }

    public boolean isMasterPasswordRequired() {
        return IsMasterPasswordRequired(this.f2187a);
    }

    public boolean isAES() {
        return IsAES(this.f2187a);
    }

    public boolean isAES(Obj obj) {
        return IsAES(this.f2187a, obj.f2180a);
    }

    public boolean isRC4() {
        return IsRC4(this.f2187a);
    }

    SecurityHandler(long j, Object obj) {
        this.f2187a = j;
        this.f2188b = obj;
    }

    public static SecurityHandler __Create(long j, Object obj) {
        return new SecurityHandler(j, obj);
    }

    public long __GetHandle() {
        return this.f2187a;
    }

    public void __SetRefHandle(Object obj) {
        this.f2188b = obj;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        destroy();
    }
}
