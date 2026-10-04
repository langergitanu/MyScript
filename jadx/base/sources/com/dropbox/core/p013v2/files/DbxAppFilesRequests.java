package com.dropbox.core.p013v2.files;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.files.ListFolderArg;
import com.dropbox.core.p013v2.files.ListFolderContinueArg;
import com.dropbox.core.p013v2.files.ListFolderContinueError;
import com.dropbox.core.p013v2.files.ListFolderError;
import com.dropbox.core.p013v2.files.ListFolderResult;
import com.dropbox.core.p013v2.files.PreviewResult;
import com.dropbox.core.p013v2.files.ThumbnailV2Arg;
import com.dropbox.core.p013v2.files.ThumbnailV2Error;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppFilesRequests {
    private final DbxRawClientV2 client;

    public DbxAppFilesRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
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

    public DbxAppGetThumbnailV2Builder getThumbnailV2Builder(PathOrLink pathOrLink) {
        return new DbxAppGetThumbnailV2Builder(this, ThumbnailV2Arg.newBuilder(pathOrLink));
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

    public DbxAppListFolderBuilder listFolderBuilder(String str) {
        return new DbxAppListFolderBuilder(this, ListFolderArg.newBuilder(str));
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
}
