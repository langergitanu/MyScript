package com.myscript.nebo.analytics.remoteconfig;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: RemoteConfigController.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1598d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H&J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/analytics/remoteconfig/RemoteConfig;", "", "getString", "", SubscriberAttributeKt.JSON_NAME_KEY, "default", "getBoolean", "", "Provider", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface RemoteConfig {

    /* JADX INFO: compiled from: RemoteConfigController.kt */
    @Metadata(m1598d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004À\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/analytics/remoteconfig/RemoteConfig$Provider;", "", "provideRemoteConfig", "Lcom/myscript/nebo/analytics/remoteconfig/RemoteConfig;", "analytics_release"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
    public interface Provider {
        RemoteConfig provideRemoteConfig();
    }

    boolean getBoolean(String key, boolean z);

    String getString(String key, String str);

    /* JADX INFO: compiled from: RemoteConfigController.kt */
    @Metadata(m1600k = 3, m1601mv = {2, 3, 0}, m1603xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ String getString$default(RemoteConfig remoteConfig, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
        }
        if ((i & 2) != 0) {
            str2 = "";
        }
        return remoteConfig.getString(str, str2);
    }

    static /* synthetic */ boolean getBoolean$default(RemoteConfig remoteConfig, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoolean");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return remoteConfig.getBoolean(str, z);
    }
}
