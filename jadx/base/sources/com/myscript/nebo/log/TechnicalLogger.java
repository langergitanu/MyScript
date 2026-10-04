package com.myscript.nebo.log;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: TechnicalLogger.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J\u0014\u0010\n\u001a\u00020\u00032\n\u0010\u000b\u001a\u00060\fj\u0002`\rH&¨\u0006\u000eÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/log/TechnicalLogger;", "", "logTrace", "", "trace", "", "setKeyValue", SubscriberAttributeKt.JSON_NAME_KEY, "value", "setUserProperty", "logError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logging"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface TechnicalLogger {
    void logError(Exception exception);

    void logTrace(String trace);

    void setKeyValue(String key, String value);

    void setUserProperty(String key, String value);
}
