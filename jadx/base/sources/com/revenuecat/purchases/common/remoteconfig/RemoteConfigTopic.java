package com.revenuecat.purchases.common.remoteconfig;

import com.revenuecat.purchases.common.events.BackendEvent;
import kotlin.Metadata;

/* JADX INFO: compiled from: RemoteConfigTopic.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigTopic;", "", "wireName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireName", "()Ljava/lang/String;", "Workflows", "UiConfig", "Sources", "CheckpointRules", "Audiences", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public enum RemoteConfigTopic {
    Workflows(BackendEvent.WORKFLOW_EVENT_TYPE),
    UiConfig("ui_config"),
    Sources("sources"),
    CheckpointRules("checkpoint_rules"),
    Audiences("audiences");

    private final String wireName;

    RemoteConfigTopic(String str) {
        this.wireName = str;
    }

    public final String getWireName() {
        return this.wireName;
    }
}
