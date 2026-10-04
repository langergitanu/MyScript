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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes5.dex */
public class FolderOverviewItemPinnedDetails {
    protected final long folderOverviewLocationAsset;

    @Nonnull
    protected final List<Long> pinnedItemsAssetIndices;

    public FolderOverviewItemPinnedDetails(long j, @Nonnull List<Long> list) {
        this.folderOverviewLocationAsset = j;
        if (list == null) {
            throw new IllegalArgumentException("Required value for 'pinnedItemsAssetIndices' is null");
        }
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new IllegalArgumentException("An item in list 'pinnedItemsAssetIndices' is null");
            }
        }
        this.pinnedItemsAssetIndices = list;
    }

    public long getFolderOverviewLocationAsset() {
        return this.folderOverviewLocationAsset;
    }

    @Nonnull
    public List<Long> getPinnedItemsAssetIndices() {
        return this.pinnedItemsAssetIndices;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.folderOverviewLocationAsset), this.pinnedItemsAssetIndices});
    }

    public boolean equals(Object obj) {
        List<Long> list;
        List<Long> list2;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            FolderOverviewItemPinnedDetails folderOverviewItemPinnedDetails = (FolderOverviewItemPinnedDetails) obj;
            if (this.folderOverviewLocationAsset == folderOverviewItemPinnedDetails.folderOverviewLocationAsset && ((list = this.pinnedItemsAssetIndices) == (list2 = folderOverviewItemPinnedDetails.pinnedItemsAssetIndices) || list.equals(list2))) {
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

    static class Serializer extends StructSerializer<FolderOverviewItemPinnedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FolderOverviewItemPinnedDetails folderOverviewItemPinnedDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("folder_overview_location_asset");
            StoneSerializers.uInt64().serialize(Long.valueOf(folderOverviewItemPinnedDetails.folderOverviewLocationAsset), jsonGenerator);
            jsonGenerator.writeFieldName("pinned_items_asset_indices");
            StoneSerializers.list(StoneSerializers.uInt64()).serialize(folderOverviewItemPinnedDetails.pinnedItemsAssetIndices, jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public FolderOverviewItemPinnedDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Long lDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("folder_overview_location_asset".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("pinned_items_asset_indices".equals(currentName)) {
                        list = (List) StoneSerializers.list(StoneSerializers.uInt64()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"folder_overview_location_asset\" missing.");
                }
                if (list == null) {
                    throw new JsonParseException(jsonParser, "Required field \"pinned_items_asset_indices\" missing.");
                }
                FolderOverviewItemPinnedDetails folderOverviewItemPinnedDetails = new FolderOverviewItemPinnedDetails(lDeserialize.longValue(), list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(folderOverviewItemPinnedDetails, folderOverviewItemPinnedDetails.toStringMultiline());
                return folderOverviewItemPinnedDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
