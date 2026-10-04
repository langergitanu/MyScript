package com.revenuecat.purchases.common.localrules;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: RulesDimensionProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/localrules/RulesDimensionNamespace;", "", SubscriberAttributeKt.JSON_NAME_KEY, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", TypedValues.Custom.NAME, "Device", "Store", "SubscriberAttributes", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public enum RulesDimensionNamespace {
    Custom(Keys.CUSTOM),
    Device("device"),
    Store("store"),
    SubscriberAttributes("subscriberAttributes");

    private final String key;

    RulesDimensionNamespace(String str) {
        this.key = str;
    }

    public final String getKey() {
        return this.key;
    }
}
