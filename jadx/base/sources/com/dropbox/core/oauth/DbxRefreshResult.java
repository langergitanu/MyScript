package com.dropbox.core.oauth;

import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class DbxRefreshResult {
    public static final JsonReader<DbxRefreshResult> Reader = new JsonReader<DbxRefreshResult>() { // from class: com.dropbox.core.oauth.DbxRefreshResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public DbxRefreshResult read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            String field = null;
            String field2 = null;
            Long field3 = null;
            String field4 = null;
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
                    } else if (currentName.equals("scope")) {
                        field4 = JsonReader.StringReader.readField(jsonParser, currentName, field4);
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
            if (field3 == null) {
                throw new JsonReadException("missing field \"expires_in\"", jsonLocationExpectObjectStart);
            }
            return new DbxRefreshResult(field2, field3.longValue(), field4);
        }
    };
    private final String accessToken;
    private final long expiresIn;
    private long issueTime;
    private String scope;

    public DbxRefreshResult(String str, long j) {
        this(str, j, null);
    }

    public DbxRefreshResult(String str, long j, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("access token can't be null.");
        }
        this.accessToken = str;
        this.expiresIn = j;
        this.issueTime = System.currentTimeMillis();
        this.scope = str2;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long getExpiresAt() {
        return Long.valueOf(this.issueTime + (this.expiresIn * 1000));
    }

    public String getScope() {
        return this.scope;
    }

    void setIssueTime(long j) {
        this.issueTime = j;
    }
}
