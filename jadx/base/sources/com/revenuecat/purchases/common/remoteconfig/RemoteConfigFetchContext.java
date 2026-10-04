package com.revenuecat.purchases.common.remoteconfig;

import androidx.media3.exoplayer.offline.DownloadService;
import kotlin.Metadata;

/* JADX INFO: compiled from: RemoteConfigFetchContext.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m1598d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m1599d2 = {"Lcom/revenuecat/purchases/common/remoteconfig/RemoteConfigFetchContext;", "", "wireName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getWireName", "()Ljava/lang/String;", "AppStart", "Foreground", "IdentityChange", "Read", "purchases_defaultsRelease"}, m1600k = 1, m1601mv = {1, 8, 0}, m1603xi = 48)
public enum RemoteConfigFetchContext {
    AppStart("app_start"),
    Foreground(DownloadService.KEY_FOREGROUND),
    IdentityChange("identity_change"),
    Read("read");

    private final String wireName;

    RemoteConfigFetchContext(String str) {
        this.wireName = str;
    }

    public final String getWireName() {
        return this.wireName;
    }
}
