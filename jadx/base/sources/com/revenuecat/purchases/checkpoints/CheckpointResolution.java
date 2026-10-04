package com.revenuecat.purchases.checkpoints;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointResolution.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointResolution;", "", "()V", "MatchedOffering", "MatchedWorkflow", "NoAction", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedOffering;", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$NoAction;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class CheckpointResolution {
    public /* synthetic */ CheckpointResolution(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CheckpointResolution() {
    }

    /* JADX INFO: compiled from: CheckpointResolution.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedOffering;", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution;", "offering", "Lcom/revenuecat/purchases/Offering;", "(Lcom/revenuecat/purchases/Offering;)V", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class MatchedOffering extends CheckpointResolution {
        private final Offering offering;

        public static /* synthetic */ MatchedOffering copy$default(MatchedOffering matchedOffering, Offering offering, int i, Object obj) {
            if ((i & 1) != 0) {
                offering = matchedOffering.offering;
            }
            return matchedOffering.copy(offering);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Offering getOffering() {
            return this.offering;
        }

        public final MatchedOffering copy(Offering offering) {
            Intrinsics.checkNotNullParameter(offering, "offering");
            return new MatchedOffering(offering);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof MatchedOffering) && Intrinsics.areEqual(this.offering, ((MatchedOffering) other).offering);
        }

        public int hashCode() {
            return this.offering.hashCode();
        }

        public String toString() {
            return "MatchedOffering(offering=" + this.offering + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MatchedOffering(Offering offering) {
            super(null);
            Intrinsics.checkNotNullParameter(offering, "offering");
            this.offering = offering;
        }

        public final Offering getOffering() {
            return this.offering;
        }
    }

    /* JADX INFO: compiled from: CheckpointResolution.kt */
    @Metadata(m1598d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$MatchedWorkflow;", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution;", Keys.WORKFLOW, "Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "uiConfig", "Lcom/revenuecat/purchases/UiConfig;", "offering", "Lcom/revenuecat/purchases/Offering;", "(Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;Lcom/revenuecat/purchases/UiConfig;Lcom/revenuecat/purchases/Offering;)V", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "getUiConfig", "()Lcom/revenuecat/purchases/UiConfig;", "getWorkflow", "()Lcom/revenuecat/purchases/common/workflows/PublishedWorkflow;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class MatchedWorkflow extends CheckpointResolution {
        private final Offering offering;
        private final UiConfig uiConfig;
        private final PublishedWorkflow workflow;

        public static /* synthetic */ MatchedWorkflow copy$default(MatchedWorkflow matchedWorkflow, PublishedWorkflow publishedWorkflow, UiConfig uiConfig, Offering offering, int i, Object obj) {
            if ((i & 1) != 0) {
                publishedWorkflow = matchedWorkflow.workflow;
            }
            if ((i & 2) != 0) {
                uiConfig = matchedWorkflow.uiConfig;
            }
            if ((i & 4) != 0) {
                offering = matchedWorkflow.offering;
            }
            return matchedWorkflow.copy(publishedWorkflow, uiConfig, offering);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final PublishedWorkflow getWorkflow() {
            return this.workflow;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final UiConfig getUiConfig() {
            return this.uiConfig;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Offering getOffering() {
            return this.offering;
        }

        public final MatchedWorkflow copy(PublishedWorkflow workflow, UiConfig uiConfig, Offering offering) {
            Intrinsics.checkNotNullParameter(workflow, "workflow");
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            Intrinsics.checkNotNullParameter(offering, "offering");
            return new MatchedWorkflow(workflow, uiConfig, offering);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MatchedWorkflow)) {
                return false;
            }
            MatchedWorkflow matchedWorkflow = (MatchedWorkflow) other;
            return Intrinsics.areEqual(this.workflow, matchedWorkflow.workflow) && Intrinsics.areEqual(this.uiConfig, matchedWorkflow.uiConfig) && Intrinsics.areEqual(this.offering, matchedWorkflow.offering);
        }

        public int hashCode() {
            return (((this.workflow.hashCode() * 31) + this.uiConfig.hashCode()) * 31) + this.offering.hashCode();
        }

        public String toString() {
            return "MatchedWorkflow(workflow=" + this.workflow + ", uiConfig=" + this.uiConfig + ", offering=" + this.offering + ')';
        }

        public final PublishedWorkflow getWorkflow() {
            return this.workflow;
        }

        public final UiConfig getUiConfig() {
            return this.uiConfig;
        }

        public final Offering getOffering() {
            return this.offering;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MatchedWorkflow(PublishedWorkflow workflow, UiConfig uiConfig, Offering offering) {
            super(null);
            Intrinsics.checkNotNullParameter(workflow, "workflow");
            Intrinsics.checkNotNullParameter(uiConfig, "uiConfig");
            Intrinsics.checkNotNullParameter(offering, "offering");
            this.workflow = workflow;
            this.uiConfig = uiConfig;
            this.offering = offering;
        }
    }

    /* JADX INFO: compiled from: CheckpointResolution.kt */
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$NoAction;", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution;", "reason", "Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$NoAction$Reason;", "(Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$NoAction$Reason;)V", "getReason", "()Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$NoAction$Reason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Reason", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class NoAction extends CheckpointResolution {
        private final Reason reason;

        /* JADX INFO: compiled from: CheckpointResolution.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/checkpoints/CheckpointResolution$NoAction$Reason;", "", "(Ljava/lang/String;I)V", "NO_MATCH", "CONFIGURATION_UNAVAILABLE", "UNKNOWN_CHECKPOINT", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public enum Reason {
            NO_MATCH,
            CONFIGURATION_UNAVAILABLE,
            UNKNOWN_CHECKPOINT
        }

        public static /* synthetic */ NoAction copy$default(NoAction noAction, Reason reason, int i, Object obj) {
            if ((i & 1) != 0) {
                reason = noAction.reason;
            }
            return noAction.copy(reason);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Reason getReason() {
            return this.reason;
        }

        public final NoAction copy(Reason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new NoAction(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NoAction) && this.reason == ((NoAction) other).reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "NoAction(reason=" + this.reason + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoAction(Reason reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final Reason getReason() {
            return this.reason;
        }
    }
}
