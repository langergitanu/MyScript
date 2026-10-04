package com.survicate.surveys.core.logic.display.models;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.core.logic.display.DisplayLogic;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QuestionSuggestion.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¨\u0006\u0006"}, m1599d2 = {"isSatisfiedBy", "", "Lcom/survicate/surveys/core/logic/display/models/QuestionSuggestion;", "answers", "", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "shared_release"}, m1600k = 2, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class QuestionSuggestionKt {

    /* JADX INFO: compiled from: QuestionSuggestion.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 1, 0}, m1603xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AndOrOperator.values().length];
            try {
                iArr[AndOrOperator.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AndOrOperator.f2260OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isSatisfiedBy(QuestionSuggestion questionSuggestion, List<? extends QuestionAnswered> answers) {
        Intrinsics.checkNotNullParameter(questionSuggestion, "<this>");
        Intrinsics.checkNotNullParameter(answers, "answers");
        if (questionSuggestion.getDisplayLogic().isEmpty()) {
            return true;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[questionSuggestion.getDisplayLogicOperator().ordinal()];
        if (i == 1) {
            List<DisplayLogic> displayLogic = questionSuggestion.getDisplayLogic();
            if ((displayLogic instanceof Collection) && displayLogic.isEmpty()) {
                return true;
            }
            for (DisplayLogic displayLogic2 : displayLogic) {
                List<? extends QuestionAnswered> list = answers;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (QuestionAnswered questionAnswered : list) {
                        if (questionAnswered.getPointId() != displayLogic2.getPointId() || !displayLogic2.isSatisfied(questionAnswered)) {
                        }
                    }
                }
                return false;
            }
            return true;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        List<DisplayLogic> displayLogic3 = questionSuggestion.getDisplayLogic();
        if ((displayLogic3 instanceof Collection) && displayLogic3.isEmpty()) {
            return false;
        }
        for (DisplayLogic displayLogic4 : displayLogic3) {
            List<? extends QuestionAnswered> list2 = answers;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                for (QuestionAnswered questionAnswered2 : list2) {
                    if (questionAnswered2.getPointId() == displayLogic4.getPointId() && displayLogic4.isSatisfied(questionAnswered2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
