package com.myscript.nebo.whatsnew;

import kotlin.Metadata;

/* JADX INFO: compiled from: IPLSMigrationState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&R\u0018\u0010\u0004\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/IPLSMigrationState;", "", "requiresPLSMigration", "", "isPLSMigrationDone", "()Z", "setPLSMigrationDone", "(Z)V", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IPLSMigrationState {
    boolean isPLSMigrationDone();

    boolean requiresPLSMigration();

    void setPLSMigrationDone(boolean z);
}
