package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class UploadSessionStartBatchResult {

    @Nonnull
    protected final List<String> sessionIds;

    public UploadSessionStartBatchResult(@Nonnull List<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'sessionIds' is null");
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'sessionIds' is null");
            }
        }
        this.sessionIds = list;
    }

    @Nonnull
    public List<String> getSessionIds() {
        return this.sessionIds;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sessionIds});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<String> list = this.sessionIds;
        List<String> list2 = ((UploadSessionStartBatchResult) obj).sessionIds;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UploadSessionStartBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UploadSessionStartBatchResult uploadSessionStartBatchResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("session_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(uploadSessionStartBatchResult.sessionIds, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UploadSessionStartBatchResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("session_ids".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"session_ids\" missing.");
                }
                UploadSessionStartBatchResult uploadSessionStartBatchResult = new UploadSessionStartBatchResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(uploadSessionStartBatchResult, uploadSessionStartBatchResult.toStringMultiline());
                return uploadSessionStartBatchResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
