package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.SharedLinkAccessLevel;
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
public class SharedLinkCreateDetails {

    @Nullable
    protected final SharedLinkAccessLevel sharedLinkAccessLevel;

    public SharedLinkCreateDetails(@Nullable SharedLinkAccessLevel sharedLinkAccessLevel) {
        this.sharedLinkAccessLevel = sharedLinkAccessLevel;
    }

    public SharedLinkCreateDetails() {
        this(null);
    }

    @Nullable
    public SharedLinkAccessLevel getSharedLinkAccessLevel() {
        return this.sharedLinkAccessLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedLinkAccessLevel});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedLinkAccessLevel sharedLinkAccessLevel = this.sharedLinkAccessLevel;
        SharedLinkAccessLevel sharedLinkAccessLevel2 = ((SharedLinkCreateDetails) obj).sharedLinkAccessLevel;
        return sharedLinkAccessLevel == sharedLinkAccessLevel2 || (sharedLinkAccessLevel != null && sharedLinkAccessLevel.equals(sharedLinkAccessLevel2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedLinkCreateDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedLinkCreateDetails sharedLinkCreateDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharedLinkCreateDetails.sharedLinkAccessLevel != null) {
                jsonGenerator.writeFieldName("shared_link_access_level");
                StoneSerializers.nullable(SharedLinkAccessLevel.Serializer.INSTANCE).serialize(sharedLinkCreateDetails.sharedLinkAccessLevel, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedLinkCreateDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharedLinkAccessLevel sharedLinkAccessLevel = null;
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
                    if ("shared_link_access_level".equals(currentName)) {
                        sharedLinkAccessLevel = (SharedLinkAccessLevel) StoneSerializers.nullable(SharedLinkAccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharedLinkCreateDetails sharedLinkCreateDetails = new SharedLinkCreateDetails(sharedLinkAccessLevel);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedLinkCreateDetails, sharedLinkCreateDetails.toStringMultiline());
                return sharedLinkCreateDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
