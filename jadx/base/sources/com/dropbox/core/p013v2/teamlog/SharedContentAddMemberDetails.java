package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class SharedContentAddMemberDetails {

    @Nonnull
    protected final AccessLevel sharedContentAccessLevel;

    public SharedContentAddMemberDetails(@Nonnull AccessLevel accessLevel) {
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = accessLevel;
    }

    @Nonnull
    public AccessLevel getSharedContentAccessLevel() {
        return this.sharedContentAccessLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedContentAccessLevel});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AccessLevel accessLevel = this.sharedContentAccessLevel;
        AccessLevel accessLevel2 = ((SharedContentAddMemberDetails) obj).sharedContentAccessLevel;
        return accessLevel == accessLevel2 || accessLevel.equals(accessLevel2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentAddMemberDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentAddMemberDetails sharedContentAddMemberDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(sharedContentAddMemberDetails.sharedContentAccessLevel, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentAddMemberDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevelDeserialize = null;
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
                    if ("shared_content_access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_content_access_level\" missing.");
                }
                SharedContentAddMemberDetails sharedContentAddMemberDetails = new SharedContentAddMemberDetails(accessLevelDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentAddMemberDetails, sharedContentAddMemberDetails.toStringMultiline());
                return sharedContentAddMemberDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
