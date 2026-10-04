package com.survicate.surveys.infrastructure.storage;

import android.content.SharedPreferences;
import kotlin.Metadata;

/* JADX INFO: compiled from: Migrations.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/SurvicateStoreMigration;", "", "targetSchemaVersion", "", "<init>", "(I)V", "getTargetSchemaVersion", "()I", "migrate", "", "sharedPrefs", "Landroid/content/SharedPreferences;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class SurvicateStoreMigration {
    private final int targetSchemaVersion;

    public abstract void migrate(SharedPreferences sharedPrefs);

    public SurvicateStoreMigration(int i) {
        this.targetSchemaVersion = i;
    }

    public final int getTargetSchemaVersion() {
        return this.targetSchemaVersion;
    }
}
