package com.dropbox.core;

import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.p012v1.DbxClientV1;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxOAuth1Upgrader {
    public static final JsonReader<String> ResponseReader = new JsonReader<String>() { // from class: com.dropbox.core.DbxOAuth1Upgrader.3
        @Override // com.dropbox.core.json.JsonReader
        public String read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            String field = null;
            String field2 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                JsonReader.nextToken(jsonParser);
                try {
                    if (currentName.equals("token_type")) {
                        field = DbxAuthFinish.BearerTokenTypeReader.readField(jsonParser, currentName, field);
                    } else if (currentName.equals("access_token")) {
                        field2 = DbxAuthFinish.AccessTokenReader.readField(jsonParser, currentName, field2);
                    } else {
                        JsonReader.skipValue(jsonParser);
                    }
                } catch (JsonReadException e) {
                    throw e.addFieldContext(currentName);
                }
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (field == null) {
                throw new JsonReadException("missing field \"token_type\"", jsonLocationExpectObjectStart);
            }
            if (field2 != null) {
                return field2;
            }
            throw new JsonReadException("missing field \"access_token\"", jsonLocationExpectObjectStart);
        }
    };
    private final DbxAppInfo appInfo;
    private final DbxRequestConfig requestConfig;

    public DbxOAuth1Upgrader(DbxRequestConfig dbxRequestConfig, DbxAppInfo dbxAppInfo) {
        if (dbxRequestConfig == null) {
            throw new IllegalArgumentException("'requestConfig' is null");
        }
        if (dbxAppInfo == null) {
            throw new IllegalArgumentException("'appInfo' is null");
        }
        this.requestConfig = dbxRequestConfig;
        this.appInfo = dbxAppInfo;
    }

    public String createOAuth2AccessToken(DbxOAuth1AccessToken dbxOAuth1AccessToken) throws DbxException {
        if (dbxOAuth1AccessToken == null) {
            throw new IllegalArgumentException("'token' can't be null");
        }
        return (String) DbxRequestUtil.doPostNoAuth(this.requestConfig, DbxClientV1.USER_AGENT_ID, this.appInfo.getHost().getApi(), "1/oauth2/token_from_oauth1", null, getHeaders(dbxOAuth1AccessToken), new DbxRequestUtil.ResponseHandler<String>() { // from class: com.dropbox.core.DbxOAuth1Upgrader.1
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public String handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() != 200) {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
                return (String) DbxRequestUtil.readJsonFromResponse(DbxOAuth1Upgrader.ResponseReader, response);
            }
        });
    }

    public void disableOAuth1AccessToken(DbxOAuth1AccessToken dbxOAuth1AccessToken) throws DbxException {
        if (dbxOAuth1AccessToken == null) {
            throw new IllegalArgumentException("'token' can't be null");
        }
        DbxRequestUtil.doPostNoAuth(this.requestConfig, DbxClientV1.USER_AGENT_ID, this.appInfo.getHost().getApi(), "1/disable_access_token", null, getHeaders(dbxOAuth1AccessToken), new DbxRequestUtil.ResponseHandler<Void>() { // from class: com.dropbox.core.DbxOAuth1Upgrader.2
            @Override // com.dropbox.core.DbxRequestUtil.ResponseHandler
            public Void handle(HttpRequestor.Response response) throws DbxException {
                if (response.getStatusCode() == 200) {
                    return null;
                }
                throw DbxRequestUtil.unexpectedStatus(response);
            }
        });
    }

    private ArrayList<HttpRequestor.Header> getHeaders(DbxOAuth1AccessToken dbxOAuth1AccessToken) {
        ArrayList<HttpRequestor.Header> arrayList = new ArrayList<>(1);
        arrayList.add(new HttpRequestor.Header("Authorization", buildOAuth1Header(dbxOAuth1AccessToken)));
        return arrayList;
    }

    private String buildOAuth1Header(DbxOAuth1AccessToken dbxOAuth1AccessToken) {
        StringBuilder sb = new StringBuilder("OAuth oauth_version=\"1.0\", oauth_signature_method=\"PLAINTEXT\", oauth_consumer_key=\"");
        sb.append(encode(this.appInfo.getKey())).append("\", oauth_token=\"");
        sb.append(encode(dbxOAuth1AccessToken.getKey())).append("\", oauth_signature=\"");
        sb.append(encode(this.appInfo.getSecret())).append("&").append(encode(dbxOAuth1AccessToken.getSecret())).append("\"");
        return sb.toString();
    }

    private static String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw LangUtil.mkAssert("UTF-8 should always be supported", e);
        }
    }
}
