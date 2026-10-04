package com.revenuecat.purchases.p036ui.revenuecatui.components;

import kotlin.Metadata;

/* JADX INFO: compiled from: LoadedWorkflowPaywall.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/WorkflowHeaderStepInfo;", "", "hasHeroImage", "", "hasHeader", "(ZZ)V", "getHasHeader", "()Z", "getHasHeroImage", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final /* data */ class WorkflowHeaderStepInfo {
    public static final int $stable = 0;
    private final boolean hasHeader;
    private final boolean hasHeroImage;

    public static /* synthetic */ WorkflowHeaderStepInfo copy$default(WorkflowHeaderStepInfo workflowHeaderStepInfo, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = workflowHeaderStepInfo.hasHeroImage;
        }
        if ((i & 2) != 0) {
            z2 = workflowHeaderStepInfo.hasHeader;
        }
        return workflowHeaderStepInfo.copy(z, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasHeroImage() {
        return this.hasHeroImage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getHasHeader() {
        return this.hasHeader;
    }

    public final WorkflowHeaderStepInfo copy(boolean hasHeroImage, boolean hasHeader) {
        return new WorkflowHeaderStepInfo(hasHeroImage, hasHeader);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WorkflowHeaderStepInfo)) {
            return false;
        }
        WorkflowHeaderStepInfo workflowHeaderStepInfo = (WorkflowHeaderStepInfo) other;
        return this.hasHeroImage == workflowHeaderStepInfo.hasHeroImage && this.hasHeader == workflowHeaderStepInfo.hasHeader;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.hasHeroImage) * 31) + Boolean.hashCode(this.hasHeader);
    }

    public String toString() {
        return "WorkflowHeaderStepInfo(hasHeroImage=" + this.hasHeroImage + ", hasHeader=" + this.hasHeader + ')';
    }

    public WorkflowHeaderStepInfo(boolean z, boolean z2) {
        this.hasHeroImage = z;
        this.hasHeader = z2;
    }

    public final boolean getHasHeroImage() {
        return this.hasHeroImage;
    }

    public final boolean getHasHeader() {
        return this.hasHeader;
    }
}
