package com.revenuecat.purchases.p036ui.revenuecatui.data;

import com.revenuecat.purchases.p036ui.revenuecatui.data.PaywallState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowPaywallUiState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPaywallUiState;", "", "currentStepId", "", "stepStates", "", "Lcom/revenuecat/purchases/ui/revenuecatui/data/PaywallState$Loaded$Components;", "pendingTransition", "Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPendingTransition;", "(Ljava/lang/String;Ljava/util/Map;Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPendingTransition;)V", "getCurrentStepId", "()Ljava/lang/String;", "getPendingTransition", "()Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPendingTransition;", "getStepStates", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class WorkflowPaywallUiState {
    public static final int $stable = 0;
    private final String currentStepId;
    private final WorkflowPendingTransition pendingTransition;
    private final Map<String, PaywallState.Loaded.Components> stepStates;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkflowPaywallUiState copy$default(WorkflowPaywallUiState workflowPaywallUiState, String str, Map map, WorkflowPendingTransition workflowPendingTransition, int i, Object obj) {
        if ((i & 1) != 0) {
            str = workflowPaywallUiState.currentStepId;
        }
        if ((i & 2) != 0) {
            map = workflowPaywallUiState.stepStates;
        }
        if ((i & 4) != 0) {
            workflowPendingTransition = workflowPaywallUiState.pendingTransition;
        }
        return workflowPaywallUiState.copy(str, map, workflowPendingTransition);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCurrentStepId() {
        return this.currentStepId;
    }

    public final Map<String, PaywallState.Loaded.Components> component2() {
        return this.stepStates;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WorkflowPendingTransition getPendingTransition() {
        return this.pendingTransition;
    }

    public final WorkflowPaywallUiState copy(String currentStepId, Map<String, PaywallState.Loaded.Components> stepStates, WorkflowPendingTransition pendingTransition) {
        Intrinsics.checkNotNullParameter(currentStepId, "currentStepId");
        Intrinsics.checkNotNullParameter(stepStates, "stepStates");
        return new WorkflowPaywallUiState(currentStepId, stepStates, pendingTransition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowPaywallUiState)) {
            return false;
        }
        WorkflowPaywallUiState workflowPaywallUiState = (WorkflowPaywallUiState) other;
        return Intrinsics.areEqual(this.currentStepId, workflowPaywallUiState.currentStepId) && Intrinsics.areEqual(this.stepStates, workflowPaywallUiState.stepStates) && Intrinsics.areEqual(this.pendingTransition, workflowPaywallUiState.pendingTransition);
    }

    public int hashCode() {
        int iHashCode = ((this.currentStepId.hashCode() * 31) + this.stepStates.hashCode()) * 31;
        WorkflowPendingTransition workflowPendingTransition = this.pendingTransition;
        return iHashCode + (workflowPendingTransition == null ? 0 : workflowPendingTransition.hashCode());
    }

    public String toString() {
        return "WorkflowPaywallUiState(currentStepId=" + this.currentStepId + ", stepStates=" + this.stepStates + ", pendingTransition=" + this.pendingTransition + ')';
    }

    public WorkflowPaywallUiState(String currentStepId, Map<String, PaywallState.Loaded.Components> stepStates, WorkflowPendingTransition workflowPendingTransition) {
        Intrinsics.checkNotNullParameter(currentStepId, "currentStepId");
        Intrinsics.checkNotNullParameter(stepStates, "stepStates");
        this.currentStepId = currentStepId;
        this.stepStates = stepStates;
        this.pendingTransition = workflowPendingTransition;
    }

    public /* synthetic */ WorkflowPaywallUiState(String str, Map map, WorkflowPendingTransition workflowPendingTransition, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? null : workflowPendingTransition);
    }

    public final String getCurrentStepId() {
        return this.currentStepId;
    }

    public final Map<String, PaywallState.Loaded.Components> getStepStates() {
        return this.stepStates;
    }

    public final WorkflowPendingTransition getPendingTransition() {
        return this.pendingTransition;
    }
}
