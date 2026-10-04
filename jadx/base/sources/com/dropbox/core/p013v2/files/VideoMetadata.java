package com.dropbox.core.p013v2.files;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.MimeTypes;
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
import java.util.Arrays;
import java.util.Date;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class VideoMetadata extends MediaMetadata {

    @Nullable
    protected final Long duration;

    public VideoMetadata(@Nullable Dimensions dimensions, @Nullable GpsCoordinates gpsCoordinates, @Nullable Date date, @Nullable Long l) {
        super(dimensions, gpsCoordinates, date);
        this.duration = l;
    }

    public VideoMetadata() {
        this(null, null, null, null);
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

    @Nullable
    public Long getDuration() {
        return this.duration;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder extends MediaMetadata.Builder {
        protected Long duration = null;

        protected Builder() {
        }

        public Builder withDuration(Long l) {
            this.duration = l;
            return this;
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
        public VideoMetadata build() {
            return new VideoMetadata(this.dimensions, this.location, this.timeTaken, this.duration);
        }
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.duration});
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    public boolean equals(Object obj) {
        Long l;
        Long l2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        VideoMetadata videoMetadata = (VideoMetadata) obj;
        return (this.dimensions == videoMetadata.dimensions || (this.dimensions != null && this.dimensions.equals(videoMetadata.dimensions))) && (this.location == videoMetadata.location || (this.location != null && this.location.equals(videoMetadata.location))) && ((this.timeTaken == videoMetadata.timeTaken || (this.timeTaken != null && this.timeTaken.equals(videoMetadata.timeTaken))) && ((l = this.duration) == (l2 = videoMetadata.duration) || (l != null && l.equals(l2))));
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.MediaMetadata
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<VideoMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(VideoMetadata videoMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag(MimeTypes.BASE_TYPE_VIDEO, jsonGenerator);
            if (videoMetadata.dimensions != null) {
                jsonGenerator.writeFieldName("dimensions");
                StoneSerializers.nullableStruct(Dimensions.Serializer.INSTANCE).serialize(videoMetadata.dimensions, jsonGenerator);
            }
            if (videoMetadata.location != null) {
                jsonGenerator.writeFieldName(FirebaseAnalytics.Param.LOCATION);
                StoneSerializers.nullableStruct(GpsCoordinates.Serializer.INSTANCE).serialize(videoMetadata.location, jsonGenerator);
            }
            if (videoMetadata.timeTaken != null) {
                jsonGenerator.writeFieldName("time_taken");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(videoMetadata.timeTaken, jsonGenerator);
            }
            if (videoMetadata.duration != null) {
                jsonGenerator.writeFieldName(TypedValues.TransitionType.S_DURATION);
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(videoMetadata.duration, jsonGenerator);
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
        public VideoMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Dimensions dimensions = null;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if (MimeTypes.BASE_TYPE_VIDEO.equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                GpsCoordinates gpsCoordinates = null;
                Date date = null;
                Long l = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("dimensions".equals(currentName)) {
                        dimensions = (Dimensions) StoneSerializers.nullableStruct(Dimensions.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if (FirebaseAnalytics.Param.LOCATION.equals(currentName)) {
                        gpsCoordinates = (GpsCoordinates) StoneSerializers.nullableStruct(GpsCoordinates.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("time_taken".equals(currentName)) {
                        date = (Date) StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(jsonParser);
                    } else if (TypedValues.TransitionType.S_DURATION.equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                VideoMetadata videoMetadata = new VideoMetadata(dimensions, gpsCoordinates, date, l);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(videoMetadata, videoMetadata.toStringMultiline());
                return videoMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
