package com.myscript.nebo.migration;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: ILenovoMigrationController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000fJ\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000e\u001a\u00020\fH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/migration/ILenovoMigrationController;", "", "progress", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/myscript/nebo/migration/MigrationProgress;", "getProgress", "()Lkotlinx/coroutines/flow/StateFlow;", "migrationState", "Lcom/myscript/nebo/migration/MigrationState;", "getMigrationState", "()Lcom/myscript/nebo/migration/MigrationState;", TtmlNode.START, "", "markMigrationPending", "markMigrationCompleted", "Provider", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ILenovoMigrationController {

    /* JADX INFO: compiled from: ILenovoMigrationController.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/migration/ILenovoMigrationController$Provider;", "", "provideLenovoMigrationController", "Lcom/myscript/nebo/migration/ILenovoMigrationController;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        ILenovoMigrationController provideLenovoMigrationController();
    }

    MigrationState getMigrationState();

    StateFlow<MigrationProgress> getProgress();

    void markMigrationCompleted();

    void markMigrationPending();

    void start();
}
