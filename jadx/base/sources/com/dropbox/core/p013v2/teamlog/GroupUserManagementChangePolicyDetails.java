package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.GroupCreation;
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
public class GroupUserManagementChangePolicyDetails {

    @Nonnull
    protected final GroupCreation newValue;

    @Nullable
    protected final GroupCreation previousValue;

    public GroupUserManagementChangePolicyDetails(@Nonnull GroupCreation groupCreation, @Nullable GroupCreation groupCreation2) {
        if (groupCreation == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = groupCreation;
        this.previousValue = groupCreation2;
    }

    public GroupUserManagementChangePolicyDetails(@Nonnull GroupCreation groupCreation) {
        this(groupCreation, null);
    }

    @Nonnull
    public GroupCreation getNewValue() {
        return this.newValue;
    }

    @Nullable
    public GroupCreation getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        GroupCreation groupCreation;
        GroupCreation groupCreation2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GroupUserManagementChangePolicyDetails groupUserManagementChangePolicyDetails = (GroupUserManagementChangePolicyDetails) obj;
        GroupCreation groupCreation3 = this.newValue;
        GroupCreation groupCreation4 = groupUserManagementChangePolicyDetails.newValue;
        return (groupCreation3 == groupCreation4 || groupCreation3.equals(groupCreation4)) && ((groupCreation = this.previousValue) == (groupCreation2 = groupUserManagementChangePolicyDetails.previousValue) || (groupCreation != null && groupCreation.equals(groupCreation2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupUserManagementChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupUserManagementChangePolicyDetails groupUserManagementChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            GroupCreation.Serializer.INSTANCE.serialize(groupUserManagementChangePolicyDetails.newValue, jsonGenerator);
            if (groupUserManagementChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(GroupCreation.Serializer.INSTANCE).serialize(groupUserManagementChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupUserManagementChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            GroupCreation groupCreationDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GroupCreation groupCreation = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        groupCreationDeserialize = GroupCreation.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        groupCreation = (GroupCreation) StoneSerializers.nullable(GroupCreation.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (groupCreationDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                GroupUserManagementChangePolicyDetails groupUserManagementChangePolicyDetails = new GroupUserManagementChangePolicyDetails(groupCreationDeserialize, groupCreation);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupUserManagementChangePolicyDetails, groupUserManagementChangePolicyDetails.toStringMultiline());
                return groupUserManagementChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
