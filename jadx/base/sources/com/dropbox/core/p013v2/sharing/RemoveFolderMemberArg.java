package com.dropbox.core.p013v2.sharing;

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
class RemoveFolderMemberArg {
    protected final boolean leaveACopy;

    @Nonnull
    protected final MemberSelector member;

    @Nonnull
    protected final String sharedFolderId;

    public RemoveFolderMemberArg(@Nonnull String str, @Nonnull MemberSelector memberSelector, boolean z) {
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
        this.leaveACopy = z;
    }

    @Nonnull
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Nonnull
    public MemberSelector getMember() {
        return this.member;
    }

    public boolean getLeaveACopy() {
        return this.leaveACopy;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.sharedFolderId, this.member, Boolean.valueOf(this.leaveACopy)});
    }

    public boolean equals(Object obj) {
        RemoveFolderMemberArg removeFolderMemberArg;
        String str;
        String str2;
        MemberSelector memberSelector;
        MemberSelector memberSelector2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.sharedFolderId) == (str2 = (removeFolderMemberArg = (RemoveFolderMemberArg) obj).sharedFolderId) || str.equals(str2)) && (((memberSelector = this.member) == (memberSelector2 = removeFolderMemberArg.member) || memberSelector.equals(memberSelector2)) && this.leaveACopy == removeFolderMemberArg.leaveACopy);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RemoveFolderMemberArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RemoveFolderMemberArg removeFolderMemberArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(removeFolderMemberArg.sharedFolderId, jsonGenerator);
            jsonGenerator.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(removeFolderMemberArg.member, jsonGenerator);
            jsonGenerator.writeFieldName("leave_a_copy");
            StoneSerializers.boolean_().serialize(Boolean.valueOf(removeFolderMemberArg.leaveACopy), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RemoveFolderMemberArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                Boolean boolDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("shared_folder_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("member".equals(currentName)) {
                        memberSelectorDeserialize = MemberSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("leave_a_copy".equals(currentName)) {
                        boolDeserialize = StoneSerializers.boolean_().deserialize(jsonParser);
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
                if (boolDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"leave_a_copy\" missing.");
                }
                RemoveFolderMemberArg removeFolderMemberArg = new RemoveFolderMemberArg(strDeserialize, memberSelectorDeserialize, boolDeserialize.booleanValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(removeFolderMemberArg, removeFolderMemberArg.toStringMultiline());
                return removeFolderMemberArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
