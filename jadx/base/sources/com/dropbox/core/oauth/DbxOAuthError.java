package com.dropbox.core.oauth;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class DbxOAuthError {
    public static final String UNKNOWN = "unknown";
    private final String error;
    private final String errorDescription;
    public static final String INVALID_REQUEST = "invalid_request";
    public static final String INVALID_GRANT = "invalid_grant";
    public static final String UNSUPPORTED_GRANT_TYPE = "unsupported_grant_type";
    public static final Set<String> ERRORS = new HashSet(Arrays.asList(INVALID_REQUEST, INVALID_GRANT, UNSUPPORTED_GRANT_TYPE));
    public static final JsonReader<DbxOAuthError> Reader = new JsonReader<DbxOAuthError>() { // from class: com.dropbox.core.oauth.DbxOAuthError.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public final DbxOAuthError read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            String field = null;
            String field2 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                try {
                    if (currentName.equals("error")) {
                        field = StringReader.readField(jsonParser, currentName, field);
                    } else if (currentName.equals("error_description")) {
                        field2 = StringReader.readField(jsonParser, currentName, field2);
                    } else {
                        JsonReader.skipValue(jsonParser);
                    }
                } catch (JsonReadException e) {
                    throw e.addFieldContext(currentName);
                }
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (field == null) {
                throw new JsonReadException("missing field \"error\"", jsonLocationExpectObjectStart);
            }
            return new DbxOAuthError(field, field2);
        }
    };

    public DbxOAuthError(String str, String str2) {
        if (ERRORS.contains(str)) {
            this.error = str;
        } else {
            this.error = "unknown";
        }
        this.errorDescription = str2;
    }

    public String getError() {
        return this.error;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }
}
