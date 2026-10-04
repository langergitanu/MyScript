package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.DumpWriter;
import com.dropbox.core.util.Dumpable;
import com.dropbox.core.util.StringUtil;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class DbxAppInfo extends Dumpable {
    private final DbxHost host;
    private final String key;
    private final String secret;
    public static final JsonReader<DbxAppInfo> Reader = new JsonReader<DbxAppInfo>() { // from class: com.dropbox.core.DbxAppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public final DbxAppInfo read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            String field = null;
            DbxHost field2 = null;
            String field3 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                try {
                    if (currentName.equals(SubscriberAttributeKt.JSON_NAME_KEY)) {
                        field = DbxAppInfo.KeyReader.readField(jsonParser, currentName, field);
                    } else if (currentName.equals("secret")) {
                        field3 = DbxAppInfo.SecretReader.readField(jsonParser, currentName, field3);
                    } else if (currentName.equals(DiagnosticsTracker.HOST_KEY)) {
                        field2 = DbxHost.Reader.readField(jsonParser, currentName, field2);
                    } else {
                        JsonReader.skipValue(jsonParser);
                    }
                } catch (JsonReadException e) {
                    throw e.addFieldContext(currentName);
                }
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (field == null) {
                throw new JsonReadException("missing field \"key\"", jsonLocationExpectObjectStart);
            }
            if (field2 == null) {
                field2 = DbxHost.DEFAULT;
            }
            return new DbxAppInfo(field, field3, field2);
        }
    };
    public static final JsonReader<String> KeyReader = new JsonReader<String>() { // from class: com.dropbox.core.DbxAppInfo.2
        @Override // com.dropbox.core.json.JsonReader
        public String read(JsonParser jsonParser) throws JsonReadException, IOException {
            try {
                String text = jsonParser.getText();
                String keyFormatError = DbxAppInfo.getKeyFormatError(text);
                if (keyFormatError != null) {
                    throw new JsonReadException("bad format for app key: " + keyFormatError, jsonParser.getTokenLocation());
                }
                jsonParser.nextToken();
                return text;
            } catch (JsonParseException e) {
                throw JsonReadException.fromJackson(e);
            }
        }
    };
    public static final JsonReader<String> SecretReader = new JsonReader<String>() { // from class: com.dropbox.core.DbxAppInfo.3
        @Override // com.dropbox.core.json.JsonReader
        public String read(JsonParser jsonParser) throws JsonReadException, IOException {
            try {
                String text = jsonParser.getText();
                String keyFormatError = DbxAppInfo.getKeyFormatError(text);
                if (keyFormatError != null) {
                    throw new JsonReadException("bad format for app secret: " + keyFormatError, jsonParser.getTokenLocation());
                }
                jsonParser.nextToken();
                return text;
            } catch (JsonParseException e) {
                throw JsonReadException.fromJackson(e);
            }
        }
    };

    public DbxAppInfo(String str) {
        this(str, null);
    }

    public DbxAppInfo(String str, String str2) {
        checkKeyArg(str);
        checkSecretArg(str2);
        this.key = str;
        this.secret = str2;
        this.host = DbxHost.DEFAULT;
    }

    public DbxAppInfo(String str, String str2, DbxHost dbxHost) {
        checkKeyArg(str);
        checkSecretArg(str2);
        this.key = str;
        this.secret = str2;
        this.host = dbxHost;
    }

    public String getKey() {
        return this.key;
    }

    public String getSecret() {
        return this.secret;
    }

    public DbxHost getHost() {
        return this.host;
    }

    public boolean hasSecret() {
        return this.secret != null;
    }

    @Override // com.dropbox.core.util.Dumpable
    protected void dumpFields(DumpWriter dumpWriter) {
        dumpWriter.mo519f(SubscriberAttributeKt.JSON_NAME_KEY).m527v(this.key);
        dumpWriter.mo519f("secret").m527v(this.secret);
    }

    public static String getKeyFormatError(String str) {
        return getTokenPartError(str);
    }

    public static String getSecretFormatError(String str) {
        return getTokenPartError(str);
    }

    public static String getTokenPartError(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "can't be empty";
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '!' || cCharAt > '~') {
                return "invalid character at index " + i + ": " + StringUtil.m531jq("" + cCharAt);
            }
        }
        return null;
    }

    public static void checkKeyArg(String str) {
        String tokenPartError;
        if (str == null) {
            tokenPartError = "can't be null";
        } else {
            tokenPartError = getTokenPartError(str);
        }
        if (tokenPartError != null) {
            throw new IllegalArgumentException("Bad 'key': " + tokenPartError);
        }
    }

    public static void checkSecretArg(String str) {
        String tokenPartError = getTokenPartError(str);
        if (tokenPartError != null) {
            throw new IllegalArgumentException("Bad 'secret': " + tokenPartError);
        }
    }
}
