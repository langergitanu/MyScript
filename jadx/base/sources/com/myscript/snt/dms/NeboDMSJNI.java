package com.myscript.snt.dms;

import com.myscript.atk.core.ICancelableTaskProgressCallback;
import com.myscript.atk.core.IColorInversionPolicy;
import com.myscript.atk.core.ITypesetListener;
import com.myscript.atk.core.Json;
import com.myscript.atk.core.SWIGVectorCustomResource;
import com.myscript.atk.core.SWIGVectorString;
import com.myscript.atk.core.ViewTransform;
import com.myscript.snt.core.CollectionKey;
import com.myscript.snt.core.DisplayContext;
import com.myscript.snt.core.IRendererListener;
import com.myscript.snt.core.IThumbnailerImageRequester;
import com.myscript.snt.core.IThumbnailerNotificationListener;
import com.myscript.snt.core.NeboSanitizer;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageController;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.core.RecoContext;
import com.myscript.snt.core.SWIGOptionContext;
import com.myscript.snt.core.SWIGVectorCollectionKey;
import com.myscript.snt.core.SWIGVectorColors;
import com.myscript.snt.core.SWIGVectorNotebookKey;
import com.myscript.snt.core.SWIGVectorPageKey;
import com.myscript.snt.dms.ContentInfo;
import com.myscript.snt.dms.ObjectWithTrashState;
import com.myscript.snt.dms.SyncEvent;

/* JADX INFO: loaded from: classes7.dex */
class NeboDMSJNI {
    public static final native long AttachmentInfo_attachment_get(long j, AttachmentInfo attachmentInfo);

    public static final native void AttachmentInfo_attachment_set(long j, AttachmentInfo attachmentInfo, long j2);

    public static final native byte[] AttachmentInfo_extension_get(long j, AttachmentInfo attachmentInfo);

    public static final native void AttachmentInfo_extension_set(long j, AttachmentInfo attachmentInfo, byte[] bArr);

    public static final native long AttachmentInfo_page_get(long j, AttachmentInfo attachmentInfo);

    public static final native void AttachmentInfo_page_set(long j, AttachmentInfo attachmentInfo, long j2);

    public static final native int AttachmentInfo_referenceCount_get(long j, AttachmentInfo attachmentInfo);

    public static final native void AttachmentInfo_referenceCount_set(long j, AttachmentInfo attachmentInfo, int i);

    public static final native byte[] AttachmentInfo_signature_get(long j, AttachmentInfo attachmentInfo);

    public static final native void AttachmentInfo_signature_set(long j, AttachmentInfo attachmentInfo, byte[] bArr);

    public static final native byte[] AttachmentInfo_url_get(long j, AttachmentInfo attachmentInfo);

    public static final native void AttachmentInfo_url_set(long j, AttachmentInfo attachmentInfo, byte[] bArr);

    public static final native boolean AttachmentInfo_valid(long j, AttachmentInfo attachmentInfo);

    public static final native byte[] BackupMetadata_applicationVersion_get(long j, BackupMetadata backupMetadata);

    public static final native void BackupMetadata_applicationVersion_set(long j, BackupMetadata backupMetadata, byte[] bArr);

    public static final native long BackupMetadata_backupVersion_get(long j, BackupMetadata backupMetadata);

    public static final native void BackupMetadata_backupVersion_set(long j, BackupMetadata backupMetadata, long j2);

    public static final native boolean BackupMetadata_isValid(long j, BackupMetadata backupMetadata);

    public static final native byte[] BackupMetadata_osNameAndVersion_get(long j, BackupMetadata backupMetadata);

    public static final native void BackupMetadata_osNameAndVersion_set(long j, BackupMetadata backupMetadata, byte[] bArr);

    public static final native long BackupMetadata_timestamp_get(long j, BackupMetadata backupMetadata);

    public static final native void BackupMetadata_timestamp_set(long j, BackupMetadata backupMetadata, long j2);

    public static final native long BackupMetadata_uncompressedSize_get(long j, BackupMetadata backupMetadata);

    public static final native void BackupMetadata_uncompressedSize_set(long j, BackupMetadata backupMetadata, long j2);

    public static final native long BatchResult_cloudFileIdRev(long j, BatchResult batchResult, long j2);

    public static final native long BatchResult_error(long j, BatchResult batchResult, long j2);

    public static final native boolean BatchResult_hasCloudFileIdRev(long j, BatchResult batchResult, long j2);

    public static final native boolean BatchResult_hasError(long j, BatchResult batchResult, long j2);

    public static final native boolean BatchResult_hasKey(long j, BatchResult batchResult, long j2);

    public static final native boolean BatchResult_hasString(long j, BatchResult batchResult, long j2);

    public static final native void BatchResult_put__SWIG_0(long j, BatchResult batchResult, long j2, byte[] bArr);

    public static final native void BatchResult_put__SWIG_1(long j, BatchResult batchResult, long j2, long j3, CloudFileIdRev cloudFileIdRev);

    public static final native void BatchResult_put__SWIG_2(long j, BatchResult batchResult, long j2, long j3, CloudError cloudError);

    public static final native int BatchResult_size(long j, BatchResult batchResult);

    public static final native byte[] BatchResult_string(long j, BatchResult batchResult, long j2);

    public static final native boolean CancelableCloudTaskProgressHandler_progress(long j, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, long j2, boolean z, long j3, long j4);

    public static final native byte[] CloudCreateFileRequest_localPath_get(long j, CloudCreateFileRequest cloudCreateFileRequest);

    public static final native void CloudCreateFileRequest_localPath_set(long j, CloudCreateFileRequest cloudCreateFileRequest, byte[] bArr);

    public static final native byte[] CloudCreateFileRequest_mimeType_get(long j, CloudCreateFileRequest cloudCreateFileRequest);

    public static final native void CloudCreateFileRequest_mimeType_set(long j, CloudCreateFileRequest cloudCreateFileRequest, byte[] bArr);

    public static final native byte[] CloudCreateFileRequest_name_get(long j, CloudCreateFileRequest cloudCreateFileRequest);

    public static final native void CloudCreateFileRequest_name_set(long j, CloudCreateFileRequest cloudCreateFileRequest, byte[] bArr);

    public static final native long CloudCreateFileRequest_parent_get(long j, CloudCreateFileRequest cloudCreateFileRequest);

    public static final native void CloudCreateFileRequest_parent_set(long j, CloudCreateFileRequest cloudCreateFileRequest, long j2, CloudFile cloudFile);

    public static final native long CloudCreateFileRequest_requestId_get(long j, CloudCreateFileRequest cloudCreateFileRequest);

    public static final native void CloudCreateFileRequest_requestId_set(long j, CloudCreateFileRequest cloudCreateFileRequest, long j2);

    public static final native byte[] CloudCreateFolderRequest_name_get(long j, CloudCreateFolderRequest cloudCreateFolderRequest);

    public static final native void CloudCreateFolderRequest_name_set(long j, CloudCreateFolderRequest cloudCreateFolderRequest, byte[] bArr);

    public static final native long CloudCreateFolderRequest_parent_get(long j, CloudCreateFolderRequest cloudCreateFolderRequest);

    public static final native void CloudCreateFolderRequest_parent_set(long j, CloudCreateFolderRequest cloudCreateFolderRequest, long j2, CloudFile cloudFile);

    public static final native long CloudCreateFolderRequest_requestId_get(long j, CloudCreateFolderRequest cloudCreateFolderRequest);

    public static final native void CloudCreateFolderRequest_requestId_set(long j, CloudCreateFolderRequest cloudCreateFolderRequest, long j2);

    public static final native void CloudDownloadFileTaskHandler_downloaded(long j, CloudDownloadFileTaskHandler cloudDownloadFileTaskHandler, long j2);

    public static final native int CloudError_getErrorId(long j, CloudError cloudError);

    public static final native String CloudError_getMessage(long j, CloudError cloudError);

    public static final native boolean CloudError_handled(long j, CloudError cloudError);

    public static final native boolean CloudFileData_hasId(long j, CloudFileData cloudFileData);

    public static final native boolean CloudFileData_hasIsFolder(long j, CloudFileData cloudFileData);

    public static final native boolean CloudFileData_hasLastModificationDate(long j, CloudFileData cloudFileData);

    public static final native boolean CloudFileData_hasMimeType(long j, CloudFileData cloudFileData);

    public static final native boolean CloudFileData_hasName(long j, CloudFileData cloudFileData);

    public static final native boolean CloudFileData_hasParentId(long j, CloudFileData cloudFileData);

    public static final native boolean CloudFileData_hasPath(long j, CloudFileData cloudFileData);

    public static final native boolean CloudFileData_hasRevision(long j, CloudFileData cloudFileData);

    public static final native boolean CloudFileData_hasSize(long j, CloudFileData cloudFileData);

    public static final native byte[] CloudFileData_id(long j, CloudFileData cloudFileData);

    public static final native boolean CloudFileData_isFolder(long j, CloudFileData cloudFileData);

    public static final native long CloudFileData_lastModificationDate(long j, CloudFileData cloudFileData);

    public static final native byte[] CloudFileData_mimeType(long j, CloudFileData cloudFileData);

    public static final native byte[] CloudFileData_name(long j, CloudFileData cloudFileData);

    public static final native byte[] CloudFileData_parentId(long j, CloudFileData cloudFileData);

    public static final native byte[] CloudFileData_path(long j, CloudFileData cloudFileData);

    public static final native byte[] CloudFileData_revision(long j, CloudFileData cloudFileData);

    public static final native void CloudFileData_setId(long j, CloudFileData cloudFileData, byte[] bArr);

    public static final native void CloudFileData_setIsFolder(long j, CloudFileData cloudFileData, boolean z);

    public static final native void CloudFileData_setLastModificationDate(long j, CloudFileData cloudFileData, long j2);

    public static final native void CloudFileData_setMimeType(long j, CloudFileData cloudFileData, byte[] bArr);

    public static final native void CloudFileData_setName(long j, CloudFileData cloudFileData, byte[] bArr);

    public static final native void CloudFileData_setParentId(long j, CloudFileData cloudFileData, byte[] bArr);

    public static final native void CloudFileData_setPath(long j, CloudFileData cloudFileData, byte[] bArr);

    public static final native void CloudFileData_setRevision(long j, CloudFileData cloudFileData, byte[] bArr);

    public static final native void CloudFileData_setSize(long j, CloudFileData cloudFileData, long j2);

    public static final native long CloudFileData_size(long j, CloudFileData cloudFileData);

    public static final native byte[] CloudFileIdRev_id_get(long j, CloudFileIdRev cloudFileIdRev);

    public static final native void CloudFileIdRev_id_set(long j, CloudFileIdRev cloudFileIdRev, byte[] bArr);

    public static final native byte[] CloudFileIdRev_revision_get(long j, CloudFileIdRev cloudFileIdRev);

    public static final native void CloudFileIdRev_revision_set(long j, CloudFileIdRev cloudFileIdRev, byte[] bArr);

    public static final native long CloudFileRequest_file_get(long j, CloudFileRequest cloudFileRequest);

    public static final native void CloudFileRequest_file_set(long j, CloudFileRequest cloudFileRequest, long j2, CloudFile cloudFile);

    public static final native byte[] CloudFileRequest_outputPath_get(long j, CloudFileRequest cloudFileRequest);

    public static final native void CloudFileRequest_outputPath_set(long j, CloudFileRequest cloudFileRequest, byte[] bArr);

    public static final native long CloudFileRequest_requestId_get(long j, CloudFileRequest cloudFileRequest);

    public static final native void CloudFileRequest_requestId_set(long j, CloudFileRequest cloudFileRequest, long j2);

    public static final native byte[] CloudFileRequest_revision_get(long j, CloudFileRequest cloudFileRequest);

    public static final native void CloudFileRequest_revision_set(long j, CloudFileRequest cloudFileRequest, byte[] bArr);

    public static final native byte[] CloudFile_id_get(long j, CloudFile cloudFile);

    public static final native void CloudFile_id_set(long j, CloudFile cloudFile, byte[] bArr);

    public static final native byte[] CloudFile_path_get(long j, CloudFile cloudFile);

    public static final native void CloudFile_path_set(long j, CloudFile cloudFile, byte[] bArr);

    public static final native void CloudOperationLogger_addError(long j, CloudOperationLogger cloudOperationLogger, byte[] bArr, byte[] bArr2);

    public static final native byte[] CloudOperationLogger_dump(long j, CloudOperationLogger cloudOperationLogger);

    public static final native void CloudOperationLogger_endActionBatch(long j, CloudOperationLogger cloudOperationLogger, byte[] bArr, byte[] bArr2, long j2, SWIGVectorString sWIGVectorString);

