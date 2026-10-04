package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.SmarterSmartSyncPolicyState;
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
public class SmarterSmartSyncPolicyChangedDetails {

    @Nonnull
    protected final SmarterSmartSyncPolicyState newValue;

    @Nonnull
    protected final SmarterSmartSyncPolicyState previousValue;

    public SmarterSmartSyncPolicyChangedDetails(@Nonnull SmarterSmartSyncPolicyState smarterSmartSyncPolicyState, @Nonnull SmarterSmartSyncPolicyState smarterSmartSyncPolicyState2) {
        if (smarterSmartSyncPolicyState == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = smarterSmartSyncPolicyState;
        if (smarterSmartSyncPolicyState2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = smarterSmartSyncPolicyState2;
    }

    @Nonnull
    public SmarterSmartSyncPolicyState getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public SmarterSmartSyncPolicyState getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        SmarterSmartSyncPolicyState smarterSmartSyncPolicyState;
        SmarterSmartSyncPolicyState smarterSmartSyncPolicyState2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        SmarterSmartSyncPolicyChangedDetails smarterSmartSyncPolicyChangedDetails = (SmarterSmartSyncPolicyChangedDetails) obj;
        SmarterSmartSyncPolicyState smarterSmartSyncPolicyState3 = this.previousValue;
        SmarterSmartSyncPolicyState smarterSmartSyncPolicyState4 = smarterSmartSyncPolicyChangedDetails.previousValue;
        return (smarterSmartSyncPolicyState3 == smarterSmartSyncPolicyState4 || smarterSmartSyncPolicyState3.equals(smarterSmartSyncPolicyState4)) && ((smarterSmartSyncPolicyState = this.newValue) == (smarterSmartSyncPolicyState2 = smarterSmartSyncPolicyChangedDetails.newValue) || smarterSmartSyncPolicyState.equals(smarterSmartSyncPolicyState2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<SmarterSmartSyncPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(SmarterSmartSyncPolicyChangedDetails smarterSmartSyncPolicyChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            SmarterSmartSyncPolicyState.Serializer.INSTANCE.serialize(smarterSmartSyncPolicyChangedDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            SmarterSmartSyncPolicyState.Serializer.INSTANCE.serialize(smarterSmartSyncPolicyChangedDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public SmarterSmartSyncPolicyChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            SmarterSmartSyncPolicyState smarterSmartSyncPolicyStateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                SmarterSmartSyncPolicyState smarterSmartSyncPolicyStateDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        smarterSmartSyncPolicyStateDeserialize = SmarterSmartSyncPolicyState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        smarterSmartSyncPolicyStateDeserialize2 = SmarterSmartSyncPolicyState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (smarterSmartSyncPolicyStateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (smarterSmartSyncPolicyStateDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                SmarterSmartSyncPolicyChangedDetails smarterSmartSyncPolicyChangedDetails = new SmarterSmartSyncPolicyChangedDetails(smarterSmartSyncPolicyStateDeserialize, smarterSmartSyncPolicyStateDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(smarterSmartSyncPolicyChangedDetails, smarterSmartSyncPolicyChangedDetails.toStringMultiline());
                return smarterSmartSyncPolicyChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
