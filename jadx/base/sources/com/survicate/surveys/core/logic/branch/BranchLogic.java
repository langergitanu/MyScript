package com.survicate.surveys.core.logic.branch;

import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BranchLogic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/BranchLogic;", "", "<init>", "()V", "orderNumber", "", "getOrderNumber", "()I", "goTo", "", "getGoTo", "()J", "isSatisfiedBy", "", "answer", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "Lcom/survicate/surveys/core/logic/branch/DateBranchLogic;", "Lcom/survicate/surveys/core/logic/branch/FormBranchLogic;", "Lcom/survicate/surveys/core/logic/branch/MatrixBranchLogic;", "Lcom/survicate/surveys/core/logic/branch/MultipleChoiceBranchLogic;", "Lcom/survicate/surveys/core/logic/branch/RangeBranchLogic;", "Lcom/survicate/surveys/core/logic/branch/SingleChoiceBranchLogic;", "Lcom/survicate/surveys/core/logic/branch/TextBranchLogic;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public abstract class BranchLogic {
    public /* synthetic */ BranchLogic(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract long getGoTo();

    public abstract int getOrderNumber();

    public abstract boolean isSatisfiedBy(QuestionAnswered answer);

    private BranchLogic() {
    }
}
