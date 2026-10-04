package com.dropbox.core.p013v2.files;

import androidx.media3.common.MimeTypes;
import com.dropbox.core.p013v2.files.Dimensions;
import com.dropbox.core.p013v2.files.GpsCoordinates;
import com.dropbox.core.p013v2.files.PhotoMetadata;
import com.dropbox.core.p013v2.files.VideoMetadata;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class MediaMetadata {

    @Nullable
    protected final Dimensions dimensions;

    @Nullable
    protected final GpsCoordinates location;

    @Nullable
    protected final Date timeTaken;

    public MediaMetadata(@Nullable Dimensions dimensions, @Nullable GpsCoordinates gpsCoordinates, @Nullable Date date) {
        this.dimensions = dimensions;
        this.location = gpsCoordinates;
        this.timeTaken = LangUtil.truncateMillis(date);
    }

    public MediaMetadata() {
        this(null, null, null);
    }

    @Nullable
    public Dimensions getDimensions() {
        return this.dimensions;
    }

    @Nullable
    public GpsCoordinates getLocation() {
        return this.location;
    }

    @Nullable
    public Date getTimeTaken() {
        return this.timeTaken;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        protected Dimensions dimensions = null;
        protected GpsCoordinates location = null;
        protected Date timeTaken = null;

        protected Builder() {
        }

        public Builder withDimensions(Dimensions dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder withLocation(GpsCoordinates gpsCoordinates) {
            this.location = gpsCoordinates;
            return this;
        }

        public Builder withTimeTaken(Date date) {
            this.timeTaken = LangUtil.truncateMillis(date);
            return this;
        }

        public MediaMetadata build() {
            return new MediaMetadata(this.dimensions, this.location, this.timeTaken);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.dimensions, this.location, this.timeTaken});
    }

    public boolean equals(Object obj) {
        GpsCoordinates gpsCoordinates;
        GpsCoordinates gpsCoordinates2;
        Date date;
        Date date2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        Dimensions dimensions = this.dimensions;
        Dimensions dimensions2 = mediaMetadata.dimensions;
        return (dimensions == dimensions2 || (dimensions != null && dimensions.equals(dimensions2))) && ((gpsCoordinates = this.location) == (gpsCoordinates2 = mediaMetadata.location) || (gpsCoordinates != null && gpsCoordinates.equals(gpsCoordinates2))) && ((date = this.timeTaken) == (date2 = mediaMetadata.timeTaken) || (date != null && date.equals(date2)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<MediaMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(MediaMetadata mediaMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (mediaMetadata instanceof PhotoMetadata) {
                PhotoMetadata.Serializer.INSTANCE.serialize((PhotoMetadata) mediaMetadata, jsonGenerator, z);
                return;
            }
            if (mediaMetadata instanceof VideoMetadata) {
                VideoMetadata.Serializer.INSTANCE.serialize((VideoMetadata) mediaMetadata, jsonGenerator, z);
                return;
            }
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            if (mediaMetadata.dimensions != null) {
                jsonGenerator.writeFieldName("dimensions");
                StoneSerializers.nullableStruct(Dimensions.Serializer.INSTANCE).serialize(mediaMetadata.dimensions, jsonGenerator);
            }
            if (mediaMetadata.location != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.LOCATION);
                StoneSerializers.nullableStruct(GpsCoordinates.Serializer.INSTANCE).serialize(mediaMetadata.location, jsonGenerator);
            }
            if (mediaMetadata.timeTaken != null) {
                jsonGenerator.writeFieldName("time_taken");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(mediaMetadata.timeTaken, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:6:0x0012  */
        @Override // com.dropbox.core.stone.StructSerializer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public MediaMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            MediaMetadata mediaMetadataDeserialize;
            Dimensions dimensions = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                GpsCoordinates gpsCoordinates = null;
                Date date = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("dimensions".equals(currentName)) {
                        dimensions = (Dimensions) StoneSerializers.nullableStruct(Dimensions.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.LOCATION.equals(currentName)) {
                        gpsCoordinates = (GpsCoordinates) StoneSerializers.nullableStruct(GpsCoordinates.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("time_taken".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                mediaMetadataDeserialize = new MediaMetadata(dimensions, gpsCoordinates, date);
            } else if ("".equals(tag)) {
                mediaMetadataDeserialize = INSTANCE.deserialize(jsonParser, true);
            } else if ("photo".equals(tag)) {
                mediaMetadataDeserialize = PhotoMetadata.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if (MimeTypes.BASE_TYPE_VIDEO.equals(tag)) {
                mediaMetadataDeserialize = VideoMetadata.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else {
                throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!z) {
                expectEndObject(jsonParser);
            }
            StoneDeserializerLogger.log(mediaMetadataDeserialize, mediaMetadataDeserialize.toStringMultiline());
            return mediaMetadataDeserialize;
        }
    }
}
