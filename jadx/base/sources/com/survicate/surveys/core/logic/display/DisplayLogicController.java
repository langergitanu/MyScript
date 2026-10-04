package com.survicate.surveys.core.logic.display;

import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import com.survicate.surveys.core.logic.display.models.QuestionSuggestion;
import com.survicate.surveys.core.logic.display.models.QuestionSuggestionKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DisplayLogicController.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/DisplayLogicController;", "", "<init>", "()V", "resolveNextPointId", "", "answers", "", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "suggestedQuestions", "Lcom/survicate/surveys/core/logic/display/models/QuestionSuggestion;", "(Ljava/util/List;Ljava/util/List;)Ljava/lang/Long;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class DisplayLogicController {
    public static final DisplayLogicController INSTANCE = new DisplayLogicController();

    private DisplayLogicController() {
    }

    public final Long resolveNextPointId(List<? extends QuestionAnswered> answers, List<QuestionSuggestion> suggestedQuestions) {
        Object next;
        Intrinsics.checkNotNullParameter(answers, "answers");
        Intrinsics.checkNotNullParameter(suggestedQuestions, "suggestedQuestions");
        Iterator<T> it = suggestedQuestions.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (QuestionSuggestionKt.isSatisfiedBy((QuestionSuggestion) next, answers)) {
                break;
            }
        }
        QuestionSuggestion questionSuggestion = (QuestionSuggestion) next;
        if (questionSuggestion != null) {
            return Long.valueOf(questionSuggestion.getQuestionId());
        }
        return null;
    }
}
