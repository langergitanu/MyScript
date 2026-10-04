package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.RewindPolicy;
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
public class RewindPolicyChangedDetails {

    @Nonnull
    protected final RewindPolicy newValue;

    @Nonnull
    protected final RewindPolicy previousValue;

    public RewindPolicyChangedDetails(@Nonnull RewindPolicy rewindPolicy, @Nonnull RewindPolicy rewindPolicy2) {
        if (rewindPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = rewindPolicy;
        if (rewindPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = rewindPolicy2;
    }

    @Nonnull
    public RewindPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public RewindPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        RewindPolicy rewindPolicy;
        RewindPolicy rewindPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        RewindPolicyChangedDetails rewindPolicyChangedDetails = (RewindPolicyChangedDetails) obj;
        RewindPolicy rewindPolicy3 = this.newValue;
        RewindPolicy rewindPolicy4 = rewindPolicyChangedDetails.newValue;
        return (rewindPolicy3 == rewindPolicy4 || rewindPolicy3.equals(rewindPolicy4)) && ((rewindPolicy = this.previousValue) == (rewindPolicy2 = rewindPolicyChangedDetails.previousValue) || rewindPolicy.equals(rewindPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RewindPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RewindPolicyChangedDetails rewindPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            RewindPolicy.Serializer.INSTANCE.serialize(rewindPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            RewindPolicy.Serializer.INSTANCE.serialize(rewindPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RewindPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            RewindPolicy rewindPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                RewindPolicy rewindPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        rewindPolicyDeserialize = RewindPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        rewindPolicyDeserialize2 = RewindPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (rewindPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (rewindPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                RewindPolicyChangedDetails rewindPolicyChangedDetails = new RewindPolicyChangedDetails(rewindPolicyDeserialize, rewindPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(rewindPolicyChangedDetails, rewindPolicyChangedDetails.toStringMultiline());
                return rewindPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
