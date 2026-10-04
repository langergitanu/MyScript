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

/* JADX INFO: loaded from: classes5.dex */
public class FolderOverviewDescriptionChangedDetails {
    protected final long folderOverviewLocationAsset;

    public FolderOverviewDescriptionChangedDetails(long j) {
        this.folderOverviewLocationAsset = j;
    }

    public long getFolderOverviewLocationAsset() {
        return this.folderOverviewLocationAsset;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.folderOverviewLocationAsset)});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass().equals(getClass()) && this.folderOverviewLocationAsset == ((FolderOverviewDescriptionChangedDetails) obj).folderOverviewLocationAsset;
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FolderOverviewDescriptionChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FolderOverviewDescriptionChangedDetails folderOverviewDescriptionChangedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("folder_overview_location_asset");
            StoneSerializers.uInt64().serialize(Long.valueOf(folderOverviewDescriptionChangedDetails.folderOverviewLocationAsset), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FolderOverviewDescriptionChangedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
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
                    if ("folder_overview_location_asset".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"folder_overview_location_asset\" missing.");
                }
                FolderOverviewDescriptionChangedDetails folderOverviewDescriptionChangedDetails = new FolderOverviewDescriptionChangedDetails(lDeserialize.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(folderOverviewDescriptionChangedDetails, folderOverviewDescriptionChangedDetails.toStringMultiline());
                return folderOverviewDescriptionChangedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
