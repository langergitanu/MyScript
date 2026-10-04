package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxAuthInfo {
    public static final JsonReader<DbxAuthInfo> Reader = new JsonReader<DbxAuthInfo>() { // from class: com.dropbox.core.DbxAuthInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public final DbxAuthInfo read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            String field = null;
            DbxHost field2 = null;
            Long field3 = null;
            String field4 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                try {
                    if (currentName.equals(DiagnosticsTracker.HOST_KEY)) {
                        field2 = DbxHost.Reader.readField(jsonParser, currentName, field2);
                    } else if (currentName.equals("expires_at")) {
                        field3 = Int64Reader.readField(jsonParser, currentName, field3);
                    } else if (currentName.equals("refresh_token")) {
                        field4 = StringReader.readField(jsonParser, currentName, field4);
                    } else if (currentName.equals("access_token")) {
                        field = StringReader.readField(jsonParser, currentName, field);
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
            if (field2 == null) {
                field2 = DbxHost.DEFAULT;
            }
            return new DbxAuthInfo(field, field3, field4, field2);
        }
    };
    public static final JsonWriter<DbxAuthInfo> Writer = new JsonWriter<DbxAuthInfo>() { // from class: com.dropbox.core.DbxAuthInfo.2
        @Override // com.dropbox.core.json.JsonWriter
        public void write(DbxAuthInfo dbxAuthInfo, JsonGenerator jsonGenerator) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("access_token", dbxAuthInfo.accessToken);
            if (dbxAuthInfo.expiresAt != null) {
                jsonGenerator.writeNumberField("expires_at", dbxAuthInfo.expiresAt.longValue());
            }
            if (dbxAuthInfo.refreshToken != null) {
                jsonGenerator.writeStringField("refresh_token", dbxAuthInfo.refreshToken);
            }
            if (!dbxAuthInfo.host.equals(DbxHost.DEFAULT)) {
                jsonGenerator.writeFieldName(DiagnosticsTracker.HOST_KEY);
                DbxHost.Writer.write(dbxAuthInfo.host, jsonGenerator);
            }
            jsonGenerator.writeEndObject();
        }
    };
    private final String accessToken;
    private final Long expiresAt;
    private final DbxHost host;
    private final String refreshToken;

    public DbxAuthInfo(String str, DbxHost dbxHost) {
        this(str, null, null, dbxHost);
    }

    public DbxAuthInfo(String str, Long l, String str2, DbxHost dbxHost) {
        if (str == null) {
            throw new IllegalArgumentException("'accessToken' can't be null");
        }
        if (dbxHost == null) {
            throw new IllegalArgumentException("'host' can't be null");
        }
        this.accessToken = str;
        this.expiresAt = l;
        this.refreshToken = str2;
        this.host = dbxHost;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long getExpiresAt() {
        return this.expiresAt;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public DbxHost getHost() {
        return this.host;
    }
}
