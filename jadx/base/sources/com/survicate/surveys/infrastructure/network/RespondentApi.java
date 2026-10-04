package com.survicate.surveys.infrastructure.network;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: compiled from: RespondentApi.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&¨\u0006\n"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/RespondentApi;", "", "sendQuestionAnswered", "", "surveyId", "", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/QuestionAnsweredRequestBody;", "sendSurveySeen", "Lcom/survicate/surveys/infrastructure/network/SurveySeenRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface RespondentApi {
    void sendQuestionAnswered(String surveyId, QuestionAnsweredRequestBody body) throws IOException;

    void sendSurveySeen(String surveyId, SurveySeenRequestBody body) throws IOException;
}
