package com.dropbox.core.p013v2.paper;

import com.dropbox.core.p013v2.paper.AddPaperDocUserResult;
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
public class AddPaperDocUserMemberResult {

    @Nonnull
    protected final MemberSelector member;

    @Nonnull
    protected final AddPaperDocUserResult result;

    public AddPaperDocUserMemberResult(@Nonnull MemberSelector memberSelector, @Nonnull AddPaperDocUserResult addPaperDocUserResult) {
        if (memberSelector == null) {
            throw new IllegalArgumentException("Required value for 'member' is null");
        }
        this.member = memberSelector;
        if (addPaperDocUserResult == null) {
            throw new IllegalArgumentException("Required value for 'result' is null");
        }
        this.result = addPaperDocUserResult;
    }

    @Nonnull
    public MemberSelector getMember() {
        return this.member;
    }

    @Nonnull
    public AddPaperDocUserResult getResult() {
        return this.result;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.member, this.result});
    }

    public boolean equals(Object obj) {
        AddPaperDocUserResult addPaperDocUserResult;
        AddPaperDocUserResult addPaperDocUserResult2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        AddPaperDocUserMemberResult addPaperDocUserMemberResult = (AddPaperDocUserMemberResult) obj;
        MemberSelector memberSelector = this.member;
        MemberSelector memberSelector2 = addPaperDocUserMemberResult.member;
        return (memberSelector == memberSelector2 || memberSelector.equals(memberSelector2)) && ((addPaperDocUserResult = this.result) == (addPaperDocUserResult2 = addPaperDocUserMemberResult.result) || addPaperDocUserResult.equals(addPaperDocUserResult2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<AddPaperDocUserMemberResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(AddPaperDocUserMemberResult addPaperDocUserMemberResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("member");
            MemberSelector.Serializer.INSTANCE.serialize(addPaperDocUserMemberResult.member, jsonGenerator);
            jsonGenerator.writeFieldName("result");
            AddPaperDocUserResult.Serializer.INSTANCE.serialize(addPaperDocUserMemberResult.result, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public AddPaperDocUserMemberResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MemberSelector memberSelectorDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                AddPaperDocUserResult addPaperDocUserResultDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("member".equals(currentName)) {
                        memberSelectorDeserialize = MemberSelector.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("result".equals(currentName)) {
                        addPaperDocUserResultDeserialize = AddPaperDocUserResult.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (memberSelectorDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"member\" missing.");
                }
                if (addPaperDocUserResultDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"result\" missing.");
                }
                AddPaperDocUserMemberResult addPaperDocUserMemberResult = new AddPaperDocUserMemberResult(memberSelectorDeserialize, addPaperDocUserResultDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(addPaperDocUserMemberResult, addPaperDocUserMemberResult.toStringMultiline());
                return addPaperDocUserMemberResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
