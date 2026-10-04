package com.myscript.nebo.whatsnew;

import kotlin.Metadata;

/* JADX INFO: compiled from: IWhatsNewState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&R\u0018\u0010\u0004\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\t¨\u0006\u0011À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/whatsnew/IWhatsNewState;", "", "requiresWhatsNew", "", "whatsNewNumber", "", "getWhatsNewNumber", "()I", "setWhatsNewNumber", "(I)V", "isMigrationOngoing", "()Z", "setMigrationOngoing", "(Z)V", "migrationProgress", "getMigrationProgress", "setMigrationProgress", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IWhatsNewState {
    int getMigrationProgress();

    int getWhatsNewNumber();

    boolean isMigrationOngoing();

    boolean requiresWhatsNew();

    void setMigrationOngoing(boolean z);

    void setMigrationProgress(int i);

    void setWhatsNewNumber(int i);
}
