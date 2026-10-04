package com.survicate.surveys.infrastructure.network.p038ai;

import com.myscript.nebo.LaunchActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: FollowUpQuestionRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H¦@¢\u0006\u0002\u0010\b¨\u0006\t"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/network/ai/FollowUpQuestionRepository;", "", "requestFollowUpQuestion", "", "dialogs", "", "Lcom/survicate/surveys/infrastructure/network/ai/FollowUpDialog;", LaunchActivity.LaunchRoute.Language, "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface FollowUpQuestionRepository {
    Object requestFollowUpQuestion(List<FollowUpDialog> list, String str, Continuation<? super String> continuation);
}
