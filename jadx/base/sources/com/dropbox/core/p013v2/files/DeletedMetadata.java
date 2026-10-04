package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.Metadata;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class DeletedMetadata extends Metadata {
    public DeletedMetadata(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        super(str, str2, str3, str4, str5);
    }

    public DeletedMetadata(@Nonnull String str) {
        this(str, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    @Nullable
    public String getPathLower() {
        return this.pathLower;
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    @Nullable
    public String getPathDisplay() {
        return this.pathDisplay;
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    @Nullable
    public String getParentSharedFolderId() {
        return this.parentSharedFolderId;
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    @Nullable
    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder extends Metadata.Builder {
        protected Builder(String str) {
            super(str);
        }

        @Override // com.dropbox.core.v2.files.Metadata.Builder
        public Builder withPathLower(String str) {
            super.withPathLower(str);
            return this;
        }

        @Override // com.dropbox.core.v2.files.Metadata.Builder
        public Builder withPathDisplay(String str) {
            super.withPathDisplay(str);
            return this;
        }

        @Override // com.dropbox.core.v2.files.Metadata.Builder
        public Builder withParentSharedFolderId(String str) {
            super.withParentSharedFolderId(str);
            return this;
        }

        @Override // com.dropbox.core.v2.files.Metadata.Builder
        public Builder withPreviewUrl(String str) {
            super.withPreviewUrl(str);
            return this;
        }

        @Override // com.dropbox.core.v2.files.Metadata.Builder
        public DeletedMetadata build() {
            return new DeletedMetadata(this.name, this.pathLower, this.pathDisplay, this.parentSharedFolderId, this.previewUrl);
        }
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public int hashCode() {
        return getClass().toString().hashCode();
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        DeletedMetadata deletedMetadata = (DeletedMetadata) obj;
        return (this.name == deletedMetadata.name || this.name.equals(deletedMetadata.name)) && (this.pathLower == deletedMetadata.pathLower || (this.pathLower != null && this.pathLower.equals(deletedMetadata.pathLower))) && ((this.pathDisplay == deletedMetadata.pathDisplay || (this.pathDisplay != null && this.pathDisplay.equals(deletedMetadata.pathDisplay))) && ((this.parentSharedFolderId == deletedMetadata.parentSharedFolderId || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(deletedMetadata.parentSharedFolderId))) && (this.previewUrl == deletedMetadata.previewUrl || (this.previewUrl != null && this.previewUrl.equals(deletedMetadata.previewUrl)))));
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<DeletedMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(DeletedMetadata deletedMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("deleted", jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(deletedMetadata.name, jsonGenerator);
            if (deletedMetadata.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deletedMetadata.pathLower, jsonGenerator);
            }
            if (deletedMetadata.pathDisplay != null) {
                jsonGenerator.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deletedMetadata.pathDisplay, jsonGenerator);
            }
            if (deletedMetadata.parentSharedFolderId != null) {
                jsonGenerator.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deletedMetadata.parentSharedFolderId, jsonGenerator);
            }
            if (deletedMetadata.previewUrl != null) {
                jsonGenerator.writeFieldName("preview_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(deletedMetadata.previewUrl, jsonGenerator);
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
        public DeletedMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("deleted".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String strDeserialize = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("path_lower".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("path_display".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("parent_shared_folder_id".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("preview_url".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                DeletedMetadata deletedMetadata = new DeletedMetadata(strDeserialize, str, str2, str3, str4);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(deletedMetadata, deletedMetadata.toStringMultiline());
                return deletedMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
