package com.myscript.nebo.network;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: NeboNetworkStateRepositoryImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u0005H&¨\u0006\nÀ\u0006\u0003"}, m1599d2 = {"Lcom/myscript/nebo/network/PrefSaver;", "", "saveBoolean", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "value", "", "getBoolean", "defaultValue", "app_standardRelease"}, m1600k = 1, m1601mv = {2, 3, 0}, m1603xi = 48)
public interface PrefSaver {
    boolean getBoolean(int key, int defaultValue);

    void saveBoolean(int key, boolean value);
}
