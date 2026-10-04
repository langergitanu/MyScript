package com.survicate.surveys.infrastructure.storage;

import com.survicate.surveys.core.providers.ActiveScreenStore;
import com.survicate.surveys.core.providers.SurveyChanceStore;
import com.survicate.surveys.infrastructure.storage.interfaces.ActiveEventStore;
import com.survicate.surveys.infrastructure.storage.interfaces.PresentationStateStore;
import com.survicate.surveys.infrastructure.storage.interfaces.ResponseAttributeStore;
import com.survicate.surveys.infrastructure.storage.interfaces.SurvicateFontSystemStore;
import com.survicate.surveys.infrastructure.storage.interfaces.WorkspaceStore;
import kotlin.Metadata;

/* JADX INFO: compiled from: SessionStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/SessionStore;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/WorkspaceStore;", "Lcom/survicate/surveys/core/providers/SurveyChanceStore;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/PresentationStateStore;", "Lcom/survicate/surveys/core/providers/ActiveScreenStore;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/ActiveEventStore;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/ResponseAttributeStore;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SurvicateFontSystemStore;", "clear", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SessionStore extends WorkspaceStore, SurveyChanceStore, PresentationStateStore, ActiveScreenStore, ActiveEventStore, ResponseAttributeStore, SurvicateFontSystemStore {
    void clear();
}
