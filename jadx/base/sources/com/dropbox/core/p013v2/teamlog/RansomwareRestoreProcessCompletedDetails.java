package com.dropbox.core.p013v2.teamlog;

import androidx.core.app.NotificationCompat;
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

/* JADX INFO: loaded from: classes5.dex */
public class RansomwareRestoreProcessCompletedDetails {
    protected final long restoredFilesCount;
    protected final long restoredFilesFailedCount;

    @Nonnull
    protected final String status;

    public RansomwareRestoreProcessCompletedDetails(@Nonnull String str, long j, long j2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = str;
        this.restoredFilesCount = j;
        this.restoredFilesFailedCount = j2;
    }

    @Nonnull
    public String getStatus() {
        return this.status;
    }

    public long getRestoredFilesCount() {
        return this.restoredFilesCount;
    }

    public long getRestoredFilesFailedCount() {
        return this.restoredFilesFailedCount;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.status, Long.valueOf(this.restoredFilesCount), Long.valueOf(this.restoredFilesFailedCount)});
    }

    public boolean equals(Object obj) {
        RansomwareRestoreProcessCompletedDetails ransomwareRestoreProcessCompletedDetails;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.status) == (str2 = (ransomwareRestoreProcessCompletedDetails = (RansomwareRestoreProcessCompletedDetails) obj).status) || str.equals(str2)) && this.restoredFilesCount == ransomwareRestoreProcessCompletedDetails.restoredFilesCount && this.restoredFilesFailedCount == ransomwareRestoreProcessCompletedDetails.restoredFilesFailedCount;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<RansomwareRestoreProcessCompletedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RansomwareRestoreProcessCompletedDetails ransomwareRestoreProcessCompletedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName(NotificationCompat.CATEGORY_STATUS);
            StoneSerializers.string().serialize(ransomwareRestoreProcessCompletedDetails.status, jsonGenerator);
            jsonGenerator.writeFieldName("restored_files_count");
            StoneSerializers.int64().serialize(Long.valueOf(ransomwareRestoreProcessCompletedDetails.restoredFilesCount), jsonGenerator);
            jsonGenerator.writeFieldName("restored_files_failed_count");
            StoneSerializers.int64().serialize(Long.valueOf(ransomwareRestoreProcessCompletedDetails.restoredFilesFailedCount), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RansomwareRestoreProcessCompletedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long lDeserialize2 = null;
                String strDeserialize = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if (NotificationCompat.CATEGORY_STATUS.equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("restored_files_count".equals(currentName)) {
                        lDeserialize = StoneSerializers.int64().deserialize(jsonParser);
                    } else if ("restored_files_failed_count".equals(currentName)) {
                        lDeserialize2 = StoneSerializers.int64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"status\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"restored_files_count\" missing.");
                }
                if (lDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"restored_files_failed_count\" missing.");
                }
                RansomwareRestoreProcessCompletedDetails ransomwareRestoreProcessCompletedDetails = new RansomwareRestoreProcessCompletedDetails(strDeserialize, lDeserialize.longValue(), lDeserialize2.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(ransomwareRestoreProcessCompletedDetails, ransomwareRestoreProcessCompletedDetails.toStringMultiline());
                return ransomwareRestoreProcessCompletedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
