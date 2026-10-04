package com.survicate.surveys.infrastructure.serialization;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.network.QuestionAnsweredRequestBody;
import com.survicate.surveys.infrastructure.network.SurveySeenRequestBody;
import kotlin.Metadata;

/* JADX INFO: compiled from: RespondentSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¨\u0006\b"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/serialization/RespondentSerializer;", "", "serializeSurveySeenRequestBody", "", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/SurveySeenRequestBody;", "serializeQuestionAnsweredRequestBody", "Lcom/survicate/surveys/infrastructure/network/QuestionAnsweredRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface RespondentSerializer {
    String serializeQuestionAnsweredRequestBody(QuestionAnsweredRequestBody body);

    String serializeSurveySeenRequestBody(SurveySeenRequestBody body);
}
