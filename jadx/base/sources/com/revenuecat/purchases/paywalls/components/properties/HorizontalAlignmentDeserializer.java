package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;

/* JADX INFO: compiled from: Alignment.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignmentDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/properties/HorizontalAlignment;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class HorizontalAlignmentDeserializer extends EnumDeserializerWithDefault<HorizontalAlignment> {
    public static final HorizontalAlignmentDeserializer INSTANCE = new HorizontalAlignmentDeserializer();

    private HorizontalAlignmentDeserializer() {
        super("com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment", HorizontalAlignment.LEADING, null, 4, null);
    }
}
