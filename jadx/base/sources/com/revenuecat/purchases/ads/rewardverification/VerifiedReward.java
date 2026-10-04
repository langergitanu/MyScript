package com.revenuecat.purchases.ads.rewardverification;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerifiedReward.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "", "Entitlement", "NoReward", "UnsupportedReward", "VirtualCurrency", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface VerifiedReward {

    /* JADX INFO: compiled from: VerifiedReward.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward$VirtualCurrency;", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "code", "", Keys.AMOUNT, "", "(Ljava/lang/String;I)V", "getAmount", "()I", "getCode", "()Ljava/lang/String;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class VirtualCurrency implements VerifiedReward {
        private final int amount;
        private final String code;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VirtualCurrency)) {
                return false;
            }
            VirtualCurrency virtualCurrency = (VirtualCurrency) obj;
            return Intrinsics.areEqual(this.code, virtualCurrency.code) && this.amount == virtualCurrency.amount;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.amount;
        }

        public String toString() {
            return "VirtualCurrency(code=" + this.code + ", amount=" + this.amount + ')';
        }

        public VirtualCurrency(String code, int i) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.amount = i;
        }

        public final String getCode() {
            return this.code;
        }

        public final int getAmount() {
            return this.amount;
        }
    }

    /* JADX INFO: compiled from: VerifiedReward.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward$Entitlement;", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", Keys.IDENTIFIER, "", "expiresAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)V", "getExpiresAt", "()Ljava/util/Date;", "getIdentifier", "()Ljava/lang/String;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Entitlement implements VerifiedReward {
        private final Date expiresAt;
        private final String identifier;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entitlement)) {
                return false;
            }
            Entitlement entitlement = (Entitlement) obj;
            return Intrinsics.areEqual(this.identifier, entitlement.identifier) && Intrinsics.areEqual(this.expiresAt, entitlement.expiresAt);
        }

        public int hashCode() {
            return (this.identifier.hashCode() * 31) + this.expiresAt.hashCode();
        }

        public String toString() {
            return "Entitlement(identifier=" + this.identifier + ", expiresAt=" + this.expiresAt + ')';
        }

        public Entitlement(String identifier, Date expiresAt) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
            this.identifier = identifier;
            this.expiresAt = expiresAt;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final Date getExpiresAt() {
            return this.expiresAt;
        }
    }

    /* JADX INFO: compiled from: VerifiedReward.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward$NoReward;", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class NoReward implements VerifiedReward {
        public static final NoReward INSTANCE = new NoReward();

        private NoReward() {
        }
    }

    /* JADX INFO: compiled from: VerifiedReward.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward$UnsupportedReward;", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class UnsupportedReward implements VerifiedReward {
        public static final UnsupportedReward INSTANCE = new UnsupportedReward();

        private UnsupportedReward() {
        }
    }
}
