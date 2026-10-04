package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.WebViewMessageType;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraintDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/SealedDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/properties/SizeConstraint;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class SizeConstraintDeserializer extends SealedDeserializerWithDefault<SizeConstraint> {
    public static final SizeConstraintDeserializer INSTANCE = new SizeConstraintDeserializer();

    private SizeConstraintDeserializer() {
        super("SizeConstraint", MapsKt.mapOf(TuplesKt.m1606to(WebViewMessageType.FIT, new Function0<KSerializer<SizeConstraint.Fit>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.SizeConstraintDeserializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<SizeConstraint.Fit> invoke() {
                return SizeConstraint.Fit.INSTANCE.serializer();
            }
        }), TuplesKt.m1606to("fill", new Function0<KSerializer<SizeConstraint.Fill>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.SizeConstraintDeserializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<SizeConstraint.Fill> invoke() {
                return SizeConstraint.Fill.INSTANCE.serializer();
            }
        }), TuplesKt.m1606to("fixed", new Function0<KSerializer<SizeConstraint.Fixed>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.SizeConstraintDeserializer.3
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<SizeConstraint.Fixed> invoke() {
                return SizeConstraint.Fixed.INSTANCE.serializer();
            }
        })), new Function1<String, SizeConstraint>() { // from class: com.revenuecat.purchases.paywalls.components.properties.SizeConstraintDeserializer.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final SizeConstraint invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new SizeConstraint.Fit((UInt) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }
        }, null, 8, null);
    }
}
