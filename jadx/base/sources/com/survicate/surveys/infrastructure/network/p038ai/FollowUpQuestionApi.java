package com.survicate.surveys.infrastructure.network.p038ai;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: FollowUpQuestionApi.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionApi;", "", "requestFollowUpQuestion", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionResponse;", TtmlNode.TAG_BODY, "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;", "(Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface FollowUpQuestionApi {
    Object requestFollowUpQuestion(FollowUpQuestionRequestBody followUpQuestionRequestBody, Continuation<? super FollowUpQuestionResponse> continuation) throws IOException;
}
