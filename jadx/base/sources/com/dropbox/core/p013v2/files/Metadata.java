package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.files.DeletedMetadata;
import com.dropbox.core.p013v2.files.FileMetadata;
import com.dropbox.core.p013v2.files.FolderMetadata;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class Metadata {

    @Nonnull
    protected final String name;

    @Nullable
    protected final String parentSharedFolderId;

    @Nullable
    protected final String pathDisplay;

    @Nullable
    protected final String pathLower;

    @Nullable
    protected final String previewUrl;

    public Metadata(@Nonnull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        if (str == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = str;
        this.pathLower = str2;
        this.pathDisplay = str3;
        if (str4 != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str4)) {
            throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
        }
        this.parentSharedFolderId = str4;
        this.previewUrl = str5;
    }

    public Metadata(@Nonnull String str) {
        this(str, null, null, null, null);
    }

    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nullable
    public String getPathLower() {
        return this.pathLower;
    }

    @Nullable
    public String getPathDisplay() {
        return this.pathDisplay;
    }

    @Nullable
    public String getParentSharedFolderId() {
        return this.parentSharedFolderId;
    }

    @Nullable
    public String getPreviewUrl() {
        return this.previewUrl;
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static class Builder {
        protected final String name;
        protected String parentSharedFolderId;
        protected String pathDisplay;
        protected String pathLower;
        protected String previewUrl;

        protected Builder(String str) {
            if (str == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = str;
            this.pathLower = null;
            this.pathDisplay = null;
            this.parentSharedFolderId = null;
            this.previewUrl = null;
        }

        public Builder withPathLower(String str) {
            this.pathLower = str;
            return this;
        }

        public Builder withPathDisplay(String str) {
            this.pathDisplay = str;
            return this;
        }

        public Builder withParentSharedFolderId(String str) {
            if (str != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
            this.parentSharedFolderId = str;
            return this;
        }

        public Builder withPreviewUrl(String str) {
            this.previewUrl = str;
            return this;
        }

        public Metadata build() {
            return new Metadata(this.name, this.pathLower, this.pathDisplay, this.parentSharedFolderId, this.previewUrl);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name, this.pathLower, this.pathDisplay, this.parentSharedFolderId, this.previewUrl});
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        Metadata metadata = (Metadata) obj;
        String str9 = this.name;
        String str10 = metadata.name;
        return (str9 == str10 || str9.equals(str10)) && ((str = this.pathLower) == (str2 = metadata.pathLower) || (str != null && str.equals(str2))) && (((str3 = this.pathDisplay) == (str4 = metadata.pathDisplay) || (str3 != null && str3.equals(str4))) && (((str5 = this.parentSharedFolderId) == (str6 = metadata.parentSharedFolderId) || (str5 != null && str5.equals(str6))) && ((str7 = this.previewUrl) == (str8 = metadata.previewUrl) || (str7 != null && str7.equals(str8)))));
    }

    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<Metadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(Metadata metadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (metadata instanceof FileMetadata) {
                FileMetadata.Serializer.INSTANCE.serialize((FileMetadata) metadata, jsonGenerator, z);
                return;
            }
            if (metadata instanceof FolderMetadata) {
                FolderMetadata.Serializer.INSTANCE.serialize((FolderMetadata) metadata, jsonGenerator, z);
                return;
            }
            if (metadata instanceof DeletedMetadata) {
                DeletedMetadata.Serializer.INSTANCE.serialize((DeletedMetadata) metadata, jsonGenerator, z);
                return;
            }
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(metadata.name, jsonGenerator);
            if (metadata.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(metadata.pathLower, jsonGenerator);
            }
            if (metadata.pathDisplay != null) {
                jsonGenerator.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(metadata.pathDisplay, jsonGenerator);
            }
            if (metadata.parentSharedFolderId != null) {
                jsonGenerator.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(metadata.parentSharedFolderId, jsonGenerator);
            }
            if (metadata.previewUrl != null) {
                jsonGenerator.writeFieldName("preview_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(metadata.previewUrl, jsonGenerator);
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
        public Metadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            Metadata metadataDeserialize;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("".equals(tag)) {
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
                metadataDeserialize = new Metadata(strDeserialize, str, str2, str3, str4);
            } else if ("".equals(tag)) {
                metadataDeserialize = INSTANCE.deserialize(jsonParser, true);
            } else if ("file".equals(tag)) {
                metadataDeserialize = FileMetadata.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("folder".equals(tag)) {
                metadataDeserialize = FolderMetadata.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else if ("deleted".equals(tag)) {
                metadataDeserialize = DeletedMetadata.Serializer.INSTANCE.deserialize(jsonParser, true);
            } else {
                throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!z) {
                expectEndObject(jsonParser);
            }
            StoneDeserializerLogger.log(metadataDeserialize, metadataDeserialize.toStringMultiline());
            return metadataDeserialize;
        }
    }
}
