package com.survicate.surveys.infrastructure.network;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.environment.UrlProvider;
import com.survicate.surveys.infrastructure.serialization.RespondentSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurvicateRespondentRequestFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/SurvicateRespondentRequestFactory;", "Lcom/survicate/surveys/infrastructure/network/RespondentRequestFactory;", "serializer", "Lcom/survicate/surveys/infrastructure/serialization/RespondentSerializer;", "urlProvider", "Lcom/survicate/surveys/infrastructure/environment/UrlProvider;", "<init>", "(Lcom/survicate/surveys/infrastructure/serialization/RespondentSerializer;Lcom/survicate/surveys/infrastructure/environment/UrlProvider;)V", "createQuestionAnsweredRequest", "Lcom/survicate/surveys/infrastructure/network/URLRequest;", "surveyId", "", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/QuestionAnsweredRequestBody;", "createSurveySeenRequest", "Lcom/survicate/surveys/infrastructure/network/SurveySeenRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateRespondentRequestFactory implements RespondentRequestFactory {
    private final RespondentSerializer serializer;
    private final UrlProvider urlProvider;

    public SurvicateRespondentRequestFactory(RespondentSerializer serializer, UrlProvider urlProvider) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(urlProvider, "urlProvider");
        this.serializer = serializer;
        this.urlProvider = urlProvider;
    }

    @Override // com.survicate.surveys.infrastructure.network.RespondentRequestFactory
    public URLRequest createQuestionAnsweredRequest(String surveyId, QuestionAnsweredRequestBody body) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveQuestionAnsweredUrl(surveyId), "POST", this.serializer.serializeQuestionAnsweredRequestBody(body));
    }

    @Override // com.survicate.surveys.infrastructure.network.RespondentRequestFactory
    public URLRequest createSurveySeenRequest(String surveyId, SurveySeenRequestBody body) {
        Intrinsics.checkNotNullParameter(surveyId, "surveyId");
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveSurveySeenUrl(surveyId), "POST", this.serializer.serializeSurveySeenRequestBody(body));
    }
}
