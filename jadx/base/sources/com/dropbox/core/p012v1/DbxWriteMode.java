package com.dropbox.core.p012v1;

import androidx.credentials.provider.CredentialEntry;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxWriteMode {
    private static final DbxWriteMode AddInstance = new DbxWriteMode("overwrite", CredentialEntry.FALSE_STRING);
    private static final DbxWriteMode ForceInstance = new DbxWriteMode("overwrite", CredentialEntry.TRUE_STRING);
    final String[] params;

    DbxWriteMode(String... strArr) {
        this.params = strArr;
    }

    public static DbxWriteMode add() {
        return AddInstance;
    }

    public static DbxWriteMode force() {
        return ForceInstance;
    }

    public static DbxWriteMode update(String str) {
        return new DbxWriteMode("parent_rev", str);
    }
}
