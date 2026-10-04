package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.AccessMethodLogInfo;
import com.dropbox.core.p013v2.teamlog.GeoLocationLogInfo;
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
public class OriginLogInfo {

    @Nonnull
    protected final AccessMethodLogInfo accessMethod;

    @Nullable
    protected final GeoLocationLogInfo geoLocation;

    public OriginLogInfo(@Nonnull AccessMethodLogInfo accessMethodLogInfo, @Nullable GeoLocationLogInfo geoLocationLogInfo) {
        this.geoLocation = geoLocationLogInfo;
        if (accessMethodLogInfo == null) {
            throw new IllegalArgumentException("Required value for 'accessMethod' is null");
        }
        this.accessMethod = accessMethodLogInfo;
    }

    public OriginLogInfo(@Nonnull AccessMethodLogInfo accessMethodLogInfo) {
        this(accessMethodLogInfo, null);
    }

    @Nonnull
    public AccessMethodLogInfo getAccessMethod() {
        return this.accessMethod;
    }

    @Nullable
    public GeoLocationLogInfo getGeoLocation() {
        return this.geoLocation;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.geoLocation, this.accessMethod});
    }

    public boolean equals(Object obj) {
        GeoLocationLogInfo geoLocationLogInfo;
        GeoLocationLogInfo geoLocationLogInfo2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        OriginLogInfo originLogInfo = (OriginLogInfo) obj;
        AccessMethodLogInfo accessMethodLogInfo = this.accessMethod;
        AccessMethodLogInfo accessMethodLogInfo2 = originLogInfo.accessMethod;
        return (accessMethodLogInfo == accessMethodLogInfo2 || accessMethodLogInfo.equals(accessMethodLogInfo2)) && ((geoLocationLogInfo = this.geoLocation) == (geoLocationLogInfo2 = originLogInfo.geoLocation) || (geoLocationLogInfo != null && geoLocationLogInfo.equals(geoLocationLogInfo2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<OriginLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(OriginLogInfo originLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("access_method");
            AccessMethodLogInfo.Serializer.INSTANCE.serialize(originLogInfo.accessMethod, jsonGenerator);
            if (originLogInfo.geoLocation != null) {
                jsonGenerator.writeFieldName("geo_location");
                StoneSerializers.nullableStruct(GeoLocationLogInfo.Serializer.INSTANCE).serialize(originLogInfo.geoLocation, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public OriginLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            AccessMethodLogInfo accessMethodLogInfoDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                GeoLocationLogInfo geoLocationLogInfo = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("access_method".equals(currentName)) {
                        accessMethodLogInfoDeserialize = AccessMethodLogInfo.Serializer.INSTANCE.deserialize(jsonParser);
                    } else if ("geo_location".equals(currentName)) {
                        geoLocationLogInfo = (GeoLocationLogInfo) StoneSerializers.nullableStruct(GeoLocationLogInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (accessMethodLogInfoDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"access_method\" missing.");
                }
                OriginLogInfo originLogInfo = new OriginLogInfo(accessMethodLogInfoDeserialize, geoLocationLogInfo);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(originLogInfo, originLogInfo.toStringMultiline());
                return originLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
