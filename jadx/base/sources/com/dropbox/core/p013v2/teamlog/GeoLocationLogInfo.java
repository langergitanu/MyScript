package com.dropbox.core.p013v2.teamlog;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.survicate.surveys.surveys.FormSurveyFieldType;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class GeoLocationLogInfo {

    @Nullable
    protected final String city;

    @Nullable
    protected final String country;

    @Nonnull
    protected final String ipAddress;

    @Nullable
    protected final String region;

    public GeoLocationLogInfo(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.city = str2;
        this.region = str3;
        this.country = str4;
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'ipAddress' is null");
        }
        this.ipAddress = str;
    }

    public GeoLocationLogInfo(@Nonnull String str) {
        this(str, null, null, null);
    }

    @Nonnull
    public String getIpAddress() {
        return this.ipAddress;
    }

    @Nullable
    public String getCity() {
        return this.city;
    }

    @Nullable
    public String getRegion() {
        return this.region;
    }

    @Nullable
    public String getCountry() {
        return this.country;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected String city;
        protected String country;
        protected final String ipAddress;
        protected String region;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'ipAddress' is null");
            }
            this.ipAddress = str;
            this.city = null;
            this.region = null;
            this.country = null;
        }

        public Builder withCity(String str) {
            this.city = str;
            return this;
        }

        public Builder withRegion(String str) {
            this.region = str;
            return this;
        }

        public Builder withCountry(String str) {
            this.country = str;
            return this;
        }

        public GeoLocationLogInfo build() {
            return new GeoLocationLogInfo(this.ipAddress, this.city, this.region, this.country);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.city, this.region, this.country, this.ipAddress});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        GeoLocationLogInfo geoLocationLogInfo = (GeoLocationLogInfo) obj;
        String str7 = this.ipAddress;
        String str8 = geoLocationLogInfo.ipAddress;
        return (str7 == str8 || str7.equals(str8)) && ((str = this.city) == (str2 = geoLocationLogInfo.city) || (str != null && str.equals(str2))) && (((str3 = this.region) == (str4 = geoLocationLogInfo.region) || (str3 != null && str3.equals(str4))) && ((str5 = this.country) == (str6 = geoLocationLogInfo.country) || (str5 != null && str5.equals(str6))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<GeoLocationLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(GeoLocationLogInfo geoLocationLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("ip_address");
            StoneSerializers.string().serialize(geoLocationLogInfo.ipAddress, jsonGenerator);
            if (geoLocationLogInfo.city != null) {
                jsonGenerator.writeFieldName(FormSurveyFieldType.CITY);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(geoLocationLogInfo.city, jsonGenerator);
            }
            if (geoLocationLogInfo.region != null) {
                jsonGenerator.writeFieldName(TtmlNode.TAG_REGION);
                StoneSerializers.nullable(StoneSerializers.string()).serialize(geoLocationLogInfo.region, jsonGenerator);
            }
            if (geoLocationLogInfo.country != null) {
                jsonGenerator.writeFieldName("country");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(geoLocationLogInfo.country, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public GeoLocationLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                String str = null;
                String str2 = null;
                String str3 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("ip_address".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if (FormSurveyFieldType.CITY.equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if (TtmlNode.TAG_REGION.equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("country".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"ip_address\" missing.");
                }
                GeoLocationLogInfo geoLocationLogInfo = new GeoLocationLogInfo(strDeserialize, str, str2, str3);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(geoLocationLogInfo, geoLocationLogInfo.toStringMultiline());
                return geoLocationLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
