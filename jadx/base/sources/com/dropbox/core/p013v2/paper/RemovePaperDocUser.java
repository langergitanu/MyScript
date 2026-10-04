package com.dropbox.core.p013v2.paper;

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
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
class RemovePaperDocUser extends RefPaperDoc {

    @Nonnull
    protected final MemberSelector member;

    public RemovePaperDocUser(@Nonnull String str, @Nonnull MemberSelector memberSelector) {
        super(str);
        if (memberSelector == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = memberSelector;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    @Nonnull
    public String getDocId() {
        return this.docId;
    }

    @Nonnull
    public MemberSelector getMember() {
        return this.member;
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.member});
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public boolean equals(Object obj) {
        MemberSelector memberSelector;
        MemberSelector memberSelector2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        RemovePaperDocUser removePaperDocUser = (RemovePaperDocUser) obj;
        return (this.docId == removePaperDocUser.docId || this.docId.equals(removePaperDocUser.docId)) && ((memberSelector = this.member) == (memberSelector2 = removePaperDocUser.member) || memberSelector.equals(memberSelector2));
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.paper.RefPaperDoc
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RemovePaperDocUser> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RemovePaperDocUser removePaperDocUser, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("doc_id");
            StoneSerializers.string().serialize(removePaperDocUser.docId, jsonGenerator);
            jsonGenerator.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(removePaperDocUser.member, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RemovePaperDocUser deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("doc_id".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("member".equals(currentName)) {
                        memberSelectorDeserialize = MemberSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"doc_id\" missing.");
                }
                if (memberSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member\" missing.");
                }
                RemovePaperDocUser removePaperDocUser = new RemovePaperDocUser(strDeserialize, memberSelectorDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(removePaperDocUser, removePaperDocUser.toStringMultiline());
                return removePaperDocUser;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
