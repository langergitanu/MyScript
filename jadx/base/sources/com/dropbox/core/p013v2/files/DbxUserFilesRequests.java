package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.async.PollArg;
import com.dropbox.core.p013v2.async.PollError;
import com.dropbox.core.p013v2.async.PollErrorException;
import com.dropbox.core.p013v2.fileproperties.AddPropertiesArg;
import com.dropbox.core.p013v2.fileproperties.AddPropertiesError;
import com.dropbox.core.p013v2.fileproperties.AddPropertiesErrorException;
import com.dropbox.core.p013v2.fileproperties.GetTemplateArg;
import com.dropbox.core.p013v2.fileproperties.GetTemplateResult;
import com.dropbox.core.p013v2.fileproperties.InvalidPropertyGroupError;
import com.dropbox.core.p013v2.fileproperties.InvalidPropertyGroupErrorException;
import com.dropbox.core.p013v2.fileproperties.ListTemplateResult;
import com.dropbox.core.p013v2.fileproperties.OverwritePropertyGroupArg;
import com.dropbox.core.p013v2.fileproperties.PropertyGroup;
import com.dropbox.core.p013v2.fileproperties.PropertyGroupUpdate;
import com.dropbox.core.p013v2.fileproperties.RemovePropertiesArg;
import com.dropbox.core.p013v2.fileproperties.RemovePropertiesError;
import com.dropbox.core.p013v2.fileproperties.RemovePropertiesErrorException;
import com.dropbox.core.p013v2.fileproperties.TemplateError;
import com.dropbox.core.p013v2.fileproperties.TemplateErrorException;
import com.dropbox.core.p013v2.fileproperties.UpdatePropertiesArg;
import com.dropbox.core.p013v2.fileproperties.UpdatePropertiesError;
import com.dropbox.core.p013v2.fileproperties.UpdatePropertiesErrorException;
import com.dropbox.core.p013v2.files.AddTagArg;
import com.dropbox.core.p013v2.files.AddTagError;
import com.dropbox.core.p013v2.files.AlphaGetMetadataArg;
import com.dropbox.core.p013v2.files.AlphaGetMetadataError;
import com.dropbox.core.p013v2.files.BaseTagError;
import com.dropbox.core.p013v2.files.CreateFolderArg;
import com.dropbox.core.p013v2.files.CreateFolderBatchArg;
import com.dropbox.core.p013v2.files.CreateFolderBatchJobStatus;
import com.dropbox.core.p013v2.files.CreateFolderBatchLaunch;
import com.dropbox.core.p013v2.files.CreateFolderError;
import com.dropbox.core.p013v2.files.CreateFolderResult;
import com.dropbox.core.p013v2.files.DeleteArg;
import com.dropbox.core.p013v2.files.DeleteBatchArg;
import com.dropbox.core.p013v2.files.DeleteBatchJobStatus;
import com.dropbox.core.p013v2.files.DeleteBatchLaunch;
import com.dropbox.core.p013v2.files.DeleteError;
import com.dropbox.core.p013v2.files.DeleteResult;
import com.dropbox.core.p013v2.files.DownloadArg;
import com.dropbox.core.p013v2.files.DownloadError;
import com.dropbox.core.p013v2.files.DownloadZipArg;
import com.dropbox.core.p013v2.files.DownloadZipError;
import com.dropbox.core.p013v2.files.DownloadZipResult;
import com.dropbox.core.p013v2.files.ExportArg;
import com.dropbox.core.p013v2.files.ExportError;
import com.dropbox.core.p013v2.files.ExportResult;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.FolderMetadata;
import com.dropbox.core.p013v2.files.GetCopyReferenceArg;
import com.dropbox.core.p013v2.files.GetCopyReferenceError;
import com.dropbox.core.p013v2.files.GetCopyReferenceResult;
import com.dropbox.core.p013v2.files.GetMetadataArg;
import com.dropbox.core.p013v2.files.GetMetadataError;
import com.dropbox.core.p013v2.files.GetTagsArg;
import com.dropbox.core.p013v2.files.GetTagsResult;
import com.dropbox.core.p013v2.files.GetTemporaryLinkArg;
import com.dropbox.core.p013v2.files.GetTemporaryLinkError;
import com.dropbox.core.p013v2.files.GetTemporaryLinkResult;
import com.dropbox.core.p013v2.files.GetTemporaryUploadLinkArg;
import com.dropbox.core.p013v2.files.GetTemporaryUploadLinkResult;
import com.dropbox.core.p013v2.files.GetThumbnailBatchArg;
import com.dropbox.core.p013v2.files.GetThumbnailBatchError;
import com.dropbox.core.p013v2.files.GetThumbnailBatchResult;
import com.dropbox.core.p013v2.files.ListFolderArg;
import com.dropbox.core.p013v2.files.ListFolderContinueArg;
import com.dropbox.core.p013v2.files.ListFolderContinueError;
import com.dropbox.core.p013v2.files.ListFolderError;
import com.dropbox.core.p013v2.files.ListFolderGetLatestCursorResult;
import com.dropbox.core.p013v2.files.ListFolderLongpollArg;
import com.dropbox.core.p013v2.files.ListFolderLongpollError;
import com.dropbox.core.p013v2.files.ListFolderLongpollResult;
import com.dropbox.core.p013v2.files.ListFolderResult;
import com.dropbox.core.p013v2.files.ListRevisionsArg;
import com.dropbox.core.p013v2.files.ListRevisionsError;
import com.dropbox.core.p013v2.files.ListRevisionsResult;
import com.dropbox.core.p013v2.files.LockFileBatchArg;
import com.dropbox.core.p013v2.files.LockFileBatchResult;
import com.dropbox.core.p013v2.files.LockFileError;
import com.dropbox.core.p013v2.files.Metadata;
import com.dropbox.core.p013v2.files.MoveBatchArg;
import com.dropbox.core.p013v2.files.PaperCreateArg;
import com.dropbox.core.p013v2.files.PaperUpdateArg;
import com.dropbox.core.p013v2.files.PreviewArg;
import com.dropbox.core.p013v2.files.PreviewError;
import com.dropbox.core.p013v2.files.PreviewResult;
import com.dropbox.core.p013v2.files.RelocationArg;
import com.dropbox.core.p013v2.files.RelocationBatchArg;
import com.dropbox.core.p013v2.files.RelocationBatchArgBase;
import com.dropbox.core.p013v2.files.RelocationBatchJobStatus;
import com.dropbox.core.p013v2.files.RelocationBatchLaunch;
import com.dropbox.core.p013v2.files.RelocationBatchV2JobStatus;
import com.dropbox.core.p013v2.files.RelocationBatchV2Launch;
import com.dropbox.core.p013v2.files.RelocationError;
import com.dropbox.core.p013v2.files.RelocationResult;
import com.dropbox.core.p013v2.files.RemoveTagArg;
import com.dropbox.core.p013v2.files.RemoveTagError;
import com.dropbox.core.p013v2.files.RestoreArg;
import com.dropbox.core.p013v2.files.RestoreError;
import com.dropbox.core.p013v2.files.SaveCopyReferenceArg;
import com.dropbox.core.p013v2.files.SaveCopyReferenceError;
import com.dropbox.core.p013v2.files.SaveCopyReferenceResult;
import com.dropbox.core.p013v2.files.SaveUrlArg;
import com.dropbox.core.p013v2.files.SaveUrlError;
import com.dropbox.core.p013v2.files.SaveUrlJobStatus;
import com.dropbox.core.p013v2.files.SaveUrlResult;
import com.dropbox.core.p013v2.files.SearchArg;
import com.dropbox.core.p013v2.files.SearchError;
import com.dropbox.core.p013v2.files.SearchResult;
import com.dropbox.core.p013v2.files.SearchV2Arg;
import com.dropbox.core.p013v2.files.SearchV2ContinueArg;
import com.dropbox.core.p013v2.files.SearchV2Result;
import com.dropbox.core.p013v2.files.ThumbnailArg;
import com.dropbox.core.p013v2.files.ThumbnailError;
import com.dropbox.core.p013v2.files.ThumbnailV2Arg;
import com.dropbox.core.p013v2.files.ThumbnailV2Error;
import com.dropbox.core.p013v2.files.UnlockFileBatchArg;
import com.dropbox.core.p013v2.files.UploadArg;
import com.dropbox.core.p013v2.files.UploadSessionAppendArg;
import com.dropbox.core.p013v2.files.UploadSessionCursor;
import com.dropbox.core.p013v2.files.UploadSessionFinishArg;
import com.dropbox.core.p013v2.files.UploadSessionFinishBatchArg;
import com.dropbox.core.p013v2.files.UploadSessionFinishBatchJobStatus;
import com.dropbox.core.p013v2.files.UploadSessionFinishBatchLaunch;
import com.dropbox.core.p013v2.files.UploadSessionFinishBatchResult;
import com.dropbox.core.p013v2.files.UploadSessionStartArg;
import com.dropbox.core.p013v2.files.UploadSessionStartBatchArg;
import com.dropbox.core.p013v2.files.UploadSessionStartBatchResult;
import com.dropbox.core.stone.StoneSerializers;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserFilesRequests {
    private final DbxRawClientV2 client;

    public DbxUserFilesRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    Metadata alphaGetMetadata(AlphaGetMetadataArg alphaGetMetadataArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (Metadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/alpha/get_metadata", alphaGetMetadataArg, false, AlphaGetMetadataArg.Serializer.INSTANCE, Metadata.Serializer.INSTANCE, AlphaGetMetadataError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new AlphaGetMetadataErrorException("2/files/alpha/get_metadata", e.getRequestId(), e.getUserMessage(), (AlphaGetMetadataError) e.getErrorValue());
        }
    }

    @Deprecated
    public Metadata alphaGetMetadata(String str) throws DbxException {
        return alphaGetMetadata(new AlphaGetMetadataArg(str));
    }

    @Deprecated
    public AlphaGetMetadataBuilder alphaGetMetadataBuilder(String str) {
        return new AlphaGetMetadataBuilder(this, AlphaGetMetadataArg.newBuilder(str));
    }

    AlphaUploadUploader alphaUpload(UploadArg uploadArg) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new AlphaUploadUploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getContent(), "2/files/alpha/upload", uploadArg, false, UploadArg.Serializer.INSTANCE), this.client.getUserId());
    }

    @Deprecated
    public AlphaUploadUploader alphaUpload(String str) throws DbxException {
        return alphaUpload(new UploadArg(str));
    }

    @Deprecated
    public AlphaUploadBuilder alphaUploadBuilder(String str) {
        return new AlphaUploadBuilder(this, UploadArg.newBuilder(str));
    }

    RelocationResult copyV2(RelocationArg relocationArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/copy_v2", relocationArg, false, RelocationArg.Serializer.INSTANCE, RelocationResult.Serializer.INSTANCE, RelocationError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RelocationErrorException("2/files/copy_v2", e.getRequestId(), e.getUserMessage(), (RelocationError) e.getErrorValue());
        }
    }

    public RelocationResult copyV2(String str, String str2) throws DbxException {
        return copyV2(new RelocationArg(str, str2));
    }

    public CopyV2Builder copyV2Builder(String str, String str2) {
        return new CopyV2Builder(this, RelocationArg.newBuilder(str, str2));
    }

    Metadata copy(RelocationArg relocationArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (Metadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/copy", relocationArg, false, RelocationArg.Serializer.INSTANCE, Metadata.Serializer.INSTANCE, RelocationError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RelocationErrorException("2/files/copy", e.getRequestId(), e.getUserMessage(), (RelocationError) e.getErrorValue());
        }
    }

    @Deprecated
    public Metadata copy(String str, String str2) throws DbxException {
        return copy(new RelocationArg(str, str2));
    }

    @Deprecated
    public CopyBuilder copyBuilder(String str, String str2) {
        return new CopyBuilder(this, RelocationArg.newBuilder(str, str2));
    }

    RelocationBatchV2Launch copyBatchV2(RelocationBatchArgBase relocationBatchArgBase) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationBatchV2Launch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/copy_batch_v2", relocationBatchArgBase, false, RelocationBatchArgBase.Serializer.INSTANCE, RelocationBatchV2Launch.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"copy_batch_v2\":" + e.getErrorValue());
        }
    }

    public RelocationBatchV2Launch copyBatchV2(List<RelocationPath> list) throws DbxException {
        return copyBatchV2(new RelocationBatchArgBase(list));
    }

    public RelocationBatchV2Launch copyBatchV2(List<RelocationPath> list, boolean z) throws DbxException {
        return copyBatchV2(new RelocationBatchArgBase(list, z));
    }

    RelocationBatchLaunch copyBatch(RelocationBatchArg relocationBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationBatchLaunch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/copy_batch", relocationBatchArg, false, RelocationBatchArg.Serializer.INSTANCE, RelocationBatchLaunch.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"copy_batch\":" + e.getErrorValue());
        }
    }

    @Deprecated
    public RelocationBatchLaunch copyBatch(List<RelocationPath> list) throws DbxException {
        return copyBatch(new RelocationBatchArg(list));
    }

    @Deprecated
    public CopyBatchBuilder copyBatchBuilder(List<RelocationPath> list) {
        return new CopyBatchBuilder(this, RelocationBatchArg.newBuilder(list));
    }

    RelocationBatchV2JobStatus copyBatchCheckV2(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationBatchV2JobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/copy_batch/check_v2", pollArg, false, PollArg.Serializer.INSTANCE, RelocationBatchV2JobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/files/copy_batch/check_v2", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public RelocationBatchV2JobStatus copyBatchCheckV2(String str) throws DbxException {
        return copyBatchCheckV2(new PollArg(str));
    }

    RelocationBatchJobStatus copyBatchCheck(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationBatchJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/copy_batch/check", pollArg, false, PollArg.Serializer.INSTANCE, RelocationBatchJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/files/copy_batch/check", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    @Deprecated
    public RelocationBatchJobStatus copyBatchCheck(String str) throws DbxException {
        return copyBatchCheck(new PollArg(str));
    }

    GetCopyReferenceResult copyReferenceGet(GetCopyReferenceArg getCopyReferenceArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetCopyReferenceResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/copy_reference/get", getCopyReferenceArg, false, GetCopyReferenceArg.Serializer.INSTANCE, GetCopyReferenceResult.Serializer.INSTANCE, GetCopyReferenceError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetCopyReferenceErrorException("2/files/copy_reference/get", e.getRequestId(), e.getUserMessage(), (GetCopyReferenceError) e.getErrorValue());
        }
    }

    public GetCopyReferenceResult copyReferenceGet(String str) throws DbxException {
        return copyReferenceGet(new GetCopyReferenceArg(str));
    }

    SaveCopyReferenceResult copyReferenceSave(SaveCopyReferenceArg saveCopyReferenceArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SaveCopyReferenceResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/copy_reference/save", saveCopyReferenceArg, false, SaveCopyReferenceArg.Serializer.INSTANCE, SaveCopyReferenceResult.Serializer.INSTANCE, SaveCopyReferenceError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SaveCopyReferenceErrorException("2/files/copy_reference/save", e.getRequestId(), e.getUserMessage(), (SaveCopyReferenceError) e.getErrorValue());
        }
    }

    public SaveCopyReferenceResult copyReferenceSave(String str, String str2) throws DbxException {
        return copyReferenceSave(new SaveCopyReferenceArg(str, str2));
    }

    CreateFolderResult createFolderV2(CreateFolderArg createFolderArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (CreateFolderResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/create_folder_v2", createFolderArg, false, CreateFolderArg.Serializer.INSTANCE, CreateFolderResult.Serializer.INSTANCE, CreateFolderError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new CreateFolderErrorException("2/files/create_folder_v2", e.getRequestId(), e.getUserMessage(), (CreateFolderError) e.getErrorValue());
        }
    }

    public CreateFolderResult createFolderV2(String str) throws DbxException {
        return createFolderV2(new CreateFolderArg(str));
    }

    public CreateFolderResult createFolderV2(String str, boolean z) throws DbxException {
        return createFolderV2(new CreateFolderArg(str, z));
    }

    FolderMetadata createFolder(CreateFolderArg createFolderArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FolderMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/create_folder", createFolderArg, false, CreateFolderArg.Serializer.INSTANCE, FolderMetadata.Serializer.INSTANCE, CreateFolderError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new CreateFolderErrorException("2/files/create_folder", e.getRequestId(), e.getUserMessage(), (CreateFolderError) e.getErrorValue());
        }
    }

    @Deprecated
    public FolderMetadata createFolder(String str) throws DbxException {
        return createFolder(new CreateFolderArg(str));
    }

    @Deprecated
    public FolderMetadata createFolder(String str, boolean z) throws DbxException {
        return createFolder(new CreateFolderArg(str, z));
    }

    CreateFolderBatchLaunch createFolderBatch(CreateFolderBatchArg createFolderBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (CreateFolderBatchLaunch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/create_folder_batch", createFolderBatchArg, false, CreateFolderBatchArg.Serializer.INSTANCE, CreateFolderBatchLaunch.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"create_folder_batch\":" + e.getErrorValue());
        }
    }

    public CreateFolderBatchLaunch createFolderBatch(List<String> list) throws DbxException {
        return createFolderBatch(new CreateFolderBatchArg(list));
    }

    public CreateFolderBatchBuilder createFolderBatchBuilder(List<String> list) {
        return new CreateFolderBatchBuilder(this, CreateFolderBatchArg.newBuilder(list));
    }

    CreateFolderBatchJobStatus createFolderBatchCheck(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (CreateFolderBatchJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/create_folder_batch/check", pollArg, false, PollArg.Serializer.INSTANCE, CreateFolderBatchJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/files/create_folder_batch/check", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public CreateFolderBatchJobStatus createFolderBatchCheck(String str) throws DbxException {
        return createFolderBatchCheck(new PollArg(str));
    }

    DeleteResult deleteV2(DeleteArg deleteArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (DeleteResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/delete_v2", deleteArg, false, DeleteArg.Serializer.INSTANCE, DeleteResult.Serializer.INSTANCE, DeleteError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DeleteErrorException("2/files/delete_v2", e.getRequestId(), e.getUserMessage(), (DeleteError) e.getErrorValue());
        }
    }

    public DeleteResult deleteV2(String str) throws DbxException {
        return deleteV2(new DeleteArg(str));
    }

    public DeleteResult deleteV2(String str, String str2) throws DbxException {
        if (str2 != null) {
            if (str2.length() < 9) {
                throw new IllegalArgumentException("String 'parentRev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", str2)) {
                throw new IllegalArgumentException("String 'parentRev' does not match pattern");
            }
        }
        return deleteV2(new DeleteArg(str, str2));
    }

    Metadata delete(DeleteArg deleteArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (Metadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/delete", deleteArg, false, DeleteArg.Serializer.INSTANCE, Metadata.Serializer.INSTANCE, DeleteError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DeleteErrorException("2/files/delete", e.getRequestId(), e.getUserMessage(), (DeleteError) e.getErrorValue());
        }
    }

    @Deprecated
    public Metadata delete(String str) throws DbxException {
        return delete(new DeleteArg(str));
    }

    @Deprecated
    public Metadata delete(String str, String str2) throws DbxException {
        if (str2 != null) {
            if (str2.length() < 9) {
                throw new IllegalArgumentException("String 'parentRev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", str2)) {
                throw new IllegalArgumentException("String 'parentRev' does not match pattern");
            }
        }
        return delete(new DeleteArg(str, str2));
    }

    DeleteBatchLaunch deleteBatch(DeleteBatchArg deleteBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (DeleteBatchLaunch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/delete_batch", deleteBatchArg, false, DeleteBatchArg.Serializer.INSTANCE, DeleteBatchLaunch.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"delete_batch\":" + e.getErrorValue());
        }
    }

    public DeleteBatchLaunch deleteBatch(List<DeleteArg> list) throws DbxException {
        return deleteBatch(new DeleteBatchArg(list));
    }

    DeleteBatchJobStatus deleteBatchCheck(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (DeleteBatchJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/delete_batch/check", pollArg, false, PollArg.Serializer.INSTANCE, DeleteBatchJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/files/delete_batch/check", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public DeleteBatchJobStatus deleteBatchCheck(String str) throws DbxException {
        return deleteBatchCheck(new PollArg(str));
    }

    DbxDownloader<FileMetadata> download(DownloadArg downloadArg, List<HttpRequestor.Header> list) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return dbxRawClientV2.downloadStyle(dbxRawClientV2.getHost().getContent(), "2/files/download", downloadArg, false, list, DownloadArg.Serializer.INSTANCE, FileMetadata.Serializer.INSTANCE, DownloadError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DownloadErrorException("2/files/download", e.getRequestId(), e.getUserMessage(), (DownloadError) e.getErrorValue());
        }
    }

    public DbxDownloader<FileMetadata> download(String str) throws DbxException {
        return download(new DownloadArg(str), Collections.emptyList());
    }

    public DbxDownloader<FileMetadata> download(String str, String str2) throws DbxException {
        if (str2 != null) {
            if (str2.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", str2)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
        }
        return download(new DownloadArg(str, str2), Collections.emptyList());
    }

    public DownloadBuilder downloadBuilder(String str) {
        return new DownloadBuilder(this, str);
    }

    DbxDownloader<DownloadZipResult> downloadZip(DownloadZipArg downloadZipArg, List<HttpRequestor.Header> list) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return dbxRawClientV2.downloadStyle(dbxRawClientV2.getHost().getContent(), "2/files/download_zip", downloadZipArg, false, list, DownloadZipArg.Serializer.INSTANCE, DownloadZipResult.Serializer.INSTANCE, DownloadZipError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DownloadZipErrorException("2/files/download_zip", e.getRequestId(), e.getUserMessage(), (DownloadZipError) e.getErrorValue());
        }
    }

    public DbxDownloader<DownloadZipResult> downloadZip(String str) throws DbxException {
        return downloadZip(new DownloadZipArg(str), Collections.emptyList());
    }

    public DownloadZipBuilder downloadZipBuilder(String str) {
        return new DownloadZipBuilder(this, str);
    }

    DbxDownloader<ExportResult> export(ExportArg exportArg, List<HttpRequestor.Header> list) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return dbxRawClientV2.downloadStyle(dbxRawClientV2.getHost().getContent(), "2/files/export", exportArg, false, list, ExportArg.Serializer.INSTANCE, ExportResult.Serializer.INSTANCE, ExportError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ExportErrorException("2/files/export", e.getRequestId(), e.getUserMessage(), (ExportError) e.getErrorValue());
        }
    }

    public DbxDownloader<ExportResult> export(String str) throws DbxException {
        return export(new ExportArg(str), Collections.emptyList());
    }

    public DbxDownloader<ExportResult> export(String str, String str2) throws DbxException {
        return export(new ExportArg(str, str2), Collections.emptyList());
    }

    public ExportBuilder exportBuilder(String str) {
        return new ExportBuilder(this, str);
    }

    LockFileBatchResult getFileLockBatch(LockFileBatchArg lockFileBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LockFileBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/get_file_lock_batch", lockFileBatchArg, false, LockFileBatchArg.Serializer.INSTANCE, LockFileBatchResult.Serializer.INSTANCE, LockFileError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LockFileErrorException("2/files/get_file_lock_batch", e.getRequestId(), e.getUserMessage(), (LockFileError) e.getErrorValue());
        }
    }

    public LockFileBatchResult getFileLockBatch(List<LockFileArg> list) throws DbxException {
        return getFileLockBatch(new LockFileBatchArg(list));
    }

    Metadata getMetadata(GetMetadataArg getMetadataArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (Metadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/get_metadata", getMetadataArg, false, GetMetadataArg.Serializer.INSTANCE, Metadata.Serializer.INSTANCE, GetMetadataError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetMetadataErrorException("2/files/get_metadata", e.getRequestId(), e.getUserMessage(), (GetMetadataError) e.getErrorValue());
        }
    }

    public Metadata getMetadata(String str) throws DbxException {
        return getMetadata(new GetMetadataArg(str));
    }

    public GetMetadataBuilder getMetadataBuilder(String str) {
        return new GetMetadataBuilder(this, GetMetadataArg.newBuilder(str));
    }

    DbxDownloader<FileMetadata> getPreview(PreviewArg previewArg, List<HttpRequestor.Header> list) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return dbxRawClientV2.downloadStyle(dbxRawClientV2.getHost().getContent(), "2/files/get_preview", previewArg, false, list, PreviewArg.Serializer.INSTANCE, FileMetadata.Serializer.INSTANCE, PreviewError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PreviewErrorException("2/files/get_preview", e.getRequestId(), e.getUserMessage(), (PreviewError) e.getErrorValue());
        }
    }

    public DbxDownloader<FileMetadata> getPreview(String str) throws DbxException {
        return getPreview(new PreviewArg(str), Collections.emptyList());
    }

    public DbxDownloader<FileMetadata> getPreview(String str, String str2) throws DbxException {
        if (str2 != null) {
            if (str2.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", str2)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
        }
        return getPreview(new PreviewArg(str, str2), Collections.emptyList());
    }

    public GetPreviewBuilder getPreviewBuilder(String str) {
        return new GetPreviewBuilder(this, str);
    }

    GetTemporaryLinkResult getTemporaryLink(GetTemporaryLinkArg getTemporaryLinkArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetTemporaryLinkResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/get_temporary_link", getTemporaryLinkArg, false, GetTemporaryLinkArg.Serializer.INSTANCE, GetTemporaryLinkResult.Serializer.INSTANCE, GetTemporaryLinkError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetTemporaryLinkErrorException("2/files/get_temporary_link", e.getRequestId(), e.getUserMessage(), (GetTemporaryLinkError) e.getErrorValue());
        }
    }

    public GetTemporaryLinkResult getTemporaryLink(String str) throws DbxException {
        return getTemporaryLink(new GetTemporaryLinkArg(str));
    }

    GetTemporaryUploadLinkResult getTemporaryUploadLink(GetTemporaryUploadLinkArg getTemporaryUploadLinkArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetTemporaryUploadLinkResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/get_temporary_upload_link", getTemporaryUploadLinkArg, false, GetTemporaryUploadLinkArg.Serializer.INSTANCE, GetTemporaryUploadLinkResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"get_temporary_upload_link\":" + e.getErrorValue());
        }
    }

    public GetTemporaryUploadLinkResult getTemporaryUploadLink(CommitInfo commitInfo) throws DbxException {
        return getTemporaryUploadLink(new GetTemporaryUploadLinkArg(commitInfo));
    }

    public GetTemporaryUploadLinkResult getTemporaryUploadLink(CommitInfo commitInfo, double d) throws DbxException {
        if (d < 60.0d) {
            throw new IllegalArgumentException("Number 'duration' is smaller than 60.0");
        }
        if (d > 14400.0d) {
            throw new IllegalArgumentException("Number 'duration' is larger than 14400.0");
        }
        return getTemporaryUploadLink(new GetTemporaryUploadLinkArg(commitInfo, d));
    }

    DbxDownloader<FileMetadata> getThumbnail(ThumbnailArg thumbnailArg, List<HttpRequestor.Header> list) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return dbxRawClientV2.downloadStyle(dbxRawClientV2.getHost().getContent(), "2/files/get_thumbnail", thumbnailArg, false, list, ThumbnailArg.Serializer.INSTANCE, FileMetadata.Serializer.INSTANCE, ThumbnailError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ThumbnailErrorException("2/files/get_thumbnail", e.getRequestId(), e.getUserMessage(), (ThumbnailError) e.getErrorValue());
        }
    }

    public DbxDownloader<FileMetadata> getThumbnail(String str) throws DbxException {
        return getThumbnail(new ThumbnailArg(str), Collections.emptyList());
    }

    public GetThumbnailBuilder getThumbnailBuilder(String str) {
        return new GetThumbnailBuilder(this, ThumbnailArg.newBuilder(str));
    }

    DbxDownloader<PreviewResult> getThumbnailV2(ThumbnailV2Arg thumbnailV2Arg, List<HttpRequestor.Header> list) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return dbxRawClientV2.downloadStyle(dbxRawClientV2.getHost().getContent(), "2/files/get_thumbnail_v2", thumbnailV2Arg, false, list, ThumbnailV2Arg.Serializer.INSTANCE, PreviewResult.Serializer.INSTANCE, ThumbnailV2Error.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ThumbnailV2ErrorException("2/files/get_thumbnail_v2", e.getRequestId(), e.getUserMessage(), (ThumbnailV2Error) e.getErrorValue());
        }
    }

    public DbxDownloader<PreviewResult> getThumbnailV2(PathOrLink pathOrLink) throws DbxException {
        return getThumbnailV2(new ThumbnailV2Arg(pathOrLink), Collections.emptyList());
    }

    public DbxUserGetThumbnailV2Builder getThumbnailV2Builder(PathOrLink pathOrLink) {
        return new DbxUserGetThumbnailV2Builder(this, ThumbnailV2Arg.newBuilder(pathOrLink));
    }

    GetThumbnailBatchResult getThumbnailBatch(GetThumbnailBatchArg getThumbnailBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetThumbnailBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getContent(), "2/files/get_thumbnail_batch", getThumbnailBatchArg, false, GetThumbnailBatchArg.Serializer.INSTANCE, GetThumbnailBatchResult.Serializer.INSTANCE, GetThumbnailBatchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetThumbnailBatchErrorException("2/files/get_thumbnail_batch", e.getRequestId(), e.getUserMessage(), (GetThumbnailBatchError) e.getErrorValue());
        }
    }

    public GetThumbnailBatchResult getThumbnailBatch(List<ThumbnailArg> list) throws DbxException {
        return getThumbnailBatch(new GetThumbnailBatchArg(list));
    }

    ListFolderResult listFolder(ListFolderArg listFolderArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFolderResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/list_folder", listFolderArg, false, ListFolderArg.Serializer.INSTANCE, ListFolderResult.Serializer.INSTANCE, ListFolderError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFolderErrorException("2/files/list_folder", e.getRequestId(), e.getUserMessage(), (ListFolderError) e.getErrorValue());
        }
    }

    public ListFolderResult listFolder(String str) throws DbxException {
        return listFolder(new ListFolderArg(str));
    }

    public DbxUserListFolderBuilder listFolderBuilder(String str) {
        return new DbxUserListFolderBuilder(this, ListFolderArg.newBuilder(str));
    }

    ListFolderResult listFolderContinue(ListFolderContinueArg listFolderContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFolderResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/list_folder/continue", listFolderContinueArg, false, ListFolderContinueArg.Serializer.INSTANCE, ListFolderResult.Serializer.INSTANCE, ListFolderContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFolderContinueErrorException("2/files/list_folder/continue", e.getRequestId(), e.getUserMessage(), (ListFolderContinueError) e.getErrorValue());
        }
    }

    public ListFolderResult listFolderContinue(String str) throws DbxException {
        return listFolderContinue(new ListFolderContinueArg(str));
    }

    ListFolderGetLatestCursorResult listFolderGetLatestCursor(ListFolderArg listFolderArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFolderGetLatestCursorResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/list_folder/get_latest_cursor", listFolderArg, false, ListFolderArg.Serializer.INSTANCE, ListFolderGetLatestCursorResult.Serializer.INSTANCE, ListFolderError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFolderErrorException("2/files/list_folder/get_latest_cursor", e.getRequestId(), e.getUserMessage(), (ListFolderError) e.getErrorValue());
        }
    }

    public ListFolderGetLatestCursorResult listFolderGetLatestCursor(String str) throws DbxException {
        return listFolderGetLatestCursor(new ListFolderArg(str));
    }

    public ListFolderGetLatestCursorBuilder listFolderGetLatestCursorBuilder(String str) {
        return new ListFolderGetLatestCursorBuilder(this, ListFolderArg.newBuilder(str));
    }

    ListFolderLongpollResult listFolderLongpoll(ListFolderLongpollArg listFolderLongpollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFolderLongpollResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getNotify(), "2/files/list_folder/longpoll", listFolderLongpollArg, true, ListFolderLongpollArg.Serializer.INSTANCE, ListFolderLongpollResult.Serializer.INSTANCE, ListFolderLongpollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFolderLongpollErrorException("2/files/list_folder/longpoll", e.getRequestId(), e.getUserMessage(), (ListFolderLongpollError) e.getErrorValue());
        }
    }

    public ListFolderLongpollResult listFolderLongpoll(String str) throws DbxException {
        return listFolderLongpoll(new ListFolderLongpollArg(str));
    }

    public ListFolderLongpollResult listFolderLongpoll(String str, long j) throws DbxException {
        if (j < 30) {
            throw new IllegalArgumentException("Number 'timeout' is smaller than 30L");
        }
        if (j > 480) {
            throw new IllegalArgumentException("Number 'timeout' is larger than 480L");
        }
        return listFolderLongpoll(new ListFolderLongpollArg(str, j));
    }

    ListRevisionsResult listRevisions(ListRevisionsArg listRevisionsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListRevisionsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/list_revisions", listRevisionsArg, false, ListRevisionsArg.Serializer.INSTANCE, ListRevisionsResult.Serializer.INSTANCE, ListRevisionsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListRevisionsErrorException("2/files/list_revisions", e.getRequestId(), e.getUserMessage(), (ListRevisionsError) e.getErrorValue());
        }
    }

    public ListRevisionsResult listRevisions(String str) throws DbxException {
        return listRevisions(new ListRevisionsArg(str));
    }

    public ListRevisionsBuilder listRevisionsBuilder(String str) {
        return new ListRevisionsBuilder(this, ListRevisionsArg.newBuilder(str));
    }

    LockFileBatchResult lockFileBatch(LockFileBatchArg lockFileBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LockFileBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/lock_file_batch", lockFileBatchArg, false, LockFileBatchArg.Serializer.INSTANCE, LockFileBatchResult.Serializer.INSTANCE, LockFileError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LockFileErrorException("2/files/lock_file_batch", e.getRequestId(), e.getUserMessage(), (LockFileError) e.getErrorValue());
        }
    }

    public LockFileBatchResult lockFileBatch(List<LockFileArg> list) throws DbxException {
        return lockFileBatch(new LockFileBatchArg(list));
    }

    RelocationResult moveV2(RelocationArg relocationArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/move_v2", relocationArg, false, RelocationArg.Serializer.INSTANCE, RelocationResult.Serializer.INSTANCE, RelocationError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RelocationErrorException("2/files/move_v2", e.getRequestId(), e.getUserMessage(), (RelocationError) e.getErrorValue());
        }
    }

    public RelocationResult moveV2(String str, String str2) throws DbxException {
        return moveV2(new RelocationArg(str, str2));
    }

    public MoveV2Builder moveV2Builder(String str, String str2) {
        return new MoveV2Builder(this, RelocationArg.newBuilder(str, str2));
    }

    Metadata move(RelocationArg relocationArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (Metadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/move", relocationArg, false, RelocationArg.Serializer.INSTANCE, Metadata.Serializer.INSTANCE, RelocationError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RelocationErrorException("2/files/move", e.getRequestId(), e.getUserMessage(), (RelocationError) e.getErrorValue());
        }
    }

    @Deprecated
    public Metadata move(String str, String str2) throws DbxException {
        return move(new RelocationArg(str, str2));
    }

    @Deprecated
    public MoveBuilder moveBuilder(String str, String str2) {
        return new MoveBuilder(this, RelocationArg.newBuilder(str, str2));
    }

    RelocationBatchV2Launch moveBatchV2(MoveBatchArg moveBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationBatchV2Launch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/move_batch_v2", moveBatchArg, false, MoveBatchArg.Serializer.INSTANCE, RelocationBatchV2Launch.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"move_batch_v2\":" + e.getErrorValue());
        }
    }

    public RelocationBatchV2Launch moveBatchV2(List<RelocationPath> list) throws DbxException {
        return moveBatchV2(new MoveBatchArg(list));
    }

    public MoveBatchV2Builder moveBatchV2Builder(List<RelocationPath> list) {
        return new MoveBatchV2Builder(this, MoveBatchArg.newBuilder(list));
    }

    RelocationBatchLaunch moveBatch(RelocationBatchArg relocationBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationBatchLaunch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/move_batch", relocationBatchArg, false, RelocationBatchArg.Serializer.INSTANCE, RelocationBatchLaunch.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"move_batch\":" + e.getErrorValue());
        }
    }

    @Deprecated
    public RelocationBatchLaunch moveBatch(List<RelocationPath> list) throws DbxException {
        return moveBatch(new RelocationBatchArg(list));
    }

    @Deprecated
    public MoveBatchBuilder moveBatchBuilder(List<RelocationPath> list) {
        return new MoveBatchBuilder(this, RelocationBatchArg.newBuilder(list));
    }

    RelocationBatchV2JobStatus moveBatchCheckV2(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationBatchV2JobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/move_batch/check_v2", pollArg, false, PollArg.Serializer.INSTANCE, RelocationBatchV2JobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/files/move_batch/check_v2", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public RelocationBatchV2JobStatus moveBatchCheckV2(String str) throws DbxException {
        return moveBatchCheckV2(new PollArg(str));
    }

    RelocationBatchJobStatus moveBatchCheck(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RelocationBatchJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/move_batch/check", pollArg, false, PollArg.Serializer.INSTANCE, RelocationBatchJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/files/move_batch/check", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    @Deprecated
    public RelocationBatchJobStatus moveBatchCheck(String str) throws DbxException {
        return moveBatchCheck(new PollArg(str));
    }

    PaperCreateUploader paperCreate(PaperCreateArg paperCreateArg) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new PaperCreateUploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getApi(), "2/files/paper/create", paperCreateArg, false, PaperCreateArg.Serializer.INSTANCE), this.client.getUserId());
    }

    public PaperCreateUploader paperCreate(String str, ImportFormat importFormat) throws DbxException {
        return paperCreate(new PaperCreateArg(str, importFormat));
    }

    PaperUpdateUploader paperUpdate(PaperUpdateArg paperUpdateArg) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new PaperUpdateUploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getApi(), "2/files/paper/update", paperUpdateArg, false, PaperUpdateArg.Serializer.INSTANCE), this.client.getUserId());
    }

    public PaperUpdateUploader paperUpdate(String str, ImportFormat importFormat, PaperDocUpdatePolicy paperDocUpdatePolicy) throws DbxException {
        return paperUpdate(new PaperUpdateArg(str, importFormat, paperDocUpdatePolicy));
    }

    public PaperUpdateUploader paperUpdate(String str, ImportFormat importFormat, PaperDocUpdatePolicy paperDocUpdatePolicy, Long l) throws DbxException {
        return paperUpdate(new PaperUpdateArg(str, importFormat, paperDocUpdatePolicy, l));
    }

    void permanentlyDelete(DeleteArg deleteArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/permanently_delete", deleteArg, false, DeleteArg.Serializer.INSTANCE, StoneSerializers.void_(), DeleteError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DeleteErrorException("2/files/permanently_delete", e.getRequestId(), e.getUserMessage(), (DeleteError) e.getErrorValue());
        }
    }

    public void permanentlyDelete(String str) throws DbxException {
        permanentlyDelete(new DeleteArg(str));
    }

    public void permanentlyDelete(String str, String str2) throws DbxException {
        if (str2 != null) {
            if (str2.length() < 9) {
                throw new IllegalArgumentException("String 'parentRev' is shorter than 9");
            }
            if (!Pattern.matches("[0-9a-f]+", str2)) {
                throw new IllegalArgumentException("String 'parentRev' does not match pattern");
            }
        }
        permanentlyDelete(new DeleteArg(str, str2));
    }

    void propertiesAdd(AddPropertiesArg addPropertiesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/properties/add", addPropertiesArg, false, AddPropertiesArg.Serializer.INSTANCE, StoneSerializers.void_(), AddPropertiesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new AddPropertiesErrorException("2/files/properties/add", e.getRequestId(), e.getUserMessage(), (AddPropertiesError) e.getErrorValue());
        }
    }

    @Deprecated
    public void propertiesAdd(String str, List<PropertyGroup> list) throws DbxException {
        propertiesAdd(new AddPropertiesArg(str, list));
    }

    void propertiesOverwrite(OverwritePropertyGroupArg overwritePropertyGroupArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/properties/overwrite", overwritePropertyGroupArg, false, OverwritePropertyGroupArg.Serializer.INSTANCE, StoneSerializers.void_(), InvalidPropertyGroupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new InvalidPropertyGroupErrorException("2/files/properties/overwrite", e.getRequestId(), e.getUserMessage(), (InvalidPropertyGroupError) e.getErrorValue());
        }
    }

    @Deprecated
    public void propertiesOverwrite(String str, List<PropertyGroup> list) throws DbxException {
        propertiesOverwrite(new OverwritePropertyGroupArg(str, list));
    }

    void propertiesRemove(RemovePropertiesArg removePropertiesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/properties/remove", removePropertiesArg, false, RemovePropertiesArg.Serializer.INSTANCE, StoneSerializers.void_(), RemovePropertiesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RemovePropertiesErrorException("2/files/properties/remove", e.getRequestId(), e.getUserMessage(), (RemovePropertiesError) e.getErrorValue());
        }
    }

    @Deprecated
    public void propertiesRemove(String str, List<String> list) throws DbxException {
        propertiesRemove(new RemovePropertiesArg(str, list));
    }

    GetTemplateResult propertiesTemplateGet(GetTemplateArg getTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/properties/template/get", getTemplateArg, false, GetTemplateArg.Serializer.INSTANCE, GetTemplateResult.Serializer.INSTANCE, TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/files/properties/template/get", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
        }
    }

    @Deprecated
    public GetTemplateResult propertiesTemplateGet(String str) throws DbxException {
        return propertiesTemplateGet(new GetTemplateArg(str));
    }

    @Deprecated
    public ListTemplateResult propertiesTemplateList() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/properties/template/list", null, false, StoneSerializers.void_(), ListTemplateResult.Serializer.INSTANCE, TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/files/properties/template/list", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
        }
    }

    void propertiesUpdate(UpdatePropertiesArg updatePropertiesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/properties/update", updatePropertiesArg, false, UpdatePropertiesArg.Serializer.INSTANCE, StoneSerializers.void_(), UpdatePropertiesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UpdatePropertiesErrorException("2/files/properties/update", e.getRequestId(), e.getUserMessage(), (UpdatePropertiesError) e.getErrorValue());
        }
    }

    @Deprecated
    public void propertiesUpdate(String str, List<PropertyGroupUpdate> list) throws DbxException {
        propertiesUpdate(new UpdatePropertiesArg(str, list));
    }

    FileMetadata restore(RestoreArg restoreArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FileMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/restore", restoreArg, false, RestoreArg.Serializer.INSTANCE, FileMetadata.Serializer.INSTANCE, RestoreError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RestoreErrorException("2/files/restore", e.getRequestId(), e.getUserMessage(), (RestoreError) e.getErrorValue());
        }
    }

    public FileMetadata restore(String str, String str2) throws DbxException {
        return restore(new RestoreArg(str, str2));
    }

    SaveUrlResult saveUrl(SaveUrlArg saveUrlArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SaveUrlResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/save_url", saveUrlArg, false, SaveUrlArg.Serializer.INSTANCE, SaveUrlResult.Serializer.INSTANCE, SaveUrlError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SaveUrlErrorException("2/files/save_url", e.getRequestId(), e.getUserMessage(), (SaveUrlError) e.getErrorValue());
        }
    }

    public SaveUrlResult saveUrl(String str, String str2) throws DbxException {
        return saveUrl(new SaveUrlArg(str, str2));
    }

    SaveUrlJobStatus saveUrlCheckJobStatus(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SaveUrlJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/save_url/check_job_status", pollArg, false, PollArg.Serializer.INSTANCE, SaveUrlJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/files/save_url/check_job_status", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public SaveUrlJobStatus saveUrlCheckJobStatus(String str) throws DbxException {
        return saveUrlCheckJobStatus(new PollArg(str));
    }

    SearchResult search(SearchArg searchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SearchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/search", searchArg, false, SearchArg.Serializer.INSTANCE, SearchResult.Serializer.INSTANCE, SearchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SearchErrorException("2/files/search", e.getRequestId(), e.getUserMessage(), (SearchError) e.getErrorValue());
        }
    }

    @Deprecated
    public SearchResult search(String str, String str2) throws DbxException {
        return search(new SearchArg(str, str2));
    }

    @Deprecated
    public SearchBuilder searchBuilder(String str, String str2) {
        return new SearchBuilder(this, SearchArg.newBuilder(str, str2));
    }

    SearchV2Result searchV2(SearchV2Arg searchV2Arg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SearchV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/search_v2", searchV2Arg, false, SearchV2Arg.Serializer.INSTANCE, SearchV2Result.Serializer.INSTANCE, SearchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SearchErrorException("2/files/search_v2", e.getRequestId(), e.getUserMessage(), (SearchError) e.getErrorValue());
        }
    }

    public SearchV2Result searchV2(String str) throws DbxException {
        return searchV2(new SearchV2Arg(str));
    }

    public SearchV2Builder searchV2Builder(String str) {
        return new SearchV2Builder(this, SearchV2Arg.newBuilder(str));
    }

    SearchV2Result searchContinueV2(SearchV2ContinueArg searchV2ContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SearchV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/search/continue_v2", searchV2ContinueArg, false, SearchV2ContinueArg.Serializer.INSTANCE, SearchV2Result.Serializer.INSTANCE, SearchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SearchErrorException("2/files/search/continue_v2", e.getRequestId(), e.getUserMessage(), (SearchError) e.getErrorValue());
        }
    }

    public SearchV2Result searchContinueV2(String str) throws DbxException {
        return searchContinueV2(new SearchV2ContinueArg(str));
    }

    void tagsAdd(AddTagArg addTagArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/tags/add", addTagArg, false, AddTagArg.Serializer.INSTANCE, StoneSerializers.void_(), AddTagError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new AddTagErrorException("2/files/tags/add", e.getRequestId(), e.getUserMessage(), (AddTagError) e.getErrorValue());
        }
    }

    public void tagsAdd(String str, String str2) throws DbxException {
        tagsAdd(new AddTagArg(str, str2));
    }

    GetTagsResult tagsGet(GetTagsArg getTagsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetTagsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/tags/get", getTagsArg, false, GetTagsArg.Serializer.INSTANCE, GetTagsResult.Serializer.INSTANCE, BaseTagError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new BaseTagErrorException("2/files/tags/get", e.getRequestId(), e.getUserMessage(), (BaseTagError) e.getErrorValue());
        }
    }

    public GetTagsResult tagsGet(List<String> list) throws DbxException {
        return tagsGet(new GetTagsArg(list));
    }

    void tagsRemove(RemoveTagArg removeTagArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/tags/remove", removeTagArg, false, RemoveTagArg.Serializer.INSTANCE, StoneSerializers.void_(), RemoveTagError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RemoveTagErrorException("2/files/tags/remove", e.getRequestId(), e.getUserMessage(), (RemoveTagError) e.getErrorValue());
        }
    }

    public void tagsRemove(String str, String str2) throws DbxException {
        tagsRemove(new RemoveTagArg(str, str2));
    }

    LockFileBatchResult unlockFileBatch(UnlockFileBatchArg unlockFileBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LockFileBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/unlock_file_batch", unlockFileBatchArg, false, UnlockFileBatchArg.Serializer.INSTANCE, LockFileBatchResult.Serializer.INSTANCE, LockFileError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LockFileErrorException("2/files/unlock_file_batch", e.getRequestId(), e.getUserMessage(), (LockFileError) e.getErrorValue());
        }
    }

    public LockFileBatchResult unlockFileBatch(List<UnlockFileArg> list) throws DbxException {
        return unlockFileBatch(new UnlockFileBatchArg(list));
    }

    UploadUploader upload(UploadArg uploadArg) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new UploadUploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getContent(), "2/files/upload", uploadArg, false, UploadArg.Serializer.INSTANCE), this.client.getUserId());
    }

    public UploadUploader upload(String str) throws DbxException {
        return upload(new UploadArg(str));
    }

    public UploadBuilder uploadBuilder(String str) {
        return new UploadBuilder(this, UploadArg.newBuilder(str));
    }

    UploadSessionAppendV2Uploader uploadSessionAppendV2(UploadSessionAppendArg uploadSessionAppendArg) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new UploadSessionAppendV2Uploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getContent(), "2/files/upload_session/append_v2", uploadSessionAppendArg, false, UploadSessionAppendArg.Serializer.INSTANCE), this.client.getUserId());
    }

    public UploadSessionAppendV2Uploader uploadSessionAppendV2(UploadSessionCursor uploadSessionCursor) throws DbxException {
        return uploadSessionAppendV2(new UploadSessionAppendArg(uploadSessionCursor));
    }

    public UploadSessionAppendV2Builder uploadSessionAppendV2Builder(UploadSessionCursor uploadSessionCursor) {
        return new UploadSessionAppendV2Builder(this, UploadSessionAppendArg.newBuilder(uploadSessionCursor));
    }

    UploadSessionAppendUploader uploadSessionAppend(UploadSessionCursor uploadSessionCursor) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new UploadSessionAppendUploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getContent(), "2/files/upload_session/append", uploadSessionCursor, false, UploadSessionCursor.Serializer.INSTANCE), this.client.getUserId());
    }

    @Deprecated
    public UploadSessionAppendUploader uploadSessionAppend(String str, long j) throws DbxException {
        return uploadSessionAppend(new UploadSessionCursor(str, j));
    }

    UploadSessionFinishUploader uploadSessionFinish(UploadSessionFinishArg uploadSessionFinishArg) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new UploadSessionFinishUploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getContent(), "2/files/upload_session/finish", uploadSessionFinishArg, false, UploadSessionFinishArg.Serializer.INSTANCE), this.client.getUserId());
    }

    public UploadSessionFinishUploader uploadSessionFinish(UploadSessionCursor uploadSessionCursor, CommitInfo commitInfo) throws DbxException {
        return uploadSessionFinish(new UploadSessionFinishArg(uploadSessionCursor, commitInfo));
    }

    public UploadSessionFinishUploader uploadSessionFinish(UploadSessionCursor uploadSessionCursor, CommitInfo commitInfo, String str) throws DbxException {
        if (str != null) {
            if (str.length() < 64) {
                throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
            }
            if (str.length() > 64) {
                throw new IllegalArgumentException("String 'contentHash' is longer than 64");
            }
        }
        return uploadSessionFinish(new UploadSessionFinishArg(uploadSessionCursor, commitInfo, str));
    }

    UploadSessionFinishBatchLaunch uploadSessionFinishBatch(UploadSessionFinishBatchArg uploadSessionFinishBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (UploadSessionFinishBatchLaunch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/upload_session/finish_batch", uploadSessionFinishBatchArg, false, UploadSessionFinishBatchArg.Serializer.INSTANCE, UploadSessionFinishBatchLaunch.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"upload_session/finish_batch\":" + e.getErrorValue());
        }
    }

    @Deprecated
    public UploadSessionFinishBatchLaunch uploadSessionFinishBatch(List<UploadSessionFinishArg> list) throws DbxException {
        return uploadSessionFinishBatch(new UploadSessionFinishBatchArg(list));
    }

    UploadSessionFinishBatchResult uploadSessionFinishBatchV2(UploadSessionFinishBatchArg uploadSessionFinishBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (UploadSessionFinishBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/upload_session/finish_batch_v2", uploadSessionFinishBatchArg, false, UploadSessionFinishBatchArg.Serializer.INSTANCE, UploadSessionFinishBatchResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"upload_session/finish_batch_v2\":" + e.getErrorValue());
        }
    }

    public UploadSessionFinishBatchResult uploadSessionFinishBatchV2(List<UploadSessionFinishArg> list) throws DbxException {
        return uploadSessionFinishBatchV2(new UploadSessionFinishBatchArg(list));
    }

    UploadSessionFinishBatchJobStatus uploadSessionFinishBatchCheck(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (UploadSessionFinishBatchJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/upload_session/finish_batch/check", pollArg, false, PollArg.Serializer.INSTANCE, UploadSessionFinishBatchJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/files/upload_session/finish_batch/check", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public UploadSessionFinishBatchJobStatus uploadSessionFinishBatchCheck(String str) throws DbxException {
        return uploadSessionFinishBatchCheck(new PollArg(str));
    }

    UploadSessionStartUploader uploadSessionStart(UploadSessionStartArg uploadSessionStartArg) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new UploadSessionStartUploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getContent(), "2/files/upload_session/start", uploadSessionStartArg, false, UploadSessionStartArg.Serializer.INSTANCE), this.client.getUserId());
    }

    public UploadSessionStartUploader uploadSessionStart() throws DbxException {
        return uploadSessionStart(new UploadSessionStartArg());
    }

    public UploadSessionStartBuilder uploadSessionStartBuilder() {
        return new UploadSessionStartBuilder(this, UploadSessionStartArg.newBuilder());
    }

    UploadSessionStartBatchResult uploadSessionStartBatch(UploadSessionStartBatchArg uploadSessionStartBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (UploadSessionStartBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/files/upload_session/start_batch", uploadSessionStartBatchArg, false, UploadSessionStartBatchArg.Serializer.INSTANCE, UploadSessionStartBatchResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"upload_session/start_batch\":" + e.getErrorValue());
        }
    }

    public UploadSessionStartBatchResult uploadSessionStartBatch(long j) throws DbxException {
        return uploadSessionStartBatch(new UploadSessionStartBatchArg(j));
    }

    public UploadSessionStartBatchResult uploadSessionStartBatch(long j, UploadSessionType uploadSessionType) throws DbxException {
        return uploadSessionStartBatch(new UploadSessionStartBatchArg(j, uploadSessionType));
    }
}
