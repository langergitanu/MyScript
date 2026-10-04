package com.revenuecat.purchases.ads.rewardverification;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.revenuecat.purchases.CoroutinesExtensionsKt;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.RewardVerificationPollStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: RewardVerificationFetcher.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bà\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationFetcher;", "", RemoteConfigComponent.FETCH_FILE_NAME, "Lcom/revenuecat/purchases/RewardVerificationPollStatus;", "clientTransactionId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public interface RewardVerificationFetcher {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Object fetch(String str, Continuation<? super RewardVerificationPollStatus> continuation);

    /* JADX INFO: compiled from: RewardVerificationFetcher.kt */
    @Metadata(m1598d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m1599d2 = {"Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationFetcher$Companion;", "", "()V", "default", "Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationFetcher;", "getDefault", "()Lcom/revenuecat/purchases/ads/rewardverification/RewardVerificationFetcher;", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final RewardVerificationFetcher default = new RewardVerificationFetcher() { // from class: com.revenuecat.purchases.ads.rewardverification.RewardVerificationFetcher$Companion$default$1
            @Override // com.revenuecat.purchases.ads.rewardverification.RewardVerificationFetcher
            public final Object fetch(String str, Continuation<? super RewardVerificationPollStatus> continuation) {
                return CoroutinesExtensionsKt.awaitGetRewardVerificationResult(Purchases.Companion.getSharedInstance(), str, continuation);
            }
        };

        private Companion() {
        }

        public final RewardVerificationFetcher getDefault() {
            return default;
        }
    }
}
