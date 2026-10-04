package com.myscript.nebo.dms.core;

import com.myscript.atk.core.ICancelableTaskProgressCallback;
import com.myscript.snt.dms.IDMSMigrationToV2LogListener;
import kotlin.Metadata;

/* JADX INFO: compiled from: LibraryMigrator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/dms/core/LibraryMigrator;", "", "requiredDiskSpaceForMigrationToV2", "", "migrateToV2", "", "migrationListener", "Lcom/myscript/snt/dms/IDMSMigrationToV2LogListener;", "progressCallback", "Lcom/myscript/atk/core/ICancelableTaskProgressCallback;", "dms_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface LibraryMigrator {
    boolean migrateToV2(IDMSMigrationToV2LogListener migrationListener, ICancelableTaskProgressCallback progressCallback);

    long requiredDiskSpaceForMigrationToV2();
}
