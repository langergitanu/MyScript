package com.myscript.nebo.backup;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.media3.common.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.android.utils.ViewModelProviderExtKt;
import com.myscript.nebo.NeboApplication;
import com.myscript.nebo.backup.BackupRunnable;
import com.myscript.nebo.backup.BackupState;
import com.myscript.nebo.backup.RestoreRunnable;
import com.myscript.nebo.backup.RestoreState;
import com.myscript.nebo.common.MainThreadBus;
import com.myscript.nebo.common.network.NeboNetworkState;
import com.myscript.nebo.dms.core.IAutoSyncTimerManager;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.core.PageKey;
import com.myscript.snt.dms.DMSSyncState;
import com.myscript.snt.dms.NeboBackupController;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BackupRestoreViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004YZ[\\B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u00101\u001a\u00020\u0012H\u0014J\u000e\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u00020\u0012J\u0006\u00109\u001a\u00020\u0012J\u0006\u0010:\u001a\u00020\u0012J\u0018\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H\u0016J\u0018\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010A\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\u00122\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020\u0012H\u0016J\u0018\u0010G\u001a\u00020\u00122\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)H\u0016J\u001a\u0010H\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010I\u001a\u00020\u0012H\u0016J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010C\u001a\u00020DH\u0016J\b\u0010K\u001a\u00020\u0012H\u0016J\u0010\u0010L\u001a\u00020\u00122\u0006\u0010M\u001a\u00020)H\u0016J\u0010\u0010N\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010O\u001a\u00020\u0012H\u0016J\b\u0010P\u001a\u00020\u0012H\u0016J\b\u0010Q\u001a\u00020\u0012H\u0002J\u0006\u0010R\u001a\u000204J\u0006\u0010S\u001a\u000204J\u0006\u0010T\u001a\u000204J\u0006\u0010U\u001a\u00020VJ\u0006\u0010W\u001a\u00020\u0012J\u0006\u0010X\u001a\u00020\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001b8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010-\u001a\u00020.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006]"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRestoreViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lcom/myscript/nebo/backup/BackupRunnable$IBackupProgression;", "Lcom/myscript/nebo/backup/RestoreRunnable$IRestoreProgression;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "autoSyncTimerManager", "Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/dms/core/LibraryRepository;Lcom/myscript/nebo/dms/core/IAutoSyncTimerManager;Lkotlinx/coroutines/CoroutineDispatcher;)V", "backupRestoreListeners", "", "Lcom/myscript/nebo/backup/BackupRestoreViewModel$BackupRestoreListener;", "addBackupRestoreListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeBackupRestoreListener", "notifyPauseAutoSync", "notifyResumeAutoSync", "_backupState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myscript/nebo/backup/BackupState;", "backupState", "Landroidx/lifecycle/LiveData;", "getBackupState", "()Landroidx/lifecycle/LiveData;", "_restoreState", "Lcom/myscript/nebo/backup/RestoreState;", "restoreState", "getRestoreState", "mBackupRunnable", "Lcom/myscript/nebo/backup/BackupRunnable;", "mRestoreRunnable", "Lcom/myscript/nebo/backup/RestoreRunnable;", "lastOpenedNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "value", "", "conflictedPageCount", "getConflictedPageCount", "()I", "onSyncUpdate", "Lcom/myscript/nebo/dms/core/LibraryRepository$SyncListener;", "getOnSyncUpdate", "()Lcom/myscript/nebo/dms/core/LibraryRepository$SyncListener;", "onCleared", "backupNotebooks", "useLegacyFormat", "", "prepareRestoreNotebooks", "stream", "Ljava/io/FileInputStream;", "startRestoreArchive", "cancelBackupNotebooks", "cancelRestoreNotebooks", "backupProgress", "current", "total", "backupFinished", "backupFile", "Ljava/io/File;", "backupCanceled", "backupFreeSpaceError", "requiredSize", "", "backupError", "verifyError", "restoreProgress", "restoreFinished", "restoreCanceled", "restoreFreeSpaceError", "restoreError", "copyArchiveProgress", "percent", "copyArchiveFinished", "copyArchiveCanceled", "copyArchiveError", "restartDMS", "needCloudSync", "cancelCloudSyncIfNeeded", "isCloudSyncOngoing", "getCloudSyncState", "Lcom/myscript/snt/dms/DMSSyncState;", "triggerCloudSync", "cancelCloudSync", "BackupRestoreListener", "PauseAutoSyncEvent", "ResumeAutoSyncEvent", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BackupRestoreViewModel extends AndroidViewModel implements BackupRunnable.IBackupProgression, RestoreRunnable.IRestoreProgression {
    private static final String BACKUP_SUB_DIRECTORY = "backup";
    private static final boolean DBG = false;
    private static final ViewModelProvider.Factory Factory;
    private static final String TAG = "BackupRestoreViewModel";
    private final MutableLiveData<BackupState> _backupState;
    private final MutableLiveData<RestoreState> _restoreState;
    private final IAutoSyncTimerManager autoSyncTimerManager;
    private final List<BackupRestoreListener> backupRestoreListeners;
    private int conflictedPageCount;
    private final CoroutineDispatcher ioDispatcher;
    private NotebookKey lastOpenedNotebookKey;
    private final LibraryRepository libraryRepository;
    private BackupRunnable mBackupRunnable;
    private RestoreRunnable mRestoreRunnable;
    private final LibraryRepository.SyncListener onSyncUpdate;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRestoreViewModel$BackupRestoreListener;", "", "onPauseAutoSync", "", "onResumeAutoSync", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface BackupRestoreListener {
        void onPauseAutoSync();

        void onResumeAutoSync();
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DMSSyncState.values().length];
            try {
                iArr[DMSSyncState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DMSSyncState.UP_TO_DATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DMSSyncState.CLOUD_DISABLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackupRestoreViewModel(Application application, LibraryRepository libraryRepository, IAutoSyncTimerManager autoSyncTimerManager, CoroutineDispatcher ioDispatcher) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(autoSyncTimerManager, "autoSyncTimerManager");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.libraryRepository = libraryRepository;
        this.autoSyncTimerManager = autoSyncTimerManager;
        this.ioDispatcher = ioDispatcher;
        this.backupRestoreListeners = new ArrayList();
        MutableLiveData<BackupState> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.postValue(BackupState.Idle.INSTANCE);
        this._backupState = mutableLiveData;
        MutableLiveData<RestoreState> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.postValue(RestoreState.Idle.INSTANCE);
        this._restoreState = mutableLiveData2;
        LibraryRepository.SyncListener syncListener = new LibraryRepository.SyncListener() { // from class: com.myscript.nebo.backup.BackupRestoreViewModel$onSyncUpdate$1
            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void autoSyncSettingChanged() {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void refreshProgress(int amountDone, int totalAmount) {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncPrepareProgress(int amountDone, int totalAmount) {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncProgress(int amountDone, int totalAmount) {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncProgress(NotebookKey folderSyncing, int amountDone, int totalAmount) {
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void syncStateChanged(DMSSyncState state, int impactedFolderCount, LibraryRepository.SyncFailureReason failureReason) {
                Intrinsics.checkNotNullParameter(state, "state");
                Intrinsics.checkNotNullParameter(failureReason, "failureReason");
            }

            @Override // com.myscript.nebo.dms.core.LibraryRepository.SyncListener
            public void conflictedPageCopies(List<? extends PageKey> duplicatedPageKeys, List<? extends PageKey> duplicatedPageKeys2s) {
                Intrinsics.checkNotNullParameter(duplicatedPageKeys, "duplicatedPageKeys");
                Intrinsics.checkNotNullParameter(duplicatedPageKeys2s, "duplicatedPageKeys2s");
                this.this$0.conflictedPageCount = duplicatedPageKeys.size();
            }
        };
        this.onSyncUpdate = syncListener;
        libraryRepository.addSyncListener(syncListener);
        MainThreadBus.eventBus.register(this);
    }

    public /* synthetic */ BackupRestoreViewModel(Application application, LibraryRepository libraryRepository, IAutoSyncTimerManager iAutoSyncTimerManager, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, libraryRepository, iAutoSyncTimerManager, (i & 8) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    public final void addBackupRestoreListener(BackupRestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.backupRestoreListeners.contains(listener)) {
            return;
        }
        this.backupRestoreListeners.add(listener);
    }

    public final void removeBackupRestoreListener(BackupRestoreListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.backupRestoreListeners.remove(listener);
    }

    private final void notifyPauseAutoSync() {
        Iterator<T> it = this.backupRestoreListeners.iterator();
        while (it.hasNext()) {
            ((BackupRestoreListener) it.next()).onPauseAutoSync();
        }
    }

    private final void notifyResumeAutoSync() {
        Iterator<T> it = this.backupRestoreListeners.iterator();
        while (it.hasNext()) {
            ((BackupRestoreListener) it.next()).onResumeAutoSync();
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Deprecated(message = "Use BackupRestoreListener instead")
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRestoreViewModel$PauseAutoSyncEvent;", "", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class PauseAutoSyncEvent {
        public static final int $stable = 0;
        private final String reason;

        /* JADX WARN: Multi-variable type inference failed */
        public PauseAutoSyncEvent() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ PauseAutoSyncEvent copy$default(PauseAutoSyncEvent pauseAutoSyncEvent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = pauseAutoSyncEvent.reason;
            }
            return pauseAutoSyncEvent.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final PauseAutoSyncEvent copy(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new PauseAutoSyncEvent(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PauseAutoSyncEvent) && Intrinsics.areEqual(this.reason, ((PauseAutoSyncEvent) other).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "PauseAutoSyncEvent(reason=" + this.reason + ")";
        }

        public PauseAutoSyncEvent(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public /* synthetic */ PauseAutoSyncEvent(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "backup/restore" : str);
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Deprecated(message = "Use BackupRestoreListener instead")
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRestoreViewModel$ResumeAutoSyncEvent;", "", "reason", "", "<init>", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final /* data */ class ResumeAutoSyncEvent {
        public static final int $stable = 0;
        private final String reason;

        /* JADX WARN: Multi-variable type inference failed */
        public ResumeAutoSyncEvent() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ResumeAutoSyncEvent copy$default(ResumeAutoSyncEvent resumeAutoSyncEvent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = resumeAutoSyncEvent.reason;
            }
            return resumeAutoSyncEvent.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final ResumeAutoSyncEvent copy(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new ResumeAutoSyncEvent(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ResumeAutoSyncEvent) && Intrinsics.areEqual(this.reason, ((ResumeAutoSyncEvent) other).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "ResumeAutoSyncEvent(reason=" + this.reason + ")";
        }

        public ResumeAutoSyncEvent(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public /* synthetic */ ResumeAutoSyncEvent(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "backup/restore" : str);
        }

        public final String getReason() {
            return this.reason;
        }
    }

    public final LiveData<BackupState> getBackupState() {
        return this._backupState;
    }

    public final LiveData<RestoreState> getRestoreState() {
        return this._restoreState;
    }

    public final int getConflictedPageCount() {
        return this.conflictedPageCount;
    }

    public final LibraryRepository.SyncListener getOnSyncUpdate() {
        return this.onSyncUpdate;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        this.libraryRepository.removeSyncListener(this.onSyncUpdate);
        MainThreadBus.eventBus.unregister(this);
        super.onCleared();
    }

    public final void backupNotebooks(boolean useLegacyFormat) {
        BackupRunnable backupRunnable = this.mBackupRunnable;
        if (backupRunnable != null) {
            if (backupRunnable.getStatus() != BackupTaskStatus.BackupTaskIdle) {
                backupRunnable.removeAllProgressionListener();
                backupRunnable.addProgressionListener(this);
                return;
            }
            return;
        }
        notifyPauseAutoSync();
        this.libraryRepository.stopThumbnailer();
        this._backupState.setValue(BackupState.Idle.INSTANCE);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C61522(useLegacyFormat, null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.backup.BackupRestoreViewModel$backupNotebooks$2 */
    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.backup.BackupRestoreViewModel$backupNotebooks$2", m1609f = "BackupRestoreViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61522 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $useLegacyFormat;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C61522(boolean z, Continuation<? super C61522> continuation) {
            super(2, continuation);
            this.$useLegacyFormat = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BackupRestoreViewModel.this.new C61522(this.$useLegacyFormat, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61522) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BackupRestoreViewModel backupRestoreViewModel = BackupRestoreViewModel.this;
            backupRestoreViewModel.lastOpenedNotebookKey = backupRestoreViewModel.libraryRepository.getLastOpenedFolderKey();
            File rootDir = BackupRestoreViewModel.this.libraryRepository.getRootDir();
            BackupRestoreViewModel backupRestoreViewModel2 = BackupRestoreViewModel.this;
            Application application = BackupRestoreViewModel.this.getApplication();
            NeboBackupController backupController = BackupRestoreViewModel.this.libraryRepository.getBackupController();
            NotebookKey notebookKey = BackupRestoreViewModel.this.lastOpenedNotebookKey;
            if (notebookKey == null) {
                notebookKey = new NotebookKey();
            }
            backupRestoreViewModel2.mBackupRunnable = new BackupRunnable(application, backupController, rootDir, BackupRestoreViewModel.BACKUP_SUB_DIRECTORY, notebookKey, this.$useLegacyFormat);
            BackupRunnable backupRunnable = BackupRestoreViewModel.this.mBackupRunnable;
            if (backupRunnable != null) {
                backupRunnable.addProgressionListener(BackupRestoreViewModel.this);
            }
            BackupRunnable backupRunnable2 = BackupRestoreViewModel.this.mBackupRunnable;
            if (backupRunnable2 != null) {
                backupRunnable2.run();
            }
            return Unit.INSTANCE;
        }
    }

    public final void prepareRestoreNotebooks(FileInputStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        RestoreRunnable restoreRunnable = this.mRestoreRunnable;
        if (restoreRunnable != null) {
            if (restoreRunnable.getStatus() != BackupTaskStatus.BackupTaskIdle) {
                restoreRunnable.removeAllProgressionListener();
                restoreRunnable.addProgressionListener(this);
                return;
            }
            return;
        }
        File rootDir = this.libraryRepository.getRootDir();
        this._restoreState.setValue(RestoreState.Idle.INSTANCE);
        RestoreRunnable restoreRunnable2 = new RestoreRunnable(getApplication(), this.libraryRepository.getBackupController(), stream, rootDir, BACKUP_SUB_DIRECTORY);
        this.mRestoreRunnable = restoreRunnable2;
        restoreRunnable2.addProgressionListener(this);
    }

    public final void startRestoreArchive() {
        notifyPauseAutoSync();
        this.libraryRepository.stopThumbnailer();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.ioDispatcher, null, new C61531(null), 2, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.backup.BackupRestoreViewModel$startRestoreArchive$1 */
    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.backup.BackupRestoreViewModel$startRestoreArchive$1", m1609f = "BackupRestoreViewModel.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C61531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61531(Continuation<? super C61531> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BackupRestoreViewModel.this.new C61531(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            RestoreRunnable restoreRunnable;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                if (Intrinsics.areEqual(BackupRestoreViewModel.this._restoreState.getValue(), RestoreState.Idle.INSTANCE) && (restoreRunnable = BackupRestoreViewModel.this.mRestoreRunnable) != null) {
                    restoreRunnable.run();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void cancelBackupNotebooks() {
        BackupRunnable backupRunnable = this.mBackupRunnable;
        if (backupRunnable != null) {
            backupRunnable.cancel();
        }
        this.mBackupRunnable = null;
    }

    public final void cancelRestoreNotebooks() {
        RestoreRunnable restoreRunnable = this.mRestoreRunnable;
        if (restoreRunnable != null) {
            restoreRunnable.cancel();
        }
        this.mRestoreRunnable = null;
    }

    @Override // com.myscript.nebo.backup.BackupRunnable.IBackupProgression
    public void backupProgress(int current, int total) {
        this._backupState.postValue(new BackupState.Progress(current, total));
    }

    @Override // com.myscript.nebo.backup.BackupRunnable.IBackupProgression
    public void backupFinished(File backupFile, NotebookKey lastOpenedNotebookKey) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        Intrinsics.checkNotNullParameter(lastOpenedNotebookKey, "lastOpenedNotebookKey");
        this._backupState.postValue(new BackupState.Done(backupFile));
        this.lastOpenedNotebookKey = lastOpenedNotebookKey;
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.BackupRunnable.IBackupProgression
    public void backupCanceled() {
        this._backupState.postValue(BackupState.Canceled.INSTANCE);
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.BackupRunnable.IBackupProgression
    public void backupFreeSpaceError(long requiredSize) {
        this._backupState.postValue(new BackupState.BackupError.NotEnoughSpace(requiredSize));
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.BackupRunnable.IBackupProgression
    public void backupError() {
        this._backupState.postValue(BackupState.BackupError.UnknownError.INSTANCE);
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void verifyError() {
        this._restoreState.postValue(RestoreState.RestoreArchiveError.VerifyError.INSTANCE);
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void restoreProgress(int current, int total) {
        this._restoreState.postValue(new RestoreState.RestoreArchiveProgress(current, total));
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void restoreFinished(File backupFile, NotebookKey lastOpenedNotebookKey) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        this._restoreState.postValue(new RestoreState.RestoreArchiveDone(backupFile, lastOpenedNotebookKey));
        this.lastOpenedNotebookKey = lastOpenedNotebookKey;
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void restoreCanceled() {
        this._restoreState.postValue(RestoreState.RestoreArchiveCanceled.INSTANCE);
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void restoreFreeSpaceError(long requiredSize) {
        this._restoreState.postValue(new RestoreState.RestoreArchiveError.NotEnoughSpace(requiredSize));
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void restoreError() {
        this._restoreState.postValue(RestoreState.RestoreArchiveError.UnknownError.INSTANCE);
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void copyArchiveProgress(int percent) {
        this._restoreState.postValue(new RestoreState.CopyArchiveProgress(percent));
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void copyArchiveFinished(File backupFile) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        this._restoreState.postValue(new RestoreState.CopyArchiveDone(backupFile));
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void copyArchiveCanceled() {
        this._restoreState.postValue(RestoreState.CopyArchiveCanceled.INSTANCE);
        restartDMS();
    }

    @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
    public void copyArchiveError() {
        this._restoreState.postValue(RestoreState.CopyArchiveError.INSTANCE);
        restartDMS();
    }

    private final void restartDMS() {
        BackupRunnable backupRunnable = this.mBackupRunnable;
        if (backupRunnable != null) {
            backupRunnable.removeAllProgressionListener();
        }
        this.mBackupRunnable = null;
        RestoreRunnable restoreRunnable = this.mRestoreRunnable;
        if (restoreRunnable != null) {
            restoreRunnable.removeAllProgressionListener();
        }
        this.mRestoreRunnable = null;
        this.libraryRepository.restartThumbnailer();
        this.libraryRepository.setLastOpenedFolderKey(this.lastOpenedNotebookKey);
        notifyResumeAutoSync();
    }

    public final boolean needCloudSync() {
        NeboApplication neboApplication = (NeboApplication) getApplication();
        Intrinsics.checkNotNull(neboApplication, "null cannot be cast to non-null type com.myscript.nebo.cloudsync.CloudManager.Provider");
        boolean zIsCloudConnected = neboApplication.provideCloudManager().isCloudConnected();
        NeboNetworkState value = neboApplication.provideNeboNetworkStateRepository().getNeboNetworkState().getValue();
        boolean zIsDataTransferAllowed = value != null ? value.isDataTransferAllowed() : false;
        if (zIsCloudConnected && zIsDataTransferAllowed) {
            int i = WhenMappings.$EnumSwitchMapping$0[this.libraryRepository.getDmsSyncState().ordinal()];
            if (i != 1 && i != 2 && i != 3) {
                return true;
            }
        }
        return false;
    }

    public final boolean cancelCloudSyncIfNeeded() {
        if (!isCloudSyncOngoing()) {
            return false;
        }
        cancelCloudSync();
        return true;
    }

    public final boolean isCloudSyncOngoing() {
        return this.libraryRepository.isCloudSyncOngoing();
    }

    public final DMSSyncState getCloudSyncState() {
        return this.libraryRepository.getDmsSyncState();
    }

    public final void triggerCloudSync() {
        this.conflictedPageCount = 0;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C61541(null), 3, null);
    }

    /* JADX INFO: renamed from: com.myscript.nebo.backup.BackupRestoreViewModel$triggerCloudSync$1 */
    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.backup.BackupRestoreViewModel$triggerCloudSync$1", m1609f = "BackupRestoreViewModel.kt", m1610i = {}, m1611l = {436}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {437}, m1615s = {}, m1616v = 2)
    static final class C61541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C61541(Continuation<? super C61541> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BackupRestoreViewModel.this.new C61541(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BackupRestoreViewModel.this.autoSyncTimerManager.triggerSyncNow(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void cancelCloudSync() {
        this.autoSyncTimerManager.cancelSync();
    }

    /* JADX INFO: compiled from: BackupRestoreViewModel.kt */
    @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRestoreViewModel$Companion;", "", "<init>", "()V", "DBG", "", "TAG", "", "BACKUP_SUB_DIRECTORY", "Factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewModelProvider.Factory getFactory() {
            return BackupRestoreViewModel.Factory;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final BackupRestoreViewModel Factory$lambda$0$0(CreationExtras initializer) {
        Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
        Application applicationRequireApplication = ViewModelProviderExtKt.requireApplication(initializer);
        Intrinsics.checkNotNull(applicationRequireApplication, "null cannot be cast to non-null type com.myscript.nebo.dms.core.LibraryRepository.Provider");
        return new BackupRestoreViewModel(applicationRequireApplication, ((LibraryRepository.Provider) applicationRequireApplication).provideLibraryRepository(), ((IAutoSyncTimerManager.Provider) applicationRequireApplication).provideAutoSyncTimerManager(), null, 8, null);
    }

    static {
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(BackupRestoreViewModel.class), new Function1() { // from class: com.myscript.nebo.backup.BackupRestoreViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BackupRestoreViewModel.Factory$lambda$0$0((CreationExtras) obj);
            }
        });
        Factory = initializerViewModelFactoryBuilder.build();
    }
}
