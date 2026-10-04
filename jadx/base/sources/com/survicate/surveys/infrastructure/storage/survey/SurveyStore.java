package com.survicate.surveys.infrastructure.storage.survey;

import com.survicate.surveys.infrastructure.storage.interfaces.QuestionAnswerItem;
import com.survicate.surveys.infrastructure.storage.interfaces.SurveyAnswersStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurveyStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m1599d2 = {"Lcom/survicate/surveys/infrastructure/storage/survey/SurveyStore;", "Lcom/survicate/surveys/infrastructure/storage/interfaces/SurveyAnswersStore;", "<init>", "()V", "answers", "", "Lcom/survicate/surveys/infrastructure/storage/interfaces/QuestionAnswerItem;", "saveAnswer", "", "answer", "findAnswerBy", "id", "", "getAnswers", "clearStore", "survicate-sdk_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class SurveyStore implements SurveyAnswersStore {
    private List<QuestionAnswerItem> answers = CollectionsKt.emptyList();

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.SurveyAnswersStore
    public void saveAnswer(QuestionAnswerItem answer) {
        Intrinsics.checkNotNullParameter(answer, "answer");
        List<QuestionAnswerItem> list = this.answers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((QuestionAnswerItem) obj).getSurveyPointId() != answer.getSurveyPointId()) {
                arrayList.add(obj);
            }
        }
        this.answers = CollectionsKt.plus((Collection<? extends QuestionAnswerItem>) arrayList, answer);
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.SurveyAnswersStore
    public QuestionAnswerItem findAnswerBy(long id) {
        Object next;
        Iterator<T> it = this.answers.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((QuestionAnswerItem) next).getSurveyPointId() == id) {
                break;
            }
        }
        return (QuestionAnswerItem) next;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.SurveyAnswersStore
    public List<QuestionAnswerItem> getAnswers() {
        return this.answers;
    }

    @Override // com.survicate.surveys.infrastructure.storage.interfaces.SurveyAnswersStore
    public void clearStore() {
        this.answers = CollectionsKt.emptyList();
    }
}
