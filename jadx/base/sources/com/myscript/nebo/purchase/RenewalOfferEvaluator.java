package com.myscript.nebo.purchase;

import com.revenuecat.purchases.common.Constants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: RenewalOfferEvaluator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J1\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u000b¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J9\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u000b¢\u0006\u0002\u0010#R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, m1599d2 = {"Lcom/myscript/nebo/purchase/RenewalOfferEvaluator;", "", "<init>", "()V", "OFFER_WINDOW", "Lkotlin/time/Duration;", "getOFFER_WINDOW-UwyO8pc", "()J", "J", "MONTHLY_MIN_HELD", "MONTHLY_MIN_PERIODS", "", "MAX_HELD_MONTHS", "MAX_MONTH_EQUIVALENT", "YEARLY_PRODUCT_REGEX", "Lkotlin/text/Regex;", "MONTHLY_PRODUCT_REGEX", "earliestKnownPurchaseMs", "", "customerInfo", "Lcom/myscript/nebo/purchase/CustomerInfoResult;", "(Lcom/myscript/nebo/purchase/CustomerInfoResult;)Ljava/lang/Long;", "isEligible", "", "nowMs", "earliestPurchaseMs", "observedPayments", "(Lcom/myscript/nebo/purchase/CustomerInfoResult;JLjava/lang/Long;I)Z", "maxHeldMs", "yearly", "monthlyMinHeldMs", "evaluate", "Lcom/myscript/nebo/purchase/RenewalOfferEvaluation;", "persisted", "Lcom/myscript/nebo/purchase/RenewalOfferPersistedState;", "(Lcom/myscript/nebo/purchase/CustomerInfoResult;Lcom/myscript/nebo/purchase/RenewalOfferPersistedState;JLjava/lang/Long;I)Lcom/myscript/nebo/purchase/RenewalOfferEvaluation;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class RenewalOfferEvaluator {
    public static final int $stable;
    public static final RenewalOfferEvaluator INSTANCE = new RenewalOfferEvaluator();
    private static final int MAX_HELD_MONTHS = 16;
    private static final long MAX_MONTH_EQUIVALENT;
    private static final long MONTHLY_MIN_HELD;
    public static final int MONTHLY_MIN_PERIODS = 4;
    private static final Regex MONTHLY_PRODUCT_REGEX;
    private static final long OFFER_WINDOW;
    private static final Regex YEARLY_PRODUCT_REGEX;

    private RenewalOfferEvaluator() {
    }

    static {
        Duration.Companion companion = Duration.INSTANCE;
        OFFER_WINDOW = DurationKt.toDuration(72, DurationUnit.HOURS);
        Duration.Companion companion2 = Duration.INSTANCE;
        MONTHLY_MIN_HELD = DurationKt.toDuration(120, DurationUnit.DAYS);
        Duration.Companion companion3 = Duration.INSTANCE;
        MAX_MONTH_EQUIVALENT = DurationKt.toDuration(31, DurationUnit.DAYS);
        YEARLY_PRODUCT_REGEX = new Regex("[-_]1y([-_]|$)");
        MONTHLY_PRODUCT_REGEX = new Regex("[-_]1m([-_]|$)");
        $stable = 8;
    }

    /* JADX INFO: renamed from: getOFFER_WINDOW-UwyO8pc, reason: not valid java name */
    public final long m13360getOFFER_WINDOWUwyO8pc() {
        return OFFER_WINDOW;
    }

    public final Long earliestKnownPurchaseMs(CustomerInfoResult customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Map<String, Long> purchaseDatesByProductMs = customerInfo.getPurchaseDatesByProductMs();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Long> entry : purchaseDatesByProductMs.entrySet()) {
            String key = entry.getKey();
            if (YEARLY_PRODUCT_REGEX.containsMatchIn(key) || MONTHLY_PRODUCT_REGEX.containsMatchIn(key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return (Long) CollectionsKt.minOrNull((Iterable) CollectionsKt.plus(linkedHashMap.values(), (Iterable) CollectionsKt.listOfNotNull(customerInfo.getOriginalPurchaseDateMs())));
    }

    public static /* synthetic */ boolean isEligible$default(RenewalOfferEvaluator renewalOfferEvaluator, CustomerInfoResult customerInfoResult, long j, Long l, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            l = null;
        }
        Long l2 = l;
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return renewalOfferEvaluator.isEligible(customerInfoResult, j, l2, i);
    }

    public final boolean isEligible(CustomerInfoResult customerInfo, long nowMs, Long earliestPurchaseMs, int observedPayments) {
        Long expirationDateMs;
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        if (!customerInfo.getHasSubscribed() && customerInfo.getUnsubscribeDetectedAtMs() != null && Intrinsics.areEqual((Object) customerInfo.getWillRenew(), (Object) false) && (expirationDateMs = customerInfo.getExpirationDateMs()) != null) {
            long jLongValue = expirationDateMs.longValue();
            if (jLongValue > nowMs) {
                return false;
            }
            String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((Object[]) new String[]{customerInfo.getProductIdentifier(), customerInfo.getProductPlanIdentifier()}), Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, null, null, 0, null, null, 62, null);
            if (strJoinToString$default.length() == 0) {
                return false;
            }
            boolean zContainsMatchIn = YEARLY_PRODUCT_REGEX.containsMatchIn(strJoinToString$default);
            if ((!zContainsMatchIn && !MONTHLY_PRODUCT_REGEX.containsMatchIn(strJoinToString$default)) || customerInfo.getOriginalPurchaseDateMs() == null) {
                return false;
            }
            long jLongValue2 = jLongValue - ((Number) CollectionsKt.minOrThrow((Iterable<Double>) CollectionsKt.listOfNotNull((Object[]) new Long[]{earliestKnownPurchaseMs(customerInfo), earliestPurchaseMs}))).longValue();
            if (jLongValue2 >= maxHeldMs(customerInfo, zContainsMatchIn)) {
                return false;
            }
            return zContainsMatchIn || observedPayments >= 4 || jLongValue2 >= monthlyMinHeldMs(customerInfo);
        }
        return false;
    }

    private final long maxHeldMs(CustomerInfoResult customerInfo, boolean yearly) {
        long j = 16;
        long jM15867getInWholeMillisecondsimpl = Duration.m15867getInWholeMillisecondsimpl(MAX_MONTH_EQUIVALENT) * j;
        Long expirationDateMs = customerInfo.getExpirationDateMs();
        if (expirationDateMs != null) {
            long jLongValue = expirationDateMs.longValue();
            Long latestPurchaseDateMs = customerInfo.getLatestPurchaseDateMs();
            if (latestPurchaseDateMs != null) {
                long jLongValue2 = jLongValue - latestPurchaseDateMs.longValue();
                if (jLongValue2 > 0) {
                    if (yearly) {
                        jLongValue2 /= (long) 12;
                    }
                    return Math.min(j * jLongValue2, jM15867getInWholeMillisecondsimpl);
                }
            }
        }
        return jM15867getInWholeMillisecondsimpl;
    }

    private final long monthlyMinHeldMs(CustomerInfoResult customerInfo) {
        Long expirationDateMs = customerInfo.getExpirationDateMs();
        if (expirationDateMs == null) {
            return Duration.m15867getInWholeMillisecondsimpl(MONTHLY_MIN_HELD);
        }
        long jLongValue = expirationDateMs.longValue();
        Long latestPurchaseDateMs = customerInfo.getLatestPurchaseDateMs();
        if (latestPurchaseDateMs == null) {
            return Duration.m15867getInWholeMillisecondsimpl(MONTHLY_MIN_HELD);
        }
        long jLongValue2 = jLongValue - latestPurchaseDateMs.longValue();
        if (jLongValue2 <= 0) {
            return Duration.m15867getInWholeMillisecondsimpl(MONTHLY_MIN_HELD);
        }
        return Math.min(((long) 4) * jLongValue2, Duration.m15867getInWholeMillisecondsimpl(MONTHLY_MIN_HELD));
    }

    public static /* synthetic */ RenewalOfferEvaluation evaluate$default(RenewalOfferEvaluator renewalOfferEvaluator, CustomerInfoResult customerInfoResult, RenewalOfferPersistedState renewalOfferPersistedState, long j, Long l, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            l = null;
        }
        Long l2 = l;
        if ((i2 & 16) != 0) {
            i = 0;
        }
        return renewalOfferEvaluator.evaluate(customerInfoResult, renewalOfferPersistedState, j, l2, i);
    }

    public final RenewalOfferEvaluation evaluate(CustomerInfoResult customerInfo, RenewalOfferPersistedState persisted, long nowMs, Long earliestPurchaseMs, int observedPayments) {
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(persisted, "persisted");
        if (!isEligible(customerInfo, nowMs, earliestPurchaseMs, observedPayments)) {
            return new RenewalOfferEvaluation(RenewalOfferPersistedState.copy$default(persisted, 0L, 0L, 2, null), false, 0L);
        }
        Long expirationDateMs = customerInfo.getExpirationDateMs();
        if (expirationDateMs == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        long jLongValue = expirationDateMs.longValue();
        long windowStartMs = persisted.getWindowStartMs();
        if (jLongValue != persisted.getHandledExpirationMs() || windowStartMs > nowMs) {
            windowStartMs = nowMs;
        } else if (windowStartMs == 0) {
            return new RenewalOfferEvaluation(persisted, false, 0L);
        }
        long jM15867getInWholeMillisecondsimpl = Duration.m15867getInWholeMillisecondsimpl(OFFER_WINDOW) + windowStartMs;
        boolean z = nowMs < jM15867getInWholeMillisecondsimpl;
        return new RenewalOfferEvaluation(new RenewalOfferPersistedState(windowStartMs, jLongValue), z, z ? jM15867getInWholeMillisecondsimpl : 0L);
    }
}
