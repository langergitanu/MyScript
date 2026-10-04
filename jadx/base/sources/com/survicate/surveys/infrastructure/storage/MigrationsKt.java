package com.survicate.surveys.infrastructure.storage;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Migrations.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003¨\u0006\b"}, m1599d2 = {"MIGRATION_1_2", "Lcom/survicate/surveys/infrastructure/storage/SurvicateStoreMigration;", "getMIGRATION_1_2", "()Lcom/survicate/surveys/infrastructure/storage/SurvicateStoreMigration;", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class MigrationsKt {
    private static final SurvicateStoreMigration MIGRATION_1_2 = new SurvicateStoreMigration() { // from class: com.survicate.surveys.infrastructure.storage.MigrationsKt$MIGRATION_1_2$1
        @Override // com.survicate.surveys.infrastructure.storage.SurvicateStoreMigration
        public void migrate(SharedPreferences sharedPrefs) {
            Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
            sharedPrefs.edit().putString("firstPresentationTimesKey", sharedPrefs.getString("lastPresentationTimesKey", null)).apply();
        }
    };
    private static final SurvicateStoreMigration MIGRATION_2_3 = new MigrationsKt$MIGRATION_2_3$1();
    private static final SurvicateStoreMigration MIGRATION_3_4 = new SurvicateStoreMigration() { // from class: com.survicate.surveys.infrastructure.storage.MigrationsKt$MIGRATION_3_4$1
        private final String ALREADY_SEND_ATTRIBUTES_KEY = "alreadySendAttributes";

        @Override // com.survicate.surveys.infrastructure.storage.SurvicateStoreMigration
        public void migrate(SharedPreferences sharedPrefs) {
            Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
            if (sharedPrefs.contains(this.ALREADY_SEND_ATTRIBUTES_KEY)) {
                sharedPrefs.edit().remove(this.ALREADY_SEND_ATTRIBUTES_KEY).apply();
            }
        }
    };

    public static final SurvicateStoreMigration getMIGRATION_1_2() {
        return MIGRATION_1_2;
    }

    public static final SurvicateStoreMigration getMIGRATION_2_3() {
        return MIGRATION_2_3;
    }

    public static final SurvicateStoreMigration getMIGRATION_3_4() {
        return MIGRATION_3_4;
    }
}
