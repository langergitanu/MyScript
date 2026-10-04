package com.dropbox.core;

import androidx.browser.customtabs.CustomTabsCallback;

/* JADX INFO: loaded from: classes4.dex */
public enum TokenAccessType {
    ONLINE(CustomTabsCallback.ONLINE_EXTRAS_KEY),
    OFFLINE("offline");

    private String string;

    TokenAccessType(String str) {
        this.string = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.string;
    }
}
