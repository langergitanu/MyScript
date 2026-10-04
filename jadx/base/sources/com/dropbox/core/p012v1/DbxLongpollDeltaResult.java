package com.dropbox.core.p012v1;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class DbxLongpollDeltaResult {
    public static final JsonReader<DbxLongpollDeltaResult> Reader = new JsonReader<DbxLongpollDeltaResult>() { // from class: com.dropbox.core.v1.DbxLongpollDeltaResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.json.JsonReader
        public DbxLongpollDeltaResult read(JsonParser jsonParser) throws JsonReadException, IOException {
            JsonLocation jsonLocationExpectObjectStart = JsonReader.expectObjectStart(jsonParser);
            Boolean field = null;
            long unsignedLongField = -1;
            while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String currentName = jsonParser.getCurrentName();
                jsonParser.nextToken();
                try {
                    if (currentName.equals("changes")) {
                        field = JsonReader.BooleanReader.readField(jsonParser, currentName, field);
                    } else if (currentName.equals("backoff")) {
                        unsignedLongField = JsonReader.readUnsignedLongField(jsonParser, currentName, unsignedLongField);
                    } else {
                        JsonReader.skipValue(jsonParser);
                    }
                } catch (JsonReadException e) {
                    throw e.addFieldContext(currentName);
                }
            }
            JsonReader.expectObjectEnd(jsonParser);
            if (field == null) {
                throw new JsonReadException("missing field \"changes\"", jsonLocationExpectObjectStart);
            }
            return new DbxLongpollDeltaResult(field.booleanValue(), unsignedLongField);
        }
    };
    public long backoff;
    public boolean mightHaveChanges;

    public DbxLongpollDeltaResult(boolean z, long j) {
        this.mightHaveChanges = z;
        this.backoff = j;
    }
}
