package com.survicate.surveys.infrastructure.serialization;

import com.survicate.surveys.entities.survey.questions.question.SurveyQuestionSurveyPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonTransformingSerializer;

/* JADX INFO: compiled from: SurveyPointSerializers.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/SurveyQuestionSurveyPointSerializer;", "Lkotlinx/serialization/json/JsonTransformingSerializer;", "Lcom/survicate/surveys/entities/survey/questions/question/SurveyQuestionSurveyPoint;", "<init>", "()V", "transformDeserialize", "Lkotlinx/serialization/json/JsonElement;", "element", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyQuestionSurveyPointSerializer extends JsonTransformingSerializer<SurveyQuestionSurveyPoint> {
    public static final SurveyQuestionSurveyPointSerializer INSTANCE = new SurveyQuestionSurveyPointSerializer();

    private SurveyQuestionSurveyPointSerializer() {
        super(SurveyQuestionSurveyPoint.INSTANCE.serializer());
    }

    @Override // kotlinx.serialization.json.JsonTransformingSerializer
    protected JsonElement transformDeserialize(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return SurveyPointSerializersKt.appendAnswerTypeToSettings(element);
    }
}
