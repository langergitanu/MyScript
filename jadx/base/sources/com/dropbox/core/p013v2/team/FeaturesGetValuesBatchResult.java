package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.FeatureValue;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class FeaturesGetValuesBatchResult {

    @Nonnull
    protected final List<FeatureValue> values;

    public FeaturesGetValuesBatchResult(@Nonnull List<FeatureValue> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'values' is null");
        }
        Iterator<FeatureValue> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'values' is null");
            }
        }
        this.values = list;
    }

    @Nonnull
    public List<FeatureValue> getValues() {
        return this.values;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.values});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<FeatureValue> list = this.values;
        List<FeatureValue> list2 = ((FeaturesGetValuesBatchResult) obj).values;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FeaturesGetValuesBatchResult> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FeaturesGetValuesBatchResult featuresGetValuesBatchResult, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("values");
            StoneSerializers.list(FeatureValue.Serializer.INSTANCE).serialize(featuresGetValuesBatchResult.values, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FeaturesGetValuesBatchResult deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            List list = null;
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
                    if ("values".equals(currentName)) {
                        list = (List) StoneSerializers.list(FeatureValue.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"values\" missing.");
                }
                FeaturesGetValuesBatchResult featuresGetValuesBatchResult = new FeaturesGetValuesBatchResult(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(featuresGetValuesBatchResult, featuresGetValuesBatchResult.toStringMultiline());
                return featuresGetValuesBatchResult;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
