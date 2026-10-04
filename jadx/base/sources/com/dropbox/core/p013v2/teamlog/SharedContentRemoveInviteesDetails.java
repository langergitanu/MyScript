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
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class SharedContentRemoveInviteesDetails {

    @Nonnull
    protected final List<String> invitees;

    public SharedContentRemoveInviteesDetails(@Nonnull List<String> list) {
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
    public List<String> getInvitees() {
        return this.invitees;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.invitees});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<String> list = this.invitees;
        List<String> list2 = ((SharedContentRemoveInviteesDetails) obj).invitees;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentRemoveInviteesDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentRemoveInviteesDetails sharedContentRemoveInviteesDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("invitees");
            StoneSerializers.list(StoneSerializers.string()).serialize(sharedContentRemoveInviteesDetails.invitees, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentRemoveInviteesDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("invitees".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"invitees\" missing.");
                }
                SharedContentRemoveInviteesDetails sharedContentRemoveInviteesDetails = new SharedContentRemoveInviteesDetails(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentRemoveInviteesDetails, sharedContentRemoveInviteesDetails.toStringMultiline());
                return sharedContentRemoveInviteesDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
