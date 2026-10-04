package com.revenuecat.purchases.p036ui.revenuecatui.components;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoadedWorkflowPaywall.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowHeaderPresentation;", "", "headerStepId", "", "role", "Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowHeaderTransitionRole;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowHeaderTransitionRole;)V", "getHeaderStepId", "()Ljava/lang/String;", "getRole", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowHeaderTransitionRole;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class WorkflowHeaderPresentation {
    public static final int $stable = 0;
    private final String headerStepId;
    private final WorkflowHeaderTransitionRole role;

    public static /* synthetic */ WorkflowHeaderPresentation copy$default(WorkflowHeaderPresentation workflowHeaderPresentation, String str, WorkflowHeaderTransitionRole workflowHeaderTransitionRole, int i, Object obj) {
        if ((i & 1) != 0) {
            str = workflowHeaderPresentation.headerStepId;
        }
        if ((i & 2) != 0) {
            workflowHeaderTransitionRole = workflowHeaderPresentation.role;
        }
        return workflowHeaderPresentation.copy(str, workflowHeaderTransitionRole);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHeaderStepId() {
        return this.headerStepId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final WorkflowHeaderTransitionRole getRole() {
        return this.role;
    }

    public final WorkflowHeaderPresentation copy(String headerStepId, WorkflowHeaderTransitionRole role) {
        Intrinsics.checkNotNullParameter(headerStepId, "headerStepId");
        Intrinsics.checkNotNullParameter(role, "role");
        return new WorkflowHeaderPresentation(headerStepId, role);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowHeaderPresentation)) {
            return false;
        }
        WorkflowHeaderPresentation workflowHeaderPresentation = (WorkflowHeaderPresentation) other;
        return Intrinsics.areEqual(this.headerStepId, workflowHeaderPresentation.headerStepId) && this.role == workflowHeaderPresentation.role;
    }

    public int hashCode() {
        return (this.headerStepId.hashCode() * 31) + this.role.hashCode();
    }

    public String toString() {
        return "WorkflowHeaderPresentation(headerStepId=" + this.headerStepId + ", role=" + this.role + ')';
    }

    public WorkflowHeaderPresentation(String headerStepId, WorkflowHeaderTransitionRole role) {
        Intrinsics.checkNotNullParameter(headerStepId, "headerStepId");
        Intrinsics.checkNotNullParameter(role, "role");
        this.headerStepId = headerStepId;
        this.role = role;
    }

    public final String getHeaderStepId() {
        return this.headerStepId;
    }

    public final WorkflowHeaderTransitionRole getRole() {
        return this.role;
    }
}
