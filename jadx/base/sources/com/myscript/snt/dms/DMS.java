package com.myscript.snt.dms;

import com.myscript.atk.core.CustomResource;
import com.myscript.atk.core.Document;
import com.myscript.atk.core.ICancelableTaskProgressCallback;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.MimeType;
import com.myscript.atk.core.SWIGVectorCustomResource;
import com.myscript.atk.core.SWIGVectorMimeType;
import com.myscript.atk.core.SWIGVectorString;
import com.myscript.atk.core.ViewTransform;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.DisplayContext;
import com.myscript.snt.core.DocumentController;
import com.myscript.snt.core.ExportController;
import com.myscript.snt.core.IRendererListener;
import com.myscript.snt.core.IThumbnailerNotificationListener;
import com.myscript.snt.core.NeboSanitizer;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageControllerSanitized;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.RecoContext;
import com.myscript.snt.core.SWIGOptionContext;
import com.myscript.snt.core.SWIGVectorCollectionKey;
import com.myscript.snt.core.SWIGVectorColors;
import com.myscript.snt.core.SWIGVectorNotebookKey;
import com.myscript.snt.core.SWIGVectorPageKey;
import com.myscript.snt.core.SearchController;
import com.myscript.snt.core.Thumbnailer;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DMS {
    private transient boolean swigCMemOwn;
    private transient long swigCPtr;

    public DMS(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static long getCPtr(DMS dms) {
        if (dms == null) {
            return 0L;
        }
        return dms.swigCPtr;
    }

    protected void finalize() {
        delete();
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                NeboDMSJNI.delete_DMS(j);
            }
            this.swigCPtr = 0L;
        }
    }

    public static DMS create(DMSConfiguration dMSConfiguration) {
        long jDMS_create = NeboDMSJNI.DMS_create(DMSConfiguration.getCPtr(dMSConfiguration), dMSConfiguration);
        if (jDMS_create == 0) {
            return null;
        }
        return new DMS(jDMS_create, true);
    }

    public static String checkDatabaseSchema(DMSConfiguration dMSConfiguration) {
        return new String(NeboDMSJNI.DMS_checkDatabaseSchema(DMSConfiguration.getCPtr(dMSConfiguration), dMSConfiguration), StandardCharsets.UTF_8);
    }

    public void stop(boolean z) {
        NeboDMSJNI.DMS_stop__SWIG_0(this.swigCPtr, this, z);
    }

    public void stop() {
        NeboDMSJNI.DMS_stop__SWIG_1(this.swigCPtr, this);
    }

    public void restart() {
        NeboDMSJNI.DMS_restart(this.swigCPtr, this);
    }

    public void resetListener() {
        NeboDMSJNI.DMS_resetListener(this.swigCPtr, this);
    }

    public void addDMSListener(IDMSListener iDMSListener) {
        NeboDMSJNI.DMS_addDMSListener(this.swigCPtr, this, iDMSListener);
    }

    public void removeDMSListener(IDMSListener iDMSListener) {
        NeboDMSJNI.DMS_removeDMSListener(this.swigCPtr, this, iDMSListener);
    }

    public Thumbnailer thumbnailer() {
        long jDMS_thumbnailer = NeboDMSJNI.DMS_thumbnailer(this.swigCPtr, this);
        if (jDMS_thumbnailer == 0) {
            return null;
        }
        return new Thumbnailer(jDMS_thumbnailer, true);
    }

    public boolean createThumbnail(PageKey pageKey, ViewTransform viewTransform, boolean z) {
        return NeboDMSJNI.DMS_createThumbnail__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, ViewTransform.getCPtr(viewTransform), viewTransform, z);
    }

    public boolean createThumbnail(PageKey pageKey, float f, float f2) {
        return NeboDMSJNI.DMS_createThumbnail__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, f, f2);
    }

    public String thumbnailPath(PageKey pageKey, long j) {
        return new String(NeboDMSJNI.DMS_thumbnailPath(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, j), StandardCharsets.UTF_8);
    }

    public static void clearThumbnails(String str, String str2) {
        NeboDMSJNI.DMS_clearThumbnails(str.getBytes(), str2.getBytes());
    }

    public void setThumbnailConfiguration(float f, float f2, String str, IColorInversionPolicy iColorInversionPolicy) {
        NeboDMSJNI.DMS_setThumbnailConfiguration(this.swigCPtr, this, f, f2, str.getBytes(), iColorInversionPolicy);
    }

    public void addThumbnailNotificationListener(IThumbnailerNotificationListener iThumbnailerNotificationListener) {
        NeboDMSJNI.DMS_addThumbnailNotificationListener(this.swigCPtr, this, iThumbnailerNotificationListener);
    }

    public void removeThumbnailNotificationListener(IThumbnailerNotificationListener iThumbnailerNotificationListener) {
        NeboDMSJNI.DMS_removeThumbnailNotificationListener(this.swigCPtr, this, iThumbnailerNotificationListener);
    }

    public void restartThumbnailer() {
        NeboDMSJNI.DMS_restartThumbnailer(this.swigCPtr, this);
    }

    public void stopThumbnailer() {
        NeboDMSJNI.DMS_stopThumbnailer(this.swigCPtr, this);
    }

    public NeboBackupController createBackupController() {
        long jDMS_createBackupController = NeboDMSJNI.DMS_createBackupController(this.swigCPtr, this);
        if (jDMS_createBackupController == 0) {
            return null;
        }
        return new NeboBackupController(jDMS_createBackupController, true);
    }

    public String backupDataStructure(String str, String str2) {
        return new String(NeboDMSJNI.DMS_backupDataStructure(this.swigCPtr, this, str.getBytes(), str2.getBytes()), StandardCharsets.UTF_8);
    }

    public String dumpCloudV1(String str) {
        return new String(NeboDMSJNI.DMS_dumpCloudV1(this.swigCPtr, this, str.getBytes()), StandardCharsets.UTF_8);
    }

    public static void rawDataBackup(String str, String str2, String str3) {
        NeboDMSJNI.DMS_rawDataBackup(str.getBytes(), str2.getBytes(), str3.getBytes());
    }

    public DocumentController documentController() {
        long jDMS_documentController = NeboDMSJNI.DMS_documentController(this.swigCPtr, this);
        if (jDMS_documentController == 0) {
            return null;
        }
        return new DocumentController(jDMS_documentController, true);
    }

    public void setTypesetListener(ITypesetListener iTypesetListener) {
        NeboDMSJNI.DMS_setTypesetListener(this.swigCPtr, this, iTypesetListener);
    }

    public void setConfsDir(List<String> list) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        NeboDMSJNI.DMS_setConfsDir(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString);
    }

    public void setConflictRenamePattern(String str) {
        NeboDMSJNI.DMS_setConflictRenamePattern(this.swigCPtr, this, str.getBytes());
    }

    public void recoverLostTemporarySaves(String str) {
        NeboDMSJNI.DMS_recoverLostTemporarySaves__SWIG_0(this.swigCPtr, this, str.getBytes());
    }

    public void recoverLostTemporarySaves() {
        NeboDMSJNI.DMS_recoverLostTemporarySaves__SWIG_1(this.swigCPtr, this);
    }

    public void recoverOrphanNotebooks(String str) {
        NeboDMSJNI.DMS_recoverOrphanNotebooks__SWIG_0(this.swigCPtr, this, str.getBytes());
    }

    public void recoverOrphanNotebooks() {
        NeboDMSJNI.DMS_recoverOrphanNotebooks__SWIG_1(this.swigCPtr, this);
    }

    public void setPageCorruptionListener(IPageCorruptionListener iPageCorruptionListener) {
        NeboDMSJNI.DMS_setPageCorruptionListener(this.swigCPtr, this, iPageCorruptionListener);
    }

    public void setCloudDriveInterface(ICloudDriveInterface iCloudDriveInterface) {
        NeboDMSJNI.DMS_setCloudDriveInterface__SWIG_0(this.swigCPtr, this, iCloudDriveInterface);
    }

    public boolean hasMultiEditor(long j) {
        return NeboDMSJNI.DMS_hasMultiEditor(this.swigCPtr, this, j);
    }

    public void syncAllNotebooks(boolean z) {
        NeboDMSJNI.DMS_syncAllNotebooks__SWIG_0(this.swigCPtr, this, z);
    }

    public void syncAllNotebooks() {
        NeboDMSJNI.DMS_syncAllNotebooks__SWIG_1(this.swigCPtr, this);
    }

    public void syncNotebook(NotebookKey notebookKey) {
        NeboDMSJNI.DMS_syncNotebook(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void cancelSync() {
        NeboDMSJNI.DMS_cancelSync(this.swigCPtr, this);
    }

    public boolean resumeSync() {
        return NeboDMSJNI.DMS_resumeSync(this.swigCPtr, this);
    }

    public void cancelNotebookSync(NotebookKey notebookKey) {
        NeboDMSJNI.DMS_cancelNotebookSync(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void waitForOngoingSync() {
        NeboDMSJNI.DMS_waitForOngoingSync(this.swigCPtr, this);
    }

    public void waitForPendingSaves() {
        NeboDMSJNI.DMS_waitForPendingSaves(this.swigCPtr, this);
    }

    public long lastSynchronizationDate() {
        return NeboDMSJNI.DMS_lastSynchronizationDate(this.swigCPtr, this);
    }

    public DMSSyncState syncState() {
        return DMSSyncState.swigToEnum(NeboDMSJNI.DMS_syncState__SWIG_0(this.swigCPtr, this));
    }

    public boolean isLastSyncActionAUserAction() {
        return NeboDMSJNI.DMS_isLastSyncActionAUserAction(this.swigCPtr, this);
    }

    public long numberOfnotebookToSync() {
        return NeboDMSJNI.DMS_numberOfnotebookToSync(this.swigCPtr, this);
    }

    public void clearCache() {
        NeboDMSJNI.DMS_clearCache(this.swigCPtr, this);
    }

    public String debugSyncStates() {
        return new String(NeboDMSJNI.DMS_debugSyncStates(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public boolean isCloudEnabled() {
        return NeboDMSJNI.DMS_isCloudEnabled(this.swigCPtr, this);
    }

    public boolean allowCloudAction() {
        return NeboDMSJNI.DMS_allowCloudAction(this.swigCPtr, this);
    }

    public boolean migrateToV2(IDMSMigrationToV2LogListener iDMSMigrationToV2LogListener, ICancelableTaskProgressCallback iCancelableTaskProgressCallback) {
        return NeboDMSJNI.DMS_migrateToV2__SWIG_0(this.swigCPtr, this, iDMSMigrationToV2LogListener, iCancelableTaskProgressCallback);
    }

    public boolean migrateToV2(IDMSMigrationToV2LogListener iDMSMigrationToV2LogListener) {
        return NeboDMSJNI.DMS_migrateToV2__SWIG_1(this.swigCPtr, this, iDMSMigrationToV2LogListener);
    }

    public long requiredDiskSpaceForMigrationToV2() {
        return NeboDMSJNI.DMS_requiredDiskSpaceForMigrationToV2(this.swigCPtr, this);
    }

    public long userNotebooksCount() {
        return NeboDMSJNI.DMS_userNotebooksCount(this.swigCPtr, this);
    }

    public boolean isAutoSyncEnabled() {
        return NeboDMSJNI.DMS_isAutoSyncEnabled(this.swigCPtr, this);
    }

    public void setAutoSyncEnabled(boolean z) {
        NeboDMSJNI.DMS_setAutoSyncEnabled(this.swigCPtr, this, z);
    }

    public List<Collection> collections(DMSFilter dMSFilter) {
        return new SWIGVectorCollection(NeboDMSJNI.DMS_collections__SWIG_0(this.swigCPtr, this, dMSFilter.swigValue()), true);
    }

    public List<Collection> collections() {
        return new SWIGVectorCollection(NeboDMSJNI.DMS_collections__SWIG_1(this.swigCPtr, this), true);
    }

    public Collection collectionForCollectionKey(CollectionKey collectionKey) {
        long jDMS_collectionForCollectionKey = NeboDMSJNI.DMS_collectionForCollectionKey(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
        if (jDMS_collectionForCollectionKey == 0) {
            return null;
        }
        return new Collection(jDMS_collectionForCollectionKey, true);
    }

    public Collection collectionFromNotebookKey(NotebookKey notebookKey) {
        long jDMS_collectionFromNotebookKey = NeboDMSJNI.DMS_collectionFromNotebookKey(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
        if (jDMS_collectionFromNotebookKey == 0) {
            return null;
        }
        return new Collection(jDMS_collectionFromNotebookKey, true);
    }

    public Collection lookupCollectionByName(String str) {
        long jDMS_lookupCollectionByName = NeboDMSJNI.DMS_lookupCollectionByName(this.swigCPtr, this, str.getBytes());
        if (jDMS_lookupCollectionByName == 0) {
            return null;
        }
        return new Collection(jDMS_lookupCollectionByName, true);
    }

    public CollectionKey createCollection(String str) {
        return new CollectionKey(NeboDMSJNI.DMS_createCollection(this.swigCPtr, this, str.getBytes()), true);
    }

    public boolean restoreCollection(CollectionKey collectionKey) {
        return NeboDMSJNI.DMS_restoreCollection(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public boolean renameCollection(CollectionKey collectionKey, String str) {
        return NeboDMSJNI.DMS_renameCollection(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, str.getBytes());
    }

    public List<Notebook> notebooks(CollectionKey collectionKey, DMSFilter dMSFilter) {
        return new SWIGVectorNotebook(NeboDMSJNI.DMS_notebooks__SWIG_0(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, dMSFilter.swigValue()), true);
    }

    public List<Notebook> notebooks(CollectionKey collectionKey) {
        return new SWIGVectorNotebook(NeboDMSJNI.DMS_notebooks__SWIG_1(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey), true);
    }

    public long lastModificationDate(CollectionKey collectionKey) {
        return NeboDMSJNI.DMS_lastModificationDate(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public NotebookKey importSampleNotebook(String str, CollectionKey collectionKey, String str2) {
        return new NotebookKey(NeboDMSJNI.DMS_importSampleNotebook(this.swigCPtr, this, str.getBytes(), CollectionKey.getCPtr(collectionKey), collectionKey, str2.getBytes()), true);
    }

    public NotebookKey importNotebook(String str, CollectionKey collectionKey, String str2, boolean z) {
        return new NotebookKey(NeboDMSJNI.DMS_importNotebook__SWIG_0(this.swigCPtr, this, str.getBytes(), CollectionKey.getCPtr(collectionKey), collectionKey, str2.getBytes(), z), true);
    }

    public NotebookKey importNotebook(String str, CollectionKey collectionKey, String str2) {
        return new NotebookKey(NeboDMSJNI.DMS_importNotebook__SWIG_1(this.swigCPtr, this, str.getBytes(), CollectionKey.getCPtr(collectionKey), collectionKey, str2.getBytes()), true);
    }

    public List<PageKey> importPages(String str, NotebookKey notebookKey, ICancelableTaskProgressCallback iCancelableTaskProgressCallback) {
        return new SWIGVectorPageKey(NeboDMSJNI.DMS_importPages__SWIG_0(this.swigCPtr, this, str.getBytes(), NotebookKey.getCPtr(notebookKey), notebookKey, iCancelableTaskProgressCallback), true);
    }

    public List<PageKey> importPages(String str, NotebookKey notebookKey) {
        return new SWIGVectorPageKey(NeboDMSJNI.DMS_importPages__SWIG_1(this.swigCPtr, this, str.getBytes(), NotebookKey.getCPtr(notebookKey), notebookKey), true);
    }

    public boolean restoreNotebook(NotebookKey notebookKey) {
        return NeboDMSJNI.DMS_restoreNotebook(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public boolean moveNotebook(NotebookKey notebookKey, CollectionKey collectionKey, int i) {
        return NeboDMSJNI.DMS_moveNotebook__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, CollectionKey.getCPtr(collectionKey), collectionKey, i);
    }

    public boolean moveNotebook(NotebookKey notebookKey, CollectionKey collectionKey) {
        return NeboDMSJNI.DMS_moveNotebook__SWIG_1(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public boolean renameNotebook(NotebookKey notebookKey, String str) {
        return NeboDMSJNI.DMS_renameNotebook(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes());
    }

    public boolean updateLanguage(NotebookKey notebookKey, String str) {
        return NeboDMSJNI.DMS_updateLanguage(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes());
    }

    public String lastOpenedPageUUID(NotebookKey notebookKey) {
        return new String(NeboDMSJNI.DMS_lastOpenedPageUUID(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey), StandardCharsets.UTF_8);
    }

    public boolean setLastOpenedPageUUID(NotebookKey notebookKey, String str) {
        return NeboDMSJNI.DMS_setLastOpenedPageUUID(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes());
    }

    public Notebook notebookFromPageKey(PageKey pageKey) {
        long jDMS_notebookFromPageKey = NeboDMSJNI.DMS_notebookFromPageKey(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        if (jDMS_notebookFromPageKey == 0) {
            return null;
        }
        return new Notebook(jDMS_notebookFromPageKey, true);
    }

    public Page containerFromPageKey(PageKey pageKey) {
        long jDMS_containerFromPageKey = NeboDMSJNI.DMS_containerFromPageKey(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        if (jDMS_containerFromPageKey == 0) {
            return null;
        }
        return new Page(jDMS_containerFromPageKey, true);
    }

    public Notebook notebookFromKey(NotebookKey notebookKey) {
        long jDMS_notebookFromKey = NeboDMSJNI.DMS_notebookFromKey(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
        if (jDMS_notebookFromKey == 0) {
            return null;
        }
        return new Notebook(jDMS_notebookFromKey, true);
    }

    public Notebook lookupNotebookByName(CollectionKey collectionKey, String str) {
        long jDMS_lookupNotebookByName = NeboDMSJNI.DMS_lookupNotebookByName(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, str.getBytes());
        if (jDMS_lookupNotebookByName == 0) {
            return null;
        }
        return new Notebook(jDMS_lookupNotebookByName, true);
    }

    public String findUniqueNotebookName(CollectionKey collectionKey, String str) {
        return new String(NeboDMSJNI.DMS_findUniqueNotebookName(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, str.getBytes()), StandardCharsets.UTF_8);
    }

    public boolean discardNotebookDeleteFromCloud(NotebookKey notebookKey) {
        return NeboDMSJNI.DMS_discardNotebookDeleteFromCloud(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public Document consolidate(List<String> list, SWIGTYPE_p_snt__dms__ConsolidateParameters sWIGTYPE_p_snt__dms__ConsolidateParameters, String str, SWIGTYPE_p_atk__core__TaskProgressCallback sWIGTYPE_p_atk__core__TaskProgressCallback) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        long jDMS_consolidate__SWIG_0 = NeboDMSJNI.DMS_consolidate__SWIG_0(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, SWIGTYPE_p_snt__dms__ConsolidateParameters.getCPtr(sWIGTYPE_p_snt__dms__ConsolidateParameters), str.getBytes(), SWIGTYPE_p_atk__core__TaskProgressCallback.getCPtr(sWIGTYPE_p_atk__core__TaskProgressCallback));
        if (jDMS_consolidate__SWIG_0 == 0) {
            return null;
        }
        return new Document(jDMS_consolidate__SWIG_0, true);
    }

    public Document consolidate(List<String> list, SWIGTYPE_p_snt__dms__ConsolidateParameters sWIGTYPE_p_snt__dms__ConsolidateParameters, String str) {
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list);
        long jDMS_consolidate__SWIG_1 = NeboDMSJNI.DMS_consolidate__SWIG_1(this.swigCPtr, this, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, SWIGTYPE_p_snt__dms__ConsolidateParameters.getCPtr(sWIGTYPE_p_snt__dms__ConsolidateParameters), str.getBytes());
        if (jDMS_consolidate__SWIG_1 == 0) {
            return null;
        }
        return new Document(jDMS_consolidate__SWIG_1, true);
    }

    public PageKey createPage(NotebookKey notebookKey, String str, int i, PageType pageType, String str2, ICancelableTaskProgressCallback iCancelableTaskProgressCallback) {
        return new PageKey(NeboDMSJNI.DMS_createPage__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes(), i, pageType.swigValue(), str2.getBytes(), iCancelableTaskProgressCallback), true);
    }

    public PageKey createPage(NotebookKey notebookKey, String str, int i, PageType pageType, String str2) {
        return new PageKey(NeboDMSJNI.DMS_createPage__SWIG_1(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes(), i, pageType.swigValue(), str2.getBytes()), true);
    }

    public PageKey createPage(NotebookKey notebookKey, String str, int i, PageType pageType) {
        return new PageKey(NeboDMSJNI.DMS_createPage__SWIG_2(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes(), i, pageType.swigValue()), true);
    }

    public PageKey createPage(NotebookKey notebookKey, String str, int i) {
        return new PageKey(NeboDMSJNI.DMS_createPage__SWIG_3(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes(), i), true);
    }

    public PageKey createPage(NotebookKey notebookKey, String str) {
        return new PageKey(NeboDMSJNI.DMS_createPage__SWIG_4(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes()), true);
    }

    public PageKey createFixedPageSize(PageKey pageKey, String str, float f, float f2, int i, ICancelableTaskProgressCallback iCancelableTaskProgressCallback) {
        return new PageKey(NeboDMSJNI.DMS_createFixedPageSize__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes(), f, f2, i, iCancelableTaskProgressCallback), true);
    }

    public PageKey createFixedPageSize(PageKey pageKey, String str, float f, float f2, int i) {
        return new PageKey(NeboDMSJNI.DMS_createFixedPageSize__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes(), f, f2, i), true);
    }

    public PageKey createFixedPageSize(PageKey pageKey, String str, float f, float f2) {
        return new PageKey(NeboDMSJNI.DMS_createFixedPageSize__SWIG_2(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes(), f, f2), true);
    }

    public PageKey overwritePage(PageKey pageKey, String str) {
        return new PageKey(NeboDMSJNI.DMS_overwritePage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes()), true);
    }

    public Page pageFromKey(PageKey pageKey) {
        long jDMS_pageFromKey = NeboDMSJNI.DMS_pageFromKey(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
        if (jDMS_pageFromKey == 0) {
            return null;
        }
        return new Page(jDMS_pageFromKey, true);
    }

    public Page lookupPageById(NotebookKey notebookKey, String str) {
        long jDMS_lookupPageById = NeboDMSJNI.DMS_lookupPageById(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes());
        if (jDMS_lookupPageById == 0) {
            return null;
        }
        return new Page(jDMS_lookupPageById, true);
    }

    public PageKey resetPageUUID(PageKey pageKey) {
        return new PageKey(NeboDMSJNI.DMS_resetPageUUID(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
    }

    public boolean restorePage(PageKey pageKey) {
        return NeboDMSJNI.DMS_restorePage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public PageKey duplicatePage(PageKey pageKey, int i) {
        return new PageKey(NeboDMSJNI.DMS_duplicatePage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, i), true);
    }

    public List<PageKey> duplicatePages(List<PageKey> list) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        return new SWIGVectorPageKey(NeboDMSJNI.DMS_duplicatePages(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey), true);
    }

    public PageKey createSiblingPage(PageKey pageKey) {
        return new PageKey(NeboDMSJNI.DMS_createSiblingPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
    }

    public PageKey movePage(PageKey pageKey, NotebookKey notebookKey, int i) {
        return new PageKey(NeboDMSJNI.DMS_movePage__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, NotebookKey.getCPtr(notebookKey), notebookKey, i), true);
    }

    public PageKey movePage(PageKey pageKey, NotebookKey notebookKey) {
        return new PageKey(NeboDMSJNI.DMS_movePage__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, NotebookKey.getCPtr(notebookKey), notebookKey), true);
    }

    public PageKey movePage(PageKey pageKey, PageKey pageKey2, int i) {
        return new PageKey(NeboDMSJNI.DMS_movePage__SWIG_2(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, PageKey.getCPtr(pageKey2), pageKey2, i), true);
    }

    public PageKey movePage(PageKey pageKey, PageKey pageKey2) {
        return new PageKey(NeboDMSJNI.DMS_movePage__SWIG_3(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, PageKey.getCPtr(pageKey2), pageKey2), true);
    }

    public boolean movePages(List<PageKey> list, NotebookKey notebookKey) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        return NeboDMSJNI.DMS_movePages__SWIG_0(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public boolean movePages(List<PageKey> list, PageKey pageKey) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        return NeboDMSJNI.DMS_movePages__SWIG_1(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey, PageKey.getCPtr(pageKey), pageKey);
    }

    public PageControllerSanitized open(PageKey pageKey, DisplayContext displayContext, RecoContext recoContext, SWIGTYPE_p_std__mapT_std__string_std__string_t sWIGTYPE_p_std__mapT_std__string_std__string_t) {
        return new PageControllerSanitized(NeboDMSJNI.DMS_open__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext, SWIGTYPE_p_std__mapT_std__string_std__string_t.getCPtr(sWIGTYPE_p_std__mapT_std__string_std__string_t)), true);
    }

    public PageControllerSanitized open(PageKey pageKey, DisplayContext displayContext, RecoContext recoContext) {
        return new PageControllerSanitized(NeboDMSJNI.DMS_open__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext), true);
    }

    public Page openReadOnly(PageKey pageKey) {
        return new Page(NeboDMSJNI.DMS_openReadOnly(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
    }

    public void save(PageController pageController, boolean z, boolean z2) {
        NeboDMSJNI.DMS_save__SWIG_0(this.swigCPtr, this, PageController.getCPtr(pageController), pageController, z, z2);
    }

    public void save(PageController pageController, boolean z) {
        NeboDMSJNI.DMS_save__SWIG_1(this.swigCPtr, this, PageController.getCPtr(pageController), pageController, z);
    }

    public boolean updatePageTitle(PageKey pageKey, String str) {
        return NeboDMSJNI.DMS_updatePageTitle(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes());
    }

    public boolean setBackgroundColor(PageKey pageKey, int i, boolean z) {
        return NeboDMSJNI.DMS_setBackgroundColor__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, i, z);
    }

    public boolean setBackgroundColor(PageKey pageKey, int i) {
        return NeboDMSJNI.DMS_setBackgroundColor__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, i);
    }

    public boolean setLanguage(PageKey pageKey, String str) {
        return NeboDMSJNI.DMS_setLanguage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes());
    }

    public boolean setBackgroundPattern(PageKey pageKey, String str, boolean z) {
        return NeboDMSJNI.DMS_setBackgroundPattern__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes(), z);
    }

    public boolean setBackgroundPattern(PageKey pageKey, String str) {
        return NeboDMSJNI.DMS_setBackgroundPattern__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes());
    }

    public PdfOptimizationResult optimizePageAttachment(PageKey pageKey, PdfOptimizationLevel pdfOptimizationLevel, double d) {
        return PdfOptimizationResult.swigToEnum(NeboDMSJNI.DMS_optimizePageAttachment__SWIG_0(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, pdfOptimizationLevel.swigValue(), d));
    }

    public PdfOptimizationResult optimizePageAttachment(PageKey pageKey, PdfOptimizationLevel pdfOptimizationLevel) {
        return PdfOptimizationResult.swigToEnum(NeboDMSJNI.DMS_optimizePageAttachment__SWIG_1(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, pdfOptimizationLevel.swigValue()));
    }

    public boolean tagCorruptionInfoPage(PageKey pageKey, NeboSanitizer.SanitizerResult sanitizerResult) {
        return NeboDMSJNI.DMS_tagCorruptionInfoPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, NeboSanitizer.SanitizerResult.getCPtr(sanitizerResult), sanitizerResult);
    }

    public boolean untagCorruptedPage(PageKey pageKey) {
        return NeboDMSJNI.DMS_untagCorruptedPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public boolean tagCorruptionWarningInfoPage(PageKey pageKey, String str, String str2, String str3) {
        return NeboDMSJNI.DMS_tagCorruptionWarningInfoPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, str.getBytes(), str2.getBytes(), str3.getBytes());
    }

    public boolean untagCorruptedWarningPage(PageKey pageKey) {
        return NeboDMSJNI.DMS_untagCorruptedWarningPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public boolean isCorruptedPage(PageKey pageKey) {
        return NeboDMSJNI.DMS_isCorruptedPage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public List<Page> pages(NotebookKey notebookKey, DMSFilter dMSFilter) {
        return new SWIGVectorPage(NeboDMSJNI.DMS_pages__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, dMSFilter.swigValue()), true);
    }

    public List<Page> pages(NotebookKey notebookKey) {
        return new SWIGVectorPage(NeboDMSJNI.DMS_pages__SWIG_1(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey), true);
    }

    public List<Page> pages(PageKey pageKey, DMSFilter dMSFilter) {
        return new SWIGVectorPage(NeboDMSJNI.DMS_pages__SWIG_2(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, dMSFilter.swigValue()), true);
    }

    public List<Page> pages(PageKey pageKey) {
        return new SWIGVectorPage(NeboDMSJNI.DMS_pages__SWIG_3(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
    }

    public String welcomeVersion(PageKey pageKey) {
        return new String(NeboDMSJNI.DMS_welcomeVersion(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), StandardCharsets.UTF_8);
    }

    public boolean isSamplePage(PageKey pageKey) {
        return NeboDMSJNI.DMS_isSamplePage(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public long pageCount(boolean z) {
        return NeboDMSJNI.DMS_pageCount(this.swigCPtr, this, z);
    }

    public void restoreAll() {
        NeboDMSJNI.DMS_restoreAll(this.swigCPtr, this);
    }

    public void emptyTrash() {
        NeboDMSJNI.DMS_emptyTrash(this.swigCPtr, this);
    }

    public void deleteAllPermanently() {
        NeboDMSJNI.DMS_deleteAllPermanently(this.swigCPtr, this);
    }

    public boolean migrateKey(CollectionKey collectionKey) {
        return NeboDMSJNI.DMS_migrateKey__SWIG_0(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public boolean migrateKey(NotebookKey notebookKey) {
        return NeboDMSJNI.DMS_migrateKey__SWIG_1(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public boolean migrateKey(PageKey pageKey) {
        return NeboDMSJNI.DMS_migrateKey__SWIG_2(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey);
    }

    public SharePageManager createSharePageManager(String str, String str2) {
        long jDMS_createSharePageManager = NeboDMSJNI.DMS_createSharePageManager(this.swigCPtr, this, str.getBytes(), str2.getBytes());
        if (jDMS_createSharePageManager == 0) {
            return null;
        }
        return new SharePageManager(jDMS_createSharePageManager, true);
    }

    public ExportController createExportController(List<PageKey> list, IRendererListener iRendererListener, ITypesetListener iTypesetListener, ViewTransform viewTransform, List<String> list2, List<CustomResource> list3) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        SWIGVectorString sWIGVectorString = new SWIGVectorString(list2);
        SWIGVectorCustomResource sWIGVectorCustomResource = new SWIGVectorCustomResource(list3);
        long jDMS_createExportController = NeboDMSJNI.DMS_createExportController(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey, iRendererListener, iTypesetListener, ViewTransform.getCPtr(viewTransform), viewTransform, SWIGVectorString.getCPtr(sWIGVectorString), sWIGVectorString, SWIGVectorCustomResource.getCPtr(sWIGVectorCustomResource), sWIGVectorCustomResource);
        if (jDMS_createExportController == 0) {
            return null;
        }
        return new ExportController(jDMS_createExportController, true);
    }

    public boolean canExport(List<PageKey> list) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        return NeboDMSJNI.DMS_canExport(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public List<MimeType> supportedExportMimeTypes(PageKey pageKey) {
        return new SWIGVectorMimeType(NeboDMSJNI.DMS_supportedExportMimeTypes(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey), true);
    }

    public void refreshSyncState() {
        NeboDMSJNI.DMS_refreshSyncState(this.swigCPtr, this);
    }

    public boolean hasLocalSyncUpdate() {
        return NeboDMSJNI.DMS_hasLocalSyncUpdate(this.swigCPtr, this);
    }

    public void startSynchronizationTimer() {
        NeboDMSJNI.DMS_startSynchronizationTimer(this.swigCPtr, this);
    }

    public void stopSynchronizationTimer() {
        NeboDMSJNI.DMS_stopSynchronizationTimer(this.swigCPtr, this);
    }

    public void setAutoSyncInterval(long j) {
        NeboDMSJNI.DMS_setAutoSyncInterval(this.swigCPtr, this, j);
    }

    public static long autoSyncIntervalDefault() {
        return NeboDMSJNI.DMS_autoSyncIntervalDefault();
    }

    public void fireCloudUpdate() {
        NeboDMSJNI.DMS_fireCloudUpdate(this.swigCPtr, this);
    }

    public void fireRenamedRequest() {
        NeboDMSJNI.DMS_fireRenamedRequest(this.swigCPtr, this);
    }

    public void cloudUpdatedWithCloudId(String str) {
        NeboDMSJNI.DMS_cloudUpdatedWithCloudId(this.swigCPtr, this, str.getBytes());
    }

    public void cloudUpdated(CollectionKey collectionKey, String str, String str2, String str3) {
        NeboDMSJNI.DMS_cloudUpdated__SWIG_0(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, str.getBytes(), str2.getBytes(), str3.getBytes());
    }

    public void cloudUpdated(CollectionKey collectionKey, String str, String str2) {
        NeboDMSJNI.DMS_cloudUpdated__SWIG_1(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, str.getBytes(), str2.getBytes());
    }

    public void cloudUpdated(CollectionKey collectionKey, String str) {
        NeboDMSJNI.DMS_cloudUpdated__SWIG_2(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, str.getBytes());
    }

    public void cloudUpdated(CollectionKey collectionKey) {
        NeboDMSJNI.DMS_cloudUpdated__SWIG_3(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public void cloudUpdated(NotebookKey notebookKey, String str, String str2, String str3) {
        NeboDMSJNI.DMS_cloudUpdated__SWIG_4(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes(), str2.getBytes(), str3.getBytes());
    }

    public void cloudUpdated(NotebookKey notebookKey, String str, String str2) {
        NeboDMSJNI.DMS_cloudUpdated__SWIG_5(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes(), str2.getBytes());
    }

    public void cloudUpdated(NotebookKey notebookKey, String str) {
        NeboDMSJNI.DMS_cloudUpdated__SWIG_6(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes());
    }

    public void cloudUpdated(NotebookKey notebookKey) {
        NeboDMSJNI.DMS_cloudUpdated__SWIG_7(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey);
    }

    public void checkMigration() {
        NeboDMSJNI.DMS_checkMigration(this.swigCPtr, this);
    }

    public static int findCollectionForCollectionKey(List<Collection> list, CollectionKey collectionKey) {
        SWIGVectorCollection sWIGVectorCollection = new SWIGVectorCollection(list);
        return NeboDMSJNI.DMS_findCollectionForCollectionKey(SWIGVectorCollection.getCPtr(sWIGVectorCollection), sWIGVectorCollection, CollectionKey.getCPtr(collectionKey), collectionKey);
    }

    public SearchController searchController(boolean z) {
        long jDMS_searchController__SWIG_0 = NeboDMSJNI.DMS_searchController__SWIG_0(this.swigCPtr, this, z);
        if (jDMS_searchController__SWIG_0 == 0) {
            return null;
        }
        return new SearchController(jDMS_searchController__SWIG_0, true);
    }

    public SearchController searchController() {
        long jDMS_searchController__SWIG_1 = NeboDMSJNI.DMS_searchController__SWIG_1(this.swigCPtr, this);
        if (jDMS_searchController__SWIG_1 == 0) {
            return null;
        }
        return new SearchController(jDMS_searchController__SWIG_1, true);
    }

    public SyncState syncState(String str) {
        return SyncState.swigToEnum(NeboDMSJNI.DMS_syncState__SWIG_1(this.swigCPtr, this, str.getBytes()));
    }

    public SWIGTYPE_p_std__shared_ptrT_snt__dms__SyncEngine_t syncEngine() {
        return new SWIGTYPE_p_std__shared_ptrT_snt__dms__SyncEngine_t(NeboDMSJNI.DMS_syncEngine(this.swigCPtr, this), true);
    }

    public void setMaxNotebooksToDownloadInParallel(long j) {
        NeboDMSJNI.DMS_setMaxNotebooksToDownloadInParallel(this.swigCPtr, this, j);
    }

    public long getMaxNotebooksToDownloadInParallel() {
        return NeboDMSJNI.DMS_getMaxNotebooksToDownloadInParallel(this.swigCPtr, this);
    }

    public void setMaxNotebooksToUploadInParallel(long j) {
        NeboDMSJNI.DMS_setMaxNotebooksToUploadInParallel(this.swigCPtr, this, j);
    }

    public long getMaxNotebooksToUploadInParallel() {
        return NeboDMSJNI.DMS_getMaxNotebooksToUploadInParallel(this.swigCPtr, this);
    }

    public void purgeV1Files() {
        NeboDMSJNI.DMS_purgeV1Files(this.swigCPtr, this);
    }

    public String workingDirPath() {
        return new String(NeboDMSJNI.DMS_workingDirPath(this.swigCPtr, this), StandardCharsets.UTF_8);
    }

    public PageControllerSanitized open2(PageKey pageKey, DisplayContext displayContext, RecoContext recoContext, SWIGOptionContext sWIGOptionContext) {
        return new PageControllerSanitized(NeboDMSJNI.DMS_open2(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, DisplayContext.getCPtr(displayContext), displayContext, RecoContext.getCPtr(recoContext), recoContext, SWIGOptionContext.getCPtr(sWIGOptionContext), sWIGOptionContext), true);
    }

    public void setCloudDriveInterface(DegradedCloudDriveWrapper degradedCloudDriveWrapper) {
        NeboDMSJNI.DMS_setCloudDriveInterface__SWIG_1(this.swigCPtr, this, DegradedCloudDriveWrapper.getCPtr(degradedCloudDriveWrapper), degradedCloudDriveWrapper);
    }

    public void restoreCollections(List<CollectionKey> list) {
        SWIGVectorCollectionKey sWIGVectorCollectionKey = new SWIGVectorCollectionKey(list);
        NeboDMSJNI.DMS_restoreCollections(this.swigCPtr, this, SWIGVectorCollectionKey.getCPtr(sWIGVectorCollectionKey), sWIGVectorCollectionKey);
    }

    public void restoreNotebooks(List<NotebookKey> list) {
        SWIGVectorNotebookKey sWIGVectorNotebookKey = new SWIGVectorNotebookKey(list);
        NeboDMSJNI.DMS_restoreNotebooks(this.swigCPtr, this, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey), sWIGVectorNotebookKey);
    }

    public void restorePages(List<PageKey> list) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        NeboDMSJNI.DMS_restorePages(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public void deletePermanentlyCollections(List<CollectionKey> list) {
        SWIGVectorCollectionKey sWIGVectorCollectionKey = new SWIGVectorCollectionKey(list);
        NeboDMSJNI.DMS_deletePermanentlyCollections(this.swigCPtr, this, SWIGVectorCollectionKey.getCPtr(sWIGVectorCollectionKey), sWIGVectorCollectionKey);
    }

    public void deletePermanentlyNotebooks(List<NotebookKey> list) {
        SWIGVectorNotebookKey sWIGVectorNotebookKey = new SWIGVectorNotebookKey(list);
        NeboDMSJNI.DMS_deletePermanentlyNotebooks(this.swigCPtr, this, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey), sWIGVectorNotebookKey);
    }

    public void deletePermanentlyPages(List<PageKey> list) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        NeboDMSJNI.DMS_deletePermanentlyPages(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public void moveCollectionsToTrash(List<CollectionKey> list) {
        SWIGVectorCollectionKey sWIGVectorCollectionKey = new SWIGVectorCollectionKey(list);
        NeboDMSJNI.DMS_moveCollectionsToTrash(this.swigCPtr, this, SWIGVectorCollectionKey.getCPtr(sWIGVectorCollectionKey), sWIGVectorCollectionKey);
    }

    public void moveNotebooksToTrash(List<NotebookKey> list) {
        SWIGVectorNotebookKey sWIGVectorNotebookKey = new SWIGVectorNotebookKey(list);
        NeboDMSJNI.DMS_moveNotebooksToTrash(this.swigCPtr, this, SWIGVectorNotebookKey.getCPtr(sWIGVectorNotebookKey), sWIGVectorNotebookKey);
    }

    public void movePagesToTrash(List<PageKey> list) {
        SWIGVectorPageKey sWIGVectorPageKey = new SWIGVectorPageKey(list);
        NeboDMSJNI.DMS_movePagesToTrash(this.swigCPtr, this, SWIGVectorPageKey.getCPtr(sWIGVectorPageKey), sWIGVectorPageKey);
    }

    public static String getATTR_CORRUPTION_SOURCE_APP() {
        return new String(NeboDMSJNI.DMS_getATTR_CORRUPTION_SOURCE_APP(), StandardCharsets.UTF_8);
    }

    public NotebookKey createFolder(CollectionKey collectionKey, String str, int i) {
        return new NotebookKey(NeboDMSJNI.DMS_createFolder(this.swigCPtr, this, CollectionKey.getCPtr(collectionKey), collectionKey, str.getBytes(), i), true);
    }

    public void updateFolderCoverColor(NotebookKey notebookKey, int i) {
        NeboDMSJNI.DMS_updateFolderCoverColor(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, i);
    }

    public void setCoverColors2(PageKey pageKey, List<Integer> list) {
        SWIGVectorColors sWIGVectorColors = new SWIGVectorColors(list);
        NeboDMSJNI.DMS_setCoverColors2(this.swigCPtr, this, PageKey.getCPtr(pageKey), pageKey, SWIGVectorColors.getCPtr(sWIGVectorColors), sWIGVectorColors);
    }

    public PageKey createFixedPageSizeContainer2(NotebookKey notebookKey, String str, String str2, List<Integer> list, float f, float f2, int i, String str3, PageType pageType, int i2) {
        SWIGVectorColors sWIGVectorColors = new SWIGVectorColors(list);
        return new PageKey(NeboDMSJNI.DMS_createFixedPageSizeContainer2__SWIG_0(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes(), str2.getBytes(), SWIGVectorColors.getCPtr(sWIGVectorColors), sWIGVectorColors, f, f2, i, str3.getBytes(), pageType.swigValue(), i2), true);
    }

    public PageKey createFixedPageSizeContainer2(NotebookKey notebookKey, String str, String str2, List<Integer> list, float f, float f2, int i, String str3, PageType pageType) {
        SWIGVectorColors sWIGVectorColors = new SWIGVectorColors(list);
        return new PageKey(NeboDMSJNI.DMS_createFixedPageSizeContainer2__SWIG_1(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes(), str2.getBytes(), SWIGVectorColors.getCPtr(sWIGVectorColors), sWIGVectorColors, f, f2, i, str3.getBytes(), pageType.swigValue()), true);
    }

    public PageKey createFixedPageSizeContainer2(NotebookKey notebookKey, String str, String str2, List<Integer> list, float f, float f2, int i, String str3) {
        SWIGVectorColors sWIGVectorColors = new SWIGVectorColors(list);
        return new PageKey(NeboDMSJNI.DMS_createFixedPageSizeContainer2__SWIG_2(this.swigCPtr, this, NotebookKey.getCPtr(notebookKey), notebookKey, str.getBytes(), str2.getBytes(), SWIGVectorColors.getCPtr(sWIGVectorColors), sWIGVectorColors, f, f2, i, str3.getBytes()), true);
    }
}
