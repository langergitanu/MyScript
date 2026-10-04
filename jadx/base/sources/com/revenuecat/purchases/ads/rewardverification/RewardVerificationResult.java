package com.revenuecat.purchases.ads.rewardverification;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RewardVerificationResult.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult;", "", "storage", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Storage;", "(Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Storage;)V", "failed", "", "getFailed", "()Z", "moreRewards", "", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "getMoreRewards", "()Ljava/util/List;", "verifiedReward", "getVerifiedReward", "()Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "Companion", "Storage", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RewardVerificationResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final RewardVerificationResult failed = new RewardVerificationResult(Storage.Failed.INSTANCE);
    private final Storage storage;

    public /* synthetic */ RewardVerificationResult(Storage storage, DefaultConstructorMarker defaultConstructorMarker) {
        this(storage);
    }

    @JvmStatic
    public static final RewardVerificationResult verified(VerifiedReward verifiedReward) {
        return INSTANCE.verified(verifiedReward);
    }

    @JvmStatic
    public static final RewardVerificationResult verified(VerifiedReward verifiedReward, List<? extends VerifiedReward> list) {
        return INSTANCE.verified(verifiedReward, list);
    }

    private RewardVerificationResult(Storage storage) {
        this.storage = storage;
    }

    /* JADX INFO: compiled from: RewardVerificationResult.kt */
    @Metadata(m1598d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Storage;", "", "Failed", "Verified", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Storage$Failed;", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Storage$Verified;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    private interface Storage {

        /* JADX INFO: compiled from: RewardVerificationResult.kt */
        @Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Storage$Verified;", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Storage;", "reward", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "moreRewards", "", "(Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;Ljava/util/List;)V", "getMoreRewards", "()Ljava/util/List;", "getReward", "()Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Verified implements Storage {
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

        /* JADX INFO: compiled from: RewardVerificationResult.kt */
        @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Storage$Failed;", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Storage;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
        public static final class Failed implements Storage {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
            }
        }
    }

    public final VerifiedReward getVerifiedReward() {
        Storage storage = this.storage;
        Storage.Verified verified = storage instanceof Storage.Verified ? (Storage.Verified) storage : null;
        if (verified != null) {
            return verified.getReward();
        }
        return null;
    }

    public final List<VerifiedReward> getMoreRewards() {
        List<VerifiedReward> moreRewards;
        Storage storage = this.storage;
        Storage.Verified verified = storage instanceof Storage.Verified ? (Storage.Verified) storage : null;
        return (verified == null || (moreRewards = verified.getMoreRewards()) == null) ? CollectionsKt.emptyList() : moreRewards;
    }

    public final boolean getFailed() {
        return this.storage instanceof Storage.Failed;
    }

    /* JADX INFO: compiled from: RewardVerificationResult.kt */
    @Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult$Companion;", "", "()V", "failed", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult;", "verified", "reward", "Lcom/revenuecat/purchases/ads/rewardverification/VerifiedReward;", "moreRewards", "", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final RewardVerificationResult verified(VerifiedReward reward) {
            Intrinsics.checkNotNullParameter(reward, "reward");
            return verified$default(this, reward, null, 2, null);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RewardVerificationResult verified$default(Companion companion, VerifiedReward verifiedReward, List list, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            return companion.verified(verifiedReward, list);
        }

        @JvmStatic
        public final RewardVerificationResult verified(VerifiedReward reward, List<? extends VerifiedReward> moreRewards) {
            Intrinsics.checkNotNullParameter(reward, "reward");
            Intrinsics.checkNotNullParameter(moreRewards, "moreRewards");
            return new RewardVerificationResult(new Storage.Verified(reward, moreRewards), null);
        }
    }
}
