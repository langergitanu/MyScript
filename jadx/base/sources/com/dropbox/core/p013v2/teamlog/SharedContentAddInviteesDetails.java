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
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class SharedContentAddInviteesDetails {

    @Nonnull
    protected final List<String> invitees;

    @Nonnull
    protected final AccessLevel sharedContentAccessLevel;

    public SharedContentAddInviteesDetails(@Nonnull AccessLevel accessLevel, @Nonnull List<String> list) {
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'sharedContentAccessLevel' is null");
        }
        this.sharedContentAccessLevel = accessLevel;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'invitees' is null");
        }
        for (String str : list) {
            if (str == null) {
                throw new IllegalArgumentException("An item in list 'invitees' is null");
            }
            if (str.length() > 255) {
                throw new IllegalArgumentException("Stringan item in list 'invitees' is longer than 255");
            }
        }
        this.invitees = list;
    }

    @Nonnull
    public AccessLevel getSharedContentAccessLevel() {
        return this.sharedContentAccessLevel;
    }

    @Nonnull
    public List<String> getInvitees() {
        return this.invitees;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedContentAccessLevel, this.invitees});
    }

    public boolean equals(Object obj) {
        List<String> list;
        List<String> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedContentAddInviteesDetails sharedContentAddInviteesDetails = (SharedContentAddInviteesDetails) obj;
        AccessLevel accessLevel = this.sharedContentAccessLevel;
        AccessLevel accessLevel2 = sharedContentAddInviteesDetails.sharedContentAccessLevel;
        return (accessLevel == accessLevel2 || accessLevel.equals(accessLevel2)) && ((list = this.invitees) == (list2 = sharedContentAddInviteesDetails.invitees) || list.equals(list2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentAddInviteesDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentAddInviteesDetails sharedContentAddInviteesDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_content_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(sharedContentAddInviteesDetails.sharedContentAccessLevel, jsonGenerator);
            jsonGenerator.writeFieldName("invitees");
            StoneSerializers.list(StoneSerializers.string()).serialize(sharedContentAddInviteesDetails.invitees, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentAddInviteesDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevelDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_content_access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("invitees".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_content_access_level\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"invitees\" missing.");
                }
                SharedContentAddInviteesDetails sharedContentAddInviteesDetails = new SharedContentAddInviteesDetails(accessLevelDeserialize, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentAddInviteesDetails, sharedContentAddInviteesDetails.toStringMultiline());
                return sharedContentAddInviteesDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