    public static final native void CloudOperationLogger_endAction__SWIG_0(long j, CloudOperationLogger cloudOperationLogger, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native void CloudOperationLogger_endAction__SWIG_1(long j, CloudOperationLogger cloudOperationLogger, byte[] bArr, byte[] bArr2);

    public static final native void CloudOperationLogger_endSession(long j, CloudOperationLogger cloudOperationLogger, byte[] bArr);

    public static final native byte[] CloudOperationLogger_startAction(long j, CloudOperationLogger cloudOperationLogger);

    public static final native void CloudOperationLogger_startSession(long j, CloudOperationLogger cloudOperationLogger, byte[] bArr, int i, byte[] bArr2);

    public static final native long CloudUploadFileRequest_file_get(long j, CloudUploadFileRequest cloudUploadFileRequest);

    public static final native void CloudUploadFileRequest_file_set(long j, CloudUploadFileRequest cloudUploadFileRequest, long j2, CloudFile cloudFile);

    public static final native byte[] CloudUploadFileRequest_localPath_get(long j, CloudUploadFileRequest cloudUploadFileRequest);

    public static final native void CloudUploadFileRequest_localPath_set(long j, CloudUploadFileRequest cloudUploadFileRequest, byte[] bArr);

    public static final native long CloudUploadFileRequest_requestId_get(long j, CloudUploadFileRequest cloudUploadFileRequest);

    public static final native void CloudUploadFileRequest_requestId_set(long j, CloudUploadFileRequest cloudUploadFileRequest, long j2);

    public static final native byte[] CollectionInfo_name_get(long j, CollectionInfo collectionInfo);

    public static final native void CollectionInfo_name_set(long j, CollectionInfo collectionInfo, byte[] bArr);

    public static final native long CollectionInfo_object_get(long j, CollectionInfo collectionInfo);

    public static final native void CollectionInfo_object_set(long j, CollectionInfo collectionInfo, long j2);

    public static final native int CollectionInfo_trashState_get(long j, CollectionInfo collectionInfo);

    public static final native void CollectionInfo_trashState_set(long j, CollectionInfo collectionInfo, int i);

    public static final native boolean CollectionInfo_valid(long j, CollectionInfo collectionInfo);

    public static final native long Collection_getCreationDate(long j, Collection collection);

    public static final native long Collection_getKey(long j, Collection collection);

    public static final native byte[] Collection_getName(long j, Collection collection);

    public static final native int Collection_hashCode(long j, Collection collection);

    public static final native boolean Collection_isTrashed(long j, Collection collection);

    public static final native boolean Collection_nativeEquals(long j, Collection collection, long j2, Collection collection2);

    public static final native int Collection_syncState(long j, Collection collection);

    public static final native byte[] Collection_toString(long j, Collection collection);

    public static final native boolean ContentInfo_Rev_isModified_get(long j, ContentInfo.Rev rev);

    public static final native void ContentInfo_Rev_isModified_set(long j, ContentInfo.Rev rev, boolean z);

    public static final native byte[] ContentInfo_Rev_signature_get(long j, ContentInfo.Rev rev);

    public static final native void ContentInfo_Rev_signature_set(long j, ContentInfo.Rev rev, byte[] bArr);

    public static final native long ContentInfo_Rev_timestamp_get(long j, ContentInfo.Rev rev);

    public static final native void ContentInfo_Rev_timestamp_set(long j, ContentInfo.Rev rev, long j2);

    public static final native long ContentInfo_current_get(long j, ContentInfo contentInfo);

    public static final native void ContentInfo_current_set(long j, ContentInfo contentInfo, long j2, ContentInfo.Rev rev);

    public static final native long ContentInfo_history_get(long j, ContentInfo contentInfo);

    public static final native void ContentInfo_history_set(long j, ContentInfo contentInfo, long j2);

    public static final native long ContentInfo_lastModification_get(long j, ContentInfo contentInfo);

    public static final native void ContentInfo_lastModification_set(long j, ContentInfo contentInfo, long j2, ContentInfo.Rev rev);

    public static final native byte[] ContentInfo_pageId_get(long j, ContentInfo contentInfo);

    public static final native void ContentInfo_pageId_set(long j, ContentInfo contentInfo, byte[] bArr);

    public static final native byte[] ContentInfo_path_get(long j, ContentInfo contentInfo);

    public static final native void ContentInfo_path_set(long j, ContentInfo contentInfo, byte[] bArr);

    public static final native int ContractsTestConfiguration_batchUploadThreshold_get(long j, ContractsTestConfiguration contractsTestConfiguration);

    public static final native void ContractsTestConfiguration_batchUploadThreshold_set(long j, ContractsTestConfiguration contractsTestConfiguration, int i);

    public static final native byte[] ContractsTestConfiguration_existingFilePath_get(long j, ContractsTestConfiguration contractsTestConfiguration);

    public static final native void ContractsTestConfiguration_existingFilePath_set(long j, ContractsTestConfiguration contractsTestConfiguration, byte[] bArr);

    public static final native byte[] ContractsTestConfiguration_filter_get(long j, ContractsTestConfiguration contractsTestConfiguration);

    public static final native void ContractsTestConfiguration_filter_set(long j, ContractsTestConfiguration contractsTestConfiguration, byte[] bArr);

    public static final native byte[] ContractsTestConfiguration_tempDir_get(long j, ContractsTestConfiguration contractsTestConfiguration);

    public static final native void ContractsTestConfiguration_tempDir_set(long j, ContractsTestConfiguration contractsTestConfiguration, byte[] bArr);

    public static final native long ContractsTest_configuration_get(long j, ContractsTest contractsTest);

    public static final native void ContractsTest_configuration_set(long j, ContractsTest contractsTest, long j2, ContractsTestConfiguration contractsTestConfiguration);

    public static final native long ContractsTest_logger_get(long j, ContractsTest contractsTest);

    public static final native void ContractsTest_logger_set(long j, ContractsTest contractsTest, long j2);

    public static final native boolean ContractsTest_run(long j, ContractsTest contractsTest, ICloudDriveInterface iCloudDriveInterface);

    public static final native void ContractsTest_setLogger(long j, ContractsTest contractsTest, CloudIntegrationLogger cloudIntegrationLogger);

    public static final native byte[] CorruptionInfo_message_get(long j, CorruptionInfo corruptionInfo);

    public static final native void CorruptionInfo_message_set(long j, CorruptionInfo corruptionInfo, byte[] bArr);

    public static final native byte[] CorruptionInfo_reason_get(long j, CorruptionInfo corruptionInfo);

    public static final native void CorruptionInfo_reason_set(long j, CorruptionInfo corruptionInfo, byte[] bArr);

    public static final native byte[] CorruptionInfo_signature_get(long j, CorruptionInfo corruptionInfo);

    public static final native void CorruptionInfo_signature_set(long j, CorruptionInfo corruptionInfo, byte[] bArr);

    public static final native byte[] CorruptionInfo_source_get(long j, CorruptionInfo corruptionInfo);

    public static final native void CorruptionInfo_source_set(long j, CorruptionInfo corruptionInfo, byte[] bArr);

    public static final native long CorruptionInfo_timestamp_get(long j, CorruptionInfo corruptionInfo);

    public static final native void CorruptionInfo_timestamp_set(long j, CorruptionInfo corruptionInfo, long j2);

    public static final native byte[] CorruptionInfo_version_get(long j, CorruptionInfo corruptionInfo);

    public static final native void CorruptionInfo_version_set(long j, CorruptionInfo corruptionInfo, byte[] bArr);

    public static final native long DEFAULT_BACKGROUND_COLOR_get();

    public static final native byte[] DEFAULT_RAW_CONTENT_BACKGROUND_PATTERN_get();

    public static final native byte[] DMSConfiguration_appVersion_get(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMSConfiguration_appVersion_set(long j, DMSConfiguration dMSConfiguration, byte[] bArr);

    public static final native byte[] DMSConfiguration_databaseDirPath_get(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMSConfiguration_databaseDirPath_set(long j, DMSConfiguration dMSConfiguration, byte[] bArr);

    public static final native boolean DMSConfiguration_enableAutoSync_get(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMSConfiguration_enableAutoSync_set(long j, DMSConfiguration dMSConfiguration, boolean z);

    public static final native boolean DMSConfiguration_enableRecent_get(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMSConfiguration_enableRecent_set(long j, DMSConfiguration dMSConfiguration, boolean z);

    public static final native boolean DMSConfiguration_enableTrash_get(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMSConfiguration_enableTrash_set(long j, DMSConfiguration dMSConfiguration, boolean z);

    public static final native long DMSConfiguration_maxRecentPages_get(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMSConfiguration_maxRecentPages_set(long j, DMSConfiguration dMSConfiguration, long j2);

    public static final native byte[] DMSConfiguration_rootNotesPath_get(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMSConfiguration_rootNotesPath_set(long j, DMSConfiguration dMSConfiguration, byte[] bArr);

    public static final native long DMSConfiguration_uuidGenerator_get(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMSConfiguration_uuidGenerator_set(long j, DMSConfiguration dMSConfiguration, long j2);

    public static final native byte[] DMSConfiguration_workingDirPath_get(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMSConfiguration_workingDirPath_set(long j, DMSConfiguration dMSConfiguration, byte[] bArr);

    public static final native byte[] DMSError_message_get(long j, DMSError dMSError);

    public static final native void DMSError_message_set(long j, DMSError dMSError, byte[] bArr);

    public static final native byte[] DMSError_objectUuid_get(long j, DMSError dMSError);

    public static final native void DMSError_objectUuid_set(long j, DMSError dMSError, byte[] bArr);

    public static final native void DMSViewModel_clearErrors(long j, DMSViewModel dMSViewModel);

    public static final native void DMSViewModel_collectionDeleted(long j, DMSViewModel dMSViewModel, long j2, CollectionKey collectionKey, long j3, SWIGVectorNotebookKey sWIGVectorNotebookKey, long j4, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native void DMSViewModel_collectionUUIDReset(long j, DMSViewModel dMSViewModel, long j2, CollectionKey collectionKey, long j3, CollectionKey collectionKey2);

    public static final native void DMSViewModel_collectionsRenamed(long j, DMSViewModel dMSViewModel, long j2, SWIGVectorCollectionKey sWIGVectorCollectionKey);

    public static final native void DMSViewModel_collectionsUpdated(long j, DMSViewModel dMSViewModel, long j2, SWIGVectorCollectionKey sWIGVectorCollectionKey);

    public static final native void DMSViewModel_conflictedPageCopies(long j, DMSViewModel dMSViewModel, long j2);

    public static final native void DMSViewModel_dmsSyncStateChanged(long j, DMSViewModel dMSViewModel, int i, long j2, boolean z);

    public static final native long DMSViewModel_errors(long j, DMSViewModel dMSViewModel);

    public static final native void DMSViewModel_log(long j, DMSViewModel dMSViewModel, byte[] bArr, int i);

    public static final native void DMSViewModel_needThumbnailUpdate(long j, DMSViewModel dMSViewModel, long j2, PageKey pageKey);

    public static final native void DMSViewModel_notebookDeleted(long j, DMSViewModel dMSViewModel, long j2, NotebookKey notebookKey, long j3, CollectionKey collectionKey, long j4, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native void DMSViewModel_notebookMoved(long j, DMSViewModel dMSViewModel, long j2, CollectionKey collectionKey, long j3, NotebookKey notebookKey);

    public static final native void DMSViewModel_notebookSyncCanceled(long j, DMSViewModel dMSViewModel, long j2, NotebookKey notebookKey);

    public static final native void DMSViewModel_notebookSyncProgress(long j, DMSViewModel dMSViewModel, long j2, NotebookKey notebookKey, long j3, long j4);

    public static final native void DMSViewModel_notebookUUIDReset(long j, DMSViewModel dMSViewModel, long j2, NotebookKey notebookKey, long j3, NotebookKey notebookKey2, long j4, CollectionKey collectionKey);

    public static final native void DMSViewModel_notebooksRenamed(long j, DMSViewModel dMSViewModel, long j2, SWIGVectorNotebookKey sWIGVectorNotebookKey);

    public static final native void DMSViewModel_notebooksUpdated(long j, DMSViewModel dMSViewModel, long j2, SWIGVectorNotebookKey sWIGVectorNotebookKey);

    public static final native void DMSViewModel_pageContentChanged(long j, DMSViewModel dMSViewModel, long j2, PageKey pageKey);

    public static final native void DMSViewModel_pageDeleted__SWIG_0(long j, DMSViewModel dMSViewModel, long j2, PageKey pageKey, long j3, NotebookKey notebookKey);

    public static final native void DMSViewModel_pageDeleted__SWIG_1(long j, DMSViewModel dMSViewModel, long j2, PageKey pageKey, long j3, PageKey pageKey2);

    public static final native void DMSViewModel_pageMoved__SWIG_0(long j, DMSViewModel dMSViewModel, long j2, NotebookKey notebookKey, long j3, PageKey pageKey);

    public static final native void DMSViewModel_pageMoved__SWIG_1(long j, DMSViewModel dMSViewModel, long j2, PageKey pageKey, long j3, PageKey pageKey2);

    public static final native void DMSViewModel_pageUUIDReset__SWIG_0(long j, DMSViewModel dMSViewModel, long j2, PageKey pageKey, long j3, PageKey pageKey2, long j4, NotebookKey notebookKey);

    public static final native void DMSViewModel_pageUUIDReset__SWIG_1(long j, DMSViewModel dMSViewModel, long j2, PageKey pageKey, long j3, PageKey pageKey2, long j4, PageKey pageKey3);

    public static final native void DMSViewModel_pagesRenamed(long j, DMSViewModel dMSViewModel, long j2, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native void DMSViewModel_pagesUpdated(long j, DMSViewModel dMSViewModel, long j2, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native void DMSViewModel_refreshCanceled(long j, DMSViewModel dMSViewModel);

    public static final native void DMSViewModel_refreshProgress(long j, DMSViewModel dMSViewModel, long j2, long j3);

    public static final native void DMSViewModel_restored(long j, DMSViewModel dMSViewModel, long j2, SWIGVectorCollectionKey sWIGVectorCollectionKey, long j3, SWIGVectorNotebookKey sWIGVectorNotebookKey, long j4, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native void DMSViewModel_syncCanceled(long j, DMSViewModel dMSViewModel);

    public static final native void DMSViewModel_syncProgress(long j, DMSViewModel dMSViewModel, long j2, long j3);

    public static final native void DMSViewModel_trashed(long j, DMSViewModel dMSViewModel, long j2, SWIGVectorCollectionKey sWIGVectorCollectionKey, long j3, SWIGVectorNotebookKey sWIGVectorNotebookKey, long j4, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native void DMS_addDMSListener(long j, DMS dms, IDMSListener iDMSListener);

    public static final native void DMS_addThumbnailNotificationListener(long j, DMS dms, IThumbnailerNotificationListener iThumbnailerNotificationListener);

    public static final native boolean DMS_allowCloudAction(long j, DMS dms);

    public static final native long DMS_autoSyncIntervalDefault();

    public static final native byte[] DMS_backupDataStructure(long j, DMS dms, byte[] bArr, byte[] bArr2);

    public static final native boolean DMS_canExport(long j, DMS dms, long j2, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native void DMS_cancelNotebookSync(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native void DMS_cancelSync(long j, DMS dms);

    public static final native byte[] DMS_checkDatabaseSchema(long j, DMSConfiguration dMSConfiguration);

    public static final native void DMS_checkMigration(long j, DMS dms);

    public static final native void DMS_clearCache(long j, DMS dms);

    public static final native void DMS_clearThumbnails(byte[] bArr, byte[] bArr2);

    public static final native void DMS_cloudUpdatedWithCloudId(long j, DMS dms, byte[] bArr);

    public static final native void DMS_cloudUpdated__SWIG_0(long j, DMS dms, long j2, CollectionKey collectionKey, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native void DMS_cloudUpdated__SWIG_1(long j, DMS dms, long j2, CollectionKey collectionKey, byte[] bArr, byte[] bArr2);

    public static final native void DMS_cloudUpdated__SWIG_2(long j, DMS dms, long j2, CollectionKey collectionKey, byte[] bArr);

    public static final native void DMS_cloudUpdated__SWIG_3(long j, DMS dms, long j2, CollectionKey collectionKey);

    public static final native void DMS_cloudUpdated__SWIG_4(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native void DMS_cloudUpdated__SWIG_5(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr, byte[] bArr2);

    public static final native void DMS_cloudUpdated__SWIG_6(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr);

    public static final native void DMS_cloudUpdated__SWIG_7(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native long DMS_collectionForCollectionKey(long j, DMS dms, long j2, CollectionKey collectionKey);

    public static final native long DMS_collectionFromNotebookKey(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native long DMS_collections__SWIG_0(long j, DMS dms, int i);

    public static final native long DMS_collections__SWIG_1(long j, DMS dms);

    public static final native long DMS_consolidate__SWIG_0(long j, DMS dms, long j2, SWIGVectorString sWIGVectorString, long j3, byte[] bArr, long j4);

    public static final native long DMS_consolidate__SWIG_1(long j, DMS dms, long j2, SWIGVectorString sWIGVectorString, long j3, byte[] bArr);

    public static final native long DMS_containerFromPageKey(long j, DMS dms, long j2, PageKey pageKey);

    public static final native long DMS_create(long j, DMSConfiguration dMSConfiguration);

    public static final native long DMS_createBackupController(long j, DMS dms);

    public static final native long DMS_createCollection(long j, DMS dms, byte[] bArr);

    public static final native long DMS_createExportController(long j, DMS dms, long j2, SWIGVectorPageKey sWIGVectorPageKey, IRendererListener iRendererListener, ITypesetListener iTypesetListener, long j3, ViewTransform viewTransform, long j4, SWIGVectorString sWIGVectorString, long j5, SWIGVectorCustomResource sWIGVectorCustomResource);

    public static final native long DMS_createFixedPageSizeContainer2__SWIG_0(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr, byte[] bArr2, long j3, SWIGVectorColors sWIGVectorColors, float f, float f2, int i, byte[] bArr3, int i2, int i3);

    public static final native long DMS_createFixedPageSizeContainer2__SWIG_1(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr, byte[] bArr2, long j3, SWIGVectorColors sWIGVectorColors, float f, float f2, int i, byte[] bArr3, int i2);

    public static final native long DMS_createFixedPageSizeContainer2__SWIG_2(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr, byte[] bArr2, long j3, SWIGVectorColors sWIGVectorColors, float f, float f2, int i, byte[] bArr3);

    public static final native long DMS_createFixedPageSize__SWIG_0(long j, DMS dms, long j2, PageKey pageKey, byte[] bArr, float f, float f2, int i, ICancelableTaskProgressCallback iCancelableTaskProgressCallback);

    public static final native long DMS_createFixedPageSize__SWIG_1(long j, DMS dms, long j2, PageKey pageKey, byte[] bArr, float f, float f2, int i);

    public static final native long DMS_createFixedPageSize__SWIG_2(long j, DMS dms, long j2, PageKey pageKey, byte[] bArr, float f, float f2);

    public static final native long DMS_createFolder(long j, DMS dms, long j2, CollectionKey collectionKey, byte[] bArr, int i);

    public static final native long DMS_createPage__SWIG_0(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr, int i, int i2, byte[] bArr2, ICancelableTaskProgressCallback iCancelableTaskProgressCallback);

    public static final native long DMS_createPage__SWIG_1(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr, int i, int i2, byte[] bArr2);

    public static final native long DMS_createPage__SWIG_2(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr, int i, int i2);

    public static final native long DMS_createPage__SWIG_3(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr, int i);

    public static final native long DMS_createPage__SWIG_4(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr);

    public static final native long DMS_createSharePageManager(long j, DMS dms, byte[] bArr, byte[] bArr2);

    public static final native long DMS_createSiblingPage(long j, DMS dms, long j2, PageKey pageKey);

    public static final native boolean DMS_createThumbnail__SWIG_0(long j, DMS dms, long j2, PageKey pageKey, long j3, ViewTransform viewTransform, boolean z);

    public static final native boolean DMS_createThumbnail__SWIG_1(long j, DMS dms, long j2, PageKey pageKey, float f, float f2);

    public static final native byte[] DMS_debugSyncStates(long j, DMS dms);

    public static final native void DMS_deleteAllPermanently(long j, DMS dms);

    public static final native void DMS_deletePermanentlyCollections(long j, DMS dms, long j2, SWIGVectorCollectionKey sWIGVectorCollectionKey);

    public static final native void DMS_deletePermanentlyNotebooks(long j, DMS dms, long j2, SWIGVectorNotebookKey sWIGVectorNotebookKey);

    public static final native void DMS_deletePermanentlyPages(long j, DMS dms, long j2, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native boolean DMS_discardNotebookDeleteFromCloud(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native long DMS_documentController(long j, DMS dms);

    public static final native byte[] DMS_dumpCloudV1(long j, DMS dms, byte[] bArr);

    public static final native long DMS_duplicatePage(long j, DMS dms, long j2, PageKey pageKey, int i);

    public static final native long DMS_duplicatePages(long j, DMS dms, long j2, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native void DMS_emptyTrash(long j, DMS dms);

    public static final native int DMS_findCollectionForCollectionKey(long j, SWIGVectorCollection sWIGVectorCollection, long j2, CollectionKey collectionKey);

    public static final native byte[] DMS_findUniqueNotebookName(long j, DMS dms, long j2, CollectionKey collectionKey, byte[] bArr);

    public static final native void DMS_fireCloudUpdate(long j, DMS dms);

    public static final native void DMS_fireRenamedRequest(long j, DMS dms);

    public static final native byte[] DMS_getATTR_CORRUPTION_SOURCE_APP();

    public static final native long DMS_getMaxNotebooksToDownloadInParallel(long j, DMS dms);

    public static final native long DMS_getMaxNotebooksToUploadInParallel(long j, DMS dms);

    public static final native boolean DMS_hasLocalSyncUpdate(long j, DMS dms);

    public static final native boolean DMS_hasMultiEditor(long j, DMS dms, long j2);

    public static final native long DMS_importNotebook__SWIG_0(long j, DMS dms, byte[] bArr, long j2, CollectionKey collectionKey, byte[] bArr2, boolean z);

    public static final native long DMS_importNotebook__SWIG_1(long j, DMS dms, byte[] bArr, long j2, CollectionKey collectionKey, byte[] bArr2);

    public static final native long DMS_importPages__SWIG_0(long j, DMS dms, byte[] bArr, long j2, NotebookKey notebookKey, ICancelableTaskProgressCallback iCancelableTaskProgressCallback);

    public static final native long DMS_importPages__SWIG_1(long j, DMS dms, byte[] bArr, long j2, NotebookKey notebookKey);

    public static final native long DMS_importSampleNotebook(long j, DMS dms, byte[] bArr, long j2, CollectionKey collectionKey, byte[] bArr2);

    public static final native boolean DMS_isAutoSyncEnabled(long j, DMS dms);

    public static final native boolean DMS_isCloudEnabled(long j, DMS dms);

    public static final native boolean DMS_isCorruptedPage(long j, DMS dms, long j2, PageKey pageKey);

    public static final native boolean DMS_isLastSyncActionAUserAction(long j, DMS dms);

    public static final native boolean DMS_isSamplePage(long j, DMS dms, long j2, PageKey pageKey);

    public static final native long DMS_lastModificationDate(long j, DMS dms, long j2, CollectionKey collectionKey);

    public static final native byte[] DMS_lastOpenedPageUUID(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native long DMS_lastSynchronizationDate(long j, DMS dms);

    public static final native long DMS_lookupCollectionByName(long j, DMS dms, byte[] bArr);

    public static final native long DMS_lookupNotebookByName(long j, DMS dms, long j2, CollectionKey collectionKey, byte[] bArr);

    public static final native long DMS_lookupPageById(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr);

    public static final native boolean DMS_migrateKey__SWIG_0(long j, DMS dms, long j2, CollectionKey collectionKey);

    public static final native boolean DMS_migrateKey__SWIG_1(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native boolean DMS_migrateKey__SWIG_2(long j, DMS dms, long j2, PageKey pageKey);

    public static final native boolean DMS_migrateToV2__SWIG_0(long j, DMS dms, IDMSMigrationToV2LogListener iDMSMigrationToV2LogListener, ICancelableTaskProgressCallback iCancelableTaskProgressCallback);

    public static final native boolean DMS_migrateToV2__SWIG_1(long j, DMS dms, IDMSMigrationToV2LogListener iDMSMigrationToV2LogListener);

    public static final native void DMS_moveCollectionsToTrash(long j, DMS dms, long j2, SWIGVectorCollectionKey sWIGVectorCollectionKey);

    public static final native boolean DMS_moveNotebook__SWIG_0(long j, DMS dms, long j2, NotebookKey notebookKey, long j3, CollectionKey collectionKey, int i);

    public static final native boolean DMS_moveNotebook__SWIG_1(long j, DMS dms, long j2, NotebookKey notebookKey, long j3, CollectionKey collectionKey);

    public static final native void DMS_moveNotebooksToTrash(long j, DMS dms, long j2, SWIGVectorNotebookKey sWIGVectorNotebookKey);

    public static final native long DMS_movePage__SWIG_0(long j, DMS dms, long j2, PageKey pageKey, long j3, NotebookKey notebookKey, int i);

    public static final native long DMS_movePage__SWIG_1(long j, DMS dms, long j2, PageKey pageKey, long j3, NotebookKey notebookKey);

    public static final native long DMS_movePage__SWIG_2(long j, DMS dms, long j2, PageKey pageKey, long j3, PageKey pageKey2, int i);

    public static final native long DMS_movePage__SWIG_3(long j, DMS dms, long j2, PageKey pageKey, long j3, PageKey pageKey2);

    public static final native void DMS_movePagesToTrash(long j, DMS dms, long j2, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native boolean DMS_movePages__SWIG_0(long j, DMS dms, long j2, SWIGVectorPageKey sWIGVectorPageKey, long j3, NotebookKey notebookKey);

    public static final native boolean DMS_movePages__SWIG_1(long j, DMS dms, long j2, SWIGVectorPageKey sWIGVectorPageKey, long j3, PageKey pageKey);

    public static final native long DMS_notebookFromKey(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native long DMS_notebookFromPageKey(long j, DMS dms, long j2, PageKey pageKey);

    public static final native long DMS_notebooks__SWIG_0(long j, DMS dms, long j2, CollectionKey collectionKey, int i);

    public static final native long DMS_notebooks__SWIG_1(long j, DMS dms, long j2, CollectionKey collectionKey);

    public static final native long DMS_numberOfnotebookToSync(long j, DMS dms);

    public static final native long DMS_open2(long j, DMS dms, long j2, PageKey pageKey, long j3, DisplayContext displayContext, long j4, RecoContext recoContext, long j5, SWIGOptionContext sWIGOptionContext);

    public static final native long DMS_openReadOnly(long j, DMS dms, long j2, PageKey pageKey);

    public static final native long DMS_open__SWIG_0(long j, DMS dms, long j2, PageKey pageKey, long j3, DisplayContext displayContext, long j4, RecoContext recoContext, long j5);

    public static final native long DMS_open__SWIG_1(long j, DMS dms, long j2, PageKey pageKey, long j3, DisplayContext displayContext, long j4, RecoContext recoContext);

    public static final native int DMS_optimizePageAttachment__SWIG_0(long j, DMS dms, long j2, PageKey pageKey, int i, double d);

    public static final native int DMS_optimizePageAttachment__SWIG_1(long j, DMS dms, long j2, PageKey pageKey, int i);

    public static final native long DMS_overwritePage(long j, DMS dms, long j2, PageKey pageKey, byte[] bArr);

    public static final native long DMS_pageCount(long j, DMS dms, boolean z);

    public static final native long DMS_pageFromKey(long j, DMS dms, long j2, PageKey pageKey);

    public static final native long DMS_pages__SWIG_0(long j, DMS dms, long j2, NotebookKey notebookKey, int i);

    public static final native long DMS_pages__SWIG_1(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native long DMS_pages__SWIG_2(long j, DMS dms, long j2, PageKey pageKey, int i);

    public static final native long DMS_pages__SWIG_3(long j, DMS dms, long j2, PageKey pageKey);

    public static final native void DMS_purgeV1Files(long j, DMS dms);

    public static final native void DMS_rawDataBackup(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native void DMS_recoverLostTemporarySaves__SWIG_0(long j, DMS dms, byte[] bArr);

    public static final native void DMS_recoverLostTemporarySaves__SWIG_1(long j, DMS dms);

    public static final native void DMS_recoverOrphanNotebooks__SWIG_0(long j, DMS dms, byte[] bArr);

    public static final native void DMS_recoverOrphanNotebooks__SWIG_1(long j, DMS dms);

    public static final native void DMS_refreshSyncState(long j, DMS dms);

    public static final native void DMS_removeDMSListener(long j, DMS dms, IDMSListener iDMSListener);

    public static final native void DMS_removeThumbnailNotificationListener(long j, DMS dms, IThumbnailerNotificationListener iThumbnailerNotificationListener);

    public static final native boolean DMS_renameCollection(long j, DMS dms, long j2, CollectionKey collectionKey, byte[] bArr);

    public static final native boolean DMS_renameNotebook(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr);

    public static final native long DMS_requiredDiskSpaceForMigrationToV2(long j, DMS dms);

    public static final native void DMS_resetListener(long j, DMS dms);

    public static final native long DMS_resetPageUUID(long j, DMS dms, long j2, PageKey pageKey);

    public static final native void DMS_restart(long j, DMS dms);

    public static final native void DMS_restartThumbnailer(long j, DMS dms);

    public static final native void DMS_restoreAll(long j, DMS dms);

    public static final native boolean DMS_restoreCollection(long j, DMS dms, long j2, CollectionKey collectionKey);

    public static final native void DMS_restoreCollections(long j, DMS dms, long j2, SWIGVectorCollectionKey sWIGVectorCollectionKey);

    public static final native boolean DMS_restoreNotebook(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native void DMS_restoreNotebooks(long j, DMS dms, long j2, SWIGVectorNotebookKey sWIGVectorNotebookKey);

    public static final native boolean DMS_restorePage(long j, DMS dms, long j2, PageKey pageKey);

    public static final native void DMS_restorePages(long j, DMS dms, long j2, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native boolean DMS_resumeSync(long j, DMS dms);

    public static final native void DMS_save__SWIG_0(long j, DMS dms, long j2, PageController pageController, boolean z, boolean z2);

    public static final native void DMS_save__SWIG_1(long j, DMS dms, long j2, PageController pageController, boolean z);

    public static final native long DMS_searchController__SWIG_0(long j, DMS dms, boolean z);

    public static final native long DMS_searchController__SWIG_1(long j, DMS dms);

    public static final native void DMS_setAutoSyncEnabled(long j, DMS dms, boolean z);

    public static final native void DMS_setAutoSyncInterval(long j, DMS dms, long j2);

    public static final native boolean DMS_setBackgroundColor__SWIG_0(long j, DMS dms, long j2, PageKey pageKey, int i, boolean z);

    public static final native boolean DMS_setBackgroundColor__SWIG_1(long j, DMS dms, long j2, PageKey pageKey, int i);

    public static final native boolean DMS_setBackgroundPattern__SWIG_0(long j, DMS dms, long j2, PageKey pageKey, byte[] bArr, boolean z);

    public static final native boolean DMS_setBackgroundPattern__SWIG_1(long j, DMS dms, long j2, PageKey pageKey, byte[] bArr);

    public static final native void DMS_setCloudDriveInterface__SWIG_0(long j, DMS dms, ICloudDriveInterface iCloudDriveInterface);

    public static final native void DMS_setCloudDriveInterface__SWIG_1(long j, DMS dms, long j2, DegradedCloudDriveWrapper degradedCloudDriveWrapper);

    public static final native void DMS_setConflictRenamePattern(long j, DMS dms, byte[] bArr);

    public static final native void DMS_setConfsDir(long j, DMS dms, long j2, SWIGVectorString sWIGVectorString);

    public static final native void DMS_setCoverColors2(long j, DMS dms, long j2, PageKey pageKey, long j3, SWIGVectorColors sWIGVectorColors);

    public static final native boolean DMS_setLanguage(long j, DMS dms, long j2, PageKey pageKey, byte[] bArr);

    public static final native boolean DMS_setLastOpenedPageUUID(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr);

    public static final native void DMS_setMaxNotebooksToDownloadInParallel(long j, DMS dms, long j2);

    public static final native void DMS_setMaxNotebooksToUploadInParallel(long j, DMS dms, long j2);

    public static final native void DMS_setPageCorruptionListener(long j, DMS dms, IPageCorruptionListener iPageCorruptionListener);

    public static final native void DMS_setThumbnailConfiguration(long j, DMS dms, float f, float f2, byte[] bArr, IColorInversionPolicy iColorInversionPolicy);

    public static final native void DMS_setTypesetListener(long j, DMS dms, ITypesetListener iTypesetListener);

    public static final native void DMS_startSynchronizationTimer(long j, DMS dms);

    public static final native void DMS_stopSynchronizationTimer(long j, DMS dms);

    public static final native void DMS_stopThumbnailer(long j, DMS dms);

    public static final native void DMS_stop__SWIG_0(long j, DMS dms, boolean z);

    public static final native void DMS_stop__SWIG_1(long j, DMS dms);

    public static final native long DMS_supportedExportMimeTypes(long j, DMS dms, long j2, PageKey pageKey);

    public static final native void DMS_syncAllNotebooks__SWIG_0(long j, DMS dms, boolean z);

    public static final native void DMS_syncAllNotebooks__SWIG_1(long j, DMS dms);

    public static final native long DMS_syncEngine(long j, DMS dms);

    public static final native void DMS_syncNotebook(long j, DMS dms, long j2, NotebookKey notebookKey);

    public static final native int DMS_syncState__SWIG_0(long j, DMS dms);

    public static final native int DMS_syncState__SWIG_1(long j, DMS dms, byte[] bArr);

    public static final native boolean DMS_tagCorruptionInfoPage(long j, DMS dms, long j2, PageKey pageKey, long j3, NeboSanitizer.SanitizerResult sanitizerResult);

    public static final native boolean DMS_tagCorruptionWarningInfoPage(long j, DMS dms, long j2, PageKey pageKey, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native byte[] DMS_thumbnailPath(long j, DMS dms, long j2, PageKey pageKey, long j3);

    public static final native long DMS_thumbnailer(long j, DMS dms);

    public static final native boolean DMS_untagCorruptedPage(long j, DMS dms, long j2, PageKey pageKey);

    public static final native boolean DMS_untagCorruptedWarningPage(long j, DMS dms, long j2, PageKey pageKey);

    public static final native void DMS_updateFolderCoverColor(long j, DMS dms, long j2, NotebookKey notebookKey, int i);

    public static final native boolean DMS_updateLanguage(long j, DMS dms, long j2, NotebookKey notebookKey, byte[] bArr);

    public static final native boolean DMS_updatePageTitle(long j, DMS dms, long j2, PageKey pageKey, byte[] bArr);

    public static final native long DMS_userNotebooksCount(long j, DMS dms);

    public static final native void DMS_waitForOngoingSync(long j, DMS dms);

    public static final native void DMS_waitForPendingSaves(long j, DMS dms);

    public static final native byte[] DMS_welcomeVersion(long j, DMS dms, long j2, PageKey pageKey);

    public static final native byte[] DMS_workingDirPath(long j, DMS dms);

    public static final native boolean DefaultCloudIntegrationLogger_allowColors(long j, DefaultCloudIntegrationLogger defaultCloudIntegrationLogger);

    public static final native void DefaultCloudIntegrationLogger_flush(long j, DefaultCloudIntegrationLogger defaultCloudIntegrationLogger);

    public static final native void DefaultCloudIntegrationLogger_log(long j, DefaultCloudIntegrationLogger defaultCloudIntegrationLogger, byte[] bArr);

    public static final native void DefaultCloudIntegrationLogger_logLine__SWIG_0(long j, DefaultCloudIntegrationLogger defaultCloudIntegrationLogger, byte[] bArr);

    public static final native void DefaultCloudIntegrationLogger_logLine__SWIG_1(long j, DefaultCloudIntegrationLogger defaultCloudIntegrationLogger);

    public static final native int DegradedCloudDriveWrapper_getDegradedDownload(long j, DegradedCloudDriveWrapper degradedCloudDriveWrapper);

    public static final native int DegradedCloudDriveWrapper_getDegradedUpload(long j, DegradedCloudDriveWrapper degradedCloudDriveWrapper);

    public static final native void DegradedCloudDriveWrapper_setDegradedDownload(long j, DegradedCloudDriveWrapper degradedCloudDriveWrapper, int i);

    public static final native void DegradedCloudDriveWrapper_setDegradedUpload(long j, DegradedCloudDriveWrapper degradedCloudDriveWrapper, int i);

    public static final native byte[] DeterministicUuidGenerator_generateUUID(long j, DeterministicUuidGenerator deterministicUuidGenerator);

    public static final native void DeterministicUuidGenerator_reset(long j, DeterministicUuidGenerator deterministicUuidGenerator);

    public static final native long Device_cloudDrive_get(long j, Device device);

    public static final native void Device_cloudDrive_set(long j, Device device, long j2);

    public static final native long Device_dms_get(long j, Device device);

    public static final native void Device_dms_set(long j, Device device, long j2, DMS dms);

    public static final native int Device_id_get(long j, Device device);

    public static final native void Device_id_set(long j, Device device, int i);

    public static final native byte[] Device_name_get(long j, Device device);

    public static final native void Device_name_set(long j, Device device, byte[] bArr);

    public static final native long Device_uuidGenerator_get(long j, Device device);

    public static final native void Device_uuidGenerator_set(long j, Device device, long j2);

    public static final native byte[] Device_v1Dir_get(long j, Device device);

    public static final native void Device_v1Dir_set(long j, Device device, byte[] bArr);

    public static final native byte[] Device_v2Dir_get(long j, Device device);

    public static final native void Device_v2Dir_set(long j, Device device, byte[] bArr);

    public static final native long Device_viewModel_get(long j, Device device);

    public static final native void Device_viewModel_set(long j, Device device, long j2);

    public static final native boolean ImportBackupOptions_deleteCloudOnlyObjects_get(long j, ImportBackupOptions importBackupOptions);

    public static final native void ImportBackupOptions_deleteCloudOnlyObjects_set(long j, ImportBackupOptions importBackupOptions, boolean z);

    public static final native byte[] InvalidPageId_get();

    public static final native byte[] MetadataInfo_key_get(long j, MetadataInfo metadataInfo);

    public static final native void MetadataInfo_key_set(long j, MetadataInfo metadataInfo, byte[] bArr);

    public static final native long MetadataInfo_timestamp_get(long j, MetadataInfo metadataInfo);

    public static final native void MetadataInfo_timestamp_set(long j, MetadataInfo metadataInfo, long j2);

    public static final native byte[] MetadataInfo_value_get(long j, MetadataInfo metadataInfo);

    public static final native void MetadataInfo_value_set(long j, MetadataInfo metadataInfo, byte[] bArr);

    public static final native long MonkeyOperationData_collectionKey_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_collectionKey_set(long j, MonkeyOperationData monkeyOperationData, long j2, CollectionKey collectionKey);

    public static final native int MonkeyOperationData_device_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_device_set(long j, MonkeyOperationData monkeyOperationData, int i);

    public static final native boolean MonkeyOperationData_disabled_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_disabled_set(long j, MonkeyOperationData monkeyOperationData, boolean z);

    public static final native int MonkeyOperationData_newPositionIndex_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_newPositionIndex_set(long j, MonkeyOperationData monkeyOperationData, int i);

    public static final native byte[] MonkeyOperationData_newUuid_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_newUuid_set(long j, MonkeyOperationData monkeyOperationData, byte[] bArr);

    public static final native long MonkeyOperationData_notebookKey_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_notebookKey_set(long j, MonkeyOperationData monkeyOperationData, long j2, NotebookKey notebookKey);

    public static final native int MonkeyOperationData_operation_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_operation_set(long j, MonkeyOperationData monkeyOperationData, int i);

    public static final native long MonkeyOperationData_pageContainerKey_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_pageContainerKey_set(long j, MonkeyOperationData monkeyOperationData, long j2, PageKey pageKey);

    public static final native long MonkeyOperationData_pageKey_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_pageKey_set(long j, MonkeyOperationData monkeyOperationData, long j2, PageKey pageKey);

    public static final native int MonkeyOperationData_step_get(long j, MonkeyOperationData monkeyOperationData);

    public static final native void MonkeyOperationData_step_set(long j, MonkeyOperationData monkeyOperationData, int i);

    public static final native boolean MonkeyTestConfiguration_assertOrExitOnComplete_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_assertOrExitOnComplete_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, boolean z);

    public static final native boolean MonkeyTestConfiguration_enableTrashSupport_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_enableTrashSupport_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, boolean z);

    public static final native boolean MonkeyTestConfiguration_forceInitializeV2_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_forceInitializeV2_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, boolean z);

    public static final native int MonkeyTestConfiguration_imageNumMax_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_imageNumMax_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, int i);

    public static final native int MonkeyTestConfiguration_imageNumMin_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_imageNumMin_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, int i);

    public static final native byte[] MonkeyTestConfiguration_imagePathPattern_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_imagePathPattern_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, byte[] bArr);

    public static final native boolean MonkeyTestConfiguration_onlyFirstDeviceUseV1Data_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_onlyFirstDeviceUseV1Data_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, boolean z);

    public static final native long MonkeyTestConfiguration_operationCount_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_operationCount_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, long j2);

    public static final native byte[] MonkeyTestConfiguration_recoAssetsDir_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_recoAssetsDir_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, byte[] bArr);

    public static final native long MonkeyTestConfiguration_seed_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_seed_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, long j2);

    public static final native byte[] MonkeyTestConfiguration_tempDir_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_tempDir_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, byte[] bArr);

    public static final native boolean MonkeyTestConfiguration_useDeterministicsUuid_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_useDeterministicsUuid_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, boolean z);

    public static final native long MonkeyTestConfiguration_v1CollectionMax_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_v1CollectionMax_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, long j2);

    public static final native long MonkeyTestConfiguration_v1CollectionMin_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_v1CollectionMin_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, long j2);

    public static final native long MonkeyTestConfiguration_v1NotebookMax_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_v1NotebookMax_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, long j2);

    public static final native long MonkeyTestConfiguration_v1NotebookMin_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_v1NotebookMin_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, long j2);

    public static final native long MonkeyTestConfiguration_v1PageMax_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_v1PageMax_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, long j2);

    public static final native long MonkeyTestConfiguration_v1PageMin_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_v1PageMin_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, long j2);

    public static final native boolean MonkeyTestConfiguration_verbose_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_verbose_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, boolean z);

    public static final native boolean MonkeyTestConfiguration_withPageContainer_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_withPageContainer_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, boolean z);

    public static final native boolean MonkeyTestConfiguration_withV1Data_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_withV1Data_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, boolean z);

    public static final native byte[] MonkeyTestConfiguration_workingDir_get(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native void MonkeyTestConfiguration_workingDir_set(long j, MonkeyTestConfiguration monkeyTestConfiguration, byte[] bArr);

    public static final native boolean MonkeyTest_run2(long j, MonkeyTest monkeyTest, ICloudDriveInterface iCloudDriveInterface, ICloudDriveInterface iCloudDriveInterface2, IDMSListener iDMSListener, IDMSListener iDMSListener2);

    public static final native boolean MonkeyTest_run__SWIG_0(long j, MonkeyTest monkeyTest, long j2, long j3);

    public static final native boolean MonkeyTest_run__SWIG_1(long j, MonkeyTest monkeyTest, long j2);

    public static final native void MonkeyTest_setLogger(long j, MonkeyTest monkeyTest, CloudIntegrationLogger cloudIntegrationLogger);

    public static final native byte[] MonkeyTest_v1Dir(long j, MonkeyTest monkeyTest);

    public static final native int MoveInfo_newChildIndex_get(long j, MoveInfo moveInfo);

    public static final native void MoveInfo_newChildIndex_set(long j, MoveInfo moveInfo, int i);

    public static final native long MoveInfo_newParent_get(long j, MoveInfo moveInfo);

    public static final native void MoveInfo_newParent_set(long j, MoveInfo moveInfo, long j2);

    public static final native int MoveInfo_oldChildIndex_get(long j, MoveInfo moveInfo);

    public static final native void MoveInfo_oldChildIndex_set(long j, MoveInfo moveInfo, int i);

    public static final native long MoveInfo_oldParent_get(long j, MoveInfo moveInfo);

    public static final native void MoveInfo_oldParent_set(long j, MoveInfo moveInfo, long j2);

    public static final native long NeboBackupController_CURRENT_BACKUP_VERSION_get();

    public static final native byte[] NeboBackupController_METADATA_FILE_NAME_get();

    public static final native byte[] NeboBackupController_archiveExtension();

    public static final native byte[] NeboBackupController_backup__SWIG_0(long j, NeboBackupController neboBackupController, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z);

    public static final native byte[] NeboBackupController_backup__SWIG_1(long j, NeboBackupController neboBackupController, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native void NeboBackupController_cancel(long j, NeboBackupController neboBackupController);

    public static final native long NeboBackupController_metadata(long j, NeboBackupController neboBackupController, byte[] bArr);

    public static final native byte[] NeboBackupController_neboBackupFileName(byte[] bArr);

    public static final native boolean NeboBackupController_restore__SWIG_0(long j, NeboBackupController neboBackupController, byte[] bArr, IDMSMigrationToV2LogListener iDMSMigrationToV2LogListener);

    public static final native boolean NeboBackupController_restore__SWIG_1(long j, NeboBackupController neboBackupController, byte[] bArr);

    public static final native boolean NeboBackupController_saveMetadata(long j, BackupMetadata backupMetadata, byte[] bArr);

    public static final native void NeboBackupController_setProgressionListener(long j, NeboBackupController neboBackupController, INeboBackupProgressionListener iNeboBackupProgressionListener);

    public static final native void NeboBackupController_setZipArchiver(long j, NeboBackupController neboBackupController, IZipArchiver iZipArchiver);

    public static final native long NotebookCreationInfo_coverColor_get(long j, NotebookCreationInfo notebookCreationInfo);

    public static final native void NotebookCreationInfo_coverColor_set(long j, NotebookCreationInfo notebookCreationInfo, long j2);

    public static final native boolean NotebookCreationInfo_importNotebook_get(long j, NotebookCreationInfo notebookCreationInfo);

    public static final native void NotebookCreationInfo_importNotebook_set(long j, NotebookCreationInfo notebookCreationInfo, boolean z);

    public static final native boolean NotebookCreationInfo_isValid(long j, NotebookCreationInfo notebookCreationInfo);

    public static final native byte[] NotebookCreationInfo_notebookName_get(long j, NotebookCreationInfo notebookCreationInfo);

    public static final native void NotebookCreationInfo_notebookName_set(long j, NotebookCreationInfo notebookCreationInfo, byte[] bArr);

    public static final native long NotebookCreationInfo_parentCollectionKey_get(long j, NotebookCreationInfo notebookCreationInfo);

    public static final native void NotebookCreationInfo_parentCollectionKey_set(long j, NotebookCreationInfo notebookCreationInfo, long j2, CollectionKey collectionKey);

    public static final native byte[] NotebookInfo_appVersion_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_appVersion_set(long j, NotebookInfo notebookInfo, byte[] bArr);

    public static final native byte[] NotebookInfo_app_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_app_set(long j, NotebookInfo notebookInfo, byte[] bArr);

    public static final native byte[] NotebookInfo_corrupted_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_corrupted_set(long j, NotebookInfo notebookInfo, byte[] bArr);

    public static final native long NotebookInfo_coverColor_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_coverColor_set(long j, NotebookInfo notebookInfo, long j2);

    public static final native byte[] NotebookInfo_docVersion_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_docVersion_set(long j, NotebookInfo notebookInfo, byte[] bArr);

    public static final native long NotebookInfo_lastModificationDate_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_lastModificationDate_set(long j, NotebookInfo notebookInfo, long j2);

    public static final native byte[] NotebookInfo_lastOpenedPageId_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_lastOpenedPageId_set(long j, NotebookInfo notebookInfo, byte[] bArr);

    public static final native byte[] NotebookInfo_name_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_name_set(long j, NotebookInfo notebookInfo, byte[] bArr);

    public static final native long NotebookInfo_object_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_object_set(long j, NotebookInfo notebookInfo, long j2);

    public static final native byte[] NotebookInfo_os_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_os_set(long j, NotebookInfo notebookInfo, byte[] bArr);

    public static final native int NotebookInfo_trashState_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_trashState_set(long j, NotebookInfo notebookInfo, int i);

    public static final native boolean NotebookInfo_valid(long j, NotebookInfo notebookInfo);

    public static final native byte[] NotebookInfo_welcomeVersion_get(long j, NotebookInfo notebookInfo);

    public static final native void NotebookInfo_welcomeVersion_set(long j, NotebookInfo notebookInfo, byte[] bArr);

    public static final native void NotebookManager_addListener(long j, NotebookManager notebookManager, IPaginatedContainerListener iPaginatedContainerListener);

    public static final native long NotebookManager_create(long j, DMS dms, long j2, PageKey pageKey);

    public static final native long NotebookManager_createChildPageThumbnailGenerator(long j, NotebookManager notebookManager, IThumbnailerImageRequester iThumbnailerImageRequester, IColorInversionPolicy iColorInversionPolicy);

    public static final native byte[] NotebookManager_createPage__SWIG_0(long j, NotebookManager notebookManager, byte[] bArr, boolean z);

    public static final native byte[] NotebookManager_createPage__SWIG_1(long j, NotebookManager notebookManager, byte[] bArr);

    public static final native byte[] NotebookManager_duplicatePage__SWIG_0(long j, NotebookManager notebookManager, byte[] bArr, boolean z);

    public static final native byte[] NotebookManager_duplicatePage__SWIG_1(long j, NotebookManager notebookManager, byte[] bArr);

    public static final native boolean NotebookManager_isValidPageId(long j, NotebookManager notebookManager, byte[] bArr);

    public static final native void NotebookManager_movePage__SWIG_0(long j, NotebookManager notebookManager, byte[] bArr, byte[] bArr2, boolean z);

    public static final native void NotebookManager_movePage__SWIG_1(long j, NotebookManager notebookManager, byte[] bArr, byte[] bArr2);

    public static final native long NotebookManager_newRef(long j, NotebookManager notebookManager);

    public static final native long NotebookManager_pageActions(long j, NotebookManager notebookManager, byte[] bArr);

    public static final native byte[] NotebookManager_pageAt(long j, NotebookManager notebookManager, long j2);

    public static final native long NotebookManager_pageCount(long j, NotebookManager notebookManager);

    public static final native long NotebookManager_pageProperties(long j, NotebookManager notebookManager, byte[] bArr);

    public static final native long NotebookManager_pages(long j, NotebookManager notebookManager);

    public static final native void NotebookManager_removeListener(long j, NotebookManager notebookManager, IPaginatedContainerListener iPaginatedContainerListener);

    public static final native void NotebookManager_removePage(long j, NotebookManager notebookManager, byte[] bArr);

    public static final native void NotebookManager_removePages(long j, NotebookManager notebookManager, long j2, SWIGVectorString sWIGVectorString);

    public static final native void NotebookManager_selectPage__SWIG_0(long j, NotebookManager notebookManager, byte[] bArr, boolean z);

    public static final native void NotebookManager_selectPage__SWIG_1(long j, NotebookManager notebookManager, byte[] bArr);

    public static final native byte[] NotebookManager_selectedPage(long j, NotebookManager notebookManager);

    public static final native void NotebookManager_setPageBackgroundColor(long j, NotebookManager notebookManager, byte[] bArr, int i);

    public static final native void NotebookManager_setPageBackgroundPattern(long j, NotebookManager notebookManager, byte[] bArr, int i);

    public static final native long Notebook_derivedRef(long j, Notebook notebook);

    public static final native int Notebook_getCoverColor2(long j, Notebook notebook);

    public static final native long Notebook_getKey(long j, Notebook notebook);

    public static final native long Notebook_getLastModificationDate(long j, Notebook notebook);

    public static final native byte[] Notebook_getName(long j, Notebook notebook);

    public static final native int Notebook_hashCode(long j, Notebook notebook);

    public static final native boolean Notebook_isCloudOnly(long j, Notebook notebook);

    public static final native boolean Notebook_isCorrupted(long j, Notebook notebook);

    public static final native boolean Notebook_isSupported(long j, Notebook notebook);

    public static final native boolean Notebook_isTrashed(long j, Notebook notebook);

    public static final native boolean Notebook_isValid(long j, Notebook notebook);

    public static final native boolean Notebook_isWelcome(long j, Notebook notebook);

    public static final native boolean Notebook_nativeEquals(long j, Notebook notebook, long j2, Notebook notebook2);

    public static final native int Notebook_syncProgress(long j, Notebook notebook);

    public static final native int Notebook_syncState(long j, Notebook notebook);

    public static final native byte[] Notebook_toString(long j, Notebook notebook);

    public static final native int ObjectWithTrashState_Trash_state_get(long j, ObjectWithTrashState.Trash trash);

    public static final native void ObjectWithTrashState_Trash_state_set(long j, ObjectWithTrashState.Trash trash, int i);

    public static final native long ObjectWithTrashState_Trash_timestamp_get(long j, ObjectWithTrashState.Trash trash);

    public static final native void ObjectWithTrashState_Trash_timestamp_set(long j, ObjectWithTrashState.Trash trash, long j2);

    public static final native long ObjectWithTrashState_object_get(long j, ObjectWithTrashState objectWithTrashState);

    public static final native void ObjectWithTrashState_object_set(long j, ObjectWithTrashState objectWithTrashState, long j2);

    public static final native long ObjectWithTrashState_trash_get(long j, ObjectWithTrashState objectWithTrashState);

    public static final native void ObjectWithTrashState_trash_set(long j, ObjectWithTrashState objectWithTrashState, long j2, ObjectWithTrashState.Trash trash);

    public static final native void PDFManager_addListener(long j, PDFManager pDFManager, IPaginatedContainerListener iPaginatedContainerListener);

    public static final native long PDFManager_create(long j, PageController pageController);

    public static final native long PDFManager_createChildPageThumbnailGenerator(long j, PDFManager pDFManager, IThumbnailerImageRequester iThumbnailerImageRequester, IColorInversionPolicy iColorInversionPolicy);

    public static final native byte[] PDFManager_createPage__SWIG_0(long j, PDFManager pDFManager, byte[] bArr, boolean z);

    public static final native byte[] PDFManager_createPage__SWIG_1(long j, PDFManager pDFManager, byte[] bArr);

    public static final native byte[] PDFManager_duplicatePage__SWIG_0(long j, PDFManager pDFManager, byte[] bArr, boolean z);

    public static final native byte[] PDFManager_duplicatePage__SWIG_1(long j, PDFManager pDFManager, byte[] bArr);

    public static final native boolean PDFManager_isValidPageId(long j, PDFManager pDFManager, byte[] bArr);

    public static final native void PDFManager_movePage__SWIG_0(long j, PDFManager pDFManager, byte[] bArr, byte[] bArr2, boolean z);

    public static final native void PDFManager_movePage__SWIG_1(long j, PDFManager pDFManager, byte[] bArr, byte[] bArr2);

    public static final native long PDFManager_newRef(long j, PDFManager pDFManager);

    public static final native long PDFManager_pageActions(long j, PDFManager pDFManager, byte[] bArr);

    public static final native byte[] PDFManager_pageAt(long j, PDFManager pDFManager, long j2);

    public static final native long PDFManager_pageCount(long j, PDFManager pDFManager);

    public static final native long PDFManager_pageProperties(long j, PDFManager pDFManager, byte[] bArr);

    public static final native long PDFManager_pages(long j, PDFManager pDFManager);

    public static final native void PDFManager_removeListener(long j, PDFManager pDFManager, IPaginatedContainerListener iPaginatedContainerListener);

    public static final native void PDFManager_removePage(long j, PDFManager pDFManager, byte[] bArr);

    public static final native void PDFManager_removePages(long j, PDFManager pDFManager, long j2, SWIGVectorString sWIGVectorString);

    public static final native void PDFManager_selectPage__SWIG_0(long j, PDFManager pDFManager, byte[] bArr, boolean z);

    public static final native void PDFManager_selectPage__SWIG_1(long j, PDFManager pDFManager, byte[] bArr);

    public static final native byte[] PDFManager_selectedPage(long j, PDFManager pDFManager);

    public static final native void PDFManager_setPageBackgroundColor(long j, PDFManager pDFManager, byte[] bArr, int i);

    public static final native void PDFManager_setPageBackgroundPattern(long j, PDFManager pDFManager, byte[] bArr, int i);

    public static final native byte[] PageInfo_appVersion_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_appVersion_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native byte[] PageInfo_automaticTitle_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_automaticTitle_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native boolean PageInfo_backgroundColorIsNull_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_backgroundColorIsNull_set(long j, PageInfo pageInfo, boolean z);

    public static final native int PageInfo_backgroundColor_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_backgroundColor_set(long j, PageInfo pageInfo, int i);

    public static final native boolean PageInfo_backgroundPatternIsNull_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_backgroundPatternIsNull_set(long j, PageInfo pageInfo, boolean z);

    public static final native byte[] PageInfo_backgroundPattern_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_backgroundPattern_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native int PageInfo_childPageCount_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_childPageCount_set(long j, PageInfo pageInfo, int i);

    public static final native long PageInfo_corruptedInfo_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_corruptedInfo_set(long j, PageInfo pageInfo, long j2, CorruptionInfo corruptionInfo);

    public static final native long PageInfo_corruptedWarningInfo_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_corruptedWarningInfo_set(long j, PageInfo pageInfo, long j2, CorruptionInfo corruptionInfo);

    public static final native long PageInfo_coverColors_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_coverColors_set(long j, PageInfo pageInfo, long j2);

    public static final native byte[] PageInfo_creationAppVersion_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_creationAppVersion_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native byte[] PageInfo_diagramVersion_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_diagramVersion_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native byte[] PageInfo_docVersion_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_docVersion_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native byte[] PageInfo_drawingVersion_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_drawingVersion_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native byte[] PageInfo_embeddedContentFilename_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_embeddedContentFilename_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native boolean PageInfo_embeddedContentInitDone_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_embeddedContentInitDone_set(long j, PageInfo pageInfo, boolean z);

    public static final native byte[] PageInfo_embeddedContentObjectUrl_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_embeddedContentObjectUrl_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native byte[] PageInfo_embeddedContentType_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_embeddedContentType_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native boolean PageInfo_hasContent_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_hasContent_set(long j, PageInfo pageInfo, boolean z);

    public static final native float PageInfo_height_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_height_set(long j, PageInfo pageInfo, float f);

    public static final native boolean PageInfo_isContainer_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_isContainer_set(long j, PageInfo pageInfo, boolean z);

    public static final native boolean PageInfo_isValid_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_isValid_set(long j, PageInfo pageInfo, boolean z);

    public static final native byte[] PageInfo_language_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_language_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native long PageInfo_lastModificationDate_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_lastModificationDate_set(long j, PageInfo pageInfo, long j2);

    public static final native byte[] PageInfo_mathVersion_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_mathVersion_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native long PageInfo_metadataModificationDate_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_metadataModificationDate_set(long j, PageInfo pageInfo, long j2);

    public static final native long PageInfo_object_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_object_set(long j, PageInfo pageInfo, long j2);

    public static final native byte[] PageInfo_os_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_os_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native byte[] PageInfo_pageType_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_pageType_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native long PageInfo_resetedFieldsInfo_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_resetedFieldsInfo_set(long j, PageInfo pageInfo, long j2);

    public static final native long PageInfo_thumbnailGenerationDate_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_thumbnailGenerationDate_set(long j, PageInfo pageInfo, long j2);

    public static final native boolean PageInfo_titleIsNull_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_titleIsNull_set(long j, PageInfo pageInfo, boolean z);

    public static final native byte[] PageInfo_title_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_title_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native int PageInfo_trashState_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_trashState_set(long j, PageInfo pageInfo, int i);

    public static final native boolean PageInfo_valid(long j, PageInfo pageInfo);

    public static final native byte[] PageInfo_welcomeVersion_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_welcomeVersion_set(long j, PageInfo pageInfo, byte[] bArr);

    public static final native float PageInfo_width_get(long j, PageInfo pageInfo);

    public static final native void PageInfo_width_set(long j, PageInfo pageInfo, float f);

    public static final native boolean PagePreSaveInfo_automaticTitleChanged_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_automaticTitleChanged_set(long j, PagePreSaveInfo pagePreSaveInfo, boolean z);

    public static final native byte[] PagePreSaveInfo_automaticTitle_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_automaticTitle_set(long j, PagePreSaveInfo pagePreSaveInfo, byte[] bArr);

    public static final native boolean PagePreSaveInfo_hasContent_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_hasContent_set(long j, PagePreSaveInfo pagePreSaveInfo, boolean z);

    public static final native boolean PagePreSaveInfo_isDeleted_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_isDeleted_set(long j, PagePreSaveInfo pagePreSaveInfo, boolean z);

    public static final native boolean PagePreSaveInfo_isModified_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_isModified_set(long j, PagePreSaveInfo pagePreSaveInfo, boolean z);

    public static final native boolean PagePreSaveInfo_needThumbnailUpdate_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_needThumbnailUpdate_set(long j, PagePreSaveInfo pagePreSaveInfo, boolean z);

    public static final native long PagePreSaveInfo_page_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_page_set(long j, PagePreSaveInfo pagePreSaveInfo, long j2);

    public static final native boolean PagePreSaveInfo_scrollPositionChanged_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_scrollPositionChanged_set(long j, PagePreSaveInfo pagePreSaveInfo, boolean z);

    public static final native byte[] PagePreSaveInfo_scrollPosition_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_scrollPosition_set(long j, PagePreSaveInfo pagePreSaveInfo, byte[] bArr);

    public static final native long PagePreSaveInfo_timestamp_get(long j, PagePreSaveInfo pagePreSaveInfo);

    public static final native void PagePreSaveInfo_timestamp_set(long j, PagePreSaveInfo pagePreSaveInfo, long j2);

    public static final native int PageProperties_backgroundPattern_get(long j, PageProperties pageProperties);

    public static final native void PageProperties_backgroundPattern_set(long j, PageProperties pageProperties, int i);

    public static final native int PageProperties_getBackgroundColor(long j, PageProperties pageProperties);

    public static final native float PageProperties_height_get(long j, PageProperties pageProperties);

    public static final native void PageProperties_height_set(long j, PageProperties pageProperties, float f);

    public static final native boolean PageProperties_isCorrupted_get(long j, PageProperties pageProperties);

    public static final native void PageProperties_isCorrupted_set(long j, PageProperties pageProperties, boolean z);

    public static final native byte[] PageProperties_pageId_get(long j, PageProperties pageProperties);

    public static final native void PageProperties_pageId_set(long j, PageProperties pageProperties, byte[] bArr);

    public static final native float PageProperties_width_get(long j, PageProperties pageProperties);

    public static final native void PageProperties_width_set(long j, PageProperties pageProperties, float f);

    public static final native int Page_childPages(long j, Page page);

    public static final native byte[] Page_contentType__SWIG_0(long j, Page page);

    public static final native byte[] Page_contentType__SWIG_1(int i);

    public static final native long Page_creationDate(long j, Page page);

    public static final native long Page_derivedRef(long j, Page page);

    public static final native int Page_fromContentType(byte[] bArr);

    public static final native int Page_getBackgroundColor(long j, Page page);

    public static final native byte[] Page_getBackgroundPattern(long j, Page page);

    public static final native long Page_getCoverColors(long j, Page page);

    public static final native long Page_getKey(long j, Page page);

    public static final native long Page_getLastModificationDate(long j, Page page);

    public static final native byte[] Page_getTitle(long j, Page page);

    public static final native int Page_getType(long j, Page page);

    public static final native boolean Page_hasContent(long j, Page page);

    public static final native int Page_hashCode(long j, Page page);

    public static final native float Page_height(long j, Page page);

    public static final native boolean Page_isCloudOnly(long j, Page page);

    public static final native boolean Page_isContainer(long j, Page page);

    public static final native boolean Page_isCorrupted(long j, Page page);

    public static final native boolean Page_isMigrationNeeded(long j, Page page);

    public static final native boolean Page_isSupported(long j, Page page);

    public static final native boolean Page_isTrashed(long j, Page page);

    public static final native byte[] Page_language(long j, Page page);

    public static final native long Page_metadataModificationDate(long j, Page page);

    public static final native boolean Page_nativeEquals(long j, Page page, long j2, Page page2);

    public static final native long Page_rowId(long j, Page page);

    public static final native int Page_syncState(long j, Page page);

    public static final native long Page_thumbnailGenerationDate(long j, Page page);

    public static final native byte[] Page_toString(long j, Page page);

    public static final native byte[] Page_userTitle(long j, Page page);

    public static final native float Page_width(long j, Page page);

    public static final native long SWIGVectorCloudCreateFileRequest_at(long j, SWIGVectorCloudCreateFileRequest sWIGVectorCloudCreateFileRequest, int i);

    public static final native void SWIGVectorCloudCreateFileRequest_push_back(long j, SWIGVectorCloudCreateFileRequest sWIGVectorCloudCreateFileRequest, long j2, CloudCreateFileRequest cloudCreateFileRequest);

    public static final native int SWIGVectorCloudCreateFileRequest_size(long j, SWIGVectorCloudCreateFileRequest sWIGVectorCloudCreateFileRequest);

    public static final native long SWIGVectorCloudCreateFolderRequest_at(long j, SWIGVectorCloudCreateFolderRequest sWIGVectorCloudCreateFolderRequest, int i);

    public static final native void SWIGVectorCloudCreateFolderRequest_push_back(long j, SWIGVectorCloudCreateFolderRequest sWIGVectorCloudCreateFolderRequest, long j2, CloudCreateFolderRequest cloudCreateFolderRequest);

    public static final native int SWIGVectorCloudCreateFolderRequest_size(long j, SWIGVectorCloudCreateFolderRequest sWIGVectorCloudCreateFolderRequest);

    public static final native long SWIGVectorCloudFileData_at(long j, SWIGVectorCloudFileData sWIGVectorCloudFileData, int i);

    public static final native void SWIGVectorCloudFileData_push_back(long j, SWIGVectorCloudFileData sWIGVectorCloudFileData, long j2, CloudFileData cloudFileData);

    public static final native int SWIGVectorCloudFileData_size(long j, SWIGVectorCloudFileData sWIGVectorCloudFileData);

    public static final native long SWIGVectorCloudFileIdRev_at(long j, SWIGVectorCloudFileIdRev sWIGVectorCloudFileIdRev, int i);

    public static final native void SWIGVectorCloudFileIdRev_push_back(long j, SWIGVectorCloudFileIdRev sWIGVectorCloudFileIdRev, long j2, CloudFileIdRev cloudFileIdRev);

    public static final native int SWIGVectorCloudFileIdRev_size(long j, SWIGVectorCloudFileIdRev sWIGVectorCloudFileIdRev);

    public static final native long SWIGVectorCloudFileRequest_at(long j, SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest, int i);

    public static final native void SWIGVectorCloudFileRequest_push_back(long j, SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest, long j2, CloudFileRequest cloudFileRequest);

    public static final native int SWIGVectorCloudFileRequest_size(long j, SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest);

    public static final native long SWIGVectorCloudUploadFileRequest_at(long j, SWIGVectorCloudUploadFileRequest sWIGVectorCloudUploadFileRequest, int i);

    public static final native void SWIGVectorCloudUploadFileRequest_push_back(long j, SWIGVectorCloudUploadFileRequest sWIGVectorCloudUploadFileRequest, long j2, CloudUploadFileRequest cloudUploadFileRequest);

    public static final native int SWIGVectorCloudUploadFileRequest_size(long j, SWIGVectorCloudUploadFileRequest sWIGVectorCloudUploadFileRequest);

    public static final native long SWIGVectorCollection_at(long j, SWIGVectorCollection sWIGVectorCollection, int i);

    public static final native void SWIGVectorCollection_push_back(long j, SWIGVectorCollection sWIGVectorCollection, long j2, Collection collection);

    public static final native int SWIGVectorCollection_size(long j, SWIGVectorCollection sWIGVectorCollection);

    public static final native long SWIGVectorNotebook_at(long j, SWIGVectorNotebook sWIGVectorNotebook, int i);

    public static final native void SWIGVectorNotebook_push_back(long j, SWIGVectorNotebook sWIGVectorNotebook, long j2, Notebook notebook);

    public static final native int SWIGVectorNotebook_size(long j, SWIGVectorNotebook sWIGVectorNotebook);

    public static final native int SWIGVectorPageAction_at(long j, SWIGVectorPageAction sWIGVectorPageAction, int i);

    public static final native void SWIGVectorPageAction_push_back(long j, SWIGVectorPageAction sWIGVectorPageAction, int i);

    public static final native int SWIGVectorPageAction_size(long j, SWIGVectorPageAction sWIGVectorPageAction);

    public static final native long SWIGVectorPageProperties_at(long j, SWIGVectorPageProperties sWIGVectorPageProperties, int i);

    public static final native void SWIGVectorPageProperties_push_back(long j, SWIGVectorPageProperties sWIGVectorPageProperties, long j2, PageProperties pageProperties);

    public static final native int SWIGVectorPageProperties_size(long j, SWIGVectorPageProperties sWIGVectorPageProperties);

    public static final native long SWIGVectorPage_at(long j, SWIGVectorPage sWIGVectorPage, int i);

    public static final native void SWIGVectorPage_push_back(long j, SWIGVectorPage sWIGVectorPage, long j2, Page page);

    public static final native int SWIGVectorPage_size(long j, SWIGVectorPage sWIGVectorPage);

    public static final native long SWIGVectorSharePageUser_at(long j, SWIGVectorSharePageUser sWIGVectorSharePageUser, int i);

    public static final native void SWIGVectorSharePageUser_push_back(long j, SWIGVectorSharePageUser sWIGVectorSharePageUser, long j2, SharePageUser sharePageUser);

    public static final native int SWIGVectorSharePageUser_size(long j, SWIGVectorSharePageUser sWIGVectorSharePageUser);

    public static final native long SWIGVectorSharePage_at(long j, SWIGVectorSharePage sWIGVectorSharePage, int i);

    public static final native void SWIGVectorSharePage_push_back(long j, SWIGVectorSharePage sWIGVectorSharePage, long j2, SharePage sharePage);

    public static final native int SWIGVectorSharePage_size(long j, SWIGVectorSharePage sWIGVectorSharePage);

    public static final native byte[] SharePageManagerTaskParam_documentPath_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_documentPath_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, byte[] bArr);

    public static final native byte[] SharePageManagerTaskParam_message_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_message_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, byte[] bArr);

    public static final native long SharePageManagerTaskParam_newPageKey_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_newPageKey_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, long j2, PageKey pageKey);

    public static final native long SharePageManagerTaskParam_notebookKeys_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_notebookKeys_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, long j2, SWIGVectorNotebookKey sWIGVectorNotebookKey);

    public static final native long SharePageManagerTaskParam_pageKeys_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_pageKeys_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, long j2, SWIGVectorPageKey sWIGVectorPageKey);

    public static final native long SharePageManagerTaskParam_result_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_result_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, long j2, SharePageResult sharePageResult);

    public static final native long SharePageManagerTaskParam_sharePageRequest_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_sharePageRequest_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, long j2, SharePageRequest sharePageRequest);

    public static final native byte[] SharePageManagerTaskParam_userEmail_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_userEmail_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, byte[] bArr);

    public static final native long SharePageManagerTaskParam_users_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_users_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, long j2, SWIGVectorSharePageUser sWIGVectorSharePageUser);

    public static final native int SharePageManagerTaskParam_visibility_get(long j, SharePageManagerTaskParam sharePageManagerTaskParam);

    public static final native void SharePageManagerTaskParam_visibility_set(long j, SharePageManagerTaskParam sharePageManagerTaskParam, int i);

    public static final native void SharePageManager_addUsers(long j, SharePageManager sharePageManager, long j2, PageKey pageKey, long j3, SWIGVectorSharePageUser sWIGVectorSharePageUser, byte[] bArr);

    public static final native boolean SharePageManager_changeSharePageState(long j, SharePageManager sharePageManager, long j2, PageKey pageKey, int i);

    public static final native boolean SharePageManager_changeSharePageUploadProgress(long j, SharePageManager sharePageManager, long j2, PageKey pageKey, float f, float f2);

    public static final native void SharePageManager_changeVisibility(long j, SharePageManager sharePageManager, long j2, PageKey pageKey, int i);

    public static final native long SharePageManager_create(long j, DMS dms, byte[] bArr, byte[] bArr2);

    public static final native void SharePageManager_destroy(long j, SharePageManager sharePageManager);

    public static final native void SharePageManager_disableSharePage(long j, SharePageManager sharePageManager, long j2, PageKey pageKey);

    public static final native void SharePageManager_fetchSharedPageInfos(long j, SharePageManager sharePageManager, long j2, PageKey pageKey);

    public static final native void SharePageManager_listSharedPages(long j, SharePageManager sharePageManager);

    public static final native void SharePageManager_removeSharePage(long j, SharePageManager sharePageManager, long j2, PageKey pageKey);

    public static final native void SharePageManager_removeUser(long j, SharePageManager sharePageManager, long j2, PageKey pageKey, byte[] bArr);

    public static final native void SharePageManager_setListPagesTimerInterval(long j, SharePageManager sharePageManager, long j2);

    public static final native void SharePageManager_setRequester(long j, SharePageManager sharePageManager, ISharePageManagerRequester iSharePageManagerRequester);

    public static final native void SharePageManager_setUIListener(long j, SharePageManager sharePageManager, ISharePageManagerUIListener iSharePageManagerUIListener);

    public static final native void SharePageManager_sharePage(long j, SharePageManager sharePageManager, long j2, PageKey pageKey);

    public static final native void SharePageManager_sharePageDone(long j, SharePageManager sharePageManager, long j2, PageKey pageKey, long j3, SharePageResult sharePageResult);

    public static final native long SharePageManager_sharedPage(long j, SharePageManager sharePageManager, long j2, PageKey pageKey);

    public static final native long SharePageManager_sharedPages(long j, SharePageManager sharePageManager);

    public static final native void SharePageManager_startListPagesTimer(long j, SharePageManager sharePageManager);

    public static final native void SharePageManager_stopListPagesTimer(long j, SharePageManager sharePageManager);

    public static final native void SharePageManager_updateUser(long j, SharePageManager sharePageManager, long j2, PageKey pageKey, long j3, SharePageUser sharePageUser);

    public static final native boolean SharePageOptions_addUser(long j, SharePageOptions sharePageOptions, long j2, SharePageUser sharePageUser);

    public static final native void SharePageOptions_clearUsers(long j, SharePageOptions sharePageOptions);

    public static final native long SharePageOptions_fromJSON(long j, Json json);

    public static final native boolean SharePageOptions_removeUser(long j, SharePageOptions sharePageOptions, byte[] bArr);

    public static final native boolean SharePageOptions_replaceUser(long j, SharePageOptions sharePageOptions, long j2, SharePageUser sharePageUser);

    public static final native void SharePageOptions_setUserMessage(long j, SharePageOptions sharePageOptions, byte[] bArr);

    public static final native void SharePageOptions_setVisibility(long j, SharePageOptions sharePageOptions, int i);

    public static final native long SharePageOptions_sharePageUsers(long j, SharePageOptions sharePageOptions);

    public static final native long SharePageOptions_toJSON(long j, SharePageOptions sharePageOptions);

    public static final native long SharePageOptions_user(long j, SharePageOptions sharePageOptions, byte[] bArr);

    public static final native long SharePageOptions_userFromJSON(long j, Json json);

    public static final native byte[] SharePageOptions_userMessage(long j, SharePageOptions sharePageOptions);

    public static final native long SharePageOptions_userToJSON(long j, SharePageUser sharePageUser);

    public static final native int SharePageOptions_visibility(long j, SharePageOptions sharePageOptions);

    public static final native long SharePageRequest_notebookKey(long j, SharePageRequest sharePageRequest);

    public static final native long SharePageRequest_pageKey(long j, SharePageRequest sharePageRequest);

    public static final native byte[] SharePageRequest_uuid(long j, SharePageRequest sharePageRequest);

    public static final native boolean SharePageResult_isSuccess_get(long j, SharePageResult sharePageResult);

    public static final native void SharePageResult_isSuccess_set(long j, SharePageResult sharePageResult, boolean z);

    public static final native int SharePageResult_returnCode_get(long j, SharePageResult sharePageResult);

    public static final native void SharePageResult_returnCode_set(long j, SharePageResult sharePageResult, int i);

    public static final native byte[] SharePageResult_sharedLink_get(long j, SharePageResult sharePageResult);

    public static final native void SharePageResult_sharedLink_set(long j, SharePageResult sharePageResult, byte[] bArr);

    public static final native long SharePageResult_uploadedDateMicroSeconds_get(long j, SharePageResult sharePageResult);

    public static final native void SharePageResult_uploadedDateMicroSeconds_set(long j, SharePageResult sharePageResult, long j2);

    public static final native long SharePageUser_createDefaultUser__SWIG_0(byte[] bArr, byte[] bArr2);

    public static final native long SharePageUser_createDefaultUser__SWIG_1(byte[] bArr);

    public static final native byte[] SharePageUser_email(long j, SharePageUser sharePageUser);

    public static final native boolean SharePageUser_isValid(long j, SharePageUser sharePageUser);

    public static final native byte[] SharePageUser_name(long j, SharePageUser sharePageUser);

    public static final native void SharePageUser_setUserRight(long j, SharePageUser sharePageUser, int i);

    public static final native int SharePageUser_userRight(long j, SharePageUser sharePageUser);

    public static final native boolean SharePage_canBeMerged(long j, SharePage sharePage);

    public static final native int SharePage_compare__SWIG_0(long j, SharePage sharePage, long j2, SharePage sharePage2);

    public static final native int SharePage_compare__SWIG_1(long j, SharePage sharePage, long j2);

    public static final native long SharePage_createDeletedSharePage(byte[] bArr);

    public static final native long SharePage_createEmptySharePage(byte[] bArr);

    public static final native long SharePage_createRemoteSharePage(byte[] bArr, byte[] bArr2, long j, long j2, byte[] bArr3, boolean z, long j3, SharePageOptions sharePageOptions, byte[] bArr4);

    public static final native long SharePage_creationDate(long j, SharePage sharePage);

    public static final native long SharePage_derivedRef(long j, SharePage sharePage);

    public static final native boolean SharePage_equals__SWIG_0(long j, SharePage sharePage, long j2, SharePage sharePage2);

    public static final native boolean SharePage_equals__SWIG_1(long j, SharePage sharePage, long j2, PageKey pageKey);

    public static final native boolean SharePage_isDeleted(long j, SharePage sharePage);

    public static final native boolean SharePage_isPageInitialized(long j, SharePage sharePage);

    public static final native boolean SharePage_isPageUpToDate(long j, SharePage sharePage);

    public static final native boolean SharePage_isTemporaryState(long j, SharePage sharePage);

    public static final native long SharePage_lastModificationDate(long j, SharePage sharePage);

    public static final native byte[] SharePage_lastSignature(long j, SharePage sharePage);

    public static final native long SharePage_localUploadedDate(long j, SharePage sharePage);

    public static final native void SharePage_markAsOutdated(long j, SharePage sharePage);

    public static final native void SharePage_mergeWithRemote(long j, SharePage sharePage, long j2, SharePage sharePage2);

    public static final native long SharePage_metadataModificationDate(long j, SharePage sharePage);

    public static final native long SharePage_options(long j, SharePage sharePage);

    public static final native float SharePage_pageFileSize(long j, SharePage sharePage);

    public static final native long SharePage_pageKey(long j, SharePage sharePage);

    public static final native int SharePage_pageStateFromPageDates(long j, SharePage sharePage);

    public static final native byte[] SharePage_pageType(long j, SharePage sharePage);

    public static final native long SharePage_remoteLastModificationDate(long j, SharePage sharePage);

    public static final native long SharePage_remoteMetadataModificationDate(long j, SharePage sharePage);

    public static final native byte[] SharePage_remoteSignature(long j, SharePage sharePage);

    public static final native byte[] SharePage_remoteStatus(long j, SharePage sharePage);

    public static final native long SharePage_remoteUploadedDate(long j, SharePage sharePage);

    public static final native void SharePage_resetPageKey(long j, SharePage sharePage, long j2, PageKey pageKey);

    public static final native void SharePage_setCreationDate(long j, SharePage sharePage, long j2);

    public static final native void SharePage_setIsDeleted(long j, SharePage sharePage, boolean z);

    public static final native void SharePage_setLastModificationDate(long j, SharePage sharePage, long j2);

    public static final native void SharePage_setLocalUploadedDate(long j, SharePage sharePage, long j2);

    public static final native void SharePage_setMetadataModificationDate(long j, SharePage sharePage, long j2);

    public static final native void SharePage_setOptions(long j, SharePage sharePage, long j2, SharePageOptions sharePageOptions);

    public static final native void SharePage_setPageFileSize(long j, SharePage sharePage, float f);

    public static final native void SharePage_setPageType(long j, SharePage sharePage, byte[] bArr);

    public static final native void SharePage_setRemoteLastModificationDate(long j, SharePage sharePage, long j2);

    public static final native void SharePage_setRemoteMetadataModificationDate(long j, SharePage sharePage, long j2);

    public static final native byte[] SharePage_setRemoteSignature(long j, SharePage sharePage, byte[] bArr);

    public static final native void SharePage_setRemoteStatus(long j, SharePage sharePage, byte[] bArr);

    public static final native void SharePage_setRemoteUploadedDate(long j, SharePage sharePage, long j2);

    public static final native void SharePage_setSharedLink(long j, SharePage sharePage, byte[] bArr);

    public static final native void SharePage_setState(long j, SharePage sharePage, int i);

    public static final native void SharePage_setTitle(long j, SharePage sharePage, byte[] bArr);

    public static final native void SharePage_setUploadProgress(long j, SharePage sharePage, float f);

    public static final native byte[] SharePage_sharedLink(long j, SharePage sharePage);

    public static final native byte[] SharePage_signature(long j, SharePage sharePage);

    public static final native int SharePage_state(long j, SharePage sharePage);

    public static final native byte[] SharePage_title(long j, SharePage sharePage);

    public static final native boolean SharePage_updateAfterUpload(long j, SharePage sharePage, long j2, SharePageResult sharePageResult);

    public static final native boolean SharePage_updateFromPageInfo(long j, SharePage sharePage, long j2, Page page);

    public static final native float SharePage_uploadProgress(long j, SharePage sharePage);

    public static final native byte[] SharePage_uuid(long j, SharePage sharePage);

    public static final native boolean SyncContentFile_applicable_get(long j, SyncContentFile syncContentFile);

    public static final native void SyncContentFile_applicable_set(long j, SyncContentFile syncContentFile, boolean z);

    public static final native byte[] SyncContentFile_filePath_get(long j, SyncContentFile syncContentFile);

    public static final native void SyncContentFile_filePath_set(long j, SyncContentFile syncContentFile, byte[] bArr);

    public static final native boolean SyncContentFile_makeCopy_get(long j, SyncContentFile syncContentFile);

    public static final native void SyncContentFile_makeCopy_set(long j, SyncContentFile syncContentFile, boolean z);

    public static final native byte[] SyncContentFile_signature_get(long j, SyncContentFile syncContentFile);

    public static final native void SyncContentFile_signature_set(long j, SyncContentFile syncContentFile, byte[] bArr);

    public static final native long SyncEventSet_cloud_get(long j, SyncEventSet syncEventSet);

    public static final native void SyncEventSet_cloud_set(long j, SyncEventSet syncEventSet, long j2, SyncEvent syncEvent);

    public static final native long SyncEventSet_local_get(long j, SyncEventSet syncEventSet);

    public static final native void SyncEventSet_local_set(long j, SyncEventSet syncEventSet, long j2, SyncEvent syncEvent);

    public static final native long SyncEventSet_merged_get(long j, SyncEventSet syncEventSet);

    public static final native void SyncEventSet_merged_set(long j, SyncEventSet syncEventSet, long j2, SyncEvent syncEvent);

    public static final native int SyncEvent_Attachment_referenceCount_get(long j, SyncEvent.Attachment attachment);

    public static final native void SyncEvent_Attachment_referenceCount_set(long j, SyncEvent.Attachment attachment, int i);

    public static final native byte[] SyncEvent_Attachment_url_get(long j, SyncEvent.Attachment attachment);

    public static final native void SyncEvent_Attachment_url_set(long j, SyncEvent.Attachment attachment, byte[] bArr);

    public static final native byte[] SyncEvent_Attachment_uuid_get(long j, SyncEvent.Attachment attachment);

    public static final native void SyncEvent_Attachment_uuid_set(long j, SyncEvent.Attachment attachment, byte[] bArr);

    public static final native long SyncEvent_Content_SWIGUpcast(long j);

    public static final native int SyncEvent_Content_origin_get(long j, SyncEvent.Content content);

    public static final native void SyncEvent_Content_origin_set(long j, SyncEvent.Content content, int i);

    public static final native byte[] SyncEvent_Metadata_key_get(long j, SyncEvent.Metadata metadata);

    public static final native void SyncEvent_Metadata_key_set(long j, SyncEvent.Metadata metadata, byte[] bArr);

    public static final native int SyncEvent_Metadata_origin_get(long j, SyncEvent.Metadata metadata);

    public static final native void SyncEvent_Metadata_origin_set(long j, SyncEvent.Metadata metadata, int i);

    public static final native long SyncEvent_Metadata_timestamp_get(long j, SyncEvent.Metadata metadata);

    public static final native void SyncEvent_Metadata_timestamp_set(long j, SyncEvent.Metadata metadata, long j2);

    public static final native byte[] SyncEvent_Metadata_value_get(long j, SyncEvent.Metadata metadata);

    public static final native void SyncEvent_Metadata_value_set(long j, SyncEvent.Metadata metadata, byte[] bArr);

    public static final native double SyncEvent_Parent_childIndex_get(long j, SyncEvent.Parent parent);

    public static final native void SyncEvent_Parent_childIndex_set(long j, SyncEvent.Parent parent, double d);

    public static final native int SyncEvent_Parent_origin_get(long j, SyncEvent.Parent parent);

    public static final native void SyncEvent_Parent_origin_set(long j, SyncEvent.Parent parent, int i);

    public static final native long SyncEvent_Parent_rowid_get(long j, SyncEvent.Parent parent);

    public static final native void SyncEvent_Parent_rowid_set(long j, SyncEvent.Parent parent, long j2);

    public static final native long SyncEvent_Parent_timestamp_get(long j, SyncEvent.Parent parent);

    public static final native void SyncEvent_Parent_timestamp_set(long j, SyncEvent.Parent parent, long j2);

    public static final native byte[] SyncEvent_Parent_uuid_get(long j, SyncEvent.Parent parent);

    public static final native void SyncEvent_Parent_uuid_set(long j, SyncEvent.Parent parent, byte[] bArr);

    public static final native int SyncEvent_Trash_origin_get(long j, SyncEvent.Trash trash);

    public static final native void SyncEvent_Trash_origin_set(long j, SyncEvent.Trash trash, int i);

    public static final native int SyncEvent_Trash_state_get(long j, SyncEvent.Trash trash);

    public static final native void SyncEvent_Trash_state_set(long j, SyncEvent.Trash trash, int i);

    public static final native long SyncEvent_Trash_timestamp_get(long j, SyncEvent.Trash trash);

    public static final native void SyncEvent_Trash_timestamp_set(long j, SyncEvent.Trash trash, long j2);

    public static final native long SyncEvent_attachments_get(long j, SyncEvent syncEvent);

    public static final native void SyncEvent_attachments_set(long j, SyncEvent syncEvent, long j2);

    public static final native long SyncEvent_content_get(long j, SyncEvent syncEvent);

    public static final native void SyncEvent_content_set(long j, SyncEvent syncEvent, long j2, SyncEvent.Content content);

    public static final native long SyncEvent_metadata_get(long j, SyncEvent syncEvent);

    public static final native void SyncEvent_metadata_set(long j, SyncEvent syncEvent, long j2);

    public static final native long SyncEvent_object_get(long j, SyncEvent syncEvent);

    public static final native void SyncEvent_object_set(long j, SyncEvent syncEvent, long j2);

    public static final native long SyncEvent_parent_get(long j, SyncEvent syncEvent);

    public static final native void SyncEvent_parent_set(long j, SyncEvent syncEvent, long j2, SyncEvent.Parent parent);

    public static final native void SyncEvent_setOrigin(long j, SyncEvent syncEvent, int i);

    public static final native long SyncEvent_timestamp_get(long j, SyncEvent syncEvent);

    public static final native void SyncEvent_timestamp_set(long j, SyncEvent syncEvent, long j2);

    public static final native long SyncEvent_trash_get(long j, SyncEvent syncEvent);

    public static final native void SyncEvent_trash_set(long j, SyncEvent syncEvent, long j2, SyncEvent.Trash trash);

    public static final native int SyncEvent_type_get(long j, SyncEvent syncEvent);

    public static final native void SyncEvent_type_set(long j, SyncEvent syncEvent, int i);

    public static final native boolean SyncEvent_valid(long j, SyncEvent syncEvent);

    public static final native long SyncStateCauseLabels_get();

    public static final native long SyncStateLabels_get();

    public static final native long SyncStateWithCauses_causes_get(long j, SyncStateWithCauses syncStateWithCauses);

    public static final native void SyncStateWithCauses_causes_set(long j, SyncStateWithCauses syncStateWithCauses, long j2);

    public static final native int SyncStateWithCauses_syncState_get(long j, SyncStateWithCauses syncStateWithCauses);

    public static final native void SyncStateWithCauses_syncState_set(long j, SyncStateWithCauses syncStateWithCauses, int i);

    public static final native long UndefinedPosition_get();

    public static final native int computeARGBGradientEndColor__SWIG_0(int i, float f);

    public static final native int computeARGBGradientEndColor__SWIG_1(int i);

    public static final native void delete_AttachmentInfo(long j);

    public static final native void delete_BackupMetadata(long j);

    public static final native void delete_BatchResult(long j);

    public static final native void delete_CancelableCloudTaskProgressHandler(long j);

    public static final native void delete_CloudCreateFileRequest(long j);

    public static final native void delete_CloudCreateFolderRequest(long j);

    public static final native void delete_CloudDownloadFileTaskHandler(long j);

    public static final native void delete_CloudError(long j);

    public static final native void delete_CloudFile(long j);

    public static final native void delete_CloudFileData(long j);

    public static final native void delete_CloudFileIdRev(long j);

    public static final native void delete_CloudFileRequest(long j);

    public static final native void delete_CloudOperationLogger(long j);

    public static final native void delete_CloudUploadFileRequest(long j);

    public static final native void delete_Collection(long j);

    public static final native void delete_CollectionInfo(long j);

    public static final native void delete_ContentInfo(long j);

    public static final native void delete_ContentInfo_Rev(long j);

    public static final native void delete_ContractsTest(long j);

    public static final native void delete_ContractsTestConfiguration(long j);

    public static final native void delete_CorruptionInfo(long j);

    public static final native void delete_DMS(long j);

    public static final native void delete_DMSConfiguration(long j);

    public static final native void delete_DMSError(long j);

    public static final native void delete_DMSViewModel(long j);

    public static final native void delete_DefaultCloudIntegrationLogger(long j);

    public static final native void delete_DegradedCloudDriveWrapper(long j);

    public static final native void delete_DeterministicUuidGenerator(long j);

    public static final native void delete_Device(long j);

    public static final native void delete_ImportBackupOptions(long j);

    public static final native void delete_MetadataInfo(long j);

    public static final native void delete_MonkeyOperationData(long j);

    public static final native void delete_MonkeyTest(long j);

    public static final native void delete_MonkeyTestConfiguration(long j);

    public static final native void delete_MoveInfo(long j);

    public static final native void delete_NeboBackupController(long j);

    public static final native void delete_Notebook(long j);

    public static final native void delete_NotebookCreationInfo(long j);

    public static final native void delete_NotebookInfo(long j);

    public static final native void delete_NotebookManager(long j);

    public static final native void delete_ObjectWithTrashState(long j);

    public static final native void delete_ObjectWithTrashState_Trash(long j);

    public static final native void delete_PDFManager(long j);

    public static final native void delete_Page(long j);

    public static final native void delete_PageInfo(long j);

    public static final native void delete_PagePreSaveInfo(long j);

    public static final native void delete_PageProperties(long j);

    public static final native void delete_SWIGVectorCloudCreateFileRequest(long j);

    public static final native void delete_SWIGVectorCloudCreateFolderRequest(long j);

    public static final native void delete_SWIGVectorCloudFileData(long j);

    public static final native void delete_SWIGVectorCloudFileIdRev(long j);

    public static final native void delete_SWIGVectorCloudFileRequest(long j);

    public static final native void delete_SWIGVectorCloudUploadFileRequest(long j);

    public static final native void delete_SWIGVectorCollection(long j);

    public static final native void delete_SWIGVectorNotebook(long j);

    public static final native void delete_SWIGVectorPage(long j);

    public static final native void delete_SWIGVectorPageAction(long j);

    public static final native void delete_SWIGVectorPageProperties(long j);

    public static final native void delete_SWIGVectorSharePage(long j);

    public static final native void delete_SWIGVectorSharePageUser(long j);

    public static final native void delete_SharePage(long j);

    public static final native void delete_SharePageManager(long j);

    public static final native void delete_SharePageManagerTaskParam(long j);

    public static final native void delete_SharePageOptions(long j);

    public static final native void delete_SharePageRequest(long j);

    public static final native void delete_SharePageResult(long j);

    public static final native void delete_SharePageUser(long j);

    public static final native void delete_SyncContentFile(long j);

    public static final native void delete_SyncEvent(long j);

    public static final native void delete_SyncEventSet(long j);

    public static final native void delete_SyncEvent_Attachment(long j);

    public static final native void delete_SyncEvent_Content(long j);

    public static final native void delete_SyncEvent_Metadata(long j);

    public static final native void delete_SyncEvent_Parent(long j);

    public static final native void delete_SyncEvent_Trash(long j);

    public static final native void delete_SyncStateWithCauses(long j);

    public static final native boolean isResultCodeSuccess(int i);

    public static final native int migrateLegacyCoverColorIndexToARGBColor(long j);

    public static final native long new_AttachmentInfo();

    public static final native long new_BackupMetadata();

    public static final native long new_BatchResult();

    public static final native long new_CancelableCloudTaskProgressHandler(long j);

    public static final native long new_CloudCreateFileRequest__SWIG_0(long j, long j2, CloudFile cloudFile, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native long new_CloudCreateFileRequest__SWIG_1(long j, CloudFile cloudFile, byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native long new_CloudCreateFolderRequest__SWIG_0(long j, long j2, CloudFile cloudFile, byte[] bArr);

    public static final native long new_CloudCreateFolderRequest__SWIG_1(long j, CloudFile cloudFile, byte[] bArr);

    public static final native long new_CloudDownloadFileTaskHandler(long j);

    public static final native long new_CloudError__SWIG_0(int i, byte[] bArr, boolean z);

    public static final native long new_CloudError__SWIG_1(int i, byte[] bArr);

    public static final native long new_CloudError__SWIG_2(int i);

    public static final native long new_CloudFile();

    public static final native long new_CloudFileData__SWIG_0();

    public static final native long new_CloudFileData__SWIG_1(long j, CloudFileData cloudFileData);

    public static final native long new_CloudFileIdRev();

    public static final native long new_CloudFileRequest__SWIG_0(long j, long j2, CloudFile cloudFile, byte[] bArr, byte[] bArr2);

    public static final native long new_CloudFileRequest__SWIG_1(long j, long j2, CloudFile cloudFile, byte[] bArr);

    public static final native long new_CloudFileRequest__SWIG_2(long j, CloudFile cloudFile, byte[] bArr);

    public static final native long new_CloudFileRequest__SWIG_3(byte[] bArr);

    public static final native long new_CloudOperationLogger();

    public static final native long new_CloudUploadFileRequest__SWIG_0(long j, long j2, CloudFile cloudFile, byte[] bArr);

    public static final native long new_CloudUploadFileRequest__SWIG_1(long j, CloudFile cloudFile, byte[] bArr);

    public static final native long new_Collection(long j, CollectionKey collectionKey, long j2, CollectionInfo collectionInfo);

    public static final native long new_CollectionInfo__SWIG_0();

    public static final native long new_CollectionInfo__SWIG_1(long j, byte[] bArr, int i);

    public static final native long new_ContentInfo_Rev__SWIG_0();

    public static final native long new_ContentInfo_Rev__SWIG_1(byte[] bArr, long j, boolean z);

    public static final native long new_ContentInfo__SWIG_0();

    public static final native long new_ContentInfo__SWIG_1(long j, ContentInfo.Rev rev, long j2, ContentInfo.Rev rev2, byte[] bArr, byte[] bArr2);

    public static final native long new_ContractsTest(long j, ContractsTestConfiguration contractsTestConfiguration);

    public static final native long new_ContractsTestConfiguration__SWIG_0(byte[] bArr, byte[] bArr2, int i);

    public static final native long new_ContractsTestConfiguration__SWIG_1(byte[] bArr, byte[] bArr2);

    public static final native long new_CorruptionInfo();

    public static final native long new_DMSConfiguration__SWIG_0(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j, boolean z, boolean z2, boolean z3);

    public static final native long new_DMSConfiguration__SWIG_1(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j, boolean z, boolean z2);

    public static final native long new_DMSConfiguration__SWIG_2(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j, boolean z);

    public static final native long new_DMSConfiguration__SWIG_3(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, long j);

    public static final native long new_DMSConfiguration__SWIG_4(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native long new_DMSConfiguration__SWIG_5(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public static final native long new_DMSError();

    public static final native long new_DMSViewModel();

    public static final native long new_DefaultCloudIntegrationLogger();

    public static final native long new_DegradedCloudDriveWrapper__SWIG_0(ICloudDriveInterface iCloudDriveInterface, int i, int i2);

    public static final native long new_DegradedCloudDriveWrapper__SWIG_1(ICloudDriveInterface iCloudDriveInterface, int i);

    public static final native long new_DegradedCloudDriveWrapper__SWIG_2(ICloudDriveInterface iCloudDriveInterface);

    public static final native long new_DeterministicUuidGenerator__SWIG_0(long j);

    public static final native long new_DeterministicUuidGenerator__SWIG_1();

    public static final native long new_Device();

    public static final native long new_ImportBackupOptions();

    public static final native long new_MetadataInfo__SWIG_0();

    public static final native long new_MetadataInfo__SWIG_1(byte[] bArr, byte[] bArr2, long j);

    public static final native long new_MonkeyOperationData();

    public static final native long new_MonkeyTest(long j, MonkeyTestConfiguration monkeyTestConfiguration);

    public static final native long new_MonkeyTestConfiguration__SWIG_0(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, int i2);

    public static final native long new_MonkeyTestConfiguration__SWIG_1(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i);

    public static final native long new_MonkeyTestConfiguration__SWIG_2(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    public static final native long new_MoveInfo__SWIG_0();

    public static final native long new_MoveInfo__SWIG_1(long j, int i, long j2, int i2);

    public static final native long new_NeboBackupController(long j, DMS dms);

    public static final native long new_Notebook(long j, NotebookKey notebookKey, long j2, NotebookInfo notebookInfo);

    public static final native long new_NotebookCreationInfo__SWIG_0();

    public static final native long new_NotebookCreationInfo__SWIG_1(long j, CollectionKey collectionKey, long j2, byte[] bArr);

    public static final native long new_NotebookInfo();

    public static final native long new_ObjectWithTrashState();

    public static final native long new_ObjectWithTrashState_Trash();

    public static final native long new_Page(long j, PageKey pageKey, long j2, PageInfo pageInfo);

    public static final native long new_PageInfo();

    public static final native long new_PagePreSaveInfo();

    public static final native long new_PageProperties__SWIG_0(byte[] bArr, float f, float f2, long j, int i, boolean z);

    public static final native long new_PageProperties__SWIG_1(byte[] bArr, float f, float f2, long j, int i);

    public static final native long new_PageProperties__SWIG_2(byte[] bArr, float f, float f2, long j);

    public static final native long new_PageProperties__SWIG_3(byte[] bArr, float f, float f2);

    public static final native long new_PageProperties__SWIG_4(byte[] bArr, float f);

    public static final native long new_PageProperties__SWIG_5(byte[] bArr);

    public static final native long new_PageProperties__SWIG_6();

    public static final native long new_SWIGVectorCloudCreateFileRequest();

    public static final native long new_SWIGVectorCloudCreateFolderRequest();

    public static final native long new_SWIGVectorCloudFileData();

    public static final native long new_SWIGVectorCloudFileIdRev();

    public static final native long new_SWIGVectorCloudFileRequest();

    public static final native long new_SWIGVectorCloudUploadFileRequest();

    public static final native long new_SWIGVectorCollection();

    public static final native long new_SWIGVectorNotebook();

    public static final native long new_SWIGVectorPage();

    public static final native long new_SWIGVectorPageAction();

    public static final native long new_SWIGVectorPageProperties();

    public static final native long new_SWIGVectorSharePage();

    public static final native long new_SWIGVectorSharePageUser();

    public static final native long new_SharePage(long j, PageKey pageKey);

    public static final native long new_SharePageManagerTaskParam();

    public static final native long new_SharePageOptions();

    public static final native long new_SharePageRequest__SWIG_0(long j, PageKey pageKey);

    public static final native long new_SharePageRequest__SWIG_1(long j, NotebookKey notebookKey);

    public static final native long new_SharePageResult();

    public static final native long new_SharePageUser__SWIG_0(byte[] bArr, byte[] bArr2);

    public static final native long new_SharePageUser__SWIG_1(byte[] bArr);

    public static final native long new_SyncContentFile();

    public static final native long new_SyncEvent();

    public static final native long new_SyncEventSet();

    public static final native long new_SyncEvent_Attachment__SWIG_0();

    public static final native long new_SyncEvent_Attachment__SWIG_1(byte[] bArr, byte[] bArr2, int i);

    public static final native long new_SyncEvent_Content__SWIG_0();

    public static final native long new_SyncEvent_Content__SWIG_1(long j, ContentInfo.Rev rev, long j2, ContentInfo.Rev rev2, byte[] bArr, byte[] bArr2, int i);

    public static final native long new_SyncEvent_Content__SWIG_2(long j, ContentInfo contentInfo, int i);

    public static final native long new_SyncEvent_Metadata__SWIG_0();

    public static final native long new_SyncEvent_Metadata__SWIG_1(byte[] bArr, byte[] bArr2, long j, int i);

    public static final native long new_SyncEvent_Parent__SWIG_0();

    public static final native long new_SyncEvent_Parent__SWIG_1(long j, byte[] bArr, double d, long j2, int i);

    public static final native long new_SyncEvent_Trash__SWIG_0();

    public static final native long new_SyncEvent_Trash__SWIG_1(int i, long j, int i2);

    public static final native long new_SyncStateWithCauses__SWIG_0(int i);

    public static final native long new_SyncStateWithCauses__SWIG_1(int i, int i2);

    public static final native long new_SyncStateWithCauses__SWIG_2(int i, long j);

    NeboDMSJNI() {
    }
}
