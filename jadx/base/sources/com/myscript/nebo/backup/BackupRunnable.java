package com.myscript.nebo.backup;

import android.app.Application;
import android.os.Build;
import android.os.StatFs;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.MimeTypes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.myscript.nebo.BuildConfig;
import com.myscript.nebo.common.utils.PlatformUtils;
import com.myscript.snt.core.NotebookKey;
import com.myscript.snt.dms.INeboBackupProgressionListener;
import com.myscript.snt.dms.NeboBackupController;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p039io.FilesKt;

/* JADX INFO: compiled from: BackupRunnable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002+,B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0016J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0014J\u000e\u0010(\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0014J\u0006\u0010)\u001a\u00020\u001fJ\u0006\u0010*\u001a\u00020\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006-"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRunnable;", "Ljava/lang/Runnable;", "Lcom/myscript/snt/dms/INeboBackupProgressionListener;", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "backup", "Lcom/myscript/snt/dms/NeboBackupController;", "srcFolder", "Ljava/io/File;", "dstFolderName", "", "lastOpenedNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "useLegacyFormat", "", "<init>", "(Landroid/app/Application;Lcom/myscript/snt/dms/NeboBackupController;Ljava/io/File;Ljava/lang/String;Lcom/myscript/snt/core/NotebookKey;Z)V", "dstDir", "listeners", "", "Lcom/myscript/nebo/backup/BackupRunnable$IBackupProgression;", "canceled", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "version", "value", "Lcom/myscript/nebo/backup/BackupTaskStatus;", NotificationCompat.CATEGORY_STATUS, "getStatus", "()Lcom/myscript/nebo/backup/BackupTaskStatus;", "run", "", "progression", "done", "", "current", "", "total", "addProgressionListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeProgressionListener", "removeAllProgressionListener", "cancel", "IBackupProgression", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class BackupRunnable implements Runnable, INeboBackupProgressionListener {
    private static final String TAG = "BackupRunnable";
    private final NeboBackupController backup;
    private boolean canceled;
    private final File dstDir;
    private final NotebookKey lastOpenedNotebookKey;
    private final Set<IBackupProgression> listeners;
    private final ReentrantLock lock;
    private final File srcFolder;
    private BackupTaskStatus status;
    private final boolean useLegacyFormat;
    private final String version;
    public static final int $stable = 8;

    /* JADX INFO: compiled from: BackupRunnable.kt */
    @Metadata(m1598d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/backup/BackupRunnable$IBackupProgression;", "", "backupProgress", "", "current", "", "total", "backupFinished", "backupFile", "Ljava/io/File;", "lastOpenedNotebookKey", "Lcom/myscript/snt/core/NotebookKey;", "backupCanceled", "backupFreeSpaceError", "requiredSize", "", "backupError", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface IBackupProgression {
        void backupCanceled();

        void backupError();

        void backupFinished(File backupFile, NotebookKey lastOpenedNotebookKey);

        void backupFreeSpaceError(long requiredSize);

        void backupProgress(int current, int total);
    }

    public BackupRunnable(Application application, NeboBackupController backup, File srcFolder, String dstFolderName, NotebookKey lastOpenedNotebookKey, boolean z) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(backup, "backup");
        Intrinsics.checkNotNullParameter(srcFolder, "srcFolder");
        Intrinsics.checkNotNullParameter(dstFolderName, "dstFolderName");
        Intrinsics.checkNotNullParameter(lastOpenedNotebookKey, "lastOpenedNotebookKey");
        this.backup = backup;
        this.srcFolder = srcFolder;
        this.lastOpenedNotebookKey = lastOpenedNotebookKey;
        this.useLegacyFormat = z;
        File file = new File(application.getCacheDir(), dstFolderName);
        this.dstDir = file;
        this.listeners = new LinkedHashSet();
        this.lock = new ReentrantLock();
        this.status = BackupTaskStatus.BackupTaskIdle;
        if (file.exists()) {
            FilesKt.deleteRecursively(file);
        }
        file.mkdirs();
        if (!srcFolder.isDirectory()) {
            throw new IllegalArgumentException(("Backup source directory must exists " + srcFolder).toString());
        }
        backup.setProgressionListener(this);
        String version = PlatformUtils.getVersion(application, BuildConfig.BUILD_NUMBER);
        Intrinsics.checkNotNullExpressionValue(version, "getVersion(...)");
        this.version = version;
    }

    public final BackupTaskStatus getStatus() {
        return this.status;
    }

    @Override // java.lang.Runnable
    public void run() {
        ReentrantLock reentrantLock;
        try {
            long length = this.srcFolder.length();
            if (length >= new StatFs(this.dstDir.getAbsolutePath()).getAvailableBytes()) {
                reentrantLock = this.lock;
                reentrantLock.lock();
                try {
                    Iterator<T> it = this.listeners.iterator();
                    while (it.hasNext()) {
                        ((IBackupProgression) it.next()).backupFreeSpaceError(length);
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
        this.canceled = false;
        this.status = BackupTaskStatus.BackupTaskBusy;
        String strBackup = this.backup.backup(this.dstDir.getAbsolutePath(), this.version, "Android " + Build.VERSION.RELEASE, this.useLegacyFormat);
        Intrinsics.checkNotNull(strBackup);
        if (strBackup.length() > 0) {
            this.status = BackupTaskStatus.BackupTaskFinished;
            this.lock.lock();
            try {
                Iterator<T> it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    ((IBackupProgression) it2.next()).backupFinished(new File(strBackup), this.lastOpenedNotebookKey);
                }
                Unit unit2 = Unit.INSTANCE;
                return;
            } finally {
            }
        }
        reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (IBackupProgression iBackupProgression : this.listeners) {
                if (this.canceled) {
                    this.status = BackupTaskStatus.BackupTaskCanceled;
                    iBackupProgression.backupCanceled();
                } else {
                    this.status = BackupTaskStatus.BackupTaskError;
                    iBackupProgression.backupError();
                }
            }
            Unit unit3 = Unit.INSTANCE;
            reentrantLock.unlock();
            Log.w(TAG, "Backup didn't finished with success");
        } finally {
        }
    }

    @Override // com.myscript.snt.dms.INeboBackupProgressionListener
    public boolean progression(float done, int current, int total) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((IBackupProgression) it.next()).backupProgress(current, total);
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            return !this.canceled;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void addProgressionListener(IBackupProgression listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.listeners.add(listener);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void removeProgressionListener(IBackupProgression listener) {
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
