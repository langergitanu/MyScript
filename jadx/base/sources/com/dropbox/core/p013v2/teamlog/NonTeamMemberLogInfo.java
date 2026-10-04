package com.dropbox.core.p013v2.teamlog;

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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class NonTeamMemberLogInfo extends UserLogInfo {
    public NonTeamMemberLogInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        super(str, str2, str3);
    }

    public NonTeamMemberLogInfo() {
        this(null, null, null);
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

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder extends UserLogInfo.Builder {
        protected Builder() {
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
        public NonTeamMemberLogInfo build() {
            return new NonTeamMemberLogInfo(this.accountId, this.displayName, this.email);
        }
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        NonTeamMemberLogInfo nonTeamMemberLogInfo = (NonTeamMemberLogInfo) obj;
        return (this.accountId == nonTeamMemberLogInfo.accountId || (this.accountId != null && this.accountId.equals(nonTeamMemberLogInfo.accountId))) && (this.displayName == nonTeamMemberLogInfo.displayName || (this.displayName != null && this.displayName.equals(nonTeamMemberLogInfo.displayName))) && (this.email == nonTeamMemberLogInfo.email || (this.email != null && this.email.equals(nonTeamMemberLogInfo.email)));
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.teamlog.UserLogInfo
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<NonTeamMemberLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(NonTeamMemberLogInfo nonTeamMemberLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("non_team_member", jsonGenerator);
            if (nonTeamMemberLogInfo.accountId != null) {
                jsonGenerator.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(nonTeamMemberLogInfo.accountId, jsonGenerator);
            }
            if (nonTeamMemberLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(nonTeamMemberLogInfo.displayName, jsonGenerator);
            }
            if (nonTeamMemberLogInfo.email != null) {
                jsonGenerator.writeFieldName("email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(nonTeamMemberLogInfo.email, jsonGenerator);
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
        public NonTeamMemberLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String str = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("non_team_member".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String str2 = null;
                String str3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("account_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("email".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                NonTeamMemberLogInfo nonTeamMemberLogInfo = new NonTeamMemberLogInfo(str, str2, str3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(nonTeamMemberLogInfo, nonTeamMemberLogInfo.toStringMultiline());
                return nonTeamMemberLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
