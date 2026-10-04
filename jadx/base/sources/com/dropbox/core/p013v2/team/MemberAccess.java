package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.GroupAccessType;
import com.dropbox.core.p013v2.team.UserSelectorArg;
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
public class MemberAccess {

    @Nonnull
    protected final GroupAccessType accessType;

    @Nonnull
    protected final UserSelectorArg user;

    public MemberAccess(@Nonnull UserSelectorArg userSelectorArg, @Nonnull GroupAccessType groupAccessType) {
        if (userSelectorArg == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userSelectorArg;
        if (groupAccessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = groupAccessType;
    }

    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nonnull
    public GroupAccessType getAccessType() {
        return this.accessType;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.accessType});
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
        MemberAccess memberAccess = (MemberAccess) obj;
        UserSelectorArg userSelectorArg = this.user;
        UserSelectorArg userSelectorArg2 = memberAccess.user;
        return (userSelectorArg == userSelectorArg2 || userSelectorArg.equals(userSelectorArg2)) && ((groupAccessType = this.accessType) == (groupAccessType2 = memberAccess.accessType) || groupAccessType.equals(groupAccessType2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MemberAccess> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MemberAccess memberAccess, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(memberAccess.user, jsonGenerator);
            jsonGenerator.writeFieldName("access_type");
            GroupAccessType.Serializer.INSTANCE.serialize(memberAccess.accessType, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MemberAccess deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserSelectorArg userSelectorArgDeserialize = null;
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
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("access_type".equals(currentName)) {
                        groupAccessTypeDeserialize = GroupAccessType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                if (groupAccessTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_type\" missing.");
                }
                MemberAccess memberAccess = new MemberAccess(userSelectorArgDeserialize, groupAccessTypeDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(memberAccess, memberAccess.toStringMultiline());
                return memberAccess;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
