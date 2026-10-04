package com.myscript.nebo.analytics.firebase;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: NeboFirebaseEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/myscript/nebo/analytics/firebase/PaywallOrigin;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GridViewBanner", "TrialEnd", "Onboarding", "RenewalOffer", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class PaywallOrigin {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PaywallOrigin[] $VALUES;
    private final String value;
    public static final PaywallOrigin GridViewBanner = new PaywallOrigin("GridViewBanner", 0, "gridview_banner");
    public static final PaywallOrigin TrialEnd = new PaywallOrigin("TrialEnd", 1, "trial_end");
    public static final PaywallOrigin Onboarding = new PaywallOrigin("Onboarding", 2, "onboarding");
    public static final PaywallOrigin RenewalOffer = new PaywallOrigin("RenewalOffer", 3, "renewal_offer");

    private static final /* synthetic */ PaywallOrigin[] $values() {
        return new PaywallOrigin[]{GridViewBanner, TrialEnd, Onboarding, RenewalOffer};
    }

    public static EnumEntries<PaywallOrigin> getEntries() {
        return $ENTRIES;
    }

    public static PaywallOrigin valueOf(String str) {
        return (PaywallOrigin) Enum.valueOf(PaywallOrigin.class, str);
    }

    public static PaywallOrigin[] values() {
        return (PaywallOrigin[]) $VALUES.clone();
    }

    private PaywallOrigin(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        PaywallOrigin[] paywallOriginArr$values = $values();
        $VALUES = paywallOriginArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(paywallOriginArr$values);
    }
}
