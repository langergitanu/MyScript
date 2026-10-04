package com.dropbox.core.p013v2.teamlog;

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
public class PaperContentAddToFolderDetails {

    @Nonnull
    protected final String eventUuid;
    protected final long parentAssetIndex;
    protected final long targetAssetIndex;

    public PaperContentAddToFolderDetails(@Nonnull String str, long j, long j2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        this.targetAssetIndex = j;
        this.parentAssetIndex = j2;
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    public long getTargetAssetIndex() {
        return this.targetAssetIndex;
    }

    public long getParentAssetIndex() {
        return this.parentAssetIndex;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, Long.valueOf(this.targetAssetIndex), Long.valueOf(this.parentAssetIndex)});
    }

    public boolean equals(Object obj) {
        PaperContentAddToFolderDetails paperContentAddToFolderDetails;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && ((str = this.eventUuid) == (str2 = (paperContentAddToFolderDetails = (PaperContentAddToFolderDetails) obj).eventUuid) || str.equals(str2)) && this.targetAssetIndex == paperContentAddToFolderDetails.targetAssetIndex && this.parentAssetIndex == paperContentAddToFolderDetails.parentAssetIndex;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperContentAddToFolderDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperContentAddToFolderDetails paperContentAddToFolderDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(paperContentAddToFolderDetails.eventUuid, jsonGenerator);
            jsonGenerator.writeFieldName("target_asset_index");
            StoneSerializers.uInt64().serialize(Long.valueOf(paperContentAddToFolderDetails.targetAssetIndex), jsonGenerator);
            jsonGenerator.writeFieldName("parent_asset_index");
            StoneSerializers.uInt64().serialize(Long.valueOf(paperContentAddToFolderDetails.parentAssetIndex), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperContentAddToFolderDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("target_asset_index".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("parent_asset_index".equals(currentName)) {
                        lDeserialize2 = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"target_asset_index\" missing.");
                }
                if (lDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"parent_asset_index\" missing.");
                }
                PaperContentAddToFolderDetails paperContentAddToFolderDetails = new PaperContentAddToFolderDetails(strDeserialize, lDeserialize.longValue(), lDeserialize2.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperContentAddToFolderDetails, paperContentAddToFolderDetails.toStringMultiline());
                return paperContentAddToFolderDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
