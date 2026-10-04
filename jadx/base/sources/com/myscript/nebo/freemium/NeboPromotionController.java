package com.myscript.nebo.freemium;

import com.myscript.nebo.freemium.PromotionController;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: compiled from: NeboPromotionController.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, m1599d2 = {"Lcom/myscript/nebo/freemium/NeboPromotionController;", "Lcom/myscript/nebo/freemium/PromotionController;", "<init>", "()V", "isPromotionalCampaign", "", "promotionalCampaignPeriod", "Lcom/myscript/nebo/freemium/PromotionController$PromotionalPeriod;", "promotionalCampaignId", "", "Companion", "freemium_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class NeboPromotionController implements PromotionController {
    public static final int $stable = 0;
    private static final String JANUARY_BTS_PERIOD_FROM = "07/01/2025 00:00:00";
    private static final String JANUARY_BTS_PERIOD_TO = "17/01/2025 23:59:59";

    @Override // com.myscript.nebo.freemium.PromotionController
    public boolean isPromotionalCampaign() {
        return promotionalCampaignPeriod() != PromotionController.PromotionalPeriod.OUTSIDE;
    }

    @Override // com.myscript.nebo.freemium.PromotionController
    public PromotionController.PromotionalPeriod promotionalCampaignPeriod() {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date date2 = simpleDateFormat.parse(JANUARY_BTS_PERIOD_FROM);
        if (date2 != null && (date = simpleDateFormat.parse(JANUARY_BTS_PERIOD_TO)) != null) {
            Date date3 = new Date();
            return (date3.compareTo(date2) < 0 || date3.compareTo(date) > 0) ? PromotionController.PromotionalPeriod.OUTSIDE : PromotionController.PromotionalPeriod.DAY;
        }
        return PromotionController.PromotionalPeriod.OUTSIDE;
    }

    @Override // com.myscript.nebo.freemium.PromotionController
    public String promotionalCampaignId() {
        return "JANUARY_BTS_2025";
    }
}
