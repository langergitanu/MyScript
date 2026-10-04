package com.myscript.nebo.dms.gdrive;

import androidx.credentials.provider.CredentialEntry;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.DateTime;
import com.google.api.services.drive.model.File;
import com.myscript.snt.dms.CloudFileData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GDriveCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\f\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002\u001a\u0012\u0010\u000e\u001a\u00020\u00012\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004\"\u0019\u0010\u0005\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0013\u001a\u00020\u0001*\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m1599d2 = {"isUserLimitExceeded", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)Z", "isStorageQuotaExceeded", "GDRIVE_AUTO_SYNC_INTERVAL_IN_SECONDS", "", "GDRIVE_VERSION_MIMETYPE", "", "GDRIVE_MIME_TYPE_FOLDER", "IS_V2_ROOT_FOLDER_PROPERTY_KEY", "isFolderMimeType", "mimeType", "isVersionFileMimeType", "toGDriveMimeType", "toCloudFileData", "Lcom/myscript/snt/dms/CloudFileData;", "Lcom/google/api/services/drive/model/File;", "isV2VersionFolder", "(Lcom/google/api/services/drive/model/File;)Z", "dms-gdrive_release"}, m1600k = 2, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GDriveCallbackKt {
    private static final long GDRIVE_AUTO_SYNC_INTERVAL_IN_SECONDS = 60;
    private static final String GDRIVE_MIME_TYPE_FOLDER = "application/vnd.google-apps.folder";
    private static final String GDRIVE_VERSION_MIMETYPE = "application/vnd.myscript.neboversion";
    private static final String IS_V2_ROOT_FOLDER_PROPERTY_KEY = "isV2RootFolder";

    public static final boolean isUserLimitExceeded(Exception exc) {
        List<GoogleJsonError.ErrorInfo> errors;
        Intrinsics.checkNotNullParameter(exc, "<this>");
        if (!(exc instanceof GoogleJsonResponseException)) {
            if (exc instanceof HttpResponseException) {
                String content = ((HttpResponseException) exc).getContent();
                Intrinsics.checkNotNullExpressionValue(content, "getContent(...)");
                if (StringsKt.findAnyOf$default(content, GDriveCallback.INSTANCE.getGDRIVE_LIMIT_EXCEEDED_REASONS(), 0, false, 6, null) != null) {
                    return true;
                }
            }
            return false;
        }
        GoogleJsonError details = ((GoogleJsonResponseException) exc).getDetails();
        if (details != null && (errors = details.getErrors()) != null) {
            List<GoogleJsonError.ErrorInfo> list = errors;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (GDriveCallback.INSTANCE.getGDRIVE_LIMIT_EXCEEDED_REASONS().contains(((GoogleJsonError.ErrorInfo) it.next()).getReason())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final boolean isStorageQuotaExceeded(Exception exc) {
        GoogleJsonError details;
        List<GoogleJsonError.ErrorInfo> errors;
        Intrinsics.checkNotNullParameter(exc, "<this>");
        if (exc instanceof GoogleJsonResponseException) {
            GoogleJsonResponseException googleJsonResponseException = (GoogleJsonResponseException) exc;
            if (googleJsonResponseException.getStatusCode() == 403 && (details = googleJsonResponseException.getDetails()) != null && (errors = details.getErrors()) != null) {
                List<GoogleJsonError.ErrorInfo> list = errors;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (GDriveCallback.INSTANCE.getGDRIVE_STORAGE_QUOTA_EXCEEDED_REASONS().contains(((GoogleJsonError.ErrorInfo) it.next()).getReason())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isFolderMimeType(String str) {
        return Intrinsics.areEqual(str, GDRIVE_MIME_TYPE_FOLDER) || str == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isVersionFileMimeType(String str) {
        return Intrinsics.areEqual(GDRIVE_VERSION_MIMETYPE, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toGDriveMimeType(String str) {
        return Intrinsics.areEqual(str, "application/vnd.myscript.folder") ? GDRIVE_MIME_TYPE_FOLDER : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CloudFileData toCloudFileData(File file) {
        String str;
        CloudFileData cloudFileData = new CloudFileData();
        cloudFileData.setId(file.getId());
        cloudFileData.setIsFolder(isFolderMimeType(file.getMimeType()));
        DateTime modifiedTime = file.getModifiedTime();
        cloudFileData.setLastModificationDate(modifiedTime != null ? Long.valueOf(modifiedTime.getValue() * 1000).longValue() : 0L);
        String name = file.getName();
        if (name == null) {
            name = "";
        }
        cloudFileData.setName(name);
        List<String> parents = file.getParents();
        if (parents == null || (str = (String) CollectionsKt.firstOrNull((List) parents)) == null) {
            str = "";
        }
        cloudFileData.setParentId(str);
        String headRevisionId = file.getHeadRevisionId();
        cloudFileData.setRevision(headRevisionId != null ? headRevisionId : "");
        Long size = file.getSize();
        cloudFileData.setSize(size != null ? size.longValue() : 0L);
        cloudFileData.setMimeType(file.getMimeType());
        return cloudFileData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isV2VersionFolder(File file) {
        Map<String, String> appProperties = file.getAppProperties();
        return Intrinsics.areEqual(appProperties != null ? appProperties.get(IS_V2_ROOT_FOLDER_PROPERTY_KEY) : null, CredentialEntry.TRUE_STRING);
    }
}
