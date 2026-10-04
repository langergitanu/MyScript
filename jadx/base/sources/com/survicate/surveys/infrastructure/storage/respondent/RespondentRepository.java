package com.survicate.surveys.infrastructure.storage.respondent;

import androidx.core.app.NotificationCompat;
import com.survicate.surveys.entities.models.RespondentEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: RespondentRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/respondent/RespondentRepository;", "", "init", "", "addRespondentEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/survicate/surveys/entities/models/RespondentEvent;", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface RespondentRepository {
    void addRespondentEvent(RespondentEvent event);

    void clear();

    void init();
}
