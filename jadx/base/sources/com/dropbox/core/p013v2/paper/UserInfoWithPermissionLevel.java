package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.PaperDocPermissionLevel;
import com.dropbox.core.p013v2.sharing.UserInfo;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public class UserInfoWithPermissionLevel {

    @Nonnull
    protected final PaperDocPermissionLevel permissionLevel;

    @Nonnull
    protected final UserInfo user;

    public UserInfoWithPermissionLevel(@Nonnull UserInfo userInfo, @Nonnull PaperDocPermissionLevel paperDocPermissionLevel) {
        if (userInfo == null) {
            throw new IllegalArgumentException("Required value for 'user' is null");
        }
        this.user = userInfo;
        if (paperDocPermissionLevel == null) {
            throw new IllegalArgumentException("Required value for 'permissionLevel' is null");
        }
        this.permissionLevel = paperDocPermissionLevel;
    }

    @Nonnull
    public UserInfo getUser() {
        return this.user;
    }

    @Nonnull
    public PaperDocPermissionLevel getPermissionLevel() {
        return this.permissionLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.user, this.permissionLevel});
    }

    public boolean equals(Object obj) {
        PaperDocPermissionLevel paperDocPermissionLevel;
        PaperDocPermissionLevel paperDocPermissionLevel2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UserInfoWithPermissionLevel userInfoWithPermissionLevel = (UserInfoWithPermissionLevel) obj;
        UserInfo userInfo = this.user;
        UserInfo userInfo2 = userInfoWithPermissionLevel.user;
        return (userInfo == userInfo2 || userInfo.equals(userInfo2)) && ((paperDocPermissionLevel = this.permissionLevel) == (paperDocPermissionLevel2 = userInfoWithPermissionLevel.permissionLevel) || paperDocPermissionLevel.equals(paperDocPermissionLevel2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UserInfoWithPermissionLevel> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UserInfoWithPermissionLevel userInfoWithPermissionLevel, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("user");
            UserInfo.Serializer.INSTANCE.serialize(userInfoWithPermissionLevel.user, jsonGenerator);
            jsonGenerator.writeFieldName("permission_level");
            PaperDocPermissionLevel.Serializer.INSTANCE.serialize(userInfoWithPermissionLevel.permissionLevel, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UserInfoWithPermissionLevel deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            UserInfo userInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperDocPermissionLevel paperDocPermissionLevelDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("user".equals(currentName)) {
                        userInfoDeserialize = UserInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("permission_level".equals(currentName)) {
                        paperDocPermissionLevelDeserialize = PaperDocPermissionLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (userInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"user\" missing.");
                }
                if (paperDocPermissionLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"permission_level\" missing.");
                }
                UserInfoWithPermissionLevel userInfoWithPermissionLevel = new UserInfoWithPermissionLevel(userInfoDeserialize, paperDocPermissionLevelDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(userInfoWithPermissionLevel, userInfoWithPermissionLevel.toStringMultiline());
                return userInfoWithPermissionLevel;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
