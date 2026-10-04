package com.revenuecat.purchases.p036ui.revenuecatui.components;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.p036ui.revenuecatui.components.style.ButtonComponentStyle;
import com.revenuecat.purchases.p036ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: PaywallAction.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "", "External", "Internal", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface PaywallAction {

    /* JADX INFO: compiled from: PaywallAction.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "NavigateTo", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public interface Internal extends PaywallAction {

        /* JADX INFO: compiled from: PaywallAction.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal;", FirebaseAnalytics.Param.DESTINATION, "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;)V", "getDestination", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;", HttpHeaders.DESTINATION, "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class NavigateTo implements Internal {
            public static final int $stable = 8;
            private final Destination destination;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NavigateTo) && Intrinsics.areEqual(this.destination, ((NavigateTo) obj).destination);
            }

            public int hashCode() {
                return this.destination.hashCode();
            }

            public String toString() {
                return "NavigateTo(destination=" + this.destination + ')';
            }

            public NavigateTo(Destination destination) {
                Intrinsics.checkNotNullParameter(destination, "destination");
                this.destination = destination;
            }

            /* JADX INFO: compiled from: PaywallAction.kt */
            @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;", "", "Sheet", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination$Sheet;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
            public interface Destination {

                /* JADX INFO: compiled from: PaywallAction.kt */
                @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination$Sheet;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$Internal$NavigateTo$Destination;", "sheet", "Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;)V", "getSheet", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/style/ButtonComponentStyle$Action$NavigateTo$Destination$Sheet;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
                public static final /* data */ class Sheet implements Destination {
                    public static final int $stable = 0;
                    private final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet;

                    public static /* synthetic */ Sheet copy$default(Sheet sheet, ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet2, int i, Object obj) {
                        if ((i & 1) != 0) {
                            sheet2 = sheet.sheet;
                        }
                        return sheet.copy(sheet2);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final ButtonComponentStyle.Action.NavigateTo.Destination.Sheet getSheet() {
                        return this.sheet;
                    }

                    public final Sheet copy(ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet) {
                        Intrinsics.checkNotNullParameter(sheet, "sheet");
                        return new Sheet(sheet);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        return (other instanceof Sheet) && Intrinsics.areEqual(this.sheet, ((Sheet) other).sheet);
                    }

                    public int hashCode() {
                        return this.sheet.hashCode();
                    }

                    public String toString() {
                        return "Sheet(sheet=" + this.sheet + ')';
                    }

                    public Sheet(ButtonComponentStyle.Action.NavigateTo.Destination.Sheet sheet) {
                        Intrinsics.checkNotNullParameter(sheet, "sheet");
                        this.sheet = sheet;
                    }

                    public final /* synthetic */ ButtonComponentStyle.Action.NavigateTo.Destination.Sheet getSheet() {
                        return this.sheet;
                    }
                }
            }

            public final /* synthetic */ Destination getDestination() {
                return this.destination;
            }
        }
    }

    /* JADX INFO: compiled from: PaywallAction.kt */
    @Metadata(m1598d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0007\u0002\u0003\u0004\u0005\u0006\u0007\b\u0082\u0001\u0007\t\n\u000b\f\r\u000e\u000f¨\u0006\u0010À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction;", "CloseWorkflow", "LaunchWebCheckout", "NavigateBack", "NavigateTo", "PurchasePackage", "RestorePurchases", "WorkflowTrigger", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$CloseWorkflow;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateBack;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$PurchasePackage;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$RestorePurchases;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$WorkflowTrigger;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public interface External extends PaywallAction {

        /* JADX INFO: compiled from: PaywallAction.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$RestorePurchases;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "()V", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class RestorePurchases implements External {
            public static final int $stable = 0;
            public static final RestorePurchases INSTANCE = new RestorePurchases();

            private RestorePurchases() {
            }
        }

        /* JADX INFO: compiled from: PaywallAction.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateBack;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "()V", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class NavigateBack implements External {
            public static final int $stable = 0;
            public static final NavigateBack INSTANCE = new NavigateBack();

            private NavigateBack() {
            }
        }

        /* JADX INFO: compiled from: PaywallAction.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$CloseWorkflow;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "()V", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class CloseWorkflow implements External {
            public static final int $stable = 0;
            public static final CloseWorkflow INSTANCE = new CloseWorkflow();

            private CloseWorkflow() {
            }
        }

        /* JADX INFO: compiled from: PaywallAction.kt */
        @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$WorkflowTrigger;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "componentId", "", "triggerType", "Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "(Ljava/lang/String;Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;)V", "getComponentId", "()Ljava/lang/String;", "getTriggerType", "()Lcom/revenuecat/purchases/common/workflows/WorkflowTriggerType;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class WorkflowTrigger implements External {
            public static final int $stable = 0;
            private final String componentId;
            private final WorkflowTriggerType triggerType;

            public static /* synthetic */ WorkflowTrigger copy$default(WorkflowTrigger workflowTrigger, String str, WorkflowTriggerType workflowTriggerType, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = workflowTrigger.componentId;
                }
                if ((i & 2) != 0) {
                    workflowTriggerType = workflowTrigger.triggerType;
                }
                return workflowTrigger.copy(str, workflowTriggerType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getComponentId() {
                return this.componentId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final WorkflowTriggerType getTriggerType() {
                return this.triggerType;
            }

            public final WorkflowTrigger copy(String componentId, WorkflowTriggerType triggerType) {
                Intrinsics.checkNotNullParameter(componentId, "componentId");
                Intrinsics.checkNotNullParameter(triggerType, "triggerType");
                return new WorkflowTrigger(componentId, triggerType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WorkflowTrigger)) {
                    return false;
                }
                WorkflowTrigger workflowTrigger = (WorkflowTrigger) other;
                return Intrinsics.areEqual(this.componentId, workflowTrigger.componentId) && this.triggerType == workflowTrigger.triggerType;
            }

            public int hashCode() {
                return (this.componentId.hashCode() * 31) + this.triggerType.hashCode();
            }

            public String toString() {
                return "WorkflowTrigger(componentId=" + this.componentId + ", triggerType=" + this.triggerType + ')';
            }

            public WorkflowTrigger(String componentId, WorkflowTriggerType triggerType) {
                Intrinsics.checkNotNullParameter(componentId, "componentId");
                Intrinsics.checkNotNullParameter(triggerType, "triggerType");
                this.componentId = componentId;
                this.triggerType = triggerType;
            }

            public final String getComponentId() {
                return this.componentId;
            }

            public final WorkflowTriggerType getTriggerType() {
                return this.triggerType;
            }
        }

        /* JADX INFO: compiled from: PaywallAction.kt */
        @Metadata(m1598d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$PurchasePackage;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "resolvedOffer", "Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "(Lcom/revenuecat/purchases/Package;Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;)V", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "getResolvedOffer", "()Lcom/revenuecat/purchases/ui/revenuecatui/helpers/ResolvedOffer;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class PurchasePackage implements External {
            public static final int $stable = 8;
            private final Package rcPackage;
            private final ResolvedOffer resolvedOffer;

            public static /* synthetic */ PurchasePackage copy$default(PurchasePackage purchasePackage, Package r1, ResolvedOffer resolvedOffer, int i, Object obj) {
                if ((i & 1) != 0) {
                    r1 = purchasePackage.rcPackage;
                }
                if ((i & 2) != 0) {
                    resolvedOffer = purchasePackage.resolvedOffer;
                }
                return purchasePackage.copy(r1, resolvedOffer);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Package getRcPackage() {
                return this.rcPackage;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ResolvedOffer getResolvedOffer() {
                return this.resolvedOffer;
            }

            public final PurchasePackage copy(Package rcPackage, ResolvedOffer resolvedOffer) {
                return new PurchasePackage(rcPackage, resolvedOffer);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PurchasePackage)) {
                    return false;
                }
                PurchasePackage purchasePackage = (PurchasePackage) other;
                return Intrinsics.areEqual(this.rcPackage, purchasePackage.rcPackage) && Intrinsics.areEqual(this.resolvedOffer, purchasePackage.resolvedOffer);
            }

            public int hashCode() {
                Package r0 = this.rcPackage;
                int iHashCode = (r0 == null ? 0 : r0.hashCode()) * 31;
                ResolvedOffer resolvedOffer = this.resolvedOffer;
                return iHashCode + (resolvedOffer != null ? resolvedOffer.hashCode() : 0);
            }

            public String toString() {
                return "PurchasePackage(rcPackage=" + this.rcPackage + ", resolvedOffer=" + this.resolvedOffer + ')';
            }

            public PurchasePackage(Package r1, ResolvedOffer resolvedOffer) {
                this.rcPackage = r1;
                this.resolvedOffer = resolvedOffer;
            }

            public /* synthetic */ PurchasePackage(Package r1, ResolvedOffer resolvedOffer, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(r1, (i & 2) != 0 ? null : resolvedOffer);
            }

            public final Package getRcPackage() {
                return this.rcPackage;
            }

            public final ResolvedOffer getResolvedOffer() {
                return this.resolvedOffer;
            }
        }

        /* JADX INFO: compiled from: PaywallAction.kt */
        @Metadata(m1598d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001!B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", "customUrl", "", "openMethod", "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "autoDismiss", "", "paramBehavior", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior;", "resolvedUrl", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;ZLcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior;Ljava/lang/String;)V", "getAutoDismiss", "()Z", "getCustomUrl", "()Ljava/lang/String;", "getOpenMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getParamBehavior", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior;", "getResolvedUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "ParamBehavior", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final /* data */ class LaunchWebCheckout implements External {
            public static final int $stable = 8;
            private final boolean autoDismiss;
            private final String customUrl;
            private final ButtonComponent.UrlMethod openMethod;
            private final ParamBehavior paramBehavior;
            private final String resolvedUrl;

            public static /* synthetic */ LaunchWebCheckout copy$default(LaunchWebCheckout launchWebCheckout, String str, ButtonComponent.UrlMethod urlMethod, boolean z, ParamBehavior paramBehavior, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = launchWebCheckout.customUrl;
                }
                if ((i & 2) != 0) {
                    urlMethod = launchWebCheckout.openMethod;
                }
                if ((i & 4) != 0) {
                    z = launchWebCheckout.autoDismiss;
                }
                if ((i & 8) != 0) {
                    paramBehavior = launchWebCheckout.paramBehavior;
                }
                if ((i & 16) != 0) {
                    str2 = launchWebCheckout.resolvedUrl;
                }
                String str3 = str2;
                boolean z2 = z;
                return launchWebCheckout.copy(str, urlMethod, z2, paramBehavior, str3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getCustomUrl() {
                return this.customUrl;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final ParamBehavior getParamBehavior() {
                return this.paramBehavior;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getResolvedUrl() {
                return this.resolvedUrl;
            }

            public final LaunchWebCheckout copy(String customUrl, ButtonComponent.UrlMethod openMethod, boolean autoDismiss, ParamBehavior paramBehavior, String resolvedUrl) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                Intrinsics.checkNotNullParameter(paramBehavior, "paramBehavior");
                return new LaunchWebCheckout(customUrl, openMethod, autoDismiss, paramBehavior, resolvedUrl);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LaunchWebCheckout)) {
                    return false;
                }
                LaunchWebCheckout launchWebCheckout = (LaunchWebCheckout) other;
                return Intrinsics.areEqual(this.customUrl, launchWebCheckout.customUrl) && this.openMethod == launchWebCheckout.openMethod && this.autoDismiss == launchWebCheckout.autoDismiss && Intrinsics.areEqual(this.paramBehavior, launchWebCheckout.paramBehavior) && Intrinsics.areEqual(this.resolvedUrl, launchWebCheckout.resolvedUrl);
            }

            public int hashCode() {
                String str = this.customUrl;
                int iHashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.openMethod.hashCode()) * 31) + Boolean.hashCode(this.autoDismiss)) * 31) + this.paramBehavior.hashCode()) * 31;
                String str2 = this.resolvedUrl;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "LaunchWebCheckout(customUrl=" + this.customUrl + ", openMethod=" + this.openMethod + ", autoDismiss=" + this.autoDismiss + ", paramBehavior=" + this.paramBehavior + ", resolvedUrl=" + this.resolvedUrl + ')';
            }

            public LaunchWebCheckout(String str, ButtonComponent.UrlMethod openMethod, boolean z, ParamBehavior paramBehavior, String str2) {
                Intrinsics.checkNotNullParameter(openMethod, "openMethod");
                Intrinsics.checkNotNullParameter(paramBehavior, "paramBehavior");
                this.customUrl = str;
                this.openMethod = openMethod;
                this.autoDismiss = z;
                this.paramBehavior = paramBehavior;
                this.resolvedUrl = str2;
            }

            public /* synthetic */ LaunchWebCheckout(String str, ButtonComponent.UrlMethod urlMethod, boolean z, ParamBehavior paramBehavior, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, urlMethod, z, paramBehavior, (i & 16) != 0 ? null : str2);
            }

            public final String getCustomUrl() {
                return this.customUrl;
            }

            public final ButtonComponent.UrlMethod getOpenMethod() {
                return this.openMethod;
            }

            public final boolean getAutoDismiss() {
                return this.autoDismiss;
            }

            public final ParamBehavior getParamBehavior() {
                return this.paramBehavior;
            }

            public final String getResolvedUrl() {
                return this.resolvedUrl;
            }

            /* JADX INFO: compiled from: PaywallAction.kt */
            @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior;", "", "Append", "DoNotAppend", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior$Append;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior$DoNotAppend;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
            public interface ParamBehavior {

                /* JADX INFO: compiled from: PaywallAction.kt */
                @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior$Append;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior;", "rcPackage", "Lcom/revenuecat/purchases/Package;", "packageParam", "", "appUserIdParam", "envParam", "(Lcom/revenuecat/purchases/Package;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppUserIdParam", "()Ljava/lang/String;", "getEnvParam", "getPackageParam", "getRcPackage", "()Lcom/revenuecat/purchases/Package;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
                public static final /* data */ class Append implements ParamBehavior {
                    public static final int $stable = 8;
                    private final String appUserIdParam;
                    private final String envParam;
                    private final String packageParam;
                    private final Package rcPackage;

                    public static /* synthetic */ Append copy$default(Append append, Package r1, String str, String str2, String str3, int i, Object obj) {
                        if ((i & 1) != 0) {
                            r1 = append.rcPackage;
                        }
                        if ((i & 2) != 0) {
                            str = append.packageParam;
                        }
                        if ((i & 4) != 0) {
                            str2 = append.appUserIdParam;
                        }
                        if ((i & 8) != 0) {
                            str3 = append.envParam;
                        }
                        return append.copy(r1, str, str2, str3);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final Package getRcPackage() {
                        return this.rcPackage;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final String getPackageParam() {
                        return this.packageParam;
                    }

                    /* JADX INFO: renamed from: component3, reason: from getter */
                    public final String getAppUserIdParam() {
                        return this.appUserIdParam;
                    }

                    /* JADX INFO: renamed from: component4, reason: from getter */
                    public final String getEnvParam() {
                        return this.envParam;
                    }

                    public final Append copy(Package rcPackage, String packageParam, String appUserIdParam, String envParam) {
                        return new Append(rcPackage, packageParam, appUserIdParam, envParam);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Append)) {
                            return false;
                        }
                        Append append = (Append) other;
                        return Intrinsics.areEqual(this.rcPackage, append.rcPackage) && Intrinsics.areEqual(this.packageParam, append.packageParam) && Intrinsics.areEqual(this.appUserIdParam, append.appUserIdParam) && Intrinsics.areEqual(this.envParam, append.envParam);
                    }

                    public int hashCode() {
                        Package r0 = this.rcPackage;
                        int iHashCode = (r0 == null ? 0 : r0.hashCode()) * 31;
                        String str = this.packageParam;
                        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                        String str2 = this.appUserIdParam;
                        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                        String str3 = this.envParam;
                        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
                    }

                    public String toString() {
                        return "Append(rcPackage=" + this.rcPackage + ", packageParam=" + this.packageParam + ", appUserIdParam=" + this.appUserIdParam + ", envParam=" + this.envParam + ')';
                    }

                    public Append(Package r1, String str, String str2, String str3) {
                        this.rcPackage = r1;
                        this.packageParam = str;
                        this.appUserIdParam = str2;
                        this.envParam = str3;
                    }

                    public /* synthetic */ Append(Package r2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                        this(r2, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
                    }

                    public final Package getRcPackage() {
                        return this.rcPackage;
                    }

                    public final String getPackageParam() {
                        return this.packageParam;
                    }

                    public final String getAppUserIdParam() {
                        return this.appUserIdParam;
                    }

                    public final String getEnvParam() {
                        return this.envParam;
                    }
                }

                /* JADX INFO: compiled from: PaywallAction.kt */
                @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior$DoNotAppend;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$LaunchWebCheckout$ParamBehavior;", "()V", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
                public static final class DoNotAppend implements ParamBehavior {
                    public static final int $stable = 0;
                    public static final DoNotAppend INSTANCE = new DoNotAppend();

                    private DoNotAppend() {
                    }
                }
            }
        }

        /* JADX INFO: compiled from: PaywallAction.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External;", FirebaseAnalytics.Param.DESTINATION, "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", "(Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;)V", "getDestination", "()Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", HttpHeaders.DESTINATION, "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class NavigateTo implements External {
            public static final int $stable = 8;
            private final Destination destination;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof NavigateTo) && Intrinsics.areEqual(this.destination, ((NavigateTo) obj).destination);
            }

            public int hashCode() {
                return this.destination.hashCode();
            }

            public String toString() {
                return "NavigateTo(destination=" + this.destination + ')';
            }

            public NavigateTo(Destination destination) {
                Intrinsics.checkNotNullParameter(destination, "destination");
                this.destination = destination;
            }

            /* JADX INFO: compiled from: PaywallAction.kt */
            @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", "", "CustomerCenter", "Url", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination$Url;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
            public interface Destination {

                /* JADX INFO: compiled from: PaywallAction.kt */
                @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination$CustomerCenter;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", "()V", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
                public static final class CustomerCenter implements Destination {
                    public static final int $stable = 0;
                    public static final CustomerCenter INSTANCE = new CustomerCenter();

                    private CustomerCenter() {
                    }
                }

                /* JADX INFO: compiled from: PaywallAction.kt */
                @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination$Url;", "Lcom/revenuecat/purchases/ui/revenuecatui/components/PaywallAction$External$NavigateTo$Destination;", ImagesContract.URL, "", FirebaseAnalytics.Param.METHOD, "Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "(Ljava/lang/String;Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;)V", "getMethod", "()Lcom/revenuecat/purchases/paywalls/components/ButtonComponent$UrlMethod;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
                public static final /* data */ class Url implements Destination {
                    public static final int $stable = 0;
                    private final ButtonComponent.UrlMethod method;
                    private final String url;

                    public static /* synthetic */ Url copy$default(Url url, String str, ButtonComponent.UrlMethod urlMethod, int i, Object obj) {
                        if ((i & 1) != 0) {
                            str = url.url;
                        }
                        if ((i & 2) != 0) {
                            urlMethod = url.method;
                        }
                        return url.copy(str, urlMethod);
                    }

                    /* JADX INFO: renamed from: component1, reason: from getter */
                    public final String getUrl() {
                        return this.url;
                    }

                    /* JADX INFO: renamed from: component2, reason: from getter */
                    public final ButtonComponent.UrlMethod getMethod() {
                        return this.method;
                    }

                    public final Url copy(String url, ButtonComponent.UrlMethod method) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        Intrinsics.checkNotNullParameter(method, "method");
                        return new Url(url, method);
                    }

                    public boolean equals(Object other) {
                        if (this == other) {
                            return true;
                        }
                        if (!(other instanceof Url)) {
                            return false;
                        }
                        Url url = (Url) other;
                        return Intrinsics.areEqual(this.url, url.url) && this.method == url.method;
                    }

                    public int hashCode() {
                        return (this.url.hashCode() * 31) + this.method.hashCode();
                    }

                    public String toString() {
                        return "Url(url=" + this.url + ", method=" + this.method + ')';
                    }

                    public Url(String url, ButtonComponent.UrlMethod method) {
                        Intrinsics.checkNotNullParameter(url, "url");
                        Intrinsics.checkNotNullParameter(method, "method");
                        this.url = url;
                        this.method = method;
                    }

                    public final /* synthetic */ String getUrl() {
                        return this.url;
                    }

                    public final /* synthetic */ ButtonComponent.UrlMethod getMethod() {
                        return this.method;
                    }
                }
            }

            public final /* synthetic */ Destination getDestination() {
                return this.destination;
            }
        }
    }
}
