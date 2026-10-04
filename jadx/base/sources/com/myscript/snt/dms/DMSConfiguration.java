package com.myscript.snt.dms;

import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class DMSConfiguration {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DMSConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DMSConfiguration dMSConfiguration) {
        if (dMSConfiguration == null) {
            return 0L;
        }
        return dMSConfiguration.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_DMSConfiguration(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public void setRootNotesPath(String str) {
        NeboDMSJNI.DMSConfiguration_rootNotesPath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getRootNotesPath() {
        return new String(NeboDMSJNI.DMSConfiguration_rootNotesPath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setDatabaseDirPath(String str) {
        NeboDMSJNI.DMSConfiguration_databaseDirPath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getDatabaseDirPath() {
        return new String(NeboDMSJNI.DMSConfiguration_databaseDirPath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setAppVersion(String str) {
        NeboDMSJNI.DMSConfiguration_appVersion_set(this.swigCPtr, this, str.getBytes());
    }

    public String getAppVersion() {
        return new String(NeboDMSJNI.DMSConfiguration_appVersion_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setWorkingDirPath(String str) {
        NeboDMSJNI.DMSConfiguration_workingDirPath_set(this.swigCPtr, this, str.getBytes());
    }

    public String getWorkingDirPath() {
        return new String(NeboDMSJNI.DMSConfiguration_workingDirPath_get(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public void setUuidGenerator(SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t) {
        NeboDMSJNI.DMSConfiguration_uuidGenerator_set(this.swigCPtr, this, SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t));
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t getUuidGenerator() {
        long jDMSConfiguration_uuidGenerator_get = NeboDMSJNI.DMSConfiguration_uuidGenerator_get(this.swigCPtr, this);
        if (jDMSConfiguration_uuidGenerator_get == 0) {
            return null;
        }
        return new SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t(jDMSConfiguration_uuidGenerator_get, false);
    }

    public void setEnableAutoSync(boolean z) {
        NeboDMSJNI.DMSConfiguration_enableAutoSync_set(this.swigCPtr, this, z);
    }

    public boolean getEnableAutoSync() {
        return NeboDMSJNI.DMSConfiguration_enableAutoSync_get(this.swigCPtr, this);
    }

    public void setEnableTrash(boolean z) {
        NeboDMSJNI.DMSConfiguration_enableTrash_set(this.swigCPtr, this, z);
    }

    public boolean getEnableTrash() {
        return NeboDMSJNI.DMSConfiguration_enableTrash_get(this.swigCPtr, this);
    }

    public void setEnableRecent(boolean z) {
        NeboDMSJNI.DMSConfiguration_enableRecent_set(this.swigCPtr, this, z);
    }

    public boolean getEnableRecent() {
        return NeboDMSJNI.DMSConfiguration_enableRecent_get(this.swigCPtr, this);
    }

    public void setMaxRecentPages(long j) {
        NeboDMSJNI.DMSConfiguration_maxRecentPages_set(this.swigCPtr, this, j);
    }

    public long getMaxRecentPages() {
        return NeboDMSJNI.DMSConfiguration_maxRecentPages_get(this.swigCPtr, this);
    }

    public DMSConfiguration(String str, String str2, String str3, String str4, SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t, boolean z, boolean z2, boolean z3) {
        this(NeboDMSJNI.new_DMSConfiguration__SWIG_0(str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes(), SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t), z, z2, z3), true);
    }

    public DMSConfiguration(String str, String str2, String str3, String str4, SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t, boolean z, boolean z2) {
        this(NeboDMSJNI.new_DMSConfiguration__SWIG_1(str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes(), SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t), z, z2), true);
    }

    public DMSConfiguration(String str, String str2, String str3, String str4, SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t, boolean z) {
        this(NeboDMSJNI.new_DMSConfiguration__SWIG_2(str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes(), SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t), z), true);
    }

    public DMSConfiguration(String str, String str2, String str3, String str4, SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t) {
        this(NeboDMSJNI.new_DMSConfiguration__SWIG_3(str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes(), SWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t.getCPtr(sWIGTYPE_p_std__shared_ptrT_snt__dms__UuidGenerator_t)), true);
    }

    public DMSConfiguration(String str, String str2, String str3, String str4) {
        this(NeboDMSJNI.new_DMSConfiguration__SWIG_4(str.getBytes(), str2.getBytes(), str3.getBytes(), str4.getBytes()), true);
    }

    public DMSConfiguration(String str, String str2, String str3) {
        this(NeboDMSJNI.new_DMSConfiguration__SWIG_5(str.getBytes(), str2.getBytes(), str3.getBytes()), true);
    }
}
