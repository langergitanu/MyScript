package com.survicate.surveys.core.logic.display;

import com.survicate.surveys.core.logic.core.AndOrOperator;
import com.survicate.surveys.core.logic.display.groups.DisplayLogicGroup;
import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DisplayLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0007\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/display/DisplayLogic;", "", "<init>", "()V", "pointId", "", "getPointId", "()J", "groups", "", "Lcom/survicate/surveys/core/logic/display/groups/DisplayLogicGroup;", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "getGroups", "()Ljava/util/List;", "groupOperator", "Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "getGroupOperator", "()Lcom/survicate/surveys/core/logic/core/AndOrOperator;", "isSatisfied", "", "providedAnswer", "Lcom/survicate/surveys/core/logic/display/DateDisplayLogic;", "Lcom/survicate/surveys/core/logic/display/FormDisplayLogic;", "Lcom/survicate/surveys/core/logic/display/MatrixDisplayLogic;", "Lcom/survicate/surveys/core/logic/display/MultipleChoiceDisplayLogic;", "Lcom/survicate/surveys/core/logic/display/RangeDisplayLogic;", "Lcom/survicate/surveys/core/logic/display/SingleChoiceDisplayLogic;", "Lcom/survicate/surveys/core/logic/display/TextDisplayLogic;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class DisplayLogic {
    public /* synthetic */ DisplayLogic(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract AndOrOperator getGroupOperator();

    public abstract List<DisplayLogicGroup<? extends QuestionAnswered>> getGroups();

    public abstract long getPointId();

    public abstract boolean isSatisfied(QuestionAnswered providedAnswer);

    private DisplayLogic() {
    }
}
