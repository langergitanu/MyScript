package com.revenuecat.purchases.p036ui.revenuecatui.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowScreenContext.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/data/WorkflowScreenContext;", "", "workflowId", "", "stepId", "stepType", "screenType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getScreenType", "()Ljava/util/List;", "getStepId", "()Ljava/lang/String;", "getStepType", "getWorkflowId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class WorkflowScreenContext {
    public static final int $stable = 8;
    private final List<String> screenType;
    private final String stepId;
    private final String stepType;
    private final String workflowId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WorkflowScreenContext copy$default(WorkflowScreenContext workflowScreenContext, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = workflowScreenContext.workflowId;
        }
        if ((i & 2) != 0) {
            str2 = workflowScreenContext.stepId;
        }
        if ((i & 4) != 0) {
            str3 = workflowScreenContext.stepType;
        }
        if ((i & 8) != 0) {
            list = workflowScreenContext.screenType;
        }
        return workflowScreenContext.copy(str, str2, str3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getWorkflowId() {
        return this.workflowId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getStepId() {
        return this.stepId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getStepType() {
        return this.stepType;
    }

    public final List<String> component4() {
        return this.screenType;
    }

    public final WorkflowScreenContext copy(String workflowId, String stepId, String stepType, List<String> screenType) {
        Intrinsics.checkNotNullParameter(workflowId, "workflowId");
        Intrinsics.checkNotNullParameter(stepId, "stepId");
        Intrinsics.checkNotNullParameter(stepType, "stepType");
        return new WorkflowScreenContext(workflowId, stepId, stepType, screenType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowScreenContext)) {
            return false;
        }
        WorkflowScreenContext workflowScreenContext = (WorkflowScreenContext) other;
        return Intrinsics.areEqual(this.workflowId, workflowScreenContext.workflowId) && Intrinsics.areEqual(this.stepId, workflowScreenContext.stepId) && Intrinsics.areEqual(this.stepType, workflowScreenContext.stepType) && Intrinsics.areEqual(this.screenType, workflowScreenContext.screenType);
    }

    public int hashCode() {
        int iHashCode = ((((this.workflowId.hashCode() * 31) + this.stepId.hashCode()) * 31) + this.stepType.hashCode()) * 31;
        List<String> list = this.screenType;
        return iHashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "WorkflowScreenContext(workflowId=" + this.workflowId + ", stepId=" + this.stepId + ", stepType=" + this.stepType + ", screenType=" + this.screenType + ')';
    }

    public WorkflowScreenContext(String workflowId, String stepId, String stepType, List<String> list) {
        Intrinsics.checkNotNullParameter(workflowId, "workflowId");
        Intrinsics.checkNotNullParameter(stepId, "stepId");
        Intrinsics.checkNotNullParameter(stepType, "stepType");
        this.workflowId = workflowId;
        this.stepId = stepId;
        this.stepType = stepType;
        this.screenType = list;
    }

    public final String getWorkflowId() {
        return this.workflowId;
    }

    public final String getStepId() {
        return this.stepId;
    }

    public final String getStepType() {
        return this.stepType;
    }

    public final List<String> getScreenType() {
        return this.screenType;
    }
}
