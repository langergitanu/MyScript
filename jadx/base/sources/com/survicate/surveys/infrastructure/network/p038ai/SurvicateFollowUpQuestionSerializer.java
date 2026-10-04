package com.survicate.surveys.infrastructure.network.p038ai;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* JADX INFO: compiled from: FollowUpQuestionSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/SurvicateFollowUpQuestionSerializer;", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionSerializer;", "jsonSerialization", "Lkotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/Json;)V", "serializeFollowUpQuestionRequestBody", "", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;", "deserializeFollowUpQuestionResponse", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionResponse;", "response", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateFollowUpQuestionSerializer implements FollowUpQuestionSerializer {
    private final Json jsonSerialization;

    public SurvicateFollowUpQuestionSerializer(Json jsonSerialization) {
        Intrinsics.checkNotNullParameter(jsonSerialization, "jsonSerialization");
        this.jsonSerialization = jsonSerialization;
    }

    @Override // com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionSerializer
    public String serializeFollowUpQuestionRequestBody(FollowUpQuestionRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return json.encodeToString(FollowUpQuestionRequestBody.INSTANCE.serializer(), body);
    }

    @Override // com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionSerializer
    public FollowUpQuestionResponse deserializeFollowUpQuestionResponse(String response) {
        Intrinsics.checkNotNullParameter(response, "response");
        Json json = this.jsonSerialization;
        json.getSerializersModule();
        return (FollowUpQuestionResponse) json.decodeFromString(FollowUpQuestionResponse.INSTANCE.serializer(), response);
    }
}
