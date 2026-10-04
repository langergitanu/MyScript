package com.survicate.surveys.infrastructure.network.p038ai;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.survicate.surveys.infrastructure.network.URLRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: FollowUpQuestionRequestFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestFactory;", "", "createFollowUpQuestionRequest", "Lcom/survicate/surveys/infrastructure/network/URLRequest;", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface FollowUpQuestionRequestFactory {
    URLRequest createFollowUpQuestionRequest(FollowUpQuestionRequestBody body);
}
