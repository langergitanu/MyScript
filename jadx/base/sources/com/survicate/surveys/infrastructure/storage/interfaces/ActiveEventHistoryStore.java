package com.survicate.surveys.infrastructure.storage.interfaces;

import com.survicate.surveys.entities.models.ActiveEventHistory;
import com.survicate.surveys.targeting.ActiveEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: ActiveEventHistoryStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/interfaces/ActiveEventHistoryStore;", "", "saveHistoryFor", "", "activeEvent", "Lcom/survicate/surveys/targeting/ActiveEvent;", "findMatchingHistory", "Lcom/survicate/surveys/entities/models/ActiveEventHistory;", "eventName", "", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface ActiveEventHistoryStore {
    ActiveEventHistory findMatchingHistory(String eventName);

    void saveHistoryFor(ActiveEvent activeEvent);
}
