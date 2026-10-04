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
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class PaperContentRemoveFromFolderDetails {

    @Nonnull
    protected final String eventUuid;

    @Nullable
    protected final Long parentAssetIndex;

    @Nullable
    protected final Long targetAssetIndex;

    public PaperContentRemoveFromFolderDetails(@Nonnull String str, @Nullable Long l, @Nullable Long l2) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'eventUuid' is null");
        }
        this.eventUuid = str;
        this.targetAssetIndex = l;
        this.parentAssetIndex = l2;
    }

    public PaperContentRemoveFromFolderDetails(@Nonnull String str) {
        this(str, null, null);
    }

    @Nonnull
    public String getEventUuid() {
        return this.eventUuid;
    }

    @Nullable
    public Long getTargetAssetIndex() {
        return this.targetAssetIndex;
    }

    @Nullable
    public Long getParentAssetIndex() {
        return this.parentAssetIndex;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected final String eventUuid;
        protected Long parentAssetIndex;
        protected Long targetAssetIndex;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'eventUuid' is null");
            }
            this.eventUuid = str;
            this.targetAssetIndex = null;
            this.parentAssetIndex = null;
        }

        public Builder withTargetAssetIndex(Long l) {
            this.targetAssetIndex = l;
            return this;
        }

        public Builder withParentAssetIndex(Long l) {
            this.parentAssetIndex = l;
            return this;
        }

        public PaperContentRemoveFromFolderDetails build() {
            return new PaperContentRemoveFromFolderDetails(this.eventUuid, this.targetAssetIndex, this.parentAssetIndex);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.eventUuid, this.targetAssetIndex, this.parentAssetIndex});
    }

    public boolean equals(Object obj) {
        Long l;
        Long l2;
        Long l3;
        Long l4;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        PaperContentRemoveFromFolderDetails paperContentRemoveFromFolderDetails = (PaperContentRemoveFromFolderDetails) obj;
        String str = this.eventUuid;
        String str2 = paperContentRemoveFromFolderDetails.eventUuid;
        return (str == str2 || str.equals(str2)) && ((l = this.targetAssetIndex) == (l2 = paperContentRemoveFromFolderDetails.targetAssetIndex) || (l != null && l.equals(l2))) && ((l3 = this.parentAssetIndex) == (l4 = paperContentRemoveFromFolderDetails.parentAssetIndex) || (l3 != null && l3.equals(l4)));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<PaperContentRemoveFromFolderDetails> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(PaperContentRemoveFromFolderDetails paperContentRemoveFromFolderDetails, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("event_uuid");
            StoneSerializers.string().serialize(paperContentRemoveFromFolderDetails.eventUuid, jsonGenerator);
            if (paperContentRemoveFromFolderDetails.targetAssetIndex != null) {
                jsonGenerator.writeFieldName("target_asset_index");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(paperContentRemoveFromFolderDetails.targetAssetIndex, jsonGenerator);
            }
            if (paperContentRemoveFromFolderDetails.parentAssetIndex != null) {
                jsonGenerator.writeFieldName("parent_asset_index");
                StoneSerializers.nullable(StoneSerializers.uInt64()).serialize(paperContentRemoveFromFolderDetails.parentAssetIndex, jsonGenerator);
            }
            if (z) {
                return;
            }
            jsonGenerator.writeEndObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.dropbox.core.stone.StructSerializer
        public PaperContentRemoveFromFolderDetails deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            String strDeserialize = null;
            if (z) {
                tag = null;
            } else {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
            }
            if (tag == null) {
                Long l = null;
                Long l2 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("event_uuid".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("target_asset_index".equals(currentName)) {
                        l = (Long) StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(jsonParser);
                    } else if ("parent_asset_index".equals(currentName)) {
                        l2 = (Long) StoneSerializers.nullable(StoneSerializers.uInt64()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"event_uuid\" missing.");
                }
                PaperContentRemoveFromFolderDetails paperContentRemoveFromFolderDetails = new PaperContentRemoveFromFolderDetails(strDeserialize, l, l2);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(paperContentRemoveFromFolderDetails, paperContentRemoveFromFolderDetails.toStringMultiline());
                return paperContentRemoveFromFolderDetails;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
