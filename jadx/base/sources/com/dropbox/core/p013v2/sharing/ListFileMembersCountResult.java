package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.SharedFileMembers;
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

/* JADX INFO: loaded from: classes4.dex */
public class ListFileMembersCountResult {
    protected final long memberCount;

    @Nonnull
    protected final SharedFileMembers members;

    public ListFileMembersCountResult(@Nonnull SharedFileMembers sharedFileMembers, long j) {
        if (sharedFileMembers == null) {
            throw new IllegalArgumentException("Required value for 'members' is null");
        }
        this.members = sharedFileMembers;
        this.memberCount = j;
    }

    @Nonnull
    public SharedFileMembers getMembers() {
        return this.members;
    }

    public long getMemberCount() {
        return this.memberCount;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.members, Long.valueOf(this.memberCount)});
    }

    public boolean equals(Object obj) {
        ListFileMembersCountResult listFileMembersCountResult;
        SharedFileMembers sharedFileMembers;
        SharedFileMembers sharedFileMembers2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((sharedFileMembers = this.members) == (sharedFileMembers2 = (listFileMembersCountResult = (ListFileMembersCountResult) obj).members) || sharedFileMembers.equals(sharedFileMembers2)) && this.memberCount == listFileMembersCountResult.memberCount;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListFileMembersCountResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFileMembersCountResult listFileMembersCountResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("members");
            SharedFileMembers.Serializer.INSTANCE.serialize(listFileMembersCountResult.members, jsonGenerator);
            jsonGenerator.writeFieldName("member_count");
            StoneSerializers.uInt32().serialize(Long.valueOf(listFileMembersCountResult.memberCount), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFileMembersCountResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SharedFileMembers sharedFileMembersDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("members".equals(currentName)) {
                        sharedFileMembersDeserialize = SharedFileMembers.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("member_count".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt32().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (sharedFileMembersDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"members\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member_count\" missing.");
                }
                ListFileMembersCountResult listFileMembersCountResult = new ListFileMembersCountResult(sharedFileMembersDeserialize, lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFileMembersCountResult, listFileMembersCountResult.toStringMultiline());
                return listFileMembersCountResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
