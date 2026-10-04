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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class SharedContentChangeMemberRoleDetails {

    @Nonnull
    protected final AccessLevel newAccessLevel;

    @Nullable
    protected final AccessLevel previousAccessLevel;

    public SharedContentChangeMemberRoleDetails(@Nonnull AccessLevel accessLevel, @Nullable AccessLevel accessLevel2) {
        this.previousAccessLevel = accessLevel2;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'newAccessLevel' is null");
        }
        this.newAccessLevel = accessLevel;
    }

    public SharedContentChangeMemberRoleDetails(@Nonnull AccessLevel accessLevel) {
        this(accessLevel, null);
    }

    @Nonnull
    public AccessLevel getNewAccessLevel() {
        return this.newAccessLevel;
    }

    @Nullable
    public AccessLevel getPreviousAccessLevel() {
        return this.previousAccessLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousAccessLevel, this.newAccessLevel});
    }

    public boolean equals(Object obj) {
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedContentChangeMemberRoleDetails sharedContentChangeMemberRoleDetails = (SharedContentChangeMemberRoleDetails) obj;
        AccessLevel accessLevel3 = this.newAccessLevel;
        AccessLevel accessLevel4 = sharedContentChangeMemberRoleDetails.newAccessLevel;
        return (accessLevel3 == accessLevel4 || accessLevel3.equals(accessLevel4)) && ((accessLevel = this.previousAccessLevel) == (accessLevel2 = sharedContentChangeMemberRoleDetails.previousAccessLevel) || (accessLevel != null && accessLevel.equals(accessLevel2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentChangeMemberRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentChangeMemberRoleDetails sharedContentChangeMemberRoleDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(sharedContentChangeMemberRoleDetails.newAccessLevel, jsonGenerator);
            if (sharedContentChangeMemberRoleDetails.previousAccessLevel != null) {
                jsonGenerator.writeFieldName("previous_access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(sharedContentChangeMemberRoleDetails.previousAccessLevel, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentChangeMemberRoleDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevelDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AccessLevel accessLevel = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_access_level".equals(currentName)) {
                        accessLevel = (AccessLevel) StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_access_level\" missing.");
                }
                SharedContentChangeMemberRoleDetails sharedContentChangeMemberRoleDetails = new SharedContentChangeMemberRoleDetails(accessLevelDeserialize, accessLevel);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentChangeMemberRoleDetails, sharedContentChangeMemberRoleDetails.toStringMultiline());
                return sharedContentChangeMemberRoleDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
