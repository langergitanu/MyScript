package com.survicate.surveys.infrastructure.storage.interfaces;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SurveyAnswersStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/interfaces/SurveyAnswersStore;", "", "saveAnswer", "", "answer", "Lcom/survicate/surveys/infrastructure/storage/interfaces/QuestionAnswerItem;", "findAnswerBy", "id", "", "getAnswers", "", "clearStore", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public interface SurveyAnswersStore {
    void clearStore();

    QuestionAnswerItem findAnswerBy(long id);

    List<QuestionAnswerItem> getAnswers();

    void saveAnswer(QuestionAnswerItem answer);
}
