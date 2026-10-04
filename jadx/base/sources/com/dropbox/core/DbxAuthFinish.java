package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.StringUtil;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.auth.http.AuthHttpConstants;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxAuthFinish {
    private final String accessToken;
    private final String accountId;
    private final Long expiresIn;
    private long issueTime;
    private final String refreshToken;
    private final String scope;
    private final String teamId;
    private final String urlState;
    private final String userId;
    public static final JsonReader<DbxAuthFinish> Reader = new JsonReader<DbxAuthFinish>() { // from class: com.dropbox.core.DbxAuthFinish.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public DbxAuthFinish read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            String field = null;
            String field2 = null;
            Long field3 = null;
            String field4 = null;
            String field5 = null;
            String field6 = null;
            String field7 = null;
            String field8 = null;
            String field9 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                JsonReader.nextToken(jsonParser);
                try {
                    if (currentName.equals("token_type")) {
                        field = DbxAuthFinish.BearerTokenTypeReader.readField(jsonParser, currentName, field);
                    } else if (currentName.equals("access_token")) {
                        field2 = DbxAuthFinish.AccessTokenReader.readField(jsonParser, currentName, field2);
                    } else if (currentName.equals("expires_in")) {
                        field3 = JsonReader.UInt64Reader.readField(jsonParser, currentName, field3);
                    } else if (currentName.equals("refresh_token")) {
                        field4 = JsonReader.StringReader.readField(jsonParser, currentName, field4);
                    } else if (currentName.equals("uid")) {
                        field5 = JsonReader.StringReader.readField(jsonParser, currentName, field5);
                    } else if (currentName.equals("account_id")) {
                        field7 = JsonReader.StringReader.readField(jsonParser, currentName, field7);
                    } else if (currentName.equals("team_id")) {
                        field6 = JsonReader.StringReader.readField(jsonParser, currentName, field6);
                    } else if (currentName.equals("state")) {
                        field8 = JsonReader.StringReader.readField(jsonParser, currentName, field8);
                    } else if (currentName.equals("scope")) {
                        field9 = JsonReader.StringReader.readField(jsonParser, currentName, field9);
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
            if (field2 == null) {
                throw new JsonReadException("missing field \"access_token\"", jsonLocationExpectObjectStart);
            }
            if (field5 == null) {
                throw new JsonReadException("missing field \"uid\"", jsonLocationExpectObjectStart);
            }
            if (field7 == null && field6 == null) {
                throw new JsonReadException("missing field \"account_id\" and missing field \"team_id\"", jsonLocationExpectObjectStart);
            }
            if (field4 != null && field3 == null) {
                throw new JsonReadException("missing field \"expires_in\"", jsonLocationExpectObjectStart);
            }
            return new DbxAuthFinish(field2, field3, field4, field5, field6, field7, field8, field9);
        }
    };
    public static final JsonReader<String> BearerTokenTypeReader = new JsonReader<String>() { // from class: com.dropbox.core.DbxAuthFinish.2
        @Override // com.dropbox.core.json.JsonReader
        public String read(JsonParser jsonParser) throws JsonReadException, IOException {
            try {
                String text = jsonParser.getText();
                if (!text.equals(AuthHttpConstants.BEARER) && !text.equals("bearer")) {
                    throw new JsonReadException("expecting \"Bearer\": got " + StringUtil.m531jq(text), jsonParser.getTokenLocation());
                }
                jsonParser.nextToken();
                return text;
            } catch (JsonParseException e) {
                throw JsonReadException.fromJackson(e);
            }
        }
    };
    public static final JsonReader<String> AccessTokenReader = new JsonReader<String>() { // from class: com.dropbox.core.DbxAuthFinish.3
        @Override // com.dropbox.core.json.JsonReader
        public String read(JsonParser jsonParser) throws JsonReadException, IOException {
            try {
                String text = jsonParser.getText();
                String tokenPartError = DbxAppInfo.getTokenPartError(text);
                if (tokenPartError != null) {
                    throw new JsonReadException(tokenPartError, jsonParser.getTokenLocation());
                }
                jsonParser.nextToken();
                return text;
            } catch (JsonParseException e) {
                throw JsonReadException.fromJackson(e);
            }
        }
    };

    @Deprecated
    public DbxAuthFinish(String str, String str2, String str3, String str4, String str5) {
        this(str, null, null, str2, str4, str3, str5);
    }

    public DbxAuthFinish(String str, Long l, String str2, String str3, String str4, String str5, String str6) {
        this(str, l, str2, str3, str4, str5, str6, null);
    }

    public DbxAuthFinish(String str, Long l, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.accessToken = str;
        this.expiresIn = l;
        this.refreshToken = str2;
        this.userId = str3;
        this.accountId = str5;
        this.teamId = str4;
        this.urlState = str6;
        this.issueTime = System.currentTimeMillis();
        this.scope = str7;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long getExpiresAt() {
        Long l = this.expiresIn;
        if (l == null) {
            return null;
        }
        return Long.valueOf(this.issueTime + (l.longValue() * 1000));
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getScope() {
        return this.scope;
    }

    public String getUrlState() {
        return this.urlState;
    }

    void setIssueTime(long j) {
        this.issueTime = j;
    }

    DbxAuthFinish withUrlState(String str) {
        if (this.urlState != null) {
            throw new IllegalStateException("Already have URL state.");
        }
        DbxAuthFinish dbxAuthFinish = new DbxAuthFinish(this.accessToken, this.expiresIn, this.refreshToken, this.userId, this.teamId, this.accountId, str, this.scope);
        dbxAuthFinish.setIssueTime(this.issueTime);
        return dbxAuthFinish;
    }
}
