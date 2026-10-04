package com.myscript.nebo.migration;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: LenovoBackupSource.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH¦@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/migration/LenovoBackupSource;", "", "startBackup", "Lcom/myscript/nebo/migration/BackupStatus;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "openBackupStream", "Ljava/io/InputStream;", "handle", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface LenovoBackupSource {
    Object getStatus(Continuation<? super BackupStatus> continuation);

    Object openBackupStream(String str, Continuation<? super InputStream> continuation);

    Object startBackup(Continuation<? super BackupStatus> continuation);
}
