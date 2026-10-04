package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;

/* JADX INFO: compiled from: CarouselComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/CarouselTransitionTypeDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$AutoAdvancePages$TransitionType;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class CarouselTransitionTypeDeserializer extends EnumDeserializerWithDefault<CarouselComponent.AutoAdvancePages.TransitionType> {
    public static final CarouselTransitionTypeDeserializer INSTANCE = new CarouselTransitionTypeDeserializer();

    private CarouselTransitionTypeDeserializer() {
        super("com.revenuecat.purchases.paywalls.components.CarouselComponent.AutoAdvancePages.TransitionType", CarouselComponent.AutoAdvancePages.TransitionType.SLIDE, null, 4, null);
    }
}
