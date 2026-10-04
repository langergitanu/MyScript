package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointPaywallOutcome.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0000¢\u0006\u0002\u0010\u0002¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "", "()V", "Dismissed", "Error", "Purchased", "Restored", "WebCheckoutOpened", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class CheckpointPaywallOutcome {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: CheckpointPaywallOutcome.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome$Dismissed;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "()V", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Dismissed extends CheckpointPaywallOutcome {
        public static final int $stable = 0;
        public static final Dismissed INSTANCE = new Dismissed();

        private Dismissed() {
        }

        public String toString() {
            return "Dismissed";
        }
    }

    /* JADX INFO: compiled from: CheckpointPaywallOutcome.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome$Purchased;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "(Lcom/revenuecat/purchases/CustomerInfo;Lcom/revenuecat/purchases/models/StoreTransaction;)V", "getCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "getStoreTransaction", "()Lcom/revenuecat/purchases/models/StoreTransaction;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Purchased extends CheckpointPaywallOutcome {
        public static final int $stable = 8;
        private final CustomerInfo customerInfo;
        private final StoreTransaction storeTransaction;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Purchased)) {
                return false;
            }
            Purchased purchased = (Purchased) obj;
            return Intrinsics.areEqual(this.customerInfo, purchased.customerInfo) && Intrinsics.areEqual(this.storeTransaction, purchased.storeTransaction);
        }

        public int hashCode() {
            return (this.customerInfo.hashCode() * 31) + this.storeTransaction.hashCode();
        }

        public String toString() {
            return "Purchased(customerInfo=" + this.customerInfo + ", storeTransaction=" + this.storeTransaction + ')';
        }

        public final CustomerInfo getCustomerInfo() {
            return this.customerInfo;
        }

        public final StoreTransaction getStoreTransaction() {
            return this.storeTransaction;
        }

        public Purchased(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
            this.customerInfo = customerInfo;
            this.storeTransaction = storeTransaction;
        }
    }

    /* JADX INFO: compiled from: CheckpointPaywallOutcome.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome$Restored;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "(Lcom/revenuecat/purchases/CustomerInfo;)V", "getCustomerInfo", "()Lcom/revenuecat/purchases/CustomerInfo;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Restored extends CheckpointPaywallOutcome {
        public static final int $stable = 8;
        private final CustomerInfo customerInfo;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Restored) && Intrinsics.areEqual(this.customerInfo, ((Restored) obj).customerInfo);
        }

        public int hashCode() {
            return this.customerInfo.hashCode();
        }

        public String toString() {
            return "Restored(customerInfo=" + this.customerInfo + ')';
        }

        public final CustomerInfo getCustomerInfo() {
            return this.customerInfo;
        }

        public Restored(CustomerInfo customerInfo) {
            Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
            this.customerInfo = customerInfo;
        }
    }

    /* JADX INFO: compiled from: CheckpointPaywallOutcome.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome$Error;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "error", "Lcom/revenuecat/purchases/PurchasesError;", "(Lcom/revenuecat/purchases/PurchasesError;)V", "getError", "()Lcom/revenuecat/purchases/PurchasesError;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Error extends CheckpointPaywallOutcome {
        public static final int $stable = 0;
        private final PurchasesError error;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ')';
        }

        public final PurchasesError getError() {
            return this.error;
        }

        public Error(PurchasesError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }
    }

    /* JADX INFO: compiled from: CheckpointPaywallOutcome.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome$WebCheckoutOpened;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "()V", "toString", "", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class WebCheckoutOpened extends CheckpointPaywallOutcome {
        public static final int $stable = 0;
        public static final WebCheckoutOpened INSTANCE = new WebCheckoutOpened();

        private WebCheckoutOpened() {
        }

        public String toString() {
            return "WebCheckoutOpened";
        }
    }
}
