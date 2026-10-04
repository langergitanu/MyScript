package com.survicate.surveys.infrastructure.storage.respondent;

import androidx.core.app.NotificationCompat;
import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.infrastructure.storage.interfaces.RespondentProvider;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: RespondentStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentStore;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/RespondentProvider;", "saveRespondentEvent", "", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/entities/models/RespondentEvent;", "removeRespondentEvent", "loadRespondentEvents", "", "clearRespondentEvents", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface RespondentStore extends RespondentProvider {
    void clearRespondentEvents();

    List<RespondentEvent> loadRespondentEvents();

    void removeRespondentEvent(RespondentEvent event);

    void saveRespondentEvent(RespondentEvent event);
}
