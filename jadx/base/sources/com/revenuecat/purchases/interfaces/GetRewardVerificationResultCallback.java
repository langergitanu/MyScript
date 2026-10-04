package com.revenuecat.purchases.interfaces;

import com.revenuecat.purchases.RewardVerificationError;
import com.revenuecat.purchases.RewardVerificationPollStatus;
import kotlin.Metadata;

/* JADX INFO: compiled from: GetRewardVerificationResultCallback.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/interfaces/GetRewardVerificationResultCallback;", "", "onError", "", "error", "Lcom/revenuecat/purchases/RewardVerificationError;", "onReceived", "result", "Lcom/revenuecat/purchases/RewardVerificationPollStatus;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface GetRewardVerificationResultCallback {
    void onError(RewardVerificationError error);

    void onReceived(RewardVerificationPollStatus result);
}
