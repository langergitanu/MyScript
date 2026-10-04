package com.dropbox.core.p013v2.team;

import aws.sdk.kotlin.runtime.auth.credentials.profile.ProfileChainKt;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class UserSelectorArg {
    private Tag _tag;
    private String emailValue;
    private String externalIdValue;
    private String teamMemberIdValue;

    public enum Tag {
        TEAM_MEMBER_ID,
        EXTERNAL_ID,
        EMAIL
    }

    private UserSelectorArg() {
    }

    private UserSelectorArg withTag(Tag tag) {
        UserSelectorArg userSelectorArg = new UserSelectorArg();
        userSelectorArg._tag = tag;
        return userSelectorArg;
    }

    private UserSelectorArg withTagAndTeamMemberId(Tag tag, String str) {
        UserSelectorArg userSelectorArg = new UserSelectorArg();
        userSelectorArg._tag = tag;
        userSelectorArg.teamMemberIdValue = str;
        return userSelectorArg;
    }

    private UserSelectorArg withTagAndExternalId(Tag tag, String str) {
        UserSelectorArg userSelectorArg = new UserSelectorArg();
        userSelectorArg._tag = tag;
        userSelectorArg.externalIdValue = str;
        return userSelectorArg;
    }

    private UserSelectorArg withTagAndEmail(Tag tag, String str) {
        UserSelectorArg userSelectorArg = new UserSelectorArg();
        userSelectorArg._tag = tag;
        userSelectorArg.emailValue = str;
        return userSelectorArg;
    }

    public Tag tag() {
        return this._tag;
    }

    public boolean isTeamMemberId() {
        return this._tag == Tag.TEAM_MEMBER_ID;
    }

    public static UserSelectorArg teamMemberId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UserSelectorArg().withTagAndTeamMemberId(Tag.TEAM_MEMBER_ID, str);
    }

    public String getTeamMemberIdValue() {
        if (this._tag != Tag.TEAM_MEMBER_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.TEAM_MEMBER_ID, but was Tag." + this._tag.name());
        }
        return this.teamMemberIdValue;
    }

    public boolean isExternalId() {
        return this._tag == Tag.EXTERNAL_ID;
    }

    public static UserSelectorArg externalId(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 64) {
            throw new IllegalArgumentException("String is longer than 64");
        }
        return new UserSelectorArg().withTagAndExternalId(Tag.EXTERNAL_ID, str);
    }

    public String getExternalIdValue() {
        if (this._tag != Tag.EXTERNAL_ID) {
            throw new IllegalStateException("Invalid tag: required Tag.EXTERNAL_ID, but was Tag." + this._tag.name());
        }
        return this.externalIdValue;
    }

    public boolean isEmail() {
        return this._tag == Tag.EMAIL;
    }

    public static UserSelectorArg email(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (str.length() > 255) {
            throw new IllegalArgumentException("String is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", str)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new UserSelectorArg().withTagAndEmail(Tag.EMAIL, str);
    }

    public String getEmailValue() {
        if (this._tag != Tag.EMAIL) {
            throw new IllegalStateException("Invalid tag: required Tag.EMAIL, but was Tag." + this._tag.name());
        }
        return this.emailValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this._tag, this.teamMemberIdValue, this.externalIdValue, this.emailValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof UserSelectorArg)) {
            return false;
        }
        UserSelectorArg userSelectorArg = (UserSelectorArg) obj;
        if (this._tag != userSelectorArg._tag) {
            return false;
        }
        int i = C44241.$SwitchMap$com$dropbox$core$v2$team$UserSelectorArg$Tag[this._tag.ordinal()];
        if (i == 1) {
            String str = this.teamMemberIdValue;
            String str2 = userSelectorArg.teamMemberIdValue;
            return str == str2 || str.equals(str2);
        }
        if (i == 2) {
            String str3 = this.externalIdValue;
            String str4 = userSelectorArg.externalIdValue;
            return str3 == str4 || str3.equals(str4);
        }
        if (i != 3) {
            return false;
        }
        String str5 = this.emailValue;
        String str6 = userSelectorArg.emailValue;
        return str5 == str6 || str5.equals(str6);
    }

    /* JADX INFO: renamed from: com.dropbox.core.v2.team.UserSelectorArg$1 */
    static /* synthetic */ class C44241 {
        static final /* synthetic */ int[] $SwitchMap$com$dropbox$core$v2$team$UserSelectorArg$Tag;

        static {
            int[] iArr = new int[Tag.values().length];
            $SwitchMap$com$dropbox$core$v2$team$UserSelectorArg$Tag = iArr;
            try {
                iArr[Tag.TEAM_MEMBER_ID.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserSelectorArg$Tag[Tag.EXTERNAL_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dropbox$core$v2$team$UserSelectorArg$Tag[Tag.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends UnionSerializer<UserSelectorArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public void serialize(UserSelectorArg userSelectorArg, JsonGenerator jsonGenerator) throws IOException {
            int i = C44241.$SwitchMap$com$dropbox$core$v2$team$UserSelectorArg$Tag[userSelectorArg.tag().ordinal()];
            if (i == 1) {
                jsonGenerator.writeStartObject();
                writeTag("team_member_id", jsonGenerator);
                jsonGenerator.writeFieldName("team_member_id");
                StoneSerializers.string().serialize(userSelectorArg.teamMemberIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 2) {
                jsonGenerator.writeStartObject();
                writeTag(ProfileChainKt.EXTERNAL_ID, jsonGenerator);
                jsonGenerator.writeFieldName(ProfileChainKt.EXTERNAL_ID);
                StoneSerializers.string().serialize(userSelectorArg.externalIdValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            if (i == 3) {
                jsonGenerator.writeStartObject();
                writeTag("email", jsonGenerator);
                jsonGenerator.writeFieldName("email");
                StoneSerializers.string().serialize(userSelectorArg.emailValue, jsonGenerator);
                jsonGenerator.writeEndObject();
                return;
            }
            throw new IllegalArgumentException("Unrecognized tag: " + userSelectorArg.tag());
        }

        @Override // com.dropbox.core.stone.StoneSerializer
        public UserSelectorArg deserialize(JsonParser jsonParser) throws IOException {
            String tag;
            boolean z;
            UserSelectorArg userSelectorArgEmail;
            if (jsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
                tag = getStringValue(jsonParser);
                jsonParser.nextToken();
                z = true;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                z = false;
            }
            if (tag == null) {
                throw new JsonParseException(jsonParser, "Required field missing: .tag");
            }
            if ("team_member_id".equals(tag)) {
                expectField("team_member_id", jsonParser);
                userSelectorArgEmail = UserSelectorArg.teamMemberId(StoneSerializers.string().deserialize(jsonParser));
            } else if (ProfileChainKt.EXTERNAL_ID.equals(tag)) {
                expectField(ProfileChainKt.EXTERNAL_ID, jsonParser);
                userSelectorArgEmail = UserSelectorArg.externalId(StoneSerializers.string().deserialize(jsonParser));
            } else if ("email".equals(tag)) {
                expectField("email", jsonParser);
                userSelectorArgEmail = UserSelectorArg.email(StoneSerializers.string().deserialize(jsonParser));
            } else {
                throw new JsonParseException(jsonParser, "Unknown tag: " + tag);
            }
            if (!z) {
                skipFields(jsonParser);
                expectEndObject(jsonParser);
            }
            return userSelectorArgEmail;
        }
    }
}
