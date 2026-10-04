package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.UserSelectorArg;
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
class MembersDeactivateArg extends MembersDeactivateBaseArg {
    protected final boolean wipeData;

    public MembersDeactivateArg(@Nonnull UserSelectorArg userSelectorArg, boolean z) {
        super(userSelectorArg);
        this.wipeData = z;
    }

    public MembersDeactivateArg(@Nonnull UserSelectorArg userSelectorArg) {
        this(userSelectorArg, true);
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    public boolean getWipeData() {
        return this.wipeData;
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{Boolean.valueOf(this.wipeData)});
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            MembersDeactivateArg membersDeactivateArg = (MembersDeactivateArg) obj;
            if ((this.user == membersDeactivateArg.user || this.user.equals(membersDeactivateArg.user)) && this.wipeData == membersDeactivateArg.wipeData) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersDeactivateArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersDeactivateArg membersDeactivateArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(membersDeactivateArg.user, jsonGenerator);
            jsonGenerator.writeFieldName("wipe_data");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(membersDeactivateArg.wipeData), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersDeactivateArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserSelectorArg userSelectorArgDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("wipe_data".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                MembersDeactivateArg membersDeactivateArg = new MembersDeactivateArg(userSelectorArgDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersDeactivateArg, membersDeactivateArg.toStringMultiline());
                return membersDeactivateArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
