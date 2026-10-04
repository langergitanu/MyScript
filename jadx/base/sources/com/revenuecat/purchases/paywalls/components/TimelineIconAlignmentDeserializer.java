package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TimelineComponent.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, m1599d2 = {"Lcom/revenuecat/purchases/paywalls/components/TimelineIconAlignmentDeserializer;", "Lcom/revenuecat/purchases/utils/serializers/EnumDeserializerWithDefault;", "Lcom/revenuecat/purchases/paywalls/components/TimelineComponent$IconAlignment;", "()V", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public final class TimelineIconAlignmentDeserializer extends EnumDeserializerWithDefault<TimelineComponent.IconAlignment> {
    public static final TimelineIconAlignmentDeserializer INSTANCE = new TimelineIconAlignmentDeserializer();

    private TimelineIconAlignmentDeserializer() {
        super("com.revenuecat.purchases.paywalls.components.TimelineComponent.IconAlignment", TimelineComponent.IconAlignment.Title, new Function1<TimelineComponent.IconAlignment, String>() { // from class: com.revenuecat.purchases.paywalls.components.TimelineIconAlignmentDeserializer.1

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TimelineIconAlignmentDeserializer$1$WhenMappings */
            /* JADX INFO: compiled from: TimelineComponent.kt */
            @Metadata(m1600k = 3, m1601mv = {1, 8, 0}, m1603xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[TimelineComponent.IconAlignment.values().length];
                    try {
                        iArr[TimelineComponent.IconAlignment.Title.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[TimelineComponent.IconAlignment.TitleAndDescription.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(TimelineComponent.IconAlignment value) {
                Intrinsics.checkNotNullParameter(value, "value");
                int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
                if (i == 1) {
                    return "title";
                }
                if (i == 2) {
                    return "title_and_description";
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }
}
