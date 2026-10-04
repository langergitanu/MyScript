package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PaperMemberPolicy;
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
public class PaperChangeMemberLinkPolicyDetails {

    @Nonnull
    protected final PaperMemberPolicy newValue;

    public PaperChangeMemberLinkPolicyDetails(@Nonnull PaperMemberPolicy paperMemberPolicy) {
        if (paperMemberPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = paperMemberPolicy;
    }

    @Nonnull
    public PaperMemberPolicy getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperMemberPolicy paperMemberPolicy = this.newValue;
        PaperMemberPolicy paperMemberPolicy2 = ((PaperChangeMemberLinkPolicyDetails) obj).newValue;
        return paperMemberPolicy == paperMemberPolicy2 || paperMemberPolicy.equals(paperMemberPolicy2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperChangeMemberLinkPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperChangeMemberLinkPolicyDetails paperChangeMemberLinkPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            PaperMemberPolicy.Serializer.INSTANCE.serialize(paperChangeMemberLinkPolicyDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperChangeMemberLinkPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PaperMemberPolicy paperMemberPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        paperMemberPolicyDeserialize = PaperMemberPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (paperMemberPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                PaperChangeMemberLinkPolicyDetails paperChangeMemberLinkPolicyDetails = new PaperChangeMemberLinkPolicyDetails(paperMemberPolicyDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperChangeMemberLinkPolicyDetails, paperChangeMemberLinkPolicyDetails.toStringMultiline());
                return paperChangeMemberLinkPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
