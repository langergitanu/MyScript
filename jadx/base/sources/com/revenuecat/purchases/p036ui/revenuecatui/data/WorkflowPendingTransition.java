package com.revenuecat.purchases.p036ui.revenuecatui.data;

import com.revenuecat.purchases.p036ui.revenuecatui.workflow.NavigationDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowPaywallUiState.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowPendingTransition;", "", "fromStepId", "", "direction", "Lcom/revenuecat/purchases/ui/revenuecatui/workflow/NavigationDirection;", "id", "", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/workflow/NavigationDirection;I)V", "getDirection", "()Lcom/revenuecat/purchases/ui/revenuecatui/workflow/NavigationDirection;", "getFromStepId", "()Ljava/lang/String;", "getId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class WorkflowPendingTransition {
    public static final int $stable = 0;
    private final NavigationDirection direction;
    private final String fromStepId;
    private final int id;

    public static /* synthetic */ WorkflowPendingTransition copy$default(WorkflowPendingTransition workflowPendingTransition, String str, NavigationDirection navigationDirection, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = workflowPendingTransition.fromStepId;
        }
        if ((i2 & 2) != 0) {
            navigationDirection = workflowPendingTransition.direction;
        }
        if ((i2 & 4) != 0) {
            i = workflowPendingTransition.id;
        }
        return workflowPendingTransition.copy(str, navigationDirection, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFromStepId() {
        return this.fromStepId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final NavigationDirection getDirection() {
        return this.direction;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final WorkflowPendingTransition copy(String fromStepId, NavigationDirection direction, int id) {
        Intrinsics.checkNotNullParameter(fromStepId, "fromStepId");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new WorkflowPendingTransition(fromStepId, direction, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowPendingTransition)) {
            return false;
        }
        WorkflowPendingTransition workflowPendingTransition = (WorkflowPendingTransition) other;
        return Intrinsics.areEqual(this.fromStepId, workflowPendingTransition.fromStepId) && this.direction == workflowPendingTransition.direction && this.id == workflowPendingTransition.id;
    }

    public int hashCode() {
        return (((this.fromStepId.hashCode() * 31) + this.direction.hashCode()) * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        return "WorkflowPendingTransition(fromStepId=" + this.fromStepId + ", direction=" + this.direction + ", id=" + this.id + ')';
    }

    public WorkflowPendingTransition(String fromStepId, NavigationDirection direction, int i) {
        Intrinsics.checkNotNullParameter(fromStepId, "fromStepId");
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.fromStepId = fromStepId;
        this.direction = direction;
        this.id = i;
    }

    public final String getFromStepId() {
        return this.fromStepId;
    }

    public final NavigationDirection getDirection() {
        return this.direction;
    }

    public final int getId() {
        return this.id;
    }
}
