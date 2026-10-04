package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teampolicies.EmmState;
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
public class EmmChangePolicyDetails {

    @Nonnull
    protected final EmmState newValue;

    @Nullable
    protected final EmmState previousValue;

    public EmmChangePolicyDetails(@Nonnull EmmState emmState, @Nullable EmmState emmState2) {
        if (emmState == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = emmState;
        this.previousValue = emmState2;
    }

    public EmmChangePolicyDetails(@Nonnull EmmState emmState) {
        this(emmState, null);
    }

    @Nonnull
    public EmmState getNewValue() {
        return this.newValue;
    }

    @Nullable
    public EmmState getPreviousValue() {
        return this.previousValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.newValue, this.previousValue});
    }

    public boolean equals(Object obj) {
        EmmState emmState;
        EmmState emmState2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        EmmChangePolicyDetails emmChangePolicyDetails = (EmmChangePolicyDetails) obj;
        EmmState emmState3 = this.newValue;
        EmmState emmState4 = emmChangePolicyDetails.newValue;
        return (emmState3 == emmState4 || emmState3.equals(emmState4)) && ((emmState = this.previousValue) == (emmState2 = emmChangePolicyDetails.previousValue) || (emmState != null && emmState.equals(emmState2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<EmmChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(EmmChangePolicyDetails emmChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("new_value");
            EmmState.Serializer.INSTANCE.serialize(emmChangePolicyDetails.newValue, jsonGenerator);
            if (emmChangePolicyDetails.previousValue != null) {
                jsonGenerator.writeFieldName("previous_value");
                StoneSerializers.nullable(EmmState.Serializer.INSTANCE).serialize(emmChangePolicyDetails.previousValue, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public EmmChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            EmmState emmStateDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                EmmState emmState = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("new_value".equals(currentName)) {
                        emmStateDeserialize = EmmState.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("previous_value".equals(currentName)) {
                        emmState = (EmmState) StoneSerializers.nullable(EmmState.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (emmStateDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                EmmChangePolicyDetails emmChangePolicyDetails = new EmmChangePolicyDetails(emmStateDeserialize, emmState);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(emmChangePolicyDetails, emmChangePolicyDetails.toStringMultiline());
                return emmChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
