package com.dropbox.core.p013v2;

import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.oauth.DbxRefreshResult;
import com.dropbox.core.p013v2.common.PathRoot;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppClientV2 extends DbxAppClientV2Base {
    public DbxAppClientV2(DbxRequestConfig dbxRequestConfig, String str, String str2) {
        this(dbxRequestConfig, str, str2, DbxHost.DEFAULT);
    }

    public DbxAppClientV2(DbxRequestConfig dbxRequestConfig, String str, String str2, DbxHost dbxHost) {
        super(new DbxAppRawClientV2(dbxRequestConfig, str, str2, dbxHost, null));
    }

    public DbxAppClientV2(DbxRequestConfig dbxRequestConfig, String str, String str2, DbxHost dbxHost, String str3) {
        super(new DbxAppRawClientV2(dbxRequestConfig, str, str2, dbxHost, str3));
    }

    private static final class DbxAppRawClientV2 extends DbxRawClientV2 {
        private final String key;
        private final String secret;

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        public boolean canRefreshAccessToken() {
            return false;
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        public boolean needsRefreshAccessToken() {
            return false;
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        public DbxRefreshResult refreshAccessToken() {
            return null;
        }

        private DbxAppRawClientV2(DbxRequestConfig dbxRequestConfig, String str, String str2, DbxHost dbxHost, String str3) {
            super(dbxRequestConfig, dbxHost, str3, null);
            this.key = str;
            this.secret = str2;
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        protected void addAuthHeaders(List<HttpRequestor.Header> list) {
            DbxRequestUtil.removeAuthHeader(list);
            DbxRequestUtil.addBasicAuthHeader(list, this.key, this.secret);
        }

        @Override // com.dropbox.core.p013v2.DbxRawClientV2
        protected DbxRawClientV2 withPathRoot(PathRoot pathRoot) {
            throw new UnsupportedOperationException("App endpoints don't support Dropbox-API-Path-Root header.");
        }
    }
}
