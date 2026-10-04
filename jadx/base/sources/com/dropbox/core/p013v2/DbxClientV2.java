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
public class DbxClientV2 extends DbxClientV2Base {
    public DbxClientV2(DbxRequestConfig dbxRequestConfig, String str) {
        this(dbxRequestConfig, str, DbxHost.DEFAULT, null);
    }

    public DbxClientV2(DbxRequestConfig dbxRequestConfig, String str, String str2) {
        this(dbxRequestConfig, str, DbxHost.DEFAULT, str2);
    }

    public DbxClientV2(DbxRequestConfig dbxRequestConfig, DbxCredential dbxCredential) {
        this(dbxRequestConfig, dbxCredential, DbxHost.DEFAULT, null, null);
    }

    public DbxClientV2(DbxRequestConfig dbxRequestConfig, String str, DbxHost dbxHost) {
        this(dbxRequestConfig, str, dbxHost, null);
    }

    public DbxClientV2(DbxRequestConfig dbxRequestConfig, String str, DbxHost dbxHost, String str2) {
        this(dbxRequestConfig, new DbxCredential(str), dbxHost, str2, null);
    }

    private DbxClientV2(DbxRequestConfig dbxRequestConfig, DbxCredential dbxCredential, DbxHost dbxHost, String str, PathRoot pathRoot) {
        super(new DbxUserRawClientV2(dbxRequestConfig, dbxCredential, dbxHost, str, pathRoot));
    }

    DbxClientV2(DbxRawClientV2 dbxRawClientV2) {
        super(dbxRawClientV2);
    }

    public DbxClientV2 withPathRoot(PathRoot pathRoot) {
        if (pathRoot == null) {
            throw new IllegalArgumentException("'pathRoot' should not be null");
        }
        return new DbxClientV2(this._client.withPathRoot(pathRoot));
    }

    public DbxRefreshResult refreshAccessToken() throws DbxException {
        return this._client.refreshAccessToken();
    }

    private static final class DbxUserRawClientV2 extends DbxRawClientV2 {
        private final DbxCredential credential;

        DbxUserRawClientV2(DbxRequestConfig dbxRequestConfig, DbxCredential dbxCredential, DbxHost dbxHost, String str, PathRoot pathRoot) {
            super(dbxRequestConfig, dbxHost, str, pathRoot);
            if (dbxCredential == null) {
                throw new NullPointerException("credential");
            }
            this.credential = dbxCredential;
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
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        protected DbxRawClientV2 withPathRoot(PathRoot pathRoot) {
            return new DbxUserRawClientV2(getRequestConfig(), this.credential, getHost(), getUserId(), pathRoot);
        }
    }
}
