package com.revenuecat.purchases.common.workflows;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkflowResolution.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "", "()V", "Found", "NoWorkflow", "Unavailable", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution$Found;", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution$NoWorkflow;", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution$Unavailable;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class WorkflowResolution {
    public /* synthetic */ WorkflowResolution(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private WorkflowResolution() {
    }

    /* JADX INFO: compiled from: WorkflowResolution.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowResolution$Found;", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "workflowId", "", "(Ljava/lang/String;)V", "getWorkflowId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class Found extends WorkflowResolution {
        private final String workflowId;

        public static /* synthetic */ Found copy$default(Found found, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = found.workflowId;
            }
            return found.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getWorkflowId() {
            return this.workflowId;
        }

        public final Found copy(String workflowId) {
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            return new Found(workflowId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Found) && Intrinsics.areEqual(this.workflowId, ((Found) other).workflowId);
        }

        public int hashCode() {
            return this.workflowId.hashCode();
        }

        public String toString() {
            return "Found(workflowId=" + this.workflowId + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Found(String workflowId) {
            super(null);
            Intrinsics.checkNotNullParameter(workflowId, "workflowId");
            this.workflowId = workflowId;
        }

        public final String getWorkflowId() {
            return this.workflowId;
        }
    }

    /* JADX INFO: compiled from: WorkflowResolution.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowResolution$NoWorkflow;", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class NoWorkflow extends WorkflowResolution {
        public static final NoWorkflow INSTANCE = new NoWorkflow();

        private NoWorkflow() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: WorkflowResolution.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/common/workflows/WorkflowResolution$Unavailable;", "Lcom/revenuecat/purchases/common/workflows/WorkflowResolution;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Unavailable extends WorkflowResolution {
        public static final Unavailable INSTANCE = new Unavailable();

        private Unavailable() {
            super(null);
        }
    }
}
