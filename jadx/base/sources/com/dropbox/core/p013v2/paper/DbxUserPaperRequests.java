package com.dropbox.core.p013v2.paper;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.paper.AddPaperDocUser;
import com.dropbox.core.p013v2.paper.AddPaperDocUserMemberResult;
import com.dropbox.core.p013v2.paper.DocLookupError;
import com.dropbox.core.p013v2.paper.FoldersContainingPaperDoc;
import com.dropbox.core.p013v2.paper.ListDocsCursorError;
import com.dropbox.core.p013v2.paper.ListPaperDocsArgs;
import com.dropbox.core.p013v2.paper.ListPaperDocsContinueArgs;
import com.dropbox.core.p013v2.paper.ListPaperDocsResponse;
import com.dropbox.core.p013v2.paper.ListUsersCursorError;
import com.dropbox.core.p013v2.paper.ListUsersOnFolderArgs;
import com.dropbox.core.p013v2.paper.ListUsersOnFolderContinueArgs;
import com.dropbox.core.p013v2.paper.ListUsersOnFolderResponse;
import com.dropbox.core.p013v2.paper.ListUsersOnPaperDocArgs;
import com.dropbox.core.p013v2.paper.ListUsersOnPaperDocContinueArgs;
import com.dropbox.core.p013v2.paper.ListUsersOnPaperDocResponse;
import com.dropbox.core.p013v2.paper.PaperDocCreateArgs;
import com.dropbox.core.p013v2.paper.PaperDocExport;
import com.dropbox.core.p013v2.paper.PaperDocExportResult;
import com.dropbox.core.p013v2.paper.PaperDocSharingPolicy;
import com.dropbox.core.p013v2.paper.PaperDocUpdateArgs;
import com.dropbox.core.p013v2.paper.PaperFolderCreateArg;
import com.dropbox.core.p013v2.paper.PaperFolderCreateError;
import com.dropbox.core.p013v2.paper.PaperFolderCreateResult;
import com.dropbox.core.p013v2.paper.RefPaperDoc;
import com.dropbox.core.p013v2.paper.RemovePaperDocUser;
import com.dropbox.core.p013v2.paper.SharingPolicy;
import com.dropbox.core.p013v2.sharing.MemberSelector;
import com.dropbox.core.stone.StoneSerializers;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserPaperRequests {
    private final DbxRawClientV2 client;

    public DbxUserPaperRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    void docsArchive(RefPaperDoc refPaperDoc) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/archive", refPaperDoc, false, RefPaperDoc.Serializer.INSTANCE, StoneSerializers.void_(), DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/archive", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public void docsArchive(String str) throws DbxException {
        docsArchive(new RefPaperDoc(str));
    }

    DocsCreateUploader docsCreate(PaperDocCreateArgs paperDocCreateArgs) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new DocsCreateUploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/create", paperDocCreateArgs, false, PaperDocCreateArgs.Serializer.INSTANCE), this.client.getUserId());
    }

    @Deprecated
    public DocsCreateUploader docsCreate(ImportFormat importFormat) throws DbxException {
        return docsCreate(new PaperDocCreateArgs(importFormat));
    }

    @Deprecated
    public DocsCreateUploader docsCreate(ImportFormat importFormat, String str) throws DbxException {
        return docsCreate(new PaperDocCreateArgs(importFormat, str));
    }

    DbxDownloader<PaperDocExportResult> docsDownload(PaperDocExport paperDocExport, List<HttpRequestor.Header> list) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return dbxRawClientV2.downloadStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/download", paperDocExport, false, list, PaperDocExport.Serializer.INSTANCE, PaperDocExportResult.Serializer.INSTANCE, DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/download", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public DbxDownloader<PaperDocExportResult> docsDownload(String str, ExportFormat exportFormat) throws DbxException {
        return docsDownload(new PaperDocExport(str, exportFormat), Collections.emptyList());
    }

    @Deprecated
    public DocsDownloadBuilder docsDownloadBuilder(String str, ExportFormat exportFormat) {
        return new DocsDownloadBuilder(this, str, exportFormat);
    }

    ListUsersOnFolderResponse docsFolderUsersList(ListUsersOnFolderArgs listUsersOnFolderArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListUsersOnFolderResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/folder_users/list", listUsersOnFolderArgs, false, ListUsersOnFolderArgs.Serializer.INSTANCE, ListUsersOnFolderResponse.Serializer.INSTANCE, DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/folder_users/list", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public ListUsersOnFolderResponse docsFolderUsersList(String str) throws DbxException {
        return docsFolderUsersList(new ListUsersOnFolderArgs(str));
    }

    @Deprecated
    public ListUsersOnFolderResponse docsFolderUsersList(String str, int i) throws DbxException {
        if (i < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1");
        }
        if (i > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000");
        }
        return docsFolderUsersList(new ListUsersOnFolderArgs(str, i));
    }

    ListUsersOnFolderResponse docsFolderUsersListContinue(ListUsersOnFolderContinueArgs listUsersOnFolderContinueArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListUsersOnFolderResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/folder_users/list/continue", listUsersOnFolderContinueArgs, false, ListUsersOnFolderContinueArgs.Serializer.INSTANCE, ListUsersOnFolderResponse.Serializer.INSTANCE, ListUsersCursorError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListUsersCursorErrorException("2/paper/docs/folder_users/list/continue", e.getRequestId(), e.getUserMessage(), (ListUsersCursorError) e.getErrorValue());
        }
    }

    @Deprecated
    public ListUsersOnFolderResponse docsFolderUsersListContinue(String str, String str2) throws DbxException {
        return docsFolderUsersListContinue(new ListUsersOnFolderContinueArgs(str, str2));
    }

    FoldersContainingPaperDoc docsGetFolderInfo(RefPaperDoc refPaperDoc) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FoldersContainingPaperDoc) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/get_folder_info", refPaperDoc, false, RefPaperDoc.Serializer.INSTANCE, FoldersContainingPaperDoc.Serializer.INSTANCE, DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/get_folder_info", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public FoldersContainingPaperDoc docsGetFolderInfo(String str) throws DbxException {
        return docsGetFolderInfo(new RefPaperDoc(str));
    }

    ListPaperDocsResponse docsList(ListPaperDocsArgs listPaperDocsArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListPaperDocsResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/list", listPaperDocsArgs, false, ListPaperDocsArgs.Serializer.INSTANCE, ListPaperDocsResponse.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"docs/list\":" + e.getErrorValue());
        }
    }

    @Deprecated
    public ListPaperDocsResponse docsList() throws DbxException {
        return docsList(new ListPaperDocsArgs());
    }

    @Deprecated
    public DocsListBuilder docsListBuilder() {
        return new DocsListBuilder(this, ListPaperDocsArgs.newBuilder());
    }

    ListPaperDocsResponse docsListContinue(ListPaperDocsContinueArgs listPaperDocsContinueArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListPaperDocsResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/list/continue", listPaperDocsContinueArgs, false, ListPaperDocsContinueArgs.Serializer.INSTANCE, ListPaperDocsResponse.Serializer.INSTANCE, ListDocsCursorError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListDocsCursorErrorException("2/paper/docs/list/continue", e.getRequestId(), e.getUserMessage(), (ListDocsCursorError) e.getErrorValue());
        }
    }

    @Deprecated
    public ListPaperDocsResponse docsListContinue(String str) throws DbxException {
        return docsListContinue(new ListPaperDocsContinueArgs(str));
    }

    void docsPermanentlyDelete(RefPaperDoc refPaperDoc) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/permanently_delete", refPaperDoc, false, RefPaperDoc.Serializer.INSTANCE, StoneSerializers.void_(), DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/permanently_delete", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public void docsPermanentlyDelete(String str) throws DbxException {
        docsPermanentlyDelete(new RefPaperDoc(str));
    }

    SharingPolicy docsSharingPolicyGet(RefPaperDoc refPaperDoc) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharingPolicy) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/sharing_policy/get", refPaperDoc, false, RefPaperDoc.Serializer.INSTANCE, SharingPolicy.Serializer.INSTANCE, DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/sharing_policy/get", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public SharingPolicy docsSharingPolicyGet(String str) throws DbxException {
        return docsSharingPolicyGet(new RefPaperDoc(str));
    }

    void docsSharingPolicySet(PaperDocSharingPolicy paperDocSharingPolicy) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/sharing_policy/set", paperDocSharingPolicy, false, PaperDocSharingPolicy.Serializer.INSTANCE, StoneSerializers.void_(), DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/sharing_policy/set", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public void docsSharingPolicySet(String str, SharingPolicy sharingPolicy) throws DbxException {
        docsSharingPolicySet(new PaperDocSharingPolicy(str, sharingPolicy));
    }

    DocsUpdateUploader docsUpdate(PaperDocUpdateArgs paperDocUpdateArgs) throws DbxException {
        DbxRawClientV2 dbxRawClientV2 = this.client;
        return new DocsUpdateUploader(dbxRawClientV2.uploadStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/update", paperDocUpdateArgs, false, PaperDocUpdateArgs.Serializer.INSTANCE), this.client.getUserId());
    }

    @Deprecated
    public DocsUpdateUploader docsUpdate(String str, PaperDocUpdatePolicy paperDocUpdatePolicy, long j, ImportFormat importFormat) throws DbxException {
        return docsUpdate(new PaperDocUpdateArgs(str, paperDocUpdatePolicy, j, importFormat));
    }

    List<AddPaperDocUserMemberResult> docsUsersAdd(AddPaperDocUser addPaperDocUser) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/users/add", addPaperDocUser, false, AddPaperDocUser.Serializer.INSTANCE, StoneSerializers.list(AddPaperDocUserMemberResult.Serializer.INSTANCE), DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/users/add", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public List<AddPaperDocUserMemberResult> docsUsersAdd(String str, List<AddMember> list) throws DbxException {
        return docsUsersAdd(new AddPaperDocUser(str, list));
    }

    @Deprecated
    public DocsUsersAddBuilder docsUsersAddBuilder(String str, List<AddMember> list) {
        return new DocsUsersAddBuilder(this, AddPaperDocUser.newBuilder(str, list));
    }

    ListUsersOnPaperDocResponse docsUsersList(ListUsersOnPaperDocArgs listUsersOnPaperDocArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListUsersOnPaperDocResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/users/list", listUsersOnPaperDocArgs, false, ListUsersOnPaperDocArgs.Serializer.INSTANCE, ListUsersOnPaperDocResponse.Serializer.INSTANCE, DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/users/list", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public ListUsersOnPaperDocResponse docsUsersList(String str) throws DbxException {
        return docsUsersList(new ListUsersOnPaperDocArgs(str));
    }

    @Deprecated
    public DocsUsersListBuilder docsUsersListBuilder(String str) {
        return new DocsUsersListBuilder(this, ListUsersOnPaperDocArgs.newBuilder(str));
    }

    ListUsersOnPaperDocResponse docsUsersListContinue(ListUsersOnPaperDocContinueArgs listUsersOnPaperDocContinueArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListUsersOnPaperDocResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/users/list/continue", listUsersOnPaperDocContinueArgs, false, ListUsersOnPaperDocContinueArgs.Serializer.INSTANCE, ListUsersOnPaperDocResponse.Serializer.INSTANCE, ListUsersCursorError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListUsersCursorErrorException("2/paper/docs/users/list/continue", e.getRequestId(), e.getUserMessage(), (ListUsersCursorError) e.getErrorValue());
        }
    }

    @Deprecated
    public ListUsersOnPaperDocResponse docsUsersListContinue(String str, String str2) throws DbxException {
        return docsUsersListContinue(new ListUsersOnPaperDocContinueArgs(str, str2));
    }

    void docsUsersRemove(RemovePaperDocUser removePaperDocUser) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/docs/users/remove", removePaperDocUser, false, RemovePaperDocUser.Serializer.INSTANCE, StoneSerializers.void_(), DocLookupError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DocLookupErrorException("2/paper/docs/users/remove", e.getRequestId(), e.getUserMessage(), (DocLookupError) e.getErrorValue());
        }
    }

    @Deprecated
    public void docsUsersRemove(String str, MemberSelector memberSelector) throws DbxException {
        docsUsersRemove(new RemovePaperDocUser(str, memberSelector));
    }

    PaperFolderCreateResult foldersCreate(PaperFolderCreateArg paperFolderCreateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (PaperFolderCreateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/paper/folders/create", paperFolderCreateArg, false, PaperFolderCreateArg.Serializer.INSTANCE, PaperFolderCreateResult.Serializer.INSTANCE, PaperFolderCreateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PaperFolderCreateErrorException("2/paper/folders/create", e.getRequestId(), e.getUserMessage(), (PaperFolderCreateError) e.getErrorValue());
        }
    }

    @Deprecated
    public PaperFolderCreateResult foldersCreate(String str) throws DbxException {
        return foldersCreate(new PaperFolderCreateArg(str));
    }

    @Deprecated
    public FoldersCreateBuilder foldersCreateBuilder(String str) {
        return new FoldersCreateBuilder(this, PaperFolderCreateArg.newBuilder(str));
    }
}
