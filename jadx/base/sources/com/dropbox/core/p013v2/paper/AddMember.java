package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.PaperDocPermissionLevel;
import com.dropbox.core.p013v2.sharing.MemberSelector;
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
public class AddMember {

    @Nonnull
    protected final MemberSelector member;

    @Nonnull
    protected final PaperDocPermissionLevel permissionLevel;

    public AddMember(@Nonnull MemberSelector memberSelector, @Nonnull PaperDocPermissionLevel paperDocPermissionLevel) {
        if (paperDocPermissionLevel == null) {
            throw new IllegalArgumentException("Required value for 'permissionLevel' is null");
        }
        this.permissionLevel = paperDocPermissionLevel;
        if (memberSelector == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = memberSelector;
    }

    public AddMember(@Nonnull MemberSelector memberSelector) {
        this(memberSelector, PaperDocPermissionLevel.EDIT);
    }

    @Nonnull
    public MemberSelector getMember() {
        return this.member;
    }

    @Nonnull
    public PaperDocPermissionLevel getPermissionLevel() {
        return this.permissionLevel;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.permissionLevel, this.member});
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
        AddMember addMember = (AddMember) obj;
        MemberSelector memberSelector = this.member;
        MemberSelector memberSelector2 = addMember.member;
        return (memberSelector == memberSelector2 || memberSelector.equals(memberSelector2)) && ((paperDocPermissionLevel = this.permissionLevel) == (paperDocPermissionLevel2 = addMember.permissionLevel) || paperDocPermissionLevel.equals(paperDocPermissionLevel2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AddMember> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AddMember addMember, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(addMember.member, jsonGenerator);
            jsonGenerator.writeFieldName("permission_level");
            PaperDocPermissionLevel.Serializer.INSTANCE.serialize(addMember.permissionLevel, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AddMember deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MemberSelector memberSelectorDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperDocPermissionLevel paperDocPermissionLevelDeserialize = PaperDocPermissionLevel.EDIT;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("member".equals(currentName)) {
                        memberSelectorDeserialize = MemberSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("permission_level".equals(currentName)) {
                        paperDocPermissionLevelDeserialize = PaperDocPermissionLevel.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member\" missing.");
                }
                AddMember addMember = new AddMember(memberSelectorDeserialize, paperDocPermissionLevelDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(addMember, addMember.toStringMultiline());
                return addMember;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
