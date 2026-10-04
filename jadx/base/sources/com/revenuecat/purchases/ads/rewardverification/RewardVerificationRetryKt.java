package com.revenuecat.purchases.ads.rewardverification;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: RewardVerificationRetry.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u00020\u0003H\u0080@¢\u0006\u0002\u0010\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, m1599d2 = {"ENTITLEMENT_REFRESH_RETRY_DELAY_MS", "", "rewardVerificationRetryDelay", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "purchases_defaultsRelease"}, m1600k = 2, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class RewardVerificationRetryKt {
    public static final long ENTITLEMENT_REFRESH_RETRY_DELAY_MS = 300;

    public static final Object rewardVerificationRetryDelay(Continuation<? super Unit> continuation) {
        Object objDelay = DelayKt.delay(300L, continuation);
        return objDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay : Unit.INSTANCE;
    }
}
