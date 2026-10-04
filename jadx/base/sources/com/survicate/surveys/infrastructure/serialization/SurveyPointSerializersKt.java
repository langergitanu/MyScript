package com.survicate.surveys.infrastructure.serialization;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: compiled from: SurveyPointSerializers.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0003"}, m1599d2 = {"appendAnswerTypeToSettings", "Lkotlinx/serialization/json/JsonElement;", "surveyPoint", "survicate-sdk_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyPointSerializersKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final JsonElement appendAnswerTypeToSettings(JsonElement jsonElement) {
        JsonElement jsonElement2;
        JsonObject jsonObjectAsObjectOrNull;
        if (jsonElement instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) jsonElement;
            JsonElement jsonElement3 = (JsonElement) jsonObject.get((Object) "answer_type");
            if (jsonElement3 != null && (jsonElement2 = (JsonElement) jsonObject.get((Object) "settings")) != null && (jsonObjectAsObjectOrNull = KotlinxSerializationExtKt.asObjectOrNull(jsonElement2)) != null) {
                return new JsonObject(MapsKt.plus((Map) jsonElement, TuplesKt.m1606to("settings", new JsonObject(MapsKt.plus(jsonObjectAsObjectOrNull, TuplesKt.m1606to("answer_type", jsonElement3))))));
            }
        }
        return jsonElement;
    }
}
