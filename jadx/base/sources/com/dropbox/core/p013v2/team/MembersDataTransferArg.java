package com.dropbox.core.p013v2.team;

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
class MembersDataTransferArg extends MembersDeactivateBaseArg {

    @Nonnull
    protected final UserSelectorArg transferAdminId;

    @Nonnull
    protected final UserSelectorArg transferDestId;

    public MembersDataTransferArg(@Nonnull UserSelectorArg userSelectorArg, @Nonnull UserSelectorArg userSelectorArg2, @Nonnull UserSelectorArg userSelectorArg3) {
        super(userSelectorArg);
        if (userSelectorArg2 == null) {
            throw new IllegalArgumentException("Required value for 'transferDestId' is null");
        }
        this.transferDestId = userSelectorArg2;
        if (userSelectorArg3 == null) {
            throw new IllegalArgumentException("Required value for 'transferAdminId' is null");
        }
        this.transferAdminId = userSelectorArg3;
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Nonnull
    public UserSelectorArg getTransferDestId() {
        return this.transferDestId;
    }

    @Nonnull
    public UserSelectorArg getTransferAdminId() {
        return this.transferAdminId;
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.transferDestId, this.transferAdminId});
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public boolean equals(Object obj) {
        UserSelectorArg userSelectorArg;
        UserSelectorArg userSelectorArg2;
        UserSelectorArg userSelectorArg3;
        UserSelectorArg userSelectorArg4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MembersDataTransferArg membersDataTransferArg = (MembersDataTransferArg) obj;
        return (this.user == membersDataTransferArg.user || this.user.equals(membersDataTransferArg.user)) && ((userSelectorArg = this.transferDestId) == (userSelectorArg2 = membersDataTransferArg.transferDestId) || userSelectorArg.equals(userSelectorArg2)) && ((userSelectorArg3 = this.transferAdminId) == (userSelectorArg4 = membersDataTransferArg.transferAdminId) || userSelectorArg3.equals(userSelectorArg4));
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersDataTransferArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersDataTransferArg membersDataTransferArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(membersDataTransferArg.user, jsonGenerator);
            jsonGenerator.writeFieldName("transfer_dest_id");
            UserSelectorArg.Serializer.INSTANCE.serialize(membersDataTransferArg.transferDestId, jsonGenerator);
            jsonGenerator.writeFieldName("transfer_admin_id");
            UserSelectorArg.Serializer.INSTANCE.serialize(membersDataTransferArg.transferAdminId, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersDataTransferArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserSelectorArg userSelectorArgDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                UserSelectorArg userSelectorArgDeserialize2 = null;
                UserSelectorArg userSelectorArgDeserialize3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("transfer_dest_id".equals(currentName)) {
                        userSelectorArgDeserialize2 = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("transfer_admin_id".equals(currentName)) {
                        userSelectorArgDeserialize3 = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                if (userSelectorArgDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"transfer_dest_id\" missing.");
                }
                if (userSelectorArgDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"transfer_admin_id\" missing.");
                }
                MembersDataTransferArg membersDataTransferArg = new MembersDataTransferArg(userSelectorArgDeserialize, userSelectorArgDeserialize2, userSelectorArgDeserialize3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersDataTransferArg, membersDataTransferArg.toStringMultiline());
                return membersDataTransferArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
