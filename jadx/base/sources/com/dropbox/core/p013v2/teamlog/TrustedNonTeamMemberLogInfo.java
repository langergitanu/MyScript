package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamLogInfo;
import com.dropbox.core.p013v2.teamlog.TrustedNonTeamMemberType;
import com.dropbox.core.p013v2.teamlog.UserLogInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.revenuecat.purchases.p036ui.revenuecatui.components.webview.Keys;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class TrustedNonTeamMemberLogInfo extends UserLogInfo {

    @Nullable
    protected final TeamLogInfo team;

    @Nonnull
    protected final TrustedNonTeamMemberType trustedNonTeamMemberType;

    public TrustedNonTeamMemberLogInfo(@Nonnull TrustedNonTeamMemberType trustedNonTeamMemberType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable TeamLogInfo teamLogInfo) {
        super(str, str2, str3);
        if (trustedNonTeamMemberType == null) {
            throw new IllegalArgumentException("Required value for 'trustedNonTeamMemberType' is null");
        }
        this.trustedNonTeamMemberType = trustedNonTeamMemberType;
        this.team = teamLogInfo;
    }

    public TrustedNonTeamMemberLogInfo(@Nonnull TrustedNonTeamMemberType trustedNonTeamMemberType) {
        this(trustedNonTeamMemberType, null, null, null, null);
    }

    @Nonnull
    public TrustedNonTeamMemberType getTrustedNonTeamMemberType() {
        return this.trustedNonTeamMemberType;
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    @Nullable
    public String getAccountId() {
        return this.accountId;
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    @Nullable
    public String getEmail() {
        return this.email;
    }

    @Nullable
    public TeamLogInfo getTeam() {
        return this.team;
    }

    public static Builder newBuilder(TrustedNonTeamMemberType trustedNonTeamMemberType) {
        return new Builder(trustedNonTeamMemberType);
    }

    public static class Builder extends UserLogInfo.Builder {
        protected TeamLogInfo team;
        protected final TrustedNonTeamMemberType trustedNonTeamMemberType;

        protected Builder(TrustedNonTeamMemberType trustedNonTeamMemberType) {
            if (trustedNonTeamMemberType == null) {
                throw new IllegalArgumentException("Required value for 'trustedNonTeamMemberType' is null");
            }
            this.trustedNonTeamMemberType = trustedNonTeamMemberType;
            this.team = null;
        }

        public Builder withTeam(TeamLogInfo teamLogInfo) {
            this.team = teamLogInfo;
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.UserLogInfo.Builder
        public Builder withAccountId(String str) {
            super.withAccountId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.UserLogInfo.Builder
        public Builder withDisplayName(String str) {
            super.withDisplayName(str);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.UserLogInfo.Builder
        public Builder withEmail(String str) {
            super.withEmail(str);
            return this;
        }

        @Override // com.dropbox.core.v2.teamlog.UserLogInfo.Builder
        public TrustedNonTeamMemberLogInfo build() {
            return new TrustedNonTeamMemberLogInfo(this.trustedNonTeamMemberType, this.accountId, this.displayName, this.email, this.team);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.trustedNonTeamMemberType, this.team});
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public boolean equals(Object obj) {
        TeamLogInfo teamLogInfo;
        TeamLogInfo teamLogInfo2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TrustedNonTeamMemberLogInfo trustedNonTeamMemberLogInfo = (TrustedNonTeamMemberLogInfo) obj;
        TrustedNonTeamMemberType trustedNonTeamMemberType = this.trustedNonTeamMemberType;
        TrustedNonTeamMemberType trustedNonTeamMemberType2 = trustedNonTeamMemberLogInfo.trustedNonTeamMemberType;
        return (trustedNonTeamMemberType == trustedNonTeamMemberType2 || trustedNonTeamMemberType.equals(trustedNonTeamMemberType2)) && (this.accountId == trustedNonTeamMemberLogInfo.accountId || (this.accountId != null && this.accountId.equals(trustedNonTeamMemberLogInfo.accountId))) && ((this.displayName == trustedNonTeamMemberLogInfo.displayName || (this.displayName != null && this.displayName.equals(trustedNonTeamMemberLogInfo.displayName))) && ((this.email == trustedNonTeamMemberLogInfo.email || (this.email != null && this.email.equals(trustedNonTeamMemberLogInfo.email))) && ((teamLogInfo = this.team) == (teamLogInfo2 = trustedNonTeamMemberLogInfo.team) || (teamLogInfo != null && teamLogInfo.equals(teamLogInfo2)))));
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TrustedNonTeamMemberLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TrustedNonTeamMemberLogInfo trustedNonTeamMemberLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("trusted_non_team_member", jsonGenerator);
            jsonGenerator.writeFieldName("trusted_non_team_member_type");
            TrustedNonTeamMemberType.Serializer.INSTANCE.serialize(trustedNonTeamMemberLogInfo.trustedNonTeamMemberType, jsonGenerator);
            if (trustedNonTeamMemberLogInfo.accountId != null) {
                jsonGenerator.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(trustedNonTeamMemberLogInfo.accountId, jsonGenerator);
            }
            if (trustedNonTeamMemberLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(trustedNonTeamMemberLogInfo.displayName, jsonGenerator);
            }
            if (trustedNonTeamMemberLogInfo.email != null) {
                jsonGenerator.writeFieldName("email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(trustedNonTeamMemberLogInfo.email, jsonGenerator);
            }
            if (trustedNonTeamMemberLogInfo.team != null) {
                jsonGenerator.writeFieldName("team");
                StoneSerializers.nullableStruct(TeamLogInfo.Serializer.INSTANCE).serialize(trustedNonTeamMemberLogInfo.team, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public TrustedNonTeamMemberLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("trusted_non_team_member".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                TrustedNonTeamMemberType trustedNonTeamMemberTypeDeserialize = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                TeamLogInfo teamLogInfo = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("trusted_non_team_member_type".equals(currentName)) {
                        trustedNonTeamMemberTypeDeserialize = TrustedNonTeamMemberType.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("account_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("email".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("team".equals(currentName)) {
                        teamLogInfo = (TeamLogInfo) StoneSerializers.nullableStruct(TeamLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (trustedNonTeamMemberTypeDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"trusted_non_team_member_type\" missing.");
                }
                TrustedNonTeamMemberLogInfo trustedNonTeamMemberLogInfo = new TrustedNonTeamMemberLogInfo(trustedNonTeamMemberTypeDeserialize, str, str2, str3, teamLogInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(trustedNonTeamMemberLogInfo, trustedNonTeamMemberLogInfo.toStringMultiline());
                return trustedNonTeamMemberLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
