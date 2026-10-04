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
public class RelocateAssetReferencesLogInfo {
    protected final long destAssetIndex;
    protected final long srcAssetIndex;

    public RelocateAssetReferencesLogInfo(long j, long j2) {
        this.srcAssetIndex = j;
        this.destAssetIndex = j2;
    }

    public long getSrcAssetIndex() {
        return this.srcAssetIndex;
    }

    public long getDestAssetIndex() {
        return this.destAssetIndex;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.srcAssetIndex), Long.valueOf(this.destAssetIndex)});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            RelocateAssetReferencesLogInfo relocateAssetReferencesLogInfo = (RelocateAssetReferencesLogInfo) obj;
            if (this.srcAssetIndex == relocateAssetReferencesLogInfo.srcAssetIndex && this.destAssetIndex == relocateAssetReferencesLogInfo.destAssetIndex) {
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

    static class Serializer extends StructSerializer<RelocateAssetReferencesLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(RelocateAssetReferencesLogInfo relocateAssetReferencesLogInfo, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("src_asset_index");
            StoneSerializers.uInt64().serialize(Long.valueOf(relocateAssetReferencesLogInfo.srcAssetIndex), jsonGenerator);
            jsonGenerator.writeFieldName("dest_asset_index");
            StoneSerializers.uInt64().serialize(Long.valueOf(relocateAssetReferencesLogInfo.destAssetIndex), jsonGenerator);
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public RelocateAssetReferencesLogInfo deserialize(JsonParser jsonParser, boolean z) throws IOException {
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
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("src_asset_index".equals(currentName)) {
                        lDeserialize = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else if ("dest_asset_index".equals(currentName)) {
                        lDeserialize2 = StoneSerializers.uInt64().deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (lDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"src_asset_index\" missing.");
                }
                if (lDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"dest_asset_index\" missing.");
                }
                RelocateAssetReferencesLogInfo relocateAssetReferencesLogInfo = new RelocateAssetReferencesLogInfo(lDeserialize.longValue(), lDeserialize2.longValue());
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(relocateAssetReferencesLogInfo, relocateAssetReferencesLogInfo.toStringMultiline());
                return relocateAssetReferencesLogInfo;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
