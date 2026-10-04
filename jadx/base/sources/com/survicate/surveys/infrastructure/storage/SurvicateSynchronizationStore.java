package com.survicate.surveys.infrastructure.storage;

import com.survicate.surveys.entities.models.RespondentEvent;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SurvicateSynchronizationStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/SurvicateSynchronizationStore;", "", "saveSeenEventsToSend", "", "seenEvents", "", "Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "loadSeenEventsToSend", "saveAnswerEventsToSend", "answerEvents", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "loadAnswerEventsToSend", "clear", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurvicateSynchronizationStore {
    void clear();

    List<RespondentEvent.QuestionAnswered> loadAnswerEventsToSend();

    List<RespondentEvent.SurveySeen> loadSeenEventsToSend();

    void saveAnswerEventsToSend(List<RespondentEvent.QuestionAnswered> answerEvents);

    void saveSeenEventsToSend(List<RespondentEvent.SurveySeen> seenEvents);
}
