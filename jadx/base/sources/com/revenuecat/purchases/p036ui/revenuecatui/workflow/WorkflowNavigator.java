package com.revenuecat.purchases.p036ui.revenuecatui.workflow;

import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowStep;
import com.revenuecat.purchases.common.workflows.WorkflowTrigger;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerAction;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowNavigator.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/workflow/WorkflowNavigator;", "", Keys.WORKFLOW, "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "(Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;)V", "backStack", "Lkotlin/collections/ArrayDeque;", "", "backStackSnapshot", "", "getBackStackSnapshot", "()Ljava/util/List;", "canNavigateBack", "", "getCanNavigateBack", "()Z", "currentStep", "Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "getCurrentStep", "()Lcom/revenuecat/purchases/common/workflows/WorkflowStep;", "currentStepId", "peekBackStep", "getPeekBackStep", "navigateBack", "peekTriggerStep", "componentId", "triggerType", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "triggerAction", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class WorkflowNavigator {
    public static final int $stable = 8;
    private final ArrayDeque<String> backStack;
    private String currentStepId;
    private final PublishedWorkflow workflow;

    public WorkflowNavigator(PublishedWorkflow workflow) {
        Intrinsics.checkNotNullParameter(workflow, "workflow");
        this.workflow = workflow;
        this.currentStepId = workflow.getInitialStepId();
        this.backStack = new ArrayDeque<>();
    }

    public final List<String> getBackStackSnapshot() {
        return CollectionsKt.toList(this.backStack);
    }

    public final WorkflowStep getCurrentStep() {
        return this.workflow.getSteps().get(this.currentStepId);
    }

    public final WorkflowStep peekTriggerStep(String componentId, WorkflowTriggerType triggerType) {
        Object next;
        WorkflowTriggerAction workflowTriggerAction;
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        WorkflowStep currentStep = getCurrentStep();
        if (currentStep == null) {
            return null;
        }
        Iterator<T> it = currentStep.getTriggers().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            WorkflowTrigger workflowTrigger = (WorkflowTrigger) next;
            if (Intrinsics.areEqual(workflowTrigger.getComponentId(), componentId) && workflowTrigger.getType() == triggerType) {
                break;
            }
        }
        WorkflowTrigger workflowTrigger2 = (WorkflowTrigger) next;
        if (workflowTrigger2 == null || (workflowTriggerAction = currentStep.getTriggerActions().get(workflowTrigger2.getActionId())) == null || !(workflowTriggerAction instanceof WorkflowTriggerAction.Step)) {
            return null;
        }
        return this.workflow.getSteps().get(((WorkflowTriggerAction.Step) workflowTriggerAction).getStepId());
    }

    public final WorkflowStep getPeekBackStep() {
        String strLastOrNull = this.backStack.lastOrNull();
        if (strLastOrNull != null) {
            return this.workflow.getSteps().get(strLastOrNull);
        }
        return null;
    }

    public final WorkflowStep triggerAction(String componentId, WorkflowTriggerType triggerType) {
        Object next;
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        WorkflowStep currentStep = getCurrentStep();
        if (currentStep == null) {
            return null;
        }
        Iterator<T> it = currentStep.getTriggers().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            WorkflowTrigger workflowTrigger = (WorkflowTrigger) next;
            if (Intrinsics.areEqual(workflowTrigger.getComponentId(), componentId) && workflowTrigger.getType() == triggerType) {
                break;
            }
        }
        WorkflowTrigger workflowTrigger2 = (WorkflowTrigger) next;
        if (workflowTrigger2 == null) {
            Logger.INSTANCE.m1587w("No trigger found for componentId '" + componentId + "' and type '" + triggerType + "' in step '" + currentStep.getId() + '\'');
            return null;
        }
        WorkflowTriggerAction workflowTriggerAction = currentStep.getTriggerActions().get(workflowTrigger2.getActionId());
        if (workflowTriggerAction == null) {
            Logger.INSTANCE.m1587w("No trigger action found for actionId '" + workflowTrigger2.getActionId() + "' in step '" + currentStep.getId() + '\'');
            return null;
        }
        if (!(workflowTriggerAction instanceof WorkflowTriggerAction.Step)) {
            Logger.INSTANCE.m1587w("Unknown workflow trigger action type for actionId '" + workflowTrigger2.getActionId() + "' — ignoring");
            return null;
        }
        String stepId = ((WorkflowTriggerAction.Step) workflowTriggerAction).getStepId();
        WorkflowStep workflowStep = this.workflow.getSteps().get(stepId);
        if (workflowStep == null) {
            Logger.INSTANCE.m1587w("Step '" + stepId + "' not found in workflow '" + this.workflow.getId() + '\'');
            return null;
        }
        this.backStack.addLast(this.currentStepId);
        this.currentStepId = stepId;
        return workflowStep;
    }

    public final WorkflowStep navigateBack() {
        if (this.backStack.isEmpty()) {
            return null;
        }
        String strRemoveLast = this.backStack.removeLast();
        this.currentStepId = strRemoveLast;
        return this.workflow.getSteps().get(strRemoveLast);
    }

    public final boolean getCanNavigateBack() {
        return !this.backStack.isEmpty();
    }
}
