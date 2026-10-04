package com.myscript.nebo.analytics;

import android.os.Bundle;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalyticsEvent.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J#\u0010\u0006\u001a\u00020\u00072\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\b\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\rÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/analytics/AnalyticsEvent;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "getKey", "()Ljava/lang/String;", "log", "", "extra", "Landroid/os/Bundle;", "extraDelegate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface AnalyticsEvent {
    String getKey();

    void log(Bundle extra);

    void log(Function1<? super Bundle, Unit> extraDelegate);

    /* JADX INFO: compiled from: AnalyticsEvent.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void log$default(AnalyticsEvent analyticsEvent, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: com.myscript.nebo.analytics.AnalyticsEvent$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return AnalyticsEvent.log$lambda$0((Bundle) obj2);
                }
            };
        }
        analyticsEvent.log((Function1<? super Bundle, Unit>) function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static Unit log$lambda$0(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        return Unit.INSTANCE;
    }
}
