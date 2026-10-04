package com.survicate.surveys.infrastructure.storage;

import android.content.SharedPreferences;
import com.survicate.surveys.core.logging.SdkLogger;
import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.helpers.LogTags;
import com.survicate.surveys.infrastructure.serialization.SurvicateSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SerializedSharedPrefsSurvicateSynchronizationStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/SerializedSharedPrefsSurvicateSynchronizationStore;", "Lcom/survicate/surveys/infrastructure/storage/SurvicateSynchronizationStore;", "preferences", "Landroid/content/SharedPreferences;", "serializer", "Lcom/survicate/surveys/infrastructure/serialization/SurvicateSerializer;", "logger", "Lcom/survicate/surveys/core/logging/SdkLogger;", "<init>", "(Landroid/content/SharedPreferences;Lcom/survicate/surveys/infrastructure/serialization/SurvicateSerializer;Lcom/survicate/surveys/core/logging/SdkLogger;)V", "saveSeenEventsToSend", "", "seenEvents", "", "Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "loadSeenEventsToSend", "saveAnswerEventsToSend", "answerEvents", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "loadAnswerEventsToSend", "clear", "Companion", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SerializedSharedPrefsSurvicateSynchronizationStore implements SurvicateSynchronizationStore {
    private static final String ANSWERS_TO_SEND_KEY = "answersToSend";
    private static final String SURVEY_SEEN_EVENTS_TO_SEND_KEY = "surveySeenEventsToSend";
    private final SdkLogger logger;
    private final SharedPreferences preferences;
    private final SurvicateSerializer serializer;

    public SerializedSharedPrefsSurvicateSynchronizationStore(SharedPreferences preferences, SurvicateSerializer serializer, SdkLogger logger) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.preferences = preferences;
        this.serializer = serializer;
        this.logger = logger;
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateSynchronizationStore
    public void saveSeenEventsToSend(List<RespondentEvent.SurveySeen> seenEvents) {
        Intrinsics.checkNotNullParameter(seenEvents, "seenEvents");
        this.preferences.edit().putString(SURVEY_SEEN_EVENTS_TO_SEND_KEY, this.serializer.serializeSurveySeenEvents(seenEvents)).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateSynchronizationStore
    public List<RespondentEvent.SurveySeen> loadSeenEventsToSend() {
        if (!this.preferences.contains(SURVEY_SEEN_EVENTS_TO_SEND_KEY)) {
            return CollectionsKt.emptyList();
        }
        try {
            String string = this.preferences.getString(SURVEY_SEEN_EVENTS_TO_SEND_KEY, "");
            Intrinsics.checkNotNull(string);
            return this.serializer.deserializeSurveySeenEvents(string);
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to load seen events to send", e);
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateSynchronizationStore
    public void saveAnswerEventsToSend(List<RespondentEvent.QuestionAnswered> answerEvents) {
        Intrinsics.checkNotNullParameter(answerEvents, "answerEvents");
        this.preferences.edit().putString(ANSWERS_TO_SEND_KEY, this.serializer.serializeAnswerEvents(answerEvents)).apply();
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateSynchronizationStore
    public List<RespondentEvent.QuestionAnswered> loadAnswerEventsToSend() {
        if (!this.preferences.contains(ANSWERS_TO_SEND_KEY)) {
            return CollectionsKt.emptyList();
        }
        try {
            String string = this.preferences.getString(ANSWERS_TO_SEND_KEY, "");
            Intrinsics.checkNotNull(string);
            return this.serializer.deserializeAnswerEvents(string);
        } catch (Exception e) {
            this.logger.error(LogTags.PERSISTENCE, "Failed to load answer events to send", e);
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.survicate.surveys.infrastructure.storage.SurvicateSynchronizationStore
    public void clear() {
        this.preferences.edit().remove(SURVEY_SEEN_EVENTS_TO_SEND_KEY).remove(ANSWERS_TO_SEND_KEY).apply();
    }
}
