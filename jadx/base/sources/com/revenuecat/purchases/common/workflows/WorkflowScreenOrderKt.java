package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.common.workflows.WorkflowTriggerAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowScreenOrder.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0002\u001a\u0012\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001*\u00020\u0006H\u0000¨\u0006\u0007"}, m1599d2 = {"nextStepIds", "", "", "Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "screensInVisitOrder", "Lcom/revenuecat/purchases/common/workflows/WorkflowScreen;", "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WorkflowScreenOrderKt {
    public static final List<WorkflowScreen> screensInVisitOrder(PublishedWorkflow publishedWorkflow) {
        Intrinsics.checkNotNullParameter(publishedWorkflow, "<this>");
        Set ofNotNull = SetsKt.setOfNotNull((Object[]) new String[]{publishedWorkflow.getInitialStepId(), publishedWorkflow.getSingleStepFallbackId()});
        Set mutableSet = CollectionsKt.toMutableSet(ofNotNull);
        ArrayDeque arrayDeque = new ArrayDeque(ofNotNull);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (!arrayDeque.isEmpty()) {
            WorkflowStep workflowStep = publishedWorkflow.getSteps().get(arrayDeque.removeFirst());
            if (workflowStep != null) {
                String screenId = workflowStep.getScreenId();
                if (screenId != null) {
                    linkedHashSet.add(screenId);
                }
                for (String str : nextStepIds(workflowStep)) {
                    if (mutableSet.add(str)) {
                        arrayDeque.addLast(str);
                    }
                }
            }
        }
        Set setPlus = SetsKt.plus((Set) linkedHashSet, (Iterable) publishedWorkflow.getScreens().keySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = setPlus.iterator();
        while (it.hasNext()) {
            WorkflowScreen workflowScreen = publishedWorkflow.getScreens().get((String) it.next());
            if (workflowScreen != null) {
                arrayList.add(workflowScreen);
            }
        }
        return arrayList;
    }

    private static final List<String> nextStepIds(WorkflowStep workflowStep) {
        List<WorkflowTrigger> triggers = workflowStep.getTriggers();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(triggers, 10));
        Iterator<T> it = triggers.iterator();
        while (it.hasNext()) {
            arrayList.add(((WorkflowTrigger) it.next()).getActionId());
        }
        List listPlus = CollectionsKt.plus((Collection) arrayList, (Iterable) workflowStep.getTriggerActions().keySet());
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = listPlus.iterator();
        while (it2.hasNext()) {
            WorkflowTriggerAction workflowTriggerAction = workflowStep.getTriggerActions().get((String) it2.next());
            WorkflowTriggerAction.Step step = workflowTriggerAction instanceof WorkflowTriggerAction.Step ? (WorkflowTriggerAction.Step) workflowTriggerAction : null;
            String stepId = step != null ? step.getStepId() : null;
            if (stepId != null) {
                arrayList2.add(stepId);
            }
        }
        return arrayList2;
    }
}
