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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
class MembersRemoveArg extends MembersDeactivateArg {
    protected final boolean keepAccount;
    protected final boolean retainTeamShares;

    @Nullable
    protected final UserSelectorArg transferAdminId;

    @Nullable
    protected final UserSelectorArg transferDestId;

    public MembersRemoveArg(@Nonnull UserSelectorArg userSelectorArg, boolean z, @Nullable UserSelectorArg userSelectorArg2, @Nullable UserSelectorArg userSelectorArg3, boolean z2, boolean z3) {
        super(userSelectorArg, z);
        this.transferDestId = userSelectorArg2;
        this.transferAdminId = userSelectorArg3;
        this.keepAccount = z2;
        this.retainTeamShares = z3;
    }

    public MembersRemoveArg(@Nonnull UserSelectorArg userSelectorArg) {
        this(userSelectorArg, true, null, null, false, false);
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateArg, com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    @Nonnull
    public UserSelectorArg getUser() {
        return this.user;
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateArg
    public boolean getWipeData() {
        return this.wipeData;
    }

    @Nullable
    public UserSelectorArg getTransferDestId() {
        return this.transferDestId;
    }

    @Nullable
    public UserSelectorArg getTransferAdminId() {
        return this.transferAdminId;
    }

    public boolean getKeepAccount() {
        return this.keepAccount;
    }

    public boolean getRetainTeamShares() {
        return this.retainTeamShares;
    }

    public static Builder newBuilder(UserSelectorArg userSelectorArg) {
        return new Builder(userSelectorArg);
    }

    public static class Builder {
        protected boolean keepAccount;
        protected boolean retainTeamShares;
        protected UserSelectorArg transferAdminId;
        protected UserSelectorArg transferDestId;
        protected final UserSelectorArg user;
        protected boolean wipeData;

        protected Builder(UserSelectorArg userSelectorArg) {
            if (userSelectorArg == null) {
                throw new IllegalArgumentException("Required value for 'user' is null");
            }
            this.user = userSelectorArg;
            this.wipeData = true;
            this.transferDestId = null;
            this.transferAdminId = null;
            this.keepAccount = false;
            this.retainTeamShares = false;
        }

        public Builder withWipeData(Boolean bool) {
            if (bool != null) {
                this.wipeData = bool.booleanValue();
                return this;
            }
            this.wipeData = true;
            return this;
        }

        public Builder withTransferDestId(UserSelectorArg userSelectorArg) {
            this.transferDestId = userSelectorArg;
            return this;
        }

        public Builder withTransferAdminId(UserSelectorArg userSelectorArg) {
            this.transferAdminId = userSelectorArg;
            return this;
        }

        public Builder withKeepAccount(Boolean bool) {
            if (bool != null) {
                this.keepAccount = bool.booleanValue();
                return this;
            }
            this.keepAccount = false;
            return this;
        }

        public Builder withRetainTeamShares(Boolean bool) {
            if (bool != null) {
                this.retainTeamShares = bool.booleanValue();
                return this;
            }
            this.retainTeamShares = false;
            return this;
        }

        public MembersRemoveArg build() {
            return new MembersRemoveArg(this.user, this.wipeData, this.transferDestId, this.transferAdminId, this.keepAccount, this.retainTeamShares);
        }
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateArg, com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.transferDestId, this.transferAdminId, Boolean.valueOf(this.keepAccount), Boolean.valueOf(this.retainTeamShares)});
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateArg, com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public boolean equals(Object obj) {
        UserSelectorArg userSelectorArg;
        UserSelectorArg userSelectorArg2;
        UserSelectorArg userSelectorArg3;
        UserSelectorArg userSelectorArg4;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            MembersRemoveArg membersRemoveArg = (MembersRemoveArg) obj;
            if ((this.user == membersRemoveArg.user || this.user.equals(membersRemoveArg.user)) && this.wipeData == membersRemoveArg.wipeData && (((userSelectorArg = this.transferDestId) == (userSelectorArg2 = membersRemoveArg.transferDestId) || (userSelectorArg != null && userSelectorArg.equals(userSelectorArg2))) && (((userSelectorArg3 = this.transferAdminId) == (userSelectorArg4 = membersRemoveArg.transferAdminId) || (userSelectorArg3 != null && userSelectorArg3.equals(userSelectorArg4))) && this.keepAccount == membersRemoveArg.keepAccount && this.retainTeamShares == membersRemoveArg.retainTeamShares))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateArg, com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.team.MembersDeactivateArg, com.dropbox.core.p013v2.team.MembersDeactivateBaseArg
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MembersRemoveArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MembersRemoveArg membersRemoveArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserSelectorArg.Serializer.INSTANCE.serialize(membersRemoveArg.user, jsonGenerator);
            jsonGenerator.writeFieldName("wipe_data");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(membersRemoveArg.wipeData), jsonGenerator);
            if (membersRemoveArg.transferDestId != null) {
                jsonGenerator.writeFieldName("transfer_dest_id");
                StoneSerializers.nullable(UserSelectorArg.Serializer.INSTANCE).serialize(membersRemoveArg.transferDestId, jsonGenerator);
            }
            if (membersRemoveArg.transferAdminId != null) {
                jsonGenerator.writeFieldName("transfer_admin_id");
                StoneSerializers.nullable(UserSelectorArg.Serializer.INSTANCE).serialize(membersRemoveArg.transferAdminId, jsonGenerator);
            }
            jsonGenerator.writeFieldName("keep_account");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(membersRemoveArg.keepAccount), jsonGenerator);
            jsonGenerator.writeFieldName("retain_team_shares");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(membersRemoveArg.retainTeamShares), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public MembersRemoveArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Boolean boolDeserialize = true;
                Boolean boolDeserialize2 = false;
                Boolean boolDeserialize3 = false;
                UserSelectorArg userSelectorArgDeserialize = null;
                UserSelectorArg userSelectorArg = null;
                UserSelectorArg userSelectorArg2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user".equals(currentName)) {
                        userSelectorArgDeserialize = UserSelectorArg.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("wipe_data".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("transfer_dest_id".equals(currentName)) {
                        userSelectorArg = (UserSelectorArg) StoneSerializers.nullable(UserSelectorArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("transfer_admin_id".equals(currentName)) {
                        userSelectorArg2 = (UserSelectorArg) StoneSerializers.nullable(UserSelectorArg.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("keep_account".equals(currentName)) {
                        boolDeserialize2 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("retain_team_shares".equals(currentName)) {
                        boolDeserialize3 = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userSelectorArgDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                MembersRemoveArg membersRemoveArg = new MembersRemoveArg(userSelectorArgDeserialize, boolDeserialize.booleanValue(), userSelectorArg, userSelectorArg2, boolDeserialize2.booleanValue(), boolDeserialize3.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(membersRemoveArg, membersRemoveArg.toStringMultiline());
                return membersRemoveArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
