package com.myscript.nebo.log;

import com.myscript.nebo.analytics.AnalyticsController;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FirebaseAnalyticsLogger.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0014\u0010\f\u001a\u00020\u00052\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fH\u0016¨\u0006\u0011"}, m1599d2 = {"Lcom/myscript/nebo/log/FirebaseAnalyticsLogger;", "Lcom/myscript/nebo/log/TechnicalLogger;", "<init>", "()V", "logTrace", "", "trace", "", "setKeyValue", SubscriberAttributeKt.JSON_NAME_KEY, "value", "setUserProperty", "logError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Companion", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class FirebaseAnalyticsLogger implements TechnicalLogger {
    public static final int $stable = 0;
    private static final String TAG = "FirebaseAnalyticsLogger";

    @Override // com.myscript.nebo.log.TechnicalLogger
    public void logTrace(String trace) {
        Intrinsics.checkNotNullParameter(trace, "trace");
        AnalyticsController.addTrace(trace);
    }

    @Override // com.myscript.nebo.log.TechnicalLogger
    public void setKeyValue(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        AnalyticsController.setKeyValue(key, value);
    }

    @Override // com.myscript.nebo.log.TechnicalLogger
    public void setUserProperty(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        AnalyticsController.setUserProperty(key, value);
    }

    @Override // com.myscript.nebo.log.TechnicalLogger
    public void logError(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        AnalyticsController.logException(exception);
    }
}
