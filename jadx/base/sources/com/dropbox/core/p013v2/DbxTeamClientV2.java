package com.dropbox.core.p013v2;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.oauth.DbxRefreshResult;
import com.dropbox.core.p013v2.common.PathRoot;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DbxTeamClientV2 extends DbxTeamClientV2Base {
    private final DbxCredential credential;

    public DbxTeamClientV2(DbxRequestConfig dbxRequestConfig, String str) {
        this(dbxRequestConfig, str, DbxHost.DEFAULT);
    }

    public DbxTeamClientV2(DbxRequestConfig dbxRequestConfig, String str, DbxHost dbxHost) {
        this(dbxRequestConfig, str, dbxHost, (String) null);
    }

    public DbxTeamClientV2(DbxRequestConfig dbxRequestConfig, DbxCredential dbxCredential) {
        this(dbxRequestConfig, dbxCredential, DbxHost.DEFAULT, (String) null);
    }

    public DbxTeamClientV2(DbxRequestConfig dbxRequestConfig, String str, DbxHost dbxHost, String str2) {
        this(dbxRequestConfig, new DbxCredential(str), dbxHost, str2);
    }

    public DbxTeamClientV2(DbxRequestConfig dbxRequestConfig, DbxCredential dbxCredential, DbxHost dbxHost, String str) {
        super(new DbxTeamRawClientV2(dbxRequestConfig, dbxCredential, dbxHost, str, null, null, null));
        this.credential = dbxCredential;
    }

    public DbxRefreshResult refreshAccessToken() throws DbxException {
        return this._client.refreshAccessToken();
    }

    public DbxClientV2 asMember(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'memberId' should not be null");
        }
        return new DbxClientV2(new DbxTeamRawClientV2(this._client.getRequestConfig(), this.credential, this._client.getHost(), this._client.getUserId(), str, null, null));
    }

    public DbxClientV2 asAdmin(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'adminId' should not be null");
        }
        return new DbxClientV2(new DbxTeamRawClientV2(this._client.getRequestConfig(), this.credential, this._client.getHost(), this._client.getUserId(), null, str, null));
    }

    private static final class DbxTeamRawClientV2 extends DbxRawClientV2 {
        private final String adminId;
        private final DbxCredential credential;
        private final String memberId;

        private DbxTeamRawClientV2(DbxRequestConfig dbxRequestConfig, DbxCredential dbxCredential, DbxHost dbxHost, String str, String str2, String str3, PathRoot pathRoot) {
            super(dbxRequestConfig, dbxHost, str, pathRoot);
            if (dbxCredential == null) {
                throw new NullPointerException("credential");
            }
            this.credential = dbxCredential;
            this.memberId = str2;
            this.adminId = str3;
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        public DbxRefreshResult refreshAccessToken() throws DbxException {
            this.credential.refresh(getRequestConfig());
            return new DbxRefreshResult(this.credential.getAccessToken(), (this.credential.getExpiresAt().longValue() - System.currentTimeMillis()) / 1000);
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        public boolean canRefreshAccessToken() {
            return this.credential.getRefreshToken() != null;
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        public boolean needsRefreshAccessToken() {
            return canRefreshAccessToken() && this.credential.aboutToExpire();
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        protected void addAuthHeaders(List<HttpRequestor.Header> list) {
            DbxRequestUtil.removeAuthHeader(list);
            DbxRequestUtil.addAuthHeader(list, this.credential.getAccessToken());
            String str = this.memberId;
            if (str != null) {
                DbxRequestUtil.addSelectUserHeader(list, str);
            }
            String str2 = this.adminId;
            if (str2 != null) {
                DbxRequestUtil.addSelectAdminHeader(list, str2);
            }
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        protected DbxRawClientV2 withPathRoot(PathRoot pathRoot) {
            return new DbxTeamRawClientV2(getRequestConfig(), this.credential, getHost(), getUserId(), this.memberId, this.adminId, pathRoot);
        }
    }
}
