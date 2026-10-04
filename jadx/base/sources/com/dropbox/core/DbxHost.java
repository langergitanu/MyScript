package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxHost {
    public static final DbxHost DEFAULT = new DbxHost("api.dropboxapi.com", "content.dropboxapi.com", "www.dropbox.com", "notify.dropboxapi.com");
    public static final JsonReader<DbxHost> Reader = new JsonReader<DbxHost>() { // from class: com.dropbox.core.DbxHost.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public DbxHost read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonToken currentToken = jsonParser.getCurrentToken();
            if (currentToken == JsonToken.VALUE_STRING) {
                String text = jsonParser.getText();
                JsonReader.nextToken(jsonParser);
                return DbxHost.fromBaseHost(text);
            }
            if (currentToken == JsonToken.START_OBJECT) {
                JsonLocation tokenLocation = jsonParser.getTokenLocation();
                nextToken(jsonParser);
                String field = null;
                String field2 = null;
                String field3 = null;
                String field4 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    try {
                        if (currentName.equals("api")) {
                            field = JsonReader.StringReader.readField(jsonParser, currentName, field);
                        } else if (currentName.equals(FirebaseAnalytics.Param.CONTENT)) {
                            field2 = JsonReader.StringReader.readField(jsonParser, currentName, field2);
                        } else if (currentName.equals("web")) {
                            field3 = JsonReader.StringReader.readField(jsonParser, currentName, field3);
                        } else if (currentName.equals("notify")) {
                            field4 = JsonReader.StringReader.readField(jsonParser, currentName, field4);
                        } else {
                            throw new JsonReadException("unknown field", jsonParser.getCurrentLocation());
                        }
                    } catch (JsonReadException e) {
                        throw e.addFieldContext(currentName);
                    }
                }
                JsonReader.expectObjectEnd(jsonParser);
                if (field == null) {
                    throw new JsonReadException("missing field \"api\"", tokenLocation);
                }
                if (field2 == null) {
                    throw new JsonReadException("missing field \"content\"", tokenLocation);
                }
                if (field3 == null) {
                    throw new JsonReadException("missing field \"web\"", tokenLocation);
                }
                if (field4 == null) {
                    throw new JsonReadException("missing field \"notify\"", tokenLocation);
                }
                return new DbxHost(field, field2, field3, field4);
            }
            throw new JsonReadException("expecting a string or an object", jsonParser.getTokenLocation());
        }
    };
    public static final JsonWriter<DbxHost> Writer = new JsonWriter<DbxHost>() { // from class: com.dropbox.core.DbxHost.2
        @Override // com.dropbox.core.json.JsonWriter
        public void write(DbxHost dbxHost, JsonGenerator jsonGenerator) throws IOException {
            String strInferBaseHost = dbxHost.inferBaseHost();
            if (strInferBaseHost != null) {
                jsonGenerator.writeString(strInferBaseHost);
                return;
            }
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("api", dbxHost.api);
            jsonGenerator.writeStringField(FirebaseAnalytics.Param.CONTENT, dbxHost.content);
            jsonGenerator.writeStringField("web", dbxHost.web);
            jsonGenerator.writeStringField("notify", dbxHost.notify);
            jsonGenerator.writeEndObject();
        }
    };
    private final String api;
    private final String content;
    private final String notify;
    private final String web;

    public DbxHost(String str, String str2, String str3, String str4) {
        this.api = str;
        this.content = str2;
        this.web = str3;
        this.notify = str4;
    }

    public String getApi() {
        return this.api;
    }

    public String getContent() {
        return this.content;
    }

    public String getWeb() {
        return this.web;
    }

    public String getNotify() {
        return this.notify;
    }

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.api, this.content, this.web, this.notify});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DbxHost) {
            DbxHost dbxHost = (DbxHost) obj;
            if (dbxHost.api.equals(this.api) && dbxHost.content.equals(this.content) && dbxHost.web.equals(this.web) && dbxHost.notify.equals(this.notify)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DbxHost fromBaseHost(String str) {
        return new DbxHost("api-" + str, "api-content-" + str, "meta-" + str, "api-notify-" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String inferBaseHost() {
        if (!this.web.startsWith("meta-") || !this.api.startsWith("api-") || !this.content.startsWith("api-content-") || !this.notify.startsWith("api-notify-")) {
            return null;
        }
        String strSubstring = this.web.substring("meta-".length());
        String strSubstring2 = this.api.substring("api-".length());
        String strSubstring3 = this.content.substring("api-content-".length());
        String strSubstring4 = this.notify.substring("api-notify-".length());
        if (strSubstring.equals(strSubstring2) && strSubstring.equals(strSubstring3) && strSubstring.equals(strSubstring4)) {
            return strSubstring;
        }
        return null;
    }
}
