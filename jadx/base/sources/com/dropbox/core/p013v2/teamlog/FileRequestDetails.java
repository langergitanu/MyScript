package com.dropbox.core.p013v2.teamlog;

import com.dropbox.core.p013v2.teamlog.FileRequestDeadline;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class FileRequestDetails {
    protected final long assetIndex;

    @Nullable
    protected final FileRequestDeadline deadline;

    public FileRequestDetails(long j, @Nullable FileRequestDeadline fileRequestDeadline) {
        this.assetIndex = j;
        this.deadline = fileRequestDeadline;
    }

    public FileRequestDetails(long j) {
        this(j, null);
    }

    public long getAssetIndex() {
        return this.assetIndex;
    }

    @Nullable
    public FileRequestDeadline getDeadline() {
        return this.deadline;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.assetIndex), this.deadline});
    }

    public boolean equals(Object obj) {
        FileRequestDeadline fileRequestDeadline;
        FileRequestDeadline fileRequestDeadline2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            FileRequestDetails fileRequestDetails = (FileRequestDetails) obj;
            if (this.assetIndex == fileRequestDetails.assetIndex && ((fileRequestDeadline = this.deadline) == (fileRequestDeadline2 = fileRequestDetails.deadline) || (fileRequestDeadline != null && fileRequestDeadline.equals(fileRequestDeadline2)))) {
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

    static class Serializer extends StructSerializer<FileRequestDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FileRequestDetails fileRequestDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("asset_index");
            StoneSerializers.uInt64().serialize(Long.valueOf(fileRequestDetails.assetIndex), jsonGenerator);
            if (fileRequestDetails.deadline != null) {
                jsonGenerator.writeFieldName("deadline");
                StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).serialize(fileRequestDetails.deadline, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FileRequestDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                FileRequestDeadline fileRequestDeadline = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("asset_index".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("deadline".equals(currentName)) {
                        fileRequestDeadline = (FileRequestDeadline) StoneSerializers.nullableStruct(FileRequestDeadline.Serializer.INSTANCE).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"asset_index\" missing.");
                }
                FileRequestDetails fileRequestDetails = new FileRequestDetails(lDeserialize.longValue(), fileRequestDeadline);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(fileRequestDetails, fileRequestDetails.toStringMultiline());
                return fileRequestDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
