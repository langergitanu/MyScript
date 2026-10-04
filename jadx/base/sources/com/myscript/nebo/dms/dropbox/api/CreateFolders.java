package com.myscript.nebo.dms.dropbox.api;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.RetryException;
import com.dropbox.core.p013v2.DbxClientV2;
import com.dropbox.core.p013v2.files.CreateFolderBatchJobStatus;
import com.dropbox.core.p013v2.files.CreateFolderBatchLaunch;
import com.dropbox.core.p013v2.files.CreateFolderBatchResultEntry;
import com.dropbox.core.p013v2.files.FolderMetadata;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CreateFolders.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0002J\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J(\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/api/CreateFolders;", "", "<init>", "()V", "TAG", "", "FORCE_USING_ASYNC_TASK", "", "CREATE_FOLDERS_BY_SET_OF", "", "CREATE_FOLDERS_MAX_TRY", "WAIT_FOR_CREATE_FOLDERS_COMPLETE_INTERVAL", "", "lastError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "canceled", "createDropboxFolders", "Lcom/dropbox/core/v2/files/CreateFolderBatchLaunch;", NotificationCompat.CATEGORY_SERVICE, "Lcom/dropbox/core/v2/DbxClientV2;", "paths", "", "createFolders", "Lcom/myscript/nebo/dms/dropbox/api/CreateFolders$CreateFolderResult;", "commitSession", "session", "startIndex", "CreateFolderResult", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class CreateFolders {
    private static final int CREATE_FOLDERS_BY_SET_OF = 10;
    private static final int CREATE_FOLDERS_MAX_TRY = 5;
    private static final boolean FORCE_USING_ASYNC_TASK = false;
    public static final CreateFolders INSTANCE = new CreateFolders();
    private static final String TAG = "CreateFolders";
    private static final long WAIT_FOR_CREATE_FOLDERS_COMPLETE_INTERVAL = 50;
    private static boolean canceled;
    private static Exception lastError;

    private CreateFolders() {
    }

    /* JADX INFO: compiled from: CreateFolders.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, m1599d2 = {"Lcom/myscript/nebo/dms/dropbox/api/CreateFolders$CreateFolderResult;", "", FirebaseAnalytics.Param.INDEX, "", FirebaseAnalytics.Param.SUCCESS, "", TtmlNode.TAG_METADATA, "Lcom/dropbox/core/v2/files/FolderMetadata;", "lastError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(IZLcom/dropbox/core/v2/files/FolderMetadata;Ljava/lang/Exception;)V", "getIndex", "()I", "getSuccess", "()Z", "getMetadata", "()Lcom/dropbox/core/v2/files/FolderMetadata;", "getLastError", "()Ljava/lang/Exception;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "dms-dropbox_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class CreateFolderResult {
        private final int index;
        private final Exception lastError;
        private final FolderMetadata metadata;
        private final boolean success;

        public static /* synthetic */ CreateFolderResult copy$default(CreateFolderResult createFolderResult, int i, boolean z, FolderMetadata folderMetadata, Exception exc, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = createFolderResult.index;
            }
            if ((i2 & 2) != 0) {
                z = createFolderResult.success;
            }
            if ((i2 & 4) != 0) {
                folderMetadata = createFolderResult.metadata;
            }
            if ((i2 & 8) != 0) {
                exc = createFolderResult.lastError;
            }
            return createFolderResult.copy(i, z, folderMetadata, exc);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final FolderMetadata getMetadata() {
            return this.metadata;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Exception getLastError() {
            return this.lastError;
        }

        public final CreateFolderResult copy(int index, boolean success, FolderMetadata metadata, Exception lastError) {
            return new CreateFolderResult(index, success, metadata, lastError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CreateFolderResult)) {
                return false;
            }
            CreateFolderResult createFolderResult = (CreateFolderResult) other;
            return this.index == createFolderResult.index && this.success == createFolderResult.success && Intrinsics.areEqual(this.metadata, createFolderResult.metadata) && Intrinsics.areEqual(this.lastError, createFolderResult.lastError);
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.index) * 31) + Boolean.hashCode(this.success)) * 31;
            FolderMetadata folderMetadata = this.metadata;
            int iHashCode2 = (iHashCode + (folderMetadata == null ? 0 : folderMetadata.hashCode())) * 31;
            Exception exc = this.lastError;
            return iHashCode2 + (exc != null ? exc.hashCode() : 0);
        }

        public String toString() {
            return "CreateFolderResult(index=" + this.index + ", success=" + this.success + ", metadata=" + this.metadata + ", lastError=" + this.lastError + ")";
        }

        public CreateFolderResult(int i, boolean z, FolderMetadata folderMetadata, Exception exc) {
            this.index = i;
            this.success = z;
            this.metadata = folderMetadata;
            this.lastError = exc;
        }

        public final int getIndex() {
            return this.index;
        }

        public final Exception getLastError() {
            return this.lastError;
        }

        public final FolderMetadata getMetadata() {
            return this.metadata;
        }

        public final boolean getSuccess() {
            return this.success;
        }
    }

    private final CreateFolderBatchLaunch createDropboxFolders(DbxClientV2 service, List<String> paths) {
        try {
            if (canceled) {
                return null;
            }
            return service.files().createFolderBatchBuilder(paths).withForceAsync(false).start();
        } catch (Exception e) {
            lastError = e;
            return null;
        }
    }

    public final List<CreateFolderResult> createFolders(DbxClientV2 service, List<String> paths) {
        List<CreateFolderResult> listCommitSession;
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(paths, "paths");
        lastError = null;
        ArrayList arrayList = new ArrayList();
        List mutableList = CollectionsKt.toMutableList((Collection) paths);
        int size = (paths.size() / 10) + 1;
        int i = 0;
        for (int i2 = 1; !mutableList.isEmpty() && i2 < size * 5 && !canceled; i2++) {
            List<String> listSubList = mutableList.subList(0, RangesKt.coerceAtMost(10, mutableList.size()));
            int size2 = listSubList.size();
            CreateFolderBatchLaunch createFolderBatchLaunchCreateDropboxFolders = createDropboxFolders(service, listSubList);
            if (createFolderBatchLaunchCreateDropboxFolders != null && (listCommitSession = INSTANCE.commitSession(service, createFolderBatchLaunchCreateDropboxFolders, i)) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listCommitSession) {
                    if (((CreateFolderResult) obj).getSuccess()) {
                        arrayList2.add(obj);
                    }
                }
                if (arrayList2.size() == listSubList.size()) {
                    mutableList.removeAll(listSubList);
                    arrayList.addAll(listCommitSession);
                    i += size2;
                }
            }
        }
        canceled = false;
        return arrayList;
    }

    private final List<CreateFolderResult> commitSession(DbxClientV2 service, CreateFolderBatchLaunch session, int startIndex) throws Exception {
        CreateFolderBatchJobStatus createFolderBatchJobStatusCreateFolderBatchCheck;
        ArrayList arrayList = new ArrayList();
        if (session.isAsyncJobId()) {
            String asyncJobIdValue = session.getAsyncJobIdValue();
            while (true) {
                try {
                    createFolderBatchJobStatusCreateFolderBatchCheck = service.files().createFolderBatchCheck(asyncJobIdValue);
                    if (createFolderBatchJobStatusCreateFolderBatchCheck.isComplete()) {
                        break;
                    }
                    Thread.sleep(WAIT_FOR_CREATE_FOLDERS_COMPLETE_INTERVAL);
                } catch (RetryException e) {
                    Log.i(TAG, "Server is not responding, retry failed: " + e.getMessage());
                    throw e;
                } catch (Exception e2) {
                    Log.e(TAG, "Error creating folder to Dropbox: ", e2);
                    throw e2;
                }
            }
            List<CreateFolderBatchResultEntry> entries = createFolderBatchJobStatusCreateFolderBatchCheck.getCompleteValue().getEntries();
            if (entries != null) {
                int i = 0;
                for (Object obj : entries) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    CreateFolderBatchResultEntry createFolderBatchResultEntry = (CreateFolderBatchResultEntry) obj;
                    arrayList.add(new CreateFolderResult(i + startIndex, createFolderBatchResultEntry.isSuccess() || (createFolderBatchResultEntry.isFailure() && createFolderBatchResultEntry.getFailureValue().getPathValue().isConflict()), createFolderBatchResultEntry.isSuccess() ? createFolderBatchResultEntry.getSuccessValue().getMetadata() : null, lastError));
                    i = i2;
                }
            }
            return arrayList;
        }
        if (session.isComplete()) {
            List<CreateFolderBatchResultEntry> entries2 = session.getCompleteValue().getEntries();
            if (entries2 != null) {
                int i3 = 0;
                for (Object obj2 : entries2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    CreateFolderBatchResultEntry createFolderBatchResultEntry2 = (CreateFolderBatchResultEntry) obj2;
                    arrayList.add(new CreateFolderResult(i3 + startIndex, createFolderBatchResultEntry2.isSuccess() || (createFolderBatchResultEntry2.isFailure() && createFolderBatchResultEntry2.getFailureValue().getPathValue().isConflict()), createFolderBatchResultEntry2.isSuccess() ? createFolderBatchResultEntry2.getSuccessValue().getMetadata() : null, lastError));
                    i3 = i4;
                }
            }
            return arrayList;
        }
        Log.e(TAG, "Error creating folder to Dropbox");
        throw new IllegalStateException();
    }
}
