package com.survicate.surveys.infrastructure.serialization;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import com.survicate.surveys.entities.models.ActiveEventHistory;
import com.survicate.surveys.entities.models.RespondentEvent;
import com.survicate.surveys.traits.UserTrait;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SurvicateJsonSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u001c\u0010\u0015\u001a\u00020\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u001e\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0016\u0010\u001b\u001a\u00020\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\tH\u0016J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\t2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0016\u0010 \u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\tH\u0016J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\t2\u0006\u0010$\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/SurvicateJsonSerializer;", "Lcom/survicate/surveys/infrastructure/serialization/SurvicateSerializer;", "jsonSerialization", "Lkotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/Json;)V", "serializeTraits", "", "userTraits", "", "Lcom/survicate/surveys/traits/UserTrait;", "deserializeUserTraits", "serializedTraits", "tryParseUserTrait", "rawTrait", "Lorg/json/JSONObject;", "serializeAnswerEvents", "answeredPoints", "Lcom/survicate/surveys/entities/models/RespondentEvent$QuestionAnswered;", "deserializeAnswerEvents", "serializedAnswers", "serializePresentationTimesMap", "presentationTimes", "", "", "deserializePresentationTimesMap", "serializedTimes", "serializeSurveySeenEvents", "seenEvents", "Lcom/survicate/surveys/entities/models/RespondentEvent$SurveySeen;", "deserializeSurveySeenEvents", "serializedEvents", "serializeEventsHistory", "eventsHistory", "Lcom/survicate/surveys/entities/models/ActiveEventHistory;", "deserializeEventsHistory", "serializedHistory", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateJsonSerializer implements SurvicateSerializer {
    private final Json jsonSerialization;

    public SurvicateJsonSerializer(Json jsonSerialization) {
        Intrinsics.checkNotNullParameter(jsonSerialization, "jsonSerialization");
        this.jsonSerialization = jsonSerialization;
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public String serializeTraits(List<? extends UserTrait> userTraits) {
        Intrinsics.checkNotNullParameter(userTraits, "userTraits");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(new ArrayListSerializer(UserTrait.INSTANCE.serializer()), userTraits);
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public List<UserTrait> deserializeUserTraits(String serializedTraits) throws JSONException {
        Intrinsics.checkNotNullParameter(serializedTraits, "serializedTraits");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(serializedTraits);
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNull(jSONObject);
            UserTrait userTraitTryParseUserTrait = tryParseUserTrait(jSONObject);
            if (userTraitTryParseUserTrait != null) {
                arrayList.add(userTraitTryParseUserTrait);
            }
        }
        return arrayList;
    }

    private final UserTrait tryParseUserTrait(JSONObject rawTrait) {
        try {
            String string = rawTrait.getString(SubscriberAttributeKt.JSON_NAME_KEY);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = rawTrait.isNull("value") ? null : rawTrait.getString("value");
            Long lValueOf = rawTrait.isNull("timestamp_ms") ? null : Long.valueOf(rawTrait.getLong("timestamp_ms"));
            Long lValueOf2 = rawTrait.isNull("throttled_to_ms") ? null : Long.valueOf(rawTrait.getLong("throttled_to_ms"));
            UserTrait userTrait = new UserTrait(string, string2);
            userTrait.setTimestampMs$survicate_sdk_release(lValueOf);
            userTrait.setThrottledToMs$survicate_sdk_release(lValueOf2);
            return userTrait;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public String serializeAnswerEvents(List<RespondentEvent.QuestionAnswered> answeredPoints) {
        Intrinsics.checkNotNullParameter(answeredPoints, "answeredPoints");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(new ArrayListSerializer(RespondentEvent.QuestionAnswered.INSTANCE.serializer()), answeredPoints);
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public List<RespondentEvent.QuestionAnswered> deserializeAnswerEvents(String serializedAnswers) {
        Intrinsics.checkNotNullParameter(serializedAnswers, "serializedAnswers");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return (List) json.decodeFromString(new ArrayListSerializer(RespondentEvent.QuestionAnswered.INSTANCE.serializer()), serializedAnswers);
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public String serializePresentationTimesMap(Map<String, Long> presentationTimes) {
        Intrinsics.checkNotNullParameter(presentationTimes, "presentationTimes");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, LongSerializer.INSTANCE), presentationTimes);
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public Map<String, Long> deserializePresentationTimesMap(String serializedTimes) {
        Intrinsics.checkNotNullParameter(serializedTimes, "serializedTimes");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return (Map) json.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE)), serializedTimes);
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public String serializeSurveySeenEvents(List<RespondentEvent.SurveySeen> seenEvents) {
        Intrinsics.checkNotNullParameter(seenEvents, "seenEvents");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(new ArrayListSerializer(RespondentEvent.SurveySeen.INSTANCE.serializer()), seenEvents);
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public List<RespondentEvent.SurveySeen> deserializeSurveySeenEvents(String serializedEvents) {
        Intrinsics.checkNotNullParameter(serializedEvents, "serializedEvents");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return (List) json.decodeFromString(new ArrayListSerializer(RespondentEvent.SurveySeen.INSTANCE.serializer()), serializedEvents);
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public String serializeEventsHistory(List<ActiveEventHistory> eventsHistory) {
        Intrinsics.checkNotNullParameter(eventsHistory, "eventsHistory");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(new ArrayListSerializer(ActiveEventHistory.INSTANCE.serializer()), eventsHistory);
    }

    @Override // com.survicate.surveys.infrastructure.serialization.SurvicateSerializer
    public List<ActiveEventHistory> deserializeEventsHistory(String serializedHistory) {
        Intrinsics.checkNotNullParameter(serializedHistory, "serializedHistory");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return (List) json.decodeFromString(new ArrayListSerializer(ActiveEventHistory.INSTANCE.serializer()), serializedHistory);
    }
}
