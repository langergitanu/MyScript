package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.PlacementRestriction;
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
public class DataPlacementRestrictionChangePolicyDetails {

    @Nonnull
    protected final PlacementRestriction newValue;

    @Nonnull
    protected final PlacementRestriction previousValue;

    public DataPlacementRestrictionChangePolicyDetails(@Nonnull PlacementRestriction placementRestriction, @Nonnull PlacementRestriction placementRestriction2) {
        if (placementRestriction == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = placementRestriction;
        if (placementRestriction2 == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = placementRestriction2;
    }

    @Nonnull
    public PlacementRestriction getPreviousValue() {
        return this.previousValue;
    }

    @Nonnull
    public PlacementRestriction getNewValue() {
        return this.newValue;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.previousValue, this.newValue});
    }

    public boolean equals(Object obj) {
        PlacementRestriction placementRestriction;
        PlacementRestriction placementRestriction2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DataPlacementRestrictionChangePolicyDetails dataPlacementRestrictionChangePolicyDetails = (DataPlacementRestrictionChangePolicyDetails) obj;
        PlacementRestriction placementRestriction3 = this.previousValue;
        PlacementRestriction placementRestriction4 = dataPlacementRestrictionChangePolicyDetails.previousValue;
        return (placementRestriction3 == placementRestriction4 || placementRestriction3.equals(placementRestriction4)) && ((placementRestriction = this.newValue) == (placementRestriction2 = dataPlacementRestrictionChangePolicyDetails.newValue) || placementRestriction.equals(placementRestriction2));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DataPlacementRestrictionChangePolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DataPlacementRestrictionChangePolicyDetails dataPlacementRestrictionChangePolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("previous_value");
            PlacementRestriction.Serializer.INSTANCE.serialize(dataPlacementRestrictionChangePolicyDetails.previousValue, jsonGenerator);
            jsonGenerator.writeFieldName("new_value");
            PlacementRestriction.Serializer.INSTANCE.serialize(dataPlacementRestrictionChangePolicyDetails.newValue, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DataPlacementRestrictionChangePolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PlacementRestriction placementRestrictionDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                PlacementRestriction placementRestrictionDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("previous_value".equals(currentName)) {
                        placementRestrictionDeserialize = PlacementRestriction.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("new_value".equals(currentName)) {
                        placementRestrictionDeserialize2 = PlacementRestriction.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (placementRestrictionDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"previous_value\" missing.");
                }
                if (placementRestrictionDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"new_value\" missing.");
                }
                DataPlacementRestrictionChangePolicyDetails dataPlacementRestrictionChangePolicyDetails = new DataPlacementRestrictionChangePolicyDetails(placementRestrictionDeserialize, placementRestrictionDeserialize2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(dataPlacementRestrictionChangePolicyDetails, dataPlacementRestrictionChangePolicyDetails.toStringMultiline());
                return dataPlacementRestrictionChangePolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
