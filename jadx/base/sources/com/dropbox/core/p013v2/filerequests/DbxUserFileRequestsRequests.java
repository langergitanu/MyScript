package com.dropbox.core.p013v2.filerequests;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.filerequests.CountFileRequestsError;
import com.dropbox.core.p013v2.filerequests.CountFileRequestsResult;
import com.dropbox.core.p013v2.filerequests.CreateFileRequestArgs;
import com.dropbox.core.p013v2.filerequests.CreateFileRequestError;
import com.dropbox.core.p013v2.filerequests.DeleteAllClosedFileRequestsError;
import com.dropbox.core.p013v2.filerequests.DeleteAllClosedFileRequestsResult;
import com.dropbox.core.p013v2.filerequests.DeleteFileRequestArgs;
import com.dropbox.core.p013v2.filerequests.DeleteFileRequestError;
import com.dropbox.core.p013v2.filerequests.DeleteFileRequestsResult;
import com.dropbox.core.p013v2.filerequests.FileRequest;
import com.dropbox.core.p013v2.filerequests.GetFileRequestArgs;
import com.dropbox.core.p013v2.filerequests.GetFileRequestError;
import com.dropbox.core.p013v2.filerequests.ListFileRequestsArg;
import com.dropbox.core.p013v2.filerequests.ListFileRequestsContinueArg;
import com.dropbox.core.p013v2.filerequests.ListFileRequestsContinueError;
import com.dropbox.core.p013v2.filerequests.ListFileRequestsError;
import com.dropbox.core.p013v2.filerequests.ListFileRequestsResult;
import com.dropbox.core.p013v2.filerequests.ListFileRequestsV2Result;
import com.dropbox.core.p013v2.filerequests.UpdateFileRequestArgs;
import com.dropbox.core.p013v2.filerequests.UpdateFileRequestError;
import com.dropbox.core.stone.StoneSerializers;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserFileRequestsRequests {
    private final DbxRawClientV2 client;

    public DbxUserFileRequestsRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    public CountFileRequestsResult count() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (CountFileRequestsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_requests/count", null, false, StoneSerializers.void_(), CountFileRequestsResult.Serializer.INSTANCE, CountFileRequestsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new CountFileRequestsErrorException("2/file_requests/count", e.getRequestId(), e.getUserMessage(), (CountFileRequestsError) e.getErrorValue());
        }
    }

    FileRequest create(CreateFileRequestArgs createFileRequestArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FileRequest) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_requests/create", createFileRequestArgs, false, CreateFileRequestArgs.Serializer.INSTANCE, FileRequest.Serializer.INSTANCE, CreateFileRequestError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new CreateFileRequestErrorException("2/file_requests/create", e.getRequestId(), e.getUserMessage(), (CreateFileRequestError) e.getErrorValue());
        }
    }

    public FileRequest create(String str, String str2) throws DbxException {
        return create(new CreateFileRequestArgs(str, str2));
    }

    public CreateBuilder createBuilder(String str, String str2) {
        return new CreateBuilder(this, CreateFileRequestArgs.newBuilder(str, str2));
    }

    DeleteFileRequestsResult delete(DeleteFileRequestArgs deleteFileRequestArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (DeleteFileRequestsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_requests/delete", deleteFileRequestArgs, false, DeleteFileRequestArgs.Serializer.INSTANCE, DeleteFileRequestsResult.Serializer.INSTANCE, DeleteFileRequestError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DeleteFileRequestErrorException("2/file_requests/delete", e.getRequestId(), e.getUserMessage(), (DeleteFileRequestError) e.getErrorValue());
        }
    }

    public DeleteFileRequestsResult delete(List<String> list) throws DbxException {
        return delete(new DeleteFileRequestArgs(list));
    }

    public DeleteAllClosedFileRequestsResult deleteAllClosed() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (DeleteAllClosedFileRequestsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_requests/delete_all_closed", null, false, StoneSerializers.void_(), DeleteAllClosedFileRequestsResult.Serializer.INSTANCE, DeleteAllClosedFileRequestsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DeleteAllClosedFileRequestsErrorException("2/file_requests/delete_all_closed", e.getRequestId(), e.getUserMessage(), (DeleteAllClosedFileRequestsError) e.getErrorValue());
        }
    }

    FileRequest get(GetFileRequestArgs getFileRequestArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FileRequest) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_requests/get", getFileRequestArgs, false, GetFileRequestArgs.Serializer.INSTANCE, FileRequest.Serializer.INSTANCE, GetFileRequestError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetFileRequestErrorException("2/file_requests/get", e.getRequestId(), e.getUserMessage(), (GetFileRequestError) e.getErrorValue());
        }
    }

    public FileRequest get(String str) throws DbxException {
        return get(new GetFileRequestArgs(str));
    }

    ListFileRequestsV2Result listV2(ListFileRequestsArg listFileRequestsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFileRequestsV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_requests/list_v2", listFileRequestsArg, false, ListFileRequestsArg.Serializer.INSTANCE, ListFileRequestsV2Result.Serializer.INSTANCE, ListFileRequestsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFileRequestsErrorException("2/file_requests/list_v2", e.getRequestId(), e.getUserMessage(), (ListFileRequestsError) e.getErrorValue());
        }
    }

    public ListFileRequestsV2Result listV2() throws DbxException {
        return listV2(new ListFileRequestsArg());
    }

    public ListFileRequestsV2Result listV2(long j) throws DbxException {
        return listV2(new ListFileRequestsArg(j));
    }

    public ListFileRequestsResult list() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFileRequestsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_requests/list", null, false, StoneSerializers.void_(), ListFileRequestsResult.Serializer.INSTANCE, ListFileRequestsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFileRequestsErrorException("2/file_requests/list", e.getRequestId(), e.getUserMessage(), (ListFileRequestsError) e.getErrorValue());
        }
    }

    ListFileRequestsV2Result listContinue(ListFileRequestsContinueArg listFileRequestsContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFileRequestsV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_requests/list/continue", listFileRequestsContinueArg, false, ListFileRequestsContinueArg.Serializer.INSTANCE, ListFileRequestsV2Result.Serializer.INSTANCE, ListFileRequestsContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFileRequestsContinueErrorException("2/file_requests/list/continue", e.getRequestId(), e.getUserMessage(), (ListFileRequestsContinueError) e.getErrorValue());
        }
    }

    public ListFileRequestsV2Result listContinue(String str) throws DbxException {
        return listContinue(new ListFileRequestsContinueArg(str));
    }

    FileRequest update(UpdateFileRequestArgs updateFileRequestArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FileRequest) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/file_requests/update", updateFileRequestArgs, false, UpdateFileRequestArgs.Serializer.INSTANCE, FileRequest.Serializer.INSTANCE, UpdateFileRequestError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UpdateFileRequestErrorException("2/file_requests/update", e.getRequestId(), e.getUserMessage(), (UpdateFileRequestError) e.getErrorValue());
        }
    }

    public FileRequest update(String str) throws DbxException {
        return update(new UpdateFileRequestArgs(str));
    }

    public UpdateBuilder updateBuilder(String str) {
        return new UpdateBuilder(this, UpdateFileRequestArgs.newBuilder(str));
    }
}
