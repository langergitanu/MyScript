package com.survicate.surveys.infrastructure.network.p038ai;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: FollowUpQuestionSerializer.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionSerializer;", "", "serializeFollowUpQuestionRequestBody", "", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;", "deserializeFollowUpQuestionResponse", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionResponse;", "response", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface FollowUpQuestionSerializer {
    FollowUpQuestionResponse deserializeFollowUpQuestionResponse(String response);

    String serializeFollowUpQuestionRequestBody(FollowUpQuestionRequestBody body);
}
