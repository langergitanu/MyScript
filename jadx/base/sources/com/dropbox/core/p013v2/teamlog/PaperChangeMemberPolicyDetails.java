package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PaperMemberPolicy;
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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class PaperChangeMemberPolicyDetails {

    @Nonnull
    protected final PaperMemberPolicy newValue;

    @Nullable
    protected final PaperMemberPolicy previousValue;

    public PaperChangeMemberPolicyDetails(@Nonnull PaperMemberPolicy paperMemberPolicy, @Nullable PaperMemberPolicy paperMemberPolicy2) {
        if (paperMemberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = paperMemberPolicy;
        this.previousValue = paperMemberPolicy2;
    }

    public PaperChangeMemberPolicyDetails(@Nonnull PaperMemberPolicy paperMemberPolicy) {
        this(paperMemberPolicy, null);
    }

    @Nonnull
    public PaperMemberPolicy getNewValue() {
        return this.newValue;
    }

    @Nullable
    public PaperMemberPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        PaperMemberPolicy paperMemberPolicy;
        PaperMemberPolicy paperMemberPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperChangeMemberPolicyDetails paperChangeMemberPolicyDetails = (PaperChangeMemberPolicyDetails) obj;
        PaperMemberPolicy paperMemberPolicy3 = this.newValue;
        PaperMemberPolicy paperMemberPolicy4 = paperChangeMemberPolicyDetails.newValue;
        return (paperMemberPolicy3 == paperMemberPolicy4 || paperMemberPolicy3.equals(paperMemberPolicy4)) && ((paperMemberPolicy = this.previousValue) == (paperMemberPolicy2 = paperChangeMemberPolicyDetails.previousValue) || (paperMemberPolicy != null && paperMemberPolicy.equals(paperMemberPolicy2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperChangeMemberPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperChangeMemberPolicyDetails paperChangeMemberPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            PaperMemberPolicy.Serializer.INSTANCE.serialize(paperChangeMemberPolicyDetails.newValue, jsonGenerator);
            if (paperChangeMemberPolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(PaperMemberPolicy.Serializer.INSTANCE).serialize(paperChangeMemberPolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperChangeMemberPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PaperMemberPolicy paperMemberPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PaperMemberPolicy paperMemberPolicy = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        paperMemberPolicyDeserialize = PaperMemberPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        paperMemberPolicy = (PaperMemberPolicy) StoneSerializers.nullable(PaperMemberPolicy.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (paperMemberPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                PaperChangeMemberPolicyDetails paperChangeMemberPolicyDetails = new PaperChangeMemberPolicyDetails(paperMemberPolicyDeserialize, paperMemberPolicy);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperChangeMemberPolicyDetails, paperChangeMemberPolicyDetails.toStringMultiline());
                return paperChangeMemberPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
