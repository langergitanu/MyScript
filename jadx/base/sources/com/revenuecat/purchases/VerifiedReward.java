package com.revenuecat.purchases;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerifiedReward.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/VerifiedReward;", "", "Entitlement", "NoReward", "UnsupportedReward", "VirtualCurrency", "Lcom/revenuecat/purchases/VerifiedReward$Entitlement;", "Lcom/revenuecat/purchases/VerifiedReward$NoReward;", "Lcom/revenuecat/purchases/VerifiedReward$UnsupportedReward;", "Lcom/revenuecat/purchases/VerifiedReward$VirtualCurrency;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface VerifiedReward {

    /* JADX INFO: compiled from: VerifiedReward.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, m1599d2 = {"Lcom/revenuecat/purchases/VerifiedReward$VirtualCurrency;", "Lcom/revenuecat/purchases/VerifiedReward;", "code", "", Keys.AMOUNT, "", "(Ljava/lang/String;I)V", "getAmount", "()I", "getCode", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class VirtualCurrency implements VerifiedReward {
        private final int amount;
        private final String code;

        public static /* synthetic */ VirtualCurrency copy$default(VirtualCurrency virtualCurrency, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = virtualCurrency.code;
            }
            if ((i2 & 2) != 0) {
                i = virtualCurrency.amount;
            }
            return virtualCurrency.copy(str, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getAmount() {
            return this.amount;
        }

        public final VirtualCurrency copy(String code, int amount) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new VirtualCurrency(code, amount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VirtualCurrency)) {
                return false;
            }
            VirtualCurrency virtualCurrency = (VirtualCurrency) other;
            return Intrinsics.areEqual(this.code, virtualCurrency.code) && this.amount == virtualCurrency.amount;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + Integer.hashCode(this.amount);
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
    @Metadata(m1598d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, m1599d2 = {"Lcom/revenuecat/purchases/VerifiedReward$Entitlement;", "Lcom/revenuecat/purchases/VerifiedReward;", Keys.IDENTIFIER, "", "expiresAt", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)V", "getExpiresAt", "()Ljava/util/Date;", "getIdentifier", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class Entitlement implements VerifiedReward {
        private final Date expiresAt;
        private final String identifier;

        public static /* synthetic */ Entitlement copy$default(Entitlement entitlement, String str, Date date, int i, Object obj) {
            if ((i & 1) != 0) {
                str = entitlement.identifier;
            }
            if ((i & 2) != 0) {
                date = entitlement.expiresAt;
            }
            return entitlement.copy(str, date);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Date getExpiresAt() {
            return this.expiresAt;
        }

        public final Entitlement copy(String identifier, Date expiresAt) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(expiresAt, "expiresAt");
            return new Entitlement(identifier, expiresAt);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Entitlement)) {
                return false;
            }
            Entitlement entitlement = (Entitlement) other;
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
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/VerifiedReward$NoReward;", "Lcom/revenuecat/purchases/VerifiedReward;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class NoReward implements VerifiedReward {
        public static final NoReward INSTANCE = new NoReward();

        private NoReward() {
        }
    }

    /* JADX INFO: compiled from: VerifiedReward.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/VerifiedReward$UnsupportedReward;", "Lcom/revenuecat/purchases/VerifiedReward;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class UnsupportedReward implements VerifiedReward {
        public static final UnsupportedReward INSTANCE = new UnsupportedReward();

        private UnsupportedReward() {
        }
    }
}
