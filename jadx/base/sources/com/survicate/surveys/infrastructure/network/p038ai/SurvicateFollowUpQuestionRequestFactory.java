package com.survicate.surveys.infrastructure.network.p038ai;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.environment.UrlProvider;
import com.survicate.surveys.infrastructure.network.URLRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FollowUpQuestionRequestFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/SurvicateFollowUpQuestionRequestFactory;", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestFactory;", "serializer", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionSerializer;", "urlProvider", "Lcom/survicate/surveys/infrastructure/environment/UrlProvider;", "<init>", "(Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionSerializer;Lcom/survicate/surveys/infrastructure/environment/UrlProvider;)V", "createFollowUpQuestionRequest", "Lcom/survicate/surveys/infrastructure/network/URLRequest;", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurvicateFollowUpQuestionRequestFactory implements FollowUpQuestionRequestFactory {
    private final FollowUpQuestionSerializer serializer;
    private final UrlProvider urlProvider;

    public SurvicateFollowUpQuestionRequestFactory(FollowUpQuestionSerializer serializer, UrlProvider urlProvider) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(urlProvider, "urlProvider");
        this.serializer = serializer;
        this.urlProvider = urlProvider;
    }

    @Override // com.survicate.surveys.infrastructure.network.p038ai.FollowUpQuestionRequestFactory
    public URLRequest createFollowUpQuestionRequest(FollowUpQuestionRequestBody body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return new URLRequest(this.urlProvider.resolveFollowUpQuestionUrl(), "POST", this.serializer.serializeFollowUpQuestionRequestBody(body));
    }
}
