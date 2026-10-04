package com.myscript.nebo.dms.gdrive;

import android.app.Application;
import android.net.http.NetworkException;
import android.os.ext.SdkExtensions;
import androidx.core.app.NotificationCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.credentials.provider.CredentialEntry;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.p007ts.PsExtractor;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.batch.json.JsonBatchCallback;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.googleapis.notifications.ResourceStates;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveRequest;
import com.google.api.services.drive.model.About;
import com.google.api.services.drive.model.Change;
import com.google.api.services.drive.model.ChangeList;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.myscript.android.utils.HashUtilsKt;
import com.myscript.nebo.cloudsync.dialogs.CloudTokenInvalidDialogFragment;
import com.myscript.nebo.dms.cloud.common.utils.CloudErrorExtKt;
import com.myscript.nebo.dms.cloud.common.utils.ProgressOutputStream;
import com.myscript.snt.dms.BatchResult;
import com.myscript.snt.dms.CancelableCloudTaskProgressHandler;
import com.myscript.snt.dms.CloudCreateFileRequest;
import com.myscript.snt.dms.CloudCreateFolderRequest;
import com.myscript.snt.dms.CloudDownloadFileTaskHandler;
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
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.p039io.CloseableKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: compiled from: GDriveCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0085\u00012\u00020\u0001:\u0006\u0083\u0001\u0084\u0001\u0085\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001a\u001a\u00020\fJ\u0012\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020\u0019H\u0016J\b\u0010+\u001a\u00020\u0015H\u0016J\b\u0010,\u001a\u00020\u0015H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\fH\u0016J\u0010\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015H\u0016J\u001a\u00101\u001a\u00020\u00152\b\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u00100\u001a\u00020\u0015H\u0002J\u001e\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0019H\u0016J\u001c\u00109\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010:\u001a\u00020\u0019H\u0002J \u0010;\u001a\b\u0012\u0004\u0012\u000205042\b\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u00106\u001a\u000207H\u0002J$\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0016042\u0006\u0010=\u001a\u00020\u00152\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00160?H\u0002J\u0010\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u000207H\u0016J \u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0019H\u0016J,\u0010I\u001a\u00020C2\b\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020\u0019H\u0002J\u0018\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020M2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020\u00152\u0006\u0010D\u001a\u00020OH\u0016J\u0018\u0010P\u001a\u00020K2\u0006\u0010L\u001a\u00020Q2\u0006\u0010F\u001a\u00020GH\u0016Jq\u0010R\u001a\n0SR\u00060 R\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u0010T\u001a\u00020\u00152\u0006\u0010U\u001a\u00020\u00152\b\b\u0002\u0010=\u001a\u00020\u00152\b\b\u0002\u0010V\u001a\u00020\u00152\u0014\b\u0002\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150X2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u0010ZJ\u0010\u0010[\u001a\u00020\f2\u0006\u0010A\u001a\u000207H\u0016J\u0010\u0010\\\u001a\u00020\f2\u0006\u00106\u001a\u000207H\u0016J\u001a\u0010]\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u0010A\u001a\u000207H\u0002J\"\u0010^\u001a\u00020\f2\b\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u0010_\u001a\u00020`2\u0006\u0010F\u001a\u00020GH\u0002J\u0018\u0010a\u001a\u00020\f2\u0006\u0010_\u001a\u00020`2\u0006\u0010F\u001a\u00020GH\u0016J\"\u0010b\u001a\u00020K2\b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010F\u001a\u00020G2\u0006\u0010e\u001a\u00020fH\u0016J\u0018\u0010g\u001a\u00020\u00152\u0006\u0010h\u001a\u00020i2\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010j\u001a\u00020K2\u0006\u0010k\u001a\u00020l2\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010m\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0015H\u0016J\b\u0010n\u001a\u00020\u0015H\u0016J\u0016\u0010o\u001a\u00020\f2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020r0qH\u0002J\u0016\u0010s\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160qH\u0002J\u0006\u0010t\u001a\u00020\fJ4\u0010u\u001a\n\u0018\u00010vj\u0004\u0018\u0001`w2\b\u00102\u001a\u0004\u0018\u00010\u00152\u0006\u0010x\u001a\u0002072\u0006\u0010T\u001a\u00020\u00152\b\b\u0002\u0010y\u001a\u00020\u0019H\u0002J\u0012\u0010z\u001a\u00020{2\n\u0010|\u001a\u00060vj\u0002`wJ\b\u0010}\u001a\u00020\fH\u0002J\u0012\u0010~\u001a\u00020\u00192\n\u0010|\u001a\u00060vj\u0002`wJ\u001b\u0010\u007f\u001a\u00020\f*\b0\u0080\u0001j\u0003`\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u001f\u001a\u00060 R\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0086\u0001"}, m1599d2 = {"Lcom/myscript/nebo/dms/gdrive/GDriveCallback;", "Lcom/myscript/snt/dms/ICloudDriveInterface;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "statusCallback", "Lcom/myscript/nebo/dms/gdrive/GDriveCallback$StatusCallback;", "errorCallback", "Lcom/myscript/nebo/dms/gdrive/GDriveCallback$ErrorCallback;", "cloudOperationLogger", "Lcom/myscript/snt/dms/CloudOperationLogger;", "onInsufficientStorage", "Lkotlin/Function0;", "", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/dms/gdrive/GDriveCallback$StatusCallback;Lcom/myscript/nebo/dms/gdrive/GDriveCallback$ErrorCallback;Lcom/myscript/snt/dms/CloudOperationLogger;Lkotlin/jvm/functions/Function0;)V", "downloadDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "uploadDispatcher", "createFileDispatcher", "metadataCache", "", "", "Lcom/google/api/services/drive/model/File;", "filePathToIdCache", "isConnected", "", CloudTokenInvalidDialogFragment.ACTION_DISCONNECT, NotificationCompat.CATEGORY_SERVICE, "Lcom/google/api/services/drive/Drive;", "getService", "()Lcom/google/api/services/drive/Drive;", "files", "Lcom/google/api/services/drive/Drive$Files;", "getFiles", "()Lcom/google/api/services/drive/Drive$Files;", "autoSyncIntervalInSeconds", "", "getAutoSyncIntervalInSeconds", "()J", "startPageToken", "isGDriveStorageFull", "margin", "isCloudEnabled", "getV1RootPath", "getV2RootPath", "isV2Initialized", "initializeV2", "getId", "filePath", "getIdInternal", "actionId", "list", "", "Lcom/myscript/snt/dms/CloudFileData;", "folder", "Lcom/myscript/snt/dms/CloudFile;", "needsLastModificationDate", "refreshCache", "forceFullRefresh", "listFromCache", "populateFileList", "parentId", "inputFiles", "", "getRevision", "file", "createFile", "Lcom/myscript/snt/dms/CloudFileIdRev;", "request", "Lcom/myscript/snt/dms/CloudCreateFileRequest;", "progressCallback", "Lcom/myscript/snt/dms/CancelableCloudTaskProgressHandler;", "checkAlreadyExists", "createFileInternal", "createFiles", "Lcom/myscript/snt/dms/BatchResult;", "requests", "Lcom/myscript/snt/dms/SWIGVectorCloudCreateFileRequest;", "createFolder", "Lcom/myscript/snt/dms/CloudCreateFolderRequest;", "createFolders", "Lcom/myscript/snt/dms/SWIGVectorCloudCreateFolderRequest;", "getDriveFileCreationRequest", "Lcom/google/api/services/drive/Drive$Files$Create;", "name", "mimeType", "localPath", DiagnosticsEntry.PROPERTIES_KEY, "", "requestId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/myscript/snt/dms/CancelableCloudTaskProgressHandler;Ljava/lang/Long;)Lcom/google/api/services/drive/Drive$Files$Create;", "deleteFile", "deleteFolder", "deleteInternal", "downloadFileInternal", "fileRequest", "Lcom/myscript/snt/dms/CloudFileRequest;", "downloadFile", "downloadFiles", "fileRequests", "Lcom/myscript/snt/dms/SWIGVectorCloudFileRequest;", "doneCallback", "Lcom/myscript/snt/dms/CloudDownloadFileTaskHandler;", "uploadFile", "uploadRequest", "Lcom/myscript/snt/dms/CloudUploadFileRequest;", "uploadFiles", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Lcom/myscript/snt/dms/SWIGVectorCloudUploadFileRequest;", "exists", "getProfileId", "cacheChanges", "changes", "", "Lcom/google/api/services/drive/model/Change;", "cacheFiles", "reset", "checkAlreadyExistsFast", "Ljava/lang/Exception;", "Lkotlin/Exception;", "parent", "throwAutomatically", "errorLevelForException", "Lcom/myscript/snt/dms/DMSLogLevel;", "exception", "checkConnectivity", "isAuthenticateError", "appendToQuery", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "queryParameter", "StatusCallback", "ErrorCallback", "Companion", "dms-gdrive_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class GDriveCallback implements ICloudDriveInterface {
    private static final double CURRENT_VERSION = 2.1d;
    private static final String DRIVE_FILE_FIELDS = "id, name, parents, mimeType, headRevisionId, modifiedTime, size";
    private static final String DRIVE_ROOT_PATH = "App Data";
    private static final String DRIVE_ROOT_PATH_ID = "appDataFolder";
    public static final int GDRIVE_MAX_REQUESTS_IN_BATCH = 100;
    private static final String GDRIVE_TOKEN_BAD_AUTHENTICATION = "BadAuthentication";
    private static final String GDRIVE_TOKEN_ERROR = "Invalid Credentials";
    private static final String GDRIVE_V1_ROOT_NAME = "";
    private static final String GDRIVE_V2_ROOT_NAME = "2.0";
    public static final int LIST_PAGE_SIZE = 1000;
    private final Application application;
    private final CloudOperationLogger cloudOperationLogger;
    private final ExecutorCoroutineDispatcher createFileDispatcher;
    private final ExecutorCoroutineDispatcher downloadDispatcher;
    private final ErrorCallback errorCallback;
    private final Map<String, String> filePathToIdCache;
    private volatile boolean isConnected;
    private final Map<String, File> metadataCache;
    private final Function0<Unit> onInsufficientStorage;
    private String startPageToken;
    private final StatusCallback statusCallback;
    private final ExecutorCoroutineDispatcher uploadDispatcher;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> GDRIVE_LIMIT_EXCEEDED_REASONS = CollectionsKt.listOf((Object[]) new String[]{"userRateLimitExceeded", "rateLimitExceeded"});
    private static final List<String> GDRIVE_STORAGE_QUOTA_EXCEEDED_REASONS = CollectionsKt.listOf("storageQuotaExceeded");

    /* JADX INFO: compiled from: GDriveCallback.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/gdrive/GDriveCallback$ErrorCallback;", "", "handleAndThrowError", "", "actionId", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "dms-gdrive_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface ErrorCallback {
        Void handleAndThrowError(String actionId, Exception exception);
    }

    /* JADX INFO: compiled from: GDriveCallback.kt */
    @FunctionalInterface
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/gdrive/GDriveCallback$StatusCallback;", "", "isGDriveAvailable", "", "dms-gdrive_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface StatusCallback {
        boolean isGDriveAvailable();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GDriveCallback(Application application, StatusCallback statusCallback, ErrorCallback errorCallback) {
        this(application, statusCallback, errorCallback, null, null, 24, null);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(statusCallback, "statusCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GDriveCallback(Application application, StatusCallback statusCallback, ErrorCallback errorCallback, CloudOperationLogger cloudOperationLogger) {
        this(application, statusCallback, errorCallback, cloudOperationLogger, null, 16, null);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(statusCallback, "statusCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
    }

    public final long getAutoSyncIntervalInSeconds() {
        return 60L;
    }

    public GDriveCallback(Application application, StatusCallback statusCallback, ErrorCallback errorCallback, CloudOperationLogger cloudOperationLogger, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(statusCallback, "statusCallback");
        Intrinsics.checkNotNullParameter(errorCallback, "errorCallback");
        this.application = application;
        this.statusCallback = statusCallback;
        this.errorCallback = errorCallback;
        this.cloudOperationLogger = cloudOperationLogger;
        this.onInsufficientStorage = function0;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(5);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(...)");
        this.downloadDispatcher = ExecutorsKt.from(executorServiceNewFixedThreadPool);
        ExecutorService executorServiceNewFixedThreadPool2 = Executors.newFixedThreadPool(10);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool2, "newFixedThreadPool(...)");
        this.uploadDispatcher = ExecutorsKt.from(executorServiceNewFixedThreadPool2);
        ExecutorService executorServiceNewFixedThreadPool3 = Executors.newFixedThreadPool(10);
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool3, "newFixedThreadPool(...)");
        this.createFileDispatcher = ExecutorsKt.from(executorServiceNewFixedThreadPool3);
        this.metadataCache = new LinkedHashMap();
        this.filePathToIdCache = new LinkedHashMap();
        this.isConnected = true;
    }

    public /* synthetic */ GDriveCallback(Application application, StatusCallback statusCallback, ErrorCallback errorCallback, CloudOperationLogger cloudOperationLogger, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, statusCallback, errorCallback, (i & 8) != 0 ? null : cloudOperationLogger, (i & 16) != 0 ? null : function0);
    }

    public final void disconnect() {
        this.isConnected = false;
    }

    private final Drive getService() {
        Drive driveService = DriveLoginHelper.getInstance().getDriveService();
        Intrinsics.checkNotNullExpressionValue(driveService, "getDriveService(...)");
        return driveService;
    }

    public final Drive.Files getFiles() {
        Drive.Files files = getService().files();
        Intrinsics.checkNotNullExpressionValue(files, "files(...)");
        return files;
    }

    static /* synthetic */ boolean isGDriveStorageFull$default(GDriveCallback gDriveCallback, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        return gDriveCallback.isGDriveStorageFull(j);
    }

    private final boolean isGDriveStorageFull(long margin) {
        About.StorageQuota storageQuota;
        Long limit;
        Long usage;
        try {
            About aboutExecute = getService().about().get().setFields2("storageQuota(limit, usage)").execute();
            if (aboutExecute != null && (storageQuota = aboutExecute.getStorageQuota()) != null && (limit = storageQuota.getLimit()) != null) {
                long jLongValue = limit.longValue();
                About.StorageQuota storageQuota2 = aboutExecute.getStorageQuota();
                if (storageQuota2 != null && (usage = storageQuota2.getUsage()) != null) {
                    long jLongValue2 = usage.longValue();
                    if (jLongValue > 0 && jLongValue2 + margin >= jLongValue) {
                        return true;
                    }
                }
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public boolean isCloudEnabled() {
        return this.statusCallback.isGDriveAvailable();
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    /* JADX INFO: renamed from: getV1RootPath */
    public String getV1RootFullPath() {
        return "";
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    /* JADX INFO: renamed from: getV2RootPath */
    public String getV2RootFullPath() {
        return GDRIVE_V2_ROOT_NAME;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.google.api.services.drive.Drive$Files$List] */
    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public boolean isV2Initialized() {
        List<File> files;
        double d;
        Collection<File> collectionValues = this.metadataCache.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (GDriveCallbackKt.isV2VersionFolder((File) it.next())) {
                    return true;
                }
            }
        }
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        Object obj = null;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        Drive.Files.List spaces = getFiles().list().setQ("mimeType = 'application/vnd.myscript.neboversion' or (mimeType = 'application/vnd.google-apps.folder' and appProperties has { key='isV2RootFolder' and value='true' })").setFields2("files(id, mimeType, name, appProperties)").setSpaces(DRIVE_ROOT_PATH_ID);
        try {
            try {
                checkConnectivity();
                FileList fileListExecute = spaces.execute();
                List<File> files2 = fileListExecute.getFiles();
                Intrinsics.checkNotNullExpressionValue(files2, "getFiles(...)");
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : files2) {
                    if (Intrinsics.areEqual(((File) obj2).getMimeType(), "application/vnd.myscript.neboversion")) {
                        arrayList.add(obj2);
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    try {
                        String name = ((File) it2.next()).getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        d = Double.parseDouble(name);
                    } catch (NumberFormatException unused) {
                        d = 1.0d;
                    }
                    arrayList3.add(Double.valueOf(d));
                }
                ArrayList arrayList4 = arrayList3;
                boolean z = arrayList4 instanceof Collection;
                if (!z || !arrayList4.isEmpty()) {
                    Iterator it3 = arrayList4.iterator();
                    while (it3.hasNext()) {
                        if (((Number) it3.next()).doubleValue() > CURRENT_VERSION) {
                            this.errorCallback.handleAndThrowError(strStartAction, new IllegalStateException("Unsupported Cloud Version"));
                            throw new KotlinNothingValueException();
                        }
                    }
                }
                if (!z || !arrayList4.isEmpty()) {
                    Iterator it4 = arrayList4.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            break;
                        }
                        if (((Number) it4.next()).doubleValue() == CURRENT_VERSION) {
                            if (fileListExecute != null && (files = fileListExecute.getFiles()) != null) {
                                Iterator<T> it5 = files.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        break;
                                    }
                                    Object next = it5.next();
                                    if (GDriveCallbackKt.isV2VersionFolder((File) next)) {
                                        obj = next;
                                        break;
                                    }
                                }
                                File file = (File) obj;
                                if (file != null) {
                                    this.metadataCache.put(file.getId(), file);
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    @Override // com.myscript.snt.dms.ICloudDriveInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initializeV2() throws Throwable {
        GDriveCallback gDriveCallback;
        CloudOperationLogger cloudOperationLogger;
        if (isV2Initialized()) {
            return;
        }
        CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger2 != null ? cloudOperationLogger2.startAction() : null;
        try {
            try {
                checkConnectivity();
                gDriveCallback = this;
                try {
                    getDriveFileCreationRequest$default(gDriveCallback, strStartAction, "2.1", "application/vnd.myscript.neboversion", null, null, null, null, null, 248, null).execute();
                    if (getFiles().list().setQ("mimeType = 'application/vnd.google-apps.folder' and appProperties has { key='isV2RootFolder' and value='true' }").setSpaces(DRIVE_ROOT_PATH_ID).execute().getFiles().isEmpty()) {
                        gDriveCallback = this;
                        gDriveCallback.filePathToIdCache.put(GDRIVE_V2_ROOT_NAME, getDriveFileCreationRequest$default(gDriveCallback, strStartAction, GDRIVE_V2_ROOT_NAME, "application/vnd.google-apps.folder", "", "", MapsKt.mapOf(TuplesKt.m1606to("isV2RootFolder", CredentialEntry.TRUE_STRING)), null, null, PsExtractor.AUDIO_STREAM, null).execute().getId());
                    } else {
                        gDriveCallback = this;
                    }
                    CloudOperationLogger cloudOperationLogger3 = gDriveCallback.cloudOperationLogger;
                    if (cloudOperationLogger3 != null) {
                        cloudOperationLogger3.endAction(strStartAction, "INITIALIZE_V2");
                    }
                } catch (Exception e) {
                    e = e;
                    gDriveCallback.errorCallback.handleAndThrowError(strStartAction, e);
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                th = th;
                cloudOperationLogger = this.cloudOperationLogger;
                if (cloudOperationLogger != null) {
                    cloudOperationLogger.endAction(strStartAction, "INITIALIZE_V2");
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            gDriveCallback = this;
        } catch (Throwable th2) {
            th = th2;
            cloudOperationLogger = this.cloudOperationLogger;
            if (cloudOperationLogger != null) {
            }
            throw th;
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public String getId(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            return getIdInternal(strStartAction, filePath);
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "GET_ID");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.api.services.drive.Drive$Files$List] */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.google.api.services.drive.Drive$Files$List] */
    private final String getIdInternal(String actionId, String filePath) {
        List list;
        String str = filePath;
        String str2 = "";
        if (StringsKt.isBlank(str)) {
            try {
                checkConnectivity();
                String id = getFiles().get(DRIVE_ROOT_PATH_ID).setFields2("id").execute().getId();
                this.filePathToIdCache.put("", id);
                Intrinsics.checkNotNull(id);
                return id;
            } catch (Exception e) {
                this.errorCallback.handleAndThrowError(actionId, e);
                throw new KotlinNothingValueException();
            }
        }
        int i = 0;
        List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{DomExceptionUtils.SEPARATOR}, false, 0, 6, (Object) null);
        StringBuilder sb = new StringBuilder();
        int size = listSplit$default.size() - 1;
        String str3 = "";
        while (true) {
            String str4 = str2;
            if (i < size) {
                if (i > 0) {
                    sb.append(DomExceptionUtils.SEPARATOR);
                }
                int i2 = size;
                sb.append(DomExceptionUtils.SEPARATOR + listSplit$default.get(i));
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                if (this.filePathToIdCache.containsKey(string)) {
                    String str5 = this.filePathToIdCache.get(string);
                    if (str5 == null) {
                        str5 = str4;
                    }
                    str3 = str5;
                    list = listSplit$default;
                } else if (StringsKt.isBlank((CharSequence) listSplit$default.get(i))) {
                    list = listSplit$default;
                    str3 = DRIVE_ROOT_PATH_ID;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    if (StringsKt.isBlank((CharSequence) listSplit$default.get(i))) {
                        list = listSplit$default;
                    } else {
                        list = listSplit$default;
                        appendToQuery(sb2, "name = '" + listSplit$default.get(i) + "'");
                    }
                    if (!StringsKt.isBlank(str3)) {
                        appendToQuery(sb2, "'" + ((Object) str3) + "' in parents");
                    }
                    if (!Intrinsics.areEqual(filePath, DRIVE_ROOT_PATH)) {
                        appendToQuery(sb2, "mimeType = 'application/vnd.google-apps.folder'");
                    }
                    String string2 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                    try {
                        checkConnectivity();
                        FileList fileListExecute = getFiles().list().setFields2("files(id, name, parents, mimeType, headRevisionId, modifiedTime, size)").setQ(string2).setSpaces(DRIVE_ROOT_PATH_ID).execute();
                        if (fileListExecute.getFiles().isEmpty()) {
                            throw new NoSuchElementException();
                        }
                        if (fileListExecute.getFiles().size() > 1) {
                            throw new IllegalStateException("File with path " + filePath + " has more than 1 result.");
                        }
                        List<File> files = fileListExecute.getFiles();
                        Intrinsics.checkNotNullExpressionValue(files, "getFiles(...)");
                        String id2 = ((File) CollectionsKt.first((List) files)).getId();
                        Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                        this.filePathToIdCache.put(sb.toString(), id2);
                        str3 = id2;
                    } catch (Exception e2) {
                        this.errorCallback.handleAndThrowError(actionId, e2);
                        throw new KotlinNothingValueException();
                    }
                }
                i++;
                str2 = str4;
                size = i2;
                listSplit$default = list;
            } else {
                StringBuilder sb3 = new StringBuilder();
                appendToQuery(sb3, "name = '" + CollectionsKt.last(listSplit$default) + "'");
                appendToQuery(sb3, "mimeType != 'application/vnd.myscript.neboversion'");
                if (!StringsKt.isBlank(str3)) {
                    appendToQuery(sb3, "'" + ((Object) str3) + "' in parents");
                }
                String string3 = sb3.toString();
                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                try {
                    checkConnectivity();
                    FileList fileListExecute2 = getFiles().list().setFields2("files(id)").setQ(string3).setSpaces(DRIVE_ROOT_PATH_ID).execute();
                    if (fileListExecute2.getFiles().isEmpty()) {
                        throw new NoSuchElementException();
                    }
                    if (fileListExecute2.getFiles().size() > 1) {
                        throw new IllegalStateException("File with path " + filePath + " has more than 1 result.");
                    }
                    List<File> files2 = fileListExecute2.getFiles();
                    Intrinsics.checkNotNullExpressionValue(files2, "getFiles(...)");
                    String id3 = ((File) CollectionsKt.first((List) files2)).getId();
                    this.filePathToIdCache.put(filePath, id3);
                    Intrinsics.checkNotNull(id3);
                    return id3;
                } catch (Exception e3) {
                    this.errorCallback.handleAndThrowError(actionId, e3);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public List<CloudFileData> list(CloudFile folder, boolean needsLastModificationDate) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            refreshCache$default(this, strStartAction, false, 2, null);
            return listFromCache(strStartAction, folder);
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "LIST");
            }
        }
    }

    static /* synthetic */ void refreshCache$default(GDriveCallback gDriveCallback, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        gDriveCallback.refreshCache(str, z);
    }

    private final void refreshCache(String actionId, boolean forceFullRefresh) {
        String nextPageToken = null;
        if (this.startPageToken == null || forceFullRefresh) {
            do {
                try {
                    checkConnectivity();
                    Drive.Files.List list = getFiles().list();
                    list.setFields2("nextPageToken, files(id, name, parents, mimeType, headRevisionId, modifiedTime, size, appProperties)");
                    list.setSpaces(DRIVE_ROOT_PATH_ID);
                    list.setPageSize(1000);
                    if (nextPageToken != null) {
                        list.setPageToken(nextPageToken);
                    }
                    FileList fileListExecute = list.execute();
                    List<File> files = fileListExecute.getFiles();
                    Intrinsics.checkNotNullExpressionValue(files, "getFiles(...)");
                    cacheFiles(files);
                    nextPageToken = fileListExecute.getNextPageToken();
                } catch (Exception e) {
                    this.errorCallback.handleAndThrowError(actionId, e);
                    throw new KotlinNothingValueException();
                }
            } while (nextPageToken != null);
            this.startPageToken = getService().changes().getStartPageToken().execute().getStartPageToken();
            return;
        }
        do {
            try {
                checkConnectivity();
                Drive.Changes.List list2 = getService().changes().list(this.startPageToken);
                list2.setFields2("nextPageToken, newStartPageToken, changes(file(id, name, parents, mimeType, headRevisionId, modifiedTime, size, appProperties), removed, fileId)");
                list2.setSpaces(DRIVE_ROOT_PATH_ID);
                list2.setPageSize(1000);
                list2.setIncludeRemoved(true);
                if (nextPageToken != null) {
                    list2.setPageToken(nextPageToken);
                }
                ChangeList changeListExecute = list2.execute();
                List<Change> changes = changeListExecute.getChanges();
                Intrinsics.checkNotNullExpressionValue(changes, "getChanges(...)");
                cacheChanges(changes);
                String newStartPageToken = changeListExecute.getNewStartPageToken();
                if (newStartPageToken != null) {
                    this.startPageToken = newStartPageToken;
                }
                nextPageToken = changeListExecute.getNextPageToken();
            } catch (Exception e2) {
                this.errorCallback.handleAndThrowError(actionId, e2);
                throw new KotlinNothingValueException();
            }
        } while (nextPageToken != null);
    }

    private final List<CloudFileData> listFromCache(String actionId, CloudFile folder) {
        if (!folder.getPath().equals("") && !folder.getPath().equals(GDRIVE_V2_ROOT_NAME) && !this.metadataCache.containsKey(folder.getId())) {
            this.errorCallback.handleAndThrowError(actionId, new NoSuchElementException("Folder with id " + folder.getId() + " not found"));
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.metadataCache.values());
        String id = folder.getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        List<File> listPopulateFileList = populateFileList(id, arrayList);
        SWIGVectorCloudFileData sWIGVectorCloudFileData = new SWIGVectorCloudFileData();
        Iterator<T> it = listPopulateFileList.iterator();
        while (it.hasNext()) {
            sWIGVectorCloudFileData.push_back(GDriveCallbackKt.toCloudFileData((File) it.next()));
        }
        return sWIGVectorCloudFileData;
    }

    private final List<File> populateFileList(String parentId, List<File> inputFiles) {
        ArrayList<File> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<File> it = inputFiles.iterator();
        while (it.hasNext()) {
            File next = it.next();
            if (!GDriveCallbackKt.isVersionFileMimeType(next.getMimeType()) && !GDriveCallbackKt.isV2VersionFolder(next)) {
                List<String> parents = next.getParents();
                if (parents != null && parents.contains(parentId)) {
                    arrayList2.add(next);
                    arrayList.add(next);
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
        for (File file : arrayList) {
            if (GDriveCallbackKt.isFolderMimeType(file.getMimeType())) {
                String id = file.getId();
                Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                arrayList2.addAll(populateFileList(id, inputFiles));
            }
        }
        return arrayList2;
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public String getRevision(CloudFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            try {
                checkConnectivity();
                String headRevisionId = getFiles().get(file.getId()).setFields2("id, headRevisionId").execute().getHeadRevisionId();
                Intrinsics.checkNotNullExpressionValue(headRevisionId, "getHeadRevisionId(...)");
                return headRevisionId;
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
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        if (checkAlreadyExists) {
            try {
                refreshCache$default(this, strStartAction, false, 2, null);
            } finally {
                CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
                if (cloudOperationLogger2 != null) {
                    cloudOperationLogger2.endAction(strStartAction, "CREATE_FILE", request.getLocalPath());
                }
            }
        }
        return createFileInternal(strStartAction, request, progressCallback, checkAlreadyExists);
    }

    static /* synthetic */ CloudFileIdRev createFileInternal$default(GDriveCallback gDriveCallback, String str, CloudCreateFileRequest cloudCreateFileRequest, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return gDriveCallback.createFileInternal(str, cloudCreateFileRequest, cancelableCloudTaskProgressHandler, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final CloudFileIdRev createFileInternal(String actionId, CloudCreateFileRequest request, CancelableCloudTaskProgressHandler progressCallback, boolean checkAlreadyExists) {
        if (checkAlreadyExists) {
            try {
                CloudFile parent = request.getParent();
                Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                String name = request.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                checkAlreadyExistsFast$default(this, actionId, parent, name, false, 8, null);
            } catch (Exception e) {
                e = e;
                String localPath = request.getLocalPath();
                Intrinsics.checkNotNullExpressionValue(localPath, "getLocalPath(...)");
                long length = 0;
                if (!StringsKt.isBlank(localPath)) {
                    java.io.File file = new java.io.File(request.getLocalPath());
                    if (!file.exists()) {
                        file = null;
                    }
                    if (file != null) {
                        length = file.length();
                    }
                }
                if (GDriveCallbackKt.isStorageQuotaExceeded(e)) {
                    Function0<Unit> function0 = this.onInsufficientStorage;
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else if (e instanceof GoogleJsonResponseException) {
                    GoogleJsonResponseException googleJsonResponseException = (GoogleJsonResponseException) e;
                    if (googleJsonResponseException.getStatusCode() == 403 && googleJsonResponseException.getDetails() == null && isGDriveStorageFull(length)) {
                    }
                }
                if ((e instanceof GoogleJsonResponseException) && ((GoogleJsonResponseException) e).getStatusCode() == 404) {
                    e = new NoSuchElementException("Parent folder " + request.getParent().getPath() + " not found");
                }
                this.errorCallback.handleAndThrowError(actionId, e);
                throw new KotlinNothingValueException();
            }
        }
        checkConnectivity();
        String name2 = request.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        String mimeType = request.getMimeType();
        Intrinsics.checkNotNullExpressionValue(mimeType, "getMimeType(...)");
        String gDriveMimeType = GDriveCallbackKt.toGDriveMimeType(mimeType);
        String id = request.getParent().getId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        String localPath2 = request.getLocalPath();
        Intrinsics.checkNotNullExpressionValue(localPath2, "getLocalPath(...)");
        File fileExecute = getDriveFileCreationRequest$default(this, actionId, name2, gDriveMimeType, id, localPath2, null, progressCallback, Long.valueOf(request.getRequestId()), 32, null).execute();
        CloudFileIdRev cloudFileIdRev = new CloudFileIdRev();
        cloudFileIdRev.setId(fileExecute.getId());
        cloudFileIdRev.setRevision(fileExecute.getHeadRevisionId());
        return cloudFileIdRev;
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public BatchResult createFiles(SWIGVectorCloudCreateFileRequest requests, CancelableCloudTaskProgressHandler progressCallback) throws InterruptedException {
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        ArrayList arrayList = new ArrayList();
        BatchResult batchResult = new BatchResult();
        refreshCache$default(this, strStartAction, false, 2, null);
        BuildersKt__BuildersKt.runBlocking$default(null, new C62751(requests, this, strStartAction, progressCallback, batchResult, arrayList, null), 1, null);
        CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
        if (cloudOperationLogger2 != null) {
            cloudOperationLogger2.endActionBatch(strStartAction, "CREATE_FILES", arrayList);
        }
        return batchResult;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.gdrive.GDriveCallback$createFiles$1 */
    /* JADX INFO: compiled from: GDriveCallback.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.gdrive.GDriveCallback$createFiles$1", m1609f = "GDriveCallback.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $actionId;
        final /* synthetic */ List<String> $files;
        final /* synthetic */ CancelableCloudTaskProgressHandler $progressCallback;
        final /* synthetic */ SWIGVectorCloudCreateFileRequest $requests;
        final /* synthetic */ BatchResult $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GDriveCallback this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62751(SWIGVectorCloudCreateFileRequest sWIGVectorCloudCreateFileRequest, GDriveCallback gDriveCallback, String str, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, BatchResult batchResult, List<String> list, Continuation<? super C62751> continuation) {
            super(2, continuation);
            this.$requests = sWIGVectorCloudCreateFileRequest;
            this.this$0 = gDriveCallback;
            this.$actionId = str;
            this.$progressCallback = cancelableCloudTaskProgressHandler;
            this.$result = batchResult;
            this.$files = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C62751 c62751 = new C62751(this.$requests, this.this$0, this.$actionId, this.$progressCallback, this.$result, this.$files, continuation);
            c62751.L$0 = obj;
            return c62751;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SWIGVectorCloudCreateFileRequest sWIGVectorCloudCreateFileRequest = this.$requests;
            GDriveCallback gDriveCallback = this.this$0;
            String str = this.$actionId;
            CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler = this.$progressCallback;
            BatchResult batchResult = this.$result;
            List<String> list = this.$files;
            for (CloudCreateFileRequest cloudCreateFileRequest : sWIGVectorCloudCreateFileRequest) {
                ExecutorCoroutineDispatcher executorCoroutineDispatcher = gDriveCallback.createFileDispatcher;
                GDriveCallback$createFiles$1$1$1 gDriveCallback$createFiles$1$1$1 = new GDriveCallback$createFiles$1$1$1(gDriveCallback, str, cloudCreateFileRequest, cancelableCloudTaskProgressHandler, batchResult, list, null);
                List<String> list2 = list;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, executorCoroutineDispatcher, null, gDriveCallback$createFiles$1$1$1, 2, null);
                gDriveCallback = gDriveCallback;
                str = str;
                cancelableCloudTaskProgressHandler = cancelableCloudTaskProgressHandler;
                batchResult = batchResult;
                list = list2;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    @Override // com.myscript.snt.dms.ICloudDriveInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String createFolder(CloudCreateFolderRequest request) throws Throwable {
        String str;
        CloudOperationLogger cloudOperationLogger;
        Intrinsics.checkNotNullParameter(request, "request");
        CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
        String str2 = null;
        String strStartAction = cloudOperationLogger2 != null ? cloudOperationLogger2.startAction() : null;
        String id = request.getParent().getId();
        if (StringsKt.isBlank(id)) {
            id = DRIVE_ROOT_PATH_ID;
        }
        String str3 = id;
        String name = request.getName();
        try {
            try {
                refreshCache$default(this, strStartAction, false, 2, null);
                str = strStartAction;
                try {
                    CloudFile parent = request.getParent();
                    Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                    String name2 = request.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    checkAlreadyExistsFast$default(this, str, parent, name2, false, 8, null);
                    checkConnectivity();
                    Intrinsics.checkNotNull(name);
                    Intrinsics.checkNotNull(str3);
                    String id2 = getDriveFileCreationRequest$default(this, str, name, "application/vnd.google-apps.folder", str3, null, null, null, Long.valueOf(request.getRequestId()), 112, null).execute().getId();
                    CloudOperationLogger cloudOperationLogger3 = this.cloudOperationLogger;
                    if (cloudOperationLogger3 != null) {
                        cloudOperationLogger3.endAction(str, "CREATE_FOLDER");
                    }
                    Intrinsics.checkNotNull(id2);
                    return id2;
                } catch (Exception e) {
                    e = e;
                    if ((e instanceof GoogleJsonResponseException) && ((GoogleJsonResponseException) e).getStatusCode() == 404) {
                        e = new NoSuchElementException("Parent folder " + request.getParent().getPath() + " not found");
                    }
                    this.errorCallback.handleAndThrowError(str, e);
                    throw new KotlinNothingValueException();
                }
            } catch (Throwable th) {
                th = th;
                cloudOperationLogger = this.cloudOperationLogger;
                if (cloudOperationLogger != null) {
                    cloudOperationLogger.endAction(str2, "CREATE_FOLDER");
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            str = strStartAction;
        } catch (Throwable th2) {
            th = th2;
            str2 = strStartAction;
            cloudOperationLogger = this.cloudOperationLogger;
            if (cloudOperationLogger != null) {
            }
            throw th;
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public BatchResult createFolders(SWIGVectorCloudCreateFolderRequest requests, CancelableCloudTaskProgressHandler progressCallback) {
        boolean z;
        BatchRequest batchRequest;
        final BatchResult batchResult;
        final Ref.LongRef longRef;
        long j;
        GDriveCallback gDriveCallback = this;
        Intrinsics.checkNotNullParameter(requests, "requests");
        CancelableCloudTaskProgressHandler progressCallback2 = progressCallback;
        Intrinsics.checkNotNullParameter(progressCallback2, "progressCallback");
        CloudOperationLogger cloudOperationLogger = gDriveCallback.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        BatchResult batchResult2 = new BatchResult();
        BatchRequest batchRequestBatch = gDriveCallback.getService().batch();
        long size = requests.size();
        Ref.LongRef longRef2 = new Ref.LongRef();
        List listChunked = CollectionsKt.chunked(requests, 100);
        boolean z2 = false;
        try {
            refreshCache$default(gDriveCallback, strStartAction, false, 2, null);
            Iterator it = listChunked.iterator();
            BatchRequest batchRequestBatch2 = batchRequestBatch;
            while (it.hasNext()) {
                for (final CloudCreateFolderRequest cloudCreateFolderRequest : (List) it.next()) {
                    CloudFile parent = cloudCreateFolderRequest.getParent();
                    Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
                    String name = cloudCreateFolderRequest.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    Exception excCheckAlreadyExistsFast = gDriveCallback.checkAlreadyExistsFast(strStartAction, parent, name, z2);
                    if (excCheckAlreadyExistsFast != null) {
                        CloudOperationLogger cloudOperationLogger2 = gDriveCallback.cloudOperationLogger;
                        if (cloudOperationLogger2 != null) {
                            cloudOperationLogger2.addError(strStartAction, excCheckAlreadyExistsFast.toString());
                        }
                        batchResult2.put(cloudCreateFolderRequest.getRequestId(), CloudErrorExtKt.getAsCloudError(excCheckAlreadyExistsFast));
                        batchRequest = batchRequestBatch2;
                        j = size;
                        z = z2;
                        batchResult = batchResult2;
                        longRef = longRef2;
                    } else {
                        String name2 = cloudCreateFolderRequest.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        String id = cloudCreateFolderRequest.getParent().getId();
                        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                        final long j2 = size;
                        z = z2;
                        Drive.Files.Create driveFileCreationRequest$default = getDriveFileCreationRequest$default(gDriveCallback, strStartAction, name2, "application/vnd.google-apps.folder", id, null, null, null, Long.valueOf(cloudCreateFolderRequest.getRequestId()), 112, null);
                        try {
                            final String str = strStartAction;
                            batchRequest = batchRequestBatch2;
                            final CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler = progressCallback2;
                            batchResult = batchResult2;
                            longRef = longRef2;
                            try {
                                JsonBatchCallback<File> jsonBatchCallback = new JsonBatchCallback<File>() { // from class: com.myscript.nebo.dms.gdrive.GDriveCallback$createFolders$1$1$1
                                    @Override // com.google.api.client.googleapis.batch.BatchCallback
                                    public void onSuccess(File file, HttpHeaders responseHeaders) {
                                        Intrinsics.checkNotNullParameter(file, "file");
                                        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                                        CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler2 = cancelableCloudTaskProgressHandler;
                                        long requestId = cloudCreateFolderRequest.getRequestId();
                                        longRef.element++;
                                        cancelableCloudTaskProgressHandler2.progress(requestId, false, longRef.element, j2);
                                        BatchResult batchResult3 = batchResult;
                                        CloudCreateFolderRequest cloudCreateFolderRequest2 = cloudCreateFolderRequest;
                                        synchronized (batchResult3) {
                                            batchResult3.put(cloudCreateFolderRequest2.getRequestId(), file.getId());
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    }

                                    @Override // com.google.api.client.googleapis.batch.json.JsonBatchCallback
                                    public void onFailure(GoogleJsonError e, HttpHeaders responseHeaders) {
                                        NoSuchElementException runtimeException;
                                        Intrinsics.checkNotNullParameter(e, "e");
                                        Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
                                        if (e.getCode() == 404) {
                                            runtimeException = new NoSuchElementException("Parent not found " + e.getMessage());
                                        } else {
                                            runtimeException = new RuntimeException("createFolders failed " + e.getMessage());
                                        }
                                        BatchResult batchResult3 = batchResult;
                                        GDriveCallback gDriveCallback2 = this;
                                        String str2 = str;
                                        CloudCreateFolderRequest cloudCreateFolderRequest2 = cloudCreateFolderRequest;
                                        synchronized (batchResult3) {
                                            CloudOperationLogger cloudOperationLogger3 = gDriveCallback2.cloudOperationLogger;
                                            if (cloudOperationLogger3 != null) {
                                                cloudOperationLogger3.addError(str2, CloudErrorExtKt.getAsCloudError(runtimeException).toString());
                                            }
                                            batchResult3.put(cloudCreateFolderRequest2.getRequestId(), CloudErrorExtKt.getAsCloudError(runtimeException));
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    }
                                };
                                j = j2;
                                gDriveCallback = this;
                                strStartAction = str;
                                driveFileCreationRequest$default.queue(batchRequest, jsonBatchCallback);
                            } catch (Exception e) {
                                e = e;
                                gDriveCallback = this;
                                strStartAction = str;
                                gDriveCallback.errorCallback.handleAndThrowError(strStartAction, e);
                                throw new KotlinNothingValueException();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            gDriveCallback = this;
                        }
                    }
                    progressCallback2 = progressCallback;
                    longRef2 = longRef;
                    batchResult2 = batchResult;
                    batchRequestBatch2 = batchRequest;
                    size = j;
                    z2 = z;
                }
                BatchRequest batchRequest2 = batchRequestBatch2;
                long j3 = size;
                boolean z3 = z2;
                BatchResult batchResult3 = batchResult2;
                Ref.LongRef longRef3 = longRef2;
                if (batchRequest2.size() > 0) {
                    gDriveCallback.checkConnectivity();
                    batchRequest2.execute();
                    batchRequestBatch2 = gDriveCallback.getService().batch();
                } else {
                    batchRequestBatch2 = batchRequest2;
                }
                progressCallback2 = progressCallback;
                longRef2 = longRef3;
                batchResult2 = batchResult3;
                size = j3;
                z2 = z3;
            }
            BatchResult batchResult4 = batchResult2;
            CloudOperationLogger cloudOperationLogger3 = gDriveCallback.cloudOperationLogger;
            if (cloudOperationLogger3 != null) {
                cloudOperationLogger3.endActionBatch(strStartAction, "CREATE_FOLDERS", CollectionsKt.emptyList());
            }
            return batchResult4;
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Drive.Files.Create getDriveFileCreationRequest$default(GDriveCallback gDriveCallback, String str, String str2, String str3, String str4, String str5, Map map, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, Long l, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = "";
        }
        if ((i & 16) != 0) {
            str5 = "";
        }
        if ((i & 32) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i & 64) != 0) {
            cancelableCloudTaskProgressHandler = null;
        }
        if ((i & 128) != 0) {
            l = null;
        }
        return gDriveCallback.getDriveFileCreationRequest(str, str2, str3, str4, str5, map, cancelableCloudTaskProgressHandler, l);
    }

    private final Drive.Files.Create getDriveFileCreationRequest(final String actionId, String name, String mimeType, String parentId, String localPath, Map<String, String> properties, final CancelableCloudTaskProgressHandler progressCallback, final Long requestId) throws IOException {
        Drive.Files.Create create;
        File file = new File();
        file.setName(name);
        String str = parentId;
        if (StringsKt.isBlank(str)) {
            str = DRIVE_ROOT_PATH_ID;
        }
        file.setParents(CollectionsKt.listOf(str));
        file.setMimeType(mimeType);
        file.setAppProperties(properties);
        final FileContent fileContent = !StringsKt.isBlank(localPath) ? new FileContent(mimeType, new java.io.File(localPath)) : null;
        MediaHttpUploaderProgressListener mediaHttpUploaderProgressListener = new MediaHttpUploaderProgressListener() { // from class: com.myscript.nebo.dms.gdrive.GDriveCallback$$ExternalSyntheticLambda1
            @Override // com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener
            public final void progressChanged(MediaHttpUploader mediaHttpUploader) {
                GDriveCallback.getDriveFileCreationRequest$lambda$1(fileContent, requestId, this, progressCallback, actionId, mediaHttpUploader);
            }
        };
        if (fileContent != null) {
            create = getFiles().create(file, fileContent);
            MediaHttpUploader mediaHttpUploader = create.getMediaHttpUploader();
            if (mediaHttpUploader != null) {
                mediaHttpUploader.setProgressListener(mediaHttpUploaderProgressListener);
            }
        } else {
            create = getFiles().create(file);
            MediaHttpUploader mediaHttpUploader2 = create.getMediaHttpUploader();
            if (mediaHttpUploader2 != null) {
                mediaHttpUploader2.setProgressListener(mediaHttpUploaderProgressListener);
            }
        }
        create.setFields2(DRIVE_FILE_FIELDS);
        Intrinsics.checkNotNullExpressionValue(create, "apply(...)");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDriveFileCreationRequest$lambda$1(FileContent fileContent, Long l, GDriveCallback gDriveCallback, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, String str, MediaHttpUploader mediaHttpUploader) {
        mediaHttpUploader.setDirectUploadEnabled(false);
        mediaHttpUploader.setChunkSize(262144);
        if (fileContent != null) {
            long length = fileContent.getFile().length();
            if (l != null) {
                long jLongValue = l.longValue();
                if (gDriveCallback.isConnected && (cancelableCloudTaskProgressHandler == null || cancelableCloudTaskProgressHandler.progress(jLongValue, false, mediaHttpUploader.getNumBytesUploaded(), length))) {
                    return;
                }
                gDriveCallback.errorCallback.handleAndThrowError(str, new IOException("Canceled"));
                throw new KotlinNothingValueException();
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public void deleteFile(CloudFile file) {
        Intrinsics.checkNotNullParameter(file, "file");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            deleteInternal(strStartAction, file);
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "DELETE_FILE");
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public void deleteFolder(CloudFile folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            deleteInternal(strStartAction, folder);
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "DELETE_FOLDER");
            }
        }
    }

    private final void deleteInternal(String actionId, CloudFile file) {
        String id = file.getId();
        Intrinsics.checkNotNull(id);
        if (StringsKt.isBlank(id)) {
            return;
        }
        try {
            checkConnectivity();
            getFiles().delete(id).execute();
        } catch (Exception e) {
            e = e;
            if ((e instanceof GoogleJsonResponseException) && ((GoogleJsonResponseException) e).getStatusCode() == 404) {
                e = new NoSuchElementException("File " + file.getId() + " not found");
            }
            this.errorCallback.handleAndThrowError(actionId, e);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void downloadFileInternal(final String actionId, final CloudFileRequest fileRequest, final CancelableCloudTaskProgressHandler progressCallback) {
        if (!this.isConnected || !progressCallback.progress(fileRequest.getRequestId(), true, 0L, 0L)) {
            this.errorCallback.handleAndThrowError(actionId, new IOException("Canceled"));
            throw new KotlinNothingValueException();
        }
        final Ref.LongRef longRef = new Ref.LongRef();
        try {
            ProgressOutputStream progressOutputStream = new ProgressOutputStream(0L, new FileOutputStream(fileRequest.getOutputPath()), new ProgressOutputStream.ProgressListener() { // from class: com.myscript.nebo.dms.gdrive.GDriveCallback$$ExternalSyntheticLambda2
                @Override // com.myscript.nebo.dms.cloud.common.utils.ProgressOutputStream.ProgressListener
                public final void progress(long j, long j2) {
                    GDriveCallback.downloadFileInternal$lambda$0(longRef, this, progressCallback, fileRequest, actionId, j, j2);
                }
            });
            try {
                getService().revisions().get(fileRequest.getFile().getId(), fileRequest.getRevision()).executeMediaAndDownloadTo(progressOutputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(progressOutputStream, null);
                progressCallback.progress(fileRequest.getRequestId(), false, longRef.element, longRef.element);
            } finally {
            }
        } catch (Exception e) {
            NoSuchElementException noSuchElementException = e;
            if ((noSuchElementException instanceof HttpResponseException) && ((HttpResponseException) noSuchElementException).getStatusCode() == 404) {
                noSuchElementException = new NoSuchElementException("File " + fileRequest.getFile().getId() + " not found");
            }
            this.errorCallback.handleAndThrowError(actionId, noSuchElementException);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void downloadFileInternal$lambda$0(Ref.LongRef longRef, GDriveCallback gDriveCallback, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, CloudFileRequest cloudFileRequest, String str, long j, long j2) {
        longRef.element = j;
        if (gDriveCallback.isConnected && cancelableCloudTaskProgressHandler.progress(cloudFileRequest.getRequestId(), false, j, j2)) {
            return;
        }
        gDriveCallback.errorCallback.handleAndThrowError(str, new IOException("Canceled"));
        throw new KotlinNothingValueException();
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public void downloadFile(CloudFileRequest fileRequest, CancelableCloudTaskProgressHandler progressCallback) {
        Intrinsics.checkNotNullParameter(fileRequest, "fileRequest");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            downloadFileInternal(strStartAction, fileRequest, progressCallback);
        } finally {
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 != null) {
                cloudOperationLogger2.endAction(strStartAction, "DOWNLOAD_FILE", fileRequest.getOutputPath());
            }
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public BatchResult downloadFiles(SWIGVectorCloudFileRequest fileRequests, CancelableCloudTaskProgressHandler progressCallback, CloudDownloadFileTaskHandler doneCallback) throws InterruptedException {
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        Intrinsics.checkNotNullParameter(doneCallback, "doneCallback");
        if (fileRequests == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        ArrayList arrayList = new ArrayList();
        BatchResult batchResult = new BatchResult();
        BuildersKt__BuildersKt.runBlocking$default(null, new C62761(fileRequests, this, strStartAction, progressCallback, doneCallback, batchResult, arrayList, null), 1, null);
        CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
        if (cloudOperationLogger2 != null) {
            cloudOperationLogger2.endActionBatch(strStartAction, "DOWNLOAD_FILES", arrayList);
        }
        return batchResult;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.gdrive.GDriveCallback$downloadFiles$1 */
    /* JADX INFO: compiled from: GDriveCallback.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.gdrive.GDriveCallback$downloadFiles$1", m1609f = "GDriveCallback.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $actionId;
        final /* synthetic */ CloudDownloadFileTaskHandler $doneCallback;
        final /* synthetic */ SWIGVectorCloudFileRequest $fileRequests;
        final /* synthetic */ List<String> $files;
        final /* synthetic */ CancelableCloudTaskProgressHandler $progressCallback;
        final /* synthetic */ BatchResult $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GDriveCallback this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62761(SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest, GDriveCallback gDriveCallback, String str, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, CloudDownloadFileTaskHandler cloudDownloadFileTaskHandler, BatchResult batchResult, List<String> list, Continuation<? super C62761> continuation) {
            super(2, continuation);
            this.$fileRequests = sWIGVectorCloudFileRequest;
            this.this$0 = gDriveCallback;
            this.$actionId = str;
            this.$progressCallback = cancelableCloudTaskProgressHandler;
            this.$doneCallback = cloudDownloadFileTaskHandler;
            this.$result = batchResult;
            this.$files = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C62761 c62761 = new C62761(this.$fileRequests, this.this$0, this.$actionId, this.$progressCallback, this.$doneCallback, this.$result, this.$files, continuation);
            c62761.L$0 = obj;
            return c62761;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SWIGVectorCloudFileRequest sWIGVectorCloudFileRequest = this.$fileRequests;
            GDriveCallback gDriveCallback = this.this$0;
            String str = this.$actionId;
            CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler = this.$progressCallback;
            CloudDownloadFileTaskHandler cloudDownloadFileTaskHandler = this.$doneCallback;
            BatchResult batchResult = this.$result;
            List<String> list = this.$files;
            for (CloudFileRequest cloudFileRequest : sWIGVectorCloudFileRequest) {
                ExecutorCoroutineDispatcher executorCoroutineDispatcher = gDriveCallback.downloadDispatcher;
                GDriveCallback$downloadFiles$1$1$1 gDriveCallback$downloadFiles$1$1$1 = new GDriveCallback$downloadFiles$1$1$1(gDriveCallback, str, cloudFileRequest, cancelableCloudTaskProgressHandler, cloudDownloadFileTaskHandler, batchResult, list, null);
                BatchResult batchResult2 = batchResult;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, executorCoroutineDispatcher, null, gDriveCallback$downloadFiles$1$1$1, 2, null);
                gDriveCallback = gDriveCallback;
                str = str;
                cancelableCloudTaskProgressHandler = cancelableCloudTaskProgressHandler;
                cloudDownloadFileTaskHandler = cloudDownloadFileTaskHandler;
                batchResult = batchResult2;
                list = list;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8 A[Catch: all -> 0x011e, TryCatch #2 {all -> 0x011e, blocks: (B:11:0x0063, B:12:0x0069, B:13:0x0076, B:20:0x0087, B:22:0x008d, B:24:0x0091, B:26:0x009c, B:28:0x00a5, B:30:0x00ab, B:32:0x00b2, B:37:0x00bf, B:39:0x00c3, B:41:0x00ce, B:42:0x00e8, B:43:0x00f2, B:34:0x00b8, B:36:0x00bc, B:44:0x00f3, B:45:0x011d), top: B:58:0x0030, inners: #1 }] */
    @Override // com.myscript.snt.dms.ICloudDriveInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String uploadFile(CloudUploadFileRequest uploadRequest, final CancelableCloudTaskProgressHandler progressCallback) throws Throwable {
        final GDriveCallback gDriveCallback;
        final CloudUploadFileRequest cloudUploadFileRequest;
        String id;
        java.io.File file;
        Intrinsics.checkNotNullParameter(uploadRequest, "uploadRequest");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        final String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            id = uploadRequest.getFile().getId();
            file = new java.io.File(uploadRequest.getLocalPath());
        } catch (Throwable th) {
            th = th;
            gDriveCallback = this;
            cloudUploadFileRequest = uploadRequest;
        }
        try {
            if (!file.exists()) {
                this.errorCallback.handleAndThrowError(strStartAction, new NoSuchElementException("The file " + file.getAbsolutePath() + " does not exist locally"));
                throw new KotlinNothingValueException();
            }
            File file2 = new File();
            final FileContent fileContent = new FileContent(file2.getMimeType(), file);
            DriveRequest<File> fields2 = getFiles().update(id, file2, fileContent).setFields2(DRIVE_FILE_FIELDS);
            MediaHttpUploader mediaHttpUploader = fields2.getMediaHttpUploader();
            mediaHttpUploader.setDirectUploadEnabled(false);
            mediaHttpUploader.setChunkSize(262144);
            gDriveCallback = this;
            cloudUploadFileRequest = uploadRequest;
            mediaHttpUploader.setProgressListener(new MediaHttpUploaderProgressListener() { // from class: com.myscript.nebo.dms.gdrive.GDriveCallback$$ExternalSyntheticLambda0
                @Override // com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener
                public final void progressChanged(MediaHttpUploader mediaHttpUploader2) {
                    GDriveCallback.uploadFile$lambda$0$0(this.f$0, progressCallback, cloudUploadFileRequest, fileContent, strStartAction, mediaHttpUploader2);
                }
            });
            try {
                checkConnectivity();
                String headRevisionId = fields2.execute().getHeadRevisionId();
                Intrinsics.checkNotNull(headRevisionId);
                CloudOperationLogger cloudOperationLogger2 = gDriveCallback.cloudOperationLogger;
                if (cloudOperationLogger2 != null) {
                    cloudOperationLogger2.endAction(strStartAction, "UPLOAD_FILE", cloudUploadFileRequest.getLocalPath());
                }
                return headRevisionId;
            } catch (Exception e) {
                NoSuchElementException noSuchElementException = e;
                if (GDriveCallbackKt.isStorageQuotaExceeded(noSuchElementException)) {
                    Function0<Unit> function0 = gDriveCallback.onInsufficientStorage;
                    if (function0 != null) {
                        function0.invoke();
                    }
                } else if ((noSuchElementException instanceof GoogleJsonResponseException) && ((GoogleJsonResponseException) noSuchElementException).getStatusCode() == 403 && ((GoogleJsonResponseException) noSuchElementException).getDetails() == null) {
                    if (isGDriveStorageFull(file.exists() ? file.length() : 0L)) {
                    }
                }
                if ((noSuchElementException instanceof GoogleJsonResponseException) && ((GoogleJsonResponseException) noSuchElementException).getStatusCode() == 404) {
                    noSuchElementException = new NoSuchElementException("File " + id + " does not exist remotely");
                }
                gDriveCallback.errorCallback.handleAndThrowError(strStartAction, noSuchElementException);
                throw new KotlinNothingValueException();
            }
        } catch (Throwable th2) {
            th = th2;
            Throwable th3 = th;
            CloudOperationLogger cloudOperationLogger3 = gDriveCallback.cloudOperationLogger;
            if (cloudOperationLogger3 == null) {
                throw th3;
            }
            cloudOperationLogger3.endAction(strStartAction, "UPLOAD_FILE", cloudUploadFileRequest.getLocalPath());
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uploadFile$lambda$0$0(GDriveCallback gDriveCallback, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, CloudUploadFileRequest cloudUploadFileRequest, FileContent fileContent, String str, MediaHttpUploader mediaHttpUploader) {
        if (gDriveCallback.isConnected && cancelableCloudTaskProgressHandler.progress(cloudUploadFileRequest.getRequestId(), false, mediaHttpUploader.getNumBytesUploaded(), fileContent.getFile().length())) {
            return;
        }
        gDriveCallback.errorCallback.handleAndThrowError(str, new IOException("Canceled"));
        throw new KotlinNothingValueException();
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public BatchResult uploadFiles(SWIGVectorCloudUploadFileRequest entries, CancelableCloudTaskProgressHandler progressCallback) throws InterruptedException {
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(progressCallback, "progressCallback");
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        BatchResult batchResult = new BatchResult();
        ArrayList arrayList = new ArrayList();
        BuildersKt__BuildersKt.runBlocking$default(null, new C62771(entries, this, progressCallback, batchResult, arrayList, strStartAction, null), 1, null);
        CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
        if (cloudOperationLogger2 != null) {
            cloudOperationLogger2.endActionBatch(strStartAction, "UPLOAD_FILES", arrayList);
        }
        return batchResult;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.dms.gdrive.GDriveCallback$uploadFiles$1 */
    /* JADX INFO: compiled from: GDriveCallback.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.dms.gdrive.GDriveCallback$uploadFiles$1", m1609f = "GDriveCallback.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C62771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $actionId;
        final /* synthetic */ SWIGVectorCloudUploadFileRequest $entries;
        final /* synthetic */ List<String> $files;
        final /* synthetic */ CancelableCloudTaskProgressHandler $progressCallback;
        final /* synthetic */ BatchResult $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GDriveCallback this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C62771(SWIGVectorCloudUploadFileRequest sWIGVectorCloudUploadFileRequest, GDriveCallback gDriveCallback, CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler, BatchResult batchResult, List<String> list, String str, Continuation<? super C62771> continuation) {
            super(2, continuation);
            this.$entries = sWIGVectorCloudUploadFileRequest;
            this.this$0 = gDriveCallback;
            this.$progressCallback = cancelableCloudTaskProgressHandler;
            this.$result = batchResult;
            this.$files = list;
            this.$actionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C62771 c62771 = new C62771(this.$entries, this.this$0, this.$progressCallback, this.$result, this.$files, this.$actionId, continuation);
            c62771.L$0 = obj;
            return c62771;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C62771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SWIGVectorCloudUploadFileRequest sWIGVectorCloudUploadFileRequest = this.$entries;
            GDriveCallback gDriveCallback = this.this$0;
            CancelableCloudTaskProgressHandler cancelableCloudTaskProgressHandler = this.$progressCallback;
            BatchResult batchResult = this.$result;
            List<String> list = this.$files;
            String str = this.$actionId;
            for (CloudUploadFileRequest cloudUploadFileRequest : sWIGVectorCloudUploadFileRequest) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, gDriveCallback.uploadDispatcher, null, new GDriveCallback$uploadFiles$1$1$1(gDriveCallback, cloudUploadFileRequest, cancelableCloudTaskProgressHandler, batchResult, list, str, null), 2, null);
                gDriveCallback = gDriveCallback;
                cancelableCloudTaskProgressHandler = cancelableCloudTaskProgressHandler;
                batchResult = batchResult;
                list = list;
                str = str;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public boolean exists(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        if (Intrinsics.areEqual(filePath, "")) {
            return true;
        }
        if (Intrinsics.areEqual(filePath, GDRIVE_V2_ROOT_NAME)) {
            return isV2Initialized();
        }
        CloudOperationLogger cloudOperationLogger = this.cloudOperationLogger;
        String strStartAction = cloudOperationLogger != null ? cloudOperationLogger.startAction() : null;
        try {
            getIdInternal(strStartAction, filePath);
            CloudOperationLogger cloudOperationLogger2 = this.cloudOperationLogger;
            if (cloudOperationLogger2 == null) {
                return true;
            }
            cloudOperationLogger2.endAction(strStartAction, ResourceStates.EXISTS);
            return true;
        } catch (Exception unused) {
            CloudOperationLogger cloudOperationLogger3 = this.cloudOperationLogger;
            if (cloudOperationLogger3 != null) {
                cloudOperationLogger3.endAction(strStartAction, ResourceStates.EXISTS);
            }
            return false;
        } catch (Throwable th) {
            CloudOperationLogger cloudOperationLogger4 = this.cloudOperationLogger;
            if (cloudOperationLogger4 != null) {
                cloudOperationLogger4.endAction(strStartAction, ResourceStates.EXISTS);
            }
            throw th;
        }
    }

    @Override // com.myscript.snt.dms.ICloudDriveInterface
    public String getProfileId() {
        return HashUtilsKt.getSha256("GDrive/TODO");
    }

    private final void cacheChanges(Collection<Change> changes) {
        String id;
        for (Change change : changes) {
            if (change.getRemoved().booleanValue()) {
                this.metadataCache.remove(change.getFileId());
            } else {
                File file = change.getFile();
                if (file != null && (id = file.getId()) != null) {
                    if (Intrinsics.areEqual((Object) change.getRemoved(), (Object) true)) {
                        this.metadataCache.remove(id);
                    } else {
                        this.metadataCache.put(id, change.getFile());
                    }
                }
            }
        }
    }

    private final void cacheFiles(Collection<File> files) {
        for (File file : files) {
            this.metadataCache.put(file.getId(), file);
        }
    }

    public final void reset() {
        this.metadataCache.clear();
        this.filePathToIdCache.clear();
        this.startPageToken = null;
    }

    static /* synthetic */ Exception checkAlreadyExistsFast$default(GDriveCallback gDriveCallback, String str, CloudFile cloudFile, String str2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return gDriveCallback.checkAlreadyExistsFast(str, cloudFile, str2, z);
    }

    private final Exception checkAlreadyExistsFast(String actionId, CloudFile parent, String name, boolean throwAutomatically) {
        Exception exc;
        List<String> parents;
        IllegalStateException illegalStateException;
        if (!this.metadataCache.containsKey(parent.getId())) {
            refreshCache(actionId, true);
        }
        try {
            if (!this.metadataCache.containsKey(parent.getId())) {
                illegalStateException = new NoSuchElementException("Parent " + parent.getPath() + " (" + parent.getId() + ") does not exist");
            } else {
                Collection<File> collectionValues = this.metadataCache.values();
                if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
                    for (File file : collectionValues) {
                        if (Intrinsics.areEqual(file.getName(), name) && (parents = file.getParents()) != null && parents.contains(parent.getId())) {
                            illegalStateException = new IllegalStateException(name + " already exists in folder " + parent.getPath() + " (" + parent.getId() + ")");
                            break;
                        }
                    }
                }
                illegalStateException = null;
            }
            exc = illegalStateException;
        } catch (Exception e) {
            exc = e;
        }
        if (!throwAutomatically || exc == null) {
            return exc;
        }
        this.errorCallback.handleAndThrowError(actionId, exc);
        throw new KotlinNothingValueException();
    }

    public final DMSLogLevel errorLevelForException(Exception exception) {
        String message;
        String message2;
        Intrinsics.checkNotNullParameter(exception, "exception");
        if ((exception instanceof IllegalStateException) && (message2 = exception.getMessage()) != null && StringsKt.contains$default((CharSequence) message2, (CharSequence) "Unsupported Cloud Version", false, 2, (Object) null)) {
            return DMSLogLevel.INFO;
        }
        if (exception instanceof NoSuchElementException) {
            return DMSLogLevel.WARNING;
        }
        if ((exception instanceof IOException) && (message = exception.getMessage()) != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "Canceled", false, 2, (Object) null)) {
            return DMSLogLevel.INFO;
        }
        if (SdkExtensions.getExtensionVersion(31) >= 7 && ((exception instanceof NetworkException) || (exception.getCause() instanceof NetworkException))) {
            return DMSLogLevel.WARNING;
        }
        return DMSLogLevel.ERR;
    }

    private final void checkConnectivity() throws IOException {
        if (!isCloudEnabled()) {
            throw new IOException("Canceled");
        }
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
        return StringsKt.contains$default((CharSequence) str, (CharSequence) GDRIVE_TOKEN_ERROR, false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) GDRIVE_TOKEN_BAD_AUTHENTICATION, false, 2, (Object) null);
    }

    /* JADX INFO: compiled from: GDriveCallback.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m1599d2 = {"Lcom/myscript/nebo/dms/gdrive/GDriveCallback$Companion;", "", "<init>", "()V", "CURRENT_VERSION", "", "GDRIVE_V1_ROOT_NAME", "", "GDRIVE_V2_ROOT_NAME", "DRIVE_ROOT_PATH", "DRIVE_ROOT_PATH_ID", "DRIVE_FILE_FIELDS", "GDRIVE_MAX_REQUESTS_IN_BATCH", "", "LIST_PAGE_SIZE", "GDRIVE_LIMIT_EXCEEDED_REASONS", "", "getGDRIVE_LIMIT_EXCEEDED_REASONS", "()Ljava/util/List;", "GDRIVE_STORAGE_QUOTA_EXCEEDED_REASONS", "getGDRIVE_STORAGE_QUOTA_EXCEEDED_REASONS", "GDRIVE_TOKEN_ERROR", "GDRIVE_TOKEN_BAD_AUTHENTICATION", "dms-gdrive_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getGDRIVE_LIMIT_EXCEEDED_REASONS() {
            return GDriveCallback.GDRIVE_LIMIT_EXCEEDED_REASONS;
        }

        public final List<String> getGDRIVE_STORAGE_QUOTA_EXCEEDED_REASONS() {
            return GDriveCallback.GDRIVE_STORAGE_QUOTA_EXCEEDED_REASONS;
        }
    }

    private final void appendToQuery(StringBuilder sb, String str) {
        if (sb.length() > 0) {
            sb.append(" and ");
        }
        sb.append(str);
    }
}
