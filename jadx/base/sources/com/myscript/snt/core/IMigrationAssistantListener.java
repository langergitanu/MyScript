package com.myscript.snt.core;

/* JADX INFO: loaded from: classes7.dex */
public interface IMigrationAssistantListener {
    void migrationAssistantDidCancelMigration();

    void migrationAssistantDidEndMigration();

    void migrationAssistantDidProgress(float f);

    void migrationAssistantDidStartDocument(String str);
}
