package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.Dimensions;
import com.dropbox.core.p013v2.files.GpsCoordinates;
import com.dropbox.core.p013v2.files.MediaMetadata;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Date;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoMetadata extends MediaMetadata {
    public PhotoMetadata(@Nullable Dimensions dimensions, @Nullable GpsCoordinates gpsCoordinates, @Nullable Date date) {
        super(dimensions, gpsCoordinates, date);
    }

    public PhotoMetadata() {
        this(null, null, null);
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    @Nullable
    public Dimensions getDimensions() {
        return this.dimensions;
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    @Nullable
    public GpsCoordinates getLocation() {
        return this.location;
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    @Nullable
    public Date getTimeTaken() {
        return this.timeTaken;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder extends MediaMetadata.Builder {
        protected Builder() {
        }

        @Override // com.dropbox.core.v2.files.MediaMetadata.Builder
        public Builder withDimensions(Dimensions dimensions) {
            super.withDimensions(dimensions);
            return this;
        }

        @Override // com.dropbox.core.v2.files.MediaMetadata.Builder
        public Builder withLocation(GpsCoordinates gpsCoordinates) {
            super.withLocation(gpsCoordinates);
            return this;
        }

        @Override // com.dropbox.core.v2.files.MediaMetadata.Builder
        public Builder withTimeTaken(Date date) {
            super.withTimeTaken(date);
            return this;
        }

        @Override // com.dropbox.core.v2.files.MediaMetadata.Builder
        public PhotoMetadata build() {
            return new PhotoMetadata(this.dimensions, this.location, this.timeTaken);
        }
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PhotoMetadata photoMetadata = (PhotoMetadata) obj;
        return (this.dimensions == photoMetadata.dimensions || (this.dimensions != null && this.dimensions.equals(photoMetadata.dimensions))) && (this.location == photoMetadata.location || (this.location != null && this.location.equals(photoMetadata.location))) && (this.timeTaken == photoMetadata.timeTaken || (this.timeTaken != null && this.timeTaken.equals(photoMetadata.timeTaken)));
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PhotoMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PhotoMetadata photoMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("photo", jsonGenerator);
            if (photoMetadata.dimensions != null) {
                jsonGenerator.writeFieldName("dimensions");
                StoneSerializers.nullableStruct(Dimensions.Serializer.INSTANCE).serialize(photoMetadata.dimensions, jsonGenerator);
            }
            if (photoMetadata.location != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.LOCATION);
                StoneSerializers.nullableStruct(GpsCoordinates.Serializer.INSTANCE).serialize(photoMetadata.location, jsonGenerator);
            }
            if (photoMetadata.timeTaken != null) {
                jsonGenerator.writeFieldName("time_taken");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(photoMetadata.timeTaken, jsonGenerator);
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
        public PhotoMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Dimensions dimensions = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("photo".equals(tag)) {
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
                PhotoMetadata photoMetadata = new PhotoMetadata(dimensions, gpsCoordinates, date);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(photoMetadata, photoMetadata.toStringMultiline());
                return photoMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
