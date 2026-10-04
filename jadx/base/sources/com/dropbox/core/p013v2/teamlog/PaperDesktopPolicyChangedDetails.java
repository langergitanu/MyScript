package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PaperDesktopPolicy;
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
public class PaperDesktopPolicyChangedDetails {

    @Nonnull
    protected final PaperDesktopPolicy newValue;

    @Nonnull
    protected final PaperDesktopPolicy previousValue;

    public PaperDesktopPolicyChangedDetails(@Nonnull PaperDesktopPolicy paperDesktopPolicy, @Nonnull PaperDesktopPolicy paperDesktopPolicy2) {
        if (paperDesktopPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = paperDesktopPolicy;
        if (paperDesktopPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = paperDesktopPolicy2;
    }

    @Nonnull
    public PaperDesktopPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public PaperDesktopPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        PaperDesktopPolicy paperDesktopPolicy;
        PaperDesktopPolicy paperDesktopPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperDesktopPolicyChangedDetails paperDesktopPolicyChangedDetails = (PaperDesktopPolicyChangedDetails) obj;
        PaperDesktopPolicy paperDesktopPolicy3 = this.newValue;
        PaperDesktopPolicy paperDesktopPolicy4 = paperDesktopPolicyChangedDetails.newValue;
        return (paperDesktopPolicy3 == paperDesktopPolicy4 || paperDesktopPolicy3.equals(paperDesktopPolicy4)) && ((paperDesktopPolicy = this.previousValue) == (paperDesktopPolicy2 = paperDesktopPolicyChangedDetails.previousValue) || paperDesktopPolicy.equals(paperDesktopPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperDesktopPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperDesktopPolicyChangedDetails paperDesktopPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            PaperDesktopPolicy.Serializer.INSTANCE.serialize(paperDesktopPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            PaperDesktopPolicy.Serializer.INSTANCE.serialize(paperDesktopPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperDesktopPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PaperDesktopPolicy paperDesktopPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperDesktopPolicy paperDesktopPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        paperDesktopPolicyDeserialize = PaperDesktopPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        paperDesktopPolicyDeserialize2 = PaperDesktopPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (paperDesktopPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (paperDesktopPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                PaperDesktopPolicyChangedDetails paperDesktopPolicyChangedDetails = new PaperDesktopPolicyChangedDetails(paperDesktopPolicyDeserialize, paperDesktopPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperDesktopPolicyChangedDetails, paperDesktopPolicyChangedDetails.toStringMultiline());
                return paperDesktopPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
