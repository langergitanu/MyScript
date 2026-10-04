package com.myscript.nebo.freemium;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: NeboPromotionController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\b\tJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/freemium/PromotionController;", "", "isPromotionalCampaign", "", "promotionalCampaignPeriod", "Lcom/myscript/nebo/freemium/PromotionController$PromotionalPeriod;", "promotionalCampaignId", "", "Provider", "PromotionalPeriod", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface PromotionController {

    /* JADX INFO: compiled from: NeboPromotionController.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/freemium/PromotionController$Provider;", "", "providePromotionController", "Lcom/myscript/nebo/freemium/PromotionController;", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        PromotionController providePromotionController();
    }

    default boolean isPromotionalCampaign() {
        return false;
    }

    String promotionalCampaignId();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: NeboPromotionController.kt */
    @Metadata(m1598d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m1599d2 = {"Lcom/myscript/nebo/freemium/PromotionController$PromotionalPeriod;", "", "<init>", "(Ljava/lang/String;I)V", "BEFORE", "DAY", "AFTER", "OUTSIDE", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class PromotionalPeriod {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PromotionalPeriod[] $VALUES;
        public static final PromotionalPeriod BEFORE = new PromotionalPeriod("BEFORE", 0);
        public static final PromotionalPeriod DAY = new PromotionalPeriod("DAY", 1);
        public static final PromotionalPeriod AFTER = new PromotionalPeriod("AFTER", 2);
        public static final PromotionalPeriod OUTSIDE = new PromotionalPeriod("OUTSIDE", 3);

        private static final /* synthetic */ PromotionalPeriod[] $values() {
            return new PromotionalPeriod[]{BEFORE, DAY, AFTER, OUTSIDE};
        }

        public static EnumEntries<PromotionalPeriod> getEntries() {
            return $ENTRIES;
        }

        public static PromotionalPeriod valueOf(String str) {
            return (PromotionalPeriod) Enum.valueOf(PromotionalPeriod.class, str);
        }

        public static PromotionalPeriod[] values() {
            return (PromotionalPeriod[]) $VALUES.clone();
        }

        private PromotionalPeriod(String str, int i) {
        }

        static {
            PromotionalPeriod[] promotionalPeriodArr$values = $values();
            $VALUES = promotionalPeriodArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(promotionalPeriodArr$values);
        }
    }

    /* JADX INFO: compiled from: NeboPromotionController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isPromotionalCampaign(PromotionController promotionController) {
            return PromotionController.super.isPromotionalCampaign();
        }

        @Deprecated
        public static PromotionalPeriod promotionalCampaignPeriod(PromotionController promotionController) {
            return PromotionController.super.promotionalCampaignPeriod();
        }
    }

    default PromotionalPeriod promotionalCampaignPeriod() {
        return PromotionalPeriod.OUTSIDE;
    }
}
