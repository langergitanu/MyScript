package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.sharing.AccessLevel;
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
public class SharedContentRemoveMemberDetails {

    @Nullable
    protected final AccessLevel sharedContentAccessLevel;

    public SharedContentRemoveMemberDetails(@Nullable AccessLevel accessLevel) {
        this.sharedContentAccessLevel = accessLevel;
    }

    public SharedContentRemoveMemberDetails() {
        this(null);
    }

    @Nullable
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
        AccessLevel accessLevel2 = ((SharedContentRemoveMemberDetails) obj).sharedContentAccessLevel;
        return accessLevel == accessLevel2 || (accessLevel != null && accessLevel.equals(accessLevel2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentRemoveMemberDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentRemoveMemberDetails sharedContentRemoveMemberDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (sharedContentRemoveMemberDetails.sharedContentAccessLevel != null) {
                jsonGenerator.writeFieldName("shared_content_access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(sharedContentRemoveMemberDetails.sharedContentAccessLevel, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentRemoveMemberDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevel = null;
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
                        accessLevel = (AccessLevel) StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                SharedContentRemoveMemberDetails sharedContentRemoveMemberDetails = new SharedContentRemoveMemberDetails(accessLevel);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentRemoveMemberDetails, sharedContentRemoveMemberDetails.toStringMultiline());
                return sharedContentRemoveMemberDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
