package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PaperDefaultFolderPolicy;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class PaperDefaultFolderPolicyChangedDetails {

    @Nonnull
    protected final PaperDefaultFolderPolicy newValue;

    @Nonnull
    protected final PaperDefaultFolderPolicy previousValue;

    public PaperDefaultFolderPolicyChangedDetails(@Nonnull PaperDefaultFolderPolicy paperDefaultFolderPolicy, @Nonnull PaperDefaultFolderPolicy paperDefaultFolderPolicy2) {
        if (paperDefaultFolderPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = paperDefaultFolderPolicy;
        if (paperDefaultFolderPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = paperDefaultFolderPolicy2;
    }

    @Nonnull
    public PaperDefaultFolderPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public PaperDefaultFolderPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        PaperDefaultFolderPolicy paperDefaultFolderPolicy;
        PaperDefaultFolderPolicy paperDefaultFolderPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperDefaultFolderPolicyChangedDetails paperDefaultFolderPolicyChangedDetails = (PaperDefaultFolderPolicyChangedDetails) obj;
        PaperDefaultFolderPolicy paperDefaultFolderPolicy3 = this.newValue;
        PaperDefaultFolderPolicy paperDefaultFolderPolicy4 = paperDefaultFolderPolicyChangedDetails.newValue;
        return (paperDefaultFolderPolicy3 == paperDefaultFolderPolicy4 || paperDefaultFolderPolicy3.equals(paperDefaultFolderPolicy4)) && ((paperDefaultFolderPolicy = this.previousValue) == (paperDefaultFolderPolicy2 = paperDefaultFolderPolicyChangedDetails.previousValue) || paperDefaultFolderPolicy.equals(paperDefaultFolderPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDefaultFolderPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDefaultFolderPolicyChangedDetails paperDefaultFolderPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            PaperDefaultFolderPolicy.Serializer.INSTANCE.serialize(paperDefaultFolderPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            PaperDefaultFolderPolicy.Serializer.INSTANCE.serialize(paperDefaultFolderPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDefaultFolderPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PaperDefaultFolderPolicy paperDefaultFolderPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperDefaultFolderPolicy paperDefaultFolderPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        paperDefaultFolderPolicyDeserialize = PaperDefaultFolderPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        paperDefaultFolderPolicyDeserialize2 = PaperDefaultFolderPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (paperDefaultFolderPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (paperDefaultFolderPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                PaperDefaultFolderPolicyChangedDetails paperDefaultFolderPolicyChangedDetails = new PaperDefaultFolderPolicyChangedDetails(paperDefaultFolderPolicyDeserialize, paperDefaultFolderPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDefaultFolderPolicyChangedDetails, paperDefaultFolderPolicyChangedDetails.toStringMultiline());
                return paperDefaultFolderPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
