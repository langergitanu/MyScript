package com.dropbox.core.p013v2.team;

import com.dropbox.core.p013v2.team.Feature;
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
class FeaturesGetValuesBatchArg {

    @Nonnull
    protected final List<Feature> features;

    public FeaturesGetValuesBatchArg(@Nonnull List<Feature> list) {
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'features' is null");
        }
        Iterator<Feature> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'features' is null");
            }
        }
        this.features = list;
    }

    @Nonnull
    public List<Feature> getFeatures() {
        return this.features;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.features});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        List<Feature> list = this.features;
        List<Feature> list2 = ((FeaturesGetValuesBatchArg) obj).features;
        return list == list2 || list.equals(list2);
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FeaturesGetValuesBatchArg> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FeaturesGetValuesBatchArg featuresGetValuesBatchArg, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("features");
            StoneSerializers.list(Feature.Serializer.INSTANCE).serialize(featuresGetValuesBatchArg.features, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FeaturesGetValuesBatchArg deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("features".equals(currentName)) {
                        list = (List) StoneSerializers.list(Feature.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"features\" missing.");
                }
                FeaturesGetValuesBatchArg featuresGetValuesBatchArg = new FeaturesGetValuesBatchArg(list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(featuresGetValuesBatchArg, featuresGetValuesBatchArg.toStringMultiline());
                return featuresGetValuesBatchArg;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
