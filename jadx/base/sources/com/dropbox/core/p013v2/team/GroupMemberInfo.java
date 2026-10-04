package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupAccessType;
import com.dropbox.core.p013v2.team.MemberProfile;
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
public class GroupMemberInfo {

    @Nonnull
    protected final GroupAccessType accessType;

    @Nonnull
    protected final MemberProfile profile;

    public GroupMemberInfo(@Nonnull MemberProfile memberProfile, @Nonnull GroupAccessType groupAccessType) {
        if (memberProfile == null) {
            throw new IllegalArgumentException("Required value for 'profile' is null");
        }
        this.profile = memberProfile;
        if (groupAccessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = groupAccessType;
    }

    @Nonnull
    public MemberProfile getProfile() {
        return this.profile;
    }

    @Nonnull
    public GroupAccessType getAccessType() {
        return this.accessType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.profile, this.accessType});
    }

    public boolean equals(Object obj) {
        GroupAccessType groupAccessType;
        GroupAccessType groupAccessType2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GroupMemberInfo groupMemberInfo = (GroupMemberInfo) obj;
        MemberProfile memberProfile = this.profile;
        MemberProfile memberProfile2 = groupMemberInfo.profile;
        return (memberProfile == memberProfile2 || memberProfile.equals(memberProfile2)) && ((groupAccessType = this.accessType) == (groupAccessType2 = groupMemberInfo.accessType) || groupAccessType.equals(groupAccessType2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupMemberInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupMemberInfo groupMemberInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("profile");
            MemberProfile.Serializer.INSTANCE.serialize(groupMemberInfo.profile, jsonGenerator);
            jsonGenerator.writeFieldName("access_type");
            GroupAccessType.Serializer.INSTANCE.serialize(groupMemberInfo.accessType, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupMemberInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MemberProfile memberProfileDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GroupAccessType groupAccessTypeDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("profile".equals(currentName)) {
                        memberProfileDeserialize = MemberProfile.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("access_type".equals(currentName)) {
                        groupAccessTypeDeserialize = GroupAccessType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberProfileDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"profile\" missing.");
                }
                if (groupAccessTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_type\" missing.");
                }
                GroupMemberInfo groupMemberInfo = new GroupMemberInfo(memberProfileDeserialize, groupAccessTypeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupMemberInfo, groupMemberInfo.toStringMultiline());
                return groupMemberInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
