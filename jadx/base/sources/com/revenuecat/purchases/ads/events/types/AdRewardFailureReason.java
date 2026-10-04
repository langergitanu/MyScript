package com.revenuecat.purchases.ads.events.types;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: AdRewardFailureReason.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b'\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "", "value", "", "(Ljava/lang/String;)V", "getValue$purchases_defaultsRelease", "()Ljava/lang/String;", "BackendError", "Cancelled", "NetworkError", HttpHeaders.TIMEOUT, "Unknown", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public abstract class AdRewardFailureReason {
    private final String value;

    public AdRewardFailureReason(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    /* JADX INFO: renamed from: getValue$purchases_defaultsRelease, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: compiled from: AdRewardFailureReason.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason$Timeout;", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Timeout extends AdRewardFailureReason {
        public static final Timeout INSTANCE = new Timeout();

        private Timeout() {
            super("timeout");
        }
    }

    /* JADX INFO: compiled from: AdRewardFailureReason.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason$NetworkError;", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class NetworkError extends AdRewardFailureReason {
        public static final NetworkError INSTANCE = new NetworkError();

        private NetworkError() {
            super("network_error");
        }
    }

    /* JADX INFO: compiled from: AdRewardFailureReason.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason$Cancelled;", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Cancelled extends AdRewardFailureReason {
        public static final Cancelled INSTANCE = new Cancelled();

        private Cancelled() {
            super("cancelled");
        }
    }

    /* JADX INFO: compiled from: AdRewardFailureReason.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason$Unknown;", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Unknown extends AdRewardFailureReason {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super("unknown");
        }
    }

    /* JADX INFO: compiled from: AdRewardFailureReason.kt */
    @Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason$BackendError;", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "reason", "", "(Ljava/lang/String;)V", "getReason", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final /* data */ class BackendError extends AdRewardFailureReason {
        private final String reason;

        public static /* synthetic */ BackendError copy$default(BackendError backendError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = backendError.reason;
            }
            return backendError.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final BackendError copy(String reason) {
            return new BackendError(reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof BackendError) && Intrinsics.areEqual(this.reason, ((BackendError) other).reason);
        }

        public int hashCode() {
            String str = this.reason;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "BackendError(reason=" + this.reason + ')';
        }

        public BackendError(String str) {
            super(str == null ? "backend_error" : str);
            this.reason = str;
        }

        public final String getReason() {
            return this.reason;
        }
    }
}
