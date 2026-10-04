package com.myscript.nebo.migration;

import android.app.Application;
import androidx.media3.common.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.backup.RestoreRunnable;
import com.myscript.nebo.dms.core.LibraryRepository;
import com.myscript.nebo.migration.MigrationRestorer;
import com.myscript.snt.core.NotebookKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RestoreRunnableMigrationRestorer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m1599d2 = {"Lcom/myscript/nebo/migration/RestoreRunnableMigrationRestorer;", "Lcom/myscript/nebo/migration/MigrationRestorer;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "libraryRepository", "Lcom/myscript/nebo/dms/core/LibraryRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroid/app/Application;Lcom/myscript/nebo/dms/core/LibraryRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "stopThumbnailer", "", "restartThumbnailer", "restore", "stream", "Ljava/io/FileInputStream;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/migration/MigrationRestorer$Listener;", "(Ljava/io/FileInputStream;Lcom/myscript/nebo/migration/MigrationRestorer$Listener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Adapter", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RestoreRunnableMigrationRestorer implements MigrationRestorer {
    private static final String BACKUP_SUB_DIRECTORY = "lenovo_migration";
    private final Application application;
    private final CoroutineDispatcher ioDispatcher;
    private final LibraryRepository libraryRepository;
    public static final int $stable = 8;

    public RestoreRunnableMigrationRestorer(Application application, LibraryRepository libraryRepository, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(libraryRepository, "libraryRepository");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.application = application;
        this.libraryRepository = libraryRepository;
        this.ioDispatcher = ioDispatcher;
    }

    public /* synthetic */ RestoreRunnableMigrationRestorer(Application application, LibraryRepository libraryRepository, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, libraryRepository, (i & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // com.myscript.nebo.migration.MigrationRestorer
    public void stopThumbnailer() {
        this.libraryRepository.stopThumbnailer();
    }

    @Override // com.myscript.nebo.migration.MigrationRestorer
    public void restartThumbnailer() {
        this.libraryRepository.restartThumbnailer();
    }

    @Override // com.myscript.nebo.migration.MigrationRestorer
    public Object restore(FileInputStream fileInputStream, MigrationRestorer.Listener listener, Continuation<? super Unit> continuation) {
        RestoreRunnable restoreRunnable = new RestoreRunnable(this.application, this.libraryRepository.getBackupController(), fileInputStream, this.libraryRepository.getRootDir(), BACKUP_SUB_DIRECTORY);
        restoreRunnable.addProgressionListener(new Adapter(this, listener));
        Object objWithContext = BuildersKt.withContext(this.ioDispatcher, new C66322(restoreRunnable, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.myscript.nebo.migration.RestoreRunnableMigrationRestorer$restore$2 */
    /* JADX INFO: compiled from: RestoreRunnableMigrationRestorer.kt */
    @Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m1599d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    @DebugMetadata(m1608c = "com.myscript.nebo.migration.RestoreRunnableMigrationRestorer$restore$2", m1609f = "RestoreRunnableMigrationRestorer.kt", m1610i = {}, m1611l = {}, m1612m = "invokeSuspend", m1613n = {}, m1614nl = {}, m1615s = {}, m1616v = 2)
    static final class C66322 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RestoreRunnable $runnable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C66322(RestoreRunnable restoreRunnable, Continuation<? super C66322> continuation) {
            super(2, continuation);
            this.$runnable = restoreRunnable;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C66322(this.$runnable, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C66322) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$runnable.run();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: RestoreRunnableMigrationRestorer.kt */
    @Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\u001a\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m1599d2 = {"Lcom/myscript/nebo/migration/RestoreRunnableMigrationRestorer$Adapter;", "Lcom/myscript/nebo/backup/RestoreRunnable$IRestoreProgression;", "out", "Lcom/myscript/nebo/migration/MigrationRestorer$Listener;", "<init>", "(Lcom/myscript/nebo/migration/RestoreRunnableMigrationRestorer;Lcom/myscript/nebo/migration/MigrationRestorer$Listener;)V", "copyArchiveProgress", "", "percent", "", "copyArchiveFinished", "backupFile", "Ljava/io/File;", "copyArchiveCanceled", "copyArchiveError", "verifyError", "restoreProgress", "current", "total", "restoreFinished", "lastOpenedNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "restoreCanceled", "restoreFreeSpaceError", "requiredSize", "", "restoreError", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    private final class Adapter implements RestoreRunnable.IRestoreProgression {
        private final MigrationRestorer.Listener out;
        final /* synthetic */ RestoreRunnableMigrationRestorer this$0;

        public Adapter(RestoreRunnableMigrationRestorer restoreRunnableMigrationRestorer, MigrationRestorer.Listener out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.this$0 = restoreRunnableMigrationRestorer;
            this.out = out;
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void copyArchiveProgress(int percent) {
            this.out.onCopyProgress(percent);
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void copyArchiveFinished(File backupFile) {
            Intrinsics.checkNotNullParameter(backupFile, "backupFile");
            this.out.onCopyFinished();
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void copyArchiveCanceled() {
            this.out.onCopyCanceled();
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void copyArchiveError() {
            this.out.onCopyError();
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void verifyError() {
            this.out.onVerifyError();
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void restoreProgress(int current, int total) {
            this.out.onRestoreProgress(current, total);
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void restoreFinished(File backupFile, NotebookKey lastOpenedNotebookKey) {
            Intrinsics.checkNotNullParameter(backupFile, "backupFile");
            this.this$0.libraryRepository.setLastOpenedFolderKey(lastOpenedNotebookKey);
            this.out.onRestoreFinished();
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void restoreCanceled() {
            this.out.onRestoreCanceled();
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void restoreFreeSpaceError(long requiredSize) {
            this.out.onRestoreInsufficientSpace(requiredSize);
        }

        @Override // com.myscript.nebo.backup.RestoreRunnable.IRestoreProgression
        public void restoreError() {
            this.out.onRestoreError();
        }
    }
}
