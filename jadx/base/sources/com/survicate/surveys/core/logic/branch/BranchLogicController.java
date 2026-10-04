package com.survicate.surveys.core.logic.branch;

import com.survicate.surveys.core.logic.display.models.QuestionAnswered;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BranchLogicController.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m1599d2 = {"Lcom/survicate/surveys/core/logic/branch/BranchLogicController;", "", "<init>", "()V", "resolveNextPointId", "", "answer", "Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;", "rules", "", "Lcom/survicate/surveys/core/logic/branch/BranchLogic;", "(Lcom/survicate/surveys/core/logic/display/models/QuestionAnswered;Ljava/util/List;)Ljava/lang/Long;", "shared_release"}, m1600k = 1, m1601mv = {2, 1, 0}, m1603xi = 48)
public final class BranchLogicController {
    public static final BranchLogicController INSTANCE = new BranchLogicController();

    private BranchLogicController() {
    }

    public final Long resolveNextPointId(QuestionAnswered answer, List<? extends BranchLogic> rules) {
        Object next;
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(rules, "rules");
        Iterator it = CollectionsKt.sortedWith(rules, new Comparator() { // from class: com.survicate.surveys.core.logic.branch.BranchLogicController$resolveNextPointId$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((BranchLogic) t).getOrderNumber()), Integer.valueOf(((BranchLogic) t2).getOrderNumber()));
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((BranchLogic) next).isSatisfiedBy(answer)) {
                break;
            }
        }
        BranchLogic branchLogic = (BranchLogic) next;
        if (branchLogic != null) {
            return Long.valueOf(branchLogic.getGoTo());
        }
        return null;
    }
}
