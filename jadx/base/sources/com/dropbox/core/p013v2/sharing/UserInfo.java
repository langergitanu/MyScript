package com.dropbox.core.p013v2.sharing;

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

/* JADX INFO: loaded from: classes4.dex */
public class UserInfo {

    @Nonnull
    protected final String accountId;

    @Nonnull
    protected final String displayName;

    @Nonnull
    protected final String email;
    protected final boolean sameTeam;

    @Nullable
    protected final String teamMemberId;

    public UserInfo(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, boolean z, @Nullable String str4) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'accountId' is null");
        }
        if (str.length() < 40) {
            throw new IllegalArgumentException("String 'accountId' is shorter than 40");
        }
        if (str.length() > 40) {
            throw new IllegalArgumentException("String 'accountId' is longer than 40");
        }
        this.accountId = str;
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'email' is null");
        }
        this.email = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Required value for 'displayName' is null");
        }
        this.displayName = str3;
        this.sameTeam = z;
        this.teamMemberId = str4;
    }

    public UserInfo(@Nonnull String str, @Nonnull String str2, @Nonnull String str3, boolean z) {
        this(str, str2, str3, z, null);
    }

    @Nonnull
    public String getAccountId() {
        return this.accountId;
    }

    @Nonnull
    public String getEmail() {
        return this.email;
    }

    @Nonnull
    public String getDisplayName() {
        return this.displayName;
    }

    public boolean getSameTeam() {
        return this.sameTeam;
    }

    @Nullable
    public String getTeamMemberId() {
        return this.teamMemberId;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.accountId, this.email, this.displayName, Boolean.valueOf(this.sameTeam), this.teamMemberId});
    }

    public boolean equals(Object obj) {
        UserInfo userInfo;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.accountId) == (str2 = (userInfo = (UserInfo) obj).accountId) || str.equals(str2)) && (((str3 = this.email) == (str4 = userInfo.email) || str3.equals(str4)) && (((str5 = this.displayName) == (str6 = userInfo.displayName) || str5.equals(str6)) && this.sameTeam == userInfo.sameTeam && ((str7 = this.teamMemberId) == (str8 = userInfo.teamMemberId) || (str7 != null && str7.equals(str8)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    public static class Serializer extends StructSerializer<UserInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserInfo userInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("account_id");
            StoneSerializers.string().serialize(userInfo.accountId, jsonGenerator);
            jsonGenerator.writeFieldName("email");
            StoneSerializers.string().serialize(userInfo.email, jsonGenerator);
            jsonGenerator.writeFieldName(Keys.DISPLAY_NAME);
            StoneSerializers.string().serialize(userInfo.displayName, jsonGenerator);
            jsonGenerator.writeFieldName("same_team");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(userInfo.sameTeam), jsonGenerator);
            if (userInfo.teamMemberId != null) {
                jsonGenerator.writeFieldName("team_member_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(userInfo.teamMemberId, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Boolean boolDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String strDeserialize3 = null;
                String str = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("account_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("email".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if (Keys.DISPLAY_NAME.equals(currentName)) {
                        strDeserialize3 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("same_team".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
                    } else if ("team_member_id".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"account_id\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"email\" missing.");
                }
                if (strDeserialize3 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"display_name\" missing.");
                }
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"same_team\" missing.");
                }
                UserInfo userInfo = new UserInfo(strDeserialize, strDeserialize2, strDeserialize3, boolDeserialize.booleanValue(), str);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userInfo, userInfo.toStringMultiline());
                return userInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
