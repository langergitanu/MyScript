package com.dropbox.core.p013v2;

import com.dropbox.core.p013v2.account.DbxUserAccountRequests;
import com.dropbox.core.p013v2.auth.DbxUserAuthRequests;
import com.dropbox.core.p013v2.check.DbxUserCheckRequests;
import com.dropbox.core.p013v2.contacts.DbxUserContactsRequests;
import com.dropbox.core.p013v2.fileproperties.DbxUserFilePropertiesRequests;
import com.dropbox.core.p013v2.filerequests.DbxUserFileRequestsRequests;
import com.dropbox.core.p013v2.files.DbxUserFilesRequests;
import com.dropbox.core.p013v2.openid.DbxUserOpenidRequests;
import com.dropbox.core.p013v2.paper.DbxUserPaperRequests;
import com.dropbox.core.p013v2.sharing.DbxUserSharingRequests;
import com.dropbox.core.p013v2.users.DbxUserUsersRequests;

/* JADX INFO: loaded from: classes4.dex */
public class DbxClientV2Base {
    protected final DbxRawClientV2 _client;
    private final DbxUserAccountRequests account;
    private final DbxUserAuthRequests auth;
    private final DbxUserCheckRequests check;
    private final DbxUserContactsRequests contacts;
    private final DbxUserFilePropertiesRequests fileProperties;
    private final DbxUserFileRequestsRequests fileRequests;
    private final DbxUserFilesRequests files;
    private final DbxUserOpenidRequests openid;
    private final DbxUserPaperRequests paper;
    private final DbxUserSharingRequests sharing;
    private final DbxUserUsersRequests users;

    protected DbxClientV2Base(DbxRawClientV2 dbxRawClientV2) {
        this._client = dbxRawClientV2;
        this.account = new DbxUserAccountRequests(dbxRawClientV2);
        this.auth = new DbxUserAuthRequests(dbxRawClientV2);
        this.check = new DbxUserCheckRequests(dbxRawClientV2);
        this.contacts = new DbxUserContactsRequests(dbxRawClientV2);
        this.fileProperties = new DbxUserFilePropertiesRequests(dbxRawClientV2);
        this.fileRequests = new DbxUserFileRequestsRequests(dbxRawClientV2);
        this.files = new DbxUserFilesRequests(dbxRawClientV2);
        this.openid = new DbxUserOpenidRequests(dbxRawClientV2);
        this.paper = new DbxUserPaperRequests(dbxRawClientV2);
        this.sharing = new DbxUserSharingRequests(dbxRawClientV2);
        this.users = new DbxUserUsersRequests(dbxRawClientV2);
    }

    public DbxUserAccountRequests account() {
        return this.account;
    }

    public DbxUserAuthRequests auth() {
        return this.auth;
    }

    public DbxUserCheckRequests check() {
        return this.check;
    }

    public DbxUserContactsRequests contacts() {
        return this.contacts;
    }

    public DbxUserFilePropertiesRequests fileProperties() {
        return this.fileProperties;
    }

    public DbxUserFileRequestsRequests fileRequests() {
        return this.fileRequests;
    }

    public DbxUserFilesRequests files() {
        return this.files;
    }

    public DbxUserOpenidRequests openid() {
        return this.openid;
    }

    public DbxUserPaperRequests paper() {
        return this.paper;
    }

    public DbxUserSharingRequests sharing() {
        return this.sharing;
    }

    public DbxUserUsersRequests users() {
        return this.users;
    }
}
