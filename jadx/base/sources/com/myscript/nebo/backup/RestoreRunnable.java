package com.myscript.nebo.backup;

import android.app.Application;
import android.os.StatFs;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.common.utils.FileUtils;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.dms.BackupMetadata;
import com.myscript.snt.dms.INeboBackupProgressionListener;
import com.myscript.snt.dms.NeboBackupController;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.CloseableKt;

/* JADX INFO: compiled from: RestoreRunnable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\b\u0007\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u000234B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020!H\u0016J\b\u0010(\u001a\u00020!H\u0016J \u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020%H\u0016J\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0019J\u000e\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0019J\u0006\u00101\u001a\u00020!J\u0006\u00102\u001a\u00020!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreRunnable;", "Ljava/lang/Runnable;", "Lcom/myscript/snt/dms/INeboBackupProgressionListener;", "Lcom/myscript/nebo/common/utils/FileUtils$IFileUtilsProgression;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "backup", "Lcom/myscript/snt/dms/NeboBackupController;", "stream", "Ljava/io/FileInputStream;", "restoreFolder", "Ljava/io/File;", "restoreFolderName", "", "<init>", "(Landroid/app/Application;Lcom/myscript/snt/dms/NeboBackupController;Ljava/io/FileInputStream;Ljava/io/File;Ljava/lang/String;)V", "getBackup", "()Lcom/myscript/snt/dms/NeboBackupController;", "value", "Lcom/myscript/nebo/backup/BackupTaskStatus;", NotificationCompat.CATEGORY_STATUS, "getStatus", "()Lcom/myscript/nebo/backup/BackupTaskStatus;", "listeners", "", "Lcom/myscript/nebo/backup/RestoreRunnable$IRestoreProgression;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "canceled", "", "dstFolder", "dstTempFolder", "run", "", "copyFileStarted", "copyFileProgress", "percent", "", "copyCanceled", "copyFileEnded", "copyError", "progression", "done", "", "current", "total", "addProgressionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeProgressionListener", "removeAllProgressionListener", "cancel", "IRestoreProgression", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RestoreRunnable implements Runnable, INeboBackupProgressionListener, FileUtils.IFileUtilsProgression {
    private static final String RESTORE_SUB_DIRECTORY = "restore";
    private static final String TAG = "RestoreRunnable";
    private final NeboBackupController backup;
    private boolean canceled;
    private final File dstFolder;
    private final File dstTempFolder;
    private final Set<IRestoreProgression> listeners;
    private final ReentrantLock lock;
    private final File restoreFolder;
    private BackupTaskStatus status;
    private final FileInputStream stream;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: RestoreRunnable.kt */
    @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&¨\u0006\u0017À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/backup/RestoreRunnable$IRestoreProgression;", "", "restoreFreeSpaceError", "", "requiredSize", "", "copyArchiveProgress", "percent", "", "copyArchiveFinished", "backupFile", "Ljava/io/File;", "copyArchiveCanceled", "copyArchiveError", "verifyError", "restoreProgress", "current", "total", "restoreFinished", "lastOpenedNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "restoreCanceled", "restoreError", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface IRestoreProgression {
        void copyArchiveCanceled();

        void copyArchiveError();

        void copyArchiveFinished(File backupFile);

        void copyArchiveProgress(int percent);

        void restoreCanceled();

        void restoreError();

        void restoreFinished(File backupFile, NotebookKey lastOpenedNotebookKey);

        void restoreFreeSpaceError(long requiredSize);

        void restoreProgress(int current, int total);

        void verifyError();
    }

    @Override // com.myscript.nebo.common.utils.FileUtils.IFileUtilsProgression
    public void copyFileEnded() {
    }

    public RestoreRunnable(Application application, NeboBackupController backup, FileInputStream stream, File restoreFolder, String restoreFolderName) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(backup, "backup");
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(restoreFolder, "restoreFolder");
        Intrinsics.checkNotNullParameter(restoreFolderName, "restoreFolderName");
        this.backup = backup;
        this.stream = stream;
        this.restoreFolder = restoreFolder;
        this.status = BackupTaskStatus.BackupTaskIdle;
        this.listeners = new LinkedHashSet();
        this.lock = new ReentrantLock();
        File file = new File(application.getCacheDir(), RESTORE_SUB_DIRECTORY);
        this.dstFolder = file;
        File file2 = new File(application.getCacheDir(), restoreFolderName);
        this.dstTempFolder = file2;
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        if (!file2.isDirectory()) {
            file2.mkdirs();
        }
        if (!restoreFolder.isDirectory()) {
            restoreFolder.mkdirs();
        }
        backup.setProgressionListener(this);
    }

    public final NeboBackupController getBackup() {
        return this.backup;
    }

    public final BackupTaskStatus getStatus() {
        return this.status;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        ReentrantLock reentrantLock;
        BackupMetadata backupMetadataMetadata;
        this.canceled = false;
        long size = this.stream.getChannel().size();
        try {
            if (size >= new StatFs(this.dstFolder.getAbsolutePath()).getAvailableBytes()) {
                reentrantLock = this.lock;
                reentrantLock.lock();
                try {
                    Iterator<T> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        ((IRestoreProgression) it.next()).restoreFreeSpaceError(size);
                    }
                    Unit unit = Unit.INSTANCE;
                    reentrantLock.unlock();
                    this.status = BackupTaskStatus.BackupTaskError;
                    return;
                } finally {
                }
            }
        } catch (IllegalArgumentException unused) {
            Log.e(TAG, "Check available space: file system access failed");
        }
        this.status = BackupTaskStatus.BackupTaskBusy;
        File file = new File(this.dstFolder, UUID.randomUUID() + ".nebobackup");
        FileInputStream fileInputStream = this.stream;
        FileInputStream fileInputStream2 = fileInputStream;
        try {
            if (FileUtils.streamToFile(this.dstFolder, file, fileInputStream, this) != null) {
                this.lock.lock();
                try {
                    Iterator<T> it2 = this.listeners.iterator();
                    while (it2.hasNext()) {
                        ((IRestoreProgression) it2.next()).copyArchiveFinished(file);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    try {
                        backupMetadataMetadata = this.backup.metadata(file.getAbsolutePath());
                    } catch (Exception e) {
                        Log.e(TAG, "Impossible to read metadata", e);
                    }
                    if (!backupMetadataMetadata.isValid()) {
                        this.status = BackupTaskStatus.BackupTaskError;
                        this.lock.lock();
                        try {
                            Iterator<T> it3 = this.listeners.iterator();
                            while (it3.hasNext()) {
                                ((IRestoreProgression) it3.next()).verifyError();
                            }
                            Unit unit3 = Unit.INSTANCE;
                            CloseableKt.closeFinally(fileInputStream2, null);
                            return;
                        } finally {
                        }
                    }
                    try {
                        long uncompressedSize = backupMetadataMetadata.getUncompressedSize() * ((long) 2);
                        if (uncompressedSize >= new StatFs(this.restoreFolder.getAbsolutePath()).getAvailableBytes()) {
                            reentrantLock = this.lock;
                            reentrantLock.lock();
                            try {
                                Iterator<T> it4 = this.listeners.iterator();
                                while (it4.hasNext()) {
                                    ((IRestoreProgression) it4.next()).restoreFreeSpaceError(size + uncompressedSize);
                                }
                                Unit unit4 = Unit.INSTANCE;
                                reentrantLock.unlock();
                                file.delete();
                                this.status = BackupTaskStatus.BackupTaskError;
                                CloseableKt.closeFinally(fileInputStream2, null);
                                return;
                            } finally {
                            }
                        }
                    } catch (IllegalArgumentException unused2) {
                        Log.e(TAG, "Check available space: file system access failed");
                    }
                    NotebookKey notebookKey = new NotebookKey();
                    NotebookKey notebookKeyDeserialize = notebookKey.isValid() ? NotebookKey.deserialize(notebookKey.serialize()) : null;
                    this.canceled = false;
                    this.status = BackupTaskStatus.BackupTaskBusy;
                    if (this.backup.restore(file.getAbsolutePath())) {
                        this.status = BackupTaskStatus.BackupTaskFinished;
                        reentrantLock = this.lock;
                        reentrantLock.lock();
                        try {
                            Iterator<T> it5 = this.listeners.iterator();
                            while (it5.hasNext()) {
                                ((IRestoreProgression) it5.next()).restoreFinished(file, notebookKeyDeserialize);
                            }
                            Unit unit5 = Unit.INSTANCE;
                            reentrantLock.unlock();
                        } finally {
                        }
                    } else {
                        reentrantLock = this.lock;
                        reentrantLock.lock();
                        try {
                            for (IRestoreProgression iRestoreProgression : this.listeners) {
                                if (this.canceled) {
                                    this.status = BackupTaskStatus.BackupTaskCanceled;
                                    iRestoreProgression.restoreCanceled();
                                } else {
                                    this.status = BackupTaskStatus.BackupTaskError;
                                    iRestoreProgression.restoreError();
                                }
                            }
                            Unit unit6 = Unit.INSTANCE;
                            reentrantLock.unlock();
                            Log.w(TAG, "Backup restoration didn't finished with success");
                        } finally {
                        }
                    }
                    Boolean.valueOf(file.delete());
                } finally {
                }
            } else {
                if (this.canceled) {
                    this.status = BackupTaskStatus.BackupTaskCanceled;
                    reentrantLock = this.lock;
                    reentrantLock.lock();
                    try {
                        Iterator<T> it6 = this.listeners.iterator();
                        while (it6.hasNext()) {
                            ((IRestoreProgression) it6.next()).copyArchiveCanceled();
                        }
                        Unit unit7 = Unit.INSTANCE;
                        reentrantLock.unlock();
                    } finally {
                    }
                } else {
                    this.status = BackupTaskStatus.BackupTaskError;
                    this.lock.lock();
                    try {
                        Iterator<T> it7 = this.listeners.iterator();
                        while (it7.hasNext()) {
                            ((IRestoreProgression) it7.next()).copyArchiveError();
                        }
                        Unit unit8 = Unit.INSTANCE;
                    } finally {
                    }
                }
                Integer.valueOf(Log.e(TAG, "Error during copy stream"));
            }
            CloseableKt.closeFinally(fileInputStream2, null);
        } finally {
        }
    }

    @Override // com.myscript.nebo.common.utils.FileUtils.IFileUtilsProgression
    public void copyFileStarted() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((IRestoreProgression) it.next()).copyArchiveProgress(0);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.myscript.nebo.common.utils.FileUtils.IFileUtilsProgression
    public boolean copyFileProgress(int percent) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((IRestoreProgression) it.next()).copyArchiveProgress(percent);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return this.canceled;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.myscript.nebo.common.utils.FileUtils.IFileUtilsProgression
    public void copyCanceled() {
        this.canceled = true;
    }

    @Override // com.myscript.nebo.common.utils.FileUtils.IFileUtilsProgression
    public void copyError() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((IRestoreProgression) it.next()).copyArchiveError();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.myscript.snt.dms.INeboBackupProgressionListener
    public boolean progression(float done, int current, int total) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((IRestoreProgression) it.next()).restoreProgress(current, total);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return !this.canceled;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void addProgressionListener(IRestoreProgression listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.listeners.add(listener);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void removeProgressionListener(IRestoreProgression listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.listeners.remove(listener);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void removeAllProgressionListener() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.listeners.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void cancel() {
        this.canceled = true;
    }
}
