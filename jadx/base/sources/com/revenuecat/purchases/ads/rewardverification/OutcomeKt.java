package com.revenuecat.purchases.ads.rewardverification;

import com.revenuecat.purchases.ads.rewardverification.Outcome;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Outcome.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, m1599d2 = {"toResult", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationResult;", "Lcom/revenuecat/purchases/ads/rewardverification/Outcome;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class OutcomeKt {
    public static final RewardVerificationResult toResult(Outcome outcome) {
        Intrinsics.checkNotNullParameter(outcome, "<this>");
        if (outcome instanceof Outcome.Verified) {
            Outcome.Verified verified = (Outcome.Verified) outcome;
            return RewardVerificationResult.INSTANCE.verified(verified.getReward(), verified.getMoreRewards());
        }
        if (outcome instanceof Outcome.Failed) {
            return RewardVerificationResult.failed;
        }
        throw new NoWhenBranchMatchedException();
    }
}
