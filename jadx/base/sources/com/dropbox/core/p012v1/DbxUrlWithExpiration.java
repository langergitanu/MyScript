package com.dropbox.core.p012v1;

import com.dropbox.core.json.JsonDateReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.Date;
import org.apache.http.cookie.ClientCookie;

/* JADX INFO: loaded from: classes4.dex */
public final class DbxUrlWithExpiration {
    public static final JsonReader<DbxUrlWithExpiration> Reader = new JsonReader<DbxUrlWithExpiration>() { // from class: com.dropbox.core.v1.DbxUrlWithExpiration.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public DbxUrlWithExpiration read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            String field = null;
            Date field2 = null;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                try {
                    if (currentName.equals(ImagesContract.URL)) {
                        field = JsonReader.StringReader.readField(jsonParser, currentName, field);
                    } else if (currentName.equals(ClientCookie.EXPIRES_ATTR)) {
                        field2 = JsonDateReader.Dropbox.readField(jsonParser, currentName, field2);
                    } else {
                        JsonReader.skipValue(jsonParser);
                    }
                } catch (JsonReadException e) {
                    throw e.addFieldContext(currentName);
                }
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (field == null) {
                throw new JsonReadException("missing field \"url\"", jsonLocationExpectObjectStart);
            }
            if (field2 == null) {
                throw new JsonReadException("missing field \"expires\"", jsonLocationExpectObjectStart);
            }
            return new DbxUrlWithExpiration(field, field2);
        }
    };
    public final Date expires;
    public final String url;

    public DbxUrlWithExpiration(String str, Date date) {
        this.url = str;
        this.expires = date;
    }
}
