package com.dropbox.core.p013v2.teamlog;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.compose.material.TextFieldImplKt;
import androidx.compose.p004ui.spatial.RectListKt;
import androidx.compose.runtime.GapComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import androidx.media3.extractor.p007ts.PsExtractor;
import androidx.media3.extractor.p007ts.TsExtractor;
import androidx.window.core.layout.WindowSizeClass;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.location.LocationRequest;
import com.myscript.nebo.p022ai.presentation.compose.AIContainerViewModel;
import com.pdftron.pdf.pdfa.PDFACompliance;
import com.revenuecat.purchases.p036ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.p036ui.revenuecatui.components.WorkflowTransitionState;
import com.yalantis.ucrop.UCrop;
import java.io.IOException;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.p041ws.WebSocketProtocol;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.http.HttpStatus;
import org.joda.time.DateTimeConstants;

/* JADX INFO: loaded from: classes5.dex */
public enum EventTypeArg {
    ADMIN_ALERTING_ALERT_STATE_CHANGED,
    ADMIN_ALERTING_CHANGED_ALERT_CONFIG,
    ADMIN_ALERTING_TRIGGERED_ALERT,
    RANSOMWARE_RESTORE_PROCESS_COMPLETED,
    RANSOMWARE_RESTORE_PROCESS_STARTED,
    APP_BLOCKED_BY_PERMISSIONS,
    APP_LINK_TEAM,
    APP_LINK_USER,
    APP_UNLINK_TEAM,
    APP_UNLINK_USER,
    INTEGRATION_CONNECTED,
    INTEGRATION_DISCONNECTED,
    FILE_ADD_COMMENT,
    FILE_CHANGE_COMMENT_SUBSCRIPTION,
    FILE_DELETE_COMMENT,
    FILE_EDIT_COMMENT,
    FILE_LIKE_COMMENT,
    FILE_RESOLVE_COMMENT,
    FILE_UNLIKE_COMMENT,
    FILE_UNRESOLVE_COMMENT,
    GOVERNANCE_POLICY_ADD_FOLDERS,
    GOVERNANCE_POLICY_ADD_FOLDER_FAILED,
    GOVERNANCE_POLICY_CONTENT_DISPOSED,
    GOVERNANCE_POLICY_CREATE,
    GOVERNANCE_POLICY_DELETE,
    GOVERNANCE_POLICY_EDIT_DETAILS,
    GOVERNANCE_POLICY_EDIT_DURATION,
    GOVERNANCE_POLICY_EXPORT_CREATED,
    GOVERNANCE_POLICY_EXPORT_REMOVED,
    GOVERNANCE_POLICY_REMOVE_FOLDERS,
    GOVERNANCE_POLICY_REPORT_CREATED,
    GOVERNANCE_POLICY_ZIP_PART_DOWNLOADED,
    LEGAL_HOLDS_ACTIVATE_A_HOLD,
    LEGAL_HOLDS_ADD_MEMBERS,
    LEGAL_HOLDS_CHANGE_HOLD_DETAILS,
    LEGAL_HOLDS_CHANGE_HOLD_NAME,
    LEGAL_HOLDS_EXPORT_A_HOLD,
    LEGAL_HOLDS_EXPORT_CANCELLED,
    LEGAL_HOLDS_EXPORT_DOWNLOADED,
    LEGAL_HOLDS_EXPORT_REMOVED,
    LEGAL_HOLDS_RELEASE_A_HOLD,
    LEGAL_HOLDS_REMOVE_MEMBERS,
    LEGAL_HOLDS_REPORT_A_HOLD,
    DEVICE_CHANGE_IP_DESKTOP,
    DEVICE_CHANGE_IP_MOBILE,
    DEVICE_CHANGE_IP_WEB,
    DEVICE_DELETE_ON_UNLINK_FAIL,
    DEVICE_DELETE_ON_UNLINK_SUCCESS,
    DEVICE_LINK_FAIL,
    DEVICE_LINK_SUCCESS,
    DEVICE_MANAGEMENT_DISABLED,
    DEVICE_MANAGEMENT_ENABLED,
    DEVICE_SYNC_BACKUP_STATUS_CHANGED,
    DEVICE_UNLINK,
    DROPBOX_PASSWORDS_EXPORTED,
    DROPBOX_PASSWORDS_NEW_DEVICE_ENROLLED,
    EMM_REFRESH_AUTH_TOKEN,
    EXTERNAL_DRIVE_BACKUP_ELIGIBILITY_STATUS_CHECKED,
    EXTERNAL_DRIVE_BACKUP_STATUS_CHANGED,
    ACCOUNT_CAPTURE_CHANGE_AVAILABILITY,
    ACCOUNT_CAPTURE_MIGRATE_ACCOUNT,
    ACCOUNT_CAPTURE_NOTIFICATION_EMAILS_SENT,
    ACCOUNT_CAPTURE_RELINQUISH_ACCOUNT,
    DISABLED_DOMAIN_INVITES,
    DOMAIN_INVITES_APPROVE_REQUEST_TO_JOIN_TEAM,
    DOMAIN_INVITES_DECLINE_REQUEST_TO_JOIN_TEAM,
    DOMAIN_INVITES_EMAIL_EXISTING_USERS,
    DOMAIN_INVITES_REQUEST_TO_JOIN_TEAM,
    DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_NO,
    DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_YES,
    DOMAIN_VERIFICATION_ADD_DOMAIN_FAIL,
    DOMAIN_VERIFICATION_ADD_DOMAIN_SUCCESS,
    DOMAIN_VERIFICATION_REMOVE_DOMAIN,
    ENABLED_DOMAIN_INVITES,
    TEAM_ENCRYPTION_KEY_CANCEL_KEY_DELETION,
    TEAM_ENCRYPTION_KEY_CREATE_KEY,
    TEAM_ENCRYPTION_KEY_DELETE_KEY,
    TEAM_ENCRYPTION_KEY_DISABLE_KEY,
    TEAM_ENCRYPTION_KEY_ENABLE_KEY,
    TEAM_ENCRYPTION_KEY_ROTATE_KEY,
    TEAM_ENCRYPTION_KEY_SCHEDULE_KEY_DELETION,
    APPLY_NAMING_CONVENTION,
    CREATE_FOLDER,
    FILE_ADD,
    FILE_ADD_FROM_AUTOMATION,
    FILE_COPY,
    FILE_DELETE,
    FILE_DOWNLOAD,
    FILE_EDIT,
    FILE_GET_COPY_REFERENCE,
    FILE_LOCKING_LOCK_STATUS_CHANGED,
    FILE_MOVE,
    FILE_PERMANENTLY_DELETE,
    FILE_PREVIEW,
    FILE_RENAME,
    FILE_RESTORE,
    FILE_REVERT,
    FILE_ROLLBACK_CHANGES,
    FILE_SAVE_COPY_REFERENCE,
    FOLDER_OVERVIEW_DESCRIPTION_CHANGED,
    FOLDER_OVERVIEW_ITEM_PINNED,
    FOLDER_OVERVIEW_ITEM_UNPINNED,
    OBJECT_LABEL_ADDED,
    OBJECT_LABEL_REMOVED,
    OBJECT_LABEL_UPDATED_VALUE,
    ORGANIZE_FOLDER_WITH_TIDY,
    REPLAY_FILE_DELETE,
    REWIND_FOLDER,
    UNDO_NAMING_CONVENTION,
    UNDO_ORGANIZE_FOLDER_WITH_TIDY,
    USER_TAGS_ADDED,
    USER_TAGS_REMOVED,
    EMAIL_INGEST_RECEIVE_FILE,
    FILE_REQUEST_CHANGE,
    FILE_REQUEST_CLOSE,
    FILE_REQUEST_CREATE,
    FILE_REQUEST_DELETE,
    FILE_REQUEST_RECEIVE_FILE,
    GROUP_ADD_EXTERNAL_ID,
    GROUP_ADD_MEMBER,
    GROUP_CHANGE_EXTERNAL_ID,
    GROUP_CHANGE_MANAGEMENT_TYPE,
    GROUP_CHANGE_MEMBER_ROLE,
    GROUP_CREATE,
    GROUP_DELETE,
    GROUP_DESCRIPTION_UPDATED,
    GROUP_JOIN_POLICY_UPDATED,
    GROUP_MOVED,
    GROUP_REMOVE_EXTERNAL_ID,
    GROUP_REMOVE_MEMBER,
    GROUP_RENAME,
    ACCOUNT_LOCK_OR_UNLOCKED,
    EMM_ERROR,
    GUEST_ADMIN_SIGNED_IN_VIA_TRUSTED_TEAMS,
    GUEST_ADMIN_SIGNED_OUT_VIA_TRUSTED_TEAMS,
    LOGIN_FAIL,
    LOGIN_SUCCESS,
    LOGOUT,
    RESELLER_SUPPORT_SESSION_END,
    RESELLER_SUPPORT_SESSION_START,
    SIGN_IN_AS_SESSION_END,
    SIGN_IN_AS_SESSION_START,
    SSO_ERROR,
    BACKUP_ADMIN_INVITATION_SENT,
    BACKUP_INVITATION_OPENED,
    CREATE_TEAM_INVITE_LINK,
    DELETE_TEAM_INVITE_LINK,
    MEMBER_ADD_EXTERNAL_ID,
    MEMBER_ADD_NAME,
    MEMBER_CHANGE_ADMIN_ROLE,
    MEMBER_CHANGE_EMAIL,
    MEMBER_CHANGE_EXTERNAL_ID,
    MEMBER_CHANGE_MEMBERSHIP_TYPE,
    MEMBER_CHANGE_NAME,
    MEMBER_CHANGE_RESELLER_ROLE,
    MEMBER_CHANGE_STATUS,
    MEMBER_DELETE_MANUAL_CONTACTS,
    MEMBER_DELETE_PROFILE_PHOTO,
    MEMBER_PERMANENTLY_DELETE_ACCOUNT_CONTENTS,
    MEMBER_REMOVE_EXTERNAL_ID,
    MEMBER_SET_PROFILE_PHOTO,
    MEMBER_SPACE_LIMITS_ADD_CUSTOM_QUOTA,
    MEMBER_SPACE_LIMITS_CHANGE_CUSTOM_QUOTA,
    MEMBER_SPACE_LIMITS_CHANGE_STATUS,
    MEMBER_SPACE_LIMITS_REMOVE_CUSTOM_QUOTA,
    MEMBER_SUGGEST,
    MEMBER_TRANSFER_ACCOUNT_CONTENTS,
    PENDING_SECONDARY_EMAIL_ADDED,
    SECONDARY_EMAIL_DELETED,
    SECONDARY_EMAIL_VERIFIED,
    SECONDARY_MAILS_POLICY_CHANGED,
    BINDER_ADD_PAGE,
    BINDER_ADD_SECTION,
    BINDER_REMOVE_PAGE,
    BINDER_REMOVE_SECTION,
    BINDER_RENAME_PAGE,
    BINDER_RENAME_SECTION,
    BINDER_REORDER_PAGE,
    BINDER_REORDER_SECTION,
    PAPER_CONTENT_ADD_MEMBER,
    PAPER_CONTENT_ADD_TO_FOLDER,
    PAPER_CONTENT_ARCHIVE,
    PAPER_CONTENT_CREATE,
    PAPER_CONTENT_PERMANENTLY_DELETE,
    PAPER_CONTENT_REMOVE_FROM_FOLDER,
    PAPER_CONTENT_REMOVE_MEMBER,
    PAPER_CONTENT_RENAME,
    PAPER_CONTENT_RESTORE,
    PAPER_DOC_ADD_COMMENT,
    PAPER_DOC_CHANGE_MEMBER_ROLE,
    PAPER_DOC_CHANGE_SHARING_POLICY,
    PAPER_DOC_CHANGE_SUBSCRIPTION,
    PAPER_DOC_DELETED,
    PAPER_DOC_DELETE_COMMENT,
    PAPER_DOC_DOWNLOAD,
    PAPER_DOC_EDIT,
    PAPER_DOC_EDIT_COMMENT,
    PAPER_DOC_FOLLOWED,
    PAPER_DOC_MENTION,
    PAPER_DOC_OWNERSHIP_CHANGED,
    PAPER_DOC_REQUEST_ACCESS,
    PAPER_DOC_RESOLVE_COMMENT,
    PAPER_DOC_REVERT,
    PAPER_DOC_SLACK_SHARE,
    PAPER_DOC_TEAM_INVITE,
    PAPER_DOC_TRASHED,
    PAPER_DOC_UNRESOLVE_COMMENT,
    PAPER_DOC_UNTRASHED,
    PAPER_DOC_VIEW,
    PAPER_EXTERNAL_VIEW_ALLOW,
    PAPER_EXTERNAL_VIEW_DEFAULT_TEAM,
    PAPER_EXTERNAL_VIEW_FORBID,
    PAPER_FOLDER_CHANGE_SUBSCRIPTION,
    PAPER_FOLDER_DELETED,
    PAPER_FOLDER_FOLLOWED,
    PAPER_FOLDER_TEAM_INVITE,
    PAPER_PUBLISHED_LINK_CHANGE_PERMISSION,
    PAPER_PUBLISHED_LINK_CREATE,
    PAPER_PUBLISHED_LINK_DISABLED,
    PAPER_PUBLISHED_LINK_VIEW,
    PASSWORD_CHANGE,
    PASSWORD_RESET,
    PASSWORD_RESET_ALL,
    CLASSIFICATION_CREATE_REPORT,
    CLASSIFICATION_CREATE_REPORT_FAIL,
    EMM_CREATE_EXCEPTIONS_REPORT,
    EMM_CREATE_USAGE_REPORT,
    EXPORT_MEMBERS_REPORT,
    EXPORT_MEMBERS_REPORT_FAIL,
    EXTERNAL_SHARING_CREATE_REPORT,
    EXTERNAL_SHARING_REPORT_FAILED,
    NO_EXPIRATION_LINK_GEN_CREATE_REPORT,
    NO_EXPIRATION_LINK_GEN_REPORT_FAILED,
    NO_PASSWORD_LINK_GEN_CREATE_REPORT,
    NO_PASSWORD_LINK_GEN_REPORT_FAILED,
    NO_PASSWORD_LINK_VIEW_CREATE_REPORT,
    NO_PASSWORD_LINK_VIEW_REPORT_FAILED,
    OUTDATED_LINK_VIEW_CREATE_REPORT,
    OUTDATED_LINK_VIEW_REPORT_FAILED,
    PAPER_ADMIN_EXPORT_START,
    RANSOMWARE_ALERT_CREATE_REPORT,
    RANSOMWARE_ALERT_CREATE_REPORT_FAILED,
    SMART_SYNC_CREATE_ADMIN_PRIVILEGE_REPORT,
    TEAM_ACTIVITY_CREATE_REPORT,
    TEAM_ACTIVITY_CREATE_REPORT_FAIL,
    COLLECTION_SHARE,
    FILE_TRANSFERS_FILE_ADD,
    FILE_TRANSFERS_TRANSFER_DELETE,
    FILE_TRANSFERS_TRANSFER_DOWNLOAD,
    FILE_TRANSFERS_TRANSFER_SEND,
    FILE_TRANSFERS_TRANSFER_VIEW,
    NOTE_ACL_INVITE_ONLY,
    NOTE_ACL_LINK,
    NOTE_ACL_TEAM_LINK,
    NOTE_SHARED,
    NOTE_SHARE_RECEIVE,
    OPEN_NOTE_SHARED,
    REPLAY_FILE_SHARED_LINK_CREATED,
    REPLAY_FILE_SHARED_LINK_MODIFIED,
    REPLAY_PROJECT_TEAM_ADD,
    REPLAY_PROJECT_TEAM_DELETE,
    SF_ADD_GROUP,
    SF_ALLOW_NON_MEMBERS_TO_VIEW_SHARED_LINKS,
    SF_EXTERNAL_INVITE_WARN,
    SF_FB_INVITE,
    SF_FB_INVITE_CHANGE_ROLE,
    SF_FB_UNINVITE,
    SF_INVITE_GROUP,
    SF_TEAM_GRANT_ACCESS,
    SF_TEAM_INVITE,
    SF_TEAM_INVITE_CHANGE_ROLE,
    SF_TEAM_JOIN,
    SF_TEAM_JOIN_FROM_OOB_LINK,
    SF_TEAM_UNINVITE,
    SHARED_CONTENT_ADD_INVITEES,
    SHARED_CONTENT_ADD_LINK_EXPIRY,
    SHARED_CONTENT_ADD_LINK_PASSWORD,
    SHARED_CONTENT_ADD_MEMBER,
    SHARED_CONTENT_CHANGE_DOWNLOADS_POLICY,
    SHARED_CONTENT_CHANGE_INVITEE_ROLE,
    SHARED_CONTENT_CHANGE_LINK_AUDIENCE,
    SHARED_CONTENT_CHANGE_LINK_EXPIRY,
    SHARED_CONTENT_CHANGE_LINK_PASSWORD,
    SHARED_CONTENT_CHANGE_MEMBER_ROLE,
    SHARED_CONTENT_CHANGE_VIEWER_INFO_POLICY,
    SHARED_CONTENT_CLAIM_INVITATION,
    SHARED_CONTENT_COPY,
    SHARED_CONTENT_DOWNLOAD,
    SHARED_CONTENT_RELINQUISH_MEMBERSHIP,
    SHARED_CONTENT_REMOVE_INVITEES,
    SHARED_CONTENT_REMOVE_LINK_EXPIRY,
    SHARED_CONTENT_REMOVE_LINK_PASSWORD,
    SHARED_CONTENT_REMOVE_MEMBER,
    SHARED_CONTENT_REQUEST_ACCESS,
    SHARED_CONTENT_RESTORE_INVITEES,
    SHARED_CONTENT_RESTORE_MEMBER,
    SHARED_CONTENT_UNSHARE,
    SHARED_CONTENT_VIEW,
    SHARED_FOLDER_CHANGE_LINK_POLICY,
    SHARED_FOLDER_CHANGE_MEMBERS_INHERITANCE_POLICY,
    SHARED_FOLDER_CHANGE_MEMBERS_MANAGEMENT_POLICY,
    SHARED_FOLDER_CHANGE_MEMBERS_POLICY,
    SHARED_FOLDER_CREATE,
    SHARED_FOLDER_DECLINE_INVITATION,
    SHARED_FOLDER_MOUNT,
    SHARED_FOLDER_NEST,
    SHARED_FOLDER_TRANSFER_OWNERSHIP,
    SHARED_FOLDER_UNMOUNT,
    SHARED_LINK_ADD_EXPIRY,
    SHARED_LINK_CHANGE_EXPIRY,
    SHARED_LINK_CHANGE_VISIBILITY,
    SHARED_LINK_COPY,
    SHARED_LINK_CREATE,
    SHARED_LINK_DISABLE,
    SHARED_LINK_DOWNLOAD,
    SHARED_LINK_REMOVE_EXPIRY,
    SHARED_LINK_SETTINGS_ADD_EXPIRATION,
    SHARED_LINK_SETTINGS_ADD_PASSWORD,
    SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_DISABLED,
    SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_ENABLED,
    SHARED_LINK_SETTINGS_CHANGE_AUDIENCE,
    SHARED_LINK_SETTINGS_CHANGE_EXPIRATION,
    SHARED_LINK_SETTINGS_CHANGE_PASSWORD,
    SHARED_LINK_SETTINGS_REMOVE_EXPIRATION,
    SHARED_LINK_SETTINGS_REMOVE_PASSWORD,
    SHARED_LINK_SHARE,
    SHARED_LINK_VIEW,
    SHARED_NOTE_OPENED,
    SHMODEL_DISABLE_DOWNLOADS,
    SHMODEL_ENABLE_DOWNLOADS,
    SHMODEL_GROUP_SHARE,
    SHOWCASE_ACCESS_GRANTED,
    SHOWCASE_ADD_MEMBER,
    SHOWCASE_ARCHIVED,
    SHOWCASE_CREATED,
    SHOWCASE_DELETE_COMMENT,
    SHOWCASE_EDITED,
    SHOWCASE_EDIT_COMMENT,
    SHOWCASE_FILE_ADDED,
    SHOWCASE_FILE_DOWNLOAD,
    SHOWCASE_FILE_REMOVED,
    SHOWCASE_FILE_VIEW,
    SHOWCASE_PERMANENTLY_DELETED,
    SHOWCASE_POST_COMMENT,
    SHOWCASE_REMOVE_MEMBER,
    SHOWCASE_RENAMED,
    SHOWCASE_REQUEST_ACCESS,
    SHOWCASE_RESOLVE_COMMENT,
    SHOWCASE_RESTORED,
    SHOWCASE_TRASHED,
    SHOWCASE_TRASHED_DEPRECATED,
    SHOWCASE_UNRESOLVE_COMMENT,
    SHOWCASE_UNTRASHED,
    SHOWCASE_UNTRASHED_DEPRECATED,
    SHOWCASE_VIEW,
    SSO_ADD_CERT,
    SSO_ADD_LOGIN_URL,
    SSO_ADD_LOGOUT_URL,
    SSO_CHANGE_CERT,
    SSO_CHANGE_LOGIN_URL,
    SSO_CHANGE_LOGOUT_URL,
    SSO_CHANGE_SAML_IDENTITY_MODE,
    SSO_REMOVE_CERT,
    SSO_REMOVE_LOGIN_URL,
    SSO_REMOVE_LOGOUT_URL,
    TEAM_FOLDER_CHANGE_STATUS,
    TEAM_FOLDER_CREATE,
    TEAM_FOLDER_DOWNGRADE,
    TEAM_FOLDER_PERMANENTLY_DELETE,
    TEAM_FOLDER_RENAME,
    TEAM_SELECTIVE_SYNC_SETTINGS_CHANGED,
    ACCOUNT_CAPTURE_CHANGE_POLICY,
    ADMIN_EMAIL_REMINDERS_CHANGED,
    ALLOW_DOWNLOAD_DISABLED,
    ALLOW_DOWNLOAD_ENABLED,
    APP_PERMISSIONS_CHANGED,
    CAMERA_UPLOADS_POLICY_CHANGED,
    CAPTURE_TRANSCRIPT_POLICY_CHANGED,
    CLASSIFICATION_CHANGE_POLICY,
    COMPUTER_BACKUP_POLICY_CHANGED,
    CONTENT_ADMINISTRATION_POLICY_CHANGED,
    DATA_PLACEMENT_RESTRICTION_CHANGE_POLICY,
    DATA_PLACEMENT_RESTRICTION_SATISFY_POLICY,
    DEVICE_APPROVALS_ADD_EXCEPTION,
    DEVICE_APPROVALS_CHANGE_DESKTOP_POLICY,
    DEVICE_APPROVALS_CHANGE_MOBILE_POLICY,
    DEVICE_APPROVALS_CHANGE_OVERAGE_ACTION,
    DEVICE_APPROVALS_CHANGE_UNLINK_ACTION,
    DEVICE_APPROVALS_REMOVE_EXCEPTION,
    DIRECTORY_RESTRICTIONS_ADD_MEMBERS,
    DIRECTORY_RESTRICTIONS_REMOVE_MEMBERS,
    DROPBOX_PASSWORDS_POLICY_CHANGED,
    EMAIL_INGEST_POLICY_CHANGED,
    EMM_ADD_EXCEPTION,
    EMM_CHANGE_POLICY,
    EMM_REMOVE_EXCEPTION,
    EXTENDED_VERSION_HISTORY_CHANGE_POLICY,
    EXTERNAL_DRIVE_BACKUP_POLICY_CHANGED,
    FILE_COMMENTS_CHANGE_POLICY,
    FILE_LOCKING_POLICY_CHANGED,
    FILE_PROVIDER_MIGRATION_POLICY_CHANGED,
    FILE_REQUESTS_CHANGE_POLICY,
    FILE_REQUESTS_EMAILS_ENABLED,
    FILE_REQUESTS_EMAILS_RESTRICTED_TO_TEAM_ONLY,
    FILE_TRANSFERS_POLICY_CHANGED,
    FOLDER_LINK_RESTRICTION_POLICY_CHANGED,
    GOOGLE_SSO_CHANGE_POLICY,
    GROUP_USER_MANAGEMENT_CHANGE_POLICY,
    INTEGRATION_POLICY_CHANGED,
    INVITE_ACCEPTANCE_EMAIL_POLICY_CHANGED,
    MEMBER_REQUESTS_CHANGE_POLICY,
    MEMBER_SEND_INVITE_POLICY_CHANGED,
    MEMBER_SPACE_LIMITS_ADD_EXCEPTION,
    MEMBER_SPACE_LIMITS_CHANGE_CAPS_TYPE_POLICY,
    MEMBER_SPACE_LIMITS_CHANGE_POLICY,
    MEMBER_SPACE_LIMITS_REMOVE_EXCEPTION,
    MEMBER_SUGGESTIONS_CHANGE_POLICY,
    MICROSOFT_OFFICE_ADDIN_CHANGE_POLICY,
    NETWORK_CONTROL_CHANGE_POLICY,
    PAPER_CHANGE_DEPLOYMENT_POLICY,
    PAPER_CHANGE_MEMBER_LINK_POLICY,
    PAPER_CHANGE_MEMBER_POLICY,
    PAPER_CHANGE_POLICY,
    PAPER_DEFAULT_FOLDER_POLICY_CHANGED,
    PAPER_DESKTOP_POLICY_CHANGED,
    PAPER_ENABLED_USERS_GROUP_ADDITION,
    PAPER_ENABLED_USERS_GROUP_REMOVAL,
    PASSWORD_STRENGTH_REQUIREMENTS_CHANGE_POLICY,
    PERMANENT_DELETE_CHANGE_POLICY,
    RESELLER_SUPPORT_CHANGE_POLICY,
    REWIND_POLICY_CHANGED,
    SEND_FOR_SIGNATURE_POLICY_CHANGED,
    SHARING_CHANGE_FOLDER_JOIN_POLICY,
    SHARING_CHANGE_LINK_ALLOW_CHANGE_EXPIRATION_POLICY,
    SHARING_CHANGE_LINK_DEFAULT_EXPIRATION_POLICY,
    SHARING_CHANGE_LINK_ENFORCE_PASSWORD_POLICY,
    SHARING_CHANGE_LINK_POLICY,
    SHARING_CHANGE_MEMBER_POLICY,
    SHOWCASE_CHANGE_DOWNLOAD_POLICY,
    SHOWCASE_CHANGE_ENABLED_POLICY,
    SHOWCASE_CHANGE_EXTERNAL_SHARING_POLICY,
    SMARTER_SMART_SYNC_POLICY_CHANGED,
    SMART_SYNC_CHANGE_POLICY,
    SMART_SYNC_NOT_OPT_OUT,
    SMART_SYNC_OPT_OUT,
    SSO_CHANGE_POLICY,
    TEAM_BRANDING_POLICY_CHANGED,
    TEAM_EXTENSIONS_POLICY_CHANGED,
    TEAM_SELECTIVE_SYNC_POLICY_CHANGED,
    TEAM_SHARING_WHITELIST_SUBJECTS_CHANGED,
    TFA_ADD_EXCEPTION,
    TFA_CHANGE_POLICY,
    TFA_REMOVE_EXCEPTION,
    TWO_ACCOUNT_CHANGE_POLICY,
    VIEWER_INFO_POLICY_CHANGED,
    WATERMARKING_POLICY_CHANGED,
    WEB_SESSIONS_CHANGE_ACTIVE_SESSION_LIMIT,
    WEB_SESSIONS_CHANGE_FIXED_LENGTH_POLICY,
    WEB_SESSIONS_CHANGE_IDLE_LENGTH_POLICY,
    DATA_RESIDENCY_MIGRATION_REQUEST_SUCCESSFUL,
    DATA_RESIDENCY_MIGRATION_REQUEST_UNSUCCESSFUL,
    TEAM_MERGE_FROM,
    TEAM_MERGE_TO,
    TEAM_PROFILE_ADD_BACKGROUND,
    TEAM_PROFILE_ADD_LOGO,
    TEAM_PROFILE_CHANGE_BACKGROUND,
    TEAM_PROFILE_CHANGE_DEFAULT_LANGUAGE,
    TEAM_PROFILE_CHANGE_LOGO,
    TEAM_PROFILE_CHANGE_NAME,
    TEAM_PROFILE_REMOVE_BACKGROUND,
    TEAM_PROFILE_REMOVE_LOGO,
    TFA_ADD_BACKUP_PHONE,
    TFA_ADD_SECURITY_KEY,
    TFA_CHANGE_BACKUP_PHONE,
    TFA_CHANGE_STATUS,
    TFA_REMOVE_BACKUP_PHONE,
    TFA_REMOVE_SECURITY_KEY,
    TFA_RESET,
    CHANGED_ENTERPRISE_ADMIN_ROLE,
    CHANGED_ENTERPRISE_CONNECTED_TEAM_STATUS,
    ENDED_ENTERPRISE_ADMIN_SESSION,
    ENDED_ENTERPRISE_ADMIN_SESSION_DEPRECATED,
    ENTERPRISE_SETTINGS_LOCKING,
    GUEST_ADMIN_CHANGE_STATUS,
    STARTED_ENTERPRISE_ADMIN_SESSION,
    TEAM_MERGE_REQUEST_ACCEPTED,
    TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_PRIMARY_TEAM,
    TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_SECONDARY_TEAM,
    TEAM_MERGE_REQUEST_AUTO_CANCELED,
    TEAM_MERGE_REQUEST_CANCELED,
    TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_PRIMARY_TEAM,
    TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_SECONDARY_TEAM,
    TEAM_MERGE_REQUEST_EXPIRED,
    TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_PRIMARY_TEAM,
    TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_SECONDARY_TEAM,
    TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_PRIMARY_TEAM,
    TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_SECONDARY_TEAM,
    TEAM_MERGE_REQUEST_REMINDER,
    TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_PRIMARY_TEAM,
    TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_SECONDARY_TEAM,
    TEAM_MERGE_REQUEST_REVOKED,
    TEAM_MERGE_REQUEST_SENT_SHOWN_TO_PRIMARY_TEAM,
    TEAM_MERGE_REQUEST_SENT_SHOWN_TO_SECONDARY_TEAM,
    OTHER;

