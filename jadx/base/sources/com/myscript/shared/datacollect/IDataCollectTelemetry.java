package com.myscript.shared.datacollect;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: IDataCollectTelemetry.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&J\u0014\u0010\b\u001a\u00020\u00032\n\u0010\t\u001a\u00060\nj\u0002`\u000bH&¨\u0006\fÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/shared/datacollect/IDataCollectTelemetry;", "", "logEvent", "", "eventName", "", "params", "", "logException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "shared-datacollect_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface IDataCollectTelemetry {
    void logEvent(String eventName, Map<String, String> params);

    void logException(Exception exception);

    /* JADX INFO: compiled from: IDataCollectTelemetry.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void logEvent$default(IDataCollectTelemetry iDataCollectTelemetry, String str, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logEvent");
        }
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        iDataCollectTelemetry.logEvent(str, map);
    }
}
