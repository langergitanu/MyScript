package com.survicate.surveys.infrastructure.serialization;

import com.survicate.surveys.entities.models.ActiveEventHistory;
import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.traits.UserTrait;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONException;

/* JADX INFO: compiled from: SurvicateSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\u0003H&J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H&J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\r\u001a\u00020\u0003H&J\u001c\u0010\u000e\u001a\u00020\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u0010H&J\u001e\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0016\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0005H&J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00052\u0006\u0010\u0018\u001a\u00020\u0003H&J\u0016\u0010\u0019\u001a\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0005H&J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00052\u0006\u0010\u001d\u001a\u00020\u0003H&¨\u0006\u001e"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/SurvicateSerializer;", "", "serializeTraits", "", "userTraits", "", "Lcom/survicate/surveys/traits/UserTrait;", "deserializeUserTraits", "serializedTraits", "serializeAnswerEvents", "answeredPoints", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "deserializeAnswerEvents", "serializedAnswers", "serializePresentationTimesMap", "presentationTimes", "", "", "deserializePresentationTimesMap", "serializedTimes", "serializeSurveySeenEvents", "seenEvents", "Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "deserializeSurveySeenEvents", "serializedEvents", "serializeEventsHistory", "eventsHistory", "Lcom/survicate/surveys/entities/models/ActiveEventHistory;", "deserializeEventsHistory", "serializedHistory", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurvicateSerializer {
    List<RespondentEvent.QuestionAnswered> deserializeAnswerEvents(String serializedAnswers);

    List<ActiveEventHistory> deserializeEventsHistory(String serializedHistory);

    Map<String, Long> deserializePresentationTimesMap(String serializedTimes);

    List<RespondentEvent.SurveySeen> deserializeSurveySeenEvents(String serializedEvents);

    List<UserTrait> deserializeUserTraits(String serializedTraits) throws JSONException;

    String serializeAnswerEvents(List<RespondentEvent.QuestionAnswered> answeredPoints);

    String serializeEventsHistory(List<ActiveEventHistory> eventsHistory);

    String serializePresentationTimesMap(Map<String, Long> presentationTimes);

    String serializeSurveySeenEvents(List<RespondentEvent.SurveySeen> seenEvents);

    String serializeTraits(List<? extends UserTrait> userTraits);
}
