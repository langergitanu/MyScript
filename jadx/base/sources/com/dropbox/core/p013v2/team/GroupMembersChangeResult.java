package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupFullInfo;
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

/* JADX INFO: loaded from: classes5.dex */
public class GroupMembersChangeResult {

    @Nonnull
    protected final String asyncJobId;

    @Nonnull
    protected final GroupFullInfo groupInfo;

    public GroupMembersChangeResult(@Nonnull GroupFullInfo groupFullInfo, @Nonnull String str) {
        if (groupFullInfo == null) {
            throw new IllegalArgumentException("Required value for 'groupInfo' is null");
        }
        this.groupInfo = groupFullInfo;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'asyncJobId' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'asyncJobId' is shorter than 1");
        }
        this.asyncJobId = str;
    }

    @Nonnull
    public GroupFullInfo getGroupInfo() {
        return this.groupInfo;
    }

    @Nonnull
    public String getAsyncJobId() {
        return this.asyncJobId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.groupInfo, this.asyncJobId});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GroupMembersChangeResult groupMembersChangeResult = (GroupMembersChangeResult) obj;
        GroupFullInfo groupFullInfo = this.groupInfo;
        GroupFullInfo groupFullInfo2 = groupMembersChangeResult.groupInfo;
        return (groupFullInfo == groupFullInfo2 || groupFullInfo.equals(groupFullInfo2)) && ((str = this.asyncJobId) == (str2 = groupMembersChangeResult.asyncJobId) || str.equals(str2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GroupMembersChangeResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GroupMembersChangeResult groupMembersChangeResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("group_info");
            GroupFullInfo.Serializer.INSTANCE.serialize(groupMembersChangeResult.groupInfo, jsonGenerator);
            jsonGenerator.writeFieldName("async_job_id");
            StoneSerializers.string().serialize(groupMembersChangeResult.asyncJobId, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GroupMembersChangeResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            GroupFullInfo groupFullInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("group_info".equals(currentName)) {
                        groupFullInfoDeserialize = GroupFullInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("async_job_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (groupFullInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"group_info\" missing.");
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"async_job_id\" missing.");
                }
                GroupMembersChangeResult groupMembersChangeResult = new GroupMembersChangeResult(groupFullInfoDeserialize, strDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(groupMembersChangeResult, groupMembersChangeResult.toStringMultiline());
                return groupMembersChangeResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
