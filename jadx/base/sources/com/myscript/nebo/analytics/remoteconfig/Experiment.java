package com.myscript.nebo.analytics.remoteconfig;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: Experiment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m1599d2 = {"Lcom/myscript/nebo/analytics/remoteconfig/Experiment;", "", "<init>", "()V", "defaults", "", "", "getDefaults", "()Ljava/util/Map;", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public final class Experiment {
    public static final Experiment INSTANCE = new Experiment();
    private static final Map<String, Object> defaults = MapsKt.emptyMap();

    private Experiment() {
    }

    public final Map<String, Object> getDefaults() {
        return defaults;
    }
}
