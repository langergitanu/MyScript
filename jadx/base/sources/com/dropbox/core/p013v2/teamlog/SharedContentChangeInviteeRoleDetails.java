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
public class SharedContentChangeInviteeRoleDetails {

    @Nonnull
    protected final String invitee;

    @Nonnull
    protected final AccessLevel newAccessLevel;

    @Nullable
    protected final AccessLevel previousAccessLevel;

    public SharedContentChangeInviteeRoleDetails(@Nonnull AccessLevel accessLevel, @Nonnull String str, @Nullable AccessLevel accessLevel2) {
        this.previousAccessLevel = accessLevel2;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'newAccessLevel' is null");
        }
        this.newAccessLevel = accessLevel;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'invitee' is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String 'invitee' is longer than 255");
        }
        this.invitee = str;
    }

    public SharedContentChangeInviteeRoleDetails(@Nonnull AccessLevel accessLevel, @Nonnull String str) {
        this(accessLevel, str, null);
    }

    @Nonnull
    public AccessLevel getNewAccessLevel() {
        return this.newAccessLevel;
    }

    @Nonnull
    public String getInvitee() {
        return this.invitee;
    }

    @Nullable
    public AccessLevel getPreviousAccessLevel() {
        return this.previousAccessLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousAccessLevel, this.newAccessLevel, this.invitee});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SharedContentChangeInviteeRoleDetails sharedContentChangeInviteeRoleDetails = (SharedContentChangeInviteeRoleDetails) obj;
        AccessLevel accessLevel3 = this.newAccessLevel;
        AccessLevel accessLevel4 = sharedContentChangeInviteeRoleDetails.newAccessLevel;
        return (accessLevel3 == accessLevel4 || accessLevel3.equals(accessLevel4)) && ((str = this.invitee) == (str2 = sharedContentChangeInviteeRoleDetails.invitee) || str.equals(str2)) && ((accessLevel = this.previousAccessLevel) == (accessLevel2 = sharedContentChangeInviteeRoleDetails.previousAccessLevel) || (accessLevel != null && accessLevel.equals(accessLevel2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SharedContentChangeInviteeRoleDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SharedContentChangeInviteeRoleDetails sharedContentChangeInviteeRoleDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_access_level");
            AccessLevel.Serializer.INSTANCE.serialize(sharedContentChangeInviteeRoleDetails.newAccessLevel, jsonGenerator);
            jsonGenerator.writeFieldName("invitee");
            StoneSerializers.string().serialize(sharedContentChangeInviteeRoleDetails.invitee, jsonGenerator);
            if (sharedContentChangeInviteeRoleDetails.previousAccessLevel != null) {
                jsonGenerator.writeFieldName("previous_access_level");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(sharedContentChangeInviteeRoleDetails.previousAccessLevel, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SharedContentChangeInviteeRoleDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessLevel accessLevelDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                AccessLevel accessLevel = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("invitee".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("previous_access_level".equals(currentName)) {
                        accessLevel = (AccessLevel) StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_access_level\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"invitee\" missing.");
                }
                SharedContentChangeInviteeRoleDetails sharedContentChangeInviteeRoleDetails = new SharedContentChangeInviteeRoleDetails(accessLevelDeserialize, strDeserialize, accessLevel);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(sharedContentChangeInviteeRoleDetails, sharedContentChangeInviteeRoleDetails.toStringMultiline());
                return sharedContentChangeInviteeRoleDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
