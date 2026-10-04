package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.TeamLogInfo;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class TeamMemberLogInfo extends UserLogInfo {

    @Nullable
    protected final String memberExternalId;

    @Nullable
    protected final TeamLogInfo team;

    @Nullable
    protected final String teamMemberId;

    public TeamMemberLogInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable TeamLogInfo teamLogInfo) {
        super(str, str2, str3);
        this.teamMemberId = str4;
        if (str5 != null && str5.length() > 64) {
            throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
        }
        this.memberExternalId = str5;
        this.team = teamLogInfo;
    }

    public TeamMemberLogInfo() {
        this(null, null, null, null, null, null);
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
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    @Nullable
    public String getMemberExternalId() {
        return this.memberExternalId;
    }

    @Nullable
    public TeamLogInfo getTeam() {
        return this.team;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder extends UserLogInfo.Builder {
        protected String teamMemberId = null;
        protected String memberExternalId = null;
        protected TeamLogInfo team = null;

        protected Builder() {
        }

        public Builder withTeamMemberId(String str) {
            this.teamMemberId = str;
            return this;
        }

        public Builder withMemberExternalId(String str) {
            if (str != null && str.length() > 64) {
                throw new IllegalArgumentException("String 'memberExternalId' is longer than 64");
            }
            this.memberExternalId = str;
            return this;
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
        public TeamMemberLogInfo build() {
            return new TeamMemberLogInfo(this.accountId, this.displayName, this.email, this.teamMemberId, this.memberExternalId, this.team);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.teamMemberId, this.memberExternalId, this.team});
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        TeamLogInfo teamLogInfo;
        TeamLogInfo teamLogInfo2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        TeamMemberLogInfo teamMemberLogInfo = (TeamMemberLogInfo) obj;
        return (this.accountId == teamMemberLogInfo.accountId || (this.accountId != null && this.accountId.equals(teamMemberLogInfo.accountId))) && (this.displayName == teamMemberLogInfo.displayName || (this.displayName != null && this.displayName.equals(teamMemberLogInfo.displayName))) && ((this.email == teamMemberLogInfo.email || (this.email != null && this.email.equals(teamMemberLogInfo.email))) && (((str = this.teamMemberId) == (str2 = teamMemberLogInfo.teamMemberId) || (str != null && str.equals(str2))) && (((str3 = this.memberExternalId) == (str4 = teamMemberLogInfo.memberExternalId) || (str3 != null && str3.equals(str4))) && ((teamLogInfo = this.team) == (teamLogInfo2 = teamMemberLogInfo.team) || (teamLogInfo != null && teamLogInfo.equals(teamLogInfo2))))));
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<TeamMemberLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(TeamMemberLogInfo teamMemberLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("team_member", jsonGenerator);
            if (teamMemberLogInfo.accountId != null) {
                jsonGenerator.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberLogInfo.accountId, jsonGenerator);
            }
            if (teamMemberLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberLogInfo.displayName, jsonGenerator);
            }
            if (teamMemberLogInfo.email != null) {
                jsonGenerator.writeFieldName("email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberLogInfo.email, jsonGenerator);
            }
            if (teamMemberLogInfo.teamMemberId != null) {
                jsonGenerator.writeFieldName("team_member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberLogInfo.teamMemberId, jsonGenerator);
            }
            if (teamMemberLogInfo.memberExternalId != null) {
                jsonGenerator.writeFieldName("member_external_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(teamMemberLogInfo.memberExternalId, jsonGenerator);
            }
            if (teamMemberLogInfo.team != null) {
                jsonGenerator.writeFieldName("team");
                StoneSerializers.nullableStruct(TeamLogInfo.Serializer.INSTANCE).serialize(teamMemberLogInfo.team, jsonGenerator);
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
        public TeamMemberLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("team_member".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                TeamLogInfo teamLogInfo = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("account_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("email".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("team_member_id".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("member_external_id".equals(currentName)) {
                        str5 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("team".equals(currentName)) {
                        teamLogInfo = (TeamLogInfo) StoneSerializers.nullableStruct(TeamLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                TeamMemberLogInfo teamMemberLogInfo = new TeamMemberLogInfo(str, str2, str3, str4, str5, teamLogInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(teamMemberLogInfo, teamMemberLogInfo.toStringMultiline());
                return teamMemberLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
