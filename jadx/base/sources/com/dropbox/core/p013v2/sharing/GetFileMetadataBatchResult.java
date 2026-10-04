package com.dropbox.core.p013v2.sharing;

import com.dropbox.core.p013v2.sharing.GetFileMetadataIndividualResult;
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
public class GetFileMetadataBatchResult {

    @Nonnull
    protected final String file;

    @Nonnull
    protected final GetFileMetadataIndividualResult result;

    public GetFileMetadataBatchResult(@Nonnull String str, @Nonnull GetFileMetadataIndividualResult getFileMetadataIndividualResult) {
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
        if (getFileMetadataIndividualResult == null) {
            throw new IllegalArgumentException("Required value for 'result' is null");
        }
        this.result = getFileMetadataIndividualResult;
    }

    @Nonnull
    public String getFile() {
        return this.file;
    }

    @Nonnull
    public GetFileMetadataIndividualResult getResult() {
        return this.result;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.file, this.result});
    }

    public boolean equals(Object obj) {
        GetFileMetadataIndividualResult getFileMetadataIndividualResult;
        GetFileMetadataIndividualResult getFileMetadataIndividualResult2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GetFileMetadataBatchResult getFileMetadataBatchResult = (GetFileMetadataBatchResult) obj;
        String str = this.file;
        String str2 = getFileMetadataBatchResult.file;
        return (str == str2 || str.equals(str2)) && ((getFileMetadataIndividualResult = this.result) == (getFileMetadataIndividualResult2 = getFileMetadataBatchResult.result) || getFileMetadataIndividualResult.equals(getFileMetadataIndividualResult2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GetFileMetadataBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GetFileMetadataBatchResult getFileMetadataBatchResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("file");
            StoneSerializers.string().serialize(getFileMetadataBatchResult.file, jsonGenerator);
            jsonGenerator.writeFieldName("result");
            GetFileMetadataIndividualResult.Serializer.INSTANCE.serialize(getFileMetadataBatchResult.result, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GetFileMetadataBatchResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GetFileMetadataIndividualResult getFileMetadataIndividualResultDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("file".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("result".equals(currentName)) {
                        getFileMetadataIndividualResultDeserialize = GetFileMetadataIndividualResult.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"file\" missing.");
                }
                if (getFileMetadataIndividualResultDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"result\" missing.");
                }
                GetFileMetadataBatchResult getFileMetadataBatchResult = new GetFileMetadataBatchResult(strDeserialize, getFileMetadataIndividualResultDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(getFileMetadataBatchResult, getFileMetadataBatchResult.toStringMultiline());
                return getFileMetadataBatchResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
