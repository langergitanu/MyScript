package com.survicate.surveys.infrastructure.serialization;

import com.survicate.surveys.entities.survey.translations.DisclaimerSettingsTranslation;
import com.survicate.surveys.entities.survey.translations.ImageTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyMessagesTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyPointEntryTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyPointImageTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyPointSettingsTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyPointTranslation;
import com.survicate.surveys.entities.survey.translations.SurveySettingsTranslation;
import com.survicate.surveys.entities.survey.translations.SurveyTranslation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: TranslationsSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010$\u001a\u00020%H\u0016J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00022\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00022\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\u0018\u0010-\u001a\b\u0012\u0004\u0012\u00020+0\u00022\b\u0010.\u001a\u0004\u0018\u00010)H\u0002J\u0014\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u00010)H\u0002J\u0014\u00102\u001a\u0004\u0018\u0001032\b\u00101\u001a\u0004\u0018\u00010)H\u0002J\u0014\u00104\u001a\u0004\u0018\u0001052\b\u00101\u001a\u0004\u0018\u00010)H\u0002J\u0010\u00106\u001a\u0002072\u0006\u00101\u001a\u00020)H\u0002J\u001e\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\"¨\u0006="}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/TranslationsSerializer;", "Lkotlinx/serialization/KSerializer;", "", "Lcom/survicate/surveys/entities/survey/translations/SurveyTranslation;", "<init>", "()V", "POINTS_KEY", "", "POINT_CONTENT_KEY", "POINT_DESCRIPTION_KEY", "POINT_ANSWERS_KEY", "POINT_FIELDS_KEY", "POINT_SETTINGS_TEXT_KEY", "POINT_SETTINGS_LEFT_TEXT_KEY", "POINT_SETTINGS_RIGHT_TEXT_KEY", "POINT_SETTINGS_MATRIX_SCALE", "POINT_SETTINGS_COMMENT_LABEL", "POINT_SETTINGS_SURVEY_POINT_IMAGE", "POINT_SETTINGS_SURVEY_POINT_IMAGE_IMAGE", "POINT_SETTINGS_SURVEY_POINT_IMAGE_DESCRIPTION", "POINT_DISCLAIMER_SETTINGS_KEY", "DISCLAIMER_SETTINGS_TITLE_KEY", "DISCLAIMER_SETTINGS_DESCRIPTION_KEY", "DISCLAIMER_SETTINGS_CHECKBOX_LABEL_KEY", "SETTINGS_KEY", "SETTINGS_MESSAGES_KEY", "MESSAGES_SUBMIT_TEXT_KEY", "MESSAGES_NAVIGATION_BACK_TEXT_KEY", "MESSAGES_ANSWER_REQUIRED_TEXT_KEY", "MESSAGES_INPUT_TEXT_PLACEHOLDER_KEY", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor$annotations", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "mapPoints", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointTranslation;", TranslationsSerializer.POINTS_KEY, "Lkotlinx/serialization/json/JsonObject;", "mapPointAnswers", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointEntryTranslation;", TranslationsSerializer.POINT_ANSWERS_KEY, "mapPointFields", TranslationsSerializer.POINT_FIELDS_KEY, "mapPointSettings", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointSettingsTranslation;", TranslationsSerializer.SETTINGS_KEY, "mapDisclaimerSettings", "Lcom/survicate/surveys/entities/survey/translations/DisclaimerSettingsTranslation;", "mapSurveyPointImage", "Lcom/survicate/surveys/entities/survey/translations/SurveyPointImageTranslation;", "mapSettings", "Lcom/survicate/surveys/entities/survey/translations/SurveySettingsTranslation;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class TranslationsSerializer implements KSerializer<List<? extends SurveyTranslation>> {
    private static final String DISCLAIMER_SETTINGS_CHECKBOX_LABEL_KEY = "checkbox_label";
    private static final String DISCLAIMER_SETTINGS_DESCRIPTION_KEY = "description";
    private static final String DISCLAIMER_SETTINGS_TITLE_KEY = "title";
    private static final String MESSAGES_ANSWER_REQUIRED_TEXT_KEY = "answer_required_text";
    private static final String MESSAGES_INPUT_TEXT_PLACEHOLDER_KEY = "text_placeholder";
    private static final String MESSAGES_NAVIGATION_BACK_TEXT_KEY = "navigation_back_text";
    private static final String MESSAGES_SUBMIT_TEXT_KEY = "submit_text";
    private static final String POINTS_KEY = "points";
    private static final String POINT_ANSWERS_KEY = "answers";
    private static final String POINT_CONTENT_KEY = "content";
    private static final String POINT_DESCRIPTION_KEY = "description";
    private static final String POINT_DISCLAIMER_SETTINGS_KEY = "disclaimer_settings";
    private static final String POINT_FIELDS_KEY = "fields";
    private static final String POINT_SETTINGS_COMMENT_LABEL = "comment_label";
    private static final String POINT_SETTINGS_LEFT_TEXT_KEY = "text_on_the_left";
    private static final String POINT_SETTINGS_MATRIX_SCALE = "scale";
    private static final String POINT_SETTINGS_RIGHT_TEXT_KEY = "text_on_the_right";
    private static final String POINT_SETTINGS_SURVEY_POINT_IMAGE = "point_image";
    private static final String POINT_SETTINGS_SURVEY_POINT_IMAGE_DESCRIPTION = "description";
    private static final String POINT_SETTINGS_SURVEY_POINT_IMAGE_IMAGE = "image";
    private static final String POINT_SETTINGS_TEXT_KEY = "text";
    private static final String SETTINGS_KEY = "settings";
    private static final String SETTINGS_MESSAGES_KEY = "messages";
    public static final TranslationsSerializer INSTANCE = new TranslationsSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.SerialDescriptor("com.survicate.surveys.SurveyTranslations", JsonElement.INSTANCE.serializer().getDescriptor());

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    private TranslationsSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public List<SurveyTranslation> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!(decoder instanceof JsonDecoder)) {
            throw new IllegalArgumentException("KotlinxTranslationsSerializer works only with JsonDecoder".toString());
        }
        JsonElement jsonElementDecodeJsonElement = ((JsonDecoder) decoder).decodeJsonElement();
        if (!(jsonElementDecodeJsonElement instanceof JsonObject)) {
            return CollectionsKt.emptyList();
        }
        Set<Map.Entry<String, JsonElement>> setEntrySet = ((JsonObject) jsonElementDecodeJsonElement).entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            JsonObject jsonObject = JsonElementKt.getJsonObject((JsonElement) entry.getValue());
            ArrayList arrayList2 = new ArrayList(jsonObject.size());
            for (Map.Entry<String, JsonElement> entry2 : jsonObject.entrySet()) {
                arrayList2.add(new Triple(entry.getKey(), entry2.getKey(), entry2.getValue()));
            }
            CollectionsKt.addAll(arrayList, arrayList2);
        }
        ArrayList<Triple> arrayList3 = arrayList;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (Triple triple : arrayList3) {
            String str = (String) triple.getFirst();
            String str2 = (String) triple.getSecond();
            JsonObject jsonObject2 = JsonElementKt.getJsonObject((JsonElement) triple.getThird());
            JsonObject objectOrThrow = KotlinxSerializationExtKt.getObjectOrThrow(jsonObject2, POINTS_KEY);
            JsonObject objectOrThrow2 = KotlinxSerializationExtKt.getObjectOrThrow(jsonObject2, SETTINGS_KEY);
            TranslationsSerializer translationsSerializer = INSTANCE;
            arrayList4.add(new SurveyTranslation(str, str2, translationsSerializer.mapPoints(objectOrThrow), translationsSerializer.mapSettings(objectOrThrow2)));
        }
        return arrayList4;
    }

    private final List<SurveyPointTranslation> mapPoints(JsonObject points) {
        Set<Map.Entry<String, JsonElement>> setEntrySet = points.entrySet();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            long j = Long.parseLong((String) entry.getKey());
            JsonObject jsonObject = JsonElementKt.getJsonObject((JsonElement) entry.getValue());
            JsonElement jsonElement = (JsonElement) jsonObject.get((Object) "content");
            JsonObject jsonObjectAsObjectOrNull = null;
            String strAsStringOrNull = jsonElement != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement) : null;
            JsonElement jsonElement2 = (JsonElement) jsonObject.get((Object) "description");
            String strAsStringOrNull2 = jsonElement2 != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement2) : null;
            JsonElement jsonElement3 = (JsonElement) jsonObject.get((Object) POINT_ANSWERS_KEY);
            JsonObject jsonObjectAsObjectOrNull2 = jsonElement3 != null ? KotlinxSerializationExtKt.asObjectOrNull(jsonElement3) : null;
            JsonElement jsonElement4 = (JsonElement) jsonObject.get((Object) POINT_FIELDS_KEY);
            JsonObject jsonObjectAsObjectOrNull3 = jsonElement4 != null ? KotlinxSerializationExtKt.asObjectOrNull(jsonElement4) : null;
            JsonElement jsonElement5 = (JsonElement) jsonObject.get((Object) SETTINGS_KEY);
            if (jsonElement5 != null) {
                jsonObjectAsObjectOrNull = KotlinxSerializationExtKt.asObjectOrNull(jsonElement5);
            }
            TranslationsSerializer translationsSerializer = INSTANCE;
            arrayList.add(new SurveyPointTranslation(j, strAsStringOrNull, strAsStringOrNull2, translationsSerializer.mapPointAnswers(jsonObjectAsObjectOrNull2), translationsSerializer.mapPointFields(jsonObjectAsObjectOrNull3), translationsSerializer.mapPointSettings(jsonObjectAsObjectOrNull)));
        }
        return arrayList;
    }

    private final List<SurveyPointEntryTranslation> mapPointAnswers(JsonObject answers) {
        Set<Map.Entry<String, JsonElement>> setEntrySet;
        if (answers != null && (setEntrySet = answers.entrySet()) != null) {
            Set<Map.Entry<String, JsonElement>> set = setEntrySet;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                arrayList.add(new SurveyPointEntryTranslation(Long.parseLong((String) entry.getKey()), KotlinxSerializationExtKt.asStringOrNull((JsonElement) entry.getValue())));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    private final List<SurveyPointEntryTranslation> mapPointFields(JsonObject fields) {
        Set<Map.Entry<String, JsonElement>> setEntrySet;
        if (fields != null && (setEntrySet = fields.entrySet()) != null) {
            Set<Map.Entry<String, JsonElement>> set = setEntrySet;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                arrayList.add(new SurveyPointEntryTranslation(Long.parseLong((String) entry.getKey()), KotlinxSerializationExtKt.asStringOrNull((JsonElement) entry.getValue())));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    private final SurveyPointSettingsTranslation mapPointSettings(JsonObject settings) {
        LinkedHashMap linkedHashMap;
        JsonObject jsonObjectAsObjectOrNull;
        if (settings == null) {
            return null;
        }
        JsonElement jsonElement = (JsonElement) settings.get("text");
        String strAsStringOrNull = jsonElement != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement) : null;
        JsonElement jsonElement2 = (JsonElement) settings.get(POINT_SETTINGS_LEFT_TEXT_KEY);
        String strAsStringOrNull2 = jsonElement2 != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement2) : null;
        JsonElement jsonElement3 = (JsonElement) settings.get(POINT_SETTINGS_RIGHT_TEXT_KEY);
        String strAsStringOrNull3 = jsonElement3 != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement3) : null;
        JsonElement jsonElement4 = (JsonElement) settings.get(POINT_DISCLAIMER_SETTINGS_KEY);
        DisclaimerSettingsTranslation disclaimerSettingsTranslationMapDisclaimerSettings = mapDisclaimerSettings(jsonElement4 != null ? KotlinxSerializationExtKt.asObjectOrNull(jsonElement4) : null);
        JsonElement jsonElement5 = (JsonElement) settings.get(POINT_SETTINGS_MATRIX_SCALE);
        if (jsonElement5 == null || (jsonObjectAsObjectOrNull = KotlinxSerializationExtKt.asObjectOrNull(jsonElement5)) == null) {
            linkedHashMap = null;
        } else {
            JsonObject jsonObject = jsonObjectAsObjectOrNull;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(jsonObject.size()));
            Iterator<T> it = jsonObject.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap2.put(entry.getKey(), JsonElementKt.getJsonPrimitive((JsonElement) entry.getValue()).getContent());
            }
            linkedHashMap = linkedHashMap2;
        }
        JsonElement jsonElement6 = (JsonElement) settings.get(POINT_SETTINGS_COMMENT_LABEL);
        String strAsStringOrNull4 = jsonElement6 != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement6) : null;
        JsonElement jsonElement7 = (JsonElement) settings.get(POINT_SETTINGS_SURVEY_POINT_IMAGE);
        return new SurveyPointSettingsTranslation(strAsStringOrNull, strAsStringOrNull2, strAsStringOrNull3, disclaimerSettingsTranslationMapDisclaimerSettings, linkedHashMap, strAsStringOrNull4, mapSurveyPointImage(jsonElement7 != null ? KotlinxSerializationExtKt.asObjectOrNull(jsonElement7) : null));
    }

    private final DisclaimerSettingsTranslation mapDisclaimerSettings(JsonObject settings) {
        if (settings == null) {
            return null;
        }
        JsonElement jsonElement = (JsonElement) settings.get(DISCLAIMER_SETTINGS_TITLE_KEY);
        String strAsStringOrNull = jsonElement != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement) : null;
        JsonElement jsonElement2 = (JsonElement) settings.get("description");
        String strAsStringOrNull2 = jsonElement2 != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement2) : null;
        JsonElement jsonElement3 = (JsonElement) settings.get(DISCLAIMER_SETTINGS_CHECKBOX_LABEL_KEY);
        return new DisclaimerSettingsTranslation(strAsStringOrNull, strAsStringOrNull2, jsonElement3 != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement3) : null);
    }

    private static final ImageTranslation mapSurveyPointImage$mapImage(JsonObject jsonObject) {
        if (jsonObject == null) {
            return null;
        }
        JsonElement jsonElement = (JsonElement) jsonObject.get("description");
        return new ImageTranslation(jsonElement != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement) : null);
    }

    private final SurveyPointImageTranslation mapSurveyPointImage(JsonObject settings) {
        if (settings == null) {
            return null;
        }
        JsonElement jsonElement = (JsonElement) settings.get("image");
        return new SurveyPointImageTranslation(mapSurveyPointImage$mapImage(jsonElement != null ? KotlinxSerializationExtKt.asObjectOrNull(jsonElement) : null));
    }

    private final SurveySettingsTranslation mapSettings(JsonObject settings) {
        JsonObject objectOrThrow = KotlinxSerializationExtKt.getObjectOrThrow(settings, SETTINGS_MESSAGES_KEY);
        JsonElement jsonElement = (JsonElement) objectOrThrow.get((Object) MESSAGES_SUBMIT_TEXT_KEY);
        String strAsStringOrNull = jsonElement != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement) : null;
        JsonElement jsonElement2 = (JsonElement) objectOrThrow.get((Object) MESSAGES_NAVIGATION_BACK_TEXT_KEY);
        String strAsStringOrNull2 = jsonElement2 != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement2) : null;
        JsonElement jsonElement3 = (JsonElement) objectOrThrow.get((Object) MESSAGES_ANSWER_REQUIRED_TEXT_KEY);
        String strAsStringOrNull3 = jsonElement3 != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement3) : null;
        JsonElement jsonElement4 = (JsonElement) objectOrThrow.get((Object) MESSAGES_INPUT_TEXT_PLACEHOLDER_KEY);
        return new SurveySettingsTranslation(new SurveyMessagesTranslation(strAsStringOrNull, strAsStringOrNull2, strAsStringOrNull3, jsonElement4 != null ? KotlinxSerializationExtKt.asStringOrNull(jsonElement4) : null));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, List<SurveyTranslation> value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new UnsupportedOperationException();
    }
}
