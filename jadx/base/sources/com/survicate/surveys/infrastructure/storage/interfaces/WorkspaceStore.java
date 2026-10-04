package com.survicate.surveys.infrastructure.storage.interfaces;

import com.survicate.surveys.entities.survey.Workspace;
import kotlin.Metadata;

/* JADX INFO: compiled from: WorkspaceStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/interfaces/WorkspaceStore;", "", "saveWorkspace", "", "workspace", "Lcom/survicate/surveys/entities/survey/Workspace;", "getWorkspace", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface WorkspaceStore {
    Workspace getWorkspace();

    void saveWorkspace(Workspace workspace);
}
