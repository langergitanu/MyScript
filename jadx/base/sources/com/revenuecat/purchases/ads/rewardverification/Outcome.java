package com.revenuecat.purchases.ads.rewardverification;

import com.revenuecat.purchases.ads.events.types.AdRewardFailureReason;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Outcome.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Outcome;", "", "Failed", "Verified", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Verified;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface Outcome {

    /* JADX INFO: compiled from: Outcome.kt */
    @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Verified;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome;", "reward", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "moreRewards", "", "(Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;Ljava/util/List;)V", "getMoreRewards", "()Ljava/util/List;", "getReward", "()Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Verified implements Outcome {
        private final List<VerifiedReward> moreRewards;
        private final VerifiedReward reward;

        /* JADX WARN: Multi-variable type inference failed */
        public Verified(VerifiedReward reward, List<? extends VerifiedReward> moreRewards) {
            Intrinsics.checkNotNullParameter(reward, "reward");
            Intrinsics.checkNotNullParameter(moreRewards, "moreRewards");
            this.reward = reward;
            this.moreRewards = moreRewards;
        }

        public final List<VerifiedReward> getMoreRewards() {
            return this.moreRewards;
        }

        public final VerifiedReward getReward() {
            return this.reward;
        }
    }

    /* JADX INFO: compiled from: Outcome.kt */
    @Metadata(m1598d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\r\u000e\u000f\u0010\u0011\u0012R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0006\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome;", "isUnexpected", "", "()Z", "logMessage", "", "getLogMessage", "()Ljava/lang/String;", "trackingFailureReason", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "getTrackingFailureReason", "()Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "BackendRejected", "Cancelled", "ExhaustedWhilePending", "ExhaustedWhileTransientErroring", "TerminalError", "UnexpectedResponse", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$BackendRejected;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$Cancelled;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$ExhaustedWhilePending;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$ExhaustedWhileTransientErroring;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$TerminalError;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$UnexpectedResponse;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public interface Failed extends Outcome {
        String getLogMessage();

        AdRewardFailureReason getTrackingFailureReason();

        boolean isUnexpected();

        /* JADX INFO: compiled from: Outcome.kt */
        @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$BackendRejected;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed;", "backendMessage", "", "failureReason", "(Ljava/lang/String;Ljava/lang/String;)V", "isUnexpected", "", "()Z", "logMessage", "getLogMessage", "()Ljava/lang/String;", "trackingFailureReason", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "getTrackingFailureReason", "()Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class BackendRejected implements Failed {
            private final String backendMessage;
            private final String failureReason;

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public boolean isUnexpected() {
                return false;
            }

            public BackendRejected(String str, String str2) {
                this.backendMessage = str;
                this.failureReason = str2;
            }

            public /* synthetic */ BackendRejected(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : str2);
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public String getLogMessage() {
                String str = this.backendMessage;
                if (str != null) {
                    if (StringsKt.isBlank(str)) {
                        str = null;
                    }
                    if (str != null) {
                        return str;
                    }
                }
                String str2 = this.failureReason;
                if (str2 == null) {
                    return "Reward verification was rejected by AdMob server-side verification.";
                }
                String str3 = StringsKt.isBlank(str2) ? null : str2;
                if (str3 != null) {
                    return "Reward verification was rejected by AdMob server-side verification (reason: " + str3 + ").";
                }
                return "Reward verification was rejected by AdMob server-side verification.";
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public AdRewardFailureReason getTrackingFailureReason() {
                return new AdRewardFailureReason.BackendError(this.failureReason);
            }
        }

        /* JADX INFO: compiled from: Outcome.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$ExhaustedWhilePending;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed;", "()V", "isUnexpected", "", "()Z", "logMessage", "", "getLogMessage", "()Ljava/lang/String;", "trackingFailureReason", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "getTrackingFailureReason", "()Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class ExhaustedWhilePending implements Failed {
            public static final ExhaustedWhilePending INSTANCE = new ExhaustedWhilePending();

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public boolean isUnexpected() {
                return false;
            }

            private ExhaustedWhilePending() {
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public String getLogMessage() {
                return "Reward verification timed out: the AdMob server-side verification (SSV) callback was not received in time. Possible causes: SSV is not enabled/configured for this ad unit in the AdMob Dashboard, the SSV callback URL is misconfigured in the AdMob Dashboard, AdMob delayed delivering the callback, or RevenueCat failed to process the SSV webhook.";
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public AdRewardFailureReason getTrackingFailureReason() {
                return AdRewardFailureReason.Timeout.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: Outcome.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$ExhaustedWhileTransientErroring;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed;", "()V", "isUnexpected", "", "()Z", "logMessage", "", "getLogMessage", "()Ljava/lang/String;", "trackingFailureReason", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "getTrackingFailureReason", "()Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class ExhaustedWhileTransientErroring implements Failed {
            public static final ExhaustedWhileTransientErroring INSTANCE = new ExhaustedWhileTransientErroring();

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public boolean isUnexpected() {
                return false;
            }

            private ExhaustedWhileTransientErroring() {
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public String getLogMessage() {
                return "Reward verification timed out after repeated transient errors while polling — typically unstable device network connectivity. The reward couldn't be verified.";
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public AdRewardFailureReason getTrackingFailureReason() {
                return AdRewardFailureReason.NetworkError.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: Outcome.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$UnexpectedResponse;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed;", "()V", "isUnexpected", "", "()Z", "logMessage", "", "getLogMessage", "()Ljava/lang/String;", "trackingFailureReason", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "getTrackingFailureReason", "()Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class UnexpectedResponse implements Failed {
            public static final UnexpectedResponse INSTANCE = new UnexpectedResponse();

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public boolean isUnexpected() {
                return true;
            }

            private UnexpectedResponse() {
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public String getLogMessage() {
                return "Reward verification stopped after the server returned a status this SDK version doesn't recognize. Update to the latest SDK version; if you're already on the latest, contact RevenueCat support.";
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public AdRewardFailureReason getTrackingFailureReason() {
                return AdRewardFailureReason.Unknown.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: Outcome.kt */
        @Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$TerminalError;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed;", "error", "", "(Ljava/lang/String;)V", "isUnexpected", "", "()Z", "logMessage", "getLogMessage", "()Ljava/lang/String;", "trackingFailureReason", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "getTrackingFailureReason", "()Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class TerminalError implements Failed {
            private final String error;

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public boolean isUnexpected() {
                return true;
            }

            public TerminalError(String error) {
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public String getLogMessage() {
                return "Reward verification stopped after an unrecoverable error: " + this.error + ". This is unexpected; if it persists, contact RevenueCat support with the error above.";
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public AdRewardFailureReason getTrackingFailureReason() {
                return AdRewardFailureReason.Unknown.INSTANCE;
            }
        }

        /* JADX INFO: compiled from: Outcome.kt */
        @Metadata(m1598d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed$Cancelled;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome$Failed;", "()V", "isUnexpected", "", "()Z", "logMessage", "", "getLogMessage", "()Ljava/lang/String;", "trackingFailureReason", "Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "getTrackingFailureReason", "()Lcom/revenuecat/purchases/ads/events/types/AdRewardFailureReason;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Cancelled implements Failed {
            public static final Cancelled INSTANCE = new Cancelled();

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public boolean isUnexpected() {
                return false;
            }

            private Cancelled() {
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public String getLogMessage() {
                return "Reward verification was cancelled before it could complete.";
            }

            @Override // com.revenuecat.purchases.ads.rewardverification.Outcome.Failed
            public AdRewardFailureReason getTrackingFailureReason() {
                return AdRewardFailureReason.Cancelled.INSTANCE;
            }
        }
    }
}