    static class Serializer extends UnionSerializer<EventTypeArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(EventTypeArg eventTypeArg, JsonGenerator jsonGenerator) throws IOException {
            switch (C44671.$SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[eventTypeArg.ordinal()]) {
                case 1:
                    jsonGenerator.writeString("admin_alerting_alert_state_changed");
                    break;
                case 2:
                    jsonGenerator.writeString("admin_alerting_changed_alert_config");
                    break;
                case 3:
                    jsonGenerator.writeString("admin_alerting_triggered_alert");
                    break;
                case 4:
                    jsonGenerator.writeString("ransomware_restore_process_completed");
                    break;
                case 5:
                    jsonGenerator.writeString("ransomware_restore_process_started");
                    break;
                case 6:
                    jsonGenerator.writeString("app_blocked_by_permissions");
                    break;
                case 7:
                    jsonGenerator.writeString("app_link_team");
                    break;
                case 8:
                    jsonGenerator.writeString("app_link_user");
                    break;
                case 9:
                    jsonGenerator.writeString("app_unlink_team");
                    break;
                case 10:
                    jsonGenerator.writeString("app_unlink_user");
                    break;
                case 11:
                    jsonGenerator.writeString("integration_connected");
                    break;
                case 12:
                    jsonGenerator.writeString("integration_disconnected");
                    break;
                case 13:
                    jsonGenerator.writeString("file_add_comment");
                    break;
                case 14:
                    jsonGenerator.writeString("file_change_comment_subscription");
                    break;
                case 15:
                    jsonGenerator.writeString("file_delete_comment");
                    break;
                case 16:
                    jsonGenerator.writeString("file_edit_comment");
                    break;
                case 17:
                    jsonGenerator.writeString("file_like_comment");
                    break;
                case 18:
                    jsonGenerator.writeString("file_resolve_comment");
                    break;
                case 19:
                    jsonGenerator.writeString("file_unlike_comment");
                    break;
                case 20:
                    jsonGenerator.writeString("file_unresolve_comment");
                    break;
                case 21:
                    jsonGenerator.writeString("governance_policy_add_folders");
                    break;
                case 22:
                    jsonGenerator.writeString("governance_policy_add_folder_failed");
                    break;
                case 23:
                    jsonGenerator.writeString("governance_policy_content_disposed");
                    break;
                case 24:
                    jsonGenerator.writeString("governance_policy_create");
                    break;
                case 25:
                    jsonGenerator.writeString("governance_policy_delete");
                    break;
                case 26:
                    jsonGenerator.writeString("governance_policy_edit_details");
                    break;
                case 27:
                    jsonGenerator.writeString("governance_policy_edit_duration");
                    break;
                case 28:
                    jsonGenerator.writeString("governance_policy_export_created");
                    break;
                case 29:
                    jsonGenerator.writeString("governance_policy_export_removed");
                    break;
                case 30:
                    jsonGenerator.writeString("governance_policy_remove_folders");
                    break;
                case 31:
                    jsonGenerator.writeString("governance_policy_report_created");
                    break;
                case 32:
                    jsonGenerator.writeString("governance_policy_zip_part_downloaded");
                    break;
                case 33:
                    jsonGenerator.writeString("legal_holds_activate_a_hold");
                    break;
                case 34:
                    jsonGenerator.writeString("legal_holds_add_members");
                    break;
                case 35:
                    jsonGenerator.writeString("legal_holds_change_hold_details");
                    break;
                case 36:
                    jsonGenerator.writeString("legal_holds_change_hold_name");
                    break;
                case 37:
                    jsonGenerator.writeString("legal_holds_export_a_hold");
                    break;
                case 38:
                    jsonGenerator.writeString("legal_holds_export_cancelled");
                    break;
                case 39:
                    jsonGenerator.writeString("legal_holds_export_downloaded");
                    break;
                case 40:
                    jsonGenerator.writeString("legal_holds_export_removed");
                    break;
                case 41:
                    jsonGenerator.writeString("legal_holds_release_a_hold");
                    break;
                case 42:
                    jsonGenerator.writeString("legal_holds_remove_members");
                    break;
                case 43:
                    jsonGenerator.writeString("legal_holds_report_a_hold");
                    break;
                case 44:
                    jsonGenerator.writeString("device_change_ip_desktop");
                    break;
                case 45:
                    jsonGenerator.writeString("device_change_ip_mobile");
                    break;
                case 46:
                    jsonGenerator.writeString("device_change_ip_web");
                    break;
                case 47:
                    jsonGenerator.writeString("device_delete_on_unlink_fail");
                    break;
                case 48:
                    jsonGenerator.writeString("device_delete_on_unlink_success");
                    break;
                case 49:
                    jsonGenerator.writeString("device_link_fail");
                    break;
                case 50:
                    jsonGenerator.writeString("device_link_success");
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                    jsonGenerator.writeString("device_management_disabled");
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                    jsonGenerator.writeString("device_management_enabled");
                    break;
                case 53:
                    jsonGenerator.writeString("device_sync_backup_status_changed");
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                    jsonGenerator.writeString("device_unlink");
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    jsonGenerator.writeString("dropbox_passwords_exported");
                    break;
                case 56:
                    jsonGenerator.writeString("dropbox_passwords_new_device_enrolled");
                    break;
                case 57:
                    jsonGenerator.writeString("emm_refresh_auth_token");
                    break;
                case 58:
                    jsonGenerator.writeString("external_drive_backup_eligibility_status_checked");
                    break;
                case 59:
                    jsonGenerator.writeString("external_drive_backup_status_changed");
                    break;
                case 60:
                    jsonGenerator.writeString("account_capture_change_availability");
                    break;
                case 61:
                    jsonGenerator.writeString("account_capture_migrate_account");
                    break;
                case RectListKt.BitOffsetForGesturable /* 62 */:
                    jsonGenerator.writeString("account_capture_notification_emails_sent");
                    break;
                case 63:
                    jsonGenerator.writeString("account_capture_relinquish_account");
                    break;
                case 64:
                    jsonGenerator.writeString("disabled_domain_invites");
                    break;
                case 65:
                    jsonGenerator.writeString("domain_invites_approve_request_to_join_team");
                    break;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    jsonGenerator.writeString("domain_invites_decline_request_to_join_team");
                    break;
                case 67:
                    jsonGenerator.writeString("domain_invites_email_existing_users");
                    break;
                case 68:
                    jsonGenerator.writeString("domain_invites_request_to_join_team");
                    break;
                case UCrop.REQUEST_CROP /* 69 */:
                    jsonGenerator.writeString("domain_invites_set_invite_new_user_pref_to_no");
                    break;
                case 70:
                    jsonGenerator.writeString("domain_invites_set_invite_new_user_pref_to_yes");
                    break;
                case TsExtractor.TS_SYNC_BYTE /* 71 */:
                    jsonGenerator.writeString("domain_verification_add_domain_fail");
                    break;
                case 72:
                    jsonGenerator.writeString("domain_verification_add_domain_success");
                    break;
                case 73:
                    jsonGenerator.writeString("domain_verification_remove_domain");
                    break;
                case 74:
                    jsonGenerator.writeString("enabled_domain_invites");
                    break;
                case 75:
                    jsonGenerator.writeString("team_encryption_key_cancel_key_deletion");
                    break;
                case BaseNCodec.MIME_CHUNK_SIZE /* 76 */:
                    jsonGenerator.writeString("team_encryption_key_create_key");
                    break;
                case 77:
                    jsonGenerator.writeString("team_encryption_key_delete_key");
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_UNSIGNED_INT64 /* 78 */:
                    jsonGenerator.writeString("team_encryption_key_disable_key");
                    break;
                case 79:
                    jsonGenerator.writeString("team_encryption_key_enable_key");
                    break;
                case 80:
                    jsonGenerator.writeString("team_encryption_key_rotate_key");
                    break;
                case PDFACompliance.e_PDFA8_1 /* 81 */:
                    jsonGenerator.writeString("team_encryption_key_schedule_key_deletion");
                    break;
                case 82:
                    jsonGenerator.writeString("apply_naming_convention");
                    break;
                case 83:
                    jsonGenerator.writeString("create_folder");
                    break;
                case 84:
                    jsonGenerator.writeString("file_add");
                    break;
                case 85:
                    jsonGenerator.writeString("file_add_from_automation");
                    break;
                case 86:
                    jsonGenerator.writeString("file_copy");
                    break;
                case 87:
                    jsonGenerator.writeString("file_delete");
                    break;
                case 88:
                    jsonGenerator.writeString("file_download");
                    break;
                case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
                    jsonGenerator.writeString("file_edit");
                    break;
                case 90:
                    jsonGenerator.writeString("file_get_copy_reference");
                    break;
                case PDFACompliance.e_PDFA9_1 /* 91 */:
                    jsonGenerator.writeString("file_locking_lock_status_changed");
                    break;
                case PDFACompliance.e_PDFA9_2 /* 92 */:
                    jsonGenerator.writeString("file_move");
                    break;
                case PDFACompliance.e_PDFA9_3 /* 93 */:
                    jsonGenerator.writeString("file_permanently_delete");
                    break;
                case PDFACompliance.e_PDFA9_4 /* 94 */:
                    jsonGenerator.writeString("file_preview");
                    break;
                case PDFACompliance.e_PDFA9_5 /* 95 */:
                    jsonGenerator.writeString("file_rename");
                    break;
                case 96:
                    jsonGenerator.writeString("file_restore");
                    break;
                case 97:
                    jsonGenerator.writeString("file_revert");
                    break;
                case 98:
                    jsonGenerator.writeString("file_rollback_changes");
                    break;
                case 99:
                    jsonGenerator.writeString("file_save_copy_reference");
                    break;
                case 100:
                    jsonGenerator.writeString("folder_overview_description_changed");
                    break;
                case 101:
                    jsonGenerator.writeString("folder_overview_item_pinned");
                    break;
                case 102:
                    jsonGenerator.writeString("folder_overview_item_unpinned");
                    break;
                case HttpStatusCodesKt.HTTP_EARLY_HINTS /* 103 */:
                    jsonGenerator.writeString("object_label_added");
                    break;
                case 104:
                    jsonGenerator.writeString("object_label_removed");
                    break;
                case LocationRequest.PRIORITY_NO_POWER /* 105 */:
                    jsonGenerator.writeString("object_label_updated_value");
                    break;
                case 106:
                    jsonGenerator.writeString("organize_folder_with_tidy");
                    break;
                case 107:
                    jsonGenerator.writeString("replay_file_delete");
                    break;
                case 108:
                    jsonGenerator.writeString("rewind_folder");
                    break;
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY /* 109 */:
                    jsonGenerator.writeString("undo_naming_convention");
                    break;
                case 110:
                    jsonGenerator.writeString("undo_organize_folder_with_tidy");
                    break;
                case 111:
                    jsonGenerator.writeString("user_tags_added");
                    break;
                case 112:
                    jsonGenerator.writeString("user_tags_removed");
                    break;
                case 113:
                    jsonGenerator.writeString("email_ingest_receive_file");
                    break;
                case 114:
                    jsonGenerator.writeString("file_request_change");
                    break;
                case 115:
                    jsonGenerator.writeString("file_request_close");
                    break;
                case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID /* 116 */:
                    jsonGenerator.writeString("file_request_create");
                    break;
                case 117:
                    jsonGenerator.writeString("file_request_delete");
                    break;
                case 118:
                    jsonGenerator.writeString("file_request_receive_file");
                    break;
                case 119:
                    jsonGenerator.writeString("group_add_external_id");
                    break;
                case 120:
                    jsonGenerator.writeString("group_add_member");
                    break;
                case PDFACompliance.e_PDFA1_2_1 /* 121 */:
                    jsonGenerator.writeString("group_change_external_id");
                    break;
                case PDFACompliance.e_PDFA1_2_2 /* 122 */:
                    jsonGenerator.writeString("group_change_management_type");
                    break;
                case PDFACompliance.e_PDFA1_2_3 /* 123 */:
                    jsonGenerator.writeString("group_change_member_role");
                    break;
                case 124:
                    jsonGenerator.writeString("group_create");
                    break;
                case GapComposerKt.nodeKey /* 125 */:
                    jsonGenerator.writeString("group_delete");
                    break;
                case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                    jsonGenerator.writeString("group_description_updated");
                    break;
                case 127:
                    jsonGenerator.writeString("group_join_policy_updated");
                    break;
                case 128:
                    jsonGenerator.writeString("group_moved");
                    break;
                case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                    jsonGenerator.writeString("group_remove_external_id");
                    break;
                case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                    jsonGenerator.writeString("group_remove_member");
                    break;
                case PDFACompliance.e_PDFA1_3_1 /* 131 */:
                    jsonGenerator.writeString("group_rename");
                    break;
                case PDFACompliance.e_PDFA1_3_2 /* 132 */:
                    jsonGenerator.writeString("account_lock_or_unlocked");
                    break;
                case PDFACompliance.e_PDFA1_3_3 /* 133 */:
                    jsonGenerator.writeString("emm_error");
                    break;
                case 134:
                    jsonGenerator.writeString("guest_admin_signed_in_via_trusted_teams");
                    break;
                case 135:
                    jsonGenerator.writeString("guest_admin_signed_out_via_trusted_teams");
                    break;
                case TsExtractor.TS_STREAM_TYPE_DTS_HD /* 136 */:
                    jsonGenerator.writeString("login_fail");
                    break;
                case 137:
                    jsonGenerator.writeString("login_success");
                    break;
                case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                    jsonGenerator.writeString("logout");
                    break;
                case TsExtractor.TS_STREAM_TYPE_DTS_UHD /* 139 */:
                    jsonGenerator.writeString("reseller_support_session_end");
                    break;
                case 140:
                    jsonGenerator.writeString("reseller_support_session_start");
                    break;
                case PDFACompliance.e_PDFA1_4_1 /* 141 */:
                    jsonGenerator.writeString("sign_in_as_session_end");
                    break;
                case PDFACompliance.e_PDFA1_4_2 /* 142 */:
                    jsonGenerator.writeString("sign_in_as_session_start");
                    break;
                case 143:
                    jsonGenerator.writeString("sso_error");
                    break;
                case 144:
                    jsonGenerator.writeString("backup_admin_invitation_sent");
                    break;
                case 145:
                    jsonGenerator.writeString("backup_invitation_opened");
                    break;
                case 146:
                    jsonGenerator.writeString("create_team_invite_link");
                    break;
                case 147:
                    jsonGenerator.writeString("delete_team_invite_link");
                    break;
                case 148:
                    jsonGenerator.writeString("member_add_external_id");
                    break;
                case 149:
                    jsonGenerator.writeString("member_add_name");
                    break;
                case TextFieldImplKt.AnimationDuration /* 150 */:
                    jsonGenerator.writeString("member_change_admin_role");
                    break;
                case 151:
                    jsonGenerator.writeString("member_change_email");
                    break;
                case 152:
                    jsonGenerator.writeString("member_change_external_id");
                    break;
                case 153:
                    jsonGenerator.writeString("member_change_membership_type");
                    break;
                case 154:
                    jsonGenerator.writeString("member_change_name");
                    break;
                case 155:
                    jsonGenerator.writeString("member_change_reseller_role");
                    break;
                case 156:
                    jsonGenerator.writeString("member_change_status");
                    break;
                case 157:
                    jsonGenerator.writeString("member_delete_manual_contacts");
                    break;
                case 158:
                    jsonGenerator.writeString("member_delete_profile_photo");
                    break;
                case 159:
                    jsonGenerator.writeString("member_permanently_delete_account_contents");
                    break;
                case 160:
                    jsonGenerator.writeString("member_remove_external_id");
                    break;
                case PDFACompliance.e_PDFA1_6_1 /* 161 */:
                    jsonGenerator.writeString("member_set_profile_photo");
                    break;
                case 162:
                    jsonGenerator.writeString("member_space_limits_add_custom_quota");
                    break;
                case 163:
                    jsonGenerator.writeString("member_space_limits_change_custom_quota");
                    break;
                case 164:
                    jsonGenerator.writeString("member_space_limits_change_status");
                    break;
                case 165:
                    jsonGenerator.writeString("member_space_limits_remove_custom_quota");
                    break;
                case 166:
                    jsonGenerator.writeString("member_suggest");
                    break;
                case 167:
                    jsonGenerator.writeString("member_transfer_account_contents");
                    break;
                case DateTimeConstants.HOURS_PER_WEEK /* 168 */:
                    jsonGenerator.writeString("pending_secondary_email_added");
                    break;
                case 169:
                    jsonGenerator.writeString("secondary_email_deleted");
                    break;
                case 170:
                    jsonGenerator.writeString("secondary_email_verified");
                    break;
                case PDFACompliance.e_PDFA1_7_1 /* 171 */:
                    jsonGenerator.writeString("secondary_mails_policy_changed");
                    break;
                case 172:
                    jsonGenerator.writeString("binder_add_page");
                    break;
                case PDFACompliance.e_PDFA1_7_3 /* 173 */:
                    jsonGenerator.writeString("binder_add_section");
                    break;
                case PDFACompliance.e_PDFA1_7_4 /* 174 */:
                    jsonGenerator.writeString("binder_remove_page");
                    break;
                case 175:
                    jsonGenerator.writeString("binder_remove_section");
                    break;
                case 176:
                    jsonGenerator.writeString("binder_rename_page");
                    break;
                case 177:
                    jsonGenerator.writeString("binder_rename_section");
                    break;
                case 178:
                    jsonGenerator.writeString("binder_reorder_page");
                    break;
                case 179:
                    jsonGenerator.writeString("binder_reorder_section");
                    break;
                case SensibleDefaults.X_OFFSET /* 180 */:
                    jsonGenerator.writeString("paper_content_add_member");
                    break;
                case PDFACompliance.e_PDFA1_8_1 /* 181 */:
                    jsonGenerator.writeString("paper_content_add_to_folder");
                    break;
                case PDFACompliance.e_PDFA1_8_2 /* 182 */:
                    jsonGenerator.writeString("paper_content_archive");
                    break;
                case PDFACompliance.e_PDFA1_8_3 /* 183 */:
                    jsonGenerator.writeString("paper_content_create");
                    break;
                case PDFACompliance.e_PDFA1_8_4 /* 184 */:
                    jsonGenerator.writeString("paper_content_permanently_delete");
                    break;
                case 185:
                    jsonGenerator.writeString("paper_content_remove_from_folder");
                    break;
                case PDFACompliance.e_PDFA1_8_6 /* 186 */:
                    jsonGenerator.writeString("paper_content_remove_member");
                    break;
                case PDFACompliance.e_PDFA1_8_7 /* 187 */:
                    jsonGenerator.writeString("paper_content_rename");
                    break;
                case TsExtractor.TS_PACKET_SIZE /* 188 */:
                    jsonGenerator.writeString("paper_content_restore");
                    break;
                case PsExtractor.PRIVATE_STREAM_1 /* 189 */:
                    jsonGenerator.writeString("paper_doc_add_comment");
                    break;
                case 190:
                    jsonGenerator.writeString("paper_doc_change_member_role");
                    break;
                case 191:
                    jsonGenerator.writeString("paper_doc_change_sharing_policy");
                    break;
                case PsExtractor.AUDIO_STREAM /* 192 */:
                    jsonGenerator.writeString("paper_doc_change_subscription");
                    break;
                case 193:
                    jsonGenerator.writeString("paper_doc_deleted");
                    break;
                case 194:
                    jsonGenerator.writeString("paper_doc_delete_comment");
                    break;
                case 195:
                    jsonGenerator.writeString("paper_doc_download");
                    break;
                case 196:
                    jsonGenerator.writeString("paper_doc_edit");
                    break;
                case 197:
                    jsonGenerator.writeString("paper_doc_edit_comment");
                    break;
                case 198:
                    jsonGenerator.writeString("paper_doc_followed");
                    break;
                case 199:
                    jsonGenerator.writeString("paper_doc_mention");
                    break;
                case 200:
                    jsonGenerator.writeString("paper_doc_ownership_changed");
                    break;
                case 201:
                    jsonGenerator.writeString("paper_doc_request_access");
                    break;
                case 202:
                    jsonGenerator.writeString("paper_doc_resolve_comment");
                    break;
                case 203:
                    jsonGenerator.writeString("paper_doc_revert");
                    break;
                case 204:
                    jsonGenerator.writeString("paper_doc_slack_share");
                    break;
                case HttpStatus.SC_RESET_CONTENT /* 205 */:
                    jsonGenerator.writeString("paper_doc_team_invite");
                    break;
                case 206:
                    jsonGenerator.writeString("paper_doc_trashed");
                    break;
                case 207:
                    jsonGenerator.writeString("paper_doc_unresolve_comment");
                    break;
                case 208:
                    jsonGenerator.writeString("paper_doc_untrashed");
                    break;
                case 209:
                    jsonGenerator.writeString("paper_doc_view");
                    break;
                case 210:
                    jsonGenerator.writeString("paper_external_view_allow");
                    break;
                case 211:
                    jsonGenerator.writeString("paper_external_view_default_team");
                    break;
                case 212:
                    jsonGenerator.writeString("paper_external_view_forbid");
                    break;
                case 213:
                    jsonGenerator.writeString("paper_folder_change_subscription");
                    break;
                case 214:
                    jsonGenerator.writeString("paper_folder_deleted");
                    break;
                case 215:
                    jsonGenerator.writeString("paper_folder_followed");
                    break;
                case 216:
                    jsonGenerator.writeString("paper_folder_team_invite");
                    break;
                case 217:
                    jsonGenerator.writeString("paper_published_link_change_permission");
                    break;
                case 218:
                    jsonGenerator.writeString("paper_published_link_create");
                    break;
                case 219:
                    jsonGenerator.writeString("paper_published_link_disabled");
                    break;
                case 220:
                    jsonGenerator.writeString("paper_published_link_view");
                    break;
                case PDFACompliance.e_PDFA2_2_1 /* 221 */:
                    jsonGenerator.writeString("password_change");
                    break;
                case 222:
                    jsonGenerator.writeString("password_reset");
                    break;
                case 223:
                    jsonGenerator.writeString("password_reset_all");
                    break;
                case 224:
                    jsonGenerator.writeString("classification_create_report");
                    break;
                case 225:
                    jsonGenerator.writeString("classification_create_report_fail");
                    break;
                case 226:
                    jsonGenerator.writeString("emm_create_exceptions_report");
                    break;
                case 227:
                    jsonGenerator.writeString("emm_create_usage_report");
                    break;
                case 228:
                    jsonGenerator.writeString("export_members_report");
                    break;
                case 229:
                    jsonGenerator.writeString("export_members_report_fail");
                    break;
                case 230:
                    jsonGenerator.writeString("external_sharing_create_report");
                    break;
                case 231:
                    jsonGenerator.writeString("external_sharing_report_failed");
                    break;
                case PDFACompliance.e_PDFA2_3_2 /* 232 */:
                    jsonGenerator.writeString("no_expiration_link_gen_create_report");
                    break;
                case PDFACompliance.e_PDFA2_3_3 /* 233 */:
                    jsonGenerator.writeString("no_expiration_link_gen_report_failed");
                    break;
                case 234:
                    jsonGenerator.writeString("no_password_link_gen_create_report");
                    break;
                case 235:
                    jsonGenerator.writeString("no_password_link_gen_report_failed");
                    break;
                case 236:
                    jsonGenerator.writeString("no_password_link_view_create_report");
                    break;
                case 237:
                    jsonGenerator.writeString("no_password_link_view_report_failed");
                    break;
                case 238:
                    jsonGenerator.writeString("outdated_link_view_create_report");
                    break;
                case 239:
                    jsonGenerator.writeString("outdated_link_view_report_failed");
                    break;
                case PsExtractor.VIDEO_STREAM_MASK /* 240 */:
                    jsonGenerator.writeString("paper_admin_export_start");
                    break;
                case PDFACompliance.e_PDFA2_4_1 /* 241 */:
                    jsonGenerator.writeString("ransomware_alert_create_report");
                    break;
                case PDFACompliance.e_PDFA2_4_2 /* 242 */:
                    jsonGenerator.writeString("ransomware_alert_create_report_failed");
                    break;
                case PDFACompliance.e_PDFA2_4_3 /* 243 */:
                    jsonGenerator.writeString("smart_sync_create_admin_privilege_report");
                    break;
                case PDFACompliance.e_PDFA2_4_4 /* 244 */:
                    jsonGenerator.writeString("team_activity_create_report");
                    break;
                case 245:
                    jsonGenerator.writeString("team_activity_create_report_fail");
                    break;
                case 246:
                    jsonGenerator.writeString("collection_share");
                    break;
                case 247:
                    jsonGenerator.writeString("file_transfers_file_add");
                    break;
                case 248:
                    jsonGenerator.writeString("file_transfers_transfer_delete");
                    break;
                case 249:
                    jsonGenerator.writeString("file_transfers_transfer_download");
                    break;
                case 250:
                    jsonGenerator.writeString("file_transfers_transfer_send");
                    break;
                case PDFACompliance.e_PDFA2_5_1 /* 251 */:
                    jsonGenerator.writeString("file_transfers_transfer_view");
                    break;
                case PDFACompliance.e_PDFA2_5_2 /* 252 */:
                    jsonGenerator.writeString("note_acl_invite_only");
                    break;
                case 253:
                    jsonGenerator.writeString("note_acl_link");
                    break;
                case 254:
                    jsonGenerator.writeString("note_acl_team_link");
                    break;
                case 255:
                    jsonGenerator.writeString("note_shared");
                    break;
                case 256:
                    jsonGenerator.writeString("note_share_receive");
                    break;
                case 257:
                    jsonGenerator.writeString("open_note_shared");
                    break;
                case 258:
                    jsonGenerator.writeString("replay_file_shared_link_created");
                    break;
                case 259:
                    jsonGenerator.writeString("replay_file_shared_link_modified");
                    break;
                case 260:
                    jsonGenerator.writeString("replay_project_team_add");
                    break;
                case PDFACompliance.e_PDFA2_6_1 /* 261 */:
                    jsonGenerator.writeString("replay_project_team_delete");
                    break;
                case 262:
                    jsonGenerator.writeString("sf_add_group");
                    break;
                case 263:
                    jsonGenerator.writeString("sf_allow_non_members_to_view_shared_links");
                    break;
                case 264:
                    jsonGenerator.writeString("sf_external_invite_warn");
                    break;
                case 265:
                    jsonGenerator.writeString("sf_fb_invite");
                    break;
                case 266:
                    jsonGenerator.writeString("sf_fb_invite_change_role");
                    break;
                case 267:
                    jsonGenerator.writeString("sf_fb_uninvite");
                    break;
                case 268:
                    jsonGenerator.writeString("sf_invite_group");
                    break;
                case 269:
                    jsonGenerator.writeString("sf_team_grant_access");
                    break;
                case 270:
                    jsonGenerator.writeString("sf_team_invite");
                    break;
                case PDFACompliance.e_PDFA2_7_1 /* 271 */:
                    jsonGenerator.writeString("sf_team_invite_change_role");
                    break;
                case 272:
                    jsonGenerator.writeString("sf_team_join");
                    break;
                case 273:
                    jsonGenerator.writeString("sf_team_join_from_oob_link");
                    break;
                case 274:
                    jsonGenerator.writeString("sf_team_uninvite");
                    break;
                case 275:
                    jsonGenerator.writeString("shared_content_add_invitees");
                    break;
                case 276:
                    jsonGenerator.writeString("shared_content_add_link_expiry");
                    break;
                case 277:
                    jsonGenerator.writeString("shared_content_add_link_password");
                    break;
                case 278:
                    jsonGenerator.writeString("shared_content_add_member");
                    break;
                case 279:
                    jsonGenerator.writeString("shared_content_change_downloads_policy");
                    break;
                case 280:
                    jsonGenerator.writeString("shared_content_change_invitee_role");
                    break;
                case PDFACompliance.e_PDFA2_8_1 /* 281 */:
                    jsonGenerator.writeString("shared_content_change_link_audience");
                    break;
                case 282:
                    jsonGenerator.writeString("shared_content_change_link_expiry");
                    break;
                case 283:
                    jsonGenerator.writeString("shared_content_change_link_password");
                    break;
                case 284:
                    jsonGenerator.writeString("shared_content_change_member_role");
                    break;
                case 285:
                    jsonGenerator.writeString("shared_content_change_viewer_info_policy");
                    break;
                case 286:
                    jsonGenerator.writeString("shared_content_claim_invitation");
                    break;
                case 287:
                    jsonGenerator.writeString("shared_content_copy");
                    break;
                case 288:
                    jsonGenerator.writeString("shared_content_download");
                    break;
                case 289:
                    jsonGenerator.writeString("shared_content_relinquish_membership");
                    break;
                case 290:
                    jsonGenerator.writeString("shared_content_remove_invitees");
                    break;
                case PDFACompliance.e_PDFA2_9_1 /* 291 */:
                    jsonGenerator.writeString("shared_content_remove_link_expiry");
                    break;
                case 292:
                    jsonGenerator.writeString("shared_content_remove_link_password");
                    break;
                case 293:
                    jsonGenerator.writeString("shared_content_remove_member");
                    break;
                case 294:
                    jsonGenerator.writeString("shared_content_request_access");
                    break;
                case 295:
                    jsonGenerator.writeString("shared_content_restore_invitees");
                    break;
                case 296:
                    jsonGenerator.writeString("shared_content_restore_member");
                    break;
                case 297:
                    jsonGenerator.writeString("shared_content_unshare");
                    break;
                case 298:
                    jsonGenerator.writeString("shared_content_view");
                    break;
                case AIContainerViewModel.SUMMARIZE_MIN_LIMIT /* 299 */:
                    jsonGenerator.writeString("shared_folder_change_link_policy");
                    break;
                case 300:
                    jsonGenerator.writeString("shared_folder_change_members_inheritance_policy");
                    break;
                case 301:
                    jsonGenerator.writeString("shared_folder_change_members_management_policy");
                    break;
                case 302:
                    jsonGenerator.writeString("shared_folder_change_members_policy");
                    break;
                case 303:
                    jsonGenerator.writeString("shared_folder_create");
                    break;
                case 304:
                    jsonGenerator.writeString("shared_folder_decline_invitation");
                    break;
                case 305:
                    jsonGenerator.writeString("shared_folder_mount");
                    break;
                case 306:
                    jsonGenerator.writeString("shared_folder_nest");
                    break;
                case 307:
                    jsonGenerator.writeString("shared_folder_transfer_ownership");
                    break;
                case 308:
                    jsonGenerator.writeString("shared_folder_unmount");
                    break;
                case 309:
                    jsonGenerator.writeString("shared_link_add_expiry");
                    break;
                case 310:
                    jsonGenerator.writeString("shared_link_change_expiry");
                    break;
                case 311:
                    jsonGenerator.writeString("shared_link_change_visibility");
                    break;
                case 312:
                    jsonGenerator.writeString("shared_link_copy");
                    break;
                case 313:
                    jsonGenerator.writeString("shared_link_create");
                    break;
                case 314:
                    jsonGenerator.writeString("shared_link_disable");
                    break;
                case 315:
                    jsonGenerator.writeString("shared_link_download");
                    break;
                case TypedValues.AttributesType.TYPE_PATH_ROTATE /* 316 */:
                    jsonGenerator.writeString("shared_link_remove_expiry");
                    break;
                case TypedValues.AttributesType.TYPE_EASING /* 317 */:
                    jsonGenerator.writeString("shared_link_settings_add_expiration");
                    break;
                case TypedValues.AttributesType.TYPE_PIVOT_TARGET /* 318 */:
                    jsonGenerator.writeString("shared_link_settings_add_password");
                    break;
                case 319:
                    jsonGenerator.writeString("shared_link_settings_allow_download_disabled");
                    break;
                case 320:
                    jsonGenerator.writeString("shared_link_settings_allow_download_enabled");
                    break;
                case PDFACompliance.e_PDFA3_2_1 /* 321 */:
                    jsonGenerator.writeString("shared_link_settings_change_audience");
                    break;
                case PDFACompliance.e_PDFA3_2_2 /* 322 */:
                    jsonGenerator.writeString("shared_link_settings_change_expiration");
                    break;
                case PDFACompliance.e_PDFA3_2_3 /* 323 */:
                    jsonGenerator.writeString("shared_link_settings_change_password");
                    break;
                case PDFACompliance.e_PDFA3_2_4 /* 324 */:
                    jsonGenerator.writeString("shared_link_settings_remove_expiration");
                    break;
                case PDFACompliance.e_PDFA3_2_5 /* 325 */:
                    jsonGenerator.writeString("shared_link_settings_remove_password");
                    break;
                case PDFACompliance.e_PDFA3_2_6 /* 326 */:
                    jsonGenerator.writeString("shared_link_share");
                    break;
                case PDFACompliance.e_PDFA3_2_7 /* 327 */:
                    jsonGenerator.writeString("shared_link_view");
                    break;
                case 328:
                    jsonGenerator.writeString("shared_note_opened");
                    break;
                case 329:
                    jsonGenerator.writeString("shmodel_disable_downloads");
                    break;
                case 330:
                    jsonGenerator.writeString("shmodel_enable_downloads");
                    break;
                case PDFACompliance.e_PDFA3_3_1 /* 331 */:
                    jsonGenerator.writeString("shmodel_group_share");
                    break;
                case PDFACompliance.e_PDFA3_3_2 /* 332 */:
                    jsonGenerator.writeString("showcase_access_granted");
                    break;
                case 333:
                    jsonGenerator.writeString("showcase_add_member");
                    break;
                case PDFACompliance.e_PDFA3_3_4 /* 334 */:
                    jsonGenerator.writeString("showcase_archived");
                    break;
                case 335:
                    jsonGenerator.writeString("showcase_created");
                    break;
                case 336:
                    jsonGenerator.writeString("showcase_delete_comment");
                    break;
                case 337:
                    jsonGenerator.writeString("showcase_edited");
                    break;
                case 338:
                    jsonGenerator.writeString("showcase_edit_comment");
                    break;
                case 339:
                    jsonGenerator.writeString("showcase_file_added");
                    break;
                case 340:
                    jsonGenerator.writeString("showcase_file_download");
                    break;
                case PDFACompliance.e_PDFA3_4_1 /* 341 */:
                    jsonGenerator.writeString("showcase_file_removed");
                    break;
                case 342:
                    jsonGenerator.writeString("showcase_file_view");
                    break;
                case 343:
                    jsonGenerator.writeString("showcase_permanently_deleted");
                    break;
                case 344:
                    jsonGenerator.writeString("showcase_post_comment");
                    break;
                case 345:
                    jsonGenerator.writeString("showcase_remove_member");
                    break;
                case 346:
                    jsonGenerator.writeString("showcase_renamed");
                    break;
                case 347:
                    jsonGenerator.writeString("showcase_request_access");
                    break;
                case 348:
                    jsonGenerator.writeString("showcase_resolve_comment");
                    break;
                case 349:
                    jsonGenerator.writeString("showcase_restored");
                    break;
                case WorkflowTransitionState.SLIDE_DURATION_MS /* 350 */:
                    jsonGenerator.writeString("showcase_trashed");
                    break;
                case PDFACompliance.e_PDFA3_5_1 /* 351 */:
                    jsonGenerator.writeString("showcase_trashed_deprecated");
                    break;
                case PDFACompliance.e_PDFA3_5_2 /* 352 */:
                    jsonGenerator.writeString("showcase_unresolve_comment");
                    break;
                case PDFACompliance.e_PDFA3_5_3 /* 353 */:
                    jsonGenerator.writeString("showcase_untrashed");
                    break;
                case PDFACompliance.e_PDFA3_5_4 /* 354 */:
                    jsonGenerator.writeString("showcase_untrashed_deprecated");
                    break;
                case PDFACompliance.e_PDFA3_5_5 /* 355 */:
                    jsonGenerator.writeString("showcase_view");
                    break;
                case PDFACompliance.e_PDFA3_5_6 /* 356 */:
                    jsonGenerator.writeString("sso_add_cert");
                    break;
                case PDFACompliance.e_PDFA3_5_7 /* 357 */:
                    jsonGenerator.writeString("sso_add_login_url");
                    break;
                case 358:
                    jsonGenerator.writeString("sso_add_logout_url");
                    break;
                case 359:
                    jsonGenerator.writeString("sso_change_cert");
                    break;
                case 360:
                    jsonGenerator.writeString("sso_change_login_url");
                    break;
                case PDFACompliance.e_PDFA3_6_1 /* 361 */:
                    jsonGenerator.writeString("sso_change_logout_url");
                    break;
                case 362:
                    jsonGenerator.writeString("sso_change_saml_identity_mode");
                    break;
                case 363:
                    jsonGenerator.writeString("sso_remove_cert");
                    break;
                case 364:
                    jsonGenerator.writeString("sso_remove_login_url");
                    break;
                case 365:
                    jsonGenerator.writeString("sso_remove_logout_url");
                    break;
                case 366:
                    jsonGenerator.writeString("team_folder_change_status");
                    break;
                case 367:
                    jsonGenerator.writeString("team_folder_create");
                    break;
                case 368:
                    jsonGenerator.writeString("team_folder_downgrade");
                    break;
                case 369:
                    jsonGenerator.writeString("team_folder_permanently_delete");
                    break;
                case 370:
                    jsonGenerator.writeString("team_folder_rename");
                    break;
                case PDFACompliance.e_PDFA3_7_1 /* 371 */:
                    jsonGenerator.writeString("team_selective_sync_settings_changed");
                    break;
                case PDFACompliance.e_PDFA3_7_2 /* 372 */:
                    jsonGenerator.writeString("account_capture_change_policy");
                    break;
                case PDFACompliance.e_PDFA3_7_3 /* 373 */:
                    jsonGenerator.writeString("admin_email_reminders_changed");
                    break;
                case 374:
                    jsonGenerator.writeString("allow_download_disabled");
                    break;
                case 375:
                    jsonGenerator.writeString("allow_download_enabled");
                    break;
                case 376:
                    jsonGenerator.writeString("app_permissions_changed");
                    break;
                case 377:
                    jsonGenerator.writeString("camera_uploads_policy_changed");
                    break;
                case 378:
                    jsonGenerator.writeString("capture_transcript_policy_changed");
                    break;
                case 379:
                    jsonGenerator.writeString("classification_change_policy");
                    break;
                case 380:
                    jsonGenerator.writeString("computer_backup_policy_changed");
                    break;
                case PDFACompliance.e_PDFA3_8_1 /* 381 */:
                    jsonGenerator.writeString("content_administration_policy_changed");
                    break;
                case 382:
                    jsonGenerator.writeString("data_placement_restriction_change_policy");
                    break;
                case 383:
                    jsonGenerator.writeString("data_placement_restriction_satisfy_policy");
                    break;
                case RendererCapabilities.DECODER_SUPPORT_MASK /* 384 */:
                    jsonGenerator.writeString("device_approvals_add_exception");
                    break;
                case 385:
                    jsonGenerator.writeString("device_approvals_change_desktop_policy");
                    break;
                case 386:
                    jsonGenerator.writeString("device_approvals_change_mobile_policy");
                    break;
                case 387:
                    jsonGenerator.writeString("device_approvals_change_overage_action");
                    break;
                case 388:
                    jsonGenerator.writeString("device_approvals_change_unlink_action");
                    break;
                case 389:
                    jsonGenerator.writeString("device_approvals_remove_exception");
                    break;
                case 390:
                    jsonGenerator.writeString("directory_restrictions_add_members");
                    break;
                case 391:
                    jsonGenerator.writeString("directory_restrictions_remove_members");
                    break;
                case 392:
                    jsonGenerator.writeString("dropbox_passwords_policy_changed");
                    break;
                case 393:
                    jsonGenerator.writeString("email_ingest_policy_changed");
                    break;
                case 394:
                    jsonGenerator.writeString("emm_add_exception");
                    break;
                case 395:
                    jsonGenerator.writeString("emm_change_policy");
                    break;
                case 396:
                    jsonGenerator.writeString("emm_remove_exception");
                    break;
                case 397:
                    jsonGenerator.writeString("extended_version_history_change_policy");
                    break;
                case 398:
                    jsonGenerator.writeString("external_drive_backup_policy_changed");
                    break;
                case 399:
                    jsonGenerator.writeString("file_comments_change_policy");
                    break;
                case 400:
                    jsonGenerator.writeString("file_locking_policy_changed");
                    break;
                case 401:
                    jsonGenerator.writeString("file_provider_migration_policy_changed");
                    break;
                case 402:
                    jsonGenerator.writeString("file_requests_change_policy");
                    break;
                case 403:
                    jsonGenerator.writeString("file_requests_emails_enabled");
                    break;
                case 404:
                    jsonGenerator.writeString("file_requests_emails_restricted_to_team_only");
                    break;
                case 405:
                    jsonGenerator.writeString("file_transfers_policy_changed");
                    break;
                case HttpStatus.SC_NOT_ACCEPTABLE /* 406 */:
                    jsonGenerator.writeString("folder_link_restriction_policy_changed");
                    break;
                case HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED /* 407 */:
                    jsonGenerator.writeString("google_sso_change_policy");
                    break;
                case HttpStatus.SC_REQUEST_TIMEOUT /* 408 */:
                    jsonGenerator.writeString("group_user_management_change_policy");
                    break;
                case 409:
                    jsonGenerator.writeString("integration_policy_changed");
                    break;
                case HttpStatus.SC_GONE /* 410 */:
                    jsonGenerator.writeString("invite_acceptance_email_policy_changed");
                    break;
                case HttpStatus.SC_LENGTH_REQUIRED /* 411 */:
                    jsonGenerator.writeString("member_requests_change_policy");
                    break;
                case 412:
                    jsonGenerator.writeString("member_send_invite_policy_changed");
                    break;
                case HttpStatus.SC_REQUEST_TOO_LONG /* 413 */:
                    jsonGenerator.writeString("member_space_limits_add_exception");
                    break;
                case HttpStatus.SC_REQUEST_URI_TOO_LONG /* 414 */:
                    jsonGenerator.writeString("member_space_limits_change_caps_type_policy");
                    break;
                case HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE /* 415 */:
                    jsonGenerator.writeString("member_space_limits_change_policy");
                    break;
                case 416:
                    jsonGenerator.writeString("member_space_limits_remove_exception");
                    break;
                case HttpStatus.SC_EXPECTATION_FAILED /* 417 */:
                    jsonGenerator.writeString("member_suggestions_change_policy");
                    break;
                case 418:
                    jsonGenerator.writeString("microsoft_office_addin_change_policy");
                    break;
                case HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE /* 419 */:
                    jsonGenerator.writeString("network_control_change_policy");
                    break;
                case 420:
                    jsonGenerator.writeString("paper_change_deployment_policy");
                    break;
                case 421:
                    jsonGenerator.writeString("paper_change_member_link_policy");
                    break;
                case 422:
                    jsonGenerator.writeString("paper_change_member_policy");
                    break;
                case 423:
                    jsonGenerator.writeString("paper_change_policy");
                    break;
                case 424:
                    jsonGenerator.writeString("paper_default_folder_policy_changed");
                    break;
                case TypedValues.CycleType.TYPE_WAVE_PHASE /* 425 */:
                    jsonGenerator.writeString("paper_desktop_policy_changed");
                    break;
                case 426:
                    jsonGenerator.writeString("paper_enabled_users_group_addition");
                    break;
                case 427:
                    jsonGenerator.writeString("paper_enabled_users_group_removal");
                    break;
                case 428:
                    jsonGenerator.writeString("password_strength_requirements_change_policy");
                    break;
                case 429:
                    jsonGenerator.writeString("permanent_delete_change_policy");
                    break;
                case 430:
                    jsonGenerator.writeString("reseller_support_change_policy");
                    break;
                case 431:
                    jsonGenerator.writeString("rewind_policy_changed");
                    break;
                case 432:
                    jsonGenerator.writeString("send_for_signature_policy_changed");
                    break;
                case 433:
                    jsonGenerator.writeString("sharing_change_folder_join_policy");
                    break;
                case 434:
                    jsonGenerator.writeString("sharing_change_link_allow_change_expiration_policy");
                    break;
                case 435:
                    jsonGenerator.writeString("sharing_change_link_default_expiration_policy");
                    break;
                case 436:
                    jsonGenerator.writeString("sharing_change_link_enforce_password_policy");
                    break;
                case 437:
                    jsonGenerator.writeString("sharing_change_link_policy");
                    break;
                case 438:
                    jsonGenerator.writeString("sharing_change_member_policy");
                    break;
                case 439:
                    jsonGenerator.writeString("showcase_change_download_policy");
                    break;
                case 440:
                    jsonGenerator.writeString("showcase_change_enabled_policy");
                    break;
                case 441:
                    jsonGenerator.writeString("showcase_change_external_sharing_policy");
                    break;
                case 442:
                    jsonGenerator.writeString("smarter_smart_sync_policy_changed");
                    break;
                case 443:
                    jsonGenerator.writeString("smart_sync_change_policy");
                    break;
                case 444:
                    jsonGenerator.writeString("smart_sync_not_opt_out");
                    break;
                case 445:
                    jsonGenerator.writeString("smart_sync_opt_out");
                    break;
                case 446:
                    jsonGenerator.writeString("sso_change_policy");
                    break;
                case 447:
                    jsonGenerator.writeString("team_branding_policy_changed");
                    break;
                case 448:
                    jsonGenerator.writeString("team_extensions_policy_changed");
                    break;
                case 449:
                    jsonGenerator.writeString("team_selective_sync_policy_changed");
                    break;
                case 450:
                    jsonGenerator.writeString("team_sharing_whitelist_subjects_changed");
                    break;
                case 451:
                    jsonGenerator.writeString("tfa_add_exception");
                    break;
                case 452:
                    jsonGenerator.writeString("tfa_change_policy");
                    break;
                case 453:
                    jsonGenerator.writeString("tfa_remove_exception");
                    break;
                case 454:
                    jsonGenerator.writeString("two_account_change_policy");
                    break;
                case 455:
                    jsonGenerator.writeString("viewer_info_policy_changed");
                    break;
                case 456:
                    jsonGenerator.writeString("watermarking_policy_changed");
                    break;
                case 457:
                    jsonGenerator.writeString("web_sessions_change_active_session_limit");
                    break;
                case 458:
                    jsonGenerator.writeString("web_sessions_change_fixed_length_policy");
                    break;
                case 459:
                    jsonGenerator.writeString("web_sessions_change_idle_length_policy");
                    break;
                case 460:
                    jsonGenerator.writeString("data_residency_migration_request_successful");
                    break;
                case 461:
                    jsonGenerator.writeString("data_residency_migration_request_unsuccessful");
                    break;
                case 462:
                    jsonGenerator.writeString("team_merge_from");
                    break;
                case 463:
                    jsonGenerator.writeString("team_merge_to");
                    break;
                case 464:
                    jsonGenerator.writeString("team_profile_add_background");
                    break;
                case 465:
                    jsonGenerator.writeString("team_profile_add_logo");
                    break;
                case 466:
                    jsonGenerator.writeString("team_profile_change_background");
                    break;
                case 467:
                    jsonGenerator.writeString("team_profile_change_default_language");
                    break;
                case 468:
                    jsonGenerator.writeString("team_profile_change_logo");
                    break;
                case 469:
                    jsonGenerator.writeString("team_profile_change_name");
                    break;
                case 470:
                    jsonGenerator.writeString("team_profile_remove_background");
                    break;
                case 471:
                    jsonGenerator.writeString("team_profile_remove_logo");
                    break;
                case 472:
                    jsonGenerator.writeString("tfa_add_backup_phone");
                    break;
                case 473:
                    jsonGenerator.writeString("tfa_add_security_key");
                    break;
                case 474:
                    jsonGenerator.writeString("tfa_change_backup_phone");
                    break;
                case 475:
                    jsonGenerator.writeString("tfa_change_status");
                    break;
                case 476:
                    jsonGenerator.writeString("tfa_remove_backup_phone");
                    break;
                case 477:
                    jsonGenerator.writeString("tfa_remove_security_key");
                    break;
                case 478:
                    jsonGenerator.writeString("tfa_reset");
                    break;
                case 479:
                    jsonGenerator.writeString("changed_enterprise_admin_role");
                    break;
                case WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND /* 480 */:
                    jsonGenerator.writeString("changed_enterprise_connected_team_status");
                    break;
                case 481:
                    jsonGenerator.writeString("ended_enterprise_admin_session");
                    break;
                case 482:
                    jsonGenerator.writeString("ended_enterprise_admin_session_deprecated");
                    break;
                case 483:
                    jsonGenerator.writeString("enterprise_settings_locking");
                    break;
                case 484:
                    jsonGenerator.writeString("guest_admin_change_status");
                    break;
                case 485:
                    jsonGenerator.writeString("started_enterprise_admin_session");
                    break;
                case 486:
                    jsonGenerator.writeString("team_merge_request_accepted");
                    break;
                case 487:
                    jsonGenerator.writeString("team_merge_request_accepted_shown_to_primary_team");
                    break;
                case 488:
                    jsonGenerator.writeString("team_merge_request_accepted_shown_to_secondary_team");
                    break;
                case 489:
                    jsonGenerator.writeString("team_merge_request_auto_canceled");
                    break;
                case 490:
                    jsonGenerator.writeString("team_merge_request_canceled");
                    break;
                case 491:
                    jsonGenerator.writeString("team_merge_request_canceled_shown_to_primary_team");
                    break;
                case 492:
                    jsonGenerator.writeString("team_merge_request_canceled_shown_to_secondary_team");
                    break;
                case 493:
                    jsonGenerator.writeString("team_merge_request_expired");
                    break;
                case 494:
                    jsonGenerator.writeString("team_merge_request_expired_shown_to_primary_team");
                    break;
                case 495:
                    jsonGenerator.writeString("team_merge_request_expired_shown_to_secondary_team");
                    break;
                case 496:
                    jsonGenerator.writeString("team_merge_request_rejected_shown_to_primary_team");
                    break;
                case 497:
                    jsonGenerator.writeString("team_merge_request_rejected_shown_to_secondary_team");
                    break;
                case 498:
                    jsonGenerator.writeString("team_merge_request_reminder");
                    break;
                case 499:
                    jsonGenerator.writeString("team_merge_request_reminder_shown_to_primary_team");
                    break;
                case 500:
                    jsonGenerator.writeString("team_merge_request_reminder_shown_to_secondary_team");
                    break;
                case 501:
                    jsonGenerator.writeString("team_merge_request_revoked");
                    break;
                case 502:
                    jsonGenerator.writeString("team_merge_request_sent_shown_to_primary_team");
                    break;
                case 503:
                    jsonGenerator.writeString("team_merge_request_sent_shown_to_secondary_team");
                    break;
                default:
                    jsonGenerator.writeString("other");
                    break;
            }
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public EventTypeArg deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            EventTypeArg eventTypeArg;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("admin_alerting_alert_state_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.ADMIN_ALERTING_ALERT_STATE_CHANGED;
            } else if ("admin_alerting_changed_alert_config".equals(tag)) {
                eventTypeArg = EventTypeArg.ADMIN_ALERTING_CHANGED_ALERT_CONFIG;
            } else if ("admin_alerting_triggered_alert".equals(tag)) {
                eventTypeArg = EventTypeArg.ADMIN_ALERTING_TRIGGERED_ALERT;
            } else if ("ransomware_restore_process_completed".equals(tag)) {
                eventTypeArg = EventTypeArg.RANSOMWARE_RESTORE_PROCESS_COMPLETED;
            } else if ("ransomware_restore_process_started".equals(tag)) {
                eventTypeArg = EventTypeArg.RANSOMWARE_RESTORE_PROCESS_STARTED;
            } else if ("app_blocked_by_permissions".equals(tag)) {
                eventTypeArg = EventTypeArg.APP_BLOCKED_BY_PERMISSIONS;
            } else if ("app_link_team".equals(tag)) {
                eventTypeArg = EventTypeArg.APP_LINK_TEAM;
            } else if ("app_link_user".equals(tag)) {
                eventTypeArg = EventTypeArg.APP_LINK_USER;
            } else if ("app_unlink_team".equals(tag)) {
                eventTypeArg = EventTypeArg.APP_UNLINK_TEAM;
            } else if ("app_unlink_user".equals(tag)) {
                eventTypeArg = EventTypeArg.APP_UNLINK_USER;
            } else if ("integration_connected".equals(tag)) {
                eventTypeArg = EventTypeArg.INTEGRATION_CONNECTED;
            } else if ("integration_disconnected".equals(tag)) {
                eventTypeArg = EventTypeArg.INTEGRATION_DISCONNECTED;
            } else if ("file_add_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_ADD_COMMENT;
            } else if ("file_change_comment_subscription".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_CHANGE_COMMENT_SUBSCRIPTION;
            } else if ("file_delete_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_DELETE_COMMENT;
            } else if ("file_edit_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_EDIT_COMMENT;
            } else if ("file_like_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_LIKE_COMMENT;
            } else if ("file_resolve_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_RESOLVE_COMMENT;
            } else if ("file_unlike_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_UNLIKE_COMMENT;
            } else if ("file_unresolve_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_UNRESOLVE_COMMENT;
            } else if ("governance_policy_add_folders".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_ADD_FOLDERS;
            } else if ("governance_policy_add_folder_failed".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_ADD_FOLDER_FAILED;
            } else if ("governance_policy_content_disposed".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_CONTENT_DISPOSED;
            } else if ("governance_policy_create".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_CREATE;
            } else if ("governance_policy_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_DELETE;
            } else if ("governance_policy_edit_details".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_EDIT_DETAILS;
            } else if ("governance_policy_edit_duration".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_EDIT_DURATION;
            } else if ("governance_policy_export_created".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_EXPORT_CREATED;
            } else if ("governance_policy_export_removed".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_EXPORT_REMOVED;
            } else if ("governance_policy_remove_folders".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_REMOVE_FOLDERS;
            } else if ("governance_policy_report_created".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_REPORT_CREATED;
            } else if ("governance_policy_zip_part_downloaded".equals(tag)) {
                eventTypeArg = EventTypeArg.GOVERNANCE_POLICY_ZIP_PART_DOWNLOADED;
            } else if ("legal_holds_activate_a_hold".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_ACTIVATE_A_HOLD;
            } else if ("legal_holds_add_members".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_ADD_MEMBERS;
            } else if ("legal_holds_change_hold_details".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_CHANGE_HOLD_DETAILS;
            } else if ("legal_holds_change_hold_name".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_CHANGE_HOLD_NAME;
            } else if ("legal_holds_export_a_hold".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_EXPORT_A_HOLD;
            } else if ("legal_holds_export_cancelled".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_EXPORT_CANCELLED;
            } else if ("legal_holds_export_downloaded".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_EXPORT_DOWNLOADED;
            } else if ("legal_holds_export_removed".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_EXPORT_REMOVED;
            } else if ("legal_holds_release_a_hold".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_RELEASE_A_HOLD;
            } else if ("legal_holds_remove_members".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_REMOVE_MEMBERS;
            } else if ("legal_holds_report_a_hold".equals(tag)) {
                eventTypeArg = EventTypeArg.LEGAL_HOLDS_REPORT_A_HOLD;
            } else if ("device_change_ip_desktop".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_CHANGE_IP_DESKTOP;
            } else if ("device_change_ip_mobile".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_CHANGE_IP_MOBILE;
            } else if ("device_change_ip_web".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_CHANGE_IP_WEB;
            } else if ("device_delete_on_unlink_fail".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_DELETE_ON_UNLINK_FAIL;
            } else if ("device_delete_on_unlink_success".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_DELETE_ON_UNLINK_SUCCESS;
            } else if ("device_link_fail".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_LINK_FAIL;
            } else if ("device_link_success".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_LINK_SUCCESS;
            } else if ("device_management_disabled".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_MANAGEMENT_DISABLED;
            } else if ("device_management_enabled".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_MANAGEMENT_ENABLED;
            } else if ("device_sync_backup_status_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_SYNC_BACKUP_STATUS_CHANGED;
            } else if ("device_unlink".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_UNLINK;
            } else if ("dropbox_passwords_exported".equals(tag)) {
                eventTypeArg = EventTypeArg.DROPBOX_PASSWORDS_EXPORTED;
            } else if ("dropbox_passwords_new_device_enrolled".equals(tag)) {
                eventTypeArg = EventTypeArg.DROPBOX_PASSWORDS_NEW_DEVICE_ENROLLED;
            } else if ("emm_refresh_auth_token".equals(tag)) {
                eventTypeArg = EventTypeArg.EMM_REFRESH_AUTH_TOKEN;
            } else if ("external_drive_backup_eligibility_status_checked".equals(tag)) {
                eventTypeArg = EventTypeArg.EXTERNAL_DRIVE_BACKUP_ELIGIBILITY_STATUS_CHECKED;
            } else if ("external_drive_backup_status_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.EXTERNAL_DRIVE_BACKUP_STATUS_CHANGED;
            } else if ("account_capture_change_availability".equals(tag)) {
                eventTypeArg = EventTypeArg.ACCOUNT_CAPTURE_CHANGE_AVAILABILITY;
            } else if ("account_capture_migrate_account".equals(tag)) {
                eventTypeArg = EventTypeArg.ACCOUNT_CAPTURE_MIGRATE_ACCOUNT;
            } else if ("account_capture_notification_emails_sent".equals(tag)) {
                eventTypeArg = EventTypeArg.ACCOUNT_CAPTURE_NOTIFICATION_EMAILS_SENT;
            } else if ("account_capture_relinquish_account".equals(tag)) {
                eventTypeArg = EventTypeArg.ACCOUNT_CAPTURE_RELINQUISH_ACCOUNT;
            } else if ("disabled_domain_invites".equals(tag)) {
                eventTypeArg = EventTypeArg.DISABLED_DOMAIN_INVITES;
            } else if ("domain_invites_approve_request_to_join_team".equals(tag)) {
                eventTypeArg = EventTypeArg.DOMAIN_INVITES_APPROVE_REQUEST_TO_JOIN_TEAM;
            } else if ("domain_invites_decline_request_to_join_team".equals(tag)) {
                eventTypeArg = EventTypeArg.DOMAIN_INVITES_DECLINE_REQUEST_TO_JOIN_TEAM;
            } else if ("domain_invites_email_existing_users".equals(tag)) {
                eventTypeArg = EventTypeArg.DOMAIN_INVITES_EMAIL_EXISTING_USERS;
            } else if ("domain_invites_request_to_join_team".equals(tag)) {
                eventTypeArg = EventTypeArg.DOMAIN_INVITES_REQUEST_TO_JOIN_TEAM;
            } else if ("domain_invites_set_invite_new_user_pref_to_no".equals(tag)) {
                eventTypeArg = EventTypeArg.DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_NO;
            } else if ("domain_invites_set_invite_new_user_pref_to_yes".equals(tag)) {
                eventTypeArg = EventTypeArg.DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_YES;
            } else if ("domain_verification_add_domain_fail".equals(tag)) {
                eventTypeArg = EventTypeArg.DOMAIN_VERIFICATION_ADD_DOMAIN_FAIL;
            } else if ("domain_verification_add_domain_success".equals(tag)) {
                eventTypeArg = EventTypeArg.DOMAIN_VERIFICATION_ADD_DOMAIN_SUCCESS;
            } else if ("domain_verification_remove_domain".equals(tag)) {
                eventTypeArg = EventTypeArg.DOMAIN_VERIFICATION_REMOVE_DOMAIN;
            } else if ("enabled_domain_invites".equals(tag)) {
                eventTypeArg = EventTypeArg.ENABLED_DOMAIN_INVITES;
            } else if ("team_encryption_key_cancel_key_deletion".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_ENCRYPTION_KEY_CANCEL_KEY_DELETION;
            } else if ("team_encryption_key_create_key".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_ENCRYPTION_KEY_CREATE_KEY;
            } else if ("team_encryption_key_delete_key".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_ENCRYPTION_KEY_DELETE_KEY;
            } else if ("team_encryption_key_disable_key".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_ENCRYPTION_KEY_DISABLE_KEY;
            } else if ("team_encryption_key_enable_key".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_ENCRYPTION_KEY_ENABLE_KEY;
            } else if ("team_encryption_key_rotate_key".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_ENCRYPTION_KEY_ROTATE_KEY;
            } else if ("team_encryption_key_schedule_key_deletion".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_ENCRYPTION_KEY_SCHEDULE_KEY_DELETION;
            } else if ("apply_naming_convention".equals(tag)) {
                eventTypeArg = EventTypeArg.APPLY_NAMING_CONVENTION;
            } else if ("create_folder".equals(tag)) {
                eventTypeArg = EventTypeArg.CREATE_FOLDER;
            } else if ("file_add".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_ADD;
            } else if ("file_add_from_automation".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_ADD_FROM_AUTOMATION;
            } else if ("file_copy".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_COPY;
            } else if ("file_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_DELETE;
            } else if ("file_download".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_DOWNLOAD;
            } else if ("file_edit".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_EDIT;
            } else if ("file_get_copy_reference".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_GET_COPY_REFERENCE;
            } else if ("file_locking_lock_status_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_LOCKING_LOCK_STATUS_CHANGED;
            } else if ("file_move".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_MOVE;
            } else if ("file_permanently_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_PERMANENTLY_DELETE;
            } else if ("file_preview".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_PREVIEW;
            } else if ("file_rename".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_RENAME;
            } else if ("file_restore".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_RESTORE;
            } else if ("file_revert".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_REVERT;
            } else if ("file_rollback_changes".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_ROLLBACK_CHANGES;
            } else if ("file_save_copy_reference".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_SAVE_COPY_REFERENCE;
            } else if ("folder_overview_description_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.FOLDER_OVERVIEW_DESCRIPTION_CHANGED;
            } else if ("folder_overview_item_pinned".equals(tag)) {
                eventTypeArg = EventTypeArg.FOLDER_OVERVIEW_ITEM_PINNED;
            } else if ("folder_overview_item_unpinned".equals(tag)) {
                eventTypeArg = EventTypeArg.FOLDER_OVERVIEW_ITEM_UNPINNED;
            } else if ("object_label_added".equals(tag)) {
                eventTypeArg = EventTypeArg.OBJECT_LABEL_ADDED;
            } else if ("object_label_removed".equals(tag)) {
                eventTypeArg = EventTypeArg.OBJECT_LABEL_REMOVED;
            } else if ("object_label_updated_value".equals(tag)) {
                eventTypeArg = EventTypeArg.OBJECT_LABEL_UPDATED_VALUE;
            } else if ("organize_folder_with_tidy".equals(tag)) {
                eventTypeArg = EventTypeArg.ORGANIZE_FOLDER_WITH_TIDY;
            } else if ("replay_file_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.REPLAY_FILE_DELETE;
            } else if ("rewind_folder".equals(tag)) {
                eventTypeArg = EventTypeArg.REWIND_FOLDER;
            } else if ("undo_naming_convention".equals(tag)) {
                eventTypeArg = EventTypeArg.UNDO_NAMING_CONVENTION;
            } else if ("undo_organize_folder_with_tidy".equals(tag)) {
                eventTypeArg = EventTypeArg.UNDO_ORGANIZE_FOLDER_WITH_TIDY;
            } else if ("user_tags_added".equals(tag)) {
                eventTypeArg = EventTypeArg.USER_TAGS_ADDED;
            } else if ("user_tags_removed".equals(tag)) {
                eventTypeArg = EventTypeArg.USER_TAGS_REMOVED;
            } else if ("email_ingest_receive_file".equals(tag)) {
                eventTypeArg = EventTypeArg.EMAIL_INGEST_RECEIVE_FILE;
            } else if ("file_request_change".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_REQUEST_CHANGE;
            } else if ("file_request_close".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_REQUEST_CLOSE;
            } else if ("file_request_create".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_REQUEST_CREATE;
            } else if ("file_request_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_REQUEST_DELETE;
            } else if ("file_request_receive_file".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_REQUEST_RECEIVE_FILE;
            } else if ("group_add_external_id".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_ADD_EXTERNAL_ID;
            } else if ("group_add_member".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_ADD_MEMBER;
            } else if ("group_change_external_id".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_CHANGE_EXTERNAL_ID;
            } else if ("group_change_management_type".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_CHANGE_MANAGEMENT_TYPE;
            } else if ("group_change_member_role".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_CHANGE_MEMBER_ROLE;
            } else if ("group_create".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_CREATE;
            } else if ("group_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_DELETE;
            } else if ("group_description_updated".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_DESCRIPTION_UPDATED;
            } else if ("group_join_policy_updated".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_JOIN_POLICY_UPDATED;
            } else if ("group_moved".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_MOVED;
            } else if ("group_remove_external_id".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_REMOVE_EXTERNAL_ID;
            } else if ("group_remove_member".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_REMOVE_MEMBER;
            } else if ("group_rename".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_RENAME;
            } else if ("account_lock_or_unlocked".equals(tag)) {
                eventTypeArg = EventTypeArg.ACCOUNT_LOCK_OR_UNLOCKED;
            } else if ("emm_error".equals(tag)) {
                eventTypeArg = EventTypeArg.EMM_ERROR;
            } else if ("guest_admin_signed_in_via_trusted_teams".equals(tag)) {
                eventTypeArg = EventTypeArg.GUEST_ADMIN_SIGNED_IN_VIA_TRUSTED_TEAMS;
            } else if ("guest_admin_signed_out_via_trusted_teams".equals(tag)) {
                eventTypeArg = EventTypeArg.GUEST_ADMIN_SIGNED_OUT_VIA_TRUSTED_TEAMS;
            } else if ("login_fail".equals(tag)) {
                eventTypeArg = EventTypeArg.LOGIN_FAIL;
            } else if ("login_success".equals(tag)) {
                eventTypeArg = EventTypeArg.LOGIN_SUCCESS;
            } else if ("logout".equals(tag)) {
                eventTypeArg = EventTypeArg.LOGOUT;
            } else if ("reseller_support_session_end".equals(tag)) {
                eventTypeArg = EventTypeArg.RESELLER_SUPPORT_SESSION_END;
            } else if ("reseller_support_session_start".equals(tag)) {
                eventTypeArg = EventTypeArg.RESELLER_SUPPORT_SESSION_START;
            } else if ("sign_in_as_session_end".equals(tag)) {
                eventTypeArg = EventTypeArg.SIGN_IN_AS_SESSION_END;
            } else if ("sign_in_as_session_start".equals(tag)) {
                eventTypeArg = EventTypeArg.SIGN_IN_AS_SESSION_START;
            } else if ("sso_error".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_ERROR;
            } else if ("backup_admin_invitation_sent".equals(tag)) {
                eventTypeArg = EventTypeArg.BACKUP_ADMIN_INVITATION_SENT;
            } else if ("backup_invitation_opened".equals(tag)) {
                eventTypeArg = EventTypeArg.BACKUP_INVITATION_OPENED;
            } else if ("create_team_invite_link".equals(tag)) {
                eventTypeArg = EventTypeArg.CREATE_TEAM_INVITE_LINK;
            } else if ("delete_team_invite_link".equals(tag)) {
                eventTypeArg = EventTypeArg.DELETE_TEAM_INVITE_LINK;
            } else if ("member_add_external_id".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_ADD_EXTERNAL_ID;
            } else if ("member_add_name".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_ADD_NAME;
            } else if ("member_change_admin_role".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_CHANGE_ADMIN_ROLE;
            } else if ("member_change_email".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_CHANGE_EMAIL;
            } else if ("member_change_external_id".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_CHANGE_EXTERNAL_ID;
            } else if ("member_change_membership_type".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_CHANGE_MEMBERSHIP_TYPE;
            } else if ("member_change_name".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_CHANGE_NAME;
            } else if ("member_change_reseller_role".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_CHANGE_RESELLER_ROLE;
            } else if ("member_change_status".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_CHANGE_STATUS;
            } else if ("member_delete_manual_contacts".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_DELETE_MANUAL_CONTACTS;
            } else if ("member_delete_profile_photo".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_DELETE_PROFILE_PHOTO;
            } else if ("member_permanently_delete_account_contents".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_PERMANENTLY_DELETE_ACCOUNT_CONTENTS;
            } else if ("member_remove_external_id".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_REMOVE_EXTERNAL_ID;
            } else if ("member_set_profile_photo".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SET_PROFILE_PHOTO;
            } else if ("member_space_limits_add_custom_quota".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SPACE_LIMITS_ADD_CUSTOM_QUOTA;
            } else if ("member_space_limits_change_custom_quota".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_CUSTOM_QUOTA;
            } else if ("member_space_limits_change_status".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_STATUS;
            } else if ("member_space_limits_remove_custom_quota".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SPACE_LIMITS_REMOVE_CUSTOM_QUOTA;
            } else if ("member_suggest".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SUGGEST;
            } else if ("member_transfer_account_contents".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_TRANSFER_ACCOUNT_CONTENTS;
            } else if ("pending_secondary_email_added".equals(tag)) {
                eventTypeArg = EventTypeArg.PENDING_SECONDARY_EMAIL_ADDED;
            } else if ("secondary_email_deleted".equals(tag)) {
                eventTypeArg = EventTypeArg.SECONDARY_EMAIL_DELETED;
            } else if ("secondary_email_verified".equals(tag)) {
                eventTypeArg = EventTypeArg.SECONDARY_EMAIL_VERIFIED;
            } else if ("secondary_mails_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.SECONDARY_MAILS_POLICY_CHANGED;
            } else if ("binder_add_page".equals(tag)) {
                eventTypeArg = EventTypeArg.BINDER_ADD_PAGE;
            } else if ("binder_add_section".equals(tag)) {
                eventTypeArg = EventTypeArg.BINDER_ADD_SECTION;
            } else if ("binder_remove_page".equals(tag)) {
                eventTypeArg = EventTypeArg.BINDER_REMOVE_PAGE;
            } else if ("binder_remove_section".equals(tag)) {
                eventTypeArg = EventTypeArg.BINDER_REMOVE_SECTION;
            } else if ("binder_rename_page".equals(tag)) {
                eventTypeArg = EventTypeArg.BINDER_RENAME_PAGE;
            } else if ("binder_rename_section".equals(tag)) {
                eventTypeArg = EventTypeArg.BINDER_RENAME_SECTION;
            } else if ("binder_reorder_page".equals(tag)) {
                eventTypeArg = EventTypeArg.BINDER_REORDER_PAGE;
            } else if ("binder_reorder_section".equals(tag)) {
                eventTypeArg = EventTypeArg.BINDER_REORDER_SECTION;
            } else if ("paper_content_add_member".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CONTENT_ADD_MEMBER;
            } else if ("paper_content_add_to_folder".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CONTENT_ADD_TO_FOLDER;
            } else if ("paper_content_archive".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CONTENT_ARCHIVE;
            } else if ("paper_content_create".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CONTENT_CREATE;
            } else if ("paper_content_permanently_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CONTENT_PERMANENTLY_DELETE;
            } else if ("paper_content_remove_from_folder".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CONTENT_REMOVE_FROM_FOLDER;
            } else if ("paper_content_remove_member".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CONTENT_REMOVE_MEMBER;
            } else if ("paper_content_rename".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CONTENT_RENAME;
            } else if ("paper_content_restore".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CONTENT_RESTORE;
            } else if ("paper_doc_add_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_ADD_COMMENT;
            } else if ("paper_doc_change_member_role".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_CHANGE_MEMBER_ROLE;
            } else if ("paper_doc_change_sharing_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_CHANGE_SHARING_POLICY;
            } else if ("paper_doc_change_subscription".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_CHANGE_SUBSCRIPTION;
            } else if ("paper_doc_deleted".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_DELETED;
            } else if ("paper_doc_delete_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_DELETE_COMMENT;
            } else if ("paper_doc_download".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_DOWNLOAD;
            } else if ("paper_doc_edit".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_EDIT;
            } else if ("paper_doc_edit_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_EDIT_COMMENT;
            } else if ("paper_doc_followed".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_FOLLOWED;
            } else if ("paper_doc_mention".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_MENTION;
            } else if ("paper_doc_ownership_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_OWNERSHIP_CHANGED;
            } else if ("paper_doc_request_access".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_REQUEST_ACCESS;
            } else if ("paper_doc_resolve_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_RESOLVE_COMMENT;
            } else if ("paper_doc_revert".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_REVERT;
            } else if ("paper_doc_slack_share".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_SLACK_SHARE;
            } else if ("paper_doc_team_invite".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_TEAM_INVITE;
            } else if ("paper_doc_trashed".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_TRASHED;
            } else if ("paper_doc_unresolve_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_UNRESOLVE_COMMENT;
            } else if ("paper_doc_untrashed".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_UNTRASHED;
            } else if ("paper_doc_view".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DOC_VIEW;
            } else if ("paper_external_view_allow".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_EXTERNAL_VIEW_ALLOW;
            } else if ("paper_external_view_default_team".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_EXTERNAL_VIEW_DEFAULT_TEAM;
            } else if ("paper_external_view_forbid".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_EXTERNAL_VIEW_FORBID;
            } else if ("paper_folder_change_subscription".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_FOLDER_CHANGE_SUBSCRIPTION;
            } else if ("paper_folder_deleted".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_FOLDER_DELETED;
            } else if ("paper_folder_followed".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_FOLDER_FOLLOWED;
            } else if ("paper_folder_team_invite".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_FOLDER_TEAM_INVITE;
            } else if ("paper_published_link_change_permission".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_PUBLISHED_LINK_CHANGE_PERMISSION;
            } else if ("paper_published_link_create".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_PUBLISHED_LINK_CREATE;
            } else if ("paper_published_link_disabled".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_PUBLISHED_LINK_DISABLED;
            } else if ("paper_published_link_view".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_PUBLISHED_LINK_VIEW;
            } else if ("password_change".equals(tag)) {
                eventTypeArg = EventTypeArg.PASSWORD_CHANGE;
            } else if ("password_reset".equals(tag)) {
                eventTypeArg = EventTypeArg.PASSWORD_RESET;
            } else if ("password_reset_all".equals(tag)) {
                eventTypeArg = EventTypeArg.PASSWORD_RESET_ALL;
            } else if ("classification_create_report".equals(tag)) {
                eventTypeArg = EventTypeArg.CLASSIFICATION_CREATE_REPORT;
            } else if ("classification_create_report_fail".equals(tag)) {
                eventTypeArg = EventTypeArg.CLASSIFICATION_CREATE_REPORT_FAIL;
            } else if ("emm_create_exceptions_report".equals(tag)) {
                eventTypeArg = EventTypeArg.EMM_CREATE_EXCEPTIONS_REPORT;
            } else if ("emm_create_usage_report".equals(tag)) {
                eventTypeArg = EventTypeArg.EMM_CREATE_USAGE_REPORT;
            } else if ("export_members_report".equals(tag)) {
                eventTypeArg = EventTypeArg.EXPORT_MEMBERS_REPORT;
            } else if ("export_members_report_fail".equals(tag)) {
                eventTypeArg = EventTypeArg.EXPORT_MEMBERS_REPORT_FAIL;
            } else if ("external_sharing_create_report".equals(tag)) {
                eventTypeArg = EventTypeArg.EXTERNAL_SHARING_CREATE_REPORT;
            } else if ("external_sharing_report_failed".equals(tag)) {
                eventTypeArg = EventTypeArg.EXTERNAL_SHARING_REPORT_FAILED;
            } else if ("no_expiration_link_gen_create_report".equals(tag)) {
                eventTypeArg = EventTypeArg.NO_EXPIRATION_LINK_GEN_CREATE_REPORT;
            } else if ("no_expiration_link_gen_report_failed".equals(tag)) {
                eventTypeArg = EventTypeArg.NO_EXPIRATION_LINK_GEN_REPORT_FAILED;
            } else if ("no_password_link_gen_create_report".equals(tag)) {
                eventTypeArg = EventTypeArg.NO_PASSWORD_LINK_GEN_CREATE_REPORT;
            } else if ("no_password_link_gen_report_failed".equals(tag)) {
                eventTypeArg = EventTypeArg.NO_PASSWORD_LINK_GEN_REPORT_FAILED;
            } else if ("no_password_link_view_create_report".equals(tag)) {
                eventTypeArg = EventTypeArg.NO_PASSWORD_LINK_VIEW_CREATE_REPORT;
            } else if ("no_password_link_view_report_failed".equals(tag)) {
                eventTypeArg = EventTypeArg.NO_PASSWORD_LINK_VIEW_REPORT_FAILED;
            } else if ("outdated_link_view_create_report".equals(tag)) {
                eventTypeArg = EventTypeArg.OUTDATED_LINK_VIEW_CREATE_REPORT;
            } else if ("outdated_link_view_report_failed".equals(tag)) {
                eventTypeArg = EventTypeArg.OUTDATED_LINK_VIEW_REPORT_FAILED;
            } else if ("paper_admin_export_start".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_ADMIN_EXPORT_START;
            } else if ("ransomware_alert_create_report".equals(tag)) {
                eventTypeArg = EventTypeArg.RANSOMWARE_ALERT_CREATE_REPORT;
            } else if ("ransomware_alert_create_report_failed".equals(tag)) {
                eventTypeArg = EventTypeArg.RANSOMWARE_ALERT_CREATE_REPORT_FAILED;
            } else if ("smart_sync_create_admin_privilege_report".equals(tag)) {
                eventTypeArg = EventTypeArg.SMART_SYNC_CREATE_ADMIN_PRIVILEGE_REPORT;
            } else if ("team_activity_create_report".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_ACTIVITY_CREATE_REPORT;
            } else if ("team_activity_create_report_fail".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_ACTIVITY_CREATE_REPORT_FAIL;
            } else if ("collection_share".equals(tag)) {
                eventTypeArg = EventTypeArg.COLLECTION_SHARE;
            } else if ("file_transfers_file_add".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_TRANSFERS_FILE_ADD;
            } else if ("file_transfers_transfer_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_TRANSFERS_TRANSFER_DELETE;
            } else if ("file_transfers_transfer_download".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_TRANSFERS_TRANSFER_DOWNLOAD;
            } else if ("file_transfers_transfer_send".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_TRANSFERS_TRANSFER_SEND;
            } else if ("file_transfers_transfer_view".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_TRANSFERS_TRANSFER_VIEW;
            } else if ("note_acl_invite_only".equals(tag)) {
                eventTypeArg = EventTypeArg.NOTE_ACL_INVITE_ONLY;
            } else if ("note_acl_link".equals(tag)) {
                eventTypeArg = EventTypeArg.NOTE_ACL_LINK;
            } else if ("note_acl_team_link".equals(tag)) {
                eventTypeArg = EventTypeArg.NOTE_ACL_TEAM_LINK;
            } else if ("note_shared".equals(tag)) {
                eventTypeArg = EventTypeArg.NOTE_SHARED;
            } else if ("note_share_receive".equals(tag)) {
                eventTypeArg = EventTypeArg.NOTE_SHARE_RECEIVE;
            } else if ("open_note_shared".equals(tag)) {
                eventTypeArg = EventTypeArg.OPEN_NOTE_SHARED;
            } else if ("replay_file_shared_link_created".equals(tag)) {
                eventTypeArg = EventTypeArg.REPLAY_FILE_SHARED_LINK_CREATED;
            } else if ("replay_file_shared_link_modified".equals(tag)) {
                eventTypeArg = EventTypeArg.REPLAY_FILE_SHARED_LINK_MODIFIED;
            } else if ("replay_project_team_add".equals(tag)) {
                eventTypeArg = EventTypeArg.REPLAY_PROJECT_TEAM_ADD;
            } else if ("replay_project_team_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.REPLAY_PROJECT_TEAM_DELETE;
            } else if ("sf_add_group".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_ADD_GROUP;
            } else if ("sf_allow_non_members_to_view_shared_links".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_ALLOW_NON_MEMBERS_TO_VIEW_SHARED_LINKS;
            } else if ("sf_external_invite_warn".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_EXTERNAL_INVITE_WARN;
            } else if ("sf_fb_invite".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_FB_INVITE;
            } else if ("sf_fb_invite_change_role".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_FB_INVITE_CHANGE_ROLE;
            } else if ("sf_fb_uninvite".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_FB_UNINVITE;
            } else if ("sf_invite_group".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_INVITE_GROUP;
            } else if ("sf_team_grant_access".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_TEAM_GRANT_ACCESS;
            } else if ("sf_team_invite".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_TEAM_INVITE;
            } else if ("sf_team_invite_change_role".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_TEAM_INVITE_CHANGE_ROLE;
            } else if ("sf_team_join".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_TEAM_JOIN;
            } else if ("sf_team_join_from_oob_link".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_TEAM_JOIN_FROM_OOB_LINK;
            } else if ("sf_team_uninvite".equals(tag)) {
                eventTypeArg = EventTypeArg.SF_TEAM_UNINVITE;
            } else if ("shared_content_add_invitees".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_ADD_INVITEES;
            } else if ("shared_content_add_link_expiry".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_ADD_LINK_EXPIRY;
            } else if ("shared_content_add_link_password".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_ADD_LINK_PASSWORD;
            } else if ("shared_content_add_member".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_ADD_MEMBER;
            } else if ("shared_content_change_downloads_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_CHANGE_DOWNLOADS_POLICY;
            } else if ("shared_content_change_invitee_role".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_CHANGE_INVITEE_ROLE;
            } else if ("shared_content_change_link_audience".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_CHANGE_LINK_AUDIENCE;
            } else if ("shared_content_change_link_expiry".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_CHANGE_LINK_EXPIRY;
            } else if ("shared_content_change_link_password".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_CHANGE_LINK_PASSWORD;
            } else if ("shared_content_change_member_role".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_CHANGE_MEMBER_ROLE;
            } else if ("shared_content_change_viewer_info_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_CHANGE_VIEWER_INFO_POLICY;
            } else if ("shared_content_claim_invitation".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_CLAIM_INVITATION;
            } else if ("shared_content_copy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_COPY;
            } else if ("shared_content_download".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_DOWNLOAD;
            } else if ("shared_content_relinquish_membership".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_RELINQUISH_MEMBERSHIP;
            } else if ("shared_content_remove_invitees".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_REMOVE_INVITEES;
            } else if ("shared_content_remove_link_expiry".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_REMOVE_LINK_EXPIRY;
            } else if ("shared_content_remove_link_password".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_REMOVE_LINK_PASSWORD;
            } else if ("shared_content_remove_member".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_REMOVE_MEMBER;
            } else if ("shared_content_request_access".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_REQUEST_ACCESS;
            } else if ("shared_content_restore_invitees".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_RESTORE_INVITEES;
            } else if ("shared_content_restore_member".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_RESTORE_MEMBER;
            } else if ("shared_content_unshare".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_UNSHARE;
            } else if ("shared_content_view".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_CONTENT_VIEW;
            } else if ("shared_folder_change_link_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_CHANGE_LINK_POLICY;
            } else if ("shared_folder_change_members_inheritance_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_CHANGE_MEMBERS_INHERITANCE_POLICY;
            } else if ("shared_folder_change_members_management_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_CHANGE_MEMBERS_MANAGEMENT_POLICY;
            } else if ("shared_folder_change_members_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_CHANGE_MEMBERS_POLICY;
            } else if ("shared_folder_create".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_CREATE;
            } else if ("shared_folder_decline_invitation".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_DECLINE_INVITATION;
            } else if ("shared_folder_mount".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_MOUNT;
            } else if ("shared_folder_nest".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_NEST;
            } else if ("shared_folder_transfer_ownership".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_TRANSFER_OWNERSHIP;
            } else if ("shared_folder_unmount".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_FOLDER_UNMOUNT;
            } else if ("shared_link_add_expiry".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_ADD_EXPIRY;
            } else if ("shared_link_change_expiry".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_CHANGE_EXPIRY;
            } else if ("shared_link_change_visibility".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_CHANGE_VISIBILITY;
            } else if ("shared_link_copy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_COPY;
            } else if ("shared_link_create".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_CREATE;
            } else if ("shared_link_disable".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_DISABLE;
            } else if ("shared_link_download".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_DOWNLOAD;
            } else if ("shared_link_remove_expiry".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_REMOVE_EXPIRY;
            } else if ("shared_link_settings_add_expiration".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SETTINGS_ADD_EXPIRATION;
            } else if ("shared_link_settings_add_password".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SETTINGS_ADD_PASSWORD;
            } else if ("shared_link_settings_allow_download_disabled".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_DISABLED;
            } else if ("shared_link_settings_allow_download_enabled".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_ENABLED;
            } else if ("shared_link_settings_change_audience".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SETTINGS_CHANGE_AUDIENCE;
            } else if ("shared_link_settings_change_expiration".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SETTINGS_CHANGE_EXPIRATION;
            } else if ("shared_link_settings_change_password".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SETTINGS_CHANGE_PASSWORD;
            } else if ("shared_link_settings_remove_expiration".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SETTINGS_REMOVE_EXPIRATION;
            } else if ("shared_link_settings_remove_password".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SETTINGS_REMOVE_PASSWORD;
            } else if ("shared_link_share".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_SHARE;
            } else if ("shared_link_view".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_LINK_VIEW;
            } else if ("shared_note_opened".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARED_NOTE_OPENED;
            } else if ("shmodel_disable_downloads".equals(tag)) {
                eventTypeArg = EventTypeArg.SHMODEL_DISABLE_DOWNLOADS;
            } else if ("shmodel_enable_downloads".equals(tag)) {
                eventTypeArg = EventTypeArg.SHMODEL_ENABLE_DOWNLOADS;
            } else if ("shmodel_group_share".equals(tag)) {
                eventTypeArg = EventTypeArg.SHMODEL_GROUP_SHARE;
            } else if ("showcase_access_granted".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_ACCESS_GRANTED;
            } else if ("showcase_add_member".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_ADD_MEMBER;
            } else if ("showcase_archived".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_ARCHIVED;
            } else if ("showcase_created".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_CREATED;
            } else if ("showcase_delete_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_DELETE_COMMENT;
            } else if ("showcase_edited".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_EDITED;
            } else if ("showcase_edit_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_EDIT_COMMENT;
            } else if ("showcase_file_added".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_FILE_ADDED;
            } else if ("showcase_file_download".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_FILE_DOWNLOAD;
            } else if ("showcase_file_removed".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_FILE_REMOVED;
            } else if ("showcase_file_view".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_FILE_VIEW;
            } else if ("showcase_permanently_deleted".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_PERMANENTLY_DELETED;
            } else if ("showcase_post_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_POST_COMMENT;
            } else if ("showcase_remove_member".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_REMOVE_MEMBER;
            } else if ("showcase_renamed".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_RENAMED;
            } else if ("showcase_request_access".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_REQUEST_ACCESS;
            } else if ("showcase_resolve_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_RESOLVE_COMMENT;
            } else if ("showcase_restored".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_RESTORED;
            } else if ("showcase_trashed".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_TRASHED;
            } else if ("showcase_trashed_deprecated".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_TRASHED_DEPRECATED;
            } else if ("showcase_unresolve_comment".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_UNRESOLVE_COMMENT;
            } else if ("showcase_untrashed".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_UNTRASHED;
            } else if ("showcase_untrashed_deprecated".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_UNTRASHED_DEPRECATED;
            } else if ("showcase_view".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_VIEW;
            } else if ("sso_add_cert".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_ADD_CERT;
            } else if ("sso_add_login_url".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_ADD_LOGIN_URL;
            } else if ("sso_add_logout_url".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_ADD_LOGOUT_URL;
            } else if ("sso_change_cert".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_CHANGE_CERT;
            } else if ("sso_change_login_url".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_CHANGE_LOGIN_URL;
            } else if ("sso_change_logout_url".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_CHANGE_LOGOUT_URL;
            } else if ("sso_change_saml_identity_mode".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_CHANGE_SAML_IDENTITY_MODE;
            } else if ("sso_remove_cert".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_REMOVE_CERT;
            } else if ("sso_remove_login_url".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_REMOVE_LOGIN_URL;
            } else if ("sso_remove_logout_url".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_REMOVE_LOGOUT_URL;
            } else if ("team_folder_change_status".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_FOLDER_CHANGE_STATUS;
            } else if ("team_folder_create".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_FOLDER_CREATE;
            } else if ("team_folder_downgrade".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_FOLDER_DOWNGRADE;
            } else if ("team_folder_permanently_delete".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_FOLDER_PERMANENTLY_DELETE;
            } else if ("team_folder_rename".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_FOLDER_RENAME;
            } else if ("team_selective_sync_settings_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_SELECTIVE_SYNC_SETTINGS_CHANGED;
            } else if ("account_capture_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.ACCOUNT_CAPTURE_CHANGE_POLICY;
            } else if ("admin_email_reminders_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.ADMIN_EMAIL_REMINDERS_CHANGED;
            } else if ("allow_download_disabled".equals(tag)) {
                eventTypeArg = EventTypeArg.ALLOW_DOWNLOAD_DISABLED;
            } else if ("allow_download_enabled".equals(tag)) {
                eventTypeArg = EventTypeArg.ALLOW_DOWNLOAD_ENABLED;
            } else if ("app_permissions_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.APP_PERMISSIONS_CHANGED;
            } else if ("camera_uploads_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.CAMERA_UPLOADS_POLICY_CHANGED;
            } else if ("capture_transcript_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.CAPTURE_TRANSCRIPT_POLICY_CHANGED;
            } else if ("classification_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.CLASSIFICATION_CHANGE_POLICY;
            } else if ("computer_backup_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.COMPUTER_BACKUP_POLICY_CHANGED;
            } else if ("content_administration_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.CONTENT_ADMINISTRATION_POLICY_CHANGED;
            } else if ("data_placement_restriction_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.DATA_PLACEMENT_RESTRICTION_CHANGE_POLICY;
            } else if ("data_placement_restriction_satisfy_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.DATA_PLACEMENT_RESTRICTION_SATISFY_POLICY;
            } else if ("device_approvals_add_exception".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_APPROVALS_ADD_EXCEPTION;
            } else if ("device_approvals_change_desktop_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_APPROVALS_CHANGE_DESKTOP_POLICY;
            } else if ("device_approvals_change_mobile_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_APPROVALS_CHANGE_MOBILE_POLICY;
            } else if ("device_approvals_change_overage_action".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_APPROVALS_CHANGE_OVERAGE_ACTION;
            } else if ("device_approvals_change_unlink_action".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_APPROVALS_CHANGE_UNLINK_ACTION;
            } else if ("device_approvals_remove_exception".equals(tag)) {
                eventTypeArg = EventTypeArg.DEVICE_APPROVALS_REMOVE_EXCEPTION;
            } else if ("directory_restrictions_add_members".equals(tag)) {
                eventTypeArg = EventTypeArg.DIRECTORY_RESTRICTIONS_ADD_MEMBERS;
            } else if ("directory_restrictions_remove_members".equals(tag)) {
                eventTypeArg = EventTypeArg.DIRECTORY_RESTRICTIONS_REMOVE_MEMBERS;
            } else if ("dropbox_passwords_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.DROPBOX_PASSWORDS_POLICY_CHANGED;
            } else if ("email_ingest_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.EMAIL_INGEST_POLICY_CHANGED;
            } else if ("emm_add_exception".equals(tag)) {
                eventTypeArg = EventTypeArg.EMM_ADD_EXCEPTION;
            } else if ("emm_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.EMM_CHANGE_POLICY;
            } else if ("emm_remove_exception".equals(tag)) {
                eventTypeArg = EventTypeArg.EMM_REMOVE_EXCEPTION;
            } else if ("extended_version_history_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.EXTENDED_VERSION_HISTORY_CHANGE_POLICY;
            } else if ("external_drive_backup_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.EXTERNAL_DRIVE_BACKUP_POLICY_CHANGED;
            } else if ("file_comments_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_COMMENTS_CHANGE_POLICY;
            } else if ("file_locking_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_LOCKING_POLICY_CHANGED;
            } else if ("file_provider_migration_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_PROVIDER_MIGRATION_POLICY_CHANGED;
            } else if ("file_requests_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_REQUESTS_CHANGE_POLICY;
            } else if ("file_requests_emails_enabled".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_REQUESTS_EMAILS_ENABLED;
            } else if ("file_requests_emails_restricted_to_team_only".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_REQUESTS_EMAILS_RESTRICTED_TO_TEAM_ONLY;
            } else if ("file_transfers_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.FILE_TRANSFERS_POLICY_CHANGED;
            } else if ("folder_link_restriction_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.FOLDER_LINK_RESTRICTION_POLICY_CHANGED;
            } else if ("google_sso_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.GOOGLE_SSO_CHANGE_POLICY;
            } else if ("group_user_management_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.GROUP_USER_MANAGEMENT_CHANGE_POLICY;
            } else if ("integration_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.INTEGRATION_POLICY_CHANGED;
            } else if ("invite_acceptance_email_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.INVITE_ACCEPTANCE_EMAIL_POLICY_CHANGED;
            } else if ("member_requests_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_REQUESTS_CHANGE_POLICY;
            } else if ("member_send_invite_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SEND_INVITE_POLICY_CHANGED;
            } else if ("member_space_limits_add_exception".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SPACE_LIMITS_ADD_EXCEPTION;
            } else if ("member_space_limits_change_caps_type_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_CAPS_TYPE_POLICY;
            } else if ("member_space_limits_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_POLICY;
            } else if ("member_space_limits_remove_exception".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SPACE_LIMITS_REMOVE_EXCEPTION;
            } else if ("member_suggestions_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.MEMBER_SUGGESTIONS_CHANGE_POLICY;
            } else if ("microsoft_office_addin_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.MICROSOFT_OFFICE_ADDIN_CHANGE_POLICY;
            } else if ("network_control_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.NETWORK_CONTROL_CHANGE_POLICY;
            } else if ("paper_change_deployment_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CHANGE_DEPLOYMENT_POLICY;
            } else if ("paper_change_member_link_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CHANGE_MEMBER_LINK_POLICY;
            } else if ("paper_change_member_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CHANGE_MEMBER_POLICY;
            } else if ("paper_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_CHANGE_POLICY;
            } else if ("paper_default_folder_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DEFAULT_FOLDER_POLICY_CHANGED;
            } else if ("paper_desktop_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_DESKTOP_POLICY_CHANGED;
            } else if ("paper_enabled_users_group_addition".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_ENABLED_USERS_GROUP_ADDITION;
            } else if ("paper_enabled_users_group_removal".equals(tag)) {
                eventTypeArg = EventTypeArg.PAPER_ENABLED_USERS_GROUP_REMOVAL;
            } else if ("password_strength_requirements_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.PASSWORD_STRENGTH_REQUIREMENTS_CHANGE_POLICY;
            } else if ("permanent_delete_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.PERMANENT_DELETE_CHANGE_POLICY;
            } else if ("reseller_support_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.RESELLER_SUPPORT_CHANGE_POLICY;
            } else if ("rewind_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.REWIND_POLICY_CHANGED;
            } else if ("send_for_signature_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.SEND_FOR_SIGNATURE_POLICY_CHANGED;
            } else if ("sharing_change_folder_join_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARING_CHANGE_FOLDER_JOIN_POLICY;
            } else if ("sharing_change_link_allow_change_expiration_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARING_CHANGE_LINK_ALLOW_CHANGE_EXPIRATION_POLICY;
            } else if ("sharing_change_link_default_expiration_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARING_CHANGE_LINK_DEFAULT_EXPIRATION_POLICY;
            } else if ("sharing_change_link_enforce_password_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARING_CHANGE_LINK_ENFORCE_PASSWORD_POLICY;
            } else if ("sharing_change_link_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARING_CHANGE_LINK_POLICY;
            } else if ("sharing_change_member_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHARING_CHANGE_MEMBER_POLICY;
            } else if ("showcase_change_download_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_CHANGE_DOWNLOAD_POLICY;
            } else if ("showcase_change_enabled_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_CHANGE_ENABLED_POLICY;
            } else if ("showcase_change_external_sharing_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SHOWCASE_CHANGE_EXTERNAL_SHARING_POLICY;
            } else if ("smarter_smart_sync_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.SMARTER_SMART_SYNC_POLICY_CHANGED;
            } else if ("smart_sync_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SMART_SYNC_CHANGE_POLICY;
            } else if ("smart_sync_not_opt_out".equals(tag)) {
                eventTypeArg = EventTypeArg.SMART_SYNC_NOT_OPT_OUT;
            } else if ("smart_sync_opt_out".equals(tag)) {
                eventTypeArg = EventTypeArg.SMART_SYNC_OPT_OUT;
            } else if ("sso_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.SSO_CHANGE_POLICY;
            } else if ("team_branding_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_BRANDING_POLICY_CHANGED;
            } else if ("team_extensions_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_EXTENSIONS_POLICY_CHANGED;
            } else if ("team_selective_sync_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_SELECTIVE_SYNC_POLICY_CHANGED;
            } else if ("team_sharing_whitelist_subjects_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_SHARING_WHITELIST_SUBJECTS_CHANGED;
            } else if ("tfa_add_exception".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_ADD_EXCEPTION;
            } else if ("tfa_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_CHANGE_POLICY;
            } else if ("tfa_remove_exception".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_REMOVE_EXCEPTION;
            } else if ("two_account_change_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.TWO_ACCOUNT_CHANGE_POLICY;
            } else if ("viewer_info_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.VIEWER_INFO_POLICY_CHANGED;
            } else if ("watermarking_policy_changed".equals(tag)) {
                eventTypeArg = EventTypeArg.WATERMARKING_POLICY_CHANGED;
            } else if ("web_sessions_change_active_session_limit".equals(tag)) {
                eventTypeArg = EventTypeArg.WEB_SESSIONS_CHANGE_ACTIVE_SESSION_LIMIT;
            } else if ("web_sessions_change_fixed_length_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.WEB_SESSIONS_CHANGE_FIXED_LENGTH_POLICY;
            } else if ("web_sessions_change_idle_length_policy".equals(tag)) {
                eventTypeArg = EventTypeArg.WEB_SESSIONS_CHANGE_IDLE_LENGTH_POLICY;
            } else if ("data_residency_migration_request_successful".equals(tag)) {
                eventTypeArg = EventTypeArg.DATA_RESIDENCY_MIGRATION_REQUEST_SUCCESSFUL;
            } else if ("data_residency_migration_request_unsuccessful".equals(tag)) {
                eventTypeArg = EventTypeArg.DATA_RESIDENCY_MIGRATION_REQUEST_UNSUCCESSFUL;
            } else if ("team_merge_from".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_FROM;
            } else if ("team_merge_to".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_TO;
            } else if ("team_profile_add_background".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_PROFILE_ADD_BACKGROUND;
            } else if ("team_profile_add_logo".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_PROFILE_ADD_LOGO;
            } else if ("team_profile_change_background".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_PROFILE_CHANGE_BACKGROUND;
            } else if ("team_profile_change_default_language".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_PROFILE_CHANGE_DEFAULT_LANGUAGE;
            } else if ("team_profile_change_logo".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_PROFILE_CHANGE_LOGO;
            } else if ("team_profile_change_name".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_PROFILE_CHANGE_NAME;
            } else if ("team_profile_remove_background".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_PROFILE_REMOVE_BACKGROUND;
            } else if ("team_profile_remove_logo".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_PROFILE_REMOVE_LOGO;
            } else if ("tfa_add_backup_phone".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_ADD_BACKUP_PHONE;
            } else if ("tfa_add_security_key".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_ADD_SECURITY_KEY;
            } else if ("tfa_change_backup_phone".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_CHANGE_BACKUP_PHONE;
            } else if ("tfa_change_status".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_CHANGE_STATUS;
            } else if ("tfa_remove_backup_phone".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_REMOVE_BACKUP_PHONE;
            } else if ("tfa_remove_security_key".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_REMOVE_SECURITY_KEY;
            } else if ("tfa_reset".equals(tag)) {
                eventTypeArg = EventTypeArg.TFA_RESET;
            } else if ("changed_enterprise_admin_role".equals(tag)) {
                eventTypeArg = EventTypeArg.CHANGED_ENTERPRISE_ADMIN_ROLE;
            } else if ("changed_enterprise_connected_team_status".equals(tag)) {
                eventTypeArg = EventTypeArg.CHANGED_ENTERPRISE_CONNECTED_TEAM_STATUS;
            } else if ("ended_enterprise_admin_session".equals(tag)) {
                eventTypeArg = EventTypeArg.ENDED_ENTERPRISE_ADMIN_SESSION;
            } else if ("ended_enterprise_admin_session_deprecated".equals(tag)) {
                eventTypeArg = EventTypeArg.ENDED_ENTERPRISE_ADMIN_SESSION_DEPRECATED;
            } else if ("enterprise_settings_locking".equals(tag)) {
                eventTypeArg = EventTypeArg.ENTERPRISE_SETTINGS_LOCKING;
            } else if ("guest_admin_change_status".equals(tag)) {
                eventTypeArg = EventTypeArg.GUEST_ADMIN_CHANGE_STATUS;
            } else if ("started_enterprise_admin_session".equals(tag)) {
                eventTypeArg = EventTypeArg.STARTED_ENTERPRISE_ADMIN_SESSION;
            } else if ("team_merge_request_accepted".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_ACCEPTED;
            } else if ("team_merge_request_accepted_shown_to_primary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_PRIMARY_TEAM;
            } else if ("team_merge_request_accepted_shown_to_secondary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_SECONDARY_TEAM;
            } else if ("team_merge_request_auto_canceled".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_AUTO_CANCELED;
            } else if ("team_merge_request_canceled".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_CANCELED;
            } else if ("team_merge_request_canceled_shown_to_primary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_PRIMARY_TEAM;
            } else if ("team_merge_request_canceled_shown_to_secondary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_SECONDARY_TEAM;
            } else if ("team_merge_request_expired".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_EXPIRED;
            } else if ("team_merge_request_expired_shown_to_primary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_PRIMARY_TEAM;
            } else if ("team_merge_request_expired_shown_to_secondary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_SECONDARY_TEAM;
            } else if ("team_merge_request_rejected_shown_to_primary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_PRIMARY_TEAM;
            } else if ("team_merge_request_rejected_shown_to_secondary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_SECONDARY_TEAM;
            } else if ("team_merge_request_reminder".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_REMINDER;
            } else if ("team_merge_request_reminder_shown_to_primary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_PRIMARY_TEAM;
            } else if ("team_merge_request_reminder_shown_to_secondary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_SECONDARY_TEAM;
            } else if ("team_merge_request_revoked".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_REVOKED;
            } else if ("team_merge_request_sent_shown_to_primary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_SENT_SHOWN_TO_PRIMARY_TEAM;
            } else if ("team_merge_request_sent_shown_to_secondary_team".equals(tag)) {
                eventTypeArg = EventTypeArg.TEAM_MERGE_REQUEST_SENT_SHOWN_TO_SECONDARY_TEAM;
            } else {
                eventTypeArg = EventTypeArg.OTHER;
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return eventTypeArg;
        }
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.teamlog.EventTypeArg$1 */
    static /* synthetic */ class C44671 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg;

