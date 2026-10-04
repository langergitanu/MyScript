package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamcommon.GroupManagementType;
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
public class GroupChangeManagementTypeDetails {

    @Nonnull
    protected final GroupManagementType newValue;

    @Nullable
    protected final GroupManagementType previousValue;

    public GroupChangeManagementTypeDetails(@Nonnull GroupManagementType groupManagementType, @Nullable GroupManagementType groupManagementType2) {
        if (groupManagementType == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = groupManagementType;
        this.previousValue = groupManagementType2;
    }

    public GroupChangeManagementTypeDetails(@Nonnull GroupManagementType groupManagementType) {
        this(groupManagementType, null);
    }

    @Nonnull
    public GroupManagementType getNewValue() {
        return this.newValue;
    }

    @Nullable
    public GroupManagementType getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        GroupManagementType groupManagementType;
        GroupManagementType groupManagementType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GroupChangeManagementTypeDetails groupChangeManagementTypeDetails = (GroupChangeManagementTypeDetails) obj;
        GroupManagementType groupManagementType3 = this.newValue;
        GroupManagementType groupManagementType4 = groupChangeManagementTypeDetails.newValue;
        return (groupManagementType3 == groupManagementType4 || groupManagementType3.equals(groupManagementType4)) && ((groupManagementType = this.previousValue) == (groupManagementType2 = groupChangeManagementTypeDetails.previousValue) || (groupManagementType != null && groupManagementType.equals(groupManagementType2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupChangeManagementTypeDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupChangeManagementTypeDetails groupChangeManagementTypeDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            GroupManagementType.Serializer.INSTANCE.serialize(groupChangeManagementTypeDetails.newValue, jsonGenerator);
            if (groupChangeManagementTypeDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).serialize(groupChangeManagementTypeDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupChangeManagementTypeDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            GroupManagementType groupManagementTypeDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GroupManagementType groupManagementType = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        groupManagementTypeDeserialize = GroupManagementType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        groupManagementType = (GroupManagementType) StoneSerializers.nullable(GroupManagementType.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (groupManagementTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                GroupChangeManagementTypeDetails groupChangeManagementTypeDetails = new GroupChangeManagementTypeDetails(groupManagementTypeDeserialize, groupManagementType);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupChangeManagementTypeDetails, groupChangeManagementTypeDetails.toStringMultiline());
                return groupChangeManagementTypeDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
