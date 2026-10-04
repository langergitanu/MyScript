package com.myscript.snt.core;

import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.Page;
import com.myscript.atk.core.SWIGVectorString;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class MigrationAssistant {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public MigrationAssistant(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(MigrationAssistant migrationAssistant) {
        if (migrationAssistant == null) {
            return 0L;
        }
        return migrationAssistant.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboEngineJNI.delete_MigrationAssistant(j);
            }
            this.swigCPtr = 0L;
        }
    }

    private static long SwigConstructMigrationAssistant(String str, List<String> list, ITypesetListener iTypesetListener, String str2) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        return NeboEngineJNI.new_MigrationAssistant(str.getBytes(), SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, iTypesetListener, str2.getBytes());
    }

    public MigrationAssistant(String str, List<String> list, ITypesetListener iTypesetListener, String str2) {
        this(SwigConstructMigrationAssistant(str, list, iTypesetListener, str2), true);
    }

    public void setConfDirs(List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        NeboEngineJNI.MigrationAssistant_setConfDirs(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public void setMigrationAssistantListener(IMigrationAssistantListener iMigrationAssistantListener) {
        NeboEngineJNI.MigrationAssistant_setMigrationAssistantListener(this.swigCPtr, this, iMigrationAssistantListener);
    }

    public void migrate(String str, int i) {
        NeboEngineJNI.MigrationAssistant_migrate__SWIG_0(this.swigCPtr, this, str.getBytes(), i);
    }

    public void migrate(Page page, C6917x831fd516 c6917x831fd516, String str) {
        NeboEngineJNI.MigrationAssistant_migrate__SWIG_1(this.swigCPtr, this, Page.getCPtr(page), page, C6917x831fd516.getCPtr(c6917x831fd516), str.getBytes());
    }

    public void migrate(Page page, C6917x831fd516 c6917x831fd516) {
        NeboEngineJNI.MigrationAssistant_migrate__SWIG_2(this.swigCPtr, this, Page.getCPtr(page), page, C6917x831fd516.getCPtr(c6917x831fd516));
    }

    public void migrate(Page page) {
        NeboEngineJNI.MigrationAssistant_migrate__SWIG_3(this.swigCPtr, this, Page.getCPtr(page), page);
    }

    public void cancel() {
        NeboEngineJNI.MigrationAssistant_cancel(this.swigCPtr, this);
    }

    public static boolean findFileSystemCallback(Object obj, Object obj2) {
        return NeboEngineJNI.MigrationAssistant_findFileSystemCallback(obj, obj2);
    }

    public SWIGTYPE_p_std__mapT_std__string_bool_t getIinkSdkExtraPartTypes() {
        return new SWIGTYPE_p_std__mapT_std__string_bool_t(NeboEngineJNI.MigrationAssistant_iinkSdkExtraPartTypes_get(this.swigCPtr, this), true);
    }
}
