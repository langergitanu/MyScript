package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.InviteAcceptanceEmailPolicy;
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
public class InviteAcceptanceEmailPolicyChangedDetails {

    @Nonnull
    protected final InviteAcceptanceEmailPolicy newValue;

    @Nonnull
    protected final InviteAcceptanceEmailPolicy previousValue;

    public InviteAcceptanceEmailPolicyChangedDetails(@Nonnull InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicy, @Nonnull InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicy2) {
        if (inviteAcceptanceEmailPolicy == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = inviteAcceptanceEmailPolicy;
        if (inviteAcceptanceEmailPolicy2 == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = inviteAcceptanceEmailPolicy2;
    }

    @Nonnull
    public InviteAcceptanceEmailPolicy getNewValue() {
        return this.newValue;
    }

    @Nonnull
    public InviteAcceptanceEmailPolicy getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicy;
        InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicy2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        InviteAcceptanceEmailPolicyChangedDetails inviteAcceptanceEmailPolicyChangedDetails = (InviteAcceptanceEmailPolicyChangedDetails) obj;
        InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicy3 = this.newValue;
        InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicy4 = inviteAcceptanceEmailPolicyChangedDetails.newValue;
        return (inviteAcceptanceEmailPolicy3 == inviteAcceptanceEmailPolicy4 || inviteAcceptanceEmailPolicy3.equals(inviteAcceptanceEmailPolicy4)) && ((inviteAcceptanceEmailPolicy = this.previousValue) == (inviteAcceptanceEmailPolicy2 = inviteAcceptanceEmailPolicyChangedDetails.previousValue) || inviteAcceptanceEmailPolicy.equals(inviteAcceptanceEmailPolicy2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<InviteAcceptanceEmailPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(InviteAcceptanceEmailPolicyChangedDetails inviteAcceptanceEmailPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            InviteAcceptanceEmailPolicy.Serializer.INSTANCE.serialize(inviteAcceptanceEmailPolicyChangedDetails.newValue, jsonGenerator);
            jsonGenerator.writeFieldName("previous_value");
            InviteAcceptanceEmailPolicy.Serializer.INSTANCE.serialize(inviteAcceptanceEmailPolicyChangedDetails.previousValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public InviteAcceptanceEmailPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicyDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                InviteAcceptanceEmailPolicy inviteAcceptanceEmailPolicyDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        inviteAcceptanceEmailPolicyDeserialize = InviteAcceptanceEmailPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        inviteAcceptanceEmailPolicyDeserialize2 = InviteAcceptanceEmailPolicy.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (inviteAcceptanceEmailPolicyDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                if (inviteAcceptanceEmailPolicyDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                InviteAcceptanceEmailPolicyChangedDetails inviteAcceptanceEmailPolicyChangedDetails = new InviteAcceptanceEmailPolicyChangedDetails(inviteAcceptanceEmailPolicyDeserialize, inviteAcceptanceEmailPolicyDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(inviteAcceptanceEmailPolicyChangedDetails, inviteAcceptanceEmailPolicyChangedDetails.toStringMultiline());
                return inviteAcceptanceEmailPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
