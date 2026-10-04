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
public class DataPlacementRestrictionSatisfyPolicyDetails {

    @Nonnull
    protected final PlacementRestriction placementRestriction;

    public DataPlacementRestrictionSatisfyPolicyDetails(@Nonnull PlacementRestriction placementRestriction) {
        if (placementRestriction == null) {
            throw new IllegalArgumentException("Required value for 'placementRestriction' is null");
        }
        this.placementRestriction = placementRestriction;
    }

    @Nonnull
    public PlacementRestriction getPlacementRestriction() {
        return this.placementRestriction;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.placementRestriction});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PlacementRestriction placementRestriction = this.placementRestriction;
        PlacementRestriction placementRestriction2 = ((DataPlacementRestrictionSatisfyPolicyDetails) obj).placementRestriction;
        return placementRestriction == placementRestriction2 || placementRestriction.equals(placementRestriction2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DataPlacementRestrictionSatisfyPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DataPlacementRestrictionSatisfyPolicyDetails dataPlacementRestrictionSatisfyPolicyDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("placement_restriction");
            PlacementRestriction.Serializer.INSTANCE.serialize(dataPlacementRestrictionSatisfyPolicyDetails.placementRestriction, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public DataPlacementRestrictionSatisfyPolicyDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            PlacementRestriction placementRestrictionDeserialize = null;
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
                    if ("placement_restriction".equals(currentName)) {
                        placementRestrictionDeserialize = PlacementRestriction.Serializer.INSTANCE.deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (placementRestrictionDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"placement_restriction\" missing.");
                }
                DataPlacementRestrictionSatisfyPolicyDetails dataPlacementRestrictionSatisfyPolicyDetails = new DataPlacementRestrictionSatisfyPolicyDetails(placementRestrictionDeserialize);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(dataPlacementRestrictionSatisfyPolicyDetails, dataPlacementRestrictionSatisfyPolicyDetails.toStringMultiline());
                return dataPlacementRestrictionSatisfyPolicyDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
