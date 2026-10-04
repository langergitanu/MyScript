package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SharedFolderCreateDetails {

    @Nullable
    protected final String targetNsId;

    public SharedFolderCreateDetails(@Nullable String str) {
        this.targetNsId = str;
    }

    public SharedFolderCreateDetails() {
        this(null);
    }

    @Nullable
    public String getTargetNsId() {
        return this.targetNsId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.targetNsId});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        String str = this.targetNsId;
        String str2 = ((SharedFolderCreateDetails) obj).targetNsId;
        return str == str2 || (str != null && str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedFolderCreateDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedFolderCreateDetails sharedFolderCreateDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharedFolderCreateDetails.targetNsId != null) {
                jsonGenerator.writeFieldName("target_ns_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(sharedFolderCreateDetails.targetNsId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedFolderCreateDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
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
                    if ("target_ns_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharedFolderCreateDetails sharedFolderCreateDetails = new SharedFolderCreateDetails(str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedFolderCreateDetails, sharedFolderCreateDetails.toStringMultiline());
                return sharedFolderCreateDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
