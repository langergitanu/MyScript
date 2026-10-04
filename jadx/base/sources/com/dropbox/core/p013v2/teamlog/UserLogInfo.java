package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.NonTeamMemberLogInfo;
import com.dropbox.core.p013v2.teamlog.TeamMemberLogInfo;
import com.dropbox.core.p013v2.teamlog.TrustedNonTeamMemberLogInfo;
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
public class UserLogInfo {

    @Nullable
    protected final String accountId;

    @Nullable
    protected final String displayName;

    @Nullable
    protected final String email;

    public UserLogInfo(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (str != null) {
            if (str.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (str.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
            }
        }
        this.accountId = str;
        this.displayName = str2;
        if (str3 != null && str3.length() > 255) {
            throw new IllegalArgumentException("String 'email' is longer than 255");
        }
        this.email = str3;
    }

    public UserLogInfo() {
        this(null, null, null);
    }

    @Nullable
    public String getAccountId() {
        return this.accountId;
    }

    @Nullable
    public String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public String getEmail() {
        return this.email;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected String accountId = null;
        protected String displayName = null;
        protected String email = null;

        protected Builder() {
        }

        public Builder withAccountId(String str) {
            if (str != null) {
                if (str.length() < 40) {
                    throw new IllegalArgumentException("String 'accountId' is shorter than 40");
                }
                if (str.length() > 40) {
                    throw new IllegalArgumentException("String 'accountId' is longer than 40");
                }
            }
            this.accountId = str;
            return this;
        }

        public Builder withDisplayName(String str) {
            this.displayName = str;
            return this;
        }

        public Builder withEmail(String str) {
            if (str != null && str.length() > 255) {
                throw new IllegalArgumentException("String 'email' is longer than 255");
            }
            this.email = str;
            return this;
        }

        public UserLogInfo build() {
            return new UserLogInfo(this.accountId, this.displayName, this.email);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accountId, this.displayName, this.email});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserLogInfo userLogInfo = (UserLogInfo) obj;
        String str5 = this.accountId;
        String str6 = userLogInfo.accountId;
        return (str5 == str6 || (str5 != null && str5.equals(str6))) && ((str = this.displayName) == (str2 = userLogInfo.displayName) || (str != null && str.equals(str2))) && ((str3 = this.email) == (str4 = userLogInfo.email) || (str3 != null && str3.equals(str4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserLogInfo userLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (userLogInfo instanceof TeamMemberLogInfo) {
                TeamMemberLogInfo.Serializer.INSTANCE.serialize((TeamMemberLogInfo) userLogInfo, jsonGenerator, z);
                return;
            }
            if (userLogInfo instanceof TrustedNonTeamMemberLogInfo) {
                TrustedNonTeamMemberLogInfo.Serializer.INSTANCE.serialize((TrustedNonTeamMemberLogInfo) userLogInfo, jsonGenerator, z);
                return;
            }
            if (userLogInfo instanceof NonTeamMemberLogInfo) {
                NonTeamMemberLogInfo.Serializer.INSTANCE.serialize((NonTeamMemberLogInfo) userLogInfo, jsonGenerator, z);
                return;
            }
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (userLogInfo.accountId != null) {
                jsonGenerator.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userLogInfo.accountId, jsonGenerator);
            }
            if (userLogInfo.displayName != null) {
                jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userLogInfo.displayName, jsonGenerator);
            }
            if (userLogInfo.email != null) {
                jsonGenerator.writeFieldName("email");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userLogInfo.email, jsonGenerator);
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
        public UserLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserLogInfo userLogInfoDeserialize;
            String str = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("".equals(tag)) {
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
                userLogInfoDeserialize = new UserLogInfo(str, str2, str3);
            } else if ("".equals(tag)) {
                userLogInfoDeserialize = INSTANCE.deserialize(jsonParser, true);
            } else if ("team_member".equals(tag)) {
                userLogInfoDeserialize = TeamMemberLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("trusted_non_team_member".equals(tag)) {
                userLogInfoDeserialize = TrustedNonTeamMemberLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("non_team_member".equals(tag)) {
                userLogInfoDeserialize = NonTeamMemberLogInfo.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else {
                throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!z) {
                expectEndObject(jsonParser);
            }
            StoneDeserializerLogger.log(userLogInfoDeserialize, userLogInfoDeserialize.toStringMultiline());
            return userLogInfoDeserialize;
        }
    }
}
