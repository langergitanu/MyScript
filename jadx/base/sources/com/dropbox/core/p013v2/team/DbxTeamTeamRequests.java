package com.dropbox.core.p013v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.p013v2.account.PhotoSourceArg;
import com.dropbox.core.p013v2.async.LaunchEmptyResult;
import com.dropbox.core.p013v2.async.PollArg;
import com.dropbox.core.p013v2.async.PollEmptyResult;
import com.dropbox.core.p013v2.async.PollError;
import com.dropbox.core.p013v2.async.PollErrorException;
import com.dropbox.core.p013v2.fileproperties.AddTemplateArg;
import com.dropbox.core.p013v2.fileproperties.AddTemplateResult;
import com.dropbox.core.p013v2.fileproperties.GetTemplateArg;
import com.dropbox.core.p013v2.fileproperties.GetTemplateResult;
import com.dropbox.core.p013v2.fileproperties.ListTemplateResult;
import com.dropbox.core.p013v2.fileproperties.ModifyTemplateError;
import com.dropbox.core.p013v2.fileproperties.ModifyTemplateErrorException;
import com.dropbox.core.p013v2.fileproperties.PropertyFieldTemplate;
import com.dropbox.core.p013v2.fileproperties.TemplateError;
import com.dropbox.core.p013v2.fileproperties.TemplateErrorException;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateArg;
import com.dropbox.core.p013v2.fileproperties.UpdateTemplateResult;
import com.dropbox.core.p013v2.files.SyncSettingArg;
import com.dropbox.core.p013v2.team.AddSecondaryEmailsArg;
import com.dropbox.core.p013v2.team.AddSecondaryEmailsError;
import com.dropbox.core.p013v2.team.AddSecondaryEmailsResult;
import com.dropbox.core.p013v2.team.CustomQuotaError;
import com.dropbox.core.p013v2.team.CustomQuotaResult;
import com.dropbox.core.p013v2.team.CustomQuotaUsersArg;
import com.dropbox.core.p013v2.team.DateRange;
import com.dropbox.core.p013v2.team.DateRangeError;
import com.dropbox.core.p013v2.team.DeleteSecondaryEmailsArg;
import com.dropbox.core.p013v2.team.DeleteSecondaryEmailsResult;
import com.dropbox.core.p013v2.team.ExcludedUsersListArg;
import com.dropbox.core.p013v2.team.ExcludedUsersListContinueArg;
import com.dropbox.core.p013v2.team.ExcludedUsersListContinueError;
import com.dropbox.core.p013v2.team.ExcludedUsersListError;
import com.dropbox.core.p013v2.team.ExcludedUsersListResult;
import com.dropbox.core.p013v2.team.ExcludedUsersUpdateArg;
import com.dropbox.core.p013v2.team.ExcludedUsersUpdateError;
import com.dropbox.core.p013v2.team.ExcludedUsersUpdateResult;
import com.dropbox.core.p013v2.team.FeaturesGetValuesBatchArg;
import com.dropbox.core.p013v2.team.FeaturesGetValuesBatchError;
import com.dropbox.core.p013v2.team.FeaturesGetValuesBatchResult;
import com.dropbox.core.p013v2.team.GetActivityReport;
import com.dropbox.core.p013v2.team.GetDevicesReport;
import com.dropbox.core.p013v2.team.GetMembershipReport;
import com.dropbox.core.p013v2.team.GetStorageReport;
import com.dropbox.core.p013v2.team.GroupCreateArg;
import com.dropbox.core.p013v2.team.GroupCreateError;
import com.dropbox.core.p013v2.team.GroupDeleteError;
import com.dropbox.core.p013v2.team.GroupFullInfo;
import com.dropbox.core.p013v2.team.GroupMemberSetAccessTypeError;
import com.dropbox.core.p013v2.team.GroupMembersAddArg;
import com.dropbox.core.p013v2.team.GroupMembersAddError;
import com.dropbox.core.p013v2.team.GroupMembersChangeResult;
import com.dropbox.core.p013v2.team.GroupMembersRemoveArg;
import com.dropbox.core.p013v2.team.GroupMembersRemoveError;
import com.dropbox.core.p013v2.team.GroupMembersSetAccessTypeArg;
import com.dropbox.core.p013v2.team.GroupSelector;
import com.dropbox.core.p013v2.team.GroupSelectorError;
import com.dropbox.core.p013v2.team.GroupUpdateArgs;
import com.dropbox.core.p013v2.team.GroupUpdateError;
import com.dropbox.core.p013v2.team.GroupsGetInfoError;
import com.dropbox.core.p013v2.team.GroupsGetInfoItem;
import com.dropbox.core.p013v2.team.GroupsListArg;
import com.dropbox.core.p013v2.team.GroupsListContinueArg;
import com.dropbox.core.p013v2.team.GroupsListContinueError;
import com.dropbox.core.p013v2.team.GroupsListResult;
import com.dropbox.core.p013v2.team.GroupsMembersListArg;
import com.dropbox.core.p013v2.team.GroupsMembersListContinueArg;
import com.dropbox.core.p013v2.team.GroupsMembersListContinueError;
import com.dropbox.core.p013v2.team.GroupsMembersListResult;
import com.dropbox.core.p013v2.team.GroupsPollError;
import com.dropbox.core.p013v2.team.GroupsSelector;
import com.dropbox.core.p013v2.team.LegalHoldPolicy;
import com.dropbox.core.p013v2.team.LegalHoldsGetPolicyArg;
import com.dropbox.core.p013v2.team.LegalHoldsGetPolicyError;
import com.dropbox.core.p013v2.team.LegalHoldsListHeldRevisionResult;
import com.dropbox.core.p013v2.team.LegalHoldsListHeldRevisionsArg;
import com.dropbox.core.p013v2.team.LegalHoldsListHeldRevisionsContinueArg;
import com.dropbox.core.p013v2.team.LegalHoldsListHeldRevisionsError;
import com.dropbox.core.p013v2.team.LegalHoldsListPoliciesArg;
import com.dropbox.core.p013v2.team.LegalHoldsListPoliciesError;
import com.dropbox.core.p013v2.team.LegalHoldsListPoliciesResult;
import com.dropbox.core.p013v2.team.LegalHoldsPolicyCreateArg;
import com.dropbox.core.p013v2.team.LegalHoldsPolicyCreateError;
import com.dropbox.core.p013v2.team.LegalHoldsPolicyReleaseArg;
import com.dropbox.core.p013v2.team.LegalHoldsPolicyReleaseError;
import com.dropbox.core.p013v2.team.LegalHoldsPolicyUpdateArg;
import com.dropbox.core.p013v2.team.LegalHoldsPolicyUpdateError;
import com.dropbox.core.p013v2.team.ListMemberAppsArg;
import com.dropbox.core.p013v2.team.ListMemberAppsError;
import com.dropbox.core.p013v2.team.ListMemberAppsResult;
import com.dropbox.core.p013v2.team.ListMemberDevicesArg;
import com.dropbox.core.p013v2.team.ListMemberDevicesError;
import com.dropbox.core.p013v2.team.ListMemberDevicesResult;
import com.dropbox.core.p013v2.team.ListMembersAppsArg;
import com.dropbox.core.p013v2.team.ListMembersAppsError;
import com.dropbox.core.p013v2.team.ListMembersAppsResult;
import com.dropbox.core.p013v2.team.ListMembersDevicesArg;
import com.dropbox.core.p013v2.team.ListMembersDevicesError;
import com.dropbox.core.p013v2.team.ListMembersDevicesResult;
import com.dropbox.core.p013v2.team.ListTeamAppsArg;
import com.dropbox.core.p013v2.team.ListTeamAppsError;
import com.dropbox.core.p013v2.team.ListTeamAppsResult;
import com.dropbox.core.p013v2.team.ListTeamDevicesArg;
import com.dropbox.core.p013v2.team.ListTeamDevicesError;
import com.dropbox.core.p013v2.team.ListTeamDevicesResult;
import com.dropbox.core.p013v2.team.MembersAddArg;
import com.dropbox.core.p013v2.team.MembersAddJobStatus;
import com.dropbox.core.p013v2.team.MembersAddJobStatusV2Result;
import com.dropbox.core.p013v2.team.MembersAddLaunch;
import com.dropbox.core.p013v2.team.MembersAddLaunchV2Result;
import com.dropbox.core.p013v2.team.MembersAddV2Arg;
import com.dropbox.core.p013v2.team.MembersDataTransferArg;
import com.dropbox.core.p013v2.team.MembersDeactivateArg;
import com.dropbox.core.p013v2.team.MembersDeleteProfilePhotoArg;
import com.dropbox.core.p013v2.team.MembersDeleteProfilePhotoError;
import com.dropbox.core.p013v2.team.MembersGetAvailableTeamMemberRolesResult;
import com.dropbox.core.p013v2.team.MembersGetInfoArgs;
import com.dropbox.core.p013v2.team.MembersGetInfoError;
import com.dropbox.core.p013v2.team.MembersGetInfoItem;
import com.dropbox.core.p013v2.team.MembersGetInfoV2Arg;
import com.dropbox.core.p013v2.team.MembersGetInfoV2Result;
import com.dropbox.core.p013v2.team.MembersListArg;
import com.dropbox.core.p013v2.team.MembersListContinueArg;
import com.dropbox.core.p013v2.team.MembersListContinueError;
import com.dropbox.core.p013v2.team.MembersListError;
import com.dropbox.core.p013v2.team.MembersListResult;
import com.dropbox.core.p013v2.team.MembersListV2Result;
import com.dropbox.core.p013v2.team.MembersRecoverArg;
import com.dropbox.core.p013v2.team.MembersRecoverError;
import com.dropbox.core.p013v2.team.MembersRemoveArg;
import com.dropbox.core.p013v2.team.MembersRemoveError;
import com.dropbox.core.p013v2.team.MembersSendWelcomeError;
import com.dropbox.core.p013v2.team.MembersSetPermissions2Arg;
import com.dropbox.core.p013v2.team.MembersSetPermissions2Error;
import com.dropbox.core.p013v2.team.MembersSetPermissions2Result;
import com.dropbox.core.p013v2.team.MembersSetPermissionsArg;
import com.dropbox.core.p013v2.team.MembersSetPermissionsError;
import com.dropbox.core.p013v2.team.MembersSetPermissionsResult;
import com.dropbox.core.p013v2.team.MembersSetProfileArg;
import com.dropbox.core.p013v2.team.MembersSetProfileError;
import com.dropbox.core.p013v2.team.MembersSetProfilePhotoArg;
import com.dropbox.core.p013v2.team.MembersSetProfilePhotoError;
import com.dropbox.core.p013v2.team.MembersSuspendError;
import com.dropbox.core.p013v2.team.MembersTransferFormerMembersFilesError;
import com.dropbox.core.p013v2.team.MembersUnsuspendArg;
import com.dropbox.core.p013v2.team.MembersUnsuspendError;
import com.dropbox.core.p013v2.team.RemoveCustomQuotaResult;
import com.dropbox.core.p013v2.team.ResendVerificationEmailArg;
import com.dropbox.core.p013v2.team.ResendVerificationEmailResult;
import com.dropbox.core.p013v2.team.RevokeDeviceSessionArg;
import com.dropbox.core.p013v2.team.RevokeDeviceSessionBatchArg;
import com.dropbox.core.p013v2.team.RevokeDeviceSessionBatchError;
import com.dropbox.core.p013v2.team.RevokeDeviceSessionBatchResult;
import com.dropbox.core.p013v2.team.RevokeDeviceSessionError;
import com.dropbox.core.p013v2.team.RevokeLinkedApiAppArg;
import com.dropbox.core.p013v2.team.RevokeLinkedApiAppBatchArg;
import com.dropbox.core.p013v2.team.RevokeLinkedAppBatchError;
import com.dropbox.core.p013v2.team.RevokeLinkedAppBatchResult;
import com.dropbox.core.p013v2.team.RevokeLinkedAppError;
import com.dropbox.core.p013v2.team.SetCustomQuotaArg;
import com.dropbox.core.p013v2.team.SetCustomQuotaError;
import com.dropbox.core.p013v2.team.SharingAllowlistAddArgs;
import com.dropbox.core.p013v2.team.SharingAllowlistAddError;
import com.dropbox.core.p013v2.team.SharingAllowlistAddResponse;
import com.dropbox.core.p013v2.team.SharingAllowlistListArg;
import com.dropbox.core.p013v2.team.SharingAllowlistListContinueArg;
import com.dropbox.core.p013v2.team.SharingAllowlistListContinueError;
import com.dropbox.core.p013v2.team.SharingAllowlistListError;
import com.dropbox.core.p013v2.team.SharingAllowlistListResponse;
import com.dropbox.core.p013v2.team.SharingAllowlistRemoveArgs;
import com.dropbox.core.p013v2.team.SharingAllowlistRemoveError;
import com.dropbox.core.p013v2.team.SharingAllowlistRemoveResponse;
import com.dropbox.core.p013v2.team.TeamFolderActivateError;
import com.dropbox.core.p013v2.team.TeamFolderArchiveArg;
import com.dropbox.core.p013v2.team.TeamFolderArchiveError;
import com.dropbox.core.p013v2.team.TeamFolderArchiveJobStatus;
import com.dropbox.core.p013v2.team.TeamFolderArchiveLaunch;
import com.dropbox.core.p013v2.team.TeamFolderCreateArg;
import com.dropbox.core.p013v2.team.TeamFolderCreateError;
import com.dropbox.core.p013v2.team.TeamFolderGetInfoItem;
import com.dropbox.core.p013v2.team.TeamFolderIdArg;
import com.dropbox.core.p013v2.team.TeamFolderIdListArg;
import com.dropbox.core.p013v2.team.TeamFolderListArg;
import com.dropbox.core.p013v2.team.TeamFolderListContinueArg;
import com.dropbox.core.p013v2.team.TeamFolderListContinueError;
import com.dropbox.core.p013v2.team.TeamFolderListError;
import com.dropbox.core.p013v2.team.TeamFolderListResult;
import com.dropbox.core.p013v2.team.TeamFolderMetadata;
import com.dropbox.core.p013v2.team.TeamFolderPermanentlyDeleteError;
import com.dropbox.core.p013v2.team.TeamFolderRenameArg;
import com.dropbox.core.p013v2.team.TeamFolderRenameError;
import com.dropbox.core.p013v2.team.TeamFolderUpdateSyncSettingsArg;
import com.dropbox.core.p013v2.team.TeamFolderUpdateSyncSettingsError;
import com.dropbox.core.p013v2.team.TeamGetInfoResult;
import com.dropbox.core.p013v2.team.TeamMemberInfo;
import com.dropbox.core.p013v2.team.TeamMemberInfoV2Result;
import com.dropbox.core.p013v2.team.TeamNamespacesListArg;
import com.dropbox.core.p013v2.team.TeamNamespacesListContinueArg;
import com.dropbox.core.p013v2.team.TeamNamespacesListContinueError;
import com.dropbox.core.p013v2.team.TeamNamespacesListError;
import com.dropbox.core.p013v2.team.TeamNamespacesListResult;
import com.dropbox.core.p013v2.team.TokenGetAuthenticatedAdminError;
import com.dropbox.core.p013v2.team.TokenGetAuthenticatedAdminResult;
import com.dropbox.core.p013v2.team.UserSelectorArg;
import com.dropbox.core.stone.StoneSerializers;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public class DbxTeamTeamRequests {
    private final DbxRawClientV2 client;

    public DbxTeamTeamRequests(DbxRawClientV2 dbxRawClientV2) {
        this.client = dbxRawClientV2;
    }

    ListMemberDevicesResult devicesListMemberDevices(ListMemberDevicesArg listMemberDevicesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListMemberDevicesResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/devices/list_member_devices", listMemberDevicesArg, false, ListMemberDevicesArg.Serializer.INSTANCE, ListMemberDevicesResult.Serializer.INSTANCE, ListMemberDevicesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListMemberDevicesErrorException("2/team/devices/list_member_devices", e.getRequestId(), e.getUserMessage(), (ListMemberDevicesError) e.getErrorValue());
        }
    }

    public ListMemberDevicesResult devicesListMemberDevices(String str) throws DbxException {
        return devicesListMemberDevices(new ListMemberDevicesArg(str));
    }

    public DevicesListMemberDevicesBuilder devicesListMemberDevicesBuilder(String str) {
        return new DevicesListMemberDevicesBuilder(this, ListMemberDevicesArg.newBuilder(str));
    }

    ListMembersDevicesResult devicesListMembersDevices(ListMembersDevicesArg listMembersDevicesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListMembersDevicesResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/devices/list_members_devices", listMembersDevicesArg, false, ListMembersDevicesArg.Serializer.INSTANCE, ListMembersDevicesResult.Serializer.INSTANCE, ListMembersDevicesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListMembersDevicesErrorException("2/team/devices/list_members_devices", e.getRequestId(), e.getUserMessage(), (ListMembersDevicesError) e.getErrorValue());
        }
    }

    public ListMembersDevicesResult devicesListMembersDevices() throws DbxException {
        return devicesListMembersDevices(new ListMembersDevicesArg());
    }

    public DevicesListMembersDevicesBuilder devicesListMembersDevicesBuilder() {
        return new DevicesListMembersDevicesBuilder(this, ListMembersDevicesArg.newBuilder());
    }

    ListTeamDevicesResult devicesListTeamDevices(ListTeamDevicesArg listTeamDevicesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListTeamDevicesResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/devices/list_team_devices", listTeamDevicesArg, false, ListTeamDevicesArg.Serializer.INSTANCE, ListTeamDevicesResult.Serializer.INSTANCE, ListTeamDevicesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListTeamDevicesErrorException("2/team/devices/list_team_devices", e.getRequestId(), e.getUserMessage(), (ListTeamDevicesError) e.getErrorValue());
        }
    }

    @Deprecated
    public ListTeamDevicesResult devicesListTeamDevices() throws DbxException {
        return devicesListTeamDevices(new ListTeamDevicesArg());
    }

    @Deprecated
    public DevicesListTeamDevicesBuilder devicesListTeamDevicesBuilder() {
        return new DevicesListTeamDevicesBuilder(this, ListTeamDevicesArg.newBuilder());
    }

    public void devicesRevokeDeviceSession(RevokeDeviceSessionArg revokeDeviceSessionArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/devices/revoke_device_session", revokeDeviceSessionArg, false, RevokeDeviceSessionArg.Serializer.INSTANCE, StoneSerializers.void_(), RevokeDeviceSessionError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RevokeDeviceSessionErrorException("2/team/devices/revoke_device_session", e.getRequestId(), e.getUserMessage(), (RevokeDeviceSessionError) e.getErrorValue());
        }
    }

    RevokeDeviceSessionBatchResult devicesRevokeDeviceSessionBatch(RevokeDeviceSessionBatchArg revokeDeviceSessionBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RevokeDeviceSessionBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/devices/revoke_device_session_batch", revokeDeviceSessionBatchArg, false, RevokeDeviceSessionBatchArg.Serializer.INSTANCE, RevokeDeviceSessionBatchResult.Serializer.INSTANCE, RevokeDeviceSessionBatchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RevokeDeviceSessionBatchErrorException("2/team/devices/revoke_device_session_batch", e.getRequestId(), e.getUserMessage(), (RevokeDeviceSessionBatchError) e.getErrorValue());
        }
    }

    public RevokeDeviceSessionBatchResult devicesRevokeDeviceSessionBatch(List<RevokeDeviceSessionArg> list) throws DbxException {
        return devicesRevokeDeviceSessionBatch(new RevokeDeviceSessionBatchArg(list));
    }

    FeaturesGetValuesBatchResult featuresGetValues(FeaturesGetValuesBatchArg featuresGetValuesBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (FeaturesGetValuesBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/features/get_values", featuresGetValuesBatchArg, false, FeaturesGetValuesBatchArg.Serializer.INSTANCE, FeaturesGetValuesBatchResult.Serializer.INSTANCE, FeaturesGetValuesBatchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new FeaturesGetValuesBatchErrorException("2/team/features/get_values", e.getRequestId(), e.getUserMessage(), (FeaturesGetValuesBatchError) e.getErrorValue());
        }
    }

    public FeaturesGetValuesBatchResult featuresGetValues(List<Feature> list) throws DbxException {
        return featuresGetValues(new FeaturesGetValuesBatchArg(list));
    }

    public TeamGetInfoResult getInfo() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamGetInfoResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/get_info", null, false, StoneSerializers.void_(), TeamGetInfoResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"get_info\":" + e.getErrorValue());
        }
    }

    GroupFullInfo groupsCreate(GroupCreateArg groupCreateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GroupFullInfo) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/create", groupCreateArg, false, GroupCreateArg.Serializer.INSTANCE, GroupFullInfo.Serializer.INSTANCE, GroupCreateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupCreateErrorException("2/team/groups/create", e.getRequestId(), e.getUserMessage(), (GroupCreateError) e.getErrorValue());
        }
    }

    public GroupFullInfo groupsCreate(String str) throws DbxException {
        return groupsCreate(new GroupCreateArg(str));
    }

    public GroupsCreateBuilder groupsCreateBuilder(String str) {
        return new GroupsCreateBuilder(this, GroupCreateArg.newBuilder(str));
    }

    public LaunchEmptyResult groupsDelete(GroupSelector groupSelector) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LaunchEmptyResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/delete", groupSelector, false, GroupSelector.Serializer.INSTANCE, LaunchEmptyResult.Serializer.INSTANCE, GroupDeleteError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupDeleteErrorException("2/team/groups/delete", e.getRequestId(), e.getUserMessage(), (GroupDeleteError) e.getErrorValue());
        }
    }

    public List<GroupsGetInfoItem> groupsGetInfo(GroupsSelector groupsSelector) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/get_info", groupsSelector, false, GroupsSelector.Serializer.INSTANCE, StoneSerializers.list(GroupsGetInfoItem.Serializer.INSTANCE), GroupsGetInfoError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupsGetInfoErrorException("2/team/groups/get_info", e.getRequestId(), e.getUserMessage(), (GroupsGetInfoError) e.getErrorValue());
        }
    }

    PollEmptyResult groupsJobStatusGet(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (PollEmptyResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/job_status/get", pollArg, false, PollArg.Serializer.INSTANCE, PollEmptyResult.Serializer.INSTANCE, GroupsPollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupsPollErrorException("2/team/groups/job_status/get", e.getRequestId(), e.getUserMessage(), (GroupsPollError) e.getErrorValue());
        }
    }

    public PollEmptyResult groupsJobStatusGet(String str) throws DbxException {
        return groupsJobStatusGet(new PollArg(str));
    }

    GroupsListResult groupsList(GroupsListArg groupsListArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GroupsListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/list", groupsListArg, false, GroupsListArg.Serializer.INSTANCE, GroupsListResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"groups/list\":" + e.getErrorValue());
        }
    }

    public GroupsListResult groupsList() throws DbxException {
        return groupsList(new GroupsListArg());
    }

    public GroupsListResult groupsList(long j) throws DbxException {
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        return groupsList(new GroupsListArg(j));
    }

    GroupsListResult groupsListContinue(GroupsListContinueArg groupsListContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GroupsListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/list/continue", groupsListContinueArg, false, GroupsListContinueArg.Serializer.INSTANCE, GroupsListResult.Serializer.INSTANCE, GroupsListContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupsListContinueErrorException("2/team/groups/list/continue", e.getRequestId(), e.getUserMessage(), (GroupsListContinueError) e.getErrorValue());
        }
    }

    public GroupsListResult groupsListContinue(String str) throws DbxException {
        return groupsListContinue(new GroupsListContinueArg(str));
    }

    GroupMembersChangeResult groupsMembersAdd(GroupMembersAddArg groupMembersAddArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GroupMembersChangeResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/members/add", groupMembersAddArg, false, GroupMembersAddArg.Serializer.INSTANCE, GroupMembersChangeResult.Serializer.INSTANCE, GroupMembersAddError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupMembersAddErrorException("2/team/groups/members/add", e.getRequestId(), e.getUserMessage(), (GroupMembersAddError) e.getErrorValue());
        }
    }

    public GroupMembersChangeResult groupsMembersAdd(GroupSelector groupSelector, List<MemberAccess> list) throws DbxException {
        return groupsMembersAdd(new GroupMembersAddArg(groupSelector, list));
    }

    public GroupMembersChangeResult groupsMembersAdd(GroupSelector groupSelector, List<MemberAccess> list, boolean z) throws DbxException {
        return groupsMembersAdd(new GroupMembersAddArg(groupSelector, list, z));
    }

    GroupsMembersListResult groupsMembersList(GroupsMembersListArg groupsMembersListArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GroupsMembersListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/members/list", groupsMembersListArg, false, GroupsMembersListArg.Serializer.INSTANCE, GroupsMembersListResult.Serializer.INSTANCE, GroupSelectorError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupSelectorErrorException("2/team/groups/members/list", e.getRequestId(), e.getUserMessage(), (GroupSelectorError) e.getErrorValue());
        }
    }

    public GroupsMembersListResult groupsMembersList(GroupSelector groupSelector) throws DbxException {
        return groupsMembersList(new GroupsMembersListArg(groupSelector));
    }

    public GroupsMembersListResult groupsMembersList(GroupSelector groupSelector, long j) throws DbxException {
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        return groupsMembersList(new GroupsMembersListArg(groupSelector, j));
    }

    GroupsMembersListResult groupsMembersListContinue(GroupsMembersListContinueArg groupsMembersListContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GroupsMembersListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/members/list/continue", groupsMembersListContinueArg, false, GroupsMembersListContinueArg.Serializer.INSTANCE, GroupsMembersListResult.Serializer.INSTANCE, GroupsMembersListContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupsMembersListContinueErrorException("2/team/groups/members/list/continue", e.getRequestId(), e.getUserMessage(), (GroupsMembersListContinueError) e.getErrorValue());
        }
    }

    public GroupsMembersListResult groupsMembersListContinue(String str) throws DbxException {
        return groupsMembersListContinue(new GroupsMembersListContinueArg(str));
    }

    GroupMembersChangeResult groupsMembersRemove(GroupMembersRemoveArg groupMembersRemoveArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GroupMembersChangeResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/members/remove", groupMembersRemoveArg, false, GroupMembersRemoveArg.Serializer.INSTANCE, GroupMembersChangeResult.Serializer.INSTANCE, GroupMembersRemoveError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupMembersRemoveErrorException("2/team/groups/members/remove", e.getRequestId(), e.getUserMessage(), (GroupMembersRemoveError) e.getErrorValue());
        }
    }

    public GroupMembersChangeResult groupsMembersRemove(GroupSelector groupSelector, List<UserSelectorArg> list) throws DbxException {
        return groupsMembersRemove(new GroupMembersRemoveArg(groupSelector, list));
    }

    public GroupMembersChangeResult groupsMembersRemove(GroupSelector groupSelector, List<UserSelectorArg> list, boolean z) throws DbxException {
        return groupsMembersRemove(new GroupMembersRemoveArg(groupSelector, list, z));
    }

    List<GroupsGetInfoItem> groupsMembersSetAccessType(GroupMembersSetAccessTypeArg groupMembersSetAccessTypeArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/members/set_access_type", groupMembersSetAccessTypeArg, false, GroupMembersSetAccessTypeArg.Serializer.INSTANCE, StoneSerializers.list(GroupsGetInfoItem.Serializer.INSTANCE), GroupMemberSetAccessTypeError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupMemberSetAccessTypeErrorException("2/team/groups/members/set_access_type", e.getRequestId(), e.getUserMessage(), (GroupMemberSetAccessTypeError) e.getErrorValue());
        }
    }

    public List<GroupsGetInfoItem> groupsMembersSetAccessType(GroupSelector groupSelector, UserSelectorArg userSelectorArg, GroupAccessType groupAccessType) throws DbxException {
        return groupsMembersSetAccessType(new GroupMembersSetAccessTypeArg(groupSelector, userSelectorArg, groupAccessType));
    }

    public List<GroupsGetInfoItem> groupsMembersSetAccessType(GroupSelector groupSelector, UserSelectorArg userSelectorArg, GroupAccessType groupAccessType, boolean z) throws DbxException {
        return groupsMembersSetAccessType(new GroupMembersSetAccessTypeArg(groupSelector, userSelectorArg, groupAccessType, z));
    }

    GroupFullInfo groupsUpdate(GroupUpdateArgs groupUpdateArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GroupFullInfo) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/groups/update", groupUpdateArgs, false, GroupUpdateArgs.Serializer.INSTANCE, GroupFullInfo.Serializer.INSTANCE, GroupUpdateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new GroupUpdateErrorException("2/team/groups/update", e.getRequestId(), e.getUserMessage(), (GroupUpdateError) e.getErrorValue());
        }
    }

    public GroupFullInfo groupsUpdate(GroupSelector groupSelector) throws DbxException {
        return groupsUpdate(new GroupUpdateArgs(groupSelector));
    }

    public GroupsUpdateBuilder groupsUpdateBuilder(GroupSelector groupSelector) {
        return new GroupsUpdateBuilder(this, GroupUpdateArgs.newBuilder(groupSelector));
    }

    LegalHoldPolicy legalHoldsCreatePolicy(LegalHoldsPolicyCreateArg legalHoldsPolicyCreateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LegalHoldPolicy) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/legal_holds/create_policy", legalHoldsPolicyCreateArg, false, LegalHoldsPolicyCreateArg.Serializer.INSTANCE, LegalHoldPolicy.Serializer.INSTANCE, LegalHoldsPolicyCreateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LegalHoldsPolicyCreateErrorException("2/team/legal_holds/create_policy", e.getRequestId(), e.getUserMessage(), (LegalHoldsPolicyCreateError) e.getErrorValue());
        }
    }

    public LegalHoldPolicy legalHoldsCreatePolicy(String str, List<String> list) throws DbxException {
        return legalHoldsCreatePolicy(new LegalHoldsPolicyCreateArg(str, list));
    }

    public LegalHoldsCreatePolicyBuilder legalHoldsCreatePolicyBuilder(String str, List<String> list) {
        return new LegalHoldsCreatePolicyBuilder(this, LegalHoldsPolicyCreateArg.newBuilder(str, list));
    }

    LegalHoldPolicy legalHoldsGetPolicy(LegalHoldsGetPolicyArg legalHoldsGetPolicyArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LegalHoldPolicy) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/legal_holds/get_policy", legalHoldsGetPolicyArg, false, LegalHoldsGetPolicyArg.Serializer.INSTANCE, LegalHoldPolicy.Serializer.INSTANCE, LegalHoldsGetPolicyError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LegalHoldsGetPolicyErrorException("2/team/legal_holds/get_policy", e.getRequestId(), e.getUserMessage(), (LegalHoldsGetPolicyError) e.getErrorValue());
        }
    }

    public LegalHoldPolicy legalHoldsGetPolicy(String str) throws DbxException {
        return legalHoldsGetPolicy(new LegalHoldsGetPolicyArg(str));
    }

    LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisions(LegalHoldsListHeldRevisionsArg legalHoldsListHeldRevisionsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LegalHoldsListHeldRevisionResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/legal_holds/list_held_revisions", legalHoldsListHeldRevisionsArg, false, LegalHoldsListHeldRevisionsArg.Serializer.INSTANCE, LegalHoldsListHeldRevisionResult.Serializer.INSTANCE, LegalHoldsListHeldRevisionsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LegalHoldsListHeldRevisionsErrorException("2/team/legal_holds/list_held_revisions", e.getRequestId(), e.getUserMessage(), (LegalHoldsListHeldRevisionsError) e.getErrorValue());
        }
    }

    public LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisions(String str) throws DbxException {
        return legalHoldsListHeldRevisions(new LegalHoldsListHeldRevisionsArg(str));
    }

    LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisionsContinue(LegalHoldsListHeldRevisionsContinueArg legalHoldsListHeldRevisionsContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LegalHoldsListHeldRevisionResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/legal_holds/list_held_revisions_continue", legalHoldsListHeldRevisionsContinueArg, false, LegalHoldsListHeldRevisionsContinueArg.Serializer.INSTANCE, LegalHoldsListHeldRevisionResult.Serializer.INSTANCE, LegalHoldsListHeldRevisionsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LegalHoldsListHeldRevisionsErrorException("2/team/legal_holds/list_held_revisions_continue", e.getRequestId(), e.getUserMessage(), (LegalHoldsListHeldRevisionsError) e.getErrorValue());
        }
    }

    public LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisionsContinue(String str) throws DbxException {
        return legalHoldsListHeldRevisionsContinue(new LegalHoldsListHeldRevisionsContinueArg(str));
    }

    public LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisionsContinue(String str, String str2) throws DbxException {
        if (str2 != null && str2.length() < 1) {
            throw new IllegalArgumentException("String 'cursor' is shorter than 1");
        }
        return legalHoldsListHeldRevisionsContinue(new LegalHoldsListHeldRevisionsContinueArg(str, str2));
    }

    LegalHoldsListPoliciesResult legalHoldsListPolicies(LegalHoldsListPoliciesArg legalHoldsListPoliciesArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LegalHoldsListPoliciesResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/legal_holds/list_policies", legalHoldsListPoliciesArg, false, LegalHoldsListPoliciesArg.Serializer.INSTANCE, LegalHoldsListPoliciesResult.Serializer.INSTANCE, LegalHoldsListPoliciesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LegalHoldsListPoliciesErrorException("2/team/legal_holds/list_policies", e.getRequestId(), e.getUserMessage(), (LegalHoldsListPoliciesError) e.getErrorValue());
        }
    }

    public LegalHoldsListPoliciesResult legalHoldsListPolicies() throws DbxException {
        return legalHoldsListPolicies(new LegalHoldsListPoliciesArg());
    }

    public LegalHoldsListPoliciesResult legalHoldsListPolicies(boolean z) throws DbxException {
        return legalHoldsListPolicies(new LegalHoldsListPoliciesArg(z));
    }

    void legalHoldsReleasePolicy(LegalHoldsPolicyReleaseArg legalHoldsPolicyReleaseArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/legal_holds/release_policy", legalHoldsPolicyReleaseArg, false, LegalHoldsPolicyReleaseArg.Serializer.INSTANCE, StoneSerializers.void_(), LegalHoldsPolicyReleaseError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LegalHoldsPolicyReleaseErrorException("2/team/legal_holds/release_policy", e.getRequestId(), e.getUserMessage(), (LegalHoldsPolicyReleaseError) e.getErrorValue());
        }
    }

    public void legalHoldsReleasePolicy(String str) throws DbxException {
        legalHoldsReleasePolicy(new LegalHoldsPolicyReleaseArg(str));
    }

    LegalHoldPolicy legalHoldsUpdatePolicy(LegalHoldsPolicyUpdateArg legalHoldsPolicyUpdateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LegalHoldPolicy) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/legal_holds/update_policy", legalHoldsPolicyUpdateArg, false, LegalHoldsPolicyUpdateArg.Serializer.INSTANCE, LegalHoldPolicy.Serializer.INSTANCE, LegalHoldsPolicyUpdateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new LegalHoldsPolicyUpdateErrorException("2/team/legal_holds/update_policy", e.getRequestId(), e.getUserMessage(), (LegalHoldsPolicyUpdateError) e.getErrorValue());
        }
    }

    public LegalHoldPolicy legalHoldsUpdatePolicy(String str) throws DbxException {
        return legalHoldsUpdatePolicy(new LegalHoldsPolicyUpdateArg(str));
    }

    public LegalHoldsUpdatePolicyBuilder legalHoldsUpdatePolicyBuilder(String str) {
        return new LegalHoldsUpdatePolicyBuilder(this, LegalHoldsPolicyUpdateArg.newBuilder(str));
    }

    ListMemberAppsResult linkedAppsListMemberLinkedApps(ListMemberAppsArg listMemberAppsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListMemberAppsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/linked_apps/list_member_linked_apps", listMemberAppsArg, false, ListMemberAppsArg.Serializer.INSTANCE, ListMemberAppsResult.Serializer.INSTANCE, ListMemberAppsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListMemberAppsErrorException("2/team/linked_apps/list_member_linked_apps", e.getRequestId(), e.getUserMessage(), (ListMemberAppsError) e.getErrorValue());
        }
    }

    public ListMemberAppsResult linkedAppsListMemberLinkedApps(String str) throws DbxException {
        return linkedAppsListMemberLinkedApps(new ListMemberAppsArg(str));
    }

    ListMembersAppsResult linkedAppsListMembersLinkedApps(ListMembersAppsArg listMembersAppsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListMembersAppsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/linked_apps/list_members_linked_apps", listMembersAppsArg, false, ListMembersAppsArg.Serializer.INSTANCE, ListMembersAppsResult.Serializer.INSTANCE, ListMembersAppsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListMembersAppsErrorException("2/team/linked_apps/list_members_linked_apps", e.getRequestId(), e.getUserMessage(), (ListMembersAppsError) e.getErrorValue());
        }
    }

    public ListMembersAppsResult linkedAppsListMembersLinkedApps() throws DbxException {
        return linkedAppsListMembersLinkedApps(new ListMembersAppsArg());
    }

    public ListMembersAppsResult linkedAppsListMembersLinkedApps(String str) throws DbxException {
        return linkedAppsListMembersLinkedApps(new ListMembersAppsArg(str));
    }

    ListTeamAppsResult linkedAppsListTeamLinkedApps(ListTeamAppsArg listTeamAppsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ListTeamAppsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/linked_apps/list_team_linked_apps", listTeamAppsArg, false, ListTeamAppsArg.Serializer.INSTANCE, ListTeamAppsResult.Serializer.INSTANCE, ListTeamAppsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ListTeamAppsErrorException("2/team/linked_apps/list_team_linked_apps", e.getRequestId(), e.getUserMessage(), (ListTeamAppsError) e.getErrorValue());
        }
    }

    @Deprecated
    public ListTeamAppsResult linkedAppsListTeamLinkedApps() throws DbxException {
        return linkedAppsListTeamLinkedApps(new ListTeamAppsArg());
    }

    @Deprecated
    public ListTeamAppsResult linkedAppsListTeamLinkedApps(String str) throws DbxException {
        return linkedAppsListTeamLinkedApps(new ListTeamAppsArg(str));
    }

    void linkedAppsRevokeLinkedApp(RevokeLinkedApiAppArg revokeLinkedApiAppArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/linked_apps/revoke_linked_app", revokeLinkedApiAppArg, false, RevokeLinkedApiAppArg.Serializer.INSTANCE, StoneSerializers.void_(), RevokeLinkedAppError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RevokeLinkedAppErrorException("2/team/linked_apps/revoke_linked_app", e.getRequestId(), e.getUserMessage(), (RevokeLinkedAppError) e.getErrorValue());
        }
    }

    public void linkedAppsRevokeLinkedApp(String str, String str2) throws DbxException {
        linkedAppsRevokeLinkedApp(new RevokeLinkedApiAppArg(str, str2));
    }

    public void linkedAppsRevokeLinkedApp(String str, String str2, boolean z) throws DbxException {
        linkedAppsRevokeLinkedApp(new RevokeLinkedApiAppArg(str, str2, z));
    }

    RevokeLinkedAppBatchResult linkedAppsRevokeLinkedAppBatch(RevokeLinkedApiAppBatchArg revokeLinkedApiAppBatchArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (RevokeLinkedAppBatchResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/linked_apps/revoke_linked_app_batch", revokeLinkedApiAppBatchArg, false, RevokeLinkedApiAppBatchArg.Serializer.INSTANCE, RevokeLinkedAppBatchResult.Serializer.INSTANCE, RevokeLinkedAppBatchError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new RevokeLinkedAppBatchErrorException("2/team/linked_apps/revoke_linked_app_batch", e.getRequestId(), e.getUserMessage(), (RevokeLinkedAppBatchError) e.getErrorValue());
        }
    }

    public RevokeLinkedAppBatchResult linkedAppsRevokeLinkedAppBatch(List<RevokeLinkedApiAppArg> list) throws DbxException {
        return linkedAppsRevokeLinkedAppBatch(new RevokeLinkedApiAppBatchArg(list));
    }

    ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersAdd(ExcludedUsersUpdateArg excludedUsersUpdateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ExcludedUsersUpdateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/member_space_limits/excluded_users/add", excludedUsersUpdateArg, false, ExcludedUsersUpdateArg.Serializer.INSTANCE, ExcludedUsersUpdateResult.Serializer.INSTANCE, ExcludedUsersUpdateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ExcludedUsersUpdateErrorException("2/team/member_space_limits/excluded_users/add", e.getRequestId(), e.getUserMessage(), (ExcludedUsersUpdateError) e.getErrorValue());
        }
    }

    public ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersAdd() throws DbxException {
        return memberSpaceLimitsExcludedUsersAdd(new ExcludedUsersUpdateArg());
    }

    public ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersAdd(List<UserSelectorArg> list) throws DbxException {
        if (list != null) {
            Iterator<UserSelectorArg> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'users' is null");
                }
            }
        }
        return memberSpaceLimitsExcludedUsersAdd(new ExcludedUsersUpdateArg(list));
    }

    ExcludedUsersListResult memberSpaceLimitsExcludedUsersList(ExcludedUsersListArg excludedUsersListArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ExcludedUsersListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/member_space_limits/excluded_users/list", excludedUsersListArg, false, ExcludedUsersListArg.Serializer.INSTANCE, ExcludedUsersListResult.Serializer.INSTANCE, ExcludedUsersListError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ExcludedUsersListErrorException("2/team/member_space_limits/excluded_users/list", e.getRequestId(), e.getUserMessage(), (ExcludedUsersListError) e.getErrorValue());
        }
    }

    public ExcludedUsersListResult memberSpaceLimitsExcludedUsersList() throws DbxException {
        return memberSpaceLimitsExcludedUsersList(new ExcludedUsersListArg());
    }

    public ExcludedUsersListResult memberSpaceLimitsExcludedUsersList(long j) throws DbxException {
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        return memberSpaceLimitsExcludedUsersList(new ExcludedUsersListArg(j));
    }

    ExcludedUsersListResult memberSpaceLimitsExcludedUsersListContinue(ExcludedUsersListContinueArg excludedUsersListContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ExcludedUsersListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/member_space_limits/excluded_users/list/continue", excludedUsersListContinueArg, false, ExcludedUsersListContinueArg.Serializer.INSTANCE, ExcludedUsersListResult.Serializer.INSTANCE, ExcludedUsersListContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ExcludedUsersListContinueErrorException("2/team/member_space_limits/excluded_users/list/continue", e.getRequestId(), e.getUserMessage(), (ExcludedUsersListContinueError) e.getErrorValue());
        }
    }

    public ExcludedUsersListResult memberSpaceLimitsExcludedUsersListContinue(String str) throws DbxException {
        return memberSpaceLimitsExcludedUsersListContinue(new ExcludedUsersListContinueArg(str));
    }

    ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersRemove(ExcludedUsersUpdateArg excludedUsersUpdateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ExcludedUsersUpdateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/member_space_limits/excluded_users/remove", excludedUsersUpdateArg, false, ExcludedUsersUpdateArg.Serializer.INSTANCE, ExcludedUsersUpdateResult.Serializer.INSTANCE, ExcludedUsersUpdateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ExcludedUsersUpdateErrorException("2/team/member_space_limits/excluded_users/remove", e.getRequestId(), e.getUserMessage(), (ExcludedUsersUpdateError) e.getErrorValue());
        }
    }

    public ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersRemove() throws DbxException {
        return memberSpaceLimitsExcludedUsersRemove(new ExcludedUsersUpdateArg());
    }

    public ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersRemove(List<UserSelectorArg> list) throws DbxException {
        if (list != null) {
            Iterator<UserSelectorArg> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'users' is null");
                }
            }
        }
        return memberSpaceLimitsExcludedUsersRemove(new ExcludedUsersUpdateArg(list));
    }

    List<CustomQuotaResult> memberSpaceLimitsGetCustomQuota(CustomQuotaUsersArg customQuotaUsersArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/member_space_limits/get_custom_quota", customQuotaUsersArg, false, CustomQuotaUsersArg.Serializer.INSTANCE, StoneSerializers.list(CustomQuotaResult.Serializer.INSTANCE), CustomQuotaError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new CustomQuotaErrorException("2/team/member_space_limits/get_custom_quota", e.getRequestId(), e.getUserMessage(), (CustomQuotaError) e.getErrorValue());
        }
    }

    public List<CustomQuotaResult> memberSpaceLimitsGetCustomQuota(List<UserSelectorArg> list) throws DbxException {
        return memberSpaceLimitsGetCustomQuota(new CustomQuotaUsersArg(list));
    }

    List<RemoveCustomQuotaResult> memberSpaceLimitsRemoveCustomQuota(CustomQuotaUsersArg customQuotaUsersArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/member_space_limits/remove_custom_quota", customQuotaUsersArg, false, CustomQuotaUsersArg.Serializer.INSTANCE, StoneSerializers.list(RemoveCustomQuotaResult.Serializer.INSTANCE), CustomQuotaError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new CustomQuotaErrorException("2/team/member_space_limits/remove_custom_quota", e.getRequestId(), e.getUserMessage(), (CustomQuotaError) e.getErrorValue());
        }
    }

    public List<RemoveCustomQuotaResult> memberSpaceLimitsRemoveCustomQuota(List<UserSelectorArg> list) throws DbxException {
        return memberSpaceLimitsRemoveCustomQuota(new CustomQuotaUsersArg(list));
    }

    List<CustomQuotaResult> memberSpaceLimitsSetCustomQuota(SetCustomQuotaArg setCustomQuotaArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/member_space_limits/set_custom_quota", setCustomQuotaArg, false, SetCustomQuotaArg.Serializer.INSTANCE, StoneSerializers.list(CustomQuotaResult.Serializer.INSTANCE), SetCustomQuotaError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SetCustomQuotaErrorException("2/team/member_space_limits/set_custom_quota", e.getRequestId(), e.getUserMessage(), (SetCustomQuotaError) e.getErrorValue());
        }
    }

    public List<CustomQuotaResult> memberSpaceLimitsSetCustomQuota(List<UserCustomQuotaArg> list) throws DbxException {
        return memberSpaceLimitsSetCustomQuota(new SetCustomQuotaArg(list));
    }

    MembersAddLaunchV2Result membersAddV2(MembersAddV2Arg membersAddV2Arg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersAddLaunchV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/add_v2", membersAddV2Arg, false, MembersAddV2Arg.Serializer.INSTANCE, MembersAddLaunchV2Result.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"members/add_v2\":" + e.getErrorValue());
        }
    }

    public MembersAddLaunchV2Result membersAddV2(List<MemberAddV2Arg> list) throws DbxException {
        return membersAddV2(new MembersAddV2Arg(list));
    }

    public MembersAddLaunchV2Result membersAddV2(List<MemberAddV2Arg> list, boolean z) throws DbxException {
        return membersAddV2(new MembersAddV2Arg(list, z));
    }

    MembersAddLaunch membersAdd(MembersAddArg membersAddArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersAddLaunch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/add", membersAddArg, false, MembersAddArg.Serializer.INSTANCE, MembersAddLaunch.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"members/add\":" + e.getErrorValue());
        }
    }

    public MembersAddLaunch membersAdd(List<MemberAddArg> list) throws DbxException {
        return membersAdd(new MembersAddArg(list));
    }

    public MembersAddLaunch membersAdd(List<MemberAddArg> list, boolean z) throws DbxException {
        return membersAdd(new MembersAddArg(list, z));
    }

    MembersAddJobStatusV2Result membersAddJobStatusGetV2(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersAddJobStatusV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/add/job_status/get_v2", pollArg, false, PollArg.Serializer.INSTANCE, MembersAddJobStatusV2Result.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/team/members/add/job_status/get_v2", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public MembersAddJobStatusV2Result membersAddJobStatusGetV2(String str) throws DbxException {
        return membersAddJobStatusGetV2(new PollArg(str));
    }

    MembersAddJobStatus membersAddJobStatusGet(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersAddJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/add/job_status/get", pollArg, false, PollArg.Serializer.INSTANCE, MembersAddJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/team/members/add/job_status/get", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public MembersAddJobStatus membersAddJobStatusGet(String str) throws DbxException {
        return membersAddJobStatusGet(new PollArg(str));
    }

    TeamMemberInfoV2Result membersDeleteProfilePhotoV2(MembersDeleteProfilePhotoArg membersDeleteProfilePhotoArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamMemberInfoV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/delete_profile_photo_v2", membersDeleteProfilePhotoArg, false, MembersDeleteProfilePhotoArg.Serializer.INSTANCE, TeamMemberInfoV2Result.Serializer.INSTANCE, MembersDeleteProfilePhotoError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersDeleteProfilePhotoErrorException("2/team/members/delete_profile_photo_v2", e.getRequestId(), e.getUserMessage(), (MembersDeleteProfilePhotoError) e.getErrorValue());
        }
    }

    public TeamMemberInfoV2Result membersDeleteProfilePhotoV2(UserSelectorArg userSelectorArg) throws DbxException {
        return membersDeleteProfilePhotoV2(new MembersDeleteProfilePhotoArg(userSelectorArg));
    }

    TeamMemberInfo membersDeleteProfilePhoto(MembersDeleteProfilePhotoArg membersDeleteProfilePhotoArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamMemberInfo) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/delete_profile_photo", membersDeleteProfilePhotoArg, false, MembersDeleteProfilePhotoArg.Serializer.INSTANCE, TeamMemberInfo.Serializer.INSTANCE, MembersDeleteProfilePhotoError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersDeleteProfilePhotoErrorException("2/team/members/delete_profile_photo", e.getRequestId(), e.getUserMessage(), (MembersDeleteProfilePhotoError) e.getErrorValue());
        }
    }

    public TeamMemberInfo membersDeleteProfilePhoto(UserSelectorArg userSelectorArg) throws DbxException {
        return membersDeleteProfilePhoto(new MembersDeleteProfilePhotoArg(userSelectorArg));
    }

    public MembersGetAvailableTeamMemberRolesResult membersGetAvailableTeamMemberRoles() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersGetAvailableTeamMemberRolesResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/get_available_team_member_roles", null, false, StoneSerializers.void_(), MembersGetAvailableTeamMemberRolesResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"members/get_available_team_member_roles\":" + e.getErrorValue());
        }
    }

    MembersGetInfoV2Result membersGetInfoV2(MembersGetInfoV2Arg membersGetInfoV2Arg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersGetInfoV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/get_info_v2", membersGetInfoV2Arg, false, MembersGetInfoV2Arg.Serializer.INSTANCE, MembersGetInfoV2Result.Serializer.INSTANCE, MembersGetInfoError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersGetInfoErrorException("2/team/members/get_info_v2", e.getRequestId(), e.getUserMessage(), (MembersGetInfoError) e.getErrorValue());
        }
    }

    public MembersGetInfoV2Result membersGetInfoV2(List<UserSelectorArg> list) throws DbxException {
        return membersGetInfoV2(new MembersGetInfoV2Arg(list));
    }

    List<MembersGetInfoItem> membersGetInfo(MembersGetInfoArgs membersGetInfoArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/get_info", membersGetInfoArgs, false, MembersGetInfoArgs.Serializer.INSTANCE, StoneSerializers.list(MembersGetInfoItem.Serializer.INSTANCE), MembersGetInfoError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersGetInfoErrorException("2/team/members/get_info", e.getRequestId(), e.getUserMessage(), (MembersGetInfoError) e.getErrorValue());
        }
    }

    public List<MembersGetInfoItem> membersGetInfo(List<UserSelectorArg> list) throws DbxException {
        return membersGetInfo(new MembersGetInfoArgs(list));
    }

    MembersListV2Result membersListV2(MembersListArg membersListArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersListV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/list_v2", membersListArg, false, MembersListArg.Serializer.INSTANCE, MembersListV2Result.Serializer.INSTANCE, MembersListError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersListErrorException("2/team/members/list_v2", e.getRequestId(), e.getUserMessage(), (MembersListError) e.getErrorValue());
        }
    }

    public MembersListV2Result membersListV2() throws DbxException {
        return membersListV2(new MembersListArg());
    }

    public MembersListV2Builder membersListV2Builder() {
        return new MembersListV2Builder(this, MembersListArg.newBuilder());
    }

    MembersListResult membersList(MembersListArg membersListArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/list", membersListArg, false, MembersListArg.Serializer.INSTANCE, MembersListResult.Serializer.INSTANCE, MembersListError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersListErrorException("2/team/members/list", e.getRequestId(), e.getUserMessage(), (MembersListError) e.getErrorValue());
        }
    }

    public MembersListResult membersList() throws DbxException {
        return membersList(new MembersListArg());
    }

    public MembersListBuilder membersListBuilder() {
        return new MembersListBuilder(this, MembersListArg.newBuilder());
    }

    MembersListV2Result membersListContinueV2(MembersListContinueArg membersListContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersListV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/list/continue_v2", membersListContinueArg, false, MembersListContinueArg.Serializer.INSTANCE, MembersListV2Result.Serializer.INSTANCE, MembersListContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersListContinueErrorException("2/team/members/list/continue_v2", e.getRequestId(), e.getUserMessage(), (MembersListContinueError) e.getErrorValue());
        }
    }

    public MembersListV2Result membersListContinueV2(String str) throws DbxException {
        return membersListContinueV2(new MembersListContinueArg(str));
    }

    MembersListResult membersListContinue(MembersListContinueArg membersListContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/list/continue", membersListContinueArg, false, MembersListContinueArg.Serializer.INSTANCE, MembersListResult.Serializer.INSTANCE, MembersListContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersListContinueErrorException("2/team/members/list/continue", e.getRequestId(), e.getUserMessage(), (MembersListContinueError) e.getErrorValue());
        }
    }

    public MembersListResult membersListContinue(String str) throws DbxException {
        return membersListContinue(new MembersListContinueArg(str));
    }

    LaunchEmptyResult membersMoveFormerMemberFiles(MembersDataTransferArg membersDataTransferArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LaunchEmptyResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/move_former_member_files", membersDataTransferArg, false, MembersDataTransferArg.Serializer.INSTANCE, LaunchEmptyResult.Serializer.INSTANCE, MembersTransferFormerMembersFilesError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersTransferFormerMembersFilesErrorException("2/team/members/move_former_member_files", e.getRequestId(), e.getUserMessage(), (MembersTransferFormerMembersFilesError) e.getErrorValue());
        }
    }

    public LaunchEmptyResult membersMoveFormerMemberFiles(UserSelectorArg userSelectorArg, UserSelectorArg userSelectorArg2, UserSelectorArg userSelectorArg3) throws DbxException {
        return membersMoveFormerMemberFiles(new MembersDataTransferArg(userSelectorArg, userSelectorArg2, userSelectorArg3));
    }

    PollEmptyResult membersMoveFormerMemberFilesJobStatusCheck(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (PollEmptyResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/move_former_member_files/job_status/check", pollArg, false, PollArg.Serializer.INSTANCE, PollEmptyResult.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/team/members/move_former_member_files/job_status/check", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public PollEmptyResult membersMoveFormerMemberFilesJobStatusCheck(String str) throws DbxException {
        return membersMoveFormerMemberFilesJobStatusCheck(new PollArg(str));
    }

    void membersRecover(MembersRecoverArg membersRecoverArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/recover", membersRecoverArg, false, MembersRecoverArg.Serializer.INSTANCE, StoneSerializers.void_(), MembersRecoverError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersRecoverErrorException("2/team/members/recover", e.getRequestId(), e.getUserMessage(), (MembersRecoverError) e.getErrorValue());
        }
    }

    public void membersRecover(UserSelectorArg userSelectorArg) throws DbxException {
        membersRecover(new MembersRecoverArg(userSelectorArg));
    }

    LaunchEmptyResult membersRemove(MembersRemoveArg membersRemoveArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (LaunchEmptyResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/remove", membersRemoveArg, false, MembersRemoveArg.Serializer.INSTANCE, LaunchEmptyResult.Serializer.INSTANCE, MembersRemoveError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersRemoveErrorException("2/team/members/remove", e.getRequestId(), e.getUserMessage(), (MembersRemoveError) e.getErrorValue());
        }
    }

    public LaunchEmptyResult membersRemove(UserSelectorArg userSelectorArg) throws DbxException {
        return membersRemove(new MembersRemoveArg(userSelectorArg));
    }

    public MembersRemoveBuilder membersRemoveBuilder(UserSelectorArg userSelectorArg) {
        return new MembersRemoveBuilder(this, MembersRemoveArg.newBuilder(userSelectorArg));
    }

    PollEmptyResult membersRemoveJobStatusGet(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (PollEmptyResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/remove/job_status/get", pollArg, false, PollArg.Serializer.INSTANCE, PollEmptyResult.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/team/members/remove/job_status/get", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public PollEmptyResult membersRemoveJobStatusGet(String str) throws DbxException {
        return membersRemoveJobStatusGet(new PollArg(str));
    }

    AddSecondaryEmailsResult membersSecondaryEmailsAdd(AddSecondaryEmailsArg addSecondaryEmailsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (AddSecondaryEmailsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/secondary_emails/add", addSecondaryEmailsArg, false, AddSecondaryEmailsArg.Serializer.INSTANCE, AddSecondaryEmailsResult.Serializer.INSTANCE, AddSecondaryEmailsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new AddSecondaryEmailsErrorException("2/team/members/secondary_emails/add", e.getRequestId(), e.getUserMessage(), (AddSecondaryEmailsError) e.getErrorValue());
        }
    }

    public AddSecondaryEmailsResult membersSecondaryEmailsAdd(List<UserSecondaryEmailsArg> list) throws DbxException {
        return membersSecondaryEmailsAdd(new AddSecondaryEmailsArg(list));
    }

    DeleteSecondaryEmailsResult membersSecondaryEmailsDelete(DeleteSecondaryEmailsArg deleteSecondaryEmailsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (DeleteSecondaryEmailsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/secondary_emails/delete", deleteSecondaryEmailsArg, false, DeleteSecondaryEmailsArg.Serializer.INSTANCE, DeleteSecondaryEmailsResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"members/secondary_emails/delete\":" + e.getErrorValue());
        }
    }

    public DeleteSecondaryEmailsResult membersSecondaryEmailsDelete(List<UserSecondaryEmailsArg> list) throws DbxException {
        return membersSecondaryEmailsDelete(new DeleteSecondaryEmailsArg(list));
    }

    ResendVerificationEmailResult membersSecondaryEmailsResendVerificationEmails(ResendVerificationEmailArg resendVerificationEmailArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (ResendVerificationEmailResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/secondary_emails/resend_verification_emails", resendVerificationEmailArg, false, ResendVerificationEmailArg.Serializer.INSTANCE, ResendVerificationEmailResult.Serializer.INSTANCE, StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"members/secondary_emails/resend_verification_emails\":" + e.getErrorValue());
        }
    }

    public ResendVerificationEmailResult membersSecondaryEmailsResendVerificationEmails(List<UserSecondaryEmailsArg> list) throws DbxException {
        return membersSecondaryEmailsResendVerificationEmails(new ResendVerificationEmailArg(list));
    }

    public void membersSendWelcomeEmail(UserSelectorArg userSelectorArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/send_welcome_email", userSelectorArg, false, UserSelectorArg.Serializer.INSTANCE, StoneSerializers.void_(), MembersSendWelcomeError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersSendWelcomeErrorException("2/team/members/send_welcome_email", e.getRequestId(), e.getUserMessage(), (MembersSendWelcomeError) e.getErrorValue());
        }
    }

    MembersSetPermissions2Result membersSetAdminPermissionsV2(MembersSetPermissions2Arg membersSetPermissions2Arg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersSetPermissions2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/set_admin_permissions_v2", membersSetPermissions2Arg, false, MembersSetPermissions2Arg.Serializer.INSTANCE, MembersSetPermissions2Result.Serializer.INSTANCE, MembersSetPermissions2Error.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersSetPermissions2ErrorException("2/team/members/set_admin_permissions_v2", e.getRequestId(), e.getUserMessage(), (MembersSetPermissions2Error) e.getErrorValue());
        }
    }

    public MembersSetPermissions2Result membersSetAdminPermissionsV2(UserSelectorArg userSelectorArg) throws DbxException {
        return membersSetAdminPermissionsV2(new MembersSetPermissions2Arg(userSelectorArg));
    }

    public MembersSetPermissions2Result membersSetAdminPermissionsV2(UserSelectorArg userSelectorArg, List<String> list) throws DbxException {
        if (list != null) {
            if (list.size() > 1) {
                throw new IllegalArgumentException("List 'newRoles' has more than 1 items");
            }
            for (String str : list) {
                if (str == null) {
                    throw new IllegalArgumentException("An item in list 'newRoles' is null");
                }
                if (str.length() > 128) {
                    throw new IllegalArgumentException("Stringan item in list 'newRoles' is longer than 128");
                }
                if (!Pattern.matches("pid_dbtmr:.*", str)) {
                    throw new IllegalArgumentException("Stringan item in list 'newRoles' does not match pattern");
                }
            }
        }
        return membersSetAdminPermissionsV2(new MembersSetPermissions2Arg(userSelectorArg, list));
    }

    MembersSetPermissionsResult membersSetAdminPermissions(MembersSetPermissionsArg membersSetPermissionsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (MembersSetPermissionsResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/set_admin_permissions", membersSetPermissionsArg, false, MembersSetPermissionsArg.Serializer.INSTANCE, MembersSetPermissionsResult.Serializer.INSTANCE, MembersSetPermissionsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersSetPermissionsErrorException("2/team/members/set_admin_permissions", e.getRequestId(), e.getUserMessage(), (MembersSetPermissionsError) e.getErrorValue());
        }
    }

    public MembersSetPermissionsResult membersSetAdminPermissions(UserSelectorArg userSelectorArg, AdminTier adminTier) throws DbxException {
        return membersSetAdminPermissions(new MembersSetPermissionsArg(userSelectorArg, adminTier));
    }

    TeamMemberInfoV2Result membersSetProfileV2(MembersSetProfileArg membersSetProfileArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamMemberInfoV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/set_profile_v2", membersSetProfileArg, false, MembersSetProfileArg.Serializer.INSTANCE, TeamMemberInfoV2Result.Serializer.INSTANCE, MembersSetProfileError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersSetProfileErrorException("2/team/members/set_profile_v2", e.getRequestId(), e.getUserMessage(), (MembersSetProfileError) e.getErrorValue());
        }
    }

    public TeamMemberInfoV2Result membersSetProfileV2(UserSelectorArg userSelectorArg) throws DbxException {
        return membersSetProfileV2(new MembersSetProfileArg(userSelectorArg));
    }

    public MembersSetProfileV2Builder membersSetProfileV2Builder(UserSelectorArg userSelectorArg) {
        return new MembersSetProfileV2Builder(this, MembersSetProfileArg.newBuilder(userSelectorArg));
    }

    TeamMemberInfo membersSetProfile(MembersSetProfileArg membersSetProfileArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamMemberInfo) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/set_profile", membersSetProfileArg, false, MembersSetProfileArg.Serializer.INSTANCE, TeamMemberInfo.Serializer.INSTANCE, MembersSetProfileError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersSetProfileErrorException("2/team/members/set_profile", e.getRequestId(), e.getUserMessage(), (MembersSetProfileError) e.getErrorValue());
        }
    }

    public TeamMemberInfo membersSetProfile(UserSelectorArg userSelectorArg) throws DbxException {
        return membersSetProfile(new MembersSetProfileArg(userSelectorArg));
    }

    public MembersSetProfileBuilder membersSetProfileBuilder(UserSelectorArg userSelectorArg) {
        return new MembersSetProfileBuilder(this, MembersSetProfileArg.newBuilder(userSelectorArg));
    }

    TeamMemberInfoV2Result membersSetProfilePhotoV2(MembersSetProfilePhotoArg membersSetProfilePhotoArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamMemberInfoV2Result) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/set_profile_photo_v2", membersSetProfilePhotoArg, false, MembersSetProfilePhotoArg.Serializer.INSTANCE, TeamMemberInfoV2Result.Serializer.INSTANCE, MembersSetProfilePhotoError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersSetProfilePhotoErrorException("2/team/members/set_profile_photo_v2", e.getRequestId(), e.getUserMessage(), (MembersSetProfilePhotoError) e.getErrorValue());
        }
    }

    public TeamMemberInfoV2Result membersSetProfilePhotoV2(UserSelectorArg userSelectorArg, PhotoSourceArg photoSourceArg) throws DbxException {
        return membersSetProfilePhotoV2(new MembersSetProfilePhotoArg(userSelectorArg, photoSourceArg));
    }

    TeamMemberInfo membersSetProfilePhoto(MembersSetProfilePhotoArg membersSetProfilePhotoArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamMemberInfo) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/set_profile_photo", membersSetProfilePhotoArg, false, MembersSetProfilePhotoArg.Serializer.INSTANCE, TeamMemberInfo.Serializer.INSTANCE, MembersSetProfilePhotoError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersSetProfilePhotoErrorException("2/team/members/set_profile_photo", e.getRequestId(), e.getUserMessage(), (MembersSetProfilePhotoError) e.getErrorValue());
        }
    }

    public TeamMemberInfo membersSetProfilePhoto(UserSelectorArg userSelectorArg, PhotoSourceArg photoSourceArg) throws DbxException {
        return membersSetProfilePhoto(new MembersSetProfilePhotoArg(userSelectorArg, photoSourceArg));
    }

    void membersSuspend(MembersDeactivateArg membersDeactivateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/suspend", membersDeactivateArg, false, MembersDeactivateArg.Serializer.INSTANCE, StoneSerializers.void_(), MembersSuspendError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersSuspendErrorException("2/team/members/suspend", e.getRequestId(), e.getUserMessage(), (MembersSuspendError) e.getErrorValue());
        }
    }

    public void membersSuspend(UserSelectorArg userSelectorArg) throws DbxException {
        membersSuspend(new MembersDeactivateArg(userSelectorArg));
    }

    public void membersSuspend(UserSelectorArg userSelectorArg, boolean z) throws DbxException {
        membersSuspend(new MembersDeactivateArg(userSelectorArg, z));
    }

    void membersUnsuspend(MembersUnsuspendArg membersUnsuspendArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/members/unsuspend", membersUnsuspendArg, false, MembersUnsuspendArg.Serializer.INSTANCE, StoneSerializers.void_(), MembersUnsuspendError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new MembersUnsuspendErrorException("2/team/members/unsuspend", e.getRequestId(), e.getUserMessage(), (MembersUnsuspendError) e.getErrorValue());
        }
    }

    public void membersUnsuspend(UserSelectorArg userSelectorArg) throws DbxException {
        membersUnsuspend(new MembersUnsuspendArg(userSelectorArg));
    }

    TeamNamespacesListResult namespacesList(TeamNamespacesListArg teamNamespacesListArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamNamespacesListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/namespaces/list", teamNamespacesListArg, false, TeamNamespacesListArg.Serializer.INSTANCE, TeamNamespacesListResult.Serializer.INSTANCE, TeamNamespacesListError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamNamespacesListErrorException("2/team/namespaces/list", e.getRequestId(), e.getUserMessage(), (TeamNamespacesListError) e.getErrorValue());
        }
    }

    public TeamNamespacesListResult namespacesList() throws DbxException {
        return namespacesList(new TeamNamespacesListArg());
    }

    public TeamNamespacesListResult namespacesList(long j) throws DbxException {
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        return namespacesList(new TeamNamespacesListArg(j));
    }

    TeamNamespacesListResult namespacesListContinue(TeamNamespacesListContinueArg teamNamespacesListContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamNamespacesListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/namespaces/list/continue", teamNamespacesListContinueArg, false, TeamNamespacesListContinueArg.Serializer.INSTANCE, TeamNamespacesListResult.Serializer.INSTANCE, TeamNamespacesListContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamNamespacesListContinueErrorException("2/team/namespaces/list/continue", e.getRequestId(), e.getUserMessage(), (TeamNamespacesListContinueError) e.getErrorValue());
        }
    }

    public TeamNamespacesListResult namespacesListContinue(String str) throws DbxException {
        return namespacesListContinue(new TeamNamespacesListContinueArg(str));
    }

    AddTemplateResult propertiesTemplateAdd(AddTemplateArg addTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (AddTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/properties/template/add", addTemplateArg, false, AddTemplateArg.Serializer.INSTANCE, AddTemplateResult.Serializer.INSTANCE, ModifyTemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ModifyTemplateErrorException("2/team/properties/template/add", e.getRequestId(), e.getUserMessage(), (ModifyTemplateError) e.getErrorValue());
        }
    }

    @Deprecated
    public AddTemplateResult propertiesTemplateAdd(String str, String str2, List<PropertyFieldTemplate> list) throws DbxException {
        return propertiesTemplateAdd(new AddTemplateArg(str, str2, list));
    }

    GetTemplateResult propertiesTemplateGet(GetTemplateArg getTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/properties/template/get", getTemplateArg, false, GetTemplateArg.Serializer.INSTANCE, GetTemplateResult.Serializer.INSTANCE, TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/team/properties/template/get", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
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
            return (ListTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/properties/template/list", null, false, StoneSerializers.void_(), ListTemplateResult.Serializer.INSTANCE, TemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TemplateErrorException("2/team/properties/template/list", e.getRequestId(), e.getUserMessage(), (TemplateError) e.getErrorValue());
        }
    }

    UpdateTemplateResult propertiesTemplateUpdate(UpdateTemplateArg updateTemplateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (UpdateTemplateResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/properties/template/update", updateTemplateArg, false, UpdateTemplateArg.Serializer.INSTANCE, UpdateTemplateResult.Serializer.INSTANCE, ModifyTemplateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new ModifyTemplateErrorException("2/team/properties/template/update", e.getRequestId(), e.getUserMessage(), (ModifyTemplateError) e.getErrorValue());
        }
    }

    @Deprecated
    public UpdateTemplateResult propertiesTemplateUpdate(String str) throws DbxException {
        return propertiesTemplateUpdate(new UpdateTemplateArg(str));
    }

    @Deprecated
    public PropertiesTemplateUpdateBuilder propertiesTemplateUpdateBuilder(String str) {
        return new PropertiesTemplateUpdateBuilder(this, UpdateTemplateArg.newBuilder(str));
    }

    GetActivityReport reportsGetActivity(DateRange dateRange) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetActivityReport) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/reports/get_activity", dateRange, false, DateRange.Serializer.INSTANCE, GetActivityReport.Serializer.INSTANCE, DateRangeError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DateRangeErrorException("2/team/reports/get_activity", e.getRequestId(), e.getUserMessage(), (DateRangeError) e.getErrorValue());
        }
    }

    @Deprecated
    public GetActivityReport reportsGetActivity() throws DbxException {
        return reportsGetActivity(new DateRange());
    }

    @Deprecated
    public ReportsGetActivityBuilder reportsGetActivityBuilder() {
        return new ReportsGetActivityBuilder(this, DateRange.newBuilder());
    }

    GetDevicesReport reportsGetDevices(DateRange dateRange) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetDevicesReport) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/reports/get_devices", dateRange, false, DateRange.Serializer.INSTANCE, GetDevicesReport.Serializer.INSTANCE, DateRangeError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DateRangeErrorException("2/team/reports/get_devices", e.getRequestId(), e.getUserMessage(), (DateRangeError) e.getErrorValue());
        }
    }

    @Deprecated
    public GetDevicesReport reportsGetDevices() throws DbxException {
        return reportsGetDevices(new DateRange());
    }

    @Deprecated
    public ReportsGetDevicesBuilder reportsGetDevicesBuilder() {
        return new ReportsGetDevicesBuilder(this, DateRange.newBuilder());
    }

    GetMembershipReport reportsGetMembership(DateRange dateRange) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetMembershipReport) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/reports/get_membership", dateRange, false, DateRange.Serializer.INSTANCE, GetMembershipReport.Serializer.INSTANCE, DateRangeError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DateRangeErrorException("2/team/reports/get_membership", e.getRequestId(), e.getUserMessage(), (DateRangeError) e.getErrorValue());
        }
    }

    @Deprecated
    public GetMembershipReport reportsGetMembership() throws DbxException {
        return reportsGetMembership(new DateRange());
    }

    @Deprecated
    public ReportsGetMembershipBuilder reportsGetMembershipBuilder() {
        return new ReportsGetMembershipBuilder(this, DateRange.newBuilder());
    }

    GetStorageReport reportsGetStorage(DateRange dateRange) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (GetStorageReport) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/reports/get_storage", dateRange, false, DateRange.Serializer.INSTANCE, GetStorageReport.Serializer.INSTANCE, DateRangeError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new DateRangeErrorException("2/team/reports/get_storage", e.getRequestId(), e.getUserMessage(), (DateRangeError) e.getErrorValue());
        }
    }

    @Deprecated
    public GetStorageReport reportsGetStorage() throws DbxException {
        return reportsGetStorage(new DateRange());
    }

    @Deprecated
    public ReportsGetStorageBuilder reportsGetStorageBuilder() {
        return new ReportsGetStorageBuilder(this, DateRange.newBuilder());
    }

    SharingAllowlistAddResponse sharingAllowlistAdd(SharingAllowlistAddArgs sharingAllowlistAddArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharingAllowlistAddResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/sharing_allowlist/add", sharingAllowlistAddArgs, false, SharingAllowlistAddArgs.Serializer.INSTANCE, SharingAllowlistAddResponse.Serializer.INSTANCE, SharingAllowlistAddError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharingAllowlistAddErrorException("2/team/sharing_allowlist/add", e.getRequestId(), e.getUserMessage(), (SharingAllowlistAddError) e.getErrorValue());
        }
    }

    public SharingAllowlistAddResponse sharingAllowlistAdd() throws DbxException {
        return sharingAllowlistAdd(new SharingAllowlistAddArgs());
    }

    public SharingAllowlistAddBuilder sharingAllowlistAddBuilder() {
        return new SharingAllowlistAddBuilder(this, SharingAllowlistAddArgs.newBuilder());
    }

    SharingAllowlistListResponse sharingAllowlistList(SharingAllowlistListArg sharingAllowlistListArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharingAllowlistListResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/sharing_allowlist/list", sharingAllowlistListArg, false, SharingAllowlistListArg.Serializer.INSTANCE, SharingAllowlistListResponse.Serializer.INSTANCE, SharingAllowlistListError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharingAllowlistListErrorException("2/team/sharing_allowlist/list", e.getRequestId(), e.getUserMessage(), (SharingAllowlistListError) e.getErrorValue());
        }
    }

    public SharingAllowlistListResponse sharingAllowlistList() throws DbxException {
        return sharingAllowlistList(new SharingAllowlistListArg());
    }

    public SharingAllowlistListResponse sharingAllowlistList(long j) throws DbxException {
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        return sharingAllowlistList(new SharingAllowlistListArg(j));
    }

    SharingAllowlistListResponse sharingAllowlistListContinue(SharingAllowlistListContinueArg sharingAllowlistListContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharingAllowlistListResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/sharing_allowlist/list/continue", sharingAllowlistListContinueArg, false, SharingAllowlistListContinueArg.Serializer.INSTANCE, SharingAllowlistListResponse.Serializer.INSTANCE, SharingAllowlistListContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharingAllowlistListContinueErrorException("2/team/sharing_allowlist/list/continue", e.getRequestId(), e.getUserMessage(), (SharingAllowlistListContinueError) e.getErrorValue());
        }
    }

    public SharingAllowlistListResponse sharingAllowlistListContinue(String str) throws DbxException {
        return sharingAllowlistListContinue(new SharingAllowlistListContinueArg(str));
    }

    SharingAllowlistRemoveResponse sharingAllowlistRemove(SharingAllowlistRemoveArgs sharingAllowlistRemoveArgs) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (SharingAllowlistRemoveResponse) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/sharing_allowlist/remove", sharingAllowlistRemoveArgs, false, SharingAllowlistRemoveArgs.Serializer.INSTANCE, SharingAllowlistRemoveResponse.Serializer.INSTANCE, SharingAllowlistRemoveError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new SharingAllowlistRemoveErrorException("2/team/sharing_allowlist/remove", e.getRequestId(), e.getUserMessage(), (SharingAllowlistRemoveError) e.getErrorValue());
        }
    }

    public SharingAllowlistRemoveResponse sharingAllowlistRemove() throws DbxException {
        return sharingAllowlistRemove(new SharingAllowlistRemoveArgs());
    }

    public SharingAllowlistRemoveBuilder sharingAllowlistRemoveBuilder() {
        return new SharingAllowlistRemoveBuilder(this, SharingAllowlistRemoveArgs.newBuilder());
    }

    TeamFolderMetadata teamFolderActivate(TeamFolderIdArg teamFolderIdArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamFolderMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/activate", teamFolderIdArg, false, TeamFolderIdArg.Serializer.INSTANCE, TeamFolderMetadata.Serializer.INSTANCE, TeamFolderActivateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamFolderActivateErrorException("2/team/team_folder/activate", e.getRequestId(), e.getUserMessage(), (TeamFolderActivateError) e.getErrorValue());
        }
    }

    public TeamFolderMetadata teamFolderActivate(String str) throws DbxException {
        return teamFolderActivate(new TeamFolderIdArg(str));
    }

    TeamFolderArchiveLaunch teamFolderArchive(TeamFolderArchiveArg teamFolderArchiveArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamFolderArchiveLaunch) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/archive", teamFolderArchiveArg, false, TeamFolderArchiveArg.Serializer.INSTANCE, TeamFolderArchiveLaunch.Serializer.INSTANCE, TeamFolderArchiveError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamFolderArchiveErrorException("2/team/team_folder/archive", e.getRequestId(), e.getUserMessage(), (TeamFolderArchiveError) e.getErrorValue());
        }
    }

    public TeamFolderArchiveLaunch teamFolderArchive(String str) throws DbxException {
        return teamFolderArchive(new TeamFolderArchiveArg(str));
    }

    public TeamFolderArchiveLaunch teamFolderArchive(String str, boolean z) throws DbxException {
        return teamFolderArchive(new TeamFolderArchiveArg(str, z));
    }

    TeamFolderArchiveJobStatus teamFolderArchiveCheck(PollArg pollArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamFolderArchiveJobStatus) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/archive/check", pollArg, false, PollArg.Serializer.INSTANCE, TeamFolderArchiveJobStatus.Serializer.INSTANCE, PollError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new PollErrorException("2/team/team_folder/archive/check", e.getRequestId(), e.getUserMessage(), (PollError) e.getErrorValue());
        }
    }

    public TeamFolderArchiveJobStatus teamFolderArchiveCheck(String str) throws DbxException {
        return teamFolderArchiveCheck(new PollArg(str));
    }

    TeamFolderMetadata teamFolderCreate(TeamFolderCreateArg teamFolderCreateArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamFolderMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/create", teamFolderCreateArg, false, TeamFolderCreateArg.Serializer.INSTANCE, TeamFolderMetadata.Serializer.INSTANCE, TeamFolderCreateError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamFolderCreateErrorException("2/team/team_folder/create", e.getRequestId(), e.getUserMessage(), (TeamFolderCreateError) e.getErrorValue());
        }
    }

    public TeamFolderMetadata teamFolderCreate(String str) throws DbxException {
        return teamFolderCreate(new TeamFolderCreateArg(str));
    }

    public TeamFolderMetadata teamFolderCreate(String str, SyncSettingArg syncSettingArg) throws DbxException {
        return teamFolderCreate(new TeamFolderCreateArg(str, syncSettingArg));
    }

    List<TeamFolderGetInfoItem> teamFolderGetInfo(TeamFolderIdListArg teamFolderIdListArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (List) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/get_info", teamFolderIdListArg, false, TeamFolderIdListArg.Serializer.INSTANCE, StoneSerializers.list(TeamFolderGetInfoItem.Serializer.INSTANCE), StoneSerializers.void_());
        } catch (DbxWrappedException e) {
            throw new DbxApiException(e.getRequestId(), e.getUserMessage(), "Unexpected error response for \"team_folder/get_info\":" + e.getErrorValue());
        }
    }

    public List<TeamFolderGetInfoItem> teamFolderGetInfo(List<String> list) throws DbxException {
        return teamFolderGetInfo(new TeamFolderIdListArg(list));
    }

    TeamFolderListResult teamFolderList(TeamFolderListArg teamFolderListArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamFolderListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/list", teamFolderListArg, false, TeamFolderListArg.Serializer.INSTANCE, TeamFolderListResult.Serializer.INSTANCE, TeamFolderListError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamFolderListErrorException("2/team/team_folder/list", e.getRequestId(), e.getUserMessage(), (TeamFolderListError) e.getErrorValue());
        }
    }

    public TeamFolderListResult teamFolderList() throws DbxException {
        return teamFolderList(new TeamFolderListArg());
    }

    public TeamFolderListResult teamFolderList(long j) throws DbxException {
        if (j < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (j > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        return teamFolderList(new TeamFolderListArg(j));
    }

    TeamFolderListResult teamFolderListContinue(TeamFolderListContinueArg teamFolderListContinueArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamFolderListResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/list/continue", teamFolderListContinueArg, false, TeamFolderListContinueArg.Serializer.INSTANCE, TeamFolderListResult.Serializer.INSTANCE, TeamFolderListContinueError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamFolderListContinueErrorException("2/team/team_folder/list/continue", e.getRequestId(), e.getUserMessage(), (TeamFolderListContinueError) e.getErrorValue());
        }
    }

    public TeamFolderListResult teamFolderListContinue(String str) throws DbxException {
        return teamFolderListContinue(new TeamFolderListContinueArg(str));
    }

    void teamFolderPermanentlyDelete(TeamFolderIdArg teamFolderIdArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/permanently_delete", teamFolderIdArg, false, TeamFolderIdArg.Serializer.INSTANCE, StoneSerializers.void_(), TeamFolderPermanentlyDeleteError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamFolderPermanentlyDeleteErrorException("2/team/team_folder/permanently_delete", e.getRequestId(), e.getUserMessage(), (TeamFolderPermanentlyDeleteError) e.getErrorValue());
        }
    }

    public void teamFolderPermanentlyDelete(String str) throws DbxException {
        teamFolderPermanentlyDelete(new TeamFolderIdArg(str));
    }

    TeamFolderMetadata teamFolderRename(TeamFolderRenameArg teamFolderRenameArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamFolderMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/rename", teamFolderRenameArg, false, TeamFolderRenameArg.Serializer.INSTANCE, TeamFolderMetadata.Serializer.INSTANCE, TeamFolderRenameError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamFolderRenameErrorException("2/team/team_folder/rename", e.getRequestId(), e.getUserMessage(), (TeamFolderRenameError) e.getErrorValue());
        }
    }

    public TeamFolderMetadata teamFolderRename(String str, String str2) throws DbxException {
        return teamFolderRename(new TeamFolderRenameArg(str, str2));
    }

    TeamFolderMetadata teamFolderUpdateSyncSettings(TeamFolderUpdateSyncSettingsArg teamFolderUpdateSyncSettingsArg) throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TeamFolderMetadata) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/team_folder/update_sync_settings", teamFolderUpdateSyncSettingsArg, false, TeamFolderUpdateSyncSettingsArg.Serializer.INSTANCE, TeamFolderMetadata.Serializer.INSTANCE, TeamFolderUpdateSyncSettingsError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TeamFolderUpdateSyncSettingsErrorException("2/team/team_folder/update_sync_settings", e.getRequestId(), e.getUserMessage(), (TeamFolderUpdateSyncSettingsError) e.getErrorValue());
        }
    }

    public TeamFolderMetadata teamFolderUpdateSyncSettings(String str) throws DbxException {
        return teamFolderUpdateSyncSettings(new TeamFolderUpdateSyncSettingsArg(str));
    }

    public TeamFolderUpdateSyncSettingsBuilder teamFolderUpdateSyncSettingsBuilder(String str) {
        return new TeamFolderUpdateSyncSettingsBuilder(this, TeamFolderUpdateSyncSettingsArg.newBuilder(str));
    }

    public TokenGetAuthenticatedAdminResult tokenGetAuthenticatedAdmin() throws DbxException {
        try {
            DbxRawClientV2 dbxRawClientV2 = this.client;
            return (TokenGetAuthenticatedAdminResult) dbxRawClientV2.rpcStyle(dbxRawClientV2.getHost().getApi(), "2/team/token/get_authenticated_admin", null, false, StoneSerializers.void_(), TokenGetAuthenticatedAdminResult.Serializer.INSTANCE, TokenGetAuthenticatedAdminError.Serializer.INSTANCE);
        } catch (DbxWrappedException e) {
            throw new TokenGetAuthenticatedAdminErrorException("2/team/token/get_authenticated_admin", e.getRequestId(), e.getUserMessage(), (TokenGetAuthenticatedAdminError) e.getErrorValue());
        }
    }
}
