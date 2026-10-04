package com.myscript.nebo.migration;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: MigrationRestorer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/migration/MigrationRestorer;", "", "stopThumbnailer", "", "restartThumbnailer", "restore", "stream", "Ljava/io/FileInputStream;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/myscript/nebo/migration/MigrationRestorer$Listener;", "(Ljava/io/FileInputStream;Lcom/myscript/nebo/migration/MigrationRestorer$Listener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Listener", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface MigrationRestorer {

    /* JADX INFO: compiled from: MigrationRestorer.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0003H&¨\u0006\u0013À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/migration/MigrationRestorer$Listener;", "", "onCopyProgress", "", "percent", "", "onCopyFinished", "onCopyCanceled", "onCopyError", "onVerifyError", "onRestoreProgress", "current", "total", "onRestoreFinished", "onRestoreCanceled", "onRestoreInsufficientSpace", "requiredSize", "", "onRestoreError", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Listener {
        void onCopyCanceled();

        void onCopyError();

        void onCopyFinished();

        void onCopyProgress(int percent);

        void onRestoreCanceled();

        void onRestoreError();

        void onRestoreFinished();

        void onRestoreInsufficientSpace(long requiredSize);

        void onRestoreProgress(int current, int total);

        void onVerifyError();
    }

    void restartThumbnailer();

    Object restore(FileInputStream fileInputStream, Listener listener, Continuation<? super Unit> continuation);

    void stopThumbnailer();
}
