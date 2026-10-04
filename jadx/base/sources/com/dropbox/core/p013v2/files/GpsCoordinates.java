package com.dropbox.core.p013v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class GpsCoordinates {
    protected final double latitude;
    protected final double longitude;

    public GpsCoordinates(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Double.valueOf(this.latitude), Double.valueOf(this.longitude)});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            GpsCoordinates gpsCoordinates = (GpsCoordinates) obj;
            if (this.latitude == gpsCoordinates.latitude && this.longitude == gpsCoordinates.longitude) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GpsCoordinates> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GpsCoordinates gpsCoordinates, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("latitude");
            StoneSerializers.float64().serialize(Double.valueOf(gpsCoordinates.latitude), jsonGenerator);
            jsonGenerator.writeFieldName("longitude");
            StoneSerializers.float64().serialize(Double.valueOf(gpsCoordinates.longitude), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GpsCoordinates deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Double dDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Double dDeserialize2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("latitude".equals(currentName)) {
                        dDeserialize = StoneSerializers.float64().deserialize(jsonParser);
                    } else if ("longitude".equals(currentName)) {
                        dDeserialize2 = StoneSerializers.float64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (dDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"latitude\" missing.");
                }
                if (dDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"longitude\" missing.");
                }
                GpsCoordinates gpsCoordinates = new GpsCoordinates(dDeserialize.doubleValue(), dDeserialize2.doubleValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(gpsCoordinates, gpsCoordinates.toStringMultiline());
                return gpsCoordinates;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