        static {
            int[] iArr = new int[EventTypeArg.values().length];
            $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg = iArr;
            try {
                iArr[EventTypeArg.ADMIN_ALERTING_ALERT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ADMIN_ALERTING_CHANGED_ALERT_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ADMIN_ALERTING_TRIGGERED_ALERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.RANSOMWARE_RESTORE_PROCESS_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.RANSOMWARE_RESTORE_PROCESS_STARTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.APP_BLOCKED_BY_PERMISSIONS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.APP_LINK_TEAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.APP_LINK_USER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.APP_UNLINK_TEAM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.APP_UNLINK_USER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.INTEGRATION_CONNECTED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.INTEGRATION_DISCONNECTED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_ADD_COMMENT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_CHANGE_COMMENT_SUBSCRIPTION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_DELETE_COMMENT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_EDIT_COMMENT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_LIKE_COMMENT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_RESOLVE_COMMENT.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_UNLIKE_COMMENT.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_UNRESOLVE_COMMENT.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_ADD_FOLDERS.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_ADD_FOLDER_FAILED.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_CONTENT_DISPOSED.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_CREATE.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_DELETE.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_EDIT_DETAILS.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_EDIT_DURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_EXPORT_CREATED.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_EXPORT_REMOVED.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_REMOVE_FOLDERS.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_REPORT_CREATED.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOVERNANCE_POLICY_ZIP_PART_DOWNLOADED.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_ACTIVATE_A_HOLD.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_ADD_MEMBERS.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_CHANGE_HOLD_DETAILS.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_CHANGE_HOLD_NAME.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_EXPORT_A_HOLD.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_EXPORT_CANCELLED.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_EXPORT_DOWNLOADED.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_EXPORT_REMOVED.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_RELEASE_A_HOLD.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_REMOVE_MEMBERS.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LEGAL_HOLDS_REPORT_A_HOLD.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_CHANGE_IP_DESKTOP.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_CHANGE_IP_MOBILE.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_CHANGE_IP_WEB.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_DELETE_ON_UNLINK_FAIL.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_DELETE_ON_UNLINK_SUCCESS.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_LINK_FAIL.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_LINK_SUCCESS.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_MANAGEMENT_DISABLED.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_MANAGEMENT_ENABLED.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_SYNC_BACKUP_STATUS_CHANGED.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_UNLINK.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DROPBOX_PASSWORDS_EXPORTED.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DROPBOX_PASSWORDS_NEW_DEVICE_ENROLLED.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EMM_REFRESH_AUTH_TOKEN.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EXTERNAL_DRIVE_BACKUP_ELIGIBILITY_STATUS_CHECKED.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EXTERNAL_DRIVE_BACKUP_STATUS_CHANGED.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ACCOUNT_CAPTURE_CHANGE_AVAILABILITY.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ACCOUNT_CAPTURE_MIGRATE_ACCOUNT.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ACCOUNT_CAPTURE_NOTIFICATION_EMAILS_SENT.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ACCOUNT_CAPTURE_RELINQUISH_ACCOUNT.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DISABLED_DOMAIN_INVITES.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DOMAIN_INVITES_APPROVE_REQUEST_TO_JOIN_TEAM.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DOMAIN_INVITES_DECLINE_REQUEST_TO_JOIN_TEAM.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DOMAIN_INVITES_EMAIL_EXISTING_USERS.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DOMAIN_INVITES_REQUEST_TO_JOIN_TEAM.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_NO.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DOMAIN_INVITES_SET_INVITE_NEW_USER_PREF_TO_YES.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DOMAIN_VERIFICATION_ADD_DOMAIN_FAIL.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DOMAIN_VERIFICATION_ADD_DOMAIN_SUCCESS.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DOMAIN_VERIFICATION_REMOVE_DOMAIN.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ENABLED_DOMAIN_INVITES.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_ENCRYPTION_KEY_CANCEL_KEY_DELETION.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_ENCRYPTION_KEY_CREATE_KEY.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_ENCRYPTION_KEY_DELETE_KEY.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_ENCRYPTION_KEY_DISABLE_KEY.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_ENCRYPTION_KEY_ENABLE_KEY.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_ENCRYPTION_KEY_ROTATE_KEY.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_ENCRYPTION_KEY_SCHEDULE_KEY_DELETION.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.APPLY_NAMING_CONVENTION.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CREATE_FOLDER.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_ADD.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_ADD_FROM_AUTOMATION.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_COPY.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_DELETE.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_DOWNLOAD.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_EDIT.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_GET_COPY_REFERENCE.ordinal()] = 90;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_LOCKING_LOCK_STATUS_CHANGED.ordinal()] = 91;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_MOVE.ordinal()] = 92;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_PERMANENTLY_DELETE.ordinal()] = 93;
            } catch (NoSuchFieldError unused93) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_PREVIEW.ordinal()] = 94;
            } catch (NoSuchFieldError unused94) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_RENAME.ordinal()] = 95;
            } catch (NoSuchFieldError unused95) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_RESTORE.ordinal()] = 96;
            } catch (NoSuchFieldError unused96) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_REVERT.ordinal()] = 97;
            } catch (NoSuchFieldError unused97) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_ROLLBACK_CHANGES.ordinal()] = 98;
            } catch (NoSuchFieldError unused98) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_SAVE_COPY_REFERENCE.ordinal()] = 99;
            } catch (NoSuchFieldError unused99) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FOLDER_OVERVIEW_DESCRIPTION_CHANGED.ordinal()] = 100;
            } catch (NoSuchFieldError unused100) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FOLDER_OVERVIEW_ITEM_PINNED.ordinal()] = 101;
            } catch (NoSuchFieldError unused101) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FOLDER_OVERVIEW_ITEM_UNPINNED.ordinal()] = 102;
            } catch (NoSuchFieldError unused102) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.OBJECT_LABEL_ADDED.ordinal()] = 103;
            } catch (NoSuchFieldError unused103) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.OBJECT_LABEL_REMOVED.ordinal()] = 104;
            } catch (NoSuchFieldError unused104) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.OBJECT_LABEL_UPDATED_VALUE.ordinal()] = 105;
            } catch (NoSuchFieldError unused105) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ORGANIZE_FOLDER_WITH_TIDY.ordinal()] = 106;
            } catch (NoSuchFieldError unused106) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.REPLAY_FILE_DELETE.ordinal()] = 107;
            } catch (NoSuchFieldError unused107) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.REWIND_FOLDER.ordinal()] = 108;
            } catch (NoSuchFieldError unused108) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.UNDO_NAMING_CONVENTION.ordinal()] = 109;
            } catch (NoSuchFieldError unused109) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.UNDO_ORGANIZE_FOLDER_WITH_TIDY.ordinal()] = 110;
            } catch (NoSuchFieldError unused110) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.USER_TAGS_ADDED.ordinal()] = 111;
            } catch (NoSuchFieldError unused111) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.USER_TAGS_REMOVED.ordinal()] = 112;
            } catch (NoSuchFieldError unused112) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EMAIL_INGEST_RECEIVE_FILE.ordinal()] = 113;
            } catch (NoSuchFieldError unused113) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_REQUEST_CHANGE.ordinal()] = 114;
            } catch (NoSuchFieldError unused114) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_REQUEST_CLOSE.ordinal()] = 115;
            } catch (NoSuchFieldError unused115) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_REQUEST_CREATE.ordinal()] = 116;
            } catch (NoSuchFieldError unused116) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_REQUEST_DELETE.ordinal()] = 117;
            } catch (NoSuchFieldError unused117) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_REQUEST_RECEIVE_FILE.ordinal()] = 118;
            } catch (NoSuchFieldError unused118) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_ADD_EXTERNAL_ID.ordinal()] = 119;
            } catch (NoSuchFieldError unused119) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_ADD_MEMBER.ordinal()] = 120;
            } catch (NoSuchFieldError unused120) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_CHANGE_EXTERNAL_ID.ordinal()] = 121;
            } catch (NoSuchFieldError unused121) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_CHANGE_MANAGEMENT_TYPE.ordinal()] = 122;
            } catch (NoSuchFieldError unused122) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_CHANGE_MEMBER_ROLE.ordinal()] = 123;
            } catch (NoSuchFieldError unused123) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_CREATE.ordinal()] = 124;
            } catch (NoSuchFieldError unused124) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_DELETE.ordinal()] = 125;
            } catch (NoSuchFieldError unused125) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_DESCRIPTION_UPDATED.ordinal()] = 126;
            } catch (NoSuchFieldError unused126) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_JOIN_POLICY_UPDATED.ordinal()] = 127;
            } catch (NoSuchFieldError unused127) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_MOVED.ordinal()] = 128;
            } catch (NoSuchFieldError unused128) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_REMOVE_EXTERNAL_ID.ordinal()] = 129;
            } catch (NoSuchFieldError unused129) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_REMOVE_MEMBER.ordinal()] = 130;
            } catch (NoSuchFieldError unused130) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_RENAME.ordinal()] = 131;
            } catch (NoSuchFieldError unused131) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ACCOUNT_LOCK_OR_UNLOCKED.ordinal()] = 132;
            } catch (NoSuchFieldError unused132) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EMM_ERROR.ordinal()] = 133;
            } catch (NoSuchFieldError unused133) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GUEST_ADMIN_SIGNED_IN_VIA_TRUSTED_TEAMS.ordinal()] = 134;
            } catch (NoSuchFieldError unused134) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GUEST_ADMIN_SIGNED_OUT_VIA_TRUSTED_TEAMS.ordinal()] = 135;
            } catch (NoSuchFieldError unused135) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LOGIN_FAIL.ordinal()] = 136;
            } catch (NoSuchFieldError unused136) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LOGIN_SUCCESS.ordinal()] = 137;
            } catch (NoSuchFieldError unused137) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.LOGOUT.ordinal()] = 138;
            } catch (NoSuchFieldError unused138) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.RESELLER_SUPPORT_SESSION_END.ordinal()] = 139;
            } catch (NoSuchFieldError unused139) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.RESELLER_SUPPORT_SESSION_START.ordinal()] = 140;
            } catch (NoSuchFieldError unused140) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SIGN_IN_AS_SESSION_END.ordinal()] = 141;
            } catch (NoSuchFieldError unused141) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SIGN_IN_AS_SESSION_START.ordinal()] = 142;
            } catch (NoSuchFieldError unused142) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_ERROR.ordinal()] = 143;
            } catch (NoSuchFieldError unused143) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BACKUP_ADMIN_INVITATION_SENT.ordinal()] = 144;
            } catch (NoSuchFieldError unused144) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BACKUP_INVITATION_OPENED.ordinal()] = 145;
            } catch (NoSuchFieldError unused145) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CREATE_TEAM_INVITE_LINK.ordinal()] = 146;
            } catch (NoSuchFieldError unused146) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DELETE_TEAM_INVITE_LINK.ordinal()] = 147;
            } catch (NoSuchFieldError unused147) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_ADD_EXTERNAL_ID.ordinal()] = 148;
            } catch (NoSuchFieldError unused148) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_ADD_NAME.ordinal()] = 149;
            } catch (NoSuchFieldError unused149) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_CHANGE_ADMIN_ROLE.ordinal()] = 150;
            } catch (NoSuchFieldError unused150) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_CHANGE_EMAIL.ordinal()] = 151;
            } catch (NoSuchFieldError unused151) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_CHANGE_EXTERNAL_ID.ordinal()] = 152;
            } catch (NoSuchFieldError unused152) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_CHANGE_MEMBERSHIP_TYPE.ordinal()] = 153;
            } catch (NoSuchFieldError unused153) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_CHANGE_NAME.ordinal()] = 154;
            } catch (NoSuchFieldError unused154) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_CHANGE_RESELLER_ROLE.ordinal()] = 155;
            } catch (NoSuchFieldError unused155) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_CHANGE_STATUS.ordinal()] = 156;
            } catch (NoSuchFieldError unused156) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_DELETE_MANUAL_CONTACTS.ordinal()] = 157;
            } catch (NoSuchFieldError unused157) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_DELETE_PROFILE_PHOTO.ordinal()] = 158;
            } catch (NoSuchFieldError unused158) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_PERMANENTLY_DELETE_ACCOUNT_CONTENTS.ordinal()] = 159;
            } catch (NoSuchFieldError unused159) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_REMOVE_EXTERNAL_ID.ordinal()] = 160;
            } catch (NoSuchFieldError unused160) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SET_PROFILE_PHOTO.ordinal()] = 161;
            } catch (NoSuchFieldError unused161) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SPACE_LIMITS_ADD_CUSTOM_QUOTA.ordinal()] = 162;
            } catch (NoSuchFieldError unused162) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_CUSTOM_QUOTA.ordinal()] = 163;
            } catch (NoSuchFieldError unused163) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_STATUS.ordinal()] = 164;
            } catch (NoSuchFieldError unused164) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SPACE_LIMITS_REMOVE_CUSTOM_QUOTA.ordinal()] = 165;
            } catch (NoSuchFieldError unused165) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SUGGEST.ordinal()] = 166;
            } catch (NoSuchFieldError unused166) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_TRANSFER_ACCOUNT_CONTENTS.ordinal()] = 167;
            } catch (NoSuchFieldError unused167) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PENDING_SECONDARY_EMAIL_ADDED.ordinal()] = 168;
            } catch (NoSuchFieldError unused168) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SECONDARY_EMAIL_DELETED.ordinal()] = 169;
            } catch (NoSuchFieldError unused169) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SECONDARY_EMAIL_VERIFIED.ordinal()] = 170;
            } catch (NoSuchFieldError unused170) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SECONDARY_MAILS_POLICY_CHANGED.ordinal()] = 171;
            } catch (NoSuchFieldError unused171) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BINDER_ADD_PAGE.ordinal()] = 172;
            } catch (NoSuchFieldError unused172) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BINDER_ADD_SECTION.ordinal()] = 173;
            } catch (NoSuchFieldError unused173) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BINDER_REMOVE_PAGE.ordinal()] = 174;
            } catch (NoSuchFieldError unused174) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BINDER_REMOVE_SECTION.ordinal()] = 175;
            } catch (NoSuchFieldError unused175) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BINDER_RENAME_PAGE.ordinal()] = 176;
            } catch (NoSuchFieldError unused176) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BINDER_RENAME_SECTION.ordinal()] = 177;
            } catch (NoSuchFieldError unused177) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BINDER_REORDER_PAGE.ordinal()] = 178;
            } catch (NoSuchFieldError unused178) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.BINDER_REORDER_SECTION.ordinal()] = 179;
            } catch (NoSuchFieldError unused179) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CONTENT_ADD_MEMBER.ordinal()] = 180;
            } catch (NoSuchFieldError unused180) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CONTENT_ADD_TO_FOLDER.ordinal()] = 181;
            } catch (NoSuchFieldError unused181) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CONTENT_ARCHIVE.ordinal()] = 182;
            } catch (NoSuchFieldError unused182) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CONTENT_CREATE.ordinal()] = 183;
            } catch (NoSuchFieldError unused183) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CONTENT_PERMANENTLY_DELETE.ordinal()] = 184;
            } catch (NoSuchFieldError unused184) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CONTENT_REMOVE_FROM_FOLDER.ordinal()] = 185;
            } catch (NoSuchFieldError unused185) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CONTENT_REMOVE_MEMBER.ordinal()] = 186;
            } catch (NoSuchFieldError unused186) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CONTENT_RENAME.ordinal()] = 187;
            } catch (NoSuchFieldError unused187) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CONTENT_RESTORE.ordinal()] = 188;
            } catch (NoSuchFieldError unused188) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_ADD_COMMENT.ordinal()] = 189;
            } catch (NoSuchFieldError unused189) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_CHANGE_MEMBER_ROLE.ordinal()] = 190;
            } catch (NoSuchFieldError unused190) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_CHANGE_SHARING_POLICY.ordinal()] = 191;
            } catch (NoSuchFieldError unused191) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_CHANGE_SUBSCRIPTION.ordinal()] = 192;
            } catch (NoSuchFieldError unused192) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_DELETED.ordinal()] = 193;
            } catch (NoSuchFieldError unused193) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_DELETE_COMMENT.ordinal()] = 194;
            } catch (NoSuchFieldError unused194) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_DOWNLOAD.ordinal()] = 195;
            } catch (NoSuchFieldError unused195) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_EDIT.ordinal()] = 196;
            } catch (NoSuchFieldError unused196) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_EDIT_COMMENT.ordinal()] = 197;
            } catch (NoSuchFieldError unused197) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_FOLLOWED.ordinal()] = 198;
            } catch (NoSuchFieldError unused198) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_MENTION.ordinal()] = 199;
            } catch (NoSuchFieldError unused199) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_OWNERSHIP_CHANGED.ordinal()] = 200;
            } catch (NoSuchFieldError unused200) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_REQUEST_ACCESS.ordinal()] = 201;
            } catch (NoSuchFieldError unused201) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_RESOLVE_COMMENT.ordinal()] = 202;
            } catch (NoSuchFieldError unused202) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_REVERT.ordinal()] = 203;
            } catch (NoSuchFieldError unused203) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_SLACK_SHARE.ordinal()] = 204;
            } catch (NoSuchFieldError unused204) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_TEAM_INVITE.ordinal()] = 205;
            } catch (NoSuchFieldError unused205) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_TRASHED.ordinal()] = 206;
            } catch (NoSuchFieldError unused206) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_UNRESOLVE_COMMENT.ordinal()] = 207;
            } catch (NoSuchFieldError unused207) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_UNTRASHED.ordinal()] = 208;
            } catch (NoSuchFieldError unused208) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DOC_VIEW.ordinal()] = 209;
            } catch (NoSuchFieldError unused209) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_EXTERNAL_VIEW_ALLOW.ordinal()] = 210;
            } catch (NoSuchFieldError unused210) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_EXTERNAL_VIEW_DEFAULT_TEAM.ordinal()] = 211;
            } catch (NoSuchFieldError unused211) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_EXTERNAL_VIEW_FORBID.ordinal()] = 212;
            } catch (NoSuchFieldError unused212) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_FOLDER_CHANGE_SUBSCRIPTION.ordinal()] = 213;
            } catch (NoSuchFieldError unused213) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_FOLDER_DELETED.ordinal()] = 214;
            } catch (NoSuchFieldError unused214) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_FOLDER_FOLLOWED.ordinal()] = 215;
            } catch (NoSuchFieldError unused215) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_FOLDER_TEAM_INVITE.ordinal()] = 216;
            } catch (NoSuchFieldError unused216) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_PUBLISHED_LINK_CHANGE_PERMISSION.ordinal()] = 217;
            } catch (NoSuchFieldError unused217) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_PUBLISHED_LINK_CREATE.ordinal()] = 218;
            } catch (NoSuchFieldError unused218) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_PUBLISHED_LINK_DISABLED.ordinal()] = 219;
            } catch (NoSuchFieldError unused219) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_PUBLISHED_LINK_VIEW.ordinal()] = 220;
            } catch (NoSuchFieldError unused220) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PASSWORD_CHANGE.ordinal()] = 221;
            } catch (NoSuchFieldError unused221) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PASSWORD_RESET.ordinal()] = 222;
            } catch (NoSuchFieldError unused222) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PASSWORD_RESET_ALL.ordinal()] = 223;
            } catch (NoSuchFieldError unused223) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CLASSIFICATION_CREATE_REPORT.ordinal()] = 224;
            } catch (NoSuchFieldError unused224) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CLASSIFICATION_CREATE_REPORT_FAIL.ordinal()] = 225;
            } catch (NoSuchFieldError unused225) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EMM_CREATE_EXCEPTIONS_REPORT.ordinal()] = 226;
            } catch (NoSuchFieldError unused226) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EMM_CREATE_USAGE_REPORT.ordinal()] = 227;
            } catch (NoSuchFieldError unused227) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EXPORT_MEMBERS_REPORT.ordinal()] = 228;
            } catch (NoSuchFieldError unused228) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EXPORT_MEMBERS_REPORT_FAIL.ordinal()] = 229;
            } catch (NoSuchFieldError unused229) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EXTERNAL_SHARING_CREATE_REPORT.ordinal()] = 230;
            } catch (NoSuchFieldError unused230) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EXTERNAL_SHARING_REPORT_FAILED.ordinal()] = 231;
            } catch (NoSuchFieldError unused231) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NO_EXPIRATION_LINK_GEN_CREATE_REPORT.ordinal()] = 232;
            } catch (NoSuchFieldError unused232) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NO_EXPIRATION_LINK_GEN_REPORT_FAILED.ordinal()] = 233;
            } catch (NoSuchFieldError unused233) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NO_PASSWORD_LINK_GEN_CREATE_REPORT.ordinal()] = 234;
            } catch (NoSuchFieldError unused234) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NO_PASSWORD_LINK_GEN_REPORT_FAILED.ordinal()] = 235;
            } catch (NoSuchFieldError unused235) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NO_PASSWORD_LINK_VIEW_CREATE_REPORT.ordinal()] = 236;
            } catch (NoSuchFieldError unused236) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NO_PASSWORD_LINK_VIEW_REPORT_FAILED.ordinal()] = 237;
            } catch (NoSuchFieldError unused237) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.OUTDATED_LINK_VIEW_CREATE_REPORT.ordinal()] = 238;
            } catch (NoSuchFieldError unused238) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.OUTDATED_LINK_VIEW_REPORT_FAILED.ordinal()] = 239;
            } catch (NoSuchFieldError unused239) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_ADMIN_EXPORT_START.ordinal()] = 240;
            } catch (NoSuchFieldError unused240) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.RANSOMWARE_ALERT_CREATE_REPORT.ordinal()] = 241;
            } catch (NoSuchFieldError unused241) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.RANSOMWARE_ALERT_CREATE_REPORT_FAILED.ordinal()] = 242;
            } catch (NoSuchFieldError unused242) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SMART_SYNC_CREATE_ADMIN_PRIVILEGE_REPORT.ordinal()] = 243;
            } catch (NoSuchFieldError unused243) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_ACTIVITY_CREATE_REPORT.ordinal()] = 244;
            } catch (NoSuchFieldError unused244) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_ACTIVITY_CREATE_REPORT_FAIL.ordinal()] = 245;
            } catch (NoSuchFieldError unused245) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.COLLECTION_SHARE.ordinal()] = 246;
            } catch (NoSuchFieldError unused246) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_TRANSFERS_FILE_ADD.ordinal()] = 247;
            } catch (NoSuchFieldError unused247) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_TRANSFERS_TRANSFER_DELETE.ordinal()] = 248;
            } catch (NoSuchFieldError unused248) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_TRANSFERS_TRANSFER_DOWNLOAD.ordinal()] = 249;
            } catch (NoSuchFieldError unused249) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_TRANSFERS_TRANSFER_SEND.ordinal()] = 250;
            } catch (NoSuchFieldError unused250) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_TRANSFERS_TRANSFER_VIEW.ordinal()] = 251;
            } catch (NoSuchFieldError unused251) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NOTE_ACL_INVITE_ONLY.ordinal()] = 252;
            } catch (NoSuchFieldError unused252) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NOTE_ACL_LINK.ordinal()] = 253;
            } catch (NoSuchFieldError unused253) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NOTE_ACL_TEAM_LINK.ordinal()] = 254;
            } catch (NoSuchFieldError unused254) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NOTE_SHARED.ordinal()] = 255;
            } catch (NoSuchFieldError unused255) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NOTE_SHARE_RECEIVE.ordinal()] = 256;
            } catch (NoSuchFieldError unused256) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.OPEN_NOTE_SHARED.ordinal()] = 257;
            } catch (NoSuchFieldError unused257) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.REPLAY_FILE_SHARED_LINK_CREATED.ordinal()] = 258;
            } catch (NoSuchFieldError unused258) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.REPLAY_FILE_SHARED_LINK_MODIFIED.ordinal()] = 259;
            } catch (NoSuchFieldError unused259) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.REPLAY_PROJECT_TEAM_ADD.ordinal()] = 260;
            } catch (NoSuchFieldError unused260) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.REPLAY_PROJECT_TEAM_DELETE.ordinal()] = 261;
            } catch (NoSuchFieldError unused261) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_ADD_GROUP.ordinal()] = 262;
            } catch (NoSuchFieldError unused262) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_ALLOW_NON_MEMBERS_TO_VIEW_SHARED_LINKS.ordinal()] = 263;
            } catch (NoSuchFieldError unused263) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_EXTERNAL_INVITE_WARN.ordinal()] = 264;
            } catch (NoSuchFieldError unused264) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_FB_INVITE.ordinal()] = 265;
            } catch (NoSuchFieldError unused265) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_FB_INVITE_CHANGE_ROLE.ordinal()] = 266;
            } catch (NoSuchFieldError unused266) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_FB_UNINVITE.ordinal()] = 267;
            } catch (NoSuchFieldError unused267) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_INVITE_GROUP.ordinal()] = 268;
            } catch (NoSuchFieldError unused268) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_TEAM_GRANT_ACCESS.ordinal()] = 269;
            } catch (NoSuchFieldError unused269) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_TEAM_INVITE.ordinal()] = 270;
            } catch (NoSuchFieldError unused270) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_TEAM_INVITE_CHANGE_ROLE.ordinal()] = 271;
            } catch (NoSuchFieldError unused271) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_TEAM_JOIN.ordinal()] = 272;
            } catch (NoSuchFieldError unused272) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_TEAM_JOIN_FROM_OOB_LINK.ordinal()] = 273;
            } catch (NoSuchFieldError unused273) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SF_TEAM_UNINVITE.ordinal()] = 274;
            } catch (NoSuchFieldError unused274) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_ADD_INVITEES.ordinal()] = 275;
            } catch (NoSuchFieldError unused275) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_ADD_LINK_EXPIRY.ordinal()] = 276;
            } catch (NoSuchFieldError unused276) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_ADD_LINK_PASSWORD.ordinal()] = 277;
            } catch (NoSuchFieldError unused277) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_ADD_MEMBER.ordinal()] = 278;
            } catch (NoSuchFieldError unused278) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_CHANGE_DOWNLOADS_POLICY.ordinal()] = 279;
            } catch (NoSuchFieldError unused279) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_CHANGE_INVITEE_ROLE.ordinal()] = 280;
            } catch (NoSuchFieldError unused280) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_CHANGE_LINK_AUDIENCE.ordinal()] = 281;
            } catch (NoSuchFieldError unused281) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_CHANGE_LINK_EXPIRY.ordinal()] = 282;
            } catch (NoSuchFieldError unused282) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_CHANGE_LINK_PASSWORD.ordinal()] = 283;
            } catch (NoSuchFieldError unused283) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_CHANGE_MEMBER_ROLE.ordinal()] = 284;
            } catch (NoSuchFieldError unused284) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_CHANGE_VIEWER_INFO_POLICY.ordinal()] = 285;
            } catch (NoSuchFieldError unused285) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_CLAIM_INVITATION.ordinal()] = 286;
            } catch (NoSuchFieldError unused286) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_COPY.ordinal()] = 287;
            } catch (NoSuchFieldError unused287) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_DOWNLOAD.ordinal()] = 288;
            } catch (NoSuchFieldError unused288) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_RELINQUISH_MEMBERSHIP.ordinal()] = 289;
            } catch (NoSuchFieldError unused289) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_REMOVE_INVITEES.ordinal()] = 290;
            } catch (NoSuchFieldError unused290) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_REMOVE_LINK_EXPIRY.ordinal()] = 291;
            } catch (NoSuchFieldError unused291) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_REMOVE_LINK_PASSWORD.ordinal()] = 292;
            } catch (NoSuchFieldError unused292) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_REMOVE_MEMBER.ordinal()] = 293;
            } catch (NoSuchFieldError unused293) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_REQUEST_ACCESS.ordinal()] = 294;
            } catch (NoSuchFieldError unused294) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_RESTORE_INVITEES.ordinal()] = 295;
            } catch (NoSuchFieldError unused295) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_RESTORE_MEMBER.ordinal()] = 296;
            } catch (NoSuchFieldError unused296) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_UNSHARE.ordinal()] = 297;
            } catch (NoSuchFieldError unused297) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_CONTENT_VIEW.ordinal()] = 298;
            } catch (NoSuchFieldError unused298) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_CHANGE_LINK_POLICY.ordinal()] = 299;
            } catch (NoSuchFieldError unused299) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_CHANGE_MEMBERS_INHERITANCE_POLICY.ordinal()] = 300;
            } catch (NoSuchFieldError unused300) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_CHANGE_MEMBERS_MANAGEMENT_POLICY.ordinal()] = 301;
            } catch (NoSuchFieldError unused301) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_CHANGE_MEMBERS_POLICY.ordinal()] = 302;
            } catch (NoSuchFieldError unused302) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_CREATE.ordinal()] = 303;
            } catch (NoSuchFieldError unused303) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_DECLINE_INVITATION.ordinal()] = 304;
            } catch (NoSuchFieldError unused304) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_MOUNT.ordinal()] = 305;
            } catch (NoSuchFieldError unused305) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_NEST.ordinal()] = 306;
            } catch (NoSuchFieldError unused306) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_TRANSFER_OWNERSHIP.ordinal()] = 307;
            } catch (NoSuchFieldError unused307) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_FOLDER_UNMOUNT.ordinal()] = 308;
            } catch (NoSuchFieldError unused308) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_ADD_EXPIRY.ordinal()] = 309;
            } catch (NoSuchFieldError unused309) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_CHANGE_EXPIRY.ordinal()] = 310;
            } catch (NoSuchFieldError unused310) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_CHANGE_VISIBILITY.ordinal()] = 311;
            } catch (NoSuchFieldError unused311) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_COPY.ordinal()] = 312;
            } catch (NoSuchFieldError unused312) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_CREATE.ordinal()] = 313;
            } catch (NoSuchFieldError unused313) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_DISABLE.ordinal()] = 314;
            } catch (NoSuchFieldError unused314) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_DOWNLOAD.ordinal()] = 315;
            } catch (NoSuchFieldError unused315) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_REMOVE_EXPIRY.ordinal()] = 316;
            } catch (NoSuchFieldError unused316) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SETTINGS_ADD_EXPIRATION.ordinal()] = 317;
            } catch (NoSuchFieldError unused317) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SETTINGS_ADD_PASSWORD.ordinal()] = 318;
            } catch (NoSuchFieldError unused318) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_DISABLED.ordinal()] = 319;
            } catch (NoSuchFieldError unused319) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SETTINGS_ALLOW_DOWNLOAD_ENABLED.ordinal()] = 320;
            } catch (NoSuchFieldError unused320) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SETTINGS_CHANGE_AUDIENCE.ordinal()] = 321;
            } catch (NoSuchFieldError unused321) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SETTINGS_CHANGE_EXPIRATION.ordinal()] = 322;
            } catch (NoSuchFieldError unused322) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SETTINGS_CHANGE_PASSWORD.ordinal()] = 323;
            } catch (NoSuchFieldError unused323) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SETTINGS_REMOVE_EXPIRATION.ordinal()] = 324;
            } catch (NoSuchFieldError unused324) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SETTINGS_REMOVE_PASSWORD.ordinal()] = 325;
            } catch (NoSuchFieldError unused325) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_SHARE.ordinal()] = 326;
            } catch (NoSuchFieldError unused326) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_LINK_VIEW.ordinal()] = 327;
            } catch (NoSuchFieldError unused327) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARED_NOTE_OPENED.ordinal()] = 328;
            } catch (NoSuchFieldError unused328) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHMODEL_DISABLE_DOWNLOADS.ordinal()] = 329;
            } catch (NoSuchFieldError unused329) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHMODEL_ENABLE_DOWNLOADS.ordinal()] = 330;
            } catch (NoSuchFieldError unused330) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHMODEL_GROUP_SHARE.ordinal()] = 331;
            } catch (NoSuchFieldError unused331) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_ACCESS_GRANTED.ordinal()] = 332;
            } catch (NoSuchFieldError unused332) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_ADD_MEMBER.ordinal()] = 333;
            } catch (NoSuchFieldError unused333) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_ARCHIVED.ordinal()] = 334;
            } catch (NoSuchFieldError unused334) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_CREATED.ordinal()] = 335;
            } catch (NoSuchFieldError unused335) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_DELETE_COMMENT.ordinal()] = 336;
            } catch (NoSuchFieldError unused336) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_EDITED.ordinal()] = 337;
            } catch (NoSuchFieldError unused337) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_EDIT_COMMENT.ordinal()] = 338;
            } catch (NoSuchFieldError unused338) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_FILE_ADDED.ordinal()] = 339;
            } catch (NoSuchFieldError unused339) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_FILE_DOWNLOAD.ordinal()] = 340;
            } catch (NoSuchFieldError unused340) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_FILE_REMOVED.ordinal()] = 341;
            } catch (NoSuchFieldError unused341) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_FILE_VIEW.ordinal()] = 342;
            } catch (NoSuchFieldError unused342) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_PERMANENTLY_DELETED.ordinal()] = 343;
            } catch (NoSuchFieldError unused343) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_POST_COMMENT.ordinal()] = 344;
            } catch (NoSuchFieldError unused344) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_REMOVE_MEMBER.ordinal()] = 345;
            } catch (NoSuchFieldError unused345) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_RENAMED.ordinal()] = 346;
            } catch (NoSuchFieldError unused346) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_REQUEST_ACCESS.ordinal()] = 347;
            } catch (NoSuchFieldError unused347) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_RESOLVE_COMMENT.ordinal()] = 348;
            } catch (NoSuchFieldError unused348) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_RESTORED.ordinal()] = 349;
            } catch (NoSuchFieldError unused349) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_TRASHED.ordinal()] = 350;
            } catch (NoSuchFieldError unused350) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_TRASHED_DEPRECATED.ordinal()] = 351;
            } catch (NoSuchFieldError unused351) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_UNRESOLVE_COMMENT.ordinal()] = 352;
            } catch (NoSuchFieldError unused352) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_UNTRASHED.ordinal()] = 353;
            } catch (NoSuchFieldError unused353) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_UNTRASHED_DEPRECATED.ordinal()] = 354;
            } catch (NoSuchFieldError unused354) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_VIEW.ordinal()] = 355;
            } catch (NoSuchFieldError unused355) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_ADD_CERT.ordinal()] = 356;
            } catch (NoSuchFieldError unused356) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_ADD_LOGIN_URL.ordinal()] = 357;
            } catch (NoSuchFieldError unused357) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_ADD_LOGOUT_URL.ordinal()] = 358;
            } catch (NoSuchFieldError unused358) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_CHANGE_CERT.ordinal()] = 359;
            } catch (NoSuchFieldError unused359) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_CHANGE_LOGIN_URL.ordinal()] = 360;
            } catch (NoSuchFieldError unused360) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_CHANGE_LOGOUT_URL.ordinal()] = 361;
            } catch (NoSuchFieldError unused361) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_CHANGE_SAML_IDENTITY_MODE.ordinal()] = 362;
            } catch (NoSuchFieldError unused362) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_REMOVE_CERT.ordinal()] = 363;
            } catch (NoSuchFieldError unused363) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_REMOVE_LOGIN_URL.ordinal()] = 364;
            } catch (NoSuchFieldError unused364) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_REMOVE_LOGOUT_URL.ordinal()] = 365;
            } catch (NoSuchFieldError unused365) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_FOLDER_CHANGE_STATUS.ordinal()] = 366;
            } catch (NoSuchFieldError unused366) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_FOLDER_CREATE.ordinal()] = 367;
            } catch (NoSuchFieldError unused367) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_FOLDER_DOWNGRADE.ordinal()] = 368;
            } catch (NoSuchFieldError unused368) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_FOLDER_PERMANENTLY_DELETE.ordinal()] = 369;
            } catch (NoSuchFieldError unused369) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_FOLDER_RENAME.ordinal()] = 370;
            } catch (NoSuchFieldError unused370) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_SELECTIVE_SYNC_SETTINGS_CHANGED.ordinal()] = 371;
            } catch (NoSuchFieldError unused371) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ACCOUNT_CAPTURE_CHANGE_POLICY.ordinal()] = 372;
            } catch (NoSuchFieldError unused372) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ADMIN_EMAIL_REMINDERS_CHANGED.ordinal()] = 373;
            } catch (NoSuchFieldError unused373) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ALLOW_DOWNLOAD_DISABLED.ordinal()] = 374;
            } catch (NoSuchFieldError unused374) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ALLOW_DOWNLOAD_ENABLED.ordinal()] = 375;
            } catch (NoSuchFieldError unused375) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.APP_PERMISSIONS_CHANGED.ordinal()] = 376;
            } catch (NoSuchFieldError unused376) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CAMERA_UPLOADS_POLICY_CHANGED.ordinal()] = 377;
            } catch (NoSuchFieldError unused377) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CAPTURE_TRANSCRIPT_POLICY_CHANGED.ordinal()] = 378;
            } catch (NoSuchFieldError unused378) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CLASSIFICATION_CHANGE_POLICY.ordinal()] = 379;
            } catch (NoSuchFieldError unused379) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.COMPUTER_BACKUP_POLICY_CHANGED.ordinal()] = 380;
            } catch (NoSuchFieldError unused380) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CONTENT_ADMINISTRATION_POLICY_CHANGED.ordinal()] = 381;
            } catch (NoSuchFieldError unused381) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DATA_PLACEMENT_RESTRICTION_CHANGE_POLICY.ordinal()] = 382;
            } catch (NoSuchFieldError unused382) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DATA_PLACEMENT_RESTRICTION_SATISFY_POLICY.ordinal()] = 383;
            } catch (NoSuchFieldError unused383) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_APPROVALS_ADD_EXCEPTION.ordinal()] = 384;
            } catch (NoSuchFieldError unused384) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_APPROVALS_CHANGE_DESKTOP_POLICY.ordinal()] = 385;
            } catch (NoSuchFieldError unused385) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_APPROVALS_CHANGE_MOBILE_POLICY.ordinal()] = 386;
            } catch (NoSuchFieldError unused386) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_APPROVALS_CHANGE_OVERAGE_ACTION.ordinal()] = 387;
            } catch (NoSuchFieldError unused387) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_APPROVALS_CHANGE_UNLINK_ACTION.ordinal()] = 388;
            } catch (NoSuchFieldError unused388) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DEVICE_APPROVALS_REMOVE_EXCEPTION.ordinal()] = 389;
            } catch (NoSuchFieldError unused389) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DIRECTORY_RESTRICTIONS_ADD_MEMBERS.ordinal()] = 390;
            } catch (NoSuchFieldError unused390) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DIRECTORY_RESTRICTIONS_REMOVE_MEMBERS.ordinal()] = 391;
            } catch (NoSuchFieldError unused391) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DROPBOX_PASSWORDS_POLICY_CHANGED.ordinal()] = 392;
            } catch (NoSuchFieldError unused392) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EMAIL_INGEST_POLICY_CHANGED.ordinal()] = 393;
            } catch (NoSuchFieldError unused393) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EMM_ADD_EXCEPTION.ordinal()] = 394;
            } catch (NoSuchFieldError unused394) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EMM_CHANGE_POLICY.ordinal()] = 395;
            } catch (NoSuchFieldError unused395) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EMM_REMOVE_EXCEPTION.ordinal()] = 396;
            } catch (NoSuchFieldError unused396) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EXTENDED_VERSION_HISTORY_CHANGE_POLICY.ordinal()] = 397;
            } catch (NoSuchFieldError unused397) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.EXTERNAL_DRIVE_BACKUP_POLICY_CHANGED.ordinal()] = 398;
            } catch (NoSuchFieldError unused398) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_COMMENTS_CHANGE_POLICY.ordinal()] = 399;
            } catch (NoSuchFieldError unused399) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_LOCKING_POLICY_CHANGED.ordinal()] = 400;
            } catch (NoSuchFieldError unused400) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_PROVIDER_MIGRATION_POLICY_CHANGED.ordinal()] = 401;
            } catch (NoSuchFieldError unused401) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_REQUESTS_CHANGE_POLICY.ordinal()] = 402;
            } catch (NoSuchFieldError unused402) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_REQUESTS_EMAILS_ENABLED.ordinal()] = 403;
            } catch (NoSuchFieldError unused403) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_REQUESTS_EMAILS_RESTRICTED_TO_TEAM_ONLY.ordinal()] = 404;
            } catch (NoSuchFieldError unused404) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FILE_TRANSFERS_POLICY_CHANGED.ordinal()] = 405;
            } catch (NoSuchFieldError unused405) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.FOLDER_LINK_RESTRICTION_POLICY_CHANGED.ordinal()] = 406;
            } catch (NoSuchFieldError unused406) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GOOGLE_SSO_CHANGE_POLICY.ordinal()] = 407;
            } catch (NoSuchFieldError unused407) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GROUP_USER_MANAGEMENT_CHANGE_POLICY.ordinal()] = 408;
            } catch (NoSuchFieldError unused408) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.INTEGRATION_POLICY_CHANGED.ordinal()] = 409;
            } catch (NoSuchFieldError unused409) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.INVITE_ACCEPTANCE_EMAIL_POLICY_CHANGED.ordinal()] = 410;
            } catch (NoSuchFieldError unused410) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_REQUESTS_CHANGE_POLICY.ordinal()] = 411;
            } catch (NoSuchFieldError unused411) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SEND_INVITE_POLICY_CHANGED.ordinal()] = 412;
            } catch (NoSuchFieldError unused412) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SPACE_LIMITS_ADD_EXCEPTION.ordinal()] = 413;
            } catch (NoSuchFieldError unused413) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_CAPS_TYPE_POLICY.ordinal()] = 414;
            } catch (NoSuchFieldError unused414) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SPACE_LIMITS_CHANGE_POLICY.ordinal()] = 415;
            } catch (NoSuchFieldError unused415) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SPACE_LIMITS_REMOVE_EXCEPTION.ordinal()] = 416;
            } catch (NoSuchFieldError unused416) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MEMBER_SUGGESTIONS_CHANGE_POLICY.ordinal()] = 417;
            } catch (NoSuchFieldError unused417) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.MICROSOFT_OFFICE_ADDIN_CHANGE_POLICY.ordinal()] = 418;
            } catch (NoSuchFieldError unused418) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.NETWORK_CONTROL_CHANGE_POLICY.ordinal()] = 419;
            } catch (NoSuchFieldError unused419) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CHANGE_DEPLOYMENT_POLICY.ordinal()] = 420;
            } catch (NoSuchFieldError unused420) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CHANGE_MEMBER_LINK_POLICY.ordinal()] = 421;
            } catch (NoSuchFieldError unused421) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CHANGE_MEMBER_POLICY.ordinal()] = 422;
            } catch (NoSuchFieldError unused422) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_CHANGE_POLICY.ordinal()] = 423;
            } catch (NoSuchFieldError unused423) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DEFAULT_FOLDER_POLICY_CHANGED.ordinal()] = 424;
            } catch (NoSuchFieldError unused424) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_DESKTOP_POLICY_CHANGED.ordinal()] = 425;
            } catch (NoSuchFieldError unused425) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_ENABLED_USERS_GROUP_ADDITION.ordinal()] = 426;
            } catch (NoSuchFieldError unused426) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PAPER_ENABLED_USERS_GROUP_REMOVAL.ordinal()] = 427;
            } catch (NoSuchFieldError unused427) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PASSWORD_STRENGTH_REQUIREMENTS_CHANGE_POLICY.ordinal()] = 428;
            } catch (NoSuchFieldError unused428) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.PERMANENT_DELETE_CHANGE_POLICY.ordinal()] = 429;
            } catch (NoSuchFieldError unused429) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.RESELLER_SUPPORT_CHANGE_POLICY.ordinal()] = 430;
            } catch (NoSuchFieldError unused430) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.REWIND_POLICY_CHANGED.ordinal()] = 431;
            } catch (NoSuchFieldError unused431) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SEND_FOR_SIGNATURE_POLICY_CHANGED.ordinal()] = 432;
            } catch (NoSuchFieldError unused432) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARING_CHANGE_FOLDER_JOIN_POLICY.ordinal()] = 433;
            } catch (NoSuchFieldError unused433) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARING_CHANGE_LINK_ALLOW_CHANGE_EXPIRATION_POLICY.ordinal()] = 434;
            } catch (NoSuchFieldError unused434) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARING_CHANGE_LINK_DEFAULT_EXPIRATION_POLICY.ordinal()] = 435;
            } catch (NoSuchFieldError unused435) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARING_CHANGE_LINK_ENFORCE_PASSWORD_POLICY.ordinal()] = 436;
            } catch (NoSuchFieldError unused436) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARING_CHANGE_LINK_POLICY.ordinal()] = 437;
            } catch (NoSuchFieldError unused437) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHARING_CHANGE_MEMBER_POLICY.ordinal()] = 438;
            } catch (NoSuchFieldError unused438) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_CHANGE_DOWNLOAD_POLICY.ordinal()] = 439;
            } catch (NoSuchFieldError unused439) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_CHANGE_ENABLED_POLICY.ordinal()] = 440;
            } catch (NoSuchFieldError unused440) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SHOWCASE_CHANGE_EXTERNAL_SHARING_POLICY.ordinal()] = 441;
            } catch (NoSuchFieldError unused441) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SMARTER_SMART_SYNC_POLICY_CHANGED.ordinal()] = 442;
            } catch (NoSuchFieldError unused442) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SMART_SYNC_CHANGE_POLICY.ordinal()] = 443;
            } catch (NoSuchFieldError unused443) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SMART_SYNC_NOT_OPT_OUT.ordinal()] = 444;
            } catch (NoSuchFieldError unused444) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SMART_SYNC_OPT_OUT.ordinal()] = 445;
            } catch (NoSuchFieldError unused445) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.SSO_CHANGE_POLICY.ordinal()] = 446;
            } catch (NoSuchFieldError unused446) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_BRANDING_POLICY_CHANGED.ordinal()] = 447;
            } catch (NoSuchFieldError unused447) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_EXTENSIONS_POLICY_CHANGED.ordinal()] = 448;
            } catch (NoSuchFieldError unused448) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_SELECTIVE_SYNC_POLICY_CHANGED.ordinal()] = 449;
            } catch (NoSuchFieldError unused449) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_SHARING_WHITELIST_SUBJECTS_CHANGED.ordinal()] = 450;
            } catch (NoSuchFieldError unused450) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_ADD_EXCEPTION.ordinal()] = 451;
            } catch (NoSuchFieldError unused451) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_CHANGE_POLICY.ordinal()] = 452;
            } catch (NoSuchFieldError unused452) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_REMOVE_EXCEPTION.ordinal()] = 453;
            } catch (NoSuchFieldError unused453) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TWO_ACCOUNT_CHANGE_POLICY.ordinal()] = 454;
            } catch (NoSuchFieldError unused454) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.VIEWER_INFO_POLICY_CHANGED.ordinal()] = 455;
            } catch (NoSuchFieldError unused455) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.WATERMARKING_POLICY_CHANGED.ordinal()] = 456;
            } catch (NoSuchFieldError unused456) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.WEB_SESSIONS_CHANGE_ACTIVE_SESSION_LIMIT.ordinal()] = 457;
            } catch (NoSuchFieldError unused457) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.WEB_SESSIONS_CHANGE_FIXED_LENGTH_POLICY.ordinal()] = 458;
            } catch (NoSuchFieldError unused458) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.WEB_SESSIONS_CHANGE_IDLE_LENGTH_POLICY.ordinal()] = 459;
            } catch (NoSuchFieldError unused459) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DATA_RESIDENCY_MIGRATION_REQUEST_SUCCESSFUL.ordinal()] = 460;
            } catch (NoSuchFieldError unused460) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.DATA_RESIDENCY_MIGRATION_REQUEST_UNSUCCESSFUL.ordinal()] = 461;
            } catch (NoSuchFieldError unused461) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_FROM.ordinal()] = 462;
            } catch (NoSuchFieldError unused462) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_TO.ordinal()] = 463;
            } catch (NoSuchFieldError unused463) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_PROFILE_ADD_BACKGROUND.ordinal()] = 464;
            } catch (NoSuchFieldError unused464) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_PROFILE_ADD_LOGO.ordinal()] = 465;
            } catch (NoSuchFieldError unused465) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_PROFILE_CHANGE_BACKGROUND.ordinal()] = 466;
            } catch (NoSuchFieldError unused466) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_PROFILE_CHANGE_DEFAULT_LANGUAGE.ordinal()] = 467;
            } catch (NoSuchFieldError unused467) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_PROFILE_CHANGE_LOGO.ordinal()] = 468;
            } catch (NoSuchFieldError unused468) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_PROFILE_CHANGE_NAME.ordinal()] = 469;
            } catch (NoSuchFieldError unused469) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_PROFILE_REMOVE_BACKGROUND.ordinal()] = 470;
            } catch (NoSuchFieldError unused470) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_PROFILE_REMOVE_LOGO.ordinal()] = 471;
            } catch (NoSuchFieldError unused471) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_ADD_BACKUP_PHONE.ordinal()] = 472;
            } catch (NoSuchFieldError unused472) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_ADD_SECURITY_KEY.ordinal()] = 473;
            } catch (NoSuchFieldError unused473) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_CHANGE_BACKUP_PHONE.ordinal()] = 474;
            } catch (NoSuchFieldError unused474) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_CHANGE_STATUS.ordinal()] = 475;
            } catch (NoSuchFieldError unused475) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_REMOVE_BACKUP_PHONE.ordinal()] = 476;
            } catch (NoSuchFieldError unused476) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_REMOVE_SECURITY_KEY.ordinal()] = 477;
            } catch (NoSuchFieldError unused477) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TFA_RESET.ordinal()] = 478;
            } catch (NoSuchFieldError unused478) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CHANGED_ENTERPRISE_ADMIN_ROLE.ordinal()] = 479;
            } catch (NoSuchFieldError unused479) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.CHANGED_ENTERPRISE_CONNECTED_TEAM_STATUS.ordinal()] = 480;
            } catch (NoSuchFieldError unused480) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ENDED_ENTERPRISE_ADMIN_SESSION.ordinal()] = 481;
            } catch (NoSuchFieldError unused481) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ENDED_ENTERPRISE_ADMIN_SESSION_DEPRECATED.ordinal()] = 482;
            } catch (NoSuchFieldError unused482) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.ENTERPRISE_SETTINGS_LOCKING.ordinal()] = 483;
            } catch (NoSuchFieldError unused483) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.GUEST_ADMIN_CHANGE_STATUS.ordinal()] = 484;
            } catch (NoSuchFieldError unused484) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.STARTED_ENTERPRISE_ADMIN_SESSION.ordinal()] = 485;
            } catch (NoSuchFieldError unused485) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_ACCEPTED.ordinal()] = 486;
            } catch (NoSuchFieldError unused486) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_PRIMARY_TEAM.ordinal()] = 487;
            } catch (NoSuchFieldError unused487) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_ACCEPTED_SHOWN_TO_SECONDARY_TEAM.ordinal()] = 488;
            } catch (NoSuchFieldError unused488) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_AUTO_CANCELED.ordinal()] = 489;
            } catch (NoSuchFieldError unused489) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_CANCELED.ordinal()] = 490;
            } catch (NoSuchFieldError unused490) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_PRIMARY_TEAM.ordinal()] = 491;
            } catch (NoSuchFieldError unused491) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_CANCELED_SHOWN_TO_SECONDARY_TEAM.ordinal()] = 492;
            } catch (NoSuchFieldError unused492) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_EXPIRED.ordinal()] = 493;
            } catch (NoSuchFieldError unused493) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_PRIMARY_TEAM.ordinal()] = 494;
            } catch (NoSuchFieldError unused494) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_EXPIRED_SHOWN_TO_SECONDARY_TEAM.ordinal()] = 495;
            } catch (NoSuchFieldError unused495) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_PRIMARY_TEAM.ordinal()] = 496;
            } catch (NoSuchFieldError unused496) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_REJECTED_SHOWN_TO_SECONDARY_TEAM.ordinal()] = 497;
            } catch (NoSuchFieldError unused497) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_REMINDER.ordinal()] = 498;
            } catch (NoSuchFieldError unused498) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_PRIMARY_TEAM.ordinal()] = 499;
            } catch (NoSuchFieldError unused499) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_REMINDER_SHOWN_TO_SECONDARY_TEAM.ordinal()] = 500;
            } catch (NoSuchFieldError unused500) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_REVOKED.ordinal()] = 501;
            } catch (NoSuchFieldError unused501) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_SENT_SHOWN_TO_PRIMARY_TEAM.ordinal()] = 502;
            } catch (NoSuchFieldError unused502) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$teamlog$EventTypeArg[EventTypeArg.TEAM_MERGE_REQUEST_SENT_SHOWN_TO_SECONDARY_TEAM.ordinal()] = 503;
            } catch (NoSuchFieldError unused503) {
            }
        }
    }
}
