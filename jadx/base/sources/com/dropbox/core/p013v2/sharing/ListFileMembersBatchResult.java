package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.ListFileMembersIndividualResult;
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
public class ListFileMembersBatchResult {

    @Nonnull
    protected final String file;

    @Nonnull
    protected final ListFileMembersIndividualResult result;

    public ListFileMembersBatchResult(@Nonnull String str, @Nonnull ListFileMembersIndividualResult listFileMembersIndividualResult) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'file' is null");
        }
        if (str.length() < 1) {
            throw new IllegalArgumentException("String 'file' is shorter than 1");
        }
        if (!Pattern.matches("((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?", str)) {
            throw new IllegalArgumentException("String 'file' does not match pattern");
        }
        this.file = str;
        if (listFileMembersIndividualResult == null) {
            throw new IllegalArgumentException("Required value for 'result' is null");
        }
        this.result = listFileMembersIndividualResult;
    }

    @Nonnull
    public String getFile() {
        return this.file;
    }

    @Nonnull
    public ListFileMembersIndividualResult getResult() {
        return this.result;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.file, this.result});
    }

    public boolean equals(Object obj) {
        ListFileMembersIndividualResult listFileMembersIndividualResult;
        ListFileMembersIndividualResult listFileMembersIndividualResult2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ListFileMembersBatchResult listFileMembersBatchResult = (ListFileMembersBatchResult) obj;
        String str = this.file;
        String str2 = listFileMembersBatchResult.file;
        return (str == str2 || str.equals(str2)) && ((listFileMembersIndividualResult = this.result) == (listFileMembersIndividualResult2 = listFileMembersBatchResult.result) || listFileMembersIndividualResult.equals(listFileMembersIndividualResult2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<ListFileMembersBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(ListFileMembersBatchResult listFileMembersBatchResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("file");
            StoneSerializers.string().serialize(listFileMembersBatchResult.file, jsonGenerator);
            jsonGenerator.writeFieldName("result");
            ListFileMembersIndividualResult.Serializer.INSTANCE.serialize(listFileMembersBatchResult.result, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public ListFileMembersBatchResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                ListFileMembersIndividualResult listFileMembersIndividualResultDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("file".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("result".equals(currentName)) {
                        listFileMembersIndividualResultDeserialize = ListFileMembersIndividualResult.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file\" missing.");
                }
                if (listFileMembersIndividualResultDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"result\" missing.");
                }
                ListFileMembersBatchResult listFileMembersBatchResult = new ListFileMembersBatchResult(strDeserialize, listFileMembersIndividualResultDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(listFileMembersBatchResult, listFileMembersBatchResult.toStringMultiline());
                return listFileMembersBatchResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
