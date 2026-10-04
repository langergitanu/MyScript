package com.myscript.nebo.purchase;

import com.revenuecat.purchases.Offerings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: SubscriptionRepository.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0002\"#J\u000e\u0010\u0018\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001c\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001d\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001e\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001f\u001a\u00020\u0019H¦@¢\u0006\u0002\u0010\u001aJ\b\u0010 \u001a\u00020\u0004H&J\b\u0010!\u001a\u00020\u0019H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0005R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006$À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "", "isConfigured", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "isPreConfigured", "hasSubscribed", "getHasSubscribed", "isBillingUnavailable", "freePeriodState", "Lcom/myscript/nebo/purchase/FreePeriodState;", "getFreePeriodState", "renewalOfferState", "Lcom/myscript/nebo/purchase/RenewalOfferState;", "getRenewalOfferState", "planType", "Lcom/myscript/nebo/purchase/ISubscriptionRepository$PlanType;", "getPlanType", "()Lcom/myscript/nebo/purchase/ISubscriptionRepository$PlanType;", "offerings", "Lcom/revenuecat/purchases/Offerings;", "getOfferings", "()Lcom/revenuecat/purchases/Offerings;", "preConfigure", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConfiguration", "fetchSubscriptionStatus", "startFreeTrial", "startOEMOffer", "checkFreePeriodStatus", "hasPaywallAfterFreePeriodBeenShown", "setPaywallAfterOptInTrialShown", "Provider", "PlanType", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface ISubscriptionRepository {

    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/purchase/ISubscriptionRepository$Provider;", "", "provideSubscriptionRepository", "Lcom/myscript/nebo/purchase/ISubscriptionRepository;", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        ISubscriptionRepository provideSubscriptionRepository();
    }

    Object checkFreePeriodStatus(Continuation<? super Unit> continuation);

    Object fetchSubscriptionStatus(Continuation<? super Unit> continuation);

    StateFlow<FreePeriodState> getFreePeriodState();

    StateFlow<Boolean> getHasSubscribed();

    Offerings getOfferings();

    PlanType getPlanType();

    StateFlow<RenewalOfferState> getRenewalOfferState();

    boolean hasPaywallAfterFreePeriodBeenShown();

    StateFlow<Boolean> isBillingUnavailable();

    StateFlow<Boolean> isConfigured();

    StateFlow<Boolean> isPreConfigured();

    Object preConfigure(Continuation<? super Unit> continuation);

    void setPaywallAfterOptInTrialShown();

    Object startFreeTrial(Continuation<? super Unit> continuation);

    Object startOEMOffer(Continuation<? super Unit> continuation);

    Object updateConfiguration(Continuation<? super Unit> continuation);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SubscriptionRepository.kt */
    @Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/purchase/ISubscriptionRepository$PlanType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "YEARLY", "MONTHLY", "LIFETIME", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class PlanType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PlanType[] $VALUES;
        private final String value;
        public static final PlanType YEARLY = new PlanType("YEARLY", 0, "yearly");
        public static final PlanType MONTHLY = new PlanType("MONTHLY", 1, "monthly");
        public static final PlanType LIFETIME = new PlanType("LIFETIME", 2, "lifetime");

        private static final /* synthetic */ PlanType[] $values() {
            return new PlanType[]{YEARLY, MONTHLY, LIFETIME};
        }

        public static EnumEntries<PlanType> getEntries() {
            return $ENTRIES;
        }

        public static PlanType valueOf(String str) {
            return (PlanType) Enum.valueOf(PlanType.class, str);
        }

        public static PlanType[] values() {
            return (PlanType[]) $VALUES.clone();
        }

        private PlanType(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            PlanType[] planTypeArr$values = $values();
            $VALUES = planTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(planTypeArr$values);
        }
    }
}
