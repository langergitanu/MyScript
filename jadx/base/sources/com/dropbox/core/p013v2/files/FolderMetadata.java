package com.dropbox.core.p013v2.files;

import com.dropbox.core.p013v2.fileproperties.PropertyGroup;
import com.dropbox.core.p013v2.files.FolderSharingInfo;
import com.dropbox.core.p013v2.files.Metadata;
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
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class FolderMetadata extends Metadata {

    /* JADX INFO: renamed from: id */
    @Nonnull
    protected final String f697id;

    @Nullable
    protected final List<PropertyGroup> propertyGroups;

    @Nullable
    protected final String sharedFolderId;

    @Nullable
    protected final FolderSharingInfo sharingInfo;

    public FolderMetadata(@Nonnull String str, @Nonnull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable FolderSharingInfo folderSharingInfo, @Nullable List<PropertyGroup> list) {
        super(str, str3, str4, str5, str6);
        if (str2 == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (str2.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        this.f697id = str2;
        if (str7 != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str7)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = str7;
        this.sharingInfo = folderSharingInfo;
        if (list != null) {
            Iterator<PropertyGroup> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                }
            }
        }
        this.propertyGroups = list;
    }

    public FolderMetadata(@Nonnull String str, @Nonnull String str2) {
        this(str, str2, null, null, null, null, null, null, null);
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Nonnull
    public String getId() {
        return this.f697id;
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

    @Nullable
    public String getSharedFolderId() {
        return this.sharedFolderId;
    }

    @Nullable
    public FolderSharingInfo getSharingInfo() {
        return this.sharingInfo;
    }

    @Nullable
    public List<PropertyGroup> getPropertyGroups() {
        return this.propertyGroups;
    }

    public static Builder newBuilder(String str, String str2) {
        return new Builder(str, str2);
    }

    public static class Builder extends Metadata.Builder {

        /* JADX INFO: renamed from: id */
        protected final String f698id;
        protected List<PropertyGroup> propertyGroups;
        protected String sharedFolderId;
        protected FolderSharingInfo sharingInfo;

        protected Builder(String str, String str2) {
            super(str);
            if (str2 == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (str2.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            this.f698id = str2;
            this.sharedFolderId = null;
            this.sharingInfo = null;
            this.propertyGroups = null;
        }

        public Builder withSharedFolderId(String str) {
            if (str != null && !Pattern.matches("[-_0-9a-zA-Z:]+", str)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = str;
            return this;
        }

        public Builder withSharingInfo(FolderSharingInfo folderSharingInfo) {
            this.sharingInfo = folderSharingInfo;
            return this;
        }

        public Builder withPropertyGroups(List<PropertyGroup> list) {
            if (list != null) {
                Iterator<PropertyGroup> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                    }
                }
            }
            this.propertyGroups = list;
            return this;
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
        public FolderMetadata build() {
            return new FolderMetadata(this.name, this.f698id, this.pathLower, this.pathDisplay, this.parentSharedFolderId, this.previewUrl, this.sharedFolderId, this.sharingInfo, this.propertyGroups);
        }
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(new Object[]{this.f697id, this.sharedFolderId, this.sharingInfo, this.propertyGroups});
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        FolderSharingInfo folderSharingInfo;
        FolderSharingInfo folderSharingInfo2;
        List<PropertyGroup> list;
        List<PropertyGroup> list2;
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        FolderMetadata folderMetadata = (FolderMetadata) obj;
        return (this.name == folderMetadata.name || this.name.equals(folderMetadata.name)) && ((str = this.f697id) == (str2 = folderMetadata.f697id) || str.equals(str2)) && ((this.pathLower == folderMetadata.pathLower || (this.pathLower != null && this.pathLower.equals(folderMetadata.pathLower))) && ((this.pathDisplay == folderMetadata.pathDisplay || (this.pathDisplay != null && this.pathDisplay.equals(folderMetadata.pathDisplay))) && ((this.parentSharedFolderId == folderMetadata.parentSharedFolderId || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(folderMetadata.parentSharedFolderId))) && ((this.previewUrl == folderMetadata.previewUrl || (this.previewUrl != null && this.previewUrl.equals(folderMetadata.previewUrl))) && (((str3 = this.sharedFolderId) == (str4 = folderMetadata.sharedFolderId) || (str3 != null && str3.equals(str4))) && (((folderSharingInfo = this.sharingInfo) == (folderSharingInfo2 = folderMetadata.sharingInfo) || (folderSharingInfo != null && folderSharingInfo.equals(folderSharingInfo2))) && ((list = this.propertyGroups) == (list2 = folderMetadata.propertyGroups) || (list != null && list.equals(list2)))))))));
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    @Override // com.dropbox.core.p013v2.files.Metadata
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    static class Serializer extends StructSerializer<FolderMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        Serializer() {
        }

        @Override // com.dropbox.core.stone.StructSerializer
        public void serialize(FolderMetadata folderMetadata, JsonGenerator jsonGenerator, boolean z) throws IOException {
            if (!z) {
                jsonGenerator.writeStartObject();
            }
            writeTag("folder", jsonGenerator);
            jsonGenerator.writeFieldName("name");
            StoneSerializers.string().serialize(folderMetadata.name, jsonGenerator);
            jsonGenerator.writeFieldName("id");
            StoneSerializers.string().serialize(folderMetadata.f697id, jsonGenerator);
            if (folderMetadata.pathLower != null) {
                jsonGenerator.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderMetadata.pathLower, jsonGenerator);
            }
            if (folderMetadata.pathDisplay != null) {
                jsonGenerator.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderMetadata.pathDisplay, jsonGenerator);
            }
            if (folderMetadata.parentSharedFolderId != null) {
                jsonGenerator.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderMetadata.parentSharedFolderId, jsonGenerator);
            }
            if (folderMetadata.previewUrl != null) {
                jsonGenerator.writeFieldName("preview_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderMetadata.previewUrl, jsonGenerator);
            }
            if (folderMetadata.sharedFolderId != null) {
                jsonGenerator.writeFieldName("shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(folderMetadata.sharedFolderId, jsonGenerator);
            }
            if (folderMetadata.sharingInfo != null) {
                jsonGenerator.writeFieldName("sharing_info");
                StoneSerializers.nullableStruct(FolderSharingInfo.Serializer.INSTANCE).serialize(folderMetadata.sharingInfo, jsonGenerator);
            }
            if (folderMetadata.propertyGroups != null) {
                jsonGenerator.writeFieldName("property_groups");
                StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).serialize(folderMetadata.propertyGroups, jsonGenerator);
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
        public FolderMetadata deserialize(JsonParser jsonParser, boolean z) throws IOException {
            String tag;
            if (!z) {
                expectStartObject(jsonParser);
                tag = readTag(jsonParser);
                if ("folder".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String strDeserialize = null;
                String strDeserialize2 = null;
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                FolderSharingInfo folderSharingInfo = null;
                List list = null;
                while (jsonParser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String currentName = jsonParser.getCurrentName();
                    jsonParser.nextToken();
                    if ("name".equals(currentName)) {
                        strDeserialize = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("id".equals(currentName)) {
                        strDeserialize2 = StoneSerializers.string().deserialize(jsonParser);
                    } else if ("path_lower".equals(currentName)) {
                        str = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("path_display".equals(currentName)) {
                        str2 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("parent_shared_folder_id".equals(currentName)) {
                        str3 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("preview_url".equals(currentName)) {
                        str4 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("shared_folder_id".equals(currentName)) {
                        str5 = (String) StoneSerializers.nullable(StoneSerializers.string()).deserialize(jsonParser);
                    } else if ("sharing_info".equals(currentName)) {
                        folderSharingInfo = (FolderSharingInfo) StoneSerializers.nullableStruct(FolderSharingInfo.Serializer.INSTANCE).deserialize(jsonParser);
                    } else if ("property_groups".equals(currentName)) {
                        list = (List) StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).deserialize(jsonParser);
                    } else {
                        skipValue(jsonParser);
                    }
                }
                if (strDeserialize == null) {
                    throw new JsonParseException(jsonParser, "Required field \"name\" missing.");
                }
                if (strDeserialize2 == null) {
                    throw new JsonParseException(jsonParser, "Required field \"id\" missing.");
                }
                FolderMetadata folderMetadata = new FolderMetadata(strDeserialize, strDeserialize2, str, str2, str3, str4, str5, folderSharingInfo, list);
                if (!z) {
                    expectEndObject(jsonParser);
                }
                StoneDeserializerLogger.log(folderMetadata, folderMetadata.toStringMultiline());
                return folderMetadata;
            }
            throw new JsonParseException(jsonParser, "No subtype found that matches tag: \"" + tag + "\"");
        }
    }
}
