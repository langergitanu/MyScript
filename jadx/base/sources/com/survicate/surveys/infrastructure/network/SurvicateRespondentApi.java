package com.survicate.surveys.infrastructure.network;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RespondentApi.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/SurvicateRespondentApi;", "Lcom/survicate/surveys/infrastructure/network/RespondentApi;", "httpClient", "Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;", "requestFactory", "Lcom/survicate/surveys/infrastructure/network/RespondentRequestFactory;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/SurvicateHttpClient;Lcom/survicate/surveys/infrastructure/network/RespondentRequestFactory;)V", "sendQuestionAnswered", "", "surveyId", "", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/QuestionAnsweredRequestBody;", "sendSurveySeen", "Lcom/survicate/surveys/infrastructure/network/SurveySeenRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateRespondentApi implements RespondentApi {
    private final SurvicateHttpClient httpClient;
    private final RespondentRequestFactory requestFactory;

    public SurvicateRespondentApi(SurvicateHttpClient httpClient, RespondentRequestFactory requestFactory) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(requestFactory, "requestFactory");
        this.httpClient = httpClient;
        this.requestFactory = requestFactory;
    }

    @Override // com.survicate.surveys.infrastructure.network.RespondentApi
    public void sendQuestionAnswered(String surveyId, QuestionAnsweredRequestBody body) throws IOException {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(body, "body");
        this.httpClient.loadUrlResponse(this.requestFactory.createQuestionAnsweredRequest(surveyId, body));
    }

    @Override // com.survicate.surveys.infrastructure.network.RespondentApi
    public void sendSurveySeen(String surveyId, SurveySeenRequestBody body) throws IOException {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(body, "body");
        this.httpClient.loadUrlResponse(this.requestFactory.createSurveySeenRequest(surveyId, body));
    }
}
