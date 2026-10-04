package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.AccessLevel;
import com.dropbox.core.p013v2.sharing.MemberSelector;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class UpdateFolderMemberArg {

    @Nonnull
    protected final AccessLevel accessLevel;

    @Nonnull
    protected final MemberSelector member;

    @Nonnull
    protected final String sharedFolderId;

    public UpdateFolderMemberArg(@Nonnull String str, @Nonnull MemberSelector memberSelector, @Nonnull AccessLevel accessLevel) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str;
        if (memberSelector == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = memberSelector;
        if (accessLevel == null) {
            throw new IllegalArgumentException("Required value for 'accessLevel' is null");
        }
        this.accessLevel = accessLevel;
    }

    @Nonnull
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Nonnull
    public MemberSelector getMember() {
        return this.member;
    }

    @Nonnull
    public AccessLevel getAccessLevel() {
        return this.accessLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedFolderId, this.member, this.accessLevel});
    }

    public boolean equals(Object obj) {
        MemberSelector memberSelector;
        MemberSelector memberSelector2;
        AccessLevel accessLevel;
        AccessLevel accessLevel2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        UpdateFolderMemberArg updateFolderMemberArg = (UpdateFolderMemberArg) obj;
        String str = this.sharedFolderId;
        String str2 = updateFolderMemberArg.sharedFolderId;
        return (str == str2 || str.equals(str2)) && ((memberSelector = this.member) == (memberSelector2 = updateFolderMemberArg.member) || memberSelector.equals(memberSelector2)) && ((accessLevel = this.accessLevel) == (accessLevel2 = updateFolderMemberArg.accessLevel) || accessLevel.equals(accessLevel2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<UpdateFolderMemberArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(UpdateFolderMemberArg updateFolderMemberArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(updateFolderMemberArg.sharedFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(updateFolderMemberArg.member, jsonGenerator);
            jsonGenerator.writeFieldName("access_level");
            AccessLevel.Serializer.INSTANCE.serialize(updateFolderMemberArg.accessLevel, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public UpdateFolderMemberArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                MemberSelector memberSelectorDeserialize = null;
                AccessLevel accessLevelDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("member".equals(currentName)) {
                        memberSelectorDeserialize = MemberSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("access_level".equals(currentName)) {
                        accessLevelDeserialize = AccessLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"shared_folder_id\" missing.");
                }
                if (memberSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member\" missing.");
                }
                if (accessLevelDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_level\" missing.");
                }
                UpdateFolderMemberArg updateFolderMemberArg = new UpdateFolderMemberArg(strDeserialize, memberSelectorDeserialize, accessLevelDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(updateFolderMemberArg, updateFolderMemberArg.toStringMultiline());
                return updateFolderMemberArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
