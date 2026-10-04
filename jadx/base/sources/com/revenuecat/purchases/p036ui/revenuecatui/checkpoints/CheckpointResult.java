package com.revenuecat.purchases.p036ui.revenuecatui.checkpoints;

import com.revenuecat.purchases.Offering;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckpointResult.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0000¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult;", "", "()V", "NoAction", "PaywallPresented", "ReceivedOffering", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class CheckpointResult {
    public static final int $stable = 0;

    /* JADX INFO: compiled from: CheckpointResult.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult$ReceivedOffering;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult;", "offering", "Lcom/revenuecat/purchases/Offering;", "(Lcom/revenuecat/purchases/Offering;)V", "getOffering", "()Lcom/revenuecat/purchases/Offering;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class ReceivedOffering extends CheckpointResult {
        public static final int $stable = 8;
        private final Offering offering;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ReceivedOffering) && Intrinsics.areEqual(this.offering, ((ReceivedOffering) obj).offering);
        }

        public int hashCode() {
            return this.offering.hashCode();
        }

        public String toString() {
            return "ReceivedOffering(offering=" + this.offering + ')';
        }

        public final Offering getOffering() {
            return this.offering;
        }

        public ReceivedOffering(Offering offering) {
            Intrinsics.checkNotNullParameter(offering, "offering");
            this.offering = offering;
        }
    }

    /* JADX INFO: compiled from: CheckpointResult.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult$PaywallPresented;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult;", "paywallOutcome", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "(Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;)V", "getPaywallOutcome", "()Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointPaywallOutcome;", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class PaywallPresented extends CheckpointResult {
        public static final int $stable = 0;
        private final CheckpointPaywallOutcome paywallOutcome;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PaywallPresented) && Intrinsics.areEqual(this.paywallOutcome, ((PaywallPresented) obj).paywallOutcome);
        }

        public int hashCode() {
            return this.paywallOutcome.hashCode();
        }

        public String toString() {
            return "PaywallPresented(paywallOutcome=" + this.paywallOutcome + ')';
        }

        public final CheckpointPaywallOutcome getPaywallOutcome() {
            return this.paywallOutcome;
        }

        public PaywallPresented(CheckpointPaywallOutcome paywallOutcome) {
            Intrinsics.checkNotNullParameter(paywallOutcome, "paywallOutcome");
            this.paywallOutcome = paywallOutcome;
        }
    }

    /* JADX INFO: compiled from: CheckpointResult.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0007B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult$NoAction;", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult;", "reason", "Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult$NoAction$Reason;", "(Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult$NoAction$Reason;)V", "getReason", "()Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult$NoAction$Reason;", "Reason", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class NoAction extends CheckpointResult {
        public static final int $stable = 0;
        private final Reason reason;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NoAction) && Intrinsics.areEqual(this.reason, ((NoAction) obj).reason);
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "NoAction(reason=" + this.reason + ')';
        }

        public final Reason getReason() {
            return this.reason;
        }

        public NoAction(Reason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        /* JADX INFO: compiled from: CheckpointResult.kt */
        @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m1599d2 = {"Lcom/revenuecat/purchases/ui/revenuecatui/checkpoints/CheckpointResult$NoAction$Reason;", "", "value", "", "(Ljava/lang/String;)V", "getValue$revenuecatui_defaultsRelease", "()Ljava/lang/String;", "toString", "Companion", "revenuecatui_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Reason {
            public static final int $stable = 0;
            private final String value;
            public static final Reason NO_MATCH = new Reason("NO_MATCH");
            public static final Reason HOLDOUT = new Reason("HOLDOUT");
            public static final Reason FREQUENCY_CAPPED = new Reason("FREQUENCY_CAPPED");
            public static final Reason CONFIGURATION_UNAVAILABLE = new Reason("CONFIGURATION_UNAVAILABLE");
            public static final Reason UNKNOWN_CHECKPOINT = new Reason("UNKNOWN_CHECKPOINT");
            public static final Reason INVALID_CHECKPOINT_IDENTIFIER = new Reason("INVALID_CHECKPOINT_IDENTIFIER");

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Reason) && Intrinsics.areEqual(this.value, ((Reason) obj).value);
            }

            public int hashCode() {
                return this.value.hashCode();
            }

            public Reason(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
            }

            /* JADX INFO: renamed from: getValue$revenuecatui_defaultsRelease, reason: from getter */
            public final String getValue() {
                return this.value;
            }

            public String toString() {
                return this.value;
            }
        }
    }
}
