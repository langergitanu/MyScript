package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.async.LaunchEmptyResult;
import com.dropbox.core.p013v2.async.LaunchResultBase;
import com.dropbox.core.p013v2.async.PollArg;
import com.dropbox.core.p013v2.async.PollError;
import com.dropbox.core.p013v2.async.PollErrorException;
import com.dropbox.core.p013v2.sharing.AddFileMemberArgs;
import com.dropbox.core.p013v2.sharing.AddFileMemberError;
import com.dropbox.core.p013v2.sharing.AddFolderMemberArg;
import com.dropbox.core.p013v2.sharing.AddFolderMemberError;
import com.dropbox.core.p013v2.sharing.CreateSharedLinkArg;
import com.dropbox.core.p013v2.sharing.CreateSharedLinkError;
import com.dropbox.core.p013v2.sharing.CreateSharedLinkWithSettingsArg;
import com.dropbox.core.p013v2.sharing.CreateSharedLinkWithSettingsError;
import com.dropbox.core.p013v2.sharing.FileMemberActionError;
import com.dropbox.core.p013v2.sharing.FileMemberActionIndividualResult;
import com.dropbox.core.p013v2.sharing.FileMemberActionResult;
import com.dropbox.core.p013v2.sharing.FileMemberRemoveActionResult;
import com.dropbox.core.p013v2.sharing.GetFileMetadataArg;
import com.dropbox.core.p013v2.sharing.GetFileMetadataBatchArg;
import com.dropbox.core.p013v2.sharing.GetFileMetadataBatchResult;
import com.dropbox.core.p013v2.sharing.GetFileMetadataError;
import com.dropbox.core.p013v2.sharing.GetMetadataArgs;
import com.dropbox.core.p013v2.sharing.GetSharedLinkFileError;
import com.dropbox.core.p013v2.sharing.GetSharedLinkMetadataArg;
import com.dropbox.core.p013v2.sharing.GetSharedLinksArg;
import com.dropbox.core.p013v2.sharing.GetSharedLinksError;
import com.dropbox.core.p013v2.sharing.GetSharedLinksResult;
import com.dropbox.core.p013v2.sharing.JobStatus;
import com.dropbox.core.p013v2.sharing.ListFileMembersArg;
import com.dropbox.core.p013v2.sharing.ListFileMembersBatchArg;
import com.dropbox.core.p013v2.sharing.ListFileMembersBatchResult;
import com.dropbox.core.p013v2.sharing.ListFileMembersContinueArg;
import com.dropbox.core.p013v2.sharing.ListFileMembersContinueError;
import com.dropbox.core.p013v2.sharing.ListFileMembersError;
import com.dropbox.core.p013v2.sharing.ListFilesArg;
import com.dropbox.core.p013v2.sharing.ListFilesContinueArg;
import com.dropbox.core.p013v2.sharing.ListFilesContinueError;
import com.dropbox.core.p013v2.sharing.ListFilesResult;
import com.dropbox.core.p013v2.sharing.ListFolderMembersArgs;
import com.dropbox.core.p013v2.sharing.ListFolderMembersContinueArg;
import com.dropbox.core.p013v2.sharing.ListFolderMembersContinueError;
import com.dropbox.core.p013v2.sharing.ListFoldersArgs;
import com.dropbox.core.p013v2.sharing.ListFoldersContinueArg;
import com.dropbox.core.p013v2.sharing.ListFoldersContinueError;
import com.dropbox.core.p013v2.sharing.ListFoldersResult;
import com.dropbox.core.p013v2.sharing.ListSharedLinksArg;
import com.dropbox.core.p013v2.sharing.ListSharedLinksError;
import com.dropbox.core.p013v2.sharing.ListSharedLinksResult;
import com.dropbox.core.p013v2.sharing.MemberAccessLevelResult;
import com.dropbox.core.p013v2.sharing.ModifySharedLinkSettingsArgs;
import com.dropbox.core.p013v2.sharing.ModifySharedLinkSettingsError;
import com.dropbox.core.p013v2.sharing.MountFolderArg;
import com.dropbox.core.p013v2.sharing.MountFolderError;
import com.dropbox.core.p013v2.sharing.PathLinkMetadata;
import com.dropbox.core.p013v2.sharing.RelinquishFileMembershipArg;
import com.dropbox.core.p013v2.sharing.RelinquishFileMembershipError;
import com.dropbox.core.p013v2.sharing.RelinquishFolderMembershipArg;
import com.dropbox.core.p013v2.sharing.RelinquishFolderMembershipError;
import com.dropbox.core.p013v2.sharing.RemoveFileMemberArg;
import com.dropbox.core.p013v2.sharing.RemoveFileMemberError;
import com.dropbox.core.p013v2.sharing.RemoveFolderMemberArg;
import com.dropbox.core.p013v2.sharing.RemoveFolderMemberError;
import com.dropbox.core.p013v2.sharing.RemoveMemberJobStatus;
import com.dropbox.core.p013v2.sharing.RevokeSharedLinkArg;
import com.dropbox.core.p013v2.sharing.RevokeSharedLinkError;
import com.dropbox.core.p013v2.sharing.SetAccessInheritanceArg;
import com.dropbox.core.p013v2.sharing.SetAccessInheritanceError;
import com.dropbox.core.p013v2.sharing.ShareFolderArg;
import com.dropbox.core.p013v2.sharing.ShareFolderError;
import com.dropbox.core.p013v2.sharing.ShareFolderJobStatus;
import com.dropbox.core.p013v2.sharing.ShareFolderLaunch;
import com.dropbox.core.p013v2.sharing.SharedFileMembers;
import com.dropbox.core.p013v2.sharing.SharedFileMetadata;
import com.dropbox.core.p013v2.sharing.SharedFolderAccessError;
import com.dropbox.core.p013v2.sharing.SharedFolderMembers;
import com.dropbox.core.p013v2.sharing.SharedFolderMetadata;
import com.dropbox.core.p013v2.sharing.SharedLinkError;
import com.dropbox.core.p013v2.sharing.SharedLinkMetadata;
import com.dropbox.core.p013v2.sharing.SharingUserError;
import com.dropbox.core.p013v2.sharing.TransferFolderArg;
import com.dropbox.core.p013v2.sharing.TransferFolderError;
import com.dropbox.core.p013v2.sharing.UnmountFolderArg;
import com.dropbox.core.p013v2.sharing.UnmountFolderError;
import com.dropbox.core.p013v2.sharing.UnshareFileArg;
import com.dropbox.core.p013v2.sharing.UnshareFileError;
import com.dropbox.core.p013v2.sharing.UnshareFolderArg;
import com.dropbox.core.p013v2.sharing.UnshareFolderError;
import com.dropbox.core.p013v2.sharing.UpdateFileMemberArgs;
import com.dropbox.core.p013v2.sharing.UpdateFolderMemberArg;
import com.dropbox.core.p013v2.sharing.UpdateFolderMemberError;
import com.dropbox.core.p013v2.sharing.UpdateFolderPolicyArg;
import com.dropbox.core.p013v2.sharing.UpdateFolderPolicyError;
import com.dropbox.core.stone.StoneSerializers;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DbxUserSharingRequests {
    private final DbxRawClientV2 client;

    public DbxUserSharingRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    List<FileMemberActionResult> addFileMember(AddFileMemberArgs addFileMemberArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/add_file_member", addFileMemberArgs, false, AddFileMemberArgs.Serializer.INSTANCE, StoneSerializers.list(FileMemberActionResult.Serializer.INSTANCE), AddFileMemberError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new AddFileMemberErrorException("2/sharing/add_file_member", e.getRequestId(), e.getUserMessage(), (AddFileMemberError) e.getErrorValue());
        }
    }

    public List<FileMemberActionResult> addFileMember(String str, List<MemberSelector> list) throws DbxException {
        return addFileMember(new AddFileMemberArgs(str, list));
    }

    public AddFileMemberBuilder addFileMemberBuilder(String str, List<MemberSelector> list) {
        return new AddFileMemberBuilder(this, AddFileMemberArgs.newBuilder(str, list));
    }

    void addFolderMember(AddFolderMemberArg addFolderMemberArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/add_folder_member", addFolderMemberArg, false, AddFolderMemberArg.Serializer.INSTANCE, StoneSerializers.void_(), AddFolderMemberError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new AddFolderMemberErrorException("2/sharing/add_folder_member", e.getRequestId(), e.getUserMessage(), (AddFolderMemberError) e.getErrorValue());
        }
    }

    public void addFolderMember(String str, List<AddMember> list) throws DbxException {
        addFolderMember(new AddFolderMemberArg(str, list));
    }

    public AddFolderMemberBuilder addFolderMemberBuilder(String str, List<AddMember> list) {
        return new AddFolderMemberBuilder(this, AddFolderMemberArg.newBuilder(str, list));
    }

    JobStatus checkJobStatus(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (JobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/check_job_status", pollArg, false, PollArg.Serializer.INSTANCE, JobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/sharing/check_job_status", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public JobStatus checkJobStatus(String str) throws DbxException {
        return checkJobStatus(new PollArg(str));
    }

    RemoveMemberJobStatus checkRemoveMemberJobStatus(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RemoveMemberJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/check_remove_member_job_status", pollArg, false, PollArg.Serializer.INSTANCE, RemoveMemberJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/sharing/check_remove_member_job_status", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public RemoveMemberJobStatus checkRemoveMemberJobStatus(String str) throws DbxException {
        return checkRemoveMemberJobStatus(new PollArg(str));
    }

    ShareFolderJobStatus checkShareJobStatus(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ShareFolderJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/check_share_job_status", pollArg, false, PollArg.Serializer.INSTANCE, ShareFolderJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/sharing/check_share_job_status", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public ShareFolderJobStatus checkShareJobStatus(String str) throws DbxException {
        return checkShareJobStatus(new PollArg(str));
    }

    PathLinkMetadata createSharedLink(CreateSharedLinkArg createSharedLinkArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (PathLinkMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/create_shared_link", createSharedLinkArg, false, CreateSharedLinkArg.Serializer.INSTANCE, PathLinkMetadata.Serializer.INSTANCE, CreateSharedLinkError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new CreateSharedLinkErrorException("2/sharing/create_shared_link", e.getRequestId(), e.getUserMessage(), (CreateSharedLinkError) e.getErrorValue());
        }
    }

    @Deprecated
    public PathLinkMetadata createSharedLink(String str) throws DbxException {
        return createSharedLink(new CreateSharedLinkArg(str));
    }

    @Deprecated
    public CreateSharedLinkBuilder createSharedLinkBuilder(String str) {
        return new CreateSharedLinkBuilder(this, CreateSharedLinkArg.newBuilder(str));
    }

    SharedLinkMetadata createSharedLinkWithSettings(CreateSharedLinkWithSettingsArg createSharedLinkWithSettingsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedLinkMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/create_shared_link_with_settings", createSharedLinkWithSettingsArg, false, CreateSharedLinkWithSettingsArg.Serializer.INSTANCE, SharedLinkMetadata.Serializer.INSTANCE, CreateSharedLinkWithSettingsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new CreateSharedLinkWithSettingsErrorException("2/sharing/create_shared_link_with_settings", e.getRequestId(), e.getUserMessage(), (CreateSharedLinkWithSettingsError) e.getErrorValue());
        }
    }

    public SharedLinkMetadata createSharedLinkWithSettings(String str) throws DbxException {
        return createSharedLinkWithSettings(new CreateSharedLinkWithSettingsArg(str));
    }

    public SharedLinkMetadata createSharedLinkWithSettings(String str, SharedLinkSettings sharedLinkSettings) throws DbxException {
        return createSharedLinkWithSettings(new CreateSharedLinkWithSettingsArg(str, sharedLinkSettings));
    }

    SharedFileMetadata getFileMetadata(GetFileMetadataArg getFileMetadataArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedFileMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/get_file_metadata", getFileMetadataArg, false, GetFileMetadataArg.Serializer.INSTANCE, SharedFileMetadata.Serializer.INSTANCE, GetFileMetadataError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetFileMetadataErrorException("2/sharing/get_file_metadata", e.getRequestId(), e.getUserMessage(), (GetFileMetadataError) e.getErrorValue());
        }
    }

    public SharedFileMetadata getFileMetadata(String str) throws DbxException {
        return getFileMetadata(new GetFileMetadataArg(str));
    }

    public SharedFileMetadata getFileMetadata(String str, List<FileAction> list) throws DbxException {
        if (list != null) {
            Iterator<FileAction> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        return getFileMetadata(new GetFileMetadataArg(str, list));
    }

    List<GetFileMetadataBatchResult> getFileMetadataBatch(GetFileMetadataBatchArg getFileMetadataBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/get_file_metadata/batch", getFileMetadataBatchArg, false, GetFileMetadataBatchArg.Serializer.INSTANCE, StoneSerializers.list(GetFileMetadataBatchResult.Serializer.INSTANCE), SharingUserError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharingUserErrorException("2/sharing/get_file_metadata/batch", e.getRequestId(), e.getUserMessage(), (SharingUserError) e.getErrorValue());
        }
    }

    public List<GetFileMetadataBatchResult> getFileMetadataBatch(List<String> list) throws DbxException {
        return getFileMetadataBatch(new GetFileMetadataBatchArg(list));
    }

    public List<GetFileMetadataBatchResult> getFileMetadataBatch(List<String> list, List<FileAction> list2) throws DbxException {
        if (list2 != null) {
            Iterator<FileAction> it = list2.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        return getFileMetadataBatch(new GetFileMetadataBatchArg(list, list2));
    }

    SharedFolderMetadata getFolderMetadata(GetMetadataArgs getMetadataArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedFolderMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/get_folder_metadata", getMetadataArgs, false, GetMetadataArgs.Serializer.INSTANCE, SharedFolderMetadata.Serializer.INSTANCE, SharedFolderAccessError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharedFolderAccessErrorException("2/sharing/get_folder_metadata", e.getRequestId(), e.getUserMessage(), (SharedFolderAccessError) e.getErrorValue());
        }
    }

    public SharedFolderMetadata getFolderMetadata(String str) throws DbxException {
        return getFolderMetadata(new GetMetadataArgs(str));
    }

    public SharedFolderMetadata getFolderMetadata(String str, List<FolderAction> list) throws DbxException {
        if (list != null) {
            Iterator<FolderAction> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        return getFolderMetadata(new GetMetadataArgs(str, list));
    }

    DbxDownloader<SharedLinkMetadata> getSharedLinkFile(GetSharedLinkMetadataArg getSharedLinkMetadataArg, List<HttpRequestor.Header> list) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return dbxRawClientV2.downloadStyle(dbxRawClientV2.getHost().getContent(), "2/sharing/get_shared_link_file", getSharedLinkMetadataArg, false, list, GetSharedLinkMetadataArg.Serializer.INSTANCE, SharedLinkMetadata.Serializer.INSTANCE, GetSharedLinkFileError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetSharedLinkFileErrorException("2/sharing/get_shared_link_file", e.getRequestId(), e.getUserMessage(), (GetSharedLinkFileError) e.getErrorValue());
        }
    }

    public DbxDownloader<SharedLinkMetadata> getSharedLinkFile(String str) throws DbxException {
        return getSharedLinkFile(new GetSharedLinkMetadataArg(str), Collections.emptyList());
    }

    public GetSharedLinkFileBuilder getSharedLinkFileBuilder(String str) {
        return new GetSharedLinkFileBuilder(this, GetSharedLinkMetadataArg.newBuilder(str));
    }

    SharedLinkMetadata getSharedLinkMetadata(GetSharedLinkMetadataArg getSharedLinkMetadataArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedLinkMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/get_shared_link_metadata", getSharedLinkMetadataArg, false, GetSharedLinkMetadataArg.Serializer.INSTANCE, SharedLinkMetadata.Serializer.INSTANCE, SharedLinkError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharedLinkErrorException("2/sharing/get_shared_link_metadata", e.getRequestId(), e.getUserMessage(), (SharedLinkError) e.getErrorValue());
        }
    }

    public SharedLinkMetadata getSharedLinkMetadata(String str) throws DbxException {
        return getSharedLinkMetadata(new GetSharedLinkMetadataArg(str));
    }

    public DbxUserGetSharedLinkMetadataBuilder getSharedLinkMetadataBuilder(String str) {
        return new DbxUserGetSharedLinkMetadataBuilder(this, GetSharedLinkMetadataArg.newBuilder(str));
    }

    GetSharedLinksResult getSharedLinks(GetSharedLinksArg getSharedLinksArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetSharedLinksResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/get_shared_links", getSharedLinksArg, false, GetSharedLinksArg.Serializer.INSTANCE, GetSharedLinksResult.Serializer.INSTANCE, GetSharedLinksError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GetSharedLinksErrorException("2/sharing/get_shared_links", e.getRequestId(), e.getUserMessage(), (GetSharedLinksError) e.getErrorValue());
        }
    }

    @Deprecated
    public GetSharedLinksResult getSharedLinks() throws DbxException {
        return getSharedLinks(new GetSharedLinksArg());
    }

    @Deprecated
    public GetSharedLinksResult getSharedLinks(String str) throws DbxException {
        return getSharedLinks(new GetSharedLinksArg(str));
    }

    SharedFileMembers listFileMembers(ListFileMembersArg listFileMembersArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedFileMembers) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_file_members", listFileMembersArg, false, ListFileMembersArg.Serializer.INSTANCE, SharedFileMembers.Serializer.INSTANCE, ListFileMembersError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFileMembersErrorException("2/sharing/list_file_members", e.getRequestId(), e.getUserMessage(), (ListFileMembersError) e.getErrorValue());
        }
    }

    public SharedFileMembers listFileMembers(String str) throws DbxException {
        return listFileMembers(new ListFileMembersArg(str));
    }

    public ListFileMembersBuilder listFileMembersBuilder(String str) {
        return new ListFileMembersBuilder(this, ListFileMembersArg.newBuilder(str));
    }

    List<ListFileMembersBatchResult> listFileMembersBatch(ListFileMembersBatchArg listFileMembersBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_file_members/batch", listFileMembersBatchArg, false, ListFileMembersBatchArg.Serializer.INSTANCE, StoneSerializers.list(ListFileMembersBatchResult.Serializer.INSTANCE), SharingUserError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharingUserErrorException("2/sharing/list_file_members/batch", e.getRequestId(), e.getUserMessage(), (SharingUserError) e.getErrorValue());
        }
    }

    public List<ListFileMembersBatchResult> listFileMembersBatch(List<String> list) throws DbxException {
        return listFileMembersBatch(new ListFileMembersBatchArg(list));
    }

    public List<ListFileMembersBatchResult> listFileMembersBatch(List<String> list, long j) throws DbxException {
        if (j > 20) {
            throw new IllegalArgumentException("Number 'limit' is larger than 20L");
        }
        return listFileMembersBatch(new ListFileMembersBatchArg(list, j));
    }

    SharedFileMembers listFileMembersContinue(ListFileMembersContinueArg listFileMembersContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedFileMembers) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_file_members/continue", listFileMembersContinueArg, false, ListFileMembersContinueArg.Serializer.INSTANCE, SharedFileMembers.Serializer.INSTANCE, ListFileMembersContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFileMembersContinueErrorException("2/sharing/list_file_members/continue", e.getRequestId(), e.getUserMessage(), (ListFileMembersContinueError) e.getErrorValue());
        }
    }

    public SharedFileMembers listFileMembersContinue(String str) throws DbxException {
        return listFileMembersContinue(new ListFileMembersContinueArg(str));
    }

    SharedFolderMembers listFolderMembers(ListFolderMembersArgs listFolderMembersArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedFolderMembers) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_folder_members", listFolderMembersArgs, false, ListFolderMembersArgs.Serializer.INSTANCE, SharedFolderMembers.Serializer.INSTANCE, SharedFolderAccessError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharedFolderAccessErrorException("2/sharing/list_folder_members", e.getRequestId(), e.getUserMessage(), (SharedFolderAccessError) e.getErrorValue());
        }
    }

    public SharedFolderMembers listFolderMembers(String str) throws DbxException {
        return listFolderMembers(new ListFolderMembersArgs(str));
    }

    public ListFolderMembersBuilder listFolderMembersBuilder(String str) {
        return new ListFolderMembersBuilder(this, ListFolderMembersArgs.newBuilder(str));
    }

    SharedFolderMembers listFolderMembersContinue(ListFolderMembersContinueArg listFolderMembersContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedFolderMembers) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_folder_members/continue", listFolderMembersContinueArg, false, ListFolderMembersContinueArg.Serializer.INSTANCE, SharedFolderMembers.Serializer.INSTANCE, ListFolderMembersContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFolderMembersContinueErrorException("2/sharing/list_folder_members/continue", e.getRequestId(), e.getUserMessage(), (ListFolderMembersContinueError) e.getErrorValue());
        }
    }

    public SharedFolderMembers listFolderMembersContinue(String str) throws DbxException {
        return listFolderMembersContinue(new ListFolderMembersContinueArg(str));
    }

    ListFoldersResult listFolders(ListFoldersArgs listFoldersArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFoldersResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_folders", listFoldersArgs, false, ListFoldersArgs.Serializer.INSTANCE, ListFoldersResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"list_folders\":" + e.getErrorValue());
        }
    }

    public ListFoldersResult listFolders() throws DbxException {
        return listFolders(new ListFoldersArgs());
    }

    public ListFoldersBuilder listFoldersBuilder() {
        return new ListFoldersBuilder(this, ListFoldersArgs.newBuilder());
    }

    ListFoldersResult listFoldersContinue(ListFoldersContinueArg listFoldersContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFoldersResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_folders/continue", listFoldersContinueArg, false, ListFoldersContinueArg.Serializer.INSTANCE, ListFoldersResult.Serializer.INSTANCE, ListFoldersContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFoldersContinueErrorException("2/sharing/list_folders/continue", e.getRequestId(), e.getUserMessage(), (ListFoldersContinueError) e.getErrorValue());
        }
    }

    public ListFoldersResult listFoldersContinue(String str) throws DbxException {
        return listFoldersContinue(new ListFoldersContinueArg(str));
    }

    ListFoldersResult listMountableFolders(ListFoldersArgs listFoldersArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFoldersResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_mountable_folders", listFoldersArgs, false, ListFoldersArgs.Serializer.INSTANCE, ListFoldersResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"list_mountable_folders\":" + e.getErrorValue());
        }
    }

    public ListFoldersResult listMountableFolders() throws DbxException {
        return listMountableFolders(new ListFoldersArgs());
    }

    public ListMountableFoldersBuilder listMountableFoldersBuilder() {
        return new ListMountableFoldersBuilder(this, ListFoldersArgs.newBuilder());
    }

    ListFoldersResult listMountableFoldersContinue(ListFoldersContinueArg listFoldersContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFoldersResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_mountable_folders/continue", listFoldersContinueArg, false, ListFoldersContinueArg.Serializer.INSTANCE, ListFoldersResult.Serializer.INSTANCE, ListFoldersContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFoldersContinueErrorException("2/sharing/list_mountable_folders/continue", e.getRequestId(), e.getUserMessage(), (ListFoldersContinueError) e.getErrorValue());
        }
    }

    public ListFoldersResult listMountableFoldersContinue(String str) throws DbxException {
        return listMountableFoldersContinue(new ListFoldersContinueArg(str));
    }

    ListFilesResult listReceivedFiles(ListFilesArg listFilesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFilesResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_received_files", listFilesArg, false, ListFilesArg.Serializer.INSTANCE, ListFilesResult.Serializer.INSTANCE, SharingUserError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharingUserErrorException("2/sharing/list_received_files", e.getRequestId(), e.getUserMessage(), (SharingUserError) e.getErrorValue());
        }
    }

    public ListFilesResult listReceivedFiles() throws DbxException {
        return listReceivedFiles(new ListFilesArg());
    }

    public ListReceivedFilesBuilder listReceivedFilesBuilder() {
        return new ListReceivedFilesBuilder(this, ListFilesArg.newBuilder());
    }

    ListFilesResult listReceivedFilesContinue(ListFilesContinueArg listFilesContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListFilesResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_received_files/continue", listFilesContinueArg, false, ListFilesContinueArg.Serializer.INSTANCE, ListFilesResult.Serializer.INSTANCE, ListFilesContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListFilesContinueErrorException("2/sharing/list_received_files/continue", e.getRequestId(), e.getUserMessage(), (ListFilesContinueError) e.getErrorValue());
        }
    }

    public ListFilesResult listReceivedFilesContinue(String str) throws DbxException {
        return listReceivedFilesContinue(new ListFilesContinueArg(str));
    }

    ListSharedLinksResult listSharedLinks(ListSharedLinksArg listSharedLinksArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListSharedLinksResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/list_shared_links", listSharedLinksArg, false, ListSharedLinksArg.Serializer.INSTANCE, ListSharedLinksResult.Serializer.INSTANCE, ListSharedLinksError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListSharedLinksErrorException("2/sharing/list_shared_links", e.getRequestId(), e.getUserMessage(), (ListSharedLinksError) e.getErrorValue());
        }
    }

    public ListSharedLinksResult listSharedLinks() throws DbxException {
        return listSharedLinks(new ListSharedLinksArg());
    }

    public ListSharedLinksBuilder listSharedLinksBuilder() {
        return new ListSharedLinksBuilder(this, ListSharedLinksArg.newBuilder());
    }

    SharedLinkMetadata modifySharedLinkSettings(ModifySharedLinkSettingsArgs modifySharedLinkSettingsArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedLinkMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/modify_shared_link_settings", modifySharedLinkSettingsArgs, false, ModifySharedLinkSettingsArgs.Serializer.INSTANCE, SharedLinkMetadata.Serializer.INSTANCE, ModifySharedLinkSettingsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ModifySharedLinkSettingsErrorException("2/sharing/modify_shared_link_settings", e.getRequestId(), e.getUserMessage(), (ModifySharedLinkSettingsError) e.getErrorValue());
        }
    }

    public SharedLinkMetadata modifySharedLinkSettings(String str, SharedLinkSettings sharedLinkSettings) throws DbxException {
        return modifySharedLinkSettings(new ModifySharedLinkSettingsArgs(str, sharedLinkSettings));
    }

    public SharedLinkMetadata modifySharedLinkSettings(String str, SharedLinkSettings sharedLinkSettings, boolean z) throws DbxException {
        return modifySharedLinkSettings(new ModifySharedLinkSettingsArgs(str, sharedLinkSettings, z));
    }

    SharedFolderMetadata mountFolder(MountFolderArg mountFolderArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedFolderMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/mount_folder", mountFolderArg, false, MountFolderArg.Serializer.INSTANCE, SharedFolderMetadata.Serializer.INSTANCE, MountFolderError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MountFolderErrorException("2/sharing/mount_folder", e.getRequestId(), e.getUserMessage(), (MountFolderError) e.getErrorValue());
        }
    }

    public SharedFolderMetadata mountFolder(String str) throws DbxException {
        return mountFolder(new MountFolderArg(str));
    }

    void relinquishFileMembership(RelinquishFileMembershipArg relinquishFileMembershipArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/relinquish_file_membership", relinquishFileMembershipArg, false, RelinquishFileMembershipArg.Serializer.INSTANCE, StoneSerializers.void_(), RelinquishFileMembershipError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RelinquishFileMembershipErrorException("2/sharing/relinquish_file_membership", e.getRequestId(), e.getUserMessage(), (RelinquishFileMembershipError) e.getErrorValue());
        }
    }

    public void relinquishFileMembership(String str) throws DbxException {
        relinquishFileMembership(new RelinquishFileMembershipArg(str));
    }

    LaunchEmptyResult relinquishFolderMembership(RelinquishFolderMembershipArg relinquishFolderMembershipArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LaunchEmptyResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/relinquish_folder_membership", relinquishFolderMembershipArg, false, RelinquishFolderMembershipArg.Serializer.INSTANCE, LaunchEmptyResult.Serializer.INSTANCE, RelinquishFolderMembershipError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RelinquishFolderMembershipErrorException("2/sharing/relinquish_folder_membership", e.getRequestId(), e.getUserMessage(), (RelinquishFolderMembershipError) e.getErrorValue());
        }
    }

    public LaunchEmptyResult relinquishFolderMembership(String str) throws DbxException {
        return relinquishFolderMembership(new RelinquishFolderMembershipArg(str));
    }

    public LaunchEmptyResult relinquishFolderMembership(String str, boolean z) throws DbxException {
        return relinquishFolderMembership(new RelinquishFolderMembershipArg(str, z));
    }

    FileMemberActionIndividualResult removeFileMember(RemoveFileMemberArg removeFileMemberArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FileMemberActionIndividualResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/remove_file_member", removeFileMemberArg, false, RemoveFileMemberArg.Serializer.INSTANCE, FileMemberActionIndividualResult.Serializer.INSTANCE, RemoveFileMemberError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RemoveFileMemberErrorException("2/sharing/remove_file_member", e.getRequestId(), e.getUserMessage(), (RemoveFileMemberError) e.getErrorValue());
        }
    }

    @Deprecated
    public FileMemberActionIndividualResult removeFileMember(String str, MemberSelector memberSelector) throws DbxException {
        return removeFileMember(new RemoveFileMemberArg(str, memberSelector));
    }

    FileMemberRemoveActionResult removeFileMember2(RemoveFileMemberArg removeFileMemberArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FileMemberRemoveActionResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/remove_file_member_2", removeFileMemberArg, false, RemoveFileMemberArg.Serializer.INSTANCE, FileMemberRemoveActionResult.Serializer.INSTANCE, RemoveFileMemberError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RemoveFileMemberErrorException("2/sharing/remove_file_member_2", e.getRequestId(), e.getUserMessage(), (RemoveFileMemberError) e.getErrorValue());
        }
    }

    public FileMemberRemoveActionResult removeFileMember2(String str, MemberSelector memberSelector) throws DbxException {
        return removeFileMember2(new RemoveFileMemberArg(str, memberSelector));
    }

    LaunchResultBase removeFolderMember(RemoveFolderMemberArg removeFolderMemberArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LaunchResultBase) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/remove_folder_member", removeFolderMemberArg, false, RemoveFolderMemberArg.Serializer.INSTANCE, LaunchResultBase.Serializer.INSTANCE, RemoveFolderMemberError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RemoveFolderMemberErrorException("2/sharing/remove_folder_member", e.getRequestId(), e.getUserMessage(), (RemoveFolderMemberError) e.getErrorValue());
        }
    }

    public LaunchResultBase removeFolderMember(String str, MemberSelector memberSelector, boolean z) throws DbxException {
        return removeFolderMember(new RemoveFolderMemberArg(str, memberSelector, z));
    }

    void revokeSharedLink(RevokeSharedLinkArg revokeSharedLinkArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/revoke_shared_link", revokeSharedLinkArg, false, RevokeSharedLinkArg.Serializer.INSTANCE, StoneSerializers.void_(), RevokeSharedLinkError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RevokeSharedLinkErrorException("2/sharing/revoke_shared_link", e.getRequestId(), e.getUserMessage(), (RevokeSharedLinkError) e.getErrorValue());
        }
    }

    public void revokeSharedLink(String str) throws DbxException {
        revokeSharedLink(new RevokeSharedLinkArg(str));
    }

    ShareFolderLaunch setAccessInheritance(SetAccessInheritanceArg setAccessInheritanceArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ShareFolderLaunch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/set_access_inheritance", setAccessInheritanceArg, false, SetAccessInheritanceArg.Serializer.INSTANCE, ShareFolderLaunch.Serializer.INSTANCE, SetAccessInheritanceError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SetAccessInheritanceErrorException("2/sharing/set_access_inheritance", e.getRequestId(), e.getUserMessage(), (SetAccessInheritanceError) e.getErrorValue());
        }
    }

    public ShareFolderLaunch setAccessInheritance(String str) throws DbxException {
        return setAccessInheritance(new SetAccessInheritanceArg(str));
    }

    public ShareFolderLaunch setAccessInheritance(String str, AccessInheritance accessInheritance) throws DbxException {
        if (accessInheritance == null) {
            throw new IllegalArgumentException("Required value for 'accessInheritance' is null");
        }
        return setAccessInheritance(new SetAccessInheritanceArg(str, accessInheritance));
    }

    ShareFolderLaunch shareFolder(ShareFolderArg shareFolderArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ShareFolderLaunch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/share_folder", shareFolderArg, false, ShareFolderArg.Serializer.INSTANCE, ShareFolderLaunch.Serializer.INSTANCE, ShareFolderError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ShareFolderErrorException("2/sharing/share_folder", e.getRequestId(), e.getUserMessage(), (ShareFolderError) e.getErrorValue());
        }
    }

    public ShareFolderLaunch shareFolder(String str) throws DbxException {
        return shareFolder(new ShareFolderArg(str));
    }

    public ShareFolderBuilder shareFolderBuilder(String str) {
        return new ShareFolderBuilder(this, ShareFolderArg.newBuilder(str));
    }

    void transferFolder(TransferFolderArg transferFolderArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/transfer_folder", transferFolderArg, false, TransferFolderArg.Serializer.INSTANCE, StoneSerializers.void_(), TransferFolderError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TransferFolderErrorException("2/sharing/transfer_folder", e.getRequestId(), e.getUserMessage(), (TransferFolderError) e.getErrorValue());
        }
    }

    public void transferFolder(String str, String str2) throws DbxException {
        transferFolder(new TransferFolderArg(str, str2));
    }

    void unmountFolder(UnmountFolderArg unmountFolderArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/unmount_folder", unmountFolderArg, false, UnmountFolderArg.Serializer.INSTANCE, StoneSerializers.void_(), UnmountFolderError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UnmountFolderErrorException("2/sharing/unmount_folder", e.getRequestId(), e.getUserMessage(), (UnmountFolderError) e.getErrorValue());
        }
    }

    public void unmountFolder(String str) throws DbxException {
        unmountFolder(new UnmountFolderArg(str));
    }

    void unshareFile(UnshareFileArg unshareFileArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/unshare_file", unshareFileArg, false, UnshareFileArg.Serializer.INSTANCE, StoneSerializers.void_(), UnshareFileError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UnshareFileErrorException("2/sharing/unshare_file", e.getRequestId(), e.getUserMessage(), (UnshareFileError) e.getErrorValue());
        }
    }

    public void unshareFile(String str) throws DbxException {
        unshareFile(new UnshareFileArg(str));
    }

    LaunchEmptyResult unshareFolder(UnshareFolderArg unshareFolderArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LaunchEmptyResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/unshare_folder", unshareFolderArg, false, UnshareFolderArg.Serializer.INSTANCE, LaunchEmptyResult.Serializer.INSTANCE, UnshareFolderError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UnshareFolderErrorException("2/sharing/unshare_folder", e.getRequestId(), e.getUserMessage(), (UnshareFolderError) e.getErrorValue());
        }
    }

    public LaunchEmptyResult unshareFolder(String str) throws DbxException {
        return unshareFolder(new UnshareFolderArg(str));
    }

    public LaunchEmptyResult unshareFolder(String str, boolean z) throws DbxException {
        return unshareFolder(new UnshareFolderArg(str, z));
    }

    MemberAccessLevelResult updateFileMember(UpdateFileMemberArgs updateFileMemberArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MemberAccessLevelResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/update_file_member", updateFileMemberArgs, false, UpdateFileMemberArgs.Serializer.INSTANCE, MemberAccessLevelResult.Serializer.INSTANCE, FileMemberActionError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new FileMemberActionErrorException("2/sharing/update_file_member", e.getRequestId(), e.getUserMessage(), (FileMemberActionError) e.getErrorValue());
        }
    }

    public MemberAccessLevelResult updateFileMember(String str, MemberSelector memberSelector, AccessLevel accessLevel) throws DbxException {
        return updateFileMember(new UpdateFileMemberArgs(str, memberSelector, accessLevel));
    }

    MemberAccessLevelResult updateFolderMember(UpdateFolderMemberArg updateFolderMemberArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MemberAccessLevelResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/update_folder_member", updateFolderMemberArg, false, UpdateFolderMemberArg.Serializer.INSTANCE, MemberAccessLevelResult.Serializer.INSTANCE, UpdateFolderMemberError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UpdateFolderMemberErrorException("2/sharing/update_folder_member", e.getRequestId(), e.getUserMessage(), (UpdateFolderMemberError) e.getErrorValue());
        }
    }

    public MemberAccessLevelResult updateFolderMember(String str, MemberSelector memberSelector, AccessLevel accessLevel) throws DbxException {
        return updateFolderMember(new UpdateFolderMemberArg(str, memberSelector, accessLevel));
    }

    SharedFolderMetadata updateFolderPolicy(UpdateFolderPolicyArg updateFolderPolicyArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharedFolderMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/sharing/update_folder_policy", updateFolderPolicyArg, false, UpdateFolderPolicyArg.Serializer.INSTANCE, SharedFolderMetadata.Serializer.INSTANCE, UpdateFolderPolicyError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new UpdateFolderPolicyErrorException("2/sharing/update_folder_policy", e.getRequestId(), e.getUserMessage(), (UpdateFolderPolicyError) e.getErrorValue());
        }
    }

    public SharedFolderMetadata updateFolderPolicy(String str) throws DbxException {
        return updateFolderPolicy(new UpdateFolderPolicyArg(str));
    }

    public UpdateFolderPolicyBuilder updateFolderPolicyBuilder(String str) {
        return new UpdateFolderPolicyBuilder(this, UpdateFolderPolicyArg.newBuilder(str));
    }
}
