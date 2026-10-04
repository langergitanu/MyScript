package com.dropbox.core.oauth;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.p013v2.DbxRawClientV2;
import com.dropbox.core.util.StringUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class DbxCredential {
    public static final long EXPIRE_MARGIN = 300000;
    public static final JsonReader<DbxCredential> Reader = new JsonReader<DbxCredential>() { // from class: com.dropbox.core.oauth.DbxCredential.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public final DbxCredential read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            String field = null;
            Long field2 = null;
            String field3 = null;
            String field4 = null;
            String field5 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                try {
                    if (currentName.equals("access_token")) {
                        field = StringReader.readField(jsonParser, currentName, field);
                    } else if (currentName.equals("expires_at")) {
                        field2 = Int64Reader.readField(jsonParser, currentName, field2);
                    } else if (currentName.equals("refresh_token")) {
                        field3 = StringReader.readField(jsonParser, currentName, field3);
                    } else if (currentName.equals("app_key")) {
                        field4 = StringReader.readField(jsonParser, currentName, field4);
                    } else if (currentName.equals("app_secret")) {
                        field5 = StringReader.readField(jsonParser, currentName, field5);
                    } else {
                        JsonReader.skipValue(jsonParser);
                    }
                } catch (JsonReadException e) {
                    throw e.addFieldContext(currentName);
                }
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (field == null) {
                throw new JsonReadException("missing field \"access_token\"", jsonLocationExpectObjectStart);
            }
            return new DbxCredential(field, field2, field3, field4, field5);
        }
    };
    public static final JsonWriter<DbxCredential> Writer = new JsonWriter<DbxCredential>() { // from class: com.dropbox.core.oauth.DbxCredential.3
        @Override // com.dropbox.core.json.JsonWriter
        public void write(DbxCredential dbxCredential, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("access_token", dbxCredential.accessToken);
            if (dbxCredential.expiresAt != null) {
                jsonGenerator.writeNumberField("expires_at", dbxCredential.expiresAt.longValue());
            }
            if (dbxCredential.refreshToken != null) {
                jsonGenerator.writeStringField("refresh_token", dbxCredential.refreshToken);
            }
            if (dbxCredential.appKey != null) {
                jsonGenerator.writeStringField("app_key", dbxCredential.appKey);
            }
            if (dbxCredential.appSecret != null) {
                jsonGenerator.writeStringField("app_secret", dbxCredential.appSecret);
            }
            jsonGenerator.writeEndObject();
        }
    };
    private String accessToken;
    private final String appKey;
    private final String appSecret;
    private Long expiresAt;
    private final String refreshToken;

    public DbxCredential(String str) {
        this(str, null, null, null, null);
    }

    public DbxCredential(String str, Long l, String str2, String str3) {
        this(str, l, str2, str3, null);
    }

    public DbxCredential(String str, Long l, String str2, String str3, String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Missing access token.");
        }
        if (str2 != null && str3 == null) {
            throw new IllegalArgumentException("Can't refresh without app Key.");
        }
        if (str2 != null && l == null) {
            throw new IllegalArgumentException("Missing expireAt.");
        }
        this.accessToken = str;
        this.expiresAt = l;
        this.refreshToken = str2;
        this.appKey = str3;
        this.appSecret = str4;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long getExpiresAt() {
        return this.expiresAt;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public boolean aboutToExpire() {
        return getExpiresAt() != null && System.currentTimeMillis() + 300000 > getExpiresAt().longValue();
    }

    public DbxRefreshResult refresh(DbxRequestConfig dbxRequestConfig, DbxHost dbxHost, Collection<String> collection) throws DbxException {
        if (this.refreshToken == null) {
            throw new DbxOAuthException(null, new DbxOAuthError(DbxOAuthError.INVALID_REQUEST, "Cannot refresh becasue there is no refresh token"));
        }
        if (this.appKey == null) {
            throw new IllegalStateException("DbxCredential's constructor should always guarantee appKey is not null if refreshToken is not null.");
        }
        HashMap map = new HashMap();
        map.put("grant_type", "refresh_token");
        map.put("refresh_token", this.refreshToken);
        map.put("locale", dbxRequestConfig.getUserLocale());
        ArrayList arrayList = new ArrayList();
        String str = this.appSecret;
        if (str == null) {
            map.put("client_id", this.appKey);
        } else {
            DbxRequestUtil.addBasicAuthHeader(arrayList, this.appKey, str);
        }
        if (collection != null) {
            map.put("scope", StringUtil.join(collection, " "));
        }
        DbxRefreshResult dbxRefreshResult = (DbxRefreshResult) DbxRequestUtil.doPostNoAuth(dbxRequestConfig, DbxRawClientV2.USER_AGENT_ID, dbxHost.getApi(), "oauth2/token", DbxRequestUtil.toParamsArray(map), arrayList, new DbxRequestUtil.ResponseHandler<DbxRefreshResult>() { // from class: com.dropbox.core.oauth.DbxCredential.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public DbxRefreshResult handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw new DbxOAuthException(DbxRequestUtil.getRequestId(response), (DbxOAuthError) DbxRequestUtil.readJsonFromResponse(DbxOAuthError.Reader, response));
                }
                return (DbxRefreshResult) DbxRequestUtil.readJsonFromResponse(DbxRefreshResult.Reader, response);
            }
        });
        synchronized (this) {
            this.accessToken = dbxRefreshResult.getAccessToken();
            this.expiresAt = dbxRefreshResult.getExpiresAt();
        }
        return dbxRefreshResult;
    }

    public DbxRefreshResult refresh(DbxRequestConfig dbxRequestConfig) throws DbxException {
        return refresh(dbxRequestConfig, DbxHost.DEFAULT, null);
    }

    public DbxRefreshResult refresh(DbxRequestConfig dbxRequestConfig, Collection<String> collection) throws DbxException {
        return refresh(dbxRequestConfig, DbxHost.DEFAULT, collection);
    }

    public String toString() {
        return Writer.writeToString(this);
    }
}
