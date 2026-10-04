package com.myscript.nebo.dms.dropbox;

import android.net.http.NetworkException;
import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.dropbox.core.DbxException;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.p013v2.DbxClientV2;
import com.dropbox.core.p013v2.files.CreateFolderErrorException;
import com.dropbox.core.p013v2.files.DeleteErrorException;
import com.dropbox.core.p013v2.files.DeletedMetadata;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.FolderMetadata;
import com.dropbox.core.p013v2.files.ListFolderErrorException;
import com.google.api.client.googleapis.notifications.ResourceStates;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.myscript.android.utils.HashUtilsKt;
import com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment;
import com.myscript.nebo.dms.cloud.common.api.ProgressListener;
import com.myscript.nebo.dms.cloud.common.api.Uploader;
import com.myscript.nebo.dms.cloud.common.utils.CloudDriveInterfaceExtKt;
import com.myscript.nebo.dms.cloud.common.utils.CloudErrorExtKt;
import com.myscript.nebo.dms.cloud.common.utils.CloudLogger;
import com.myscript.nebo.dms.dropbox.api.CreateFolder;
import com.myscript.nebo.dms.dropbox.api.CreateFolders;
import com.myscript.nebo.dms.dropbox.api.DropboxDownloader;
import com.myscript.nebo.dms.dropbox.api.DropboxUploader;
import com.myscript.nebo.dms.dropbox.api.ListFolder;
import com.myscript.nebo.dms.dropbox.api.ListFolderByParcel;
import com.myscript.nebo.dms.dropbox.exceptions.InsufficientSpaceException;
import com.myscript.snt.dms.BatchResult;
import com.myscript.snt.dms.CancelableCloudTaskProgressHandler;
import com.myscript.snt.dms.CloudCreateFileRequest;
import com.myscript.snt.dms.CloudCreateFolderRequest;
import com.myscript.snt.dms.CloudDownloadFileTaskHandler;
import com.myscript.snt.dms.CloudError;
import com.myscript.snt.dms.CloudFile;
import com.myscript.snt.dms.CloudFileData;
import com.myscript.snt.dms.CloudFileIdRev;
import com.myscript.snt.dms.CloudFileRequest;
import com.myscript.snt.dms.CloudOperationLogger;
import com.myscript.snt.dms.CloudUploadFileRequest;
import com.myscript.snt.dms.DMSLogLevel;
import com.myscript.snt.dms.ICloudDriveInterface;
import com.myscript.snt.dms.SWIGVectorCloudCreateFileRequest;
import com.myscript.snt.dms.SWIGVectorCloudCreateFolderRequest;
import com.myscript.snt.dms.SWIGVectorCloudFileData;
import com.myscript.snt.dms.SWIGVectorCloudFileRequest;
import com.myscript.snt.dms.SWIGVectorCloudUploadFileRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DropboxCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 k2\u00020\u0001:\u0003ijkBC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0018\u001a\u00020\fJ\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\fH\u0016J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011H\u0016J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140%2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u0017H\u0016J\u001c\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010&\u001a\u00020\u001dH\u0002J*\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00140+2\b\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010,\u001a\u00020\u001d2\b\b\u0002\u0010-\u001a\u00020\u0017H\u0002J\f\u0010.\u001a\u00020\u0014*\u00020/H\u0002J\u0010\u00100\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u001dH\u0016J \u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0017H\u0016J\u0018\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010<\u001a\u00020\u00112\u0006\u00103\u001a\u00020=H\u0016J\u0018\u0010>\u001a\u0002092\u0006\u0010:\u001a\u00020?2\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010@\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001dH\u0016J\u0010\u0010A\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001dH\u0016J\u0018\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020D2\u0006\u00105\u001a\u000206H\u0016J \u0010E\u001a\u0002092\u0006\u0010F\u001a\u00020G2\u0006\u00105\u001a\u0002062\u0006\u0010H\u001a\u00020IH\u0016J\u001a\u0010J\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u00103\u001a\u00020KH\u0002J\u0018\u0010L\u001a\u00020\u00112\u0006\u00103\u001a\u00020K2\u0006\u00105\u001a\u000206H\u0016J\u0018\u0010M\u001a\u0002092\u0006\u0010:\u001a\u00020N2\u0006\u00105\u001a\u000206H\u0016J$\u0010O\u001a\b\u0012\u0004\u0012\u00020P0%2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020K0%2\u0006\u00105\u001a\u000206H\u0002J\u0010\u0010R\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0011H\u0016J\b\u0010S\u001a\u00020\u0011H\u0016J\u001a\u0010T\u001a\u00020\u00172\b\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020\u0011H\u0002J0\u0010X\u001a\u0002092\b\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010Y\u001a\u00020G2\b\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u0010H\u001a\u0004\u0018\u00010IH\u0002J&\u0010Z\u001a\b\u0012\u0004\u0012\u00020P0%2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0%2\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0010\u0010]\u001a\u00020\f2\u0006\u0010^\u001a\u00020\u0014H\u0002J\u0010\u0010_\u001a\u00020\f2\u0006\u0010^\u001a\u00020\u0014H\u0002J\u0006\u0010`\u001a\u00020\fJ\u0012\u0010a\u001a\u00020b2\n\u0010c\u001a\u00060dj\u0002`eJ\u0012\u0010f\u001a\u00020\u00172\n\u0010c\u001a\u00060dj\u0002`eJ\u0014\u0010g\u001a\u0004\u0018\u00010\u00112\b\u0010h\u001a\u0004\u0018\u00010\u0011H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000Rb\u0010\u0012\u001aV\u0012\u0004\u0012\u00020\u0011\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0014`\u00150\u0013j*\u0012\u0004\u0012\u00020\u0011\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0014`\u0015`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010U\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000¨\u0006l"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/DropboxCallback;", "Lcom/myscript/snt/dms/ICloudDriveInterface;", "statusCallback", "Lcom/myscript/nebo/dms/dropbox/DropboxCallback$StatusCallback;", "errorCallback", "Lcom/myscript/nebo/dms/dropbox/DropboxCallback$ErrorCallback;", "cloudOperationLogger", "Lcom/myscript/snt/dms/CloudOperationLogger;", "cloudLogger", "Lcom/myscript/nebo/dms/cloud/common/utils/CloudLogger;", "onInsufficientStorage", "Lkotlin/Function0;", "", "<init>", "(Lcom/myscript/nebo/dms/dropbox/DropboxCallback$StatusCallback;Lcom/myscript/nebo/dms/dropbox/DropboxCallback$ErrorCallback;Lcom/myscript/snt/dms/CloudOperationLogger;Lcom/myscript/nebo/dms/cloud/common/utils/CloudLogger;Lkotlin/jvm/functions/Function0;)V", "listCursors", "", "", "metadataCache", "Ljava/util/HashMap;", "Lcom/myscript/snt/dms/CloudFileData;", "Lkotlin/collections/HashMap;", "isConnected", "", CloudTokenInvalidDialogFragment.ACTION_DISCONNECT, "isCloudEnabled", "getV1RootPath", "getV2RootPath", "v2RootCloudFile", "Lcom/myscript/snt/dms/CloudFile;", "getV2RootCloudFile", "()Lcom/myscript/snt/dms/CloudFile;", "isV2Initialized", "initializeV2", "getId", "filePath", "list", "", "cloudFile", "needsLastModificationDate", "refreshCache", "actionId", "listFromCache", "", "folder", "throwIfNotFound", "toCloudFileData", "Lcom/dropbox/core/v2/files/Metadata;", "getRevision", "createFile", "Lcom/myscript/snt/dms/CloudFileIdRev;", "request", "Lcom/myscript/snt/dms/CloudCreateFileRequest;", "progressCallback", "Lcom/myscript/snt/dms/CancelableCloudTaskProgressHandler;", "checkAlreadyExists", "createFiles", "Lcom/myscript/snt/dms/BatchResult;", "requests", "Lcom/myscript/snt/dms/SWIGVectorCloudCreateFileRequest;", "createFolder", "Lcom/myscript/snt/dms/CloudCreateFolderRequest;", "createFolders", "Lcom/myscript/snt/dms/SWIGVectorCloudCreateFolderRequest;", "deleteFile", "deleteFolder", "downloadFile", "cloudFileRequest", "Lcom/myscript/snt/dms/CloudFileRequest;", "downloadFiles", "files", "Lcom/myscript/snt/dms/SWIGVectorCloudFileRequest;", "doneCallback", "Lcom/myscript/snt/dms/CloudDownloadFileTaskHandler;", "getParentFromUploadRequest", "Lcom/myscript/snt/dms/CloudUploadFileRequest;", "uploadFile", "uploadFiles", "Lcom/myscript/snt/dms/SWIGVectorCloudUploadFileRequest;", "uploadFilesInternal", "Lcom/myscript/nebo/dms/cloud/common/api/Uploader$UploadResult;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "exists", "getProfileId", "existsInternal", "v1RootFullPath", "v2RootFullPath", "v2VersionFullPath", "downloadFilesInternal", "cloudFileRequests", "upload", "uploadItems", "Lcom/myscript/nebo/dms/cloud/common/api/Uploader$UploadItem;", "addToMetadataCache", "cloudFileData", "removeFromMetadataCache", "reset", "errorLevelFromException", "Lcom/myscript/snt/dms/DMSLogLevel;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isAuthenticateError", "getName", "fileIdOrFilePath", "StatusCallback", "ErrorCallback", "Companion", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class DropboxCallback implements ICloudDriveInterface {
    private static final double CURRENT_VERSION = 2.1d;
    private static final String DROPBOX_TOKEN_ERROR = "invalid_access_token";
    private static final String DROPBOX_TOKEN_ERROR_BIS = "refresh token is invalid or revoked";
    private static final String DROPBOX_V1_ROOT_NAME = "1.0";
    private static final String DROPBOX_V2_ROOT_NAME = "2.0";
    private static final String USER_FOLDER_HASH = "0A3C1EE8BEF647028F8308E9C00EE1DC";
    private final CloudLogger cloudLogger;
    private final CloudOperationLogger cloudOperationLogger;
    private final ErrorCallback errorCallback;
    private volatile boolean isConnected;
    private final Map<String, String> listCursors;
    private final HashMap<String, HashMap<String, CloudFileData>> metadataCache;
    private final Function0<Unit> onInsufficientStorage;
    private final StatusCallback statusCallback;
    private final String v1RootFullPath;
    private final String v2RootFullPath;
    private final String v2VersionFullPath;

    /* JADX INFO: compiled from: DropboxCallback.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/DropboxCallback$ErrorCallback;", "", "handleAndThrowError", "", "actionId", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ErrorCallback {
        Void handleAndThrowError(String actionId, Exception exception);
    }

    /* JADX INFO: compiled from: DropboxCallback.kt */
    @FunctionalInterface
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/DropboxCallback$StatusCallback;", "", "isDropboxAvailable", "", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface StatusCallback {
        boolean isDropboxAvailable();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DropboxCallback(StatusCallback statusCallback, ErrorCallback errorCallback) {
        this(statusCallback, errorCallback, null, null, null, 28, null);
        Intrinsics.checkNotNullParameter(statusCallback, "statusCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DropboxCallback(StatusCallback statusCallback, ErrorCallback errorCallback, CloudOperationLogger cloudOperationLogger) {
        this(statusCallback, errorCallback, cloudOperationLogger, null, null, 24, null);
        Intrinsics.checkNotNullParameter(statusCallback, "statusCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DropboxCallback(StatusCallback statusCallback, ErrorCallback errorCallback, CloudOperationLogger cloudOperationLogger, CloudLogger cloudLogger) {
        this(statusCallback, errorCallback, cloudOperationLogger, cloudLogger, null, 16, null);
        Intrinsics.checkNotNullParameter(statusCallback, "statusCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
    }

    public DropboxCallback(StatusCallback statusCallback, ErrorCallback errorCallback, CloudOperationLogger cloudOperationLogger, CloudLogger cloudLogger, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(statusCallback, "statusCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        this.statusCallback = statusCallback;
        this.errorCallback = errorCallback;
        this.cloudOperationLogger = cloudOperationLogger;
        this.cloudLogger = cloudLogger;
        this.onInsufficientStorage = function0;
        this.listCursors = new LinkedHashMap();
        this.metadataCache = new HashMap<>();
        this.isConnected = true;
        this.v1RootFullPath = "/1.0/0A3C1EE8BEF647028F8308E9C00EE1DC";
        this.v2RootFullPath = "/2.0/0A3C1EE8BEF647028F8308E9C00EE1DC";
        this.v2VersionFullPath = "/2.1";
    }

    public /* synthetic */ DropboxCallback(StatusCallback statusCallback, ErrorCallback errorCallback, CloudOperationLogger cloudOperationLogger, CloudLogger cloudLogger, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(statusCallback, errorCallback, (i & 4) != 0 ? null : cloudOperationLogger, (i & 8) != 0 ? null : cloudLogger, (i & 16) != 0 ? null : function0);
    }

    public final void disconnect() {
        this.isConnected = false;
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public boolean isCloudEnabled() {
        return this.statusCallback.isDropboxAvailable();
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    /* JADX INFO: renamed from: getV1RootPath, reason: from getter */
    public String getV1RootFullPath() {
        return this.v1RootFullPath;
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    /* JADX INFO: renamed from: getV2RootPath, reason: from getter */
    public String getV2RootFullPath() {
        return this.v2RootFullPath;
    }

    private final CloudFile getV2RootCloudFile() {
        CloudFile cloudFile = new CloudFile();
        cloudFile.setId("");
        cloudFile.setPath(getV2RootFullPath());
        return cloudFile;
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public boolean isV2Initialized() {
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            try {
                ListFolder listFolder = ListFolder.INSTANCE;
                DbxClientV2 dropboxClient = DropboxClient.getInstance();
                Intrinsics.checkNotNullExpressionValue(dropboxClient, "getInstance(...)");
                boolean z = false;
                if (listFolder.get(dropboxClient, null, false, new Function1() { // from class: com.myscript.nebo.dms.dropbox.DropboxCallback$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(DropboxCallback.isV2Initialized$lambda$0((com.dropbox.core.p013v2.files.Metadata) obj));
                    }
                }) != null && (!r2.isEmpty())) {
                    throw new IllegalStateException("Unsupported Cloud Version");
                }
                if (existsInternal(strStartAction, this.v2VersionFullPath) && existsInternal(strStartAction, getV2RootFullPath())) {
                    z = true;
                }
                return z;
            } catch (Exception e) {
                this.errorCallback.handleAndThrowError(strStartAction, e);
                throw new KotlinNothingValueException();
            }
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "IS_V2_INITIALIZED");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isV2Initialized$lambda$0(com.dropbox.core.p013v2.files.Metadata metadata) {
        String name;
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        FolderMetadata folderMetadata = DropboxCallbackKt.toFolderMetadata(metadata);
        return ComparisonsKt.compareValues((folderMetadata == null || (name = folderMetadata.getName()) == null) ? null : StringsKt.toDoubleOrNull(name), Double.valueOf(CURRENT_VERSION)) > 0;
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public void initializeV2() {
        if (isV2Initialized()) {
            return;
        }
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            try {
                if (!existsInternal(strStartAction, getV2RootFullPath())) {
                    CreateFolder createFolder = CreateFolder.INSTANCE;
                    DbxClientV2 dropboxClient = DropboxClient.getInstance();
                    Intrinsics.checkNotNullExpressionValue(dropboxClient, "getInstance(...)");
                    createFolder.get(dropboxClient, getV2RootFullPath());
                }
                if (!existsInternal(strStartAction, this.v2VersionFullPath)) {
                    CreateFolder createFolder2 = CreateFolder.INSTANCE;
                    DbxClientV2 dropboxClient2 = DropboxClient.getInstance();
                    Intrinsics.checkNotNullExpressionValue(dropboxClient2, "getInstance(...)");
                    createFolder2.get(dropboxClient2, this.v2VersionFullPath);
                }
            } catch (Exception e) {
                this.errorCallback.handleAndThrowError(strStartAction, e);
                throw new KotlinNothingValueException();
            }
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "INITIALIZE_V2");
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public String getId(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            try {
                com.dropbox.core.p013v2.files.Metadata metadata = DropboxClient.getInstance().files().getMetadata(filePath);
                if (metadata instanceof FileMetadata) {
                    String id = ((FileMetadata) metadata).getId();
                    Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                    return id;
                }
                if (!(metadata instanceof FolderMetadata)) {
                    this.errorCallback.handleAndThrowError(strStartAction, new RuntimeException("getId return invalid type " + metadata.getClass().getSimpleName()));
                    throw new KotlinNothingValueException();
                }
                String id2 = ((FolderMetadata) metadata).getId();
                Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                return id2;
            } catch (Exception e) {
                e = e;
                if (DropboxCallbackKt.isNotFound(e)) {
                    e = new NoSuchElementException("File " + filePath + " not found");
                }
                this.errorCallback.handleAndThrowError(strStartAction, e);
                throw new KotlinNothingValueException();
            }
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "GET_ID");
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public List<CloudFileData> list(CloudFile cloudFile, boolean needsLastModificationDate) throws Throwable {
        DropboxCallback dropboxCallback;
        Intrinsics.checkNotNullParameter(cloudFile, "cloudFile");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            refreshCache(strStartAction, cloudFile);
            dropboxCallback = this;
            try {
                List<CloudFileData> listListFromCache$default = listFromCache$default(dropboxCallback, strStartAction, cloudFile, false, 4, null);
                CloudOperationLogger cloudOperationLogger2 = dropboxCallback.cloudOperationLogger;
                if (cloudOperationLogger2 != null) {
                    cloudOperationLogger2.endAction(strStartAction, "LIST");
                }
                return listListFromCache$default;
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                CloudOperationLogger cloudOperationLogger3 = dropboxCallback.cloudOperationLogger;
                if (cloudOperationLogger3 == null) {
                    throw th2;
                }
                cloudOperationLogger3.endAction(strStartAction, "LIST");
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            dropboxCallback = this;
        }
    }

    static /* synthetic */ void refreshCache$default(DropboxCallback dropboxCallback, String str, CloudFile cloudFile, int i, Object obj) {
        if ((i & 2) != 0) {
            cloudFile = dropboxCallback.getV2RootCloudFile();
        }
        dropboxCallback.refreshCache(str, cloudFile);
    }

    private final void refreshCache(String actionId, CloudFile cloudFile) {
        try {
            DbxClientV2 dropboxClient = DropboxClient.getInstance();
            Intrinsics.checkNotNullExpressionValue(dropboxClient, "getInstance(...)");
            ListFolderByParcel listFolderByParcel = new ListFolderByParcel(dropboxClient, cloudFile.getPath(), this.listCursors.get(cloudFile.getPath()), true, null, 16, null);
            for (List<com.dropbox.core.p013v2.files.Metadata> listBegin = listFolderByParcel.begin(); listBegin != null && (!listBegin.isEmpty()); listBegin = listFolderByParcel.next()) {
                for (com.dropbox.core.p013v2.files.Metadata metadata : listBegin) {
                    if (metadata instanceof DeletedMetadata) {
                        removeFromMetadataCache(toCloudFileData(metadata));
                    } else {
                        addToMetadataCache(toCloudFileData(metadata));
                    }
                }
            }
            this.listCursors.put(cloudFile.getPath(), listFolderByParcel.getCursor());
        } catch (Exception e) {
            e = e;
            if (e instanceof ListFolderErrorException) {
                e = new NoSuchElementException("Folder " + cloudFile.getPath() + " not found");
            }
            this.errorCallback.handleAndThrowError(actionId, e);
            throw new KotlinNothingValueException();
        }
    }

    static /* synthetic */ List listFromCache$default(DropboxCallback dropboxCallback, String str, CloudFile cloudFile, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return dropboxCallback.listFromCache(str, cloudFile, z);
    }

    private final List<CloudFileData> listFromCache(String actionId, CloudFile folder, boolean throwIfNotFound) {
        Collection<CloudFileData> collectionValues;
        SWIGVectorCloudFileData sWIGVectorCloudFileData = new SWIGVectorCloudFileData();
        boolean zBooleanValue = false;
        if (this.metadataCache.containsKey(folder.getPath())) {
            HashMap<String, CloudFileData> map = this.metadataCache.get(folder.getPath());
            if (map != null && (collectionValues = map.values()) != null) {
                for (CloudFileData cloudFileData : collectionValues) {
                    sWIGVectorCloudFileData.push_back(cloudFileData);
                    if (cloudFileData.isFolder()) {
                        CloudFile cloudFile = new CloudFile();
                        cloudFile.setId(cloudFileData.m1102id());
                        cloudFile.setPath(cloudFileData.path());
                        Unit unit = Unit.INSTANCE;
                        Iterator<T> it = listFromCache(actionId, cloudFile, false).iterator();
                        while (it.hasNext()) {
                            sWIGVectorCloudFileData.push_back((CloudFileData) it.next());
                        }
                    }
                }
            }
        } else if (throwIfNotFound) {
            String parent = new File(folder.getPath()).getParent();
            if (parent != null) {
                HashMap<String, CloudFileData> map2 = this.metadataCache.get(parent);
                Boolean boolValueOf = map2 != null ? Boolean.valueOf(map2.containsKey(folder.getPath())) : null;
                if (boolValueOf != null) {
                    zBooleanValue = boolValueOf.booleanValue();
                }
            }
            if (!zBooleanValue) {
                this.errorCallback.handleAndThrowError(actionId, new NoSuchElementException("Folder " + folder.getPath() + " not found"));
                throw new KotlinNothingValueException();
            }
        }
        return sWIGVectorCloudFileData;
    }

    private final CloudFileData toCloudFileData(com.dropbox.core.p013v2.files.Metadata metadata) {
        Date clientModified;
        CloudFileData cloudFileData = new CloudFileData();
        FileMetadata fileMetadata = DropboxCallbackKt.toFileMetadata(metadata);
        if (fileMetadata != null) {
            cloudFileData.setId(fileMetadata.getId());
        }
        FolderMetadata folderMetadata = DropboxCallbackKt.toFolderMetadata(metadata);
        if (folderMetadata != null) {
            cloudFileData.setId(folderMetadata.getId());
        }
        cloudFileData.setIsFolder(false);
        FolderMetadata folderMetadata2 = DropboxCallbackKt.toFolderMetadata(metadata);
        if (folderMetadata2 != null) {
            cloudFileData.setIsFolder(DropboxCallbackKt.isFolder(folderMetadata2));
        }
        DeletedMetadata deletedMetadata = DropboxCallbackKt.toDeletedMetadata(metadata);
        if (deletedMetadata != null) {
            cloudFileData.setIsFolder(DropboxCallbackKt.isFolder(deletedMetadata));
        }
        FileMetadata fileMetadata2 = DropboxCallbackKt.toFileMetadata(metadata);
        cloudFileData.setLastModificationDate(((fileMetadata2 == null || (clientModified = fileMetadata2.getClientModified()) == null) ? 0L : clientModified.getTime()) * 1000);
        cloudFileData.setPath(metadata.getPathDisplay());
        cloudFileData.setName(metadata.getName());
        String parentSharedFolderId = metadata.getParentSharedFolderId();
        if (parentSharedFolderId != null) {
            cloudFileData.setParentId(parentSharedFolderId);
        }
        FileMetadata fileMetadata3 = DropboxCallbackKt.toFileMetadata(metadata);
        if (fileMetadata3 != null) {
            cloudFileData.setRevision(fileMetadata3.getRev());
            cloudFileData.setSize(fileMetadata3.getSize());
        }
        return cloudFileData;
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public String getRevision(CloudFile cloudFile) {
        Intrinsics.checkNotNullParameter(cloudFile, "cloudFile");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            try {
                com.dropbox.core.p013v2.files.Metadata metadata = DropboxClient.getInstance().files().getMetadata(cloudFile.getPath());
                Intrinsics.checkNotNullExpressionValue(metadata, "getMetadata(...)");
                FileMetadata fileMetadata = DropboxCallbackKt.toFileMetadata(metadata);
                String rev = fileMetadata != null ? fileMetadata.getRev() : null;
                return rev == null ? "1" : rev;
            } catch (Exception e) {
                this.errorCallback.handleAndThrowError(strStartAction, e);
                throw new KotlinNothingValueException();
            }
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "GET_REVISION");
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public CloudFileIdRev createFile(CloudCreateFileRequest request, CancelableCloudTaskProgressHandler progressCallback, boolean checkAlreadyExists) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        Uploader.UploadResult uploadResult = null;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            try {
                refreshCache$default(this, strStartAction, null, 2, null);
                if (checkAlreadyExists) {
                    CloudFile parent = request.getParent();
                    Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                    String name = request.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    CloudDriveInterfaceExtKt.checkAlreadyExists$default(this, strStartAction, parent, name, false, new C62471(this), 8, null);
                }
                List<? extends Uploader.UploadItem> listListOf = CollectionsKt.listOf(new Uploader.UploadItem(Long.valueOf(request.getRequestId()), request.getParent().getPath() + DomExceptionUtils.SEPARATOR + request.getName(), request.getLocalPath()));
                CloudFileIdRev cloudFileIdRev = new CloudFileIdRev();
                List<Uploader.UploadResult> listUpload = upload(listListOf, progressCallback);
                if (!listUpload.isEmpty()) {
                    uploadResult = (Uploader.UploadResult) CollectionsKt.first((List) listUpload);
                }
                if (uploadResult != null) {
                    cloudFileIdRev.setId(uploadResult.cloudId);
                    cloudFileIdRev.setRevision(uploadResult.revision);
                }
                CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
                if (cloudOperationLogger2 != null) {
                    cloudOperationLogger2.endAction(strStartAction, "CREATE_FILE", request.getLocalPath());
                }
                return cloudFileIdRev;
            } catch (Exception e) {
                this.errorCallback.handleAndThrowError(strStartAction, e);
                throw new KotlinNothingValueException();
            }
        } finally {
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.dropbox.DropboxCallback$createFile$1 */
    /* JADX INFO: compiled from: DropboxCallback.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62471 extends AdaptedFunctionReference implements Function2<String, CloudFile, List<CloudFileData>> {
        C62471(Object obj) {
            super(2, obj, DropboxCallback.class, "listFromCache", "listFromCache(Ljava/lang/String;Lcom/myscript/snt/dms/CloudFile;Z)Ljava/util/List;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final List<CloudFileData> invoke(String str, CloudFile p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            return DropboxCallback.listFromCache$default((DropboxCallback) this.receiver, str, p1, false, 4, null);
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public BatchResult createFiles(SWIGVectorCloudCreateFileRequest requests, CancelableCloudTaskProgressHandler progressCallback) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        ArrayList arrayList = new ArrayList();
        try {
            refreshCache$default(this, strStartAction, null, 2, null);
            BatchResult batchResult = new BatchResult();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (CloudCreateFileRequest cloudCreateFileRequest : requests) {
                CloudFile parent = cloudCreateFileRequest.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                String name = cloudCreateFileRequest.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Exception excCheckAlreadyExists = CloudDriveInterfaceExtKt.checkAlreadyExists(this, strStartAction, parent, name, false, new DropboxCallback$createFiles$1$exception$1(this));
                if (excCheckAlreadyExists != null) {
                    CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
                    if (cloudOperationLogger2 != null) {
                        cloudOperationLogger2.addError(strStartAction, CloudErrorExtKt.getAsCloudError(excCheckAlreadyExists).toString());
                    }
                    batchResult.put(cloudCreateFileRequest.getRequestId(), CloudErrorExtKt.getAsCloudError(excCheckAlreadyExists));
                } else {
                    String str = cloudCreateFileRequest.getParent().getPath() + DomExceptionUtils.SEPARATOR + cloudCreateFileRequest.getName();
                    linkedHashMap.put(str, new Uploader.UploadItem(Long.valueOf(cloudCreateFileRequest.getRequestId()), str, cloudCreateFileRequest.getLocalPath()));
                }
            }
            for (Uploader.UploadResult uploadResult : upload(CollectionsKt.toList(linkedHashMap.values()), progressCallback)) {
                if (uploadResult.lastError != null) {
                    if (uploadResult.insufficientStorage && (function0 = this.onInsufficientStorage) != null) {
                        function0.invoke();
                    }
                    CloudOperationLogger cloudOperationLogger3 = this.cloudOperationLogger;
                    if (cloudOperationLogger3 != null) {
                        Exception lastError = uploadResult.lastError;
                        Intrinsics.checkNotNullExpressionValue(lastError, "lastError");
                        cloudOperationLogger3.addError(strStartAction, CloudErrorExtKt.getAsCloudError(lastError).toString());
                    }
                    long j = uploadResult.requestId;
                    Exception lastError2 = uploadResult.lastError;
                    Intrinsics.checkNotNullExpressionValue(lastError2, "lastError");
                    batchResult.put(j, CloudErrorExtKt.getAsCloudError(lastError2));
                } else {
                    String localPath = uploadResult.localPath;
                    Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
                    arrayList.add(localPath);
                    long j2 = uploadResult.requestId;
                    CloudFileIdRev cloudFileIdRev = new CloudFileIdRev();
                    cloudFileIdRev.setId(uploadResult.cloudId);
                    cloudFileIdRev.setRevision(uploadResult.revision);
                    Unit unit = Unit.INSTANCE;
                    batchResult.put(j2, cloudFileIdRev);
                }
            }
            CloudOperationLogger cloudOperationLogger4 = this.cloudOperationLogger;
            if (cloudOperationLogger4 != null) {
                cloudOperationLogger4.endActionBatch(strStartAction, "CREATE_FILES", arrayList);
            }
            return batchResult;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00fa A[DONT_GENERATE, FINALLY_INSNS] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[DONT_GENERATE, FINALLY_INSNS, SYNTHETIC] */
    @Override // com.myscript.snt.dms.ICloudDriveInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String createFolder(CloudCreateFolderRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        refreshCache$default(this, strStartAction, null, 2, null);
        CloudFile parent = request.getParent();
        Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
        String name = request.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        CloudDriveInterfaceExtKt.checkAlreadyExists$default(this, strStartAction, parent, name, false, new C62481(this), 8, null);
        try {
            try {
                String id = DropboxClient.getInstance().files().createFolderV2(request.getParent().getPath() + DomExceptionUtils.SEPARATOR + request.getName(), false).getMetadata().getId();
                if (id == null) {
                    throw new RuntimeException("Unable to create folder " + request.getName() + " in " + request.getParent().getPath());
                }
                CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
                if (cloudOperationLogger2 != null) {
                    cloudOperationLogger2.endAction(strStartAction, "CREATE_FOLDER");
                }
                return id;
            } catch (Exception e) {
                e = e;
                if ((e instanceof CreateFolderErrorException) && ((CreateFolderErrorException) e).errorValue.getPathValue().isConflict()) {
                    e = new IllegalStateException("Folder " + request.getName() + " already exists in folder " + request.getParent().getPath());
                }
                this.errorCallback.handleAndThrowError(strStartAction, e);
                throw new KotlinNothingValueException();
            }
        } finally {
        }
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.dropbox.DropboxCallback$createFolder$1 */
    /* JADX INFO: compiled from: DropboxCallback.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    static final /* synthetic */ class C62481 extends AdaptedFunctionReference implements Function2<String, CloudFile, List<CloudFileData>> {
        C62481(Object obj) {
            super(2, obj, DropboxCallback.class, "listFromCache", "listFromCache(Ljava/lang/String;Lcom/myscript/snt/dms/CloudFile;Z)Ljava/util/List;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final List<CloudFileData> invoke(String str, CloudFile p1) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            return DropboxCallback.listFromCache$default((DropboxCallback) this.receiver, str, p1, false, 4, null);
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public BatchResult createFolders(SWIGVectorCloudCreateFolderRequest requests, CancelableCloudTaskProgressHandler progressCallback) {
        String id;
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            refreshCache$default(this, strStartAction, null, 2, null);
            BatchResult batchResult = new BatchResult();
            ArrayList arrayList = new ArrayList();
            for (CloudCreateFolderRequest cloudCreateFolderRequest : requests) {
                CloudFile parent = cloudCreateFolderRequest.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                String name = cloudCreateFolderRequest.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                Exception excCheckAlreadyExists = CloudDriveInterfaceExtKt.checkAlreadyExists(this, strStartAction, parent, name, false, new DropboxCallback$createFolders$1$exception$1(this));
                if (excCheckAlreadyExists != null) {
                    CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
                    if (cloudOperationLogger2 != null) {
                        cloudOperationLogger2.addError(strStartAction, CloudErrorExtKt.getAsCloudError(excCheckAlreadyExists).toString());
                    }
                    batchResult.put(cloudCreateFolderRequest.getRequestId(), CloudErrorExtKt.getAsCloudError(excCheckAlreadyExists));
                } else {
                    arrayList.add(cloudCreateFolderRequest.getParent().getPath() + DomExceptionUtils.SEPARATOR + cloudCreateFolderRequest.getName());
                }
            }
            CreateFolders createFolders = CreateFolders.INSTANCE;
            DbxClientV2 dropboxClient = DropboxClient.getInstance();
            Intrinsics.checkNotNullExpressionValue(dropboxClient, "getInstance(...)");
            for (CreateFolders.CreateFolderResult createFolderResult : createFolders.createFolders(dropboxClient, arrayList)) {
                long requestId = requests.get(createFolderResult.getIndex()).getRequestId();
                FolderMetadata metadata = createFolderResult.getMetadata();
                if (metadata == null || (id = metadata.getId()) == null) {
                    id = "";
                }
                batchResult.put(requestId, id);
            }
            CloudOperationLogger cloudOperationLogger3 = this.cloudOperationLogger;
            if (cloudOperationLogger3 != null) {
                cloudOperationLogger3.endActionBatch(strStartAction, "CREATE_FOLDERS", CollectionsKt.emptyList());
            }
            return batchResult;
        } finally {
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public void deleteFile(CloudFile cloudFile) {
        Intrinsics.checkNotNullParameter(cloudFile, "cloudFile");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            try {
                DropboxClient.getInstance().files().deleteV2(cloudFile.getPath());
            } catch (Exception e) {
                e = e;
                if ((e instanceof DeleteErrorException) && ((DeleteErrorException) e).errorValue.getPathLookupValue().isNotFound()) {
                    e = new NoSuchElementException("File " + cloudFile.getId() + " not found");
                }
                this.errorCallback.handleAndThrowError(strStartAction, e);
                throw new KotlinNothingValueException();
            }
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "DELETE_FILE");
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public void deleteFolder(CloudFile cloudFile) {
        Intrinsics.checkNotNullParameter(cloudFile, "cloudFile");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            try {
                DropboxClient.getInstance().files().deleteV2(cloudFile.getPath());
            } catch (Exception e) {
                e = e;
                if ((e instanceof DeleteErrorException) && ((DeleteErrorException) e).errorValue.getPathLookupValue().isNotFound()) {
                    e = new NoSuchElementException("Folder " + cloudFile.getId() + " not found");
                }
                this.errorCallback.handleAndThrowError(strStartAction, e);
                throw new KotlinNothingValueException();
            }
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "DELETE_FOLDER");
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public void downloadFile(CloudFileRequest cloudFileRequest, CancelableCloudTaskProgressHandler progressCallback) throws Throwable {
        DropboxCallback dropboxCallback;
        Intrinsics.checkNotNullParameter(cloudFileRequest, "cloudFileRequest");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest = new SWIGVectorCloudFileRequest();
            sWIGVectorCloudFileRequest.push_back(cloudFileRequest);
            dropboxCallback = this;
            try {
                try {
                    BatchResult batchResultDownloadFilesInternal$default = downloadFilesInternal$default(dropboxCallback, strStartAction, sWIGVectorCloudFileRequest, progressCallback, null, 8, null);
                    if (batchResultDownloadFilesInternal$default.hasError(cloudFileRequest.getRequestId())) {
                        CloudLogger cloudLogger = dropboxCallback.cloudLogger;
                        if (cloudLogger != null) {
                            CloudError cloudErrorError = batchResultDownloadFilesInternal$default.error(cloudFileRequest.getRequestId());
                            Intrinsics.checkNotNullExpressionValue(cloudErrorError, "error(...)");
                            cloudLogger.logError(cloudErrorError);
                        }
                        ErrorCallback errorCallback = dropboxCallback.errorCallback;
                        CloudError cloudErrorError2 = batchResultDownloadFilesInternal$default.error(cloudFileRequest.getRequestId());
                        Intrinsics.checkNotNullExpressionValue(cloudErrorError2, "error(...)");
                        errorCallback.handleAndThrowError(strStartAction, CloudErrorExtKt.getAsException(cloudErrorError2));
                        throw new KotlinNothingValueException();
                    }
                    CloudOperationLogger cloudOperationLogger2 = dropboxCallback.cloudOperationLogger;
                    if (cloudOperationLogger2 != null) {
                        cloudOperationLogger2.endAction(strStartAction, "DOWNLOAD_FILE", cloudFileRequest.getOutputPath());
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e = e;
                    throw e;
                }
            } catch (Throwable th) {
                th = th;
            }
            th = th;
        } catch (Exception e2) {
            e = e2;
            dropboxCallback = this;
        } catch (Throwable th2) {
            th = th2;
            dropboxCallback = this;
        }
        Throwable th3 = th;
        CloudOperationLogger cloudOperationLogger3 = dropboxCallback.cloudOperationLogger;
        if (cloudOperationLogger3 == null) {
            throw th3;
        }
        cloudOperationLogger3.endAction(strStartAction, "DOWNLOAD_FILE", cloudFileRequest.getOutputPath());
        throw th3;
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public BatchResult downloadFiles(SWIGVectorCloudFileRequest files, CancelableCloudTaskProgressHandler progressCallback, CloudDownloadFileTaskHandler doneCallback) {
        Intrinsics.checkNotNullParameter(files, "files");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        Intrinsics.checkNotNullParameter(doneCallback, "doneCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        BatchResult batchResultDownloadFilesInternal = downloadFilesInternal(strStartAction, files, progressCallback, doneCallback);
        CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
        if (cloudOperationLogger2 != null) {
            SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest = files;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sWIGVectorCloudFileRequest, 10));
            Iterator<CloudFileRequest> it = sWIGVectorCloudFileRequest.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getOutputPath());
            }
            cloudOperationLogger2.endActionBatch(strStartAction, "DOWNLOAD_FILES", arrayList);
        }
        return batchResultDownloadFilesInternal;
    }

    private final CloudFile getParentFromUploadRequest(String actionId, CloudUploadFileRequest request) {
        String parent = new File(request.getFile().getPath()).getParent();
        if (parent != null) {
            CloudFile cloudFile = new CloudFile();
            cloudFile.setId("");
            cloudFile.setPath(parent);
            return cloudFile;
        }
        this.errorCallback.handleAndThrowError(actionId, new NoSuchElementException(request.getFile().getId() + " not found remotely."));
        throw new KotlinNothingValueException();
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public String uploadFile(CloudUploadFileRequest request, CancelableCloudTaskProgressHandler progressCallback) throws Throwable {
        DropboxCallback dropboxCallback;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            CloudFile parentFromUploadRequest = getParentFromUploadRequest(strStartAction, request);
            refreshCache$default(this, strStartAction, null, 2, null);
            dropboxCallback = this;
            try {
                List listListFromCache$default = listFromCache$default(dropboxCallback, strStartAction, parentFromUploadRequest, false, 4, null);
                if (!(listListFromCache$default instanceof Collection) || !listListFromCache$default.isEmpty()) {
                    Iterator it = listListFromCache$default.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((CloudFileData) it.next()).path(), request.getFile().getPath())) {
                            List<Uploader.UploadResult> listUploadFilesInternal = uploadFilesInternal(CollectionsKt.listOf(request), progressCallback);
                            if (listUploadFilesInternal.isEmpty()) {
                                dropboxCallback.errorCallback.handleAndThrowError(strStartAction, new RuntimeException("File upload failed"));
                                throw new KotlinNothingValueException();
                            }
                            Uploader.UploadResult uploadResult = (Uploader.UploadResult) CollectionsKt.first((List) listUploadFilesInternal);
                            if (uploadResult.lastError != null) {
                                ErrorCallback errorCallback = dropboxCallback.errorCallback;
                                Exception lastError = uploadResult.lastError;
                                Intrinsics.checkNotNullExpressionValue(lastError, "lastError");
                                errorCallback.handleAndThrowError(strStartAction, lastError);
                                throw new KotlinNothingValueException();
                            }
                            String str = uploadResult.revision;
                            if (str == null) {
                                dropboxCallback.errorCallback.handleAndThrowError(strStartAction, new RuntimeException("File upload failed"));
                                throw new KotlinNothingValueException();
                            }
                            CloudOperationLogger cloudOperationLogger2 = dropboxCallback.cloudOperationLogger;
                            if (cloudOperationLogger2 != null) {
                                cloudOperationLogger2.endAction(strStartAction, "UPLOAD_FILE", request.getLocalPath());
                            }
                            return str;
                        }
                    }
                }
                dropboxCallback.errorCallback.handleAndThrowError(strStartAction, new NoSuchElementException(request.getFile().getId() + " not found remotely."));
                throw new KotlinNothingValueException();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                CloudOperationLogger cloudOperationLogger3 = dropboxCallback.cloudOperationLogger;
                if (cloudOperationLogger3 == null) {
                    throw th2;
                }
                cloudOperationLogger3.endAction(strStartAction, "UPLOAD_FILE", request.getLocalPath());
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            dropboxCallback = this;
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public BatchResult uploadFiles(SWIGVectorCloudUploadFileRequest requests, CancelableCloudTaskProgressHandler progressCallback) {
        CloudError asCloudError;
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        BatchResult batchResult = new BatchResult();
        refreshCache$default(this, strStartAction, null, 2, null);
        ArrayList arrayList = new ArrayList();
        SWIGVectorCloudUploadFileRequest sWIGVectorCloudUploadFileRequest = requests;
        for (CloudUploadFileRequest cloudUploadFileRequest : sWIGVectorCloudUploadFileRequest) {
            Intrinsics.checkNotNull(cloudUploadFileRequest);
            List listListFromCache$default = listFromCache$default(this, strStartAction, getParentFromUploadRequest(strStartAction, cloudUploadFileRequest), false, 4, null);
            if (!(listListFromCache$default instanceof Collection) || !listListFromCache$default.isEmpty()) {
                Iterator it = listListFromCache$default.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((CloudFileData) it.next()).path(), cloudUploadFileRequest.getFile().getPath())) {
                        arrayList.add(cloudUploadFileRequest);
                        break;
                    }
                }
            }
            CloudError asCloudError2 = CloudErrorExtKt.getAsCloudError(new NoSuchElementException(cloudUploadFileRequest.getFile().getId() + " not found remotely"));
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.addError(strStartAction, asCloudError2.toString());
            }
            batchResult.put(cloudUploadFileRequest.getRequestId(), asCloudError2);
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add((CloudUploadFileRequest) it2.next());
        }
        for (Uploader.UploadResult uploadResult : uploadFilesInternal(arrayList3, progressCallback)) {
            Exception exc = uploadResult.lastError;
            if (exc != null) {
                if (uploadResult.insufficientStorage) {
                    Function0<Unit> function0 = this.onInsufficientStorage;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    Exception exc2 = uploadResult.lastError;
                    asCloudError = CloudErrorExtKt.getAsCloudError(new InsufficientSpaceException(exc2 != null ? exc2.getMessage() : null));
                } else {
                    asCloudError = CloudErrorExtKt.getAsCloudError(exc);
                }
                CloudOperationLogger cloudOperationLogger3 = this.cloudOperationLogger;
                if (cloudOperationLogger3 != null) {
                    cloudOperationLogger3.addError(strStartAction, asCloudError.toString());
                }
                batchResult.put(uploadResult.requestId, asCloudError);
            } else if (uploadResult.success) {
                batchResult.put(uploadResult.requestId, uploadResult.revision);
            } else {
                CloudError asCloudError3 = CloudErrorExtKt.getAsCloudError(new RuntimeException("Unable to get upload metadata."));
                CloudOperationLogger cloudOperationLogger4 = this.cloudOperationLogger;
                if (cloudOperationLogger4 != null) {
                    cloudOperationLogger4.addError(strStartAction, asCloudError3.toString());
                }
                batchResult.put(uploadResult.requestId, asCloudError3);
            }
        }
        CloudOperationLogger cloudOperationLogger5 = this.cloudOperationLogger;
        if (cloudOperationLogger5 != null) {
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sWIGVectorCloudUploadFileRequest, 10));
            Iterator<CloudUploadFileRequest> it3 = sWIGVectorCloudUploadFileRequest.iterator();
            while (it3.hasNext()) {
                arrayList4.add(it3.next().getLocalPath());
            }
            cloudOperationLogger5.endActionBatch(strStartAction, "UPLOAD_FILES", arrayList4);
        }
        return batchResult;
    }

    private final List<Uploader.UploadResult> uploadFilesInternal(List<? extends CloudUploadFileRequest> entries, CancelableCloudTaskProgressHandler progressCallback) {
        ArrayList arrayList = new ArrayList();
        for (CloudUploadFileRequest cloudUploadFileRequest : entries) {
            Long lValueOf = Long.valueOf(cloudUploadFileRequest.getRequestId());
            String path = cloudUploadFileRequest.getFile().getPath();
            String localPath = cloudUploadFileRequest.getLocalPath();
            if (localPath == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            arrayList.add(new Uploader.UploadItem(lValueOf, path, localPath));
        }
        return upload(arrayList, progressCallback);
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public boolean exists(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            return existsInternal(strStartAction, filePath);
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, ResourceStates.EXISTS);
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public String getProfileId() {
        return HashUtilsKt.getSha256("Dropbox/TODO");
    }

    private final boolean existsInternal(String actionId, String filePath) {
        try {
            return DropboxClient.getInstance().files().getMetadata(filePath) != null;
        } catch (Exception e) {
            if (DropboxCallbackKt.isNotFound(e)) {
                return false;
            }
            this.errorCallback.handleAndThrowError(actionId, e);
            throw new KotlinNothingValueException();
        }
    }

    static /* synthetic */ BatchResult downloadFilesInternal$default(DropboxCallback dropboxCallback, String str, SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, CloudDownloadFileTaskHandler cloudDownloadFileTaskHandler, int i, Object obj) {
        if ((i & 8) != 0) {
            cloudDownloadFileTaskHandler = null;
        }
        return dropboxCallback.downloadFilesInternal(str, sWIGVectorCloudFileRequest, cancelableCloudTaskProgressHandler, cloudDownloadFileTaskHandler);
    }

    private final BatchResult downloadFilesInternal(String actionId, SWIGVectorCloudFileRequest cloudFileRequests, final CancelableCloudTaskProgressHandler progressCallback, final CloudDownloadFileTaskHandler doneCallback) {
        try {
            DbxClientV2 dropboxClient = DropboxClient.getInstance();
            Intrinsics.checkNotNullExpressionValue(dropboxClient, "getInstance(...)");
            return new DropboxDownloader(dropboxClient).download(cloudFileRequests, new ProgressListener() { // from class: com.myscript.nebo.dms.dropbox.DropboxCallback.downloadFilesInternal.1
                @Override // com.myscript.nebo.dms.cloud.common.api.ProgressListener
                public /* bridge */ /* synthetic */ void onComplete(Long l, String str) {
                    onComplete(l.longValue(), str);
                }

                @Override // com.myscript.nebo.dms.cloud.common.api.ProgressListener
                public /* bridge */ /* synthetic */ boolean onProgress(Long l, boolean z, long j, long j2) {
                    return onProgress(l.longValue(), z, j, j2);
                }

                public boolean onProgress(long requestId, boolean justCheckIsCanceled, long progress, long max) throws IOException {
                    CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler;
                    if (DropboxCallback.this.isConnected && ((cancelableCloudTaskProgressHandler = progressCallback) == null || cancelableCloudTaskProgressHandler.progress(requestId, justCheckIsCanceled, progress, max))) {
                        return false;
                    }
                    throw new IOException("Canceled");
                }

                public void onComplete(long requestId, String revision) {
                    CloudDownloadFileTaskHandler cloudDownloadFileTaskHandler;
                    Intrinsics.checkNotNullParameter(revision, "revision");
                    if (!DropboxCallback.this.isConnected || (cloudDownloadFileTaskHandler = doneCallback) == null) {
                        return;
                    }
                    cloudDownloadFileTaskHandler.downloaded(requestId);
                }
            });
        } catch (Exception e) {
            this.errorCallback.handleAndThrowError(actionId, e);
            throw new KotlinNothingValueException();
        }
    }

    private final List<Uploader.UploadResult> upload(List<? extends Uploader.UploadItem> uploadItems, final CancelableCloudTaskProgressHandler progressCallback) {
        return new DropboxUploader().upload(uploadItems, new ProgressListener() { // from class: com.myscript.nebo.dms.dropbox.DropboxCallback.upload.1
            public void onComplete(long requestId, String revision) {
                Intrinsics.checkNotNullParameter(revision, "revision");
            }

            @Override // com.myscript.nebo.dms.cloud.common.api.ProgressListener
            public /* bridge */ /* synthetic */ void onComplete(Long l, String str) {
                onComplete(l.longValue(), str);
            }

            @Override // com.myscript.nebo.dms.cloud.common.api.ProgressListener
            public /* bridge */ /* synthetic */ boolean onProgress(Long l, boolean z, long j, long j2) {
                return onProgress(l.longValue(), z, j, j2);
            }

            public boolean onProgress(long requestId, boolean justCheckIsCanceled, long progress, long max) {
                if (!DropboxCallback.this.isConnected) {
                    return true;
                }
                CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler = progressCallback;
                return (cancelableCloudTaskProgressHandler == null || cancelableCloudTaskProgressHandler.progress(requestId, justCheckIsCanceled, progress, max)) ? false : true;
            }
        });
    }

    private final void addToMetadataCache(CloudFileData cloudFileData) {
        if (Intrinsics.areEqual(cloudFileData.path(), getV2RootFullPath()) && !this.metadataCache.containsKey(getV2RootFullPath())) {
            this.metadataCache.put(getV2RootFullPath(), new HashMap<>());
            return;
        }
        String strParent = DropboxCallbackKt.parent(cloudFileData);
        if (strParent == null) {
            return;
        }
        if (!this.metadataCache.containsKey(strParent)) {
            this.metadataCache.put(strParent, new HashMap<>());
        }
        String strPath = cloudFileData.path();
        HashMap<String, CloudFileData> map = this.metadataCache.get(strParent);
        if (map != null) {
            map.put(strPath, cloudFileData);
        }
    }

    private final void removeFromMetadataCache(CloudFileData cloudFileData) {
        HashMap<String, CloudFileData> map;
        String strParent = DropboxCallbackKt.parent(cloudFileData);
        if (strParent != null && this.metadataCache.containsKey(strParent) && (map = this.metadataCache.get(strParent)) != null) {
            map.remove(cloudFileData.path());
        }
        this.metadataCache.remove(cloudFileData.path());
    }

    public final void reset() {
        this.listCursors.clear();
        this.metadataCache.clear();
    }

    public final DMSLogLevel errorLevelFromException(Exception exception) {
        String message;
        String message2;
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (!(exception instanceof NetworkIOException) && !(exception.getCause() instanceof NetworkIOException)) {
            if ((exception instanceof IllegalStateException) && (message2 = exception.getMessage()) != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "Unsupported Cloud Version", false, 2, (Object) null)) {
                return DMSLogLevel.INFO;
            }
            if (exception instanceof NoSuchElementException) {
                return DMSLogLevel.WARNING;
            }
            if ((exception instanceof IOException) && (message = exception.getMessage()) != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "Canceled", false, 2, (Object) null)) {
                return DMSLogLevel.INFO;
            }
            if (Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(31) >= 7) {
                if ((exception instanceof NetworkException) || (exception.getCause() instanceof NetworkException)) {
                    return DMSLogLevel.WARNING;
                }
                return DMSLogLevel.ERR;
            }
            return DMSLogLevel.ERR;
        }
        return DMSLogLevel.WARNING;
    }

    public final boolean isAuthenticateError(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        String message = exception.getMessage();
        if (message == null) {
            Throwable cause = exception.getCause();
            message = cause != null ? cause.getMessage() : null;
            if (message == null) {
                return false;
            }
        }
        String str = message;
        return StringsKt.contains$default((CharSequence) str, (CharSequence) DROPBOX_TOKEN_ERROR, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) DROPBOX_TOKEN_ERROR_BIS, false, 2, (Object) null);
    }

    public final String getName(String fileIdOrFilePath) throws DbxException {
        com.dropbox.core.p013v2.files.Metadata metadata = DropboxClient.getInstance().files().getMetadata(fileIdOrFilePath);
        if (metadata != null) {
            return metadata.getName();
        }
        return null;
    }
}
