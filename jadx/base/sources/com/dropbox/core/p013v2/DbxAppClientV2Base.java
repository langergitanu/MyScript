package com.dropbox.core.p013v2;

import com.dropbox.core.p013v2.auth.DbxAppAuthRequests;
import com.dropbox.core.p013v2.check.DbxAppCheckRequests;
import com.dropbox.core.p013v2.files.DbxAppFilesRequests;
import com.dropbox.core.p013v2.sharing.DbxAppSharingRequests;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppClientV2Base {
    protected final DbxRawClientV2 _client;
    private final DbxAppAuthRequests auth;
    private final DbxAppCheckRequests check;
    private final DbxAppFilesRequests files;
    private final DbxAppSharingRequests sharing;

    protected DbxAppClientV2Base(DbxRawClientV2 dbxRawClientV2) {
        this._client = dbxRawClientV2;
        this.auth = new DbxAppAuthRequests(dbxRawClientV2);
        this.check = new DbxAppCheckRequests(dbxRawClientV2);
        this.files = new DbxAppFilesRequests(dbxRawClientV2);
        this.sharing = new DbxAppSharingRequests(dbxRawClientV2);
    }

    public DbxAppAuthRequests auth() {
        return this.auth;
    }

    public DbxAppCheckRequests check() {
        return this.check;
    }

    public DbxAppFilesRequests files() {
        return this.files;
    }

    public DbxAppSharingRequests sharing() {
        return this.sharing;
    }
}
